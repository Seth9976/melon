package okhttp3;

import Tf.v;
import androidx.appcompat.app.o;
import e2.a;
import ie.d;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\fH\u0007J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001A\u00020\u0012H\u0016J\u0010\u0010\u0013\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001A\u00020\u0003J\r\u0010\u0005\u001A\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\u0003H\u0016J\r\u0010\u0004\u001A\u00020\u0003H\u0007¢\u0006\u0002\b\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001A\u00020\u00038\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001A\u00020\u00038\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\n¨\u0006\u0019"}, d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "parameterNamesAndValues", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "parameter", "name", "-deprecated_subtype", "toString", "-deprecated_type", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MediaType {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0007H\u0007¢\u0006\u0002\b\rJ\u0017\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\u0007H\u0007¢\u0006\u0002\b\u000FJ\u0011\u0010\u0010\u001A\u00020\u000B*\u00020\u0007H\u0007¢\u0006\u0002\b\nJ\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u000B*\u00020\u0007H\u0007¢\u0006\u0002\b\u000ER\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", "get", "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @d
        @NotNull
        public final MediaType -deprecated_get(@NotNull String s) {
            q.g(s, "mediaType");
            return this.get(s);
        }

        @d
        @Nullable
        public final MediaType -deprecated_parse(@NotNull String s) {
            q.g(s, "mediaType");
            return this.parse(s);
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MediaType get(@NotNull String s) {
            q.g(s, "<this>");
            Matcher matcher0 = MediaType.TYPE_SUBTYPE.matcher(s);
            if(!matcher0.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + s + '\"').toString());
            }
            String s1 = matcher0.group(1);
            q.f(s1, "typeSubtype.group(1)");
            Locale locale0 = Locale.US;
            q.f(locale0, "US");
            String s2 = s1.toLowerCase(locale0);
            q.f(s2, "this as java.lang.String).toLowerCase(locale)");
            String s3 = matcher0.group(2);
            q.f(s3, "typeSubtype.group(2)");
            String s4 = s3.toLowerCase(locale0);
            q.f(s4, "this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList0 = new ArrayList();
            Matcher matcher1 = MediaType.PARAMETER.matcher(s);
            int v = matcher0.end();
            while(v < s.length()) {
                matcher1.region(v, s.length());
                if(matcher1.lookingAt()) {
                    String s5 = matcher1.group(1);
                    if(s5 == null) {
                        v = matcher1.end();
                        continue;
                    }
                    String s6 = matcher1.group(2);
                    if(s6 == null) {
                        s6 = matcher1.group(3);
                    }
                    else if(v.r0(s6, "\'", false) && v.i0(s6, "\'", false) && s6.length() > 2) {
                        s6 = s6.substring(1, s6.length() - 1);
                        q.f(s6, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    arrayList0.add(s5);
                    arrayList0.add(s6);
                    v = matcher1.end();
                    continue;
                }
                StringBuilder stringBuilder0 = new StringBuilder("Parameter is not formatted correctly: \"");
                String s7 = s.substring(v);
                q.f(s7, "this as java.lang.String).substring(startIndex)");
                stringBuilder0.append(s7);
                stringBuilder0.append("\" for: \"");
                throw new IllegalArgumentException(o.r(stringBuilder0, s, '\"').toString());
            }
            return new MediaType(s, s2, s4, ((String[])arrayList0.toArray(new String[0])), null);
        }

        @Nullable
        public final MediaType parse(@NotNull String s) {
            q.g(s, "<this>");
            try {
                return this.get(s);
            }
            catch(IllegalArgumentException unused_ex) {
                return null;
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final Pattern PARAMETER = null;
    @NotNull
    private static final String QUOTED = "\"([^\"]*)\"";
    @NotNull
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)";
    private static final Pattern TYPE_SUBTYPE;
    @NotNull
    private final String mediaType;
    @NotNull
    private final String[] parameterNamesAndValues;
    @NotNull
    private final String subtype;
    @NotNull
    private final String type;

    @d
    @NotNull
    public final String -deprecated_subtype() {
        return this.subtype;
    }

    @d
    @NotNull
    public final String -deprecated_type() {
        return this.type;
    }

    static {
        MediaType.Companion = new Companion(null);
        MediaType.TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)");
        MediaType.PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&\'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    private MediaType(String s, String s1, String s2, String[] arr_s) {
        this.mediaType = s;
        this.type = s1;
        this.subtype = s2;
        this.parameterNamesAndValues = arr_s;
    }

    public MediaType(String s, String s1, String s2, String[] arr_s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, s2, arr_s);
    }

    @Nullable
    public final Charset charset() {
        return MediaType.charset$default(this, null, 1, null);
    }

    @Nullable
    public final Charset charset(@Nullable Charset charset0) {
        String s = this.parameter("charset");
        if(s == null) {
            return charset0;
        }
        try {
            return Charset.forName(s);
        }
        catch(IllegalArgumentException unused_ex) {
            return charset0;
        }
    }

    public static Charset charset$default(MediaType mediaType0, Charset charset0, int v, Object object0) {
        if((v & 1) != 0) {
            charset0 = null;
        }
        return mediaType0.charset(charset0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof MediaType && q.b(((MediaType)object0).mediaType, this.mediaType);
    }

    @NotNull
    public static final MediaType get(@NotNull String s) {
        return MediaType.Companion.get(s);
    }

    @Override
    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @Nullable
    public final String parameter(@NotNull String s) {
        q.g(s, "name");
        int v1 = a.G(0, this.parameterNamesAndValues.length - 1, 2);
        if(v1 >= 0) {
            for(int v = 0; true; v += 2) {
                if(v.j0(this.parameterNamesAndValues[v], s, true)) {
                    return this.parameterNamesAndValues[v + 1];
                }
                if(v == v1) {
                    break;
                }
            }
        }
        return null;
    }

    @Nullable
    public static final MediaType parse(@NotNull String s) {
        return MediaType.Companion.parse(s);
    }

    @NotNull
    public final String subtype() {
        return this.subtype;
    }

    @Override
    @NotNull
    public String toString() {
        return this.mediaType;
    }

    @NotNull
    public final String type() {
        return this.type;
    }
}

