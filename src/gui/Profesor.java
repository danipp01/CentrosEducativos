package gui;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellido1;

	private String apellido2;

	private String direccion;

	private String dni;

	private String email;

	private String nombre;

	private String telefono;

	@ManyToOne
	private TipologiaSexo tipologiasexo;

	@OneToMany(mappedBy="profesor")
	private List<ValoracionMateria> valoracionmaterias;

	public Profesor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipologiaSexo getTipologiasexo() {
		return this.tipologiasexo;
	}

	public void setTipologiasexo(TipologiaSexo tipologiasexo) {
		this.tipologiasexo = tipologiasexo;
	}

	public List<ValoracionMateria> getValoracionmaterias() {
		return this.valoracionmaterias;
	}

	public void setValoracionmaterias(List<ValoracionMateria> valoracionmaterias) {
		this.valoracionmaterias = valoracionmaterias;
	}

	public ValoracionMateria addValoracionmateria(ValoracionMateria valoracionmateria) {
		getValoracionmaterias().add(valoracionmateria);
		valoracionmateria.setProfesor(this);

		return valoracionmateria;
	}

	public ValoracionMateria removeValoracionmateria(ValoracionMateria valoracionmateria) {
		getValoracionmaterias().remove(valoracionmateria);
		valoracionmateria.setProfesor(null);

		return valoracionmateria;
	}

}