<!DOCTYPE html>
<html>

<head>
  <link rel="stylesheet" href="_css/estilo.css" />
  <meta charset="UTF-8" />
  <title>Soma</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>

<body>
  <div>
      <?php

        function soma($a,$b){
          $s = $a+$b;
          return $s;
        }

        $x = $_POST["val1"];
        $y = $_POST["val2"];

      $resultado = soma($x,$y);

      echo "A soma entre $x e $y é $resultado";
      ?>
  </div>
</body>

</html>
