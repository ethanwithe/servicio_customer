package com.gimnasio.servicio_customer.service;

import java.util.List;
import java.util.Map;

import com.gimnasio.servicio_customer.dto.ClienteDTO;
import com.gimnasio.servicio_customer.dto.EstadisticasDTO;
import com.gimnasio.servicio_customer.model.Cliente;

public interface ClienteService {

    ClienteDTO crearCliente(Cliente cliente);

    ClienteDTO obtenerClientePorId(Long id);

    List<ClienteDTO> obtenerTodosLosClientes();

    List<ClienteDTO> obtenerClientesActivos();

    List<ClienteDTO> obtenerClientesPorMembresia(String membresia);

    List<ClienteDTO> obtenerMembresiasPorVencer(int dias);

    ClienteDTO actualizarCliente(Long id, Cliente cliente);

    void eliminarCliente(Long id);

    ClienteDTO renovarMembresia(Long id, int meses);

    ClienteDTO registrarVisita(Long id);

    List<ClienteDTO> buscarClientes(String keyword);

    EstadisticasDTO obtenerEstadisticas();

    List<Map<String, Object>> obtenerCrecimientoMensual();

    List<ClienteDTO> obtenerTopClientes(int limite);
}
