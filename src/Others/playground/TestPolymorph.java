package Others.playground;

/**
 * Created by gjm19_000 on 8/19/2017.
 */
public class TestPolymorph implements PolyTest {
    public void func1() {
        System.out.println("this is func 1");

    }

    public void func2(){
        System.out.println("This is func 2. Which shouldn't be called from interface");
    }
}


