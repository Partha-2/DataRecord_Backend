package com.example.DataRecord.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DataRecord.Entity.Data;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DataRepository extends JpaRepository<Data,Long> {

   @Query("From Data  where end_year = :end_year")
    List<Data> findAllByEndYear(String end_year);

    @Query("From Data  where topics = :topics")
    List<Data> findAllByTopics(String topics);

    @Query("From Data  where sector = :sector")
    List<Data> findAllBySector(String sector);

    @Query("From Data  where region = :region")
    List<Data> findAllByRegion(String region);

    @Query("From Data  where pest = :pest")
    List<Data> findAllByPest(String pest);

    @Query("From Data  where source = :source")
    List<Data> findAllBySource(String source);

    @Query("From Data  where swot = :swot")
    List<Data> findAllBySwot(String swot);

    @Query("From Data  where country = :country")
    List<Data> findAllByCountry(String country);

    @Query("From Data  where city = :city")
    List<Data> findAllByCity(String city);
}
