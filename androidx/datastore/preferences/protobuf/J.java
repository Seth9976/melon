package androidx.datastore.preferences.protobuf;

import E9.h;
import U4.x;
import androidx.appcompat.app.o;
import java.io.Serializable;
import java.util.Arrays;

public abstract class j implements Serializable, Iterable {
    public int a;
    public static final i b = null;
    public static final f c = null;
    private static final long serialVersionUID = 1L;

    static {
        j.b = new i(D.b);
        j.c = new f(0);
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

    public static i d(byte[] arr_b, int v, int v1) {
        j.b(v, v + v1, arr_b.length);
        if(j.c.a != 0) {
            byte[] arr_b1 = new byte[v1];
            System.arraycopy(arr_b, v, arr_b1, 0, v1);
            return new i(arr_b1);
        }
        return new i(Arrays.copyOfRange(arr_b, v, v1 + v));
    }

    public abstract void e(int arg1, byte[] arg2);

    public abstract byte f(int arg1);

    @Override
    public final int hashCode() {
        int v = this.a;
        if(v == 0) {
            int v1 = this.size();
            int v2 = ((i)this).g();
            int v3 = v1;
            for(int v4 = v2; v4 < v2 + v1; ++v4) {
                v3 = v3 * 0x1F + ((i)this).d[v4];
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
            String s1 = h.u(this);
            return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        int v1 = j.b(0, 0x2F, ((i)this).size());
        i i0 = v1 == 0 ? j.b : new g(((i)this).d, ((i)this).g(), v1);
        stringBuilder0.append(h.u(i0));
        stringBuilder0.append("...");
        return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), stringBuilder0.toString(), "\">");
    }
}

