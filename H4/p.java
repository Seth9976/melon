package h4;

import B3.L;
import B3.N;
import android.util.SparseArray;

public final class p {
    public final L a;
    public final boolean b;
    public final boolean c;
    public final SparseArray d;
    public final SparseArray e;
    public final N f;
    public byte[] g;
    public int h;
    public int i;
    public long j;
    public boolean k;
    public long l;
    public o m;
    public o n;
    public boolean o;
    public long p;
    public long q;
    public boolean r;
    public boolean s;

    public p(L l0, boolean z, boolean z1) {
        this.a = l0;
        this.b = z;
        this.c = z1;
        this.d = new SparseArray();
        this.e = new SparseArray();
        this.m = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.n = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        byte[] arr_b = new byte[0x80];
        this.g = arr_b;
        this.f = new N(0, 0, 3, arr_b);
        this.k = false;
        this.o = false;
        this.n.b = false;
        this.n.a = false;
    }

    public final void a() {
        boolean z1;
        boolean z = false;
        if(!this.b) {
            z1 = this.s;
        }
        else if(this.n.b && (this.n.d == 2 || this.n.d == 7)) {
            z1 = true;
        }
        else {
            z1 = false;
        }
        boolean z2 = this.r;
        if(this.i == 5 || z1 && this.i == 1) {
            z = true;
        }
        this.r = z2 | z;
    }
}

