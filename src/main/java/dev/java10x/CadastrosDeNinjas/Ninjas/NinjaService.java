package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    //Listar todos os ninjas por id
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjasPorId = ninjaRepository.findById(id);
        return ninjasPorId.orElse(null);
    }

    //criar um novo ninja

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    //Deletar o ninja
    public void deletarNinjaPorId(Long id){
       ninjaRepository.deleteById(id);
    }
}
