package w8;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class d0 extends i implements n {
    public final b0 B;
    public final b0 D;
    public final Context r;
    public final b0 w;

    public d0(Context context0, b0 b00, b0 b01, b0 b02, Continuation continuation0) {
        this.r = context0;
        this.w = b00;
        this.B = b01;
        this.D = b02;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d0(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((d0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        ((RequestBuilder)Glide.with(this.r).asBitmap().load(((Uri)this.w.getValue())).skipMemoryCache(false)).listener(new c0(this.r, this.B, this.D)).submit();
        return H.a;
    }
}

