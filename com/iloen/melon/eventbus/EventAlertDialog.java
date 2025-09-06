package com.iloen.melon.eventbus;

import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import javax.net.ssl.SSLHandshakeException;

public class EventAlertDialog {
    public final String message;
    public final String title;

    public EventAlertDialog(String s, String s1) {
        this.title = s;
        this.message = s1;
    }

    public static EventAlertDialog fromException(Exception exception0) {
        MelonAppBase.instance.getContext();
        String s = exception0.getMessage();
        Throwable throwable0 = exception0.getCause();
        if(throwable0 != null && throwable0 instanceof SSLHandshakeException) {
            s = "인증서가 유효하지 않습니다. 기기의 날짜/시간 설정 정보를 확인한 후에 다시 로그인해주세요.";
        }
        return new EventAlertDialog("안내", s);
    }

    public static EventAlertDialog fromNetworkError(int v) {
        return new EventAlertDialog("안내", MelonAppBase.instance.getContext().getString(v));
    }

    public static EventAlertDialog fromNetworkError(String s) {
        return new EventAlertDialog("안내", s);
    }

    public static EventAlertDialog fromVolleyError(VolleyError volleyError0) {
        MelonAppBase.instance.getContext();
        String s = volleyError0.getMessage();
        Throwable throwable0 = volleyError0.getCause();
        if(throwable0 != null && throwable0 instanceof SSLHandshakeException) {
            s = "인증서가 유효하지 않습니다. 기기의 날짜/시간 설정 정보를 확인한 후에 다시 로그인해주세요.";
        }
        return new EventAlertDialog("안내", s);
    }
}

