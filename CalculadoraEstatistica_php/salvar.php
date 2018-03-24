<?php
	$i;
	//pagina que vai salvar o arquivo
	$autor = $_SESSION['autor'];
	$objetivo = $_SESSION['objetivo'];
	$delimitador = $_SESSION['delimitador'];
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
	$quartil = $_SESSION['quartil'];
	$kintil = $_SESSION['kintil'];
	$decil = $_SESSION['decil'];
	$dms = $_SESSION['dms'];
	$amplitude_total = $_SESSION['amplitude_total'];
	$variança = $_SESSION['variança'];
	$desvio_p =	$_SESSION['desvio_p'];
	$As = $_SESSION['As'];
	$Ku = $_SESSION['Ku'];
	$ids = $_SESSION['ids'];
	
	if($delimitador == 1)
		$delimitador = ";";
	else
		$delimitador = " ";
	
	$fp = fopen("arquivos/".$ids.".txt", "w");
	
	$linha = "Nome do Autor: ".$autor."\r\n";
	fwrite($fp, $linha,strlen($linha));
	
	$linha = "Objetivo do Trabalho: ".$objetivo."\r\n\r\n";
	fwrite($fp, $linha,strlen($linha));
	
	$linha = "Dados Brutos: ";
	fwrite($fp, $linha);
	for($i = 1; $i <= $total_num; $i++ )
	{
		if($i == $total_num)
			fwrite($fp, $dados_brutos[$i]);
		else
			fwrite($fp, $dados_brutos[$i]."".$delimitador);
	}
	fwrite($fp, "\r\n");
	
	$linha = "Total de Números: ".$total_num."\r\n";
	fwrite($fp, $linha);
	
	$linha = "Média: ".$media."\r\n";
	fwrite($fp, $linha);
	
	$linha = "Moda: ".$moda."\r\n";
	fwrite($fp, $linha);
	
	$linha = "Mediana: "; 
	fwrite($fp, $linha);
	for($i = 1; $i <= $total_num; $i++)
	{
		if($i == $mediana1)
			fwrite($fp,$dados_brutos[$i]." (posição ".$mediana1.")");
		else
		if($i == $mediana2)// em caso de total de numeros pares ele mostrara a seguna mediana
			fwrite($fp, " e ".$dados_brutos[$i]." (posição ".$mediana2.")");
	}
	fwrite($fp, "\r\n");
	
	$linha = "Rol: ";
	fwrite($fp, $linha);
	for($i = 0; $i < $total_num; $i++ )
	{
		if($i == ($total_num-1))
			fwrite($fp,$rol[$i]);
		else
			fwrite($fp,$rol[$i]."".$delimitador);
	}
	fwrite($fp, "\r\n\r\n");
	
	fwrite($fp, "Quartils \r\n");
	for($i=1;$i<4;$i++)
	{
		fwrite($fp, "Q".$i." : ".$quartil[$i]."\r\n");
	}
	fwrite($fp, "\r\n\r\n");
	
	fwrite($fp, "Quintils \r\n");
	for($i=1;$i<5;$i++)
	{
		fwrite($fp, "K".$i." : ".$kintil[$i]."\r\n");
	}
	fwrite($fp, "\r\n\r\n");
	
	fwrite($fp, "Decils \r\n");
	for($i=1;$i<10;$i++)
	{
		fwrite($fp, "D".$i." : ".$decil[$i]."\r\n");
	}
	fwrite($fp, "\r\n\r\n");
	
	fwrite($fp, "Tabela de Classes: \r\n");
	fwrite($fp, "Classe - Intervalo - Fi - Fi(Ac) - Xi - Xi(Ac)\r\n");
	for($i=1;$i<=$k;$i++)
	{
		fwrite($fp, $i." - ");
		if($i == $k)
			fwrite($fp, $inter[$i-1]." |---| ".$inter[$i]." - ");
		else
			fwrite($fp, $inter[$i-1]." |--- ".$inter[$i]." - ");
		
		fwrite($fp, $fi[$i]." - ".$fiac[$i]." - ");
		fwrite($fp, $xi[$i]." - ".$xiac[$i]."\r\n");
	}
	fwrite($fp, "\r\n\r\n");
	
	fwrite($fp, "Amplitude Total: ".$amplitude_total." \r\n");
	fwrite($fp, "Desvio Médio Simples: ".$dms." \r\n");
	fwrite($fp, "Variança: ".$variança." \r\n");
	fwrite($fp, "Desvio Padrão: ".$desvio_p." \r\n\r\n");
	
	fwrite($fp, "Medidas de Assimetria: ");
	if($As == 0)
	{
		fwrite($fp ,"Distribuição Simétrica (".$As.")\r\n");
	}
	else
	if($As > 0)
	{
		fwrite($fp,"Distribuição Assimétrica Positiva (á Direita : ".$As.")\r\n");
	}
	else
	if($As < 0)
	{
		fwrite($fp, "Distribuição Assimétrica Negativa (à Esquerda : ".$As.")\r\n");
	}
	
	fwrite($fp, "Medidas de Curtose: ");
	if($Ku == 0.263)
	{
		fwrite($fp ,"Distribuição Mesocúrtica (".$Ku.")\r\n");
	}
	else
	if($Ku > 0.263)
	{
		fwrite($fp,"Distribuição Platicúrtica (".$Ku.")\r\n");
	}
	else
	if($Ku < 0.263)
	{
		fwrite($fp,"Distribuição Leptocúrtica (".$Ku.")\r\n");
	}
	
	fclose ($fp);
?>