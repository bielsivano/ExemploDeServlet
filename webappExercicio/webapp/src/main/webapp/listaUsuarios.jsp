<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listas de Usuários</title>
</head>
<body>
    <h1>Listas de Usuários</h1>

    <h2>Usuários Ativos</h2>
    <ul>
        <c:forEach items="${usuariosAtivos}" var="usuario">
            <li>${usuario}</li>
        </c:forEach>
    </ul>

    <h2>Usuários Inativos</h2>
    <ul>
        <c:forEach items="${usuariosInativos}" var="usuario">
            <li>${usuario}</li>
        </c:forEach>
    </ul>

    <h2>Administradores</h2>
    <ul>
        <c:forEach items="${administradores}" var="usuario">
            <li>${usuario}</li>
        </c:forEach>
    </ul>
</body>
</html>
