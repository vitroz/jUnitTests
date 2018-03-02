package lab1;

import lab1.Emprestimo;

public class ServicoEmprestimo {
	
	public boolean realizaEmprestimo(Emprestimo emprestimo) {	
		
		if(ehNulo(emprestimo.getUsuario().getNome())) {
			System.out.println("Nome de Usuario n�o Informado");
			return false;
		}
		
		if(ehNulo(emprestimo.getLivro().getTitulo())) {
			System.out.println("Titulo de livro n�o Informado");
			return false;
		}
		
		if(!emprestimo.getLivro().isReservado() && 
		   !emprestimo.getLivro().isEmprestado()) {
			
			emprestimo.getLivro().setEmprestado(true);
			System.out.println("Livro Reservado com Sucesso");
			return true;
		}
		System.out.println("Livro reservado ou emprestado.");
		return false;		
	}
	
	public boolean ehNulo(String campo) {
		if(campo == null) {
			return true;
		}
		return false;
	}

}
