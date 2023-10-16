package com.jp.senac.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AlterarServlet
 */
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
		//recuperando o aluno que tem o nome informado (e que deve ser alterado)
		
		
		try {
			Aluno aluno = dao.pesquisarPorID(id);
			request.setAttribute("aluno", aluno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		    
		    request.getRequestDispatcher("alterarAlunos.jsp").forward(request, response);
		}




}
