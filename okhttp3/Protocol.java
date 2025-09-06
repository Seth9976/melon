package okhttp3;

import ie.d;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0003H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\r"}, d2 = {"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum Protocol {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Protocol get(@NotNull String s) {
            q.g(s, "protocol");
            Protocol protocol0 = Protocol.HTTP_1_0;
            if(s.equals("http/1.0")) {
                return protocol0;
            }
            Protocol protocol1 = Protocol.HTTP_1_1;
            if(s.equals("http/1.1")) {
                return protocol1;
            }
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if(s.equals("h2_prior_knowledge")) {
                return protocol2;
            }
            Protocol protocol3 = Protocol.HTTP_2;
            if(s.equals("h2")) {
                return protocol3;
            }
            Protocol protocol4 = Protocol.SPDY_3;
            if(s.equals("spdy/3.1")) {
                return protocol4;
            }
            Protocol protocol5 = Protocol.QUIC;
            if(!s.equals("quic")) {
                throw new IOException("Unexpected protocol: " + s);
            }
            return protocol5;
        }
    }

    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    @d
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String protocol;

    private static final Protocol[] $values() [...] // Inlined contents

    static {
        Protocol.Companion = new Companion(null);
    }

    private Protocol(String s1) {
        this.protocol = s1;
    }

    public static final String access$getProtocol$p(Protocol protocol0) {
        return protocol0.protocol;
    }

    @NotNull
    public static final Protocol get(@NotNull String s) {
        return Protocol.Companion.get(s);
    }

    @Override
    @NotNull
    public String toString() {
        return this.protocol;
    }
}

