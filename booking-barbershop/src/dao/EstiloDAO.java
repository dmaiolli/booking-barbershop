package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.Estilo;
import exception.LoadFileException;
import helper.FileHelper;

public class EstiloDAO {

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

	public List<Estilo> consultaTodos() throws SQLException {
		List<Estilo> estilos = new ArrayList<Estilo>();
		this.conecta();

		String sql = "select * from tb_estilo";
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			String estilo = rs.getString("ds_estilo");
			Double valor = rs.getDouble("vl_corte");

			estilos.add(new Estilo(estilo, valor));
		}

		this.desconecta();
		return estilos;
	}

	public void salva(Estilo estilo) throws SQLException {
		this.conecta();

		String sql = String.format("insert into tb_estilo(ds_estilo, vl_corte" + "values(?, ?", estilo.getTipo(),
				estilo.getValor());
		
		Statement stmt = this.conn.createStatement();
		stmt.executeUpdate(sql);
		
		this.desconecta();
	}

	private void desconecta() throws SQLException {
		if (!conn.isClosed())
			conn.close();
	}
}
