package com.devops.eventmanagement.models.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name="clientes")
public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "ciudades_id")
    private Ciudad ciudad;




}
