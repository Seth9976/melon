package com.gaa.sdk.auth;

import E9.g;
import J5.c;
import Z8.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.gaa.sdk.base.ConnectionInfo;
import com.gaa.sdk.base.e;
import com.iloen.melon.MelonAppBase;
import y5.a;

public final class d {
    public int a;
    public final Context b;
    public c c;
    public com.gaa.sdk.auth.c d;
    public final ConnectionInfo e;
    public final g f;
    public final String g;

    public d(MelonAppBase melonAppBase0) {
        this.a = 0;
        this.f = new g(7);
        this.g = "1.0.0";
        Context context0 = melonAppBase0.getApplicationContext();
        this.b = context0;
        this.e = new ConnectionInfo(context0);
    }

    public final void a(Activity activity0, Intent intent0, b b0) {
        a.X("GaaSignInClientImpl", "Start the foreground login.");
        GaaSignInClientImpl.1 gaaSignInClientImpl$10 = new GaaSignInClientImpl.1(this, ((Handler)this.f.a), b0);
        Intent intent1 = new Intent(activity0, SignInActivity.class);
        intent1.putExtra("sign_in_intent", intent0);
        intent1.putExtra("result_receiver", gaaSignInClientImpl$10);
        intent1.putExtra("connection_info", this.e);
        activity0.startActivity(intent1);
    }

    public final void b(com.gaa.sdk.auth.b b0) {
        if(this.a == 1) {
            a.X("GaaSignInClientImpl", "Currently logging in.");
            b0.c(d.c(0x30D6), null);
            return;
        }
        if(!ye.a.K(this.b, ((String)this.e.a.a))) {
            b0.c(d.c(1010), null);
            return;
        }
        this.a = 1;
        this.d = new com.gaa.sdk.auth.c(this, b0);
        try {
            Intent intent0 = new Intent("com.gaa.extern.auth.SIGN_IN_BIND");
            intent0.setPackage(((String)this.e.a.a));
            intent0.putExtra("authLibraryVersion", this.g);
            ye.a.S(this.b, intent0);
            if(this.b.bindService(intent0, this.d, 1)) {
                a.X("GaaSignInClientImpl", "Service was bonded successfully.");
                return;
            }
            this.a = 0;
            a.Y("GaaSignInClientImpl", "Connection to Purchase service is blocked.");
            goto label_31;
        }
        catch(e e0) {
        }
        catch(SecurityException unused_ex) {
            this.a = 0;
            a.Y("GaaSignInClientImpl", "service security exception");
            goto label_31;
        }
        catch(Exception exception0) {
            this.a = 0;
            Log.e("GaaSignInClientImpl", "service exception: ", exception0);
            b0.c(d.c(12500), null);
            return;
        }
        this.a = 0;
        a.X("GaaSignInClientImpl", "service unavailable on device. : " + e0.a);
        b0.c(d.c(11), null);
        return;
    label_31:
        b0.c(d.c(12500), null);
    }

    public static com.gaa.sdk.auth.e c(int v) {
        String s;
        boolean z = com.gaa.sdk.base.d.c();
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
                s = com.gaa.sdk.base.d.b(v, z);
            }
        }
        com.gaa.sdk.auth.e e0 = new com.gaa.sdk.auth.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.a = v;
        e0.b = s;
        return e0;
    }
}

