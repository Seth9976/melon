package k;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface;
import android.view.KeyEvent.DispatcherState;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.g;
import androidx.appcompat.view.menu.MenuBuilder;

public final class l implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, v {
    public C a;
    public g b;
    public h c;

    @Override  // k.v
    public final void b(MenuBuilder menuBuilder0, boolean z) {
        if(z || menuBuilder0 == this.a) {
            g g0 = this.b;
            if(g0 != null) {
                g0.dismiss();
            }
        }
    }

    @Override  // k.v
    public final boolean m(MenuBuilder menuBuilder0) {
        return false;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        C c0 = this.a;
        h h0 = this.c;
        if(h0.f == null) {
            h0.f = new k.g(h0);
        }
        c0.q(h0.f.b(v), null, 0);
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface0) {
        this.c.b(this.a, true);
    }

    @Override  // android.content.DialogInterface$OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface0, int v, KeyEvent keyEvent0) {
        C c0 = this.a;
        if(v == 4 || v == 82) {
            if(keyEvent0.getAction() == 0 && keyEvent0.getRepeatCount() == 0) {
                Window window0 = this.b.getWindow();
                if(window0 != null) {
                    View view0 = window0.getDecorView();
                    if(view0 != null) {
                        KeyEvent.DispatcherState keyEvent$DispatcherState0 = view0.getKeyDispatcherState();
                        if(keyEvent$DispatcherState0 != null) {
                            keyEvent$DispatcherState0.startTracking(keyEvent0, this);
                            return true;
                        }
                    }
                }
            }
            else if(keyEvent0.getAction() == 1 && !keyEvent0.isCanceled()) {
                Window window1 = this.b.getWindow();
                if(window1 != null) {
                    View view1 = window1.getDecorView();
                    if(view1 != null) {
                        KeyEvent.DispatcherState keyEvent$DispatcherState1 = view1.getKeyDispatcherState();
                        if(keyEvent$DispatcherState1 != null && keyEvent$DispatcherState1.isTracking(keyEvent0)) {
                            c0.c(true);
                            dialogInterface0.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return c0.performShortcut(v, keyEvent0, 0);
    }
}

