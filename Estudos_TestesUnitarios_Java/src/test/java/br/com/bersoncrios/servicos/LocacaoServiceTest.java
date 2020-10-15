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

		
		//Cen�rio
			Usuario usuario = UsuarioBuilder.umUsuario().agora();
			List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
			
						
		//A��o 
			Locacao locacao;
			
			locacao = service.alugarFilme(usuario, filmes);
			
		//Verifica��o
			error.checkThat(locacao.getValor(), is(equalTo(5.0)));
			error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			error.checkThat(isMesmaData(locacao.getDataRetorno(),obterDataComDiferencaDias(1) ), is(true));
	}

	//FORMA ELEGANTE
	@Test(expected=FilmeSemEstoqueException.class)
	public void naoDeveAlugarFilmeSemEstoque() throws Exception {
		//Cen�rio
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 4.0));
		
		//A��o
			service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		//CEN�RIO
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
	
		//A��O
			try {
				service.alugarFilme(null, filmes);
				fail();
			} catch (LocadoraException e) {
				assertThat(e.getMessage(), is("Usu�rio Vazio"));
			}
	}
	
	@Test
	public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		//CEN�RIO
			Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
			exception.expect(LocadoraException.class);
			exception.expectMessage("Filme Vazio");
			
		
		//A��O
			service.alugarFilme(usuario, null);
	}

	@Test
	public void deveDevolverNaSegundaSeAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));

		
		//Cen�rio
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
			
						
		//A��o 
			Locacao retorno = service.alugarFilme(usuario, filmes);
			
		//Verifica��o
			assertThat(retorno.getDataRetorno(), MatchersProprios.caiNumaSegunda());

	}
	
	@Test
	public void naoDeveAlugarFilmeParaNegativadoSPC()  throws FilmeSemEstoqueException, LocadoraException{

		//Cen�rio
			Usuario usuario = UsuarioBuilder.umUsuario().agora();
			List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
			
			//LAN�A UMA EXPECTATIVA
			Mockito.when(spcService.possuiNegativacao(usuario)).thenReturn(true);
			
			exception.expect(LocadoraException.class);	
		exception.expectMessage("User Negativo");
		//A��o 
			service.alugarFilme(usuario, filmes);
			
		//verificacsao	
			Mockito.verify(spcService).possuiNegativacao(usuario);
	}
}
