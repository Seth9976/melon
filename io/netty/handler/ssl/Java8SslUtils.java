package io.netty.handler.ssl;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class Java8SslUtils {
    public static boolean checkSniHostnameMatch(Collection collection0, byte[] arr_b) {
        if(collection0 != null && !collection0.isEmpty()) {
            SNIHostName sNIHostName0 = new SNIHostName(arr_b);
            for(Object object0: collection0) {
                if(((SNIMatcher)object0).getType() == 0 && ((SNIMatcher)object0).matches(sNIHostName0)) {
                    return true;
                }
                if(false) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public static List getSniHostName(byte[] arr_b) {
        return arr_b == null || arr_b.length == 0 ? Collections.EMPTY_LIST : Collections.singletonList(new SNIHostName(arr_b));
    }

    public static List getSniHostNames(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            List list1 = new ArrayList(list0.size());
            for(Object object0: list0) {
                ((ArrayList)list1).add(new SNIHostName(((String)object0).getBytes(CharsetUtil.UTF_8)));
            }
            return list1;
        }
        return Collections.EMPTY_LIST;
    }

    public static List getSniHostNames(SSLParameters sSLParameters0) {
        List list0 = sSLParameters0.getServerNames();
        if(list0 != null && !list0.isEmpty()) {
            List list1 = new ArrayList(list0.size());
            for(Object object0: list0) {
                SNIServerName sNIServerName0 = (SNIServerName)object0;
                if(!(sNIServerName0 instanceof SNIHostName)) {
                    throw new IllegalArgumentException("Only javax.net.ssl.SNIHostName instances are supported, but found: " + sNIServerName0);
                }
                ((ArrayList)list1).add(((SNIHostName)sNIServerName0).getAsciiName());
            }
            return list1;
        }
        return Collections.EMPTY_LIST;
    }

    public static boolean getUseCipherSuitesOrder(SSLParameters sSLParameters0) {
        return sSLParameters0.getUseCipherSuitesOrder();
    }

    public static boolean isValidHostNameForSNI(String s) {
        try {
            new SNIHostName(s);
            return true;
        }
        catch(IllegalArgumentException unused_ex) {
            return false;
        }
    }

    public static void setSNIMatchers(SSLParameters sSLParameters0, Collection collection0) {
        sSLParameters0.setSNIMatchers(collection0);
    }

    public static void setSniHostNames(SSLParameters sSLParameters0, List list0) {
        sSLParameters0.setServerNames(Java8SslUtils.getSniHostNames(list0));
    }

    public static void setUseCipherSuitesOrder(SSLParameters sSLParameters0, boolean z) {
        sSLParameters0.setUseCipherSuitesOrder(z);
    }
}

