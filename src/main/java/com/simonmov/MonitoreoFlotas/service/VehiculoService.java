package com.simonmov.MonitoreoFlotas.service;

import com.simonmov.MonitoreoFlotas.domain.Vehiculo;

import java.util.Optional;

public interface VehiculoService {

    Optional<Vehiculo> findById(Integer id);

    Iterable<Vehiculo> findAll();

    Vehiculo save(Vehiculo vehiculo);

    void deleteById(Integer id);

    Optional<Vehiculo> findVehiculoAlertaCombustible(float combustible);
}
