package ar.edu.unlam.tallerweb1.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import static org.assertj.core.api.Assertions.*;

public class TestContinentePais extends SpringTest {

	@Test
	@Transactional @Rollback(true)
	public void testContinenteEuropeo() {
		Session session = getSession();
		Continente europa = new Continente();
		europa.setNombreContinente("Europa");
		session.save(europa);
		
		Continente america = new Continente();
		america.setNombreContinente("America");
		session.save(america);
		
		Pais espania = new Pais();
		espania.setContinente(europa);
		session.save(espania);
		
		Pais portugal = new Pais();
		portugal.setContinente(europa);
		session.save(portugal);
		
		Pais argentina = new Pais();
		argentina.setContinente(america);
		session.save(argentina);
		
		List<Pais> pe = getSession()
				.createCriteria(Pais.class,"p")
				.createAlias("p.continente", "pc")
				.add(Restrictions.eq("pc.nombreContinente","Europa"))
				.list();
		assertThat(pe).hasSize(2);
	}

}
