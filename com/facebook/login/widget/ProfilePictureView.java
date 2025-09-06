package com.facebook.login.widget;

import Tf.v;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import androidx.media3.session.a0;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest.Builder;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R.dimen;
import com.facebook.login.R.drawable;
import com.facebook.login.R.styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 g2\u00020\u0001:\u0002ghB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u0004\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\b\u0010\r\u001A\u0004\u0018\u00010\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\t2\u0006\u0010\u001A\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u000EH\u0003\u00A2\u0006\u0004\b%\u0010$J\u0017\u0010&\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u0006H\u0003\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020\u000E2\u0006\u0010(\u001A\u00020\u0015H\u0003\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\u000EH\u0003\u00A2\u0006\u0004\b-\u0010$J\u0019\u0010/\u001A\u00020\u000E2\b\u0010.\u001A\u0004\u0018\u00010\fH\u0003\u00A2\u0006\u0004\b/\u0010\u0010J\u0017\u00101\u001A\u00020\u000E2\u0006\u00100\u001A\u00020\u0015H\u0003\u00A2\u0006\u0004\b1\u0010*J\u0017\u00105\u001A\u0002042\u0006\u00103\u001A\u000202H\u0002\u00A2\u0006\u0004\b5\u00106J\u0019\u00109\u001A\u00020\u000E2\b\u00108\u001A\u0004\u0018\u000107H\u0003\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\u0015H\u0003\u00A2\u0006\u0004\b;\u0010,J\u0017\u0010=\u001A\u00020\t2\u0006\u0010<\u001A\u00020\u0015H\u0003\u00A2\u0006\u0004\b=\u0010>R\u0014\u0010@\u001A\u00020?8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010CR\u0018\u0010E\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001A\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010FR\u0018\u0010L\u001A\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR.\u0010O\u001A\u0004\u0018\u0001022\b\u0010N\u001A\u0004\u0018\u0001028\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\bO\u0010P\u001A\u0004\bQ\u0010R\"\u0004\bS\u0010TR*\u0010U\u001A\u00020\u00152\u0006\u0010N\u001A\u00020\u00158\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bU\u0010,\"\u0004\bW\u0010*R$\u0010Y\u001A\u0004\u0018\u00010X8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bY\u0010Z\u001A\u0004\b[\u0010\\\"\u0004\b]\u0010^R*\u0010_\u001A\u00020\t2\u0006\u0010N\u001A\u00020\t8\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\b_\u0010C\u001A\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010f\u001A\u00020\u00152\u0006\u0010N\u001A\u00020\u00158F@FX\u0086\u000E\u00A2\u0006\f\u001A\u0004\bd\u0010,\"\u0004\be\u0010*\u00A8\u0006i"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/Bitmap;", "inputBitmap", "Lie/H;", "setDefaultProfilePicture", "(Landroid/graphics/Bitmap;)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", "state", "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "onDetachedFromWindow", "()V", "initialize", "parseAttributes", "(Landroid/util/AttributeSet;)V", "force", "refreshImage", "(Z)V", "isUnspecifiedDimensions", "()Z", "setBlankProfilePicture", "imageBitmap", "setImageBitmap", "allowCachedResponse", "sendImageRequest", "", "accessToken", "Landroid/net/Uri;", "getProfilePictureUri", "(Ljava/lang/String;)Landroid/net/Uri;", "Lcom/facebook/internal/ImageResponse;", "response", "processResponse", "(Lcom/facebook/internal/ImageResponse;)V", "updateImageQueryParameters", "forcePreset", "getPresetSizeInPixels", "(Z)I", "Landroid/widget/ImageView;", "image", "Landroid/widget/ImageView;", "queryHeight", "I", "queryWidth", "imageContents", "Landroid/graphics/Bitmap;", "Lcom/facebook/internal/ImageRequest;", "lastRequest", "Lcom/facebook/internal/ImageRequest;", "customizedDefaultProfilePicture", "Lcom/facebook/ProfileTracker;", "profileTracker", "Lcom/facebook/ProfileTracker;", "value", "profileId", "Ljava/lang/String;", "getProfileId", "()Ljava/lang/String;", "setProfileId", "(Ljava/lang/String;)V", "isCropped", "Z", "setCropped", "Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "onErrorListener", "Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "getOnErrorListener", "()Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "setOnErrorListener", "(Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;)V", "presetSize", "getPresetSize", "()I", "setPresetSize", "(I)V", "getShouldUpdateOnProfileChange", "setShouldUpdateOnProfileChange", "shouldUpdateOnProfileChange", "Companion", "OnErrorListener", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProfilePictureView extends FrameLayout {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$Companion;", "", "()V", "BITMAP_HEIGHT_KEY", "", "BITMAP_KEY", "BITMAP_WIDTH_KEY", "CUSTOM", "", "IS_CROPPED_DEFAULT_VALUE", "", "IS_CROPPED_KEY", "LARGE", "MIN_SIZE", "NORMAL", "PENDING_REFRESH_KEY", "PRESET_SIZE_KEY", "PROFILE_ID_KEY", "SMALL", "SUPER_STATE_KEY", "TAG", "getTAG", "()Ljava/lang/String;", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getTAG() {
            return "ProfilePictureView";
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "", "Lcom/facebook/FacebookException;", "error", "Lie/H;", "onError", "(Lcom/facebook/FacebookException;)V", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface OnErrorListener {
        void onError(@NotNull FacebookException arg1);
    }

    @NotNull
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    @NotNull
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    @NotNull
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    @NotNull
    public static final Companion Companion = null;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    @NotNull
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    @NotNull
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    @NotNull
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    @NotNull
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    @NotNull
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    @NotNull
    private static final String TAG;
    @Nullable
    private Bitmap customizedDefaultProfilePicture;
    @NotNull
    private final ImageView image;
    @Nullable
    private Bitmap imageContents;
    private boolean isCropped;
    @Nullable
    private ImageRequest lastRequest;
    @Nullable
    private OnErrorListener onErrorListener;
    private int presetSize;
    @Nullable
    private String profileId;
    @Nullable
    private ProfileTracker profileTracker;
    private int queryHeight;
    private int queryWidth;

    static {
        ProfilePictureView.Companion = new Companion(null);
        ProfilePictureView.TAG = "ProfilePictureView";
    }

    public ProfilePictureView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.image = new ImageView(this.getContext());
        this.isCropped = true;
        this.presetSize = -1;
        this.initialize();
    }

    public ProfilePictureView(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0);
        this.image = new ImageView(this.getContext());
        this.isCropped = true;
        this.presetSize = -1;
        this.initialize();
        this.parseAttributes(attributeSet0);
    }

    public ProfilePictureView(@NotNull Context context0, @NotNull AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        q.g(attributeSet0, "attrs");
        super(context0, attributeSet0, v);
        this.image = new ImageView(this.getContext());
        this.isCropped = true;
        this.presetSize = -1;
        this.initialize();
        this.parseAttributes(attributeSet0);
    }

    public static void a(ProfilePictureView profilePictureView0, ImageResponse imageResponse0) {
        ProfilePictureView.sendImageRequest$lambda$2(profilePictureView0, imageResponse0);
    }

    public static final String access$getTAG$cp() [...] // 潜在的解密器

    @Nullable
    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSize;
    }

    private final int getPresetSizeInPixels(boolean z) {
        int v1;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            int v = this.presetSize;
            if(v == -1 && !z) {
                return 0;
            }
            switch(v) {
                case -4: {
                    v1 = dimen.com_facebook_profilepictureview_preset_size_large;
                    break;
                }
                case -3: {
                    v1 = dimen.com_facebook_profilepictureview_preset_size_normal;
                    break;
                }
                case -2: {
                    v1 = dimen.com_facebook_profilepictureview_preset_size_small;
                    break;
                }
                case -1: {
                    v1 = dimen.com_facebook_profilepictureview_preset_size_normal;
                    break;
                }
                default: {
                    return 0;
                }
            }
            return this.getResources().getDimensionPixelSize(v1);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return 0;
    }

    @Nullable
    public final String getProfileId() {
        return this.profileId;
    }

    private final Uri getProfilePictureUri(String s) {
        Profile profile0 = Profile.Companion.getCurrentProfile();
        return profile0 == null || !AccessToken.Companion.isLoggedInWithInstagram() ? ImageRequest.Companion.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight, s) : profile0.getProfilePictureUri(this.queryWidth, this.queryHeight);
    }

    public final boolean getShouldUpdateOnProfileChange() {
        return this.profileTracker == null ? false : this.profileTracker.isTracking();
    }

    private final void initialize() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.removeAllViews();
            FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(-1, -1);
            this.image.setLayoutParams(frameLayout$LayoutParams0);
            this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.addView(this.image);
            this.profileTracker = new ProfileTracker() {
                @Override  // com.facebook.ProfileTracker
                public void onCurrentProfileChanged(@Nullable Profile profile0, @Nullable Profile profile1) {
                    ProfilePictureView.this.setProfileId((profile1 == null ? null : profile1.getId()));
                    ProfilePictureView.this.refreshImage(true);
                }
            };
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    private final boolean isUnspecifiedDimensions() {
        return this.queryWidth == 0 && this.queryHeight == 0;
    }

    @Override  // android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    @Override  // android.widget.FrameLayout
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.refreshImage(false);
    }

    @Override  // android.widget.FrameLayout
    public void onMeasure(int v, int v1) {
        int v5;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
        int v2 = View.MeasureSpec.getSize(v1);
        int v3 = View.MeasureSpec.getSize(v);
        int v4 = 1;
        if(View.MeasureSpec.getMode(v1) == 0x40000000 || viewGroup$LayoutParams0.height != -2) {
            v5 = 0;
        }
        else {
            v2 = this.getPresetSizeInPixels(true);
            v1 = View.MeasureSpec.makeMeasureSpec(v2, 0x40000000);
            v5 = 1;
        }
        if(View.MeasureSpec.getMode(v) == 0x40000000 || viewGroup$LayoutParams0.width != -2) {
            v4 = v5;
        }
        else {
            v3 = this.getPresetSizeInPixels(true);
            v = View.MeasureSpec.makeMeasureSpec(v3, 0x40000000);
        }
        if(v4 != 0) {
            this.setMeasuredDimension(v3, v2);
            this.measureChildren(v, v1);
            return;
        }
        super.onMeasure(v, v1);
    }

    @Override  // android.view.View
    public void onRestoreInstanceState(@NotNull Parcelable parcelable0) {
        q.g(parcelable0, "state");
        if(!parcelable0.getClass().equals(Bundle.class)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((Bundle)parcelable0).getParcelable("ProfilePictureView_superState"));
        this.setProfileId(((Bundle)parcelable0).getString("ProfilePictureView_profileId"));
        this.setPresetSize(((Bundle)parcelable0).getInt("ProfilePictureView_presetSize"));
        this.setCropped(((Bundle)parcelable0).getBoolean("ProfilePictureView_isCropped"));
        this.queryWidth = ((Bundle)parcelable0).getInt("ProfilePictureView_width");
        this.queryHeight = ((Bundle)parcelable0).getInt("ProfilePictureView_height");
        this.refreshImage(true);
    }

    @Override  // android.view.View
    @NotNull
    public Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = super.onSaveInstanceState();
        Parcelable parcelable1 = new Bundle();
        ((Bundle)parcelable1).putParcelable("ProfilePictureView_superState", parcelable0);
        ((BaseBundle)parcelable1).putString("ProfilePictureView_profileId", this.profileId);
        ((BaseBundle)parcelable1).putInt("ProfilePictureView_presetSize", this.presetSize);
        ((BaseBundle)parcelable1).putBoolean("ProfilePictureView_isCropped", this.isCropped);
        ((BaseBundle)parcelable1).putInt("ProfilePictureView_width", this.queryWidth);
        ((BaseBundle)parcelable1).putInt("ProfilePictureView_height", this.queryHeight);
        ((BaseBundle)parcelable1).putBoolean("ProfilePictureView_refresh", this.lastRequest != null);
        return parcelable1;
    }

    private final void parseAttributes(AttributeSet attributeSet0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, styleable.com_facebook_profile_picture_view);
            q.f(typedArray0, "context.obtainStyledAttr…ook_profile_picture_view)");
            this.setPresetSize(typedArray0.getInt(styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
            this.setCropped(typedArray0.getBoolean(styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true));
            typedArray0.recycle();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void processResponse(ImageResponse imageResponse0) {
        if(!CrashShieldHandler.isObjectCrashing(this) && imageResponse0 != null) {
            try {
                if(q.b(imageResponse0.getRequest(), this.lastRequest)) {
                    this.lastRequest = null;
                    Bitmap bitmap0 = imageResponse0.getBitmap();
                    Exception exception0 = imageResponse0.getError();
                    if(exception0 != null) {
                        OnErrorListener profilePictureView$OnErrorListener0 = this.onErrorListener;
                        if(profilePictureView$OnErrorListener0 != null) {
                            profilePictureView$OnErrorListener0.onError(new FacebookException("Error in downloading profile picture for profileId: " + this.profileId, exception0));
                            return;
                        }
                        Logger.Companion.log(LoggingBehavior.REQUESTS, 6, "ProfilePictureView", exception0.toString());
                        return;
                    }
                    if(bitmap0 != null) {
                        this.setImageBitmap(bitmap0);
                        if(imageResponse0.isCachedRedirect()) {
                            this.sendImageRequest(false);
                            return;
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private final void refreshImage(boolean z) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                boolean z1 = this.updateImageQueryParameters();
                if(this.profileId == null || this.profileId.length() == 0 || this.isUnspecifiedDimensions()) {
                    this.setBlankProfilePicture();
                    return;
                }
                else if(z1 || z) {
                    this.sendImageRequest(true);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private final void sendImageRequest(boolean z) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String s = "";
            com.facebook.AccessToken.Companion accessToken$Companion0 = AccessToken.Companion;
            if(accessToken$Companion0.isCurrentAccessTokenActive()) {
                AccessToken accessToken0 = accessToken$Companion0.getCurrentAccessToken();
                if(accessToken0 != null) {
                    String s1 = accessToken0.getToken();
                    if(s1 != null) {
                        s = s1;
                    }
                }
            }
            Uri uri0 = this.getProfilePictureUri(s);
            Context context0 = this.getContext();
            q.f(context0, "context");
            ImageRequest imageRequest0 = new Builder(context0, uri0).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new a0(this, 18)).build();
            ImageRequest imageRequest1 = this.lastRequest;
            if(imageRequest1 != null) {
                ImageDownloader.cancelRequest(imageRequest1);
            }
            this.lastRequest = imageRequest0;
            ImageDownloader.downloadAsync(imageRequest0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void sendImageRequest$lambda$2(ProfilePictureView profilePictureView0, ImageResponse imageResponse0) {
        q.g(profilePictureView0, "this$0");
        profilePictureView0.processResponse(imageResponse0);
    }

    private final void setBlankProfilePicture() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ImageRequest imageRequest0 = this.lastRequest;
            if(imageRequest0 != null) {
                ImageDownloader.cancelRequest(imageRequest0);
            }
            Bitmap bitmap0 = this.customizedDefaultProfilePicture;
            if(bitmap0 == null) {
                int v = this.isCropped ? drawable.com_facebook_profile_picture_blank_square : drawable.com_facebook_profile_picture_blank_portrait;
                this.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), v));
                return;
            }
            this.updateImageQueryParameters();
            Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, this.queryWidth, this.queryHeight, false);
            q.f(bitmap1, "createScaledBitmap(custo…idth, queryHeight, false)");
            this.setImageBitmap(bitmap1);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void setCropped(boolean z) {
        this.isCropped = z;
        this.refreshImage(false);
    }

    public final void setDefaultProfilePicture(@Nullable Bitmap bitmap0) {
        this.customizedDefaultProfilePicture = bitmap0;
    }

    private final void setImageBitmap(Bitmap bitmap0) {
        if(!CrashShieldHandler.isObjectCrashing(this) && bitmap0 != null) {
            try {
                this.imageContents = bitmap0;
                this.image.setImageBitmap(bitmap0);
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public final void setOnErrorListener(@Nullable OnErrorListener profilePictureView$OnErrorListener0) {
        this.onErrorListener = profilePictureView$OnErrorListener0;
    }

    public final void setPresetSize(int v) {
        if(v != -4 && v != -3 && v != -2 && v != -1) {
            throw new IllegalArgumentException("Must use a predefined preset size");
        }
        this.presetSize = v;
        this.requestLayout();
    }

    public final void setProfileId(@Nullable String s) {
        boolean z = true;
        if(this.profileId == null || this.profileId.length() == 0 || !v.j0(this.profileId, s, true)) {
            this.setBlankProfilePicture();
        }
        else {
            z = false;
        }
        this.profileId = s;
        this.refreshImage(z);
    }

    public final void setShouldUpdateOnProfileChange(boolean z) {
        if(z) {
            ProfileTracker profileTracker0 = this.profileTracker;
            if(profileTracker0 != null) {
                profileTracker0.startTracking();
            }
        }
        else {
            ProfileTracker profileTracker1 = this.profileTracker;
            if(profileTracker1 != null) {
                profileTracker1.stopTracking();
            }
        }
    }

    private final boolean updateImageQueryParameters() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int v = this.getHeight();
            int v1 = this.getWidth();
            boolean z = true;
            if(v1 >= 1 && v >= 1) {
                int v2 = this.getPresetSizeInPixels(false);
                if(v2 != 0) {
                    v = v2;
                    v1 = v;
                }
                if(v1 > v) {
                    v1 = this.isCropped ? v : 0;
                }
                else if(this.isCropped) {
                    v = v1;
                }
                else {
                    v = 0;
                }
                if(v1 == this.queryWidth && v == this.queryHeight) {
                    z = false;
                }
                this.queryWidth = v1;
                this.queryHeight = v;
                return z;
            }
            return false;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }
}

