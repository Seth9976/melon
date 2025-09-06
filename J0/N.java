package J0;

import android.view.MotionEvent;
import java.util.List;
import x9.c;

public final class n {
    public final Object a;
    public final h b;
    public final int c;
    public int d;

    public n(List list0, h h0) {
        this.a = list0;
        this.b = h0;
        MotionEvent motionEvent0 = null;
        MotionEvent motionEvent1 = h0 == null ? null : ((MotionEvent)((c)h0.d).c);
        int v = 0;
        this.c = motionEvent1 == null ? 0 : motionEvent1.getButtonState();
        MotionEvent motionEvent2 = h0 == null ? null : ((MotionEvent)((c)h0.d).c);
        if(motionEvent2 != null) {
            motionEvent2.getMetaState();
        }
        if(h0 != null) {
            motionEvent0 = (MotionEvent)((c)h0.d).c;
        }
        if(motionEvent0 == null) {
            int v1 = list0.size();
            while(v < v1) {
                v v2 = (v)list0.get(v);
                if(!u.c(v2)) {
                    if(!u.a(v2)) {
                        ++v;
                        continue;
                    }
                    v = 1;
                    this.d = v;
                    return;
                }
                v = 2;
                this.d = v;
                return;
            }
            v = 3;
        }
        else {
            switch(motionEvent0.getActionMasked()) {
                case 0: 
                case 5: {
                    v = 1;
                    break;
                }
                case 1: 
                case 6: {
                    v = 2;
                    break;
                }
                case 2: 
                case 7: {
                    v = 3;
                    this.d = v;
                    return;
                }
                case 8: {
                    v = 6;
                    break;
                }
                case 9: {
                    v = 4;
                    break;
                }
                case 10: {
                    v = 5;
                }
            }
        }
        this.d = v;
    }
}

