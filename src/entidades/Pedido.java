package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private LocalDateTime dataPedido;
	private StatusPedido status;
	private Integer id;
	private String empresa;
	
	// Relação de associação
	List<ItemPedido> ItensList = new ArrayList<>();
	private Cliente cliente;

	public Pedido(Integer id, LocalDateTime dataPedido, StatusPedido status, Cliente cliente, String empresa) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
		this.empresa = empresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemPedido> getItensList() {
		return ItensList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void adicionarItem(ItemPedido item) {
		ItensList.add(item);
	}
	
	public void removerItem(ItemPedido item) {
		ItensList.remove(item);
	}

	public Double total() {
		double sum = 0.0;
		for(ItemPedido item : ItensList) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		    sb.append("\n\tId do pedido: ");
		    sb.append(this.getId() + "\n");
			sb.append("\tMomento do pedido: " );
			sb.append(dataPedido.format(fmt)+ "\n");
			sb.append("\tStatus do pedido: " );
			sb.append(this.getStatus() + "\n");
			sb.append("\tEmpresa: " );
			sb.append(this.getEmpresa() + "\n");
			sb.append("\tPedido: \n");
				for (ItemPedido item : ItensList) {
					sb.append(item + "\n");
				}
			sb.append("\n\tTotal a pagar: ");
			sb.append("R$" + String.format("%.2f", total()));
		return sb.toString();
	}
	
	public String mostraPedidos() {
		StringBuilder sb = new StringBuilder();
		    sb.append("\n\tId do pedido: ");
		    sb.append(this.getId() + "\n");
			sb.append("\tMomento do pedido: " );
			sb.append(dataPedido.format(fmt)+ "\n");
			sb.append("\tStatus do pedido: " );
			sb.append(this.getStatus() + "\n");
			sb.append("\n\tEmpresa: " );
			sb.append(this.getEmpresa() + "\n");
			sb.append("\n\tCliente: ");
			sb.append(this.getCliente().getNome() + "\n");
			sb.append("\n\tPedido: \n" );
				for (ItemPedido item : ItensList) {
					sb.append(item + "\n");
				}
			sb.append("\n\tTotal pago: ");
			sb.append("R$" + String.format("%.2f", total()));
			sb.append("\n\n\t***************************************");
		return sb.toString();
	}
	
	
	
	
	
}


