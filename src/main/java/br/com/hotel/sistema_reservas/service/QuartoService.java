package br.com.hotel.sistema_reservas.service;

import br.com.hotel.sistema_reservas.model.Quarto;
import br.com.hotel.sistema_reservas.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public List<Quarto> listarTodos() {
        return quartoRepository.findAll();
    }

    public Quarto salvar(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

}
