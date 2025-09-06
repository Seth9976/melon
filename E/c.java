package e;

import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;
import f.b;
import java.util.LinkedHashMap;

public final class c implements B {
    public final h a;
    public final String b;
    public final a c;
    public final b d;

    public c(h h0, String s, a a0, b b0) {
        this.a = h0;
        this.b = s;
        this.c = a0;
        this.d = b0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        h h0 = this.a;
        LinkedHashMap linkedHashMap0 = h0.e;
        String s = this.b;
        if(r.ON_START == r0) {
            Bundle bundle0 = h0.g;
            LinkedHashMap linkedHashMap1 = h0.f;
            b b0 = this.d;
            a a0 = this.c;
            linkedHashMap0.put(s, new d(b0, a0));
            if(linkedHashMap1.containsKey(s)) {
                Object object0 = linkedHashMap1.get(s);
                linkedHashMap1.remove(s);
                a0.onActivityResult(object0);
            }
            ActivityResult activityResult0 = (ActivityResult)com.google.firebase.b.F(bundle0, s, ActivityResult.class);
            if(activityResult0 != null) {
                bundle0.remove(s);
                a0.onActivityResult(b0.parseResult(activityResult0.a, activityResult0.b));
            }
        }
        else {
            if(r.ON_STOP == r0) {
                linkedHashMap0.remove(s);
                return;
            }
            if(r.ON_DESTROY == r0) {
                h0.f(s);
            }
        }
    }
}

