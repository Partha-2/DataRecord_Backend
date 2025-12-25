package com.example.DataRecord.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataRecord.Dto.ServiceDto;
import com.example.DataRecord.Entity.Data;



@RestController
@CrossOrigin(origins="*")
@RequestMapping("/data")
public class DataController {

	@Autowired
	private ServiceDto serviceRepository;
	
	@ResponseBody
	@GetMapping("/endYear/{end_year}")
	public List<Data> getEndYear(@PathVariable String end_year) {
		return serviceRepository.getDataByEndYear(end_year);
	}
	
	@ResponseBody
	@GetMapping("/all/accounts")
	public List<Data> allAccounts()
	{	
		return serviceRepository.getAllData();
	}
	
	@ResponseBody
	@GetMapping("/id/{id}")
	public Data getAccountById(@PathVariable Long id)
	{	
		return serviceRepository.getAccountById(id);
	}
	
	
	@ResponseBody
	@GetMapping("/topics/{topics}")
	public List<Data> getTopics(@PathVariable String topics) {
		return serviceRepository.getDataByTopics(topics);
	}
	
	@ResponseBody
	@GetMapping("/sector/{sector}")
	public List<Data> getSector(@PathVariable String sector) {
		return serviceRepository.getDataBySector(sector);
	}
	
	@ResponseBody
	@GetMapping("/region/{region}")
	public List<Data> getRegion(@PathVariable String region) {
		return serviceRepository.getDataByRegion(region);
	}
	
	@ResponseBody
	@GetMapping("/pest/{pest}")
	public List<Data> getPest(@PathVariable String pest) {
		return serviceRepository.getDataByPest(pest);
	}
	
	@ResponseBody
	@GetMapping("/source/{source}")
	public List<Data> getSource(@PathVariable String source) {
		return serviceRepository.getDataBySource(source);
	}
	
	@ResponseBody
	@GetMapping("/swot/{swot}")
	public List<Data> getSwot(@PathVariable String swot) {
		return serviceRepository.getDataBySwot(swot);
	}
	
	@ResponseBody
	@GetMapping("/country/{country}")
	public List<Data> getCountry(@PathVariable String country) {
		return serviceRepository.getDataByCountry(country);
	}
	
	@ResponseBody
	@GetMapping("/city/{city}")
	public List<Data> getCity(@PathVariable String city) {
		return serviceRepository.getDataByCity(city);
	}

}
