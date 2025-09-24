package dev.java10x.CadastrosDeNinjas.Ninjas;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos os ninjas por id
    public NinjaDTO listarNinjasPorId(Long id) {
        Optional<NinjaModel> ninjasPorId = ninjaRepository.findById(id);
        return ninjasPorId.map(ninjaMapper::map).orElse(null);
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
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    //Atualizar Ninjas
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjasExistente = ninjaRepository.findById(id);
        if (ninjasExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}