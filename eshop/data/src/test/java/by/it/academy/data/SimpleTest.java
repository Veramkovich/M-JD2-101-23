package by.it.academy.data;

import java.util.List;

public class SimpleTest {

    public static void main(String[] args) {
        A a1 = new A();
        B b1 = new B();

        a1.setB(b1);
        b1.setA(a1);

        System.out.println("b1 has a=" + b1.getA());
        System.out.println("a1 has b=" + a1.getB());

    }

}

class A {

    private B b;

    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }
}

class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}

class C {

    List<A> aList;

}