package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.IntangivelDAO;
import poo.ControlePatrimonio.ativo.Intangivel;

public class AlterarIntangivel implements Comando {
	
	public void executar(Scanner entrada) {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
				
		IntangivelDAO intangivelDAO = new IntangivelDAO();
		
		System.out.println("Altera��o de dados:");
		System.out.println("Digite o codigo do ativo Intang�vel que deseja Alterar:");
		int codigo = entrada.nextInt();
		System.out.println("Digite a descri��o:");
		String descricao = scan1.nextLine();
		System.out.println("Digite o tempo restante de explora��o:");
		int tempoRestante = entrada.nextInt();
		System.out.println("Digite o valor gerado por ano:");
		double valorAno = entrada.nextDouble();
		Intangivel intangivel = new Intangivel(codigo, descricao, tempoRestante, valorAno);
		
		intangivelDAO.alterar(intangivel);
		
		System.out.println("\nAltera��o feita com sucesso!\n");
	}
}
