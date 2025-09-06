package Cc;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.b0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.iloen.melon.utils.MelonSettingInfo;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.k;
import we.n;

public final class w1 extends i implements n {
    public final k B;
    public final int D;
    public final boolean E;
    public final b0 G;
    public final b0 I;
    public final a M;
    public final Object r;
    public final Context w;

    public w1(Object object0, Context context0, k k0, int v, boolean z, b0 b00, b0 b01, a a0, Continuation continuation0) {
        this.r = object0;
        this.w = context0;
        this.B = k0;
        this.D = v;
        this.E = z;
        this.G = b00;
        this.I = b01;
        this.M = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w1(this.r, this.w, this.B, this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((w1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Object object1 = this.r;
        H h0 = H.a;
        b0 b00 = this.G;
        Context context0 = this.w;
        if(object1 instanceof Integer) {
            Drawable drawable0 = context0.getResources().getDrawable(((Number)object1).intValue(), context0.getTheme());
            if(drawable0 != null) {
                k k0 = this.B;
                if(k0 != null) {
                    k0.invoke(drawable0);
                }
                if(MelonSettingInfo.isLowMemoryMode()) {
                    if(drawable0 instanceof WebpDrawable) {
                        drawable0 = new BitmapDrawable(context0.getResources(), ((WebpDrawable)drawable0).getFirstFrame());
                    }
                    b00.setValue(drawable0);
                    return h0;
                }
                if(drawable0 instanceof WebpDrawable) {
                    ((WebpDrawable)drawable0).setLoopCount(this.D);
                    ((WebpDrawable)drawable0).start();
                }
                b00.setValue(drawable0);
                return h0;
            }
        }
        else if(this.E && (object1 == null || object1.equals(""))) {
            b00.setValue(null);
        }
        ((RequestBuilder)((RequestBuilder)Glide.with(context0).asDrawable().load(object1).skipMemoryCache(false)).override(1000, 1000)).listener(new v1(this.B, context0, this.D, this.I, b00, this.M)).submit();
        return h0;
    }
}

