package poo.ControlePatrimonio.ativo;

public class Intangivel extends Ativo{
	private int tempoRestante;
	private double valorAno;
	private String tipo;
	
	public Intangivel( int codigo, String descricao, int tempoRestante, double valorAno) {
		super(codigo, descricao);
		this.tempoRestante = tempoRestante;
		this.valorAno = valorAno;
		tipo = "Ativo Intangível";
	}
	
	public int getTempoRestante() {
		return tempoRestante;
	}

	public double getValorAno() {
		return valorAno;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public double valorTotal() {
		return tempoRestante*valorAno;
	}

	@Override
	public String toString() {
		return  "Tipo de Ativo: " + tipo + super.toString() + "\n";
	}
	
	
	
	
}
