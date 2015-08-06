package algorithm.sort;


/**
 * @author mti1301
 * @since 2015/7/7.
 */
class A {
    String a = "aaaa";

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return a;
    }
}

public class B extends A {

    public static void main(String[] args) {
        ClassLoader loader = B.class.getClassLoader();
        while (loader != null){
            System.out.println(loader.getClass().getCanonicalName());
            loader = loader.getParent();
        }
    }
}
