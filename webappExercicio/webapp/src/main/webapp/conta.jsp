<%@ page language="java" contentType="text/html; charset=UTF-8 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contas_Bancárias</title>
</head>
<body>
    <h1>Contas Bancárias</h1>

    <form action="ContaBancariaServlet" method="get">
        <input type="hidden" name="action" value="criar">

        Número da Conta: <input type="text" name="numeroConta">
        <br>
        Saldo Inicial: <input type="text" name="saldoInicial">
        <br>
        <input type="submit" value="Criar Conta">
    </form>

    <form action="ContaBancariaServlet" method="get">
        <input type="hidden" name="action" value="visualizar">

        Número da Conta: <input type="text" name="numeroConta">
        <br>
        <input type="submit" value="Visualizar Conta">
    </form>

    <form action="ContaBancariaServlet" method="get">
        <input type="hidden" name="action" value="atualizar">

        Número da Conta: <input type="text" name="numeroConta">
        <br>
        Valor a Depositar: <input type="text" name="valor">
        <br>
        <input type="submit" value="Depositar">
    </form>

    <h2>Resultado:</h2>
    <p>
        <%= request.getAttribute("resultado") %>
    </p>
</body>
</html>
