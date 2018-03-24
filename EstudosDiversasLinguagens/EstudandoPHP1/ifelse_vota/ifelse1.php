<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>IF E ELSE I</title>
    <link rel="stylesheet" href="../css/estilo.css">
</head>
<body>
    <div>
        <?php
        $ano = $_POST["ano"];
        //date("Y") indica o ano atual
        $idade = date("Y") - $ano ;
        echo "Você nasceu em $ano e tem $idade <br/>";

        if ($idade < 16) {
          $voto = "não vota";
        }
        elseif ($idade >= 16 && $idade < 18) {
            $voto = "voto opcional";
        }
        elseif ($idade > 65){
            $voto = "voto opcional";
        }
        else{
            $voto = "voto obrigatorio";
        }

        echo "Para essa idade, $voto ";

        ?>
    </div>
</body>
</html>
