package gd;

import Ma.m;
import Ud.j;
import android.content.Context;
import androidx.compose.runtime.w;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import f1.x;
import ie.H;
import k8.Y;
import k8.o;
import k8.t;
import kc.s2;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.StateFlowKt;
import okhttp3.OkHttpClient;
import r8.f;
import we.a;

public final class r5 implements a {
    public final int a;

    public r5(int v) {
        this.a = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        switch(this.a) {
            case 0: {
                return new j();
            }
            case 1: {
                return new j();
            }
            case 2: {
                return new j();
            }
            case 3: {
                return new j();
            }
            case 4: {
                return w.s(new x("", 0L, 6));
            }
            case 5: {
                return new j();
            }
            case 6: {
                return new j();
            }
            case 7: {
                return new j();
            }
            case 8: {
                return new OkHttpClient();
            }
            case 9: {
                return new j();
            }
            case 10: {
                return null;
            }
            case 11: {
                return StateFlowKt.MutableStateFlow(0);
            }
            case 12: {
                return MusicBrowserActivity.showDialogOfflinePayback$lambda$32();
            }
            case 13: {
                return "1000003139";
            }
            case 14: {
                return MusicBrowserActivity.onEventMainThread$lambda$71();
            }
            case 15: {
                return "1000003153";
            }
            case 16: {
                return MusicBrowserActivity.showDialogOnNetworkOff$lambda$34();
            }
            case 17: {
                return MusicBrowserActivity.checkGooglePlayService$lambda$30();
            }
            case 18: {
                return MusicBrowserActivity.onEventMainThread$lambda$72();
            }
            case 19: {
                Navigator.open(SettingMainFragment.Companion.newInstance());
                return h0;
            }
            case 20: {
                Navigator.openLoginView(f.f);
                return h0;
            }
            case 21: {
                ToastManager.show(0x7F1310E9);  // string:use_3g_setting_on "Wi-Fi가 연결되지 않았을 경우 데이터 네트워크를 사용합니다."
                MelonSettingInfo.setUseDataNetwork(true);
                return h0;
            }
            case 22: {
                s5 s50 = new s5();
                Navigator.INSTANCE.open(s50);
                return h0;
            }
            case 23: {
                return false;
            }
            case 24: {
                return BaseActivity.showEventNotificationDialog$lambda$7();
            }
            case 25: {
                return "1000003139";
            }
            case 26: {
                return new j();
            }
            case 27: {
                MelonAppBase.Companion.getClass();
                Context context0 = t.a().getApplicationContext();
                q.d(context0);
                return (s2)((o)(((m)b.B(context0, m.class)))).w.get();
            }
            case 28: {
                return Y.i(ContsTypeCode.VIDEO, "code(...)");
            }
            default: {
                return ActionKind.ClickContent;
            }
        }
    }
}

