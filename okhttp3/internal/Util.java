package okhttp3.internal;

import Ce.f;
import Ce.g;
import Tf.n;
import Tf.o;
import c2.Y;
import d8.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import je.p;
import je.w;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import okhttp3.Call;
import okhttp3.EventListener.Factory;
import okhttp3.EventListener;
import okhttp3.Headers.Builder;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody.Companion;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000\u00C2\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001A%\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u0000\u00A2\u0006\u0004\b\u0005\u0010\u0006\u001A\u001D\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\r\u001A;\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00070\u000E*\b\u0012\u0004\u0012\u00020\u00070\u000E2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u000E2\u000E\u0010\u0011\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010\u00A2\u0006\u0004\b\u0012\u0010\u0013\u001A7\u0010\u0014\u001A\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000E2\u000E\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000E2\u000E\u0010\u0011\u001A\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010\u00A2\u0006\u0004\b\u0014\u0010\u0015\u001A\u001B\u0010\u0018\u001A\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001A\u00020\t\u00A2\u0006\u0004\b\u0018\u0010\u0019\u001A-\u0010\u001C\u001A\u00020\u001B*\b\u0012\u0004\u0012\u00020\u00070\u000E2\u0006\u0010\u001A\u001A\u00020\u00072\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00070\u0010\u00A2\u0006\u0004\b\u001C\u0010\u001D\u001A%\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u00070\u000E*\b\u0012\u0004\u0012\u00020\u00070\u000E2\u0006\u0010\u001A\u001A\u00020\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001F\u001A%\u0010\"\u001A\u00020\u001B*\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u001B2\b\b\u0002\u0010!\u001A\u00020\u001B\u00A2\u0006\u0004\b\"\u0010#\u001A%\u0010$\u001A\u00020\u001B*\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u001B2\b\b\u0002\u0010!\u001A\u00020\u001B\u00A2\u0006\u0004\b$\u0010#\u001A%\u0010%\u001A\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u001B2\b\b\u0002\u0010!\u001A\u00020\u001B\u00A2\u0006\u0004\b%\u0010&\u001A-\u0010(\u001A\u00020\u001B*\u00020\u00072\u0006\u0010\'\u001A\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u001B2\b\b\u0002\u0010!\u001A\u00020\u001B\u00A2\u0006\u0004\b(\u0010)\u001A-\u0010(\u001A\u00020\u001B*\u00020\u00072\u0006\u0010+\u001A\u00020*2\b\b\u0002\u0010 \u001A\u00020\u001B2\b\b\u0002\u0010!\u001A\u00020\u001B\u00A2\u0006\u0004\b(\u0010,\u001A\u0011\u0010-\u001A\u00020\u001B*\u00020\u0007\u00A2\u0006\u0004\b-\u0010.\u001A\u0011\u0010/\u001A\u00020\t*\u00020\u0007\u00A2\u0006\u0004\b/\u00100\u001A\u0015\u00101\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b1\u00100\u001A)\u00102\u001A\u00020\u00072\u0006\u00102\u001A\u00020\u00072\u0012\u00104\u001A\n\u0012\u0006\b\u0001\u0012\u0002030\u000E\"\u000203\u00A2\u0006\u0004\b2\u00105\u001A\u0019\u00109\u001A\u000207*\u0002062\u0006\u00108\u001A\u000207\u00A2\u0006\u0004\b9\u0010:\u001A\'\u0010>\u001A\u00020\u001B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010;\u001A\u00020\u00002\b\u0010=\u001A\u0004\u0018\u00010<\u00A2\u0006\u0004\b>\u0010?\u001A\u0011\u0010@\u001A\u00020\u001B*\u00020*\u00A2\u0006\u0004\b@\u0010A\u001A\u0017\u0010E\u001A\u00020D*\b\u0012\u0004\u0012\u00020C0B\u00A2\u0006\u0004\bE\u0010F\u001A\u0017\u0010G\u001A\b\u0012\u0004\u0012\u00020C0B*\u00020D\u00A2\u0006\u0004\bG\u0010H\u001A\u0019\u0010I\u001A\u00020\t*\u00020\u00162\u0006\u0010\u000F\u001A\u00020\u0016\u00A2\u0006\u0004\bI\u0010J\u001A\u0011\u0010M\u001A\u00020L*\u00020K\u00A2\u0006\u0004\bM\u0010N\u001A\u001C\u0010Q\u001A\u00020\u001B*\u00020O2\u0006\u0010P\u001A\u00020\u001BH\u0086\u0004\u00A2\u0006\u0004\bQ\u0010R\u001A\u001C\u0010Q\u001A\u00020\u001B*\u00020S2\u0006\u0010P\u001A\u00020\u001BH\u0086\u0004\u00A2\u0006\u0004\bQ\u0010T\u001A\u001C\u0010Q\u001A\u00020\u0000*\u00020\u001B2\u0006\u0010P\u001A\u00020\u0000H\u0086\u0004\u00A2\u0006\u0004\bQ\u0010U\u001A\u0019\u0010X\u001A\u00020\u0004*\u00020V2\u0006\u0010W\u001A\u00020\u001B\u00A2\u0006\u0004\bX\u0010Y\u001A\u0011\u0010Z\u001A\u00020\u001B*\u000206\u00A2\u0006\u0004\bZ\u0010[\u001A!\u0010^\u001A\u00020\t*\u00020\\2\u0006\u0010;\u001A\u00020\u001B2\u0006\u0010]\u001A\u00020<\u00A2\u0006\u0004\b^\u0010_\u001A!\u0010a\u001A\u00020\t*\u00020\\2\u0006\u0010`\u001A\u00020\u001B2\u0006\u0010]\u001A\u00020<\u00A2\u0006\u0004\ba\u0010_\u001A\u0011\u0010c\u001A\u00020\u0007*\u00020b\u00A2\u0006\u0004\bc\u0010d\u001A\u0019\u0010f\u001A\u00020\t*\u00020b2\u0006\u0010e\u001A\u000206\u00A2\u0006\u0004\bf\u0010g\u001A!\u0010j\u001A\u00020\u00042\f\u0010i\u001A\b\u0012\u0004\u0012\u00020\u00040hH\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0004\bj\u0010k\u001A)\u0010l\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00072\f\u0010i\u001A\b\u0012\u0004\u0012\u00020\u00040hH\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0004\bl\u0010m\u001A\u0019\u0010^\u001A\u00020\u001B*\u00020n2\u0006\u0010o\u001A\u00020O\u00A2\u0006\u0004\b^\u0010p\u001A\u001B\u0010q\u001A\u00020\u001B*\u00020\u00072\b\b\u0002\u0010 \u001A\u00020\u001B\u00A2\u0006\u0004\bq\u0010r\u001A\u0011\u0010t\u001A\u00020\u0000*\u00020s\u00A2\u0006\u0004\bt\u0010u\u001A\u0019\u0010w\u001A\u00020\u0000*\u00020\u00072\u0006\u0010v\u001A\u00020\u0000\u00A2\u0006\u0004\bw\u0010x\u001A\u001B\u0010y\u001A\u00020\u001B*\u0004\u0018\u00010\u00072\u0006\u0010v\u001A\u00020\u001B\u00A2\u0006\u0004\by\u0010r\u001A#\u0010{\u001A\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010z*\b\u0012\u0004\u0012\u00028\u00000B\u00A2\u0006\u0004\b{\u0010|\u001A/\u0010~\u001A\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010z2\u0012\u0010}\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000E\"\u00028\u0000H\u0007\u00A2\u0006\u0004\b~\u0010\u007F\u001A<\u0010\u0083\u0001\u001A\u000F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001\"\u0005\b\u0000\u0010\u0080\u0001\"\u0005\b\u0001\u0010\u0081\u0001*\u000F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001\u00A2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001\u001A\u0015\u0010\u0086\u0001\u001A\u00020\u0004*\u00030\u0085\u0001\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001\u001A\u0014\u0010\u0086\u0001\u001A\u00020\u0004*\u00020b\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0088\u0001\u001A\u0015\u0010\u0086\u0001\u001A\u00020\u0004*\u00030\u0089\u0001\u00A2\u0006\u0006\b\u0086\u0001\u0010\u008A\u0001\u001A\u001F\u0010\u008E\u0001\u001A\u00020\t*\u00030\u008B\u00012\b\u0010\u008D\u0001\u001A\u00030\u008C\u0001\u00A2\u0006\u0006\b\u008E\u0001\u0010\u008F\u0001\u001A\u0014\u0010\u0090\u0001\u001A\u00020\u0007*\u00020\u0000\u00A2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001\u001A\u0014\u0010\u0090\u0001\u001A\u00020\u0007*\u00020\u001B\u00A2\u0006\u0006\b\u0090\u0001\u0010\u0092\u0001\u001A\u0017\u0010\u0093\u0001\u001A\u00020\u0004*\u000203H\u0086\b\u00A2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001\u001A\u0017\u0010\u0095\u0001\u001A\u00020\u0004*\u000203H\u0086\b\u00A2\u0006\u0006\b\u0095\u0001\u0010\u0094\u0001\u001A\u0017\u0010\u0096\u0001\u001A\u00020\u0004*\u000203H\u0086\b\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0094\u0001\u001A:\u0010\u009B\u0001\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010z2\u0007\u0010\u0097\u0001\u001A\u0002032\u000E\u0010\u0099\u0001\u001A\t\u0012\u0004\u0012\u00028\u00000\u0098\u00012\u0007\u0010\u009A\u0001\u001A\u00020\u0007\u00A2\u0006\u0006\b\u009B\u0001\u0010\u009C\u0001\u001A-\u0010\u00A0\u0001\u001A\u00020\u0004\"\u0005\b\u0000\u0010\u009D\u0001*\t\u0012\u0004\u0012\u00028\u00000\u009E\u00012\u0007\u0010\u009F\u0001\u001A\u00028\u0000H\u0000\u00A2\u0006\u0006\b\u00A0\u0001\u0010\u00A1\u0001\u001A\u0017\u0010\u00A2\u0001\u001A\u00020\u0004*\u000203H\u0080\b\u00A2\u0006\u0006\b\u00A2\u0001\u0010\u0094\u0001\u001A\u0017\u0010\u00A3\u0001\u001A\u00020\u0004*\u000203H\u0080\b\u00A2\u0006\u0006\b\u00A3\u0001\u0010\u0094\u0001\u001A0\u0010\u00A8\u0001\u001A\u00030\u00A7\u0001*\b0\u00A4\u0001j\u0003`\u00A5\u00012\u0013\u0010\u00A6\u0001\u001A\u000E\u0012\n\u0012\b0\u00A4\u0001j\u0003`\u00A5\u00010B\u00A2\u0006\u0006\b\u00A8\u0001\u0010\u00A9\u0001\u001AC\u0010\u00AD\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010z*\t\u0012\u0004\u0012\u00028\u00000\u00AA\u00012\u0014\u0010\u00AC\u0001\u001A\u000F\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u00AB\u0001H\u0086\b\u00F8\u0001\u0000\u00A2\u0006\u0006\b\u00AD\u0001\u0010\u00AE\u0001\"\u0018\u0010\u00B0\u0001\u001A\u00030\u00AF\u00018\u0006X\u0087\u0004\u00A2\u0006\b\n\u0006\b\u00B0\u0001\u0010\u00B1\u0001\"\u0017\u0010\u00B2\u0001\u001A\u00020D8\u0006X\u0087\u0004\u00A2\u0006\b\n\u0006\b\u00B2\u0001\u0010\u00B3\u0001\"\u0018\u0010\u00B5\u0001\u001A\u00030\u00B4\u00018\u0006X\u0087\u0004\u00A2\u0006\b\n\u0006\b\u00B5\u0001\u0010\u00B6\u0001\"\u0018\u0010\u00B8\u0001\u001A\u00030\u00B7\u00018\u0006X\u0087\u0004\u00A2\u0006\b\n\u0006\b\u00B8\u0001\u0010\u00B9\u0001\"\u0018\u0010\u00BB\u0001\u001A\u00030\u00BA\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BB\u0001\u0010\u00BC\u0001\"\u0018\u0010\u00BE\u0001\u001A\u00030\u00BD\u00018\u0006X\u0087\u0004\u00A2\u0006\b\n\u0006\b\u00BE\u0001\u0010\u00BF\u0001\"\u0018\u0010\u00C1\u0001\u001A\u00030\u00C0\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C1\u0001\u0010\u00C2\u0001\"\u0017\u0010\u00C3\u0001\u001A\u00020\t8\u0000X\u0081\u0004\u00A2\u0006\b\n\u0006\b\u00C3\u0001\u0010\u00C4\u0001\"\u0017\u0010\u00C5\u0001\u001A\u00020\u00078\u0000X\u0081\u0004\u00A2\u0006\b\n\u0006\b\u00C5\u0001\u0010\u00C6\u0001\"\u0017\u0010\u00C7\u0001\u001A\u00020\u00078\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00C7\u0001\u0010\u00C6\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006\u00C8\u0001"}, d2 = {"", "arrayLength", "offset", "count", "Lie/H;", "checkOffsetAndCount", "(JJJ)V", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", "value", "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "isSensitiveHeader", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lokio/BufferedSource;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", "", "mask", "and", "(BI)I", "", "(SI)I", "(IJ)J", "Lokio/BufferedSink;", "medium", "writeMedium", "(Lokio/BufferedSink;I)V", "readMedium", "(Lokio/BufferedSource;)I", "Lokio/Source;", "timeUnit", "skipAll", "(Lokio/Source;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "discard", "Ljava/net/Socket;", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", "source", "isHealthy", "(Ljava/net/Socket;Lokio/BufferedSource;)Z", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "(Lwe/a;)V", "threadName", "(Ljava/lang/String;Lwe/a;)V", "Lokio/Buffer;", "b", "(Lokio/Buffer;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", "T", "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", "V", "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;)Z", "toHexString", "(J)Ljava/lang/String;", "(I)Ljava/lang/String;", "wait", "(Ljava/lang/Object;)V", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "E", "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "", "Lkotlin/Function1;", "predicate", "filterList", "(Ljava/lang/Iterable;Lwe/k;)Ljava/util/List;", "", "EMPTY_BYTE_ARRAY", "[B", "EMPTY_HEADERS", "Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "Lokio/Options;", "UNICODE_BOMS", "Lokio/Options;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "LTf/n;", "VERIFY_AS_IP_ADDRESS", "LTf/n;", "assertionsEnabled", "Z", "okHttpName", "Ljava/lang/String;", "userAgent", "okhttp"}, k = 2, mv = {1, 8, 0}, xi = 0x30)
public final class Util {
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    @NotNull
    public static final Headers EMPTY_HEADERS = null;
    @NotNull
    public static final RequestBody EMPTY_REQUEST = null;
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = null;
    @NotNull
    private static final Options UNICODE_BOMS = null;
    @NotNull
    public static final TimeZone UTC = null;
    @NotNull
    private static final n VERIFY_AS_IP_ADDRESS = null;
    public static final boolean assertionsEnabled = false;
    @NotNull
    public static final String okHttpName = null;
    @NotNull
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] arr_b = new byte[0];
        Util.EMPTY_BYTE_ARRAY = arr_b;
        Util.EMPTY_HEADERS = Headers.Companion.of(new String[0]);
        Util.EMPTY_RESPONSE = Companion.create$default(ResponseBody.Companion, arr_b, null, 1, null);
        Util.EMPTY_REQUEST = okhttp3.RequestBody.Companion.create$default(RequestBody.Companion, arr_b, null, 0, 0, 7, null);
        ByteString[] arr_byteString = {ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000")};
        Util.UNICODE_BOMS = Options.Companion.of(arr_byteString);
        TimeZone timeZone0 = TimeZone.getTimeZone("GMT");
        q.d(timeZone0);
        Util.UTC = timeZone0;
        Util.VERIFY_AS_IP_ADDRESS = new n("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        Util.assertionsEnabled = false;
        Util.okHttpName = "OkHttp";
    }

    public static EventListener a(EventListener eventListener0, Call call0) {
        return Util.asFactory$lambda$8(eventListener0, call0);
    }

    public static final void addIfAbsent(@NotNull List list0, Object object0) {
        q.g(list0, "<this>");
        if(!list0.contains(object0)) {
            list0.add(object0);
        }
    }

    public static final int and(byte b, int v) {
        return b & v;
    }

    public static final int and(short v, int v1) {
        return v & v1;
    }

    public static final long and(int v, long v1) {
        return ((long)v) & v1;
    }

    @NotNull
    public static final Factory asFactory(@NotNull EventListener eventListener0) {
        q.g(eventListener0, "<this>");
        return new j3.n(eventListener0, 10);
    }

    private static final EventListener asFactory$lambda$8(EventListener eventListener0, Call call0) {
        q.g(eventListener0, "$this_asFactory");
        q.g(call0, "it");
        return eventListener0;
    }

    // 去混淆评级： 低(20)
    public static final void assertThreadDoesntHoldLock(@NotNull Object object0) {
        q.g(object0, "<this>");
        if(Util.assertionsEnabled && Thread.holdsLock(object0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2402 MUST NOT hold lock on " + object0);
        }
    }

    // 去混淆评级： 低(20)
    public static final void assertThreadHoldsLock(@NotNull Object object0) {
        q.g(object0, "<this>");
        if(Util.assertionsEnabled && !Thread.holdsLock(object0)) {
            throw new AssertionError("Thread jeb-dexdec-sb-st-2433 MUST hold lock on " + object0);
        }
    }

    public static final boolean canParseAsIpAddress(@NotNull String s) {
        q.g(s, "<this>");
        return Util.VERIFY_AS_IP_ADDRESS.b(s);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl httpUrl0, @NotNull HttpUrl httpUrl1) {
        q.g(httpUrl0, "<this>");
        q.g(httpUrl1, "other");
        return q.b(httpUrl0.host(), httpUrl1.host()) && httpUrl0.port() == httpUrl1.port() && q.b(httpUrl0.scheme(), httpUrl1.scheme());
    }

    public static final int checkDuration(@NotNull String s, long v, @Nullable TimeUnit timeUnit0) {
        q.g(s, "name");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalStateException((s + " < 0").toString());
        }
        if(timeUnit0 == null) {
            throw new IllegalStateException("unit == null");
        }
        long v2 = timeUnit0.toMillis(v);
        if(v2 > 0x7FFFFFFFL) {
            throw new IllegalArgumentException((s + " too large.").toString());
        }
        if(v2 == 0L && v1 > 0) {
            throw new IllegalArgumentException((s + " too small.").toString());
        }
        return (int)v2;
    }

    public static final void checkOffsetAndCount(long v, long v1, long v2) {
        if((v1 | v2) < 0L || v1 > v || v - v1 < v2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeable0) {
        q.g(closeable0, "<this>");
        try {
            closeable0.close();
        }
        catch(RuntimeException runtimeException0) {
            throw runtimeException0;
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket serverSocket0) {
        q.g(serverSocket0, "<this>");
        try {
            serverSocket0.close();
        }
        catch(RuntimeException runtimeException0) {
            throw runtimeException0;
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void closeQuietly(@NotNull Socket socket0) {
        q.g(socket0, "<this>");
        try {
            socket0.close();
        }
        catch(AssertionError assertionError0) {
            throw assertionError0;
        }
        catch(RuntimeException runtimeException0) {
            if(!q.b(runtimeException0.getMessage(), "bio == null")) {
                throw runtimeException0;
            }
        }
        catch(Exception unused_ex) {
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] arr_s, @NotNull String s) {
        q.g(arr_s, "<this>");
        q.g(s, "value");
        Object[] arr_object = Arrays.copyOf(arr_s, arr_s.length + 1);
        q.f(arr_object, "copyOf(this, newSize)");
        ((String[])arr_object)[((String[])arr_object).length - 1] = s;
        return (String[])arr_object;
    }

    public static final int delimiterOffset(@NotNull String s, char c, int v, int v1) {
        q.g(s, "<this>");
        while(v < v1) {
            if(s.charAt(v) == c) {
                return v;
            }
            ++v;
        }
        return v1;
    }

    public static final int delimiterOffset(@NotNull String s, @NotNull String s1, int v, int v1) {
        q.g(s, "<this>");
        q.g(s1, "delimiters");
        while(v < v1) {
            if(o.w0(s1, s.charAt(v))) {
                return v;
            }
            ++v;
        }
        return v1;
    }

    public static int delimiterOffset$default(String s, char c, int v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0;
        }
        if((v2 & 4) != 0) {
            v1 = s.length();
        }
        return Util.delimiterOffset(s, c, v, v1);
    }

    public static int delimiterOffset$default(String s, String s1, int v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0;
        }
        if((v2 & 4) != 0) {
            v1 = s.length();
        }
        return Util.delimiterOffset(s, s1, v, v1);
    }

    public static final boolean discard(@NotNull Source source0, int v, @NotNull TimeUnit timeUnit0) {
        q.g(source0, "<this>");
        q.g(timeUnit0, "timeUnit");
        try {
            return Util.skipAll(source0, v, timeUnit0);
        }
        catch(IOException unused_ex) {
            return false;
        }
    }

    @NotNull
    public static final List filterList(@NotNull Iterable iterable0, @NotNull k k0) {
        q.g(iterable0, "<this>");
        q.g(k0, "predicate");
        List list0 = w.a;
        for(Object object0: iterable0) {
            if(((Boolean)k0.invoke(object0)).booleanValue()) {
                if(list0.isEmpty()) {
                    list0 = new ArrayList();
                }
                N.b(list0).add(object0);
            }
        }
        return list0;
    }

    @NotNull
    public static final String format(@NotNull String s, @NotNull Object[] arr_object) [...] // 潜在的解密器

    public static final boolean hasIntersection(@NotNull String[] arr_s, @Nullable String[] arr_s1, @NotNull Comparator comparator0) {
        q.g(arr_s, "<this>");
        q.g(comparator0, "comparator");
        if(arr_s.length != 0 && arr_s1 != null && arr_s1.length != 0) {
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                Y y0 = q.j(arr_s1);
                while(y0.hasNext()) {
                    if(comparator0.compare(s, ((String)y0.next())) == 0) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@NotNull Response response0) {
        q.g(response0, "<this>");
        String s = response0.headers().get("Content-Length");
        return s == null ? -1L : Util.toLongOrDefault(s, -1L);
    }

    public static final void ignoreIoExceptions(@NotNull a a0) {
        q.g(a0, "block");
        try {
            a0.invoke();
        }
        catch(IOException unused_ex) {
        }
    }

    @SafeVarargs
    @NotNull
    public static final List immutableListOf(@NotNull Object[] arr_object) {
        q.g(arr_object, "elements");
        Object[] arr_object1 = (Object[])arr_object.clone();
        List list0 = Collections.unmodifiableList(e.k.A(Arrays.copyOf(arr_object1, arr_object1.length)));
        q.f(list0, "unmodifiableList(listOf(*elements.clone()))");
        return list0;
    }

    public static final int indexOf(@NotNull String[] arr_s, @NotNull String s, @NotNull Comparator comparator0) {
        q.g(arr_s, "<this>");
        q.g(s, "value");
        q.g(comparator0, "comparator");
        for(int v = 0; v < arr_s.length; ++v) {
            if(comparator0.compare(arr_s[v], s) == 0) {
                return v;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String s) {
        q.g(s, "<this>");
        int v = s.length();
        int v1 = 0;
        while(v1 < v) {
            int v2 = s.charAt(v1);
            if(q.h(v2, 0x1F) > 0 && q.h(v2, 0x7F) < 0) {
                ++v1;
                continue;
            }
            return v1;
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String s, int v, int v1) {
        q.g(s, "<this>");
        while(v < v1) {
            switch(s.charAt(v)) {
                case 9: 
                case 10: 
                case 12: 
                case 13: 
                case 0x20: {
                    ++v;
                    continue;
                }
                default: {
                    return v;
                }
            }
        }
        return v1;
    }

    public static int indexOfFirstNonAsciiWhitespace$default(String s, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = s.length();
        }
        return Util.indexOfFirstNonAsciiWhitespace(s, v, v1);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String s, int v, int v1) {
        q.g(s, "<this>");
        int v2 = v1 - 1;
        if(v <= v2) {
        alab1:
            while(true) {
                switch(s.charAt(v2)) {
                    case 9: 
                    case 10: 
                    case 12: 
                    case 13: 
                    case 0x20: {
                        if(v2 != v) {
                            break;
                        }
                        break alab1;
                    }
                    default: {
                        return v2 + 1;
                    }
                }
                --v2;
            }
        }
        return v;
    }

    public static int indexOfLastNonAsciiWhitespace$default(String s, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = s.length();
        }
        return Util.indexOfLastNonAsciiWhitespace(s, v, v1);
    }

    public static final int indexOfNonWhitespace(@NotNull String s, int v) {
        q.g(s, "<this>");
        int v1 = s.length();
        while(v < v1) {
            if(s.charAt(v) != 9 && s.charAt(v) != 0x20) {
                return v;
            }
            ++v;
        }
        return s.length();
    }

    public static int indexOfNonWhitespace$default(String s, int v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        return Util.indexOfNonWhitespace(s, v);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] arr_s, @NotNull String[] arr_s1, @NotNull Comparator comparator0) {
        q.g(arr_s, "<this>");
        q.g(arr_s1, "other");
        q.g(comparator0, "comparator");
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            for(int v1 = 0; v1 < arr_s1.length; ++v1) {
                if(comparator0.compare(s, arr_s1[v1]) == 0) {
                    arrayList0.add(s);
                    break;
                }
            }
        }
        return (String[])arrayList0.toArray(new String[0]);
    }

    public static final boolean isCivilized(@NotNull FileSystem fileSystem0, @NotNull File file0) {
        q.g(fileSystem0, "<this>");
        q.g(file0, "file");
        Sink sink0 = fileSystem0.sink(file0);
        try {
            fileSystem0.delete(file0);
        }
        catch(IOException unused_ex) {
            d.l(sink0, null);
            fileSystem0.delete(file0);
            return false;
        }
        catch(Throwable throwable0) {
            d.l(sink0, throwable0);
            throw throwable0;
        }
        d.l(sink0, null);
        return true;
    }

    public static final boolean isHealthy(@NotNull Socket socket0, @NotNull BufferedSource bufferedSource0) {
        q.g(socket0, "<this>");
        q.g(bufferedSource0, "source");
        try {
            int v = socket0.getSoTimeout();
            try {
                socket0.setSoTimeout(1);
                boolean z = bufferedSource0.exhausted();
                return !z;
            }
            finally {
                socket0.setSoTimeout(v);
            }
        }
        catch(SocketTimeoutException unused_ex) {
            return true;
        }
        catch(IOException unused_ex) {
            return false;
        }
    }

    // 去混淆评级： 低(20)
    public static final boolean isSensitiveHeader(@NotNull String s) {
        q.g(s, "name");
        return s.equalsIgnoreCase("Authorization") || s.equalsIgnoreCase("Cookie") || s.equalsIgnoreCase("Proxy-Authorization") || s.equalsIgnoreCase("Set-Cookie");
    }

    public static final void notify(@NotNull Object object0) {
        q.g(object0, "<this>");
        object0.notify();
    }

    public static final void notifyAll(@NotNull Object object0) {
        q.g(object0, "<this>");
        object0.notifyAll();
    }

    public static final int parseHexDigit(char c) {
        if(0x30 <= c && c < 58) {
            return c - 0x30;
        }
        if(97 <= c && c < 103) {
            return c - 87;
        }
        return 65 > c || c >= 71 ? -1 : c - 55;
    }

    @NotNull
    public static final String peerName(@NotNull Socket socket0) {
        q.g(socket0, "<this>");
        SocketAddress socketAddress0 = socket0.getRemoteSocketAddress();
        if(socketAddress0 instanceof InetSocketAddress) {
            String s = ((InetSocketAddress)socketAddress0).getHostName();
            q.f(s, "address.hostName");
            return s;
        }
        return socketAddress0.toString();
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource bufferedSource0, @NotNull Charset charset0) {
        q.g(bufferedSource0, "<this>");
        q.g(charset0, "default");
        switch(bufferedSource0.select(Util.UNICODE_BOMS)) {
            case -1: {
                return charset0;
            }
            case 0: {
                Charset charset1 = StandardCharsets.UTF_8;
                q.f(charset1, "UTF_8");
                return charset1;
            }
            case 1: {
                Charset charset2 = StandardCharsets.UTF_16BE;
                q.f(charset2, "UTF_16BE");
                return charset2;
            }
            case 2: {
                Charset charset3 = StandardCharsets.UTF_16LE;
                q.f(charset3, "UTF_16LE");
                return charset3;
            }
            case 3: {
                Charset charset4 = Tf.a.d;
                if(charset4 == null) {
                    charset4 = Charset.forName("UTF-32BE");
                    q.f(charset4, "forName(...)");
                    Tf.a.d = charset4;
                }
                return charset4;
            }
            case 4: {
                Charset charset5 = Tf.a.c;
                if(charset5 == null) {
                    charset5 = Charset.forName("UTF-32LE");
                    q.f(charset5, "forName(...)");
                    Tf.a.c = charset5;
                }
                return charset5;
            }
            default: {
                throw new AssertionError();
            }
        }
    }

    @Nullable
    public static final Object readFieldOrNull(@NotNull Object object0, @NotNull Class class0, @NotNull String s) {
        Class class2;
        q.g(object0, "instance");
        q.g(class0, "fieldType");
        q.g(s, "fieldName");
        Class class1 = object0.getClass();
        while(true) {
            class2 = Object.class;
            if(class1.equals(class2)) {
                break;
            }
            try {
                Field field0 = class1.getDeclaredField(s);
                field0.setAccessible(true);
                Object object1 = field0.get(object0);
                return !class0.isInstance(object1) ? null : class0.cast(object1);
            }
            catch(NoSuchFieldException unused_ex) {
                class1 = class1.getSuperclass();
                q.f(class1, "c.superclass");
                continue;
            }
            return null;
        }
        if(!s.equals("delegate")) {
            Object object2 = Util.readFieldOrNull(object0, class2, "delegate");
            return object2 == null ? null : Util.readFieldOrNull(object2, class0, s);
        }
        return null;
    }

    public static final int readMedium(@NotNull BufferedSource bufferedSource0) {
        q.g(bufferedSource0, "<this>");
        int v = Util.and(bufferedSource0.readByte(), ((byte)0xFF));
        int v1 = Util.and(bufferedSource0.readByte(), ((byte)0xFF));
        return Util.and(bufferedSource0.readByte(), ((byte)0xFF)) | (v << 16 | v1 << 8);
    }

    public static final int skipAll(@NotNull Buffer buffer0, byte b) {
        q.g(buffer0, "<this>");
        int v = 0;
        while(!buffer0.exhausted() && buffer0.getByte(0L) == b) {
            ++v;
            buffer0.readByte();
        }
        return v;
    }

    public static final boolean skipAll(@NotNull Source source0, int v, @NotNull TimeUnit timeUnit0) {
        q.g(source0, "<this>");
        q.g(timeUnit0, "timeUnit");
        long v1 = System.nanoTime();
        long v2 = source0.timeout().hasDeadline() ? source0.timeout().deadlineNanoTime() - v1 : 0x7FFFFFFFFFFFFFFFL;
        source0.timeout().deadlineNanoTime(Math.min(v2, timeUnit0.toNanos(((long)v))) + v1);
        try {
            Buffer buffer0 = new Buffer();
            while(source0.read(buffer0, 0x2000L) != -1L) {
                buffer0.clear();
            }
        }
        catch(InterruptedIOException unused_ex) {
            if(v2 == 0x7FFFFFFFFFFFFFFFL) {
                source0.timeout().clearDeadline();
                return false;
            }
            source0.timeout().deadlineNanoTime(v1 + v2);
            return false;
        }
        catch(Throwable throwable0) {
            if(v2 == 0x7FFFFFFFFFFFFFFFL) {
                source0.timeout().clearDeadline();
            }
            else {
                source0.timeout().deadlineNanoTime(v1 + v2);
            }
            throw throwable0;
        }
        if(Long.compare(v2, 0x7FFFFFFFFFFFFFFFL) == 0) {
            source0.timeout().clearDeadline();
            return true;
        }
        source0.timeout().deadlineNanoTime(v1 + v2);
        return true;
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull String s, boolean z) {
        q.g(s, "name");
        return new sg.a(s, z);
    }

    private static final Thread threadFactory$lambda$1(String s, boolean z, Runnable runnable0) {
        q.g(s, "$name");
        Thread thread0 = new Thread(runnable0, s);
        thread0.setDaemon(z);
        return thread0;
    }

    public static final void threadName(@NotNull String s, @NotNull a a0) {
        q.g(s, "name");
        q.g(a0, "block");
        Thread thread0 = Thread.currentThread();
        thread0.setName(s);
        try {
            a0.invoke();
        }
        finally {
            thread0.setName("jeb-dexdec-sb-st-2432");
        }
    }

    @NotNull
    public static final List toHeaderList(@NotNull Headers headers0) {
        q.g(headers0, "<this>");
        g g0 = P4.a.K(0, headers0.size());
        List list0 = new ArrayList(je.q.Q(10, g0));
        Iterator iterator0 = g0.iterator();
        while(iterator0.hasNext()) {
            int v = ((f)iterator0).nextInt();
            list0.add(new Header(headers0.name(v), headers0.value(v)));
        }
        return list0;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List list0) {
        q.g(list0, "<this>");
        Builder headers$Builder0 = new Builder();
        for(Object object0: list0) {
            ByteString byteString0 = ((Header)object0).component1();
            ByteString byteString1 = ((Header)object0).component2();
            headers$Builder0.addLenient$okhttp(byteString0.utf8(), byteString1.utf8());
        }
        return headers$Builder0.build();
    }

    @NotNull
    public static final String toHexString(int v) {
        String s = Integer.toHexString(v);
        q.f(s, "toHexString(this)");
        return s;
    }

    @NotNull
    public static final String toHexString(long v) {
        String s = Long.toHexString(v);
        q.f(s, "toHexString(this)");
        return s;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl httpUrl0, boolean z) {
        q.g(httpUrl0, "<this>");
        String s = o.v0(httpUrl0.host(), ":", false) ? "[" + httpUrl0.host() + ']' : httpUrl0.host();
        return z || httpUrl0.port() != HttpUrl.Companion.defaultPort(httpUrl0.scheme()) ? s + ':' + httpUrl0.port() : s;
    }

    public static String toHostHeader$default(HttpUrl httpUrl0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        return Util.toHostHeader(httpUrl0, z);
    }

    @NotNull
    public static final List toImmutableList(@NotNull List list0) {
        q.g(list0, "<this>");
        List list1 = Collections.unmodifiableList(p.Q0(list0));
        q.f(list1, "unmodifiableList(toMutableList())");
        return list1;
    }

    @NotNull
    public static final Map toImmutableMap(@NotNull Map map0) {
        q.g(map0, "<this>");
        if(map0.isEmpty()) {
            return x.a;
        }
        Map map1 = Collections.unmodifiableMap(new LinkedHashMap(map0));
        q.f(map1, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return map1;
    }

    public static final long toLongOrDefault(@NotNull String s, long v) {
        q.g(s, "<this>");
        try {
            return Long.parseLong(s);
        }
        catch(NumberFormatException unused_ex) {
            return v;
        }
    }

    public static final int toNonNegativeInt(@Nullable String s, int v) {
        if(s != null) {
            try {
                long v1 = Long.parseLong(s);
                if(v1 > 0x7FFFFFFFL) {
                    return 0x7FFFFFFF;
                }
                return v1 >= 0L ? ((int)v1) : 0;
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return v;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String s, int v, int v1) {
        q.g(s, "<this>");
        int v2 = Util.indexOfFirstNonAsciiWhitespace(s, v, v1);
        String s1 = s.substring(v2, Util.indexOfLastNonAsciiWhitespace(s, v2, v1));
        q.f(s1, "this as java.lang.String…ing(startIndex, endIndex)");
        return s1;
    }

    public static String trimSubstring$default(String s, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = s.length();
        }
        return Util.trimSubstring(s, v, v1);
    }

    public static final void wait(@NotNull Object object0) {
        q.g(object0, "<this>");
        object0.wait();
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception exception0, @NotNull List list0) {
        q.g(exception0, "<this>");
        q.g(list0, "suppressed");
        for(Object object0: list0) {
            e2.a.q(exception0, ((Exception)object0));
        }
        return exception0;
    }

    public static final void writeMedium(@NotNull BufferedSink bufferedSink0, int v) {
        q.g(bufferedSink0, "<this>");
        bufferedSink0.writeByte(v >>> 16 & 0xFF);
        bufferedSink0.writeByte(v >>> 8 & 0xFF);
        bufferedSink0.writeByte(v & 0xFF);
    }
}

