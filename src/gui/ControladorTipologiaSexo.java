package gui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import gui.Estudiante;
import gui.TipologiaSexo;

public class ControladorTipologiaSexo {

	private static ControladorTipologiaSexo instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
	
	public static ControladorTipologiaSexo getInstance () {
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	
	public ControladorTipologiaSexo() {
	}
	
	public TipologiaSexo findPrimero () {
		TipologiaSexo m = null;
	
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id limit 1", TipologiaSexo.class);
		m = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return m;
	}
	
	public TipologiaSexo findUltimo () {
		TipologiaSexo m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id desc limit 1", TipologiaSexo.class);
		m = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return m;
	}
	
	public TipologiaSexo findSiguiente (int idActual) {
		TipologiaSexo m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id > ? order by id limit 1", TipologiaSexo.class);
		q.setParameter(1, idActual);
		m = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return m;
	}
	
	public TipologiaSexo findAnterior (int idActual) {
		TipologiaSexo m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id < ? order by id desc limit 1", TipologiaSexo.class);
		q.setParameter(1, idActual);
		m = (TipologiaSexo) q.getSingleResult();
		em.close();
		
		return m;		
	}
	
	public boolean guardar (TipologiaSexo m) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (m.getIdtipologiaSexo() == 0) {
				em.persist(m);
			}
			else {
				em.merge(m);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}

	public void borrar(TipologiaSexo m) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		m=em.merge(m);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
	}
	public List<TipologiaSexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", TipologiaSexo.class);
		
		List<TipologiaSexo> list = (List<TipologiaSexo>) q.getResultList();
		em.close();
		return list;
	}

	
	

}