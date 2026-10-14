package br.com.hotel.sistema_reservas.repository;

import br.com.hotel.sistema_reservas.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
