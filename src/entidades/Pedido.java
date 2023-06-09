package entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private LocalDateTime dataPedido;
	private StatusPedido status;
	
	// Relação de associação
	List<ItemPedido> ItensList = new ArrayList<>();
	private Cliente cliente;

	public Pedido(LocalDateTime dataPedido, StatusPedido status, Cliente cliente) {
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("\nMomento da pedido: " );
			sb.append(dataPedido.format(fmt)+ "\n");
			sb.append("Status do pedido: " );
			sb.append(status + "\n");
			sb.append("Cliente: ");
			sb.append(cliente + "\n");
			sb.append("Items pedidos: \n" );
				for (ItemPedido item : ItensList) {
					sb.append(item + "\n");
				}
			sb.append("Total a pagar: ");
			sb.append("R$" + String.format("%.2f", total()));
		return sb.toString();
	}
	
	
	
	
	
}


