package com.alexisdrai;

public class PGCD {
    public int pgcd(int a, int b) {

        if (a == 0) {
            return Math.abs(b);
        }
        if (b == 0) {
            return Math.abs(a);
        }
        if (a == 0 && b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        }
        if (a % b == 0) {
            return Math.abs(b);
        }
        if (b % a == 0) {
            return Math.abs(a);
        }
        return pgcd(b, a % b);
    }
}
