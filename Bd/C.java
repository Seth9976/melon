package bd;

import android.content.Context;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class c extends i implements n {
    public final b0 B;
    public final Context r;
    public final String w;

    public c(Context context0, String s, b0 b00, Continuation continuation0) {
        this.r = context0;
        this.w = s;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new c(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((c)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Glide.with(this.r).asDrawable().load(this.w).into(new b(this.B, 0));
        return H.a;
    }
}

