package co.ab180.airbridge.internal.e0;

import Tf.o;
import co.ab180.airbridge.internal.b;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lco/ab180/airbridge/internal/e0/z;", "", "", "a", "()Ljava/lang/String;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class z {
    @NotNull
    public static final z a;

    static {
        z.a = new z();
    }

    @NotNull
    public final String a() {
        String s1;
        String s = "";
        try {
            Iterator iterator0 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        alab1:
            while(true) {
                if(!iterator0.hasNext()) {
                    return s;
                }
                Object object0 = iterator0.next();
                Iterator iterator1 = Collections.list(((NetworkInterface)object0).getInetAddresses()).iterator();
            label_6:
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    InetAddress inetAddress0 = (InetAddress)object1;
                    if(inetAddress0.isLoopbackAddress()) {
                        continue;
                    }
                    s1 = inetAddress0.getHostAddress();
                    if(o.E0(s1, ':', 0, 6) >= 0) {
                        continue;
                    }
                    break alab1;
                }
            }
        }
        catch(Exception exception0) {
            b.e.a(exception0);
            return s;
        }
        s = s1;
        goto label_6;
    }
}

