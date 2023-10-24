package poo.ControlePatrimonio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.bd.FabricaControlePatrimonio;

//classe que será utilizada para comunicar os ativos tangíveis móveis com o banco de dados 

//int codigo, String descricao,int quantidade, double valorUnidade

public class TangivelMovelDAO implements ativoBd{
	//cadastra um ativo tangível móvel
	public void cadastrar(TangivelMovel tangivelmovel) {
		try(Connection conn = FabricaControlePatrimonio.getConexao()) {
			String sql = "insert into tangivelMovel (codigo, descricao, quantidade, valorUnidade) values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tangivelmovel.getCodigo());
			ps.setString(2, tangivelmovel.getDescricao());
			ps.setInt(3, tangivelmovel.getQuantidade());
			ps.setDouble(4, tangivelmovel.getValorUnidade());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//altera um ativo tangível móvel no banco de dados
			public void alterar(TangivelMovel tangivelmovel) {
				try(Connection conn = FabricaControlePatrimonio.getConexao()) {
					String sql = "update tangivelMovel set descricao = ?, quantidade = ?, valorUnidade = ? where codigo = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, tangivelmovel.getDescricao());
					ps.setInt(2, tangivelmovel.getQuantidade());
					ps.setDouble(3, tangivelmovel.getValorUnidade());
					ps.setInt(4, tangivelmovel.getCodigo());
					ps.executeUpdate();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
	
	//remove um ativo tangível móvel do banco de dados
	public void removerAtivo(int codigoAtivo) {
		try(Connection conn = FabricaControlePatrimonio.getConexao()) {
			String sql = "delete from tangivelMovel where codigo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoAtivo);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
		
	//retorna todos os ativos tangíveis móveis do banco de dados
		public List<TangivelMovel> getAtivos() {
			try(Connection conn = FabricaControlePatrimonio.getConexao()) {
				String sql = "select * from tangivelMovel";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				List<TangivelMovel> tangiveisMoveis = new ArrayList<TangivelMovel>();
				while(rs.next()) {
					TangivelMovel tangivelMovel = new TangivelMovel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
					tangiveisMoveis.add(tangivelMovel);
				}
				return tangiveisMoveis;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
}
