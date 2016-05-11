package tiy.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Tisha868 on 5/3/16.
 */
@Controller //<<-- comments 4 compiler & controller. This class is a = controller.
public class SampleSpringAppController {

    @RequestMapping(path = "/Lioness", method = RequestMethod.GET)  // takes 2 Parameters name of the path & method.
    // Path variable doesn't have to be the same Name as the view= person.html file.

    //query string comes After the ? in the URL-->>
    // http://localhost:8080/person?  name=Tisha&city=Trinidad&age=22 = made of Name valued pairs: name=, city=, age=
    //parameters of the Method,, Match the parameters in the query string.

    public String samePerson(Model model, String name, String city, int age) { //View & Controller share the= Model.
        // Path & method^^ doesn't have to be he same.

        Person p = new Person(name, city, age); // cre8ng object *p* of type Person.
        model.addAttribute("person", p); // how we Add things to the Model.

        Person someoneElse = new Person("Programmer", "Trinidad", 23); // cre8 object *someoneElse* of type Person.
        model.addAttribute("secondPerson", someoneElse); // add person to the model. Name of variable dosnt have to
        // be the same as the attribute.

        return "person"; // takes the name of the View: person.html to display.
    }

    @RequestMapping(path = "/", method = RequestMethod.GET) // forward slash with nothing behind it, no query string
    public String home(Model model, HttpSession session) { // home method
        // allows us to keep things in a session btwn multiple
        // requests. can store thing in a session to make them available.
        model.addAttribute("name", session.getAttribute("userName")); // adding attribute called name to the model
        // session attribute called variable userName. session will Keep login name unless u restart Server.
        session.removeAttribute("userName"); // added session.removeAttribute to the Login, to Clear login field
        // after you Refresh page.
        return "home";
    }

    // http://localhost:8080/
    //You should use POST: If the form is updating data, or includes sensitive information (password). POST offers
// better security because the submitted data is not visible in the page address.
    @RequestMapping(path = "/login", method = RequestMethod.POST) // RequestMethod is a POST. matches in
    // the view: home.html
    public String login(HttpSession session, String userName) { //Login method;
        session.setAttribute("userName", userName);
        return "redirect:/"; // redirect:/ = forwards slash; takes you to the home method^^
    }

    @RequestMapping(path = "/chat", method = RequestMethod.GET) //

    public String chat(Model model, String message) { //
        WebChatClient webChatClient = new WebChatClient();
        webChatClient.sendMessage(message);
//        session.setAttribute("userName", userName);
        model.addAttribute(webChatClient);

        return "chat";
    }

    @RequestMapping(path = "/test-collection", method = RequestMethod.GET) //

    public String test(Model model, HttpSession session) { //

//        String  firststring = "1 array";
//        String  secondstring= "2 array";
//        String  thirdstring= "MORE STRINGSSSS";
//
//        ArrayList<String> elements = new ArrayList<String>();
//        elements.add(firststring);
//        elements.add(secondstring);
//        elements.add(thirdstring);
//
//        model.addAttribute("test-strings",elements ); // model.attribute; view will use that name to refer to your
//        // arraylist.

        Person firstPerson = new Person("Tisha" , "Trinidad", 22);
        Person secondPerson = new Person("Lynette","Gawga", 67);
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(firstPerson);
        persons.add(secondPerson);

        model.addAttribute("small people",persons );
        return "test";
    }
}

