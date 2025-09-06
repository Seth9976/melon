package okhttp3;

import Ce.e;
import Tf.o;
import Tf.v;
import b3.Z;
import e2.a;
import ie.d;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import je.w;
import je.y;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u00A2\u0006\u0002\u0010\u000EJ\u000F\u0010\u000F\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0002\b!J\r\u0010\u0011\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b\"J\r\u0010\u0012\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b#J\u0013\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00A2\u0006\u0002\b$J\u000F\u0010\u0015\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0002\b%J\r\u0010\u0016\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b&J\u0013\u0010\'\u001A\u00020\u00182\b\u0010(\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\u000F\u0010\f\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0002\b)J\b\u0010*\u001A\u00020\bH\u0016J\r\u0010\u0006\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b+J\u0006\u0010,\u001A\u00020-J\u0010\u0010,\u001A\u0004\u0018\u00010-2\u0006\u0010.\u001A\u00020\u0003J\r\u0010\u0005\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b/J\u0013\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00A2\u0006\u0002\b0J\r\u0010\u001A\u001A\u00020\bH\u0007\u00A2\u0006\u0002\b1J\r\u0010\u0007\u001A\u00020\bH\u0007\u00A2\u0006\u0002\b2J\u000F\u0010\u001C\u001A\u0004\u0018\u00010\u0003H\u0007\u00A2\u0006\u0002\b3J\u0010\u00104\u001A\u0004\u0018\u00010\u00032\u0006\u00105\u001A\u00020\u0003J\u000E\u00106\u001A\u00020\u00032\u0006\u00107\u001A\u00020\bJ\u0013\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001EH\u0007\u00A2\u0006\u0002\b8J\u0010\u00109\u001A\u0004\u0018\u00010\u00032\u0006\u00107\u001A\u00020\bJ\u0016\u0010:\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001A\u00020\u0003J\r\u0010 \u001A\u00020\bH\u0007\u00A2\u0006\u0002\b;J\u0006\u0010<\u001A\u00020\u0003J\u0010\u0010=\u001A\u0004\u0018\u00010\u00002\u0006\u0010.\u001A\u00020\u0003J\r\u0010\u0002\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\b>J\b\u0010?\u001A\u00020\u0003H\u0016J\r\u0010@\u001A\u00020AH\u0007\u00A2\u0006\u0002\bBJ\r\u0010C\u001A\u00020DH\u0007\u00A2\u0006\u0002\b\rJ\b\u0010E\u001A\u0004\u0018\u00010\u0003J\r\u0010B\u001A\u00020AH\u0007\u00A2\u0006\u0002\bFJ\r\u0010\r\u001A\u00020DH\u0007\u00A2\u0006\u0002\bGJ\r\u0010\u0004\u001A\u00020\u0003H\u0007\u00A2\u0006\u0002\bHR\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0011\u001A\u00020\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001A\u00020\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00030\n8G\u00A2\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001A\u00020\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001A\u0004\u0018\u00010\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001A\u00020\u0018\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\n8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0014R\u0011\u0010\u001A\u001A\u00020\b8G\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u0007\u001A\u00020\b8\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\u001BR\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u001C\u0010\u0010R\u0018\u0010\u000B\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0017\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u00030\u001E8G\u00A2\u0006\u0006\u001A\u0004\b\u001D\u0010\u001FR\u0011\u0010 \u001A\u00020\b8G\u00A2\u0006\u0006\u001A\u0004\b \u0010\u001BR\u0013\u0010\u0002\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0010R\u000E\u0010\r\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001A\u00020\u00038\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u0010\u00A8\u0006K"}, d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class HttpUrl {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010!\n\u0002\b\u000B\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001A\u00020\u00002\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0004\u00A2\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001A\u00020\u00002\u0006\u0010\t\u001A\u00020\u0004\u00A2\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u0004\u00A2\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\u000B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\u0004\u00A2\u0006\u0004\b\u000B\u0010\u0006J\u0015\u0010\r\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\f\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0010\u0010\u0006J\u0015\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0014\u001A\u00020\u00002\u0006\u0010\u0013\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0015\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0016\u0010\u0006J\u001D\u0010\u0018\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001D\u0010\u001A\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u0015\u0010\u001B\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\f\u00A2\u0006\u0004\b\u001B\u0010\u000EJ\u0015\u0010\u001C\u001A\u00020\u00002\u0006\u0010\u001C\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001C\u0010\u0006J\u0017\u0010\u001D\u001A\u00020\u00002\b\u0010\u001D\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001D\u0010\u0006J\u0017\u0010\u001E\u001A\u00020\u00002\b\u0010\u001E\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001E\u0010\u0006J\u001F\u0010!\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00042\b\u0010 \u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010%\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u00042\b\u0010$\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b%\u0010\"J\u001F\u0010&\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00042\b\u0010 \u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b&\u0010\"J\u001F\u0010\'\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u00042\b\u0010$\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\'\u0010\"J\u0015\u0010(\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0004\u00A2\u0006\u0004\b(\u0010\u0006J\u0015\u0010)\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u0004\u00A2\u0006\u0004\b)\u0010\u0006J\u0017\u0010*\u001A\u00020\u00002\b\u0010*\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b*\u0010\u0006J\u0017\u0010+\u001A\u00020\u00002\b\u0010+\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b+\u0010\u0006J\u000F\u0010.\u001A\u00020\u0000H\u0000\u00A2\u0006\u0004\b,\u0010-J\r\u00100\u001A\u00020/\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b2\u00103J!\u00108\u001A\u00020\u00002\b\u00104\u001A\u0004\u0018\u00010/2\u0006\u00105\u001A\u00020\u0004H\u0000\u00A2\u0006\u0004\b6\u00107J\u000F\u00109\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b9\u0010:J\u001F\u0010\u0012\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u00042\u0006\u0010<\u001A\u00020;H\u0002\u00A2\u0006\u0004\b\u0012\u0010=J\u0017\u0010@\u001A\u00020?2\u0006\u0010>\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b@\u0010AJ\'\u0010D\u001A\u00020?2\u0006\u00105\u001A\u00020\u00042\u0006\u0010B\u001A\u00020\f2\u0006\u0010C\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bD\u0010EJ7\u0010H\u001A\u00020?2\u0006\u00105\u001A\u00020\u00042\u0006\u0010F\u001A\u00020\f2\u0006\u0010C\u001A\u00020\f2\u0006\u0010G\u001A\u00020;2\u0006\u0010<\u001A\u00020;H\u0002\u00A2\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001A\u00020;2\u0006\u00105\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001A\u00020;2\u0006\u00105\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bL\u0010KJ\u000F\u0010M\u001A\u00020?H\u0002\u00A2\u0006\u0004\bM\u0010\u0003R$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u0005\u0010N\u001A\u0004\bO\u00103\"\u0004\bP\u0010AR\"\u0010\b\u001A\u00020\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\b\u0010N\u001A\u0004\bQ\u00103\"\u0004\bR\u0010AR\"\u0010\n\u001A\u00020\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\n\u0010N\u001A\u0004\bS\u00103\"\u0004\bT\u0010AR$\u0010\u000B\u001A\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\u000B\u0010N\u001A\u0004\bU\u00103\"\u0004\bV\u0010AR\"\u0010\r\u001A\u00020\f8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b\r\u0010W\u001A\u0004\bX\u0010:\"\u0004\bY\u0010ZR \u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00040[8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0015\u0010\\\u001A\u0004\b]\u0010^R,\u0010_\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010[8\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b_\u0010\\\u001A\u0004\b`\u0010^\"\u0004\ba\u0010bR$\u0010+\u001A\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010N\u001A\u0004\bc\u00103\"\u0004\bd\u0010A\u00A8\u0006f"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "<init>", "()V", "", "scheme", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "username", "encodedUsername", "password", "encodedPassword", "host", "", "port", "(I)Lokhttp3/HttpUrl$Builder;", "pathSegment", "addPathSegment", "pathSegments", "addPathSegments", "encodedPathSegment", "addEncodedPathSegment", "encodedPathSegments", "addEncodedPathSegments", "index", "setPathSegment", "(ILjava/lang/String;)Lokhttp3/HttpUrl$Builder;", "setEncodedPathSegment", "removePathSegment", "encodedPath", "query", "encodedQuery", "name", "value", "addQueryParameter", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "encodedName", "encodedValue", "addEncodedQueryParameter", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "fragment", "encodedFragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "()Lokhttp3/HttpUrl;", "toString", "()Ljava/lang/String;", "base", "input", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "effectivePort", "()I", "", "alreadyEncoded", "(Ljava/lang/String;Z)Lokhttp3/HttpUrl$Builder;", "canonicalName", "Lie/H;", "removeAllCanonicalQueryParameters", "(Ljava/lang/String;)V", "startPos", "limit", "resolvePath", "(Ljava/lang/String;II)V", "pos", "addTrailingSlash", "push", "(Ljava/lang/String;IIZZ)V", "isDot", "(Ljava/lang/String;)Z", "isDotDot", "pop", "Ljava/lang/String;", "getScheme$okhttp", "setScheme$okhttp", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "getHost$okhttp", "setHost$okhttp", "I", "getPort$okhttp", "setPort$okhttp", "(I)V", "", "Ljava/util/List;", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0002J \u0010\n\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0002J \u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0002J\u001C\u0010\f\u001A\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0006H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public static final int access$schemeDelimiterOffset(Companion httpUrl$Builder$Companion0, String s, int v, int v1) {
                return httpUrl$Builder$Companion0.schemeDelimiterOffset(s, v, v1);
            }

            public static final int access$slashCount(Companion httpUrl$Builder$Companion0, String s, int v, int v1) {
                return httpUrl$Builder$Companion0.slashCount(s, v, v1);
            }

            private final int parsePort(String s, int v, int v1) {
                try {
                    int v2 = Integer.parseInt(okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, v, v1, "", false, false, false, false, null, 0xF8, null));
                    if(1 <= v2 && v2 < 0x10000) {
                        return v2;
                    }
                }
                catch(NumberFormatException unused_ex) {
                }
                return -1;
            }

            private final int portColonOffset(String s, int v, int v1) {
                while(v < v1) {
                    int v2 = s.charAt(v);
                    if(v2 == 91) {
                        do {
                            ++v;
                        }
                        while(v < v1 && s.charAt(v) != 93);
                    }
                    else if(v2 == 58) {
                        return v;
                    }
                    ++v;
                }
                return v1;
            }

            private final int schemeDelimiterOffset(String s, int v, int v1) {
                if(v1 - v < 2) {
                    return -1;
                }
                int v2 = s.charAt(v);
                if(q.h(v2, 97) >= 0 && q.h(v2, 0x7A) <= 0 || q.h(v2, 65) >= 0 && q.h(v2, 90) <= 0) {
                    while(true) {
                        ++v;
                        if(v >= v1) {
                            break;
                        }
                        int v3 = s.charAt(v);
                        if((97 > v3 || v3 >= 0x7B) && (65 > v3 || v3 >= 91) && (0x30 > v3 || v3 >= 58)) {
                            switch(v3) {
                                case 43: 
                                case 45: 
                                case 46: {
                                    break;
                                }
                                case 58: {
                                    return v;
                                }
                                default: {
                                    return -1;
                                }
                            }
                        }
                    }
                }
                return -1;
            }

            private final int slashCount(String s, int v, int v1) {
                int v2 = 0;
                while(v < v1) {
                    switch(s.charAt(v)) {
                        case 0x2F: 
                        case 92: {
                            ++v2;
                            ++v;
                            continue;
                        }
                        default: {
                            return v2;
                        }
                    }
                }
                return v2;
            }
        }

        @NotNull
        public static final Companion Companion = null;
        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";
        @Nullable
        private String encodedFragment;
        @NotNull
        private String encodedPassword;
        @NotNull
        private final List encodedPathSegments;
        @Nullable
        private List encodedQueryNamesAndValues;
        @NotNull
        private String encodedUsername;
        @Nullable
        private String host;
        private int port;
        @Nullable
        private String scheme;

        static {
            Builder.Companion = new Companion(null);
        }

        public Builder() {
            this.encodedUsername = "";
            this.encodedPassword = "";
            this.port = -1;
            ArrayList arrayList0 = new ArrayList();
            this.encodedPathSegments = arrayList0;
            arrayList0.add("");
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String s) {
            q.g(s, "encodedPathSegment");
            this.push(s, 0, s.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String s) {
            q.g(s, "encodedPathSegments");
            return this.addPathSegments(s, true);
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String s, @Nullable String s1) {
            q.g(s, "encodedName");
            if(this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List list0 = this.encodedQueryNamesAndValues;
            q.d(list0);
            list0.add(okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\'<>#&=", true, false, true, false, null, 0xD3, null));
            List list1 = this.encodedQueryNamesAndValues;
            q.d(list1);
            list1.add((s1 == null ? null : okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s1, 0, 0, " \"\'<>#&=", true, false, true, false, null, 0xD3, null)));
            return this;
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String s) {
            q.g(s, "pathSegment");
            this.push(s, 0, s.length(), false, false);
            return this;
        }

        private final Builder addPathSegments(String s, boolean z) {
            int v = 0;
            do {
                int v1 = Util.delimiterOffset(s, "/\\", v, s.length());
                this.push(s, v, v1, v1 < s.length(), z);
                v = v1 + 1;
            }
            while(v <= s.length());
            return this;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String s) {
            q.g(s, "pathSegments");
            return this.addPathSegments(s, false);
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String s, @Nullable String s1) {
            q.g(s, "name");
            if(this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List list0 = this.encodedQueryNamesAndValues;
            q.d(list0);
            list0.add(okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " !\"#$&\'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 0xDB, null));
            List list1 = this.encodedQueryNamesAndValues;
            q.d(list1);
            list1.add((s1 == null ? null : okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s1, 0, 0, " !\"#$&\'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 0xDB, null)));
            return this;
        }

        @NotNull
        public final HttpUrl build() {
            ArrayList arrayList2;
            String s = this.scheme;
            if(s == null) {
                throw new IllegalStateException("scheme == null");
            }
            String s1 = okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, null);
            String s2 = okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, null);
            String s3 = this.host;
            if(s3 == null) {
                throw new IllegalStateException("host == null");
            }
            int v = this.effectivePort();
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, this.encodedPathSegments));
            for(Object object0: this.encodedPathSegments) {
                arrayList0.add(okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, ((String)object0), 0, 0, false, 7, null));
            }
            List list0 = this.encodedQueryNamesAndValues;
            String s4 = null;
            if(list0 == null) {
                arrayList2 = null;
            }
            else {
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
                for(Object object1: list0) {
                    String s5 = (String)object1;
                    arrayList1.add((s5 == null ? null : okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, s5, 0, 0, true, 3, null)));
                }
                arrayList2 = arrayList1;
            }
            String s6 = this.encodedFragment;
            if(s6 != null) {
                s4 = okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, s6, 0, 0, false, 7, null);
            }
            return new HttpUrl(s, s1, s2, s3, v, arrayList0, arrayList2, s4, "///");
        }

        private final int effectivePort() {
            int v = this.port;
            if(v != -1) {
                return v;
            }
            String s = this.scheme;
            q.d(s);
            return HttpUrl.Companion.defaultPort(s);
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String s) {
            this.encodedFragment = s == null ? null : okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, "", true, false, false, true, null, 0xB3, null);
            return this;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String s) {
            q.g(s, "encodedPassword");
            this.encodedPassword = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 0xF3, null);
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String s) {
            q.g(s, "encodedPath");
            if(!v.r0(s, "/", false)) {
                throw new IllegalArgumentException(("unexpected encodedPath: " + s).toString());
            }
            this.resolvePath(s, 0, s.length());
            return this;
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String s) {
            List list0;
            if(s == null) {
                list0 = null;
            }
            else {
                okhttp3.HttpUrl.Companion httpUrl$Companion0 = HttpUrl.Companion;
                String s1 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(httpUrl$Companion0, s, 0, 0, " \"\'<>#", true, false, true, false, null, 0xD3, null);
                list0 = s1 == null ? null : httpUrl$Companion0.toQueryNamesAndValues$okhttp(s1);
            }
            this.encodedQueryNamesAndValues = list0;
            return this;
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String s) {
            q.g(s, "encodedUsername");
            this.encodedUsername = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 0xF3, null);
            return this;
        }

        @NotNull
        public final Builder fragment(@Nullable String s) {
            this.encodedFragment = s == null ? null : okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, "", false, false, false, true, null, 0xBB, null);
            return this;
        }

        @Nullable
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @NotNull
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @NotNull
        public final List getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @NotNull
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @Nullable
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @Nullable
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @NotNull
        public final Builder host(@NotNull String s) {
            q.g(s, "host");
            String s1 = HostnamesKt.toCanonicalHost(okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, s, 0, 0, false, 7, null));
            if(s1 == null) {
                throw new IllegalArgumentException("unexpected host: " + s);
            }
            this.host = s1;
            return this;
        }

        // 去混淆评级： 低(20)
        private final boolean isDot(String s) {
            return q.b(s, ".") || v.j0(s, "%2e", true);
        }

        // 去混淆评级： 低(40)
        private final boolean isDotDot(String s) {
            return q.b(s, "..") || v.j0(s, "%2e.", true) || v.j0(s, ".%2e", true) || v.j0(s, "%2e%2e", true);
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl httpUrl0, @NotNull String s) {
            int v17;
            int v12;
            int v11;
            int v10;
            int v6;
            int v4;
            q.g(s, "input");
            int v = Util.indexOfFirstNonAsciiWhitespace$default(s, 0, 0, 3, null);
            int v1 = Util.indexOfLastNonAsciiWhitespace$default(s, v, 0, 2, null);
            Companion httpUrl$Builder$Companion0 = Builder.Companion;
            int v2 = Companion.access$schemeDelimiterOffset(httpUrl$Builder$Companion0, s, v, v1);
            if(v2 != -1) {
                if(v.q0(v, s, "https:", true)) {
                    this.scheme = "https";
                    v += 6;
                    goto label_19;
                }
                if(v.q0(v, s, "http:", true)) {
                    this.scheme = "http";
                    v += 5;
                    goto label_19;
                }
                String s1 = s.substring(0, v2);
                q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
                throw new IllegalArgumentException("Expected URL scheme \'http\' or \'https\' but was \'" + s1 + '\'');
            }
            if(httpUrl0 == null) {
                throw new IllegalArgumentException("Expected URL scheme \'http\' or \'https\' but no scheme was found for " + (s.length() <= 6 ? s : o.d1(6, s) + "..."));
            }
            this.scheme = httpUrl0.scheme();
        label_19:
            int v3 = Companion.access$slashCount(httpUrl$Builder$Companion0, s, v, v1);
            if(v3 < 2 && httpUrl0 != null && q.b(httpUrl0.scheme(), this.scheme)) {
                this.encodedUsername = httpUrl0.encodedUsername();
                this.encodedPassword = httpUrl0.encodedPassword();
                this.host = httpUrl0.host();
                this.port = httpUrl0.port();
                this.encodedPathSegments.clear();
                Collection collection0 = httpUrl0.encodedPathSegments();
                this.encodedPathSegments.addAll(collection0);
                if(v == v1 || s.charAt(v) == 35) {
                    this.encodedQuery(httpUrl0.encodedQuery());
                }
                v4 = v1;
                goto label_80;
            }
            int v5 = v + v3;
            boolean z = false;
            boolean z1 = false;
            while(true) {
                v6 = Util.delimiterOffset(s, "@/\\?#", v5, v1);
                int v7 = v6 == v1 ? -1 : s.charAt(v6);
                if(v7 == -1 || v7 == 35 || v7 == 0x2F || (v7 == 0x3F || v7 == 92)) {
                    break;
                }
                if(v7 == 0x40) {
                    if(z) {
                        v10 = v1;
                        v12 = v6;
                        this.encodedPassword = this.encodedPassword + "%40" + okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, v5, v6, " \"\':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 0xF0, null);
                    }
                    else {
                        int v8 = Util.delimiterOffset(s, ':', v5, v6);
                        okhttp3.HttpUrl.Companion httpUrl$Companion0 = HttpUrl.Companion;
                        int v9 = v8;
                        v10 = v1;
                        String s2 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(httpUrl$Companion0, s, v5, v9, " \"\':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 0xF0, null);
                        if(z1) {
                            s2 = Y.l(new StringBuilder(), this.encodedUsername, "%40", s2);
                        }
                        this.encodedUsername = s2;
                        if(v9 == v6) {
                            v11 = v6;
                        }
                        else {
                            v11 = v6;
                            this.encodedPassword = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(httpUrl$Companion0, s, v9 + 1, v11, " \"\':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 0xF0, null);
                            z = true;
                        }
                        v12 = v11;
                        z1 = true;
                    }
                    v5 = v12 + 1;
                    v1 = v10;
                }
            }
            v4 = v1;
            Companion httpUrl$Builder$Companion1 = Builder.Companion;
            int v13 = httpUrl$Builder$Companion1.portColonOffset(s, v5, v6);
            if(v13 + 1 < v6) {
                this.host = HostnamesKt.toCanonicalHost(okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, s, v5, v13, false, 4, null));
                int v14 = httpUrl$Builder$Companion1.parsePort(s, v13 + 1, v6);
                this.port = v14;
                if(v14 == -1) {
                    String s3 = s.substring(v13 + 1, v6);
                    q.f(s3, "this as java.lang.String…ing(startIndex, endIndex)");
                    throw new IllegalArgumentException(("Invalid URL port: \"" + s3 + '\"').toString());
                }
            }
            else {
                this.host = HostnamesKt.toCanonicalHost(okhttp3.HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, s, v5, v13, false, 4, null));
                String s4 = this.scheme;
                q.d(s4);
                this.port = HttpUrl.Companion.defaultPort(s4);
            }
            if(this.host != null) {
                v = v6;
            label_80:
                int v15 = Util.delimiterOffset(s, "?#", v, v4);
                this.resolvePath(s, v, v15);
                if(v15 >= v4 || s.charAt(v15) != 0x3F) {
                    v17 = v15;
                }
                else {
                    int v16 = Util.delimiterOffset(s, '#', v15, v4);
                    String s5 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, v15 + 1, v16, " \"\'<>#", true, false, true, false, null, 0xD0, null);
                    this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(s5);
                    v17 = v16;
                }
                if(v17 < v4 && s.charAt(v17) == 35) {
                    this.encodedFragment = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, v17 + 1, v4, "", true, false, false, true, null, 0xB0, null);
                }
                return this;
            }
            String s6 = s.substring(v5, v13);
            q.f(s6, "this as java.lang.String…ing(startIndex, endIndex)");
            throw new IllegalArgumentException(("Invalid URL host: \"" + s6 + '\"').toString());
        }

        @NotNull
        public final Builder password(@NotNull String s) {
            q.g(s, "password");
            this.encodedPassword = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 0xFB, null);
            return this;
        }

        private final void pop() {
            if(((String)this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1)).length() == 0 && !this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        @NotNull
        public final Builder port(int v) {
            if(1 > v || v >= 0x10000) {
                throw new IllegalArgumentException(("unexpected port: " + v).toString());
            }
            this.port = v;
            return this;
        }

        private final void push(String s, int v, int v1, boolean z, boolean z1) {
            String s1 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, v, v1, " \"<>^`{}|/\\?#", z1, false, false, false, null, 0xF0, null);
            if(!this.isDot(s1)) {
                if(this.isDotDot(s1)) {
                    this.pop();
                    return;
                }
                if(((CharSequence)Z.h(1, this.encodedPathSegments)).length() == 0) {
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, s1);
                }
                else {
                    this.encodedPathSegments.add(s1);
                }
                if(z) {
                    this.encodedPathSegments.add("");
                }
            }
        }

        @NotNull
        public final Builder query(@Nullable String s) {
            List list0;
            if(s == null) {
                list0 = null;
            }
            else {
                okhttp3.HttpUrl.Companion httpUrl$Companion0 = HttpUrl.Companion;
                String s1 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(httpUrl$Companion0, s, 0, 0, " \"\'<>#", false, false, true, false, null, 0xDB, null);
                list0 = s1 == null ? null : httpUrl$Companion0.toQueryNamesAndValues$okhttp(s1);
            }
            this.encodedQueryNamesAndValues = list0;
            return this;
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            String s2;
            String s = this.host;
            String s1 = null;
            if(s == null) {
                s2 = null;
            }
            else {
                Pattern pattern0 = Pattern.compile("[\"<>^`{|}]");
                q.f(pattern0, "compile(...)");
                s2 = pattern0.matcher(s).replaceAll("");
                q.f(s2, "replaceAll(...)");
            }
            this.host = s2;
            int v = this.encodedPathSegments.size();
            for(int v2 = 0; v2 < v; ++v2) {
                String s3 = (String)this.encodedPathSegments.get(v2);
                String s4 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s3, 0, 0, "[]", true, true, false, false, null, 0xE3, null);
                this.encodedPathSegments.set(v2, s4);
            }
            List list0 = this.encodedQueryNamesAndValues;
            if(list0 != null) {
                int v3 = list0.size();
                for(int v1 = 0; v1 < v3; ++v1) {
                    String s5 = (String)list0.get(v1);
                    list0.set(v1, (s5 == null ? null : okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s5, 0, 0, "\\^`{|}", true, true, true, false, null, 0xC3, null)));
                }
            }
            String s6 = this.encodedFragment;
            if(s6 != null) {
                s1 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s6, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 0xA3, null);
            }
            this.encodedFragment = s1;
            return this;
        }

        private final void removeAllCanonicalQueryParameters(String s) {
            List list0 = this.encodedQueryNamesAndValues;
            q.d(list0);
            int v = list0.size() - 2;
            int v1 = a.G(v, 0, -2);
            if(v1 <= v) {
                while(true) {
                    List list1 = this.encodedQueryNamesAndValues;
                    q.d(list1);
                    if(q.b(s, list1.get(v))) {
                        List list2 = this.encodedQueryNamesAndValues;
                        q.d(list2);
                        list2.remove(v + 1);
                        List list3 = this.encodedQueryNamesAndValues;
                        q.d(list3);
                        list3.remove(v);
                        List list4 = this.encodedQueryNamesAndValues;
                        q.d(list4);
                        if(list4.isEmpty()) {
                            this.encodedQueryNamesAndValues = null;
                            return;
                        }
                    }
                    if(v == v1) {
                        break;
                    }
                    v -= 2;
                }
            }
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String s) {
            q.g(s, "encodedName");
            if(this.encodedQueryNamesAndValues == null) {
                return this;
            }
            this.removeAllCanonicalQueryParameters(okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\'<>#&=", true, false, true, false, null, 0xD3, null));
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String s) {
            q.g(s, "name");
            if(this.encodedQueryNamesAndValues == null) {
                return this;
            }
            this.removeAllCanonicalQueryParameters(okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " !\"#$&\'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 0xDB, null));
            return this;
        }

        @NotNull
        public final Builder removePathSegment(int v) {
            this.encodedPathSegments.remove(v);
            if(this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        private final void resolvePath(String s, int v, int v1) {
            if(v != v1) {
                switch(s.charAt(v)) {
                    case 0x2F: 
                    case 92: {
                        this.encodedPathSegments.clear();
                        this.encodedPathSegments.add("");
                        ++v;
                        break;
                    }
                    default: {
                        this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, "");
                    }
                }
                for(int v2 = v; v2 < v1; v2 = z ? v3 + 1 : v3) {
                    int v3 = Util.delimiterOffset(s, "/\\", v2, v1);
                    boolean z = v3 < v1;
                    this.push(s, v2, v3, z, true);
                }
            }
        }

        @NotNull
        public final Builder scheme(@NotNull String s) {
            q.g(s, "scheme");
            if(s.equalsIgnoreCase("http")) {
                this.scheme = "http";
                return this;
            }
            if(!s.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: " + s);
            }
            this.scheme = "https";
            return this;
        }

        public final void setEncodedFragment$okhttp(@Nullable String s) {
            this.encodedFragment = s;
        }

        public final void setEncodedPassword$okhttp(@NotNull String s) {
            q.g(s, "<set-?>");
            this.encodedPassword = s;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int v, @NotNull String s) {
            q.g(s, "encodedPathSegment");
            String s1 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"<>^`{}|/\\?#", true, false, false, false, null, 0xF3, null);
            this.encodedPathSegments.set(v, s1);
            if(this.isDot(s1) || this.isDotDot(s1)) {
                throw new IllegalArgumentException(("unexpected path segment: " + s).toString());
            }
            return this;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List list0) {
            this.encodedQueryNamesAndValues = list0;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String s, @Nullable String s1) {
            q.g(s, "encodedName");
            this.removeAllEncodedQueryParameters(s);
            this.addEncodedQueryParameter(s, s1);
            return this;
        }

        public final void setEncodedUsername$okhttp(@NotNull String s) {
            q.g(s, "<set-?>");
            this.encodedUsername = s;
        }

        public final void setHost$okhttp(@Nullable String s) {
            this.host = s;
        }

        @NotNull
        public final Builder setPathSegment(int v, @NotNull String s) {
            q.g(s, "pathSegment");
            String s1 = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"<>^`{}|/\\?#", false, false, false, false, null, 0xFB, null);
            if(this.isDot(s1) || this.isDotDot(s1)) {
                throw new IllegalArgumentException(("unexpected path segment: " + s).toString());
            }
            this.encodedPathSegments.set(v, s1);
            return this;
        }

        public final void setPort$okhttp(int v) {
            this.port = v;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String s, @Nullable String s1) {
            q.g(s, "name");
            this.removeAllQueryParameters(s);
            this.addQueryParameter(s, s1);
            return this;
        }

        public final void setScheme$okhttp(@Nullable String s) {
            this.scheme = s;
        }

        @Override
        @NotNull
        public String toString() [...] // 潜在的解密器

        @NotNull
        public final Builder username(@NotNull String s) {
            q.g(s, "username");
            this.encodedUsername = okhttp3.HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, s, 0, 0, " \"\':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 0xFB, null);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u0019\n\u0002\b\u000B\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001A\u00020\f*\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ#\u0010\u000F\u001A\u00020\n*\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J]\u0010\u0018\u001A\u00020\f*\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u001A\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ%\u0010#\u001A\u00020\f*\b\u0012\u0004\u0012\u00020\u00050\u001D2\n\u0010 \u001A\u00060\u001Ej\u0002`\u001FH\u0000\u00A2\u0006\u0004\b!\u0010\"J\'\u0010%\u001A\u00020\f*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001D2\n\u0010 \u001A\u00060\u001Ej\u0002`\u001FH\u0000\u00A2\u0006\u0004\b$\u0010\"J\u001B\u0010)\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050&*\u00020\u0005H\u0000\u00A2\u0006\u0004\b\'\u0010(J\u0013\u0010-\u001A\u00020**\u00020\u0005H\u0007\u00A2\u0006\u0004\b+\u0010,J\u0015\u0010/\u001A\u0004\u0018\u00010**\u00020\u0005H\u0007\u00A2\u0006\u0004\b.\u0010,J\u0015\u0010/\u001A\u0004\u0018\u00010**\u000200H\u0007\u00A2\u0006\u0004\b+\u00101J\u0015\u0010/\u001A\u0004\u0018\u00010**\u000202H\u0007\u00A2\u0006\u0004\b+\u00103J\u0017\u0010+\u001A\u00020*2\u0006\u00104\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b5\u0010,J\u0019\u0010.\u001A\u0004\u0018\u00010*2\u0006\u00104\u001A\u00020\u0005H\u0007\u00A2\u0006\u0004\b6\u0010,J\u0019\u0010+\u001A\u0004\u0018\u00010*2\u0006\u00104\u001A\u000200H\u0007\u00A2\u0006\u0004\b5\u00101J\u0019\u0010+\u001A\u0004\u0018\u00010*2\u0006\u00107\u001A\u000202H\u0007\u00A2\u0006\u0004\b5\u00103J1\u0010:\u001A\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\u000B\u001A\u00020\nH\u0000\u00A2\u0006\u0004\b8\u00109Jc\u0010=\u001A\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u00052\b\b\u0002\u0010\u0013\u001A\u00020\n2\b\b\u0002\u0010\u0014\u001A\u00020\n2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\u0015\u001A\u00020\n2\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0000\u00A2\u0006\u0004\b;\u0010<R\u0014\u0010>\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010@\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b@\u0010?R\u0014\u0010A\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bA\u0010?R\u0014\u0010C\u001A\u00020B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010E\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bE\u0010?R\u0014\u0010F\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bF\u0010?R\u0014\u0010G\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bG\u0010?R\u0014\u0010H\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bH\u0010?R\u0014\u0010I\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bI\u0010?R\u0014\u0010J\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bJ\u0010?R\u0014\u0010K\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bK\u0010?R\u0014\u0010L\u001A\u00020\u00058\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bL\u0010?\u00A8\u0006M"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "<init>", "()V", "Lokio/Buffer;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "Lie/H;", "writePercentDecoded", "(Lokio/Buffer;Ljava/lang/String;IIZ)V", "isPercentEncoded", "(Ljava/lang/String;II)Z", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "writeCanonicalized", "(Lokio/Buffer;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)V", "scheme", "defaultPort", "(Ljava/lang/String;)I", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", "", "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/HttpUrl;", "Ljava/net/URI;", "(Ljava/net/URI;)Lokhttp3/HttpUrl;", "url", "-deprecated_get", "-deprecated_parse", "uri", "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "percentDecode", "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class okhttp3.HttpUrl.Companion {
        @d
        @NotNull
        public final HttpUrl -deprecated_get(@NotNull String s) {
            q.g(s, "url");
            return this.get(s);
        }

        @d
        @Nullable
        public final HttpUrl -deprecated_get(@NotNull URI uRI0) {
            q.g(uRI0, "uri");
            return this.get(uRI0);
        }

        @d
        @Nullable
        public final HttpUrl -deprecated_get(@NotNull URL uRL0) {
            q.g(uRL0, "url");
            return this.get(uRL0);
        }

        @d
        @Nullable
        public final HttpUrl -deprecated_parse(@NotNull String s) {
            q.g(s, "url");
            return this.parse(s);
        }

        private okhttp3.HttpUrl.Companion() {
        }

        public okhttp3.HttpUrl.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String canonicalize$okhttp(@NotNull String s, int v, int v1, @NotNull String s1, boolean z, boolean z1, boolean z2, boolean z3, @Nullable Charset charset0) {
            q.g(s, "<this>");
            q.g(s1, "encodeSet");
            int v2 = v;
            while(v2 < v1) {
                int v3 = s.codePointAt(v2);
                if(v3 >= 0x20 && v3 != 0x7F && (v3 < 0x80 || z3) && !o.w0(s1, ((char)v3)) && (v3 != 37 || z && (!z1 || this.isPercentEncoded(s, v2, v1))) && (v3 != 43 || !z2)) {
                    v2 += Character.charCount(v3);
                    continue;
                }
                Buffer buffer0 = new Buffer();
                buffer0.writeUtf8(s, v, v2);
                this.writeCanonicalized(buffer0, s, v2, v1, s1, z, z1, z2, z3, charset0);
                return "";
            }
            String s2 = s.substring(v, v1);
            q.f(s2, "this as java.lang.String…ing(startIndex, endIndex)");
            return s2;
        }

        public static String canonicalize$okhttp$default(okhttp3.HttpUrl.Companion httpUrl$Companion0, String s, int v, int v1, String s1, boolean z, boolean z1, boolean z2, boolean z3, Charset charset0, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = 0;
            }
            if((v2 & 2) != 0) {
                v1 = s.length();
            }
            if((v2 & 8) != 0) {
                z = false;
            }
            if((v2 & 16) != 0) {
                z1 = false;
            }
            if((v2 & 0x20) != 0) {
                z2 = false;
            }
            if((v2 & 0x40) != 0) {
                z3 = false;
            }
            if((v2 & 0x80) != 0) {
                charset0 = null;
            }
            return httpUrl$Companion0.canonicalize$okhttp(s, v, v1, s1, z, z1, z2, z3, charset0);
        }

        public final int defaultPort(@NotNull String s) {
            q.g(s, "scheme");
            if(s.equals("http")) {
                return 80;
            }
            return s.equals("https") ? 443 : -1;
        }

        @NotNull
        public final HttpUrl get(@NotNull String s) {
            q.g(s, "<this>");
            return new Builder().parse$okhttp(null, s).build();
        }

        @Nullable
        public final HttpUrl get(@NotNull URI uRI0) {
            q.g(uRI0, "<this>");
            String s = uRI0.toString();
            q.f(s, "toString()");
            return this.parse(s);
        }

        @Nullable
        public final HttpUrl get(@NotNull URL uRL0) {
            q.g(uRL0, "<this>");
            String s = uRL0.toString();
            q.f(s, "toString()");
            return this.parse(s);
        }

        private final boolean isPercentEncoded(String s, int v, int v1) {
            return v + 2 < v1 && s.charAt(v) == 37 && Util.parseHexDigit(s.charAt(v + 1)) != -1 && Util.parseHexDigit(s.charAt(v + 2)) != -1;
        }

        @Nullable
        public final HttpUrl parse(@NotNull String s) {
            q.g(s, "<this>");
            try {
                return this.get(s);
            }
            catch(IllegalArgumentException unused_ex) {
                return null;
            }
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String s, int v, int v1, boolean z) {
            q.g(s, "<this>");
            int v2 = v;
            while(v2 < v1) {
                int v3 = s.charAt(v2);
                if(v3 != 37 && (v3 != 43 || !z)) {
                    ++v2;
                    continue;
                }
                Buffer buffer0 = new Buffer();
                buffer0.writeUtf8(s, v, v2);
                this.writePercentDecoded(buffer0, s, v2, v1, z);
                return "";
            }
            String s1 = s.substring(v, v1);
            q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
            return s1;
        }

        public static String percentDecode$okhttp$default(okhttp3.HttpUrl.Companion httpUrl$Companion0, String s, int v, int v1, boolean z, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = 0;
            }
            if((v2 & 2) != 0) {
                v1 = s.length();
            }
            if((v2 & 4) != 0) {
                z = false;
            }
            return httpUrl$Companion0.percentDecode$okhttp(s, v, v1, z);
        }

        public final void toPathString$okhttp(@NotNull List list0, @NotNull StringBuilder stringBuilder0) {
            q.g(list0, "<this>");
            q.g(stringBuilder0, "out");
            int v = list0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                stringBuilder0.append('/');
                stringBuilder0.append(((String)list0.get(v1)));
            }
        }

        @NotNull
        public final List toQueryNamesAndValues$okhttp(@NotNull String s) {
            q.g(s, "<this>");
            List list0 = new ArrayList();
            for(int v = 0; v <= s.length(); v = v1 + 1) {
                int v1 = o.E0(s, '&', v, 4);
                if(v1 == -1) {
                    v1 = s.length();
                }
                int v2 = o.E0(s, '=', v, 4);
                if(v2 == -1 || v2 > v1) {
                    String s3 = s.substring(v, v1);
                    q.f(s3, "this as java.lang.String…ing(startIndex, endIndex)");
                    ((ArrayList)list0).add(s3);
                    ((ArrayList)list0).add(null);
                }
                else {
                    String s1 = s.substring(v, v2);
                    q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
                    ((ArrayList)list0).add(s1);
                    String s2 = s.substring(v2 + 1, v1);
                    q.f(s2, "this as java.lang.String…ing(startIndex, endIndex)");
                    ((ArrayList)list0).add(s2);
                }
            }
            return list0;
        }

        public final void toQueryString$okhttp(@NotNull List list0, @NotNull StringBuilder stringBuilder0) {
            q.g(list0, "<this>");
            q.g(stringBuilder0, "out");
            e e0 = P4.a.C(P4.a.K(0, list0.size()), 2);
            int v = e0.a;
            int v1 = e0.b;
            int v2 = e0.c;
            if(v2 > 0 && v <= v1 || v2 < 0 && v1 <= v) {
                while(true) {
                    String s = (String)list0.get(v);
                    String s1 = (String)list0.get(v + 1);
                    if(v > 0) {
                        stringBuilder0.append('&');
                    }
                    stringBuilder0.append(s);
                    if(s1 != null) {
                        stringBuilder0.append('=');
                        stringBuilder0.append(s1);
                    }
                    if(v == v1) {
                        break;
                    }
                    v += v2;
                }
            }
        }

        private final void writeCanonicalized(Buffer buffer0, String s, int v, int v1, String s1, boolean z, boolean z1, boolean z2, boolean z3, Charset charset0) {
            Buffer buffer1 = null;
            while(v < v1) {
                int v2 = s.codePointAt(v);
                if(!z || v2 != 9 && v2 != 10 && v2 != 12 && v2 != 13) {
                    if(v2 == 43 && z2) {
                        buffer0.writeUtf8((z ? "+" : "%2B"));
                    }
                    else if(v2 < 0x20 || v2 == 0x7F || v2 >= 0x80 && !z3 || o.w0(s1, ((char)v2)) || v2 == 37 && (!z || z1 && !this.isPercentEncoded(s, v, v1))) {
                        if(buffer1 == null) {
                            buffer1 = new Buffer();
                        }
                        if(charset0 == null || charset0.equals(StandardCharsets.UTF_8)) {
                            buffer1.writeUtf8CodePoint(v2);
                        }
                        else {
                            buffer1.writeString(s, v, Character.charCount(v2) + v, charset0);
                        }
                        while(!buffer1.exhausted()) {
                            int v3 = buffer1.readByte();
                            buffer0.writeByte(37);
                            buffer0.writeByte(((int)HttpUrl.HEX_DIGITS[(v3 & 0xFF) >> 4 & 15]));
                            buffer0.writeByte(((int)HttpUrl.HEX_DIGITS[v3 & 15]));
                        }
                    }
                    else {
                        buffer0.writeUtf8CodePoint(v2);
                    }
                }
                v += Character.charCount(v2);
            }
        }

        private final void writePercentDecoded(Buffer buffer0, String s, int v, int v1, boolean z) {
            while(v < v1) {
                int v2 = s.codePointAt(v);
                if(v2 == 37 && v + 2 < v1) {
                    int v3 = Util.parseHexDigit(s.charAt(v + 1));
                    int v4 = Util.parseHexDigit(s.charAt(v + 2));
                    if(v3 != -1 && v4 != -1) {
                        buffer0.writeByte((v3 << 4) + v4);
                        v += 3;
                        continue;
                    }
                }
                else if(v2 == 43 && z) {
                    buffer0.writeByte(0x20);
                    ++v;
                    continue;
                }
                buffer0.writeUtf8CodePoint(v2);
                v += Character.charCount(v2);
            }
        }
    }

    @NotNull
    public static final okhttp3.HttpUrl.Companion Companion = null;
    @NotNull
    public static final String FORM_ENCODE_SET = " \"\':;<=>@[]^`{}|/\\?#&!$(),~";
    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";
    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    @NotNull
    private static final char[] HEX_DIGITS = null;
    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"\':;<=>@[]^`{}|/\\?#";
    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&\'(),/:;<=>?@[]\\^`{|}~";
    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"\'<>#&=";
    @NotNull
    public static final String QUERY_ENCODE_SET = " \"\'<>#";
    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"\':;<=>@[]^`{}|/\\?#";
    @Nullable
    private final String fragment;
    @NotNull
    private final String host;
    private final boolean isHttps;
    @NotNull
    private final String password;
    @NotNull
    private final List pathSegments;
    private final int port;
    @Nullable
    private final List queryNamesAndValues;
    @NotNull
    private final String scheme;
    @NotNull
    private final String url;
    @NotNull
    private final String username;

    @d
    @Nullable
    public final String -deprecated_encodedFragment() {
        return this.encodedFragment();
    }

    @d
    @NotNull
    public final String -deprecated_encodedPassword() {
        return this.encodedPassword();
    }

    @d
    @NotNull
    public final String -deprecated_encodedPath() {
        return this.encodedPath();
    }

    @d
    @NotNull
    public final List -deprecated_encodedPathSegments() {
        return this.encodedPathSegments();
    }

    @d
    @Nullable
    public final String -deprecated_encodedQuery() {
        return this.encodedQuery();
    }

    @d
    @NotNull
    public final String -deprecated_encodedUsername() {
        return this.encodedUsername();
    }

    @d
    @Nullable
    public final String -deprecated_fragment() {
        return this.fragment;
    }

    @d
    @NotNull
    public final String -deprecated_host() {
        return this.host;
    }

    @d
    @NotNull
    public final String -deprecated_password() {
        return this.password;
    }

    @d
    @NotNull
    public final List -deprecated_pathSegments() {
        return this.pathSegments;
    }

    @d
    public final int -deprecated_pathSize() {
        return this.pathSize();
    }

    @d
    public final int -deprecated_port() {
        return this.port;
    }

    @d
    @Nullable
    public final String -deprecated_query() {
        return this.query();
    }

    @d
    @NotNull
    public final Set -deprecated_queryParameterNames() {
        return this.queryParameterNames();
    }

    @d
    public final int -deprecated_querySize() {
        return this.querySize();
    }

    @d
    @NotNull
    public final String -deprecated_scheme() {
        return this.scheme;
    }

    @d
    @NotNull
    public final URI -deprecated_uri() {
        return this.uri();
    }

    @d
    @NotNull
    public final URL -deprecated_url() {
        return this.url();
    }

    @d
    @NotNull
    public final String -deprecated_username() {
        return this.username;
    }

    static {
        HttpUrl.Companion = new okhttp3.HttpUrl.Companion(null);
        HttpUrl.HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HttpUrl(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, int v, @NotNull List list0, @Nullable List list1, @Nullable String s4, @NotNull String s5) {
        q.g(s, "scheme");
        q.g(s1, "username");
        q.g(s2, "password");
        q.g(s3, "host");
        q.g(list0, "pathSegments");
        q.g(s5, "url");
        super();
        this.scheme = s;
        this.username = s1;
        this.password = s2;
        this.host = s3;
        this.port = v;
        this.pathSegments = list0;
        this.queryNamesAndValues = list1;
        this.fragment = s4;
        this.url = s5;
        this.isHttps = q.b(s, "https");
    }

    public static final int defaultPort(@NotNull String s) {
        return HttpUrl.Companion.defaultPort(s);
    }

    @Nullable
    public final String encodedFragment() {
        if(this.fragment == null) {
            return null;
        }
        int v = o.E0(this.url, '#', 0, 6);
        String s = this.url.substring(v + 1);
        q.f(s, "this as java.lang.String).substring(startIndex)");
        return s;
    }

    @NotNull
    public final String encodedPassword() {
        if(this.password.length() == 0) {
            return "";
        }
        int v = o.E0(this.url, ':', this.scheme.length() + 3, 4);
        int v1 = o.E0(this.url, '@', 0, 6);
        String s = this.url.substring(v + 1, v1);
        q.f(s, "this as java.lang.String…ing(startIndex, endIndex)");
        return s;
    }

    @NotNull
    public final String encodedPath() {
        int v = o.E0(this.url, '/', this.scheme.length() + 3, 4);
        int v1 = Util.delimiterOffset(this.url, "?#", v, this.url.length());
        String s = this.url.substring(v, v1);
        q.f(s, "this as java.lang.String…ing(startIndex, endIndex)");
        return s;
    }

    @NotNull
    public final List encodedPathSegments() {
        int v = o.E0(this.url, '/', this.scheme.length() + 3, 4);
        int v1 = Util.delimiterOffset(this.url, "?#", v, this.url.length());
        List list0 = new ArrayList();
        while(v < v1) {
            int v2 = Util.delimiterOffset(this.url, '/', v + 1, v1);
            String s = this.url.substring(v + 1, v2);
            q.f(s, "this as java.lang.String…ing(startIndex, endIndex)");
            ((ArrayList)list0).add(s);
            v = v2;
        }
        return list0;
    }

    @Nullable
    public final String encodedQuery() {
        if(this.queryNamesAndValues == null) {
            return null;
        }
        int v = o.E0(this.url, '?', 0, 6);
        int v1 = Util.delimiterOffset(this.url, '#', v + 1, this.url.length());
        String s = this.url.substring(v + 1, v1);
        q.f(s, "this as java.lang.String…ing(startIndex, endIndex)");
        return s;
    }

    @NotNull
    public final String encodedUsername() {
        if(this.username.length() == 0) {
            return "";
        }
        int v = this.scheme.length();
        int v1 = Util.delimiterOffset(this.url, ":@", v + 3, this.url.length());
        String s = this.url.substring(v + 3, v1);
        q.f(s, "this as java.lang.String…ing(startIndex, endIndex)");
        return s;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof HttpUrl && q.b(((HttpUrl)object0).url, this.url);
    }

    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    @NotNull
    public static final HttpUrl get(@NotNull String s) {
        return HttpUrl.Companion.get(s);
    }

    @Nullable
    public static final HttpUrl get(@NotNull URI uRI0) {
        return HttpUrl.Companion.get(uRI0);
    }

    @Nullable
    public static final HttpUrl get(@NotNull URL uRL0) {
        return HttpUrl.Companion.get(uRL0);
    }

    @Override
    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder httpUrl$Builder0 = new Builder();
        httpUrl$Builder0.setScheme$okhttp(this.scheme);
        httpUrl$Builder0.setEncodedUsername$okhttp(this.encodedUsername());
        httpUrl$Builder0.setEncodedPassword$okhttp(this.encodedPassword());
        httpUrl$Builder0.setHost$okhttp(this.host);
        int v = HttpUrl.Companion.defaultPort(this.scheme);
        httpUrl$Builder0.setPort$okhttp((this.port == v ? -1 : this.port));
        httpUrl$Builder0.getEncodedPathSegments$okhttp().clear();
        httpUrl$Builder0.getEncodedPathSegments$okhttp().addAll(this.encodedPathSegments());
        httpUrl$Builder0.encodedQuery(this.encodedQuery());
        httpUrl$Builder0.setEncodedFragment$okhttp(this.encodedFragment());
        return httpUrl$Builder0;
    }

    @Nullable
    public final Builder newBuilder(@NotNull String s) {
        q.g(s, "link");
        try {
            return new Builder().parse$okhttp(this, s);
        }
        catch(IllegalArgumentException unused_ex) {
            return null;
        }
    }

    @Nullable
    public static final HttpUrl parse(@NotNull String s) {
        return HttpUrl.Companion.parse(s);
    }

    @NotNull
    public final String password() {
        return this.password;
    }

    @NotNull
    public final List pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    @Nullable
    public final String query() {
        if(this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        HttpUrl.Companion.toQueryString$okhttp(this.queryNamesAndValues, stringBuilder0);
        return stringBuilder0.toString();
    }

    @Nullable
    public final String queryParameter(@NotNull String s) {
        q.g(s, "name");
        List list0 = this.queryNamesAndValues;
        if(list0 != null) {
            e e0 = P4.a.C(P4.a.K(0, list0.size()), 2);
            int v = e0.a;
            int v1 = e0.b;
            int v2 = e0.c;
            if(v2 > 0 && v <= v1 || v2 < 0 && v1 <= v) {
                while(true) {
                    if(s.equals(this.queryNamesAndValues.get(v))) {
                        return (String)this.queryNamesAndValues.get(v + 1);
                    }
                    if(v == v1) {
                        break;
                    }
                    v += v2;
                }
            }
        }
        return null;
    }

    @NotNull
    public final String queryParameterName(int v) {
        List list0 = this.queryNamesAndValues;
        if(list0 == null) {
            throw new IndexOutOfBoundsException();
        }
        Object object0 = list0.get(v * 2);
        q.d(object0);
        return (String)object0;
    }

    @NotNull
    public final Set queryParameterNames() {
        if(this.queryNamesAndValues == null) {
            return y.a;
        }
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        e e0 = P4.a.C(P4.a.K(0, this.queryNamesAndValues.size()), 2);
        int v = e0.a;
        int v1 = e0.b;
        int v2 = e0.c;
        if(v2 > 0 && v <= v1 || v2 < 0 && v1 <= v) {
            while(true) {
                Object object0 = this.queryNamesAndValues.get(v);
                q.d(object0);
                linkedHashSet0.add(object0);
                if(v == v1) {
                    break;
                }
                v += v2;
            }
        }
        Set set0 = Collections.unmodifiableSet(linkedHashSet0);
        q.f(set0, "unmodifiableSet(result)");
        return set0;
    }

    @Nullable
    public final String queryParameterValue(int v) {
        List list0 = this.queryNamesAndValues;
        if(list0 == null) {
            throw new IndexOutOfBoundsException();
        }
        return (String)list0.get(v * 2 + 1);
    }

    @NotNull
    public final List queryParameterValues(@NotNull String s) {
        q.g(s, "name");
        if(this.queryNamesAndValues == null) {
            return w.a;
        }
        ArrayList arrayList0 = new ArrayList();
        e e0 = P4.a.C(P4.a.K(0, this.queryNamesAndValues.size()), 2);
        int v = e0.a;
        int v1 = e0.b;
        int v2 = e0.c;
        if(v2 > 0 && v <= v1 || v2 < 0 && v1 <= v) {
            while(true) {
                if(s.equals(this.queryNamesAndValues.get(v))) {
                    arrayList0.add(this.queryNamesAndValues.get(v + 1));
                }
                if(v == v1) {
                    break;
                }
                v += v2;
            }
        }
        List list0 = Collections.unmodifiableList(arrayList0);
        q.f(list0, "unmodifiableList(result)");
        return list0;
    }

    public final int querySize() {
        return this.queryNamesAndValues == null ? 0 : this.queryNamesAndValues.size() / 2;
    }

    @NotNull
    public final String redact() {
        Builder httpUrl$Builder0 = this.newBuilder("/...");
        q.d(httpUrl$Builder0);
        return httpUrl$Builder0.username("").password("").build().toString();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String s) {
        q.g(s, "link");
        Builder httpUrl$Builder0 = this.newBuilder(s);
        return httpUrl$Builder0 == null ? null : httpUrl$Builder0.build();
    }

    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @Override
    @NotNull
    public String toString() {
        return this.url;
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final String topPrivateDomain() {
        return Util.canParseAsIpAddress(this.host) ? null : PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @NotNull
    public final URI uri() {
        URI uRI0;
        try {
            return new URI("///");
        }
        catch(URISyntaxException uRISyntaxException0) {
            try {
                q.f(Pattern.compile("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]"), "compile(...)");
                q.g("///", "input");
                q.f("///", "replaceAll(...)");
                uRI0 = URI.create("///");
            }
            catch(Exception unused_ex) {
                throw new RuntimeException(uRISyntaxException0);
            }
            q.f(uRI0, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
            return uRI0;
        }
    }

    @NotNull
    public final URL url() {
        try {
            return new URL(this.url);
        }
        catch(MalformedURLException malformedURLException0) {
            throw new RuntimeException(malformedURLException0);
        }
    }

    @NotNull
    public final String username() {
        return this.username;
    }
}

