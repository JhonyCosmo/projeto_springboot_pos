package br.com.devmedia.dao;

import java.util.List;
import br.com.devmedia.domain.Produto;

public interface ProdutoDao {
	void salvar(Produto produto);
    List<Produto> recuperar();
    Produto recuperarPorID(long id);
    void atualizar(Produto produto);
    void excluir(long id);
}
