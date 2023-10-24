package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.TangivelImovelDAO;
import poo.ControlePatrimonio.ativo.TangivelImovel;

public class AlterarTangivelImovel implements Comando{
	
	public void executar(Scanner entrada) {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
				
		TangivelImovelDAO tangivelimovelDAO = new TangivelImovelDAO();
		
		System.out.println("Alteração de dados:");
		System.out.println("Digite o codigo do ativo tangível imóvel:");
		int codigo = entrada.nextInt();
		System.out.println("Digite a descrição:");
		String descricao = scan1.nextLine();
		System.out.println("Digite a localização:");
		String localizacao = scan1.nextLine();
		System.out.println("Digite tamanho em m²:");
		double tamanho = entrada.nextDouble();
		System.out.println("Digite o valor do m²:");
		double valorMetro = entrada.nextDouble();
		TangivelImovel tangivelImovel = new TangivelImovel(codigo, descricao, localizacao, tamanho, valorMetro);
		
		tangivelimovelDAO.alterar(tangivelImovel);
		
		System.out.println("\nAlteração feita com sucesso!\n");
	}	
}
