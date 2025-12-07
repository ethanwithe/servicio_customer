package com.gimnasio.servicio_customer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gimnasio.servicio_customer.dto.ClienteDTO;
import com.gimnasio.servicio_customer.dto.ClienteRequestDTO;
import com.gimnasio.servicio_customer.dto.EstadisticasDTO;
import com.gimnasio.servicio_customer.model.Cliente;
import com.gimnasio.servicio_customer.service.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@Valid @RequestBody ClienteRequestDTO dto) {
        log.info("Creando cliente {}", dto.getEmail());
        ClienteDTO nuevoCliente = clienteService.crearCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizarCliente(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDTO dto) {
        ClienteDTO clienteActualizado = clienteService.actualizarCliente(id, dto);
        return ResponseEntity.ok(clienteActualizado);
    }



    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> obtenerTodosLosClientes() {
        List<ClienteDTO> clientes = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<ClienteDTO>> obtenerClientesActivos() {
        List<ClienteDTO> clientes = clienteService.obtenerClientesActivos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/membresia/{tipo}")
    public ResponseEntity<List<ClienteDTO>> obtenerClientesPorMembresia(
            @PathVariable String tipo) {
        List<ClienteDTO> clientes = clienteService.obtenerClientesPorMembresia(tipo);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/por-vencer")
    public ResponseEntity<List<ClienteDTO>> obtenerMembresiasPorVencer(
            @RequestParam(defaultValue = "30") int dias) {
        List<ClienteDTO> clientes = clienteService.obtenerMembresiasPorVencer(dias);
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/renovar")
    public ResponseEntity<ClienteDTO> renovarMembresia(
            @PathVariable Long id,
            @RequestParam int meses) {
        ClienteDTO clienteRenovado = clienteService.renovarMembresia(id, meses);
        return ResponseEntity.ok(clienteRenovado);
    }

    @PostMapping("/{id}/visita")
    public ResponseEntity<ClienteDTO> registrarVisita(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.registrarVisita(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ClienteDTO>> buscarClientes(
            @RequestParam String keyword) {
        List<ClienteDTO> clientes = clienteService.buscarClientes(keyword);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<EstadisticasDTO> obtenerEstadisticas() {
        EstadisticasDTO estadisticas = clienteService.obtenerEstadisticas();
        return ResponseEntity.ok(estadisticas);
    }

    @GetMapping("/crecimiento")
    public ResponseEntity<List<Map<String, Object>>> obtenerCrecimientoMensual() {
        List<Map<String, Object>> crecimiento = clienteService.obtenerCrecimientoMensual();
        return ResponseEntity.ok(crecimiento);
    }

    @GetMapping("/top")
    public ResponseEntity<List<ClienteDTO>> obtenerTopClientes(
            @RequestParam(defaultValue = "10") int limite) {
        List<ClienteDTO> topClientes = clienteService.obtenerTopClientes(limite);
        return ResponseEntity.ok(topClientes);
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "servicio-customer");
        return ResponseEntity.ok(response);
    }
}