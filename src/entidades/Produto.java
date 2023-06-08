package entidades;

import services.ImpostoServico;

public class Produto implements ImpostoServico{
	private Integer id;
	private String name;
	private String breveDescricao;
	private Double preco;
	private String tipo;
	
	public Produto() {}

	public Produto(Integer id, String name, String breveDescricao, Double preco, String tipo) {
		this.id = id;
		this.name = name;
		this.breveDescricao = breveDescricao;
		this.preco += this.imposto(tipo);
		this.tipo = tipo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public double imposto(String tipo) {
		switch(tipo) {
		case "lanche":
			return preco * 0.05;
		case "bebida":
			return preco * 0.07;
		case "sobremesa":
			return preco * 0.06;
		default:
			return 0.0;
		}
	}
	
}
