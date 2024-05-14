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
    private String detalleCobro;

    @Column(name = "total_cobro")
    private BigDecimal totalCobro;

    @ManyToOne
    @JoinColumn(name = "id_salida")
    private Salida salida;

    public long getId_factura() {
        return id_factura;
    }

    public void setId_factura(long id_factura) {
        this.id_factura = id_factura;
    }

    public BigDecimal getTotalCobro() {
        return totalCobro;
    }

    public void setTotalCobro(BigDecimal totalCobro) {
        this.totalCobro = totalCobro;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public String getDetalleCobro() {
        return detalleCobro;
    }

    public void setDetalleCobro(String detalleCobro) {
        this.detalleCobro = detalleCobro;
    }

}
