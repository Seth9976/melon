package androidx.room;

import M7.b0;
import android.content.Context;
import android.content.Intent;
import ea.a;
import ie.m;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import je.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

public final class p {
    public final String a;
    public final l b;
    public final Context c;
    public final CoroutineScope d;
    public final AtomicBoolean e;
    public int f;
    public h g;
    public final MutableSharedFlow h;
    public final a i;
    public final o j;
    public final b0 k;

    public p(Context context0, String s, l l0) {
        q.g(context0, "context");
        q.g(s, "name");
        super();
        this.a = s;
        this.b = l0;
        this.c = context0.getApplicationContext();
        this.d = l0.a.getCoroutineScope();
        this.e = new AtomicBoolean(true);
        this.h = SharedFlowKt.MutableSharedFlow(0, 0, BufferOverflow.SUSPEND);
        this.i = new a(this, l0.b);
        this.j = new o(this);
        this.k = new b0(this, 1);
    }

    public final void a(Intent intent0) {
        q.g(intent0, "serviceIntent");
        if(this.e.compareAndSet(true, false)) {
            this.c.bindService(intent0, this.k, 1);
            q.g(this.i, "observer");
            LinkedHashMap linkedHashMap0 = this.b.d;
            h0 h00 = this.b.c;
            m m0 = h00.g(((String[])this.i.a));
            int[] arr_v = (int[])m0.b;
            v v0 = new v(this.i, arr_v, ((String[])m0.a));
            this.b.e.lock();
            try {
                v v2 = linkedHashMap0.containsKey(this.i) ? ((v)C.Q(this.i, linkedHashMap0)) : ((v)linkedHashMap0.put(this.i, v0));
            }
            finally {
                this.b.e.unlock();
            }
            if(v2 == null) {
                h00.h.j(arr_v);
            }
        }
    }
}

