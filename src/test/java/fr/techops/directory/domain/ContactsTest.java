package fr.techops.directory.domain;

import fr.techops.directory.DirectoryApplication;
import fr.techops.directory.infrastructure.ContactJpa;
import fr.techops.directory.infrastructure.persistence.ContactsJpaDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = DirectoryApplication.class)
class ContactsTest {

    private static List<Contact> dataList;

    @Autowired
    Contacts contacts;

    @Autowired
    ContactsJpaDao contactsJpaDao;

    @BeforeAll
    static void setUp(){
        dataList = List.of(new Contact("1", "fred", "lastName", "email@domain.com", "techops", "it"),
                        new Contact("2", "maxime", "lastName", "email2@domain.com", "lcdlc", "it"),
                        new Contact("4", "bruno", "lastName", "email3@domain.com", "oracle", "it"),
                        new Contact("5", "bruno", "lastName", "email4@domain.com", "techops", "it")
                );
    }

    @BeforeEach
    void init(){
        eraseData();
    }

    @Test
    void should_save_elements_in_database(){
        List<Contact> initialContactsInDatabase = listAllData();

        contacts.saveAll(dataList);
        List<Contact> contactsInDataBase = listAllData();

        Assertions.assertThat(contactsInDataBase).containsAll(dataList);
        Assertions.assertThat(initialContactsInDatabase).isNotEqualTo(dataList);
    }

    @Test
    void should_return_an_empty_list_when_the_table_is_empty(){
        var emptyList = new ArrayList<>();
        Assertions.assertThat(contacts.listAll()).isEqualTo(emptyList);
    }

    @Test
    void should_return_the_list_of_elements_in_the_table(){
        contacts.saveAll(dataList);

        List<Contact> contactsInDataBase = listAllData();

        Assertions.assertThat(contactsInDataBase).isEqualTo(dataList);
    }

    private List<Contact> listAllData() {
        return contactsJpaDao.findAll().stream()
                .map(ContactJpa::toContact)
                .collect(Collectors.toList());
    }

    private void eraseData(){
        contactsJpaDao.deleteAll();
    }

}