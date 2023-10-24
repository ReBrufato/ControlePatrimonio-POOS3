package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.TangivelMovelDAO;
import poo.ControlePatrimonio.ativo.TangivelMovel;

public class AlterarTangivelMovel implements Comando{
	
	public void executar(Scanner entrada) {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
				
		TangivelMovelDAO tangivelMovelDAO = new TangivelMovelDAO();
		
		System.out.println("Altera��o de dados:");
		System.out.println("Digite o codigo do ativo tang�vel m�vel:");
		int codigo = entrada.nextInt();
		System.out.println("Digite a descri��o:");
		String descricao = scan1.nextLine();
		System.out.println("Digite a quantidade de ativos:");
		int quantidade = entrada.nextInt();
		System.out.println("Digite o valor de cada unidade:");
		double valorUnidade = entrada.nextDouble();
		TangivelMovel tangivelMovel = new TangivelMovel(codigo, descricao, quantidade, valorUnidade);
		
		tangivelMovelDAO.alterar(tangivelMovel);
		
		System.out.println("\nAltera��o feita com sucesso!\n");
	}	
}
