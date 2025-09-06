package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer.UnsafeCursor;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\t\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0010\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\r\u00A2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\r8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001A\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0017R\u0014\u0010\u001B\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001B\u0010\u0017R\u0014\u0010\u001C\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u0017R\u0014\u0010\u001D\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u0017R\u0014\u0010\u001E\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u0017R\u0014\u0010\u001F\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001F\u0010\u0017R\u0014\u0010 \u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010!\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b!\u0010\u0017R\u0014\u0010\"\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\"\u0010\u0017R\u0014\u0010#\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b#\u0010\u0017R\u0014\u0010$\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b$\u0010\u0017R\u0014\u0010&\u001A\u00020%8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020%8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b(\u0010\'R\u0014\u0010)\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b)\u0010\u0017R\u0014\u0010*\u001A\u00020%8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b*\u0010\'R\u0014\u0010+\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b+\u0010\u0017R\u0014\u0010,\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b,\u0010\u0017R\u0014\u0010-\u001A\u00020\u000B8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b-\u0010\u0017\u00A8\u0006."}, d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "<init>", "()V", "Lokio/Buffer$UnsafeCursor;", "cursor", "", "key", "Lie/H;", "toggleMask", "(Lokio/Buffer$UnsafeCursor;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "ACCEPT_MAGIC", "Ljava/lang/String;", "B0_FLAG_FIN", "I", "B0_FLAG_RSV1", "B0_FLAG_RSV2", "B0_FLAG_RSV3", "B0_MASK_OPCODE", "OPCODE_FLAG_CONTROL", "B1_FLAG_MASK", "B1_MASK_LENGTH", "OPCODE_CONTINUATION", "OPCODE_TEXT", "OPCODE_BINARY", "OPCODE_CONTROL_CLOSE", "OPCODE_CONTROL_PING", "OPCODE_CONTROL_PONG", "", "PAYLOAD_BYTE_MAX", "J", "CLOSE_MESSAGE_MAX", "PAYLOAD_SHORT", "PAYLOAD_SHORT_MAX", "PAYLOAD_LONG", "CLOSE_CLIENT_GOING_AWAY", "CLOSE_NO_STATUS_CODE", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WebSocketProtocol {
    @NotNull
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 0x80;
    public static final int B0_FLAG_RSV1 = 0x40;
    public static final int B0_FLAG_RSV2 = 0x20;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 0x80;
    public static final int B1_MASK_LENGTH = 0x7F;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 0x7BL;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    @NotNull
    public static final WebSocketProtocol INSTANCE = null;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 0x7DL;
    public static final int PAYLOAD_LONG = 0x7F;
    public static final int PAYLOAD_SHORT = 0x7E;
    public static final long PAYLOAD_SHORT_MAX = 0xFFFFL;

    static {
        WebSocketProtocol.INSTANCE = new WebSocketProtocol();
    }

    @NotNull
    public final String acceptHeader(@NotNull String s) {
        q.g(s, "key");
        return ByteString.Companion.encodeUtf8(s + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
    }

    @Nullable
    public final String closeCodeExceptionMessage(int v) {
        if(v >= 1000 && v < 5000) {
            return (1004 > v || v >= 1007) && (0x3F7 > v || v >= 3000) ? null : "Code " + v + " is reserved and may not be used.";
        }
        return "Code must be in range [1000,5000): " + v;
    }

    public final void toggleMask(@NotNull UnsafeCursor buffer$UnsafeCursor0, @NotNull byte[] arr_b) {
        q.g(buffer$UnsafeCursor0, "cursor");
        q.g(arr_b, "key");
        do {
            byte[] arr_b1 = buffer$UnsafeCursor0.data;
            int v1 = buffer$UnsafeCursor0.start;
            int v2 = buffer$UnsafeCursor0.end;
            if(arr_b1 != null) {
                for(int v = 0; v1 < v2; v = v3 + 1) {
                    int v3 = v % arr_b.length;
                    arr_b1[v1] = (byte)(arr_b1[v1] ^ arr_b[v3]);
                    ++v1;
                }
            }
        }
        while(buffer$UnsafeCursor0.next() != -1);
    }

    public final void validateCloseCode(int v) {
        String s = this.closeCodeExceptionMessage(v);
        if(s == null) {
            return;
        }
        q.d(s);
        throw new IllegalArgumentException(s.toString());
    }
}

