package com.alexisdrai;

public class PGCD {
    public int pgcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (b != 0 && (a == 0 || a % b == 0)) {
            return b;
        }
        if (b == 0 || b % a == 0) {
            return a;
        }

        return pgcd(b, a % b);
    }
}
