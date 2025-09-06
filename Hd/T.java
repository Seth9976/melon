package hd;

import android.content.Context;
import androidx.compose.runtime.b0;
import bd.b;
import com.bumptech.glide.Glide;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class t extends i implements n {
    public final b0 B;
    public final Context r;
    public final String w;

    public t(Context context0, String s, b0 b00, Continuation continuation0) {
        this.r = context0;
        this.w = s;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Glide.with(this.r).asBitmap().load(this.w).into(new b(this.B, 5));
        return H.a;
    }
}

