package com.iloen.melon.player.video;

import Q4.a;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m4.d;
import m4.e;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J)\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0010\u0010\u0005\u001A\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000B\u001A\u00020\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"com/iloen/melon/player/video/VideoChatFragment$chatBannerSongData$3$1", "Lcom/bumptech/glide/request/target/BitmapImageViewTarget;", "Landroid/graphics/Bitmap;", "resource", "Lcom/bumptech/glide/request/transition/Transition;", "transition", "Lie/H;", "onResourceReady", "(Landroid/graphics/Bitmap;Lcom/bumptech/glide/request/transition/Transition;)V", "Landroid/graphics/drawable/Drawable;", "errorDrawable", "onLoadFailed", "(Landroid/graphics/drawable/Drawable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatFragment.chatBannerSongData.3.1 extends BitmapImageViewTarget {
    public final ImageView a;
    public final VideoChatFragment b;
    public final a c;
    public static final int d;

    public VideoChatFragment.chatBannerSongData.3.1(ImageView imageView0, VideoChatFragment videoChatFragment0, a a0) {
        this.a = imageView0;
        this.b = videoChatFragment0;
        this.c = a0;
        super(imageView0);
    }

    @Override  // com.bumptech.glide.request.target.ImageViewTarget
    public void onLoadFailed(Drawable drawable0) {
        int v1;
        super.onLoadFailed(drawable0);
        VideoChatFragment videoChatFragment0 = this.b;
        if(VideoChatFragment.access$isFullMode$p(videoChatFragment0)) {
            v1 = 0x7F080795;  // drawable:noimage_logo_xmini_w
        }
        else {
            int v = ColorUtils.getColor(videoChatFragment0.getContext(), 0x7F06015D);  // color:gray500s_support_high_contrast
            View view0 = this.c.getRoot();
            CardView cardView0 = view0 instanceof CardView ? ((CardView)view0) : null;
            if(cardView0 != null) {
                cardView0.setCardBackgroundColor(v);
            }
            v1 = 0x7F080796;  // drawable:noimage_logo_xxmini
        }
        this.a.setImageResource(v1);
    }

    public void onResourceReady(Bitmap bitmap0, Transition transition0) {
        q.g(bitmap0, "resource");
        super.onResourceReady(bitmap0, transition0);
        VideoChatFragment videoChatFragment0 = this.b;
        if(!VideoChatFragment.access$isFullMode$p(videoChatFragment0)) {
            e e0 = new e(bitmap0);
            e0.a = 24;
            new d(e0, new r(videoChatFragment0, this.c)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{((Bitmap)e0.d)});
        }
    }

    @Override  // com.bumptech.glide.request.target.ImageViewTarget
    public void onResourceReady(Object object0, Transition transition0) {
        this.onResourceReady(((Bitmap)object0), transition0);
    }
}

