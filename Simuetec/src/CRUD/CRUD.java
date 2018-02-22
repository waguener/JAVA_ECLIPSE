package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Simuetec.Bean.CadastroBean;
import Simuetec.Bean.LoginBean;
import Simuetec.Bean.PlacarBean;
import Simuetec.Bean.RankingBean;
import Simuetec.Util.Conexao;


public class CRUD {

	
	private String INSERT_CADASTRO = ("INSERT INTO cadastro (nome,senha) values (?,?)");
	
	private String INSERT_LOGIN = ("INSERT INTO Login (nome) values (?)");
	
	private String INSERT_PLACAR = ("INSERT INTO placar (nome,questao,corretas,erradas,sessao) values (?,?,?,?,?)"); 
	
	private String INSERT_RANKING = (" INSERT INTO ranking (nome,total) values (?,?)");
	
	private String SELECT_USUARIO = ("SELECT * FROM cadastro WHERE nome = ? and senha = ? ");
	
	private String SELECT_LOGIN = ("SELECT * FROM Login ORDER BY id ");
	
	private String SELECT_RESULTADO = ("SELECT * from placar where nome = ? and sessao = ?");
	
	private String SELECT_SESSAO = ("SELECT MAX(sessao) FROM placar WHERE nome = ");
	
	private String SELECT_SOMA = ("SELECT SUM(corretas)as soma FROM placar WHERE nome = ? and sessao = ?");
	
	private String SELECT_RANKING = ("SELECT * FROM ranking ORDER BY total DESC ");
	
	private Connection getConexao()  {
		
		Conexao con = new Conexao();
		return con.getConexao();
		
	}
	 public void salvacadastro(CadastroBean bean) throws SQLException{
	        PreparedStatement stmt = getConexao().prepareStatement(INSERT_CADASTRO);
	        
	        
	        stmt.setString(1,bean.getNome());
	        stmt.setString(2, bean.getSenha());
	        stmt.execute();
	        stmt.close();
	
	
}
	 
	 public void salvalogin (LoginBean bean) throws SQLException{
		 PreparedStatement stmt = getConexao().prepareStatement(INSERT_LOGIN);
		 
		
		 stmt.setString(1,bean.getNome());
		 stmt.execute();
		 stmt.close();
	 }
	 
	 public void salvaplacar(PlacarBean bean) throws SQLException{
		 PreparedStatement stmt = getConexao().prepareStatement(INSERT_PLACAR);
		 
		 stmt.setString(1,bean.getNome());
		 stmt.setString(2,bean.getQuestao());
		 stmt.setInt(3,bean.getCorretas());
		 stmt.setInt(4,bean.getErradas());
		 stmt.setInt(5,bean.getSessao());
		 stmt.execute();
		 stmt.close();
	 }
	 
	 public void salvaranking (RankingBean bean) throws SQLException{
		 PreparedStatement stmt = getConexao().prepareStatement(INSERT_RANKING);
		 
		 stmt.setString(1,bean.getNome());
		 stmt.setInt(2,bean.getTotal());
		 stmt.execute();
		 stmt.close();
	 }
	 
	 public boolean BuscaUsuario(String nome, String senha) throws ClassNotFoundException, SQLException {
			PreparedStatement stmt = getConexao().prepareStatement(SELECT_USUARIO);
			stmt.setString(1, nome);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			Boolean teste = null;
			
			if (rs.next()) {
				teste = true;
				stmt.close();
			} else {
				teste = false;
			}

			return teste;
			
		}
	 
	 public String BuscaLogin() throws ClassNotFoundException, SQLException {

			PreparedStatement stmt = getConexao().prepareStatement(SELECT_LOGIN);
			
			ResultSet rs = stmt.executeQuery();
			
			String nome = null;
			
			while (rs.next()) {
				rs.getInt(1);
				nome = rs.getString(2);
				
			}
			return nome;
		}
	 
	 public int BuscaSessao(String nome) throws ClassNotFoundException, SQLException {

			PreparedStatement stmt = getConexao().prepareStatement(SELECT_SESSAO + "'" +nome+ "'");
			
			ResultSet rs = stmt.executeQuery();
			
			int sessao = 0;
			
			while (rs.next()) {
				sessao = rs.getInt(1);
										
			}
			return sessao;
		}
	 
	 public int Total(String nome, int sessao) throws ClassNotFoundException, SQLException {
			PreparedStatement stmt = getConexao().prepareStatement(SELECT_SOMA);
			stmt.setString(1, nome);
			stmt.setInt(2,sessao);;
			
			int result = 0;
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()){
				result = rs.getInt(1);
			}
	 return result;
	 }
	 
	 public List<PlacarBean> Resultado(String nome , int sessao) throws ClassNotFoundException, SQLException {
			List<PlacarBean> list = new ArrayList<>();
			PreparedStatement stmt = getConexao().prepareStatement(SELECT_RESULTADO);
			stmt.setString(1, nome);
			stmt.setInt(2, sessao);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PlacarBean bean = new PlacarBean();
				bean.setId(rs.getInt(1));
				bean.setNome(rs.getString(2));
				bean.setQuestao(rs.getString(3));
				bean.setCorretas(rs.getInt(4));
				bean.setErradas(rs.getInt(5));
				bean.setSessao(rs.getInt(6));
				list.add(bean);
			}

			return list;

		}
	 
	 public List<RankingBean> Ranking() throws ClassNotFoundException, SQLException {
			List<RankingBean> list = new ArrayList<>();
			PreparedStatement stmt = getConexao().prepareStatement(SELECT_RANKING);			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				RankingBean bean = new RankingBean();
				
				bean.setId(rs.getInt(1));
				bean.setNome(rs.getString(2));
				bean.setTotal(rs.getInt(3));
				list.add(bean);
			}

			return list;

		}
	 
}
