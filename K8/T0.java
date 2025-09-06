package k8;

import A7.d;
import Tf.o;
import android.widget.TextView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.EpPlayLogger.DebugReqInfo;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.DeviceIdentifier;
import ie.H;
import java.time.format.DateTimeFormatter;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class t0 extends i implements n {
    public Object r;
    public final TextView w;

    public t0(TextView textView0, Continuation continuation0) {
        this.w = textView0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((t0)this.create(((K0)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        K0 k00 = (K0)this.r;
        d5.n.D(object0);
        MelonAppBase.Companion.getClass();
        StringBuilder stringBuilder0 = d.o("pcId:", DeviceIdentifier.id(t.a().getDeviceData().a), "\nmemKey:", k00.a, "\nmcpVer:");
        stringBuilder0.append(k00.b);
        stringBuilder0.append("\nnotSentEditCount:");
        stringBuilder0.append(k00.c);
        String s = stringBuilder0.toString();
        DebugReqInfo epPlayLogger$DebugReqInfo0 = k00.d;
        if(epPlayLogger$DebugReqInfo0 != null) {
            String s1 = epPlayLogger$DebugReqInfo0.getReqTimeStampInfo().format(DateTimeFormatter.ofPattern("MM-dd,HH:mm:ss"));
            String s2 = o.d1(5, epPlayLogger$DebugReqInfo0.getPlayableName());
            String s3 = StringUtils.INSTANCE.formatPlayerTime(epPlayLogger$DebugReqInfo0.getPlayPosition());
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(s);
            stringBuilder1.append("\nLastEpPlay:");
            stringBuilder1.append(s1);
            stringBuilder1.append("/");
            stringBuilder1.append(epPlayLogger$DebugReqInfo0.getAction());
            s = d.n(stringBuilder1, "/", s2, ".../", s3);
        }
        this.w.setText(s);
        return H.a;
    }
}

