package l8;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.activity.ErrorReportActivity;

public final class p implements ErrorListener {
    public final ErrorReportActivity a;

    public p(ErrorReportActivity errorReportActivity0) {
        this.a = errorReportActivity0;
    }

    @Override  // com.android.volley.Response$ErrorListener
    public final void onErrorResponse(VolleyError volleyError0) {
        this.a.finish();
    }
}

