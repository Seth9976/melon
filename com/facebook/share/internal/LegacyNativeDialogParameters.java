package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhotoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0002J&\u0010\u0003\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\n2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0007\u001A\u00020\bH\u0002J*\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000E\u001A\u00020\u000F2\u000E\u0010\u0010\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0012\u001A\u00020\bH\u0007J \u0010\u0013\u001A\u00020\u00042\u000E\u0010\u0014\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00112\u0006\u0010\u0007\u001A\u00020\bH\u0002¨\u0006\u0015"}, d2 = {"Lcom/facebook/share/internal/LegacyNativeDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "dataErrorsFatal", "", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "imageUrls", "", "", "callId", "Ljava/util/UUID;", "shareContent", "Lcom/facebook/share/model/ShareContent;", "shouldFailOnDataError", "createBaseParameters", "content", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LegacyNativeDialogParameters {
    @NotNull
    public static final LegacyNativeDialogParameters INSTANCE;

    static {
        LegacyNativeDialogParameters.INSTANCE = new LegacyNativeDialogParameters();
    }

    private final Bundle create(ShareLinkContent shareLinkContent0, boolean z) {
        return this.createBaseParameters(shareLinkContent0, z);
    }

    private final Bundle create(SharePhotoContent sharePhotoContent0, List list0, boolean z) {
        Bundle bundle0 = this.createBaseParameters(sharePhotoContent0, z);
        bundle0.putStringArrayList("com.facebook.platform.extra.PHOTOS", new ArrayList(list0));
        return bundle0;
    }

    @Nullable
    public static final Bundle create(@NotNull UUID uUID0, @NotNull ShareContent shareContent0, boolean z) {
        q.g(uUID0, "callId");
        q.g(shareContent0, "shareContent");
        if(shareContent0 instanceof ShareLinkContent) {
            return LegacyNativeDialogParameters.INSTANCE.create(((ShareLinkContent)shareContent0), z);
        }
        if(shareContent0 instanceof SharePhotoContent) {
            List list0 = ShareInternalUtility.getPhotoUrls(((SharePhotoContent)shareContent0), uUID0);
            if(list0 == null) {
                list0 = w.a;
            }
            return LegacyNativeDialogParameters.INSTANCE.create(((SharePhotoContent)shareContent0), list0, z);
        }
        return null;
    }

    private final Bundle createBaseParameters(ShareContent shareContent0, boolean z) {
        Bundle bundle0 = new Bundle();
        Utility.putUri(bundle0, "com.facebook.platform.extra.LINK", shareContent0.getContentUrl());
        Utility.putNonEmptyString(bundle0, "com.facebook.platform.extra.PLACE", shareContent0.getPlaceId());
        Utility.putNonEmptyString(bundle0, "com.facebook.platform.extra.REF", shareContent0.getRef());
        bundle0.putBoolean("com.facebook.platform.extra.DATA_FAILURES_FATAL", z);
        Collection collection0 = shareContent0.getPeopleIds();
        if(collection0 != null && !collection0.isEmpty()) {
            bundle0.putStringArrayList("com.facebook.platform.extra.FRIENDS", new ArrayList(collection0));
        }
        return bundle0;
    }
}

