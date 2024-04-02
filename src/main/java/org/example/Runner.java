package org.example;

public class Runner {

    public static void calculateArguments(int x, int y, int expected, String description) {
        MethodToCover theClass = new MethodToCover();
        int actual = theClass.getNumber(x, y);
        if (actual == expected) {
            System.out.printf("%s: Test passed\n", description);
        } else {
            System.out.printf("%s: Test failed\n", description);
        }
    }

    public static void main(String[] args) {

        calculateArguments(-1,2,48,"First and second If checked, x<0, y <10, z>50");
        calculateArguments(-50, 4,0,"First If checked, both arguments false for second if, x<0, y <10, z<50");
        calculateArguments(-6,22,41,"First If skipped and second If checked, x<0, y >10, z>50");
        calculateArguments(-80,12,-60,"Both If are skipped, x<0, y >10, z<50");
        calculateArguments(-4,-6,44,"Both If checked and z - skipped, x<0, y <0, z>50");
        calculateArguments(-47,-12,-21,"Both If checked and z - skipped, x<0, y <0, z<50 - может исчерпывающе");
        calculateArguments(7,-3,60,"First If skipped, second If checked and z - skipped, x>0, y <10, z>50");
        calculateArguments(1,9,51,"First If skipped, second If checked, x>0, y <10, z>50");
        calculateArguments(15,21,72,"First If skipped, second If checked, x>0, y >10, z>50");
        calculateArguments(1,62,102,"First If skipped, second If skipped, x>0, y >10, z<50");
        calculateArguments(8,-14,62,"First If skipped, second If checked, x>0, y <0, z>50");
        calculateArguments(1,-1,51,"First If skipped, second If checked, x>0, y <0, z<50");
    }

}
