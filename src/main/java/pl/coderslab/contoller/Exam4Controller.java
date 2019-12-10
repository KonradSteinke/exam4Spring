package pl.coderslab.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import pl.coderslab.dao.Animal;
import pl.coderslab.dao.AnimalDaoImpl;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"param1", "param2"})
public class Exam4Controller {

    @Autowired
    private AnimalDaoImpl animal;

    @RequestMapping("/")
    public String body() {
        return "home";
    }

    @RequestMapping("/first/{param1}/{param2}")
    public String getDetailsPath(@PathVariable String param1,
                                 @PathVariable String param2,
                                 Model model) {

        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "first";
    }

    @RequestMapping("/check")
    public String check(HttpSession ses, Model model) {

        String par1 = (String) ses.getAttribute("param1");
        String par2 = (String) ses.getAttribute("param2");

        model.addAttribute("param1", par1);
        model.addAttribute("param2", par2);
        return "check";
    }

    @RequestMapping("/createCookie/{cookieName}/{cookieValue}/{cookieTime}")
    @ResponseBody
    public String getDetailsPath(@PathVariable String cookieName,
                                 @PathVariable String cookieValue,
                                 @PathVariable int cookieTime,
                                 HttpServletResponse response) {

        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(cookieTime * 60);
        cookie.setPath("/");
        response.addCookie(cookie);


        return "ustawiono ciasteczko :" + cookieName + " " + cookieValue + " " + cookieTime + " minut";
    }


    @GetMapping("/list")
    @ResponseBody
    public String readAllCookies(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining("\n "));
        }

        return "No cookies";
    }


    @RequestMapping("/deleteCookie/{cookieName}")
    @ResponseBody
    public String delete(@PathVariable String cookieName,
                         HttpServletRequest request,HttpServletResponse res
                         ) {


        if (WebUtils.getCookie(request, cookieName) != null) {
            Cookie c = WebUtils.getCookie(request, cookieName);
            String v= c.getValue();
            c.setMaxAge(0);
            c.setPath("/");
            res.addCookie(c);
            return v;
        } else {
            return "nie ma takiego ciasteczka";
        }


    }


    @RequestMapping("/animal")
    public String animial(Model model){

        List<Animal> list=animal.getList();
        model.addAttribute("animals",list);
        return "animal";
    }


    @RequestMapping("/animal/{id:\\d+}/delete")
    public String animaldel(Model model, @PathVariable int id){
        List<Animal> list=animal.getList();
        List<Animal> toDel=new ArrayList<>();
        for(Animal animal:list){
            if(animal.getId()==id){
                toDel.add(animal);
            }
        }
        list.removeAll(toDel);
        model.addAttribute("animals",list);
        return "animal";
    }

    @RequestMapping("/animal/{id:\\d+}/status")
    public String status(Model model, @PathVariable int id){
        List<Animal> list=animal.getList();
        List<Animal> temp=animal.getList();
        for(Animal animal:list){
            if(animal.getId()==id){
                int status=animal.getStatus();
                if(status==0) animal.setStatus(1);
                else if(status==1) animal.setStatus(0);
                else return "animal";

            }

        }
        model.addAttribute("animals",list);
        return "animal";
    }






}









