package bin;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nieto extends Thread {
	String r,p;
	String nombreArchivo;
	boolean nombreCorrecto;
	
	Nieto(String name, String ruta, String patron) {
		setName(name);
		r = ruta;
		p = patron;
	}

	@Override
	public void run() {
		Date date = new Date ();
		String nombreArchivo;
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		boolean nombreCorrecto;

		System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_BLUE_BACKGROUND+"\n\tHILO "+getName() + " inicio a las " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
		Bisnieto bn1 = new Bisnieto("Bisnieto 1",r,p);
		Bisnieto bn2 = new Bisnieto("Bisnieto 2",r,p);
		
		File dir = new File(r);
		String[] archivos = dir.list();
		for (int i = 0; i < archivos.length; i++) {
			nombreArchivo = archivos[i]; 
			nombreCorrecto = nombreArchivo.matches(p);
			if (nombreCorrecto) {
				File directorio = new File(r, archivos[i]);
				if (directorio.isDirectory()) {
					System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR + ConsoleSystem.ANSI_CYAN_BACKGROUND + getName() + " (Patron)--> "+ directorio + " | (tamano:"+directorio.length()+")"));
					cascada(r+"/"+archivos[i],p,getName());
				}
				else {
					System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR + ConsoleSystem.ANSI_CYAN_BACKGROUND + getName() + " (Patron)--> " +directorio + " | (tamano:"+directorio.length()+")"));
				}
			}
		}
		bn1.start();
		bn2.start();
		System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_PURPLE_BACKGROUND+getName()+" (Patron)> TERMINO " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
	}
	
	public static void cascada(String casc, String pt, String nombre){
		File listado=new File(casc);
		String[] arrayList = listado.list();
		for (int i = 0; i < arrayList.length; i++) {
			String nombreArchivo = arrayList[i];
			boolean nombreCorrecto = nombreArchivo.matches(pt);
			if (nombreCorrecto) {
				File cadena = new File(casc,arrayList[i]);
				if(cadena.isDirectory()){
					System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_YELLOW_BACKGROUND + nombre + "(Patron) >" +casc+ " | (tamano:"+cadena.length()+")"+ConsoleSystem.ANSI_BLACK_BACKGROUND));
					cascada(casc+"/"+arrayList[i], pt, nombre);
				}
				else {
					System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR + ConsoleSystem.ANSI_CYAN_BACKGROUND +" getName() "+ " (Patron)--> " +casc + " | (tamano:"+cadena.length()+")"+ConsoleSystem.ANSI_BLACK_BACKGROUND));
				}
			}
		}
	}
}	
