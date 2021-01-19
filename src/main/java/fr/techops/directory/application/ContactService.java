package fr.techops.directory.application;

import fr.techops.directory.domain.Contact;
import fr.techops.directory.domain.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private Contacts contacts;

    public List<Contact> listContacts() {
        return contacts.listAll();
    }

}
