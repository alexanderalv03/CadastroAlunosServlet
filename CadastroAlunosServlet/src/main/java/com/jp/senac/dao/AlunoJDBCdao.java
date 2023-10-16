package com.jp.senac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import com.jp.senac.model.Aluno;

public class AlunoJDBCdao {
	
	public Connection getConexao() throws ClassNotFoundException{
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		
		String url = "jdbc:mysql://localhost:3306/cadastroalunos?useTimezone=true&serverTimezone=UTC";
		
		
		String user = "root";
		
		String password = "root";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado ao banco de dados");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return con;
	}
	public ArrayList<Aluno> listarAlunos()throws SQLException{
		ArrayList<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos";
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				alunos.add(new Aluno(id, nome, idade,semestre, genero, matricula));
			}
			rs.close();
			pst.close();
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
			
			
		}
		return alunos;
	}
public Aluno cadastrarAluno (Aluno aluno) {

		

		List<Aluno> alunos = new ArrayList<>();

		String query = "INSERT INTO alunos (nome, idade,semestre,genero,matricula) VALUES(?,?,?,?,?)";

 

		try {

			

			Connection con = getConexao();

			PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			

			pst.setString(1, aluno.getNome());

			pst.setString(2, aluno.getIdade());

			pst.setString(3, aluno.getSemestre());

			pst.setString(4, aluno.getGenero());

			pst.setString(5, aluno.getMatricula());

			

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			while(rs.next()) {

				int id = rs.getInt(1);

				aluno.setId(id);

				

			}

			

		} catch (Exception e) {

			e.printStackTrace();

		}

		

		return aluno;

	}
		public Aluno pesquisarPorID(Integer id) throws SQLException  {
	
	String query = "SELECT * FROM alunos WHERE id = ?";
	Aluno aluno = null;
	try {
		Connection con = getConexao();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,  id);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			
			String nome = rs.getString(2);
			String idade = rs.getString(3);
			String semestre = rs.getString(4);
			String genero = rs.getString(5);
			String matricula = rs.getString(6);
			aluno = new Aluno(id,nome,idade,semestre,genero,matricula);
			
			System.out.println(aluno.getNome());
			
		}

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	
	}
	 return aluno;
}


			public void excluirAluno(Integer id) throws SQLException {
	
	String delete = "DELETE from alunos WHERE (id = ?)";
	
	try {
		Connection con = getConexao();
		PreparedStatement pst = con.prepareStatement(delete);
		pst.setInt(1,  id);
		pst.executeUpdate();
		pst.close(); 
		con.close();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
}
			public Aluno alterarAluno(Aluno aluno) {
				 String update = "UPDATE alunos SET nome = ?, idade = ?, semestre = ?, genero = ?, matricula = ?, WHERE id = ?";
				
				 try {
						Connection con = getConexao();
						PreparedStatement pst = con.prepareStatement(update);
						pst.setString(1, aluno.getNome());
						pst.setString(2, aluno.getIdade());
						pst.setString(3, aluno.getSemestre());
						pst.setString(4, aluno.getGenero());
						pst.setString(5, aluno.getMatricula());
						pst.setInt(6, aluno.getId());
						pst.executeUpdate();
						pst.close();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
				return aluno;
			}
			
			
}
