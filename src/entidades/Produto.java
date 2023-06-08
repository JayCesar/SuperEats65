package entidades;

import services.ImpostoServico;

public class Produto implements ImpostoServico{
	private Integer id;
	private String name;
	private String breveDescricao;
	private Double preco;
	
	public Produto() {}

	public Produto(Integer id, String name, String breveDescricao, Double preco) {
		this.id = id;
		this.name = name;
		this.breveDescricao = breveDescricao;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreveDescricao() {
		return breveDescricao;
	}

	public void setBreveDescricao(String breveDescricao) {
		this.breveDescricao = breveDescricao;
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
		}
		return preco;
	}
	
}
