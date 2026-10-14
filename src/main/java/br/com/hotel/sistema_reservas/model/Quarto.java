package br.com.hotel.sistema_reservas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "quartos")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Informe o número do quarto")
    private String numero;

    @NotBlank(message = "Informe o tipo do quarto")
    private String tipo;

    @NotNull(message = "Informe a capacidade")
    @Min(value = 1, message = "A capacidade mínima é 1")
    private Integer capacidade;

    @NotNull(message = "Informe o valor da diária")
    @DecimalMin(value = "0.01", message = "A diária deve ser maior que zero")
    private BigDecimal diaria;

    public Quarto() {}

    public long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public BigDecimal getDiaria() {
        return diaria;
    }

    public void setDiaria(BigDecimal diaria) {
        this.diaria = diaria;
    }
}
