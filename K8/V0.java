package k8;

import android.widget.TextView;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.MusicBrowserActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class v0 extends i implements n {
    public final TextView B;
    public int r;
    public final MusicBrowserActivity w;

    public v0(MusicBrowserActivity musicBrowserActivity0, TextView textView0, Continuation continuation0) {
        this.w = musicBrowserActivity0;
        this.B = textView0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                u0 u00 = new u0(this.w, this.B, null);
                this.r = 1;
                return f0.j(this.w, s.d, u00, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

