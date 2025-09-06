package com.iloen.melon.utils.player;

import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.activity.BaseActivity;
import com.melon.ui.popup.b;
import vd.e;

class DcfUtils.3 implements ErrorListener {
    public final BaseActivity a;

    public DcfUtils.3(DcfUtils dcfUtils0, BaseActivity baseActivity0) {
        this.a = baseActivity0;
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
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
}

