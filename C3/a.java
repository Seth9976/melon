package c3;

import I6.V;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class a {
    public final V a;
    public final ArrayList b;
    public ByteBuffer[] c;
    public boolean d;

    public a(V v0) {
        this.a = v0;
        this.b = new ArrayList();
        this.c = new ByteBuffer[0];
        this.d = false;
    }

    public final void a() {
        ArrayList arrayList0 = this.b;
        arrayList0.clear();
        this.d = false;
        for(int v1 = 0; true; ++v1) {
            V v2 = this.a;
            if(v1 >= v2.size()) {
                break;
            }
            d d0 = (d)v2.get(v1);
            d0.flush();
            if(d0.isActive()) {
                arrayList0.add(d0);
            }
        }
        this.c = new ByteBuffer[arrayList0.size()];
        for(int v = 0; v <= this.b(); ++v) {
            ByteBuffer[] arr_byteBuffer = this.c;
            arr_byteBuffer[v] = ((d)arrayList0.get(v)).getOutput();
        }
    }

    public final int b() {
        return this.c.length - 1;
    }

    // 去混淆评级： 低(30)
    public final boolean c() {
        return this.d && ((d)this.b.get(this.b())).isEnded() && !this.c[this.b()].hasRemaining();
    }

    public final boolean d() {
        return !this.b.isEmpty();
    }

    public final void e(ByteBuffer byteBuffer0) {
        ByteBuffer byteBuffer1;
        for(int v = 1; v != 0; v = v1) {
            int v1 = 0;
            for(int v2 = 0; v2 <= this.b(); ++v2) {
                if(!this.c[v2].hasRemaining()) {
                    ArrayList arrayList0 = this.b;
                    d d0 = (d)arrayList0.get(v2);
                    if(!d0.isEnded()) {
                        if(v2 > 0) {
                            byteBuffer1 = this.c[v2 - 1];
                        }
                        else {
                            byteBuffer1 = byteBuffer0.hasRemaining() ? byteBuffer0 : d.a;
                        }
                        d0.queueInput(byteBuffer1);
                        ByteBuffer[] arr_byteBuffer = this.c;
                        arr_byteBuffer[v2] = d0.getOutput();
                        v1 |= (this.c[v2].hasRemaining() ? 1 : 0);
                    }
                    else if(!this.c[v2].hasRemaining() && v2 < this.b()) {
                        ((d)arrayList0.get(v2 + 1)).queueEndOfStream();
                    }
                }
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        V v0 = this.a;
        if(v0.size() != ((a)object0).a.size()) {
            return false;
        }
        for(int v1 = 0; v1 < v0.size(); ++v1) {
            if(v0.get(v1) != ((a)object0).a.get(v1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

