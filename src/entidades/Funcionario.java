package entidades;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class Funcionario extends Pessoa {
	private double Salario;
	private String Cargo;
	private LocalDate dataDeContratação;
	
	// Acesso a uma fila de pedidos
	Queue<Pedido> filaPedidos = new LinkedList<>();
	
	public Funcionario(Integer id, String nome, String email, LocalDate dataDeNascimento, String senha, double salario,
			String cargo, LocalDate dataDeContratação) {
		super(id, nome, email, dataDeNascimento, senha);
		Salario = salario;
		Cargo = cargo;
		this.dataDeContratação = dataDeContratação;
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

	public void prepararPedido(Pedido pedido) {
		filaPedidos.add(pedido);
	}
	
	public void finalizarPedido(Queue<Pedido> filaPedidos) {
		filaPedidos.clear();
	}
}


