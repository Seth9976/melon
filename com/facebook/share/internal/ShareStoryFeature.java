package com.facebook.share.internal;

import com.facebook.internal.DialogFeature;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000F\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016J\b\u0010\b\u001A\u00020\u0004H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/facebook/share/internal/ShareStoryFeature;", "", "Lcom/facebook/internal/DialogFeature;", "minVersion", "", "(Ljava/lang/String;II)V", "getAction", "", "getMinVersion", "SHARE_STORY_ASSET", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum ShareStoryFeature implements DialogFeature {
    SHARE_STORY_ASSET(20170417);

    private final int minVersion;

    private static final ShareStoryFeature[] $values() [...] // Inlined contents

    private ShareStoryFeature(int v1) {
        this.minVersion = v1;
    }

    @Override  // com.facebook.internal.DialogFeature
    @NotNull
    public String getAction() {
        return "com.facebook.platform.action.request.SHARE_STORY";
    }

    @Override  // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}

