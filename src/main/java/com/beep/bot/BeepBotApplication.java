package com.beep.bot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.beep.bot.repository.CountryRepository;

@SpringBootApplication
@ComponentScan(basePackages="com.*")
public class BeepBotApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(BeepBotApplication.class);

	@Autowired
	private EntityManager entityManager;
	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BeepBotApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// inserting data in database
		insertDataInCountryTableIfNotExist();
	}

	private void insertDataInCountryTableIfNotExist() throws IOException {
		String sqlDumpData = getSqlDump("country.sql");
		// inserting data in country table if table is empty
		if (!sqlDumpData.isEmpty()) {
			if (countryRepository.count() == 0) {
				LOGGER.info("Inserting data in country table...");
				Query query = entityManager.createNativeQuery(sqlDumpData);
				query.executeUpdate();
				LOGGER.info("Data inseted in country table successfully...");
			} else {
				LOGGER.info("Data already exist in country table...");
			}
		}
	}

	private String getSqlDump(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader read = null;
		try {
			URL input = getClass().getResource("/sql/" + fileName);
			read = new BufferedReader(new InputStreamReader(input.openStream()));
			String line;
			while ((line = read.readLine()) != null) {
				stringBuilder.append(line);
			}
		} catch (Exception e) {
			LOGGER.error("File not found: " + fileName, e);
		} finally {
			if (read != null) {
				try {
					read.close();
				} catch (IOException e) {
					LOGGER.error("Unable to close file reader: ", e);
				}
			}
		}
		return stringBuilder.toString();
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
