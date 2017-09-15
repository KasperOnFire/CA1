package generator;

import entity.Address;
import entity.CityInfo;
import entity.Company;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.HashSet;

public class Generator {

    ArrayList<String> firstname;
    ArrayList<String> lastname;
    ArrayList<Hobby> hobby;

    ArrayList<String> compname;
    ArrayList<String> compdesc;

    public Generator() {
        firstname = new ArrayList<>();
        firstname.add("Peter");
        firstname.add("Lise");
        firstname.add("Pider");
        firstname.add("David");
        firstname.add("Kurt");
        firstname.add("Anne");
        firstname.add("Lars");
        firstname.add("Martin");
        firstname.add("Marc");
        firstname.add("Marie");
        firstname.add("Emil");
        lastname = new ArrayList<>();
        lastname.add("Andersen");
        lastname.add("Pedersen");
        lastname.add("Henningsen");
        lastname.add("Møller");
        lastname.add("Andersen");
        lastname.add("Bang");
        lastname.add("Dam");
        lastname.add("Eriksen");
        lastname.add("Friis");
        hobby = new ArrayList<>();
        hobby.add(new Hobby("Hulahop", "Hulaere hele dagen"));
        hobby.add(new Hobby("Poker", "Bowler"));
        hobby.add(new Hobby("Fodbold", "Sparker roev"));
        compname = new ArrayList<>();
        compname.add("Hermansens A/S");
        compname.add("Ishuset");
        compname.add("Medicinen");
        compdesc = new ArrayList<>();
        compdesc.add("Pushere på deltid");
        compdesc.add("Forklaedte stroemere");
        compdesc.add("Peter Pans lejesvende");
    }

    public ArrayList<Person> generatePersons(ArrayList<Integer> zipCodes, int amountOfPeopleInEveryZip) {
        ArrayList<Person> sb = new ArrayList<>();
        for (int i = 0; i < zipCodes.size(); i++) {
            for (long j = 0; j < amountOfPeopleInEveryZip; j++) {
                Person p = new Person();
                p.setEmail("Email" + j + "" + i + "@mail.com");
                p.setFirstName(generateRandomString(firstname));
                p.setLastName(generateRandomString(lastname));
                Address add = new Address();
                add.setStreet("Zip_id: " + j);
                CityInfo cf = new CityInfo();
                cf.setZip(zipCodes.get(i));
                add.setCity(cf);
                p.setAddress(add);
                Hobby hob = hobby.get((int) (Math.random() * hobby.size()));
                hob.getPersons().add(p);
                p.getHobbies().add(hob);
                Phone phone = new Phone();
                phone.setNumber(createPhone());
                p.getPhone().add(phone);
                sb.add(p);
            }
        }
        return sb;
    }

    public ArrayList<Company> generateCompanies(ArrayList<Integer> zipCodes, int amountOfPeopleInEveryZip) {
        ArrayList<Company> sb = new ArrayList<>();
        for (int i = 0;
                i < zipCodes.size() / 6;
                i++) {
            for (int j = 0; j < amountOfPeopleInEveryZip; j++) {
                Company c = new Company();
                c.setDescription(generateRandomString(compdesc));
                c.setName(generateRandomString(compname));
                c.setNumEmployees((int) (Math.random() * 100));
                c.setMarketValue((int) (Math.random() * 10000000));
                c.setCvr(createCvr());
                c.setEmail("CompEmail" + j + i + "@mail.com");

                Address add = new Address();
                add.setStreet("Zip_id: " + j);
                CityInfo cf = new CityInfo();
                cf.setZip(zipCodes.get(i));
                add.setCity(cf);
                c.setAddress(add);
                Phone phone = new Phone();
                phone.setNumber(createPhone());
                c.getPhone().add(phone);
                sb.add(c);
            }
        }
        return sb;
    }

    private String generateRandomString(ArrayList<String> al) {
        int random = (int) (Math.random() * al.size());
        return al.get(random);
    }

    private HashSet<Integer> usedPhoneNumbers = new HashSet();
    private HashSet<Integer> usedCvrNumbers = new HashSet();

    private int generateNumber() {
        String number = "";
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                number += (int) (Math.random() * 8 + 1);
            }
            number += (int) (Math.random() * 9);
        }
        return Integer.parseInt(number);
    }

    private String createCvr() {
        int number = generateNumber();
        while (true) {
            if (usedCvrNumbers.contains(number)) {
                System.out.println("failed attempt");
                number++;
                if (number < 99999999) {
                    number = generateNumber();
                }
            } else {
                System.out.println(number);
                usedCvrNumbers.add(number);
                return number + "";
            }
        }
    }

    private String createPhone() {
        int number = generateNumber();
        while (true) {
            if (usedPhoneNumbers.contains(number)) {
                System.out.println("failed attempt");
                number++;
                if (number < 99999999) {
                    number = generateNumber();
                }
            } else {
                System.out.println(number);
                usedPhoneNumbers.add(number);
                return number + "";
            }
        }
    }
}
