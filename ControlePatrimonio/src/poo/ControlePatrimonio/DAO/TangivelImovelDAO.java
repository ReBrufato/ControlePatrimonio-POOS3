package poo.ControlePatrimonio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import poo.ControlePatrimonio.ativo.Intangivel;
import poo.ControlePatrimonio.ativo.TangivelImovel;
import poo.ControlePatrimonio.ativo.TangivelMovel;
import poo.ControlePatrimonio.bd.FabricaControlePatrimonio;

//classe que será utilizada para comunicar os ativos tangíveis imóveis com o banco de dados

//int codigo, String descricao, String localizacao, double tamanho, double valorMetro

public class TangivelImovelDAO implements ativoBd {
	//cadastra um ativo tangível imóvel
		public void cadastrar(TangivelImovel tangivelimovel) {
			try(Connection conn = FabricaControlePatrimonio.getConexao()) {
				String sql = "insert into tangivelImovel (codigo, descricao, localizacao, tamanho, valorMetro) values (?, ?, ?, ?, ?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, tangivelimovel.getCodigo());
				ps.setString(2, tangivelimovel.getDescricao());
				ps.setString(3, tangivelimovel.getLocalizacao());
				ps.setDouble(4, tangivelimovel.getTamanho());
				ps.setDouble(5, tangivelimovel.getValorMetro());
				ps.executeUpdate();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		//altera um ativo tangível móvel no banco de dados
		public void alterar(TangivelImovel tangivelimovel) {
			try(Connection conn = FabricaControlePatrimonio.getConexao()) {
				String sql = "update tangivelImovel set descricao = ?, localizacao = ?, tamanho = ?, valorMetro = ?, where codigo = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, tangivelimovel.getDescricao());
				ps.setString(2, tangivelimovel.getLocalizacao());
				ps.setDouble(3, tangivelimovel.getTamanho());
				ps.setDouble(4, tangivelimovel.getValorMetro());
				ps.setInt(5, tangivelimovel.getCodigo());
				ps.executeUpdate();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
				
		//remove um ativo tangível móvel do banco de dados
		public void removerAtivo(int codigoAtivo) {
			try(Connection conn = FabricaControlePatrimonio.getConexao()) {
				String sql = "delete from tangivelImovel where codigo = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, codigoAtivo);
				ps.executeUpdate();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	
		//retorna todos os ativos tangíveis imóveis do banco de dados
		public List<TangivelImovel> getAtivos() {
			try(Connection conn = FabricaControlePatrimonio.getConexao()) {
				String sql = "select * from tangivelImovel";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				List<TangivelImovel> tangiveisImoveis = new ArrayList<TangivelImovel>();
				while(rs.next()) {
					TangivelImovel tangivelImovel = new TangivelImovel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDouble(4));
					tangiveisImoveis.add(tangivelImovel);
				}
				return tangiveisImoveis;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

}
