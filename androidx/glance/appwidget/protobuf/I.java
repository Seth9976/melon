package androidx.glance.appwidget.protobuf;

import U4.x;
import a.a;
import androidx.appcompat.app.o;
import java.io.Serializable;
import java.util.Arrays;

public abstract class i implements Serializable, Iterable {
    public int a;
    public static final h b = null;
    public static final e c = null;
    private static final long serialVersionUID = 1L;

    static {
        i.b = new h(B.b);
        i.c = new e(0);
    }

    public abstract byte a(int arg1);

    public static int b(int v, int v1, int v2) {
        int v3 = v1 - v;
        if((v | v1 | v3 | v2 - v1) < 0) {
            if(v < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + v + " < 0");
            }
            throw v1 >= v ? new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2) : new IndexOutOfBoundsException("Beginning index larger than ending index: " + v + ", " + v1);
        }
        return v3;
    }

    public static h d(byte[] arr_b, int v, int v1) {
        i.b(v, v + v1, arr_b.length);
        if(i.c.a != 0) {
            byte[] arr_b1 = new byte[v1];
            System.arraycopy(arr_b, v, arr_b1, 0, v1);
            return new h(arr_b1);
        }
        return new h(Arrays.copyOfRange(arr_b, v, v1 + v));
    }

    public abstract byte e(int arg1);

    @Override
    public final int hashCode() {
        int v = this.a;
        if(v == 0) {
            int v1 = this.size();
            int v2 = ((h)this).f();
            int v3 = v1;
            for(int v4 = v2; v4 < v2 + v1; ++v4) {
                v3 = v3 * 0x1F + ((h)this).d[v4];
            }
            if(v3 == 0) {
                v3 = 1;
            }
            this.a = v3;
            return v3;
        }
        return v;
    }

    public abstract int size();

    @Override
    public final String toString() {
        String s = Integer.toHexString(System.identityHashCode(this));
        int v = this.size();
        if(this.size() <= 50) {
            String s1 = a.s(this);
            return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        int v1 = i.b(0, 0x2F, ((h)this).size());
        h h0 = v1 == 0 ? i.b : new f(((h)this).d, ((h)this).f(), v1);
        stringBuilder0.append(a.s(h0));
        stringBuilder0.append("...");
        return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), stringBuilder0.toString(), "\">");
    }
}

