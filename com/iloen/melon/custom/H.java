package com.iloen.melon.custom;

import android.content.Context;
import android.graphics.Bitmap;
import com.iloen.melon.utils.image.ImageUtils;
import kotlin.coroutines.Continuation;
import x8.f;

public final class h extends f {
    public final Context a;
    public final BlurImageView b;

    public h(BlurImageView blurImageView0, Context context0) {
        this.b = blurImageView0;
        this.a = context0;
        super();
    }

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        return ((Bitmap)object0) == null || ((Bitmap)object0).isRecycled() ? null : ImageUtils.createBlurredBitmap(this.a, ((int)this.b.f), ((Bitmap)object0));
    }

    @Override  // x8.f
    public final void postTask(Object object0) {
        if(((Bitmap)object0) != null) {
            BlurImageView.c(this.b, ((Bitmap)object0));
        }
    }
}

