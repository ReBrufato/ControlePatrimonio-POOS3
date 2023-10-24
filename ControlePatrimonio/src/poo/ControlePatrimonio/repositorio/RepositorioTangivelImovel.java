package poo.ControlePatrimonio.repositorio;

import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.bd.RepositorioTemplate;

public class RepositorioTangivelImovel extends RepositorioTemplate<TangivelImovel>{
	
	//int codigo, String descricao, String localizacao, double tamanho, double valorMetro
	
	@Override
	protected String getText(TangivelImovel t) {
		return t.getCodigo() + ";" + t.getDescricao() + ";" + t.getLocalizacao() + ";" + t.getTamanho() + ";" + t.getValorMetro() + "\r\n";
	}

	@Override
	protected String getFilename() {
		return "TangiveisImoveis.txt";
	}

	@Override
	protected TangivelImovel getAtivo(String[] dadosAtivo) {
		return new TangivelImovel(Integer.parseInt(dadosAtivo[0]), dadosAtivo[1],dadosAtivo[2], Double.parseDouble(dadosAtivo[3]), Double.parseDouble(dadosAtivo[4]));
	}
}
