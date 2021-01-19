package fr.techops.directory.infrastructure.persistence;

import fr.techops.directory.domain.Contact;
import fr.techops.directory.domain.Contacts;
import fr.techops.directory.infrastructure.ContactJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ContactsJpa implements Contacts {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactsJpa.class);


    @Autowired
    private ContactsJpaDao contactsJpaDao;

    @Override
    public List<Contact> listAll() {

        return contactsJpaDao.findAll()
                .stream()
                .map(ContactJpa::toContact)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAll(List<Contact> contacts) {
        contactsJpaDao.saveAll(contacts.stream()
            .map(ContactJpa::fromContact)
            .collect(Collectors.toList()));
        LOGGER.info("List is saved");
    }

}
