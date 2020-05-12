package øvinger.BinaryComputingIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double>{
    private Iterator<Double> it1;
    private Iterator<Double> it2;
    private BinaryOperator<Double> operator;
    private Double default1;
    private Double default2;

    public BinaryComputingIterator(Iterator<Double> it1, Iterator<Double> it2, BinaryOperator<Double> operator) {
        this.it1 = it1;
        this.it2 = it2;
        this.operator = operator;
    }

    public BinaryComputingIterator(Iterator<Double> it1, Iterator<Double> it2, BinaryOperator<Double> operator, Double default1, Double default2) {
        this.it1 = it1;
        this.it2 = it2;
        this.operator = operator;
        this.default1 = default1;
        this.default2 = default2;
    }

    @Override
    public boolean hasNext() {
       boolean next1 = it1.hasNext() || default1 != null;
       boolean next2 = it2.hasNext() || default2 != null;

       return (it1.hasNext() || it2.hasNext()) && (next2 && next1);
    }

    @Override
    public Double next() {
        double next1 = (it1.hasNext() ? it1.next() : default1);
        double next2 = (it2.hasNext() ? it2.next() : default2);

        return operator.apply(next1, next2);
    }

    public static void main(final String[] args) {
        Iterator<Double> iterator1 = Arrays.asList(2.0, 3.0).iterator();
        Iterator<Double> iterator2 = Arrays.asList(5.0).iterator();

        BinaryOperator<Double> addition = Double::sum;

        // Opprett en ny BinaryComputingIterator som tar inn iterator1 og iterator2 og utfører addisjon på verdiene.
        BinaryComputingIterator binaryIterator = new BinaryComputingIterator(iterator1, iterator2, addition, null, 10.0);

        System.out.println(binaryIterator.next());   // 7.0
        System.out.println(binaryIterator.hasNext()); // true
        System.out.println(binaryIterator.next());
        System.out.println(binaryIterator.hasNext());

    }
}
