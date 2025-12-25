package com.example.DataRecord;

import com.example.DataRecord.Entity.Data;
import com.example.DataRecord.Repo.DataRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final DataRepository repository;

    public DataLoader(DataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() > 0) {
            return; // Data already loaded
        }

        System.out.println("Loading data from CSV...");

        ClassPathResource resource = new ClassPathResource("Data.csv");
        if (!resource.exists()) {
            System.out.println("Data.csv not found in resources!");
            return;
        }

        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            // Using a Builder pattern for version 1.10.0 or newer if possible, but DEFAULT
            // with modifiers works
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setIgnoreHeaderCase(true)
                    .setTrim(true)
                    .build()
                    .parse(reader);

            List<Data> dataList = new ArrayList<>();
            for (CSVRecord record : records) {
                Data data = new Data();

                data.setEnd_year(getOrDefault(record, "end_year"));
                data.setIntensity(getOrDefault(record, "intensity"));
                data.setSector(getOrDefault(record, "sector"));
                data.setTopics(getOrDefault(record, "topic"));
                data.setSwot(getOrDefault(record, "swot"));
                data.setRegion(getOrDefault(record, "region"));
                data.setStart_year(getOrDefault(record, "start_year"));
                data.setCity(getOrDefault(record, "city"));
                data.setCountry(getOrDefault(record, "country"));
                data.setRelevance(getOrDefault(record, "relevance"));
                data.setPest(getOrDefault(record, "pestle"));
                data.setSource(getOrDefault(record, "source"));
                data.setLikelihood(getOrDefault(record, "likelihood"));

                dataList.add(data);
            }
            repository.saveAll(dataList);
            System.out.println("Loaded " + dataList.size() + " records from Data.csv.");
        } catch (Exception e) {
            System.err.println("Failed to load CSV data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String getOrDefault(CSVRecord record, String header) {
        try {
            if (record.isMapped(header)) {
                return record.get(header);
            }
        } catch (IllegalArgumentException e) {
            // ignore
        }
        return "";
    }
}
