package W;

import B2.o;
import Q0.b1;
import U.f0;
import Ua.h;
import Y.Q;
import a1.T;
import android.graphics.Rect;
import android.os.LocaleList;
import android.view.View;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import d3.g;
import f1.j;
import f1.x;
import h1.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import je.n;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.k;

public final class w {
    public final View a;
    public final p b;
    public r c;
    public k d;
    public f0 e;
    public Q f;
    public b1 g;
    public x h;
    public j i;
    public final ArrayList j;
    public final Object k;
    public Rect l;
    public final s m;

    public w(View view0, c c0, p p0) {
        this.a = view0;
        this.b = p0;
        this.c = a.h;
        this.d = a.i;
        this.h = new x("", T.b, 4);
        this.i = j.g;
        this.j = new ArrayList();
        o o0 = new o(this, 28);
        this.k = g.P(ie.k.c, o0);
        this.m = new s(c0, p0);
    }

    public final W.x a(EditorInfo editorInfo0) {
        int v3;
        int v2;
        String s = this.h.a.b;
        long v = this.h.b;
        j j0 = this.i;
        int v1 = j0.d;
        boolean z = j0.a;
        switch(j0.e) {
            case 0: {
                v2 = 1;
                break;
            }
            case 2: {
                v2 = 2;
                break;
            }
            case 3: {
                v2 = 3;
                break;
            }
            case 4: {
                v2 = 4;
                break;
            }
            case 5: {
                v2 = 7;
                break;
            }
            case 6: {
                v2 = 5;
                break;
            }
            case 7: {
                v2 = 6;
                break;
            }
            default: {
                throw new IllegalStateException("invalid ImeAction");
            }
        }
        editorInfo0.imeOptions = v2;
        b b0 = j0.f;
        if(q.b(b0, b.c)) {
            editorInfo0.hintLocales = null;
        }
        else {
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, b0));
            for(Object object0: b0.a) {
                arrayList0.add(((h1.a)object0).a);
            }
            Locale[] arr_locale = (Locale[])arrayList0.toArray(new Locale[0]);
            editorInfo0.hintLocales = new LocaleList(((Locale[])Arrays.copyOf(arr_locale, arr_locale.length)));
        }
        switch(v1) {
            case 1: {
                v3 = 1;
                break;
            }
            case 2: {
                editorInfo0.imeOptions |= 0x80000000;
                v3 = 1;
                break;
            }
            case 3: {
                v3 = 2;
                break;
            }
            case 4: {
                v3 = 3;
                break;
            }
            case 5: {
                v3 = 17;
                break;
            }
            case 6: {
                v3 = 33;
                break;
            }
            case 7: {
                v3 = 0x81;
                break;
            }
            case 8: {
                v3 = 18;
                break;
            }
            case 9: {
                v3 = 0x2002;
                break;
            }
            default: {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
        }
        editorInfo0.inputType = v3;
        if(!z && (v3 & 1) == 1) {
            editorInfo0.inputType = 0x20000 | v3;
            if(j0.e == 1) {
                editorInfo0.imeOptions |= 0x40000000;
            }
        }
        int v4 = editorInfo0.inputType;
        if((v4 & 1) == 1) {
            int v5 = j0.b;
            if(v5 == 1) {
                editorInfo0.inputType = v4 | 0x1000;
            }
            else if(v5 == 2) {
                editorInfo0.inputType = v4 | 0x2000;
            }
            else if(v5 == 3) {
                editorInfo0.inputType = v4 | 0x4000;
            }
            if(j0.c) {
                editorInfo0.inputType |= 0x8000;
            }
        }
        editorInfo0.initialSelStart = (int)(v >> 0x20);
        editorInfo0.initialSelEnd = (int)(v & 0xFFFFFFFFL);
        e2.a.P(editorInfo0, s);
        editorInfo0.imeOptions |= 0x2000000;
        if(!V.c.a || (v1 == 7 || v1 == 8)) {
            e2.a.R(editorInfo0, false);
        }
        else {
            e2.a.R(editorInfo0, true);
            editorInfo0.setSupportedHandwritingGestures(e.k.A(new Class[]{SelectGesture.class, DeleteGesture.class, SelectRangeGesture.class, DeleteRangeGesture.class, JoinOrSplitGesture.class, InsertGesture.class, RemoveSpaceGesture.class}));
            editorInfo0.setSupportedHandwritingGesturePreviews(n.A0(new Class[]{SelectGesture.class, DeleteGesture.class, SelectRangeGesture.class, DeleteRangeGesture.class}));
        }
        boolean z1 = this.i.c;
        W.x x0 = new W.x(this.h, new h(this), z1, this.e, this.f, this.g);
        WeakReference weakReference0 = new WeakReference(x0);
        this.j.add(weakReference0);
        return x0;
    }
}

