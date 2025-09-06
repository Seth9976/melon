package okhttp3;

import ie.d;
import java.io.Closeable;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001XB}\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001A\u00020\f\u0012\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u0012\b\u0010\u0010\u001A\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\u0006\u0010\u0015\u001A\u00020\u0013\u0012\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\t\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b \u0010!J\u0011\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0007\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00060%2\u0006\u0010$\u001A\u00020\u0006\u00A2\u0006\u0004\b\r\u0010&J%\u0010(\u001A\u0004\u0018\u00010\u00062\u0006\u0010$\u001A\u00020\u00062\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b(\u0010)J\u000F\u0010\r\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b*\u0010+J\r\u0010,\u001A\u00020\f\u00A2\u0006\u0004\b,\u0010+J\u0015\u0010.\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020\u0013\u00A2\u0006\u0004\b.\u0010/J\u0011\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0007\u00A2\u0006\u0004\b0\u00101J\r\u00103\u001A\u000202\u00A2\u0006\u0004\b3\u00104J\u0011\u0010\u0010\u001A\u0004\u0018\u00010\u0000H\u0007\u00A2\u0006\u0004\b5\u00106J\u0011\u0010\u0011\u001A\u0004\u0018\u00010\u0000H\u0007\u00A2\u0006\u0004\b7\u00106J\u0011\u0010\u0012\u001A\u0004\u0018\u00010\u0000H\u0007\u00A2\u0006\u0004\b8\u00106J\u0013\u0010:\u001A\b\u0012\u0004\u0012\u0002090%\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010?\u001A\u00020<H\u0007\u00A2\u0006\u0004\b=\u0010>J\u000F\u0010\u0014\u001A\u00020\u0013H\u0007\u00A2\u0006\u0004\b@\u0010AJ\u000F\u0010\u0015\u001A\u00020\u0013H\u0007\u00A2\u0006\u0004\bB\u0010AJ\u000F\u0010D\u001A\u00020CH\u0016\u00A2\u0006\u0004\bD\u0010EJ\u000F\u0010F\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\bF\u0010!R\u0017\u0010\u0003\u001A\u00020\u00028\u0007\u00A2\u0006\f\n\u0004\b\u0003\u0010G\u001A\u0004\b\u0003\u0010\u001BR\u0017\u0010\u0005\u001A\u00020\u00048\u0007\u00A2\u0006\f\n\u0004\b\u0005\u0010H\u001A\u0004\b\u0005\u0010\u001DR\u0017\u0010\u0007\u001A\u00020\u00068\u0007\u00A2\u0006\f\n\u0004\b\u0007\u0010I\u001A\u0004\b\u0007\u0010!R\u0017\u0010\t\u001A\u00020\b8\u0007\u00A2\u0006\f\n\u0004\b\t\u0010J\u001A\u0004\b\t\u0010\u001FR\u0019\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0007\u00A2\u0006\f\n\u0004\b\u000B\u0010K\u001A\u0004\b\u000B\u0010#R\u0017\u0010\r\u001A\u00020\f8\u0007\u00A2\u0006\f\n\u0004\b\r\u0010L\u001A\u0004\b\r\u0010+R\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0007\u00A2\u0006\f\n\u0004\b\u000F\u0010M\u001A\u0004\b\u000F\u00101R\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u00008\u0007\u00A2\u0006\f\n\u0004\b\u0010\u0010N\u001A\u0004\b\u0010\u00106R\u0019\u0010\u0011\u001A\u0004\u0018\u00010\u00008\u0007\u00A2\u0006\f\n\u0004\b\u0011\u0010N\u001A\u0004\b\u0011\u00106R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00008\u0007\u00A2\u0006\f\n\u0004\b\u0012\u0010N\u001A\u0004\b\u0012\u00106R\u0017\u0010\u0014\u001A\u00020\u00138\u0007\u00A2\u0006\f\n\u0004\b\u0014\u0010O\u001A\u0004\b\u0014\u0010AR\u0017\u0010\u0015\u001A\u00020\u00138\u0007\u00A2\u0006\f\n\u0004\b\u0015\u0010O\u001A\u0004\b\u0015\u0010AR\u001C\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0001X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0017\u0010P\u001A\u0004\b\u0017\u0010QR\u0018\u0010R\u001A\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0011\u0010U\u001A\u00020T8F\u00A2\u0006\u0006\u001A\u0004\bU\u0010VR\u0011\u0010W\u001A\u00020T8F\u00A2\u0006\u0006\u001A\u0004\bW\u0010VR\u0011\u0010?\u001A\u00020<8G\u00A2\u0006\u0006\u001A\u0004\b?\u0010>\u00A8\u0006Y"}, d2 = {"Lokhttp3/Response;", "Ljava/io/Closeable;", "Lokhttp3/Request;", "request", "Lokhttp3/Protocol;", "protocol", "", "message", "", "code", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Headers;", "headers", "Lokhttp3/ResponseBody;", "body", "networkResponse", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "exchange", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "-deprecated_request", "()Lokhttp3/Request;", "-deprecated_protocol", "()Lokhttp3/Protocol;", "-deprecated_code", "()I", "-deprecated_message", "()Ljava/lang/String;", "-deprecated_handshake", "()Lokhttp3/Handshake;", "name", "", "(Ljava/lang/String;)Ljava/util/List;", "defaultValue", "header", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "-deprecated_headers", "()Lokhttp3/Headers;", "trailers", "byteCount", "peekBody", "(J)Lokhttp3/ResponseBody;", "-deprecated_body", "()Lokhttp3/ResponseBody;", "Lokhttp3/Response$Builder;", "newBuilder", "()Lokhttp3/Response$Builder;", "-deprecated_networkResponse", "()Lokhttp3/Response;", "-deprecated_cacheResponse", "-deprecated_priorResponse", "Lokhttp3/Challenge;", "challenges", "()Ljava/util/List;", "Lokhttp3/CacheControl;", "-deprecated_cacheControl", "()Lokhttp3/CacheControl;", "cacheControl", "-deprecated_sentRequestAtMillis", "()J", "-deprecated_receivedResponseAtMillis", "Lie/H;", "close", "()V", "toString", "Lokhttp3/Request;", "Lokhttp3/Protocol;", "Ljava/lang/String;", "I", "Lokhttp3/Handshake;", "Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "Lokhttp3/Response;", "J", "Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/internal/connection/Exchange;", "lazyCacheControl", "Lokhttp3/CacheControl;", "", "isSuccessful", "()Z", "isRedirect", "Builder", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Response implements Closeable {
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u001E\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016\u00A2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0002\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001A\u00020\u00002\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001A\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0012J\u0017\u0010\u001D\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0019\u0010 \u001A\u00020\u00002\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0016\u00A2\u0006\u0004\b \u0010!J\u0019\u0010\"\u001A\u00020\u00002\b\u0010\"\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0019\u0010$\u001A\u00020\u00002\b\u0010$\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b$\u0010#J\u0019\u0010%\u001A\u00020\u00002\b\u0010%\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b%\u0010#J\u0017\u0010\'\u001A\u00020\u00002\u0006\u0010\'\u001A\u00020&H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\u00002\u0006\u0010)\u001A\u00020&H\u0016\u00A2\u0006\u0004\b)\u0010(J\u0017\u0010/\u001A\u00020,2\u0006\u0010+\u001A\u00020*H\u0000\u00A2\u0006\u0004\b-\u0010.J\u000F\u00100\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b0\u00101J!\u00102\u001A\u00020,2\u0006\u0010\u0016\u001A\u00020\u00102\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b2\u00103J\u0019\u00104\u001A\u00020,2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b4\u0010\u0006R$\u0010\b\u001A\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\b\u00105\u001A\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u0010:\u001A\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010\u000E\u001A\u00020\r8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u000E\u0010?\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010\u0011\u001A\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u0011\u0010D\u001A\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010\u0014\u001A\u0004\u0018\u00010\u00138\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u0014\u0010I\u001A\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010\u001D\u001A\u00020N8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u001D\u0010O\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010 \u001A\u0004\u0018\u00010\u001F8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b \u0010T\u001A\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\"\u001A\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\"\u0010Y\u001A\u0004\bZ\u00101\"\u0004\b[\u0010\u0006R$\u0010$\u001A\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b$\u0010Y\u001A\u0004\b\\\u00101\"\u0004\b]\u0010\u0006R$\u0010%\u001A\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b%\u0010Y\u001A\u0004\b^\u00101\"\u0004\b_\u0010\u0006R\"\u0010\'\u001A\u00020&8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\'\u0010`\u001A\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010)\u001A\u00020&8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010`\u001A\u0004\be\u0010b\"\u0004\bf\u0010dR$\u0010g\u001A\u0004\u0018\u00010*8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bg\u0010h\u001A\u0004\bi\u0010j\"\u0004\bk\u0010.\u00A8\u0006l"}, d2 = {"Lokhttp3/Response$Builder;", "", "<init>", "()V", "Lokhttp3/Response;", "response", "(Lokhttp3/Response;)V", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;)Lokhttp3/Response$Builder;", "Lokhttp3/Protocol;", "protocol", "(Lokhttp3/Protocol;)Lokhttp3/Response$Builder;", "", "code", "(I)Lokhttp3/Response$Builder;", "", "message", "(Ljava/lang/String;)Lokhttp3/Response$Builder;", "Lokhttp3/Handshake;", "handshake", "(Lokhttp3/Handshake;)Lokhttp3/Response$Builder;", "name", "value", "header", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Response$Builder;", "addHeader", "removeHeader", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;)Lokhttp3/Response$Builder;", "Lokhttp3/ResponseBody;", "body", "(Lokhttp3/ResponseBody;)Lokhttp3/Response$Builder;", "networkResponse", "(Lokhttp3/Response;)Lokhttp3/Response$Builder;", "cacheResponse", "priorResponse", "", "sentRequestAtMillis", "(J)Lokhttp3/Response$Builder;", "receivedResponseAtMillis", "Lokhttp3/internal/connection/Exchange;", "deferredTrailers", "Lie/H;", "initExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "initExchange", "build", "()Lokhttp3/Response;", "checkSupportResponse", "(Ljava/lang/String;Lokhttp3/Response;)V", "checkPriorResponse", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "I", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lokhttp3/Headers$Builder;", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "Lokhttp3/Response;", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "getCacheResponse$okhttp", "setCacheResponse$okhttp", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static class Builder {
        @Nullable
        private ResponseBody body;
        @Nullable
        private Response cacheResponse;
        private int code;
        @Nullable
        private Exchange exchange;
        @Nullable
        private Handshake handshake;
        @NotNull
        private okhttp3.Headers.Builder headers;
        @Nullable
        private String message;
        @Nullable
        private Response networkResponse;
        @Nullable
        private Response priorResponse;
        @Nullable
        private Protocol protocol;
        private long receivedResponseAtMillis;
        @Nullable
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new okhttp3.Headers.Builder();
        }

        public Builder(@NotNull Response response0) {
            q.g(response0, "response");
            super();
            this.code = -1;
            this.request = response0.request();
            this.protocol = response0.protocol();
            this.code = response0.code();
            this.message = response0.message();
            this.handshake = response0.handshake();
            this.headers = response0.headers().newBuilder();
            this.body = response0.body();
            this.networkResponse = response0.networkResponse();
            this.cacheResponse = response0.cacheResponse();
            this.priorResponse = response0.priorResponse();
            this.sentRequestAtMillis = response0.sentRequestAtMillis();
            this.receivedResponseAtMillis = response0.receivedResponseAtMillis();
            this.exchange = response0.exchange();
        }

        @NotNull
        public Builder addHeader(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            this.headers.add(s, s1);
            return this;
        }

        @NotNull
        public Builder body(@Nullable ResponseBody responseBody0) {
            this.body = responseBody0;
            return this;
        }

        @NotNull
        public Response build() {
            int v = this.code;
            if(v < 0) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request0 = this.request;
            if(request0 == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol0 = this.protocol;
            if(protocol0 == null) {
                throw new IllegalStateException("protocol == null");
            }
            String s = this.message;
            if(s == null) {
                throw new IllegalStateException("message == null");
            }
            return new Response(request0, protocol0, s, v, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
        }

        @NotNull
        public Builder cacheResponse(@Nullable Response response0) {
            this.checkSupportResponse("cacheResponse", response0);
            this.cacheResponse = response0;
            return this;
        }

        private final void checkPriorResponse(Response response0) {
            if(response0 != null && response0.body() != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private final void checkSupportResponse(String s, Response response0) {
            if(response0 != null) {
                if(response0.body() != null) {
                    throw new IllegalArgumentException((s + ".body != null").toString());
                }
                if(response0.networkResponse() != null) {
                    throw new IllegalArgumentException((s + ".networkResponse != null").toString());
                }
                if(response0.cacheResponse() != null) {
                    throw new IllegalArgumentException((s + ".cacheResponse != null").toString());
                }
                if(response0.priorResponse() != null) {
                    throw new IllegalArgumentException((s + ".priorResponse != null").toString());
                }
            }
        }

        @NotNull
        public Builder code(int v) {
            this.code = v;
            return this;
        }

        @Nullable
        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        @Nullable
        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        @Nullable
        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        @Nullable
        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        @NotNull
        public final okhttp3.Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        @Nullable
        public final String getMessage$okhttp() {
            return this.message;
        }

        @Nullable
        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        @Nullable
        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        @Nullable
        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        @Nullable
        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        @NotNull
        public Builder handshake(@Nullable Handshake handshake0) {
            this.handshake = handshake0;
            return this;
        }

        @NotNull
        public Builder header(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            this.headers.set(s, s1);
            return this;
        }

        @NotNull
        public Builder headers(@NotNull Headers headers0) {
            q.g(headers0, "headers");
            this.headers = headers0.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(@NotNull Exchange exchange0) {
            q.g(exchange0, "deferredTrailers");
            this.exchange = exchange0;
        }

        @NotNull
        public Builder message(@NotNull String s) {
            q.g(s, "message");
            this.message = s;
            return this;
        }

        @NotNull
        public Builder networkResponse(@Nullable Response response0) {
            this.checkSupportResponse("networkResponse", response0);
            this.networkResponse = response0;
            return this;
        }

        @NotNull
        public Builder priorResponse(@Nullable Response response0) {
            this.checkPriorResponse(response0);
            this.priorResponse = response0;
            return this;
        }

        @NotNull
        public Builder protocol(@NotNull Protocol protocol0) {
            q.g(protocol0, "protocol");
            this.protocol = protocol0;
            return this;
        }

        @NotNull
        public Builder receivedResponseAtMillis(long v) {
            this.receivedResponseAtMillis = v;
            return this;
        }

        @NotNull
        public Builder removeHeader(@NotNull String s) {
            q.g(s, "name");
            this.headers.removeAll(s);
            return this;
        }

        @NotNull
        public Builder request(@NotNull Request request0) {
            q.g(request0, "request");
            this.request = request0;
            return this;
        }

        @NotNull
        public Builder sentRequestAtMillis(long v) {
            this.sentRequestAtMillis = v;
            return this;
        }

        public final void setBody$okhttp(@Nullable ResponseBody responseBody0) {
            this.body = responseBody0;
        }

        public final void setCacheResponse$okhttp(@Nullable Response response0) {
            this.cacheResponse = response0;
        }

        public final void setCode$okhttp(int v) {
            this.code = v;
        }

        public final void setExchange$okhttp(@Nullable Exchange exchange0) {
            this.exchange = exchange0;
        }

        public final void setHandshake$okhttp(@Nullable Handshake handshake0) {
            this.handshake = handshake0;
        }

        public final void setHeaders$okhttp(@NotNull okhttp3.Headers.Builder headers$Builder0) {
            q.g(headers$Builder0, "<set-?>");
            this.headers = headers$Builder0;
        }

        public final void setMessage$okhttp(@Nullable String s) {
            this.message = s;
        }

        public final void setNetworkResponse$okhttp(@Nullable Response response0) {
            this.networkResponse = response0;
        }

        public final void setPriorResponse$okhttp(@Nullable Response response0) {
            this.priorResponse = response0;
        }

        public final void setProtocol$okhttp(@Nullable Protocol protocol0) {
            this.protocol = protocol0;
        }

        public final void setReceivedResponseAtMillis$okhttp(long v) {
            this.receivedResponseAtMillis = v;
        }

        public final void setRequest$okhttp(@Nullable Request request0) {
            this.request = request0;
        }

        public final void setSentRequestAtMillis$okhttp(long v) {
            this.sentRequestAtMillis = v;
        }
    }

    @Nullable
    private final ResponseBody body;
    @Nullable
    private final Response cacheResponse;
    private final int code;
    @Nullable
    private final Exchange exchange;
    @Nullable
    private final Handshake handshake;
    @NotNull
    private final Headers headers;
    @Nullable
    private CacheControl lazyCacheControl;
    @NotNull
    private final String message;
    @Nullable
    private final Response networkResponse;
    @Nullable
    private final Response priorResponse;
    @NotNull
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    @NotNull
    private final Request request;
    private final long sentRequestAtMillis;

    @d
    @Nullable
    public final ResponseBody -deprecated_body() {
        return this.body;
    }

    @d
    @NotNull
    public final CacheControl -deprecated_cacheControl() {
        return this.cacheControl();
    }

    @d
    @Nullable
    public final Response -deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @d
    public final int -deprecated_code() {
        return this.code;
    }

    @d
    @Nullable
    public final Handshake -deprecated_handshake() {
        return this.handshake;
    }

    @d
    @NotNull
    public final Headers -deprecated_headers() {
        return this.headers;
    }

    @d
    @NotNull
    public final String -deprecated_message() {
        return this.message;
    }

    @d
    @Nullable
    public final Response -deprecated_networkResponse() {
        return this.networkResponse;
    }

    @d
    @Nullable
    public final Response -deprecated_priorResponse() {
        return this.priorResponse;
    }

    @d
    @NotNull
    public final Protocol -deprecated_protocol() {
        return this.protocol;
    }

    @d
    public final long -deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @d
    @NotNull
    public final Request -deprecated_request() {
        return this.request;
    }

    @d
    public final long -deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public Response(@NotNull Request request0, @NotNull Protocol protocol0, @NotNull String s, int v, @Nullable Handshake handshake0, @NotNull Headers headers0, @Nullable ResponseBody responseBody0, @Nullable Response response0, @Nullable Response response1, @Nullable Response response2, long v1, long v2, @Nullable Exchange exchange0) {
        q.g(request0, "request");
        q.g(protocol0, "protocol");
        q.g(s, "message");
        q.g(headers0, "headers");
        super();
        this.request = request0;
        this.protocol = protocol0;
        this.message = s;
        this.code = v;
        this.handshake = handshake0;
        this.headers = headers0;
        this.body = responseBody0;
        this.networkResponse = response0;
        this.cacheResponse = response1;
        this.priorResponse = response2;
        this.sentRequestAtMillis = v1;
        this.receivedResponseAtMillis = v2;
        this.exchange = exchange0;
    }

    @Nullable
    public final ResponseBody body() {
        return this.body;
    }

    @NotNull
    public final CacheControl cacheControl() {
        CacheControl cacheControl0 = this.lazyCacheControl;
        if(cacheControl0 == null) {
            cacheControl0 = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = cacheControl0;
        }
        return cacheControl0;
    }

    @Nullable
    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    @NotNull
    public final List challenges() {
        Headers headers0 = this.headers;
        switch(this.code) {
            case 401: {
                return HttpHeaders.parseChallenges(headers0, "WWW-Authenticate");
            }
            case 407: {
                return HttpHeaders.parseChallenges(headers0, "Proxy-Authenticate");
            }
            default: {
                return w.a;
            }
        }
    }

    @Override
    public void close() {
        ResponseBody responseBody0 = this.body;
        if(responseBody0 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody0.close();
    }

    public final int code() {
        return this.code;
    }

    @Nullable
    public final Exchange exchange() {
        return this.exchange;
    }

    @Nullable
    public final Handshake handshake() {
        return this.handshake;
    }

    @Nullable
    public final String header(@NotNull String s) {
        q.g(s, "name");
        return Response.header$default(this, s, null, 2, null);
    }

    @Nullable
    public final String header(@NotNull String s, @Nullable String s1) {
        q.g(s, "name");
        String s2 = this.headers.get(s);
        return s2 == null ? s1 : s2;
    }

    public static String header$default(Response response0, String s, String s1, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        return response0.header(s, s1);
    }

    @NotNull
    public final List headers(@NotNull String s) {
        q.g(s, "name");
        return this.headers.values(s);
    }

    @NotNull
    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        return this.code == 307 || this.code == 308 || (this.code == 300 || this.code == 301 || this.code == 302 || this.code == 303);
    }

    public final boolean isSuccessful() {
        return 200 <= this.code && this.code < 300;
    }

    @NotNull
    public final String message() {
        return this.message;
    }

    @Nullable
    public final Response networkResponse() {
        return this.networkResponse;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @NotNull
    public final ResponseBody peekBody(long v) {
        q.d(this.body);
        BufferedSource bufferedSource0 = this.body.source().peek();
        Buffer buffer0 = new Buffer();
        bufferedSource0.request(v);
        buffer0.write(bufferedSource0, Math.min(v, bufferedSource0.getBuffer().size()));
        MediaType mediaType0 = this.body.contentType();
        return ResponseBody.Companion.create(buffer0, mediaType0, buffer0.size());
    }

    @Nullable
    public final Response priorResponse() {
        return this.priorResponse;
    }

    @NotNull
    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @NotNull
    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @Override
    @NotNull
    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    @NotNull
    public final Headers trailers() {
        Exchange exchange0 = this.exchange;
        if(exchange0 == null) {
            throw new IllegalStateException("trailers not available");
        }
        return exchange0.trailers();
    }
}

