package com.melon.ui;

import Cc.a3;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.melon.ui.popup.b;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;
import va.e0;
import va.o;
import we.a;
import we.k;

public final class p3 implements k3 {
    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, I i0, a a0, k k0, boolean z, a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        q.g(k0, "sendUserEvent");
        if(o30 instanceof m3) {
            this.showContextMenuAddTo(i0, ((m3)o30).b, ((m3)o30).a, a0, k0, z, ((m3)o30).c);
            return;
        }
        if(o30 instanceof l3) {
            l0 l00 = i0.getChildFragmentManager();
            String s = ((l3)o30).a;
            String s1 = "M20001".equals(s) ? i0.getString(0x7F1300D3) : i0.getString(0x7F1300CE);  // string:alert_dlg_title_myalbum_add_song_sel "플레이리스트에 담기"
            q.d(s1);
            List list0 = ((l3)o30).b;
            List list1 = ((l3)o30).c;
            String s2 = ((l3)o30).d;
            q.g(list1, "playableList");
            q.g(s, "playlistType");
            q.g(s2, "ocrGroupId");
            if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                l00.C();
                if(b.b(l00, "AddToPlaylistDialogFragment", null, null, 12) == null) {
                    wd.b b0 = new wd.b();
                    b0.n = list0;
                    b0.o = s1;
                    b0.r = list1;
                    b0.w = s;
                    b0.B = s2;
                    b0.l = a1;
                    b0.show(l00, "AddToPlaylistDialogFragment");
                }
            }
            return;
        }
        if(!(o30 instanceof n3)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        l0 l01 = i0.getChildFragmentManager();
        String s3 = i0.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        String s4 = i0.getString(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        b.d(b.a, l01, s3, s4, false, false, false, null, null, null, null, null, 2040);
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(I i0, String s, List list0, a a0, k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        q.g(s1, "ocrGroupId");
        com.melon.ui.popup.context.more.k k1 = new com.melon.ui.popup.context.more.k(z, false, ((e0)o.a()).j().getIsDj());
        b.o(i0.getChildFragmentManager(), k1, new a3(k0, list0, s1, i0, s, a0), 12);
    }
}

