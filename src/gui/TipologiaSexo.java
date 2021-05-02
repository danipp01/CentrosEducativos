package gui;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
	@NamedQuery(name="Tipologiasexo.findAll", query="SELECT t FROM TipologiaSexo t")
	public class TipologiaSexo implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int idTipologiaSexo;

		private String descripcion;

		//bi-directional many-to-one association to Estudiante
		@OneToMany(mappedBy="tipologiasexo")
		private List<Estudiante> estudiantes;

		//bi-directional many-to-one association to Profesor
		@OneToMany(mappedBy="tipologiasexo")
		private List<Profesor> profesors;

		public TipologiaSexo() {
		}

		public int getIdTipologiaSexo() {
			return this.idTipologiaSexo;
		}

		public void setIdTipologiaSexo(int idTipologiaSexo) {
			this.idTipologiaSexo = idTipologiaSexo;
		}

		public String getDescripcion() {
			return this.descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public List<Estudiante> getEstudiantes() {
			return this.estudiantes;
		}

		public void setEstudiantes(List<Estudiante> estudiantes) {
			this.estudiantes = estudiantes;
		}

		public Estudiante addEstudiante(Estudiante estudiante) {
			getEstudiantes().add(estudiante);
			estudiante.setTipologiasexo(this);

			return estudiante;
		}

		public Estudiante removeEstudiante(Estudiante estudiante) {
			getEstudiantes().remove(estudiante);
			estudiante.setTipologiasexo(null);

			return estudiante;
		}

		public List<Profesor> getProfesors() {
			return this.profesors;
		}

		public void setProfesors(List<Profesor> profesors) {
			this.profesors = profesors;
		}

		public Profesor addProfesor(Profesor profesor) {
			getProfesors().add(profesor);
			profesor.setTipologiasexo(this);

			return profesor;
		}

		public Profesor removeProfesor(Profesor profesor) {
			getProfesors().remove(profesor);
			profesor.setTipologiasexo(null);

			return profesor;
		}

	}

