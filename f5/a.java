package F5;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler.Companion;
import java.util.List;

public final class a implements Callback {
    public final int a;
    public final List b;

    public a(List list0, int v) {
        this.a = v;
        this.b = list0;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        if(this.a != 0) {
            Companion.a(this.b, graphResponse0);
            return;
        }
        ANRHandler.b(this.b, graphResponse0);
    }
}

