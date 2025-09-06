package com.kakaoent.leonplayer.delegate;

import Tf.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.kakaoent.leonplayer.core.model.data.json.Thumbnail;
import com.kakaoent.leonplayer.core.model.data.json.ThumbnailData;
import com.kakaoent.leonplayer.core.model.data.json.ThumbnailInfo;
import com.kakaoent.leonplayer.core.model.data.json.ThumbnailUrl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001A\u00020\u0006*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0013\u0010\f\u001A\u00020\u0006*\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0018\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u001AR\u001A\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER \u0010 \u001A\u000E\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001A\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/kakaoent/leonplayer/delegate/ThumbnailPreviewDelegateImpl;", "Lcom/kakaoent/leonplayer/delegate/ThumbnailPreviewDelegate;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lie/H;", "initProperty", "()V", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "setLiveThumbnailInfo", "(Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;)V", "setVodThumbnailInfo", "", "cachedIndex", "cacheThumbnails", "(I)V", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "thumbnailInfo", "setThumbnailInfo", "(Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;)V", "position", "Landroid/graphics/Bitmap;", "getThumbnail", "(I)Landroid/graphics/Bitmap;", "Landroid/content/Context;", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "", "", "requestThumbnailUrls", "Ljava/util/List;", "", "thumbnailMap", "Ljava/util/Map;", "getThumbnailData", "()Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailData;", "thumbnailData", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailPreviewDelegateImpl implements ThumbnailPreviewDelegate {
    @NotNull
    private final Context context;
    @NotNull
    private final List requestThumbnailUrls;
    @Nullable
    private ThumbnailInfo thumbnailInfo;
    @NotNull
    private final Map thumbnailMap;

    public ThumbnailPreviewDelegateImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.context = context0;
        this.requestThumbnailUrls = new ArrayList();
        this.thumbnailMap = new LinkedHashMap();
    }

    private final void cacheThumbnails(int v) {
        ThumbnailData thumbnailData0 = this.getThumbnailData();
        if(thumbnailData0 != null) {
            int v1 = ((Thumbnail)thumbnailData0.getThumbnails().get(0)).getHorizontalCount();
            int v2 = ((Thumbnail)thumbnailData0.getThumbnails().get(0)).getVerticalCount();
            int v3 = v / (v1 * v2);
            String s = (String)this.requestThumbnailUrls.get(v3);
            com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegateImpl.cacheThumbnails.1.1 thumbnailPreviewDelegateImpl$cacheThumbnails$1$10 = (com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegateImpl.cacheThumbnails.1.1)Glide.with(this.context).asBitmap().load(s).into(new CustomTarget() {
                @Override  // com.bumptech.glide.request.target.Target
                public void onLoadCleared(@Nullable Drawable drawable0) {
                }

                @Override  // com.bumptech.glide.request.target.CustomTarget
                public void onLoadFailed(@Nullable Drawable drawable0) {
                }

                public void onResourceReady(@NotNull Bitmap bitmap0, @Nullable Transition transition0) {
                    q.g(bitmap0, "resource");
                    int v = v2 * this * v1;
                    int v1 = bitmap0.getWidth() / v2;
                    int v2 = bitmap0.getHeight() / this;
                    for(int v3 = 0; v3 < this; ++v3) {
                        int v4 = 0;
                        while(v4 < v2) {
                            Bitmap bitmap1 = Bitmap.createBitmap(bitmap0, v1 * v4, v2 * v3, v1, v2);
                            q.f(bitmap1, "saveBitmap");
                            ThumbnailPreviewDelegateImpl.this.thumbnailMap.put(v, bitmap1);
                            ++v4;
                            ++v;
                        }
                    }
                }

                @Override  // com.bumptech.glide.request.target.Target
                public void onResourceReady(Object object0, Transition transition0) {
                    this.onResourceReady(((Bitmap)object0), transition0);
                }
            });
        }
    }

    @Override  // com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegate
    @Nullable
    public Bitmap getThumbnail(int v) {
        ThumbnailData thumbnailData0 = this.getThumbnailData();
        if(thumbnailData0 != null) {
            int v1 = v / 1000 / new BigDecimal(thumbnailData0.getInterval()).intValue();
            Bitmap bitmap0 = (Bitmap)this.thumbnailMap.get(v1);
            if(bitmap0 == null) {
                this.cacheThumbnails(v1);
                return null;
            }
            return bitmap0;
        }
        return null;
    }

    private final ThumbnailData getThumbnailData() {
        return this.thumbnailInfo == null ? null : this.thumbnailInfo.getData();
    }

    private final void initProperty() {
        this.thumbnailInfo = null;
        for(Object object0: this.thumbnailMap.values()) {
            ((Bitmap)object0).recycle();
        }
        this.thumbnailMap.clear();
        this.requestThumbnailUrls.clear();
    }

    private final void setLiveThumbnailInfo(ThumbnailData thumbnailData0) {
    }

    @Override  // com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegate
    public void setThumbnailInfo(@NotNull ThumbnailInfo thumbnailInfo0) {
        q.g(thumbnailInfo0, "thumbnailInfo");
        this.initProperty();
        this.thumbnailInfo = thumbnailInfo0;
        ThumbnailData thumbnailData0 = this.getThumbnailData();
        if(thumbnailData0 == null || thumbnailData0.getThumbnailCount() == null) {
            return;
        }
        this.setVodThumbnailInfo(thumbnailData0);
    }

    private final void setVodThumbnailInfo(ThumbnailData thumbnailData0) {
        int v1 = ((Thumbnail)thumbnailData0.getThumbnails().get(0)).getHorizontalCount();
        int v2 = ((Thumbnail)thumbnailData0.getThumbnails().get(0)).getVerticalCount();
        Integer integer0 = thumbnailData0.getThumbnailCount();
        q.d(integer0);
        int v3 = ((int)integer0) / (v1 * v2);
        String s = ((ThumbnailUrl)((Thumbnail)thumbnailData0.getThumbnails().get(0)).getUrls().get(0)).getUrl();
        if(v3 >= 0) {
            for(int v = 0; true; ++v) {
                String s1 = v.p0(s, "{index}", String.valueOf(v * v1 * v2));
                this.requestThumbnailUrls.add(s1);
                if(v == v3) {
                    break;
                }
            }
        }
    }
}

