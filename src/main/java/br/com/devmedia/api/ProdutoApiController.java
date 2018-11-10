package br.com.devmedia.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmedia.domain.Produto;
import br.com.devmedia.exception.ModelNotFoundException;
import br.com.devmedia.repository.ProdutoRepository;


@RestController
@RequestMapping("/api/v1.0")
public class ProdutoApiController {

	@Autowired
	ProdutoRepository repository;

	@GetMapping("/produtos")
	public List<Produto> getAllProdutos() {
		return repository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Produto getPersonById(@PathVariable(value = "id") Long id) {		
		Produto model=repository.findOne(id);
		if(model==null) {
			throw new ModelNotFoundException("produto", "id", id);
		}		
		return model;				
	}

	@PostMapping("/produtos")
	public Produto createProduto(@Valid @RequestBody Produto model) {
		return repository.save(model);
	}

	@PutMapping("/produtos/{id}")
	public Produto updatePerson(@PathVariable(value = "id") Long id, @Valid @RequestBody Produto modelDetails) {

		Produto model = repository.findOne(id);
		if(model==null) {
			throw new ModelNotFoundException("produto", "id", id);
		}
		
		model.setName(modelDetails.getName());
		model.setPrice(modelDetails.getPrice());

		Produto updatedModel = repository.save(model);
		return updatedModel;
	}

	@DeleteMapping("/produtos/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable(value = "id") Long id) {

		Produto model = repository.findOne(id);
		if(model==null) {
			throw new ModelNotFoundException("produto", "id", id);
		}
		repository.delete(model);		
		return ResponseEntity.ok().build();
		
	}
}
