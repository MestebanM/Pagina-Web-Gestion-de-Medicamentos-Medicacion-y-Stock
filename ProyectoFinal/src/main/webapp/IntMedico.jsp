<%-- 
    Document   : IntMedico
    Created on : Nov 22, 2023, 1:59:18 AM
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
            font-family: Arial, sans-serif;
        }

        #container {
            display: flex;
            height: 100vh;
        }

        #sidebar {
            width: 200px;
            background-color: #1a237e; /* Azul oscuro */
            color: white;
            padding: 20px;
            box-sizing: border-box;
        }

        #content {
            flex: 1;
            padding: 20px;
            box-sizing: border-box;
        }

        .button {
            display: block;
            margin-bottom: 10px;
            padding: 10px;
            background-color: #3f51b5; /* Azul */
            color: white;
            border: none;
            cursor: pointer;
            width: calc(100% - 20px); /* Toma el 100% del ancho menos el espacio de relleno */
            text-align: left;
        }

        .button:hover {
            background-color: #303f9f; /* Azul más oscuro al pasar el mouse */
        }

        #searchBar button,
        #medicationForm button {
            width: auto; /* Ancho automático para los botones en los formularios */
        }

        #searchBar,
        #medicationForm,
        #historyContent {
            display: none;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4caf50; /* Verde */
            color: white;
        }
    </style>
</head>
<body>
    <div id="container">
        <div id="sidebar">
            <p>Usuario: NombreUsuario</p>
            <p>Doctor: Dr. General</p>
            <button class="button" id="buscarBtn">Buscar Paciente</button>
            <button class="button" id="medicacionBtn">Generar Medicación</button>
            <button class="button" id="historiaBtn">Revisar Historia Clínica</button>
        </div>
        <div id="content">
            <h2 id="contentTitle"></h2>
            <div id="searchBar">
                <input type="text" placeholder="Nombre del paciente">
                <button class="button" id="buscarPacienteBtn">Buscar</button>
            </div>
            <form id="medicationForm" action="GenerarOrden" method="post">
                <input type="text" placeholder="Nombre del medicamento" name="nombre">
                <input type="text" placeholder="Dosis" name="stock">
                <input type="text" placeholder="Numero" name="numero">
                <button class="submit" id="agregarMedicamentoBtn">Agregar</button>
                
            </form>
            <div id="historyContent">
                <button class="button" id="verHistoriaBtn">Ver Historia Clínica</button>
                <table id="historiaTable">
                    <thead>
                        <tr>
                            <th>Fecha</th>
                            <th>Descripción</th>
                            <th>Resultado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>2023-01-01</td>
                            <td>Consulta inicial</td>
                            <td>Normal</td>
                        </tr>
                        <tr>
                            <td>2023-02-15</td>
                            <td>Pruebas de laboratorio</td>
                            <td>Anormal</td>
                        </tr>
                        <!-- Agrega más filas según sea necesario -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Asociar manejadores de eventos a los botones
            document.getElementById('buscarBtn').addEventListener('click', function () {
                showContent('buscar');
            });
            document.getElementById('medicacionBtn').addEventListener('click', function () {
                showContent('medicacion');
            });
            document.getElementById('historiaBtn').addEventListener('click', function () {
                showContent('historia');
            });

            document.getElementById('buscarPacienteBtn').addEventListener('click', function () {
                buscarPaciente();
            });

            document.getElementById('agregarMedicamentoBtn').addEventListener('click', function () {
                agregarMedicamento();
            });

            document.getElementById('verHistoriaBtn').addEventListener('click', function () {
                verHistoriaClinica();
            });
        });

        function showContent(option) {
            // Ocultar todos los contenidos
            document.getElementById('searchBar').style.display = 'none';
            document.getElementById('medicationForm').style.display = 'none';
            document.getElementById('historyContent').style.display = 'none';

            // Mostrar el contenido correspondiente al botón clickeado
            switch (option) {
                case 'buscar':
                    document.getElementById('contentTitle').innerText = 'Buscar Paciente';
                    document.getElementById('searchBar').style.display = 'block';
                    break;
                case 'medicacion':
                    document.getElementById('contentTitle').innerText = 'Generar Medicación';
                    document.getElementById('medicationForm').style.display = 'block';
                    break;
                case 'historia':
                    document.getElementById('contentTitle').innerText = 'Revisar Historia Clínica';
                    document.getElementById('historyContent').style.display = 'block';
                    break;
            }
        }

        function buscarPaciente() {
            // Lógica de búsqueda de paciente...
        }

        function agregarMedicamento() {
            // Lógica para agregar medicamento a la tabla...
        }

        function verHistoriaClinica() {
            // Lógica para ver la historia clínica...
        }
    </script>
</body>
</html>