package lab1;

import java.util.ArrayList;

public class Livro {

	private String autor;
	private String titulo;
	private boolean emprestado;
	private boolean reservado;
	private ArrayList<Emprestimo> historico;
	
	public boolean isReservado() {
		return reservado;
	}
	
	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
	
}
