<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Switch multi</title>
  <link rel="stylesheet" href="../css/estilo.css">

</head>
<body>
<div>
    <?php
      $cont = 1;

      do {
        echo "Progressiva: $cont <br/>";
        $cont++;
      } while ($cont <= 10);

      echo "<br/>";

      $cont2 = 10;
      do {
        echo "Regressiva: $cont2 <br/>";
        $cont2--;
      } while ($cont2 >= 1);
    ?>
</div>
</body>
</html>
