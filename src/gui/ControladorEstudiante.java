package gui;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	import gui.Estudiante;



	public class ControladorEstudiante {

		
			private static ControladorEstudiante instance = null;

			private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
			
			public static ControladorEstudiante getInstance () {
				if (instance == null) {
					instance = new ControladorEstudiante();
				}
				return instance;
			}
			
			public ControladorEstudiante() {
				
			}
			
			public Estudiante findPrimero () {
				Estudiante e = null;
				
				EntityManager em = factory.createEntityManager();
				Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1", Estudiante.class);
				e = (Estudiante) q.getSingleResult();
				em.close();
				
				return e;
			}
			
			public Estudiante findUltimo () {
				Estudiante e = null;
				
				EntityManager em = factory.createEntityManager();
				Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1", Estudiante.class);
				e = (Estudiante) q.getSingleResult();
				em.close();
				
				return e;
			}
			
			public Estudiante findSiguiente (int idActual) {
				Estudiante e = null;
				
				EntityManager em = factory.createEntityManager();
				Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1", Estudiante.class);
				q.setParameter(1, idActual);
				e = (Estudiante) q.getSingleResult();
				em.close();
				
				return e;
			}
			
			public Estudiante findAnterior (int idActual) {
				Estudiante e = null;
				
				EntityManager em = factory.createEntityManager();
				Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1", Estudiante.class);
				q.setParameter(1, idActual);
				e = (Estudiante) q.getSingleResult();
				em.close();
				
				return e;		
			}
		
			public boolean guardar (Estudiante e) {
				try {
					EntityManager em = factory.createEntityManager();
					em.getTransaction().begin();
					if (e.getId() == 0) {
						em.persist(e);
					}
					else {
						em.merge(e);
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

			public void borrar(Estudiante e) {
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				em.remove(e);
				em.getTransaction().commit();
				em.close();
	}
}

