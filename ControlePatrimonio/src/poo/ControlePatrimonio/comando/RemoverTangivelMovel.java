package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.IntangivelDAO;
import poo.ControlePatrimonio.DAO.TangivelMovelDAO;

public class RemoverTangivelMovel implements Comando{
	
	public void executar(Scanner entrada) {
		//cria um objeto DAO para excluir do banco
		TangivelMovelDAO tangivelMovelDAO = new TangivelMovelDAO();
				
		System.out.println("Digite o codigo do ativo Intang�vel:");
		int codigo = entrada.nextInt();
				
		tangivelMovelDAO.removerAtivo(codigo);
		
		System.out.println("\nRemo��o feita com sucesso!\n");
	}	
}
