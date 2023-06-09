package entidades;

import services.ImpostoServico;

public class Produto implements ImpostoServico{
	private String name;
	private Double preco;
	
	public Produto() {}

	public Produto(String name, Double preco) {
		this.name = name;
		this.preco = preco;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public double imposto(String tipo) {
		switch(tipo) {
		case "lanche":
			return preco + (preco * 0.05);
		case "bebida":
			return preco + (preco * 0.07);
		case "sobremesa":
			return preco + (preco * 0.06);
		default:
			return preco;
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
