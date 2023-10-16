<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="com.jp.senac.model.Aluno" %>
    <%@ page import="com.jp.senac.controle.ConfirmarCadastroServlet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Informações do aluno</title>
</head>
<body>

<%Aluno aluno = (Aluno) request.getAttribute("aluno"); %>

<h2>Aluno Cadastrado</h2>

Nome:<%=aluno.getNome() %>



<p>Matricula: <%=aluno.getMatricula() %></p>


<p>Idade:<%=aluno.getIdade() %></p>



<p>Genero:<%=aluno.getGenero() %></p>



<p>Semestre:<%=aluno.getSemestre() %></p>



<p>Id: <%= Integer.toString(aluno.getId()) %></p>

<input type="button" onclick="javascript:location.href='ListarServlet'" value="Confirmar">
<a href="AlterarServlet?id=<%=aluno.getId()%>">Alterar</a>


</body>
</html>