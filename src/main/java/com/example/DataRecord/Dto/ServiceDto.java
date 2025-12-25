package com.example.DataRecord.Dto;


import java.util.List;



import com.example.DataRecord.Entity.Data;


public interface ServiceDto {

	List<Data> getAllData();
	
    List<Data> getDataByEndYear(String end_Year);

    List<Data> getDataByTopics(String topics);

    List<Data> getDataBySector(String sector);

    List<Data> getDataByRegion(String region);

    List<Data> getDataByPest(String pest);

    List<Data> getDataBySource(String source);

    List<Data> getDataBySwot(String swot);

    List<Data> getDataByCountry(String country);

    List<Data> getDataByCity(String city);

	Data getAccountById(Long id);

    
}
