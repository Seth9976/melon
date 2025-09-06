package com.iloen.melon.fragments.radio;

import B3.L;
import B3.b;
import Jd.c;
import Jd.d;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.o;
import androidx.media3.exoplayer.f;
import c2.B0;
import c2.v;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.s1;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFragment;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.digitalitem.image.lib.OnPreparedListener;
import com.kakao.emoticon.ui.widget.EmoticonSpan;
import com.kakao.sdk.auth.TalkAuthCodeActivity;
import d2.n;
import e3.j;
import e3.p;
import e7.i;
import f3.l;
import gd.u1;
import i.n.i.b.a.s.e.Bb;
import i.n.i.b.a.s.e.C2;
import i.n.i.b.a.s.e.D6;
import i.n.i.b.a.s.e.D7;
import i.n.i.b.a.s.e.Da;
import i.n.i.b.a.s.e.I9;
import i.n.i.b.a.s.e.J7;
import i.n.i.b.a.s.e.K9;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.S1;
import i.n.i.b.a.s.e.S;
import i.n.i.b.a.s.e.Wa;
import i.n.i.b.a.s.e.Xa;
import i.n.i.b.a.s.e.e;
import i.n.i.b.a.s.e.i4;
import i.n.i.b.a.s.e.j3;
import i.n.i.b.a.s.e.m4;
import i.n.i.b.a.s.e.q3;
import i.n.i.b.a.s.e.u;
import i.n.i.b.a.s.e.y2;
import i.n.i.b.a.s.e.yb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import s3.q;
import y8.s;

public final class a implements v, ErrorListener, Continuation, s1, OnPreparedListener, n, e.a, j, l, Bb, Da, J7, S, j3 {
    public final int a;
    public final Object b;

    public a(S1 s10, Bf.a a0) {
        this.a = 15;
        super();
        this.b = s10;
    }

    public a(i3.a a0, f f0) {
        this.a = 28;
        super();
        this.b = f0;
    }

    public a(i3.a a0, q q0, s3.v v0, IOException iOException0, boolean z) {
        this.a = 27;
        super();
        this.b = v0;
    }

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // i.n.i.b.a.s.e.Bb
    public int a(Object object0) {
        u u0 = (u)this.b;
        K9 k90 = (K9)object0;
        try {
            return k90.f(u0);
        }
        catch(yb unused_ex) {
            return -1;
        }
    }

    @Override  // i.n.i.b.a.s.e.S
    public long a(long v) {
        return L7.A(v * ((long)((I9)this.b).e) / 1000000L, 0L, ((I9)this.b).j - 1L);
    }

    @Override  // i.n.i.b.a.s.e.Da
    public Object a(Object object0) {
        ((q3)this.b).getClass();
        return (D6)object0;
    }

    @Override  // i.n.i.b.a.s.e.j3
    public C2 b(e e0) {
        return (C2)this.b;
    }

    @Override  // f3.l
    public void c(long v, p p0) {
        b.d(v, p0, ((L[])((s)this.b).b));
    }

    public void d(D7 d70) {
        if(this.a != 17) {
            ((Wa)d70).b = 0;
            ((Wa)d70).d = null;
            ((Xa)this.b).b.add(((Wa)d70));
            return;
        }
        i4 i40 = (i4)this.b;
        synchronized(i40.b) {
            d70.b = 0;
            d70.d = null;
            int v1 = i40.h;
            i40.h = v1 + 1;
            i40.f[v1] = d70;
            if(!i40.c.isEmpty() && i40.h > 0) {
                i40.b.notify();
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.J7
    public void e(Object object0, m4 m40) {
        SparseArray sparseArray0 = ((S1)this.b).d;
        SparseBooleanArray sparseBooleanArray0 = m40.a;
        SparseArray sparseArray1 = new SparseArray(sparseBooleanArray0.size());
        for(int v = 0; v < sparseBooleanArray0.size(); ++v) {
            int v1 = m40.a(v);
            y2 y20 = (y2)sparseArray0.get(v1);
            y20.getClass();
            sparseArray1.append(v1, y20);
        }
        ((E9.s)object0).getClass();
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 27) {
            ((i3.j)(((i3.b)object0))).x += ((f)this.b).g;
            ((i3.j)(((i3.b)object0))).y += ((f)this.b).e;
            return;
        }
        ((i3.j)(((i3.b)object0))).getClass();
        ((i3.j)(((i3.b)object0))).v = ((s3.v)this.b).a;
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        if(this.a != 1) {
            TalkAuthCodeActivity.k(((TalkAuthCodeActivity)this.b), ((ActivityResult)object0));
            return;
        }
        MelonWebViewFragment.f0(((MelonWebViewFragment)this.b), ((ActivityResult)object0));
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        Object object0 = this.b;
        if(this.a != 0) {
            ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            if(((MelonBaseFragment)object0) != null) {
                ((MelonBaseFragment)object0).showProgress(false);
            }
            return;
        }
        StationFragment.f0(((StationFragment)object0), volleyError0);
    }

    @Override  // com.kakao.digitalitem.image.lib.OnPreparedListener
    public void onPrepared() {
        EmoticonSpan.b(((TextView)this.b));
    }

    @Override  // com.iloen.melon.custom.s1
    public void onToolBarItemClicked(ToolBarItem toolBar$ToolBarItem0, int v) {
        Jd.e e0;
        u1 u10 = (u1)this.b;
        switch(v) {
            case 0: {
                e0 = Jd.e.c;
                break;
            }
            case 1: {
                e0 = c.c;
                break;
            }
            case 2: {
                e0 = Jd.b.c;
                break;
            }
            case 14: {
                e0 = Jd.f.c;
                break;
            }
            case 0x1F: {
                e0 = d.c;
                break;
            }
            default: {
                return;
            }
        }
        u10.sendUserEvent(e0);
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        f2.d d0 = (f2.d)this.b;
        ArrayList arrayList0 = d0.b;
        S1.d d1 = S1.d.b(b00.a.g(0x207), b00.a.g(0x40));
        S1.d d2 = S1.d.b(b00.a.h(0x207), b00.a.h(0x40));
        if(!d1.equals(d0.c) || !d2.equals(d0.d)) {
            d0.c = d1;
            d0.d = d2;
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                ArrayList arrayList1 = ((f2.a)arrayList0.get(v)).a;
                int v1 = arrayList1.size() - 1;
                if(v1 >= 0) {
                    throw o.g(v1, arrayList1);
                }
            }
        }
        return b00;
    }

    @Override  // d2.n
    public boolean t(View view0) {
        return ((BottomSheetDragHandleView)this.b).c();
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        switch(this.a) {
            case 6: {
                ((CountDownLatch)this.b).countDown();
                return null;
            }
            case 8: {
                return (Task)((i)this.b).call();
            }
            default: {
                ((Runnable)this.b).run();
                return Tasks.forResult(null);
            }
        }
    }
}

