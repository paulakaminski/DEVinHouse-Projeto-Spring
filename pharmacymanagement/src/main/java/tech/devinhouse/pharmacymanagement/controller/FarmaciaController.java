package tech.devinhouse.pharmacymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.pharmacymanagement.controller.dto.FarmaciaRequest;
import tech.devinhouse.pharmacymanagement.controller.dto.FarmaciaResponse;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.FarmaciaEntity;
import tech.devinhouse.pharmacymanagement.service.FarmaciaService;

import java.util.List;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

    private final FarmaciaService farmaciaService;

    public FarmaciaController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }

    @GetMapping
    public List<FarmaciaResponse> encontrarTodasAsFarmacias() {
        return farmaciaService.encontrarTodasAsFarmacias();
    }

    @GetMapping("/{id}")
    public FarmaciaResponse encontrarFarmaciaPorId(@PathVariable("id") Long id) {
        FarmaciaResponse farmaciaResponse = farmaciaService.encontrarFarmaciaPorId(id);

        return farmaciaResponse;
    }

    @PostMapping()
    public ResponseEntity<FarmaciaResponse> salvarNovaFarmacia(@RequestBody FarmaciaRequest farmaciaRequest) {
        FarmaciaResponse farmaciaResponse = farmaciaService.salvarNovaFarmacia(farmaciaRequest);

        return new ResponseEntity<>(farmaciaResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public FarmaciaResponse atualizarFarmaciaPorId(@PathVariable("id") Long id, @RequestBody FarmaciaRequest farmaciaRequest) {
        FarmaciaResponse farmaciaResponse = farmaciaService.atualizarFarmaciaPorId(id, farmaciaRequest);

        return farmaciaResponse;
    }

    @DeleteMapping("/{id}")
    public void deletarFarmaciaPorId(@PathVariable("id") Long id) {
        farmaciaService.deletarFarmaciaPorId(id);

    }

}
