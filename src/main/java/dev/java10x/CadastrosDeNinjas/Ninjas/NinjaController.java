package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira rota";
    }

    //adicionar Ninjas (CREATE)
    @PostMapping("/criar")
    public String criarNinjas(){
        return "Ninja criado";
    }

    // Mostra todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> ListarNinjas(){
        return ninjaService.ListarNinjas();
    }

    //Mostrar Ninjas por Id (READ)
    @GetMapping("/todosID")
    public String mostrarNinjasPorId(){
        return "Mostrar Ninjas Por Id";
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinjasPorId(){
        return "Alterar Ninjas Por ID";
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjasPorId(){
        return "Deletar Ninjas Por ID";
    }

}
