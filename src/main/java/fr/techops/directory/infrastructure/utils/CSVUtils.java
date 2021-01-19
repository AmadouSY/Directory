package fr.techops.directory.infrastructure.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import fr.techops.directory.domain.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class CSVUtils {


    private CSVUtils(){}

    public static List<Contact> listFromCsv(String file){
        Map<String, String> columnMappings = Map.of(
                "id", "id",
                "first_name", "firstName",
                "last_name", "lastName",
                "email", "email",
                "company", "company",
                "department", "department"
        );

        var mappingStrategy = new HeaderColumnNameTranslateMappingStrategy<>();
        mappingStrategy.setColumnMapping(columnMappings);
        mappingStrategy.setType(Contact.class);

        Reader reader = null;
        try {
            final Resource resource = new ClassPathResource(file);
            reader = new BufferedReader(new FileReader(resource.getFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        var csvToBean = new CsvToBeanBuilder(reader)
                .withType(Contact.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .withMappingStrategy(mappingStrategy)
                .build();

        return (List<Contact>) csvToBean.parse();
    }


}
