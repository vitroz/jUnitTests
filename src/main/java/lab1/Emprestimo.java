package lab1;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Emprestimo {

	private Usuario usuario;
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevista;
	private LocalDate dataDevolucao;
	
	private Livro livro;
	private float valorPago;
	
	public Emprestimo(LocalDate dataEmprestimo) {
		this.dataPrevista = dataEmprestimo.plusDays(7);
		this.dataEmprestimo = dataEmprestimo;
		usuario = new Usuario();
		livro = new Livro();
	}
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	
	public LocalDate getDataPrevista() {		
		return dataPrevista;
	}
	
	 public ArrayList<Emprestimo> consultarEmprestimosPorUsuario(Usuario u){		 
		 return u.getEmprestimos();
	 }
	 
	 public Livro getLivro() {
		 return livro;
	 }
	 
	 public void setLivro(Livro livro) {
		 this.livro = livro;
	 }
	 
	 public void setDataDevolucao(LocalDate dataDevolucao) {
		 this.dataDevolucao = dataDevolucao;		 
	 }
	 
	 public LocalDate getDataDevolucao() {
		 return dataDevolucao;
	 }

	public float getValorPago() {
		return valorPago;
	}

	public void setValorPago(float valorPago) {
		if (valorPago < 5 || valorPago > 8)
		      throw new IllegalArgumentException("Valor minimo de aluguel � 5 reais, e n�o pode ultrapassar 8 reais: " + valorPago);
		    this.valorPago = valorPago;
		this.valorPago = valorPago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
