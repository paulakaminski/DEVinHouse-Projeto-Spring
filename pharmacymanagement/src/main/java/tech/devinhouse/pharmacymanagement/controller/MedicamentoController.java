package tech.devinhouse.pharmacymanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.pharmacymanagement.controller.dto.MedicamentoRequest;
import tech.devinhouse.pharmacymanagement.controller.dto.MedicamentoResponse;
import tech.devinhouse.pharmacymanagement.service.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<MedicamentoResponse> buscarTodosOsMedicamentos() {
        return medicamentoService.encontrarTodosOsMedicamentos();
    }

    @GetMapping("/{id}")
    public MedicamentoResponse buscarMedicamentoPorId(@PathVariable("id") Long id) {
        MedicamentoResponse medicamentoResponse = medicamentoService.encontrarMedicamentoPorId(id);

        return medicamentoResponse;
    }

    @PostMapping("/cadastro")
    public MedicamentoResponse cadastrarNovoMedicamento(@RequestBody MedicamentoRequest medicamentoRequest) {
        MedicamentoResponse medicamentoResponse = medicamentoService.cadastrarNovoMedicamento(medicamentoRequest);

        return medicamentoResponse;
    }

    @PutMapping("/update/{id}")
    public MedicamentoResponse atualizarMedicamentoPorId(
            @PathVariable("id") Long id,
            @RequestBody MedicamentoRequest medicamentoRequest) {

        MedicamentoResponse medicamentoResponse = medicamentoService.atualizarMedicamentoPorId(id, medicamentoRequest);

        return medicamentoResponse;

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletarMedicamentoPorId(@PathVariable("id") Long id) {
        medicamentoService.deletarMedicamentoPorId(id);
        return ResponseEntity.ok().build();
    }

}
