package com.fatosmorina.explorecalifornia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fatosmorina.explorecalifornia.domain.TourPackage;

@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false)
    <S extends TourPackage> S save(S entity);

    @Override
    @RestResource(exported = false)
    default <S extends TourPackage> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @RestResource(exported = false)
    default void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    @RestResource(exported = false)
    default void delete(TourPackage entity) {
        // TODO Auto-generated method stub

    }

    @Override
    @RestResource(exported = false)
    default void delete(Iterable<? extends TourPackage> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    @RestResource(exported = false)
    default void deleteAll() {
        // TODO Auto-generated method stub
    }

}
