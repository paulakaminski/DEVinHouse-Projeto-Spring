package tech.devinhouse.pharmacymanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.MedicamentoEntity;
import tech.devinhouse.pharmacymanagement.service.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<MedicamentoEntity> teste() {
        return medicamentoService.encontrarMedicamentos();
    }

}
