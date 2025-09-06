package gd;

import Gf.l;
import J0.f;
import android.content.Context;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.r0;
import d3.g;
import d8.d;
import e1.G;
import ie.H;
import ie.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.Map;
import jd.A;
import kg.c;
import kg.h;
import kg.k;
import kg.p;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import ld.m;
import og.i;
import p2.b;
import w0.u;
import we.a;

public final class k4 extends r implements a {
    public final int f;
    public final Object g;
    public final Object h;

    public k4(int v, Object object0, Object object1) {
        this.f = v;
        this.h = object0;
        this.g = object1;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                r0 r00 = (r0)((j)this.g).getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? ((l4)this.h).getDefaultViewModelProviderFactory() : o00;
                }
                return ((l4)this.h).getDefaultViewModelProviderFactory();
            }
            case 1: {
                r0 r01 = (r0)((j)this.g).getValue();
                n n1 = r01 instanceof n ? ((n)r01) : null;
                if(n1 != null) {
                    o0 o01 = n1.getDefaultViewModelProviderFactory();
                    return o01 == null ? ((A)this.h).getDefaultViewModelProviderFactory() : o01;
                }
                return ((A)this.h).getDefaultViewModelProviderFactory();
            }
            case 2: {
                ((c)this.h).h.invoke(((Map)this.g));
                return H.a;
            }
            case 3: {
                ((c)this.h).h.invoke(((IOException)this.g));
                return H.a;
            }
            case 4: {
                ((h)this.h).g.e(((jg.h)this.g));
                return H.a;
            }
            case 5: {
                ((h)this.h).g.e(((jg.h)this.g));
                return H.a;
            }
            case 6: {
                kg.j j0 = (kg.j)this.h;
                k k0 = (k)this.g;
                l l0 = new l(true);
                String s = k0.o.e();
                try {
                    g.R(l0, k0);
                    kg.l l1 = k0.a(null);
                    l1.b(l0);
                    lg.a a0 = j0.j;
                    synchronized(a0) {
                        if(j0.g.remove(s) != null) {
                            j0.a(l1);
                        }
                    }
                }
                catch(Exception unused_ex) {
                    lg.a a1 = j0.j;
                    synchronized(a1) {
                        k k1 = (k)j0.g.remove(s);
                    }
                }
                finally {
                    l0.c();
                }
                return H.a;
            }
            case 7: {
                f f0 = (f)this.g;
                kg.r r0 = ((p)this.h).a();
                r0.getClass();
                boolean z = false;
                try {
                    String s1 = r0.c;
                    if(s1 == null || s1.length() == 0) {
                        z = r0.d(true);
                    }
                    else if(r0.c(s1)) {
                        r0.b.c(r0.d);
                        z = true;
                    }
                }
                catch(IOException iOException0) {
                    d.D(6, iOException0, "fail to subscribe", Arrays.copyOf(new Object[0], 0));
                }
                f0.invoke(Boolean.valueOf(z));
                return H.a;
            }
            case 8: {
                Boolean boolean0 = Boolean.valueOf(((p)this.h).a().e());
                ((f)this.g).invoke(boolean0);
                return H.a;
            }
            case 9: {
                r0 r02 = (r0)((j)this.g).getValue();
                n n2 = r02 instanceof n ? ((n)r02) : null;
                if(n2 != null) {
                    o0 o02 = n2.getDefaultViewModelProviderFactory();
                    return o02 == null ? ((m)this.h).getDefaultViewModelProviderFactory() : o02;
                }
                return ((m)this.h).getDefaultViewModelProviderFactory();
            }
            case 10: {
                i i0 = (i)this.h;
                jg.h h0 = (jg.h)((X.k)this.g).invoke();
                if(!i0.d.e()) {
                    Arrays.copyOf(new Object[0], 0);
                    return H.a;
                }
                MulticastSocket multicastSocket0 = i0.b;
                if(multicastSocket0 != null) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                        h0.d(byteArrayOutputStream0);
                        byte[] arr_b = byteArrayOutputStream0.toByteArray();
                        multicastSocket0.send(new DatagramPacket(arr_b, arr_b.length, i0.f.b));
                        return H.a;
                    }
                    catch(IOException iOException1) {
                        d.I(iOException1);
                    }
                }
                return H.a;
            }
            case 11: {
                q.f(((Context)this.h), "applicationContext");
                return G.x(((Context)this.h), ((b)this.g).a);
            }
            case 12: {
                ((v0.c)this.h).c.invoke(((v0.d)this.g));
                return H.a;
            }
            default: {
                ((kotlin.jvm.internal.H)this.h).a = ((u)this.g).n0();
                return H.a;
            }
        }
    }
}

