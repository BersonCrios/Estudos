<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="_css/estilo.css"/>
    <meta charset="UTF-8"/>
    <title>Switch multi</title>
    <link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
<div>
    <?php
      $c = 0;
      while ($c <= 10) {
        echo "variavel c incrementando: $c <br/>";
        $c+=1;
      }
     echo "<br/>";
      $c = 10;
      while ($c >= 1) {
        echo "variavel c decrementando: $c <br/>";
        $c-=1;
      }
    ?>
</div>
</body>
</html>
