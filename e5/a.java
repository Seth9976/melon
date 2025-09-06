package E5;

import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.ArrayList;

public final class a implements Callback {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        if(this.a != 0) {
            ErrorReportHandler.a(((ArrayList)this.b), graphResponse0);
            return;
        }
        ExceptionAnalyzer.a(((InstrumentData)this.b), graphResponse0);
    }
}

