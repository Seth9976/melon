package com.iloen.melon.utils;

import P1.c;
import android.graphics.drawable.Drawable;
import com.iloen.melon.MelonAppBase;
import k8.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001A\u00020\u0003\u001A)\u0010\b\u001A\u00020\u00072\b\b\u0001\u0010\t\u001A\u00020\u00032\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000B\"\u00020\f¢\u0006\u0002\u0010\r\"\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"getDimension", "", "resourceId", "", "getDrawable", "Landroid/graphics/drawable/Drawable;", "EMPTY_STRING", "", "getString", "id", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ResourceUtilsKt {
    @NotNull
    public static final String EMPTY_STRING = "";

    public static final float getDimension(int v) {
        MelonAppBase.Companion.getClass();
        return t.a().getContext().getResources().getDimension(v);
    }

    @Nullable
    public static final Drawable getDrawable(int v) {
        MelonAppBase.Companion.getClass();
        return c.getDrawable(t.a().getContext(), v);
    }

    @NotNull
    public static final String getString(int v, @NotNull Object[] arr_object) [...] // 潜在的解密器
}

