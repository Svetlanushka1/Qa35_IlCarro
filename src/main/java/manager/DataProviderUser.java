package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {



    @DataProvider
    public Iterator<Object[]> datalogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> XXX(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> regData(){
        List<Object[]> list = new ArrayList<>();
        //list.add(new Object[]{new User().withName()})


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataModelUser(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});
        list.add(new Object[]{new User().withEmail("sonya@gmail.com").withPassword("Ss12345$")});
        list.add(new Object[]{new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$")});

        return list.iterator();
    }
}
