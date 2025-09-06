package com.iloen.melon.slook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.ClassUtils;

class CocktailPlayerFeedsProvider.1 extends CustomTarget {
    public final Uri a;
    public final Context b;
    public final CocktailPlayerFeedsProvider c;

    public CocktailPlayerFeedsProvider.1(CocktailPlayerFeedsProvider cocktailPlayerFeedsProvider0, Uri uri0, Context context0) {
        this.c = cocktailPlayerFeedsProvider0;
        this.a = uri0;
        this.b = context0;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable0) {
    }

    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
        if(bitmap0 != null) {
            CocktailPlayerFeedsProvider cocktailPlayerFeedsProvider0 = this.c;
            if(ClassUtils.equals(this.a, cocktailPlayerFeedsProvider0.d)) {
                CocktailPlayerFeedsProvider.e = bitmap0;
                cocktailPlayerFeedsProvider0.performUpdate(this.b);
            }
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object object0, Transition transition0) {
        this.onResourceReady(((Bitmap)object0), transition0);
    }
}

