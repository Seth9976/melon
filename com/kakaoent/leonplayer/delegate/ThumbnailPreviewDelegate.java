package com.kakaoent.leonplayer.delegate;

import android.content.Context;
import android.graphics.Bitmap;
import com.kakaoent.leonplayer.core.model.data.json.ThumbnailInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\b\u001A\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/kakaoent/leonplayer/delegate/ThumbnailPreviewDelegate;", "", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "thumbnailInfo", "Lie/H;", "setThumbnailInfo", "(Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;)V", "", "position", "Landroid/graphics/Bitmap;", "getThumbnail", "(I)Landroid/graphics/Bitmap;", "Companion", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ThumbnailPreviewDelegate {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/delegate/ThumbnailPreviewDelegate$Companion;", "", "()V", "create", "Lcom/kakaoent/leonplayer/delegate/ThumbnailPreviewDelegate;", "context", "Landroid/content/Context;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final ThumbnailPreviewDelegate create(@NotNull Context context0) {
            q.g(context0, "context");
            return new ThumbnailPreviewDelegateImpl(context0);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        ThumbnailPreviewDelegate.Companion = Companion.$$INSTANCE;
    }

    @Nullable
    Bitmap getThumbnail(int arg1);

    void setThumbnailInfo(@NotNull ThumbnailInfo arg1);
}

