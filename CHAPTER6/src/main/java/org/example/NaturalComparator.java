package org.example;

public final class NaturalComparator implements Comparator {
    public static final NaturalComparator INSTANCE = new NaturalComparator();

    private NaturalComparator() {
    }


    public int compare(Object left, Object right) {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        if (!(left instanceof Comparable)) {

            return left.toString().compareTo(right.toString());
        }

        return ((Comparable) left).compareTo(right);
    }
}


