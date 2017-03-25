package br.sceweb.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.sceweb.servico.FabricaDeConexoes;

public class EmpresaDAO {

	public int adiciona(Empresa empresa) {
		PreparedStatement ps;
		int codigoRetorno = 0;

		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values(?,?,?,?,?)");

			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());

			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return codigoRetorno;
	}

	public int exclui(String cnpj) {
		PreparedStatement ps;
		int codigoretorno = 0;

		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("delete from empresa where cnpj = ?");
			ps.setString(1, cnpj);

			codigoretorno = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return codigoretorno;
	}

	public Empresa consultaEmpresa(String cnpj){
		/*PreparedStatement ps;
		Empresa empresa = null;
		
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("select * from empresa where cnpj = ?");
			ps.setString(1, cnpj);
			ResultSet rs = ps.executeQuery();
			rs.first();
			empresa.setCnpj(rs.getString(1));
			empresa.setNomeDaEmpresa(rs.getString(2));
			empresa.setNomeFantasia(rs.getString(3));
			empresa.setEndereco(rs.getString(4));
			empresa.setTelefone(rs.getString(5));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return empresa;*/
		return new Empresa();
	}
	
}
