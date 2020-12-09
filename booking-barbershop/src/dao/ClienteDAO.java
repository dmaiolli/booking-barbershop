package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Cliente;
import domain.Estilo;
import exception.LoadFileException;
import helper.FileHelper;

public class ClienteDAO {

	private Connection conn;

	private void conecta() throws SQLException {
		try {
			Properties props = FileHelper.loadProperties();
			this.conn = DriverManager.getConnection(props.getProperty("database.url"),
					props.getProperty("database.user"), props.getProperty("database.password"));
		} catch (LoadFileException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Cliente> consultaTodos() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		this.conecta();

		String sql = "select * from tb_cliente";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String nome = rs.getString("nm_cliente");
			Integer idade = rs.getInt("vl_idade");

			clientes.add(new Cliente(nome, idade));
		}

		this.desconecta();
		return clientes.isEmpty() ? null : clientes;
	}

	public void salva(Cliente cliente) throws SQLException {
		this.conecta();

		String sql = String.format("insert into tb_cliente(nome, idade)" + "values(?, ?)", cliente.getNome(),
				cliente.getDataNascimento());

		Statement stmt = this.conn.createStatement();
		stmt.executeUpdate(sql);
		
		this.desconecta();
	}

	private void desconecta() throws SQLException {
		if (!conn.isClosed())
			conn.close();
	}

}