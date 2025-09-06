package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.ContextThemeWrapper;
import d5.w;

public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    public static Drawable getDrawable(Context context0, int v, Resources.Theme resources$Theme0) {
        return DrawableDecoderCompat.getDrawable(context0, context0, v, resources$Theme0);
    }

    public static Drawable getDrawable(Context context0, Context context1, int v) {
        return DrawableDecoderCompat.getDrawable(context0, context1, v, null);
    }

    private static Drawable getDrawable(Context context0, Context context1, int v, Resources.Theme resources$Theme0) {
        if(DrawableDecoderCompat.shouldCallAppCompatResources) {
            try {
                return DrawableDecoderCompat.loadDrawableV7(context1, v, resources$Theme0);
            }
            catch(NoClassDefFoundError unused_ex) {
            }
            catch(IllegalStateException illegalStateException0) {
                throw illegalStateException0;
            }
            catch(Resources.NotFoundException unused_ex) {
                goto label_6;
            }
            DrawableDecoderCompat.shouldCallAppCompatResources = false;
        }
    label_6:
        if(resources$Theme0 == null) {
            resources$Theme0 = context1.getTheme();
        }
        return DrawableDecoderCompat.loadDrawableV4(context1, v, resources$Theme0);
    }

    private static Drawable loadDrawableV4(Context context0, int v, Resources.Theme resources$Theme0) {
        return context0.getResources().getDrawable(v, resources$Theme0);
    }

    private static Drawable loadDrawableV7(Context context0, int v, Resources.Theme resources$Theme0) {
        if(resources$Theme0 != null) {
            ContextThemeWrapper contextThemeWrapper0 = new ContextThemeWrapper(context0);  // 初始化器: Landroid/content/ContextWrapper;-><init>(Landroid/content/Context;)V
            contextThemeWrapper0.b = resources$Theme0;
            contextThemeWrapper0.a(resources$Theme0.getResources().getConfiguration());
            context0 = contextThemeWrapper0;
        }
        return w.B(context0, v);
    }
}

