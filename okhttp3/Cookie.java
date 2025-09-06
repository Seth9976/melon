package okhttp3;

import Tf.o;
import Tf.v;
import U4.x;
import ie.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\f\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\n\u00A2\u0006\u0002\u0010\u000EJ\r\u0010\u0007\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001A\u00020\n2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001A\u00020\u0006H\u0007\u00A2\u0006\u0002\b\u0015J\b\u0010\u0016\u001A\u00020\u0017H\u0017J\r\u0010\r\u001A\u00020\nH\u0007\u00A2\u0006\u0002\b\u0018J\r\u0010\u000B\u001A\u00020\nH\u0007\u00A2\u0006\u0002\b\u0019J\u000E\u0010\u001A\u001A\u00020\n2\u0006\u0010\u001B\u001A\u00020\u001CJ\r\u0010\u0002\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u001DJ\r\u0010\b\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\u001EJ\r\u0010\f\u001A\u00020\nH\u0007\u00A2\u0006\u0002\b\u001FJ\r\u0010\t\u001A\u00020\nH\u0007\u00A2\u0006\u0002\b J\b\u0010!\u001A\u00020\u0003H\u0016J\u0015\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\nH\u0000\u00A2\u0006\u0002\b#J\r\u0010\u0004\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b$R\u0013\u0010\u0007\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u000FR\u0013\u0010\u0005\u001A\u00020\u00068\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001A\u00020\n8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0011R\u0013\u0010\u000B\u001A\u00020\n8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0011R\u0013\u0010\u0002\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u000FR\u0013\u0010\b\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u000FR\u0013\u0010\f\u001A\u00020\n8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001A\u00020\n8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u000F\u00A8\u0006\'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", "other", "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Cookie {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0003\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0004J\u0018\u0010\u0003\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\bH\u0002J\u000E\u0010\u0005\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0004J\u0006\u0010\t\u001A\u00020\u0000J\u000E\u0010\n\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0004J\u000E\u0010\u000B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\u0004J\u0006\u0010\r\u001A\u00020\u0000J\u000E\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u0004R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", "domain", "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", "build", "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @Nullable
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        @Nullable
        private String name;
        @NotNull
        private String path;
        private boolean persistent;
        private boolean secure;
        @Nullable
        private String value;

        public Builder() {
            this.expiresAt = 0xE677D21FDBFFL;
            this.path = "/";
        }

        @NotNull
        public final Cookie build() {
            String s = this.name;
            if(s == null) {
                throw new NullPointerException("builder.name == null");
            }
            String s1 = this.value;
            if(s1 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long v = this.expiresAt;
            String s2 = this.domain;
            if(s2 == null) {
                throw new NullPointerException("builder.domain == null");
            }
            return new Cookie(s, s1, v, s2, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        }

        private final Builder domain(String s, boolean z) {
            String s1 = HostnamesKt.toCanonicalHost(s);
            if(s1 == null) {
                throw new IllegalArgumentException("unexpected domain: " + s);
            }
            this.domain = s1;
            this.hostOnly = z;
            return this;
        }

        @NotNull
        public final Builder domain(@NotNull String s) {
            q.g(s, "domain");
            return this.domain(s, false);
        }

        @NotNull
        public final Builder expiresAt(long v) {
            if(v <= 0L) {
                v = 0x8000000000000000L;
            }
            if(v > 0xE677D21FDBFFL) {
                v = 0xE677D21FDBFFL;
            }
            this.expiresAt = v;
            this.persistent = true;
            return this;
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String s) {
            q.g(s, "domain");
            return this.domain(s, true);
        }

        @NotNull
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @NotNull
        public final Builder name(@NotNull String s) {
            q.g(s, "name");
            if(!q.b(o.e1(s).toString(), s)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = s;
            return this;
        }

        @NotNull
        public final Builder path(@NotNull String s) {
            q.g(s, "path");
            if(!v.r0(s, "/", false)) {
                throw new IllegalArgumentException("path must start with \'/\'");
            }
            this.path = s;
            return this;
        }

        @NotNull
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String s) {
            q.g(s, "value");
            if(!q.b(o.e1(s).toString(), s)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = s;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u0010H\u0002J\u0018\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\fH\u0002J\'\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\fH\u0000¢\u0006\u0002\b\u001BJ\u001A\u0010\u0014\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\fH\u0007J\u001E\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00150\u001D2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001E\u001A\u00020\u001FH\u0007J\u0010\u0010 \u001A\u00020\f2\u0006\u0010!\u001A\u00020\fH\u0002J \u0010\"\u001A\u00020\u00172\u0006\u0010!\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0002J\u0010\u0010#\u001A\u00020\u00172\u0006\u0010!\u001A\u00020\fH\u0002J\u0018\u0010$\u001A\u00020\u00102\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010%\u001A\u00020\fH\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", "limit", "invert", "", "domainMatch", "urlHost", "domain", "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", "s", "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final boolean access$domainMatch(Companion cookie$Companion0, String s, String s1) {
            return cookie$Companion0.domainMatch(s, s1);
        }

        public static final boolean access$pathMatch(Companion cookie$Companion0, HttpUrl httpUrl0, String s) {
            return cookie$Companion0.pathMatch(httpUrl0, s);
        }

        private final int dateCharacterOffset(String s, int v, int v1, boolean z) {
            while(v < v1) {
                int v2 = s.charAt(v);
                if((v2 < 0x20 && v2 != 9 || v2 >= 0x7F || 0x30 <= v2 && v2 < 58 || 97 <= v2 && v2 < 0x7B || 65 <= v2 && v2 < 91 || v2 == 58 ? 1 : 0) == !z) {
                    return v;
                }
                ++v;
            }
            return v1;
        }

        // 去混淆评级： 低(30)
        private final boolean domainMatch(String s, String s1) {
            return q.b(s, s1) || v.i0(s, s1, false) && s.charAt(s.length() - s1.length() - 1) == 46 && !Util.canParseAsIpAddress(s);
        }

        @Nullable
        public final Cookie parse(@NotNull HttpUrl httpUrl0, @NotNull String s) {
            q.g(httpUrl0, "url");
            q.g(s, "setCookie");
            return this.parse$okhttp(System.currentTimeMillis(), httpUrl0, s);
        }

        @Nullable
        public final Cookie parse$okhttp(long v, @NotNull HttpUrl httpUrl0, @NotNull String s) {
            long v9;
            q.g(httpUrl0, "url");
            q.g(s, "setCookie");
            int v1 = Util.delimiterOffset$default(s, ';', 0, 0, 6, null);
            int v2 = Util.delimiterOffset$default(s, '=', 0, v1, 2, null);
            String s1 = null;
            if(v2 != v1) {
                String s2 = Util.trimSubstring$default(s, 0, v2, 1, null);
                if(s2.length() != 0 && Util.indexOfControlOrNonAscii(s2) == -1) {
                    String s3 = Util.trimSubstring(s, v2 + 1, v1);
                    if(Util.indexOfControlOrNonAscii(s3) == -1) {
                        int v3 = v1 + 1;
                        int v4 = s.length();
                        String s4 = null;
                        boolean z = false;
                        boolean z1 = false;
                        boolean z2 = false;
                        boolean z3 = true;
                        long v5 = -1L;
                        long v6 = 0xE677D21FDBFFL;
                        while(v3 < v4) {
                            int v7 = Util.delimiterOffset(s, ';', v3, v4);
                            int v8 = Util.delimiterOffset(s, '=', v3, v7);
                            String s5 = Util.trimSubstring(s, v3, v8);
                            String s6 = v8 >= v7 ? "" : Util.trimSubstring(s, v8 + 1, v7);
                            if(v.j0(s5, "expires", true)) {
                                try {
                                    v6 = this.parseExpires(s6, 0, s6.length());
                                    goto label_29;
                                }
                                catch(IllegalArgumentException unused_ex) {
                                }
                            }
                            else if(v.j0(s5, "max-age", true)) {
                                try {
                                    v5 = this.parseMaxAge(s6);
                                }
                                catch(NumberFormatException unused_ex) {
                                    goto label_43;
                                }
                            label_29:
                                z1 = true;
                            }
                            else if(v.j0(s5, "domain", true)) {
                                try {
                                    s1 = this.parseDomain(s6);
                                    z3 = false;
                                    goto label_43;
                                label_35:
                                    if(v.j0(s5, "path", true)) {
                                        s4 = s6;
                                    }
                                    else if(v.j0(s5, "secure", true)) {
                                        z2 = true;
                                    }
                                    else if(v.j0(s5, "httponly", true)) {
                                        z = true;
                                    }
                                }
                                catch(IllegalArgumentException unused_ex) {
                                }
                            }
                            else {
                                goto label_35;
                            }
                        label_43:
                            v3 = v7 + 1;
                        }
                        if(v5 == 0x8000000000000000L) {
                            v9 = 0x8000000000000000L;
                        }
                        else if(v5 == -1L) {
                            v9 = v6;
                        }
                        else {
                            long v10 = v + (v5 > 0x20C49BA5E353F7L ? 0x7FFFFFFFFFFFFFFFL : v5 * 1000L);
                            v9 = v10 < v || v10 > 0xE677D21FDBFFL ? 0xE677D21FDBFFL : v10;
                        }
                        String s7 = httpUrl0.host();
                        if(s1 == null) {
                            s1 = s7;
                            goto label_61;
                        }
                        else if(this.domainMatch(s7, s1)) {
                        label_61:
                            String s8 = "/";
                            if(s7.length() == s1.length() || PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(s1) != null) {
                                if(s4 == null || !v.r0(s4, "/", false)) {
                                    String s9 = httpUrl0.encodedPath();
                                    int v11 = o.J0(s9, '/', 0, 6);
                                    if(v11 != 0) {
                                        s8 = s9.substring(0, v11);
                                        q.f(s8, "this as java.lang.String…ing(startIndex, endIndex)");
                                    }
                                    s4 = s8;
                                }
                                return new Cookie(s2, s3, v9, s1, s4, z2, z, z1, z3, null);
                            }
                        }
                    }
                }
            }
            return null;
        }

        @NotNull
        public final List parseAll(@NotNull HttpUrl httpUrl0, @NotNull Headers headers0) {
            q.g(httpUrl0, "url");
            q.g(headers0, "headers");
            List list0 = headers0.values("Set-Cookie");
            int v = list0.size();
            List list1 = null;
            for(int v1 = 0; v1 < v; ++v1) {
                Cookie cookie0 = this.parse(httpUrl0, ((String)list0.get(v1)));
                if(cookie0 != null) {
                    if(list1 == null) {
                        list1 = new ArrayList();
                    }
                    list1.add(cookie0);
                }
            }
            if(list1 != null) {
                List list2 = Collections.unmodifiableList(list1);
                q.f(list2, "{\n        Collections.un…ableList(cookies)\n      }");
                return list2;
            }
            return w.a;
        }

        private final String parseDomain(String s) {
            if(v.i0(s, ".", false)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String s1 = HostnamesKt.toCanonicalHost(o.N0(s, "."));
            if(s1 == null) {
                throw new IllegalArgumentException();
            }
            return s1;
        }

        private final long parseExpires(String s, int v, int v1) {
            int v2 = this.dateCharacterOffset(s, v, v1, false);
            Matcher matcher0 = Cookie.TIME_PATTERN.matcher(s);
            int v3 = -1;
            int v4 = -1;
            int v5 = -1;
            int v6 = -1;
            int v7 = -1;
            int v8 = -1;
            while(v2 < v1) {
                int v9 = this.dateCharacterOffset(s, v2 + 1, v1, true);
                matcher0.region(v2, v9);
                if(v4 == -1 && matcher0.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String s1 = matcher0.group(1);
                    q.f(s1, "matcher.group(1)");
                    v4 = Integer.parseInt(s1);
                    String s2 = matcher0.group(2);
                    q.f(s2, "matcher.group(2)");
                    v7 = Integer.parseInt(s2);
                    String s3 = matcher0.group(3);
                    q.f(s3, "matcher.group(3)");
                    v8 = Integer.parseInt(s3);
                }
                else if(v5 == -1 && matcher0.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String s4 = matcher0.group(1);
                    q.f(s4, "matcher.group(1)");
                    v5 = Integer.parseInt(s4);
                }
                else if(v6 == -1 && matcher0.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String s5 = matcher0.group(1);
                    q.f(s5, "matcher.group(1)");
                    Locale locale0 = Locale.US;
                    q.f(locale0, "US");
                    String s6 = s5.toLowerCase(locale0);
                    q.f(s6, "this as java.lang.String).toLowerCase(locale)");
                    q.f("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*", "MONTH_PATTERN.pattern()");
                    v6 = o.F0("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*", s6, 0, false, 6) / 4;
                }
                else if(v3 == -1 && matcher0.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String s7 = matcher0.group(1);
                    q.f(s7, "matcher.group(1)");
                    v3 = Integer.parseInt(s7);
                }
                v2 = this.dateCharacterOffset(s, v9 + 1, v1, false);
            }
            if(70 <= v3 && v3 < 100) {
                v3 += 1900;
            }
            if(v3 >= 0 && v3 < 70) {
                v3 += 2000;
            }
            if(v3 < 1601 || v6 == -1 || 1 > v5 || v5 >= 0x20 || v4 < 0 || v4 >= 24 || v7 < 0 || v7 >= 60 || v8 < 0 || v8 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar0 = new GregorianCalendar(Util.UTC);
            gregorianCalendar0.setLenient(false);
            gregorianCalendar0.set(1, v3);
            gregorianCalendar0.set(2, v6 - 1);
            gregorianCalendar0.set(5, v5);
            gregorianCalendar0.set(11, v4);
            gregorianCalendar0.set(12, v7);
            gregorianCalendar0.set(13, v8);
            gregorianCalendar0.set(14, 0);
            return gregorianCalendar0.getTimeInMillis();
        }

        private final long parseMaxAge(String s) {
            try {
                long v = Long.parseLong(s);
                return v > 0L ? v : 0x8000000000000000L;
            }
            catch(NumberFormatException numberFormatException0) {
                Pattern pattern0 = Pattern.compile("-?\\d+");
                q.f(pattern0, "compile(...)");
                q.g(s, "input");
                if(!pattern0.matcher(s).matches()) {
                    throw numberFormatException0;
                }
                return v.r0(s, "-", false) ? 0x8000000000000000L : 0x7FFFFFFFFFFFFFFFL;
            }
        }

        private final boolean pathMatch(HttpUrl httpUrl0, String s) {
            String s1 = httpUrl0.encodedPath();
            return q.b(s1, s) || v.r0(s1, s, false) && (v.i0(s, "/", false) || s1.charAt(s.length()) == 0x2F);
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    private static final Pattern YEAR_PATTERN;
    @NotNull
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    @NotNull
    private final String name;
    @NotNull
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    @NotNull
    private final String value;

    @d
    @NotNull
    public final String -deprecated_domain() {
        return this.domain;
    }

    @d
    public final long -deprecated_expiresAt() {
        return this.expiresAt;
    }

    @d
    public final boolean -deprecated_hostOnly() {
        return this.hostOnly;
    }

    @d
    public final boolean -deprecated_httpOnly() {
        return this.httpOnly;
    }

    @d
    @NotNull
    public final String -deprecated_name() {
        return this.name;
    }

    @d
    @NotNull
    public final String -deprecated_path() {
        return this.path;
    }

    @d
    public final boolean -deprecated_persistent() {
        return this.persistent;
    }

    @d
    public final boolean -deprecated_secure() {
        return this.secure;
    }

    @d
    @NotNull
    public final String -deprecated_value() {
        return this.value;
    }

    static {
        Cookie.Companion = new Companion(null);
        Cookie.YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        Cookie.MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        Cookie.DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        Cookie.TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }

    private Cookie(String s, String s1, long v, String s2, String s3, boolean z, boolean z1, boolean z2, boolean z3) {
        this.name = s;
        this.value = s1;
        this.expiresAt = v;
        this.domain = s2;
        this.path = s3;
        this.secure = z;
        this.httpOnly = z1;
        this.persistent = z2;
        this.hostOnly = z3;
    }

    public Cookie(String s, String s1, long v, String s2, String s3, boolean z, boolean z1, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, v, s2, s3, z, z1, z2, z3);
    }

    @NotNull
    public final String domain() {
        return this.domain;
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof Cookie && q.b(((Cookie)object0).name, this.name) && q.b(((Cookie)object0).value, this.value) && ((Cookie)object0).expiresAt == this.expiresAt && q.b(((Cookie)object0).domain, this.domain) && q.b(((Cookie)object0).path, this.path) && ((Cookie)object0).secure == this.secure && ((Cookie)object0).httpOnly == this.httpOnly && ((Cookie)object0).persistent == this.persistent && ((Cookie)object0).hostOnly == this.hostOnly;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @Override
    @IgnoreJRERequirement
    public int hashCode() {
        return Boolean.hashCode(this.hostOnly) + A7.d.e(A7.d.e(A7.d.e(x.b(x.b(A7.d.c(x.b(x.b(0x20F, 0x1F, this.name), 0x1F, this.value), 0x1F, this.expiresAt), 0x1F, this.domain), 0x1F, this.path), 0x1F, this.secure), 0x1F, this.httpOnly), 0x1F, this.persistent);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@NotNull HttpUrl httpUrl0) {
        q.g(httpUrl0, "url");
        if(!(this.hostOnly ? q.b(httpUrl0.host(), this.domain) : Companion.access$domainMatch(Cookie.Companion, httpUrl0.host(), this.domain))) {
            return false;
        }
        return Companion.access$pathMatch(Cookie.Companion, httpUrl0, this.path) ? !this.secure || httpUrl0.isHttps() : false;
    }

    @NotNull
    public final String name() {
        return this.name;
    }

    @Nullable
    public static final Cookie parse(@NotNull HttpUrl httpUrl0, @NotNull String s) {
        return Cookie.Companion.parse(httpUrl0, s);
    }

    @NotNull
    public static final List parseAll(@NotNull HttpUrl httpUrl0, @NotNull Headers headers0) {
        return Cookie.Companion.parseAll(httpUrl0, headers0);
    }

    @NotNull
    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    @Override
    @NotNull
    public String toString() {
        return this.toString$okhttp(false);
    }

    @NotNull
    public final String toString$okhttp(boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.name);
        stringBuilder0.append('=');
        stringBuilder0.append(this.value);
        if(this.persistent) {
            if(this.expiresAt == 0x8000000000000000L) {
                stringBuilder0.append("; max-age=0");
            }
            else {
                stringBuilder0.append("; expires=");
                stringBuilder0.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if(!this.hostOnly) {
            stringBuilder0.append("; domain=");
            if(z) {
                stringBuilder0.append(".");
            }
            stringBuilder0.append(this.domain);
        }
        stringBuilder0.append("; path=");
        stringBuilder0.append(this.path);
        if(this.secure) {
            stringBuilder0.append("; secure");
        }
        if(this.httpOnly) {
            stringBuilder0.append("; httponly");
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString()");
        return s;
    }

    @NotNull
    public final String value() {
        return this.value;
    }
}

