package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.IntangivelDAO;
import poo.ControlePatrimonio.DAO.TangivelImovelDAO;

public class RemoverTangivelImovel implements Comando{

	public void executar(Scanner entrada) {
		//cria um objeto DAO para excluir do banco
		TangivelImovelDAO tangivelImovelDAO = new TangivelImovelDAO();
				
		System.out.println("Digite o codigo do ativo Intang�vel:");
		int codigo = entrada.nextInt();
				
		tangivelImovelDAO.removerAtivo(codigo);
		
		System.out.println("\nRemo��o feita com sucesso!\n");
	}
}
