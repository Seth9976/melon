package kotlinx.serialization.json.internal;

import i.n.i.b.a.s.e.M3;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A\u0018\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0000\u001A\u0014\u0010\r\u001A\u00020\u000E*\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000BH\u0000\u001A\u0016\u0010\u0011\u001A\u00020\u000E*\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u0005H\u0000\u001A\u0010\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u0015H\u0000\u001A \u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005H\u0000\u001A \u0010\u0017\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005H\u0000\u001A \u0010\u0018\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0005H\u0002\u001A\u0018\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H\u0000\u001A\u0016\u0010\u001A\u001A\u00020\u0007*\u00020\u00072\b\b\u0002\u0010\u0002\u001A\u00020\u0003H\u0000¨\u0006\u001B"}, d2 = {"JsonDecodingException", "Lkotlinx/serialization/json/internal/JsonDecodingException;", "offset", "", "message", "", "input", "", "InvalidFloatingPointEncoded", "Lkotlinx/serialization/json/internal/JsonEncodingException;", "value", "", "output", "throwInvalidFloatingPointDecoded", "", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "result", "invalidTrailingComma", "entity", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "InvalidFloatingPointDecoded", "unexpectedFpErrorMessage", "UnknownKeyException", "minify", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class JsonExceptionsKt {
    @NotNull
    public static final JsonDecodingException InvalidFloatingPointDecoded(@NotNull Number number0, @NotNull String s, @NotNull String s1) {
        q.g(number0, "value");
        q.g(s, "key");
        q.g(s1, "output");
        return JsonExceptionsKt.JsonDecodingException(-1, JsonExceptionsKt.unexpectedFpErrorMessage(number0, s, s1));
    }

    @NotNull
    public static final JsonEncodingException InvalidFloatingPointEncoded(@NotNull Number number0, @NotNull String s) {
        q.g(number0, "value");
        q.g(s, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + number0 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using \'JsonBuilder.allowSpecialFloatingPointValues = true\'\nCurrent output: " + JsonExceptionsKt.minify$default(s, 0, 1, null));
    }

    @NotNull
    public static final JsonEncodingException InvalidFloatingPointEncoded(@NotNull Number number0, @NotNull String s, @NotNull String s1) {
        q.g(number0, "value");
        q.g(s, "key");
        q.g(s1, "output");
        return new JsonEncodingException(JsonExceptionsKt.unexpectedFpErrorMessage(number0, s, s1));
    }

    @NotNull
    public static final JsonEncodingException InvalidKeyKindException(@NotNull SerialDescriptor serialDescriptor0) {
        q.g(serialDescriptor0, "keyDescriptor");
        return new JsonEncodingException("Value of type \'" + serialDescriptor0.getSerialName() + "\' can\'t be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is \'" + serialDescriptor0.getKind() + "\'.\nUse \'allowStructuredMapKeys = true\' in \'Json {}\' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    @NotNull
    public static final JsonDecodingException JsonDecodingException(int v, @NotNull String s) {
        q.g(s, "message");
        if(v >= 0) {
            s = "Unexpected JSON token at offset " + v + ": " + s;
        }
        return new JsonDecodingException(s);
    }

    @NotNull
    public static final JsonDecodingException JsonDecodingException(int v, @NotNull String s, @NotNull CharSequence charSequence0) {
        q.g(s, "message");
        q.g(charSequence0, "input");
        return JsonExceptionsKt.JsonDecodingException(v, s + "\nJSON input: " + JsonExceptionsKt.minify(charSequence0, v));
    }

    @NotNull
    public static final JsonDecodingException UnknownKeyException(@NotNull String s, @NotNull String s1) {
        q.g(s, "key");
        q.g(s1, "input");
        return JsonExceptionsKt.JsonDecodingException(-1, "Encountered an unknown key \'" + s + "\'.\nUse \'ignoreUnknownKeys = true\' in \'Json {}\' builder to ignore unknown keys.\nCurrent input: " + JsonExceptionsKt.minify$default(s1, 0, 1, null));
    }

    @NotNull
    public static final Void invalidTrailingComma(@NotNull AbstractJsonLexer abstractJsonLexer0, @NotNull String s) {
        q.g(abstractJsonLexer0, "<this>");
        q.g(s, "entity");
        abstractJsonLexer0.fail("Trailing comma before the end of JSON " + s, abstractJsonLexer0.currentPosition - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use \'allowTrailingCommas = true\' in \'Json {}\' builder to support them.");
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public static Void invalidTrailingComma$default(AbstractJsonLexer abstractJsonLexer0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            s = "object";
        }
        return JsonExceptionsKt.invalidTrailingComma(abstractJsonLexer0, s);
    }

    @NotNull
    public static final CharSequence minify(@NotNull CharSequence charSequence0, int v) {
        String s = ".....";
        q.g(charSequence0, "<this>");
        if(charSequence0.length() >= 200) {
            if(v != -1) {
                goto label_7;
            }
            int v1 = charSequence0.length();
            if(v1 - 60 > 0) {
                return "....." + charSequence0.subSequence(v1 - 60, charSequence0.length()).toString();
            label_7:
                int v2 = v - 30;
                int v3 = v + 30;
                if(v3 >= charSequence0.length()) {
                    s = "";
                }
                StringBuilder stringBuilder0 = Y.p((v2 > 0 ? "....." : ""));
                if(v2 < 0) {
                    v2 = 0;
                }
                int v4 = charSequence0.length();
                if(v3 > v4) {
                    v3 = v4;
                }
                stringBuilder0.append(charSequence0.subSequence(v2, v3).toString());
                stringBuilder0.append(s);
                return stringBuilder0.toString();
            }
        }
        return charSequence0;
    }

    public static CharSequence minify$default(CharSequence charSequence0, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = -1;
        }
        return JsonExceptionsKt.minify(charSequence0, v);
    }

    @NotNull
    public static final Void throwInvalidFloatingPointDecoded(@NotNull AbstractJsonLexer abstractJsonLexer0, @NotNull Number number0) {
        q.g(abstractJsonLexer0, "<this>");
        q.g(number0, "result");
        AbstractJsonLexer.fail$default(abstractJsonLexer0, "Unexpected special floating-point value " + number0 + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using \'JsonBuilder.allowSpecialFloatingPointValues = true\'", 2, null);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    private static final String unexpectedFpErrorMessage(Number number0, String s, String s1) {
        return "Unexpected special floating-point value " + number0 + " with key " + s + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using \'JsonBuilder.allowSpecialFloatingPointValues = true\'\nCurrent output: " + JsonExceptionsKt.minify$default(s1, 0, 1, null);
    }
}

