package org.example.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
/*        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            //System.out.println(value);
        }

        ListIterator it2 = list.listIterator();
        while (it2.hasNext()) {
            //System.out.println(it2.next());
        }

        System.out.println("from end...");
        while (it2.hasPrevious()) {
            //System.out.println(it2.previous());
        }*/

        PersonJournal journal = new PersonJournal();
        journal.getPersonList().add(new Person("1", "Anton"));
        journal.getPersonList().add(new Person("2", "Anna"));
        journal.getPersonList().add(new Person("3", "Petr"));

        Iterator<Person> iterator = journal.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
