package com.alexisdrai;

public class PGCD {
    public int pgcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (b == 0) {
            return a;
        }

        if (a % b == 0) {
            return b;
        }

        return pgcd(b, a % b);
    }
}
