package br.com.rafaelsilveiradev.tabelafipe.principal;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    public void exibeMenu(){
        System.out.println("**** Opções ****");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");
        System.out.println("Digite o tipo de veiculo que deseja pesquisar: ");

    }
}
