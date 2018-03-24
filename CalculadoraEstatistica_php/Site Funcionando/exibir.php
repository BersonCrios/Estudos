<?php
//variaveis de controle
$i;
$pagina = 'grafico.php';

//pagina dedicada apenas a exibição
require_once 'validacao.php';
require_once 'media.php';
require_once 'rol.php';
require_once 'frequencia.php';
require_once 'separatrizes.php';

//recebendo dados gerais
$dados_brutos = $_SESSION['dados_brutos'];
$total_num = $_SESSION['total_num'];
$media = $_SESSION['media'];
$mediana1 = $_SESSION['mediana1'];
$mediana2 = $_SESSION['mediana2'];
$moda = $_SESSION['moda'];
$rol = $_SESSION['rol'];
$k = $_SESSION['classes'];
$inter = $_SESSION['intervalos'];
$fi = $_SESSION['frequencia'];
$fiac = $_SESSION['frequeac'];
$xi = $_SESSION['porcent'];
$xiac = $_SESSION['porcac'];
$quartil = $_SESSION['quartil'] ;
$kintil = $_SESSION['kintil'] ;
$decil = $_SESSION['decil'] ;

//exibindo dados brutos
echo "<b>Dados Brutos</b>";
echo "<br>";
for($i = 1; $i <= $total_num; $i++ )
{
	if($i == $total_num)
		echo $dados_brutos[$i];
	else
		echo $dados_brutos[$i].", ";
}
echo "<br>";
	
//exibindo total de numeros	
echo "<b>Total de números</b> ";
echo "<br>";
echo $total_num;
echo "<br>";

//exibindo media
echo "<b>Média</b>";
echo "<br>";
echo $media;
echo "<br>";

//exibindo moda
echo "<b>Moda</b>";
echo "<br>";
echo $moda;
echo "<br>";

//exibindo mediana
echo "<b>Mediana</b>";
echo "<br>";
for($i = 1; $i <= $total_num; $i++)
{
	if($i == $mediana1)
		echo $dados_brutos[$i]." (posição ".$mediana1.")";
	else
	if($i == $mediana2)// em caso de total de numeros pares ele mostrara a seguna mediana
		echo " e ".$dados_brutos[$i]." (posição ".$mediana2.")";
}
echo "<br>";

//exibindo rol
echo "<b>Rol</b>";
echo "<br>";
for($i = 0; $i < $total_num; $i++ )
{
	if($i == ($total_num-1))
		echo $rol[$i];
	else
		echo $rol[$i].", ";
}
echo "<br>";

//exibindo medidas separatrizes
echo "<b>Quartil</b>";
echo "<br>";
echo "<table border='1'>";
echo "<tr><td><b>Posição</b></td><td><b>Numero</b></td></tr>";
for($i=1;$i<4;$i++)
	echo "<tr><td> Q".$i."</td><td>".$quartil[$i]."</td></tr>";
echo "</table>";
echo "<br>";
#
echo "<b>Quintil</b>";
echo "<br>";
echo "<table border='1'>";
echo "<tr><td><b>Posição</b></td><td><b>Numero</b></td></tr>";
for($i=1;$i<5;$i++)
	echo "<tr><td> K".$i."</td><td>".$kintil[$i]."</td></tr>";
echo "</table>";
echo "<br>";
#
echo "<b>Decil</b></br> ";
echo "<table border='1'>";
echo "<tr><td><b>Posição</b></td><td><b>Numero</b></td></tr>";
for($i=1;$i<10;$i++)	
	echo "<tr><td> D".$i."</td><td>".$decil[$i]."</td></tr>";
echo "</table>";
echo "<br>";

//exibindo tabela de frequencias
echo "<b>Tabela</b></br> ";
echo "<table border='1'>";
echo "<tr><td><b>Classe</b></td><td><b>Intervalo</b></td><td><b>Fi</b></td><td><b>Fi(Ac)</b></td><td><b>Xi</b></td><td><b>Xi(Ac)</b></td></tr>";
for($i=1;$i<=$k;$i++)
{
	echo "<tr>";
	echo "<td>".$i."</td>";
	if($i == $k)
		echo "<td>".$inter[$i-1]." |---| ".$inter[$i]."</td>";
	else
		echo "<td>".$inter[$i-1]." |---- ".$inter[$i]."</td>";
	echo "<td>".$fi[$i]."</td><td>".$fiac[$i]."</td>";
	echo "<td>".$xi[$i]."</td><td>".$xiac[$i]."</td></tr>";
}
echo "</table>";
echo "<br>";

//exibindo graficoecho 
echo "<b>Grafico</b>";
echo "<br>";
echo "<IMG SRC= ".$pagina." BORDER=0>";
?>