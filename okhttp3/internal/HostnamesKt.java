package okhttp3.internal;

import Tf.o;
import Tf.v;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A0\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005H\u0002\u001A\"\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0002\u001A\u0010\u0010\f\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\bH\u0002\u001A\f\u0010\r\u001A\u00020\u0001*\u00020\u0003H\u0002\u001A\f\u0010\u000E\u001A\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000F"}, d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String s) {
        int v = s.length();
        int v1 = 0;
        while(v1 < v) {
            int v2 = s.charAt(v1);
            if(q.h(v2, 0x1F) > 0 && q.h(v2, 0x7F) < 0 && o.E0(" #%/:?@[\\]", ((char)v2), 0, 6) == -1) {
                ++v1;
                continue;
            }
            return true;
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String s, int v, int v1, byte[] arr_b, int v2) {
        int v3 = v2;
        while(v < v1) {
            if(v3 == arr_b.length) {
                return false;
            }
            if(v3 != v2) {
                if(s.charAt(v) != 46) {
                    return false;
                }
                ++v;
            }
            int v4 = v;
            int v5 = 0;
            while(v4 < v1) {
                int v6 = s.charAt(v4);
                if(q.h(v6, 0x30) < 0 || q.h(v6, 57) > 0) {
                    break;
                }
                if(v5 == 0 && v != v4) {
                    return false;
                }
                v5 = v5 * 10 + v6 - 0x30;
                if(v5 > 0xFF) {
                    return false;
                }
                ++v4;
            }
            if(v4 - v == 0) {
                return false;
            }
            arr_b[v3] = (byte)v5;
            ++v3;
            v = v4;
        }
        return v3 == v2 + 4;
    }

    private static final InetAddress decodeIpv6(String s, int v, int v1) {
        byte[] arr_b = new byte[16];
        int v2 = 0;
        int v3 = -1;
        int v4 = -1;
        while(v < v1) {
            if(v2 == 16) {
                return null;
            }
            if(v + 2 > v1 || !v.q0(v, s, "::", false)) {
                if(v2 != 0) {
                    if(v.q0(v, s, ":", false)) {
                        ++v;
                        goto label_20;
                    }
                    if(!v.q0(v, s, ".", false) || !HostnamesKt.decodeIpv4Suffix(s, v4, v1, arr_b, v2 - 2)) {
                        return null;
                    }
                    v2 += 2;
                    break;
                }
            label_20:
                v4 = v;
            }
            else {
                if(v3 != -1) {
                    return null;
                }
                v2 += 2;
                v3 = v2;
                if(v + 2 == v1) {
                    break;
                }
                v4 = v + 2;
            }
            int v5 = 0;
            for(v = v4; v < v1; ++v) {
                int v6 = Util.parseHexDigit(s.charAt(v));
                if(v6 == -1) {
                    break;
                }
                v5 = (v5 << 4) + v6;
            }
            if(v - v4 == 0 || v - v4 > 4) {
                return null;
            }
            int v7 = v2 + 1;
            arr_b[v2] = (byte)(v5 >>> 8 & 0xFF);
            v2 += 2;
            arr_b[v7] = (byte)(v5 & 0xFF);
        }
        if(v2 != 16) {
            if(v3 == -1) {
                return null;
            }
            System.arraycopy(arr_b, v3, arr_b, 16 - (v2 - v3), v2 - v3);
            Arrays.fill(arr_b, v3, 16 - v2 + v3, 0);
        }
        return InetAddress.getByAddress(arr_b);
    }

    private static final String inet6AddressToAscii(byte[] arr_b) {
        int v = -1;
        int v1 = 0;
        int v3 = 0;
        for(int v2 = 0; v2 < arr_b.length; v2 = v4 + 2) {
            int v4;
            for(v4 = v2; v4 < 16 && arr_b[v4] == 0 && arr_b[v4 + 1] == 0; v4 += 2) {
            }
            int v5 = v4 - v2;
            if(v5 > v3 && v5 >= 4) {
                v = v2;
                v3 = v5;
            }
        }
        Buffer buffer0 = new Buffer();
        while(v1 < arr_b.length) {
            if(v1 == v) {
                buffer0.writeByte(58);
                v1 += v3;
                if(v1 != 16) {
                    continue;
                }
                buffer0.writeByte(58);
            }
            else {
                if(v1 > 0) {
                    buffer0.writeByte(58);
                }
                buffer0.writeHexadecimalUnsignedLong(((long)(Util.and(arr_b[v1], ((byte)0xFF)) << 8 | Util.and(arr_b[v1 + 1], ((byte)0xFF)))));
                v1 += 2;
            }
        }
        return "";
    }

    @Nullable
    public static final String toCanonicalHost(@NotNull String s) {
        q.g(s, "<this>");
        if(o.v0(s, ":", false)) {
            InetAddress inetAddress0 = !v.r0(s, "[", false) || !v.i0(s, "]", false) ? HostnamesKt.decodeIpv6(s, 0, s.length()) : HostnamesKt.decodeIpv6(s, 1, s.length() - 1);
            if(inetAddress0 != null) {
                byte[] arr_b = inetAddress0.getAddress();
                if(arr_b.length == 16) {
                    return HostnamesKt.inet6AddressToAscii(arr_b);
                }
                if(arr_b.length != 4) {
                    throw new AssertionError("Invalid IPv6 address: \'" + s + '\'');
                }
                return inetAddress0.getHostAddress();
            }
        }
        else {
            try {
                String s1 = IDN.toASCII(s);
                q.f(s1, "toASCII(host)");
                Locale locale0 = Locale.US;
                q.f(locale0, "US");
                String s2 = s1.toLowerCase(locale0);
                q.f(s2, "this as java.lang.String).toLowerCase(locale)");
                if(s2.length() != 0 && !HostnamesKt.containsInvalidHostnameAsciiCodes(s2)) {
                    return s2;
                }
            }
            catch(IllegalArgumentException unused_ex) {
            }
        }
        return null;
    }
}

