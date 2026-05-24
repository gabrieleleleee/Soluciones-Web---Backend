package com.controlcalidad.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.controlcalidad.model.DetalleInspeccion;
import com.controlcalidad.model.EstandarCalidad;
import com.controlcalidad.repository.IDetalleInspeccionRepository;
import com.controlcalidad.repository.IEstandarCalidadRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleInspeccionService implements IDetalleInspeccionService {

	private final IDetalleInspeccionRepository repo;
	private final IEstandarCalidadRepository estandarRepo;

	@Override
	public DetalleInspeccion save(DetalleInspeccion detalle) throws Exception {
		// LÓGICA DE NEGOCIO: calcularCumplimiento / validarMedicion
		// 1. Buscamos el estándar de calidad completo en la base de datos
		EstandarCalidad estandar = estandarRepo.findById(detalle.getEstandarCalidad().getIdEstandar())
				.orElseThrow(() -> new Exception("Estándar de calidad no encontrado"));

		// 2. Evaluamos si el valor medido está dentro del rango permitido
		double valor = detalle.getValorMedido();
		boolean cumple = (valor >= estandar.getValorMinimo() && valor <= estandar.getValorMaximo());

		// 3. Asignamos el resultado del cálculo al atributo antes de guardar
		detalle.setCumpleEstandar(cumple);
		detalle.setEstandarCalidad(estandar);

		return repo.save(detalle);
	}

	@Override
	public DetalleInspeccion update(DetalleInspeccion detalle, Integer id) throws Exception {
		detalle.setIdDetalle(id);
		return repo.save(detalle);
	}

	@Override
	public List<DetalleInspeccion> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public DetalleInspeccion findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new DetalleInspeccion());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
