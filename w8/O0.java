package w8;

import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import hd.V;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class o0 extends i implements n {
    public final b0 B;
    public final b0 D;
    public final Context r;
    public final Uri w;

    public o0(Context context0, Uri uri0, b0 b00, b0 b01, Continuation continuation0) {
        this.r = context0;
        this.w = uri0;
        this.B = b00;
        this.D = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o0(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((o0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        ((RequestBuilder)Glide.with(this.r).asBitmap().load(this.w).skipMemoryCache(false)).listener(new V(this.w, this.B, this.D, 1)).submit();
        return H.a;
    }
}

