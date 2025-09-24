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
    public NinjaDTO criarNinjas(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // Mostra todos os Ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaDTO> ListarNinjas(){
        return ninjaService.listarNinjas();
    }

    //Mostrar Ninjas por Id (READ)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjasPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }

}
