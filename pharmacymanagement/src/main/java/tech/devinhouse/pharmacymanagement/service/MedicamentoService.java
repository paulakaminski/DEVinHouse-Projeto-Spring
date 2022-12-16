package tech.devinhouse.pharmacymanagement.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.MedicamentoEntity;
import tech.devinhouse.pharmacymanagement.dataprovider.repository.MedicamentoRepository;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<MedicamentoEntity> encontrarMedicamentos() {
        return medicamentoRepository.findAll();
    }
}
