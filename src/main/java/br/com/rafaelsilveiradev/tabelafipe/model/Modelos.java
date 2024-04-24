package br.com.rafaelsilveiradev.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<DadosVeiculos> modelos) {
}
