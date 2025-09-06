package bd;

import android.content.Context;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final b0 B;
    public final Content r;
    public final Context w;

    public j(Context context0, b0 b00, Content flexibleRes$RESPONSE$Flexible$Content0, Continuation continuation0) {
        this.r = flexibleRes$RESPONSE$Flexible$Content0;
        this.w = context0;
        this.B = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.w, this.B, this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        String s = this.r.getImgUrl();
        if(s != null) {
            Glide.with(this.w).asDrawable().load(s).into(new b(this.B, 1));
        }
        return H.a;
    }
}

