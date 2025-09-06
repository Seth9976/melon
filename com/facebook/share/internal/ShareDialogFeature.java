package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000F\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\b\u001A\u00020\u0004H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/share/internal/ShareDialogFeature;", "", "Lcom/facebook/internal/DialogFeature;", "minVersion", "", "(Ljava/lang/String;II)V", "getAction", "", "getMinVersion", "SHARE_DIALOG", "PHOTOS", "VIDEO", "MULTIMEDIA", "HASHTAG", "LINK_SHARE_QUOTES", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum ShareDialogFeature implements DialogFeature {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);

    private final int minVersion;

    private static final ShareDialogFeature[] $values() [...] // Inlined contents

    private ShareDialogFeature(int v1) {
        this.minVersion = v1;
    }

    @Override  // com.facebook.internal.DialogFeature
    @NotNull
    public String getAction() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    @Override  // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}

