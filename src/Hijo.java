package bin;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hijo extends Thread {
	String p,r;

	Hijo(String name, String ruta, String patron) {
		r = ruta;
        p=patron;
	}

	@Override
	public void run() {
		Date date = new Date ();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");

		System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_BLUE_BACKGROUND+"\n\tHILO "+getName() + " inicio a las " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
		System.out.println("LISTADO COMPLETO");
		File ruta = new File(r);
		String[] archivos = ruta.list();
		for (int i = 0; i < archivos.length; i++) {
		File cadena = new File(r,archivos[i]);
			System.out.println(getName() + "(Listado) > " + cadena.getAbsolutePath() + "/" + archivos[i]);
		}
		Nieto nieto = new Nieto("Nieto",r,p);
		nieto.start();
		System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_PURPLE_BACKGROUND+getName()+" (Listado)> TERMINO " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
	}
}
