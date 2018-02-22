package Simuetec.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.text.MaskFormatter;

public class Mascara {

	public void InsumoMascara() throws ParseException {

		MaskFormatter data = new MaskFormatter();
		data.setMask("##/##/####");
	}

	public String convertDate(String dtAtual) {

		String dtFormatada = null;

		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date date = format.parse(dtAtual);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dia = calendar.get(Calendar.DATE);
			int mes = calendar.get(Calendar.MONTH) + 1;
			int ano = calendar.get(Calendar.YEAR);
			return dtFormatada = (ano + "-" + mes + "-" + dia);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dtFormatada;

	}

}
