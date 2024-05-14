package com.hotel.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_factura;

    @Column(name = "detalle_cobro")
    private BigDecimal detalleCobro;

    @Column(name = "total_cobro")
    private BigDecimal totalCobro;

    @ManyToOne
	@JoinColumn(name = "id_salida")
	private Salida salida;

}
