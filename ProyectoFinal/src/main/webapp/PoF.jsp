<%-- 
    Document   : PoF
    Created on : Nov 20, 2023, 4:10:49 PM
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
        }

        #contenedor {
            display: flex;
            height: 100vh;
        }

        #imagen {
            flex: 1;
            overflow: hidden;
        }

        #imagen img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        #formulario {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background-color: #f4f4f4;
            position: relative;
        }
        h2{
            color:black;
        }

        #contenedor-recuadro {
            background-color: #fcf9f9;
            color: white;
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            margin-bottom: 20px;
        }

        #recuadro {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
        }

        #mensaje {
            text-align: center;
            color: black;
            font-size: bold;
            font-size: 18px;
            margin-bottom: 20px;
        }

        a.button {
            text-decoration: none;
            margin: 5px;
            padding: 10px 20px;
            border: none;
            background-color: white;
            color: #333;
            font-size: 16px;
            cursor: pointer;
            transition: transform 0.3s ease;
        }

        a.button:hover {
            transform: scale(1.1);
        }

        #registrar {
            margin-top: 20px;
            font-size: 16px;
            color: #333;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div id="contenedor">
        <div id="imagen">
            <img src="Featured-image-Student-Blog-Hospital-Team.jpg" alt="Imagen de fondo">
        </div>
        <div id="formulario">
            <div id="contenedor-recuadro">
                <h2>Bienvenido a la suite de el hospital los Santos</h2>
                <div id="recuadro">
                    <div id="mensaje">¿Cómo desea ingresar?</div>
                    <a href="ISfuncionario.html" class="button">Funcionario</a>
                    <a href="ISpaciente.html" class="button">Paciente</a>
                </div>
                <a href="RegPacientes.jsp" id="registrar">Registrar Paciente</a>
            </div>
        </div>
    </div>
</html>
