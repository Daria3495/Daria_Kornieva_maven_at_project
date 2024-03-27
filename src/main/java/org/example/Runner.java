package org.example;

public class Runner {

    public static void test(int x, int y, int expected, String description) {
        MethodToCover theClass = new MethodToCover();
        int actual = theClass.getNumber(x, y);
        if (actual == expected) {
            System.out.printf("%s: Test passed\n", description);
        } else {
            System.out.printf("%s: Test failed\n", description);
        }
    }

    public static void main(String[] args) {

        test(-1,2,4,"X>0; Y>0");
    }

}
