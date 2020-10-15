package br.com.bersoncrios.servicos;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static br.com.bersoncrios.utils.DataUtils.isMesmaData;
import static br.com.bersoncrios.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.bersoncrios.builders.UsuarioBuilder;
import br.com.bersoncrios.dados.LocacaoDAO;
import br.com.bersoncrios.dados.LocacaoDAOFake;
import br.com.bersoncrios.entidades.Filme;
import br.com.bersoncrios.entidades.Locacao;
import br.com.bersoncrios.entidades.Usuario;
import br.com.bersoncrios.exceptions.FilmeSemEstoqueException;
import br.com.bersoncrios.exceptions.LocadoraException;
import br.com.bersoncrios.matchers.DiaSemanaMatchers;
import br.com.bersoncrios.matchers.MatchersProprios;
import br.com.bersoncrios.servicos.LocacaoService;
import br.com.bersoncrios.utils.DataUtils;

public class LocacaoServiceTest {
	
	@InjectMocks
	private LocacaoService service;
	
	@Mock
	private SPCService spcService;
	@Mock
	private LocacaoDAO dao;
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void deveAlugarFilme() throws Exception {
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));

		
		//Cenário
			Usuario usuario = UsuarioBuilder.umUsuario().agora();
			List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
			
						
		//Ação 
			Locacao locacao;
			
			locacao = service.alugarFilme(usuario, filmes);
			
		//Verificação
			error.checkThat(locacao.getValor(), is(equalTo(5.0)));
			error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			error.checkThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1) ), is(true));
	}

	//FORMA ELEGANTE
	@Test(expected=FilmeSemEstoqueException.class)
	public void naoDeveAlugarFilmeSemEstoque() throws Exception {
		//Cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 4.0));
		
		//Ação
			service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		//CENÁRIO
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
	
		//AÇÃO
			try {
				service.alugarFilme(null, filmes);
				fail();
			} catch (LocadoraException e) {
				assertThat(e.getMessage(), is("Usuário Vazio"));
			}
	}
	
	@Test
	public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		//CENÁRIO
			Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
			exception.expect(LocadoraException.class);
			exception.expectMessage("Filme Vazio");
			
		
		//AÇÃO
			service.alugarFilme(usuario, null);
	}

	@Test
	public void deveDevolverNaSegundaSeAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));

		
		//Cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
			
						
		//Ação 
			Locacao retorno = service.alugarFilme(usuario, filmes);
			
		//Verificação
			assertThat(retorno.getDataRetorno(), MatchersProprios.caiNumaSegunda());

	}
	
	@Test
	public void naoDeveAlugarFilmeParaNegativadoSPC()  throws FilmeSemEstoqueException, LocadoraException{

		//Cenário
			Usuario usuario = UsuarioBuilder.umUsuario().agora();
			List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
			
			//LANÇA UMA EXPECTATIVA
			Mockito.when(spcService.possuiNegativacao(usuario)).thenReturn(true);
			
			exception.expect(LocadoraException.class);	
		exception.expectMessage("User Negativo");
		//Ação 
			service.alugarFilme(usuario, filmes);
			
		//verificacsao	
			Mockito.verify(spcService).possuiNegativacao(usuario);
	}
}
