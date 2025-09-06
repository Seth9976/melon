package com.facebook.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0017\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001A\u00020\u00072\b\u0010\u0004\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001A\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B2\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ+\u0010\u000F\u001A\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B2\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\'\u0010\u0010\u001A\u00020\u00072\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000B2\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u0010\u0010\u000EJ+\u0010\u0011\u001A\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B2\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u000EJ\u000F\u0010\u0012\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0003J!\u0010\u0013\u001A\u00020\u00052\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\r\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\r\u0010\u0015J9\u0010\u0018\u001A\u00020\u00072\b\u0010\u0004\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001A\u00020\u00052\u0016\u0010\u0017\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0016\"\u0004\u0018\u00010\u0001H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0007H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001CJ\u0017\u0010 \u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b \u0010!J\u001F\u0010 \u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010#\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b \u0010$J\u0017\u0010%\u001A\u00020\"2\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010\'\u001A\u00020\"2\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b\'\u0010&J\u0017\u0010(\u001A\u00020\"2\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b(\u0010&J\u0017\u0010)\u001A\u00020\"2\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b)\u0010&J\u001F\u0010+\u001A\u00020\"2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010*\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b+\u0010,J\u0017\u0010-\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b-\u0010!J\u001F\u0010-\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010#\u001A\u00020\"H\u0007\u00A2\u0006\u0004\b-\u0010$J\u001F\u0010/\u001A\u00020\"2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010.\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b/\u0010,J\u0017\u00100\u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b0\u0010!R\u001C\u00102\u001A\n 1*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b5\u00103R\u0014\u00106\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b6\u00103R\u0014\u00107\u001A\u00020\u00058\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b7\u00103R\u0014\u00108\u001A\u00020\u00058\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b8\u00103\u00A8\u00069"}, d2 = {"Lcom/facebook/internal/Validate;", "", "<init>", "()V", "arg", "", "name", "Lie/H;", "notNull", "(Ljava/lang/Object;Ljava/lang/String;)V", "T", "", "container", "notEmpty", "(Ljava/util/Collection;Ljava/lang/String;)V", "containsNoNulls", "containsNoNullOrEmpty", "notEmptyAndContainsNoNulls", "runningOnUiThread", "notNullOrEmpty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)V", "", "values", "oneOf", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)V", "sdkInitialized", "hasAppID", "()Ljava/lang/String;", "hasClientToken", "Landroid/content/Context;", "context", "hasInternetPermissions", "(Landroid/content/Context;)V", "", "shouldThrow", "(Landroid/content/Context;Z)V", "hasWiFiPermission", "(Landroid/content/Context;)Z", "hasChangeWifiStatePermission", "hasLocationPermission", "hasBluetoothPermission", "permission", "hasPermission", "(Landroid/content/Context;Ljava/lang/String;)Z", "hasFacebookActivity", "redirectURI", "hasCustomTabRedirectActivity", "hasContentProvider", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "NO_INTERNET_PERMISSION_REASON", "FACEBOOK_ACTIVITY_NOT_FOUND_REASON", "CONTENT_PROVIDER_NOT_FOUND_REASON", "CONTENT_PROVIDER_BASE", "CUSTOM_TAB_REDIRECT_URI_PREFIX", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Validate {
    @NotNull
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    @NotNull
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    @NotNull
    public static final String CUSTOM_TAB_REDIRECT_URI_PREFIX = "fbconnect://cct.";
    @NotNull
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    @NotNull
    public static final Validate INSTANCE = null;
    @NotNull
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    private static final String TAG;

    static {
        Validate.INSTANCE = new Validate();
        Validate.TAG = "com.facebook.internal.Validate";
    }

    public static final void containsNoNullOrEmpty(@NotNull Collection collection0, @NotNull String s) {
        q.g(collection0, "container");
        q.g(s, "name");
        for(Object object0: collection0) {
            if(((String)object0) == null) {
                throw new NullPointerException("Container \'" + s + "\' cannot contain null values");
            }
            if(((String)object0).length() <= 0) {
                throw new IllegalArgumentException(("Container \'" + s + "\' cannot contain empty values").toString());
            }
        }
    }

    public static final void containsNoNulls(@NotNull Collection collection0, @NotNull String s) {
        q.g(collection0, "container");
        q.g(s, "name");
        for(Object object0: collection0) {
            if(object0 == null) {
                throw new NullPointerException("Container \'" + s + "\' cannot contain null values");
            }
            if(false) {
                break;
            }
        }
    }

    @NotNull
    public static final String hasAppID() {
        String s = FacebookSdk.getApplicationId();
        if(s == null) {
            throw new IllegalStateException("No App ID found, please set the App ID.");
        }
        return s;
    }

    public static final boolean hasBluetoothPermission(@NotNull Context context0) {
        q.g(context0, "context");
        return Validate.hasPermission(context0, "android.permission.BLUETOOTH") && Validate.hasPermission(context0, "android.permission.BLUETOOTH_ADMIN");
    }

    public static final boolean hasChangeWifiStatePermission(@NotNull Context context0) {
        q.g(context0, "context");
        return Validate.hasPermission(context0, "android.permission.CHANGE_WIFI_STATE");
    }

    @NotNull
    public static final String hasClientToken() {
        String s = FacebookSdk.getClientToken();
        if(s == null) {
            throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml");
        }
        return s;
    }

    public static final void hasContentProvider(@NotNull Context context0) {
        q.g(context0, "context");
        String s = Validate.hasAppID();
        PackageManager packageManager0 = context0.getPackageManager();
        if(packageManager0 != null && packageManager0.resolveContentProvider("com.facebook.app.FacebookContentProvider" + s, 0) == null) {
            throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", Arrays.copyOf(new Object[]{"com.facebook.app.FacebookContentProvider" + s}, 1)).toString());
        }
    }

    public static final boolean hasCustomTabRedirectActivity(@NotNull Context context0, @NotNull String s) {
        List list0;
        q.g(context0, "context");
        q.g(s, "redirectURI");
        PackageManager packageManager0 = context0.getPackageManager();
        if(packageManager0 == null) {
            list0 = null;
        }
        else {
            Intent intent0 = new Intent();
            intent0.setAction("android.intent.action.VIEW");
            intent0.addCategory("android.intent.category.DEFAULT");
            intent0.addCategory("android.intent.category.BROWSABLE");
            intent0.setData(Uri.parse(s));
            list0 = packageManager0.queryIntentActivities(intent0, 0x40);
        }
        if(list0 != null) {
            boolean z = false;
            for(Object object0: list0) {
                ActivityInfo activityInfo0 = ((ResolveInfo)object0).activityInfo;
                if(q.b(activityInfo0.name, "com.facebook.CustomTabActivity") && q.b(activityInfo0.packageName, "com.iloen.melon")) {
                    z = true;
                    continue;
                }
                return false;
            }
            return z;
        }
        return false;
    }

    public static final void hasFacebookActivity(@NotNull Context context0) {
        q.g(context0, "context");
        Validate.hasFacebookActivity(context0, true);
    }

    @SuppressLint({"WrongConstant"})
    public static final void hasFacebookActivity(@NotNull Context context0, boolean z) {
        q.g(context0, "context");
        PackageManager packageManager0 = context0.getPackageManager();
        ActivityInfo activityInfo0 = null;
        if(packageManager0 != null) {
            ComponentName componentName0 = new ComponentName(context0, "com.facebook.FacebookActivity");
            try {
                activityInfo0 = packageManager0.getActivityInfo(componentName0, 1);
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
            }
        }
        if(activityInfo0 == null) {
            if(z) {
                throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
            }
            Log.w("com.facebook.internal.Validate", "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
    }

    public static final void hasInternetPermissions(@NotNull Context context0) {
        q.g(context0, "context");
        Validate.hasInternetPermissions(context0, true);
    }

    public static final void hasInternetPermissions(@NotNull Context context0, boolean z) {
        q.g(context0, "context");
        if(context0.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if(z) {
                throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
            }
            Log.w("com.facebook.internal.Validate", "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
    }

    public static final boolean hasLocationPermission(@NotNull Context context0) {
        q.g(context0, "context");
        return Validate.hasPermission(context0, "android.permission.ACCESS_COARSE_LOCATION") || Validate.hasPermission(context0, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static final boolean hasPermission(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "permission");
        return context0.checkCallingOrSelfPermission(s) == 0;
    }

    public static final boolean hasWiFiPermission(@NotNull Context context0) {
        q.g(context0, "context");
        return Validate.hasPermission(context0, "android.permission.ACCESS_WIFI_STATE");
    }

    public static final void notEmpty(@NotNull String s, @NotNull String s1) {
        q.g(s, "arg");
        q.g(s1, "name");
        if(s.length() <= 0) {
            throw new IllegalArgumentException(("Argument \'" + s1 + "\' cannot be empty").toString());
        }
    }

    public static final void notEmpty(@NotNull Collection collection0, @NotNull String s) {
        q.g(collection0, "container");
        q.g(s, "name");
        if(collection0.isEmpty()) {
            throw new IllegalArgumentException(("Container \'" + s + "\' cannot be empty").toString());
        }
    }

    public static final void notEmptyAndContainsNoNulls(@NotNull Collection collection0, @NotNull String s) {
        q.g(collection0, "container");
        q.g(s, "name");
        Validate.containsNoNulls(collection0, s);
        Validate.notEmpty(collection0, s);
    }

    public static final void notNull(@Nullable Object object0, @NotNull String s) {
        q.g(s, "name");
        if(object0 == null) {
            throw new NullPointerException("Argument \'" + s + "\' cannot be null");
        }
    }

    @NotNull
    public static final String notNullOrEmpty(@Nullable String s, @NotNull String s1) {
        q.g(s1, "name");
        if(s == null || s.length() <= 0) {
            throw new IllegalArgumentException(("Argument \'" + s1 + "\' cannot be null or empty").toString());
        }
        return s;
    }

    public static final void oneOf(@Nullable Object object0, @NotNull String s, @NotNull Object[] arr_object) {
        q.g(s, "name");
        q.g(arr_object, "values");
        for(int v = 0; v < arr_object.length; ++v) {
            if(q.b(arr_object[v], object0)) {
                return;
            }
        }
        throw new IllegalArgumentException("Argument \'" + s + "\' was not one of the allowed values");
    }

    public static final void runningOnUiThread() {
        if(!q.b(Looper.getMainLooper(), Looper.myLooper())) {
            throw new FacebookException("This method should be called from the UI thread");
        }
    }

    public static final void sdkInitialized() {
        if(!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }
}

