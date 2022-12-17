package tech.devinhouse.pharmacymanagement.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "medicamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String laboratorio;

    @NotNull
    private String dosagem;

    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull
    private Double precoUnitario;

    @NotNull
    private String tipo;

    public MedicamentoEntity(String nome
            , String laboratorio
            , String dosagem
            , String descricao
            , Double precoUnitario
            , String tipo) {
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.dosagem = dosagem;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.tipo = tipo;
    }

}
