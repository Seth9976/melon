package i.n.i.b.a.s.e;

import I6.z;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import b2.e;
import com.iloen.melon.custom.S0;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l4 implements bb, g0 {
    public static final c5 B;
    public static final c5 D;
    public static final c5 E;
    public static l4 G;
    public final K5 a;
    public final ab b;
    public final Y2 c;
    public final E4 d;
    public final boolean e;
    public int f;
    public long g;
    public long h;
    public int i;
    public long j;
    public long k;
    public long l;
    public long m;
    public static final U9 n;
    public static final c5 o;
    public static final c5 r;
    public static final c5 w;

    static {
        U9 u90;
        S0 s00 = new S0(28, false);
        s00.b = b5.b();
        int v = 0;
        s00.D("AD", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("AE", new Integer[]{1, 4, 4, 4, 2, 2});
        s00.D("AF", new Integer[]{4, 4, 3, 4, 2, 2});
        s00.D("AG", new Integer[]{4, 2, 1, 4, 2, 2});
        s00.D("AI", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("AL", new Integer[]{1, 1, 1, 1, 2, 2});
        s00.D("AM", new Integer[]{2, 2, 1, 3, 2, 2});
        s00.D("AO", new Integer[]{3, 4, 3, 1, 2, 2});
        s00.D("AR", new Integer[]{2, 4, 2, 1, 2, 2});
        s00.D("AS", new Integer[]{2, 2, 3, 3, 2, 2});
        s00.D("AT", new Integer[]{0, 1, 0, 0, 0, 2});
        s00.D("AU", new Integer[]{0, 2, 0, 1, 1, 2});
        s00.D("AW", new Integer[]{1, 2, 0, 4, 2, 2});
        s00.D("AX", new Integer[]{0, 2, 2, 2, 2, 2});
        s00.D("AZ", new Integer[]{3, 3, 3, 4, 4, 2});
        s00.D("BA", new Integer[]{1, 1, 0, 1, 2, 2});
        s00.D("BB", new Integer[]{0, 2, 0, 0, 2, 2});
        s00.D("BD", new Integer[]{2, 0, 3, 3, 2, 2});
        s00.D("BE", new Integer[]{0, 0, 2, 3, 2, 2});
        s00.D("BF", new Integer[]{4, 4, 4, 2, 2, 2});
        s00.D("BG", new Integer[]{0, 1, 0, 0, 2, 2});
        s00.D("BH", new Integer[]{1, 0, 2, 4, 2, 2});
        s00.D("BI", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("BJ", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("BL", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("BM", new Integer[]{0, 2, 0, 0, 2, 2});
        s00.D("BN", new Integer[]{3, 2, 1, 0, 2, 2});
        s00.D("BO", new Integer[]{1, 2, 4, 2, 2, 2});
        s00.D("BQ", new Integer[]{1, 2, 1, 2, 2, 2});
        s00.D("BR", new Integer[]{2, 4, 3, 2, 2, 2});
        s00.D("BS", new Integer[]{2, 2, 1, 3, 2, 2});
        s00.D("BT", new Integer[]{3, 0, 3, 2, 2, 2});
        s00.D("BW", new Integer[]{3, 4, 1, 1, 2, 2});
        s00.D("BY", new Integer[]{1, 1, 1, 2, 2, 2});
        s00.D("BZ", new Integer[]{2, 2, 2, 2, 2, 2});
        s00.D("CA", new Integer[]{0, 3, 1, 2, 4, 2});
        s00.D("CD", new Integer[]{4, 2, 2, 1, 2, 2});
        s00.D("CF", new Integer[]{4, 2, 3, 2, 2, 2});
        s00.D("CG", new Integer[]{3, 4, 2, 2, 2, 2});
        s00.D("CH", new Integer[]{0, 0, 0, 0, 1, 2});
        s00.D("CI", new Integer[]{3, 3, 3, 3, 2, 2});
        s00.D("CK", new Integer[]{2, 2, 3, 0, 2, 2});
        s00.D("CL", new Integer[]{1, 1, 2, 2, 2, 2});
        s00.D("CM", new Integer[]{3, 4, 3, 2, 2, 2});
        s00.D("CN", new Integer[]{2, 2, 2, 1, 3, 2});
        s00.D("CO", new Integer[]{2, 3, 4, 2, 2, 2});
        s00.D("CR", new Integer[]{2, 3, 4, 4, 2, 2});
        s00.D("CU", new Integer[]{4, 4, 2, 2, 2, 2});
        s00.D("CV", new Integer[]{2, 3, 1, 0, 2, 2});
        s00.D("CW", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("CY", new Integer[]{1, 1, 0, 0, 2, 2});
        s00.D("CZ", new Integer[]{0, 1, 0, 0, 1, 2});
        s00.D("DE", new Integer[]{0, 0, 1, 1, 0, 2});
        s00.D("DJ", new Integer[]{4, 0, 4, 4, 2, 2});
        s00.D("DK", new Integer[]{0, 0, 1, 0, 0, 2});
        s00.D("DM", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("DO", new Integer[]{3, 4, 4, 4, 2, 2});
        s00.D("DZ", new Integer[]{3, 3, 4, 4, 2, 4});
        s00.D("EC", new Integer[]{2, 4, 3, 1, 2, 2});
        s00.D("EE", new Integer[]{0, 1, 0, 0, 2, 2});
        s00.D("EG", new Integer[]{3, 4, 3, 3, 2, 2});
        s00.D("EH", new Integer[]{2, 2, 2, 2, 2, 2});
        s00.D("ER", new Integer[]{4, 2, 2, 2, 2, 2});
        s00.D("ES", new Integer[]{0, 1, 1, 1, 2, 2});
        s00.D("ET", new Integer[]{4, 4, 4, 1, 2, 2});
        s00.D("FI", new Integer[]{0, 0, 0, 0, 0, 2});
        s00.D("FJ", new Integer[]{3, 0, 2, 3, 2, 2});
        s00.D("FK", new Integer[]{4, 2, 2, 2, 2, 2});
        s00.D("FM", new Integer[]{3, 2, 4, 4, 2, 2});
        s00.D("FO", new Integer[]{1, 2, 0, 1, 2, 2});
        s00.D("FR", new Integer[]{1, 1, 2, 0, 1, 2});
        s00.D("GA", new Integer[]{3, 4, 1, 1, 2, 2});
        s00.D("GB", new Integer[]{0, 0, 1, 1, 1, 2});
        s00.D("GD", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("GE", new Integer[]{1, 1, 1, 2, 2, 2});
        s00.D("GF", new Integer[]{2, 2, 2, 3, 2, 2});
        s00.D("GG", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("GH", new Integer[]{3, 1, 3, 2, 2, 2});
        s00.D("GI", new Integer[]{0, 2, 0, 0, 2, 2});
        s00.D("GL", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("GM", new Integer[]{4, 3, 2, 4, 2, 2});
        s00.D("GN", new Integer[]{4, 3, 4, 2, 2, 2});
        s00.D("GP", new Integer[]{2, 1, 2, 3, 2, 2});
        s00.D("GQ", new Integer[]{4, 2, 2, 4, 2, 2});
        s00.D("GR", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("GT", new Integer[]{3, 2, 3, 1, 2, 2});
        s00.D("GU", new Integer[]{1, 2, 3, 4, 2, 2});
        s00.D("GW", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("GY", new Integer[]{3, 3, 3, 4, 2, 2});
        s00.D("HK", new Integer[]{0, 1, 2, 3, 2, 0});
        s00.D("HN", new Integer[]{3, 1, 3, 3, 2, 2});
        s00.D("HR", new Integer[]{1, 1, 0, 0, 3, 2});
        s00.D("HT", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("HU", new Integer[]{0, 0, 0, 0, 0, 2});
        s00.D("ID", new Integer[]{3, 2, 3, 3, 2, 2});
        s00.D("IE", new Integer[]{0, 0, 1, 1, 3, 2});
        s00.D("IL", new Integer[]{1, 0, 2, 3, 4, 2});
        s00.D("IM", new Integer[]{0, 2, 0, 1, 2, 2});
        s00.D("IN", new Integer[]{2, 1, 3, 3, 2, 2});
        s00.D("IO", new Integer[]{4, 2, 2, 4, 2, 2});
        s00.D("IQ", new Integer[]{3, 3, 4, 4, 2, 2});
        s00.D("IR", new Integer[]{3, 2, 3, 2, 2, 2});
        s00.D("IS", new Integer[]{0, 2, 0, 0, 2, 2});
        s00.D("IT", new Integer[]{0, 4, 0, 1, 2, 2});
        s00.D("JE", new Integer[]{2, 2, 1, 2, 2, 2});
        s00.D("JM", new Integer[]{3, 3, 4, 4, 2, 2});
        s00.D("JO", new Integer[]{2, 2, 1, 1, 2, 2});
        s00.D("JP", new Integer[]{0, 0, 0, 0, 2, 1});
        s00.D("KE", new Integer[]{3, 4, 2, 2, 2, 2});
        s00.D("KG", new Integer[]{2, 0, 1, 1, 2, 2});
        s00.D("KH", new Integer[]{1, 0, 4, 3, 2, 2});
        s00.D("KI", new Integer[]{4, 2, 4, 3, 2, 2});
        s00.D("KM", new Integer[]{4, 3, 2, 3, 2, 2});
        s00.D("KN", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("KP", new Integer[]{4, 2, 2, 2, 2, 2});
        s00.D("KR", new Integer[]{0, 0, 1, 3, 1, 2});
        s00.D("KW", new Integer[]{1, 3, 1, 1, 1, 2});
        s00.D("KY", new Integer[]{1, 2, 0, 2, 2, 2});
        s00.D("KZ", new Integer[]{2, 2, 2, 3, 2, 2});
        s00.D("LA", new Integer[]{1, 2, 1, 1, 2, 2});
        s00.D("LB", new Integer[]{3, 2, 0, 0, 2, 2});
        s00.D("LC", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("LI", new Integer[]{0, 2, 2, 2, 2, 2});
        s00.D("LK", new Integer[]{2, 0, 2, 3, 2, 2});
        s00.D("LR", new Integer[]{3, 4, 4, 3, 2, 2});
        s00.D("LS", new Integer[]{3, 3, 2, 3, 2, 2});
        s00.D("LT", new Integer[]{0, 0, 0, 0, 2, 2});
        s00.D("LU", new Integer[]{1, 0, 1, 1, 2, 2});
        s00.D("LV", new Integer[]{0, 0, 0, 0, 2, 2});
        s00.D("LY", new Integer[]{4, 2, 4, 3, 2, 2});
        s00.D("MA", new Integer[]{3, 2, 2, 1, 2, 2});
        s00.D("MC", new Integer[]{0, 2, 0, 0, 2, 2});
        s00.D("MD", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("ME", new Integer[]{1, 2, 0, 1, 2, 2});
        s00.D("MF", new Integer[]{2, 2, 1, 1, 2, 2});
        s00.D("MG", new Integer[]{3, 4, 2, 2, 2, 2});
        s00.D("MH", new Integer[]{4, 2, 2, 4, 2, 2});
        s00.D("MK", new Integer[]{1, 1, 0, 0, 2, 2});
        s00.D("ML", new Integer[]{4, 4, 2, 2, 2, 2});
        s00.D("MM", new Integer[]{2, 3, 3, 3, 2, 2});
        s00.D("MN", new Integer[]{2, 4, 2, 2, 2, 2});
        s00.D("MO", new Integer[]{0, 2, 4, 4, 2, 2});
        s00.D("MP", new Integer[]{0, 2, 2, 2, 2, 2});
        s00.D("MQ", new Integer[]{2, 2, 2, 3, 2, 2});
        s00.D("MR", new Integer[]{3, 0, 4, 3, 2, 2});
        s00.D("MS", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("MT", new Integer[]{0, 2, 0, 0, 2, 2});
        s00.D("MU", new Integer[]{2, 1, 1, 2, 2, 2});
        s00.D("MV", new Integer[]{4, 3, 2, 4, 2, 2});
        s00.D("MW", new Integer[]{4, 2, 1, 0, 2, 2});
        s00.D("MX", new Integer[]{2, 4, 4, 4, 4, 2});
        s00.D("MY", new Integer[]{1, 0, 3, 2, 2, 2});
        s00.D("MZ", new Integer[]{3, 3, 2, 1, 2, 2});
        s00.D("NA", new Integer[]{4, 3, 3, 2, 2, 2});
        s00.D("NC", new Integer[]{3, 0, 4, 4, 2, 2});
        s00.D("NE", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("NF", new Integer[]{2, 2, 2, 2, 2, 2});
        s00.D("NG", new Integer[]{3, 3, 2, 3, 2, 2});
        s00.D("NI", new Integer[]{2, 1, 4, 4, 2, 2});
        s00.D("NL", new Integer[]{0, 2, 3, 2, 0, 2});
        s00.D("NO", new Integer[]{0, 1, 2, 0, 0, 2});
        s00.D("NP", new Integer[]{2, 0, 4, 2, 2, 2});
        s00.D("NR", new Integer[]{3, 2, 3, 1, 2, 2});
        s00.D("NU", new Integer[]{4, 2, 2, 2, 2, 2});
        s00.D("NZ", new Integer[]{0, 2, 1, 2, 4, 2});
        s00.D("OM", new Integer[]{2, 2, 1, 3, 3, 2});
        s00.D("PA", new Integer[]{1, 3, 3, 3, 2, 2});
        s00.D("PE", new Integer[]{2, 3, 4, 4, 2, 2});
        s00.D("PF", new Integer[]{2, 2, 2, 1, 2, 2});
        s00.D("PG", new Integer[]{4, 4, 3, 2, 2, 2});
        s00.D("PH", new Integer[]{2, 1, 3, 3, 3, 2});
        s00.D("PK", new Integer[]{3, 2, 3, 3, 2, 2});
        s00.D("PL", new Integer[]{1, 0, 1, 2, 3, 2});
        s00.D("PM", new Integer[]{0, 2, 2, 2, 2, 2});
        s00.D("PR", new Integer[]{2, 1, 2, 2, 4, 3});
        s00.D("PS", new Integer[]{3, 3, 2, 2, 2, 2});
        s00.D("PT", new Integer[]{0, 1, 1, 0, 2, 2});
        s00.D("PW", new Integer[]{1, 2, 4, 1, 2, 2});
        s00.D("PY", new Integer[]{2, 0, 3, 2, 2, 2});
        s00.D("QA", new Integer[]{2, 3, 1, 2, 3, 2});
        s00.D("RE", new Integer[]{1, 0, 2, 2, 2, 2});
        s00.D("RO", new Integer[]{0, 1, 0, 1, 0, 2});
        s00.D("RS", new Integer[]{1, 2, 0, 0, 2, 2});
        s00.D("RU", new Integer[]{0, 1, 0, 1, 4, 2});
        s00.D("RW", new Integer[]{3, 3, 3, 1, 2, 2});
        s00.D("SA", new Integer[]{2, 2, 2, 1, 1, 2});
        s00.D("SB", new Integer[]{4, 2, 3, 2, 2, 2});
        s00.D("SC", new Integer[]{4, 2, 1, 3, 2, 2});
        s00.D("SD", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("SE", new Integer[]{0, 0, 0, 0, 0, 2});
        s00.D("SG", new Integer[]{1, 0, 1, 2, 3, 2});
        s00.D("SH", new Integer[]{4, 2, 2, 2, 2, 2});
        s00.D("SI", new Integer[]{0, 0, 0, 0, 2, 2});
        s00.D("SJ", new Integer[]{2, 2, 2, 2, 2, 2});
        s00.D("SK", new Integer[]{0, 1, 0, 0, 2, 2});
        s00.D("SL", new Integer[]{4, 3, 4, 0, 2, 2});
        s00.D("SM", new Integer[]{0, 2, 2, 2, 2, 2});
        s00.D("SN", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("SO", new Integer[]{3, 3, 3, 4, 2, 2});
        s00.D("SR", new Integer[]{3, 2, 2, 2, 2, 2});
        s00.D("SS", new Integer[]{4, 4, 3, 3, 2, 2});
        s00.D("ST", new Integer[]{2, 2, 1, 2, 2, 2});
        s00.D("SV", new Integer[]{2, 1, 4, 3, 2, 2});
        s00.D("SX", new Integer[]{2, 2, 1, 0, 2, 2});
        s00.D("SY", new Integer[]{4, 3, 3, 2, 2, 2});
        s00.D("SZ", new Integer[]{3, 3, 2, 4, 2, 2});
        s00.D("TC", new Integer[]{2, 2, 2, 0, 2, 2});
        s00.D("TD", new Integer[]{4, 3, 4, 4, 2, 2});
        s00.D("TG", new Integer[]{3, 2, 2, 4, 2, 2});
        s00.D("TH", new Integer[]{0, 3, 2, 3, 2, 2});
        s00.D("TJ", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("TL", new Integer[]{4, 0, 4, 4, 2, 2});
        s00.D("TM", new Integer[]{4, 2, 4, 3, 2, 2});
        s00.D("TN", new Integer[]{2, 1, 1, 2, 2, 2});
        s00.D("TO", new Integer[]{3, 3, 4, 3, 2, 2});
        s00.D("TR", new Integer[]{1, 2, 1, 1, 2, 2});
        s00.D("TT", new Integer[]{1, 4, 0, 1, 2, 2});
        s00.D("TV", new Integer[]{3, 2, 2, 4, 2, 2});
        s00.D("TW", new Integer[]{0, 0, 0, 0, 1, 0});
        s00.D("TZ", new Integer[]{3, 3, 3, 2, 2, 2});
        s00.D("UA", new Integer[]{0, 3, 1, 1, 2, 2});
        s00.D("UG", new Integer[]{3, 2, 3, 3, 2, 2});
        s00.D("US", new Integer[]{1, 1, 2, 2, 4, 2});
        s00.D("UY", new Integer[]{2, 2, 1, 1, 2, 2});
        s00.D("UZ", new Integer[]{2, 1, 3, 4, 2, 2});
        s00.D("VC", new Integer[]{1, 2, 2, 2, 2, 2});
        s00.D("VE", new Integer[]{4, 4, 4, 4, 2, 2});
        s00.D("VG", new Integer[]{2, 2, 1, 1, 2, 2});
        s00.D("VI", new Integer[]{1, 2, 1, 2, 2, 2});
        s00.D("VN", new Integer[]{0, 1, 3, 4, 2, 2});
        s00.D("VU", new Integer[]{4, 0, 3, 1, 2, 2});
        s00.D("WF", new Integer[]{4, 2, 2, 4, 2, 2});
        s00.D("WS", new Integer[]{3, 1, 3, 1, 2, 2});
        s00.D("XK", new Integer[]{0, 1, 1, 0, 2, 2});
        s00.D("YE", new Integer[]{4, 4, 4, 3, 2, 2});
        s00.D("YT", new Integer[]{4, 2, 2, 3, 2, 2});
        s00.D("ZA", new Integer[]{3, 3, 2, 1, 2, 2});
        s00.D("ZM", new Integer[]{3, 2, 3, 3, 2, 2});
        s00.D("ZW", new Integer[]{3, 2, 4, 3, 2, 2});
        Set set0 = ((b5)s00.b).entrySet();
        if(((AbstractCollection)set0).isEmpty()) {
            u90 = J6.e;
        }
        else {
            e e0 = new e(((Z4)set0).b.h, 1);
            Iterator iterator0 = ((Z4)set0).iterator();
            while(((z)iterator0).hasNext()) {
                Map.Entry map$Entry0 = (Map.Entry)((z)iterator0).next();
                Object object0 = map$Entry0.getKey();
                h9 h90 = h9.q(((Collection)map$Entry0.getValue()));
                if(!h90.isEmpty()) {
                    e0.b(object0, h90);
                    v += h90.size();
                }
            }
            u90 = new U9(e0.a(), v);
        }
        l4.n = u90;
        l4.o = h9.k(6200000L, 3900000L, 2300000L, 1300000L, 620000L);
        l4.r = h9.k(248000L, 160000L, 142000L, 127000L, 113000L);
        l4.w = h9.k(2200000L, 1300000L, 950000L, 760000L, 520000L);
        l4.B = h9.k(4400000L, 2300000L, 1500000L, 1100000L, 640000L);
        l4.D = h9.k(10000000L, 7200000L, 5000000L, 2700000L, 1600000L);
        l4.E = h9.k(2600000L, 2200000L, 2000000L, 1500000L, 470000L);
    }

    public l4(Context context0, Map map0, int v, E4 e40, boolean z) {
        this.a = K5.a(map0);
        this.b = new ab(0);
        this.c = new Y2(v);
        this.d = e40;
        this.e = z;
        if(context0 != null) {
            rc rc0 = rc.c(context0);
            this.i = rc0.a;
            this.l = this.d(rc0.a);
            k4 k40 = new k4(this);
            CopyOnWriteArrayList copyOnWriteArrayList0 = (CopyOnWriteArrayList)rc0.c;
            for(Object object0: copyOnWriteArrayList0) {
                WeakReference weakReference0 = (WeakReference)object0;
                if(weakReference0.get() == null) {
                    copyOnWriteArrayList0.remove(weakReference0);
                }
            }
            copyOnWriteArrayList0.add(new WeakReference(k40));
            P3 p30 = new P3(10, rc0, k40);
            ((Handler)rc0.b).post(p30);
            return;
        }
        this.i = 0;
        this.l = this.d(0);
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final long a() {
        synchronized(this) {
        }
        return this.l;
    }

    @Override  // i.n.i.b.a.s.e.g0
    public final void a(W2 w20, boolean z) {
        boolean z1 = false;
        synchronized(this) {
            if(z && (w20.i & 8) != 8) {
                if(this.f > 0) {
                    z1 = true;
                }
                M7.J(z1);
                this.d.getClass();
                long v = SystemClock.elapsedRealtime();
                int v1 = (int)(v - this.g);
                this.j += (long)v1;
                long v2 = this.h;
                this.k += v2;
                if(v1 > 0) {
                    this.c.b(((float)v2) * 8000.0f / ((float)v1), ((int)Math.sqrt(v2)));
                    if(this.j >= 2000L || this.k >= 0x80000L) {
                        this.l = (long)this.c.a();
                    }
                    long v3 = this.h;
                    long v4 = this.l;
                    if(v1 != 0 || v3 != 0L || v4 != this.m) {
                        this.m = v4;
                        this.b.a(v1, v3, v4);
                    }
                    this.g = v;
                    this.h = 0L;
                }
                --this.f;
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final g0 b() {
        return this;
    }

    @Override  // i.n.i.b.a.s.e.g0
    public final void b(W2 w20, boolean z) {
        __monitor_enter(this);
        boolean z1 = z && (w20.i & 8) != 8;
        try {
            if(!z1) {
                return;
            }
            if(this.f == 0) {
                this.d.getClass();
                this.g = SystemClock.elapsedRealtime();
            }
            ++this.f;
        }
        finally {
            __monitor_exit(this);
        }
    }

    @Override  // i.n.i.b.a.s.e.g0
    public final void c(W2 w20, boolean z, int v) {
        synchronized(this) {
            if(!z || (w20.i & 8) == 8) {
                return;
            }
            this.h += (long)v;
        }
    }

    public final long d(int v) {
        K5 k50 = this.a;
        Long long0 = (Long)k50.get(v);
        if(long0 == null) {
            long0 = (Long)k50.get(0);
        }
        if(long0 == null) {
            long0 = 2000000L;
        }
        return (long)long0;
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final void h(S1 s10) {
        this.b.b(s10);
    }

    @Override  // i.n.i.b.a.s.e.bb
    public final void p(Handler handler0, S1 s10) {
        s10.getClass();
        this.b.getClass();
        this.b.b(s10);
        Za za0 = new Za(handler0, s10);
        this.b.a.add(za0);
    }
}

