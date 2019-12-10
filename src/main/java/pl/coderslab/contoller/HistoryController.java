package pl.coderslab.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.History;
import pl.coderslab.dao.Product;

import java.util.Random;

@Controller
public class HistoryController {

    @Autowired
    private History history;

    @RequestMapping("/add-history")

    public String addToHistory() {
        Random rand = new Random();
        history.addProduct(new Product("prod" + rand.nextInt(10), rand.nextDouble()));
        return "history";
    }



    @RequestMapping("/show-history")
    @ResponseBody
    public String show() {
         return history.getLastProducts().toString();
    }
}
