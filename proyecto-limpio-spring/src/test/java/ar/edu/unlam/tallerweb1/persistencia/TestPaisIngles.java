package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import static org.assertj.core.api.Assertions.*;

public class TestPaisIngles extends SpringTest {

	@Test
	@Transactional @Rollback(true)
	public void testPaisesHablanIngles() {
		Session session = getSession();
		
		Pais paisUno = new Pais();
		paisUno.setIdioma("Ingles");
		session.save(paisUno);
		
		Pais paisDos = new Pais();
		paisDos.setIdioma("Español");
		session.save(paisDos);
		
		Pais paisTres = new Pais();
		paisTres.setIdioma("Ingles");
		session.save(paisTres);
		
		List<Pais> pi = getSession()
				.createCriteria(Pais.class,"p")
				.add(Restrictions.eq("p.idioma", "Ingles"))
				.list();
		assertThat(pi).hasSize(2);
	}

}
