package com.google.android.gms.cast.framework.media.internal;

import androidx.annotation.Keep;
import com.google.android.gms.cast.framework.R.dimen;
import com.google.android.gms.cast.framework.R.drawable;
import com.google.android.gms.cast.framework.R.string;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ResourceProvider {
    public static final int a;
    private static final Map zza;

    static {
        HashMap hashMap0 = new HashMap();
        hashMap0.put("smallIconDrawableResId", drawable.cast_ic_notification_small_icon);
        hashMap0.put("stopLiveStreamDrawableResId", drawable.cast_ic_notification_stop_live_stream);
        hashMap0.put("pauseDrawableResId", drawable.cast_ic_notification_pause);
        hashMap0.put("playDrawableResId", drawable.cast_ic_notification_play);
        hashMap0.put("skipNextDrawableResId", drawable.cast_ic_notification_skip_next);
        hashMap0.put("skipPrevDrawableResId", drawable.cast_ic_notification_skip_prev);
        hashMap0.put("forwardDrawableResId", drawable.cast_ic_notification_forward);
        hashMap0.put("forward10DrawableResId", drawable.cast_ic_notification_forward10);
        hashMap0.put("forward30DrawableResId", drawable.cast_ic_notification_forward30);
        hashMap0.put("rewindDrawableResId", drawable.cast_ic_notification_rewind);
        hashMap0.put("rewind10DrawableResId", drawable.cast_ic_notification_rewind10);
        hashMap0.put("rewind30DrawableResId", drawable.cast_ic_notification_rewind30);
        hashMap0.put("disconnectDrawableResId", drawable.cast_ic_notification_disconnect);
        hashMap0.put("notificationImageSizeDimenResId", dimen.cast_notification_image_size);
        hashMap0.put("castingToDeviceStringResId", string.cast_casting_to_device);
        hashMap0.put("stopLiveStreamStringResId", string.cast_stop_live_stream);
        hashMap0.put("pauseStringResId", string.cast_pause);
        hashMap0.put("playStringResId", string.cast_play);
        hashMap0.put("skipNextStringResId", string.cast_skip_next);
        hashMap0.put("skipPrevStringResId", string.cast_skip_prev);
        hashMap0.put("forwardStringResId", string.cast_forward);
        hashMap0.put("forward10StringResId", string.cast_forward_10);
        hashMap0.put("forward30StringResId", string.cast_forward_30);
        hashMap0.put("rewindStringResId", string.cast_rewind);
        hashMap0.put("rewind10StringResId", string.cast_rewind_10);
        hashMap0.put("rewind30StringResId", string.cast_rewind_30);
        hashMap0.put("disconnectStringResId", string.cast_disconnect);
        ResourceProvider.zza = Collections.unmodifiableMap(hashMap0);
    }

    @Keep
    public static Integer findResourceByName(String s) {
        return s == null ? null : ((Integer)ResourceProvider.zza.get(s));
    }
}

