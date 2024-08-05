package helper;

import model.Tutor;

import java.util.Comparator;

public class SortTutorByName implements Comparator<Tutor> {
    @Override
    public int compare(Tutor tutor1, Tutor tutor2) {
        return tutor1.getFullName().compareTo(tutor2.getFullName());
    }
}