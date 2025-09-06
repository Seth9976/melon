package com.iloen.melon.utils.template;

import Tf.o;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001B\u0010\t\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateImageCacheManager;", "", "", "key", "Landroid/graphics/Bitmap;", "bitmap", "Lie/H;", "addBitmapToMemoryCache", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "getBitmapFromMemCache", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "clear", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateImageCacheManager {
    public static final int $stable;
    @NotNull
    public static final TemplateImageCacheManager INSTANCE;
    public static final com.iloen.melon.utils.template.TemplateImageCacheManager.1 a;

    static {
        TemplateImageCacheManager.INSTANCE = new TemplateImageCacheManager();  // 初始化器: Ljava/lang/Object;-><init>()V
        TemplateImageCacheManager.a = new LruCache(((int)(((float)(Runtime.getRuntime().maxMemory() / 0x400L)) * 0.03f))) {  // 初始化器: Landroid/util/LruCache;-><init>(I)V
            @Override  // android.util.LruCache
            public int sizeOf(Object object0, Object object1) {
                return this.sizeOf(((String)object0), ((Bitmap)object1));
            }

            public int sizeOf(String s, Bitmap bitmap0) {
                q.g(s, "key");
                q.g(bitmap0, "bitmap");
                return bitmap0.getByteCount() / 0x400;
            }
        };
        TemplateImageCacheManager.$stable = 8;
    }

    public static final void addBitmapToMemoryCache(@NotNull String s, @NotNull Bitmap bitmap0) {
        q.g(s, "key");
        q.g(bitmap0, "bitmap");
        if(TemplateImageCacheManager.getBitmapFromMemCache(s) == null) {
            TemplateImageCacheManager.a.put(s, bitmap0);
        }
    }

    public static final void clear() {
        try {
            TemplateImageCacheManager.a.evictAll();
        }
        catch(Exception exception0) {
            a.v("clear() - ", exception0.getMessage(), LogU.Companion, "TemplateImageCacheManager");
        }
    }

    @Nullable
    public static final Bitmap getBitmapFromMemCache(@Nullable String s) {
        return s == null || o.H0(s) ? null : ((Bitmap)TemplateImageCacheManager.a.get(s));
    }
}

