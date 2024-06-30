package com.devops.eventmanagement.models.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name="ciudades")
public class Ciudad implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ciudad;

}
