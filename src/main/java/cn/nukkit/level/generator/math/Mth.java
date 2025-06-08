package cn.nukkit.level.generator.math;

import cn.nukkit.math.NukkitRandom;

public final class Mth {
    public static int nextInt(final NukkitRandom random, final int origin, final int bound) {
        return origin >= bound ? origin : random.nextBoundedInt(bound - origin + 1) + origin;
    }

    public static int getSeed(int x, int y, int z) {
        long xord = (x * 0x2fc20fL) ^ z * 0x6ebfff5L ^ (long) y;
        return (int) ((xord * 0x285b825 + 0xb) * xord);
    }

    public static int log2PowerOfTwo(int powerOfTwo) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(powerOfTwo);
    }

    public static int smallestEncompassingPowerOfTwo(int v) {
        if (v == 0) {
            return 1;
        }
        v--;
        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        return (v | v >> 16) + 1;
    }

    public static long smallestEncompassingPowerOfTwo(long v) {
        if (v == 0) {
            return 1;
        }
        v--;
        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        v |= v >> 16;
        return (v | v >> 32) + 1;
    }

}
