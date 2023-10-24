package poo.ControlePatrimonio.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe que retorna uma conex�o com o banco de dados em quest�o
public class FabricaControlePatrimonio {
		
	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ativosbd", "sa", "");
	}

}
