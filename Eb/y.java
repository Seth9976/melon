package eb;

import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.util.Map;
import kotlin.coroutines.Continuation;
import ne.a;

public final class y {
    public final w a;
    public final LogU b;

    public y(w w0) {
        this.a = w0;
        LogU logU0 = new LogU("PvLogDummyLog-UA");
        logU0.setCategory(Category.None);
        logU0.setUseThreadInfo(true);
        this.b = logU0;
    }

    public final Object a(String s, Map map0, Continuation continuation0) {
        x x0;
        if(continuation0 instanceof x) {
            x0 = (x)continuation0;
            int v = x0.B;
            if((v & 0x80000000) == 0) {
                x0 = new x(this, continuation0);
            }
            else {
                x0.B = v ^ 0x80000000;
            }
        }
        else {
            x0 = new x(this, continuation0);
        }
        Object object0 = x0.r;
        a a0 = a.a;
        switch(x0.B) {
            case 0: {
                n.D(object0);
                try {
                    x0.B = 1;
                    if(this.a.a(s, map0, x0) == a0) {
                        return a0;
                    }
                }
                catch(Exception exception0) {
                    LogU.warn$default(this.b, "performDummyLog() error: " + exception0.getMessage(), null, false, 6, null);
                }
                return H.a;
            }
            case 1: {
                try {
                    n.D(object0);
                }
                catch(Exception exception0) {
                    LogU.warn$default(this.b, "performDummyLog() error: " + exception0.getMessage(), null, false, 6, null);
                }
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

