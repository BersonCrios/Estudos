<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Passagem por Referencia</title>
  <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
  <div>
      <?php
        require "funcoes.php";
        //include "funcoes.php"
        echo "<h1>Testando novas funções. . .  </h1>";
        ola();
        mostraValor(4);

        echo "<h2>Finalizando Programa!</h2>";
      ?>
  </div>
</body>
</html>
