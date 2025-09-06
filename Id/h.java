package id;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import com.iloen.melon.utils.shortcut.ShortcutManager;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.b;
import d3.g;
import ed.w0;
import kotlin.jvm.internal.q;

public final class h implements View.OnClickListener {
    public final int a;
    public final k b;

    public h(k k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ShortCutItem shortCutItem0 = ShortCutItem.MELON_SEARCH;
            if(ShortcutManager.getInstance().hasShortcutInHomeScreen(shortCutItem0.getShortcutId(), true)) {
                ToastManager.show(0x7F130A04);  // string:shortcut_exist_icon "이미 홈 화면에 바로가기가 존재합니다."
                return;
            }
            k k0 = this.b;
            String s = k0.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            q.f(s, "getString(...)");
            String s1 = k0.getString(0x7F130904);  // string:search_sound_make_short_cut "음악 검색 바로가기를 생성하시겠습니까?"
            q.f(s1, "getString(...)");
            if(k0.getActivity() != null) {
                b.x(k0.getChildFragmentManager(), s, s1, false, false, null, null, new w0(14, k0, shortCutItem0), null, null, null, 0xEF8);
            }
            return;
        }
        k k1 = this.b;
        if(((A)k1.getViewModel()).c) {
            LogU.debug$default(k1.d, "Request server api..", null, false, 6, null);
            return;
        }
        f f0 = k1.r;
        if(f0 != null) {
            if(f0.f != null && f0.f.g != 0L) {
                k1.p();
                g.d0("M2", ((A)k1.getViewModel()).getMenuId(), "");
                return;
            }
            k1.o("onViewCreated");
        }
    }
}

