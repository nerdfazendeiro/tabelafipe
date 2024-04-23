package br.com.rafaelsilveiradev.tabelafipe.principal;

import br.com.rafaelsilveiradev.tabelafipe.services.ConsumoAPI;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        System.out.println("**** Opções ****");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");
        System.out.println("Digite o tipo de veiculo que deseja pesquisar: ");
        var tipoVeiculo = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + tipoVeiculo + "/marcas");
        System.out.println(json);

    }
}
