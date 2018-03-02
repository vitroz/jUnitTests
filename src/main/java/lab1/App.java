package lab1;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import lab1.Emprestimo;
import lab1.Livro;
import lab1.Usuario;
import lab1.ServicoDevolucao;
import lab1.ServicoEmprestimo;

public class App {

	public static void main(String[] args) throws ParseException {
		 ServicoEmprestimo servicoEmprestimo = new ServicoEmprestimo();
		 ServicoDevolucao servicoDevolucao = new ServicoDevolucao();
		 LocalDate formDataEmprestimo = LocalDate.now(); //Simula��o de Input.
		 Emprestimo emprestimo = new Emprestimo(formDataEmprestimo); 
		 Emprestimo emprestimo2 = new Emprestimo(formDataEmprestimo);
		 emprestimo.getUsuario().setNome("Nome Simula��o");
		 emprestimo.getLivro().setTitulo("Titulo Simula��o");
		 
		 System.out.println("Tentativa de emprestimo 1:");
		 servicoEmprestimo.realizaEmprestimo(emprestimo);
		 
		 System.out.println("Tentativa de emprestimo 2:");
		 servicoEmprestimo.realizaEmprestimo(emprestimo);
		 
		 System.out.println("Devolu��o do emprestimo 1");
		 emprestimo.setDataDevolucao(formDataEmprestimo);
		 emprestimo.setValorPago(5);
		 servicoDevolucao.realizaDevolucao(emprestimo);
		 
	}

}
