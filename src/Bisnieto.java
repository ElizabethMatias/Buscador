package bin;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bisnieto extends Thread {
	String p,r;
	
	Bisnieto(String name, String ruta, String patron) {
		setName(name);
		p = patron;
		r = ruta;
	}
	@Override
	public void run() {
		Date date = new Date ();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_BLUE_BACKGROUND+"\n\tHILO "+getName() + " inicio a las " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
		File listado=new File(r);
		String[] arrayList = listado.list();
		Pattern pat = Pattern.compile(p);
		for (int i = 0; i < arrayList.length; i++) {
			File cadena = new File(r,arrayList[i]);
			Matcher mat = pat.matcher(arrayList[i]);                                                                           
			if (mat.matches()){				
				if(!cadena.isDirectory() && getName()=="Bisnieto 1"){
						System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_GREEN_BACKGROUND+getName()  + "(Archivo) >" +arrayList[i]+ " | (tamano:"+cadena.length()+")"+ConsoleSystem.ANSI_BLACK_BACKGROUND));
				}
				else if(cadena.isDirectory() && getName()=="Bisnieto 2"){
						System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_YELLOW_BACKGROUND+getName() + "(Directorio) >" +arrayList[i]+ " | (tamano:"+carpeta(cadena)+")"+ConsoleSystem.ANSI_BLACK_BACKGROUND));
						cascada(r+"/"+arrayList[i],arrayList[i],getName(),r+" "+arrayList[i]);
					}
				if(i==0){
					if (getName()=="Bisnieto 1"){
						try {
							Thread.sleep(5000);
						} catch (InterruptedException ex) {
								System.out.println("Interrumpido");
						}
						System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_PURPLE_BACKGROUND+"\n\tBISNIETO 1 TERMINO " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
					}else if(getName()=="Bisnieto 2"){
						try {
							Thread.sleep(5000);
						} catch (InterruptedException ex) {
								System.out.println("Interrumpido");
						}
						System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_PURPLE_BACKGROUND+"\n\tBISNIETO 2 TERMINO " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
					}
				}
			}
		}
	

 	}

	public static void cascada(String r, String casc, String nombre, String nuevaCasc){
		File listado=new File(r);
		String nuevaCasc1 = nuevaCasc + " " +casc;
		String[] arrayList = listado.list();
		for (int i = 0; i < arrayList.length; i++) {
			File cadena = new File(r,arrayList[i]);
			if(cadena.isDirectory()){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ex) {
						System.out.println("Interrumpido");
				}
				System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_WHITE_BACKGROUND + nombre + "(Directorio) >" +nuevaCasc1+ " | (tamano:"+carpeta(cadena)+"  )"+ConsoleSystem.ANSI_BLACK_BACKGROUND));
				cascada(r+"/"+arrayList[i], arrayList[i],nombre, nuevaCasc1);
			}
		}
	}

	public static long carpeta(File directorio) {
		long length = 0;
		for (File file : directorio.listFiles()) {
		if (file.isFile()){
				length += file.length();
			}
			else{
			length += carpeta(file);
			}
		}
		return length;
	}
}















