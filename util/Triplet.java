package util;

public class Triplet<P, Q, R> {
    private P first;
    private Q second;
    private R third;

    public Triplet(P first, Q second, R third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public P getFirst() {
        return first;
    }

    public void setFirst(P first) {
        this.first = first;
    }

    public Q getSecond() {
        return second;
    }

    public void setSecond(Q second) {
        this.second = second;
    }

    public R getThird() {
        return third;
    }

    public void setThird(R third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
