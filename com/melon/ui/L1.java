package com.melon.ui;

import com.iloen.melon.fragments.settings.SettingMainFragment;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.b;
import ie.H;
import we.a;

public final class l1 implements a {
    public final int a;
    public final o1 b;

    public l1(o1 o10, int v) {
        this.a = v;
        this.b = o10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            SettingMainFragment.Companion.newInstance(true).open();
            return H.a;
        }
        o1 o10 = this.b;
        if(o10.getContext() != null) {
            if(NetUtils.isConnected()) {
                o1.loadPage$default(o10, true, null, 2, null);
                return H.a;
            }
            int v = NetUtils.INSTANCE.getNetworkStateForPopup();
            switch(v) {
                case 1: {
                    b.x(o10.getChildFragmentManager(), "안내", "데이터 네트워크 차단 상태에서는\n단말에 저장된 콘텐츠만 재생이 가능합니다. 음악서랍>다운로드 로 이동하시겠습니까?", false, false, null, null, new com.iloen.melon.popup.H(17), null, null, null, 0xEF8);
                    break;
                }
                case 2: {
                    b.x(o10.getChildFragmentManager(), "안내", "데이터 네트워크 차단 상태입니다.\n데이터 네트워크를 사용하시겠습니까?\n(사용중인 데이터 요금제에 따라 데이터 통화료가 부과될 수 있습니다)", false, false, null, null, new com.iloen.melon.popup.H(18), null, null, null, 0xEF8);
                    return H.a;
                label_13:
                    if(v == 3) {
                        ToastManager.showShort(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                        return H.a;
                    }
                    break;
                }
                default: {
                    goto label_13;
                }
            }
        }
        return H.a;
    }
}

