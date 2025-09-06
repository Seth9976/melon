package com.iloen.melon.task;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.utils.log.LogU;

class ReportService.1 implements ErrorListener {
    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        LogU.w("ReportService", "report::onErrorResponse() " + HttpResponse.getErrorMessage(volleyError0));
    }
}

