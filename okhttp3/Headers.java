package okhttp3;

import Tf.o;
import Tf.v;
import ie.d;
import ie.m;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import je.u;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xe.a;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 32\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u000243B\u0017\b\u0002\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\t\u001A\u0004\u0018\u00010\u00032\u0006\u0010\b\u001A\u00020\u0003H\u0086\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\b\u001A\u00020\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\b\u001A\u00020\u0003H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0014\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\b\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0011\u00A2\u0006\u0004\b\b\u0010\u0016J\u0015\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0013\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00030\u0018\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001B\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00030\u001B2\u0006\u0010\b\u001A\u00020\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b\u001F\u0010 J\"\u0010\"\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020!H\u0096\u0002\u00A2\u0006\u0004\b\"\u0010#J\r\u0010%\u001A\u00020$\u00A2\u0006\u0004\b%\u0010&J\u001A\u0010*\u001A\u00020)2\b\u0010(\u001A\u0004\u0018\u00010\'H\u0096\u0002\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b,\u0010\u0013J\u000F\u0010-\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b-\u0010.J\u001F\u00100\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001B0/\u00A2\u0006\u0004\b0\u00101R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00030\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u00102R\u0011\u0010\u0014\u001A\u00020\u00118G\u00A2\u0006\u0006\u001A\u0004\b\u0014\u0010\u0013\u00A8\u00065"}, d2 = {"Lokhttp3/Headers;", "", "Lie/m;", "", "", "namesAndValues", "<init>", "([Ljava/lang/String;)V", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Date;", "getDate", "(Ljava/lang/String;)Ljava/util/Date;", "Ljava/time/Instant;", "getInstant", "(Ljava/lang/String;)Ljava/time/Instant;", "", "-deprecated_size", "()I", "size", "index", "(I)Ljava/lang/String;", "value", "", "names", "()Ljava/util/Set;", "", "values", "(Ljava/lang/String;)Ljava/util/List;", "", "byteCount", "()J", "", "iterator", "()Ljava/util/Iterator;", "Lokhttp3/Headers$Builder;", "newBuilder", "()Lokhttp3/Headers$Builder;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "", "toMultimap", "()Ljava/util/Map;", "[Ljava/lang/String;", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Headers implements Iterable, a {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000E\u0010\b\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0005J\u0018\u0010\b\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH\u0007J\u0016\u0010\b\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\rJ\u0016\u0010\b\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005J\u000E\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0010J\u0015\u0010\u0011\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u001D\u0010\u0011\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005J\u0006\u0010\u0014\u001A\u00020\u0010J\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u00052\u0006\u0010\n\u001A\u00020\u0005H\u0086\u0002J\u000E\u0010\u0016\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0005J\u0019\u0010\u0017\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H\u0086\u0002R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @NotNull
        private final List namesAndValues;

        public Builder() {
            this.namesAndValues = new ArrayList(20);
        }

        @NotNull
        public final Builder add(@NotNull String s) {
            q.g(s, "line");
            int v = o.E0(s, ':', 0, 6);
            if(v == -1) {
                throw new IllegalArgumentException(("Unexpected header: " + s).toString());
            }
            String s1 = s.substring(0, v);
            q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
            String s2 = o.e1(s1).toString();
            String s3 = s.substring(v + 1);
            q.f(s3, "this as java.lang.String).substring(startIndex)");
            this.add(s2, s3);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            Companion.access$checkName(Headers.Companion, s);
            Companion.access$checkValue(Headers.Companion, s1, s);
            this.addLenient$okhttp(s, s1);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String s, @NotNull Instant instant0) {
            q.g(s, "name");
            q.g(instant0, "value");
            this.add(s, new Date(instant0.toEpochMilli()));
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String s, @NotNull Date date0) {
            q.g(s, "name");
            q.g(date0, "value");
            this.add(s, DatesKt.toHttpDateString(date0));
            return this;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers0) {
            q.g(headers0, "headers");
            int v = headers0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                this.addLenient$okhttp(headers0.name(v1), headers0.value(v1));
            }
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String s) {
            q.g(s, "line");
            int v = o.E0(s, ':', 1, 4);
            if(v != -1) {
                String s1 = s.substring(0, v);
                q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
                String s2 = s.substring(v + 1);
                q.f(s2, "this as java.lang.String).substring(startIndex)");
                this.addLenient$okhttp(s1, s2);
                return this;
            }
            if(s.charAt(0) == 58) {
                String s3 = s.substring(1);
                q.f(s3, "this as java.lang.String).substring(startIndex)");
                this.addLenient$okhttp("", s3);
                return this;
            }
            this.addLenient$okhttp("", s);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            this.namesAndValues.add(s);
            String s2 = o.e1(s1).toString();
            this.namesAndValues.add(s2);
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            Companion.access$checkName(Headers.Companion, s);
            this.addLenient$okhttp(s, s1);
            return this;
        }

        @NotNull
        public final Headers build() {
            return new Headers(((String[])this.namesAndValues.toArray(new String[0])), null);
        }

        @Nullable
        public final String get(@NotNull String s) {
            q.g(s, "name");
            int v = this.namesAndValues.size() - 2;
            int v1 = e2.a.G(v, 0, -2);
            if(v1 <= v) {
                while(true) {
                    if(s.equalsIgnoreCase(((String)this.namesAndValues.get(v)))) {
                        return (String)this.namesAndValues.get(v + 1);
                    }
                    if(v == v1) {
                        break;
                    }
                    v -= 2;
                }
            }
            return null;
        }

        @NotNull
        public final List getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String s) {
            q.g(s, "name");
            for(int v = 0; v < this.namesAndValues.size(); v += 2) {
                if(s.equalsIgnoreCase(((String)this.namesAndValues.get(v)))) {
                    this.namesAndValues.remove(v);
                    this.namesAndValues.remove(v);
                    v -= 2;
                }
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String s, @NotNull String s1) {
            q.g(s, "name");
            q.g(s1, "value");
            Companion.access$checkName(Headers.Companion, s);
            Companion.access$checkValue(Headers.Companion, s1, s);
            this.removeAll(s);
            this.addLenient$okhttp(s, s1);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String s, @NotNull Instant instant0) {
            q.g(s, "name");
            q.g(instant0, "value");
            return this.set(s, new Date(instant0.toEpochMilli()));
        }

        @NotNull
        public final Builder set(@NotNull String s, @NotNull Date date0) {
            q.g(s, "name");
            q.g(date0, "value");
            this.set(s, DatesKt.toHttpDateString(date0));
            return this;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\b\u001A\u0004\u0018\u00010\u00052\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ#\u0010\u0013\u001A\u00020\u00102\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0011\u001A\u00020\u00102\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u001F\u0010\u0017\u001A\u00020\u0010*\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0015H\u0007¢\u0006\u0004\b\u0011\u0010\u0016J#\u0010\u0011\u001A\u00020\u00102\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0015H\u0007¢\u0006\u0004\b\u0014\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/Headers$Companion;", "", "<init>", "()V", "", "", "namesAndValues", "name", "get", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lie/H;", "checkName", "(Ljava/lang/String;)V", "value", "checkValue", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "-deprecated_of", "", "(Ljava/util/Map;)Lokhttp3/Headers;", "toHeaders", "headers", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @d
        @NotNull
        public final Headers -deprecated_of(@NotNull Map map0) {
            q.g(map0, "headers");
            return this.of(map0);
        }

        @d
        @NotNull
        public final Headers -deprecated_of(@NotNull String[] arr_s) {
            q.g(arr_s, "namesAndValues");
            return this.of(((String[])Arrays.copyOf(arr_s, arr_s.length)));
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final void access$checkName(Companion headers$Companion0, String s) {
            headers$Companion0.checkName(s);
        }

        public static final void access$checkValue(Companion headers$Companion0, String s, String s1) {
            headers$Companion0.checkValue(s, s1);
        }

        public static final String access$get(Companion headers$Companion0, String[] arr_s, String s) {
            return headers$Companion0.get(arr_s, s);
        }

        private final void checkName(String s) {
            if(s.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int v = s.length();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = s.charAt(v1);
                if(33 > v2 || v2 >= 0x7F) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[]{v2, v1, s}).toString());
                }
            }
        }

        private final void checkValue(String s, String s1) {
            int v = s.length();
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = s.charAt(v1);
                if(v2 != 9 && (0x20 > v2 || v2 >= 0x7F)) {
                    throw new IllegalArgumentException((Util.format("Unexpected char %#04x at %d in %s value", new Object[]{v2, v1, s1}) + (Util.isSensitiveHeader(s1) ? "" : ": " + s)).toString());
                }
            }
        }

        private final String get(String[] arr_s, String s) {
            int v = arr_s.length - 2;
            int v1 = e2.a.G(v, 0, -2);
            if(v1 <= v) {
                while(true) {
                    if(v.j0(s, arr_s[v], true)) {
                        return arr_s[v + 1];
                    }
                    if(v == v1) {
                        break;
                    }
                    v -= 2;
                }
            }
            return null;
        }

        @NotNull
        public final Headers of(@NotNull Map map0) {
            q.g(map0, "<this>");
            String[] arr_s = new String[map0.size() * 2];
            int v = 0;
            for(Object object0: map0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                String s1 = (String)((Map.Entry)object0).getValue();
                String s2 = o.e1(s).toString();
                String s3 = o.e1(s1).toString();
                this.checkName(s2);
                this.checkValue(s3, s2);
                arr_s[v] = s2;
                arr_s[v + 1] = s3;
                v += 2;
            }
            return new Headers(arr_s, null);
        }

        @NotNull
        public final Headers of(@NotNull String[] arr_s) {
            q.g(arr_s, "namesAndValues");
            if(arr_s.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] arr_s1 = (String[])arr_s.clone();
            for(int v1 = 0; v1 < arr_s1.length; ++v1) {
                String s = arr_s1[v1];
                if(s == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                arr_s1[v1] = o.e1(s).toString();
            }
            int v2 = e2.a.G(0, arr_s1.length - 1, 2);
            if(v2 >= 0) {
                for(int v = 0; true; v += 2) {
                    String s1 = arr_s1[v];
                    String s2 = arr_s1[v + 1];
                    this.checkName(s1);
                    this.checkValue(s2, s1);
                    if(v == v2) {
                        break;
                    }
                }
            }
            return new Headers(arr_s1, null);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String[] namesAndValues;

    @d
    public final int -deprecated_size() {
        return this.size();
    }

    static {
        Headers.Companion = new Companion(null);
    }

    private Headers(String[] arr_s) {
        this.namesAndValues = arr_s;
    }

    public Headers(String[] arr_s, DefaultConstructorMarker defaultConstructorMarker0) {
        this(arr_s);
    }

    public final long byteCount() {
        long v = (long)(this.namesAndValues.length * 2);
        for(int v1 = 0; v1 < this.namesAndValues.length; ++v1) {
            v += (long)this.namesAndValues[v1].length();
        }
        return v;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof Headers && Arrays.equals(this.namesAndValues, ((Headers)object0).namesAndValues);
    }

    @Nullable
    public final String get(@NotNull String s) {
        q.g(s, "name");
        return Companion.access$get(Headers.Companion, this.namesAndValues, s);
    }

    @Nullable
    public final Date getDate(@NotNull String s) {
        q.g(s, "name");
        String s1 = this.get(s);
        return s1 == null ? null : DatesKt.toHttpDateOrNull(s1);
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String s) {
        q.g(s, "name");
        Date date0 = this.getDate(s);
        return date0 == null ? null : date0.toInstant();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override
    @NotNull
    public Iterator iterator() {
        int v = this.size();
        m[] arr_m = new m[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_m[v1] = new m(this.name(v1), this.value(v1));
        }
        return q.j(arr_m);
    }

    @NotNull
    public final String name(int v) {
        return this.namesAndValues[v * 2];
    }

    @NotNull
    public final Set names() {
        v.k0();
        TreeSet treeSet0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int v = this.size();
        for(int v1 = 0; v1 < v; ++v1) {
            treeSet0.add(this.name(v1));
        }
        Set set0 = Collections.unmodifiableSet(treeSet0);
        q.f(set0, "unmodifiableSet(result)");
        return set0;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder headers$Builder0 = new Builder();
        u.V(headers$Builder0.getNamesAndValues$okhttp(), this.namesAndValues);
        return headers$Builder0;
    }

    @NotNull
    public static final Headers of(@NotNull Map map0) {
        return Headers.Companion.of(map0);
    }

    @NotNull
    public static final Headers of(@NotNull String[] arr_s) {
        return Headers.Companion.of(arr_s);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map toMultimap() {
        v.k0();
        Map map0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int v = this.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = this.name(v1);
            Locale locale0 = Locale.US;
            q.f(locale0, "US");
            String s1 = s.toLowerCase(locale0);
            q.f(s1, "this as java.lang.String).toLowerCase(locale)");
            List list0 = (List)((TreeMap)map0).get(s1);
            if(list0 == null) {
                list0 = new ArrayList(2);
                ((TreeMap)map0).put(s1, list0);
            }
            list0.add(this.value(v1));
        }
        return map0;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = this.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = this.name(v1);
            String s1 = this.value(v1);
            stringBuilder0.append(s);
            stringBuilder0.append(": ");
            if(Util.isSensitiveHeader(s)) {
                s1 = "██";
            }
            stringBuilder0.append(s1);
            stringBuilder0.append("\n");
        }
        String s2 = stringBuilder0.toString();
        q.f(s2, "StringBuilder().apply(builderAction).toString()");
        return s2;
    }

    @NotNull
    public final String value(int v) {
        return this.namesAndValues[v * 2 + 1];
    }

    @NotNull
    public final List values(@NotNull String s) {
        q.g(s, "name");
        int v = this.size();
        List list0 = null;
        for(int v1 = 0; v1 < v; ++v1) {
            if(s.equalsIgnoreCase(this.name(v1))) {
                if(list0 == null) {
                    list0 = new ArrayList(2);
                }
                list0.add(this.value(v1));
            }
        }
        if(list0 != null) {
            List list1 = Collections.unmodifiableList(list0);
            q.f(list1, "{\n      Collections.unmodifiableList(result)\n    }");
            return list1;
        }
        return w.a;
    }
}

