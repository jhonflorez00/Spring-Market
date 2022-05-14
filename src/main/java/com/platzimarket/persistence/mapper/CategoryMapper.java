package com.platzimarket.persistence.mapper;

import com.platzimarket.domain.Category;
import com.platzimarket.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//le decimos a spring qu eesta la integrams con mapper structur
@Mapper(componentModel = "spring ")
public interface CategoryMapper {
    //pasamos categoria a category con esta anotacion
    //@Mappings generamos lo mapeos que vamos a realizar  llamado la fuente y lo llevamos al destino
    // hacemos la traduccion
    @Mappings({
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "descripcion",target = "category"),
            @Mapping(source = "estado",target = "active"),

    })
    Category toCategory(Categoria categoria);
    //para hacer la combercion al contrario utilizamos la siguiente mapper
    //@InheritInverseConfiguration con este invertimos la configuacion que isimos arriba en @Mappings
    // @Mapping le decimos qu eignore el atributo Producto
    @InheritInverseConfiguration
    @Mapping(target = "productos",ignore = true)
    Categoria toCategaria(Category category);
}
