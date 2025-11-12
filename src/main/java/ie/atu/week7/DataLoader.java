package ie.atu.week7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Address address1 = new Address("Galway", "g1234567");
        Person testData = new Person("Lance", "Lance@atu.ie", "1234", "Student", "Software", address1);

        personRepository.save(testData);
    }
}
