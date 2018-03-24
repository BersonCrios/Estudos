<?php
	//pagina a contar quantos arquivos 
	$ids; 

	//lendo a id
	$fp = fopen("css/cont.txt", "r");
	while(!feof ($fp))
	{
		$ids = fgets($fp,4096);
	}	
	fclose ($fp);
	//fechando e abrindo de novo
	$fp = fopen("css/cont.txt", "w");
	$ids++;
	$escreve = fwrite($fp, $ids);
	fclose ($fp);
		
	//passando os dados para a seção
	$_SESSION['ids'] = $ids;
?>