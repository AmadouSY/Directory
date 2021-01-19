package fr.techops.directory.exposition;

import fr.techops.directory.application.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "/contacts")
public class ContactExposition {

    @Autowired
    private ContactService contactService;

    @GetMapping("/all")
    public @ResponseBody
    List<ContactDTO> getContacts(){
        return ContactAdapter.toDTO(contactService.listContacts());
    }

    @RequestMapping("/hello")
    public String index() {
        return "/staindex.html";
    }
}
