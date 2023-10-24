package poo.ControlePatrimonio.repositorio;

import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.bd.RepositorioTemplate;


public class RepositorioTangivelMovel extends RepositorioTemplate<TangivelMovel>{
	
	//int codigo, String descricao,int quantidade, double valorUnidade
	
	@Override
	protected String getText(TangivelMovel t) {
		return t.getCodigo() + ";" + t.getDescricao() + ";" + t.getQuantidade() + ";" + t.getValorUnidade() + "\r\n";
	}

	@Override
	protected String getFilename() {
		return "TangiveisMoveis.txt";
	}

	@Override
	protected TangivelMovel getAtivo(String[] dadosAtivo) {
		return new TangivelMovel(Integer.parseInt(dadosAtivo[0]), dadosAtivo[1],Integer.parseInt(dadosAtivo[2]), Double.parseDouble(dadosAtivo[2]));
	}
}
