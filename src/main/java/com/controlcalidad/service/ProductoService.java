package com.controlcalidad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlcalidad.model.Producto;
import com.controlcalidad.repository.IProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService implements IProductoService {
	private final IProductoRepository repo;
	
	@Override
	public Producto save(Producto producto) throws Exception {
		return repo.save(producto);
	}

	@Override
	public Producto update(Producto producto, Integer id) throws Exception {
		// TODO Logica utilizando ID
		producto.setIdProducto(id);
		return repo.save(producto);
	}

	@Override
	public List<Producto> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Producto findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Producto());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);	
	}

}
