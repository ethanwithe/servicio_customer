package com.gimnasio.servicio_customer.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadisticasDTO {
    private Long totalClientes;
    private Long membresiasActivas;
    private Long membresiasPorVencer;
    private Long membresiasVencidas;
    private Long nuevosClientes;
    private Double tasaRetencion;
    private Map<String, Long> distribucionMembresias;
    private List<Map<String, Object>> crecimientoMensual;
}