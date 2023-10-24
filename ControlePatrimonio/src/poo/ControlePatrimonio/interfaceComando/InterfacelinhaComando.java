package poo.ControlePatrimonio.interfaceComando;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import poo.ControlePatrimonio.comando.AlterarIntangivel;
import poo.ControlePatrimonio.comando.AlterarTangivelImovel;
import poo.ControlePatrimonio.comando.AlterarTangivelMovel;
import poo.ControlePatrimonio.comando.CadastrarIntangivel;
import poo.ControlePatrimonio.comando.CadastrarTangivelImovel;
import poo.ControlePatrimonio.comando.CadastrarTangivelMovel;
import poo.ControlePatrimonio.comando.Comando;
import poo.ControlePatrimonio.comando.RemoverIntangivel;
import poo.ControlePatrimonio.comando.RemoverTangivelImovel;
import poo.ControlePatrimonio.comando.RemoverTangivelMovel;
import poo.ControlePatrimonio.comando.Sair;
import poo.ControlePatrimonio.listar.FiltrarAtivo;
import poo.ControlePatrimonio.listar.ListarAtivos;

public class InterfacelinhaComando {
	
	public static void menu() {
		System.out.println("Sistema de Controle de Patrimônio");
		System.out.println("1 - Cadastrar Ativo Tangível Móvel");
		System.out.println("2 - Cadastrar Ativo Tangível Imóvel");
		System.out.println("3 - Cadastrar Ativo Intangível");
		System.out.println("4 - Remover Ativo Tangível Móvel");
		System.out.println("5 - Remover Ativo Tangível Imóvel");
		System.out.println("6 - Remover Ativo Intangível");
		System.out.println("7 - Alterar Ativo Tangível Móvel");
		System.out.println("8 - Alterar Ativo Tangível Imóvel");
		System.out.println("9 - Alterar Ativo Intangível");
		System.out.println("10 - Listar Ativos");
		System.out.println("11 - Filtrar Ativo");
		System.out.println("0 - Sair");
		System.out.println("Escolha uma opção:");
	}
	
	public static void main(String[] args) {

		int opcao = 0;
		Scanner entrada = new Scanner(System.in);
		Hashtable<Integer, Comando> comandos = new Hashtable<Integer, Comando>();
		comandos.put(0, new Sair());
		comandos.put(1, new CadastrarTangivelMovel());
		comandos.put(2, new CadastrarTangivelImovel());
		comandos.put(3, new CadastrarIntangivel());
		comandos.put(4, new RemoverTangivelMovel());
		comandos.put(5, new RemoverTangivelImovel());
		comandos.put(6, new RemoverIntangivel());
		comandos.put(7, new AlterarTangivelMovel());
		comandos.put(8, new AlterarTangivelImovel());
		comandos.put(9, new AlterarIntangivel());
		comandos.put(10, new ListarAtivos());
		comandos.put(11, new FiltrarAtivo());
		//ARRUMAR A PAARTE DE ALTERAR UM TANGÍVEL IMOVEL
		
		do {
			menu();
			opcao = entrada.nextInt();
			try {
				comandos.get(opcao).executar(entrada);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (NullPointerException e) {
				System.out.println("Opcão inválida!");
			}
		} while (opcao != 0);
		
		entrada.close();
	}

}

