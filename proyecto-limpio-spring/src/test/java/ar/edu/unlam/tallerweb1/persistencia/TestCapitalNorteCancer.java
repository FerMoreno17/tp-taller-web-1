package ar.edu.unlam.tallerweb1.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;
import static org.assertj.core.api.Assertions.*;


public class TestCapitalNorteCancer extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void testCapitalesAlNorteDeCancer() {
		Session session = getSession();
		
		Ubicacion uOttawa = new Ubicacion();
		uOttawa.setLatitud(454208);
		uOttawa.setLongitud(756945);
		session.save(uOttawa);
		
		Ubicacion uRoma = new Ubicacion();
		uRoma.setLatitud(418905);
		uRoma.setLongitud(124942);
		session.save(uRoma);
		
		Ubicacion uBrasilia = new Ubicacion();
		uBrasilia.setLatitud(-154647);
		uBrasilia.setLongitud(475547);
		session.save(uBrasilia);
		
		Ciudad ottawa = new Ciudad();
		ottawa.setCapital(true);
		ottawa.setNombre("Ottawa");
		ottawa.setPais("Canada");
		ottawa.setUbicacion(uOttawa);
		session.save(ottawa);
		
		Ciudad roma = new Ciudad();
		roma.setCapital(true);
		roma.setNombre("Roma");
		roma.setPais("Italia");
		roma.setUbicacion(uRoma);
		session.save(roma);
		
		Ciudad brasilia = new Ciudad();
		brasilia.setCapital(true);
		brasilia.setNombre("Brasilia");
		brasilia.setPais("Brasil");
		brasilia.setUbicacion(uBrasilia);
		session.save(brasilia);
		
		Pais canada = new Pais();
		canada.setNombre("Canada");
		canada.setCapital(ottawa);
		session.save(canada);
		
		Pais brasil = new Pais();
		brasil.setNombre("Brasil");
		brasil.setCapital(brasilia);
		session.save(brasil);
		
		Pais italia = new Pais();
		italia.setNombre("Italia");
		italia.setCapital(roma);
		session.save(italia);
		
		List<Pais> pcsc = getSession()
				.createCriteria(Pais.class,"p")
				.createAlias("p.capital", "c")
				.createAlias("c.ubicacion", "u")
				.add(Restrictions.ge("u.latitud", 232614))
				.list();
		assertThat(pcsc).hasSize(2);
	}

}
