package Teste;

import java.util.ArrayList;
import java.util.List;

import poo.ControlePatrimonio.ativo.Ativo;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;

public class Teste {

	public static void main(String[] args) {
		List<Ativo> ativos = new ArrayList<Ativo>();
		
		TangivelMovel TangivelMovel1 = new TangivelMovel( 1, "Lambreta",  4, 2100);
		TangivelMovel TangivelMovel2 = new TangivelMovel( 2, "Van", 3, 57000);
		TangivelMovel TangivelMovel3 = new TangivelMovel( 3, "Notbook", 10, 3000);
		TangivelMovel TangivelMovel4 = new TangivelMovel( 4, "Tablet", 7, 1500);
		ativos.add(TangivelMovel1);
		ativos.add(TangivelMovel2);
		ativos.add(TangivelMovel3);
		ativos.add(TangivelMovel4);
		
		TangivelImovel TangivelImovel1 = new TangivelImovel( 1, "Apartamento", "Vila Prado", 50, 2000);
		TangivelImovel TangivelImovel2 = new TangivelImovel( 2, "Casa", "Vila Faria", 30, 1500);
		ativos.add(TangivelImovel1);
		ativos.add(TangivelImovel2);
		//int codigo, String descricao, int tempoRestante, double valorAno
		Intangivel Intangivel1 = new Intangivel(1, "Ações", 4, 15000);
		Intangivel Intangivel2 = new Intangivel(2, "Software", 4, 50000);
		Intangivel Intangivel3 = new Intangivel(3, "Patente", 10, 17000);
		ativos.add(Intangivel1);
		ativos.add(Intangivel2);
		ativos.add(Intangivel3);
		
		for(Ativo ativo: ativos) {
			System.out.println(ativo);
		}
	}
}	


