package entidades;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	private Pedido pedidoAtual;
	private double Salario;
	private String Cargo;
	private LocalDate dataDeContratação;
	public Funcionario(double salario, String cargo, LocalDate dataDeContratação) {
		super();
		Salario = salario;
		Cargo = cargo;
		this.dataDeContratação = dataDeContratação;
	}
	public void setPedidoAtual(Pedido pedidoAtual) {
        this.pedidoAtual = pedidoAtual;
    }

    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public LocalDate getDataDeContratação() {
		return dataDeContratação;
	}
	public void setDataDeContratação(LocalDate dataDeContratação) {
		this.dataDeContratação = dataDeContratação;
	}
	public void consultarpedido() {
		if (pedidoAtual != null) {
	        System.out.println("Consultando pedido...");
	    } else {
	        System.out.println("Nenhum pedido em andamento.");}
	}public void prepararPedido() {
		if (pedidoAtual != null) {
	        System.out.println("Preparando pedido...");
	    } else {
	        System.out.println("Nenhum pedido em andamento.");
	    }
	}public void finalizarPedido() {
		 if (pedidoAtual != null) {
		        System.out.println("Finalizando pedido...");
		    } else {
		        System.out.println("Nenhum pedido em andamento.");
		    }
	}
}
	
