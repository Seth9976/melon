package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001F\u0010\u000B\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000B\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\u000B\u0010\rJ\u001F\u0010\u0010\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0010\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00168\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/json/internal/CharMappings;", "", "<init>", "()V", "Lie/H;", "initEscape", "initCharToToken", "", "c", "", "esc", "initC2ESC", "(IC)V", "(CC)V", "", "cl", "initC2TC", "(IB)V", "(CB)V", "", "ESCAPE_2_CHAR", "[C", "", "CHAR_TO_TOKEN", "[B", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class CharMappings {
    @NotNull
    public static final byte[] CHAR_TO_TOKEN;
    @NotNull
    public static final char[] ESCAPE_2_CHAR;
    @NotNull
    public static final CharMappings INSTANCE;

    static {
        CharMappings charMappings0 = new CharMappings();
        CharMappings.INSTANCE = charMappings0;
        CharMappings.ESCAPE_2_CHAR = new char[0x75];
        CharMappings.CHAR_TO_TOKEN = new byte[0x7E];
        charMappings0.initEscape();
        charMappings0.initCharToToken();
    }

    private final void initC2ESC(char c, char c1) {
        this.initC2ESC(((int)c), c1);
    }

    private final void initC2ESC(int v, char c) {
        if(c != 0x75) {
            CharMappings.ESCAPE_2_CHAR[c] = (char)v;
        }
    }

    private final void initC2TC(char c, byte b) {
        this.initC2TC(((int)c), b);
    }

    private final void initC2TC(int v, byte b) {
        CharMappings.CHAR_TO_TOKEN[v] = b;
    }

    private final void initCharToToken() {
        for(int v = 0; v < 33; ++v) {
            this.initC2TC(v, 0x7F);
        }
        this.initC2TC(9, 3);
        this.initC2TC(10, 3);
        this.initC2TC(13, 3);
        this.initC2TC(0x20, 3);
        this.initC2TC(',', 4);
        this.initC2TC(':', 5);
        this.initC2TC('{', 6);
        this.initC2TC('}', 7);
        this.initC2TC('[', 8);
        this.initC2TC(']', 9);
        this.initC2TC('\"', 1);
        this.initC2TC('\\', 2);
    }

    private final void initEscape() {
        for(int v = 0; v < 0x20; ++v) {
            this.initC2ESC(v, 'u');
        }
        this.initC2ESC(8, 'b');
        this.initC2ESC(9, 't');
        this.initC2ESC(10, 'n');
        this.initC2ESC(12, 'f');
        this.initC2ESC(13, 'r');
        this.initC2ESC('/', '/');
        this.initC2ESC('\"', '\"');
        this.initC2ESC('\\', '\\');
    }
}

