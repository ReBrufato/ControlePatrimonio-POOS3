package poo.ControlePatrimonio.listar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import poo.ControlePatrimonio.ativo.Ativo;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;

public class Filtro<T extends Ativo>{
	private List<T> ativos;
	
	
	public Filtro() {
		ativos = new ArrayList<T>();
	}
	
	//recebe uma lista de ativo (qualquer um deles) e filtra de acordo com o tipo  passado, e vai retornar um lista com os elementos
	//resultantes do filtro
	public List<T> ativoTipo(List<T> ativosRecebidos, String tipo){
		return ativosRecebidos.parallelStream().filter(f->f.getTipo().contains(tipo)).collect(Collectors.toList());
	}
	
	//recebe uma lista de ativo (qualquer um deles) e filtra de acordo com a descrição passada, e vai retornar um lista com os elementos
	//resultantes do filtro
	public List<T> ativoDescricao(List<T> ativosRecebidos, String descricao){
		return ativosRecebidos.parallelStream().filter(f->f.getDescricao().contains(descricao)).collect(Collectors.toList());
	}
	
}
