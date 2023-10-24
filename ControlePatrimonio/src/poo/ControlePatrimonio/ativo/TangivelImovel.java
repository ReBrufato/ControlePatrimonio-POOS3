package poo.ControlePatrimonio.ativo;

public class TangivelImovel extends Ativo{
	private String localizacao;
	private double tamanho;
	private double valorMetro;
	private String tipo;
	
	public TangivelImovel( int codigo, String descricao, String localizacao, double tamanho, double valorMetro) {
		super(codigo, descricao);
		this.localizacao = localizacao;
		this.tamanho = tamanho;
		this.valorMetro = valorMetro;
		tipo = "Tangível Imóvel";
	}
	
	public String getLocalizacao() {
		return localizacao;
	}

	public double getTamanho() {
		return tamanho;
	}

	public double getValorMetro() {
		return valorMetro;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public double valorTotal() {
		return tamanho*valorMetro;
	}
	
	@Override
	public String toString() {
		return  "Tipo de Ativo: " + tipo + "\nLocalização: " + localizacao + super.toString() + "\n";
	}
	
	
}
