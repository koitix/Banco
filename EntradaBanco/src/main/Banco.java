package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Banco {

	private Date dataAgora = new Date();
	private int Ok;
	private int NaoOk;
	protected Date dataFalsa;

	public int validaEntrada(Date dataAgora) throws ParseException, IOException {
		FileWriter ArquivoLog = new FileWriter(new File("log.txt"));
		BufferedWriter escreveNoArquivo = new BufferedWriter(ArquivoLog);

		SimpleDateFormat formatoDia = new SimpleDateFormat("YYYY.MM.dd ");
		SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
		Date HoraMinima = formatoHora.parse("10:00:00");
		Date HoraMaxima = formatoHora.parse("16:00:00");
		String texto;
		if (HoraMinima.getTime() <= dataAgora.getTime() && HoraMaxima.getTime() >= dataAgora.getTime()) {
			texto = (formatoDia.format(dataAgora) + formatoHora.format(dataAgora) + " Abertura da Porta OK");
			escreveNoArquivo.append(texto + "\n");

			escreveNoArquivo.close();
			System.out.println(formatoDia.format(dataAgora) + formatoHora.format(dataAgora) + " Abertura da Porta OK");
			return Ok++;
		} else {
			texto = (formatoDia.format(dataAgora) + formatoHora.format(dataAgora)
					+ " Fora do Horário de Funcionamento");
			escreveNoArquivo.append(texto + "\n");
			escreveNoArquivo.write(texto);
			escreveNoArquivo.close();
			System.out.println(
					formatoDia.format(dataAgora) + formatoHora.format(dataAgora) + " Fora do Horário de Funcionamento");

			return NaoOk++;
		}

	}

	public Date getDataAgora() {
		return dataAgora;
	}

	public void setDataAgora(Date dataAgora) {
		this.dataAgora = dataAgora;
	}

	public Date getDataFalsa() throws ParseException {
		String fake = "11:10:09";
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");

		return dataFalsa = sdf1.parse(fake);
	}

	public void setDataFalsa(Date dataFalsa) {

		this.dataFalsa = dataFalsa;
	}

	public int getNaoOk() {
		return NaoOk;
	}

	public void setNaoOk(int naoOk) {
		NaoOk = naoOk;
	}

	public int getOk() {
		return Ok;
	}

	public void setOk(int ok) {
		Ok = ok;
	}

}
