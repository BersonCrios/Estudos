<?php
//pagina dedicada a validação dos numeros, bem como a tiragem do maior e do menor, alem do total de numeros
	$num = $_SESSION['numeros'];
	$delimitador = $_SESSION['delimitador'];
	$maior;
	$menor;
	$total_num = 0;
	$dados_brutos;//array que receberá todos os numeros validados
	//verificando qual delimitador foi escolhido
	switch($_POST["delimitador"])
	{
		case "1":
			$numeros = explode(";", $num);
			break;
		case "2":
			$numeros = explode(" ", $num);
			break;
		default:
			break;
	}
	foreach ($numeros as $numero)//função para validar os numeros, o que for numero dentro dos delimitadores será considerado
	{
		if(is_numeric($numero))
		{	
			$total_num++;
			$dados_brutos[$total_num] = $numero;
			if($total_num == 1)//primeiro criterio para definir menor e maior
			{
				$maior=$numero;
				$menor=$numero;
			}
			else
			if($numero > $maior)//criterio para definir o maior
			{
				$maior = $numero;
			}
			else
			if($numero < $menor)//criterio para definir o menor
			{
				$menor = $numero;
			}
		}
	}
	//passando os dados para a seção
	$_SESSION['maior'] = $maior;
	$_SESSION['menor'] = $menor;
	$_SESSION['dados_brutos'] = $dados_brutos;
	$_SESSION['total_num'] = $total_num;
	
?>