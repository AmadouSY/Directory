package fr.techops.directory;

import fr.techops.directory.domain.Contacts;
import fr.techops.directory.infrastructure.utils.CSVUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DirectoryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectoryApplication.class);
    public static final String MOCK_DATA_CSV = "mock_data.csv";

    @Autowired
    Contacts contacts;

    public static void main(String[] args) {
        SpringApplication.run(DirectoryApplication.class, args);
    }

    @Bean
    CommandLineRunner init(Contacts contacts) {
        return args -> {
            LOGGER.info("Feeding database");
            contacts.saveAll(CSVUtils.listFromCsv(MOCK_DATA_CSV));
        };
    }

}
