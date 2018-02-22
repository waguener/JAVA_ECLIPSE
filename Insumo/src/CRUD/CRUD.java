package CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.contorleInsumo.util.Conexao;
import br.com.controleInsumo.Bean.insumoBean;
import br.com.controleInsumo.Bean.movInsumoBean;

public class CRUD {

	private Connection getConexao() {

		Conexao con = new Conexao();

		return con.getConexao();

	}

	private String INSERT_INSUMO = ("INSERT INTO insumo (insumo,tipo,impressora,modelo,status,data) values (?,?,?,?,?,?)");
	
	private String INSERT_MOVINSUMO = ("INSERT INTO movinsumo (insumo,setor,tipo,modelo,data,hora,status) values (?,?,?,?,?,?,?)");

	private String SELECT_MAXINSUMO = ("SELECT MAX(insumo) FROM insumo");

	private String SELECT_INSUMO = ("SELECT * FROM insumo WHERE status = ? ORDER BY insumo ");

	private String SELECT_INSUMOEMUSO = ("SELECT * FROM insumo WHERE status = ? ORDER BY insumo");
	
	private String SELECT_MOVINSUMO = ("select insumo,setor,tipo,modelo,data,hora,status, round(julianday() - julianday('data'),0) as QtdDia from movinsumo where status= ? order by insumo DES");

	private String UPDATE_INSUMOEMUSO = (" UPDATE insumo SET status = ? where insumo = ?");
	
	private String DELETE_INSUMO = ("DELETE FROM insumo WHERE insumo = ");
	
	private String DELETE_MOVINSUMO = ("DELETE FROM movinsumo WHERE insumo = ");

	
	
	
	public void salvarInsumo(insumoBean bean) throws Exception, ClassNotFoundException, ParseException {

		PreparedStatement stmt = getConexao().prepareStatement(INSERT_INSUMO);

		stmt.setInt(1, bean.getInsumo());
		stmt.setString(2, bean.getTipo());
		stmt.setString(3, bean.getImpressora());
		stmt.setString(4, bean.getModelo());
		stmt.setString(5, bean.getStatus());
		stmt.setString(6, bean.getData());
		stmt.execute();
		stmt.close();
	}
	
	public void salvarMovinsumo (movInsumoBean bean) throws Exception, ClassNotFoundException, ParseException{
		
		PreparedStatement stmt = getConexao().prepareStatement(INSERT_MOVINSUMO);
		
		stmt.setInt(1,bean.getInsumo());
		stmt.setString(2,bean.getSetor());
		stmt.setString(3,bean.getTipo());
		stmt.setString(4,bean.getModelo());
		stmt.setString(5,bean.getData());
		stmt.setString(6,bean.getHora());
		stmt.setString(7,bean.getStatus());
		stmt.execute();
		stmt.close();
	}

	public int maxInsumo() throws ClassNotFoundException, SQLException {

		PreparedStatement stmt = getConexao().prepareStatement(SELECT_MAXINSUMO);

		ResultSet rs = stmt.executeQuery();

		int insumo = 0;

		while (rs.next()) {
			insumo = rs.getInt(1);
		}
		rs.close();
		return insumo;

	}

	public List<insumoBean> totalInsumo(String model) throws ClassNotFoundException, SQLException {
		List<insumoBean> list = new ArrayList<>();
		PreparedStatement stmt = getConexao().prepareStatement(SELECT_INSUMO );
		stmt.setString(1,model);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			insumoBean bean = new insumoBean();
			bean.setId(rs.getInt(1));
			bean.setInsumo(rs.getInt(2));
			bean.setTipo(rs.getString(3));
			bean.setImpressora(rs.getString(4));
			bean.setModelo(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setData(rs.getString(7));
			list.add(bean);

		}
		rs.close();
		return list;

	}

	public List<insumoBean> insumoEmuso(String model) throws ClassNotFoundException, SQLException {
		List<insumoBean> list = new ArrayList<>();
		PreparedStatement stmt = getConexao().prepareStatement(SELECT_INSUMOEMUSO );
		stmt.setString(1, model);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			insumoBean bean = new insumoBean();
			
			bean.setId(rs.getInt(1));
			bean.setInsumo(rs.getInt(2));
			bean.setTipo(rs.getString(3));
			bean.setImpressora(rs.getString(4));
			bean.setModelo(rs.getString(5));
			bean.setStatus(rs.getString(6));
			bean.setData(rs.getString(7));
			list.add(bean);

		}
		rs.close();
		return list;

	}

	public void atualizaInsumoemuso(insumoBean bean) throws SQLException, ClassNotFoundException, ParseException{
		
		PreparedStatement stmt = getConexao().prepareStatement(UPDATE_INSUMOEMUSO);
		
		stmt.setString(1,bean.getStatus());
		stmt.setInt(2,bean.getInsumo());
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	public void excluirInsumo(int model) throws ClassNotFoundException, SQLException {

		PreparedStatement stmt = getConexao().prepareStatement(DELETE_INSUMO + "'" + model + "'");
		stmt.execute();

		stmt.close();
	}
	
	public void excluirMovInsumo(int model) throws ClassNotFoundException, SQLException {

		PreparedStatement stmt = getConexao().prepareStatement(DELETE_MOVINSUMO + "'" + model + "'");
		stmt.execute();

		stmt.close();
	}
	
}
