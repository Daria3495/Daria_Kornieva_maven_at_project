package org.example;

public class MethodToCover {

    public int getNumber(int x, int y) {
        int z = 0;
        if(x < 0 && y < 10) {
            z = x - y + 100;
        } else {
            z = x - y + 100;
        }

        if(y < 0 || z > 50) {
            z = (z - y) / 2;
        }
        return x + y + z;
    }

}
