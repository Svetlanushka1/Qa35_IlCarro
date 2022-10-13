package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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
    public Iterator<Object[]> regDataValid() throws IOException {
        List<Object[]> list = new ArrayList<>();
       //list.add(new Object[]{new User().withName()})
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/registrationSuccess.csv")));
        String line =reader.readLine();  // "Zoa,Dow,zoa@mail.com,Zz12345$"
        while (line!=null){
            String [] split =line.split(",");  //  ["Noa"] ["Snow"] ["kinoa@mail.com"] ["Nn12345$"]
            list.add(new Object[]{new User().withName(split[0]).withLastname(split[1]).withEmail(split[2]).withPassword(split[3])});
            line =reader.readLine();  // null
        }


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
