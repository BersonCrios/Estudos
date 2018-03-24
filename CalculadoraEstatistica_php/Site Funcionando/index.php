<?php session_start(); ?>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Calculadora</title>
</head>
<body>
	<form  title="Calculadora de Estatisticas" id="formstatic" name="formestatistica" action="" method="post">
	<center>
	<a>Digite números separados por vírgula, espaço ou nova linha:</a><br><br>
	<textarea name='series' cols='55' rows='6'><?php echo isset($_POST['series']) ? $_POST['series'] : '' ?></textarea>
	<br/><br/>
	<a>Selecione o metodo delimitador dos numeros: </a>
	<select name="delimitador">
		<option value="1">Vírgula</option>
		<option value="2">Espaço</option>
	</select>
	<br>
	<input name="calcular" type="submit" value="Calcular"/>
	<br/><br/>
	</form>
	
	<?php 
	//verificando inicialização
	if(empty ($_POST["series"]))
	{
		echo "<b>Insira os valores na calculadora e veja a magica acontecer!</b>";
	}
	//caso esteja tudo vazio, ele não inicializia o programa.
	else
	{
		$num = $_POST["series"];//pega tudo que tem dentro da area de texto
		$delimitador = $_POST["delimitador"];
						
		//passando seções
		$_SESSION['numeros'] = $num;
		$_SESSION['delimitador'] = $delimitador;
		
		//primeira requisição para verificar se há numeros validos
		require_once 'teste.php';
		$validar = $_SESSION['validar'];
		
		//caso ele nao valide nenhum numero, ele não exibira nada, caso tenha ele passará
		if($validar == NULL)
			echo"<br><b>Insira numeros validos para a calculadora funcionar!</b><br>";
		else
			require_once 'exibir.php';
	}
	?>
	
	<br><br><br><b>
	<a>Trabalho Desenvolvido por:</a><br><br>
	<a>Sávio Martins Valentim</a><br>
	<a>Renam Ribelato Goloni</a><br>
	<a>José Augusto Buges</a><br><br>
	<a>Sistemas de Informação - 3º Periodo - UNITINS</a><br>
	<a>Prof. Arlenes Spada</a><br>
	</body>
	</center>
</html>
