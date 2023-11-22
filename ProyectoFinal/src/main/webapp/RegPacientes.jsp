<%-- 
    Document   : RegPacientes
    Created on : Nov 20, 2023, 3:57:13 PM
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
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      background: url('caduceo.webp') no-repeat center center fixed;
      background-size: cover;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    #container {
      background-color: rgba(255, 255, 255, 0.8);
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 350px;
      text-align: center;
      animation: form-animation 0.3s;
      overflow-y: auto;
      max-height: 400px;
    }

    @keyframes form-animation {
      from {
        transform: scale(1);
      }
      to {
        transform: scale(0.95);
      }
    }

    label {
      display: block;
      margin: 10px 0 5px;
      font-weight: bold;
    }

    input, select {
      width: calc(100% - 20px);
      padding: 8px;
      margin-bottom: 10px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
      transition: border-color 0.3s, transform 0.3s;
      display: inline-block;
      position: relative;
    }

    input:focus, select:focus {
      border-color: dodgerblue;
      outline: none;
      transform: scale(1.02);
    }

    .error-symbol {
      color: red;
      font-size: 18px;
      position: absolute;
      top: 8px;
      right: 8px;
      cursor: pointer;
      display: none;
    }

    .required {
      color: black;
    }

    button {
      background-color: dodgerblue;
      color: #fff;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      margin-top: 10px;
      display: inline-block;
    }

    button:hover {
      background-color: #007bb5;
    }

    .password-container {
      position: relative;
    }

    .password-icon {
      position: absolute;
      top: 50%;
      right: 8px;
      transform: translateY(-50%);
      cursor: pointer;
    }

    .hidden {
      display: none;
    }

    .checkbox-container {
      text-align: left;
      margin-top: 10px;
    }

    .checkbox-label {
      display: inline-block;
      margin-left: 5px;
    }

    #titulo {
      text-align: center;
      font-weight: bold;
      font-size: 24px;
      margin-bottom: 20px;
    }
  </style>
  <script>
    function togglePassword() {
      const passwordInput = document.getElementById('password');

      if (passwordInput.type === 'password') {
        passwordInput.type = 'text';
      } else {
        passwordInput.type = 'password';
      }
    }

    function toggleOtherInput() {
      const otherInput = document.getElementById('otro-genero');
      const generoSelect = document.getElementById('genero');
      const errorSymbolConfirmar = document.getElementById('error-symbol-confirmar');

      if (generoSelect.value === 'otros') {
        otherInput.classList.remove('hidden');
        errorSymbolConfirmar.style.display = 'none';
      } else {
        otherInput.classList.add('hidden');
        validateFields(); // Llama a validateFields para actualizar el estado del botón
      }
    }

    function validateFields() {
      var nombre = document.getElementById('nombre').value;
      var apellido = document.getElementById('apellido').value;
      var edad = document.getElementById('edad').value;
      var correo = document.getElementById('correo').value;
      var usuario = document.getElementById('usuario').value;
      var password = document.getElementById('password').value;
      var confirmarPassword = document.getElementById('confirmar-password').value;
      var genero = document.getElementById('genero').value;
      var aceptaTerminos = document.getElementById('acepta-terminos').checked;
      const errorSymbol = document.getElementById('error-symbol');
      const errorSymbolConfirmar = document.getElementById('error-symbol-confirmar');

      // Validar que todos los campos estén completos
      var todosCompletos = nombre && apellido && edad && correo && usuario && password && confirmarPassword && genero && aceptaTerminos;

      // Habilitar o deshabilitar el botón según el estado de los campos
      document.getElementById('submit-btn').disabled = !todosCompletos;

      // Mostrar o ocultar el símbolo de error
      errorSymbol.style.display = todosCompletos ? 'none' : 'block';

      // Mostrar o ocultar el símbolo de error en Confirmar Contraseña
      errorSymbolConfirmar.style.display = password === confirmarPassword ? 'none' : 'block';
    }
  </script>
</head>
<body>
  <form id="container" name="registro" action="CrearPaciente" method="post">
    <div id="titulo">REGISTRO</div>

    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" oninput="validateFields()" required>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="apellido">Apellido:</label>
    <input type="text" id="apellido" name="apellido" oninput="validateFields()" required>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="edad">Edad:</label>
    <input type="number" id="edad" name="edad" min="0" oninput="validateFields()" required>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="correo">Correo:</label>
    <input type="email" id="correo" name="correo" oninput="validateFields()" required>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="usuario">Usuario:</label>
    <input type="text" id="usuario" name="usuario" oninput="validateFields()" required>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="password" class="required">Contraseña:</label>
    <div class="password-container">
      <input type="password" id="password" name="password" oninput="validateFields()" required>
      <img src="https://img.icons8.com/material-outlined/24/000000/invisible.png" class="password-icon" onclick="togglePassword()" alt="Toggle Password Visibility">
    </div>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="confirmar-password" class="required">Confirmar Contraseña:</label>
    <div class="password-container">
      <input type="password" id="confirmar-password" name="confirmar-password" oninput="validateFields()" required>
      <div class="error-symbol" id="error-symbol-confirmar">!</div>
    </div>

    <label for="genero">Género:</label>
    <select id="genero" name="genero" onchange="toggleOtherInput()" required>
      <option value="hombre">Hombre</option>
      <option value="mujer">Mujer</option>
      <option value="otros">Otros</option>
    </select>
    <div class="error-symbol" id="error-symbol">!</div>

    <label for="otro-genero" class="hidden">Digite aquí en caso de seleccionar otros:</label>
    <input type="text" id="otro-genero" name="otro-genero" class="hidden" oninput="validateFields()">
    <div class="error-symbol" id="error-symbol">!</div>

    <div class="checkbox-container">
      <input type="checkbox" id="acepta-terminos" name="acepta-terminos" onchange="validateFields()" required>
      <label class="checkbox-label" for="acepta-terminos"><a href="TyC.html" target="_blank">Acepta los términos y condiciones</a></label>
    </div>
    <div class="error-symbol" id="error-symbol">!</div>

    <button type="submit" id="submit-btn" name="submit-btn" disabled>Registrarse</button>
  </form>
</html>
