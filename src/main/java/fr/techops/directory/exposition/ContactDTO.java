package fr.techops.directory.exposition;

public class ContactDTO{
    public final String firstName;
    public final String lastName;
    public final String email;
    public final String company;
    public final String department;

    public ContactDTO(String firstName, String lastName, String email, String company, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.company = company;
        this.department = department;
    }

}


