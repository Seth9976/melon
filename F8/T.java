package F8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class t extends i implements n {
    public final Context B;
    public final ImageView r;
    public final Drawable w;

    public t(Context context0, Drawable drawable0, ImageView imageView0, Continuation continuation0) {
        this.r = imageView0;
        this.w = drawable0;
        this.B = context0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.B, this.w, this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        int v = ScreenUtils.dipToPixel(this.B, 32.0f);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(((WebpDrawable)this.w).getIntrinsicWidth() * v / ((WebpDrawable)this.w).getIntrinsicHeight(), v);
        linearLayout$LayoutParams0.setMargins(ScreenUtils.dipToPixel(this.B, 14.0f), 0, 0, 0);
        this.r.setLayoutParams(linearLayout$LayoutParams0);
        this.r.setImageDrawable(this.w);
        ((WebpDrawable)this.w).start();
        return H.a;
    }
}

