<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Passagem por Valor</title>
  <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
  <div>
      <?php
        function teste($x){
          $x += 2;
          echo "O valor de x é $x <br/>";
        }
        $a = 3;
        teste($a);
        echo "Valor de A é $a <br/>";
      ?>
      <br/>
  </div>
</body>
</html>
