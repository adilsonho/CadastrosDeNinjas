package dev.java10x.CadastrosDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas =  ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas"; // Tem que retornar o nome da pagina que renderiza
    }



    @GetMapping("/deletar/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/detalhes/{id}")
    public String listarNinjasPorId(@PathVariable Long id, Model model) {
        NinjaDTO ninja =  ninjaService.listarNinjasPorId(id);
        if (ninja !=null) {
            model.addAttribute("ninja", ninja);
            return "detalhesninja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado");
            return "listarNinjas";
        }
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarNinja(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "editarNinja";
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja não encontrado para edição.");
            return "redirect:/ninjas/ui/listar";
        }
    }

    @PostMapping("/alterar/{id}")
    public String alterarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninjaAtualizado, RedirectAttributes redirectAttributes) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);

        if (ninja != null) {
            redirectAttributes.addFlashAttribute("mensagem", "Ninja atualizado com sucesso!");
            // Redireciona para a lista ou para a página de detalhes
            return "redirect:/ninjas/ui/detalhes/" + id;
        } else {
            redirectAttributes.addFlashAttribute("erro", "Erro: Ninja com o id: " + id + " não existe nos nossos registros.");
            return "redirect:/ninjas/ui/listar";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "adicionarNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }

}