package br.sceweb.servico;

import java.sql.DriverManager;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class FabricaDeConexoes {
	private static final Logger logger = Logger.getLogger(FabricaDeConexoes.class);

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/sceweb";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			/* Alterar usu�rio e senha conforme necessidade. */
			return (Connection) DriverManager.getConnection(url, "root", "alunofatec");
		} catch (CommunicationsException e) {
			logger.info("Exce��o de comunicacao com o DB causa: " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			logger.info("Exce��o geral causa: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
