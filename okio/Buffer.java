package okio;

import Tf.a;
import U4.x;
import ie.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import je.n;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.internal.-Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000\u00BC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001A\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u00D2\u0001B\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\f\u0010\bJ\u000F\u0010\r\u001A\u00020\u0000H\u0016\u00A2\u0006\u0004\b\r\u0010\bJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0001H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ+\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\t2\b\b\u0002\u0010\u001E\u001A\u00020\u00112\b\b\u0002\u0010\u0012\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u001F\u0010 J\'\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u001E\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u001F\u0010!J\u001F\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u001E\u001A\u00020\u0011\u00A2\u0006\u0004\b\u001F\u0010\"J!\u0010#\u001A\u00020\u00002\u0006\u0010\u001D\u001A\u00020\t2\b\b\u0002\u0010\u0012\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b#\u0010$J\u0015\u0010&\u001A\u00020\u00002\u0006\u0010%\u001A\u00020\u001A\u00A2\u0006\u0004\b&\u0010\'J\u001D\u0010&\u001A\u00020\u00002\u0006\u0010%\u001A\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b&\u0010(J\r\u0010)\u001A\u00020\u0011\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010,\u001A\u00020+H\u0016\u00A2\u0006\u0004\b,\u0010-J\u0018\u00101\u001A\u00020+2\u0006\u0010.\u001A\u00020\u0011H\u0087\u0002\u00A2\u0006\u0004\b/\u00100J\u000F\u00103\u001A\u000202H\u0016\u00A2\u0006\u0004\b3\u00104J\u000F\u00106\u001A\u000205H\u0016\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b8\u0010*J\u000F\u00109\u001A\u000202H\u0016\u00A2\u0006\u0004\b9\u00104J\u000F\u0010:\u001A\u000205H\u0016\u00A2\u0006\u0004\b:\u00107J\u000F\u0010;\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b;\u0010*J\u000F\u0010<\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b<\u0010*J\u000F\u0010=\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b=\u0010*J\u000F\u0010?\u001A\u00020>H\u0016\u00A2\u0006\u0004\b?\u0010@J\u0017\u0010?\u001A\u00020>2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b?\u0010AJ\u0017\u0010D\u001A\u0002052\u0006\u0010C\u001A\u00020BH\u0016\u00A2\u0006\u0004\bD\u0010EJ)\u0010D\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010G*\u00020F2\f\u0010C\u001A\b\u0012\u0004\u0012\u00028\u00000HH\u0016\u00A2\u0006\u0004\bD\u0010IJ\u001F\u0010K\u001A\u00020\u00132\u0006\u0010J\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001A\u00020\u00112\u0006\u0010J\u001A\u00020MH\u0016\u00A2\u0006\u0004\bN\u0010OJ\u000F\u0010Q\u001A\u00020PH\u0016\u00A2\u0006\u0004\bQ\u0010RJ\u0017\u0010Q\u001A\u00020P2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bQ\u0010SJ\u0017\u0010V\u001A\u00020P2\u0006\u0010U\u001A\u00020TH\u0016\u00A2\u0006\u0004\bV\u0010WJ\u001F\u0010V\u001A\u00020P2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010U\u001A\u00020TH\u0016\u00A2\u0006\u0004\bV\u0010XJ\u0011\u0010Y\u001A\u0004\u0018\u00010PH\u0016\u00A2\u0006\u0004\bY\u0010RJ\u000F\u0010Z\u001A\u00020PH\u0016\u00A2\u0006\u0004\bZ\u0010RJ\u0017\u0010Z\u001A\u00020P2\u0006\u0010[\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bZ\u0010SJ\u000F\u0010\\\u001A\u000205H\u0016\u00A2\u0006\u0004\b\\\u00107J\u000F\u0010^\u001A\u00020]H\u0016\u00A2\u0006\u0004\b^\u0010_J\u0017\u0010^\u001A\u00020]2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b^\u0010`J\u0017\u0010a\u001A\u0002052\u0006\u0010J\u001A\u00020]H\u0016\u00A2\u0006\u0004\ba\u0010bJ\u0017\u0010K\u001A\u00020\u00132\u0006\u0010J\u001A\u00020]H\u0016\u00A2\u0006\u0004\bK\u0010cJ\'\u0010a\u001A\u0002052\u0006\u0010J\u001A\u00020]2\u0006\u0010\u001E\u001A\u0002052\u0006\u0010\u0012\u001A\u000205H\u0016\u00A2\u0006\u0004\ba\u0010dJ\u0017\u0010a\u001A\u0002052\u0006\u0010J\u001A\u00020eH\u0016\u00A2\u0006\u0004\ba\u0010fJ\r\u0010g\u001A\u00020\u0013\u00A2\u0006\u0004\bg\u0010\u0006J\u0017\u0010h\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bh\u0010\u0015J\u0017\u0010j\u001A\u00020\u00002\u0006\u0010i\u001A\u00020>H\u0016\u00A2\u0006\u0004\bj\u0010kJ\'\u0010j\u001A\u00020\u00002\u0006\u0010i\u001A\u00020>2\u0006\u0010\u001E\u001A\u0002052\u0006\u0010\u0012\u001A\u000205H\u0016\u00A2\u0006\u0004\bj\u0010lJ\u0017\u0010n\u001A\u00020\u00002\u0006\u0010m\u001A\u00020PH\u0016\u00A2\u0006\u0004\bn\u0010oJ\'\u0010n\u001A\u00020\u00002\u0006\u0010m\u001A\u00020P2\u0006\u0010p\u001A\u0002052\u0006\u0010q\u001A\u000205H\u0016\u00A2\u0006\u0004\bn\u0010rJ\u0017\u0010t\u001A\u00020\u00002\u0006\u0010s\u001A\u000205H\u0016\u00A2\u0006\u0004\bt\u0010uJ\u001F\u0010v\u001A\u00020\u00002\u0006\u0010m\u001A\u00020P2\u0006\u0010U\u001A\u00020TH\u0016\u00A2\u0006\u0004\bv\u0010wJ/\u0010v\u001A\u00020\u00002\u0006\u0010m\u001A\u00020P2\u0006\u0010p\u001A\u0002052\u0006\u0010q\u001A\u0002052\u0006\u0010U\u001A\u00020TH\u0016\u00A2\u0006\u0004\bv\u0010xJ\u0017\u0010j\u001A\u00020\u00002\u0006\u0010y\u001A\u00020]H\u0016\u00A2\u0006\u0004\bj\u0010zJ\'\u0010j\u001A\u00020\u00002\u0006\u0010y\u001A\u00020]2\u0006\u0010\u001E\u001A\u0002052\u0006\u0010\u0012\u001A\u000205H\u0016\u00A2\u0006\u0004\bj\u0010{J\u0017\u0010j\u001A\u0002052\u0006\u0010y\u001A\u00020eH\u0016\u00A2\u0006\u0004\bj\u0010fJ\u0017\u0010}\u001A\u00020\u00112\u0006\u0010y\u001A\u00020|H\u0016\u00A2\u0006\u0004\b}\u0010~J\u001F\u0010j\u001A\u00020\u00002\u0006\u0010y\u001A\u00020|2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bj\u0010\u007FJ\u001A\u0010\u0081\u0001\u001A\u00020\u00002\u0007\u0010\u0080\u0001\u001A\u000205H\u0016\u00A2\u0006\u0005\b\u0081\u0001\u0010uJ\u001A\u0010\u0083\u0001\u001A\u00020\u00002\u0007\u0010\u0082\u0001\u001A\u000205H\u0016\u00A2\u0006\u0005\b\u0083\u0001\u0010uJ\u001A\u0010\u0084\u0001\u001A\u00020\u00002\u0007\u0010\u0082\u0001\u001A\u000205H\u0016\u00A2\u0006\u0005\b\u0084\u0001\u0010uJ\u001A\u0010\u0086\u0001\u001A\u00020\u00002\u0007\u0010\u0085\u0001\u001A\u000205H\u0016\u00A2\u0006\u0005\b\u0086\u0001\u0010uJ\u001A\u0010\u0087\u0001\u001A\u00020\u00002\u0007\u0010\u0085\u0001\u001A\u000205H\u0016\u00A2\u0006\u0005\b\u0087\u0001\u0010uJ\u001B\u0010\u0089\u0001\u001A\u00020\u00002\u0007\u0010\u0088\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u0089\u0001\u0010\u008A\u0001J\u001B\u0010\u008B\u0001\u001A\u00020\u00002\u0007\u0010\u0088\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u008B\u0001\u0010\u008A\u0001J\u001B\u0010\u008C\u0001\u001A\u00020\u00002\u0007\u0010\u0088\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u008C\u0001\u0010\u008A\u0001J\u001B\u0010\u008D\u0001\u001A\u00020\u00002\u0007\u0010\u0088\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008A\u0001J\u001C\u0010\u0092\u0001\u001A\u00030\u008F\u00012\u0007\u0010\u008E\u0001\u001A\u000205H\u0000\u00A2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001F\u0010j\u001A\u00020\u00132\u0006\u0010y\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bj\u0010LJ \u0010a\u001A\u00020\u00112\u0006\u0010J\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0005\ba\u0010\u0093\u0001J\u001B\u0010\u0094\u0001\u001A\u00020\u00112\u0007\u0010\u0080\u0001\u001A\u00020+H\u0016\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J$\u0010\u0094\u0001\u001A\u00020\u00112\u0007\u0010\u0080\u0001\u001A\u00020+2\u0007\u0010\u0096\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0097\u0001J-\u0010\u0094\u0001\u001A\u00020\u00112\u0007\u0010\u0080\u0001\u001A\u00020+2\u0007\u0010\u0096\u0001\u001A\u00020\u00112\u0007\u0010\u0098\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0099\u0001J\u001B\u0010\u0094\u0001\u001A\u00020\u00112\u0007\u0010\u009A\u0001\u001A\u00020>H\u0016\u00A2\u0006\u0006\b\u0094\u0001\u0010\u009B\u0001J$\u0010\u0094\u0001\u001A\u00020\u00112\u0007\u0010\u009A\u0001\u001A\u00020>2\u0007\u0010\u0096\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u0094\u0001\u0010\u009C\u0001J-\u0010\u0094\u0001\u001A\u00020\u00112\u0007\u0010\u009A\u0001\u001A\u00020>2\u0007\u0010\u0096\u0001\u001A\u00020\u00112\u0007\u0010\u0098\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u0094\u0001\u0010\u009D\u0001J\u001B\u0010\u009F\u0001\u001A\u00020\u00112\u0007\u0010\u009E\u0001\u001A\u00020>H\u0016\u00A2\u0006\u0006\b\u009F\u0001\u0010\u009B\u0001J$\u0010\u009F\u0001\u001A\u00020\u00112\u0007\u0010\u009E\u0001\u001A\u00020>2\u0007\u0010\u0096\u0001\u001A\u00020\u0011H\u0016\u00A2\u0006\u0006\b\u009F\u0001\u0010\u009C\u0001J#\u0010\u00A0\u0001\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u00112\u0007\u0010\u009A\u0001\u001A\u00020>H\u0016\u00A2\u0006\u0006\b\u00A0\u0001\u0010\u00A1\u0001J4\u0010\u00A0\u0001\u001A\u00020\u000E2\u0006\u0010\u001E\u001A\u00020\u00112\u0007\u0010\u009A\u0001\u001A\u00020>2\u0007\u0010\u00A2\u0001\u001A\u0002052\u0006\u0010\u0012\u001A\u000205H\u0016\u00A2\u0006\u0006\b\u00A0\u0001\u0010\u00A3\u0001J\u0011\u0010\u00A4\u0001\u001A\u00020\u0013H\u0016\u00A2\u0006\u0005\b\u00A4\u0001\u0010\u0006J\u0011\u0010\u00A5\u0001\u001A\u00020\u000EH\u0016\u00A2\u0006\u0005\b\u00A5\u0001\u0010\u0010J\u0011\u0010\u00A6\u0001\u001A\u00020\u0013H\u0016\u00A2\u0006\u0005\b\u00A6\u0001\u0010\u0006J\u0013\u0010\u00A8\u0001\u001A\u00030\u00A7\u0001H\u0016\u00A2\u0006\u0006\b\u00A8\u0001\u0010\u00A9\u0001J\u000F\u0010\u00AA\u0001\u001A\u00020>\u00A2\u0006\u0005\b\u00AA\u0001\u0010@J\u000F\u0010\u00AB\u0001\u001A\u00020>\u00A2\u0006\u0005\b\u00AB\u0001\u0010@J\u000F\u0010\u00AC\u0001\u001A\u00020>\u00A2\u0006\u0005\b\u00AC\u0001\u0010@J\u000F\u0010\u00AD\u0001\u001A\u00020>\u00A2\u0006\u0005\b\u00AD\u0001\u0010@J\u0019\u0010\u00AF\u0001\u001A\u00020>2\u0007\u0010\u00AE\u0001\u001A\u00020>\u00A2\u0006\u0006\b\u00AF\u0001\u0010\u00B0\u0001J\u0019\u0010\u00B1\u0001\u001A\u00020>2\u0007\u0010\u00AE\u0001\u001A\u00020>\u00A2\u0006\u0006\b\u00B1\u0001\u0010\u00B0\u0001J\u0019\u0010\u00B2\u0001\u001A\u00020>2\u0007\u0010\u00AE\u0001\u001A\u00020>\u00A2\u0006\u0006\b\u00B2\u0001\u0010\u00B0\u0001J\u001E\u0010\u00B4\u0001\u001A\u00020\u000E2\t\u0010\u00B3\u0001\u001A\u0004\u0018\u00010FH\u0096\u0002\u00A2\u0006\u0006\b\u00B4\u0001\u0010\u00B5\u0001J\u0011\u0010\u00B6\u0001\u001A\u000205H\u0016\u00A2\u0006\u0005\b\u00B6\u0001\u00107J\u0011\u0010\u00B7\u0001\u001A\u00020PH\u0016\u00A2\u0006\u0005\b\u00B7\u0001\u0010RJ\u000F\u0010\u00B8\u0001\u001A\u00020\u0000\u00A2\u0006\u0005\b\u00B8\u0001\u0010\bJ\u0011\u0010\u00B9\u0001\u001A\u00020\u0000H\u0016\u00A2\u0006\u0005\b\u00B9\u0001\u0010\bJ\u000F\u0010\u00BA\u0001\u001A\u00020>\u00A2\u0006\u0005\b\u00BA\u0001\u0010@J\u0018\u0010\u00BA\u0001\u001A\u00020>2\u0006\u0010\u0012\u001A\u000205\u00A2\u0006\u0006\b\u00BA\u0001\u0010\u00BB\u0001J\u001F\u0010\u00BE\u0001\u001A\u00030\u00BC\u00012\n\b\u0002\u0010\u00BD\u0001\u001A\u00030\u00BC\u0001H\u0007\u00A2\u0006\u0006\b\u00BE\u0001\u0010\u00BF\u0001J\u001F\u0010\u00C0\u0001\u001A\u00030\u00BC\u00012\n\b\u0002\u0010\u00BD\u0001\u001A\u00030\u00BC\u0001H\u0007\u00A2\u0006\u0006\b\u00C0\u0001\u0010\u00BF\u0001J\u0019\u0010/\u001A\u00020+2\u0007\u0010\u00C1\u0001\u001A\u00020\u0011H\u0007\u00A2\u0006\u0005\b\u00C2\u0001\u00100J\u0011\u0010\u00C4\u0001\u001A\u00020\u0011H\u0007\u00A2\u0006\u0005\b\u00C3\u0001\u0010*J)\u0010&\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u001A2\u0006\u0010\u0012\u001A\u00020\u00112\u0007\u0010\u00C5\u0001\u001A\u00020\u000EH\u0002\u00A2\u0006\u0005\b&\u0010\u00C6\u0001J\u001B\u0010\u00C8\u0001\u001A\u00020>2\u0007\u0010\u00C7\u0001\u001A\u00020PH\u0002\u00A2\u0006\u0006\b\u00C8\u0001\u0010\u00C9\u0001J$\u0010\u00CA\u0001\u001A\u00020>2\u0007\u0010\u00C7\u0001\u001A\u00020P2\u0007\u0010\u00AE\u0001\u001A\u00020>H\u0002\u00A2\u0006\u0006\b\u00CA\u0001\u0010\u00CB\u0001R\u001C\u0010\u00CC\u0001\u001A\u0005\u0018\u00010\u008F\u00018\u0000@\u0000X\u0081\u000E\u00A2\u0006\b\n\u0006\b\u00CC\u0001\u0010\u00CD\u0001R0\u0010\u00C4\u0001\u001A\u00020\u00112\u0007\u0010\u00CE\u0001\u001A\u00020\u00118G@@X\u0086\u000E\u00A2\u0006\u0016\n\u0006\b\u00C4\u0001\u0010\u00CF\u0001\u001A\u0005\b\u00C4\u0001\u0010*\"\u0005\b\u00D0\u0001\u0010\u0015R\u0015\u0010\u0007\u001A\u00020\u00008VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00D1\u0001\u0010\b\u00A8\u0006\u00D3\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "buffer", "()Lokio/Buffer;", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "emitCompleteSegments", "emit", "", "exhausted", "()Z", "", "byteCount", "Lie/H;", "require", "(J)V", "request", "(J)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "out", "offset", "copyTo", "(Ljava/io/OutputStream;JJ)Lokio/Buffer;", "(Lokio/Buffer;JJ)Lokio/Buffer;", "(Lokio/Buffer;J)Lokio/Buffer;", "writeTo", "(Ljava/io/OutputStream;J)Lokio/Buffer;", "input", "readFrom", "(Ljava/io/InputStream;)Lokio/Buffer;", "(Ljava/io/InputStream;J)Lokio/Buffer;", "completeSegmentByteCount", "()J", "", "readByte", "()B", "pos", "getByte", "(J)B", "get", "", "readShort", "()S", "", "readInt", "()I", "readLong", "readShortLe", "readIntLe", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "", "T", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "sink", "readFully", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "", "readByteArray", "()[B", "(J)[B", "read", "([B)I", "([B)V", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "clear", "skip", "byteString", "write", "(Lokio/ByteString;)Lokio/Buffer;", "(Lokio/ByteString;II)Lokio/Buffer;", "string", "writeUtf8", "(Ljava/lang/String;)Lokio/Buffer;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/Buffer;", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/Buffer;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/Buffer;", "source", "([B)Lokio/Buffer;", "([BII)Lokio/Buffer;", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/Buffer;", "b", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", "v", "writeLong", "(J)Lokio/Buffer;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "minimumCapacity", "Lokio/Segment;", "writableSegment$okio", "(I)Lokio/Segment;", "writableSegment", "(Lokio/Buffer;J)J", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "(Lokio/ByteString;JJ)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "flush", "isOpen", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "md5", "sha1", "sha256", "sha512", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "copy", "clone", "snapshot", "(I)Lokio/ByteString;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readUnsafe", "(Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "readAndWriteUnsafe", "index", "-deprecated_getByte", "-deprecated_size", "size", "forever", "(Ljava/io/InputStream;JZ)V", "algorithm", "digest", "(Ljava/lang/String;)Lokio/ByteString;", "hmac", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "head", "Lokio/Segment;", "value", "J", "setSize$okio", "getBuffer", "UnsafeCursor", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Buffer implements Cloneable, ByteChannel, BufferedSink, BufferedSource {
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0004¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0003R\u0018\u0010\u0014\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001A\u00020\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u0016\u0010\b\u001A\u00020\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\b\u0010 R\u0018\u0010\"\u001A\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006\'"}, d2 = {"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "<init>", "()V", "", "next", "()I", "", "offset", "seek", "(J)I", "newSize", "resizeBuffer", "(J)J", "minByteCount", "expandBuffer", "(I)J", "Lie/H;", "close", "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "", "readWrite", "Z", "Lokio/Segment;", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "J", "", "data", "[B", "start", "I", "end", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class UnsafeCursor implements Closeable {
        @Nullable
        public Buffer buffer;
        @Nullable
        public byte[] data;
        public int end;
        public long offset;
        public boolean readWrite;
        @Nullable
        private Segment segment;
        public int start;

        public UnsafeCursor() {
            this.offset = -1L;
            this.start = -1;
            this.end = -1;
        }

        @Override
        public void close() {
            if(this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public final long expandBuffer(int v) {
            if(v <= 0) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + v).toString());
            }
            if(v > 0x2000) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + v).toString());
            }
            Buffer buffer0 = this.buffer;
            if(buffer0 == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if(!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long v1 = buffer0.size();
            Segment segment0 = buffer0.writableSegment$okio(v);
            int v2 = 0x2000 - segment0.limit;
            segment0.limit = 0x2000;
            buffer0.setSize$okio(v1 + ((long)v2));
            this.setSegment$okio(segment0);
            this.offset = v1;
            this.data = segment0.data;
            this.start = 0x2000 - v2;
            this.end = 0x2000;
            return (long)v2;
        }

        @Nullable
        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            long v = this.offset;
            Buffer buffer0 = this.buffer;
            q.d(buffer0);
            if(v == buffer0.size()) {
                throw new IllegalStateException("no more bytes");
            }
            return this.offset == -1L ? this.seek(0L) : this.seek(this.offset + ((long)(this.end - this.start)));
        }

        public final long resizeBuffer(long v) {
            Buffer buffer0 = this.buffer;
            if(buffer0 == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if(!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long v1 = buffer0.size();
            if(Long.compare(v, v1) <= 0) {
                if(v < 0L) {
                    throw new IllegalArgumentException(e.a(v, "newSize < 0: ").toString());
                }
                long v2 = v1 - v;
                while(v2 > 0L) {
                    Segment segment0 = buffer0.head;
                    q.d(segment0);
                    Segment segment1 = segment0.prev;
                    q.d(segment1);
                    int v3 = segment1.limit;
                    long v4 = (long)(v3 - segment1.pos);
                    if(v4 <= v2) {
                        buffer0.head = segment1.pop();
                        SegmentPool.recycle(segment1);
                        v2 -= v4;
                    }
                    else {
                        segment1.limit = v3 - ((int)v2);
                        if(true) {
                            break;
                        }
                    }
                }
                this.setSegment$okio(null);
                this.offset = v;
                this.data = null;
                this.start = -1;
                this.end = -1;
            }
            else {
                long v5 = v - v1;
                boolean z = true;
                while(v5 > 0L) {
                    Segment segment2 = buffer0.writableSegment$okio(1);
                    int v6 = (int)Math.min(v5, 0x2000 - segment2.limit);
                    segment2.limit += v6;
                    v5 -= (long)v6;
                    if(z) {
                        this.setSegment$okio(segment2);
                        this.offset = v1;
                        this.data = segment2.data;
                        this.start = segment2.limit - v6;
                        this.end = segment2.limit;
                        z = false;
                    }
                }
            }
            buffer0.setSize$okio(v);
            return v1;
        }

        public final int seek(long v) {
            Segment segment2;
            Buffer buffer0 = this.buffer;
            if(buffer0 == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            int v1 = Long.compare(v, -1L);
            if(v1 >= 0 && v <= buffer0.size()) {
                if(v1 != 0 && v != buffer0.size()) {
                    long v2 = buffer0.size();
                    Segment segment0 = buffer0.head;
                    long v3 = 0L;
                    if(this.getSegment$okio() == null) {
                        segment2 = segment0;
                    }
                    else {
                        long v4 = this.offset;
                        int v5 = this.start;
                        Segment segment1 = this.getSegment$okio();
                        q.d(segment1);
                        long v6 = v4 - ((long)(v5 - segment1.pos));
                        if(v6 > v) {
                            segment2 = segment0;
                            segment0 = this.getSegment$okio();
                            v2 = v6;
                        }
                        else {
                            segment2 = this.getSegment$okio();
                            v3 = v6;
                        }
                    }
                    if(v2 - v > v - v3) {
                        while(true) {
                            q.d(segment2);
                            int v7 = segment2.limit;
                            int v8 = segment2.pos;
                            if(v < ((long)(v7 - v8)) + v3) {
                                break;
                            }
                            v3 += (long)(v7 - v8);
                            segment2 = segment2.next;
                        }
                    }
                    else {
                        while(v2 > v) {
                            q.d(segment0);
                            segment0 = segment0.prev;
                            q.d(segment0);
                            v2 -= (long)(segment0.limit - segment0.pos);
                        }
                        v3 = v2;
                        segment2 = segment0;
                    }
                    if(this.readWrite) {
                        q.d(segment2);
                        if(segment2.shared) {
                            Segment segment3 = segment2.unsharedCopy();
                            if(buffer0.head == segment2) {
                                buffer0.head = segment3;
                            }
                            segment2 = segment2.push(segment3);
                            Segment segment4 = segment2.prev;
                            q.d(segment4);
                            segment4.pop();
                        }
                    }
                    this.setSegment$okio(segment2);
                    this.offset = v;
                    q.d(segment2);
                    this.data = segment2.data;
                    int v9 = segment2.pos + ((int)(v - v3));
                    this.start = v9;
                    this.end = segment2.limit;
                    return segment2.limit - v9;
                }
                this.setSegment$okio(null);
                this.offset = v;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            }
            StringBuilder stringBuilder0 = Y.o(v, "offset=", " > size=");
            stringBuilder0.append(buffer0.size());
            throw new ArrayIndexOutOfBoundsException(stringBuilder0.toString());
        }

        public final void setSegment$okio(@Nullable Segment segment0) {
            this.segment = segment0;
        }
    }

    @Nullable
    public Segment head;
    private long size;

    @d
    public final byte -deprecated_getByte(long v) {
        return this.getByte(v);
    }

    @d
    public final long -deprecated_size() {
        return this.size;
    }

    @Override  // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        this.skip(this.size());
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    @NotNull
    public Buffer clone() {
        return this.copy();
    }

    @Override  // okio.Source, okio.Sink
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long v = this.size();
        if(v == 0L) {
            return 0L;
        }
        Segment segment0 = this.head;
        q.d(segment0);
        Segment segment1 = segment0.prev;
        q.d(segment1);
        return segment1.limit >= 0x2000 || !segment1.owner ? v : v - ((long)(segment1.limit - segment1.pos));
    }

    @NotNull
    public final Buffer copy() {
        Buffer buffer0 = new Buffer();
        if(this.size() == 0L) {
            return buffer0;
        }
        Segment segment0 = this.head;
        q.d(segment0);
        Segment segment1 = segment0.sharedCopy();
        buffer0.head = segment1;
        segment1.prev = segment1;
        segment1.next = segment1;
        for(Segment segment2 = segment0.next; segment2 != segment0; segment2 = segment2.next) {
            Segment segment3 = segment1.prev;
            q.d(segment3);
            q.d(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer0.setSize$okio(this.size());
        return buffer0;
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream0) {
        q.g(outputStream0, "out");
        return Buffer.copyTo$default(this, outputStream0, 0L, 0L, 6, null);
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream0, long v) {
        q.g(outputStream0, "out");
        return Buffer.copyTo$default(this, outputStream0, v, 0L, 4, null);
    }

    @NotNull
    public final Buffer copyTo(@NotNull OutputStream outputStream0, long v, long v1) {
        q.g(outputStream0, "out");
        long v2 = v;
        -SegmentedByteString.checkOffsetAndCount(this.size, v2, v1);
        if(v1 != 0L) {
            Segment segment0;
            for(segment0 = this.head; true; segment0 = segment0.next) {
                q.d(segment0);
                int v3 = segment0.limit;
                int v4 = segment0.pos;
                if(v2 < ((long)(v3 - v4))) {
                    break;
                }
                v2 -= (long)(v3 - v4);
            }
            Segment segment1 = segment0;
            long v5 = v1;
            while(v5 > 0L) {
                q.d(segment1);
                int v6 = (int)(((long)segment1.pos) + v2);
                int v7 = (int)Math.min(segment1.limit - v6, v5);
                outputStream0.write(segment1.data, v6, v7);
                v5 -= (long)v7;
                segment1 = segment1.next;
                v2 = 0L;
            }
        }
        return this;
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "out");
        return this.copyTo(buffer0, v, this.size - v);
    }

    @NotNull
    public final Buffer copyTo(@NotNull Buffer buffer0, long v, long v1) {
        q.g(buffer0, "out");
        long v2 = v;
        -SegmentedByteString.checkOffsetAndCount(this.size(), v2, v1);
        if(v1 != 0L) {
            buffer0.setSize$okio(buffer0.size() + v1);
            Segment segment0;
            for(segment0 = this.head; true; segment0 = segment0.next) {
                q.d(segment0);
                int v3 = segment0.limit;
                int v4 = segment0.pos;
                if(v2 < ((long)(v3 - v4))) {
                    break;
                }
                v2 -= (long)(v3 - v4);
            }
            Segment segment1 = segment0;
            long v5 = v1;
            while(v5 > 0L) {
                q.d(segment1);
                Segment segment2 = segment1.sharedCopy();
                int v6 = segment2.pos + ((int)v2);
                segment2.pos = v6;
                segment2.limit = Math.min(v6 + ((int)v5), segment2.limit);
                Segment segment3 = buffer0.head;
                if(segment3 == null) {
                    segment2.prev = segment2;
                    segment2.next = segment2;
                    buffer0.head = segment2;
                }
                else {
                    q.d(segment3);
                    Segment segment4 = segment3.prev;
                    q.d(segment4);
                    segment4.push(segment2);
                }
                v5 -= (long)(segment2.limit - segment2.pos);
                segment1 = segment1.next;
                v2 = 0L;
            }
        }
        return this;
    }

    public static Buffer copyTo$default(Buffer buffer0, OutputStream outputStream0, long v, long v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0L;
        }
        if((v2 & 4) != 0) {
            v1 = buffer0.size - v;
        }
        return buffer0.copyTo(outputStream0, v, v1);
    }

    public static Buffer copyTo$default(Buffer buffer0, Buffer buffer1, long v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 0L;
        }
        return buffer0.copyTo(buffer1, v);
    }

    public static Buffer copyTo$default(Buffer buffer0, Buffer buffer1, long v, long v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v = 0L;
        }
        return buffer0.copyTo(buffer1, v, v1);
    }

    private final ByteString digest(String s) {
        MessageDigest messageDigest0 = MessageDigest.getInstance(s);
        Segment segment0 = this.head;
        if(segment0 != null) {
            messageDigest0.update(segment0.data, segment0.pos, segment0.limit - segment0.pos);
            Segment segment1 = segment0.next;
            q.d(segment1);
            while(segment1 != segment0) {
                messageDigest0.update(segment1.data, segment1.pos, segment1.limit - segment1.pos);
                segment1 = segment1.next;
                q.d(segment1);
            }
        }
        byte[] arr_b = messageDigest0.digest();
        q.f(arr_b, "digest(...)");
        return new ByteString(arr_b);
    }

    @NotNull
    public Buffer emit() [...] // Inlined contents

    @Override  // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @NotNull
    public Buffer emitCompleteSegments() [...] // Inlined contents

    @Override  // okio.BufferedSink
    public BufferedSink emitCompleteSegments() {
        return this;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Buffer)) {
            return false;
        }
        if(this.size() != ((Buffer)object0).size()) {
            return false;
        }
        if(this.size() == 0L) {
            return true;
        }
        Segment segment0 = this.head;
        q.d(segment0);
        Segment segment1 = ((Buffer)object0).head;
        q.d(segment1);
        int v = segment0.pos;
        int v1 = segment1.pos;
        for(long v2 = 0L; v2 < this.size(); v2 += v3) {
            long v3 = (long)Math.min(segment0.limit - v, segment1.limit - v1);
            long v4 = 0L;
            while(v4 < v3) {
                if(segment0.data[v] != segment1.data[v1]) {
                    return false;
                }
                ++v4;
                ++v;
                ++v1;
            }
            if(v == segment0.limit) {
                segment0 = segment0.next;
                q.d(segment0);
                v = segment0.pos;
            }
            if(v1 == segment1.limit) {
                segment1 = segment1.next;
                q.d(segment1);
                v1 = segment1.pos;
            }
        }
        return true;
    }

    @Override  // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0L;
    }

    @Override  // okio.BufferedSink
    public void flush() {
    }

    @Override  // okio.BufferedSource, okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long v) {
        int v3;
        -SegmentedByteString.checkOffsetAndCount(this.size(), v, 1L);
        Segment segment0 = this.head;
        if(segment0 != null) {
            if(this.size() - v < v) {
                long v1;
                for(v1 = this.size(); v1 > v; v1 -= (long)(segment0.limit - segment0.pos)) {
                    segment0 = segment0.prev;
                    q.d(segment0);
                }
                return segment0.data[((int)(((long)segment0.pos) + v - v1))];
            }
            long v2;
            for(v2 = 0L; true; v2 = v4) {
                v3 = segment0.pos;
                long v4 = ((long)(segment0.limit - v3)) + v2;
                if(v4 > v) {
                    break;
                }
                segment0 = segment0.next;
                q.d(segment0);
            }
            return segment0.data[((int)(((long)v3) + v - v2))];
        }
        q.d(null);
        throw null;
    }

    @Override
    public int hashCode() {
        Segment segment0 = this.head;
        if(segment0 == null) {
            return 0;
        }
        int v = 1;
        do {
            int v1 = segment0.pos;
            int v2 = segment0.limit;
            while(v1 < v2) {
                v = v * 0x1F + segment0.data[v1];
                ++v1;
            }
            segment0 = segment0.next;
            q.d(segment0);
        }
        while(segment0 != this.head);
        return v;
    }

    private final ByteString hmac(String s, ByteString byteString0) {
        try {
            Mac mac0 = Mac.getInstance(s);
            mac0.init(new SecretKeySpec(byteString0.internalArray$okio(), s));
            Segment segment0 = this.head;
            if(segment0 != null) {
                mac0.update(segment0.data, segment0.pos, segment0.limit - segment0.pos);
                Segment segment1 = segment0.next;
                q.d(segment1);
                while(segment1 != segment0) {
                    mac0.update(segment1.data, segment1.pos, segment1.limit - segment1.pos);
                    segment1 = segment1.next;
                    q.d(segment1);
                }
            }
            byte[] arr_b = mac0.doFinal();
            q.f(arr_b, "doFinal(...)");
            return new ByteString(arr_b);
        }
        catch(InvalidKeyException invalidKeyException0) {
        }
        throw new IllegalArgumentException(invalidKeyException0);
    }

    @NotNull
    public final ByteString hmacSha1(@NotNull ByteString byteString0) {
        q.g(byteString0, "key");
        return this.hmac("HmacSHA1", byteString0);
    }

    @NotNull
    public final ByteString hmacSha256(@NotNull ByteString byteString0) {
        q.g(byteString0, "key");
        return this.hmac("HmacSHA256", byteString0);
    }

    @NotNull
    public final ByteString hmacSha512(@NotNull ByteString byteString0) {
        q.g(byteString0, "key");
        return this.hmac("HmacSHA512", byteString0);
    }

    @Override  // okio.BufferedSource
    public long indexOf(byte b) {
        return this.indexOf(b, 0L, 0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    public long indexOf(byte b, long v) {
        return this.indexOf(b, v, 0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    public long indexOf(byte b, long v, long v1) {
        int v4;
        long v2 = 0L;
        if(0L > v || v > v1) {
            throw new IllegalArgumentException(("size=" + this.size() + " fromIndex=" + v + " toIndex=" + v1).toString());
        }
        if(v1 > this.size()) {
            v1 = this.size();
        }
        if(Long.compare(v, v1) == 0) {
            return -1L;
        }
        Segment segment0 = this.head;
        if(segment0 == null) {
            return -1L;
        }
        if(this.size() - v < v) {
            for(v2 = this.size(); v2 > v; v2 -= (long)(segment0.limit - segment0.pos)) {
                segment0 = segment0.prev;
                q.d(segment0);
            }
            while(v2 < v1) {
                byte[] arr_b = segment0.data;
                int v3 = (int)Math.min(segment0.limit, ((long)segment0.pos) + v1 - v2);
                for(v4 = (int)(((long)segment0.pos) + v - v2); v4 < v3; ++v4) {
                    if(arr_b[v4] == b) {
                        return ((long)(v4 - segment0.pos)) + v2;
                    }
                }
                v2 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v2;
            }
            return -1L;
        }
        long v5;
        while((v5 = ((long)(segment0.limit - segment0.pos)) + v2) <= v) {
            segment0 = segment0.next;
            q.d(segment0);
            v2 = v5;
        }
        while(v2 < v1) {
            byte[] arr_b1 = segment0.data;
            int v6 = (int)Math.min(segment0.limit, ((long)segment0.pos) + v1 - v2);
            v4 = (int)(((long)segment0.pos) + v - v2);
            while(v4 < v6) {
                if(arr_b1[v4] != b) {
                    ++v4;
                    continue;
                }
                return ((long)(v4 - segment0.pos)) + v2;
            }
            v2 += (long)(segment0.limit - segment0.pos);
            segment0 = segment0.next;
            q.d(segment0);
            v = v2;
        }
        return -1L;
    }

    @Override  // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        return this.indexOf(byteString0, 0L);
    }

    @Override  // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString0, long v) {
        q.g(byteString0, "bytes");
        return this.indexOf(byteString0, v, 0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString0, long v, long v1) {
        q.g(byteString0, "bytes");
        return -Buffer.commonIndexOf$default(this, byteString0, v, v1, 0, 0, 24, null);
    }

    @Override  // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString byteString0) {
        q.g(byteString0, "targetBytes");
        return this.indexOfElement(byteString0, 0L);
    }

    @Override  // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString byteString0, long v) {
        int v4;
        q.g(byteString0, "targetBytes");
        long v1 = 0L;
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "fromIndex < 0: ").toString());
        }
        Segment segment0 = this.head;
        if(segment0 == null) {
            return -1L;
        }
        if(Long.compare(this.size() - v, v) < 0) {
            for(v1 = this.size(); v1 > v; v1 -= (long)(segment0.limit - segment0.pos)) {
                segment0 = segment0.prev;
                q.d(segment0);
            }
            if(byteString0.size() == 2) {
                int v2 = byteString0.getByte(0);
                int v3 = byteString0.getByte(1);
                while(v1 < this.size()) {
                    byte[] arr_b = segment0.data;
                    v4 = (int)(((long)segment0.pos) + v - v1);
                    int v5 = segment0.limit;
                    while(v4 < v5) {
                        int v6 = arr_b[v4];
                        if(v6 == v2 || v6 == v3) {
                            return ((long)(v4 - segment0.pos)) + v1;
                        }
                        ++v4;
                    }
                    v1 += (long)(segment0.limit - segment0.pos);
                    segment0 = segment0.next;
                    q.d(segment0);
                    v = v1;
                }
                return -1L;
            }
            byte[] arr_b1 = byteString0.internalArray$okio();
            while(v1 < this.size()) {
                byte[] arr_b2 = segment0.data;
                v4 = (int)(((long)segment0.pos) + v - v1);
                int v7 = segment0.limit;
                while(v4 < v7) {
                    int v8 = arr_b2[v4];
                    for(int v9 = 0; v9 < arr_b1.length; ++v9) {
                        if(v8 == arr_b1[v9]) {
                            return ((long)(v4 - segment0.pos)) + v1;
                        }
                    }
                    ++v4;
                }
                v1 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v1;
            }
            return -1L;
        }
        long v10;
        while((v10 = ((long)(segment0.limit - segment0.pos)) + v1) <= v) {
            segment0 = segment0.next;
            q.d(segment0);
            v1 = v10;
        }
        if(byteString0.size() == 2) {
            int v11 = byteString0.getByte(0);
            int v12 = byteString0.getByte(1);
            while(v1 < this.size()) {
                byte[] arr_b3 = segment0.data;
                v4 = (int)(((long)segment0.pos) + v - v1);
                int v13 = segment0.limit;
                while(v4 < v13) {
                    int v14 = arr_b3[v4];
                    if(v14 != v11 && v14 != v12) {
                        ++v4;
                        continue;
                    }
                    return ((long)(v4 - segment0.pos)) + v1;
                }
                v1 += (long)(segment0.limit - segment0.pos);
                segment0 = segment0.next;
                q.d(segment0);
                v = v1;
            }
            return -1L;
        }
        byte[] arr_b4 = byteString0.internalArray$okio();
        while(v1 < this.size()) {
            byte[] arr_b5 = segment0.data;
            v4 = (int)(((long)segment0.pos) + v - v1);
            int v15 = segment0.limit;
            while(v4 < v15) {
                int v16 = arr_b5[v4];
                int v17 = 0;
                while(v17 < arr_b4.length) {
                    if(v16 != arr_b4[v17]) {
                        ++v17;
                        continue;
                    }
                    return ((long)(v4 - segment0.pos)) + v1;
                }
                ++v4;
            }
            v1 += (long)(segment0.limit - segment0.pos);
            segment0 = segment0.next;
            q.d(segment0);
            v = v1;
        }
        return -1L;
    }

    @Override  // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() {
            @Override
            public int available() {
                return (int)Math.min(Buffer.this.size(), 0x7FFFFFFFL);
            }

            @Override
            public void close() {
            }

            @Override
            public int read() {
                return Buffer.this.size() <= 0L ? -1 : Buffer.this.readByte() & 0xFF;
            }

            @Override
            public int read(byte[] arr_b, int v, int v1) {
                q.g(arr_b, "sink");
                return Buffer.this.read(arr_b, v, v1);
            }

            @Override
            public String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    @NotNull
    public final ByteString md5() {
        return this.digest("MD5");
    }

    @Override  // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() {
            @Override
            public void close() {
            }

            @Override
            public void flush() {
            }

            @Override
            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override
            public void write(int v) {
                Buffer.this.writeByte(v);
            }

            @Override
            public void write(byte[] arr_b, int v, int v1) {
                q.g(arr_b, "data");
                Buffer.this.write(arr_b, v, v1);
            }
        };
    }

    @Override  // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override  // okio.BufferedSource
    public boolean rangeEquals(long v, @NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        return this.rangeEquals(v, byteString0, 0, byteString0.size());
    }

    @Override  // okio.BufferedSource
    public boolean rangeEquals(long v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(byteString0, "bytes");
        if(v2 < 0) {
            return false;
        }
        if(v >= 0L && ((long)v2) + v <= this.size() && v1 >= 0 && v1 + v2 <= byteString0.size()) {
            return v2 == 0 ? true : -Buffer.commonIndexOf(this, byteString0, v, v + 1L, v1, v2) != -1L;
        }
        return false;
    }

    @Override
    public int read(@NotNull ByteBuffer byteBuffer0) {
        q.g(byteBuffer0, "sink");
        Segment segment0 = this.head;
        if(segment0 == null) {
            return -1;
        }
        int v = Math.min(byteBuffer0.remaining(), segment0.limit - segment0.pos);
        byteBuffer0.put(segment0.data, segment0.pos, v);
        int v1 = segment0.pos + v;
        segment0.pos = v1;
        this.size -= (long)v;
        if(v1 == segment0.limit) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return v;
    }

    @Override  // okio.BufferedSource
    public int read(@NotNull byte[] arr_b) {
        q.g(arr_b, "sink");
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override  // okio.BufferedSource
    public int read(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "sink");
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
        Segment segment0 = this.head;
        if(segment0 == null) {
            return -1;
        }
        int v2 = Math.min(v1, segment0.limit - segment0.pos);
        n.T(segment0.data, v, segment0.pos, arr_b, segment0.pos + v2);
        segment0.pos += v2;
        this.setSize$okio(this.size() - ((long)v2));
        if(segment0.pos == segment0.limit) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return v2;
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(this.size() == 0L) {
            return -1L;
        }
        if(v > this.size()) {
            v = this.size();
        }
        buffer0.write(this, v);
        return v;
    }

    @Override  // okio.BufferedSource
    public long readAll(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        long v = this.size();
        if(v > 0L) {
            sink0.write(this, v);
        }
        return v;
    }

    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return Buffer.readAndWriteUnsafe$default(this, null, 1, null);
    }

    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull UnsafeCursor buffer$UnsafeCursor0) {
        q.g(buffer$UnsafeCursor0, "unsafeCursor");
        return -Buffer.commonReadAndWriteUnsafe(this, buffer$UnsafeCursor0);
    }

    public static UnsafeCursor readAndWriteUnsafe$default(Buffer buffer0, UnsafeCursor buffer$UnsafeCursor0, int v, Object object0) {
        if((v & 1) != 0) {
            buffer$UnsafeCursor0 = -SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer0.readAndWriteUnsafe(buffer$UnsafeCursor0);
    }

    @Override  // okio.BufferedSource
    public byte readByte() {
        if(this.size() == 0L) {
            throw new EOFException();
        }
        Segment segment0 = this.head;
        q.d(segment0);
        int v = segment0.limit;
        int v1 = segment0.pos + 1;
        byte b = segment0.data[segment0.pos];
        this.setSize$okio(this.size() - 1L);
        if(v1 == v) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return b;
        }
        segment0.pos = v1;
        return b;
    }

    @Override  // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() [...] // 潜在的解密器

    @Override  // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long v) {
        if(v < 0L || v > 0x7FFFFFFFL) {
            throw new IllegalArgumentException(e.a(v, "byteCount: ").toString());
        }
        if(this.size() < v) {
            throw new EOFException();
        }
        byte[] arr_b = new byte[((int)v)];
        this.readFully(arr_b);
        return arr_b;
    }

    @Override  // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        return this.readByteString(this.size());
    }

    @Override  // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long v) {
        if(v < 0L || v > 0x7FFFFFFFL) {
            throw new IllegalArgumentException(e.a(v, "byteCount: ").toString());
        }
        if(this.size() < v) {
            throw new EOFException();
        }
        if(v >= 0x1000L) {
            ByteString byteString0 = this.snapshot(((int)v));
            this.skip(v);
            return byteString0;
        }
        return new ByteString(this.readByteArray(v));
    }

    @Override  // okio.BufferedSource
    public long readDecimalLong() {
        if(this.size() == 0L) {
            throw new EOFException();
        }
        int v = 0;
        boolean z = false;
        long v1 = 0L;
        long v2 = -7L;
        boolean z1 = false;
        do {
            Segment segment0 = this.head;
            q.d(segment0);
            byte[] arr_b = segment0.data;
            int v3 = segment0.pos;
            int v4 = segment0.limit;
            while(v3 < v4) {
                int v5 = arr_b[v3];
                if(v5 >= 0x30 && v5 <= 57) {
                    int v6 = Long.compare(v1, -922337203685477580L);
                    if(v6 >= 0 && (v6 != 0 || ((long)(0x30 - v5)) >= v2)) {
                        v1 = v1 * 10L + ((long)(0x30 - v5));
                        ++v3;
                        ++v;
                        continue;
                    }
                    Buffer buffer0 = new Buffer().writeDecimalLong(v1).writeByte(v5);
                    if(!z) {
                        buffer0.readByte();
                    }
                    throw new NumberFormatException("Number too large: ");
                }
                else if(v5 == 45 && v == 0) {
                    --v2;
                    z = true;
                }
                else {
                    goto label_28;
                }
                ++v3;
                ++v;
                continue;
            label_28:
                z1 = true;
                if(true) {
                    break;
                }
            }
            if(v3 == v4) {
                this.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
            else {
                segment0.pos = v3;
            }
        }
        while(!z1 && this.head != null);
        this.setSize$okio(this.size() - ((long)v));
        if(v < (z ? 2 : 1)) {
            if(this.size() == 0L) {
                throw new EOFException();
            }
            StringBuilder stringBuilder0 = x.p((z ? "Expected a digit" : "Expected a digit or \'-\'"), " but was 0x");
            stringBuilder0.append(-SegmentedByteString.toHexString(this.getByte(0L)));
            throw new NumberFormatException(stringBuilder0.toString());
        }
        return z ? v1 : -v1;
    }

    private final void readFrom(InputStream inputStream0, long v, boolean z) {
        while(v > 0L || z) {
            Segment segment0 = this.writableSegment$okio(1);
            int v1 = inputStream0.read(segment0.data, segment0.limit, ((int)Math.min(v, 0x2000 - segment0.limit)));
            if(v1 == -1) {
                if(segment0.pos == segment0.limit) {
                    this.head = segment0.pop();
                    SegmentPool.recycle(segment0);
                }
                if(!z) {
                    throw new EOFException();
                }
                break;
            }
            segment0.limit += v1;
            this.size += (long)v1;
            v -= (long)v1;
        }
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream0) {
        q.g(inputStream0, "input");
        this.readFrom(inputStream0, 0x7FFFFFFFFFFFFFFFL, true);
        return this;
    }

    @NotNull
    public final Buffer readFrom(@NotNull InputStream inputStream0, long v) {
        q.g(inputStream0, "input");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        this.readFrom(inputStream0, v, false);
        return this;
    }

    @Override  // okio.BufferedSource
    public void readFully(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        if(this.size() >= v) {
            buffer0.write(this, v);
            return;
        }
        buffer0.write(this, this.size());
        throw new EOFException();
    }

    @Override  // okio.BufferedSource
    public void readFully(@NotNull byte[] arr_b) {
        q.g(arr_b, "sink");
        for(int v = 0; v < arr_b.length; v += v1) {
            int v1 = this.read(arr_b, v, arr_b.length - v);
            if(v1 == -1) {
                throw new EOFException();
            }
        }
    }

    @Override  // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int v5;
        if(this.size() == 0L) {
            throw new EOFException();
        }
        int v = 0;
        boolean z = false;
        long v1 = 0L;
        do {
            Segment segment0 = this.head;
            q.d(segment0);
            byte[] arr_b = segment0.data;
            int v2 = segment0.pos;
            int v3 = segment0.limit;
            while(v2 < v3) {
                int v4 = arr_b[v2];
                if(v4 >= 0x30 && v4 <= 57) {
                    v5 = v4 - 0x30;
                }
                else if(v4 >= 97 && v4 <= 102) {
                    v5 = v4 - 87;
                }
                else if(v4 < 65 || v4 > 70) {
                    goto label_25;
                }
                else {
                    v5 = v4 - 55;
                }
                if((0xF000000000000000L & v1) != 0L) {
                    throw new NumberFormatException("Number too large: ");
                }
                v1 = v1 << 4 | ((long)v5);
                ++v2;
                ++v;
                continue;
            label_25:
                if(v == 0) {
                    throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + -SegmentedByteString.toHexString(((byte)v4)));
                }
                z = true;
                break;
            }
            if(v2 == v3) {
                this.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
            else {
                segment0.pos = v2;
            }
        }
        while(!z && this.head != null);
        this.setSize$okio(this.size() - ((long)v));
        return v1;
    }

    @Override  // okio.BufferedSource
    public int readInt() {
        if(this.size() < 4L) {
            throw new EOFException();
        }
        Segment segment0 = this.head;
        q.d(segment0);
        int v = segment0.pos;
        int v1 = segment0.limit;
        if(((long)(v1 - v)) < 4L) {
            return (this.readByte() & 0xFF) << 24 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 8 | this.readByte() & 0xFF;
        }
        int v2 = segment0.data[v + 3] & 0xFF | ((segment0.data[v + 1] & 0xFF) << 16 | (segment0.data[v] & 0xFF) << 24 | (segment0.data[v + 2] & 0xFF) << 8);
        this.setSize$okio(this.size() - 4L);
        if(v + 4 == v1) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return v2;
        }
        segment0.pos = v + 4;
        return v2;
    }

    @Override  // okio.BufferedSource
    public int readIntLe() {
        return -SegmentedByteString.reverseBytes(this.readInt());
    }

    @Override  // okio.BufferedSource
    public long readLong() {
        if(this.size() < 8L) {
            throw new EOFException();
        }
        Segment segment0 = this.head;
        q.d(segment0);
        int v = segment0.pos;
        int v1 = segment0.limit;
        if(Long.compare(v1 - v, 8L) < 0) {
            return (((long)this.readInt()) & 0xFFFFFFFFL) << 0x20 | 0xFFFFFFFFL & ((long)this.readInt());
        }
        long v2 = (((long)segment0.data[v]) & 0xFFL) << 56 | (((long)segment0.data[v + 1]) & 0xFFL) << 0x30 | (((long)segment0.data[v + 2]) & 0xFFL) << 40 | (((long)segment0.data[v + 3]) & 0xFFL) << 0x20 | (((long)segment0.data[v + 4]) & 0xFFL) << 24 | (((long)segment0.data[v + 5]) & 0xFFL) << 16 | (((long)segment0.data[v + 6]) & 0xFFL) << 8 | ((long)segment0.data[v + 7]) & 0xFFL;
        this.setSize$okio(this.size() - 8L);
        if(v + 8 == v1) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return v2;
        }
        segment0.pos = v + 8;
        return v2;
    }

    @Override  // okio.BufferedSource
    public long readLongLe() {
        return -SegmentedByteString.reverseBytes(this.readLong());
    }

    @Override  // okio.BufferedSource
    public short readShort() {
        if(this.size() < 2L) {
            throw new EOFException();
        }
        Segment segment0 = this.head;
        q.d(segment0);
        int v = segment0.pos;
        int v1 = segment0.limit;
        if(v1 - v < 2) {
            return (short)((this.readByte() & 0xFF) << 8 | this.readByte() & 0xFF);
        }
        int v2 = segment0.data[v + 1] & 0xFF | (segment0.data[v] & 0xFF) << 8;
        this.setSize$okio(this.size() - 2L);
        if(v + 2 == v1) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
            return (short)v2;
        }
        segment0.pos = v + 2;
        return (short)v2;
    }

    @Override  // okio.BufferedSource
    public short readShortLe() {
        return -SegmentedByteString.reverseBytes(this.readShort());
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readString(long v, @NotNull Charset charset0) {
        q.g(charset0, "charset");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0 || v > 0x7FFFFFFFL) {
            throw new IllegalArgumentException(e.a(v, "byteCount: ").toString());
        }
        if(this.size < v) {
            throw new EOFException();
        }
        if(v1 == 0) {
            return "";
        }
        Segment segment0 = this.head;
        q.d(segment0);
        int v2 = segment0.pos;
        if(((long)v2) + v > ((long)segment0.limit)) {
            return new String(this.readByteArray(v), charset0);
        }
        String s = new String(segment0.data, v2, ((int)v), charset0);
        int v3 = segment0.pos + ((int)v);
        segment0.pos = v3;
        this.size -= v;
        if(v3 == segment0.limit) {
            this.head = segment0.pop();
            SegmentPool.recycle(segment0);
        }
        return s;
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset0) {
        q.g(charset0, "charset");
        return this.readString(this.size, charset0);
    }

    @NotNull
    public final UnsafeCursor readUnsafe() {
        return Buffer.readUnsafe$default(this, null, 1, null);
    }

    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull UnsafeCursor buffer$UnsafeCursor0) {
        q.g(buffer$UnsafeCursor0, "unsafeCursor");
        return -Buffer.commonReadUnsafe(this, buffer$UnsafeCursor0);
    }

    public static UnsafeCursor readUnsafe$default(Buffer buffer0, UnsafeCursor buffer$UnsafeCursor0, int v, Object object0) {
        if((v & 1) != 0) {
            buffer$UnsafeCursor0 = -SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer0.readUnsafe(buffer$UnsafeCursor0);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8() [...] // 潜在的解密器

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8(long v) {
        return this.readString(v, a.a);
    }

    @Override  // okio.BufferedSource
    public int readUtf8CodePoint() {
        int v4;
        int v3;
        int v2;
        if(this.size() == 0L) {
            throw new EOFException();
        }
        int v = this.getByte(0L);
        int v1 = 1;
        if((v & 0x80) == 0) {
            v2 = v & 0x7F;
            v3 = 0;
            v4 = 1;
            goto label_22;
        }
        if((v & 0xE0) == 0xC0) {
            v2 = v & 0x1F;
            v4 = 2;
            v3 = 0x80;
            goto label_22;
        }
        boolean z = false;
        if((v & 0xF0) == 0xE0) {
            z = true;
            v2 = v & 15;
            v4 = 3;
            v3 = 0x800;
        }
        else if((v & 0xF8) == 0xF0) {
            z = true;
            v2 = v & 7;
            v4 = 4;
            v3 = 0x10000;
        }
        if(z) {
        label_22:
            if(this.size() >= ((long)v4)) {
                while(v1 < v4) {
                    int v5 = this.getByte(((long)v1));
                    if((v5 & 0xC0) == 0x80) {
                        v2 = v2 << 6 | v5 & 0x3F;
                        ++v1;
                        continue;
                    }
                    this.skip(((long)v1));
                    return 0xFFFD;
                }
                this.skip(((long)v4));
                if(v2 > 0x10FFFF) {
                    return 0xFFFD;
                }
                if(0xD800 <= v2 && v2 < 0xE000) {
                    return 0xFFFD;
                }
                return v2 >= v3 ? v2 : 0xFFFD;
            }
            StringBuilder stringBuilder0 = x.n(v4, "size < ", ": ");
            stringBuilder0.append(this.size());
            stringBuilder0.append(" (to read code point prefixed 0x");
            stringBuilder0.append(-SegmentedByteString.toHexString(((byte)v)));
            stringBuilder0.append(')');
            throw new EOFException(stringBuilder0.toString());
        }
        this.skip(1L);
        return 0xFFFD;
    }

    @Override  // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long v = this.indexOf(10);
        if(v != -1L) {
            return -Buffer.readUtf8Line(this, v);
        }
        return this.size() == 0L ? null : this.readUtf8(this.size());
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return this.readUtf8LineStrict(0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long v) {
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "limit < 0: ").toString());
        }
        if(Long.compare(v, 0x7FFFFFFFFFFFFFFFL) != 0) {
            v1 = v + 1L;
        }
        long v2 = this.indexOf(10, 0L, v1);
        if(v2 != -1L) {
            return -Buffer.readUtf8Line(this, v2);
        }
        if(v1 < this.size() && this.getByte(v1 - 1L) == 13 && this.getByte(v1) == 10) {
            return -Buffer.readUtf8Line(this, v1);
        }
        Buffer buffer0 = new Buffer();
        this.copyTo(buffer0, 0L, Math.min(0x20L, this.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.size(), v) + " content=" + buffer0.readByteString().hex() + '…');
    }

    @Override  // okio.BufferedSource
    public boolean request(long v) {
        return this.size >= v;
    }

    @Override  // okio.BufferedSource
    public void require(long v) {
        if(this.size < v) {
            throw new EOFException();
        }
    }

    @Override  // okio.BufferedSource
    public int select(@NotNull Options options0) {
        q.g(options0, "options");
        int v = -Buffer.selectPrefix$default(this, options0, false, 2, null);
        if(v == -1) {
            return -1;
        }
        this.skip(((long)options0.getByteStrings$okio()[v].size()));
        return v;
    }

    @Override  // okio.BufferedSource
    @Nullable
    public Object select(@NotNull TypedOptions typedOptions0) {
        q.g(typedOptions0, "options");
        int v = this.select(typedOptions0.getOptions$okio());
        return v == -1 ? null : typedOptions0.get(v);
    }

    public final void setSize$okio(long v) {
        this.size = v;
    }

    @NotNull
    public final ByteString sha1() {
        return this.digest("SHA-1");
    }

    @NotNull
    public final ByteString sha256() {
        return this.digest("SHA-256");
    }

    @NotNull
    public final ByteString sha512() {
        return this.digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    @Override  // okio.BufferedSource
    public void skip(long v) {
        while(v > 0L) {
            Segment segment0 = this.head;
            if(segment0 == null) {
                throw new EOFException();
            }
            int v1 = (int)Math.min(v, segment0.limit - segment0.pos);
            this.setSize$okio(this.size() - ((long)v1));
            v -= (long)v1;
            int v2 = segment0.pos + v1;
            segment0.pos = v2;
            if(v2 == segment0.limit) {
                this.head = segment0.pop();
                SegmentPool.recycle(segment0);
            }
        }
    }

    @NotNull
    public final ByteString snapshot() {
        if(this.size() > 0x7FFFFFFFL) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.size()).toString());
        }
        return this.snapshot(((int)this.size()));
    }

    @NotNull
    public final ByteString snapshot(int v) {
        if(v == 0) {
            return ByteString.EMPTY;
        }
        -SegmentedByteString.checkOffsetAndCount(this.size(), 0L, v);
        Segment segment0 = this.head;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v2 < v) {
            q.d(segment0);
            int v4 = segment0.limit;
            int v5 = segment0.pos;
            if(v4 == v5) {
                throw new AssertionError("s.limit == s.pos");
            }
            v2 += v4 - v5;
            ++v3;
            segment0 = segment0.next;
        }
        byte[][] arr2_b = new byte[v3][];
        int[] arr_v = new int[v3 * 2];
        Segment segment1 = this.head;
        int v6 = 0;
        while(v1 < v) {
            q.d(segment1);
            arr2_b[v6] = segment1.data;
            v1 += segment1.limit - segment1.pos;
            arr_v[v6] = Math.min(v1, v);
            arr_v[v6 + v3] = segment1.pos;
            segment1.shared = true;
            ++v6;
            segment1 = segment1.next;
        }
        return new SegmentedByteString(arr2_b, arr_v);
    }

    @Override  // okio.Source, okio.Sink
    @NotNull
    public Timeout timeout() {
        return Timeout.NONE;
    }

    @Override
    @NotNull
    public String toString() {
        return this.snapshot().toString();
    }

    @NotNull
    public final Segment writableSegment$okio(int v) {
        if(v < 1 || v > 0x2000) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        Segment segment0 = this.head;
        if(segment0 == null) {
            Segment segment1 = SegmentPool.take();
            this.head = segment1;
            segment1.prev = segment1;
            segment1.next = segment1;
            return segment1;
        }
        q.d(segment0);
        Segment segment2 = segment0.prev;
        q.d(segment2);
        return segment2.limit + v > 0x2000 || !segment2.owner ? segment2.push(SegmentPool.take()) : segment2;
    }

    @Override
    public int write(@NotNull ByteBuffer byteBuffer0) {
        q.g(byteBuffer0, "source");
        int v = byteBuffer0.remaining();
        int v1 = v;
        while(v1 > 0) {
            Segment segment0 = this.writableSegment$okio(1);
            int v2 = Math.min(v1, 0x2000 - segment0.limit);
            byteBuffer0.get(segment0.data, segment0.limit, v2);
            v1 -= v2;
            segment0.limit += v2;
        }
        this.size += (long)v;
        return v;
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString0) {
        q.g(byteString0, "byteString");
        byteString0.write$okio(this, 0, byteString0.size());
        return this;
    }

    @NotNull
    public Buffer write(@NotNull ByteString byteString0, int v, int v1) {
        q.g(byteString0, "byteString");
        byteString0.write$okio(this, v, v1);
        return this;
    }

    @NotNull
    public Buffer write(@NotNull Source source0, long v) {
        q.g(source0, "source");
        while(v > 0L) {
            long v1 = source0.read(this, v);
            if(v1 == -1L) {
                throw new EOFException();
            }
            v -= v1;
        }
        return this;
    }

    @NotNull
    public Buffer write(@NotNull byte[] arr_b) {
        q.g(arr_b, "source");
        return this.write(arr_b, 0, arr_b.length);
    }

    @NotNull
    public Buffer write(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "source");
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
        int v2 = v1 + v;
        while(v < v2) {
            Segment segment0 = this.writableSegment$okio(1);
            int v3 = Math.min(v2 - v, 0x2000 - segment0.limit);
            int v4 = v + v3;
            n.T(arr_b, segment0.limit, v, segment0.data, v4);
            segment0.limit += v3;
            v = v4;
        }
        this.setSize$okio(this.size() + ((long)v1));
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink write(ByteString byteString0) {
        return this.write(byteString0);
    }

    @Override  // okio.BufferedSink
    public BufferedSink write(ByteString byteString0, int v, int v1) {
        return this.write(byteString0, v, v1);
    }

    @Override  // okio.BufferedSink
    public BufferedSink write(Source source0, long v) {
        return this.write(source0, v);
    }

    @Override  // okio.BufferedSink
    public BufferedSink write(byte[] arr_b) {
        return this.write(arr_b);
    }

    @Override  // okio.BufferedSink
    public BufferedSink write(byte[] arr_b, int v, int v1) {
        return this.write(arr_b, v, v1);
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        Segment segment3;
        q.g(buffer0, "source");
        if(buffer0 == this) {
            throw new IllegalArgumentException("source == this");
        }
        -SegmentedByteString.checkOffsetAndCount(buffer0.size(), 0L, v);
        while(v > 0L) {
            Segment segment0 = buffer0.head;
            q.d(segment0);
            int v1 = segment0.limit;
            Segment segment1 = buffer0.head;
            q.d(segment1);
            if(v < ((long)(v1 - segment1.pos))) {
                Segment segment2 = this.head;
                if(segment2 == null) {
                    segment3 = null;
                }
                else {
                    q.d(segment2);
                    segment3 = segment2.prev;
                }
                if(segment3 != null && segment3.owner && ((long)segment3.limit) + v - ((long)(segment3.shared ? 0 : segment3.pos)) <= 0x2000L) {
                    Segment segment4 = buffer0.head;
                    q.d(segment4);
                    segment4.writeTo(segment3, ((int)v));
                    buffer0.setSize$okio(buffer0.size() - v);
                    this.setSize$okio(this.size() + v);
                    return;
                }
                Segment segment5 = buffer0.head;
                q.d(segment5);
                buffer0.head = segment5.split(((int)v));
            }
            Segment segment6 = buffer0.head;
            q.d(segment6);
            long v2 = (long)(segment6.limit - segment6.pos);
            buffer0.head = segment6.pop();
            Segment segment7 = this.head;
            if(segment7 == null) {
                this.head = segment6;
                segment6.prev = segment6;
                segment6.next = segment6;
            }
            else {
                q.d(segment7);
                Segment segment8 = segment7.prev;
                q.d(segment8);
                segment8.push(segment6).compact();
            }
            buffer0.setSize$okio(buffer0.size() - v2);
            this.setSize$okio(this.size() + v2);
            v -= v2;
        }
    }

    @Override  // okio.BufferedSink
    public long writeAll(@NotNull Source source0) {
        q.g(source0, "source");
        long v = 0L;
        long v1;
        while((v1 = source0.read(this, 0x2000L)) != -1L) {
            v += v1;
        }
        return v;
    }

    @NotNull
    public Buffer writeByte(int v) {
        Segment segment0 = this.writableSegment$okio(1);
        int v1 = segment0.limit;
        segment0.limit = v1 + 1;
        segment0.data[v1] = (byte)v;
        this.setSize$okio(this.size() + 1L);
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeByte(int v) {
        return this.writeByte(v);
    }

    @NotNull
    public Buffer writeDecimalLong(long v) {
        boolean z;
        int v1 = Long.compare(v, 0L);
        if(v1 == 0) {
            return this.writeByte(0x30);
        }
        if(v1 < 0) {
            v = -v;
            if(v < 0L) {
                return this.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        else {
            z = false;
        }
        int v2 = -Buffer.access$countDigitsIn(v);
        if(z) {
            ++v2;
        }
        Segment segment0 = this.writableSegment$okio(v2);
        byte[] arr_b = segment0.data;
        int v3 = segment0.limit + v2;
        while(v != 0L) {
            --v3;
            arr_b[v3] = new byte[]{0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102}[((int)(v % 10L))];
            v /= 10L;
        }
        if(z) {
            arr_b[v3 - 1] = 45;
        }
        segment0.limit += v2;
        this.setSize$okio(this.size() + ((long)v2));
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeDecimalLong(long v) {
        return this.writeDecimalLong(v);
    }

    @NotNull
    public Buffer writeHexadecimalUnsignedLong(long v) {
        if(v == 0L) {
            return this.writeByte(0x30);
        }
        long v1 = v >>> 1 | v;
        long v2 = v1 | v1 >>> 2;
        long v3 = v2 | v2 >>> 4;
        long v4 = v3 | v3 >>> 8;
        long v5 = v4 | v4 >>> 16;
        long v6 = v5 | v5 >>> 0x20;
        long v7 = v6 - (v6 >>> 1 & 0x5555555555555555L);
        long v8 = (v7 >>> 2 & 0x3333333333333333L) + (v7 & 0x3333333333333333L);
        long v9 = (v8 >>> 4) + v8 & 0xF0F0F0F0F0F0F0FL;
        long v10 = v9 + (v9 >>> 8);
        long v11 = v10 + (v10 >>> 16);
        int v12 = (int)(((v11 & 0x3FL) + (v11 >>> 0x20 & 0x3FL) + 3L) / 4L);
        Segment segment0 = this.writableSegment$okio(v12);
        byte[] arr_b = segment0.data;
        int v13 = segment0.limit;
        for(int v14 = v13 + v12 - 1; v14 >= v13; --v14) {
            arr_b[v14] = new byte[]{0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102}[((int)(15L & v))];
            v >>>= 4;
        }
        segment0.limit += v12;
        this.setSize$okio(this.size() + ((long)v12));
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeHexadecimalUnsignedLong(long v) {
        return this.writeHexadecimalUnsignedLong(v);
    }

    @NotNull
    public Buffer writeInt(int v) {
        Segment segment0 = this.writableSegment$okio(4);
        int v1 = segment0.limit;
        segment0.data[v1] = (byte)(v >>> 24 & 0xFF);
        segment0.data[v1 + 1] = (byte)(v >>> 16 & 0xFF);
        segment0.data[v1 + 2] = (byte)(v >>> 8 & 0xFF);
        segment0.data[v1 + 3] = (byte)(v & 0xFF);
        segment0.limit = v1 + 4;
        this.setSize$okio(this.size() + 4L);
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeInt(int v) {
        return this.writeInt(v);
    }

    @NotNull
    public Buffer writeIntLe(int v) {
        return this.writeInt((v & 0xFF) << 24 | ((0xFF000000 & v) >>> 24 | (0xFF0000 & v) >>> 8 | (0xFF00 & v) << 8));
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeIntLe(int v) {
        return this.writeIntLe(v);
    }

    @NotNull
    public Buffer writeLong(long v) {
        Segment segment0 = this.writableSegment$okio(8);
        int v1 = segment0.limit;
        segment0.data[v1] = (byte)(((int)(v >>> 56 & 0xFFL)));
        segment0.data[v1 + 1] = (byte)(((int)(v >>> 0x30 & 0xFFL)));
        segment0.data[v1 + 2] = (byte)(((int)(v >>> 40 & 0xFFL)));
        segment0.data[v1 + 3] = (byte)(((int)(v >>> 0x20 & 0xFFL)));
        segment0.data[v1 + 4] = (byte)(((int)(v >>> 24 & 0xFFL)));
        segment0.data[v1 + 5] = (byte)(((int)(v >>> 16 & 0xFFL)));
        segment0.data[v1 + 6] = (byte)(((int)(v >>> 8 & 0xFFL)));
        segment0.data[v1 + 7] = (byte)(((int)(v & 0xFFL)));
        segment0.limit = v1 + 8;
        this.setSize$okio(this.size() + 8L);
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeLong(long v) {
        return this.writeLong(v);
    }

    @NotNull
    public Buffer writeLongLe(long v) {
        return this.writeLong(-SegmentedByteString.reverseBytes(v));
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeLongLe(long v) {
        return this.writeLongLe(v);
    }

    @NotNull
    public Buffer writeShort(int v) {
        Segment segment0 = this.writableSegment$okio(2);
        int v1 = segment0.limit;
        segment0.data[v1] = (byte)(v >>> 8 & 0xFF);
        segment0.data[v1 + 1] = (byte)(v & 0xFF);
        segment0.limit = v1 + 2;
        this.setSize$okio(this.size() + 2L);
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeShort(int v) {
        return this.writeShort(v);
    }

    @NotNull
    public Buffer writeShortLe(int v) {
        return this.writeShort(((int)(((short)((((short)v) & 0xFF) << 8 | (0xFF00 & ((short)v)) >>> 8)))));
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeShortLe(int v) {
        return this.writeShortLe(v);
    }

    @NotNull
    public Buffer writeString(@NotNull String s, int v, int v1, @NotNull Charset charset0) {
        q.g(s, "string");
        q.g(charset0, "charset");
        if(v < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + v).toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + v1 + " < " + v).toString());
        }
        if(v1 <= s.length()) {
            if(charset0.equals(a.a)) {
                return this.writeUtf8(s, v, v1);
            }
            String s1 = s.substring(v, v1);
            q.f(s1, "substring(...)");
            byte[] arr_b = s1.getBytes(charset0);
            q.f(arr_b, "getBytes(...)");
            return this.write(arr_b, 0, arr_b.length);
        }
        StringBuilder stringBuilder0 = x.n(v1, "endIndex > string.length: ", " > ");
        stringBuilder0.append(s.length());
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @NotNull
    public Buffer writeString(@NotNull String s, @NotNull Charset charset0) {
        q.g(s, "string");
        q.g(charset0, "charset");
        return this.writeString(s, 0, s.length(), charset0);
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeString(String s, int v, int v1, Charset charset0) {
        return this.writeString(s, v, v1, charset0);
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeString(String s, Charset charset0) {
        return this.writeString(s, charset0);
    }

    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream0) {
        q.g(outputStream0, "out");
        return Buffer.writeTo$default(this, outputStream0, 0L, 2, null);
    }

    @NotNull
    public final Buffer writeTo(@NotNull OutputStream outputStream0, long v) {
        q.g(outputStream0, "out");
        -SegmentedByteString.checkOffsetAndCount(this.size, 0L, v);
        Segment segment0 = this.head;
        long v1 = v;
        while(v1 > 0L) {
            q.d(segment0);
            int v2 = (int)Math.min(v1, segment0.limit - segment0.pos);
            outputStream0.write(segment0.data, segment0.pos, v2);
            int v3 = segment0.pos + v2;
            segment0.pos = v3;
            this.size -= (long)v2;
            v1 -= (long)v2;
            if(v3 == segment0.limit) {
                Segment segment1 = segment0.pop();
                this.head = segment1;
                SegmentPool.recycle(segment0);
                segment0 = segment1;
            }
        }
        return this;
    }

    public static Buffer writeTo$default(Buffer buffer0, OutputStream outputStream0, long v, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = buffer0.size;
        }
        return buffer0.writeTo(outputStream0, v);
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String s) {
        q.g(s, "string");
        return this.writeUtf8(s, 0, s.length());
    }

    @NotNull
    public Buffer writeUtf8(@NotNull String s, int v, int v1) {
        q.g(s, "string");
        if(v < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + v).toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + v1 + " < " + v).toString());
        }
        if(v1 <= s.length()) {
            while(v < v1) {
                int v2 = s.charAt(v);
                if(v2 < 0x80) {
                    Segment segment0 = this.writableSegment$okio(1);
                    byte[] arr_b = segment0.data;
                    int v3 = segment0.limit - v;
                    int v4 = Math.min(v1, 0x2000 - v3);
                    int v5 = v + 1;
                    arr_b[v + v3] = (byte)v2;
                    while(true) {
                        v = v5;
                        if(v >= v4) {
                            break;
                        }
                        int v6 = s.charAt(v);
                        if(v6 >= 0x80) {
                            break;
                        }
                        v5 = v + 1;
                        arr_b[v + v3] = (byte)v6;
                    }
                    int v7 = v3 + v - segment0.limit;
                    segment0.limit += v7;
                    this.setSize$okio(this.size() + ((long)v7));
                }
                else {
                    if(v2 < 0x800) {
                        Segment segment1 = this.writableSegment$okio(2);
                        int v8 = segment1.limit;
                        segment1.data[v8] = (byte)(v2 >> 6 | 0xC0);
                        segment1.data[v8 + 1] = (byte)(v2 & 0x3F | 0x80);
                        segment1.limit = v8 + 2;
                        this.setSize$okio(this.size() + 2L);
                    }
                    else if(v2 < 0xD800 || v2 > 0xDFFF) {
                        Segment segment3 = this.writableSegment$okio(3);
                        int v12 = segment3.limit;
                        segment3.data[v12] = (byte)(v2 >> 12 | 0xE0);
                        segment3.data[v12 + 1] = (byte)(0x3F & v2 >> 6 | 0x80);
                        segment3.data[v12 + 2] = (byte)(v2 & 0x3F | 0x80);
                        segment3.limit = v12 + 3;
                        this.setSize$okio(this.size() + 3L);
                    }
                    else {
                        int v9 = v + 1 >= v1 ? 0 : s.charAt(v + 1);
                        if(v2 > 0xDBFF || 0xDC00 > v9 || v9 >= 0xE000) {
                            this.writeByte(0x3F);
                            ++v;
                        }
                        else {
                            int v10 = ((v2 & 0x3FF) << 10 | v9 & 0x3FF) + 0x10000;
                            Segment segment2 = this.writableSegment$okio(4);
                            int v11 = segment2.limit;
                            segment2.data[v11] = (byte)(v10 >> 18 | 0xF0);
                            segment2.data[v11 + 1] = (byte)(v10 >> 12 & 0x3F | 0x80);
                            segment2.data[v11 + 2] = (byte)(v10 >> 6 & 0x3F | 0x80);
                            segment2.data[v11 + 3] = (byte)(v10 & 0x3F | 0x80);
                            segment2.limit = v11 + 4;
                            this.setSize$okio(this.size() + 4L);
                            v += 2;
                        }
                        continue;
                    }
                    ++v;
                }
            }
            return this;
        }
        StringBuilder stringBuilder0 = x.n(v1, "endIndex > string.length: ", " > ");
        stringBuilder0.append(s.length());
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeUtf8(String s) {
        return this.writeUtf8(s);
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeUtf8(String s, int v, int v1) {
        return this.writeUtf8(s, v, v1);
    }

    @NotNull
    public Buffer writeUtf8CodePoint(int v) {
        if(v < 0x80) {
            this.writeByte(v);
            return this;
        }
        if(v < 0x800) {
            Segment segment0 = this.writableSegment$okio(2);
            int v1 = segment0.limit;
            segment0.data[v1] = (byte)(v >> 6 | 0xC0);
            segment0.data[v1 + 1] = (byte)(v & 0x3F | 0x80);
            segment0.limit = v1 + 2;
            this.setSize$okio(this.size() + 2L);
            return this;
        }
        if(0xD800 <= v && v < 0xE000) {
            this.writeByte(0x3F);
            return this;
        }
        if(v < 0x10000) {
            Segment segment1 = this.writableSegment$okio(3);
            int v2 = segment1.limit;
            segment1.data[v2] = (byte)(v >> 12 | 0xE0);
            segment1.data[v2 + 1] = (byte)(v >> 6 & 0x3F | 0x80);
            segment1.data[v2 + 2] = (byte)(v & 0x3F | 0x80);
            segment1.limit = v2 + 3;
            this.setSize$okio(this.size() + 3L);
            return this;
        }
        if(v > 0x10FFFF) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + -SegmentedByteString.toHexString(v));
        }
        Segment segment2 = this.writableSegment$okio(4);
        int v3 = segment2.limit;
        segment2.data[v3] = (byte)(v >> 18 | 0xF0);
        segment2.data[v3 + 1] = (byte)(v >> 12 & 0x3F | 0x80);
        segment2.data[v3 + 2] = (byte)(v >> 6 & 0x3F | 0x80);
        segment2.data[v3 + 3] = (byte)(v & 0x3F | 0x80);
        segment2.limit = v3 + 4;
        this.setSize$okio(this.size() + 4L);
        return this;
    }

    @Override  // okio.BufferedSink
    public BufferedSink writeUtf8CodePoint(int v) {
        return this.writeUtf8CodePoint(v);
    }
}

