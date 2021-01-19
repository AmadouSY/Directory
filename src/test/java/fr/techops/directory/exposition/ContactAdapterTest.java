package fr.techops.directory.exposition;

import fr.techops.directory.domain.Contact;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

class ContactAdapterTest {

    private static Contact contact;
    private static List<Contact> contacts;

    @BeforeAll
    static void setUp() {
        contact = new Contact("1", "fred", "lastName", "email@domain.com", "techops", "it");
        contacts = List.of(new Contact("1", "fred", "lastName", "email@domain.com", "techops", "it"),
                new Contact("2", "maxime", "lastName", "email2@domain.com", "lcdlc", "it"),
                new Contact("4", "bruno", "lastName", "email3@domain.com", "oracle", "it"),
                new Contact("5", "bruno", "lastName", "email4@domain.com", "techops", "it")
        );
    }

    @Test
    void should_return_the_right_contact_dto(){
        var contactDTO = new ContactDTO("fred", "lastName", "email@domain.com", "techops", "it");

        Assertions.assertThat(ContactAdapter.toDTO(contact)).isEqualTo(contactDTO);
    }

    @Test
    void should_return_the_right_list_of_contact_dto(){
        var contactsDTO = List.of(new ContactDTO("fred", "lastName", "email@domain.com", "techops", "it"),
                new ContactDTO("maxime", "lastName", "email2@domain.com", "lcdlc", "it"),
                new ContactDTO("bruno", "lastName", "email3@domain.com", "oracle", "it"),
                new ContactDTO("bruno", "lastName", "email4@domain.com", "techops", "it")
        );
        Assertions.assertThat(ContactAdapter.toDTO(contacts)).isEqualTo(contactsDTO);
    }


}