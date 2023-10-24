package poo.ControlePatrimonio.comando;

import java.io.IOException;
import java.util.Scanner;

public interface Comando {	
	public void executar(Scanner entrada) throws IOException;
}
