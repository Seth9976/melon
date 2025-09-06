package W;

import A6.d;
import B0.b;
import Q0.b1;
import Tf.n;
import U.J0;
import U.f0;
import Ua.h;
import Y.Q;
import a1.P;
import a1.T;
import a1.t;
import a1.y;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import f1.a;
import f1.e;
import f1.f;
import f1.g;
import f1.i;
import f1.u;
import f1.v;
import ie.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import je.p;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import we.k;
import x0.c;
import y0.M;

public final class x implements InputConnection {
    public final h a;
    public final boolean b;
    public final f0 c;
    public final Q d;
    public final b1 e;
    public int f;
    public f1.x g;
    public int h;
    public boolean i;
    public final ArrayList j;
    public boolean k;

    public x(f1.x x0, h h0, boolean z, f0 f00, Q q0, b1 b10) {
        this.a = h0;
        this.b = z;
        this.c = f00;
        this.d = q0;
        this.e = b10;
        this.g = x0;
        this.j = new ArrayList();
        this.k = true;
    }

    public final void a(g g0) {
        try {
            ++this.f;
            this.j.add(g0);
        }
        finally {
            this.b();
        }
    }

    public final boolean b() {
        int v = this.f - 1;
        this.f = v;
        if(v == 0) {
            ArrayList arrayList0 = this.j;
            if(!arrayList0.isEmpty()) {
                ArrayList arrayList1 = p.Q0(arrayList0);
                ((k)((w)this.a.a).c).invoke(arrayList1);
                arrayList0.clear();
            }
        }
        return this.f > 0;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        if(this.k) {
            ++this.f;
            return true;
        }
        return false;
    }

    public final void c(int v) {
        this.sendKeyEvent(new KeyEvent(0, v));
        this.sendKeyEvent(new KeyEvent(1, v));
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int v) {
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        this.j.clear();
        this.f = 0;
        this.k = false;
        ArrayList arrayList0 = ((w)this.a.a).j;
        int v1 = arrayList0.size();
        for(int v = 0; v < v1; ++v) {
            if(q.b(((WeakReference)arrayList0.get(v)).get(), this)) {
                arrayList0.remove(v);
                return;
            }
        }
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitCompletion(CompletionInfo completionInfo0) {
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo0, int v, Bundle bundle0) {
        return false;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitCorrection(CorrectionInfo correctionInfo0) {
        return this.k ? this.b : false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence0, int v) {
        boolean z = this.k;
        if(z) {
            this.a(new a(String.valueOf(charSequence0), v));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int v, int v1) {
        if(this.k) {
            this.a(new e(v, v1));
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int v, int v1) {
        if(this.k) {
            this.a(new f(v, v1));
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean endBatchEdit() {
        return this.b();
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        if(this.k) {
            this.a(new f1.h());  // 初始化器: Ljava/lang/Object;-><init>()V
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int v) {
        return TextUtils.getCapsMode(this.g.a.b, T.e(this.g.b), v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest0, int v) {
        boolean z = true;
        int v1 = 0;
        if((v & 1) == 0) {
            z = false;
        }
        this.i = z;
        if(z) {
            if(extractedTextRequest0 != null) {
                v1 = extractedTextRequest0.token;
            }
            this.h = v1;
        }
        return B.a.i(this.g);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int v) {
        return T.b(this.g.b) ? null : e2.a.H(this.g).b;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int v, int v1) {
        return e2.a.I(this.g, v).b;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int v, int v1) {
        return e2.a.J(this.g, v).b;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int v) {
        if(this.k) {
            switch(v) {
                case 0x102001F: {
                    this.a(new v(0, this.g.a.b.length()));
                    break;
                }
                case 0x1020020: {
                    this.c(277);
                    return false;
                }
                case 0x1020021: {
                    this.c(278);
                    return false;
                }
                case 0x1020022: {
                    this.c(279);
                    return false;
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int v) {
        int v1;
        boolean z = this.k;
        if(z) {
            if(v == 0) {
                v1 = 1;
            }
            else {
                switch(v) {
                    case 2: {
                        v1 = 2;
                        break;
                    }
                    case 3: {
                        v1 = 3;
                        break;
                    }
                    case 4: {
                        v1 = 4;
                        break;
                    }
                    case 5: {
                        v1 = 6;
                        break;
                    }
                    case 6: {
                        v1 = 7;
                        break;
                    }
                    case 7: {
                        v1 = 5;
                        break;
                    }
                    default: {
                        U4.x.u(v, "IME sends unsupported Editor Action: ", "RecordingIC");
                        v1 = 1;
                    }
                }
            }
            ((w)this.a.a).d.invoke(new i(v1));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final void performHandwritingGesture(HandwritingGesture handwritingGesture0, Executor executor0, IntConsumer intConsumer0) {
        long v21;
        a1.g g1;
        if(Build.VERSION.SDK_INT >= 34) {
            b b0 = new b(this, 24);
            f0 f00 = this.c;
            int v = 3;
            if(f00 != null) {
                a1.g g0 = f00.j;
                if(g0 != null) {
                    J0 j00 = f00.d();
                    a1.Q q0 = null;
                    if(j00 == null) {
                        g1 = null;
                    }
                    else {
                        P p0 = j00.a.a;
                        g1 = p0 == null ? null : p0.a;
                    }
                    if(g0.equals(g1)) {
                        Q q1 = this.d;
                        if(Sd.b.t(handwritingGesture0)) {
                            long v1 = y5.a.J(f00, M.B(((SelectGesture)handwritingGesture0).getSelectionArea()), (((SelectGesture)handwritingGesture0).getGranularity() == 1 ? 1 : 0));
                            if(T.b(v1)) {
                                v = x1.a.x(((SelectGesture)handwritingGesture0), b0);
                            }
                            else {
                                b0.invoke(new v(((int)(v1 >> 0x20)), ((int)(v1 & 0xFFFFFFFFL))));
                                if(q1 != null) {
                                    q1.h(true);
                                }
                                v = 1;
                            }
                        }
                        else if(m.y(handwritingGesture0)) {
                            int v2 = ((DeleteGesture)handwritingGesture0).getGranularity() == 1 ? 1 : 0;
                            long v3 = y5.a.J(f00, M.B(((DeleteGesture)handwritingGesture0).getDeletionArea()), v2);
                            if(T.b(v3)) {
                                v = x1.a.x(((DeleteGesture)handwritingGesture0), b0);
                            }
                            else {
                                x1.a.M(v3, g0, v2 == 1, b0);
                                v = 1;
                            }
                        }
                        else if(m.C(handwritingGesture0)) {
                            long v4 = y5.a.f(f00, M.B(((SelectRangeGesture)handwritingGesture0).getSelectionStartArea()), M.B(((SelectRangeGesture)handwritingGesture0).getSelectionEndArea()), (((SelectRangeGesture)handwritingGesture0).getGranularity() == 1 ? 1 : 0));
                            if(T.b(v4)) {
                                v = x1.a.x(((SelectRangeGesture)handwritingGesture0), b0);
                            }
                            else {
                                b0.invoke(new v(((int)(v4 >> 0x20)), ((int)(v4 & 0xFFFFFFFFL))));
                                if(q1 != null) {
                                    q1.h(true);
                                }
                                v = 1;
                            }
                        }
                        else if(m.D(handwritingGesture0)) {
                            int v5 = ((DeleteRangeGesture)handwritingGesture0).getGranularity() == 1 ? 1 : 0;
                            long v6 = y5.a.f(f00, M.B(((DeleteRangeGesture)handwritingGesture0).getDeletionStartArea()), M.B(((DeleteRangeGesture)handwritingGesture0).getDeletionEndArea()), v5);
                            if(T.b(v6)) {
                                v = x1.a.x(((DeleteRangeGesture)handwritingGesture0), b0);
                            }
                            else {
                                x1.a.M(v6, g0, v5 == 1, b0);
                                v = 1;
                            }
                        }
                        else {
                            b1 b10 = this.e;
                            if(!Sd.b.A(handwritingGesture0)) {
                                if(!Sd.b.w(handwritingGesture0)) {
                                    if(Sd.b.y(handwritingGesture0)) {
                                        J0 j03 = f00.d();
                                        if(j03 != null) {
                                            q0 = j03.a;
                                        }
                                        long v14 = y5.a.h(((RemoveSpaceGesture)handwritingGesture0).getStartPoint());
                                        long v15 = y5.a.h(((RemoveSpaceGesture)handwritingGesture0).getEndPoint());
                                        N0.v v16 = f00.c();
                                        if(q0 == null) {
                                            v21 = T.b;
                                        }
                                        else {
                                            y y0 = q0.b;
                                            if(v16 == null) {
                                                v21 = T.b;
                                            }
                                            else {
                                                long v17 = v16.A(v14);
                                                long v18 = v16.A(v15);
                                                int v19 = y5.a.H(y0, v17, b10);
                                                int v20 = y5.a.H(y0, v18, b10);
                                                if(v19 != -1) {
                                                    if(v20 != -1) {
                                                        v19 = Math.min(v19, v20);
                                                    }
                                                    v20 = v19;
                                                label_125:
                                                    float f = y0.f(v20);
                                                    float f1 = (y0.b(v20) + f) / 2.0f;
                                                    v21 = y0.h(new c(Math.min(Float.intBitsToFloat(((int)(v17 >> 0x20))), Float.intBitsToFloat(((int)(v18 >> 0x20)))), f1 - 0.1f, Math.max(Float.intBitsToFloat(((int)(v17 >> 0x20))), Float.intBitsToFloat(((int)(v18 >> 0x20)))), f1 + 0.1f), 0, a1.p.b);
                                                }
                                                else if(v20 == -1) {
                                                    v21 = T.b;
                                                }
                                                else {
                                                    goto label_125;
                                                }
                                            }
                                        }
                                        if(T.b(v21)) {
                                            v = x1.a.x(((RemoveSpaceGesture)handwritingGesture0), b0);
                                        }
                                        else {
                                            F f2 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            f2.a = -1;
                                            F f3 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            f3.a = -1;
                                            a1.g g2 = g0.b(T.e(v21), T.d(v21));
                                            n n0 = new n("\\s+");
                                            Ld.p p1 = new Ld.p(24, f2, f3);
                                            String s1 = n0.d(g2.b, p1);
                                            int v22 = f2.a;
                                            if(v22 == -1) {
                                                v = x1.a.x(((RemoveSpaceGesture)handwritingGesture0), b0);
                                            }
                                            else {
                                                int v23 = f3.a;
                                                if(v23 == -1) {
                                                    v = x1.a.x(((RemoveSpaceGesture)handwritingGesture0), b0);
                                                }
                                                else {
                                                    String s2 = s1.substring(v22, s1.length() - (T.c(v21) - f3.a));
                                                    q.f(s2, "substring(...)");
                                                    b0.invoke(new o(new g[]{new v(((int)(v21 >> 0x20)) + v22, ((int)(v21 >> 0x20)) + v23), new a(s2, 1)}));
                                                    v = 1;
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        v = 2;
                                    }
                                }
                                else if(b10 == null) {
                                    v = x1.a.x(((InsertGesture)handwritingGesture0), b0);
                                }
                                else {
                                    int v13 = y5.a.e(f00, y5.a.h(((InsertGesture)handwritingGesture0).getInsertionPoint()), b10);
                                    if(v13 == -1) {
                                        v = x1.a.x(((InsertGesture)handwritingGesture0), b0);
                                    }
                                    else {
                                        J0 j02 = f00.d();
                                        if(j02 != null && y5.a.g(j02.a, v13)) {
                                            v = x1.a.x(((InsertGesture)handwritingGesture0), b0);
                                        }
                                        else {
                                            String s = ((InsertGesture)handwritingGesture0).getTextToInsert();
                                            b0.invoke(new o(new g[]{new v(v13, v13), new a(s, 1)}));
                                            v = 1;
                                        }
                                    }
                                }
                            }
                            else if(b10 == null) {
                                v = x1.a.x(((JoinOrSplitGesture)handwritingGesture0), b0);
                            }
                            else {
                                int v7 = y5.a.e(f00, y5.a.h(((JoinOrSplitGesture)handwritingGesture0).getJoinOrSplitPoint()), b10);
                                if(v7 == -1) {
                                    v = x1.a.x(((JoinOrSplitGesture)handwritingGesture0), b0);
                                }
                                else {
                                    J0 j01 = f00.d();
                                    if(j01 != null && y5.a.g(j01.a, v7)) {
                                        v = x1.a.x(((JoinOrSplitGesture)handwritingGesture0), b0);
                                    }
                                    else {
                                        int v8;
                                        for(v8 = v7; v8 > 0; v8 -= Character.charCount(v9)) {
                                            int v9 = Character.codePointBefore(g0, v8);
                                            if(!y5.a.O(v9)) {
                                                break;
                                            }
                                        }
                                        while(v7 < g0.b.length()) {
                                            int v10 = Character.codePointAt(g0, v7);
                                            if(!y5.a.O(v10)) {
                                                break;
                                            }
                                            v7 += Character.charCount(v10);
                                        }
                                        long v11 = t.b(v8, v7);
                                        if(T.b(v11)) {
                                            int v12 = (int)(v11 >> 0x20);
                                            b0.invoke(new o(new g[]{new v(v12, v12), new a(" ", 1)}));
                                        }
                                        else {
                                            x1.a.M(v11, g0, false, b0);
                                        }
                                        v = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(intConsumer0 != null) {
                if(executor0 != null) {
                    executor0.execute(new d(intConsumer0, v, 4));
                    return;
                }
                intConsumer0.accept(v);
            }
        }
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String s, Bundle bundle0) {
        return this.k;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture0, CancellationSignal cancellationSignal0) {
        a1.g g1;
        if(Build.VERSION.SDK_INT >= 34) {
            f0 f00 = this.c;
            if(f00 != null) {
                a1.g g0 = f00.j;
                if(g0 != null) {
                    J0 j00 = f00.d();
                    if(j00 == null) {
                        g1 = null;
                    }
                    else {
                        P p0 = j00.a.a;
                        g1 = p0 == null ? null : p0.a;
                    }
                    if(g0.equals(g1)) {
                        Q q0 = this.d;
                        if(Sd.b.t(previewableHandwritingGesture0)) {
                            if(q0 == null) {
                                goto label_67;
                            }
                            long v = y5.a.J(f00, M.B(((SelectGesture)previewableHandwritingGesture0).getSelectionArea()), (((SelectGesture)previewableHandwritingGesture0).getGranularity() == 1 ? 1 : 0));
                            f0 f01 = q0.d;
                            if(f01 != null) {
                                f01.f(v);
                            }
                            f0 f02 = q0.d;
                            if(f02 != null) {
                                f02.e(T.b);
                            }
                            if(T.b(v)) {
                                goto label_67;
                            }
                            q0.s(false);
                            q0.q(U.T.a);
                            goto label_67;
                        }
                        if(m.y(previewableHandwritingGesture0)) {
                            if(q0 == null) {
                                goto label_67;
                            }
                            long v1 = y5.a.J(f00, M.B(((DeleteGesture)previewableHandwritingGesture0).getDeletionArea()), (((DeleteGesture)previewableHandwritingGesture0).getGranularity() == 1 ? 1 : 0));
                            f0 f03 = q0.d;
                            if(f03 != null) {
                                f03.e(v1);
                            }
                            f0 f04 = q0.d;
                            if(f04 != null) {
                                f04.f(T.b);
                            }
                            if(T.b(v1)) {
                                goto label_67;
                            }
                            q0.s(false);
                            q0.q(U.T.a);
                            goto label_67;
                        }
                        boolean z = false;
                        if(m.C(previewableHandwritingGesture0)) {
                            z = true;
                            if(q0 == null) {
                                goto label_67;
                            }
                            long v2 = y5.a.f(f00, M.B(((SelectRangeGesture)previewableHandwritingGesture0).getSelectionStartArea()), M.B(((SelectRangeGesture)previewableHandwritingGesture0).getSelectionEndArea()), (((SelectRangeGesture)previewableHandwritingGesture0).getGranularity() == 1 ? 1 : 0));
                            f0 f05 = q0.d;
                            if(f05 != null) {
                                f05.f(v2);
                            }
                            f0 f06 = q0.d;
                            if(f06 != null) {
                                f06.e(T.b);
                            }
                            if(T.b(v2)) {
                                goto label_67;
                            }
                            q0.s(false);
                            q0.q(U.T.a);
                        }
                        else if(m.D(previewableHandwritingGesture0)) {
                            z = true;
                            if(q0 != null) {
                                long v3 = y5.a.f(f00, M.B(((DeleteRangeGesture)previewableHandwritingGesture0).getDeletionStartArea()), M.B(((DeleteRangeGesture)previewableHandwritingGesture0).getDeletionEndArea()), (((DeleteRangeGesture)previewableHandwritingGesture0).getGranularity() == 1 ? 1 : 0));
                                f0 f07 = q0.d;
                                if(f07 != null) {
                                    f07.e(v3);
                                }
                                f0 f08 = q0.d;
                                if(f08 != null) {
                                    f08.f(T.b);
                                }
                                if(!T.b(v3)) {
                                    q0.s(false);
                                    q0.q(U.T.a);
                                }
                            }
                        }
                        if(z) {
                        label_67:
                            if(cancellationSignal0 != null) {
                                cancellationSignal0.setOnCancelListener(new W.n(q0, 0));
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int v) {
        boolean z4;
        boolean z2;
        boolean z1;
        boolean z = false;
        if(this.k) {
            int v1 = Build.VERSION.SDK_INT;
            if(v1 >= 33) {
                z1 = (v & 16) != 0;
                z2 = (v & 8) != 0;
                boolean z3 = (v & 4) != 0;
                if(v1 >= 34 && (v & 0x20) != 0) {
                    z = true;
                }
                if(z1 || z2 || z3 || z) {
                    z4 = z;
                    z = z3;
                }
                else {
                    z4 = v1 >= 34;
                    z = true;
                    z1 = true;
                    z2 = true;
                }
            }
            else {
                z4 = false;
                z1 = true;
                z2 = true;
            }
            s s0 = ((w)this.a.a).m;
            synchronized(s0.c) {
                s0.f = z1;
                s0.g = z2;
                s0.h = z;
                s0.i = z4;
                if((v & 1) != 0) {
                    s0.e = true;
                    if(s0.j != null) {
                        s0.a();
                    }
                }
                s0.d = (v & 2) != 0;
                return true;
            }
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent0) {
        if(this.k) {
            ((BaseInputConnection)((j)((w)this.a.a).k).getValue()).sendKeyEvent(keyEvent0);
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int v, int v1) {
        boolean z = this.k;
        if(z) {
            this.a(new f1.t(v, v1));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence0, int v) {
        boolean z = this.k;
        if(z) {
            this.a(new u(String.valueOf(charSequence0), v));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setSelection(int v, int v1) {
        if(this.k) {
            this.a(new v(v, v1));
            return true;
        }
        return false;
    }
}

