package ed;

import Cb.i;
import Pc.e;
import Xb.j;
import Yb.h;
import android.content.Intent;
import android.graphics.ImageDecoder;
import android.graphics.Point;
import androidx.compose.runtime.b0;
import androidx.lifecycle.f0;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.MusicWavePreference.MusicWaveTempChannel;
import com.iloen.melon.activity.ErrorReportActivity;
import com.iloen.melon.custom.h0;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.player.playlist.common.g;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import com.iloen.melon.utils.shortcut.ShortcutManager;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.net.res.SearchMainContentRes.ArchivingTheme;
import com.melon.playlist.b;
import com.melon.ui.playerdjmalrang.DjMalrangPlayerViewCalculator;
import com.melon.ui.playermusic.PlayerMoreView;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import com.melon.ui.r4;
import gd.C0;
import gd.F7;
import gd.K4;
import gd.M3;
import gd.O7;
import gd.R4;
import gd.U3;
import gd.c2;
import gd.j2;
import gd.l5;
import gd.o5;
import gd.p3;
import gd.p5;
import gd.r2;
import gd.v2;
import gd.w3;
import gd.y0;
import hd.A1;
import hd.v0;
import ie.H;
import j9.d;
import java.util.List;
import jd.A;
import jd.V1;
import jd.Y1;
import jd.c0;
import k5.B;
import k5.q;
import k5.r;
import k5.v;
import k5.y;
import k5.z;
import k8.M0;
import k8.Y;
import kc.c1;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.JsonNamesMapKt;
import okio.BufferedSource;
import okio.Okio;
import p0.p;
import p8.f;
import sc.P0;
import we.a;
import we.k;

public final class w0 implements a {
    public final int a;
    public final Object b;
    public final Object c;

    public w0(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        Object object0 = this.b;
        Object object1 = this.c;
        switch(this.a) {
            case 0: {
                F0.e(((ArchivingTheme)object1), ((F0)object0));
                return h0;
            }
            case 1: {
                F0.g(((BannerBase)object1), ((F0)object0));
                return h0;
            }
            case 2: {
                ((k)object1).invoke(((O0)object0));
                return h0;
            }
            case 3: {
                return JsonNamesMapKt.a(((SerialDescriptor)object1), ((Json)object0));
            }
            case 4: {
                if(((k)object1) != null) {
                    ((k)object1).invoke(new C0(((y0)object0)));
                }
                return h0;
            }
            case 5: {
                if(((k)object1) != null) {
                    ((k)object1).invoke(new j2(((c2)object0)));
                }
                return h0;
            }
            case 6: {
                if(((k)object1) != null) {
                    ((k)object1).invoke(new v2(((r2)object0)));
                }
                return h0;
            }
            case 7: {
                if(((k)object1) != null) {
                    ((k)object1).invoke(new w3(((p3)object0).b));
                }
                return h0;
            }
            case 8: {
                if(((k)object1) != null) {
                    ((k)object1).invoke(new U3(((M3)object0).c));
                }
                return h0;
            }
            case 9: {
                ((k)object1).invoke(new R4(((K4)object0).d));
                return h0;
            }
            case 10: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((p5)object1)), Dispatchers.getDefault(), null, new o5(((p5)object1), ((l5)(((e)object0))).a, false, null), 2, null);
                return h0;
            }
            case 11: {
                if(((List)object1).size() == 1) {
                    ((b0)object0).setValue(Boolean.valueOf(!((Boolean)((b0)object0).getValue()).booleanValue()));
                }
                return h0;
            }
            case 12: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((O7)object1)), null, null, new F7(((com.melon.ui.K4)object0), ((O7)object1), null), 3, null);
                return h0;
            }
            case 13: {
                ((k)object1).invoke(new v0(((A1)object0).d, ((A1)object0).e, 2));
                return h0;
            }
            case 14: {
                Intent intent0 = new Intent(((id.k)object1).getContext(), MusicBrowserActivity.class);
                intent0.setAction("android.intent.action.VIEW");
                intent0.addFlags(0x4000000);
                intent0.addFlags(0x10000000);
                intent0.setData(((ShortCutItem)object0).getShortcutUri());
                ShortcutManager.getInstance().requestShortcut(ShortcutManager.createShortcutInfo(((ShortCutItem)object0).getShortcutId(), ((ShortCutItem)object0).getStringId(), 0x7F100005, intent0));  // mipmap:icon_launcher_music
                return h0;
            }
            case 15: {
                ((d)object1).a().unregisterNetworkCallback(((j9.a)object0));
                LogU.debug$default(((d)object1).a, "NetworkCallback unregistered in awaitClose", null, false, 6, null);
                return h0;
            }
            case 16: {
                ((d)object1).a().unregisterNetworkCallback(((j9.a)object0));
                LogU.debug$default(((d)object1).a, "NetworkCallback unregistered in awaitClose", null, false, 6, null);
                return h0;
            }
            case 17: {
                ((A)object1).sendUserEvent(new c0(((List)object0)));
                return h0;
            }
            case 18: {
                f f0 = ((Y1)object1).f();
                if(f0 != null) {
                    f0.a = "";
                    f0.y = "";
                    f0.F = "";
                    f0.a().track();
                }
                MusicWaveTempChannel musicWavePreference$MusicWaveTempChannel0 = (MusicWaveTempChannel)((Na.e)(((Na.f)object0))).a;
                ((Y1)object1).h = musicWavePreference$MusicWaveTempChannel0;
                String s = musicWavePreference$MusicWaveTempChannel0 == null ? null : "";
                if(s == null) {
                    s = "";
                }
                ((Y1)object1).f = s;
                T2.a a0 = f0.h(((Y1)object1));
                V1 v10 = new V1(((Y1)object1), null);
                BuildersKt__Builders_commonKt.launch$default(a0, ((Y1)object1).b, null, v10, 2, null);
                return h0;
            }
            case 19: {
                kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                z z0 = ((y)object1).a;
                BufferedSource bufferedSource0 = z0.p();
                z z1 = bufferedSource0.rangeEquals(0L, r.b) || bufferedSource0.rangeEquals(0L, r.a) ? new B(Okio.buffer(new q(z0.p())), new h0(((y)object1).b.a, 3), null) : z0;
                try {
                    return ImageDecoder.decodeDrawable(((y)object1).b(z1), new v(h1, ((y)object1), ((C)object0)));
                }
                finally {
                    ImageDecoder imageDecoder0 = (ImageDecoder)h1.a;
                    if(imageDecoder0 != null) {
                        imageDecoder0.close();
                    }
                    z1.close();
                }
            }
            case 20: {
                return MusicBrowserActivity.handleAutoExtensionNotAllowedError$lambda$65(((MusicBrowserActivity)object1), ((h)object0));
            }
            case 21: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(((MusicBrowserActivity)object1)), null, null, new M0(((MusicBrowserActivity)object1), ((String)object0), null), 3, null);
                return h0;
            }
            case 22: {
                c1 c10 = new c1(((b)object1), ((P0)object0), null);
                BuildersKt__Builders_commonKt.launch$default(((b)object1).m, null, null, c10, 3, null);
                return h0;
            }
            case 23: {
                ((k)object1).invoke(new r4("", "", "", new g(6, ((a)object0)), null, null, 100));
                return h0;
            }
            case 24: {
                long v1 = System.currentTimeMillis();
                if(v1 - ((androidx.compose.runtime.M0)object1).m() > 500L) {
                    ((androidx.compose.runtime.M0)object1).n(v1);
                    ((p)object0).add(v1);
                }
                return h0;
            }
            case 25: {
                return ((ErrorReportActivity)object1).lambda$showErrorReportPopup$0(((String)object0));
            }
            case 26: {
                StringBuilder stringBuilder0 = Y.p("handlePlaybackUiEvent()");
                i.a(stringBuilder0, "playbackUi: " + i.o(((pd.d)object1)));
                i.a(stringBuilder0, "event: " + i.o(((j)object0)));
                return stringBuilder0.toString();
            }
            case 27: {
                ((k)object1).invoke(((MelonBottomSheetItem)object0));
                return h0;
            }
            case 28: {
                int v2 = ScreenUtils.dipToPixel(((DjMalrangPlayerViewCalculator)object1).a, 50.0f);
                int v3 = ((DjMalrangPlayerViewCalculator)object1).b();
                int v4 = ((DjMalrangPlayerViewCalculator)object1).a.getResources().getDimensionPixelSize(0x7F0700E6);  // dimen:dj_malrang_player_bottom_fixed_area_height
                int v5 = ((Point)object0).x - v2 * 2;
                int v6 = (int)(((float)(((Point)object0).y - v3 - v4)) * 0.78f);
                int v7 = (int)(((double)v5) * 1.1);
                Point point0 = v7 >= v6 ? new Point(((int)(((float)v6) / 1.1f * 1.0f)), v6) : new Point(v5, v7);
                if(point0.y < ScreenUtils.dipToPixel(((DjMalrangPlayerViewCalculator)object1).a, 124.0f)) {
                    point0 = new Point(0, 0);
                }
                LogU.Companion.d("PlayerViewCalculator", "screenSize:" + ((Point)object0) + ", topFixedHeight:" + v3 + ", bottomFixedHeight:" + v4 + ", albumSize:" + point0);
                return point0;
            }
            default: {
                ((PlayerMoreView)object1).E.n.scrollTo(0, 0);
                ((PlayerMoreView)object1).setVisibility(4);
                ((PlayerMoreView)object1).E.n.setOnScrollChangeListener(null);
                ((PlayerMoreView)object1).k();
                ((com.iloen.melon.utils.ui.h)object0).invoke();
                return h0;
            }
        }
    }
}

