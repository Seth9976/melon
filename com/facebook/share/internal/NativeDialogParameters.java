package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\tH\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\tH\u0002J&\u0010\u0003\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\r2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00040\u000F2\u0006\u0010\b\u001A\u00020\tH\u0002J&\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\u000F2\u0006\u0010\b\u001A\u00020\tH\u0002J,\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u00042\b\u0010\u0017\u001A\u0004\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\tH\u0002J\"\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u00132\u0006\u0010\b\u001A\u00020\tH\u0002J*\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u001B\u001A\u00020\u001C2\u000E\u0010\u001D\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001E2\u0006\u0010\u001F\u001A\u00020\tH\u0007J \u0010 \u001A\u00020\u00042\u000E\u0010!\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001E2\u0006\u0010\b\u001A\u00020\tH\u0002¨\u0006\""}, d2 = {"Lcom/facebook/share/internal/NativeDialogParameters;", "", "()V", "create", "Landroid/os/Bundle;", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "attachmentUrlsBundle", "dataErrorsFatal", "", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "mediaInfos", "", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "imageUrls", "", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "mediaInfo", "stickerInfo", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "videoUrl", "callId", "Ljava/util/UUID;", "shareContent", "Lcom/facebook/share/model/ShareContent;", "shouldFailOnDataError", "createBaseParameters", "content", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class NativeDialogParameters {
    @NotNull
    public static final NativeDialogParameters INSTANCE;

    static {
        NativeDialogParameters.INSTANCE = new NativeDialogParameters();
    }

    private final Bundle create(ShareCameraEffectContent shareCameraEffectContent0, Bundle bundle0, boolean z) {
        Bundle bundle1 = this.createBaseParameters(shareCameraEffectContent0, z);
        Utility.putNonEmptyString(bundle1, "effect_id", shareCameraEffectContent0.getEffectId());
        if(bundle0 != null) {
            bundle1.putBundle("effect_textures", bundle0);
        }
        try {
            JSONObject jSONObject0 = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent0.getArguments());
            if(jSONObject0 != null) {
                Utility.putNonEmptyString(bundle1, "effect_arguments", jSONObject0.toString());
                return bundle1;
            }
            return bundle1;
        }
        catch(JSONException jSONException0) {
            throw new FacebookException("Unable to create a JSON Object from the provided CameraEffectArguments: " + jSONException0.getMessage());
        }
    }

    private final Bundle create(ShareLinkContent shareLinkContent0, boolean z) {
        Bundle bundle0 = this.createBaseParameters(shareLinkContent0, z);
        Utility.putNonEmptyString(bundle0, "QUOTE", shareLinkContent0.getQuote());
        Utility.putUri(bundle0, "MESSENGER_LINK", shareLinkContent0.getContentUrl());
        Utility.putUri(bundle0, "TARGET_DISPLAY", shareLinkContent0.getContentUrl());
        return bundle0;
    }

    private final Bundle create(ShareMediaContent shareMediaContent0, List list0, boolean z) {
        Bundle bundle0 = this.createBaseParameters(shareMediaContent0, z);
        bundle0.putParcelableArrayList("MEDIA", new ArrayList(list0));
        return bundle0;
    }

    private final Bundle create(SharePhotoContent sharePhotoContent0, List list0, boolean z) {
        Bundle bundle0 = this.createBaseParameters(sharePhotoContent0, z);
        bundle0.putStringArrayList("PHOTOS", new ArrayList(list0));
        return bundle0;
    }

    private final Bundle create(ShareStoryContent shareStoryContent0, Bundle bundle0, Bundle bundle1, boolean z) {
        Bundle bundle2 = this.createBaseParameters(shareStoryContent0, z);
        if(bundle0 != null) {
            bundle2.putParcelable("bg_asset", bundle0);
        }
        if(bundle1 != null) {
            bundle2.putParcelable("interactive_asset_uri", bundle1);
        }
        Collection collection0 = shareStoryContent0.getBackgroundColorList();
        if(collection0 != null && !collection0.isEmpty()) {
            bundle2.putStringArrayList("top_background_color_list", new ArrayList(collection0));
        }
        Utility.putNonEmptyString(bundle2, "content_url", shareStoryContent0.getAttributionLink());
        return bundle2;
    }

    private final Bundle create(ShareVideoContent shareVideoContent0, String s, boolean z) {
        Bundle bundle0 = this.createBaseParameters(shareVideoContent0, z);
        Utility.putNonEmptyString(bundle0, "TITLE", shareVideoContent0.getContentTitle());
        Utility.putNonEmptyString(bundle0, "DESCRIPTION", shareVideoContent0.getContentDescription());
        Utility.putNonEmptyString(bundle0, "VIDEO", s);
        return bundle0;
    }

    @Nullable
    public static final Bundle create(@NotNull UUID uUID0, @NotNull ShareContent shareContent0, boolean z) {
        q.g(uUID0, "callId");
        q.g(shareContent0, "shareContent");
        if(shareContent0 instanceof ShareLinkContent) {
            return NativeDialogParameters.INSTANCE.create(((ShareLinkContent)shareContent0), z);
        }
        List list0 = w.a;
        if(shareContent0 instanceof SharePhotoContent) {
            List list1 = ShareInternalUtility.getPhotoUrls(((SharePhotoContent)shareContent0), uUID0);
            if(list1 != null) {
                list0 = list1;
            }
            return NativeDialogParameters.INSTANCE.create(((SharePhotoContent)shareContent0), list0, z);
        }
        if(shareContent0 instanceof ShareVideoContent) {
            String s = ShareInternalUtility.getVideoUrl(((ShareVideoContent)shareContent0), uUID0);
            return NativeDialogParameters.INSTANCE.create(((ShareVideoContent)shareContent0), s, z);
        }
        if(shareContent0 instanceof ShareMediaContent) {
            List list2 = ShareInternalUtility.getMediaInfos(((ShareMediaContent)shareContent0), uUID0);
            if(list2 != null) {
                list0 = list2;
            }
            return NativeDialogParameters.INSTANCE.create(((ShareMediaContent)shareContent0), list0, z);
        }
        if(shareContent0 instanceof ShareCameraEffectContent) {
            Bundle bundle0 = ShareInternalUtility.getTextureUrlBundle(((ShareCameraEffectContent)shareContent0), uUID0);
            return NativeDialogParameters.INSTANCE.create(((ShareCameraEffectContent)shareContent0), bundle0, z);
        }
        if(shareContent0 instanceof ShareStoryContent) {
            Bundle bundle1 = ShareInternalUtility.getBackgroundAssetMediaInfo(((ShareStoryContent)shareContent0), uUID0);
            Bundle bundle2 = ShareInternalUtility.getStickerUrl(((ShareStoryContent)shareContent0), uUID0);
            return NativeDialogParameters.INSTANCE.create(((ShareStoryContent)shareContent0), bundle1, bundle2, z);
        }
        return null;
    }

    private final Bundle createBaseParameters(ShareContent shareContent0, boolean z) {
        Bundle bundle0 = new Bundle();
        Utility.putUri(bundle0, "LINK", shareContent0.getContentUrl());
        Utility.putNonEmptyString(bundle0, "PLACE", shareContent0.getPlaceId());
        Utility.putNonEmptyString(bundle0, "PAGE", shareContent0.getPageId());
        Utility.putNonEmptyString(bundle0, "REF", shareContent0.getRef());
        Utility.putNonEmptyString(bundle0, "REF", shareContent0.getRef());
        bundle0.putBoolean("DATA_FAILURES_FATAL", z);
        Collection collection0 = shareContent0.getPeopleIds();
        if(collection0 != null && !collection0.isEmpty()) {
            bundle0.putStringArrayList("FRIENDS", new ArrayList(collection0));
        }
        ShareHashtag shareHashtag0 = shareContent0.getShareHashtag();
        Utility.putNonEmptyString(bundle0, "HASHTAG", (shareHashtag0 == null ? null : shareHashtag0.getHashtag()));
        return bundle0;
    }
}

