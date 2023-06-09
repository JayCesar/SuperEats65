package aplicacao;

import java.time.LocalDate;
import java.util.Scanner;
import entidades.Funcionario;
import entidades.Pedido;
import entidades.Pessoa;

public class MenuFuncionario {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		System.out.println("\n--- Login ---");

		System.out.print("Email: ");
		String emailLogin = ler.nextLine();

		System.out.print("Senha: ");
		String senhaLogin = ler.nextLine();

		Funcionario pessoa1 = new Funcionario(null, null, null, null, null, 0, emailLogin, senhaLogin, null);

		if (emailLogin.equals(pessoa1.getEmail()) && senhaLogin.equals(pessoa1.getSenha())) {
			System.out.println("Login realizado com sucesso!");

			System.out.println("MENU:");
			System.out.println("1. Preparar Pedido");
			System.out.println("2. Finalizar Pedido");
			System.out.println("3. Sair");
			System.out.print("Escolha uma opção: ");
			int opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				pessoa1.prepararPedido();

				break;
			case 2:
				pessoa1.finalizarPedido();
				break;
			case 3:
				System.out.println("Saindo do programa...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			while (opcao != 3)
				;
			{

			}
		} else {
			System.out.println("Email ou senha incorretos!");

		}
	}
}