package com.iloen.melon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.I;
import b.a;
import com.android.volley.Request.Priority;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.LogParam;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.net.v4x.request.LogReportReq;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.popup.b;
import ed.w0;
import ie.H;
import jd.e3;
import l8.p;
import l8.q;

public class ErrorReportActivity extends PopupFragmentActivity {
    private static final String TAG = "ErrorReportActivity";

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public I getAddFragment() {
        Intent intent0 = this.getIntent();
        if(intent0 != null && intent0.hasExtra("extraCrashReport")) {
            String s = intent0.getStringExtra("extraCrashReport");
            if(TextUtils.isEmpty(s)) {
                this.finish();
            }
            this.showErrorReportPopup(s);
            return super.getAddFragment();
        }
        this.finish();
        return super.getAddFragment();
    }

    private H lambda$showErrorReportPopup$0(String s) {
        if(NetUtils.isConnected()) {
            this.requestCrashLog(s);
            return null;
        }
        ToastManager.show(0x7F1303EE);  // string:error_report_logging_network_fail "네트워크 상태가 원활하지 않아 로그 전송에 실패 하였습니다."
        this.finish();
        return null;
    }

    private H lambda$showErrorReportPopup$1() {
        this.finish();
        return null;
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
    }

    private void requestCrashLog(String s) {
        LogU.d("ErrorReportActivity", "requestCrashLog()");
        LogParam logReportReq$LogParam0 = new LogParam();
        logReportReq$LogParam0.type = Type.CRASH;
        logReportReq$LogParam0.logLevel = LogLevel.ERROR;
        logReportReq$LogParam0.message = s;
        RequestBuilder.newInstance(new LogReportReq(MelonAppBase.instance.getContext(), logReportReq$LogParam0)).priority(Priority.HIGH).listener(new q(this)).errorListener(new p(this)).request();
        ToastManager.show(0x7F1303EF);  // string:error_report_logging_success "정상적으로 로그를 전송하였습니다."
    }

    private void showErrorReportPopup(String s) {
        b.v(this.getSupportFragmentManager(), "오류 보고", "비정상적으로 종료되었습니다. \n로그를 전송하시겠습니까?", false, "취소", "확인", new w0(25, this, s), new e3(this, 6));
    }
}

