package poo.ControlePatrimonio.repositorio;

import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.bd.RepositorioTemplate;

public class RepositorioIntangivel extends RepositorioTemplate<Intangivel>{
	
	//int codigo, String descricao, int tempoRestante, double valorAno
	
	@Override
	protected String getText(Intangivel t) {
		return t.getCodigo() + ";" + t.getDescricao() + ";" + t.getTempoRestante() +  ";" + t.getValorAno() + "\r\n";
	}

	@Override
	protected String getFilename() {
		return "Intangiveis.txt";
	}

	@Override
	protected Intangivel getAtivo(String[] dadosAtivo) {
		return new Intangivel(Integer.parseInt(dadosAtivo[0]), dadosAtivo[1],Integer.parseInt(dadosAtivo[2]), Double.parseDouble(dadosAtivo[2]));
	}
}
