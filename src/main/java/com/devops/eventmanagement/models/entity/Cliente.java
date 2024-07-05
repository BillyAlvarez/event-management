package com.devops.eventmanagement.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotEmpty
    private String nombres;
    @NotEmpty
    private String apellidos;
    @NotEmpty
    @Size(min = 9, max = 9)
    @Pattern(regexp = "[0-9]{9}")
    private String telefono;
    @NotEmpty
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "ciudades_id")
    private Ciudad ciudad;




}
