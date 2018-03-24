<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="_css/estilo.css"/>
  <meta charset="UTF-8"/>
  <title>Criar caixas de texto randon</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
<div>
    <?php
        $i = 1;
        while ($i <= 5) {
          $v = "num" . $i;
          $url = "v" . $i;
          $$v = $_POST["$url"];//variavel de variavel
          echo  "Valor $i: " .  $$v . "<br/>"  ;
          $i++;
        }
    ?>
</div>
</body>
</html>
