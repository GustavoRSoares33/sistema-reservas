package br.com.hotel.sistema_reservas.controller;

import br.com.hotel.sistema_reservas.model.Quarto;
import br.com.hotel.sistema_reservas.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute(
                "quartos", quartoService.listarTodos()
        );
        return "quartos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("quarto",new Quarto());

        return "quartos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("quarto") Quarto quarto,  BindingResult resultado) {
        if(resultado.hasErrors()){
            return "quartos/formulario";
        }
        quartoService.salvar(quarto);
        return "redirect:/quartos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Quarto quarto = quartoService.buscarPorId(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Quarto não encontrado: " + id));

        model.addAttribute("quarto",quarto);
        model.addAttribute("id", id);
        return "quartos/formulario";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(
            @PathVariable Long id,
            @Valid @ModelAttribute("quarto") Quarto quarto,
            BindingResult resultado,
            Model model){

        if(resultado.hasErrors()){
            model.addAttribute("id",id);
            return "quartos/formulario";
        }

        quartoService.atualizar(id, quarto);

        return  "redirect:/quartos";

    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        quartoService.deletar(id);

        return "redirect:/quartos";
    }

}
