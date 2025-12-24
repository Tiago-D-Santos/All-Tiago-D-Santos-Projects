import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("fdf",199));
        people.add(new Person("aaa",666));
        people.add(new Person("fffg",777));


        /* 
        List<Person> peopleRich = new ArrayList<>();
        
        for(Person p: people){
            if(p.bilions>=100)peopleRich.add(p);
        }
        peopleRich.forEach(per -> System.out.println(per.name)); */



        /* List<Person> peopleRich = people.stream()//filter by a condition
            .filter(per -> per.bilions >=100)
            .collect(Collectors.toList());
        System.out.println(peopleRich); */



        /* List<Person> sortList = people.stream()
            .sorted(Comparator.comparing(per -> per.name))//comperator because it is a class that we are comparing
            .collect(Collectors.toList());
        sortList.forEach(per -> System.out.println(per.name)); */

        List<Person> sortandfilter = people.stream()
            .filter(per -> per.bilions >=100)
            .sorted(Comparator.comparing(per -> per.name))
            .collect(Collectors.toList());
            sortandfilter.forEach(per -> System.out.println(per.name));


    }
    static class Person{
        String name;
        int bilions;
        public Person(String name,int bilions){
            this.name= name;
            this.bilions=bilions;
        }
    }
}
