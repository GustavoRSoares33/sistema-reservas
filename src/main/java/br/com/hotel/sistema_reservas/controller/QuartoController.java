package br.com.hotel.sistema_reservas.controller;

import br.com.hotel.sistema_reservas.model.Quarto;
import br.com.hotel.sistema_reservas.service.QuartoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
