package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u0017\u0010\u0007\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A\u0017\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"", "token", "", "tokenDescription", "(B)Ljava/lang/String;", "", "c", "charToTokenClass", "(C)B", "", "escapeToChar", "(I)C", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class AbstractJsonLexerKt {
    public static final byte charToTokenClass(char c) {
        return c >= 0x7E ? 0 : CharMappings.CHAR_TO_TOKEN[c];
    }

    public static final char escapeToChar(int v) {
        return v >= 0x75 ? '\u0000' : CharMappings.ESCAPE_2_CHAR[v];
    }

    @NotNull
    public static final String tokenDescription(byte b) {
        switch(b) {
            case 1: {
                return "quotation mark \'\"\'";
            }
            case 2: {
                return "string escape sequence \'\\\'";
            }
            case 4: {
                return "comma \',\'";
            }
            case 5: {
                return "colon \':\'";
            }
            case 6: {
                return "start of the object \'{\'";
            }
            case 7: {
                return "end of the object \'}\'";
            }
            case 8: {
                return "start of the array \'[\'";
            }
            case 9: {
                return "end of the array \']\'";
            }
            case 10: {
                return "end of the input";
            }
            case 0x7F: {
                return "invalid token";
            }
            default: {
                return "valid token";
            }
        }
    }
}

