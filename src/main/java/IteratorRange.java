import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorRange {
    static class Range implements Iterable<Integer>{
        int head, tail;

        public Range(int head, int tail){
            this.tail = tail;
            this.head = head;
        }

        @Override
        public Iterator iterator() {
            return new RangeIterator(this);
        }

        public static List<Integer> fromTo(int head, int tail){
            Range range = new Range(head, tail);
            Iterator<Integer> it = range.iterator();
            ArrayList<Integer> list = new ArrayList<>();
            while(it.hasNext()){
                int current = it.next();
                list.add(current);
            }
            return list;
        }

        class RangeIterator implements java.util.Iterator<Integer> {
            private Integer cursor;

            public RangeIterator(Range obj){
                this.cursor = obj.head;
            }
            @Override
            public boolean hasNext() {
                return this.cursor < Range.this.tail;
            }

            @Override
            public Integer next() {
                if (!this.hasNext()){
                    throw new NoSuchElementException();
                }
                int current = cursor;
                cursor++;
                return current;
            }
        }

        public static void main(String[] args) {
            for (int i : Range.fromTo(14, 23)) {
                System.out.println(i);
            }
        }
    }
}