package br.com.rafaelsilveiradev.tabelafipe.principal;

import br.com.rafaelsilveiradev.tabelafipe.model.DadosVeiculos;
import br.com.rafaelsilveiradev.tabelafipe.model.Modelos;
import br.com.rafaelsilveiradev.tabelafipe.services.ConsumoAPI;
import br.com.rafaelsilveiradev.tabelafipe.services.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        System.out.println("**** Opções ****");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");
        System.out.println("Digite o tipo de veiculo que deseja pesquisar: ");
        var tipoVeiculo = leitura.nextLine();
        String buscaTipoVeiculos;

        if (tipoVeiculo.toLowerCase().contains("carr")) {
            buscaTipoVeiculos = ENDERECO + "carros/marcas";
        } else if (tipoVeiculo.toLowerCase().contains("mot")){
            buscaTipoVeiculos = ENDERECO + "motos/marcas";
        } else {
            buscaTipoVeiculos = ENDERECO + "caminhoes/marcas";
        }

        var json = consumo.obterDados(buscaTipoVeiculos);
        var marcas = conversor.obterLista(json, DadosVeiculos.class);
        marcas.stream()
                .sorted(Comparator.comparing(DadosVeiculos::codigo))
                .forEach(System.out::println);

        System.out.println("Digite o codigo da marca que deseja exibir os veiculos: ");
        var codigoMarca = leitura.nextLine();

        var buscaCodigoMarca = buscaTipoVeiculos + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(buscaCodigoMarca);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa Marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(DadosVeiculos::codigo))
                .forEach(System.out::println);





    }
}
