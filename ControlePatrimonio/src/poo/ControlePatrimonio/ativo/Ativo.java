package poo.ControlePatrimonio.ativo;

import java.io.Serializable;

public abstract class Ativo implements Serializable{
	private int codigo;
	private String descricao;
	private double valor;
	
	public Ativo(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}

	public abstract double valorTotal();
	
	public abstract String getTipo();
	
	@Override
	public String toString() {
		return "\nDescrição: " + descricao + "\nCódigo: " + codigo + "\nValor: " + valorTotal();
	}

}
