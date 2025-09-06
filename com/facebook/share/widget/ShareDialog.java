package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase.ModeHandler;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.share.Sharer;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import e.k;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 :2\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0007;:<=>?@B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bB\u0013\b\u0016\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u0007\u0010\u000BB\u0011\b\u0016\u0012\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\b\u0007\u0010\u000EB\u0011\b\u0016\u0012\u0006\u0010\r\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0007\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u0007\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\r\u001A\u00020\f\u0012\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u0007\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\r\u001A\u00020\u000F\u0012\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u0007\u0010\u0013B\u001B\b\u0016\u0012\u0006\u0010\u0015\u001A\u00020\u0014\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u0007\u0010\u0016J1\u0010\u001D\u001A\u00020\u001C2\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u000E\u0010\u0019\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u001B\u001A\u00020\u001AH\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ%\u0010#\u001A\u00020\u001C2\u0006\u0010 \u001A\u00020\u001F2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00030!H\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0016\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020\u001C2\u0006\u0010(\u001A\u00020%H\u0016\u00A2\u0006\u0004\b)\u0010*J\'\u0010+\u001A\u00020%2\u000E\u0010\u0019\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b+\u0010,J\'\u0010-\u001A\u00020\u001C2\u000E\u0010\u0019\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b-\u0010.J\u000F\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b0\u00101R\u0016\u0010(\u001A\u00020%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u00102R\u0016\u00103\u001A\u00020%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00102R8\u00106\u001A \u0012\u001C\u0012\u001A05R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001048\u0014X\u0094\u0004\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u00109\u00A8\u0006A"}, d2 = {"Lcom/facebook/share/widget/ShareDialog;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "Lcom/facebook/share/Sharer;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "requestCode", "(I)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;)V", "(Landroid/app/Activity;I)V", "(Landroidx/fragment/app/I;I)V", "(Landroid/app/Fragment;I)V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "(Lcom/facebook/internal/FragmentWrapper;I)V", "Landroid/content/Context;", "context", "content", "Lcom/facebook/share/widget/ShareDialog$Mode;", "mode", "Lie/H;", "logDialogShare", "(Landroid/content/Context;Lcom/facebook/share/model/ShareContent;Lcom/facebook/share/widget/ShareDialog$Mode;)V", "Lcom/facebook/internal/CallbackManagerImpl;", "callbackManager", "Lcom/facebook/FacebookCallback;", "callback", "registerCallbackImpl", "(Lcom/facebook/internal/CallbackManagerImpl;Lcom/facebook/FacebookCallback;)V", "", "getShouldFailOnDataError", "()Z", "shouldFailOnDataError", "setShouldFailOnDataError", "(Z)V", "canShow", "(Lcom/facebook/share/model/ShareContent;Lcom/facebook/share/widget/ShareDialog$Mode;)Z", "show", "(Lcom/facebook/share/model/ShareContent;Lcom/facebook/share/widget/ShareDialog$Mode;)V", "Lcom/facebook/internal/AppCall;", "createBaseAppCall", "()Lcom/facebook/internal/AppCall;", "Z", "isAutomaticMode", "", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "orderedModeHandlers", "Ljava/util/List;", "getOrderedModeHandlers", "()Ljava/util/List;", "Companion", "CameraEffectHandler", "FeedHandler", "Mode", "NativeHandler", "ShareStoryHandler", "WebShareHandler", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class ShareDialog extends FacebookDialogBase implements Sharer {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u001A0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001A\u00020\r2\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000F\u001A\u00020\rH\u0016J\u001A\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001A\u0010\u0006\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$CameraEffectHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class CameraEffectHandler extends ModeHandler {
        @NotNull
        private Object mode;

        public CameraEffectHandler() {
            this.mode = Mode.NATIVE;
        }

        public boolean canShow(@NotNull ShareContent shareContent0, boolean z) {
            q.g(shareContent0, "content");
            if(shareContent0 instanceof ShareCameraEffectContent) {
                Class class0 = shareContent0.getClass();
                return Companion.access$canShowNative(ShareDialog.Companion, class0);
            }
            return false;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ShareContent)object0), z);
        }

        @Nullable
        public AppCall createAppCall(@NotNull ShareContent shareContent0) {
            q.g(shareContent0, "content");
            ShareContentValidation.validateForNativeShare(shareContent0);
            AppCall appCall0 = ShareDialog.this.createBaseAppCall();
            boolean z = ShareDialog.this.getShouldFailOnDataError();
            Class class0 = shareContent0.getClass();
            DialogFeature dialogFeature0 = Companion.access$getFeature(ShareDialog.Companion, class0);
            if(dialogFeature0 == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(appCall0, new ParameterProvider() {
                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                @Nullable
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(shareContent0.getCallId(), z, this.$shouldFailOnDataError);
                }

                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                @Nullable
                public Bundle getParameters() {
                    return NativeDialogParameters.create(shareContent0.getCallId(), z, this.$shouldFailOnDataError);
                }
            }, dialogFeature0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ShareContent)object0));
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        @NotNull
        public Object getMode() {
            return this.mode;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public void setMode(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.mode = object0;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\u0007\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\'\u0010\u000E\u001A\u00020\r2\u0016\u0010\f\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0010\u001A\u00020\r2\u0016\u0010\f\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u000BH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u001F\u0010\u0012\u001A\u00020\r2\u000E\u0010\u0011\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0016\u0010\f\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u000BH\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\t\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u00172\u000E\u0010\u0007\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0017\u00A2\u0006\u0004\b\t\u0010\u0019J\'\u0010\t\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001A2\u000E\u0010\u0007\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0017\u00A2\u0006\u0004\b\t\u0010\u001CJ\'\u0010\t\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001D2\u000E\u0010\u0007\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0017\u00A2\u0006\u0004\b\t\u0010\u001EJ\'\u0010\u001F\u001A\u00020\r2\u0016\u0010\f\u001A\u0012\u0012\u000E\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u000BH\u0017\u00A2\u0006\u0004\b\u001F\u0010\u000FR\u0014\u0010!\u001A\u00020 8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001A\u00020#8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b$\u0010%R\u001C\u0010\'\u001A\n &*\u0004\u0018\u00010#0#8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010%R\u0014\u0010(\u001A\u00020#8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010)\u001A\u00020#8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b)\u0010%\u00A8\u0006*"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$Companion;", "", "<init>", "()V", "Lcom/facebook/internal/FragmentWrapper;", "fragmentWrapper", "Lcom/facebook/share/model/ShareContent;", "shareContent", "Lie/H;", "show", "(Lcom/facebook/internal/FragmentWrapper;Lcom/facebook/share/model/ShareContent;)V", "Ljava/lang/Class;", "contentType", "", "canShowNative", "(Ljava/lang/Class;)Z", "canShowWebTypeCheck", "content", "canShowWebCheck", "(Lcom/facebook/share/model/ShareContent;)Z", "Lcom/facebook/internal/DialogFeature;", "getFeature", "(Ljava/lang/Class;)Lcom/facebook/internal/DialogFeature;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;Lcom/facebook/share/model/ShareContent;)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;Lcom/facebook/share/model/ShareContent;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;Lcom/facebook/share/model/ShareContent;)V", "canShow", "", "DEFAULT_REQUEST_CODE", "I", "", "FEED_DIALOG", "Ljava/lang/String;", "kotlin.jvm.PlatformType", "TAG", "WEB_OG_SHARE_DIALOG", "WEB_SHARE_DIALOG", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public boolean canShow(@NotNull Class class0) {
            q.g(class0, "contentType");
            return this.canShowWebTypeCheck(class0) || this.canShowNative(class0);
        }

        private final boolean canShowNative(Class class0) {
            DialogFeature dialogFeature0 = this.getFeature(class0);
            return dialogFeature0 != null && DialogPresenter.canPresentNativeDialogWithFeature(dialogFeature0);
        }

        private final boolean canShowWebCheck(ShareContent shareContent0) {
            return this.canShowWebTypeCheck(shareContent0.getClass());
        }

        // 去混淆评级： 低(30)
        private final boolean canShowWebTypeCheck(Class class0) {
            return ShareLinkContent.class.isAssignableFrom(class0) || SharePhotoContent.class.isAssignableFrom(class0) && AccessToken.Companion.isCurrentAccessTokenActive();
        }

        private final DialogFeature getFeature(Class class0) {
            if(ShareLinkContent.class.isAssignableFrom(class0)) {
                return ShareDialogFeature.SHARE_DIALOG;
            }
            if(SharePhotoContent.class.isAssignableFrom(class0)) {
                return ShareDialogFeature.PHOTOS;
            }
            if(ShareVideoContent.class.isAssignableFrom(class0)) {
                return ShareDialogFeature.VIDEO;
            }
            if(ShareMediaContent.class.isAssignableFrom(class0)) {
                return ShareDialogFeature.MULTIMEDIA;
            }
            if(ShareCameraEffectContent.class.isAssignableFrom(class0)) {
                return CameraEffectFeature.SHARE_CAMERA_EFFECT;
            }
            return ShareStoryContent.class.isAssignableFrom(class0) ? ShareStoryFeature.SHARE_STORY_ASSET : null;
        }

        private final void show(FragmentWrapper fragmentWrapper0, ShareContent shareContent0) {
            new ShareDialog(fragmentWrapper0, 0, 2, null).show(shareContent0);
        }

        public void show(@NotNull Activity activity0, @NotNull ShareContent shareContent0) {
            q.g(activity0, "activity");
            q.g(shareContent0, "shareContent");
            new ShareDialog(activity0).show(shareContent0);
        }

        public void show(@NotNull Fragment fragment0, @NotNull ShareContent shareContent0) {
            q.g(fragment0, "fragment");
            q.g(shareContent0, "shareContent");
            this.show(new FragmentWrapper(fragment0), shareContent0);
        }

        public void show(@NotNull I i0, @NotNull ShareContent shareContent0) {
            q.g(i0, "fragment");
            q.g(shareContent0, "shareContent");
            this.show(new FragmentWrapper(i0), shareContent0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u001A0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001A\u00020\r2\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000F\u001A\u00020\rH\u0016J\u001A\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001A\u0010\u0006\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$FeedHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class FeedHandler extends ModeHandler {
        @NotNull
        private Object mode;

        public FeedHandler() {
            this.mode = Mode.FEED;
        }

        public boolean canShow(@NotNull ShareContent shareContent0, boolean z) {
            q.g(shareContent0, "content");
            return shareContent0 instanceof ShareLinkContent || shareContent0 instanceof ShareFeedContent;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ShareContent)object0), z);
        }

        @Nullable
        public AppCall createAppCall(@NotNull ShareContent shareContent0) {
            Bundle bundle0;
            q.g(shareContent0, "content");
            Activity activity0 = ShareDialog.this.getActivityContext();
            ShareDialog.this.logDialogShare(activity0, shareContent0, Mode.FEED);
            AppCall appCall0 = ShareDialog.this.createBaseAppCall();
            if(shareContent0 instanceof ShareLinkContent) {
                ShareContentValidation.validateForWebShare(shareContent0);
                bundle0 = WebDialogParameters.createForFeed(((ShareLinkContent)shareContent0));
            }
            else if(shareContent0 instanceof ShareFeedContent) {
                bundle0 = WebDialogParameters.createForFeed(((ShareFeedContent)shareContent0));
            }
            else {
                return null;
            }
            DialogPresenter.setupAppCallForWebDialog(appCall0, "feed", bundle0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ShareContent)object0));
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        @NotNull
        public Object getMode() {
            return this.mode;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public void setMode(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.mode = object0;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$Mode;", "", "(Ljava/lang/String;I)V", "AUTOMATIC", "NATIVE", "WEB", "FEED", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED;

        private static final Mode[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u001A0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001A\u00020\r2\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000F\u001A\u00020\rH\u0016J\u001A\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001A\u0010\u0006\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$NativeHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class NativeHandler extends ModeHandler {
        @NotNull
        private Object mode;

        public NativeHandler() {
            this.mode = Mode.NATIVE;
        }

        public boolean canShow(@NotNull ShareContent shareContent0, boolean z) {
            boolean z1;
            q.g(shareContent0, "content");
            if(!(shareContent0 instanceof ShareCameraEffectContent) && !(shareContent0 instanceof ShareStoryContent)) {
                if(z) {
                    z1 = true;
                }
                else {
                    z1 = shareContent0.getShareHashtag() == null ? true : DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
                    if(shareContent0 instanceof ShareLinkContent) {
                        String s = ((ShareLinkContent)shareContent0).getQuote();
                        if(s != null && s.length() != 0) {
                            z1 = z1 && DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                        }
                    }
                }
                if(z1) {
                    Class class0 = shareContent0.getClass();
                    return ShareDialog.Companion.canShowNative(class0);
                }
            }
            return false;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ShareContent)object0), z);
        }

        @Nullable
        public AppCall createAppCall(@NotNull ShareContent shareContent0) {
            q.g(shareContent0, "content");
            Activity activity0 = ShareDialog.this.getActivityContext();
            ShareDialog.this.logDialogShare(activity0, shareContent0, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(shareContent0);
            AppCall appCall0 = ShareDialog.this.createBaseAppCall();
            boolean z = ShareDialog.this.getShouldFailOnDataError();
            Class class0 = shareContent0.getClass();
            DialogFeature dialogFeature0 = ShareDialog.Companion.getFeature(class0);
            if(dialogFeature0 == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(appCall0, new ParameterProvider() {
                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                @Nullable
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(shareContent0.getCallId(), z, this.$shouldFailOnDataError);
                }

                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                @Nullable
                public Bundle getParameters() {
                    return NativeDialogParameters.create(shareContent0.getCallId(), z, this.$shouldFailOnDataError);
                }
            }, dialogFeature0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ShareContent)object0));
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        @NotNull
        public Object getMode() {
            return this.mode;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public void setMode(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.mode = object0;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u001A0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001A\u00020\r2\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000F\u001A\u00020\rH\u0016J\u001A\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016R\u001A\u0010\u0006\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$ShareStoryHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAppCall", "Lcom/facebook/internal/AppCall;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class ShareStoryHandler extends ModeHandler {
        @NotNull
        private Object mode;

        public ShareStoryHandler() {
            this.mode = Mode.NATIVE;
        }

        public boolean canShow(@NotNull ShareContent shareContent0, boolean z) {
            q.g(shareContent0, "content");
            if(shareContent0 instanceof ShareStoryContent) {
                Class class0 = shareContent0.getClass();
                return ShareDialog.Companion.canShowNative(class0);
            }
            return false;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ShareContent)object0), z);
        }

        @Nullable
        public AppCall createAppCall(@NotNull ShareContent shareContent0) {
            q.g(shareContent0, "content");
            ShareContentValidation.validateForStoryShare(shareContent0);
            AppCall appCall0 = ShareDialog.this.createBaseAppCall();
            boolean z = ShareDialog.this.getShouldFailOnDataError();
            Class class0 = shareContent0.getClass();
            DialogFeature dialogFeature0 = ShareDialog.Companion.getFeature(class0);
            if(dialogFeature0 == null) {
                return null;
            }
            DialogPresenter.setupAppCallForNativeDialog(appCall0, new ParameterProvider() {
                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                @Nullable
                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(shareContent0.getCallId(), z, this.$shouldFailOnDataError);
                }

                @Override  // com.facebook.internal.DialogPresenter$ParameterProvider
                @Nullable
                public Bundle getParameters() {
                    return NativeDialogParameters.create(shareContent0.getCallId(), z, this.$shouldFailOnDataError);
                }
            }, dialogFeature0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ShareContent)object0));
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        @NotNull
        public Object getMode() {
            return this.mode;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public void setMode(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.mode = object0;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u001A0\u0001R\u0016\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J \u0010\f\u001A\u00020\r2\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00032\u0006\u0010\u000F\u001A\u00020\rH\u0016J\u0018\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0013H\u0002J\u001A\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u000E\u0010\u000E\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0016J\u001A\u0010\u0016\u001A\u0004\u0018\u00010\u00172\u000E\u0010\u0018\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003H\u0002R\u001A\u0010\u0006\u001A\u00020\u0007X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/widget/ShareDialog$WebShareHandler;", "Lcom/facebook/internal/FacebookDialogBase$ModeHandler;", "Lcom/facebook/internal/FacebookDialogBase;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/Sharer$Result;", "(Lcom/facebook/share/widget/ShareDialog;)V", "mode", "", "getMode", "()Ljava/lang/Object;", "setMode", "(Ljava/lang/Object;)V", "canShow", "", "content", "isBestEffort", "createAndMapAttachments", "Lcom/facebook/share/model/SharePhotoContent;", "callId", "Ljava/util/UUID;", "createAppCall", "Lcom/facebook/internal/AppCall;", "getActionName", "", "shareContent", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class WebShareHandler extends ModeHandler {
        @NotNull
        private Object mode;

        public WebShareHandler() {
            this.mode = Mode.WEB;
        }

        public boolean canShow(@NotNull ShareContent shareContent0, boolean z) {
            q.g(shareContent0, "content");
            return ShareDialog.Companion.canShowWebCheck(shareContent0);
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public boolean canShow(Object object0, boolean z) {
            return this.canShow(((ShareContent)object0), z);
        }

        private final SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent0, UUID uUID0) {
            Builder sharePhotoContent$Builder0 = new Builder().readFrom(sharePhotoContent0);
            ArrayList arrayList0 = new ArrayList();
            ArrayList arrayList1 = new ArrayList();
            int v = sharePhotoContent0.getPhotos().size();
            for(int v1 = 0; v1 < v; ++v1) {
                SharePhoto sharePhoto0 = (SharePhoto)sharePhotoContent0.getPhotos().get(v1);
                Bitmap bitmap0 = sharePhoto0.getBitmap();
                if(bitmap0 != null) {
                    Attachment nativeAppCallAttachmentStore$Attachment0 = NativeAppCallAttachmentStore.createAttachment(uUID0, bitmap0);
                    sharePhoto0 = new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto0).setImageUrl(Uri.parse(nativeAppCallAttachmentStore$Attachment0.getAttachmentUrl())).setBitmap(null).build();
                    arrayList1.add(nativeAppCallAttachmentStore$Attachment0);
                }
                arrayList0.add(sharePhoto0);
            }
            sharePhotoContent$Builder0.setPhotos(arrayList0);
            NativeAppCallAttachmentStore.addAttachments(arrayList1);
            return sharePhotoContent$Builder0.build();
        }

        @Nullable
        public AppCall createAppCall(@NotNull ShareContent shareContent0) {
            Bundle bundle0;
            q.g(shareContent0, "content");
            Activity activity0 = ShareDialog.this.getActivityContext();
            ShareDialog.this.logDialogShare(activity0, shareContent0, Mode.WEB);
            AppCall appCall0 = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(shareContent0);
            if(shareContent0 instanceof ShareLinkContent) {
                bundle0 = WebDialogParameters.create(((ShareLinkContent)shareContent0));
            }
            else if(shareContent0 instanceof SharePhotoContent) {
                bundle0 = WebDialogParameters.create(this.createAndMapAttachments(((SharePhotoContent)shareContent0), appCall0.getCallId()));
            }
            else {
                return null;
            }
            DialogPresenter.setupAppCallForWebDialog(appCall0, this.getActionName(shareContent0), bundle0);
            return appCall0;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public AppCall createAppCall(Object object0) {
            return this.createAppCall(((ShareContent)object0));
        }

        // 去混淆评级： 低(20)
        private final String getActionName(ShareContent shareContent0) {
            return shareContent0 instanceof ShareLinkContent || shareContent0 instanceof SharePhotoContent ? "share" : null;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        @NotNull
        public Object getMode() {
            return this.mode;
        }

        @Override  // com.facebook.internal.FacebookDialogBase$ModeHandler
        public void setMode(@NotNull Object object0) {
            q.g(object0, "<set-?>");
            this.mode = object0;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Mode.values().length];
            try {
                arr_v[Mode.AUTOMATIC.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Mode.WEB.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Mode.NATIVE.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_REQUEST_CODE = 0;
    @NotNull
    private static final String FEED_DIALOG = "feed";
    private static final String TAG = null;
    @NotNull
    private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
    @NotNull
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    @NotNull
    private final List orderedModeHandlers;
    private boolean shouldFailOnDataError;

    static {
        ShareDialog.Companion = new Companion(null);
        ShareDialog.TAG = "ShareDialog";
        ShareDialog.DEFAULT_REQUEST_CODE = RequestCodeOffset.Share.toRequestCode();
    }

    public ShareDialog(int v) {
        super(v);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = k.e(new ModeHandler[]{new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this)});
        ShareInternalUtility.registerStaticShareCallback(v);
    }

    public ShareDialog(int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            v = ShareDialog.DEFAULT_REQUEST_CODE;
        }
        this(v);
    }

    public ShareDialog(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        this(activity0, ShareDialog.DEFAULT_REQUEST_CODE);
    }

    public ShareDialog(@NotNull Activity activity0, int v) {
        q.g(activity0, "activity");
        super(activity0, v);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = k.e(new ModeHandler[]{new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this)});
        ShareInternalUtility.registerStaticShareCallback(v);
    }

    public ShareDialog(@NotNull Fragment fragment0) {
        q.g(fragment0, "fragment");
        this(new FragmentWrapper(fragment0), 0, 2, null);
    }

    public ShareDialog(@NotNull Fragment fragment0, int v) {
        q.g(fragment0, "fragment");
        this(new FragmentWrapper(fragment0), v);
    }

    public ShareDialog(@NotNull I i0) {
        q.g(i0, "fragment");
        this(new FragmentWrapper(i0), 0, 2, null);
    }

    public ShareDialog(@NotNull I i0, int v) {
        q.g(i0, "fragment");
        this(new FragmentWrapper(i0), v);
    }

    public ShareDialog(@NotNull FragmentWrapper fragmentWrapper0, int v) {
        q.g(fragmentWrapper0, "fragmentWrapper");
        super(fragmentWrapper0, v);
        this.isAutomaticMode = true;
        this.orderedModeHandlers = k.e(new ModeHandler[]{new NativeHandler(this), new FeedHandler(this), new WebShareHandler(this), new CameraEffectHandler(this), new ShareStoryHandler(this)});
        ShareInternalUtility.registerStaticShareCallback(v);
    }

    public ShareDialog(FragmentWrapper fragmentWrapper0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            v = ShareDialog.DEFAULT_REQUEST_CODE;
        }
        this(fragmentWrapper0, v);
    }

    public static boolean canShow(@NotNull Class class0) {
        return ShareDialog.Companion.canShow(class0);
    }

    public boolean canShow(@NotNull ShareContent shareContent0, @NotNull Mode shareDialog$Mode0) {
        q.g(shareContent0, "content");
        q.g(shareDialog$Mode0, "mode");
        if(shareDialog$Mode0 == Mode.AUTOMATIC) {
            shareDialog$Mode0 = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        return this.canShowImpl(shareContent0, shareDialog$Mode0);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public AppCall createBaseAppCall() {
        return new AppCall(this.getRequestCode(), null, 2, null);
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    @NotNull
    public List getOrderedModeHandlers() {
        return this.orderedModeHandlers;
    }

    @Override  // com.facebook.share.Sharer
    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    private final void logDialogShare(Context context0, ShareContent shareContent0, Mode shareDialog$Mode0) {
        String s1;
        if(this.isAutomaticMode) {
            shareDialog$Mode0 = Mode.AUTOMATIC;
        }
        String s = "unknown";
        switch(WhenMappings.$EnumSwitchMapping$0[shareDialog$Mode0.ordinal()]) {
            case 1: {
                s1 = "automatic";
                break;
            }
            case 2: {
                s1 = "web";
                break;
            }
            case 3: {
                s1 = "native";
                break;
            }
            default: {
                s1 = "unknown";
            }
        }
        Class class0 = shareContent0.getClass();
        DialogFeature dialogFeature0 = ShareDialog.Companion.getFeature(class0);
        if(dialogFeature0 == ShareDialogFeature.SHARE_DIALOG) {
            s = "status";
        }
        else if(dialogFeature0 == ShareDialogFeature.PHOTOS) {
            s = "photo";
        }
        else if(dialogFeature0 == ShareDialogFeature.VIDEO) {
            s = "video";
        }
        String s2 = FacebookSdk.getApplicationId();
        InternalAppEventsLogger.Companion.createInstance(context0, s2).logEventImplicitly("fb_share_dialog_show", Y.c("fb_share_dialog_show", s1, "fb_share_dialog_content_type", s));
    }

    @Override  // com.facebook.internal.FacebookDialogBase
    public void registerCallbackImpl(@NotNull CallbackManagerImpl callbackManagerImpl0, @NotNull FacebookCallback facebookCallback0) {
        q.g(callbackManagerImpl0, "callbackManager");
        q.g(facebookCallback0, "callback");
        ShareInternalUtility.registerSharerCallback(this.getRequestCode(), callbackManagerImpl0, facebookCallback0);
    }

    @Override  // com.facebook.share.Sharer
    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    public static void show(@NotNull Activity activity0, @NotNull ShareContent shareContent0) {
        ShareDialog.Companion.show(activity0, shareContent0);
    }

    public static void show(@NotNull Fragment fragment0, @NotNull ShareContent shareContent0) {
        ShareDialog.Companion.show(fragment0, shareContent0);
    }

    public static void show(@NotNull I i0, @NotNull ShareContent shareContent0) {
        ShareDialog.Companion.show(i0, shareContent0);
    }

    public void show(@NotNull ShareContent shareContent0, @NotNull Mode shareDialog$Mode0) {
        q.g(shareContent0, "content");
        q.g(shareDialog$Mode0, "mode");
        this.isAutomaticMode = shareDialog$Mode0 == Mode.AUTOMATIC;
        if(shareDialog$Mode0 == Mode.AUTOMATIC) {
            shareDialog$Mode0 = FacebookDialogBase.BASE_AUTOMATIC_MODE;
        }
        this.showImpl(shareContent0, shareDialog$Mode0);
    }
}

