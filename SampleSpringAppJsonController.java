package tiy.webapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Tisha868 on 5/3/16.
 */
@RestController // returns just json.
public class SampleSpringAppJsonController{

    // post =
    //get =
    @RequestMapping(path = "/person.json", method = RequestMethod.GET)

   // public Person jsonHome(String name, String city, int age) // returns a single object
    public ArrayList<Person> jsonHome(String name, String city, int age) // returns Array list with objects
    {
        Person first = new Person(name,city,age);
        Person second = new Person("Programmer", "Tunapuna", 22);
        ArrayList<Person> myPeople = new ArrayList<Person>();
        myPeople.add(first);
        myPeople.add(second);

       // return new Person(name, city, age); //returns a single person
        return myPeople;
    }
}

