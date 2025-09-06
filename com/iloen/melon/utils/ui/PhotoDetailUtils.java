package com.iloen.melon.utils.ui;

import Tf.v;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/utils/ui/PhotoDetailUtils;", "", "", "desc", "convertToAccessibilityDesc", "(Ljava/lang/String;)Ljava/lang/String;", "descScheme", "convertToTitleFromAccessibilityDesc", "", "isAccessibilityDesc", "(Ljava/lang/String;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PhotoDetailUtils {
    public static final int $stable;
    @NotNull
    public static final PhotoDetailUtils INSTANCE;

    static {
        PhotoDetailUtils.INSTANCE = new PhotoDetailUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final String convertToAccessibilityDesc(@NotNull String s) {
        q.g(s, "desc");
        return "accessibility://" + s;
    }

    @NotNull
    public final String convertToTitleFromAccessibilityDesc(@NotNull String s) {
        q.g(s, "descScheme");
        return v.p0(s, "accessibility://", "");
    }

    public final boolean isAccessibilityDesc(@NotNull String s) {
        q.g(s, "descScheme");
        return v.r0(s, "accessibility://", true);
    }
}

