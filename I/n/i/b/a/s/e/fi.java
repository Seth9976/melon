package i.n.i.b.a.s.e;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display.Mode;
import android.view.Display;
import android.view.WindowManager;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class fi extends C4 {
    public static final class d extends mi {
        public final int B;
        public static final Parcelable.Creator CREATOR;
        public final int D;
        public final boolean E;
        public final h9 G;
        public final int I;
        public final int M;
        public final int N;
        public final boolean S;
        public final boolean T;
        public final boolean V;
        public final boolean W;
        public final h9 X;
        public final boolean Y;
        public final boolean Z;
        public final boolean b0;
        public final boolean c0;
        public final boolean d0;
        public final SparseArray e0;
        public final SparseBooleanArray f0;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final int m;
        public final int n;
        public final boolean o;
        public final boolean r;
        public final boolean w;

        static {
            new e().a();
            d.CREATOR = new S2();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public d(int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, boolean z, boolean z1, boolean z2, int v8, int v9, boolean z3, h9 h90, int v10, h9 h91, int v11, int v12, int v13, boolean z4, boolean z5, boolean z6, boolean z7, h9 h92, h9 h93, int v14, boolean z8, int v15, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, SparseArray sparseArray0, SparseBooleanArray sparseBooleanArray0) {
            super(h91, v11, h93, v14, z8, v15);
            this.g = v;
            this.h = v1;
            this.i = v2;
            this.j = v3;
            this.k = v4;
            this.l = v5;
            this.m = v6;
            this.n = v7;
            this.o = z;
            this.r = z1;
            this.w = z2;
            this.B = v8;
            this.D = v9;
            this.E = z3;
            this.G = h90;
            this.I = v10;
            this.M = v12;
            this.N = v13;
            this.S = z4;
            this.T = z5;
            this.V = z6;
            this.W = z7;
            this.X = h92;
            this.Y = z9;
            this.Z = z10;
            this.b0 = z11;
            this.c0 = z12;
            this.d0 = z13;
            this.e0 = sparseArray0;
            this.f0 = sparseBooleanArray0;
        }

        public d(Parcel parcel0) {
            super(parcel0);
            this.g = parcel0.readInt();
            this.h = parcel0.readInt();
            this.i = parcel0.readInt();
            this.j = parcel0.readInt();
            this.k = parcel0.readInt();
            this.l = parcel0.readInt();
            this.m = parcel0.readInt();
            this.n = parcel0.readInt();
            boolean z = true;
            this.o = parcel0.readInt() != 0;
            this.r = parcel0.readInt() != 0;
            this.w = parcel0.readInt() != 0;
            this.B = parcel0.readInt();
            this.D = parcel0.readInt();
            this.E = parcel0.readInt() != 0;
            ArrayList arrayList0 = new ArrayList();
            parcel0.readList(arrayList0, null);
            this.G = h9.q(arrayList0);
            this.I = parcel0.readInt();
            this.M = parcel0.readInt();
            this.N = parcel0.readInt();
            this.S = parcel0.readInt() != 0;
            this.T = parcel0.readInt() != 0;
            this.V = parcel0.readInt() != 0;
            this.W = parcel0.readInt() != 0;
            ArrayList arrayList1 = new ArrayList();
            parcel0.readList(arrayList1, null);
            this.X = h9.q(arrayList1);
            this.Y = parcel0.readInt() != 0;
            this.Z = parcel0.readInt() != 0;
            this.b0 = parcel0.readInt() != 0;
            this.c0 = parcel0.readInt() != 0;
            if(parcel0.readInt() == 0) {
                z = false;
            }
            this.d0 = z;
            int v = parcel0.readInt();
            SparseArray sparseArray0 = new SparseArray(v);
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = parcel0.readInt();
                int v3 = parcel0.readInt();
                HashMap hashMap0 = new HashMap(v3);
                for(int v4 = 0; v4 < v3; ++v4) {
                    wc wc0 = (wc)parcel0.readParcelable(wc.class.getClassLoader());
                    wc0.getClass();
                    hashMap0.put(wc0, ((f)parcel0.readParcelable(f.class.getClassLoader())));
                }
                sparseArray0.put(v2, hashMap0);
            }
            this.e0 = sparseArray0;
            this.f0 = parcel0.readSparseBooleanArray();
        }

        @Override  // i.n.i.b.a.s.e.mi
        public final int describeContents() {
            return 0;
        }

        @Override  // i.n.i.b.a.s.e.mi
        public final boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                if(d.class == class0) {
                    d fi$d0 = (d)object0;
                    if(super.equals(object0) && this.g == fi$d0.g && this.h == fi$d0.h && this.i == fi$d0.i && this.j == fi$d0.j && this.k == fi$d0.k && this.l == fi$d0.l && this.m == fi$d0.m && this.n == fi$d0.n && this.o == fi$d0.o && this.r == fi$d0.r && this.w == fi$d0.w && this.E == fi$d0.E && this.B == fi$d0.B && this.D == fi$d0.D && this.G.equals(fi$d0.G) && this.I == fi$d0.I && this.M == fi$d0.M && this.N == fi$d0.N && this.S == fi$d0.S && this.T == fi$d0.T && this.V == fi$d0.V && this.W == fi$d0.W && this.X.equals(fi$d0.X) && this.Y == fi$d0.Y && this.Z == fi$d0.Z && this.b0 == fi$d0.b0 && this.c0 == fi$d0.c0 && this.d0 == fi$d0.d0) {
                        SparseBooleanArray sparseBooleanArray0 = fi$d0.f0;
                        SparseBooleanArray sparseBooleanArray1 = this.f0;
                        int v = sparseBooleanArray1.size();
                        if(sparseBooleanArray0.size() == v) {
                            for(int v1 = 0; v1 < v; ++v1) {
                                if(sparseBooleanArray0.indexOfKey(sparseBooleanArray1.keyAt(v1)) < 0) {
                                    return false;
                                }
                            }
                            SparseArray sparseArray0 = fi$d0.e0;
                            SparseArray sparseArray1 = this.e0;
                            int v2 = sparseArray1.size();
                            if(sparseArray0.size() == v2) {
                                for(int v3 = 0; v3 < v2; ++v3) {
                                    int v4 = sparseArray0.indexOfKey(sparseArray1.keyAt(v3));
                                    if(v4 < 0) {
                                        return false;
                                    }
                                    Map map0 = (Map)sparseArray1.valueAt(v3);
                                    Map map1 = (Map)sparseArray0.valueAt(v4);
                                    if(map1.size() != map0.size()) {
                                        return false;
                                    }
                                    for(Object object1: map0.entrySet()) {
                                        wc wc0 = (wc)((Map.Entry)object1).getKey();
                                        if(!map1.containsKey(wc0) || !L7.p(((Map.Entry)object1).getValue(), map1.get(wc0))) {
                                            return false;
                                        }
                                        if(false) {
                                            break;
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        @Override  // i.n.i.b.a.s.e.mi
        public final int hashCode() {
            return (((((this.X.hashCode() + ((((((((this.G.hashCode() + ((((((((((((((super.hashCode() * 0x1F + this.g) * 0x1F + this.h) * 0x1F + this.i) * 0x1F + this.j) * 0x1F + this.k) * 0x1F + this.l) * 0x1F + this.m) * 0x1F + this.n) * 0x1F + this.o) * 0x1F + this.r) * 0x1F + this.w) * 0x1F + this.E) * 0x1F + this.B) * 0x1F + this.D) * 0x1F) * 0x1F + this.I) * 0x1F + this.M) * 0x1F + this.N) * 0x1F + this.S) * 0x1F + this.T) * 0x1F + this.V) * 0x1F + this.W) * 0x1F) * 0x1F + this.Y) * 0x1F + this.Z) * 0x1F + this.b0) * 0x1F + this.c0) * 0x1F + this.d0;
        }

        @Override  // i.n.i.b.a.s.e.mi
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.g);
            parcel0.writeInt(this.h);
            parcel0.writeInt(this.i);
            parcel0.writeInt(this.j);
            parcel0.writeInt(this.k);
            parcel0.writeInt(this.l);
            parcel0.writeInt(this.m);
            parcel0.writeInt(this.n);
            parcel0.writeInt(((int)this.o));
            parcel0.writeInt(((int)this.r));
            parcel0.writeInt(((int)this.w));
            parcel0.writeInt(this.B);
            parcel0.writeInt(this.D);
            parcel0.writeInt(((int)this.E));
            parcel0.writeList(this.G);
            parcel0.writeInt(this.I);
            parcel0.writeInt(this.M);
            parcel0.writeInt(this.N);
            parcel0.writeInt(((int)this.S));
            parcel0.writeInt(((int)this.T));
            parcel0.writeInt(((int)this.V));
            parcel0.writeInt(((int)this.W));
            parcel0.writeList(this.X);
            parcel0.writeInt(((int)this.Y));
            parcel0.writeInt(((int)this.Z));
            parcel0.writeInt(((int)this.b0));
            parcel0.writeInt(((int)this.c0));
            parcel0.writeInt(((int)this.d0));
            SparseArray sparseArray0 = this.e0;
            int v1 = sparseArray0.size();
            parcel0.writeInt(v1);
            for(int v2 = 0; v2 < v1; ++v2) {
                int v3 = sparseArray0.keyAt(v2);
                Map map0 = (Map)sparseArray0.valueAt(v2);
                parcel0.writeInt(v3);
                parcel0.writeInt(map0.size());
                for(Object object0: map0.entrySet()) {
                    parcel0.writeParcelable(((Parcelable)((Map.Entry)object0).getKey()), 0);
                    parcel0.writeParcelable(((Parcelable)((Map.Entry)object0).getValue()), 0);
                }
            }
            parcel0.writeSparseBooleanArray(this.f0);
        }
    }

    public static final class e extends b {
        public boolean A;
        public boolean B;
        public h9 C;
        public boolean D;
        public boolean E;
        public boolean F;
        public boolean G;
        public boolean H;
        public final SparseArray I;
        public final SparseBooleanArray J;
        public int g;
        public int h;
        public int i;
        public int j;
        public final int k;
        public final int l;
        public final int m;
        public final int n;
        public boolean o;
        public boolean p;
        public boolean q;
        public int r;
        public int s;
        public boolean t;
        public h9 u;
        public int v;
        public int w;
        public int x;
        public boolean y;
        public boolean z;

        public e() {
            this.b();
            this.I = new SparseArray();
            this.J = new SparseBooleanArray();
        }

        public e(Context context0) {
            super(context0);
            Point point0;
            this.b();
            this.I = new SparseArray();
            this.J = new SparseBooleanArray();
            WindowManager windowManager0 = (WindowManager)context0.getSystemService("window");
            windowManager0.getClass();
            Display display0 = windowManager0.getDefaultDisplay();
            int v = L7.a;
            if(v > 29 || display0.getDisplayId() != 0) {
            label_24:
                point0 = new Point();
                if(v >= 23) {
                    Display.Mode display$Mode0 = display0.getMode();
                    point0.x = display$Mode0.getPhysicalWidth();
                    point0.y = display$Mode0.getPhysicalHeight();
                }
                else if(v >= 17) {
                    display0.getRealSize(point0);
                }
                else {
                    display0.getSize(point0);
                }
            }
            else {
                UiModeManager uiModeManager0 = (UiModeManager)context0.getApplicationContext().getSystemService("uimode");
                if(uiModeManager0 == null || uiModeManager0.getCurrentModeType() != 4) {
                    goto label_24;
                }
                else if("Sony".equals(L7.d) && L7.e.startsWith("BRAVIA") && context0.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                    point0 = new Point(0xF00, 0x870);
                }
                else {
                    String s = v >= 28 ? L7.B("vendor.display-size") : L7.B("sys.display-size");
                    if(!TextUtils.isEmpty(s)) {
                        try {
                            String[] arr_s = s.trim().split("x", -1);
                            if(arr_s.length == 2) {
                                int v1 = Integer.parseInt(arr_s[0]);
                                int v2 = Integer.parseInt(arr_s[1]);
                                if(v1 > 0 && v2 > 0) {
                                    point0 = new Point(v1, v2);
                                    this.r = point0.x;
                                    this.s = point0.y;
                                    this.t = true;
                                    return;
                                }
                            }
                        }
                        catch(NumberFormatException unused_ex) {
                        }
                        Log.e("Util", "Invalid display size: " + s);
                    }
                    goto label_24;
                }
            }
            this.r = point0.x;
            this.s = point0.y;
            this.t = true;
        }

        public e(d fi$d0) {
            this.a = fi$d0.a;
            this.b = fi$d0.b;
            this.c = fi$d0.c;
            this.d = fi$d0.d;
            this.e = fi$d0.e;
            this.f = fi$d0.f;
            this.g = fi$d0.g;
            this.h = fi$d0.h;
            this.i = fi$d0.i;
            this.j = fi$d0.j;
            this.k = fi$d0.k;
            this.l = fi$d0.l;
            this.m = fi$d0.m;
            this.n = fi$d0.n;
            this.o = fi$d0.o;
            this.p = fi$d0.r;
            this.q = fi$d0.w;
            this.r = fi$d0.B;
            this.s = fi$d0.D;
            this.t = fi$d0.E;
            this.u = fi$d0.G;
            this.v = fi$d0.I;
            this.w = fi$d0.M;
            this.x = fi$d0.N;
            this.y = fi$d0.S;
            this.z = fi$d0.T;
            this.A = fi$d0.V;
            this.B = fi$d0.W;
            this.C = fi$d0.X;
            this.D = fi$d0.Y;
            this.E = fi$d0.Z;
            this.F = fi$d0.b0;
            this.G = fi$d0.c0;
            this.H = fi$d0.d0;
            SparseArray sparseArray0 = fi$d0.e0;
            SparseArray sparseArray1 = new SparseArray();
            for(int v = 0; v < sparseArray0.size(); ++v) {
                sparseArray1.put(sparseArray0.keyAt(v), new HashMap(((Map)sparseArray0.valueAt(v))));
            }
            this.I = sparseArray1;
            this.J = fi$d0.f0.clone();
        }

        public final d a() {
            return new d(this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.a, this.b, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.c, this.d, this.e, this.f, this.D, this.E, this.F, this.G, this.H, this.I, this.J);
        }

        public final void b() {
            this.g = 0x7FFFFFFF;
            this.h = 0x7FFFFFFF;
            this.i = 0x7FFFFFFF;
            this.j = 0x7FFFFFFF;
            this.o = true;
            this.p = false;
            this.q = true;
            this.r = 0x7FFFFFFF;
            this.s = 0x7FFFFFFF;
            this.t = true;
            this.u = c5.e;
            this.v = -1;
            this.w = 0x7FFFFFFF;
            this.x = 0x7FFFFFFF;
            this.y = true;
            this.z = false;
            this.A = false;
            this.B = false;
            this.C = c5.e;
            this.D = false;
            this.E = false;
            this.F = true;
            this.G = false;
            this.H = true;
        }
    }

    public static final class f implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final int a;
        public final int[] b;
        public final int c;
        public final boolean d;

        static {
            f.CREATOR = new T2();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public f(Parcel parcel0) {
            this.a = parcel0.readInt();
            int[] arr_v = new int[parcel0.readByte()];
            this.b = arr_v;
            parcel0.readIntArray(arr_v);
            this.c = parcel0.readInt();
            this.d = parcel0.readInt() > 0;
        }

        public f(int[] arr_v, int v, boolean z) {
            this.a = v;
            int[] arr_v1 = Arrays.copyOf(arr_v, arr_v.length);
            this.b = arr_v1;
            this.c = 0;
            this.d = z;
            Arrays.sort(arr_v1);
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
                return f.class == class0 && this.a == ((f)object0).a && Arrays.equals(this.b, ((f)object0).b) && this.c == ((f)object0).c && this.d == ((f)object0).d;
            }
            return false;
        }

        @Override
        public final int hashCode() {
            return ((Arrays.hashCode(this.b) + this.a * 0x1F) * 0x1F + this.c) * 0x1F + this.d;
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b.length);
            parcel0.writeIntArray(this.b);
            parcel0.writeInt(this.c);
            parcel0.writeInt(((int)this.d));
        }
    }

    public final K3 e;
    public final AtomicReference f;
    public static final int[] g;
    public static final o4 h;
    public static final o4 i;

    static {
        fi.g = new int[0];
        fi.h = new F5(new A0(2));
        fi.i = new F5(new A0(3));
    }

    public fi(Context context0) {
        this(context0, new w1());
    }

    public fi(Context context0, K3 k30) {
        d fi$d0 = new e(context0).a();
        super();
        this.d = false;
        this.e = k30;
        this.f = new AtomicReference(fi$d0);
    }

    public static int a(u u0, String s, boolean z) {
        if(!TextUtils.isEmpty(s) && s.equals(u0.c)) {
            return 4;
        }
        String s1 = fi.b(s);
        String s2 = fi.b(u0.c);
        if(s2 != null && s1 != null) {
            if(!s2.startsWith(s1) && !s1.startsWith(s2)) {
                return s2.split("-", 2)[0].equals(s1.split("-", 2)[0]) ? 2 : 0;
            }
            return 3;
        }
        return !z || s2 != null ? 0 : 1;
    }

    // 去混淆评级： 低(20)
    public static String b(String s) {
        return TextUtils.isEmpty(s) || TextUtils.equals(s, "und") ? null : s;
    }

    public static ArrayList c(vc vc0, int v, int v1, boolean z) {
        int v16;
        int v9;
        int v8;
        int v2 = vc0.a;
        u[] arr_u = vc0.b;
        ArrayList arrayList0 = new ArrayList(v2);
        for(int v3 = 0; v3 < v2; v3 = a.d(v3, v3, 1, arrayList0)) {
        }
        if(v != 0x7FFFFFFF && v1 != 0x7FFFFFFF) {
            int v4 = 0x7FFFFFFF;
            for(int v5 = 0; v5 < v2; ++v5) {
                u u0 = arr_u[v5];
                int v6 = u0.w;
                int v7 = u0.B;
                if(v6 > 0 && v7 > 0) {
                    if(!z || (v6 <= v7 ? 0 : 1) == (v <= v1 ? 0 : 1)) {
                        v9 = v;
                        v8 = v1;
                    }
                    else {
                        v8 = v;
                        v9 = v1;
                    }
                    int v10 = v6 * v8;
                    int v11 = v7 * v9;
                    Point point0 = v10 < v11 ? new Point((v10 + v7 - 1) / v7, v8) : new Point(v9, (v11 + v6 - 1) / v6);
                    int v12 = u0.w * v7;
                    if(u0.w >= ((int)(((float)point0.x) * 0.98f)) && v7 >= ((int)(((float)point0.y) * 0.98f)) && v12 < v4) {
                        v4 = v12;
                    }
                }
            }
            if(v4 != 0x7FFFFFFF) {
                for(int v13 = arrayList0.size() - 1; v13 >= 0; --v13) {
                    u u1 = arr_u[((int)(((Integer)arrayList0.get(v13))))];
                    int v14 = u1.w;
                    if(v14 == -1) {
                        v16 = -1;
                    }
                    else {
                        int v15 = u1.B;
                        if(v15 != -1) {
                            v16 = v14 * v15;
                        }
                    }
                    if(v16 == -1 || v16 > v4) {
                        arrayList0.remove(v13);
                    }
                }
            }
        }
        return arrayList0;
    }

    public static boolean d(int v, boolean z) {
        return (v & 7) == 4 || z && (v & 7) == 3;
    }

    // 去混淆评级： 中等(50)
    public static boolean e(u u0, String s, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8, int v9) {
        return (u0.e & 0x4000) == 0 ? fi.d(v, false) && (v & v1) != 0 && (s == null || L7.p(u0.l, s)) && (u0.w == -1 || v6 <= u0.w && u0.w <= v2) && (u0.B == -1 || v7 <= u0.B && u0.B <= v3) && (u0.D == -1.0f || ((float)v8) <= u0.D && u0.D <= ((float)v4)) && (u0.h != -1 && v9 <= u0.h && u0.h <= v5) : false;
    }

    public static int[] f(vc vc0, int[] arr_v, boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7, int v8, int v9, int v10, boolean z1) {
        u[] arr_u = vc0.b;
        if(vc0.a >= 2) {
            String s = null;
            ArrayList arrayList0 = fi.c(vc0, v9, v10, z1);
            if(arrayList0.size() >= 2) {
                if(!z) {
                    HashSet hashSet0 = new HashSet();
                    int v12 = 0;
                    for(int v11 = 0; v11 < arrayList0.size(); ++v11) {
                        String s1 = arr_u[((int)(((Integer)arrayList0.get(v11))))].l;
                        if(hashSet0.add(s1)) {
                            int v14 = 0;
                            for(int v13 = 0; v13 < arrayList0.size(); ++v13) {
                                int v15 = (int)(((Integer)arrayList0.get(v13)));
                                if(fi.e(arr_u[v15], s1, arr_v[v15], v, v1, v2, v3, v4, v5, v6, v7, v8)) {
                                    ++v14;
                                }
                            }
                            if(v14 > v12) {
                                v12 = v14;
                                s = s1;
                            }
                        }
                    }
                }
                for(int v16 = arrayList0.size() - 1; v16 >= 0; --v16) {
                    int v17 = (int)(((Integer)arrayList0.get(v16)));
                    if(!fi.e(arr_u[v17], s, arr_v[v17], v, v1, v2, v3, v4, v5, v6, v7, v8)) {
                        arrayList0.remove(v16);
                    }
                }
                return arrayList0.size() >= 2 ? M7.x(arrayList0) : fi.g;
            }
        }
        return fi.g;
    }
}

