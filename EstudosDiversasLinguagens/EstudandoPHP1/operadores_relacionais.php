<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Embracando no PHP</title>
  <link rel="stylesheet" href="css/estilo.css">
</head>
<body>
  <div class="">

    <?php
        $a = $_GET["a"];
        $b = $_GET["b"];
        $tipo = $_GET["op"];

        echo "O valores passados foram $a e $b <br/> ";

        $r = ($tipo == "s") ? $a+$b : $a*$b;
        //$variavel = expressao ? verdade : falso

        echo "O resultado será $r";
     ?>
   </div>
</body>
</html>
