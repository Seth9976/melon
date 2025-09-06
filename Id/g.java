package id;

import H0.e;
import android.content.Intent;
import android.net.Uri;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class g implements a {
    public final int a;
    public final k b;

    public g(k k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                e.w(this.b);
                return H.a;
            }
            case 1: {
                this.b.o("startSearchMusic click BUTTON_POSITIVE");
                return H.a;
            }
            case 2: {
                this.b.q(false);
                return H.a;
            }
            default: {
                k k0 = this.b;
                if(k0.f != null) {
                    Intent intent0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.parse("package:com.iloen.melon"));
                    q.f(intent0, "setData(...)");
                    k0.startActivity(intent0);
                    return H.a;
                }
                q.m("systemSettingUtils");
                throw null;
            }
        }
    }
}

