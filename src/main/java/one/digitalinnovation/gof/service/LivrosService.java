package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Livros;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface LivrosService {

	Iterable<Livros> buscarTodos();

	Livros buscarPorId(Long id);

	void inserir(Livros livros);

	void atualizar(Long id, Livros livros);

	void deletar(Long id);

}
