package bin;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Buscador {

    private Scanner sc = new Scanner(System.in);
    private boolean salir = false;
    private int opc=0;

	public static void main(String[] args) {
        try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
		    System.out.println("Interrumpido");
		}
		Buscador mi=new Buscador();
        mi.menuInicio();
	}

    public void menuInicio(){
            
        System.out.println("\nExamen 4 : Hilos\n\n--- MENU PRINCIPAL ---\n");
        System.out.println("\n1) Realizar busqueda\n2) Salir\n");
        System.out.print("\nIngresé la opción a elegir: ");
            
        opc = sc.nextInt();
            
        switch(opc){
            case 1:
                Date date = new Date ();
                DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
                System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_BLUE_BACKGROUND+"\n\tHILO PRINCIPAL INICIO " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
                System.out.println("------ Has seleccionado la opcion 1 ------\n");
                System.out.print(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_WHITE_BACKGROUND+"Escribe la ruta:     "+ConsoleSystem.ANSI_BLACK_BACKGROUND+" "));
                String rutaDirectorio = System.console().readLine();
                System.out.print(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_WHITE_BACKGROUND+"Escribe el padtron:  "+ConsoleSystem.ANSI_BLACK_BACKGROUND+" "));
                String patron = System.console().readLine();
                Hijo hijo = new Hijo("Hijo",rutaDirectorio, patron);
                hijo.start();
  
                System.out.println(String.format(ConsoleSystem.ANSI_AMARILLO_LINECOLOR+"Padre: Hilos activos: "+Thread.activeCount()+ConsoleSystem.ANSI_BLACK_BACKGROUND));
                                
                try {
                    hijo.join();
                    System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_PURPLE_BACKGROUND+"\n\tHILO PADRE PRINCIPAL TERMINO " + hourFormat.format(date)+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
                } catch ( InterruptedException ex){

                    System.out.println(String.format(ConsoleSystem.ANSI_NEGRO_LINECOLOR+ConsoleSystem.ANSI_RED_BACKGROUND+"\n\tERROR: No se pudo esperar al hilo hijo"+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
                }

                break;
            case 2:
                System.out.println("Has seleccionado la opcion 2");
                System.exit(0);
                break;
            default:
                System.out.println(String.format(ConsoleSystem.ANSI_ROJO_LINECOLOR+"\n\tOpción no válida, inténtalo de nuevo."+ConsoleSystem.ANSI_BLACK_BACKGROUND+"\n"));
            }
        }
}