package bin;
import java.util.*;
import java.io.*;

class ConsoleSystem {

	public static final String ANSI_LINECOLOR ="\u001B[1m";

	public static final String ANSI_BLANCO_LINECOLOR ="\u001B[0m";
	public static final String ANSI_NEGRO_LINECOLOR ="\u001B[30m";
	public static final String ANSI_ROJO_LINECOLOR ="\u001B[31m";
	public static final String ANSI_VERDE_LINECOLOR ="\u001B[32m";
	public static final String ANSI_AZUL_LINECOLOR ="\u001B[34m";
	public static final String ANSI_AMARILLO_LINECOLOR ="\u001B[33m";
	public static final String ANSI_ROSA_LINECOLOR ="\u001B[35m";

    public static final String ANSI_BLACK_BACKGROUND ="\u001B[0m";
	public static final String ANSI_RED_BACKGROUND ="\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND ="\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND ="\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND ="\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND ="\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND ="\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND ="\u001B[47m";

	public void clear(){

		try {
			if (System.getProperty("os.name").contains("Windows")){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (IOException | InterruptedException ex) {
			System.out.println(String.format(ANSI_NEGRO_LINECOLOR+ANSI_RED_BACKGROUND+"\n\tERROR: Tu sistema no es compatible\n"+ANSI_BLACK_BACKGROUND));
		}
	}

}