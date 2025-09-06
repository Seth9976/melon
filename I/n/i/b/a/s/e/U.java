package i.n.i.b.a.s.e;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class u implements Parcelable {
    public final int B;
    public static final Parcelable.Creator CREATOR;
    public final float D;
    public final int E;
    public final float G;
    public final byte[] I;
    public final int M;
    public final vm N;
    public final int S;
    public final int T;
    public final int V;
    public final int W;
    public final int X;
    public final int Y;
    public final Class Z;
    public final String a;
    public final String b;
    public int b0;
    public final String c;
    public final List c0;
    public final int d;
    public final long d0;
    public final int e;
    public final int e0;
    public final int f;
    public final int g;
    public final int h;
    public final String i;
    public final x8 j;
    public final String k;
    public final String l;
    public final int m;
    public final List n;
    public final c3 o;
    public final long r;
    public final int w;

    static {
        u.CREATOR = new t(27);
    }

    public u(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        this.c = parcel0.readString();
        this.d = parcel0.readInt();
        this.e = parcel0.readInt();
        int v = parcel0.readInt();
        this.f = v;
        int v1 = parcel0.readInt();
        this.g = v1;
        if(v1 != -1) {
            v = v1;
        }
        this.h = v;
        this.i = parcel0.readString();
        this.j = (x8)parcel0.readParcelable(x8.class.getClassLoader());
        this.k = parcel0.readString();
        this.l = parcel0.readString();
        this.m = parcel0.readInt();
        int v2 = parcel0.readInt();
        this.n = new ArrayList(v2);
        for(int v4 = 0; v4 < v2; ++v4) {
            byte[] arr_b = parcel0.createByteArray();
            arr_b.getClass();
            this.n.add(arr_b);
        }
        c3 c30 = (c3)parcel0.readParcelable(c3.class.getClassLoader());
        this.o = c30;
        this.r = parcel0.readLong();
        this.w = parcel0.readInt();
        this.B = parcel0.readInt();
        this.D = parcel0.readFloat();
        this.E = parcel0.readInt();
        this.G = parcel0.readFloat();
        Class class0 = null;
        this.I = parcel0.readInt() == 0 ? null : parcel0.createByteArray();
        this.M = parcel0.readInt();
        this.N = (vm)parcel0.readParcelable(vm.class.getClassLoader());
        this.S = parcel0.readInt();
        this.T = parcel0.readInt();
        this.V = parcel0.readInt();
        this.W = parcel0.readInt();
        this.X = parcel0.readInt();
        this.Y = parcel0.readInt();
        if(c30 != null) {
            class0 = Ja.class;
        }
        this.Z = class0;
        this.d0 = parcel0.readLong();
        int v5 = parcel0.readInt();
        this.c0 = new ArrayList(v5);
        for(int v3 = 0; v3 < v5; ++v3) {
            byte[] arr_b1 = parcel0.createByteArray();
            this.c0.add(arr_b1);
        }
        this.e0 = parcel0.readInt();
    }

    public u(ob ob0) {
        this.a = ob0.a;
        this.b = ob0.b;
        this.c = L7.H(ob0.c);
        this.d = ob0.d;
        this.e = ob0.e;
        int v = ob0.f;
        this.f = v;
        int v1 = ob0.g;
        this.g = v1;
        if(v1 != -1) {
            v = v1;
        }
        this.h = v;
        this.i = ob0.h;
        this.j = ob0.i;
        this.k = ob0.j;
        this.l = ob0.k;
        this.m = ob0.l;
        this.n = ob0.m == null ? Collections.EMPTY_LIST : ob0.m;
        c3 c30 = ob0.n;
        this.o = c30;
        this.r = ob0.o;
        this.w = ob0.p;
        this.B = ob0.q;
        this.D = ob0.r;
        int v2 = ob0.s;
        int v3 = 0;
        if(v2 == -1) {
            v2 = 0;
        }
        this.E = v2;
        this.G = ob0.t == -1.0f ? 1.0f : ob0.t;
        this.I = ob0.u;
        this.M = ob0.v;
        this.N = ob0.w;
        this.S = ob0.x;
        this.T = ob0.y;
        this.V = ob0.z;
        this.W = ob0.A == -1 ? 0 : ob0.A;
        int v4 = ob0.B;
        if(v4 != -1) {
            v3 = v4;
        }
        this.X = v3;
        this.Y = ob0.C;
        Class class0 = ob0.D;
        this.Z = class0 != null || c30 == null ? class0 : Ja.class;
        this.d0 = ob0.F;
        this.c0 = ob0.E == null ? Collections.EMPTY_LIST : ob0.E;
        this.e0 = ob0.G;
    }

    public final ob a() {
        ob ob0 = new ob();  // 初始化器: Ljava/lang/Object;-><init>()V
        ob0.a = this.a;
        ob0.b = this.b;
        ob0.c = this.c;
        ob0.d = this.d;
        ob0.e = this.e;
        ob0.f = this.f;
        ob0.g = this.g;
        ob0.h = this.i;
        ob0.i = this.j;
        ob0.j = this.k;
        ob0.k = this.l;
        ob0.l = this.m;
        ob0.m = this.n;
        ob0.n = this.o;
        ob0.o = this.r;
        ob0.p = this.w;
        ob0.q = this.B;
        ob0.r = this.D;
        ob0.s = this.E;
        ob0.t = this.G;
        ob0.u = this.I;
        ob0.v = this.M;
        ob0.w = this.N;
        ob0.x = this.S;
        ob0.y = this.T;
        ob0.z = this.V;
        ob0.A = this.W;
        ob0.B = this.X;
        ob0.C = this.Y;
        ob0.D = this.Z;
        ob0.E = this.c0;
        ob0.F = this.d0;
        ob0.G = this.e0;
        return ob0;
    }

    public final boolean b(u u0) {
        List list0 = this.n;
        if(list0.size() != u0.n.size()) {
            return false;
        }
        for(int v = 0; v < list0.size(); ++v) {
            if(!Arrays.equals(((byte[])list0.get(v)), ((byte[])u0.n.get(v)))) {
                return false;
            }
        }
        return true;
    }

    public final u c(u u0) {
        int v11;
        int v9;
        b[] arr_c3$b2;
        String s5;
        String s2;
        if(this == u0) {
            return this;
        }
        int v = mb.g(this.l);
        String s = u0.a;
        x8 x80 = u0.j;
        String s1 = u0.b == null ? this.b : u0.b;
        if(v != 1 && v != 3) {
            s2 = this.c;
        }
        else {
            s2 = u0.c;
            if(s2 == null) {
                s2 = this.c;
            }
        }
        int v1 = this.f == -1 ? u0.f : this.f;
        int v2 = this.g == -1 ? u0.g : this.g;
        String s3 = this.i;
        if(s3 == null) {
            String s4 = L7.D(v, u0.i);
            if(L7.J(s4).length == 1) {
                s3 = s4;
            }
        }
        x8 x81 = this.j;
        if(x81 != null) {
            if(x80 == null) {
                x80 = x81;
            }
            else {
                i.n.i.b.a.s.e.x8.b[] arr_x8$b = x80.a;
                if(arr_x8$b.length == 0) {
                    x80 = x81;
                }
                else {
                    Object[] arr_object = Arrays.copyOf(x81.a, x81.a.length + arr_x8$b.length);
                    System.arraycopy(arr_x8$b, 0, arr_object, x81.a.length, arr_x8$b.length);
                    x80 = new x8(((i.n.i.b.a.s.e.x8.b[])arr_object));
                }
            }
        }
        float f = this.D != -1.0f || v != 2 ? this.D : u0.D;
        int v3 = this.d | u0.d;
        int v4 = this.e | u0.e;
        c3 c30 = u0.o;
        ArrayList arrayList0 = new ArrayList();
        if(c30 == null) {
            s5 = null;
        }
        else {
            s5 = c30.c;
            b[] arr_c3$b = c30.a;
            for(int v5 = 0; v5 < arr_c3$b.length; ++v5) {
                b c3$b0 = arr_c3$b[v5];
                if(c3$b0.d()) {
                    arrayList0.add(c3$b0);
                }
            }
        }
        c3 c31 = this.o;
        if(c31 != null) {
            if(s5 == null) {
                s5 = c31.c;
            }
            int v6 = arrayList0.size();
            b[] arr_c3$b1 = c31.a;
            int v7 = arr_c3$b1.length;
            int v8 = 0;
            while(v8 < v7) {
                b c3$b1 = arr_c3$b1[v8];
                if(c3$b1.d()) {
                    arr_c3$b2 = arr_c3$b1;
                    UUID uUID0 = c3$b1.b;
                    v9 = v7;
                    int v10 = 0;
                    while(v10 < v6) {
                        v11 = v6;
                        if(((b)arrayList0.get(v10)).b.equals(uUID0)) {
                            goto label_75;
                        }
                        ++v10;
                        v6 = v11;
                    }
                    v11 = v6;
                    arrayList0.add(c3$b1);
                }
                else {
                    arr_c3$b2 = arr_c3$b1;
                    v11 = v6;
                    v9 = v7;
                }
            label_75:
                ++v8;
                arr_c3$b1 = arr_c3$b2;
                v7 = v9;
                v6 = v11;
            }
        }
        c3 c32 = arrayList0.isEmpty() ? null : new c3(s5, arrayList0);
        ob ob0 = this.a();
        ob0.a = s;
        ob0.b = s1;
        ob0.c = s2;
        ob0.d = v3;
        ob0.e = v4;
        ob0.f = v1;
        ob0.g = v2;
        ob0.h = s3;
        ob0.i = x80;
        ob0.n = c32;
        ob0.r = f;
        return new u(ob0);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(u.class == class0) {
                u u0 = (u)object0;
                return this.b0 == 0 || (u0.b0 == 0 || this.b0 == u0.b0) ? this.d == u0.d && this.e == u0.e && this.f == u0.f && this.g == u0.g && this.m == u0.m && this.r == u0.r && this.w == u0.w && this.B == u0.B && this.E == u0.E && this.M == u0.M && this.S == u0.S && this.T == u0.T && this.V == u0.V && this.W == u0.W && this.X == u0.X && this.Y == u0.Y && Float.compare(this.D, u0.D) == 0 && Float.compare(this.G, u0.G) == 0 && L7.p(this.Z, u0.Z) && L7.p(this.a, u0.a) && L7.p(this.b, u0.b) && L7.p(this.i, u0.i) && L7.p(this.k, u0.k) && L7.p(this.l, u0.l) && L7.p(this.c, u0.c) && Arrays.equals(this.I, u0.I) && L7.p(this.j, u0.j) && L7.p(this.N, u0.N) && L7.p(this.o, u0.o) && this.b(u0) && this.d0 == u0.d0 && L7.p(this.c0, u0.c0) && this.e0 == u0.e0 : false;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        if(this.b0 == 0) {
            int v = 0;
            int v1 = this.j == null ? 0 : Arrays.hashCode(this.j.a);
            int v2 = ((((((((Float.floatToIntBits(this.G) + ((Float.floatToIntBits(this.D) + ((((((((((((((((this.a == null ? 0 : this.a.hashCode()) + 0x20F) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F + this.d) * 0x1F + this.e) * 0x1F + this.f) * 0x1F + this.g) * 0x1F + (this.i == null ? 0 : this.i.hashCode())) * 0x1F + v1) * 0x1F + (this.k == null ? 0 : this.k.hashCode())) * 0x1F + (this.l == null ? 0 : this.l.hashCode())) * 0x1F + this.m) * 0x1F + ((int)this.r)) * 0x1F + this.w) * 0x1F + this.B) * 0x1F) * 0x1F + this.E) * 0x1F) * 0x1F + this.M) * 0x1F + this.S) * 0x1F + this.T) * 0x1F + this.V) * 0x1F + this.W) * 0x1F + this.X) * 0x1F + this.Y) * 0x1F;
            Class class0 = this.Z;
            if(class0 != null) {
                v = class0.hashCode();
            }
            this.b0 = (this.c0.hashCode() + ((v2 + v) * 0x1F + ((int)this.d0)) * 0x1F) * 0x1F + this.e0;
        }
        return this.b0;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Format(");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", [");
        stringBuilder0.append(this.w);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.B);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.D);
        stringBuilder0.append("], [");
        stringBuilder0.append(this.S);
        stringBuilder0.append(", ");
        return x.g(this.T, "])", stringBuilder0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(this.e);
        parcel0.writeInt(this.f);
        parcel0.writeInt(this.g);
        parcel0.writeString(this.i);
        parcel0.writeParcelable(this.j, 0);
        parcel0.writeString(this.k);
        parcel0.writeString(this.l);
        parcel0.writeInt(this.m);
        List list0 = this.n;
        int v2 = list0.size();
        parcel0.writeInt(v2);
        for(int v3 = 0; v3 < v2; ++v3) {
            parcel0.writeByteArray(((byte[])list0.get(v3)));
        }
        parcel0.writeParcelable(this.o, 0);
        parcel0.writeLong(this.r);
        parcel0.writeInt(this.w);
        parcel0.writeInt(this.B);
        parcel0.writeFloat(this.D);
        parcel0.writeInt(this.E);
        parcel0.writeFloat(this.G);
        byte[] arr_b = this.I;
        parcel0.writeInt((arr_b == null ? 0 : 1));
        if(arr_b != null) {
            parcel0.writeByteArray(arr_b);
        }
        parcel0.writeInt(this.M);
        parcel0.writeParcelable(this.N, v);
        parcel0.writeInt(this.S);
        parcel0.writeInt(this.T);
        parcel0.writeInt(this.V);
        parcel0.writeInt(this.W);
        parcel0.writeInt(this.X);
        parcel0.writeInt(this.Y);
        parcel0.writeLong(this.d0);
        List list1 = this.c0;
        int v4 = list1.size();
        for(int v1 = 0; v1 < v4; ++v1) {
            parcel0.writeByteArray(((byte[])list1.get(v1)));
        }
        parcel0.writeInt(this.e0);
    }
}

