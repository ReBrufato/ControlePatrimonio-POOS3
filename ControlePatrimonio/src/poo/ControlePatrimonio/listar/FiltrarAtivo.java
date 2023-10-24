package poo.ControlePatrimonio.listar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import poo.ControlePatrimonio.DAO.IntangivelDAO;
import poo.ControlePatrimonio.DAO.TangivelImovelDAO;
import poo.ControlePatrimonio.DAO.TangivelMovelDAO;
import poo.ControlePatrimonio.ativo.Ativo;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.comando.Comando;

public class FiltrarAtivo implements Comando{
	
	public void executar(Scanner entrada) {
		//scanner para pegar String no nextoLine()
		Scanner scan1 = new Scanner(System.in);
				
		//cria um objeto da classe Filtro
		Filtro<Intangivel> filtroIntangivel = new Filtro();
		Filtro<TangivelMovel> filtroTangivelMovel = new Filtro();
		Filtro<TangivelImovel> filtroTangivelImovel = new Filtro();
		
		//listas que recebem cada tipo de ativo do banco de dados
		List<Intangivel> intangiveis = new ArrayList<Intangivel>();
		List<TangivelImovel> tangiveisImoveis = new ArrayList<TangivelImovel>();
		List<TangivelMovel> tangiveisMoveis = new ArrayList<TangivelMovel>();
		
		//objetos para comunicação o banco de dados entre os três tipos de ativos
		IntangivelDAO intangivelBanco = new IntangivelDAO();
		TangivelImovelDAO tangivelimovelBanco = new TangivelImovelDAO();
		TangivelMovelDAO tangivelmovelBanco = new TangivelMovelDAO();
		
		//recebe as entradas do usuário
		System.out.println("Digite o tipo de ativo que deseja");
		String tipo = scan1.nextLine();
		System.out.println("Digite a descrição do ativo");
		String descricao = scan1.nextLine();
		
		if(tipo.equals("Intangível")) {
			//recebe os intangiveis do banco
			intangiveis = intangivelBanco.getAtivos();
			intangiveis = filtroIntangivel.ativoTipo(intangiveis, tipo);
			intangiveis = filtroIntangivel.ativoDescricao(intangiveis, descricao);
			
			for(Intangivel intangivel : intangiveis) {
				System.out.println(intangivel);
			}
			
			//verifica se foi retornado algum ativo do tipo e descrição informados
			if(intangiveis.size() == 0) {
				System.out.println("\nNão há ativos com essa descrição\n");
			}
			
		}else if (tipo.equals("Tangível Imóvel")) {
			//recebe os tangíveis imóveis do banco
			tangiveisImoveis = tangivelimovelBanco.getAtivos();
			tangiveisImoveis = filtroTangivelImovel.ativoTipo(tangiveisImoveis, tipo);
			tangiveisImoveis = filtroTangivelImovel.ativoDescricao(tangiveisImoveis, descricao);
			
			for(TangivelImovel tangivelImovel : tangiveisImoveis) {
				System.out.println(tangivelImovel);
			}
			
			//verifica se foi retornado algum ativo do tipo e descrição informados
			if(tangiveisImoveis.size() == 0) {
				System.out.println("\nNão há ativos com essa descrição\n");
			}
			
		}else if (tipo.equals("Tangível Móvel")) {
			//recebe os tangíveis móveis do banco
			tangiveisMoveis = tangivelmovelBanco.getAtivos();
			tangiveisMoveis = filtroTangivelMovel.ativoTipo(tangiveisMoveis, tipo);
			tangiveisMoveis = filtroTangivelMovel.ativoDescricao(tangiveisMoveis, descricao);
			
			for(TangivelMovel tangivelMovel : tangiveisMoveis) {
				System.out.println(tangivelMovel);
			}
			
			//verifica se foi retornado algum ativo do tipo e descrição informados
			if(tangiveisMoveis.size() == 0) {
				System.out.println("\nNão há ativos com essa descrição\n");
			}
			
		}else {
			System.out.println("\nTipo de ativo inexistente!\n");
		}
		
	}
}
