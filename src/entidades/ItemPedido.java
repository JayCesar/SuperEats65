package entidades;

public class ItemPedido {

	private Integer quantidade;
	private Double preco;
	private String tipo;
	
	// Relação de associação
	private Produto produto;
	
	public ItemPedido(Integer quantidade, Produto produto, String tipo) {
		this.quantidade = quantidade;
		this.preco = produto.imposto(tipo);
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double subTotal() {
		return quantidade * preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
