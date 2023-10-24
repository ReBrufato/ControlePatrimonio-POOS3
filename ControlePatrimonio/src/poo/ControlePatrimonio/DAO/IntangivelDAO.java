package poo.ControlePatrimonio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import poo.ControlePatrimonio.ativo.Ativo;
import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.bd.FabricaControlePatrimonio;

//classe que será utilizada para comunicar ativos intangíveis com o banco de dados

//int codigo, String descricao, int tempoRestante, double valorAno

public class IntangivelDAO implements ativoBd{
	//cadastra um ativo intangível
	public void cadastrar(Intangivel intangivel) {
		try(Connection conn = FabricaControlePatrimonio.getConexao()) {
			String sql = "insert into intangivel (codigo, descricao, tempoRestante, valorAno) values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, intangivel.getCodigo());
			ps.setString(2, intangivel.getDescricao());
			ps.setInt(3, intangivel.getTempoRestante());
			ps.setDouble(4, intangivel.getValorAno());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//altera um ativo intangível no banco de dados
	public void alterar(Intangivel intangivel) {
		try(Connection conn = FabricaControlePatrimonio.getConexao()) {
			String sql = "update intangivel set descricao = ?, tempoRestante = ?, valorAno = ? where codigo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, intangivel.getDescricao());
			ps.setInt(2, intangivel.getTempoRestante());
			ps.setDouble(3, intangivel.getValorAno());
			ps.setInt(4, intangivel.getCodigo());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//remove um ativo intangível do banco de dados
	public void removerAtivo(int codigoAtivo) {
		try(Connection conn = FabricaControlePatrimonio.getConexao()) {
			String sql = "delete from intangivel where codigo = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, codigoAtivo);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//retorna todos os ativos intangíveis do banco de dados
	public List<Intangivel> getAtivos() {
		try(Connection conn = FabricaControlePatrimonio.getConexao()) {
			String sql = "select * from intangivel";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Intangivel> intangiveis = new ArrayList<Intangivel>();
			while(rs.next()) {
				Intangivel intangivel = new Intangivel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				intangiveis.add(intangivel);
			}
			return intangiveis;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
