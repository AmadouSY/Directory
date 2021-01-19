package fr.techops.directory.exposition;

import fr.techops.directory.domain.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactAdapter {
    
    private ContactAdapter(){}

    public static ContactDTO toDTO(Contact contact){
        return new ContactDTO(
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getCompany(),
                contact.getDepartment()
        );
    }

    public static List<ContactDTO> toDTO(List<Contact> contacts){
        return contacts.stream()
                .map(ContactAdapter::toDTO)
                .collect(Collectors.toList());
    }

}
