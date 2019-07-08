package catalogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	String database = "jdbc:mysql://localhost:3306/miguelDB";
	String user = "root";
	String pass = "****";
	
	public DAO() {	
	}
	
	public void insertInto(boolean act, String tit, String nom, String niv, int hor) throws SQLException {
		Connection c = DriverManager.getConnection(database, user, pass);
		String sql = "insert into Curso values(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setBoolean(1, act);
		ps.setString(2, tit);
		ps.setString(3, nom);
		ps.setString(4, niv);
		ps.setInt(5, hor);
		ps.execute();
		ps.close();
		c.close();
	}
		
	public ArrayList<Curso> selectFrom() throws SQLException {
		ArrayList<Curso> catalogo = new ArrayList<Curso>();
		Connection c = DriverManager.getConnection(database, user, pass);
		String sql = "select * from Curso";
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while (rs.next()) {
			Curso oc = new Curso(rs.getBoolean(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
			catalogo.add(oc);
		}	
		rs.close();
		s.close();
		c.close();
		return catalogo;
	}
}
