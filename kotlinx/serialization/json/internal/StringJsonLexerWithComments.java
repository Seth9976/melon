package kotlinx.serialization.json.internal;

import Tf.o;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u0007\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0007\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexerWithComments;", "Lkotlinx/serialization/json/internal/StringJsonLexer;", "", "source", "<init>", "(Ljava/lang/String;)V", "", "consumeNextToken", "()B", "", "canConsumeValue", "()Z", "", "expected", "Lie/H;", "(C)V", "peekNextToken", "", "skipWhitespaces", "()I", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class StringJsonLexerWithComments extends StringJsonLexer {
    public StringJsonLexerWithComments(@NotNull String s) {
        q.g(s, "source");
        super(s);
    }

    @Override  // kotlinx.serialization.json.internal.StringJsonLexer
    public boolean canConsumeValue() {
        int v = this.skipWhitespaces();
        return v >= this.getSource().length() || v == -1 ? false : this.isValidValueStart(this.getSource().charAt(v));
    }

    @Override  // kotlinx.serialization.json.internal.StringJsonLexer
    public byte consumeNextToken() {
        String s = this.getSource();
        int v = this.skipWhitespaces();
        if(v < s.length() && v != -1) {
            this.currentPosition = v + 1;
            return AbstractJsonLexerKt.charToTokenClass(s.charAt(v));
        }
        return 10;
    }

    @Override  // kotlinx.serialization.json.internal.StringJsonLexer
    public void consumeNextToken(char c) {
        String s = this.getSource();
        int v = this.skipWhitespaces();
        if(v >= s.length() || v == -1) {
            this.currentPosition = -1;
            this.unexpectedToken(c);
        }
        this.currentPosition = v + 1;
        if(s.charAt(v) == c) {
            return;
        }
        this.unexpectedToken(c);
    }

    @Override  // kotlinx.serialization.json.internal.AbstractJsonLexer
    public byte peekNextToken() {
        String s = this.getSource();
        int v = this.skipWhitespaces();
        if(v < s.length() && v != -1) {
            this.currentPosition = v;
            return AbstractJsonLexerKt.charToTokenClass(s.charAt(v));
        }
        return 10;
    }

    @Override  // kotlinx.serialization.json.internal.StringJsonLexer
    public int skipWhitespaces() {
        int v = this.currentPosition;
        if(v == -1) {
            return -1;
        }
        String s = this.getSource();
    label_4:
        while(v < s.length()) {
            int v1 = s.charAt(v);
            if(v1 != 9 && v1 != 10 && v1 != 13 && v1 != 0x20) {
                if(v1 != 0x2F || v + 1 >= s.length()) {
                    break;
                }
                switch(s.charAt(v + 1)) {
                    case 42: {
                        int v2 = o.F0(s, "*/", v + 2, false, 4);
                        if(v2 != -1) {
                            v = v2 + 2;
                            continue;
                        }
                        this.currentPosition = s.length();
                        AbstractJsonLexer.fail$default(this, "Expected end of the block comment: \"*/\", but had EOF instead", 0, null, 6, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    case 0x2F: {
                        int v3 = o.E0(s, '\n', v + 2, 4);
                        if(v3 == -1) {
                            v = s.length();
                            continue;
                        }
                        else {
                            v = v3;
                        }
                        break;
                    }
                    default: {
                        break label_4;
                    }
                }
            }
            ++v;
        }
        this.currentPosition = v;
        return v;
    }
}

