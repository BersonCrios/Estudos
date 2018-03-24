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

        function soma() {
          $p = func_get_args();
          $t = func_num_args();
          $s = 0;

          for ($i=0; $i < $t ; $i++) {
            $s += $p[$i];
          }
          return $s;
        }

        $r = soma(3,5,5,8,7,5,1,5,9,2,1);

        echo "A soma dos valores é $r";
      ?>
  </div>
</body>

</html>
