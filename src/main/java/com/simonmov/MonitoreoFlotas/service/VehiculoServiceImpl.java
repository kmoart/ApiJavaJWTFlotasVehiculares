package com.simonmov.MonitoreoFlotas.service;

import com.simonmov.MonitoreoFlotas.domain.Vehiculo;
import com.simonmov.MonitoreoFlotas.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


    @Override
    public Optional<Vehiculo> findById(Integer id) {
        return this.vehiculoRepository.findById(id);
    }

    @Override
    public Iterable<Vehiculo> findAll() {
        return this.vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo save(Vehiculo vehiculo) {
        return this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void deleteById(Integer id) {
        this.vehiculoRepository.deleteById(id);
    }

    @Override
    public Optional<Vehiculo> findVehiculoAlertaCombustible(float combustible) {
        return this.vehiculoRepository.findVehiculoAlertaCombustible(combustible);
    }
}
