<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>FORM</title>
  <link rel="stylesheet" href="../css/estilo.css">
</head>
</head>

<body>
  <div>
    <?php
      //"v" deve ter o mesmo nome que o name do form da pagina formulario.html
      $valor = $_POST["v"];
      $rq = sqrt($valor);
      echo "A raiz de $valor é igual a " . number_format($rq,2);
    ?>

    <a href="formulario.html"><br/>Voltar</a>
  </div>
</body>

</html>
