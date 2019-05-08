package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class TestJugadorCampeonato extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void TestJugCamp(){
		Session session = getSession();
		Equipo boca = new Equipo();
		boca.setNombre("Boca");
		boca.setCampeonatos(4);
		session.save(boca);
		
		Equipo lanus = new Equipo();
		lanus.setNombre("Lanus");
		lanus.setCampeonatos(2);
		session.save(lanus);
		
		Equipo river = new Equipo();
		river.setNombre("River");
		river.setCampeonatos(5);
		session.save(river);
		
		Jugador unJugador = new Jugador();
		unJugador.setEquipo(boca);
		session.save(unJugador);
		
		Jugador otroJugador = new Jugador();
		otroJugador.setEquipo(lanus);
		session.save(otroJugador);
		
		Jugador ultimoJugador = new Jugador();
		ultimoJugador.setEquipo(boca);
		session.save(ultimoJugador);
		
		Jugador jugadorB = new Jugador();
		jugadorB.setEquipo(river);
		session.save(jugadorB);
		
		//Jugadores que juegan en equipos con >3 camponatos
	    //Consulta HQL
		/*String cons2 = "SELECT j FROM Jugador j WHERE j.equipo.campeonatos>='3'";
		Query consulta2 = session.createQuery(cons2);
		List<Jugador> jugadores2 = consulta2.list();
		assertThat(jugadores2).hasSize(3);*/
	       
	       List<Jugador> jc = getSession()
	    		   .createCriteria(Jugador.class, "j")
	    		   .createAlias("j.equipo","equipo")
	    		   .add(Restrictions.ge("equipo.campeonatos",3))
	    		   .list();
	       assertThat(jc).hasSize(3);
		
		
	}
}
