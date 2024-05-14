package modelo.entidad;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id_cliente;
		
		@Column(name="primer_nombre")
		private String primerNombre;
		
		@Column(name="segundo_nombre")
		private String segundoNombre;
		
		@Column(name="primer_apellido")
		private String primerApellido;
		
		@Column(name="segundo_apellido")
		private String segundoApellido;
		
		@Column(name="edad")
		private  int edad;
		
		@Column(name="direccion")
		private String direccion;
		
		@Column(name="telefono")
		private long telefono;
		
		@Column(name="genero")
		private String genero;
		
		@OneToMany(mappedBy="cliente", cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
		private List<Reserva> reserva;

		 
	public Cliente() { 
	}


	public long getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getPrimerNombre() {
		return primerNombre;
	}


	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}


	public String getSegundoNombre() {
		return segundoNombre;
	}


	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}


	public String getPrimerApellido() {
		return primerApellido;
	}


	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}


	public String getSegundoApellido() {
		return segundoApellido;
	}


	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	


	
	
	
	
	
	
	
	

}
