package tech.devinhouse.pharmacymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<FarmaciaEntity> teste() {
        return farmaciaService.encontrarFarmacias();
    }

}
