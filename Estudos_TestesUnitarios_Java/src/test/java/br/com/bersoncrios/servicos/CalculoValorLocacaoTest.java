package br.com.bersoncrios.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.bersoncrios.dados.LocacaoDAO;
import br.com.bersoncrios.dados.LocacaoDAOFake;
import br.com.bersoncrios.entidades.Filme;
import br.com.bersoncrios.entidades.Locacao;
import br.com.bersoncrios.entidades.Usuario;
import br.com.bersoncrios.exceptions.FilmeSemEstoqueException;
import br.com.bersoncrios.exceptions.LocadoraException;

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {
	
	@InjectMocks
	private LocacaoService service;
	
	@Mock
	private SPCService spcService;
	@Mock
	private LocacaoDAO dao;
	
	@Parameter
	public List<Filme> filmes;
	@Parameter(value = 1)
	public Double valorLocacao;
	@Parameter(value = 2)
	public String cenario;
	
	private static Filme f1 = new Filme("Filme 1", 2, 4.0);
	private static Filme f2 = new Filme("Filme 2", 2, 4.0);
	private static Filme f3 = new Filme("Filme 3", 2, 4.0);
	private static Filme f4 = new Filme("Filme 4", 2, 4.0);
	private static Filme f5 = new Filme("Filme 5", 2, 4.0);
	private static Filme f6 = new Filme("Filme 6", 2, 4.0);

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Parameters(name = "Teste{index} = {2}")
	public static Collection<Object[]> getParameters(){
		return Arrays.asList(new Object[][] {
			{Arrays.asList(f1,f2,f3), 11.0, "3 Filmes: 25%"},
			{Arrays.asList(f1,f2,f3,f4), 13.0, "4 Filmes: 50%"},
			{Arrays.asList(f1,f2,f3,f4,f5), 14.0, "5 Filmes: 75%"},
			{Arrays.asList(f1,f2,f3,f4,f5,f6), 14.0,"6 Filmes: 100%"}
		});
	}
	
	@Test
	public void deveCalcularValorLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
		//CENÁRIO
		Usuario u = new Usuario("U1");
		
		//AÇÃO
		Locacao l = service.alugarFilme(u, filmes);
	
		//VERIFICACAO
		assertThat(l.getValor(), is(valorLocacao));
	}
	
}
