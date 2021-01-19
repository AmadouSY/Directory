package fr.techops.directory.infrastructure.persistence;

import fr.techops.directory.infrastructure.ContactJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsJpaDao extends JpaRepository<ContactJpa, Integer> {
}
