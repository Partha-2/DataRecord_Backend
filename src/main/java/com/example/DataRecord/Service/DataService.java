package com.example.DataRecord.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DataRecord.Dto.ServiceDto;
import com.example.DataRecord.Entity.Data;
import com.example.DataRecord.Repo.DataRepository;

import java.util.List;

@Service
public class DataService implements ServiceDto{


    @Autowired
    private  DataRepository repository;

    
    public List<Data> getDataByEndYear(String end_year) {
        return repository.findAllByEndYear(end_year);
    }

    public List<Data> getDataByTopics(String topics) {
        return repository.findAllByTopics(topics);
    }

    public List<Data> getDataBySector(String sector) {
        return repository.findAllBySector(sector);
    }

    public List<Data> getDataByRegion(String region) {
        return repository.findAllByRegion(region);
    }

    public List<Data> getDataByPest(String pest) {
        return repository.findAllByPest(pest);
    }

    public List<Data> getDataBySource(String source) {
        return repository.findAllBySource(source);
    }

    public List<Data> getDataBySwot(String swot) {
        return repository.findAllBySwot(swot);
    }

    public List<Data> getDataByCountry(String country) {
        return repository.findAllByCountry(country);
    }

    public List<Data> getDataByCity(String city) {
        return repository.findAllByCity(city);
    }

	@Override
	public List<Data> getAllData() {
		
		return repository.findAll();
	}

	@SuppressWarnings("null")
	@Override
	public Data getAccountById(Long id) {
		return repository.findById(id).orElseThrow();
	}

    
}
