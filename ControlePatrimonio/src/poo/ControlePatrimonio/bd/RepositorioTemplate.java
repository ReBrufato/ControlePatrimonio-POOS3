package poo.ControlePatrimonio.bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import poo.ControlePatrimonio.ativo.Ativo;

public abstract class RepositorioTemplate <T extends Ativo>{
	//////////////ESSA CLASSE SERVE PARA ARMAZENAS OS DADOS EM ARQUIVOS, MAS NÃO PRECISO DISSO, VOU SALVAR DIRETO NO BD//////////////
	
	public final void cadastrar(T t) throws IOException {
		FileWriter file = new FileWriter(getFilename(), true);
		BufferedWriter buffer = new BufferedWriter(file);
		buffer.append(getText(t));
		buffer.close();
		file.close();
	}
	
	public final List<T> getAtivos() throws IOException {
		FileReader file = new FileReader(getFilename());
		BufferedReader buffer = new BufferedReader(file);
		List<T> ativos = new ArrayList<T>();
		String linha = buffer.readLine();
		while(linha != null) {
			String dadosAtivo[] = linha.split(";");
			T t = getAtivo(dadosAtivo);
			ativos.add(t);
			linha = buffer.readLine();
		}
		buffer.close();
		file.close();
		return ativos;
	}
	
	
	
	protected abstract String getText(T t);

	protected abstract String getFilename();

	protected abstract T getAtivo(String[] dadosAtivo);
}
