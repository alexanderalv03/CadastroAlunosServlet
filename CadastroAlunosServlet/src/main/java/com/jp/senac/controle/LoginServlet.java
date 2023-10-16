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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		 HttpSession session = request.getSession(true); // Obter ou criar a sessão

	        // Verificar se a sessão existe e se o usuário está inativo há mais de 5 minutos
	        if (session.getAttribute("lastAccessTime") != null) {
	            long lastAccessTime = (Long) session.getAttribute("lastAccessTime");
	            long currentTime = System.currentTimeMillis();
	            long inactiveTime = currentTime - lastAccessTime;

	            if (inactiveTime > 5 * 60 * 1000) { // 5 minutos em milissegundos
	                session.invalidate(); // Invalida a sessão se inativo por mais de 5 minutos
	                response.sendRedirect("index.jsp"); // Redireciona para a página de login
	                return;
	            }
	        }

	        // Atualizar o tempo de último acesso
	        session.setAttribute("lastAccessTime", System.currentTimeMillis());

		if(usuario.equals("admin") && senha.equals("admin")) {
			
			session.setAttribute("usuario", usuario);
			
			AlunoJDBCdao dao = new AlunoJDBCdao();
			
			
			try {
			List<Aluno> listaAlunos = dao.listarAlunos();
			request.setAttribute("listaAlunos", listaAlunos);
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("listarAlunos.jsp").forward(request, response); 
		}else {
			request.setAttribute("mensagem", "usuario ou senha invalidos");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
