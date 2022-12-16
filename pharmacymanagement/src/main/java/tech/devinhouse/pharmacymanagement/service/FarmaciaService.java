package tech.devinhouse.pharmacymanagement.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.FarmaciaEntity;
import tech.devinhouse.pharmacymanagement.dataprovider.repository.FarmaciaRepository;

import java.util.List;

@Service
public class FarmaciaService {

    private final FarmaciaRepository farmaciaRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }

    public List<FarmaciaEntity> encontrarFarmacias() {
        return farmaciaRepository.findAll();
    }

}
