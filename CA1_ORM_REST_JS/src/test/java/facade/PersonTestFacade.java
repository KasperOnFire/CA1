package facade;

import entity.Person;
import interfaces.PersonFacadeInterface;
import java.util.ArrayList;
import java.util.List;
import testData.TestGen;

public class PersonTestFacade implements PersonFacadeInterface {

    public TestGen gen;

    public PersonTestFacade(TestGen gen) {
        this.gen = gen;
    }

    @Override
    public Person createPerson(Person person) {
        gen.pList.add(person);
        return gen.pList.get(gen.pList.size() - 1);
    }

    @Override
    public Person deletePerson(long id) {
        Person p = null;
        for (Person person : gen.pList) {
            if (person.getId() == id) {
                p = person;
                gen.pList.remove(p);
                break;
            }
        }
        return p;
    }

    @Override
    public Person updatePerson(Person person) {
        Person p = null;
        Person toRemove = null;
        for (Person person1 : gen.pList) {
            if (person1.getId() == person.getId()) {
                p = person;
                toRemove = person1;

            }
        }
        gen.pList.add(p);
        gen.pList.remove(toRemove);
        return p;
    }

    @Override
    public Person getPerson(long id) {
        for (Person person : gen.pList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        return gen.pList;
    }

}
