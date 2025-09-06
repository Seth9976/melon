package com.iloen.melon.slook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.RemoteViews;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.ClassUtils;

class CocktailPlayerPanelProvider.4 extends CustomTarget {
    public final Uri a;
    public final RemoteViews b;
    public final Context c;
    public final CocktailPlayerPanelProvider d;

    public CocktailPlayerPanelProvider.4(CocktailPlayerPanelProvider cocktailPlayerPanelProvider0, Uri uri0, RemoteViews remoteViews0, Context context0) {
        this.d = cocktailPlayerPanelProvider0;
        this.a = uri0;
        this.b = remoteViews0;
        this.c = context0;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.CustomTarget
    public void onLoadFailed(Drawable drawable0) {
        this.d.performUpdate(this.c, false);
    }

    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
        if(ClassUtils.equals(this.a, CocktailPlayerPanelProvider.g)) {
            CocktailPlayerPanelProvider.h = bitmap0;
            this.b.setViewVisibility(0x7F0A0B82, 0);  // id:thumbnail
            this.b.setImageViewBitmap(0x7F0A0B82, CocktailPlayerPanelProvider.h);  // id:thumbnail
            this.d.performUpdate(this.c, false);
        }
    }

    @Override  // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object object0, Transition transition0) {
        this.onResourceReady(((Bitmap)object0), transition0);
    }
}

