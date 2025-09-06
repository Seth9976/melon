package bd;

import F8.u;
import android.content.Context;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;

public final class n extends i implements we.n {
    public final boolean B;
    public final b0 D;
    public final String r;
    public final Context w;

    public n(String s, Context context0, boolean z, b0 b00, Continuation continuation0) {
        this.r = s;
        this.w = context0;
        this.B = z;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        String s = this.r;
        if(s != null) {
            ((RequestBuilder)((RequestBuilder)Glide.with(this.w).asDrawable().load(s).diskCacheStrategy((this.B ? DiskCacheStrategy.DATA : DiskCacheStrategy.AUTOMATIC))).skipMemoryCache(this.B)).into(new u(3, this.w, this.D));
        }
        return H.a;
    }
}

