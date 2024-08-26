package br.com.fiap.lojaBrinquedos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.lojaBrinquedos.DTO.BrinquedoDTO;
import br.com.fiap.lojaBrinquedos.Service.BrinquedoService;

@Controller
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping
    public String getAll(Model model) {
        List<BrinquedoDTO> brinquedos = brinquedoService.getAll();
        model.addAttribute("brinquedos", brinquedos);
        return "brinquedos";
    }

    @GetMapping("/descricao/{id}")
    public String getById(@PathVariable Long id, Model model) {
        BrinquedoDTO brinquedo = brinquedoService.getById(id);
        if (brinquedo != null) {
            model.addAttribute("brinquedo", brinquedo);
            return "descricao";
        } else {
            return "redirect:/brinquedos";
        }
    }
    
    @GetMapping("/adicionar")
    public String adicionar(Model model) {
        model.addAttribute("brinquedo", new BrinquedoDTO());
        return "editar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        BrinquedoDTO brinquedo = brinquedoService.getById(id);
        if (brinquedo != null) {
            model.addAttribute("brinquedo", brinquedo);
            return "editar";
        } else {
            return "redirect:/brinquedos";
        }
    }

    @PostMapping("/adicionar")
    public String adicionarBrinquedo(@ModelAttribute BrinquedoDTO brinquedo) {
        brinquedoService.criarBrinquedo(brinquedo);
        return "redirect:/brinquedos";
    }

    @PostMapping("/editar/{id}")
    public String atualizarBrinquedo(@PathVariable Long id, @ModelAttribute BrinquedoDTO brinquedo) {
        brinquedoService.updateBrinquedo(id, brinquedo);
        return "redirect:/brinquedos";
    }

    @PostMapping("/excluir/{id}")
    public String excluirBrinquedo(@PathVariable Long id) {
        brinquedoService.deleteBrinquedo(id);
        return "redirect:/brinquedos";
    }
}
