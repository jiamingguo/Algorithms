package Medium.DesignTicTacToe_348;

/**
 * Created by gjm19_000 on 3/22/2017.
 */
public class test {
    public static void main(String args[]){
        DesignTicTacToe_348 test = new DesignTicTacToe_348(3);
        System.out.println(test.move(0,0,1));
        System.out.println(test.move(0,2,2));
        System.out.println(test.move(2,2,1));
        System.out.println(test.move(1,1,2));
        System.out.println(test.move(2,0,1));
        System.out.println(test.move(1,0,2));
        System.out.println(test.move(2,1,1));
    }
}
