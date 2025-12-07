package com.gimnasio.servicio_customer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(length = 20)
    private String telefono;
    
    @Column(length = 100)
    private String password;

    @Column(unique = true, length = 20)
    private String documento;

    @Column(length = 200)
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(length = 20)
    private String genero;

    @Column(nullable = false, length = 50)
    private String membresia; // Premium Anual, Semestral, Trimestral, Mensual, Familiar

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false, length = 20)
    private String estado; // Activa, Por Vencer, Vencida, Suspendida

    @Column(nullable= false)
    private Integer visitas;
    @Column(columnDefinition = "TEXT")
    private String notas;

    @Column(name = "contacto_emergencia", length = 100)
    private String contactoEmergencia;

    @Column(name = "telefono_emergencia", length = 20)
    private String telefonoEmergencia;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
        if (visitas == null) {
            visitas = 0;
        }
        if (estado == null) {
            actualizarEstado();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
        actualizarEstado();
    }

    private void actualizarEstado() {
        LocalDate hoy = LocalDate.now();
        LocalDate proximoVencimiento = hoy.plusDays(30);

        if (fechaVencimiento.isBefore(hoy)) {
            estado = "Vencida";
        } else if (fechaVencimiento.isBefore(proximoVencimiento)) {
            estado = "Por Vencer";
        } else {
            estado = "Activa";
        }
    }
}