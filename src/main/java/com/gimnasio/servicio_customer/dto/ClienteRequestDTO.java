package com.gimnasio.servicio_customer.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Formato de email inválido")
    @Size(max = 100)
    private String email;

    @Size(max = 20)
    private String telefono;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres")
    private String password;

    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 20)
    private String documento;

    @Size(max = 200)
    private String direccion;

    private LocalDate fechaNacimiento;

    @Size(max = 20)
    private String genero;

    @NotBlank(message = "La membresía es obligatoria")
    @Size(max = 50)
    private String membresia;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    private LocalDate fechaVencimiento;

    @Size(max = 100)
    private String contactoEmergencia;

    @Size(max = 20)
    private String telefonoEmergencia;

    private String notas;
}
