<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Fatorial</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
    <div>
        <?php
          $v =  $_POST["val"];
          echo "<h1> Calculando o fatorial de $v</h1>";
          $c = $v;
          $fat = 1;

          do {
            $fat = $fat*$c;
            $c--;
          } while ($c >= 1);
          echo "<h2>$v != $fat</h2>";
        ?>
    </div>
</body>
</html>
