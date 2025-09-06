package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.o;
import com.facebook.FacebookSdk;
import com.facebook.bolts.AppLinks;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u001B\b\u0002\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fR\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001A\u0004\b\u000E\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000F\u001A\u0004\b\u0005\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo;", "", "", "callingApplicationPackage", "", "isOpenedByAppLink", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "Lie/H;", "writeSourceApplicationInfoToDisk", "()V", "Ljava/lang/String;", "getCallingApplicationPackage", "Z", "()Z", "Companion", "Factory", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SourceApplicationInfo {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\u0003R\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000BR\u0014\u0010\r\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000B¨\u0006\u000E"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo$Companion;", "", "<init>", "()V", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "getStoredSourceApplicatioInfo", "()Lcom/facebook/appevents/internal/SourceApplicationInfo;", "Lie/H;", "clearSavedSourceApplicationInfoFromDisk", "", "CALL_APPLICATION_PACKAGE_KEY", "Ljava/lang/String;", "OPENED_BY_APP_LINK_KEY", "SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void clearSavedSourceApplicationInfoFromDisk() {
            SharedPreferences.Editor sharedPreferences$Editor0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            sharedPreferences$Editor0.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
            sharedPreferences$Editor0.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
            sharedPreferences$Editor0.apply();
        }

        @Nullable
        public final SourceApplicationInfo getStoredSourceApplicatioInfo() {
            SharedPreferences sharedPreferences0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            return sharedPreferences0.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage") ? new SourceApplicationInfo(sharedPreferences0.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), sharedPreferences0.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false), null) : null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo$Factory;", "", "()V", "create", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "activity", "Landroid/app/Activity;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Factory {
        @NotNull
        public static final Factory INSTANCE;

        static {
            Factory.INSTANCE = new Factory();
        }

        @Nullable
        public static final SourceApplicationInfo create(@NotNull Activity activity0) {
            String s;
            q.g(activity0, "activity");
            ComponentName componentName0 = activity0.getCallingActivity();
            if(componentName0 == null) {
                s = "";
            }
            else {
                s = componentName0.getPackageName();
                if(q.b(s, "com.iloen.melon")) {
                    return null;
                }
            }
            Intent intent0 = activity0.getIntent();
            boolean z = false;
            if(intent0 != null && !intent0.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)) {
                intent0.putExtra("_fbSourceApplicationHasBeenSet", true);
                Bundle bundle0 = AppLinks.getAppLinkData(intent0);
                if(bundle0 != null) {
                    Bundle bundle1 = bundle0.getBundle("referer_app_link");
                    if(bundle1 != null) {
                        s = bundle1.getString("package");
                    }
                    z = true;
                }
            }
            if(intent0 != null) {
                intent0.putExtra("_fbSourceApplicationHasBeenSet", true);
            }
            return new SourceApplicationInfo(s, z, null);
        }
    }

    @NotNull
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
    @NotNull
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    @Nullable
    private final String callingApplicationPackage;
    private final boolean isOpenedByAppLink;

    static {
        SourceApplicationInfo.Companion = new Companion(null);
    }

    private SourceApplicationInfo(String s, boolean z) {
        this.callingApplicationPackage = s;
        this.isOpenedByAppLink = z;
    }

    public SourceApplicationInfo(String s, boolean z, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, z);
    }

    public static final void clearSavedSourceApplicationInfoFromDisk() {
        SourceApplicationInfo.Companion.clearSavedSourceApplicationInfoFromDisk();
    }

    @Nullable
    public final String getCallingApplicationPackage() {
        return this.callingApplicationPackage;
    }

    @Nullable
    public static final SourceApplicationInfo getStoredSourceApplicatioInfo() {
        return SourceApplicationInfo.Companion.getStoredSourceApplicatioInfo();
    }

    public final boolean isOpenedByAppLink() {
        return this.isOpenedByAppLink;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.isOpenedByAppLink ? "Applink" : "Unclassified";
        if(this.callingApplicationPackage != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append(s);
            stringBuilder0.append('(');
            return o.r(stringBuilder0, this.callingApplicationPackage, ')');
        }
        return s;
    }

    public final void writeSourceApplicationInfoToDisk() {
        SharedPreferences.Editor sharedPreferences$Editor0 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        sharedPreferences$Editor0.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.callingApplicationPackage);
        sharedPreferences$Editor0.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.isOpenedByAppLink);
        sharedPreferences$Editor0.apply();
    }
}

