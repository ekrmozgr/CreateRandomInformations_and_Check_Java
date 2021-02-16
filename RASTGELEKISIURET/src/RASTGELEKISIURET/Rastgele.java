/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RASTGELEKISIURET;

/**
 *
 * @author ekrem
 */
public class Rastgele {
    private static int seed = 0;
    private static long long_seed = 0;
    private final static int MULTIPLIER_A = 1664525;
    private final static int INCREMENT_C = 1013904226;
    private static int MODULUS; 
    private static long long_MODULUS;


    public static int randomInt(int max) {
        seed = (int)System.currentTimeMillis();
        MODULUS = max;
        seed = (seed * MULTIPLIER_A + INCREMENT_C) % MODULUS;
        return seed;
    }
    public static long randomLong(long max)
    {
        long_seed = System.currentTimeMillis();
        long_MODULUS = max;
        long_seed = (long_seed * (long)MULTIPLIER_A + (long)INCREMENT_C + (long)randomPositiveInt(500)) % long_MODULUS;
        return long_seed;
    }
    public static int randomPositiveInt(int max) {
        int tmp = randomInt(max);
        if (tmp < 0) {
            seed = tmp * -1;
        }
        return seed;
    }
    public static long randomPositiveLong(long max) {
        long tmp = randomLong(max);
        if (tmp < 0) {
            long_seed = tmp * -1;
        }
        return long_seed;
}
}
