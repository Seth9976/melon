package X4;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.J;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.O;
import androidx.recyclerview.widget.q0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;

public final class i implements Runnable {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;

    public i(int v, int v1, Object object0, Object object1, boolean z) {
        this.a = v1;
        this.d = object0;
        this.c = object1;
        this.b = v;
        super();
    }

    public i(Object object0, Object object1, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((j)this.c).a(this.b, ((Intent)this.d));
                return;
            }
            case 1: {
                ((TextView)this.c).setTypeface(((Typeface)this.d), this.b);
                return;
            }
            case 2: {
                O0 o00 = ((J)this.c).e;
                O o0 = (O)this.d;
                if(o0.r != null && o0.r.isAttachedToWindow() && !((J)this.c).k && o00.getAbsoluteAdapterPosition() != -1) {
                    q0 q00 = o0.r.getItemAnimator();
                    if(q00 == null || !q00.f()) {
                        ArrayList arrayList0 = o0.p;
                        int v = arrayList0.size();
                        for(int v1 = 0; v1 < v; ++v1) {
                            if(!((J)arrayList0.get(v1)).l) {
                                o0.r.post(this);
                                return;
                            }
                        }
                        o0.m.onSwiped(o00, this.b);
                        return;
                    }
                    o0.r.post(this);
                    return;
                }
                return;
            }
            default: {
                ((BottomSheetBehavior)this.d).P(((View)this.c), this.b, false);
            }
        }
    }
}

