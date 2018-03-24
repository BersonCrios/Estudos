<?php session_start(); ?>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<title>:: Spada Calculator::</title>
	<link type="text/css" rel="stylesheet" href="css/design.css"/>
	</script>
</head>
<body bgcolor="#6666ff">
	
	<div class='left'>
		<ul id="menu">
			<fon2>
			<li><a href="index.html"><fon2>Inicio</fon2></a></li>
			<li><a href="conteudo.html"><fon2>Aprendendo</fon2></a></li>
			<li><a href="about.html"><fon2>Sobre</fon2></a></li>
			</fon2>
			
		</ul><!-- /menu -->
	</div>
	<div id="content">
		<form  title="Calculadora de Estatisticas" id="formstatic" name="formestatistica" action="" method="post">
			<center>
			<fon>
			
			<a>Sequência númerica (Dados brutos ou Roll): </a><br>
			<textarea name='series' cols='80' rows='1'><?php echo isset($_POST['series']) ? $_POST['series'] : '' ?></textarea>
			<br/><br/>
			<a>Como deseja separa os números:</a></fon>
			<select name="delimitador">
				<option value="1">Ponto e Vírgula</option>
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
			echo "<fon><b></b></fon>";
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
				echo"<fon><b>Valores Inválidos!!!  tente novamente</b></fon>";
			else
				require_once 'exibir.php';
		}
		?>
		
	</div>
	</body>
	</center>
</html>
