package cd;

import android.content.Context;
import androidx.compose.runtime.b0;
import bd.b;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class x0 extends i implements n {
    public final b0 B;
    public final Context r;
    public final Content w;

    public x0(Context context0, b0 b00, Content flexibleRes$RESPONSE$Flexible$Content0, Continuation continuation0) {
        this.r = context0;
        this.w = flexibleRes$RESPONSE$Flexible$Content0;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x0(this.r, this.B, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((x0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Context context0 = this.r;
        if(context0 != null) {
            Glide.with(context0).asBitmap().load(this.w.getImgUrl()).into(new b(this.B, 4));
        }
        return H.a;
    }
}

