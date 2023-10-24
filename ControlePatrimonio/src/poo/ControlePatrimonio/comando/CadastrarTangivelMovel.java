package poo.ControlePatrimonio.comando;

import java.io.IOException;
import java.util.Scanner;

import poo.ControlePatrimonio.DAO.TangivelMovelDAO;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.repositorio.RepositorioTangivelMovel;

public class CadastrarTangivelMovel implements Comando{
	
	//int codigo, String descricao,int quantidade, double valorUnidade
	
	public void executar(Scanner entrada) throws IOException {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
		
		//repositorio para armazenar em arquivo - TESTE
		RepositorioTangivelMovel repositorioTangivelMovel = new RepositorioTangivelMovel();
		
		//objeto para armazenar um ativo tangível móvel no bd
		TangivelMovelDAO tangivelMovelDAO = new TangivelMovelDAO();
		
		System.out.println("Digite o codigo do ativo tangível móvel:");
		int codigo = entrada.nextInt();
		System.out.print("Digite a descrição:");
		String descricao = scan1.nextLine();
		System.out.print("Digite a quantidade de ativos:");
		int quantidade = entrada.nextInt();
		System.out.println("Digite o valor de cada unidade:");
		double valorUnidade = entrada.nextDouble();
		TangivelMovel tangivelMovel = new TangivelMovel(codigo, descricao, quantidade, valorUnidade);
		
		tangivelMovelDAO.cadastrar(tangivelMovel);
		
		repositorioTangivelMovel.cadastrar(tangivelMovel);
		
		System.out.println("\nCadastro feito com sucesso!\n");
	}
}
