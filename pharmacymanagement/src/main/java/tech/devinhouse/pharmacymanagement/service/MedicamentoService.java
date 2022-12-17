package tech.devinhouse.pharmacymanagement.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.pharmacymanagement.controller.dto.MedicamentoRequest;
import tech.devinhouse.pharmacymanagement.controller.dto.MedicamentoResponse;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.MedicamentoEntity;
import tech.devinhouse.pharmacymanagement.dataprovider.repository.MedicamentoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<MedicamentoResponse> encontrarTodosOsMedicamentos() {
        List<MedicamentoEntity> entityList = medicamentoRepository.findAll();

        List<MedicamentoResponse> responseList = new ArrayList<>();

        for (MedicamentoEntity medicamentoEntity:
             entityList) {
            responseList.add(
                    new MedicamentoResponse(medicamentoEntity.getNome()
                            , medicamentoEntity.getLaboratorio()
                            , medicamentoEntity.getDosagem()
                            , medicamentoEntity.getDescricao()
                            , medicamentoEntity.getPrecoUnitario()
                            , medicamentoEntity.getTipo())
            );
        }

        return responseList;
    }

    public MedicamentoResponse encontrarMedicamentoPorId(Long id) {
        MedicamentoEntity medicamentoEntity = medicamentoRepository.findById(id).get();

        return new MedicamentoResponse(medicamentoEntity.getNome()
                , medicamentoEntity.getLaboratorio()
                , medicamentoEntity.getDosagem()
                , medicamentoEntity.getDescricao()
                , medicamentoEntity.getPrecoUnitario()
                , medicamentoEntity.getTipo()
        );
    }

    public MedicamentoResponse cadastrarNovoMedicamento(MedicamentoRequest medicamentoRequest) {
        MedicamentoEntity medicamentoEntity = medicamentoRepository.save(
                new MedicamentoEntity(medicamentoRequest.getNome()
                        , medicamentoRequest.getLaboratorio()
                        , medicamentoRequest.getDosagem()
                        , medicamentoRequest.getDescricao()
                        , medicamentoRequest.getPrecoUnitario()
                        , medicamentoRequest.getTipo()
                ));

        return new MedicamentoResponse(medicamentoEntity.getNome()
                , medicamentoEntity.getLaboratorio()
                , medicamentoEntity.getDosagem()
                , medicamentoEntity.getDescricao()
                , medicamentoEntity.getPrecoUnitario()
                , medicamentoEntity.getTipo()
        );

    }

    public MedicamentoResponse atualizarMedicamentoPorId(Long id, MedicamentoRequest medicamentoRequest) {
        MedicamentoEntity medicamentoEntity = medicamentoRepository.findById(id).get();

        medicamentoEntity.setNome(medicamentoRequest.getNome());
        medicamentoEntity.setLaboratorio(medicamentoRequest.getLaboratorio());
        medicamentoEntity.setDosagem(medicamentoRequest.getDosagem());
        medicamentoEntity.setDescricao(medicamentoRequest.getDescricao());
        medicamentoEntity.setPrecoUnitario(medicamentoRequest.getPrecoUnitario());
        medicamentoEntity.setTipo(medicamentoRequest.getTipo());

        medicamentoRepository.save(medicamentoEntity);

        return new MedicamentoResponse(medicamentoEntity.getNome()
                , medicamentoEntity.getLaboratorio()
                , medicamentoEntity.getDosagem()
                , medicamentoEntity.getDescricao()
                , medicamentoEntity.getPrecoUnitario()
                , medicamentoEntity.getTipo()
        );

    }

    public void deletarMedicamentoPorId(Long id) {
        medicamentoRepository.deleteById(id);
    }

}
