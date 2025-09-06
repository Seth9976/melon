package cd;

import android.content.Context;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class z0 extends i implements n {
    public final b0 B;
    public final b0 D;
    public final Context r;
    public final Content w;

    public z0(Context context0, Content flexibleRes$RESPONSE$Flexible$Content0, b0 b00, b0 b01, Continuation continuation0) {
        this.r = context0;
        this.w = flexibleRes$RESPONSE$Flexible$Content0;
        this.B = b00;
        this.D = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z0(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((z0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Context context0 = this.r;
        if(context0 != null) {
            Glide.with(context0).asBitmap().load(this.w.getImgUrl()).into(new y0(context0, this.B, this.D));
        }
        return H.a;
    }
}

