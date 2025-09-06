package G8;

import A9.a;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.popup.b;
import e3.h;
import k8.Y;
import kotlin.jvm.internal.q;
import sd.j;
import vd.G;

public final class e {
    public static boolean a() {
        i.a.f();
        if(i.e() > 0) {
            LogU.Companion.d("LegacyLocalPlaylistMigHelper", "private local playlist already exist");
            return true;
        }
        LogU.Companion.d("LegacyLocalPlaylistMigHelper", "private local playlist doesn\'t exist");
        return false;
    }

    public static void b(Activity activity0, boolean z) {
        l0 l00 = null;
        if(!z && !e.a()) {
            q.f("DCF 파일 및 DB (로컬 플레이리스트) 복원을 위해서 폴더 권한이 필요합니다.<br/><b>/melon</b> 폴더를 지정해 주셔야 정상적인 DCF 파일 사용 및 복원이 가능합니다.<br/>폴더 권한을 설정하러 이동 하시겠습니까?", "getString(...)");
            String s = ResourceUtils.replaceFontColor(activity0, "DCF 파일 및 DB (로컬 플레이리스트) 복원을 위해서 폴더 권한이 필요합니다.<br/><b>/melon</b> 폴더를 지정해 주셔야 정상적인 DCF 파일 사용 및 복원이 가능합니다.<br/>폴더 권한을 설정하러 이동 하시겠습니까?", 0);
            AppCompatActivity appCompatActivity0 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
            l0 l01 = appCompatActivity0 == null ? null : appCompatActivity0.getSupportFragmentManager();
            a a0 = new a(15);
            if(l01 != null && !Y.z(MelonAppBase.Companion) && !l01.T() && !l01.K) {
                l01.C();
                if(b.b(l01, "showTwoBtnHtmlAlertPopup", null, new Nb.i("폴더 권한 설정 안내", s, 8), 4) == null) {
                    h.t("폴더 권한 설정 안내", s, null, true, null, null, new G(a0, 0), new j(9), true, false, vd.h.f, false, null, 0xD040).show(l01, "showTwoBtnHtmlAlertPopup");
                }
            }
            return;
        }
        AppCompatActivity appCompatActivity1 = activity0 instanceof AppCompatActivity ? ((AppCompatActivity)activity0) : null;
        if(appCompatActivity1 != null) {
            l00 = appCompatActivity1.getSupportFragmentManager();
        }
        b.x(l00, "다운로드 폴더 설정 안내", "DCF 파일 관리를 위한 폴더 권한이 필요합니다. \n폴더 권한을 설정하러 이동하시겠습니까?", false, false, null, null, new a(16), null, null, null, 0xEF8);
    }
}

