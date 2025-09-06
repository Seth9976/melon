package com.gaa.sdk.auth;

import Z8.b;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.gaa.sdk.base.d;
import com.iloen.melon.utils.log.LogU;

class GaaSignInClientImpl.2 extends ResultReceiver {
    public final a a;

    public GaaSignInClientImpl.2(Handler handler0, a a0) {
        this.a = a0;
        super(handler0);
    }

    @Override  // android.os.ResultReceiver
    public final void onReceiveResult(int v, Bundle bundle0) {
        String s;
        boolean z = d.c();
        switch(v) {
            case 2: {
                s = z ? "서비스를 이용할 수 없는 상태입니다." : "The service is unavailable.";
                break;
            }
            case 11: {
                s = z ? "원스토어 서비스의 업데이트가 필요합니다." : "One Store service needs to be updated.";
                break;
            }
            case 1010: {
                s = z ? "원스토어에 연결할 수 없습니다. 원스토어 앱 실행이 필요합니다." : "Unable to connect to ONE store. Launching the ONE store app is required.";
                break;
            }
            case 12500: {
                s = z ? "로그인 실패하였습니다." : "Login failed.";
                break;
            }
            case 0x30D5: {
                s = z ? "로그인을 취소하였습니다." : "User canceled login.";
                break;
            }
            case 0x30D6: {
                s = z ? "로그인 중 입니다." : "User is logging in.";
                break;
            }
            default: {
                s = d.b(v, z);
            }
        }
        com.gaa.sdk.auth.d d0 = this.a.b;
        Activity activity0 = this.a.c;
        b b0 = this.a.d;
        if(v == 0) {
            d0.b(new a(d0, b0, activity0, 2));
            return;
        }
        LogU.Companion.d("OneStoreIapClientLifecycle", "launchSignInFlow " + false + ", " + v + ", " + s);
        b0.b.h = false;
    }
}

