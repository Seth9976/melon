package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000B\u001A\u00020\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001A\u0010\u000E\u001A\u00020\u00068GX\u0086D¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/FacebookSDKJSInterface;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "pixelId", "eventName", "jsonString", "Lie/H;", "sendEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "protocol", "Ljava/lang/String;", "getProtocol", "()Ljava/lang/String;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookSDKJSInterface {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\f\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u000EH\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001A\n \u0006*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000F"}, d2 = {"Lcom/facebook/appevents/FacebookSDKJSInterface$Companion;", "", "()V", "PARAMETER_FBSDK_PIXEL_REFERRAL", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "jsonStringToBundle", "Landroid/os/Bundle;", "jsonString", "jsonToBundle", "jsonObject", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Bundle access$jsonStringToBundle(Companion facebookSDKJSInterface$Companion0, String s) {
            return facebookSDKJSInterface$Companion0.jsonStringToBundle(s);
        }

        // 去混淆评级： 低(20)
        public final String getTAG() {
            return "FacebookSDKJSInterface";
        }

        private final Bundle jsonStringToBundle(String s) {
            try {
                return this.jsonToBundle(new JSONObject(s));
            }
            catch(JSONException unused_ex) {
                return new Bundle();
            }
        }

        private final Bundle jsonToBundle(JSONObject jSONObject0) {
            Bundle bundle0 = new Bundle();
            Iterator iterator0 = jSONObject0.keys();
            q.f(iterator0, "jsonObject.keys()");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                bundle0.putString(((String)object0), jSONObject0.getString(((String)object0)));
            }
            return bundle0;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String TAG;
    @Nullable
    private final Context context;
    @NotNull
    private final String protocol;

    static {
        FacebookSDKJSInterface.Companion = new Companion(null);
        FacebookSDKJSInterface.TAG = "FacebookSDKJSInterface";
    }

    public FacebookSDKJSInterface(@Nullable Context context0) {
        this.context = context0;
        this.protocol = "fbmq-0.1";
    }

    // 去混淆评级： 低(40)
    public static final String access$getTAG$cp() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @JavascriptInterface
    @NotNull
    public final String getProtocol() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.protocol;
    }

    @JavascriptInterface
    public final void sendEvent(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if(s == null) {
                q.f("FacebookSDKJSInterface", "TAG");
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "FacebookSDKJSInterface", "Can\'t bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
                return;
            }
            InternalAppEventsLogger internalAppEventsLogger0 = com.facebook.appevents.InternalAppEventsLogger.Companion.createInstance$default(InternalAppEventsLogger.Companion, this.context, null, 2, null);
            Bundle bundle0 = Companion.access$jsonStringToBundle(FacebookSDKJSInterface.Companion, s2);
            bundle0.putString("_fb_pixel_referral_id", s);
            internalAppEventsLogger0.logEvent(s1, bundle0);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }
}

