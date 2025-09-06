package androidx.room;

import D2.E0;
import G4.b;
import H4.d;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.q;
import me.i;

public final class a {
    public final Context a;
    public final String b;
    public final d c;
    public final E0 d;
    public final List e;
    public final boolean f;
    public final D g;
    public final Executor h;
    public final Executor i;
    public final Intent j;
    public final boolean k;
    public final boolean l;
    public final Set m;
    public final String n;
    public final File o;
    public final Callable p;
    public final List q;
    public final List r;
    public final boolean s;
    public final b t;
    public final i u;
    public boolean v;

    public a(Context context0, String s, d d0, E0 e00, List list0, boolean z, D d1, Executor executor0, Executor executor1, Intent intent0, boolean z1, boolean z2, Set set0, String s1, File file0, Callable callable0, List list1, List list2, boolean z3, b b0, i i0) {
        q.g(context0, "context");
        q.g(e00, "migrationContainer");
        q.g(executor0, "queryExecutor");
        q.g(executor1, "transactionExecutor");
        q.g(list1, "typeConverters");
        q.g(list2, "autoMigrationSpecs");
        super();
        this.a = context0;
        this.b = s;
        this.c = d0;
        this.d = e00;
        this.e = list0;
        this.f = z;
        this.g = d1;
        this.h = executor0;
        this.i = executor1;
        this.j = intent0;
        this.k = z1;
        this.l = z2;
        this.m = set0;
        this.n = s1;
        this.o = file0;
        this.p = callable0;
        this.q = list1;
        this.r = list2;
        this.s = z3;
        this.t = b0;
        this.u = i0;
        this.v = true;
    }
}

