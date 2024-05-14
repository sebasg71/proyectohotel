package modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	@Entity
	@Table(name="articulos")
	public class Articulo {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_articulo")
		private long idArticulo;
		@Column(name="nombre_articulo")
		private String  nombreArticulo;
		@Column(name="cantidad")
		private int cantidad;
		@Column(name="descripcion")
		private String  descripcion;
		@Column(name="numero_habitacion")
		private int numeroHabitacion;
		   
			
			public long getIdArticulo() {
				return idArticulo;
			}

			public void setIdArticulo(long idArticulo) {
				this.idArticulo = idArticulo;
			}

			public String getNombreArticulo() {
				return nombreArticulo;
			}

			public void setNombreArticulo(String nombreArticulo) {
				this.nombreArticulo = nombreArticulo;
			}

			public int getCantidad() {
				return cantidad;
			}

			public void setCantidad(int cantidad) {
				this.cantidad = cantidad;
			}

			public String getDescripcion() {
				return descripcion;
			}

			public void setDescripcion(String descripcion) {
				this.descripcion = descripcion;
			}

			public int getNumeroHabitacion() {
				return numeroHabitacion;
			}

			public void setNumeroHabitacion(int numeroHabitacion) {
				this.numeroHabitacion = numeroHabitacion;
			}

			
			
	}