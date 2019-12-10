package pl.coderslab.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class History {


    private ArrayList<Product> lastProducts= new ArrayList<>();

    public List<Product> getLastProducts() {
        return lastProducts;
    }

    public void addProduct(Product p){
        this.lastProducts.add(p);
    }
}
