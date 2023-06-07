package entidades;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

import entidades.enums.StatusPedido;

public class Pedido {
	
	private LocalDate dataPedido;
	private StatusPedido status;
	
	// Relação de associação
	Queue<ItemPedido> ItensList  = new LinkedList<>();

	public Pedido(LocalDate dataPedido, StatusPedido status) {
		this.dataPedido = dataPedido;
		this.status = status;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Queue<ItemPedido> getItemsPedidos() {
		return ItensList;
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
	
}


