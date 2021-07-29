package testmaven;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTest {
    private List<String> names =  Arrays.asList("Sangeeta","Shaurya","Nirmala","Suresh","Kiran","Shraddha");

    @Test
    public void streamFilter() {
        names.stream()
                .filter(p->p.length()>6)
                .forEach(System.out::println);

        names.stream()
                .filter(p->p.length()>6)
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    public void streamMap() {
        names.stream()
                .filter(s->s.endsWith("h"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void streamSort() {
        names.stream()
                .filter(s->s.startsWith("S"))
                .sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void streamBooleanReturn() {
        boolean flag = names.stream()
                .anyMatch(s->s.equalsIgnoreCase("Nirmala"));
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect() {
        Set<String> ls = names.stream()
                .filter(s->s.startsWith("S"))
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(ls);
    }
}
