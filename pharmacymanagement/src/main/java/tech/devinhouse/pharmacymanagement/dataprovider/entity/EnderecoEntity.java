package tech.devinhouse.pharmacymanagement.dataprovider.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cep;

    @NotNull
    private String logradouro;

    @NotNull
    private Integer numero;

    @NotNull
    private String bairro;

    @Column(name = "cidade")
    @NotNull
    private String localidade;

    @Column(name  = "uf")
    @NotNull
    private String estado;

    private String complemento;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;

}
