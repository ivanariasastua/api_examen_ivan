package org.una.examen.utils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 *
 * @author Dios
 */
public class MapperUtils {
    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private MapperUtils() {
    }

    public static <D, E> D DtoFromEntity(final E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <D, E> E EntityFromDto(final D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
    
    public static <D, E> List<D> DtoListFromEntityList(final Collection<E> entityList, Class<D> dtoClass) {
        return entityList.stream().map(entity -> DtoFromEntity(entity, dtoClass)).collect(Collectors.toList());
    }
    
    public static <D, E> List<E> EntityListFromDtoList(final Collection<D> dtoList, Class<E> entityClass){
        return dtoList.stream().map(dto -> EntityFromDto(dto, entityClass)).collect(Collectors.toList());
    }

}
