package tech.devinhouse.pharmacymanagement.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarmaciaRequest {
    private String razaoSocial;
    private String cnpj;
    private String nomeFantasia;
    private String email;
    private String telefoneFixo;
    private String telefoneCelular;
    private String cep;
    private Integer numero;
    private String complemento;
    private String latitude;
    private String longitude;
}
