package lab1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import lab1.Emprestimo;

public class ServicoDevolucao {
	
	public boolean realizaDevolucao(Emprestimo emprestimo) throws ParseException {
		if(emprestimo.getDataPrevista().isAfter(emprestimo.getDataDevolucao()) || 
		   emprestimo.getDataPrevista().equals(emprestimo.getDataDevolucao())) {
			
			if(emprestimo.getValorPago() == calculaValorEmprestimo(emprestimo)) {
				System.out.println("Devolu��o concluida com sucesso");
				emprestimo.getLivro().setEmprestado(false);
				return true;
			}else {
				System.out.println("Devolu��o n�o concluida com sucesso, pois valor pago n�o esta correto.");
				System.out.println("Valor a ser pago: "+ calculaValorEmprestimo(emprestimo));
				return false;
			}
		}
		System.out.println("Devolu��o n�o pode ser concluida devido a data de devolu��o invalida");
		return false;
	}
	
	public float calculaValorEmprestimo(Emprestimo emprestimo) throws ParseException {
		float valorAserPago = 5;
		if(emprestimo.getDataDevolucao().isAfter(emprestimo.getDataPrevista())) {
			long diferencaDias = calculaDiferencaDias(emprestimo);
			valorAserPago = (float) (valorAserPago + (diferencaDias * 0.40));
			if(valorAserPago >= 8) {
				return 8;
			}
			return valorAserPago;
		}else {
			return valorAserPago;
		}
	
	}
	
	public String formataData(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String sDate= sdf.format(data);
		return sDate;		
	}
	
	public long calculaDiferencaDias(Emprestimo emprestimo) throws ParseException {
		long diferencaDias = ChronoUnit.DAYS.between(emprestimo.getDataPrevista(), emprestimo.getDataDevolucao());

		return diferencaDias;
	}

}
