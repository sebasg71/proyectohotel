package modelo.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Hospedaje{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id_hospedaje;
		
		@Column(name="ciudad_domicilio")
		private String ciudadDomicilio;
		
		@Column(name="motivo_hospedaje")
		private String motivoHospedaje;
		
}
