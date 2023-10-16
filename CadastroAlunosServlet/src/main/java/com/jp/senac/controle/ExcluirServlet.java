package com.jp.senac.controle;

import java.io.IOException;

import com.jp.senac.dao.AlunoJDBCdao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		AlunoJDBCdao dao = new AlunoJDBCdao();		
		try {
			dao.excluirAluno(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//session.setAttribute("listaAlunos", listaAlunos);
		request.getRequestDispatcher("ListarServlet").forward(request, response);
		}


}
