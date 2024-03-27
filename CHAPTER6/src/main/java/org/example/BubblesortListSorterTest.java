package org.example;

public class BubblesortListSorterTest extends AbstractListSorterTest{
    protected  ListSorter createListSorter(Comparator comparator) {

        return new BubblesortListSorter(comparator);
    }

}
