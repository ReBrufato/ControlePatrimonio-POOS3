package poo.ControlePatrimonio.comando;

import java.util.Scanner;

import poo.ControlePatrimonio.DAO.IntangivelDAO;

public class RemoverIntangivel implements Comando{
	
	public void executar(Scanner entrada) {
		//cria um objeto DAO para excluir do banco
		IntangivelDAO intangivelDAO = new IntangivelDAO();
		
		System.out.println("Digite o codigo do ativo Intangível:");
		int codigo = entrada.nextInt();
		
		intangivelDAO.removerAtivo(codigo);
		
		System.out.println("\nRemoção feita com sucesso!\n");
	}
}
