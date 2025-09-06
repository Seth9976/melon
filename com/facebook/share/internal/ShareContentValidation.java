package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0004EFGHB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001A\u00020\u00062\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\u00062\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\t\u0010\bJ!\u0010\n\u001A\u00020\u00062\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\n\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u000B\u0010\bJ!\u0010\f\u001A\u00020\u00062\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\f\u0010\bJ)\u0010\u000F\u001A\u00020\u00062\u0010\u0010\u0005\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0013\u001A\u00020\u00062\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001B\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001F\u001A\u00020\u00062\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0002\u00A2\u0006\u0004\b\u001F\u0010 J\u001F\u0010!\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010#\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b#\u0010\"J\u001F\u0010$\u001A\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b$\u0010\"J\u001F\u0010\'\u001A\u00020\u00062\u0006\u0010&\u001A\u00020%2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\'\u0010(J!\u0010+\u001A\u00020\u00062\b\u0010*\u001A\u0004\u0018\u00010)2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010/\u001A\u00020\u00062\u0006\u0010.\u001A\u00020-2\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b/\u00100J\'\u00103\u001A\u00020\u00062\u000E\u00102\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003012\u0006\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b3\u00104J\u0017\u00107\u001A\u00020\u00062\u0006\u00106\u001A\u000205H\u0002\u00A2\u0006\u0004\b7\u00108J\u0019\u0010;\u001A\u00020\u00062\b\u0010:\u001A\u0004\u0018\u000109H\u0002\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010>\u001A\u00020\u00062\u0006\u0010:\u001A\u00020=H\u0002\u00A2\u0006\u0004\b>\u0010?R\u0014\u0010@\u001A\u00020\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001A\u00020\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010C\u001A\u00020\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bC\u0010AR\u0014\u0010D\u001A\u00020\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bD\u0010A\u00A8\u0006I"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation;", "", "<init>", "()V", "Lcom/facebook/share/model/ShareContent;", "content", "Lie/H;", "validateForMessage", "(Lcom/facebook/share/model/ShareContent;)V", "validateForNativeShare", "validateForWebShare", "validateForApiShare", "validateForStoryShare", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "validator", "validate", "(Lcom/facebook/share/model/ShareContent;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/ShareStoryContent;", "storyContent", "validateStoryContent", "(Lcom/facebook/share/model/ShareStoryContent;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/ShareLinkContent;", "linkContent", "validateLinkContent", "(Lcom/facebook/share/model/ShareLinkContent;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/SharePhotoContent;", "photoContent", "validatePhotoContent", "(Lcom/facebook/share/model/SharePhotoContent;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/SharePhoto;", "photo", "validatePhoto", "(Lcom/facebook/share/model/SharePhoto;)V", "validatePhotoForApi", "(Lcom/facebook/share/model/SharePhoto;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "validatePhotoForNativeDialog", "validatePhotoForWebDialog", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "validateVideoContent", "(Lcom/facebook/share/model/ShareVideoContent;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/ShareVideo;", "video", "validateVideo", "(Lcom/facebook/share/model/ShareVideo;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "validateMediaContent", "(Lcom/facebook/share/model/ShareMediaContent;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/ShareMedia;", "medium", "validateMedium", "(Lcom/facebook/share/model/ShareMedia;Lcom/facebook/share/internal/ShareContentValidation$Validator;)V", "Lcom/facebook/share/model/ShareCameraEffectContent;", "cameraEffectContent", "validateCameraEffectContent", "(Lcom/facebook/share/model/ShareCameraEffectContent;)V", "Lcom/facebook/share/model/ShareMessengerActionButton;", "button", "validateShareMessengerActionButton", "(Lcom/facebook/share/model/ShareMessengerActionButton;)V", "Lcom/facebook/share/model/ShareMessengerURLActionButton;", "validateShareMessengerURLActionButton", "(Lcom/facebook/share/model/ShareMessengerURLActionButton;)V", "webShareValidator", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "defaultValidator", "apiValidator", "storyValidator", "ApiValidator", "StoryShareValidator", "Validator", "WebShareValidator", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareContentValidation {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000BJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\u000EJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0007\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$ApiValidator;", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "<init>", "()V", "Lcom/facebook/share/model/SharePhoto;", "photo", "Lie/H;", "validate", "(Lcom/facebook/share/model/SharePhoto;)V", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "(Lcom/facebook/share/model/ShareVideoContent;)V", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "(Lcom/facebook/share/model/ShareMediaContent;)V", "Lcom/facebook/share/model/ShareLinkContent;", "linkContent", "(Lcom/facebook/share/model/ShareLinkContent;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class ApiValidator extends Validator {
        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull ShareLinkContent shareLinkContent0) {
            q.g(shareLinkContent0, "linkContent");
            if(!Utility.isNullOrEmpty(shareLinkContent0.getQuote())) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }

        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull ShareMediaContent shareMediaContent0) {
            q.g(shareMediaContent0, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull SharePhoto sharePhoto0) {
            q.g(sharePhoto0, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForApi(sharePhoto0, this);
        }

        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull ShareVideoContent shareVideoContent0) {
            q.g(shareVideoContent0, "videoContent");
            if(!Utility.isNullOrEmpty(shareVideoContent0.getPlaceId())) {
                throw new FacebookException("Cannot share video content with place IDs using the share api");
            }
            if(!Utility.isNullOrEmpty(shareVideoContent0.getPeopleIds())) {
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            }
            if(!Utility.isNullOrEmpty(shareVideoContent0.getRef())) {
                throw new FacebookException("Cannot share video content with referrer URL using the share api");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$StoryShareValidator;", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "<init>", "()V", "Lcom/facebook/share/model/ShareStoryContent;", "storyContent", "Lie/H;", "validate", "(Lcom/facebook/share/model/ShareStoryContent;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class StoryShareValidator extends Validator {
        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@Nullable ShareStoryContent shareStoryContent0) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent0, this);
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000BJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\u000EJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0007\u0010\u0011J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u0014J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0007\u0010\u0017J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0007\u0010\u001AJ\u001F\u0010\u0007\u001A\u00020\u00062\u000E\u0010\u001C\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001BH\u0016¢\u0006\u0004\b\u0007\u0010\u001DJ\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0016¢\u0006\u0004\b\u0007\u0010 ¨\u0006!"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$Validator;", "", "<init>", "()V", "Lcom/facebook/share/model/ShareLinkContent;", "linkContent", "Lie/H;", "validate", "(Lcom/facebook/share/model/ShareLinkContent;)V", "Lcom/facebook/share/model/SharePhotoContent;", "photoContent", "(Lcom/facebook/share/model/SharePhotoContent;)V", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "(Lcom/facebook/share/model/ShareVideoContent;)V", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "(Lcom/facebook/share/model/ShareMediaContent;)V", "Lcom/facebook/share/model/ShareCameraEffectContent;", "cameraEffectContent", "(Lcom/facebook/share/model/ShareCameraEffectContent;)V", "Lcom/facebook/share/model/SharePhoto;", "photo", "(Lcom/facebook/share/model/SharePhoto;)V", "Lcom/facebook/share/model/ShareVideo;", "video", "(Lcom/facebook/share/model/ShareVideo;)V", "Lcom/facebook/share/model/ShareMedia;", "medium", "(Lcom/facebook/share/model/ShareMedia;)V", "Lcom/facebook/share/model/ShareStoryContent;", "storyContent", "(Lcom/facebook/share/model/ShareStoryContent;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static class Validator {
        public void validate(@NotNull ShareCameraEffectContent shareCameraEffectContent0) {
            q.g(shareCameraEffectContent0, "cameraEffectContent");
            ShareContentValidation.INSTANCE.validateCameraEffectContent(shareCameraEffectContent0);
        }

        public void validate(@NotNull ShareLinkContent shareLinkContent0) {
            q.g(shareLinkContent0, "linkContent");
            ShareContentValidation.INSTANCE.validateLinkContent(shareLinkContent0, this);
        }

        public void validate(@NotNull ShareMedia shareMedia0) {
            q.g(shareMedia0, "medium");
            ShareContentValidation.validateMedium(shareMedia0, this);
        }

        public void validate(@NotNull ShareMediaContent shareMediaContent0) {
            q.g(shareMediaContent0, "mediaContent");
            ShareContentValidation.INSTANCE.validateMediaContent(shareMediaContent0, this);
        }

        public void validate(@NotNull SharePhoto sharePhoto0) {
            q.g(sharePhoto0, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForNativeDialog(sharePhoto0, this);
        }

        public void validate(@NotNull SharePhotoContent sharePhotoContent0) {
            q.g(sharePhotoContent0, "photoContent");
            ShareContentValidation.INSTANCE.validatePhotoContent(sharePhotoContent0, this);
        }

        public void validate(@Nullable ShareStoryContent shareStoryContent0) {
            ShareContentValidation.INSTANCE.validateStoryContent(shareStoryContent0, this);
        }

        public void validate(@Nullable ShareVideo shareVideo0) {
            ShareContentValidation.INSTANCE.validateVideo(shareVideo0, this);
        }

        public void validate(@NotNull ShareVideoContent shareVideoContent0) {
            q.g(shareVideoContent0, "videoContent");
            ShareContentValidation.INSTANCE.validateVideoContent(shareVideoContent0, this);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000BJ\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$WebShareValidator;", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "<init>", "()V", "Lcom/facebook/share/model/ShareVideoContent;", "videoContent", "Lie/H;", "validate", "(Lcom/facebook/share/model/ShareVideoContent;)V", "Lcom/facebook/share/model/ShareMediaContent;", "mediaContent", "(Lcom/facebook/share/model/ShareMediaContent;)V", "Lcom/facebook/share/model/SharePhoto;", "photo", "(Lcom/facebook/share/model/SharePhoto;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class WebShareValidator extends Validator {
        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull ShareMediaContent shareMediaContent0) {
            q.g(shareMediaContent0, "mediaContent");
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull SharePhoto sharePhoto0) {
            q.g(sharePhoto0, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForWebDialog(sharePhoto0, this);
        }

        @Override  // com.facebook.share.internal.ShareContentValidation$Validator
        public void validate(@NotNull ShareVideoContent shareVideoContent0) {
            q.g(shareVideoContent0, "videoContent");
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }
    }

    @NotNull
    public static final ShareContentValidation INSTANCE;
    @NotNull
    private static final Validator apiValidator;
    @NotNull
    private static final Validator defaultValidator;
    @NotNull
    private static final Validator storyValidator;
    @NotNull
    private static final Validator webShareValidator;

    static {
        ShareContentValidation.INSTANCE = new ShareContentValidation();
        ShareContentValidation.webShareValidator = new WebShareValidator();
        ShareContentValidation.defaultValidator = new Validator();
        ShareContentValidation.apiValidator = new ApiValidator();
        ShareContentValidation.storyValidator = new StoryShareValidator();
    }

    private final void validate(ShareContent shareContent0, Validator shareContentValidation$Validator0) {
        if(shareContent0 == null) {
            throw new FacebookException("Must provide non-null content to share");
        }
        if(shareContent0 instanceof ShareLinkContent) {
            shareContentValidation$Validator0.validate(((ShareLinkContent)shareContent0));
            return;
        }
        if(shareContent0 instanceof SharePhotoContent) {
            shareContentValidation$Validator0.validate(((SharePhotoContent)shareContent0));
            return;
        }
        if(shareContent0 instanceof ShareVideoContent) {
            shareContentValidation$Validator0.validate(((ShareVideoContent)shareContent0));
            return;
        }
        if(shareContent0 instanceof ShareMediaContent) {
            shareContentValidation$Validator0.validate(((ShareMediaContent)shareContent0));
            return;
        }
        if(shareContent0 instanceof ShareCameraEffectContent) {
            shareContentValidation$Validator0.validate(((ShareCameraEffectContent)shareContent0));
            return;
        }
        if(shareContent0 instanceof ShareStoryContent) {
            shareContentValidation$Validator0.validate(((ShareStoryContent)shareContent0));
        }
    }

    private final void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent0) {
        if(Utility.isNullOrEmpty(shareCameraEffectContent0.getEffectId())) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    public static final void validateForApiShare(@Nullable ShareContent shareContent0) {
        ShareContentValidation.INSTANCE.validate(shareContent0, ShareContentValidation.apiValidator);
    }

    public static final void validateForMessage(@Nullable ShareContent shareContent0) {
        ShareContentValidation.INSTANCE.validate(shareContent0, ShareContentValidation.defaultValidator);
    }

    public static final void validateForNativeShare(@Nullable ShareContent shareContent0) {
        ShareContentValidation.INSTANCE.validate(shareContent0, ShareContentValidation.defaultValidator);
    }

    public static final void validateForStoryShare(@Nullable ShareContent shareContent0) {
        ShareContentValidation.INSTANCE.validate(shareContent0, ShareContentValidation.storyValidator);
    }

    public static final void validateForWebShare(@Nullable ShareContent shareContent0) {
        ShareContentValidation.INSTANCE.validate(shareContent0, ShareContentValidation.webShareValidator);
    }

    private final void validateLinkContent(ShareLinkContent shareLinkContent0, Validator shareContentValidation$Validator0) {
        Uri uri0 = shareLinkContent0.getContentUrl();
        if(uri0 != null && !Utility.isWebUri(uri0)) {
            throw new FacebookException("Content Url must be an http:// or https:// url");
        }
    }

    private final void validateMediaContent(ShareMediaContent shareMediaContent0, Validator shareContentValidation$Validator0) {
        List list0 = shareMediaContent0.getMedia();
        if(list0 == null || list0.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        }
        if(list0.size() > 6) {
            throw new FacebookException("Cannot add more than 6 media.");
        }
        for(Object object0: list0) {
            shareContentValidation$Validator0.validate(((ShareMedia)object0));
        }
    }

    public static final void validateMedium(@NotNull ShareMedia shareMedia0, @NotNull Validator shareContentValidation$Validator0) {
        q.g(shareMedia0, "medium");
        q.g(shareContentValidation$Validator0, "validator");
        if(shareMedia0 instanceof SharePhoto) {
            shareContentValidation$Validator0.validate(((SharePhoto)shareMedia0));
            return;
        }
        if(!(shareMedia0 instanceof ShareVideo)) {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{shareMedia0.getClass().getSimpleName()}, 1)));
        }
        shareContentValidation$Validator0.validate(((ShareVideo)shareMedia0));
    }

    private final void validatePhoto(SharePhoto sharePhoto0) {
        if(sharePhoto0 == null) {
            throw new FacebookException("Cannot share a null SharePhoto");
        }
        if(sharePhoto0.getBitmap() == null && sharePhoto0.getImageUrl() == null) {
            throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
        }
    }

    private final void validatePhotoContent(SharePhotoContent sharePhotoContent0, Validator shareContentValidation$Validator0) {
        List list0 = sharePhotoContent0.getPhotos();
        if(list0 == null || list0.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        }
        if(list0.size() > 6) {
            throw new FacebookException("Cannot add more than 6 photos.");
        }
        for(Object object0: list0) {
            shareContentValidation$Validator0.validate(((SharePhoto)object0));
        }
    }

    private final void validatePhotoForApi(SharePhoto sharePhoto0, Validator shareContentValidation$Validator0) {
        this.validatePhoto(sharePhoto0);
        if(sharePhoto0.getBitmap() == null && Utility.isWebUri(sharePhoto0.getImageUrl())) {
            throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }

    private final void validatePhotoForNativeDialog(SharePhoto sharePhoto0, Validator shareContentValidation$Validator0) {
        this.validatePhotoForApi(sharePhoto0, shareContentValidation$Validator0);
        if(sharePhoto0.getBitmap() == null && Utility.isWebUri(sharePhoto0.getImageUrl())) {
            return;
        }
        Validate.hasContentProvider(FacebookSdk.getApplicationContext());
    }

    private final void validatePhotoForWebDialog(SharePhoto sharePhoto0, Validator shareContentValidation$Validator0) {
        this.validatePhoto(sharePhoto0);
    }

    private final void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton0) {
        if(shareMessengerActionButton0 != null) {
            if(Utility.isNullOrEmpty(shareMessengerActionButton0.getTitle())) {
                throw new FacebookException("Must specify title for ShareMessengerActionButton");
            }
            if(shareMessengerActionButton0 instanceof ShareMessengerURLActionButton) {
                this.validateShareMessengerURLActionButton(((ShareMessengerURLActionButton)shareMessengerActionButton0));
            }
        }
    }

    private final void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton0) {
        if(shareMessengerURLActionButton0.getUrl() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    private final void validateStoryContent(ShareStoryContent shareStoryContent0, Validator shareContentValidation$Validator0) {
        if(shareStoryContent0 == null || shareStoryContent0.getBackgroundAsset() == null && shareStoryContent0.getStickerAsset() == null) {
            throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if(shareStoryContent0.getBackgroundAsset() != null) {
            shareContentValidation$Validator0.validate(shareStoryContent0.getBackgroundAsset());
        }
        if(shareStoryContent0.getStickerAsset() != null) {
            shareContentValidation$Validator0.validate(shareStoryContent0.getStickerAsset());
        }
    }

    private final void validateVideo(ShareVideo shareVideo0, Validator shareContentValidation$Validator0) {
        if(shareVideo0 == null) {
            throw new FacebookException("Cannot share a null ShareVideo");
        }
        Uri uri0 = shareVideo0.getLocalUrl();
        if(uri0 == null) {
            throw new FacebookException("ShareVideo does not have a LocalUrl specified");
        }
        if(!Utility.isContentUri(uri0) && !Utility.isFileUri(uri0)) {
            throw new FacebookException("ShareVideo must reference a video that is on the device");
        }
    }

    private final void validateVideoContent(ShareVideoContent shareVideoContent0, Validator shareContentValidation$Validator0) {
        shareContentValidation$Validator0.validate(shareVideoContent0.getVideo());
        SharePhoto sharePhoto0 = shareVideoContent0.getPreviewPhoto();
        if(sharePhoto0 != null) {
            shareContentValidation$Validator0.validate(sharePhoto0);
        }
    }
}

