package com.alexisdrai;

public class PGCD {
    public int pgcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0) {return a;}

        int q = a % b;
        if (q == 0) {return b;}
        else {return pgcd(b, q);}
    }
}
