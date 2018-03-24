<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <title>Soma</title>
  <link rel="stylesheet" href="css/estilo.css">

</head>

<body>
  <div>
      <?php
        function soma($a,$b){
          $s = $a+$b;
          echo "$s";
        }
        soma(4,8);

      ?>
  </div>
</body>

</html>
