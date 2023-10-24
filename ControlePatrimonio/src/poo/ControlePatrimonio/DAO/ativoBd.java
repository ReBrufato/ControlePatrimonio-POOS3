package poo.ControlePatrimonio.DAO;

import java.util.List;

import poo.ControlePatrimonio.ativo.Ativo;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;

//essa interface será utilizada para criar a HashTable dos comandos remover, alterar e listar

public interface ativoBd<T extends Ativo>{
	
	//public abstract void cadastrar(T intangivel);
	
	//public void alterar(T intangivel);

	
	public void removerAtivo(int codigoAtivo);
	
	//public List<T> getAtivos();

}
