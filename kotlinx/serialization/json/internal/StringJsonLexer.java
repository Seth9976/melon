package kotlinx.serialization.json.internal;

import Tf.o;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u000B\u001A\u00020\u00142\u0006\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u000B\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001A\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001A\u00020\u00022\u0006\u0010\u0019\u001A\u00020\rH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u001A\u0010\u0003\u001A\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001C\u001A\u0004\b\u001D\u0010\u0017¨\u0006\u001E"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "source", "<init>", "(Ljava/lang/String;)V", "", "position", "prefetchOrEof", "(I)I", "", "consumeNextToken", "()B", "", "canConsumeValue", "()Z", "skipWhitespaces", "()I", "", "expected", "Lie/H;", "(C)V", "consumeKeyString", "()Ljava/lang/String;", "keyToMatch", "isLenient", "peekLeadingMatchingValue", "(Ljava/lang/String;Z)Ljava/lang/String;", "Ljava/lang/String;", "getSource", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class StringJsonLexer extends AbstractJsonLexer {
    @NotNull
    private final String source;

    public StringJsonLexer(@NotNull String s) {
        q.g(s, "source");
        super();
        this.source = s;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public boolean canConsumeValue() {
        int v = this.currentPosition;
        if(v == -1) {
            return false;
        }
        String s = this.getSource();
        while(v < s.length()) {
            int v1 = s.charAt(v);
            if(v1 != 9 && v1 != 10 && v1 != 13 && v1 != 0x20) {
                this.currentPosition = v;
                return this.isValidValueStart(((char)v1));
            }
            ++v;
        }
        this.currentPosition = v;
        return false;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    @NotNull
    public String consumeKeyString() {
        this.consumeNextToken('\"');
        int v = this.currentPosition;
        int v1 = o.E0(this.getSource(), '\"', v, 4);
        if(v1 != -1) {
            for(int v2 = v; v2 < v1; ++v2) {
                if(this.getSource().charAt(v2) == 92) {
                    return this.consumeString(this.getSource(), this.currentPosition, v2);
                }
            }
            this.currentPosition = v1 + 1;
            String s = this.getSource().substring(v, v1);
            q.f(s, "substring(...)");
            return s;
        }
        this.consumeStringLenient();
        this.fail$kotlinx_serialization_json(1, false);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte consumeNextToken() {
        String s = this.getSource();
        for(int v = this.currentPosition; v != -1 && v < s.length(); ++v) {
            int v1 = s.charAt(v);
            if(v1 != 10 && v1 != 0x20 && v1 != 13 && v1 != 9) {
                this.currentPosition = v + 1;
                return AbstractJsonLexerKt.charToTokenClass(((char)v1));
            }
        }
        this.currentPosition = s.length();
        return 10;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public void consumeNextToken(char c) {
        if(this.currentPosition == -1) {
            this.unexpectedToken(c);
        }
        String s = this.getSource();
        for(int v = this.currentPosition; v < s.length(); ++v) {
            int v1 = s.charAt(v);
            if(v1 != 9 && v1 != 10 && v1 != 13 && v1 != 0x20) {
                this.currentPosition = v + 1;
                if(v1 == c) {
                    return;
                }
                this.unexpectedToken(c);
            }
        }
        this.currentPosition = -1;
        this.unexpectedToken(c);
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public CharSequence getSource() {
        return this.getSource();
    }

    @NotNull
    public String getSource() {
        return this.source;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    @Nullable
    public String peekLeadingMatchingValue(@NotNull String s, boolean z) {
        q.g(s, "keyToMatch");
        int v = this.currentPosition;
        try {
            if(this.consumeNextToken() == 6 && q.b(this.peekString(z), s)) {
                this.discardPeeked();
                if(this.consumeNextToken() == 5) {
                    return this.peekString(z);
                }
            }
            return null;
        }
        finally {
            this.currentPosition = v;
            this.discardPeeked();
        }
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int prefetchOrEof(int v) {
        return v >= this.getSource().length() ? -1 : v;
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public int skipWhitespaces() {
        int v = this.currentPosition;
        if(v == -1) {
            return -1;
        }
        String s = this.getSource();
        while(v < s.length() && (s.charAt(v) == 9 || s.charAt(v) == 10 || s.charAt(v) == 13 || s.charAt(v) == 0x20)) {
            ++v;
        }
        this.currentPosition = v;
        return v;
    }
}

