package poo.ControlePatrimonio.comando;

import java.io.IOException;
import java.util.Scanner;

import poo.ControlePatrimonio.DAO.TangivelImovelDAO;
import poo.ControlePatrimonio.DAO.TangivelMovelDAO;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.repositorio.RepositorioTangivelImovel;

public class CadastrarTangivelImovel implements Comando{
		
	//int codigo, String descricao, String localizacao, double tamanho, double valorMetro
	
	public void executar(Scanner entrada) throws IOException {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
				
		//repositorio para armazenar em arquivo - TESTE
		RepositorioTangivelImovel repositorioTangivelMovel = new RepositorioTangivelImovel();
		
		//objeto para armazenar um ativo tangível imóvel no bd
		TangivelImovelDAO tangivelimovelDAO = new TangivelImovelDAO();
		
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
		
		tangivelimovelDAO.cadastrar(tangivelImovel);
		
		repositorioTangivelMovel.cadastrar(tangivelImovel);
		
		System.out.println("\nCadastro feito com sucesso!\n");
	}
}
