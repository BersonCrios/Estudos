//package br.com.bersoncrios.servicos;
//
//import static org.junit.Assert.*;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static br.com.bersoncrios.utils.DataUtils.isMesmaData;
//import static br.com.bersoncrios.utils.DataUtils.obterDataComDiferencaDias;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.internal.runners.statements.Fail;
//import org.junit.rules.ErrorCollector;
//import org.junit.rules.ExpectedException;
//
//import br.com.bersoncrios.entidades.Filme;
//import br.com.bersoncrios.entidades.Locacao;
//import br.com.bersoncrios.entidades.Usuario;
//import br.com.bersoncrios.exceptions.FilmeSemEstoqueException;
//import br.com.bersoncrios.exceptions.LocadoraException;
//import br.com.bersoncrios.servicos.LocacaoService;
//import br.com.bersoncrios.utils.DataUtils;
//
//public class LocacaoServiceTestComents {
	
	
//	@After
//	public void tearDown() {
//		System.out.println("After");
//	}
//	
//	
//	@BeforeClass
//	public static void setupClass() {
//		System.out.println("Before Class");
//	}
//	
//	
//	@AfterClass
//	public static void tearDownClass() {
//		System.out.println("After Class");
//	}
	
	
//	@Test
//	public void testeLocacao() throws Exception {
//		Verificação
//			assertThat(locacao.getValor(), is(equalTo(5.0)));
//			assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
//			assertThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1) ), is(true));
//	}

	
//	
//	//FORMA ROBUSTA
//	@Test
//	public void testeLocalao_filmeSemEstoque_2(){
//		//Cenário
//		LocacaoService service = new LocacaoService();
//		Usuario usuario = new Usuario("Usuário 1");
//		Filme filme = new Filme("Filme 1", 0, 5.0);
//		
//		//Ação
//		try {
//			service.alugarFilme(usuario, filme);
//			fail("Deveria ter lançado uma excessão");
//		} catch (Exception e) {
//			assertThat(e.getMessage(), is("Filme sem estoque"));
//		}
//	}
//	
//	
//	//FORMA NOVA
//		@Test
//		public void testeLocalao_filmeSemEstoque_3() throws Exception {
//			//Cenário
//			LocacaoService service = new LocacaoService();
//			Usuario usuario = new Usuario("Usuário 1");
//			Filme filme = new Filme("Filme 1", 0, 5.0);
//			
//			exception.expect(Exception.class);
//			exception.expectMessage("Filme sem estoque");
//			
//			//Ação
//			service.alugarFilme(usuario, filme);
//		}
	
//}
