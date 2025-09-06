package co.ab180.airbridge.internal.e0;

import e.k;
import java.util.List;
import je.p;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0003R\u0014\u0010\n\u001A\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001A\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\f0\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000ER\u0016\u0010\u0012\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u0013¨\u0006\u0015"}, d2 = {"Lco/ab180/airbridge/internal/e0/h0;", "", "<init>", "()V", "", "duration", "Lie/H;", "a", "(J)V", "J", "tolerance", "", "", "b", "Ljava/util/List;", "count", "c", "I", "currentIndex", "()I", "current", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class h0 {
    private final long a;
    private final List b;
    private int c;

    public h0() {
        this.a = 100L;
        this.b = k.A(new Integer[]{1, 2, 3, 5, 8, 13, 21, 0x20});
    }

    public final void a() {
        this.c = 0;
    }

    public final void a(long v) {
        int v2;
        if(Long.compare(v, this.a) > 0) {
            int v1 = this.c;
            if(v1 > 1) {
                v2 = v1 - 1;
                this.c = v2;
            }
        }
        else if(this.c < this.b.size() - 1) {
            v2 = this.c + 1;
            this.c = v2;
        }
    }

    public final int b() {
        Integer integer0 = (Integer)p.n0(this.c, this.b);
        if(integer0 != null) {
            return (int)integer0;
        }
        this.c = 0;
        return ((Number)this.b.get(0)).intValue();
    }
}

