package com.platzimarket.persistence;

import com.platzimarket.persistence.crud.ProductoCrudRepository;
import com.platzimarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

        private ProductoCrudRepository productoCrudRepository;

        /*creamos un metodo que nos retorna todos los usuarios de la base de datos
        * y se hace un caster porque es un método iterable*/

        public List<Producto> getAll(){
                return (List<Producto>) productoCrudRepository.findAll();
        }
        //creamos un método para conseguir las categorias ordenadas pro nombre
        public List<Producto> getByCategoria(int idCategoria){
                return productoCrudRepository.findByIdCategoriaOrderByNombre(idCategoria);
        }
        //creamos un metod para llamar el Optional y de parametros es la cantidad y el estado
         public Optional<List<Producto>> getEscasos(int cantidad){
                return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
         }
         //creamos un producto para encontralo por id
        public Optional<Producto> getProducto(int idProducto){
                return productoCrudRepository.findById(idProducto);
        }
        //guardar un Producto no se utiliza el Optional solo la entidad
        public Producto save(Producto producto){
                return productoCrudRepository.save(producto);
        }
        //eliminamos un producto por Id y no debulve nada

        public  void delete(int idProducto){
                productoCrudRepository.deleteById(idProducto);
        }
}
