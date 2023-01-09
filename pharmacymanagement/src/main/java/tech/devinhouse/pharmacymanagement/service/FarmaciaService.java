package tech.devinhouse.pharmacymanagement.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.pharmacymanagement.controller.dto.EnderecoResponse;
import tech.devinhouse.pharmacymanagement.controller.dto.FarmaciaRequest;
import tech.devinhouse.pharmacymanagement.controller.dto.FarmaciaResponse;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.EnderecoEntity;
import tech.devinhouse.pharmacymanagement.dataprovider.entity.FarmaciaEntity;
import tech.devinhouse.pharmacymanagement.dataprovider.repository.EnderecoRepository;
import tech.devinhouse.pharmacymanagement.dataprovider.repository.FarmaciaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FarmaciaService {

    private final FarmaciaRepository farmaciaRepository;
    private final EnderecoRepository enderecoRepository;
    private final CepService cepService;

    public FarmaciaService(FarmaciaRepository farmaciaRepository, EnderecoRepository enderecoRepository, CepService cepService) {
        this.farmaciaRepository = farmaciaRepository;
        this.enderecoRepository = enderecoRepository;
        this.cepService = cepService;
    }

    public List<FarmaciaResponse> encontrarTodasAsFarmacias() {
        List<FarmaciaEntity> entityList = farmaciaRepository.findAll();

        List<FarmaciaResponse> responseList = new ArrayList<>();

        for (FarmaciaEntity farmaciaEntity:
             entityList) {
            responseList.add(
                    new FarmaciaResponse(farmaciaEntity.getRazaoSocial()
                            , farmaciaEntity.getCnpj()
                            , farmaciaEntity.getNomeFantasia()
                            , farmaciaEntity.getEmail()
                            , farmaciaEntity.getTelefoneFixo()
                            , farmaciaEntity.getTelefoneCelular()
                            , new EnderecoResponse(farmaciaEntity.getEnderecoEntity().getCep()
                                , farmaciaEntity.getEnderecoEntity().getLogradouro()
                                , farmaciaEntity.getEnderecoEntity().getNumero()
                                , farmaciaEntity.getEnderecoEntity().getBairro()
                                , farmaciaEntity.getEnderecoEntity().getLocalidade()
                                , farmaciaEntity.getEnderecoEntity().getUf()
                                , farmaciaEntity.getEnderecoEntity().getComplemento()
                                , farmaciaEntity.getEnderecoEntity().getLatitude()
                                , farmaciaEntity.getEnderecoEntity().getLongitude()))
            );

        }

        return responseList;
    }

    public FarmaciaResponse encontrarFarmaciaPorId(Long id) {
        FarmaciaEntity farmaciaEntity = farmaciaRepository.findById(id).get();

        return new FarmaciaResponse(farmaciaEntity.getRazaoSocial()
                , farmaciaEntity.getCnpj()
                , farmaciaEntity.getNomeFantasia()
                , farmaciaEntity.getEmail()
                , farmaciaEntity.getTelefoneFixo()
                , farmaciaEntity.getTelefoneCelular()
                , new EnderecoResponse(farmaciaEntity.getEnderecoEntity().getCep()
                    , farmaciaEntity.getEnderecoEntity().getLogradouro()
                    , farmaciaEntity.getEnderecoEntity().getNumero()
                    , farmaciaEntity.getEnderecoEntity().getBairro()
                    , farmaciaEntity.getEnderecoEntity().getLocalidade()
                    , farmaciaEntity.getEnderecoEntity().getUf()
                    , farmaciaEntity.getEnderecoEntity().getComplemento()
                    , farmaciaEntity.getEnderecoEntity().getLatitude()
                    , farmaciaEntity.getEnderecoEntity().getLongitude())
        );
    }

    public FarmaciaResponse salvarNovaFarmacia(FarmaciaRequest farmaciaRequest) {

        EnderecoResponse enderecoResponse = cepService.buscaCep(farmaciaRequest.getCep());
        enderecoResponse.setNumero(farmaciaRequest.getNumero());
        enderecoResponse.setComplemento(farmaciaRequest.getComplemento());
        enderecoResponse.setLatitude(farmaciaRequest.getLatitude());
        enderecoResponse.setLongitude(farmaciaRequest.getLongitude());

        EnderecoEntity enderecoEntity = enderecoRepository.save(
                new EnderecoEntity(enderecoResponse.getCep()
                        , enderecoResponse.getLogradouro()
                        , enderecoResponse.getNumero()
                        , enderecoResponse.getBairro()
                        , enderecoResponse.getLocalidade()
                        , enderecoResponse.getUf()
                        , enderecoResponse.getComplemento()
                        , enderecoResponse.getLatitude()
                        , enderecoResponse.getLongitude())
        );

        FarmaciaEntity farmaciaEntity = farmaciaRepository.save(
                new FarmaciaEntity(farmaciaRequest.getRazaoSocial()
                        , farmaciaRequest.getCnpj()
                        , farmaciaRequest.getNomeFantasia()
                        , farmaciaRequest.getEmail()
                        , farmaciaRequest.getTelefoneFixo()
                        , farmaciaRequest.getTelefoneCelular()
                        , enderecoEntity)
        );

        return new FarmaciaResponse(farmaciaEntity.getRazaoSocial()
                , farmaciaEntity.getCnpj()
                , farmaciaEntity.getNomeFantasia()
                , farmaciaEntity.getEmail()
                , farmaciaEntity.getTelefoneFixo()
                , farmaciaEntity.getTelefoneCelular()
                , new EnderecoResponse(farmaciaEntity.getEnderecoEntity().getCep()
                , farmaciaEntity.getEnderecoEntity().getLogradouro()
                , farmaciaEntity.getEnderecoEntity().getNumero()
                , farmaciaEntity.getEnderecoEntity().getBairro()
                , farmaciaEntity.getEnderecoEntity().getLocalidade()
                , farmaciaEntity.getEnderecoEntity().getUf()
                , farmaciaEntity.getEnderecoEntity().getComplemento()
                , farmaciaEntity.getEnderecoEntity().getLatitude()
                , farmaciaEntity.getEnderecoEntity().getLongitude())
        );

    }

}
