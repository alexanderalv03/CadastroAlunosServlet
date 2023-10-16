package com.jp.senac.controle;

import java.io.IOException;

import com.jp.senac.dao.AlunoJDBCdao;
import com.jp.senac.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfirmarAlteracao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		String matricula = request.getParameter("matricula");
		
		
		Aluno aluno = new Aluno(id, nome, idade, semestre, genero, matricula);
		AlunoJDBCdao dao = new AlunoJDBCdao();
		dao.alterarAluno(aluno);
		
		
		request.getRequestDispatcher("ListarServlet").forward(request, response);
		
		
	}

}
