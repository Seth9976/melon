package N0;

public final class i implements k {
    public final int a;

    public i(int v) {
        this.a = v;
        super();
    }

    @Override  // N0.k
    public final long a(long v, long v1) {
        switch(this.a) {
            case 0: {
                float f1 = Math.max(Float.intBitsToFloat(((int)(v1 >> 0x20))) / Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
                return ((long)Float.floatToRawIntBits(f1)) << 0x20 | ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL;
            }
            case 1: {
                return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 >> 0x20))) / Float.intBitsToFloat(((int)(v >> 0x20))))) << 0x20 | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL;
            }
            case 2: {
                float f2 = Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)));
                float f3 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
                return ((long)Float.floatToRawIntBits(f2 / f3)) << 0x20 | ((long)Float.floatToRawIntBits(f2 / f3)) & 0xFFFFFFFFL;
            }
            case 3: {
                float f4 = Float.intBitsToFloat(((int)(v1 >> 0x20)));
                float f5 = Float.intBitsToFloat(((int)(v >> 0x20)));
                return ((long)Float.floatToRawIntBits(f4 / f5)) << 0x20 | ((long)Float.floatToRawIntBits(f4 / f5)) & 0xFFFFFFFFL;
            }
            case 4: {
                float f6 = g0.d(v, v1);
                return ((long)Float.floatToRawIntBits(f6)) << 0x20 | ((long)Float.floatToRawIntBits(f6)) & 0xFFFFFFFFL;
            }
            default: {
                if(Float.intBitsToFloat(((int)(v >> 0x20))) <= Float.intBitsToFloat(((int)(v1 >> 0x20))) && Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) <= Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)))) {
                    return 0x3F8000003F800000L;
                }
                float f = g0.d(v, v1);
                return ((long)Float.floatToRawIntBits(f)) << 0x20 | ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL;
            }
        }
    }
}

