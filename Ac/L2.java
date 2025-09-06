package Ac;

import J8.t;
import J8.u;
import J8.v;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.widget.LinearLayout;
import com.iloen.melon.MusicBrowserActivity;
import com.melon.ui.c0;
import kotlin.jvm.internal.q;
import we.k;

public final class l2 implements DialogInterface.OnDismissListener {
    public final int a;
    public final Object b;

    public l2(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface0) {
        switch(this.a) {
            case 0: {
                t t0 = (t)((v2)this.b).getBinding();
                if(t0 != null) {
                    u u0 = t0.b;
                    if(u0 != null) {
                        LinearLayout linearLayout0 = (LinearLayout)u0.c;
                        if(linearLayout0 != null) {
                            linearLayout0.setVisibility(0);
                        }
                    }
                }
                return;
            }
            case 1: {
                v v0 = (v)((j3)this.b).getBinding();
                if(v0 != null) {
                    u u1 = v0.b;
                    if(u1 != null) {
                        LinearLayout linearLayout1 = (LinearLayout)u1.c;
                        if(linearLayout1 != null) {
                            linearLayout1.setVisibility(0);
                        }
                    }
                }
                return;
            }
            case 2: {
                c0 c00 = (c0)this.b;
                if(q.b(c00.getRetainedDialog(), dialogInterface0)) {
                    c00.setRetainDialog(null);
                }
                return;
            }
            case 3: {
                MusicBrowserActivity.showSplashPopup$lambda$6$lambda$5(((MusicBrowserActivity)this.b), dialogInterface0);
                return;
            }
            default: {
                k k0 = (k)this.b;
                if(k0 != null) {
                    q.d(dialogInterface0);
                    k0.invoke(dialogInterface0);
                }
            }
        }
    }
}

