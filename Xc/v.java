package xc;

import Jc.b;
import Jc.f;
import Jc.h;
import Jc.i;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import ie.H;
import we.a;

public final class v implements a {
    public final int a;
    public final i b;
    public final z c;

    public v(i i0, z z0) {
        this.a = 1;
        super();
        this.b = i0;
        this.c = z0;
    }

    public v(z z0, i i0) {
        this.a = 0;
        super();
        this.c = z0;
        this.b = i0;
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            if("405".equals(((f)this.b).a)) {
                Intent intent0 = new Intent("android.intent.action.VIEW", r8.f.l);
                FragmentActivity fragmentActivity0 = this.c.getActivity();
                if(fragmentActivity0 != null) {
                    fragmentActivity0.startActivity(intent0);
                }
            }
            return H.a;
        }
        b b0 = new b(((h)this.b).a, ((h)this.b).b, ((h)this.b).c);
        this.c.sendUserEvent(b0);
        return H.a;
    }
}

