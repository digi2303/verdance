package com.teamabode.verdance.core.level;

public final class OpenSimplexNoise2 {
    private static final long PRIME_X = 0x5205402B9270C86FL;
    private static final long PRIME_Y = 0x598CD327003817B5L;
    private static final long HASH_MULTIPLIER = 0x53A3F72DEEC546F5L;

    private static final double SKEW_2D = 0.366025403784439;
    private static final double UNSKEW_2D = -0.21132486540518713;

    private static final int N_GRADS_2D_EXPONENT = 7;
    private static final int N_GRADS_2D = 1 << N_GRADS_2D_EXPONENT;
    private static final double NORMALIZER_2D = 0.01001634121365712;
    private static final float RSQUARED_2D = 0.5f;

    private static final float[] GRADIENTS_2D;

    static {
        GRADIENTS_2D = new float[N_GRADS_2D * 2];
        float[] grad2 = {
                0.38268343236509f, 0.923879532511287f,
                0.923879532511287f, 0.38268343236509f,
                0.923879532511287f, -0.38268343236509f,
                0.38268343236509f, -0.923879532511287f,
                -0.38268343236509f, -0.923879532511287f,
                -0.923879532511287f, -0.38268343236509f,
                -0.923879532511287f, 0.38268343236509f,
                -0.38268343236509f, 0.923879532511287f,
                0.130526192220052f, 0.99144486137381f,
                0.608761429008721f, 0.793353340291235f,
                0.793353340291235f, 0.608761429008721f,
                0.99144486137381f, 0.130526192220051f,
                0.99144486137381f, -0.130526192220051f,
                0.793353340291235f, -0.60876142900872f,
                0.608761429008721f, -0.793353340291235f,
                0.130526192220052f, -0.99144486137381f,
                -0.130526192220052f, -0.99144486137381f,
                -0.608761429008721f, -0.793353340291235f,
                -0.793353340291235f, -0.608761429008721f,
                -0.99144486137381f, -0.130526192220052f,
                -0.99144486137381f, 0.130526192220051f,
                -0.793353340291235f, 0.608761429008721f,
                -0.608761429008721f, 0.793353340291235f,
                -0.130526192220052f, 0.99144486137381f,
        };
        for (int i = 0; i < grad2.length; i++) {
            grad2[i] = (float) (grad2[i] / NORMALIZER_2D);
        }
        for (int i = 0, j = 0; i < GRADIENTS_2D.length; i++, j++) {
            if (j == grad2.length) {
                j = 0;
            }
            GRADIENTS_2D[i] = grad2[j];
        }
    }

    private final long seed;

    public OpenSimplexNoise2(long seed) {
        this.seed = seed;
    }

    public float sample(double x, double y) {
        double s = SKEW_2D * (x + y);
        return unskewedBase(this.seed, x + s, y + s);
    }

    private static float unskewedBase(long seed, double xs, double ys) {
        int xsb = fastFloor(xs);
        int ysb = fastFloor(ys);
        float xi = (float) (xs - xsb);
        float yi = (float) (ys - ysb);

        long xsbp = xsb * PRIME_X;
        long ysbp = ysb * PRIME_Y;

        float t = (xi + yi) * (float) UNSKEW_2D;
        float dx0 = xi + t;
        float dy0 = yi + t;

        float value = 0;
        float a0 = RSQUARED_2D - dx0 * dx0 - dy0 * dy0;
        if (a0 > 0) {
            value = (a0 * a0) * (a0 * a0) * grad(seed, xsbp, ysbp, dx0, dy0);
        }

        float a1 = (float) (2 * (1 + 2 * UNSKEW_2D) * (1 / UNSKEW_2D + 2)) * t
                + ((float) (-2 * (1 + 2 * UNSKEW_2D) * (1 + 2 * UNSKEW_2D)) + a0);
        if (a1 > 0) {
            float dx1 = dx0 - (float) (1 + 2 * UNSKEW_2D);
            float dy1 = dy0 - (float) (1 + 2 * UNSKEW_2D);
            value += (a1 * a1) * (a1 * a1) * grad(seed, xsbp + PRIME_X, ysbp + PRIME_Y, dx1, dy1);
        }

        if (dy0 > dx0) {
            float dx2 = dx0 - (float) UNSKEW_2D;
            float dy2 = dy0 - (float) (UNSKEW_2D + 1);
            float a2 = RSQUARED_2D - dx2 * dx2 - dy2 * dy2;
            if (a2 > 0) {
                value += (a2 * a2) * (a2 * a2) * grad(seed, xsbp, ysbp + PRIME_Y, dx2, dy2);
            }
        } else {
            float dx2 = dx0 - (float) (UNSKEW_2D + 1);
            float dy2 = dy0 - (float) UNSKEW_2D;
            float a2 = RSQUARED_2D - dx2 * dx2 - dy2 * dy2;
            if (a2 > 0) {
                value += (a2 * a2) * (a2 * a2) * grad(seed, xsbp + PRIME_X, ysbp, dx2, dy2);
            }
        }

        return value;
    }

    private static float grad(long seed, long xsvp, long ysvp, float dx, float dy) {
        long hash = seed ^ xsvp ^ ysvp;
        hash *= HASH_MULTIPLIER;
        hash ^= hash >> (64 - N_GRADS_2D_EXPONENT + 1);
        int gi = (int) hash & ((N_GRADS_2D - 1) << 1);
        return GRADIENTS_2D[gi | 0] * dx + GRADIENTS_2D[gi | 1] * dy;
    }

    private static int fastFloor(double x) {
        int xi = (int) x;
        return x < xi ? xi - 1 : xi;
    }
}
