package dev.java10x.CadastrosDeNinjas.Ninjas;

import dev.java10x.CadastrosDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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

//uma missao para varios ninjas
@OneToMany
@JoinColumn(name = "missoes_id") //foreign key ou chave estrangeira
    private MissoesModel missoes;

    public NinjaModel(){


    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

