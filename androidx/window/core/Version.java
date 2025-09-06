package androidx.window.core;

import Tf.o;
import U4.x;
import d3.g;
import ie.j;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B)\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000FH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001A\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001A\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0005\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001A\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001A\u0004\b\u001A\u0010\u000BR\u001B\u0010 \u001A\u00020\u001B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006\""}, d2 = {"Landroidx/window/core/Version;", "", "", "major", "minor", "patch", "", "description", "<init>", "(IIILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "other", "compareTo", "(Landroidx/window/core/Version;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getMajor", "getMinor", "getPatch", "Ljava/lang/String;", "getDescription", "Ljava/math/BigInteger;", "bigInteger$delegate", "Lie/j;", "getBigInteger", "()Ljava/math/BigInteger;", "bigInteger", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class Version implements Comparable {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000F\u001A\u0004\u0018\u00010\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u000EH\u0007R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0006R\u0011\u0010\u000B\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0006R\u000E\u0010\r\u001A\u00020\u000EX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/window/core/Version$Companion;", "", "()V", "CURRENT", "Landroidx/window/core/Version;", "getCURRENT", "()Landroidx/window/core/Version;", "UNKNOWN", "getUNKNOWN", "VERSION_0_1", "getVERSION_0_1", "VERSION_1_0", "getVERSION_1_0", "VERSION_PATTERN_STRING", "", "parse", "versionString", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        @NotNull
        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        @NotNull
        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        @NotNull
        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        @Nullable
        public final Version parse(@Nullable String s) {
            if(s != null && !o.H0(s)) {
                Matcher matcher0 = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(s);
                if(!matcher0.matches()) {
                    return null;
                }
                String s1 = matcher0.group(1);
                if(s1 != null) {
                    int v = Integer.parseInt(s1);
                    String s2 = matcher0.group(2);
                    if(s2 != null) {
                        int v1 = Integer.parseInt(s2);
                        String s3 = matcher0.group(3);
                        if(s3 != null) {
                            int v2 = Integer.parseInt(s3);
                            String s4 = matcher0.group(4) == null ? "" : matcher0.group(4);
                            q.d(s4);
                            return new Version(v, v1, v2, s4, null);
                        }
                    }
                }
            }
            return null;
        }
    }

    @NotNull
    private static final Version CURRENT = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final Version UNKNOWN = null;
    @NotNull
    private static final Version VERSION_0_1 = null;
    @NotNull
    private static final Version VERSION_1_0 = null;
    @NotNull
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    @NotNull
    private final j bigInteger$delegate;
    @NotNull
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    static {
        Version.Companion = new Companion(null);
        Version.UNKNOWN = new Version(0, 0, 0, "");
        Version.VERSION_0_1 = new Version(0, 1, 0, "");
        Version version0 = new Version(1, 0, 0, "");
        Version.VERSION_1_0 = version0;
        Version.CURRENT = version0;
    }

    private Version(int v, int v1, int v2, String s) {
        this.major = v;
        this.minor = v1;
        this.patch = v2;
        this.description = s;
        this.bigInteger$delegate = g.Q(new a() {
            {
                Version.this = version0;
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }

            public final BigInteger invoke() {
                return BigInteger.valueOf(Version.this.getMajor()).shiftLeft(0x20).or(BigInteger.valueOf(Version.this.getMinor())).shiftLeft(0x20).or(BigInteger.valueOf(Version.this.getPatch()));
            }
        });
    }

    public Version(int v, int v1, int v2, String s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, v1, v2, s);
    }

    public int compareTo(@NotNull Version version0) {
        q.g(version0, "other");
        return this.getBigInteger().compareTo(version0.getBigInteger());
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((Version)object0));
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof Version ? this.major == ((Version)object0).major && this.minor == ((Version)object0).minor && this.patch == ((Version)object0).patch : false;
    }

    private final BigInteger getBigInteger() {
        Object object0 = this.bigInteger$delegate.getValue();
        q.f(object0, "getValue(...)");
        return (BigInteger)object0;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    @Override
    public int hashCode() {
        return ((this.major + 0x20F) * 0x1F + this.minor) * 0x1F + this.patch;
    }

    @Nullable
    public static final Version parse(@Nullable String s) {
        return Version.Companion.parse(s);
    }

    @Override
    @NotNull
    public String toString() {
        String s = o.H0(this.description) ? "" : "-" + this.description;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.major);
        stringBuilder0.append('.');
        stringBuilder0.append(this.minor);
        stringBuilder0.append('.');
        return x.g(this.patch, s, stringBuilder0);
    }
}

