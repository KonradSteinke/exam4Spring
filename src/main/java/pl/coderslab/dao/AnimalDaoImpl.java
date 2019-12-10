package pl.coderslab.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AnimalDaoImpl implements AnimalDao {
    @Override
    public List<Animal> getList() {
        List<Animal> list=new ArrayList<>();
        list.add(
                new Animal(0,"kitek","kot",0)

        );

        list.add(new Animal(1,"daisy","pies",1));
        list.add(new Animal(2,"bronia","kot",0));
        List<Animal> list1 = list;
        return list1;

    }
}
