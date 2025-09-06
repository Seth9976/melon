package com.iloen.melon.utils.player;

import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq;
import com.iloen.melon.net.v4x.response.DcfExtensionBaseInfoRes.Response;
import com.iloen.melon.net.v4x.response.DcfExtensionBaseInfoRes;
import com.melon.ui.popup.b;
import tg.Q;
import tg.d;
import tg.g;
import vd.e;

class DcfUtils.2 implements g {
    public final BaseActivity a;
    public final DcfUtils b;

    public DcfUtils.2(DcfUtils dcfUtils0, BaseActivity baseActivity0) {
        this.b = dcfUtils0;
        this.a = baseActivity0;
    }

    @Override  // tg.g
    public void onFailure(d d0, Throwable throwable0) {
        BaseActivity baseActivity0 = this.a;
        l0 l00 = baseActivity0.getSupportFragmentManager();
        if(l00 != null && !l00.T() && !l00.K) {
            l00.C();
            e e0 = null;
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
        baseActivity0.runOnUiThread(new DcfUtils.1(baseActivity0, "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."));
    }

    @Override  // tg.g
    public void onResponse(d d0, Q q0) {
        Object object0 = q0.b;
        e e0 = null;
        BaseActivity baseActivity0 = this.a;
        if(object0 == null) {
            l0 l02 = baseActivity0.getSupportFragmentManager();
            if(l02 != null && !l02.T() && !l02.K) {
                l02.C();
                w w2 = b.b(l02, "BlockingProgressDialogFragment", null, null, 12);
                if(w2 != null) {
                    if(w2 instanceof e) {
                        e0 = (e)w2;
                    }
                    if(e0 != null) {
                        e0.dismissAllowingStateLoss();
                    }
                }
            }
        }
        else if(!((HttpResponse)object0).isSuccessful()) {
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
            Response dcfExtensionBaseInfoRes$Response0 = ((DcfExtensionBaseInfoRes)q0.b).response;
            if("Y".equals(dcfExtensionBaseInfoRes$Response0.songdcfyn) || "Y".equals(dcfExtensionBaseInfoRes$Response0.langdcfyn)) {
                RequestBuilder.newInstance(new DeviceInformDeviceCheckReq(MelonAppBase.instance.getContext(), CallerType.DCF)).tag("DcfUtils").listener(new DcfUtils.4(baseActivity0)).errorListener(new DcfUtils.3(this.b, baseActivity0)).request();
                return;
            }
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
}

