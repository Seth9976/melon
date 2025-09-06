package com.iloen.melon.sns.model;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.V;
import androidx.media3.session.M;
import i.n.i.b.a.s.e.E4;
import i.n.i.b.a.s.e.I7;
import i.n.i.b.a.s.e.J7;
import i.n.i.b.a.s.e.K7;
import i.n.i.b.a.s.e.V4;
import i.n.i.b.a.s.e.W4;
import i.n.i.b.a.s.e.m4;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a {
    public boolean a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Serializable f;
    public Object g;

    public a(Looper looper0, E4 e40, J7 j70) {
        this(new CopyOnWriteArraySet(), looper0, e40, j70);
    }

    public a(CopyOnWriteArraySet copyOnWriteArraySet0, Looper looper0, E4 e40, J7 j70) {
        this.b = e40;
        this.e = copyOnWriteArraySet0;
        this.d = j70;
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
        M m0 = new M(this, 5);
        e40.getClass();
        this.c = new W4(new Handler(looper0, m0));
    }

    public void a() {
        W4 w40 = (W4)this.c;
        ArrayDeque arrayDeque0 = (ArrayDeque)this.f;
        ArrayDeque arrayDeque1 = (ArrayDeque)this.g;
        if(!arrayDeque1.isEmpty()) {
            if(!w40.a.hasMessages(0)) {
                w40.getClass();
                V4 v40 = W4.a();
                v40.a = w40.a.obtainMessage(0);
                v40.a();
            }
            arrayDeque0.addAll(arrayDeque1);
            arrayDeque1.clear();
            if(arrayDeque0.isEmpty()) {
                while(!arrayDeque0.isEmpty()) {
                    ((Runnable)arrayDeque0.peekFirst()).run();
                    arrayDeque0.removeFirst();
                }
            }
        }
    }

    public void b() {
        CopyOnWriteArraySet copyOnWriteArraySet0 = (CopyOnWriteArraySet)this.e;
        for(Object object0: copyOnWriteArraySet0) {
            K7 k70 = (K7)object0;
            J7 j70 = (J7)this.d;
            k70.d = true;
            if(k70.c) {
                m4 m40 = k70.b.a();
                j70.e(k70.a, m40);
            }
        }
        copyOnWriteArraySet0.clear();
        this.a = true;
    }

    public void c(int v, I7 i70) {
        CopyOnWriteArraySet copyOnWriteArraySet0 = new CopyOnWriteArraySet(((CopyOnWriteArraySet)this.e));
        ((ArrayDeque)this.g).add(new V(copyOnWriteArraySet0, v, i70, 7));
    }
}

