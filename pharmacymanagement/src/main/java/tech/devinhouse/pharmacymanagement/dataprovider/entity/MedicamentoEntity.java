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
    private String precoUnitario;

    @NotNull
    private String tipo;

}
