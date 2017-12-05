package main;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


public class Run {
	

	
	
	public static void main(String[] args) throws ParseException, IOException {
		Banco banco = new Banco();
		Date data = banco.getDataAgora();
		Date data2 = banco.getDataAgora();
		Date data3 = banco.getDataFalsa();
		Date data5 = banco.getDataFalsa();
		banco.validaEntrada(data3);
		banco.validaEntrada(data);
		banco.validaEntrada(data5);
		banco.validaEntrada(data2);
	
	
		System.out.println("Quantidade de pessoas que entraram fora do horario: "+banco.getOk());
		System.out.println("Quantidade de pessoas que entraram dentro do horario: "+banco.getNaoOk());
		
	}
}
