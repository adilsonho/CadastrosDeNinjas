package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira rota";
    }
}
