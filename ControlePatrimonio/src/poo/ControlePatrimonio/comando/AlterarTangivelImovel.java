package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.TangivelImovelDAO;
import poo.ControlePatrimonio.ativo.TangivelImovel;

public class AlterarTangivelImovel implements Comando{
	
	public void executar(Scanner entrada) {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
				
		TangivelImovelDAO tangivelimovelDAO = new TangivelImovelDAO();
		
		System.out.println("Altera��o de dados:");
		System.out.println("Digite o codigo do ativo tang�vel im�vel:");
		int codigo = entrada.nextInt();
		System.out.println("Digite a descri��o:");
		String descricao = scan1.nextLine();
		System.out.println("Digite a localiza��o:");
		String localizacao = scan1.nextLine();
		System.out.println("Digite tamanho em m�:");
		double tamanho = entrada.nextDouble();
		System.out.println("Digite o valor do m�:");
		double valorMetro = entrada.nextDouble();
		TangivelImovel tangivelImovel = new TangivelImovel(codigo, descricao, localizacao, tamanho, valorMetro);
		
		tangivelimovelDAO.alterar(tangivelImovel);
		
		System.out.println("\nAltera��o feita com sucesso!\n");
	}	
}
