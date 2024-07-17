package com.test.market.persistence;

import com.test.market.persistence.crud.ProductoCrudRepository;
import com.test.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return (List<Producto>) productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return (Optional<List<Producto>>) productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }
}
