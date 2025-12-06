package com.gimnasio.servicio_customer.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.gimnasio.servicio_customer.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private String direccion;
    private LocalDate fechaNacimiento;
    private String genero;
    private String membresia;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String estado;
    private Integer visitas;
    private String notas;
    private String contactoEmergencia;
    private String telefonoEmergencia;
    private LocalDateTime fechaRegistro;
    private Integer edad;
    private Integer diasRestantes;
    private Integer mesesMembresia;

    public static ClienteDTO fromEntity(Cliente cliente) {
        ClienteDTO dto = ClienteDTO.builder()
            .id(cliente.getId())
            .nombre(cliente.getNombre())
            .email(cliente.getEmail())
            .telefono(cliente.getTelefono())
            .documento(cliente.getDocumento())
            .direccion(cliente.getDireccion())
            .fechaNacimiento(cliente.getFechaNacimiento())
            .genero(cliente.getGenero())
            .membresia(cliente.getMembresia())
            .fechaInicio(cliente.getFechaInicio())
            .fechaVencimiento(cliente.getFechaVencimiento())
            .estado(cliente.getEstado())
            .visitas(cliente.getVisitas())
            .notas(cliente.getNotas())
            .contactoEmergencia(cliente.getContactoEmergencia())
            .telefonoEmergencia(cliente.getTelefonoEmergencia())
            .fechaRegistro(cliente.getFechaRegistro())
            .build();

        // Calcular edad
        if (cliente.getFechaNacimiento() != null) {
            Period period = Period.between(cliente.getFechaNacimiento(), LocalDate.now());
            dto.setEdad(period.getYears());
        }

        // Calcular días restantes
        if (cliente.getFechaVencimiento() != null) {
            Period period = Period.between(LocalDate.now(), cliente.getFechaVencimiento());
            dto.setDiasRestantes(period.getDays() + (period.getMonths() * 30) + (period.getYears() * 365));
        }

        // Calcular meses de membresía
        if (cliente.getFechaInicio() != null && cliente.getFechaVencimiento() != null) {
            Period period = Period.between(cliente.getFechaInicio(), cliente.getFechaVencimiento());
            dto.setMesesMembresia(period.getMonths() + (period.getYears() * 12));
        }

        return dto;
    }
}