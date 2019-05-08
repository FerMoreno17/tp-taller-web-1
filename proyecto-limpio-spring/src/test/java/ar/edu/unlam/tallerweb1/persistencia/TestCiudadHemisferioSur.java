package ar.edu.unlam.tallerweb1.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;
import static org.assertj.core.api.Assertions.*;


public class TestCiudadHemisferioSur extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void testCiudadesDelHemisferioSur() {
		Session session = getSession();
		
		Ubicacion uBrasilia = new Ubicacion();
		uBrasilia.setLatitud(-154647);
		uBrasilia.setLongitud(475547);
		session.save(uBrasilia);
		
		Ubicacion uBsas = new Ubicacion();
		uBsas.setLatitud(-343647);
		uBsas.setLongitud(582238);
		session.save(uBsas);
		
		Ubicacion uOttawa = new Ubicacion();
		uOttawa.setLatitud(454208);
		uOttawa.setLongitud(756945);
		session.save(uOttawa);
		
		Ciudad brasilia = new Ciudad();
		brasilia.setUbicacion(uBrasilia);
		session.save(brasilia);
		
		Ciudad bsas = new Ciudad();
		bsas.setUbicacion(uBsas);
		session.save(bsas);
		
		Ciudad ottawa = new Ciudad();
		ottawa.setUbicacion(uOttawa);
		session.save(ottawa);
		
		List<Ciudad> chs = getSession()
				.createCriteria(Ciudad.class,"c")
				.createAlias("c.ubicacion", "u")
				.add(Restrictions.ge("u.latitud",-900000))
				.add(Restrictions.lt("u.latitud", 0))
				.list();
		assertThat(chs).hasSize(2);
	}

}
