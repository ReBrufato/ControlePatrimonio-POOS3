package poo.ControlePatrimonio.comando;

import java.io.IOException;
import java.util.Scanner;

import poo.ControlePatrimonio.DAO.IntangivelDAO;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.repositorio.RepositorioIntangivel;
import poo.ControlePatrimonio.repositorio.RepositorioTangivelImovel;

public class CadastrarIntangivel implements Comando{
	//scanner para pegar String no nextoLine()
	Scanner scan1 = new Scanner(System.in);
			
	
	//int codigo, String descricao, int tempoRestante, double valorAno
	
	public void executar(Scanner entrada) throws IOException {
		//repositorio para armazenar em arquivo - TESTE
		RepositorioIntangivel repositorioIntangivel = new RepositorioIntangivel();
		
		//objeto para armazenar um ativo intang�vel no bd
		IntangivelDAO intangivelDAO = new IntangivelDAO();
		
		System.out.println("Digite o codigo do ativo tang�vel im�vel:");
		int codigo = entrada.nextInt();
		System.out.println("Digite a descri��o:");
		String descricao = scan1.nextLine();
		System.out.println("Digite o tempo restante de explora��o:");
		int tempoRestante = entrada.nextInt();
		System.out.println("Digite o valor gerado por ano:");
		double valorAno = entrada.nextDouble();
		Intangivel intangivel = new Intangivel(codigo, descricao, tempoRestante, valorAno);
		
		intangivelDAO.cadastrar(intangivel);
		
		repositorioIntangivel.cadastrar(intangivel);
		
		System.out.println("\nCadastro feito com sucesso!\n");
	}
	
}
