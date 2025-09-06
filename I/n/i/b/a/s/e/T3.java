package i.n.i.b.a.s.e;

import B3.v;
import U4.x;
import android.util.Log;
import android.util.Pair;
import g3.i;
import k8.Y;

public final class t3 implements q4 {
    public U5 a;
    public ie b;
    public s3 c;
    public int d;
    public long e;
    public static final p f;

    static {
        t3.f = new p(8);
    }

    public t3() {
        this.d = -1;
        this.e = -1L;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        s3 s30 = this.c;
        if(s30 != null) {
            s30.a(v1);
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        return Ja.m(i50) != null;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        long v5;
        int v3;
        M7.G(this.b);
        if(this.c == null) {
            Z3 z30 = Ja.m(i50);
            if(z30 == null) {
                throw new H4("Unsupported or unrecognized wav header.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            int v1 = z30.a;
            if(v1 == 17) {
                this.c = new r3(this.a, this.b, z30);
            }
            else {
                switch(v1) {
                    case 6: {
                        this.c = new i(this.a, this.b, z30, "audio/g711-alaw", -1);
                        break;
                    }
                    case 7: {
                        this.c = new i(this.a, this.b, z30, "audio/g711-mlaw", -1);
                        break;
                    }
                    default: {
                        int v2 = z30.e;
                        switch(v1) {
                            case 3: {
                                v3 = v2 == 0x20 ? 4 : 0;
                                break;
                            }
                            case 1: 
                            case 0xFFFE: {
                                v3 = L7.u(v2);
                                break;
                            }
                            default: {
                                v3 = 0;
                            }
                        }
                        if(v3 == 0) {
                            throw new H4("Unsupported WAV format type: " + v1);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        this.c = new i(this.a, this.b, z30, "audio/raw", v3);
                        break;
                    }
                }
            }
        }
        int v4 = this.d;
        if(v4 == -1) {
            i50.getClass();
            ((D2)i50).f = 0;
            wb wb0 = new wb(8);
            Jd jd0 = Jd.a(i50, wb0);
        alab1:
            while(true) {
                v5 = jd0.b;
                int v6 = jd0.a;
                switch(v6) {
                    case 1684108385: {
                        break alab1;
                    }
                    case 1380533830: 
                    case 0x666D7420: {
                    label_35:
                        long v7 = v6 == 1380533830 ? 12L : v5 + 8L;
                        if(v7 > 0x7FFFFFFFL) {
                            throw new H4("Chunk is too large (~2GB+) to skip; id: " + v6);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                        }
                        ((D2)i50).g(((int)v7));
                        jd0 = Jd.a(i50, wb0);
                        break;
                    }
                    default: {
                        x.u(v6, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
                        goto label_35;
                    }
                }
            }
            ((D2)i50).g(8);
            long v8 = ((D2)i50).d;
            long v9 = v5 + v8;
            long v10 = ((D2)i50).c;
            if(v10 != -1L && v9 > v10) {
                StringBuilder stringBuilder0 = Y.o(v9, "Data exceeds input length: ", ", ");
                stringBuilder0.append(v10);
                Log.w("WavHeaderReader", stringBuilder0.toString());
                v9 = v10;
            }
            Pair pair0 = Pair.create(v8, v9);
            this.d = ((Long)pair0.first).intValue();
            long v11 = (long)(((Long)pair0.second));
            this.e = v11;
            this.c.c(this.d, v11);
        }
        else if(((D2)i50).d == 0L) {
            ((D2)i50).g(v4);
        }
        M7.J(this.e != -1L);
        return this.c.b(i50, this.e - ((D2)i50).d) ? -1 : 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.a = u50;
        this.b = u50.i(0, 1);
        u50.b();
    }
}

