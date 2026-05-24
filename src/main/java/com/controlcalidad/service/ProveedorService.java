package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.Proveedor;
import com.controlcalidad.repository.IProveedorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService implements IProveedorService {
	private final IProveedorRepository repo;

	@Override
	public Proveedor save(Proveedor proveedor) throws Exception {
		return repo.save(proveedor);
	}

	@Override
	public Proveedor update(Proveedor proveedor, Integer id) throws Exception {
		proveedor.setIdProveedor(id);
		return repo.save(proveedor);
	}

	@Override
	public List<Proveedor> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Proveedor findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Proveedor());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
