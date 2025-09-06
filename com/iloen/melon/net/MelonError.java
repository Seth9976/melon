package com.iloen.melon.net;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v3x.ResponseV3Res;

public class MelonError {
    public static final BigDataError BIG_DATA_ERROR;
    public static final HttpConnectionError HTTP_CONNECTION_ERROR;
    public static final HttpResponseError HTTP_RESPONSE_ERROR;
    public static final ServerResponseError SERVER_RESPONSE_ERROR;

    static {
        MelonError.HTTP_CONNECTION_ERROR = new HttpConnectionError(MelonError.fromResourceMessage(0x7F1303D9));  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                                                                                                 // 후 다시 이용해주세요."
        MelonError.HTTP_RESPONSE_ERROR = new HttpResponseError(MelonError.fromResourceMessage(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        MelonError.SERVER_RESPONSE_ERROR = new ServerResponseError(MelonError.fromResourceMessage(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        MelonError.BIG_DATA_ERROR = new BigDataError(MelonError.fromResourceMessage(0x7F1303C6));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    public static VolleyError from(HttpResponse httpResponse0) {
        if(httpResponse0 == null) {
            return MelonError.SERVER_RESPONSE_ERROR;
        }
        if(httpResponse0 instanceof ResponseV3Res) {
            if(!TextUtils.isEmpty(((ResponseV3Res)httpResponse0).errormsg)) {
                return MelonError.fromServerMessage(((ResponseV3Res)httpResponse0).errormsg);
            }
            if(!TextUtils.isEmpty(((ResponseV3Res)httpResponse0).message)) {
                return MelonError.fromServerMessage(((ResponseV3Res)httpResponse0).message);
            }
        }
        return MelonError.SERVER_RESPONSE_ERROR;
    }

    public static final VolleyError from(Throwable throwable0) {
        return new ClientDefinedError(throwable0.getMessage());
    }

    public static final VolleyError fromClientMessage(int v) {
        return new ClientDefinedError(MelonError.fromResourceMessage(v));
    }

    public static final VolleyError fromClientMessage(String s) {
        return new ClientDefinedError(s);
    }

    public static final String fromResourceMessage(int v) {
        return MelonAppBase.instance.getContext().getResources().getString(v);
    }

    public static final VolleyError fromServerMessage(String s) {
        return new ServerResponseError(s, true);
    }

    public static final VolleyError fromServerMessage(String s, String s1) {
        return new ServerResponseError(s, s1);
    }
}

