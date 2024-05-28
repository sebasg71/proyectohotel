package com.hotel.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salida")
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salida;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @ManyToOne
    @JoinColumn(name = "id_hospedaje")
    private Hospedaje hospedaje;

    public Long getId_salida() {
        return id_salida;
    }

    public void setId_salida(Long id_salida) {
        this.id_salida = id_salida;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Hospedaje getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(Hospedaje hospedaje) {
        this.hospedaje = hospedaje;
    }

}
