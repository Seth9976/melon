package rf;

import androidx.datastore.preferences.protobuf.e;
import com.iloen.melon.utils.a;
import java.io.OutputStream;
import java.util.Iterator;

public class s extends d {
    public final byte[] b;
    public int c;

    public s(byte[] arr_b) {
        this.c = 0;
        this.b = arr_b;
    }

    @Override  // rf.d
    public void e(int v, int v1, int v2, byte[] arr_b) {
        System.arraycopy(this.b, v, arr_b, v1, v2);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        if(this.size() != ((d)object0).size()) {
            return false;
        }
        if(this.size() == 0) {
            return true;
        }
        if(object0 instanceof s) {
            return this.t(((s)object0), 0, this.size());
        }
        if(object0 instanceof x) {
            return object0.equals(this);
        }
        String s = String.valueOf(object0.getClass());
        throw new IllegalArgumentException(U4.x.m(new StringBuilder(s.length() + 49), "Has a new type of ByteString been created? Found ", s));
    }

    @Override  // rf.d
    public final int f() {
        return 0;
    }

    @Override  // rf.d
    public final boolean g() {
        return true;
    }

    @Override
    public final int hashCode() {
        int v = this.c;
        if(v == 0) {
            int v1 = this.size();
            v = this.l(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.c = v;
        }
        return v;
    }

    @Override  // rf.d
    public final boolean i() {
        return B.c(this.b, 0, this.b.length) == 0;
    }

    @Override
    public Iterator iterator() {
        return new e(this);
    }

    @Override  // rf.d
    public final int l(int v, int v1, int v2) {
        for(int v3 = v1; v3 < v1 + v2; ++v3) {
            v = v * 0x1F + this.b[v3];
        }
        return v;
    }

    @Override  // rf.d
    public final int o(int v, int v1, int v2) {
        int v8;
        int v7;
        int v3 = v2 + v1;
        byte[] arr_b = this.b;
        if(v != 0) {
            if(v1 >= v3) {
                return v;
            }
            if(((byte)v) < 0xFFFFFFE0) {
                if(((byte)v) >= -62) {
                    return arr_b[v1] > -65 ? -1 : B.c(arr_b, v1 + 1, v3);
                }
            }
            else if(((byte)v) < -16) {
                int v4 = (byte)(~(v >> 8));
                if(v4 == 0) {
                    int v5 = arr_b[v1];
                    if(v1 + 1 >= v3) {
                        return B.a(((byte)v), v5);
                    }
                    ++v1;
                    v4 = v5;
                }
                if(v4 <= -65 && (((byte)v) != 0xFFFFFFE0 || v4 >= 0xFFFFFFA0) && (((byte)v) != -19 || v4 < 0xFFFFFFA0)) {
                    return arr_b[v1] <= -65 ? B.c(arr_b, v1 + 1, v3) : -1;
                }
            }
            else {
                int v6 = (byte)(~(v >> 8));
                if(v6 == 0) {
                    v7 = v1 + 1;
                    v6 = arr_b[v1];
                    if(v7 >= v3) {
                        return B.a(((byte)v), v6);
                    }
                    v8 = 0;
                }
                else {
                    v8 = (byte)(v >> 16);
                    v7 = v1;
                }
                if(v8 == 0) {
                    int v9 = arr_b[v7];
                    if(v7 + 1 >= v3) {
                        return ((byte)v) > -12 || v6 > -65 || v9 > -65 ? -1 : v9 << 16 ^ (v6 << 8 ^ ((byte)v));
                    }
                    v8 = v9;
                    ++v7;
                }
                if(v6 <= -65 && v6 + 0x70 + (((byte)v) << 28) >> 30 == 0 && v8 <= -65) {
                    return arr_b[v7] <= -65 ? B.c(arr_b, v7 + 1, v3) : -1;
                }
            }
            return -1;
        }
        return B.c(arr_b, v1, v3);
    }

    @Override  // rf.d
    public final int p() {
        return this.c;
    }

    @Override  // rf.d
    public final String q() {
        return new String(this.b, 0, this.b.length, "UTF-8");
    }

    @Override  // rf.d
    public final void s(int v, OutputStream outputStream0, int v1) {
        outputStream0.write(this.b, v, v1);
    }

    @Override  // rf.d
    public int size() {
        return this.b.length;
    }

    public final boolean t(s s0, int v, int v1) {
        byte[] arr_b = s0.b;
        byte[] arr_b1 = this.b;
        if(v1 > arr_b.length) {
            throw new IllegalArgumentException("Length too large: " + v1 + arr_b1.length);
        }
        if(v + v1 <= arr_b.length) {
            int v2 = 0;
            while(v2 < v1) {
                if(arr_b1[v2] != arr_b[v]) {
                    return false;
                }
                ++v2;
                ++v;
            }
            return true;
        }
        StringBuilder stringBuilder0 = new StringBuilder(59);
        stringBuilder0.append("Ran off end of other: ");
        stringBuilder0.append(v);
        stringBuilder0.append(", ");
        stringBuilder0.append(v1);
        throw new IllegalArgumentException(a.k(s0.b.length, ", ", stringBuilder0));
    }
}

