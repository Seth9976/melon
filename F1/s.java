package f1;

import a1.T;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import com.iloen.melon.custom.S0;
import e1.G;
import ie.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import je.p;
import kotlin.jvm.internal.q;
import we.k;

public final class s implements InputConnection {
    public final S0 a;
    public final boolean b;
    public int c;
    public x d;
    public int e;
    public boolean f;
    public final ArrayList g;
    public boolean h;

    public s(x x0, S0 s00, boolean z) {
        this.a = s00;
        this.b = z;
        this.d = x0;
        this.g = new ArrayList();
        this.h = true;
    }

    public final void a(g g0) {
        try {
            ++this.c;
            this.g.add(g0);
        }
        finally {
            this.b();
        }
    }

    public final boolean b() {
        int v = this.c - 1;
        this.c = v;
        if(v == 0) {
            ArrayList arrayList0 = this.g;
            if(!arrayList0.isEmpty()) {
                ArrayList arrayList1 = p.Q0(arrayList0);
                ((k)((A)this.a.b).e).invoke(arrayList1);
                arrayList0.clear();
            }
        }
        return this.c > 0;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean beginBatchEdit() {
        if(this.h) {
            ++this.c;
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
        this.g.clear();
        this.c = 0;
        this.h = false;
        ArrayList arrayList0 = ((A)this.a.b).i;
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
        return this.h ? this.b : false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence0, int v) {
        boolean z = this.h;
        if(z) {
            this.a(new a(String.valueOf(charSequence0), v));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int v, int v1) {
        if(this.h) {
            this.a(new e(v, v1));
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int v, int v1) {
        if(this.h) {
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
        if(this.h) {
            this.a(new h());  // 初始化器: Ljava/lang/Object;-><init>()V
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int v) {
        return TextUtils.getCapsMode(this.d.a.b, T.e(this.d.b), v);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest0, int v) {
        boolean z = true;
        int v1 = 0;
        if((v & 1) == 0) {
            z = false;
        }
        this.f = z;
        if(z) {
            if(extractedTextRequest0 != null) {
                v1 = extractedTextRequest0.token;
            }
            this.e = v1;
        }
        return G.G(this.d);
    }

    @Override  // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return null;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int v) {
        return T.b(this.d.b) ? null : e2.a.H(this.d).b;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int v, int v1) {
        return e2.a.I(this.d, v).b;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int v, int v1) {
        return e2.a.J(this.d, v).b;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int v) {
        if(this.h) {
            switch(v) {
                case 0x102001F: {
                    this.a(new v(0, this.d.a.b.length()));
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
        boolean z = this.h;
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
            ((A)this.a.b).f.invoke(new i(v1));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String s, Bundle bundle0) {
        return this.h;
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
        if(this.h) {
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
            c c0 = ((A)this.a.b).l;
            synchronized(c0.c) {
                c0.f = z1;
                c0.g = z2;
                c0.h = z;
                c0.i = z4;
                if((v & 1) != 0) {
                    c0.e = true;
                    if(c0.j != null) {
                        c0.a();
                    }
                }
                c0.d = (v & 2) != 0;
                return true;
            }
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent keyEvent0) {
        if(this.h) {
            ((BaseInputConnection)((j)((A)this.a.b).j).getValue()).sendKeyEvent(keyEvent0);
            return true;
        }
        return false;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int v, int v1) {
        boolean z = this.h;
        if(z) {
            this.a(new t(v, v1));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence0, int v) {
        boolean z = this.h;
        if(z) {
            this.a(new u(String.valueOf(charSequence0), v));
        }
        return z;
    }

    @Override  // android.view.inputmethod.InputConnection
    public final boolean setSelection(int v, int v1) {
        if(this.h) {
            this.a(new v(v, v1));
            return true;
        }
        return false;
    }
}

