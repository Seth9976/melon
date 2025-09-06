package com.facebook.share.internal;

import Tf.o;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest.ParcelableResourceWithMimeType;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer.Result;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import e.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00F4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\n\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ)\u0010\u000E\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ1\u0010\u0013\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001A\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0018J3\u0010\"\u001A\u00020!2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001A2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0007\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010$\u001A\u00020\u001F2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b$\u0010%J+\u0010\'\u001A\u0004\u0018\u00010&2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001A2\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b)\u0010*J1\u0010-\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010,\u001A\u0004\u0018\u00010+2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b-\u0010.J)\u00104\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u0001032\b\u00100\u001A\u0004\u0018\u00010/2\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\b4\u00105J#\u00108\u001A\u0004\u0018\u00010\f2\b\u00107\u001A\u0004\u0018\u0001062\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\b8\u00109J)\u0010<\u001A\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001032\b\u0010;\u001A\u0004\u0018\u00010:2\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\b<\u0010=J#\u0010@\u001A\u0004\u0018\u00010\u00152\b\u0010?\u001A\u0004\u0018\u00010>2\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\b@\u0010AJ\u001F\u0010E\u001A\u00020B2\u0006\u0010C\u001A\u00020B2\u0006\u0010D\u001A\u00020!H\u0007\u00A2\u0006\u0004\bE\u0010FJ#\u0010I\u001A\u0004\u0018\u00010G2\b\u0010H\u001A\u0004\u0018\u00010G2\u0006\u0010D\u001A\u00020!H\u0007\u00A2\u0006\u0004\bI\u0010JJ%\u0010M\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\f0L2\u0006\u0010K\u001A\u00020\fH\u0007\u00A2\u0006\u0004\bM\u0010NJ)\u0010S\u001A\u0004\u0018\u00010R2\u0006\u0010O\u001A\u0002012\u000E\u0010Q\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030PH\u0002\u00A2\u0006\u0004\bS\u0010TJ-\u0010S\u001A\u0004\u0018\u00010R2\u0006\u0010O\u001A\u0002012\b\u0010V\u001A\u0004\u0018\u00010U2\b\u0010X\u001A\u0004\u0018\u00010WH\u0002\u00A2\u0006\u0004\bS\u0010YJ\u001F\u0010Z\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\bZ\u0010[J)\u0010\\\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b\\\u0010\u000FJ3\u0010_\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010]\u001A\u0004\u0018\u00010\u00112\b\u0010^\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b_\u0010`J)\u0010_\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010^\u001A\u0004\u0018\u00010\fH\u0007\u00A2\u0006\u0004\b_\u0010\u000FJ\'\u0010_\u001A\u00020\t2\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010b\u001A\u00020aH\u0007\u00A2\u0006\u0004\b_\u0010cJ!\u0010f\u001A\u00020\t2\u0006\u0010d\u001A\u00020\f2\b\u0010e\u001A\u0004\u0018\u00010\fH\u0002\u00A2\u0006\u0004\bf\u0010gJ-\u0010m\u001A\u00020l2\b\u0010i\u001A\u0004\u0018\u00010h2\b\u0010j\u001A\u0004\u0018\u00010W2\b\u0010\u0006\u001A\u0004\u0018\u00010kH\u0007\u00A2\u0006\u0004\bm\u0010nJ-\u0010m\u001A\u00020l2\b\u0010i\u001A\u0004\u0018\u00010h2\b\u0010p\u001A\u0004\u0018\u00010o2\b\u0010\u0006\u001A\u0004\u0018\u00010kH\u0007\u00A2\u0006\u0004\bm\u0010qJ+\u0010m\u001A\u00020l2\b\u0010i\u001A\u0004\u0018\u00010h2\u0006\u0010r\u001A\u00020U2\b\u0010\u0006\u001A\u0004\u0018\u00010kH\u0007\u00A2\u0006\u0004\bm\u0010sJ#\u0010v\u001A\u0004\u0018\u00010\u00152\b\u0010u\u001A\u0004\u0018\u00010t2\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\bv\u0010wJ#\u0010x\u001A\u0004\u0018\u00010\u00152\b\u0010u\u001A\u0004\u0018\u00010t2\u0006\u00102\u001A\u000201H\u0007\u00A2\u0006\u0004\bx\u0010wJ\u001B\u0010y\u001A\u0004\u0018\u00010\f2\b\u0010V\u001A\u0004\u0018\u00010UH\u0007\u00A2\u0006\u0004\by\u0010zR\u0014\u0010{\u001A\u00020\f8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010}\u001A\u00020\f8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b}\u0010|\u00A8\u0006~"}, d2 = {"Lcom/facebook/share/internal/ShareInternalUtility;", "", "<init>", "()V", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/share/Sharer$Result;", "callback", "Ljava/lang/Exception;", "exception", "Lie/H;", "invokeCallbackWithException", "(Lcom/facebook/FacebookCallback;Ljava/lang/Exception;)V", "", "error", "invokeCallbackWithError", "(Lcom/facebook/FacebookCallback;Ljava/lang/String;)V", "postId", "Lcom/facebook/GraphResponse;", "graphResponse", "invokeCallbackWithResults", "(Lcom/facebook/FacebookCallback;Ljava/lang/String;Lcom/facebook/GraphResponse;)V", "Landroid/os/Bundle;", "result", "getNativeDialogCompletionGesture", "(Landroid/os/Bundle;)Ljava/lang/String;", "getShareDialogPostId", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "Lcom/facebook/share/internal/ResultProcessor;", "resultProcessor", "", "handleActivityResult", "(IILandroid/content/Intent;Lcom/facebook/share/internal/ResultProcessor;)Z", "getShareResultProcessor", "(Lcom/facebook/FacebookCallback;)Lcom/facebook/share/internal/ResultProcessor;", "Lcom/facebook/internal/AppCall;", "getAppCallFromActivityResult", "(IILandroid/content/Intent;)Lcom/facebook/internal/AppCall;", "registerStaticShareCallback", "(I)V", "Lcom/facebook/CallbackManager;", "callbackManager", "registerSharerCallback", "(ILcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V", "Lcom/facebook/share/model/SharePhotoContent;", "photoContent", "Ljava/util/UUID;", "appCallId", "", "getPhotoUrls", "(Lcom/facebook/share/model/SharePhotoContent;Ljava/util/UUID;)Ljava/util/List;", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "getVideoUrl", "(Lcom/facebook/share/model/ShareVideoContent;Ljava/util/UUID;)Ljava/lang/String;", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "getMediaInfos", "(Lcom/facebook/share/model/ShareMediaContent;Ljava/util/UUID;)Ljava/util/List;", "Lcom/facebook/share/model/ShareCameraEffectContent;", "cameraEffectContent", "getTextureUrlBundle", "(Lcom/facebook/share/model/ShareCameraEffectContent;Ljava/util/UUID;)Landroid/os/Bundle;", "Lorg/json/JSONArray;", "jsonArray", "requireNamespace", "removeNamespacesFromOGJsonArray", "(Lorg/json/JSONArray;Z)Lorg/json/JSONArray;", "Lorg/json/JSONObject;", "jsonObject", "removeNamespacesFromOGJsonObject", "(Lorg/json/JSONObject;Z)Lorg/json/JSONObject;", "fullName", "Landroid/util/Pair;", "getFieldNameAndNamespaceFromFullName", "(Ljava/lang/String;)Landroid/util/Pair;", "callId", "Lcom/facebook/share/model/ShareMedia;", "medium", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "getAttachment", "(Ljava/util/UUID;Lcom/facebook/share/model/ShareMedia;)Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "Landroid/net/Uri;", "uri", "Landroid/graphics/Bitmap;", "bitmap", "(Ljava/util/UUID;Landroid/net/Uri;Landroid/graphics/Bitmap;)Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "invokeOnCancelCallback", "(Lcom/facebook/FacebookCallback;)V", "invokeOnSuccessCallback", "response", "message", "invokeOnErrorCallback", "(Lcom/facebook/FacebookCallback;Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "Lcom/facebook/FacebookException;", "ex", "(Lcom/facebook/FacebookCallback;Lcom/facebook/FacebookException;)V", "shareOutcome", "errorMessage", "logShareResult", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/facebook/AccessToken;", "accessToken", "image", "Lcom/facebook/GraphRequest$Callback;", "Lcom/facebook/GraphRequest;", "newUploadStagingResourceWithImageRequest", "(Lcom/facebook/AccessToken;Landroid/graphics/Bitmap;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Ljava/io/File;", "file", "(Lcom/facebook/AccessToken;Ljava/io/File;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "imageUri", "(Lcom/facebook/AccessToken;Landroid/net/Uri;Lcom/facebook/GraphRequest$Callback;)Lcom/facebook/GraphRequest;", "Lcom/facebook/share/model/ShareStoryContent;", "storyContent", "getStickerUrl", "(Lcom/facebook/share/model/ShareStoryContent;Ljava/util/UUID;)Landroid/os/Bundle;", "getBackgroundAssetMediaInfo", "getUriExtension", "(Landroid/net/Uri;)Ljava/lang/String;", "MY_STAGING_RESOURCES", "Ljava/lang/String;", "STAGING_PARAM", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareInternalUtility {
    @NotNull
    public static final ShareInternalUtility INSTANCE = null;
    @NotNull
    public static final String MY_STAGING_RESOURCES = "me/staging_resources";
    @NotNull
    public static final String STAGING_PARAM = "file";

    static {
        ShareInternalUtility.INSTANCE = new ShareInternalUtility();
    }

    private final AppCall getAppCallFromActivityResult(int v, int v1, Intent intent0) {
        UUID uUID0 = NativeProtocol.getCallIdFromIntent(intent0);
        return uUID0 == null ? null : AppCall.Companion.finishPendingCall(uUID0, v);
    }

    private final Attachment getAttachment(UUID uUID0, Uri uri0, Bitmap bitmap0) {
        if(bitmap0 != null) {
            return NativeAppCallAttachmentStore.createAttachment(uUID0, bitmap0);
        }
        return uri0 == null ? null : NativeAppCallAttachmentStore.createAttachment(uUID0, uri0);
    }

    private final Attachment getAttachment(UUID uUID0, ShareMedia shareMedia0) {
        if(shareMedia0 instanceof SharePhoto) {
            return this.getAttachment(uUID0, ((SharePhoto)shareMedia0).getImageUrl(), ((SharePhoto)shareMedia0).getBitmap());
        }
        return shareMedia0 instanceof ShareVideo ? this.getAttachment(uUID0, ((ShareVideo)shareMedia0).getLocalUrl(), null) : this.getAttachment(uUID0, null, null);
    }

    @Nullable
    public static final Bundle getBackgroundAssetMediaInfo(@Nullable ShareStoryContent shareStoryContent0, @NotNull UUID uUID0) {
        q.g(uUID0, "appCallId");
        Bundle bundle0 = null;
        if(shareStoryContent0 != null && shareStoryContent0.getBackgroundAsset() != null) {
            ShareMedia shareMedia0 = shareStoryContent0.getBackgroundAsset();
            Attachment nativeAppCallAttachmentStore$Attachment0 = ShareInternalUtility.INSTANCE.getAttachment(uUID0, shareMedia0);
            if(nativeAppCallAttachmentStore$Attachment0 == null) {
                return null;
            }
            bundle0 = new Bundle();
            bundle0.putString("type", shareMedia0.getMediaType().name());
            bundle0.putString("uri", nativeAppCallAttachmentStore$Attachment0.getAttachmentUrl());
            String s = ShareInternalUtility.getUriExtension(nativeAppCallAttachmentStore$Attachment0.getOriginalUri());
            if(s != null) {
                Utility.putNonEmptyString(bundle0, "extension", s);
            }
            NativeAppCallAttachmentStore.addAttachments(k.z(nativeAppCallAttachmentStore$Attachment0));
        }
        return bundle0;
    }

    @NotNull
    public static final Pair getFieldNameAndNamespaceFromFullName(@NotNull String s) {
        q.g(s, "fullName");
        int v = o.E0(s, ':', 0, 6);
        if(v != -1 && s.length() > v + 1) {
            String s1 = s.substring(0, v);
            q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
            s = s.substring(v + 1);
            q.f(s, "this as java.lang.String).substring(startIndex)");
            return new Pair(s1, s);
        }
        return new Pair(null, s);
    }

    @Nullable
    public static final List getMediaInfos(@Nullable ShareMediaContent shareMediaContent0, @NotNull UUID uUID0) {
        Bundle bundle0;
        q.g(uUID0, "appCallId");
        if(shareMediaContent0 != null) {
            List list0 = shareMediaContent0.getMedia();
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList();
                List list1 = new ArrayList();
                for(Object object0: list0) {
                    ShareMedia shareMedia0 = (ShareMedia)object0;
                    Attachment nativeAppCallAttachmentStore$Attachment0 = ShareInternalUtility.INSTANCE.getAttachment(uUID0, shareMedia0);
                    if(nativeAppCallAttachmentStore$Attachment0 == null) {
                        bundle0 = null;
                    }
                    else {
                        arrayList0.add(nativeAppCallAttachmentStore$Attachment0);
                        bundle0 = new Bundle();
                        bundle0.putString("type", shareMedia0.getMediaType().name());
                        bundle0.putString("uri", nativeAppCallAttachmentStore$Attachment0.getAttachmentUrl());
                    }
                    if(bundle0 != null) {
                        list1.add(bundle0);
                    }
                }
                NativeAppCallAttachmentStore.addAttachments(arrayList0);
                return list1;
            }
        }
        return null;
    }

    @Nullable
    public static final String getNativeDialogCompletionGesture(@NotNull Bundle bundle0) {
        q.g(bundle0, "result");
        return bundle0.containsKey("completionGesture") ? bundle0.getString("completionGesture") : bundle0.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
    }

    @Nullable
    public static final List getPhotoUrls(@Nullable SharePhotoContent sharePhotoContent0, @NotNull UUID uUID0) {
        q.g(uUID0, "appCallId");
        if(sharePhotoContent0 != null) {
            List list0 = sharePhotoContent0.getPhotos();
            if(list0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: list0) {
                    Attachment nativeAppCallAttachmentStore$Attachment0 = ShareInternalUtility.INSTANCE.getAttachment(uUID0, ((SharePhoto)object0));
                    if(nativeAppCallAttachmentStore$Attachment0 != null) {
                        arrayList0.add(nativeAppCallAttachmentStore$Attachment0);
                    }
                }
                List list1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    list1.add(((Attachment)object1).getAttachmentUrl());
                }
                NativeAppCallAttachmentStore.addAttachments(arrayList0);
                return list1;
            }
        }
        return null;
    }

    @Nullable
    public static final String getShareDialogPostId(@NotNull Bundle bundle0) {
        q.g(bundle0, "result");
        if(bundle0.containsKey("postId")) {
            return bundle0.getString("postId");
        }
        return bundle0.containsKey("com.facebook.platform.extra.POST_ID") ? bundle0.getString("com.facebook.platform.extra.POST_ID") : bundle0.getString("post_id");
    }

    @NotNull
    public static final ResultProcessor getShareResultProcessor(@Nullable FacebookCallback facebookCallback0) {
        return new ResultProcessor(facebookCallback0) {
            @Override  // com.facebook.share.internal.ResultProcessor
            public void onCancel(@NotNull AppCall appCall0) {
                q.g(appCall0, "appCall");
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback0);
            }

            @Override  // com.facebook.share.internal.ResultProcessor
            public void onError(@NotNull AppCall appCall0, @NotNull FacebookException facebookException0) {
                q.g(appCall0, "appCall");
                q.g(facebookException0, "error");
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback0, facebookException0);
            }

            @Override  // com.facebook.share.internal.ResultProcessor
            public void onSuccess(@NotNull AppCall appCall0, @Nullable Bundle bundle0) {
                q.g(appCall0, "appCall");
                if(bundle0 != null) {
                    String s = ShareInternalUtility.getNativeDialogCompletionGesture(bundle0);
                    if(s != null && !"post".equalsIgnoreCase(s)) {
                        if("cancel".equalsIgnoreCase(s)) {
                            ShareInternalUtility.invokeOnCancelCallback(facebookCallback0);
                            return;
                        }
                        FacebookException facebookException0 = new FacebookException("UnknownError");
                        ShareInternalUtility.invokeOnErrorCallback(facebookCallback0, facebookException0);
                        return;
                    }
                    String s1 = ShareInternalUtility.getShareDialogPostId(bundle0);
                    ShareInternalUtility.invokeOnSuccessCallback(facebookCallback0, s1);
                }
            }
        };
    }

    @Nullable
    public static final Bundle getStickerUrl(@Nullable ShareStoryContent shareStoryContent0, @NotNull UUID uUID0) {
        q.g(uUID0, "appCallId");
        if(shareStoryContent0 != null && shareStoryContent0.getStickerAsset() != null) {
            new ArrayList().add(shareStoryContent0.getStickerAsset());
            Attachment nativeAppCallAttachmentStore$Attachment0 = ShareInternalUtility.INSTANCE.getAttachment(uUID0, shareStoryContent0.getStickerAsset());
            if(nativeAppCallAttachmentStore$Attachment0 == null) {
                return null;
            }
            Bundle bundle0 = new Bundle();
            bundle0.putString("uri", nativeAppCallAttachmentStore$Attachment0.getAttachmentUrl());
            String s = ShareInternalUtility.getUriExtension(nativeAppCallAttachmentStore$Attachment0.getOriginalUri());
            if(s != null) {
                Utility.putNonEmptyString(bundle0, "extension", s);
            }
            NativeAppCallAttachmentStore.addAttachments(k.z(nativeAppCallAttachmentStore$Attachment0));
            return bundle0;
        }
        return null;
    }

    @Nullable
    public static final Bundle getTextureUrlBundle(@Nullable ShareCameraEffectContent shareCameraEffectContent0, @NotNull UUID uUID0) {
        q.g(uUID0, "appCallId");
        if(shareCameraEffectContent0 != null) {
            CameraEffectTextures cameraEffectTextures0 = shareCameraEffectContent0.getTextures();
            if(cameraEffectTextures0 != null) {
                Bundle bundle0 = new Bundle();
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: cameraEffectTextures0.keySet()) {
                    String s = (String)object0;
                    Uri uri0 = cameraEffectTextures0.getTextureUri(s);
                    Bitmap bitmap0 = cameraEffectTextures0.getTextureBitmap(s);
                    Attachment nativeAppCallAttachmentStore$Attachment0 = ShareInternalUtility.INSTANCE.getAttachment(uUID0, uri0, bitmap0);
                    if(nativeAppCallAttachmentStore$Attachment0 != null) {
                        arrayList0.add(nativeAppCallAttachmentStore$Attachment0);
                        bundle0.putString(s, nativeAppCallAttachmentStore$Attachment0.getAttachmentUrl());
                    }
                }
                NativeAppCallAttachmentStore.addAttachments(arrayList0);
                return bundle0;
            }
        }
        return null;
    }

    @Nullable
    public static final String getUriExtension(@Nullable Uri uri0) {
        if(uri0 != null) {
            String s = uri0.toString();
            q.f(s, "uri.toString()");
            int v = o.J0(s, '.', 0, 6);
            if(v != -1) {
                String s1 = s.substring(v);
                q.f(s1, "this as java.lang.String).substring(startIndex)");
                return s1;
            }
        }
        return null;
    }

    @Nullable
    public static final String getVideoUrl(@Nullable ShareVideoContent shareVideoContent0, @NotNull UUID uUID0) {
        q.g(uUID0, "appCallId");
        if(shareVideoContent0 != null) {
            ShareVideo shareVideo0 = shareVideoContent0.getVideo();
            if(shareVideo0 != null) {
                Uri uri0 = shareVideo0.getLocalUrl();
                if(uri0 != null) {
                    Attachment nativeAppCallAttachmentStore$Attachment0 = NativeAppCallAttachmentStore.createAttachment(uUID0, uri0);
                    NativeAppCallAttachmentStore.addAttachments(k.z(nativeAppCallAttachmentStore$Attachment0));
                    return nativeAppCallAttachmentStore$Attachment0.getAttachmentUrl();
                }
            }
        }
        return null;
    }

    public static final boolean handleActivityResult(int v, int v1, @Nullable Intent intent0, @Nullable ResultProcessor resultProcessor0) {
        AppCall appCall0 = ShareInternalUtility.INSTANCE.getAppCallFromActivityResult(v, v1, intent0);
        if(appCall0 == null) {
            return false;
        }
        Bundle bundle0 = null;
        NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCall0.getCallId());
        if(resultProcessor0 == null) {
            return true;
        }
        FacebookException facebookException0 = intent0 == null ? null : NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent0));
        if(facebookException0 != null) {
            if(facebookException0 instanceof FacebookOperationCanceledException) {
                resultProcessor0.onCancel(appCall0);
                return true;
            }
            resultProcessor0.onError(appCall0, facebookException0);
            return true;
        }
        if(intent0 != null) {
            bundle0 = NativeProtocol.getSuccessResultsFromIntent(intent0);
        }
        resultProcessor0.onSuccess(appCall0, bundle0);
        return true;
    }

    public static final void invokeCallbackWithError(@Nullable FacebookCallback facebookCallback0, @Nullable String s) {
        ShareInternalUtility.invokeOnErrorCallback(facebookCallback0, s);
    }

    public static final void invokeCallbackWithException(@Nullable FacebookCallback facebookCallback0, @NotNull Exception exception0) {
        q.g(exception0, "exception");
        if(exception0 instanceof FacebookException) {
            ShareInternalUtility.invokeOnErrorCallback(facebookCallback0, ((FacebookException)exception0));
            return;
        }
        ShareInternalUtility.invokeCallbackWithError(facebookCallback0, "Error preparing share content: " + exception0.getLocalizedMessage());
    }

    public static final void invokeCallbackWithResults(@Nullable FacebookCallback facebookCallback0, @Nullable String s, @NotNull GraphResponse graphResponse0) {
        q.g(graphResponse0, "graphResponse");
        FacebookRequestError facebookRequestError0 = graphResponse0.getError();
        if(facebookRequestError0 != null) {
            String s1 = facebookRequestError0.getErrorMessage();
            if(Utility.isNullOrEmpty(s1)) {
                s1 = "Unexpected error sharing.";
            }
            ShareInternalUtility.invokeOnErrorCallback(facebookCallback0, graphResponse0, s1);
            return;
        }
        ShareInternalUtility.invokeOnSuccessCallback(facebookCallback0, s);
    }

    public static final void invokeOnCancelCallback(@Nullable FacebookCallback facebookCallback0) {
        ShareInternalUtility.INSTANCE.logShareResult("cancelled", null);
        if(facebookCallback0 != null) {
            facebookCallback0.onCancel();
        }
    }

    public static final void invokeOnErrorCallback(@Nullable FacebookCallback facebookCallback0, @NotNull FacebookException facebookException0) {
        q.g(facebookException0, "ex");
        ShareInternalUtility.INSTANCE.logShareResult("error", facebookException0.getMessage());
        if(facebookCallback0 != null) {
            facebookCallback0.onError(facebookException0);
        }
    }

    public static final void invokeOnErrorCallback(@Nullable FacebookCallback facebookCallback0, @Nullable GraphResponse graphResponse0, @Nullable String s) {
        ShareInternalUtility.INSTANCE.logShareResult("error", s);
        if(facebookCallback0 != null) {
            facebookCallback0.onError(new FacebookGraphResponseException(graphResponse0, s));
        }
    }

    public static final void invokeOnErrorCallback(@Nullable FacebookCallback facebookCallback0, @Nullable String s) {
        ShareInternalUtility.INSTANCE.logShareResult("error", s);
        if(facebookCallback0 != null) {
            facebookCallback0.onError(new FacebookException(s));
        }
    }

    public static final void invokeOnSuccessCallback(@Nullable FacebookCallback facebookCallback0, @Nullable String s) {
        ShareInternalUtility.INSTANCE.logShareResult("succeeded", null);
        if(facebookCallback0 != null) {
            facebookCallback0.onSuccess(new Result(s));
        }
    }

    private final void logShareResult(String s, String s1) {
        InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
        Bundle bundle0 = Y.b("fb_share_dialog_outcome", s);
        if(s1 != null) {
            bundle0.putString("error_message", s1);
        }
        internalAppEventsLogger0.logEventImplicitly("fb_share_dialog_result", bundle0);
    }

    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken0, @Nullable Bitmap bitmap0, @Nullable Callback graphRequest$Callback0) {
        Bundle bundle0 = new Bundle(1);
        bundle0.putParcelable("file", bitmap0);
        return new GraphRequest(accessToken0, "me/staging_resources", bundle0, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
    }

    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken0, @NotNull Uri uri0, @Nullable Callback graphRequest$Callback0) {
        q.g(uri0, "imageUri");
        String s = uri0.getPath();
        if(Utility.isFileUri(uri0) && s != null) {
            return ShareInternalUtility.newUploadStagingResourceWithImageRequest(accessToken0, new File(s), graphRequest$Callback0);
        }
        if(!Utility.isContentUri(uri0)) {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        }
        ParcelableResourceWithMimeType graphRequest$ParcelableResourceWithMimeType0 = new ParcelableResourceWithMimeType(uri0, "image/png");
        Bundle bundle0 = new Bundle(1);
        bundle0.putParcelable("file", graphRequest$ParcelableResourceWithMimeType0);
        return new GraphRequest(accessToken0, "me/staging_resources", bundle0, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
    }

    @NotNull
    public static final GraphRequest newUploadStagingResourceWithImageRequest(@Nullable AccessToken accessToken0, @Nullable File file0, @Nullable Callback graphRequest$Callback0) {
        ParcelableResourceWithMimeType graphRequest$ParcelableResourceWithMimeType0 = new ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file0, 0x10000000), "image/png");
        Bundle bundle0 = new Bundle(1);
        bundle0.putParcelable("file", graphRequest$ParcelableResourceWithMimeType0);
        return new GraphRequest(accessToken0, "me/staging_resources", bundle0, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null);
    }

    public static final void registerSharerCallback(int v, @Nullable CallbackManager callbackManager0, @Nullable FacebookCallback facebookCallback0) {
        if(!(callbackManager0 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl)callbackManager0).registerCallback(v, (int v1, Intent intent0) -> ShareInternalUtility.handleActivityResult(v, v1, intent0, ShareInternalUtility.getShareResultProcessor(facebookCallback0)));
    }

    // 检测为 Lambda 实现
    private static final boolean registerSharerCallback$lambda$1(int v, FacebookCallback facebookCallback0, int v1, Intent intent0) [...]

    public static final void registerStaticShareCallback(int v) {
        b b0 = (int v1, Intent intent0) -> ShareInternalUtility.handleActivityResult(v, v1, intent0, ShareInternalUtility.getShareResultProcessor(null));
        CallbackManagerImpl.Companion.registerStaticCallback(v, b0);
    }

    // 检测为 Lambda 实现
    private static final boolean registerStaticShareCallback$lambda$0(int v, int v1, Intent intent0) [...]

    @NotNull
    public static final JSONArray removeNamespacesFromOGJsonArray(@NotNull JSONArray jSONArray0, boolean z) {
        q.g(jSONArray0, "jsonArray");
        JSONArray jSONArray1 = new JSONArray();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = jSONArray0.get(v1);
            if(object0 instanceof JSONArray) {
                object0 = ShareInternalUtility.removeNamespacesFromOGJsonArray(((JSONArray)object0), z);
            }
            else if(object0 instanceof JSONObject) {
                object0 = ShareInternalUtility.removeNamespacesFromOGJsonObject(((JSONObject)object0), z);
            }
            jSONArray1.put(object0);
        }
        return jSONArray1;
    }

    @Nullable
    public static final JSONObject removeNamespacesFromOGJsonObject(@Nullable JSONObject jSONObject0, boolean z) {
        if(jSONObject0 == null) {
            return null;
        }
        try {
            JSONObject jSONObject1 = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray0 = jSONObject0.names();
            if(jSONArray0 == null) {
                return null;
            }
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = jSONArray0.getString(v1);
                Object object0 = jSONObject0.get(s);
                if(object0 instanceof JSONObject) {
                    object0 = ShareInternalUtility.removeNamespacesFromOGJsonObject(((JSONObject)object0), true);
                }
                else if(object0 instanceof JSONArray) {
                    object0 = ShareInternalUtility.removeNamespacesFromOGJsonArray(((JSONArray)object0), true);
                }
                q.f(s, "key");
                Pair pair0 = ShareInternalUtility.getFieldNameAndNamespaceFromFullName(s);
                String s1 = (String)pair0.first;
                String s2 = (String)pair0.second;
                if(z) {
                    if(s1 != null && s1.equals("fbsdk")) {
                        jSONObject1.put(s, object0);
                    }
                    else if(s1 == null || s1.equals("og")) {
                        jSONObject1.put(s2, object0);
                    }
                    else {
                        jSONObject2.put(s2, object0);
                    }
                }
                else if(s1 == null || !s1.equals("fb")) {
                    jSONObject1.put(s2, object0);
                }
                else {
                    jSONObject1.put(s, object0);
                }
            }
            if(jSONObject2.length() > 0) {
                jSONObject1.put("data", jSONObject2);
            }
            return jSONObject1;
        }
        catch(JSONException unused_ex) {
            throw new FacebookException("Failed to create json object from share content");
        }
    }
}

