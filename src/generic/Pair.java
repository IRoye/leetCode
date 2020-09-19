package generic;

/**
 * 泛型类的练习
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        String a[] = {"abc", "bbb", "aaaaaa", "erere"};
        Pair<String> result = ArrayAlg.minmax(a);
        System.out.println(result.first);
        System.out.println(result.second);
    }
}
class ArrayAlg {

    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(max.compareTo(a[i]) > 0) max = a[i];
            if(min.compareTo(a[i]) < 0) min = a[i];
        }
        return new Pair<String>(max, min);
    }
}
