<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.jp.senac.model.Aluno" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Aluno</title>
</head>
<body>
<%Aluno aluno = (Aluno) request.getAttribute("aluno"); %>

<%if (aluno==null){%>
	<% response.sendRedirect("index.jsp");%>
	
 

<% }%>


<h2>Alterar Aluno:</h2>


<form action="ConfirmarAlteracao" method="post">

<input type="hidden" name="id" value="<%=aluno.getId() %>">
<input type="hidden" nam e="matricula" value="<%=aluno.getMatricula() %>">


Nome:
<input type="text" name="nome" value="<%=aluno.getNome() %>">
Idade:
<input type="text" name="idade" value="<%=aluno.getIdade() %>">

Semestre:

<select name="semestre">
	<option value="primeiro" <%=aluno.getSemestre().equals("Primeiro")? "selected" : "" %>>Primeiro</option>
	<option value="segundo" <%=aluno.getSemestre().equals("Segundo")? "selected" : "" %>>Segundo</option>
	<option value="terceiro" <%=aluno.getSemestre().equals("Terceiro")? "selected" : "" %>>Terceiro</option>
	<option value="quarto" <%=aluno.getSemestre().equals("quarto")? "selected" : "" %>>Quarto</option>

</select>


Genero:


	<input type="radio" name="genero" value="Masculino" <%=aluno.getGenero().equals("Masculino") ? "checked" : "" %>>Masculino



	<input type="radio" name="genero" value="Feminino" <%=aluno.getGenero().equals("Feminino") ? "checked" : "" %>>Feminino

	<br><br>
<input type="submit" value="Confirmar Alteração">
<a href="ListarAlunos.jsp">Voltar</a>

</form>
</body>
</html>