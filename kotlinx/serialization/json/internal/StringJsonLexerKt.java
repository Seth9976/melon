package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"StringJsonLexer", "Lkotlinx/serialization/json/internal/StringJsonLexer;", "json", "Lkotlinx/serialization/json/Json;", "source", "", "kotlinx-serialization-json"}, k = 2, mv = {2, 0, 0}, xi = 0x30)
public abstract class StringJsonLexerKt {
    @NotNull
    public static final StringJsonLexer StringJsonLexer(@NotNull Json json0, @NotNull String s) {
        q.g(json0, "json");
        q.g(s, "source");
        return !json0.getConfiguration().getAllowComments() ? new StringJsonLexer(s) : new StringJsonLexerWithComments(s);
    }
}

