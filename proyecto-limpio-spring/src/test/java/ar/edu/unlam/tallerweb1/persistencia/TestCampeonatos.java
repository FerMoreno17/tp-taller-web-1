package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Equipo;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import static org.assertj.core.api.Assertions.*;

public class TestCampeonatos extends SpringTest{
	
    @Test
    @Transactional @Rollback(true)
    public void cargarEquipo(){
    	Session session = getSession();
    	
    	Equipo river = new Equipo();
        river.setNombre("River");
        river.setCampeonatos(4);
        session.save(river);
        
        Equipo boca = new Equipo();
        boca.setNombre("Boca");
        boca.setCampeonatos(5);
        session.save(boca);
        
        Equipo racing = new Equipo();
        racing.setNombre("Racing");
        racing.setCampeonatos(2);
        session.save(racing); 
        
       List<Equipo> equiposConTresCamp = getSession()
    		   .createCriteria(Equipo.class)
    		   .add(Restrictions.ge("campeonatos",3))
    		   .list();
       assertThat(equiposConTresCamp).hasSize(2);
    }
}
