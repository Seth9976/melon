package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.ConnectionSpec;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000E\u0010\u000B\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\rJ\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0010J\u0010\u0010\b\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\rH\u0002R\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/ConnectionSpecSelector;", "", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "(Ljava/util/List;)V", "isFallback", "", "isFallbackPossible", "nextModeIndex", "", "configureSecureSocket", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionFailed", "e", "Ljava/io/IOException;", "socket", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ConnectionSpecSelector {
    @NotNull
    private final List connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(@NotNull List list0) {
        q.g(list0, "connectionSpecs");
        super();
        this.connectionSpecs = list0;
    }

    @NotNull
    public final ConnectionSpec configureSecureSocket(@NotNull SSLSocket sSLSocket0) {
        ConnectionSpec connectionSpec0;
        q.g(sSLSocket0, "sslSocket");
        int v = this.nextModeIndex;
        int v1 = this.connectionSpecs.size();
        while(true) {
            connectionSpec0 = null;
            if(v >= v1) {
                break;
            }
            connectionSpec0 = (ConnectionSpec)this.connectionSpecs.get(v);
            if(connectionSpec0.isCompatible(sSLSocket0)) {
                this.nextModeIndex = v + 1;
                break;
            }
            ++v;
        }
        if(connectionSpec0 != null) {
            this.isFallbackPossible = this.isFallbackPossible(sSLSocket0);
            connectionSpec0.apply$okhttp(sSLSocket0, this.isFallback);
            return connectionSpec0;
        }
        String[] arr_s = sSLSocket0.getEnabledProtocols();
        q.d(arr_s);
        String s = Arrays.toString(arr_s);
        q.f(s, "toString(this)");
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.isFallback + ", modes=" + this.connectionSpecs + ", supported protocols=" + s);
    }

    public final boolean connectionFailed(@NotNull IOException iOException0) {
        q.g(iOException0, "e");
        this.isFallback = true;
        if(!this.isFallbackPossible) {
            return false;
        }
        if(iOException0 instanceof ProtocolException) {
            return false;
        }
        if(iOException0 instanceof InterruptedIOException) {
            return false;
        }
        if(iOException0 instanceof SSLHandshakeException && iOException0.getCause() instanceof CertificateException) {
            return false;
        }
        return iOException0 instanceof SSLPeerUnverifiedException ? false : iOException0 instanceof SSLException;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket0) {
        int v = this.nextModeIndex;
        int v1 = this.connectionSpecs.size();
        while(v < v1) {
            if(((ConnectionSpec)this.connectionSpecs.get(v)).isCompatible(sSLSocket0)) {
                return true;
            }
            ++v;
        }
        return false;
    }
}

