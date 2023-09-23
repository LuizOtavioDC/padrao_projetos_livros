package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Livros;
import one.digitalinnovation.gof.model.LivrosRepository;
import one.digitalinnovation.gof.service.LivrosService;


/**
 * Implementação da <b>Strategy</b> {@link LivrosService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements LivrosService {

	@Autowired
	private LivrosRepository LivrosRepository;

	@Override
	public Iterable<Livros> buscarTodos() {
		return LivrosRepository.findAll();
	}

	@Override
	public Livros buscarPorId(Long id) {
		Optional<Livros> livros = LivrosRepository.findById(id);
		return livros.get();
	}

	@Override
	public void inserir(Livros livros) {
		salvarLivros(livros);
	}

	@Override
	public void atualizar(Long id, Livros cliente) {
		Optional<Livros> clienteBd = LivrosRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarLivros(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		LivrosRepository.deleteById(id);
	}

	private void salvarLivros(Livros livros) {
		LivrosRepository.save(livros);
	}

}
