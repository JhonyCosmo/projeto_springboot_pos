package br.com.devmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.devmedia.dao.ProdutoDao;
import br.com.devmedia.domain.Produto;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

  @Autowired
    private ProdutoDao produtoDao;
	  
	@Override
	public void salvar(Produto playlist) {
		produtoDao.salvar(playlist);
		
	}

	 @Override
	 @Transactional(readOnly = true)
	public List<Produto> recuperar() {
		 return produtoDao.recuperar();
	}

	 @Override
	 @Transactional(readOnly = true)
	public Produto recuperarPorId(long id) {
		 return produtoDao.recuperarPorID(id);
	}

	@Override
	public void atualizar(Produto produto) {
		produtoDao.atualizar(produto);
		
	}

	@Override
	public void excluir(long id) {
		produtoDao.excluir(id);       
		
	}

}
