package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;
import ea.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0003R\u001A\u0010\u0007\u001A\u00020\bX\u0084\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/CustomTab;", "", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "openCustomTab", "", "activity", "Landroid/app/Activity;", "packageName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class CustomTab {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\bH\u0017¨\u0006\t"}, d2 = {"Lcom/facebook/internal/CustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public Uri getURIForAction(@NotNull String s, @Nullable Bundle bundle0) {
            q.g(s, "action");
            return Utility.buildUri("m.null", FacebookSdk.getGraphApiVersion() + "/dialog/" + s, bundle0);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private Uri uri;

    static {
        CustomTab.Companion = new Companion(null);
    }

    public CustomTab(@NotNull String s, @Nullable Bundle bundle0) {
        q.g(s, "action");
        super();
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        GamingAction[] arr_gamingAction = GamingAction.values();
        ArrayList arrayList0 = new ArrayList(arr_gamingAction.length);
        for(int v = 0; v < arr_gamingAction.length; ++v) {
            arrayList0.add(arr_gamingAction[v].getRawValue());
        }
        this.uri = arrayList0.contains(s) ? Utility.buildUri("fb.gg", "/dialog/" + s, bundle0) : CustomTab.Companion.getURIForAction(s, bundle0);
    }

    @NotNull
    public static Uri getURIForAction(@NotNull String s, @Nullable Bundle bundle0) {
        Class class0 = CustomTab.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return CustomTab.Companion.getURIForAction(s, bundle0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final Uri getUri() {
        return CrashShieldHandler.isObjectCrashing(this) ? null : this.uri;
    }

    public final boolean openCustomTab(@NotNull Activity activity0, @Nullable String s) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                q.g(activity0, "activity");
                c c0 = new A3.c(CustomTabPrefetchHelper.Companion.getPreparedSessionOnce()).a();
                Intent intent0 = (Intent)c0.b;
                intent0.setPackage(s);
                try {
                    intent0.setData(this.uri);
                    P1.c.startActivity(activity0, intent0, ((Bundle)c0.c));
                    return true;
                }
                catch(ActivityNotFoundException unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return false;
            }
        }
        return false;
    }

    public final void setUri(@NotNull Uri uri0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(uri0, "<set-?>");
            this.uri = uri0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }
}

