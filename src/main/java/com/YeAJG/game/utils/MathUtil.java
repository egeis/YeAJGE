package main.java.com.YeAJG.game.utils;

import org.lwjgl.util.vector.Vector3f;

/**
 * @source https://github.com/adelciotto/ParticleSystem-LWJGL/tree/master/src/com/anthdel/verletsystem 
 */
public class MathUtil {
    private static final float RAD;
    private static final int SIN_BITS, SIN_MASK, SIN_COUNT;
    private static final float radFull, radToIndex;
    private static final float[] sin, cos;
    private static final float HALF_PI = 1.57079632679489661923f;
    
    static {
        RAD = (float) Math.PI / 180.0f;

        SIN_BITS = 12;
        SIN_MASK = ~(-1 << SIN_BITS);
        SIN_COUNT = SIN_MASK + 1;

        radFull = (float) (Math.PI * 2.0);
        radToIndex = SIN_COUNT / radFull;

        sin = new float[SIN_COUNT];
        cos = new float[SIN_COUNT];

        for (int i = 0; i < SIN_COUNT; i++) {
            sin[i] = (float) Math.sin((i + 0.5f) / SIN_COUNT * radFull);
            cos[i] = (float) Math.cos((i + 0.5f) / SIN_COUNT * radFull);
        }
    }

    public static final float sin(float rad) {
        return sin[(int) (rad * radToIndex) & SIN_MASK];
    }

    public static final float cos(float rad) {
        return cos[(int) (rad * radToIndex) & SIN_MASK];
    }
    
    public static float findAngle(float srcX, float srcY, 
            float srcZ, float pX, float pY, float pZ) {
        return Vector3f.angle(new Vector3f(srcX,srcY,srcZ), new Vector3f(pX, pY, pZ) );
    }
}
