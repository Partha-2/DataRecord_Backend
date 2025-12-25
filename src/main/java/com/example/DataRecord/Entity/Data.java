package com.example.DataRecord.Entity;

import java.util.Objects;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "details")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String country;
    private String end_year;
    private String intensity;
    private String likelihood;
    private String pest;
    private String region;
    private String relevance;
    private String sector;
    private String source;
    private String start_year;
    private String swot;
    private String topics;
    
    public Data() {};
    
    public Data(Long id, String city, String country, String end_year, String intensity, String likelihood, String pest,
			String region, String relevance, String sector, String source, String start_year, String swot,
			String topics) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.end_year = end_year;
		this.intensity = intensity;
		this.likelihood = likelihood;
		this.pest = pest;
		this.region = region;
		this.relevance = relevance;
		this.sector = sector;
		this.source = source;
		this.start_year = start_year;
		this.swot = swot;
		this.topics = topics;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEnd_year(String end_year) {
		this.end_year = end_year;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}

	public void setPest(String pest) {
		this.pest = pest;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setStart_year(String start_year) {
		this.start_year = start_year;
	}

	public void setSwot(String swot) {
		this.swot = swot;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public Long getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEnd_year() {
		return end_year;
	}

	public String getIntensity() {
		return intensity;
	}

	public String getLikelihood() {
		return likelihood;
	}

	public String getPest() {
		return pest;
	}

	public String getRegion() {
		return region;
	}

	public String getRelevance() {
		return relevance;
	}

	public String getSector() {
		return sector;
	}

	public String getSource() {
		return source;
	}

	public String getStart_year() {
		return start_year;
	}

	public String getSwot() {
		return swot;
	}

	public String getTopics() {
		return topics;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, end_year, id, intensity, likelihood, pest, region, relevance, sector, source,
				start_year, swot, topics);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(end_year, other.end_year) && Objects.equals(id, other.id)
				&& Objects.equals(intensity, other.intensity) && Objects.equals(likelihood, other.likelihood)
				&& Objects.equals(pest, other.pest) && Objects.equals(region, other.region)
				&& Objects.equals(relevance, other.relevance) && Objects.equals(sector, other.sector)
				&& Objects.equals(source, other.source) && Objects.equals(start_year, other.start_year)
				&& Objects.equals(swot, other.swot) && Objects.equals(topics, other.topics);
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", city=" + city + ", country=" + country + ", end_year=" + end_year + ", intensity="
				+ intensity + ", likelihood=" + likelihood + ", pest=" + pest + ", region=" + region + ", relevance="
				+ relevance + ", sector=" + sector + ", source=" + source + ", start_year=" + start_year + ", swot="
				+ swot + ", topics=" + topics + "]";
	}
	
    
    
   
   
   
   
    
}
