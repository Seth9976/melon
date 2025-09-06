package com.iloen.melon.custom;

import A8.b;
import Q1.c;
import Y8.e;
import Z8.i;
import android.content.Intent;
import androidx.lifecycle.M;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;

public final class q0 implements M {
    public final int a;
    public final MelonWebView b;

    public q0(MelonWebView melonWebView0, int v) {
        this.a = v;
        this.b = melonWebView0;
        super();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        MelonWebView melonWebView0 = this.b;
        if(this.a != 0) {
            melonWebView0.getClass();
            int v = ((i)object0).a;
            boolean z = ((i)object0).b;
            String s = ((i)object0).c;
            Z.r(v, "setupOneStoreIap()#getEventRefresh()#onChanged() code:", "MelonWebView");
            int v1 = ((i)object0).a;
            if((v1 == 10000 || v1 == 10001 || v1 == 10002) && s != null) {
                if(v1 == 10001) {
                    s = "javascript:inAppPurchaseRestore(returnData)".replace("returnData", s);
                }
                else if(v1 == 10002) {
                    s = "javascript:inAppPurchaseRestoreCheck(returnData)".replace("returnData", s);
                }
                LogU.d("MelonWebView", "setupOneStoreIap()#getEventRefresh()#onChanged() returnData:" + s);
                melonWebView0.loadUrl(s);
                return;
            }
            melonWebView0.loadUrl("javascript:inAppPurchaseCancel()");
            if(v1 == 30000) {
                ToastManager.show("인앱 복구 테스를를 위해 구매완료 Request를 전송하지 않았습니다.");
                return;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            if(!b.d()) {
                stringBuilder0.append("[");
                stringBuilder0.append(v);
                stringBuilder0.append("]");
            }
            if(z) {
                if(v == 1007) {
                    stringBuilder0.append("결제 시도 중 연결이 실패하였습니다. 다시 시도해주세요.");
                }
                else if(s != null && !s.isEmpty()) {
                    stringBuilder0.append(s);
                }
            }
            if(stringBuilder0.length() > 0) {
                ToastManager.show(stringBuilder0.toString());
            }
            return;
        }
        melonWebView0.getClass();
        String s1 = ((e)object0).b;
        Z.r(((e)object0).a, "setupGoogleIap()#getEventRefresh()#onChanged() code:", "MelonWebView");
        int v2 = ((e)object0).a;
        if((v2 == 1000 || v2 == 1001 || v2 == 1002 || v2 == 1003) && s1 != null) {
            if(v2 == 1001) {
                s1 = "javascript:inAppPurchaseRestore(returnData)".replace("returnData", s1);
            }
            else if(v2 == 1002) {
                s1 = "javascript:inAppPurchaseRestoreCheck(returnData)".replace("returnData", s1);
            }
            LogU.d("MelonWebView", "setupGoogleIap()#getEventRefresh()#onChanged() returnData:" + s1);
            melonWebView0.loadUrl(s1);
            return;
        }
        melonWebView0.loadUrl("javascript:inAppPurchaseCancel()");
        if(v2 == 3000) {
            ToastManager.show("인앱 복구 테스를를 위해 구매완료 Request를 전송하지 않았습니다.");
        }
        if(v2 == 4 || v2 == 2000) {
            LogU.d("MelonWebView", "setupGoogleIap() mayBeErrorByPlayStoreCache");
            Intent intent0 = new Intent();
            c.Y(intent0, "com.iloen.melon.MELON_WEB_VIEW_ALERT_DIALOG.action", true);
            intent0.putExtra("alertdialogtype", 22);
            melonWebView0.getContext().sendBroadcast(intent0);
        }
    }
}

