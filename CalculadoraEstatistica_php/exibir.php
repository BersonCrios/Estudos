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
require_once 'medias_dispersao.php';
require_once 'medidas_assimetria.php';
require_once 'cont.php';

//recebendo dados gerais
$autor = $_SESSION['autor'];
$objetivo = $_SESSION['objetivo'];
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
$dms = $_SESSION['dms'];
$amplitude_total = $_SESSION['amplitude_total'];
$variança = $_SESSION['variança'];
$desvio_p =	$_SESSION['desvio_p'];
$As = $_SESSION['As'];
$Ku = $_SESSION['Ku'];
$ids = $_SESSION['ids'];

require_once 'salvar.php';



//exibindo dados brutos
echo "<fon><b>Dados Brutos</b>";
echo "<br>";
for($i = 1; $i <= $total_num; $i++ )
{
	if($i == $total_num)
		echo $dados_brutos[$i];
	else
		echo $dados_brutos[$i]."; ";
}
echo "<br><br>";
	
//exibindo rol
echo "<b>Dados em roll</b>";
echo "<br>";
for($i = 0; $i < $total_num; $i++ )
{
	if($i == ($total_num-1))
		echo $rol[$i];
	else
		echo $rol[$i]."; ";
}
echo "<br><br>";


//exibindo total de numeros	
echo "<b>Total de números</b> ";
echo "<br>";
echo $total_num;
echo "<br><br>";

//exibindo media
echo "<b>Média</b>";
echo "<br>";
echo $media;
echo "<br><br>";

//exibindo moda
echo "<b>Moda</b>";
echo "<br>";
echo $moda;
echo "<br><br>";

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
echo "<br><br>";


//exibindo medidas separatrizes
echo "<table border='1' width=300><tr><th><b><center>Quartil</center></b></th></tr></table>";
echo "<table border='1'width=300>";
echo "<tr><th><b>Posição</b></th><th><b>Numero</b></th></tr>";
for($i=1;$i<4;$i++)
	echo "<tr class= alt><td> Q".$i."</td><td>".$quartil[$i]."</td></tr>";
echo "</table>";
echo "<br>";
#
echo "<table border='1' width=300><tr><th><b><center>Quintil</center></b></th></tr></table>";
echo "<table border='1' width=300>";
echo "<tr><th><b>Posição</b></th><th><b>Numero</b></th></tr>";
for($i=1;$i<5;$i++)
	echo "<tr class= alt><td> K".$i."</td><td>".$kintil[$i]."</td></tr>";
echo "</table>";
echo "<br>";
#
echo "<table border='1' width=300><tr><th><b><center>Decil</center></b></th></tr></table>";
echo "<table border='1' width=300>";
echo "<tr><th><b>Posição</b></th><th><b>Numero</b></th></tr>";
for($i=1;$i<10;$i++)	
	echo "<tr class= alt><td> D".$i."</td><td>".$decil[$i]."</td></tr>";
echo "</table>";
echo "<br>";

//exibindo tabela de frequencias
echo "<b>Tabela</b></br> ";
echo "<table border='1' width=400>";
echo "<tr><th><b>Classe</b></th><th><b>Intervalo</b></th><th><b>Fi</b></th><th><b>Fi(Ac)</b></th><th><b>Xi</b></th><th><b>Xi(Ac)</b></th></tr>";
for($i=1;$i<=$k;$i++)
{
	echo "<tr class= alt>";
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

//exibindo medidas de dispersão
echo "<b>Amplitude Total</b>";
echo "<br>";
echo $amplitude_total."u";
echo "<br><br>";

echo "<b>Desvio Médio Simples</b>";
echo "<br>";
echo $dms;
echo "<br><br>";

echo "<b>Variânça</b>";
echo "<br>";
echo $variança."u²";
echo "<br><br>";

echo "<b>Desvio Padrão</b>";
echo "<br>";
echo $desvio_p."u";
echo "<br><br>";


//exibindo graficos 
echo "<b>Graficos</b>";
echo "<br>";
require_once 'grafico.php';
echo "<br><br>";
echo "Clique Aqui para baixar o arquivo gerado: <a href='arquivos/".$ids.".txt'>Clique Aqui com o Botão Direito</a>";

?>