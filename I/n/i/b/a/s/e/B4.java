package i.n.i.b.a.s.e;

import java.util.UUID;

public abstract class b4 {
    public static final UUID a;
    public static final UUID b;
    public static final UUID c;
    public static final UUID d;
    public static final UUID e;

    static {
        b4.a = new UUID(0L, 0L);
        b4.b = new UUID(0x1077EFECC0B24D02L, 0xACE33C1E52E2FB4BL);
        b4.c = new UUID(0xE2719D58A985B3C9L, 0x781AB030AF78D30EL);
        b4.d = new UUID(0xEDEF8BA979D64ACEL, -6645017420763422227L);
        b4.e = new UUID(0x9A04F07998404286L, 0xAB92E65BE0885F95L);
    }

    public static long a(long v) [...] // 潜在的解密器

    public static long b(long v) {
        return v == 0x8000000000000001L || v == 0x8000000000000000L ? v : v / 1000L;
    }
}

