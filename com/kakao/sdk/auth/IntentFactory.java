package com.kakao.sdk.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fJ-\u0010\r\u001A\u00020\u0004\"\n\b\u0000\u0010\u000E\u0018\u0001*\u00020\u000F2\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\bH\u0086\bJ>\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u000B\u001A\u00020\fJ\u0006\u0010\u0017\u001A\u00020\u0004¨\u0006\u0018"}, d2 = {"Lcom/kakao/sdk/auth/IntentFactory;", "", "()V", "account", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "fullUri", "Landroid/net/Uri;", "redirectUri", "", "resultReceiver", "Landroid/os/ResultReceiver;", "apps", "T", "Lcom/kakao/sdk/auth/CustomTabLauncherActivity;", "talk", "requestCode", "", "clientId", "kaHeader", "extras", "Landroid/os/Bundle;", "talkBase", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class IntentFactory {
    @NotNull
    public static final IntentFactory INSTANCE;

    static {
        IntentFactory.INSTANCE = new IntentFactory();
    }

    @NotNull
    public final Intent account(@NotNull Context context0, @NotNull Uri uri0, @NotNull String s, @NotNull ResultReceiver resultReceiver0) {
        q.g(context0, "context");
        q.g(uri0, "fullUri");
        q.g(s, "redirectUri");
        q.g(resultReceiver0, "resultReceiver");
        Intent intent0 = new Intent(context0, AuthCodeHandlerActivity.class);
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("key.result.receiver", resultReceiver0);
        bundle0.putParcelable("key.full_authorize_uri", uri0);
        bundle0.putString("key.redirect_uri", s);
        Intent intent1 = intent0.putExtra("key.bundle", bundle0).addFlags(0x10000000);
        q.f(intent1, "Intent(context, cls)\n   …t.FLAG_ACTIVITY_NEW_TASK)");
        return intent1;
    }

    public final Intent apps(Context context0, ResultReceiver resultReceiver0, Uri uri0) {
        q.g(context0, "context");
        q.g(resultReceiver0, "resultReceiver");
        q.g(uri0, "fullUri");
        q.k();
        throw null;
    }

    @NotNull
    public final Intent talk(@NotNull Context context0, int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Bundle bundle0, @NotNull ResultReceiver resultReceiver0) {
        q.g(context0, "context");
        q.g(s, "clientId");
        q.g(s1, "redirectUri");
        q.g(s2, "kaHeader");
        q.g(bundle0, "extras");
        q.g(resultReceiver0, "resultReceiver");
        Intent intent0 = new Intent(context0, TalkAuthCodeActivity.class).putExtra("key.login.intent", this.talkBase().putExtra("com.kakao.sdk.talk.appKey", s).putExtra("com.kakao.sdk.talk.redirectUri", s1).putExtra("com.kakao.sdk.talk.kaHeader", s2).putExtra("com.kakao.sdk.talk.extraparams", bundle0)).putExtra("key.request.code", v);
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("key.result.receiver", resultReceiver0);
        Intent intent1 = intent0.putExtra("key.bundle", bundle1).addFlags(0x24000000);
        q.f(intent1, "Intent(context, TalkAuth…FLAG_ACTIVITY_SINGLE_TOP)");
        return intent1;
    }

    @NotNull
    public final Intent talkBase() {
        Intent intent0 = new Intent("com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY").addCategory("android.intent.category.DEFAULT");
        q.f(intent0, "Intent(Constants.CAPRI_L…(Intent.CATEGORY_DEFAULT)");
        return intent0;
    }
}

