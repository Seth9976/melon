package l2;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import d5.n;
import ie.H;
import java.io.IOException;
import java.util.Set;
import kotlin.coroutines.Continuation;
import ne.a;
import o2.b;
import o2.d;
import oe.i;
import we.k;

public final class g extends i implements k {
    public int r;
    public final d w;

    public g(d d0, Continuation continuation0) {
        this.w = d0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new g(this.w, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((g)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                this.r = 1;
                d d0 = this.w;
                SharedPreferences.Editor sharedPreferences$Editor0 = ((SharedPreferences)d0.e.getValue()).edit();
                Set set0 = d0.f;
                if(set0 == null) {
                    sharedPreferences$Editor0.clear();
                }
                else {
                    for(Object object1: set0) {
                        sharedPreferences$Editor0.remove(((String)object1));
                    }
                }
                if(!sharedPreferences$Editor0.commit()) {
                    throw new IOException("Unable to delete migrated keys from SharedPreferences.");
                }
                if(((SharedPreferences)d0.e.getValue()).getAll().isEmpty()) {
                    Context context0 = d0.c;
                    if(context0 != null) {
                        String s = d0.d;
                        if(s != null) {
                            b.a(context0, s);
                        }
                    }
                }
                if(set0 != null) {
                    set0.clear();
                }
                return h0 == a0 ? a0 : h0;
            }
            case 1: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

