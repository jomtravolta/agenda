<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Contato</title>

<link rel="stylesheet" type="text/css" href="view/css/estilo.css" />
<link rel="stylesheet" type="text/css"
	href="view/bootstrap/css/bootstrap.min.css" />

<script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>

<body id="corpoPadrao">

	<div align="center">

		<div align="left" style="color: #6E6E6E; width: 70%; margin-top: 4%;">

			<c:if test="${msg ne null}">
				<div class="alert alert-error" style="width: 70%;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					${msg}
				</div>
			</c:if>

			<hr />
			<p>
			<table style="width: 100%">
				<tr>
					<td style="float: left; font-size: 24px;">Inclusão de <strong>Contato</strong>
					</td>
					<td style="float: right;"><a href="listarProduto"
						class="btn btn-primary" role="button">Lista de Contato</a></td>
				</tr>
			</table>
			</p>

			<hr />

			<form action="salvarContato" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="inputNome">Nome</label> <input type="text"
						id="inputNome" class="form-control" name="nome"
						style="width: 500px;" placeholder="Nome" minlength="3"
						maxlength="50" required="required" />
				</div>
				<div class="form-group">
					<label for="inputTelefone">Telefone</label> <input type="text"
						id="inputTelefone" class="form-control" name="telefone"
						style="width: 500px;" placeholder="Telefone" maxlength="11"
						required="required" />
				</div>
				<div class="form-group">
					<label for="inputEndereco">Endereço</label> <input type="text"
						id="inputEndereco" class="form-control" name="endereco"
						style="width: 500px;" required="required" maxlength="100" />
				</div>
				<div class="form-group">
					<label for="inputEmail">E-mail</label> <input type="text"
						id="inputEmail" class="form-control" name="email"
						style="width: 500px;" required="required" maxlength="50" />
				</div>
				<div class="form-group">
					<label for="inputFoto">Foto</label> <input type="file"
						id="inputFoto" class="form-control" name="foto"
						style="width: 500px;" required="required" />
				</div>
				<p>
					<a href="exibirIndex" class="btn btn-danger" role="button">Cancelar</a>
					&nbsp;
					<button type="reset" class="btn btn-default">&nbsp; Limpar
						&nbsp;</button>
					&nbsp;
					<button type="submit" value="salvar" class="btn btn-primary">&nbsp;
						salvar &nbsp;</button>
				</p>
			</form>
		</div>

	</div>

	<br />

	<hr class="linhaSeparador">
	<div class="textoRodape"></div>
</body>
</html>
