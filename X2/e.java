package x2;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import w4.f;
import y8.s;

public final class e implements KeyListener {
    public final KeyListener a;
    public final f b;

    public e(KeyListener keyListener0) {
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        super();
        this.a = keyListener0;
        this.b = f0;
    }

    @Override  // android.text.method.KeyListener
    public final void clearMetaKeyState(View view0, Editable editable0, int v) {
        this.a.clearMetaKeyState(view0, editable0, v);
    }

    @Override  // android.text.method.KeyListener
    public final int getInputType() {
        return this.a.getInputType();
    }

    @Override  // android.text.method.KeyListener
    public final boolean onKeyDown(View view0, Editable editable0, int v, KeyEvent keyEvent0) {
        boolean z;
        this.b.getClass();
        switch(v) {
            case 67: {
                z = s.f(editable0, keyEvent0, false);
                break;
            }
            case 0x70: {
                z = s.f(editable0, keyEvent0, true);
                break;
            }
            default: {
                z = false;
            }
        }
        if(z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable0);
            return true;
        }
        return this.a.onKeyDown(view0, editable0, v, keyEvent0);
    }

    @Override  // android.text.method.KeyListener
    public final boolean onKeyOther(View view0, Editable editable0, KeyEvent keyEvent0) {
        return this.a.onKeyOther(view0, editable0, keyEvent0);
    }

    @Override  // android.text.method.KeyListener
    public final boolean onKeyUp(View view0, Editable editable0, int v, KeyEvent keyEvent0) {
        return this.a.onKeyUp(view0, editable0, v, keyEvent0);
    }
}

