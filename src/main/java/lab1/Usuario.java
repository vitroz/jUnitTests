package lab1;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String matricula;
	private ArrayList<Emprestimo> emprestimos;
	
	public Usuario() {
		emprestimos = new ArrayList<Emprestimo>();
	}
	
	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	public boolean adicionaEmprestimo(Emprestimo e) {
		if(this.emprestimos.size() < 2) {
			this.emprestimos.add(e);
			return true;
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
