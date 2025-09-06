package l8;

import com.android.volley.Response.Listener;
import com.iloen.melon.activity.ErrorReportActivity;
import com.iloen.melon.net.HttpResponse;

public final class q implements Listener {
    public final ErrorReportActivity a;

    public q(ErrorReportActivity errorReportActivity0) {
        this.a = errorReportActivity0;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        HttpResponse httpResponse0 = (HttpResponse)object0;
        this.a.finish();
    }
}

