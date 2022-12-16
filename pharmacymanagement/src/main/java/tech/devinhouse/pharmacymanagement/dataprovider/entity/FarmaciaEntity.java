package tech.devinhouse.pharmacymanagement.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "farmacia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FarmaciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "razao_social")
    @NotNull
    private String razaoSocial;

    @NotNull
    private String cnpj;

    @Column(name = "nome_fantasia")
    @NotNull
    private String nomeFantasia;

    @NotNull
    private String email;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    @Column(name = "telefone_celular")
    @NotNull
    private String telefoneCelular;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    @NotNull
    private EnderecoEntity enderecoEntity;

}
