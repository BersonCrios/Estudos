<?php
//pagina dedicada a verificar se o campo não vai passar nenhum parametro errado, como apenas strings
	$num = $_SESSION['numeros'];
	$delimitador = $_SESSION['delimitador'];
	$validar = NULL;

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
			$validar = $numero;
		}
	}
	
	//passando os dados para a seção
	$_SESSION['validar'] = $validar ;

	
?>