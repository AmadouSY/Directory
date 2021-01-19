package fr.techops.directory.domain;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Contacts {

    List<Contact> listAll();
    void saveAll(List<Contact> contacts);

}
