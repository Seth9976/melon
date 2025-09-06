package com.iloen.melon.fragments.detail;

import android.content.Context;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¨\u0006\u0004"}, d2 = {"getPhotoSpanCount", "", "context", "Landroid/content/Context;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PhotoGridSpacingItemDecorationKt {
    public static final int getPhotoSpanCount(@Nullable Context context0) {
        if(ScreenUtils.isTablet(context0)) {
            return ScreenUtils.isOrientationPortrait(context0) ? 5 : 6;
        }
        return ScreenUtils.isOrientationPortrait(context0) ? 3 : 4;
    }
}

