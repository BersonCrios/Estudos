<?php

//pagina dedicada ao calculo do rol
	$dados_brutos = $_SESSION['dados_brutos'];
	$i = 0;
	$rol;	
	
	//fazendo o rol
	sort($dados_brutos);
	foreach ($dados_brutos as $n=> $value)//função para validar os numeros, o que for numero dentro dos delimitadores será considerado
	{
		$rol[$i] = $value;
		$i++;
	}
		
	//passando os dados para a seção
	$_SESSION['rol'] = $rol;
	
?>