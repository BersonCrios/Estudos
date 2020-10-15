package br.com.bersoncrios.servicos;

import static br.com.bersoncrios.utils.DataUtils.adicionarDias;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.bersoncrios.dados.LocacaoDAO;
import br.com.bersoncrios.entidades.Filme;
import br.com.bersoncrios.entidades.Locacao;
import br.com.bersoncrios.entidades.Usuario;
import br.com.bersoncrios.exceptions.FilmeSemEstoqueException;
import br.com.bersoncrios.exceptions.LocadoraException;
import br.com.bersoncrios.utils.DataUtils;

public class LocacaoService {

	private LocacaoDAO dao;
	private SPCService spcService;
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws FilmeSemEstoqueException, LocadoraException {
		if(usuario == null) {
			throw new LocadoraException("Usuário Vazio");
		}
		if(filmes == null || filmes.isEmpty()) {
			throw new LocadoraException("Filme Vazio");
		}
		
		for(Filme filme : filmes) {			
			if(filme.getEstoque() == 0) {
				throw new FilmeSemEstoqueException();
			}
		}
		
		
		if(spcService.possuiNegativacao(usuario)) {
			throw new LocadoraException("User Negativo");
		}
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		
		Double valorTotal = 0d;
		for(int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			Double valorFilme = filme.getPrecoLocacao();
			switch (i) {
				case 2: 
					valorFilme = valorFilme * 0.75; 
					break;
				case 3: 
					valorFilme = valorFilme * 0.5; 
					break;
				case 4: 
					valorFilme = valorFilme * 0.25; 
					break;
				case 5: 
					valorFilme = 0d; 
					break;
			}
			valorTotal+=valorFilme;
		}
		
		locacao.setValor(valorTotal);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1);
		}
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		dao.salvar(locacao);
		
		return locacao;
	}

}