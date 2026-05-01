package com.simonmov.MonitoreoFlotas.controller;

import com.simonmov.MonitoreoFlotas.domain.User;
import com.simonmov.MonitoreoFlotas.domain.Vehiculo;
import com.simonmov.MonitoreoFlotas.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Vehiculo>> findAll(){
        return ResponseEntity.ok(this.vehiculoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Vehiculo> save(@RequestBody Vehiculo vehiculo){
        return new ResponseEntity<>(
                this.vehiculoService.save(vehiculo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehiculo> deleteById(@PathVariable Integer id){
        this.vehiculoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/vehiculoAlerta/{combustible}")
    public Optional<Vehiculo> findVehiculoAlertaCombustible(@PathVariable float combustible){
        return this.vehiculoService.findVehiculoAlertaCombustible(combustible);
    }
}
