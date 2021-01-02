<%@page import="java.util.List"%>
<%@page import="edu.cibertec.cursoseguro.dao.entity.CursoEntity"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Mantenimiento de Cursos</title>
    </head>
    <body>
        <h1>Mantenimiento de Cursos</h1>
        <% if (request.getAttribute("lista") != null) { %>
        <br/>
        <div class="table-responsive">
            <table class="table table-responsive table-sm table-light table-striped table-bordered table-hover">
                <thead>
                    <tr class="success">
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Fecha Inicio</th>
                        <th>Minimo alumnos</th>
                        <th>Inscritos</th>
                        <th>Estado</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<CursoEntity> lista = (List<CursoEntity>) request.getAttribute("lista");
for (CursoEntity cursoEntity : lista) {%>
                    <tr>
                        <td><%= cursoEntity.getIdCurso()%></td>
                        <td><%= cursoEntity.getNomCurso()%></td>
                        <td><%= cursoEntity.getFechaInicio()%></td>
                        <td><%= cursoEntity.getAlumnosMin()%></td>
                        <td><%= cursoEntity.getAlumnosAct()%></td>
                        <td><%= cursoEntity.getEstado()%></td>
                        <td><a href="cursoEliminar?codigo=<%= cursoEntity.getIdCurso()%>">SI</a></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <% }%>
        <br/>
        <hr/>
        <div class="container">
            <div class="row d-flex justify-content-center mx-auto">
                <br/>
                <div class="login-form">
                    <h1>Datos del curso a ingresar</h1>
                    <form action="cursoGrabar" method="post">
                        <div class="form-group">
                            <input type="text" name="nomCurso" class="form-control text-box"
                                   placeholder="Nombre Curso" required="true"/>
                        </div>
                        <div class="form-group">
                            <input type="date" name="fechaInicio" class="form-control text-box"
                                   placeholder="Fecha Inicio" required="true"/>
                        </div>
                        <div class="form-group">
                            <input type="number" name="alumnosMin" class="form-control text-box"
                                   placeholder="Mínimo Alumnos" required="true"/>
                        </div>
                        <div class="form-group">
                            <select name="estado" class="form-control text-box"
                                    placeholder="Estado" required="true">
                                <option value="0">CREADO</option>
                                <option value="1">EN PROCESO DE VENTA</option>
                                <option value="2">COMPLETO</option>
                            </select>
                        </div>
                        <input type="submit" value="Grabar" class="btn btn-primary button-submit"/>
                        <a href="cursoListar" class="btn btn-primary button-submit">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>