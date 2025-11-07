package ie.atu.week7;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }
    public Person create(Person p) {
        return repo.save(p);
    }
    public List<Person> findAll() {
        return repo.findAll();
    }
    public Person findByEmployeeId(String id) {
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public Person findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }

    public Person update(Long id, Person p){
        Person existingPerson = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person Not found"));

        existingPerson.setName(p.getName());
        existingPerson.setEmail(p.getEmail());
        existingPerson.setEmployeeId(p.getEmployeeId());
        existingPerson.setPosition(p.getPosition());
        existingPerson.setDepartment(p.getDepartment());
        return repo.save(p);
    }

    public Person delete(Long id) {
        Person person = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person Not found"));

        repo.delete(person);
        return person;
    }
}
