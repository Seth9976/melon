package Y;

public abstract class w {
    public static final float a;
    public static final float b;
    public static final X0.w c;

    static {
        w.a = 25.0f;
        w.b = 25.0f;
        w.c = new X0.w("SelectionHandleInfo");
    }

    public static final long a(long v) {
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) - 1.0f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20;
    }
}

