package com.simonmov.MonitoreoFlotas.repository;

import com.simonmov.MonitoreoFlotas.domain.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo,Integer> {

    @Query("SELECT v FROM Vehiculo v WHERE v.combustible < :combustible ")
    Optional<Vehiculo> findVehiculoAlertaCombustible(@Param("combustible") float combustible);
}
