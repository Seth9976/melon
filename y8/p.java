package y8;

import kotlin.jvm.internal.q;
import pe.b;

public enum p {
    Off(-1),
    MyEQ(0x270F),
    Flat(106),
    BassBoost(0x71),
    BassReduce(0x72),
    Clean(0x8B),
    Vocal(0x77),
    Pop(109),
    Dance(0x73),
    Ballad(102),
    Rock(0x76),
    Jazz(108),
    RNB(110),
    Latin(0x75),
    Reggae(0x6F),
    Electronic(0x74),
    Club(104),
    Techno(0x70),
    Classical(103),
    HipHop(107),
    Piano(140),
    Acoustic(101);

    public static final p[] N;
    public static final b S;
    public final int a;

    static {
        p.N = arr_p;
        q.g(arr_p, "entries");
        p.S = new b(arr_p);
    }

    public p(int v1) {
        this.a = v1;
    }
}

