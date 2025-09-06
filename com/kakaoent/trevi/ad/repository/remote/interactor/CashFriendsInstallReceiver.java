package com.kakaoent.trevi.ad.repository.remote.interactor;

import Tf.v;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.kakaoent.trevi.ad.util.TreviLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsInstallReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsInstallReceiver extends BroadcastReceiver {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/interactor/CashFriendsInstallReceiver$Companion;", "", "()V", "TAG", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        CashFriendsInstallReceiver.Companion = new Companion(null);
    }

    @Override  // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context0, @NotNull Intent intent0) {
        q.g(context0, "context");
        q.g(intent0, "intent");
        TreviLog treviLog0 = TreviLog.INSTANCE;
        String s = intent0.getDataString();
        String s1 = null;
        treviLog0.d("CashFriendsInstallReceiver", "onReceive, action : " + intent0.getAction() + ", packageName : " + (s == null ? null : v.p0(s, "package:", "")));
        if("android.intent.action.PACKAGE_ADDED".equals(intent0.getAction())) {
            String s2 = intent0.getDataString();
            if(s2 != null) {
                s1 = v.p0(s2, "package:", "");
            }
            if(s1 != null && s1.length() != 0) {
                treviLog0.d("CashFriendsInstallReceiver", "ACTION_PACKAGE_ADDED CPI Installed : " + s1);
                CashFriendsManager.INSTANCE.checkAppliedAndNotify(s1);
            }
        }
    }
}

