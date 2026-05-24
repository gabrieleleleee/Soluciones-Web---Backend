package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.CategoriaProducto;
import com.controlcalidad.repository.ICategoriaProductoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaProductoService implements ICategoriaProductoService {
	private final ICategoriaProductoRepository repo;

	@Override
	public CategoriaProducto save(CategoriaProducto categoria) throws Exception {
		return repo.save(categoria);
	}

	@Override
	public CategoriaProducto update(CategoriaProducto categoria, Integer id) throws Exception {
		categoria.setIdCategoria(id);
		return repo.save(categoria);
	}

	@Override
	public List<CategoriaProducto> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public CategoriaProducto findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new CategoriaProducto());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
