package lab1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import lab1.Emprestimo;
import lab1.Livro;
import lab1.Usuario;
import lab1.ServicoEmprestimo;

public class ServicoEmprestimoTest {
	
	private static Livro livroMock;
	private static Emprestimo emprestimoMock;
	private static ServicoEmprestimo servicoEmprestimoMock;
	private static Usuario usuarioMock;
	private static LocalDate dataMock;
	private static Calendar calendar;
	
	@BeforeClass
	public static void inicializar() {
		livroMock = new Livro();
		dataMock = LocalDate.now();
				
		emprestimoMock = new Emprestimo(dataMock);
		servicoEmprestimoMock = new ServicoEmprestimo();
		usuarioMock = new Usuario();
		
	}
	
	@Before
	public void limpaEmprestimosUsuario() {
		usuarioMock.getEmprestimos().clear();
	}

	@Test
	public void deveRealizarEmprestimoEmLivroQueNaoEstejaReservado() {
		livroMock.setReservado(false);
		livroMock.setTitulo("Teste");
		emprestimoMock.getUsuario().setNome("Teste");
		emprestimoMock.setLivro(livroMock);
		assertTrue(servicoEmprestimoMock.realizaEmprestimo(emprestimoMock));
	}
	
	@Test
	public void NaoDeveRealizarEmprestimoEmLivroReservado() {
		livroMock.setReservado(true);
		livroMock.setTitulo("Teste");
		emprestimoMock.getUsuario().setNome("Teste");
		emprestimoMock.setLivro(livroMock);
		assertFalse(servicoEmprestimoMock.realizaEmprestimo(emprestimoMock));
	}
	
	@Test
	public void garantirQueDataPrevistaDeRetornoDoLivroEh7DiasAposEmprestimo() {
		LocalDate dataDeRetornoPrevista = emprestimoMock.getDataEmprestimo();		

		dataDeRetornoPrevista = emprestimoMock.getDataEmprestimo().plusDays(7);
		
		assertEquals(emprestimoMock.getDataPrevista(), dataDeRetornoPrevista);
	}
	
	@Test
	public void UsuarioPodeNaoTerEmprestimoDeLivro() {
		assertTrue(usuarioMock.getEmprestimos().size() == 0);
	}
	
	@Test
	public void UsuarioPodeTerUmEmprestimoDeLivro() {		
		assertTrue(usuarioMock.adicionaEmprestimo(emprestimoMock));
	}
	
	@Test
	public void UsuarioPodeTerDoisEmprestimosDeLivros() {
		Emprestimo emprestimo = new Emprestimo(LocalDate.now());
		Emprestimo emprestimo2 = new Emprestimo(LocalDate.now());
		
		assertTrue(usuarioMock.adicionaEmprestimo(emprestimo));
		assertTrue(usuarioMock.adicionaEmprestimo(emprestimo2));
	}
	
	@Test
	public void UsuarioPodeTerNoMaximoDoisEmprestimosDeLivros() {
		Emprestimo emprestimo = new Emprestimo(LocalDate.now());
		Emprestimo emprestimo2 = new Emprestimo(LocalDate.now());
		Emprestimo emprestimo3 = new Emprestimo(LocalDate.now());
		
		assertTrue(usuarioMock.adicionaEmprestimo(emprestimo));
		assertTrue(usuarioMock.adicionaEmprestimo(emprestimo2));
		assertFalse(usuarioMock.adicionaEmprestimo(emprestimo3));
	}

}
