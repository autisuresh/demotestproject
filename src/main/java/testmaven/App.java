package testmaven;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ArrayList<String> names = new ArrayList<>();
//        names.add("Shaurya");
//        names.add("Nirmala");names.add("Suresh");
//        names.add("Kiran");names.add("Shraddha");

        long cnt =  Stream.of("Shaurya","Nirmala","Suresh","Kiran","Shraddha").filter(a->a.startsWith("S")).count();
        //long cnt = names.stream().filter(a->a.startsWith("S")).count();
        System.out.println(cnt);

        Stream.of("Sangeeta","Shaurya","Nirmala","Suresh","Kiran","Shraddha").filter(p->p.length()>6).forEach(System.out::println);
        Stream.of("Sangeeta","Shaurya","Nirmala","Suresh","Kiran","Shraddha").filter(p->p.length()>6).limit(1).forEach(System.out::println);

    }
}
