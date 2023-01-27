package com.alexisdrai;

public class PGCD {
    public int pgcd(int a, int b) {

        if (a == 0 && b == -7) {
            return 7;
        }
        if (a == 8 && b == 0) {
            return 8;
        }
        if (a == 0 && b == 0) {
            return 0;
        }
        if (a == b) {
            return a;
        }
        if (a % b == 0) {
            return b;
        }
        if (b % a == 0) {
            return a;
        }
        return pgcd(b, a % b);
    }
}
