package fr.techops.directory.infrastructure.utils;

import fr.techops.directory.domain.Contact;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVUtilsTest {


    @Test
    void should_return_the_right_list_from_the_csv(){
        List<Contact> contacts =
                List.of(new Contact("6316868375","Leonardo","Amor","lamor0@utexas.edu","Devshare","Sales"),
                        new Contact("5158854467","Baillie","Southerns","bsoutherns1@harvard.edu","Voolia","Support"));

        List<Contact> result = CSVUtils.listFromCsv("test/test_data.csv");

        Assertions.assertThat(result).isEqualTo(contacts);
    }
}