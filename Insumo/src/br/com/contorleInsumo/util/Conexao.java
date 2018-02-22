package br.com.contorleInsumo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	 private static Connection conexao;

	    /**
	     *
	     */
	    public Conexao(){ 
			      try {
	                  	
			Class.forName("org.sqlite.JDBC");
					
			String url = "jdbc:sqlite://C:/DB/insumo.db";
					
			conexao = DriverManager.getConnection(url);
			
				System.out.println("Conex�o OK "+conexao);
	               }
	        catch(ClassNotFoundException | SQLException erro){
	            JOptionPane.showMessageDialog(null,
	          "Ocorreu um erro de conex�o. Verifique a Base de Dados indicada !"+"\n" +  erro.getMessage(),"Conex�o",3);
	            System.out.println(conexao);
	        }
	    

	    
	    }
	    // Mtodos pblicos:
	    public Connection getConexao()
	    {
	        return conexao;
	       
	    }
		}

