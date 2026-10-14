package br.com.hotel.sistema_reservas.service;

import br.com.hotel.sistema_reservas.model.Quarto;
import br.com.hotel.sistema_reservas.repository.QuartoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Quarto> buscarPorId(Long id) {
        return quartoRepository.findById(id);
    }

    public Quarto atualizar(Long id, Quarto dadosFormulario) {
        Quarto quartoExistente = quartoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Quarto não encontrado: " + id));

        quartoExistente.setNumero(dadosFormulario.getNumero());
        quartoExistente.setTipo(dadosFormulario.getTipo());
        quartoExistente.setCapacidade(dadosFormulario.getCapacidade());
        quartoExistente.setDiaria(dadosFormulario.getDiaria());

        return quartoRepository.save(quartoExistente);
    }

    public void deletar(Long id) {
        if(!quartoRepository.existsById(id)){
            throw new IllegalArgumentException(
                    "Quarto não encontrado: " + id);
        }

        quartoRepository.deleteById(id);
    }

}
