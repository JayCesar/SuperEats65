package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente extends Pessoa{
	private String cpf;
	private String telefone;
	private LocalDate dataCadastro;
	
	public Cliente(Integer id, String nome, String email, LocalDate dataDeNascimento, String senha, String cpf,
			String telefone, LocalDate dataCadastro) {
		super(id, nome, email, dataDeNascimento, senha);
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public boolean efetuarPagamento(double totalPedido) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Total a pagar: " + String.format("%.2f", totalPedido));
		System.out.println("Digite o valor total a pagar: ");
		double pagamento = sc.nextDouble();
		if (pagamento >= totalPedido) {
			return true;
		}else {
			return false;
		}
	}
	
}