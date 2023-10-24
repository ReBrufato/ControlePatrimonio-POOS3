package poo.ControlePatrimonio.listar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import poo.ControlePatrimonio.DAO.IntangivelDAO;
import poo.ControlePatrimonio.DAO.TangivelImovelDAO;
import poo.ControlePatrimonio.DAO.TangivelMovelDAO;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.comando.Comando;

public class ListarAtivos implements Comando{
	private double patrimonioTotal = 0;
	
	public void executar(Scanner entrada) {
		//consumidores para imprimir dados
		Consumer<Intangivel> consumidorintangivel = a->System.out.println(a);
		Consumer<TangivelImovel> consumidorTangivelimovel = a->System.out.println(a);
		Consumer<TangivelMovel> consumidorTangivelmovel = a->System.out.println(a);
		
		//listas para receberem o retorno
		List<Intangivel> intangiveis = new ArrayList<Intangivel>();
		List<TangivelImovel> tangiveisImoveis = new ArrayList<TangivelImovel>();
		List<TangivelMovel> tangiveisMoveis = new ArrayList<TangivelMovel>();
		
		//cria objeto intang�vel do banco
		IntangivelDAO intangivelDAO = new IntangivelDAO();
		
		//cria objeto tang�vel im�vel do banco
		TangivelImovelDAO tangivelimovelDAO = new TangivelImovelDAO();
		
		//cria objeto tang�vel m�vel do banco
		TangivelMovelDAO tangivelMovelDAO = new TangivelMovelDAO();
		
		intangiveis = intangivelDAO.getAtivos();
		tangiveisImoveis = tangivelimovelDAO.getAtivos();
		tangiveisMoveis = tangivelMovelDAO.getAtivos();
		
		
		//faz a listagem dos ativos
		System.out.println("\nLISTA DE ATIVOS\n");
		intangiveis.forEach(consumidorintangivel);
		tangiveisImoveis.forEach(consumidorTangivelimovel);
		tangiveisMoveis.forEach(consumidorTangivelmovel);
		
		//calcula o patrim�nio total
		//total de intangiveis
		for(Intangivel intangivel : intangiveis) {
			patrimonioTotal = patrimonioTotal + intangivel.valorTotal();
		}
		//total de tangiveis moveis
		for(TangivelMovel tangivelmovel : tangiveisMoveis) {
			patrimonioTotal = patrimonioTotal + tangivelmovel.valorTotal();
		}
		//total de tangiveis im�veis
		for(TangivelImovel tangivelimovel : tangiveisImoveis) {
			patrimonioTotal = patrimonioTotal + tangivelimovel.valorTotal();
		}
		
		System.out.println("\nPATRIM�NIO TOTAL DA EMPRESA: " + patrimonioTotal + "\n");
	}
}
