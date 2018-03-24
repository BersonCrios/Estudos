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
  <div>

    <?php
    $idade = 20;
    $no = "Guilherme";
    $sn = "Berson";

    echo "O" . " " . $no ." ". $sn . " tem " . $idade . " anos <br/><br/>";
    //o "." é comparado ao "+" do java

    echo "O $no $sn tem  $idade anos <br/>";

     ?>
   </div>
</body>
</html>
