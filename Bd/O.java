package bd;

import android.content.Context;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v4x.common.HeaderBase;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class o extends i implements n {
    public final b0 B;
    public final Context r;
    public final HeaderBase w;

    public o(Context context0, HeaderBase headerBase0, b0 b00, Continuation continuation0) {
        this.r = context0;
        this.w = headerBase0;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Glide.with(this.r).asDrawable().load(this.w.artistImg).into(new b(this.B, 3));
        return H.a;
    }
}

