<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Exercicio</title>
  <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
  <div>
      <?php
        //  o valor passado entro colchete deve ter o mesmo nome que o name do form da pagina formulario.html
        $nome = $_POST["nome"];
        $ano_atual = $_POST["ano_atual"];
        $ano_nasc = $_POST["ano_nasc"];
        $sexo = $_POST["sexo"];

        $idade_atual = $ano_atual - $ano_nasc;

        echo "$nome é $sexo e tem $idade_atual anos";
      ?>
      <br/>
      <a href="form.html">Voltar!</a>
  </div>
</body>
</html>
