package com.iloen.melon.utils.player;

import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import com.android.volley.Response.Listener;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes;
import com.melon.ui.popup.b;
import java.util.LinkedList;
import va.e0;
import va.o;
import vd.e;

class DcfUtils.4 implements Listener {
    public final BaseActivity a;

    public DcfUtils.4(BaseActivity baseActivity0) {
        this.a = baseActivity0;
    }

    public void onResponse(DeviceInformDeviceCheckRes deviceInformDeviceCheckRes0) {
        boolean z = deviceInformDeviceCheckRes0.isSuccessful();
        e e0 = null;
        BaseActivity baseActivity0 = this.a;
        if(z) {
            boolean z1 = ProtocolUtils.parseBoolean(deviceInformDeviceCheckRes0.response.deviceYn);
            ((e0)o.a()).A(z1);
            if(z1) {
                GetDcfExtendInfoCoroutine dcfUtils$GetDcfExtendInfoCoroutine0 = new GetDcfExtendInfoCoroutine();  // 初始化器: Lx8/f;-><init>()V
                dcfUtils$GetDcfExtendInfoCoroutine0.a = new LinkedList();
                dcfUtils$GetDcfExtendInfoCoroutine0.b = baseActivity0;
                dcfUtils$GetDcfExtendInfoCoroutine0.execute(null);
                return;
            }
            l0 l00 = baseActivity0.getSupportFragmentManager();
            if(l00 != null && !l00.T() && !l00.K) {
                l00.C();
                w w0 = b.b(l00, "BlockingProgressDialogFragment", null, null, 12);
                if(w0 != null) {
                    if(w0 instanceof e) {
                        e0 = (e)w0;
                    }
                    if(e0 != null) {
                        e0.dismissAllowingStateLoss();
                    }
                }
            }
        }
        else {
            l0 l01 = baseActivity0.getSupportFragmentManager();
            if(l01 != null && !l01.T() && !l01.K) {
                l01.C();
                w w1 = b.b(l01, "BlockingProgressDialogFragment", null, null, 12);
                if(w1 != null) {
                    if(w1 instanceof e) {
                        e0 = (e)w1;
                    }
                    if(e0 != null) {
                        e0.dismissAllowingStateLoss();
                    }
                }
            }
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        this.onResponse(((DeviceInformDeviceCheckRes)object0));
    }
}

