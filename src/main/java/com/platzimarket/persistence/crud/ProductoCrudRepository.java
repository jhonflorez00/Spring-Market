package com.platzimarket.persistence.crud;

import com.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//extendemos  la clase crud repository y pide dos valores la nombre de tabla y el tipo de dato de su clave primaria

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //creamos un método para conseguir las categorias ordenadas pro nombre
    List<Producto>findByIdCategoriaOrderByNombre(int idCategoria);

    //creamos un método para conseguir ,las cantidad es menor que y si esta disponible

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);
}
