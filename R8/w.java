package R8;

import R6.c;
import com.iloen.melon.constants.CType;
import com.iloen.melon.utils.log.DcfLog;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import x8.b;

public final class w extends b {
    public Exception a;

    @Override  // x8.f
    public final Object backgroundWork(Object object0, Continuation continuation0) {
        Void void0 = (Void)object0;
        try {
            l l0 = c.g();
            q.f(CType.EDU, "EDU");
            l0.k("TaskDcfExtendInfoForEducation", new CType[]{CType.EDU});
        }
        catch(Exception exception0) {
            this.a = exception0;
            DcfLog.w("TaskDcfExtendInfoForEducation", exception0.toString());
        }
        return H.a;
    }
}

