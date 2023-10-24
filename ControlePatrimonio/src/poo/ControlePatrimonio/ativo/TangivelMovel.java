package poo.ControlePatrimonio.ativo;

public class TangivelMovel extends Ativo{
	private int quantidade;
	private double valorUnidade;
	private String tipo;
	
	public TangivelMovel( int codigo, String descricao,int quantidade, double valorUnidade) {
		super(codigo, descricao);
		this.quantidade = quantidade;
		this.valorUnidade = valorUnidade;
		tipo = "Tangível Móvel";
	}


	public int getQuantidade() {
		return quantidade;
	}

	public double getValorUnidade() {
		return valorUnidade;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public double valorTotal() {
		return quantidade*valorUnidade;
	}
	
	@Override
	public String toString() {
		return "Tipo de Ativo: " + tipo + super.toString() + "\n";
	}

}
