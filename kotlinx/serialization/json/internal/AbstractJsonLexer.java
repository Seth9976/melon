package kotlinx.serialization.json.internal;

import Tf.o;
import U4.x;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import je.p;
import je.u;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\r\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH&\u00A2\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH&\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\n\u00A2\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0011H\u0004\u00A2\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0015\u0010\u0003J\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\r\u00A2\u0006\u0004\b\u000E\u0010\u0017J\u0017\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0011H&\u00A2\u0006\u0004\b\u000E\u0010\u0018J\u0017\u0010\u0019\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0011H\u0004\u00A2\u0006\u0004\b\u0019\u0010\u0018J!\u0010\u001F\u001A\u00020\u001C2\u0006\u0010\u001A\u001A\u00020\r2\b\b\u0002\u0010\u001B\u001A\u00020\nH\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\rH\u0016\u00A2\u0006\u0004\b \u0010\u000FJ\u0017\u0010\"\u001A\u00020\n2\b\b\u0002\u0010!\u001A\u00020\n\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u0006H&\u00A2\u0006\u0004\b$\u0010%J!\u0010)\u001A\u0004\u0018\u00010&2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020\nH&\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u0004\u0018\u00010&2\u0006\u0010(\u001A\u00020\n\u00A2\u0006\u0004\b+\u0010,J\r\u0010-\u001A\u00020\u0004\u00A2\u0006\u0004\b-\u0010\u0003J\u001F\u00100\u001A\u00020&2\u0006\u0010.\u001A\u00020\u00062\u0006\u0010/\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020&H&\u00A2\u0006\u0004\b2\u00103J\r\u00104\u001A\u00020&\u00A2\u0006\u0004\b4\u00103J\'\u00104\u001A\u00020&2\u0006\u00106\u001A\u0002052\u0006\u00107\u001A\u00020\u00062\u0006\u00108\u001A\u00020\u0006H\u0005\u00A2\u0006\u0004\b4\u00109J\r\u0010:\u001A\u00020&\u00A2\u0006\u0004\b:\u00103J\r\u0010;\u001A\u00020&\u00A2\u0006\u0004\b;\u00103J\u001F\u0010>\u001A\u00020\u00042\u0006\u0010<\u001A\u00020\u00062\u0006\u0010=\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b>\u0010?J\u0015\u0010A\u001A\u00020\u00042\u0006\u0010@\u001A\u00020\n\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010C\u001A\u00020&H\u0016\u00A2\u0006\u0004\bC\u00103J\u0015\u0010E\u001A\u00020\u00042\u0006\u0010D\u001A\u00020&\u00A2\u0006\u0004\bE\u0010FJ)\u0010\u001F\u001A\u00020\u001C2\u0006\u0010G\u001A\u00020&2\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010H\u001A\u00020&\u00A2\u0006\u0004\b\u001F\u0010IJ\r\u0010K\u001A\u00020J\u00A2\u0006\u0004\bK\u0010LJ\r\u0010M\u001A\u00020\n\u00A2\u0006\u0004\bM\u0010\fJ\u001F\u0010O\u001A\u00020\u00062\u0006\u0010N\u001A\u00020\u00062\u0006\u00108\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bO\u0010PJ\u001F\u0010R\u001A\u00020&2\u0006\u0010N\u001A\u00020\u00062\u0006\u0010Q\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bR\u00101J\u000F\u0010S\u001A\u00020&H\u0002\u00A2\u0006\u0004\bS\u00103J\u000F\u0010T\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bT\u0010\fJ\u0017\u0010U\u001A\u00020\u00062\u0006\u00107\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bU\u0010\tJ\u001F\u0010V\u001A\u00020\u00062\u0006\u00106\u001A\u0002052\u0006\u0010.\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bV\u0010WJ\u001F\u0010X\u001A\u00020\u00062\u0006\u00106\u001A\u0002052\u0006\u0010Q\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bX\u0010WJ\u0017\u0010Z\u001A\u00020\n2\u0006\u0010Y\u001A\u00020\u0006H\u0003\u00A2\u0006\u0004\bZ\u0010[J\u001F\u0010]\u001A\u00020\u00042\u0006\u0010\\\u001A\u00020&2\u0006\u00108\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b]\u0010^R\u0016\u0010Q\u001A\u00020\u00068\u0000@\u0000X\u0081\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010_R\u0014\u0010a\u001A\u00020`8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001A\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010dR&\u0010g\u001A\u00060ej\u0002`f8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bg\u0010h\u001A\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u00106\u001A\u0002058$X\u00A4\u0004\u00A2\u0006\u0006\u001A\u0004\bm\u0010n\u00A8\u0006o"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "", "<init>", "()V", "Lie/H;", "ensureHaveChars", "", "position", "prefetchOrEof", "(I)I", "", "canConsumeValue", "()Z", "", "consumeNextToken", "()B", "tryConsumeComma", "", "c", "isValidValueStart", "(C)Z", "expectEof", "expected", "(B)B", "(C)V", "unexpectedToken", "expectedToken", "wasConsumed", "", "fail$kotlinx_serialization_json", "(BZ)Ljava/lang/Void;", "fail", "peekNextToken", "doConsume", "tryConsumeNull", "(Z)Z", "skipWhitespaces", "()I", "", "keyToMatch", "isLenient", "peekLeadingMatchingValue", "(Ljava/lang/String;Z)Ljava/lang/String;", "peekString", "(Z)Ljava/lang/String;", "discardPeeked", "startPos", "endPos", "substring", "(II)Ljava/lang/String;", "consumeKeyString", "()Ljava/lang/String;", "consumeString", "", "source", "startPosition", "current", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "consumeStringLenientNotNull", "consumeStringLenient", "fromIndex", "toIndex", "appendRange", "(II)V", "allowLenientStrings", "skipElement", "(Z)V", "toString", "key", "failOnUnknownKey", "(Ljava/lang/String;)V", "message", "hint", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Void;", "", "consumeNumericLiteral", "()J", "consumeBooleanLenient", "lastPosition", "appendEscape", "(II)I", "currentPosition", "decodedString", "takePeeked", "wasUnquotedString", "appendEsc", "appendHex", "(Ljava/lang/CharSequence;I)I", "fromHexChar", "start", "consumeBoolean", "(I)Z", "literalSuffix", "consumeBooleanLiteral", "(Ljava/lang/String;I)V", "I", "Lkotlinx/serialization/json/internal/JsonPath;", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "escapedString", "Ljava/lang/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "getSource", "()Ljava/lang/CharSequence;", "kotlinx-serialization-json"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractJsonLexer {
    public int currentPosition;
    @NotNull
    private StringBuilder escapedString;
    @NotNull
    public final JsonPath path;
    @Nullable
    private String peekedString;

    public AbstractJsonLexer() {
        this.path = new JsonPath();
        this.escapedString = new StringBuilder();
    }

    private final int appendEsc(int v) {
        int v1 = this.prefetchOrEof(v);
        if(v1 != -1) {
            int v2 = this.getSource().charAt(v1);
            if(v2 == 0x75) {
                return this.appendHex(this.getSource(), v1 + 1);
            }
            int v3 = AbstractJsonLexerKt.escapeToChar(v2);
            if(v3 != 0) {
                this.escapedString.append(((char)v3));
                return v1 + 1;
            }
            AbstractJsonLexer.fail$default(this, "Invalid escaped char \'" + ((char)v2) + '\'', 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        AbstractJsonLexer.fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final int appendEscape(int v, int v1) {
        this.appendRange(v, v1);
        return this.appendEsc(v1 + 1);
    }

    private final int appendHex(CharSequence charSequence0, int v) {
        if(v + 4 >= charSequence0.length()) {
            this.currentPosition = v;
            if(this.currentPosition + 4 < charSequence0.length()) {
                return this.appendHex(charSequence0, this.currentPosition);
            }
            AbstractJsonLexer.fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        this.escapedString.append(((char)((this.fromHexChar(charSequence0, v) << 12) + (this.fromHexChar(charSequence0, v + 1) << 8) + (this.fromHexChar(charSequence0, v + 2) << 4) + this.fromHexChar(charSequence0, v + 3))));
        return v + 4;
    }

    public void appendRange(int v, int v1) {
        this.escapedString.append(this.getSource(), v, v1);
    }

    public abstract boolean canConsumeValue();

    private final boolean consumeBoolean(int v) {
        int v1 = this.prefetchOrEof(v);
        if(v1 < this.getSource().length() && v1 != -1) {
            switch(this.getSource().charAt(v1) | 0x20) {
                case 102: {
                    this.consumeBooleanLiteral("alse", v1 + 1);
                    return false;
                }
                case 0x74: {
                    this.consumeBooleanLiteral("rue", v1 + 1);
                    return true;
                }
                default: {
                    AbstractJsonLexer.fail$default(this, "Expected valid boolean literal prefix, but had \'" + this.consumeStringLenient() + '\'', 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        AbstractJsonLexer.fail$default(this, "EOF", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public final boolean consumeBooleanLenient() {
        boolean z;
        int v = this.skipWhitespaces();
        if(v != this.getSource().length()) {
            if(this.getSource().charAt(v) == 34) {
                ++v;
                z = true;
            }
            else {
                z = false;
            }
            boolean z1 = this.consumeBoolean(v);
            if(z) {
                if(this.currentPosition != this.getSource().length()) {
                    if(this.getSource().charAt(this.currentPosition) == 34) {
                        ++this.currentPosition;
                        return z1;
                    }
                    AbstractJsonLexer.fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                AbstractJsonLexer.fail$default(this, "EOF", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            return z1;
        }
        AbstractJsonLexer.fail$default(this, "EOF", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final void consumeBooleanLiteral(String s, int v) {
        if(this.getSource().length() - v >= s.length()) {
            int v1 = s.length();
            int v2 = 0;
            while(v2 < v1) {
                if(s.charAt(v2) == (this.getSource().charAt(v + v2) | 0x20)) {
                    ++v2;
                    continue;
                }
                AbstractJsonLexer.fail$default(this, "Expected valid boolean literal prefix, but had \'" + this.consumeStringLenient() + '\'', 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            this.currentPosition = s.length() + v;
            return;
        }
        AbstractJsonLexer.fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte b) {
        byte b1 = this.consumeNextToken();
        if(b1 == b) {
            return b1;
        }
        AbstractJsonLexer.fail$kotlinx_serialization_json$default(this, b, false, 2, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public abstract void consumeNextToken(char arg1);

    public final long consumeNumericLiteral() {
        int v4;
        boolean z3;
        boolean z;
        int v = this.prefetchOrEof(this.skipWhitespaces());
        if(v < this.getSource().length() && v != -1) {
            if(this.getSource().charAt(v) == 34) {
                ++v;
                if(v != this.getSource().length()) {
                    z = true;
                    goto label_10;
                }
                AbstractJsonLexer.fail$default(this, "EOF", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            else {
                z = false;
            }
        label_10:
            int v1 = v;
            boolean z1 = false;
            boolean z2 = false;
            long v2 = 0L;
            long v3 = 0L;
            while(true) {
                z3 = false;
            label_16:
                if(v1 == this.getSource().length()) {
                    goto label_58;
                }
                v4 = this.getSource().charAt(v1);
                if((v4 == 69 || v4 == 101) && !z1) {
                    if(v1 != v) {
                        ++v1;
                        z1 = true;
                        z3 = true;
                        goto label_16;
                    }
                    AbstractJsonLexer.fail$default(this, "Unexpected symbol " + ((char)v4) + " in numeric literal", 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                if(v4 != 45 || !z1) {
                    goto label_32;
                }
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
            AbstractJsonLexer.fail$default(this, "Unexpected symbol \'-\' in numeric literal", 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        label_32:
            if(v4 == 43 && z1) {
                if(v1 != v) {
                    ++v1;
                    z3 = true;
                    goto label_16;
                }
                AbstractJsonLexer.fail$default(this, "Unexpected symbol \'+\' in numeric literal", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            else if(v4 == 45) {
                if(v1 == v) {
                    ++v1;
                    z2 = true;
                    goto label_16;
                }
                AbstractJsonLexer.fail$default(this, "Unexpected symbol \'-\' in numeric literal", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            else if(AbstractJsonLexerKt.charToTokenClass(((char)v4)) == 0) {
                ++v1;
                if(v4 - 0x30 >= 0 && v4 - 0x30 < 10) {
                    if(z1) {
                        v3 = v3 * 10L + ((long)(v4 - 0x30));
                        goto label_16;
                    }
                    else {
                        v2 = v2 * 10L - ((long)(v4 - 0x30));
                        if(v2 <= 0L) {
                            goto label_16;
                        }
                        AbstractJsonLexer.fail$default(this, "Numeric value overflow", 0, null, 6, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                AbstractJsonLexer.fail$default(this, "Unexpected symbol \'" + ((char)v4) + "\' in numeric literal", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        label_58:
            if(v != v1 && (!z2 || v != v1 - 1)) {
                if(z) {
                    if(v1 != v) {
                        if(this.getSource().charAt(v1) == 34) {
                            ++v1;
                            goto label_68;
                        }
                        AbstractJsonLexer.fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    AbstractJsonLexer.fail$default(this, "EOF", 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            label_68:
                this.currentPosition = v1;
                if(z1) {
                    double f = ((double)v2) * AbstractJsonLexer.consumeNumericLiteral$calculateExponent(v3, z3);
                    if(f <= 9223372036854776000.0 && f >= -9223372036854776000.0) {
                        if(Math.floor(f) == f) {
                            v2 = (long)f;
                            goto label_79;
                        }
                        AbstractJsonLexer.fail$default(this, "Can\'t convert " + f + " to Long", 0, null, 6, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    AbstractJsonLexer.fail$default(this, "Numeric value overflow", 0, null, 6, null);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            label_79:
                if(z2) {
                    return v2;
                }
                if(v2 != 0x8000000000000000L) {
                    return -v2;
                }
                AbstractJsonLexer.fail$default(this, "Numeric value overflow", 0, null, 6, null);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            AbstractJsonLexer.fail$default(this, "Expected numeric literal", 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        AbstractJsonLexer.fail$default(this, "EOF", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private static final double consumeNumericLiteral$calculateExponent(long v, boolean z) {
        switch(z) {
            case 0: {
                return Math.pow(10.0, -((double)v));
            }
            case 1: {
                return Math.pow(10.0, v);
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @NotNull
    public final String consumeString() {
        return this.peekedString == null ? this.consumeKeyString() : this.takePeeked();
    }

    @NotNull
    public final String consumeString(@NotNull CharSequence charSequence0, int v, int v1) {
        q.g(charSequence0, "source");
        int v2 = charSequence0.charAt(v1);
        boolean z = false;
    alab1:
        while(true) {
            switch(v2) {
                case 34: {
                    String s = z ? this.decodedString(v, v1) : this.substring(v, v1);
                    this.currentPosition = v1 + 1;
                    return s;
                label_8:
                    ++v1;
                    if(v1 >= charSequence0.length()) {
                        this.appendRange(v, v1);
                        int v3 = this.prefetchOrEof(v1);
                        if(v3 != -1) {
                            v = v3;
                            v1 = v;
                            z = true;
                            break;
                        }
                        AbstractJsonLexer.fail$default(this, "Unexpected EOF", -1, null, 4, null);
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    break;
                }
                case 92: {
                    int v4 = this.prefetchOrEof(this.appendEscape(v, v1));
                    if(v4 == -1) {
                        break alab1;
                    }
                    z = true;
                    v = v4;
                    v1 = v;
                    break;
                }
                default: {
                    goto label_8;
                }
            }
            v2 = charSequence0.charAt(v1);
        }
        AbstractJsonLexer.fail$default(this, "Unexpected EOF", -1, null, 4, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public final String consumeStringLenient() {
        if(this.peekedString != null) {
            return this.takePeeked();
        }
        int v = this.skipWhitespaces();
        if(v < this.getSource().length() && v != -1) {
            int v1 = AbstractJsonLexerKt.charToTokenClass(this.getSource().charAt(v));
            if(v1 == 1) {
                return this.consumeString();
            }
            if(v1 == 0) {
                boolean z = false;
                while(AbstractJsonLexerKt.charToTokenClass(this.getSource().charAt(v)) == 0) {
                    ++v;
                    if(v >= this.getSource().length()) {
                        this.appendRange(this.currentPosition, v);
                        int v2 = this.prefetchOrEof(v);
                        if(v2 == -1) {
                            this.currentPosition = v;
                            return this.decodedString(0, 0);
                        }
                        v = v2;
                        z = true;
                    }
                }
                String s = z ? this.decodedString(this.currentPosition, v) : this.substring(this.currentPosition, v);
                this.currentPosition = v;
                return s;
            }
            AbstractJsonLexer.fail$default(this, "Expected beginning of the string, but got " + this.getSource().charAt(v), 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        AbstractJsonLexer.fail$default(this, "EOF", v, null, 4, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public final String consumeStringLenientNotNull() {
        String s = this.consumeStringLenient();
        if(q.b(s, "null") && this.wasUnquotedString()) {
            AbstractJsonLexer.fail$default(this, "Unexpected \'null\' value instead of string literal", 0, null, 6, null);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return s;
    }

    private final String decodedString(int v, int v1) {
        this.appendRange(v, v1);
        String s = this.escapedString.toString();
        q.f(s, "toString(...)");
        this.escapedString.setLength(0);
        return s;
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public void ensureHaveChars() {
    }

    public final void expectEof() {
        if(this.consumeNextToken() == 10) {
            return;
        }
        AbstractJsonLexer.fail$default(this, "Expected EOF after parsing, but had " + this.getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public final Void fail(@NotNull String s, int v, @NotNull String s1) {
        q.g(s, "message");
        q.g(s1, "hint");
        String s2 = s1.length() == 0 ? "" : "\n" + s1;
        StringBuilder stringBuilder0 = x.p(s, " at path: ");
        stringBuilder0.append("$");
        stringBuilder0.append(s2);
        throw JsonExceptionsKt.JsonDecodingException(v, stringBuilder0.toString(), this.getSource());
    }

    public static Void fail$default(AbstractJsonLexer abstractJsonLexer0, String s, int v, String s1, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if((v1 & 2) != 0) {
            v = abstractJsonLexer0.currentPosition;
        }
        if((v1 & 4) != 0) {
            s1 = "";
        }
        return abstractJsonLexer0.fail(s, v, s1);
    }

    @NotNull
    public final Void fail$kotlinx_serialization_json(byte b, boolean z) {
        int v = z ? this.currentPosition - 1 : this.currentPosition;
        AbstractJsonLexer.fail$default(this, "Expected " + AbstractJsonLexerKt.tokenDescription(b) + ", but had \'" + (this.currentPosition == this.getSource().length() || v < 0 ? "EOF" : String.valueOf(this.getSource().charAt(v))) + "\' instead", v, null, 4, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public static Void fail$kotlinx_serialization_json$default(AbstractJsonLexer abstractJsonLexer0, byte b, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if((v & 2) != 0) {
            z = true;
        }
        return abstractJsonLexer0.fail$kotlinx_serialization_json(b, z);
    }

    public final void failOnUnknownKey(@NotNull String s) {
        q.g(s, "key");
        this.fail("Encountered an unknown key \'" + s + '\'', o.K0(this.substring(0, this.currentPosition), s, 0, 6), "Use \'ignoreUnknownKeys = true\' in \'Json {}\' builder to ignore unknown keys.");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final int fromHexChar(CharSequence charSequence0, int v) {
        int v1 = charSequence0.charAt(v);
        if(0x30 <= v1 && v1 < 58) {
            return v1 - 0x30;
        }
        if(97 <= v1 && v1 < 103) {
            return v1 - 87;
        }
        if(65 <= v1 && v1 < 71) {
            return v1 - 55;
        }
        AbstractJsonLexer.fail$default(this, "Invalid toHexChar char \'" + ((char)v1) + "\' in unicode escape", 0, null, 6, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @NotNull
    public abstract CharSequence getSource();

    public final boolean isValidValueStart(char c) {
        return c != 44 && c != 58 && c != 93 && c != 0x7D;
    }

    @Nullable
    public abstract String peekLeadingMatchingValue(@NotNull String arg1, boolean arg2);

    public byte peekNextToken() {
        CharSequence charSequence0 = this.getSource();
        int v = this.currentPosition;
        int v1;
        while((v1 = this.prefetchOrEof(v)) != -1) {
            int v2 = charSequence0.charAt(v1);
            if(v2 != 9 && v2 != 10 && v2 != 13 && v2 != 0x20) {
                this.currentPosition = v1;
                return AbstractJsonLexerKt.charToTokenClass(((char)v2));
            }
            v = v1 + 1;
        }
        this.currentPosition = -1;
        return 10;
    }

    @Nullable
    public final String peekString(boolean z) {
        String s;
        int v = this.peekNextToken();
        if(z) {
            if(v != 0 && v != 1) {
                return null;
            }
            s = this.consumeStringLenient();
        }
        else {
            if(v != 1) {
                return null;
            }
            s = this.consumeString();
        }
        this.peekedString = s;
        return s;
    }

    public abstract int prefetchOrEof(int arg1);

    public final void skipElement(boolean z) {
        ArrayList arrayList0 = new ArrayList();
        int v = this.peekNextToken();
        if(v != 8 && v != 6) {
            this.consumeStringLenient();
            return;
        }
        while(true) {
            int v1 = this.peekNextToken();
            if(v1 != 1) {
                if(v1 == 6 || v1 == 8) {
                    arrayList0.add(((byte)v1));
                }
                else {
                    switch(v1) {
                        case 7: {
                            if(((Number)p.s0(arrayList0)).byteValue() != 6) {
                                throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, this.getSource());
                            }
                            u.Z(arrayList0);
                            break;
                        }
                        case 9: {
                            if(((Number)p.s0(arrayList0)).byteValue() != 8) {
                                throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, this.getSource());
                            }
                            u.Z(arrayList0);
                            break;
                        }
                        case 10: {
                            AbstractJsonLexer.fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                }
                this.consumeNextToken();
                if(arrayList0.size() == 0) {
                    break;
                }
            }
            else if(z) {
                this.consumeStringLenient();
            }
            else {
                this.consumeKeyString();
            }
        }
    }

    public abstract int skipWhitespaces();

    @NotNull
    public String substring(int v, int v1) {
        return this.getSource().subSequence(v, v1).toString();
    }

    private final String takePeeked() {
        String s = this.peekedString;
        q.d(s);
        this.peekedString = null;
        return s;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("JsonReader(source=\'");
        stringBuilder0.append(this.getSource());
        stringBuilder0.append("\', currentPosition=");
        return androidx.appcompat.app.o.q(stringBuilder0, this.currentPosition, ')');
    }

    public final boolean tryConsumeComma() {
        int v = this.skipWhitespaces();
        CharSequence charSequence0 = this.getSource();
        if(v < charSequence0.length() && v != -1 && charSequence0.charAt(v) == 44) {
            ++this.currentPosition;
            return true;
        }
        return false;
    }

    public final boolean tryConsumeNull(boolean z) {
        int v = this.prefetchOrEof(this.skipWhitespaces());
        int v1 = this.getSource().length() - v;
        if(v1 >= 4 && v != -1) {
            for(int v2 = 0; v2 < 4; ++v2) {
                if("null".charAt(v2) != this.getSource().charAt(v + v2)) {
                    return false;
                }
            }
            if(v1 > 4 && AbstractJsonLexerKt.charToTokenClass(this.getSource().charAt(v + 4)) == 0) {
                return false;
            }
            if(z) {
                this.currentPosition = v + 4;
            }
            return true;
        }
        return false;
    }

    public static boolean tryConsumeNull$default(AbstractJsonLexer abstractJsonLexer0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if((v & 1) != 0) {
            z = true;
        }
        return abstractJsonLexer0.tryConsumeNull(z);
    }

    public final void unexpectedToken(char c) {
        int v = this.currentPosition;
        if(v > 0 && c == 34) {
            try {
                this.currentPosition = v - 1;
                String s = this.consumeStringLenient();
            }
            finally {
                this.currentPosition = v;
            }
            if(q.b(s, "null")) {
                this.fail("Expected string literal but \'null\' literal was found", this.currentPosition - 1, "Use \'coerceInputValues = true\' in \'Json {}\' builder to coerce nulls if property has a default value.");
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        AbstractJsonLexer.fail$kotlinx_serialization_json$default(this, AbstractJsonLexerKt.charToTokenClass(c), false, 2, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private final boolean wasUnquotedString() {
        return this.getSource().charAt(this.currentPosition - 1) != 34;
    }
}

