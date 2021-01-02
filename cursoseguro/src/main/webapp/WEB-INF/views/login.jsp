<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <style type="text/css">
            .login-form {
                width: 340px;
                margin: 50px auto;
            }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {
                font-size: 15px;
                font-weight: bold;
            }
        </style>
        <title>Ingreso a la aplicación</title>
    </head>
    <body>
    <center><h1>Login personalizado</h1></center>
    <br/>
    <div class="login-form">
        <form name="f" method="post" action="login">
            <div class="form-group">
                <input type="text" name="username" required="true" class="form-control" placeholder="Usuario"/>
            </div>
            <div class="form-group">
                <input type="password" name="password" required="true" class="form-control" placeholder="Clave"/> <br/>
            </div>
            <div class="form-group">
                <input type="submit" name="submit" value="Ingresar" class="btn btn-primary btn-block"/>
            </div>
        </form>
    </div>
    <% if (request.getAttribute("error")!= null && 
    Boolean.parseBoolean(request.getAttribute("error").toString())) { %>
    <div class="alert alert-danger" role="alert">
        Mal ingreso de las credenciales
    </div>
    <% } %>
</body>
</html>