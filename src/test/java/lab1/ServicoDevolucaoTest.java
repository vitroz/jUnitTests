package lab1;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import lab1.ServicoDevolucao;

public class ServicoDevolucaoTest {
	
	private static Emprestimo emprestimoMock;
	private static LocalDate dataMock;
	private static ServicoDevolucao servicoDevolucaoMock;
	
	@BeforeClass
	public static void inicializar() {
		dataMock = LocalDate.now();
				
		emprestimoMock = new Emprestimo(dataMock);
		servicoDevolucaoMock = new ServicoDevolucao();
	}

	@Test
	public void devePoderRealizarDevolucaoDeLivroAntesDaDataPrevista() throws ParseException {
		Calendar calendarAntes = Calendar.getInstance();
		calendarAntes.set(2017, Calendar.NOVEMBER, 25);
		LocalDate dataAnteriorAPrevista = LocalDate.now();
		dataAnteriorAPrevista = LocalDate.now();
		//Data prevista = 27.11 - Data de devolu��o = 25.11
		emprestimoMock.setValorPago(5);
		emprestimoMock.setDataDevolucao(dataAnteriorAPrevista);
		
		assertTrue(servicoDevolucaoMock.realizaDevolucao(emprestimoMock));
		
	}
	
	@Test
	public void devePoderRealizarDevolucaoNaDataPrevista() throws ParseException {
		LocalDate dataAtual = LocalDate.now();
		//Data prevista = 27.11 - Data de devolu��o = 27.11
		emprestimoMock.setValorPago(5);
		emprestimoMock.setDataDevolucao(dataAtual);
		
		assertTrue(servicoDevolucaoMock.realizaDevolucao(emprestimoMock));		
	}
	
	@Test
	public void devolucaoDeLivroUmDiaAposDataPrevistaDeveAcrescentarMulta() throws ParseException {
		//Data prevista = 27.11 - Data de devolu��o = 28.11
		emprestimoMock.setValorPago(5);
		emprestimoMock.setDataDevolucao(emprestimoMock.getDataPrevista().plusDays(1));
		
		float valorComUmDiaDeMulta = (float) 5.4;
	
		assertTrue(servicoDevolucaoMock.calculaValorEmprestimo(emprestimoMock) == valorComUmDiaDeMulta);
		
	}
	
	@Test
	public void devolucaoDeLivroCom30DiasDeAtrasoDeveAcrescenta60porcentoDeMulta() throws ParseException {
		//Data prevista = 27.11 - Data de devolu��o = 27.12
		emprestimoMock.setValorPago(5);
		emprestimoMock.setDataDevolucao(emprestimoMock.getDataPrevista().plusDays(30));
		
		float valorCom30DiasDeMulta = (float) 8;
	
		assertTrue(servicoDevolucaoMock.calculaValorEmprestimo(emprestimoMock) == valorCom30DiasDeMulta);
		
	}
	
	@Test
	public void devolucaoDeLivroCom5DiasDeAtrasoDeveAcrescentaMulta() throws ParseException {
		//Data prevista = 27.11 - Data de devolu��o = 02.12
		emprestimoMock.setValorPago(5);
		emprestimoMock.setDataDevolucao(emprestimoMock.getDataPrevista().plusDays(5));
		
		float valorCom5DiasDeMulta = (float) 7;
	
		assertTrue(servicoDevolucaoMock.calculaValorEmprestimo(emprestimoMock) == valorCom5DiasDeMulta);
		
	}

}
