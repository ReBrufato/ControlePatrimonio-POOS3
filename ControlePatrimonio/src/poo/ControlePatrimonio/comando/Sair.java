package poo.ControlePatrimonio.comando;

import java.util.Scanner;

public class Sair implements Comando{
	
	@Override
	public void executar(Scanner entrada) {
		System.out.println("Sess�o encerrada!");
	}
}
