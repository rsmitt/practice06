package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PersonJournal {

    private List<Person> personList = new ArrayList<>();

    public List<Person> getPersonList() {
        return personList;
    }

    public Iterator<Person> getIterator() {
        return new PersonIterator();
    }

    private class PersonIterator implements Iterator<Person> {
        private int position;

        @Override
        public boolean hasNext() {
            return position < personList.size();
        }

        @Override
        public Person next() {
            if (position >= personList.size()) {
                throw new NoSuchElementException("next element absent");
            }

            Person person = personList.get(position);
            ++position;
            return person;
        }
    }
}
