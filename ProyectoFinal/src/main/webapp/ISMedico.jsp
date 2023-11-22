<%-- 
    Document   : ISMedico
    Created on : Nov 22, 2023, 1:54:08 AM
    Author     : LEIDY GIRALDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<style>
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      display: flex;
      height: 100vh;
    }

    #imagen-container {
      flex: 1;
      background: url('hospitallossantos.webp') center/cover no-repeat; /* Reemplaza 'tu-imagen.jpg' con la URL de tu imagen */
      display: flex;
      align-items: center;
      justify-content: center;
      overflow: hidden;
    }

    #form-container {
      flex: 1;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      background-color: #f0f0f0; /* Color de fondo para el lado del formulario */
      transition: transform 0.3s ease-in-out;
    }

    #form-container.active {
      transform: translateX(0%);
    }

    #login-form {
      max-width: 300px;
      text-align: center;
      padding: 20px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      background-color: white;
    }

    #login-form input {
      width: 100%;
      padding: 10px;
      margin: 8px 0;
      box-sizing: border-box;
      transition: all 0.3s;
      font-size: 16px;
    }

    #login-form input:focus {
      border: 2px solid dodgerblue;
      transform: translateY(-5px);
      font-size: 14px;
    }

    #login-form button {
      width: 100%;
      padding: 10px;
      background-color: dodgerblue;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    #signup-link {
      margin-top: 10px;
      text-align: center;
    }
  </style>
</head>
<body>

  <div id="imagen-container"></div>

  <form id="form-container" action="LoginFuncionario" method="post">
    <div id="login-form">
      <h2>Iniciar Sesión</h2>
      <!-- Campos de inicio de sesión -->
      <input type="text" id="usuario" name="Usuario" oninput="validateFields()" required>
      <input type="password" id="password" name="password" oninput="validateFields()">
      <button type="submit" >Iniciar Sesión</button>
      <div id="signup-link">
        ¿Olvido su Contraseña? <a href="#">Cambie su Contraseña</a>
      </div>
    </div>
  </form>

</body>
</html>