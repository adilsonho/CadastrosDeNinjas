package dev.java10x.CadastrosDeNinjas.Ninjas;

import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name="idade")
    private int idade;

    @Column(name= "rank")
    private String rank;

    // Muitos ninjas podem estar em UMA missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreign key no banco
    private MissoesModel missoes;

    public NinjaModel() {}

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }
}
