package dev.java10x.CadastrosDeNinjas.Ninjas;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

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

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        // Converte DTO -> Model
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);

        // Salva no banco
        NinjaModel salvo = ninjaRepository.save(ninjaModel);

        // Converte Model -> DTO e retorna
        return ninjaMapper.map(salvo);
    }


    //Deletar o ninja
    public void deletarNinjaPorId(Long id){
       ninjaRepository.deleteById(id);
    }

    //Atualizar Ninjas
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado ){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
return ninjaRepository.save(ninjaAtualizado);

        }
        return null;
    }

}
