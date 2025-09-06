package kotlinx.coroutines.channels;

import Ac.a4;
import Ac.i2;
import Bd.e;
import De.g;
import d5.n;
import e1.u;
import e2.a;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import me.i;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000\u00B6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002\u00DE\u0001B3\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\"\b\u0002\u0010\b\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00028\u0000H\u0096@\u00A2\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00060\u000E2\u0006\u0010\u000B\u001A\u00028\u0000H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00060\u000E2\u0006\u0010\u000B\u001A\u00028\u0000H\u0004\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u000F\u0010\u0014\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0017\u001A\u00028\u0000H\u0096@\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0096@\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u000EH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010 \u001A\u00020\u00062\u0006\u0010\u001F\u001A\u00020\u001EH\u0004\u00A2\u0006\u0004\b \u0010!J\u0017\u0010$\u001A\u00020\u00062\u0006\u0010\"\u001A\u00020\u001EH\u0000\u00A2\u0006\u0004\b#\u0010!J\u0016\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000%H\u0096\u0002\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010(\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b(\u0010\u0015J\u0019\u0010,\u001A\u00020+2\b\u0010*\u001A\u0004\u0018\u00010)H\u0016\u00A2\u0006\u0004\b,\u0010-J\u001D\u00100\u001A\u00020\u00062\u000E\u0010*\u001A\n\u0018\u00010.j\u0004\u0018\u0001`/\u00A2\u0006\u0004\b0\u00101J\u0019\u00103\u001A\u00020+2\b\u0010*\u001A\u0004\u0018\u00010)H\u0010\u00A2\u0006\u0004\b2\u0010-J!\u00104\u001A\u00020+2\b\u0010*\u001A\u0004\u0018\u00010)2\u0006\u00100\u001A\u00020+H\u0014\u00A2\u0006\u0004\b4\u00105J%\u00107\u001A\u00020\u00062\u0014\u00106\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010)\u0012\u0004\u0012\u00020\u00060\u0005H\u0016\u00A2\u0006\u0004\b7\u00108J\u000F\u0010;\u001A\u00020+H\u0000\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010=\u001A\u00020<H\u0016\u00A2\u0006\u0004\b=\u0010>J\u0018\u0010?\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00028\u0000H\u0082@\u00A2\u0006\u0004\b?\u0010\rJ6\u0010D\u001A\u00020\u00062\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010C\u001A\u00020\u001EH\u0082@\u00A2\u0006\u0004\bD\u0010EJ)\u0010G\u001A\u00020\u0006*\u00020F2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\bG\u0010HJ%\u0010K\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00028\u00002\f\u0010J\u001A\b\u0012\u0004\u0012\u00020\u00060IH\u0002\u00A2\u0006\u0004\bK\u0010LJG\u0010P\u001A\u00020\u00032\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010C\u001A\u00020\u001E2\b\u0010N\u001A\u0004\u0018\u00010M2\u0006\u0010O\u001A\u00020+H\u0002\u00A2\u0006\u0004\bP\u0010QJG\u0010R\u001A\u00020\u00032\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00028\u00002\u0006\u0010C\u001A\u00020\u001E2\b\u0010N\u001A\u0004\u0018\u00010M2\u0006\u0010O\u001A\u00020+H\u0002\u00A2\u0006\u0004\bR\u0010QJ\u0017\u0010T\u001A\u00020+2\u0006\u0010S\u001A\u00020\u001EH\u0003\u00A2\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001A\u00020+2\u0006\u0010V\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\bW\u0010UJ\u001B\u0010X\u001A\u00020+*\u00020M2\u0006\u0010\u000B\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\bX\u0010YJ.\u0010[\u001A\u00028\u00002\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010Z\u001A\u00020\u001EH\u0082@\u00A2\u0006\u0004\b[\u0010\\J)\u0010]\u001A\u00020\u0006*\u00020F2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\b]\u0010HJ\u001D\u0010^\u001A\u00020\u00062\f\u0010J\u001A\b\u0012\u0004\u0012\u00028\u00000IH\u0002\u00A2\u0006\u0004\b^\u0010_J4\u0010a\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010Z\u001A\u00020\u001EH\u0082@\u00A2\u0006\u0004\b`\u0010\\J#\u0010b\u001A\u00020\u00062\u0012\u0010J\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0IH\u0002\u00A2\u0006\u0004\bb\u0010_J9\u0010c\u001A\u0004\u0018\u00010M2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010Z\u001A\u00020\u001E2\b\u0010N\u001A\u0004\u0018\u00010MH\u0002\u00A2\u0006\u0004\bc\u0010dJ9\u0010e\u001A\u0004\u0018\u00010M2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010Z\u001A\u00020\u001E2\b\u0010N\u001A\u0004\u0018\u00010MH\u0002\u00A2\u0006\u0004\be\u0010dJ)\u0010f\u001A\u00020+*\u00020M2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\bf\u0010gJ\u000F\u0010h\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bh\u0010\u0015J-\u0010j\u001A\u00020+2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010i\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\bj\u0010kJ-\u0010l\u001A\u00020+2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010i\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\bl\u0010kJ\u0019\u0010n\u001A\u00020\u00062\b\b\u0002\u0010m\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\bn\u0010!J%\u0010r\u001A\u00020\u00062\n\u0010p\u001A\u0006\u0012\u0002\b\u00030o2\b\u0010q\u001A\u0004\u0018\u00010MH\u0002\u00A2\u0006\u0004\br\u0010sJ\u001B\u0010t\u001A\u00020\u00062\n\u0010p\u001A\u0006\u0012\u0002\b\u00030oH\u0002\u00A2\u0006\u0004\bt\u0010uJ%\u0010w\u001A\u0004\u0018\u00010M2\b\u0010q\u001A\u0004\u0018\u00010M2\b\u0010v\u001A\u0004\u0018\u00010MH\u0002\u00A2\u0006\u0004\bw\u0010xJ%\u0010y\u001A\u0004\u0018\u00010M2\b\u0010q\u001A\u0004\u0018\u00010M2\b\u0010v\u001A\u0004\u0018\u00010MH\u0002\u00A2\u0006\u0004\by\u0010xJ\u000F\u0010z\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bz\u0010\u0015J\u000F\u0010{\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b{\u0010\u0015J\u000F\u0010|\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b|\u0010\u0015J\u000F\u0010}\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b}\u0010\u0015J\u000F\u0010~\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b~\u0010\u0015J \u0010\u0080\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010\u007F\u001A\u00020\u001EH\u0002\u00A2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001A\u00020\u00062\u0006\u0010\u007F\u001A\u00020\u001EH\u0002\u00A2\u0006\u0005\b\u0082\u0001\u0010!J\u0018\u0010\u0083\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@H\u0002\u00A2\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J!\u0010\u0086\u0001\u001A\u00020\u001E2\r\u0010\u0085\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@H\u0002\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J!\u0010\u0088\u0001\u001A\u00020\u00062\r\u0010\u0085\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@H\u0002\u00A2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J*\u0010\u008B\u0001\u001A\u00020\u00062\r\u0010\u0085\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0007\u0010\u008A\u0001\u001A\u00020\u001EH\u0002\u00A2\u0006\u0006\b\u008B\u0001\u0010\u008C\u0001J\u0016\u0010\u008D\u0001\u001A\u00020\u0006*\u00020FH\u0002\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J\u0016\u0010\u008F\u0001\u001A\u00020\u0006*\u00020FH\u0002\u00A2\u0006\u0006\b\u008F\u0001\u0010\u008E\u0001J\u001F\u0010\u0091\u0001\u001A\u00020\u0006*\u00020F2\u0007\u0010\u0090\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J$\u0010\u0095\u0001\u001A\u00020+2\u0007\u0010\u0093\u0001\u001A\u00020\u001E2\u0007\u0010\u0094\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J/\u0010\u0097\u0001\u001A\u00020+2\f\u0010A\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u001EH\u0002\u00A2\u0006\u0005\b\u0097\u0001\u0010kJ2\u0010\u009A\u0001\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010@2\u0007\u0010\u0098\u0001\u001A\u00020\u001E2\r\u0010\u0099\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@H\u0002\u00A2\u0006\u0006\b\u009A\u0001\u0010\u009B\u0001J2\u0010\u009C\u0001\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010@2\u0007\u0010\u0098\u0001\u001A\u00020\u001E2\r\u0010\u0099\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@H\u0002\u00A2\u0006\u0006\b\u009C\u0001\u0010\u009B\u0001J;\u0010\u009E\u0001\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010@2\u0007\u0010\u0098\u0001\u001A\u00020\u001E2\r\u0010\u0099\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@2\u0007\u0010\u009D\u0001\u001A\u00020\u001EH\u0002\u00A2\u0006\u0006\b\u009E\u0001\u0010\u009F\u0001J*\u0010\u00A0\u0001\u001A\u00020\u00062\u0007\u0010\u0098\u0001\u001A\u00020\u001E2\r\u0010\u0099\u0001\u001A\b\u0012\u0004\u0012\u00028\u00000@H\u0002\u00A2\u0006\u0006\b\u00A0\u0001\u0010\u00A1\u0001J\u001A\u0010\u00A3\u0001\u001A\u00020\u00062\u0007\u0010\u00A2\u0001\u001A\u00020\u001EH\u0002\u00A2\u0006\u0005\b\u00A3\u0001\u0010!J\u001A\u0010\u00A4\u0001\u001A\u00020\u00062\u0007\u0010\u00A2\u0001\u001A\u00020\u001EH\u0002\u00A2\u0006\u0005\b\u00A4\u0001\u0010!JL\u0010\u00A7\u0001\u001A\"\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E\u0012\u0005\u0012\u00030\u00A6\u0001\u0012\u0004\u0012\u00020\u00060\u00A5\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007H\u0002\u00A2\u0006\u0006\b\u00A7\u0001\u0010\u00A8\u0001J2\u0010\u00AC\u0001\u001A\u00020\u00062\u0006\u0010*\u001A\u00020)2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E2\b\u0010\u00A9\u0001\u001A\u00030\u00A6\u0001H\u0002\u00A2\u0006\u0006\b\u00AA\u0001\u0010\u00AB\u0001JP\u0010\u00AE\u0001\u001A\u001E\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\u0005\u0012\u00030\u00A6\u0001\u0012\u0004\u0012\u00020\u00060\u00AD\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00072\u0006\u0010\u000B\u001A\u00028\u0000H\u0002\u00A2\u0006\u0006\b\u00AE\u0001\u0010\u00AF\u0001JF\u0010\u00AE\u0001\u001A\u001C\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00028\u0000\u0012\u0005\u0012\u00030\u00A6\u0001\u0012\u0004\u0012\u00020\u00060\u00A5\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0007H\u0002\u00A2\u0006\u0006\b\u00AE\u0001\u0010\u00A8\u0001J,\u0010\u00B0\u0001\u001A\u00020\u00062\u0006\u0010*\u001A\u00020)2\u0006\u0010\u000B\u001A\u00028\u00002\b\u0010\u00A9\u0001\u001A\u00030\u00A6\u0001H\u0002\u00A2\u0006\u0006\b\u00B0\u0001\u0010\u00AB\u0001R\u0015\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004\u00A2\u0006\u0007\n\u0005\b\u0004\u0010\u00B1\u0001R/\u0010\b\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00078\u0000X\u0081\u0004\u00A2\u0006\u0007\n\u0005\b\b\u0010\u00B2\u0001Rd\u0010\u00B4\u0001\u001AH\u0012\b\u0012\u0006\u0012\u0002\b\u00030o\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\u0006\u0012\u0004\u0018\u00010M\u0012 \u0012\u001E\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\u0005\u0012\u00030\u00A6\u0001\u0012\u0004\u0012\u00020\u00060\u00AD\u0001\u0018\u00010\u00AD\u0001j\u0005\u0018\u0001`\u00B3\u00018\u0002X\u0082\u0004\u00A2\u0006\u000F\n\u0006\b\u00B4\u0001\u0010\u00B5\u0001\u0012\u0005\b\u00B6\u0001\u0010\u0015R\u0017\u0010\u008A\u0001\u001A\u00020\u001E8@X\u0080\u0004\u00A2\u0006\b\u001A\u0006\b\u00B7\u0001\u0010\u00B8\u0001R\u0017\u0010\u00BA\u0001\u001A\u00020\u001E8@X\u0080\u0004\u00A2\u0006\b\u001A\u0006\b\u00B9\u0001\u0010\u00B8\u0001R%\u0010\u00BF\u0001\u001A\t\u0012\u0004\u0012\u00028\u00000\u00BB\u00018VX\u0096\u0004\u00A2\u0006\u000F\u0012\u0005\b\u00BE\u0001\u0010\u0015\u001A\u0006\b\u00BC\u0001\u0010\u00BD\u0001R+\u0010\u00C2\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000E0\u00BB\u00018VX\u0096\u0004\u00A2\u0006\u000F\u0012\u0005\b\u00C1\u0001\u0010\u0015\u001A\u0006\b\u00C0\u0001\u0010\u00BD\u0001R\u0019\u0010\u00C5\u0001\u001A\u0004\u0018\u00010)8DX\u0084\u0004\u00A2\u0006\b\u001A\u0006\b\u00C3\u0001\u0010\u00C4\u0001R\u0017\u0010\u00C7\u0001\u001A\u00020)8DX\u0084\u0004\u00A2\u0006\b\u001A\u0006\b\u00C6\u0001\u0010\u00C4\u0001R\u0016\u0010\u00C8\u0001\u001A\u00020+8TX\u0094\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00C8\u0001\u0010:R\u001D\u0010\u00C9\u0001\u001A\u00020+8VX\u0097\u0004\u00A2\u0006\u000E\u0012\u0005\b\u00CA\u0001\u0010\u0015\u001A\u0005\b\u00C9\u0001\u0010:R\u001D\u0010\u0094\u0001\u001A\u00020+8VX\u0097\u0004\u00A2\u0006\u000E\u0012\u0005\b\u00CB\u0001\u0010\u0015\u001A\u0005\b\u0094\u0001\u0010:R\u0017\u0010\u00CD\u0001\u001A\u00020\u001E8BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00CC\u0001\u0010\u00B8\u0001R\u0016\u0010\u00CE\u0001\u001A\u00020+8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00CE\u0001\u0010:R\u0017\u0010\u00D0\u0001\u001A\u00020)8BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00CF\u0001\u0010\u00C4\u0001R\u001A\u0010\u00D1\u0001\u001A\u00020+*\u00020\u001E8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00D1\u0001\u0010UR\u001A\u0010\u00D2\u0001\u001A\u00020+*\u00020\u001E8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00D2\u0001\u0010UR\r\u0010\u00D4\u0001\u001A\u00030\u00D3\u00018\u0002X\u0082\u0004R\r\u0010\u00D5\u0001\u001A\u00030\u00D3\u00018\u0002X\u0082\u0004R\r\u0010\u00D6\u0001\u001A\u00030\u00D3\u00018\u0002X\u0082\u0004R\r\u0010\u00D7\u0001\u001A\u00030\u00D3\u00018\u0002X\u0082\u0004R\u0019\u0010\u00D9\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0\u00D8\u00018\u0002X\u0082\u0004R\u0019\u0010\u00DA\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0\u00D8\u00018\u0002X\u0082\u0004R\u0019\u0010\u00DB\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000@0\u00D8\u00018\u0002X\u0082\u0004R\u0015\u0010\u00DC\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010M0\u00D8\u00018\u0002X\u0082\u0004R\u0015\u0010\u00DD\u0001\u001A\u000B\u0012\u0006\u0012\u0004\u0018\u00010M0\u00D8\u00018\u0002X\u0082\u0004\u00A8\u0006\u00DF\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "", "capacity", "Lkotlin/Function1;", "Lie/H;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILwe/k;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "trySendDropOldest-JP2dKIU", "trySendDropOldest", "onReceiveEnqueued", "()V", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "", "globalCellIndex", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "(J)V", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "waitExpandBufferCompletion", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "onClosedIdempotent", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl$kotlinx_coroutines_core", "cancelImpl", "closeOrCancelImpl", "(Ljava/lang/Throwable;Z)Z", "handler", "invokeOnClose", "(Lwe/k;)V", "hasElements$kotlinx_coroutines_core", "()Z", "hasElements", "", "toString", "()Ljava/lang/String;", "onClosedSend", "Lkotlinx/coroutines/channels/ChannelSegment;", "segment", "index", "s", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Waiter;", "prepareSenderForSuspension", "(Lkotlinx/coroutines/Waiter;Lkotlinx/coroutines/channels/ChannelSegment;I)V", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "", "waiter", "closed", "updateCellSend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "curSendersAndCloseStatus", "shouldSendSuspend", "(J)Z", "curSenders", "bufferOrRendezvousSend", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "r", "receiveOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "(Lkotlinx/coroutines/CancellableContinuation;)V", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "receiveCatchingOnNoWaiterSuspend", "onClosedReceiveCatchingOnNoWaiterSuspend", "updateCellReceive", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLjava/lang/Object;)Ljava/lang/Object;", "updateCellReceiveSlow", "tryResumeSender", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/ChannelSegment;I)Z", "expandBuffer", "b", "updateCellExpandBuffer", "(Lkotlinx/coroutines/channels/ChannelSegment;IJ)Z", "updateCellExpandBufferSlow", "nAttempts", "incCompletedExpandBufferAttempts", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "ignoredParam", "registerSelectForReceive", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "onClosedSelectOnReceive", "(Lkotlinx/coroutines/selects/SelectInstance;)V", "selectResult", "processResultSelectReceive", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "processResultSelectReceiveCatching", "invokeCloseHandler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "sendersCur", "completeClose", "(J)Lkotlinx/coroutines/channels/ChannelSegment;", "completeCancel", "closeLinkedList", "()Lkotlinx/coroutines/channels/ChannelSegment;", "lastSegment", "markAllEmptyCellsAsClosed", "(Lkotlinx/coroutines/channels/ChannelSegment;)J", "removeUnprocessedElements", "(Lkotlinx/coroutines/channels/ChannelSegment;)V", "sendersCounter", "cancelSuspendedReceiveRequests", "(Lkotlinx/coroutines/channels/ChannelSegment;J)V", "resumeReceiverOnClosedChannel", "(Lkotlinx/coroutines/Waiter;)V", "resumeSenderOnCancelledChannel", "receiver", "resumeWaiterOnClosedChannel", "(Lkotlinx/coroutines/Waiter;Z)V", "sendersAndCloseStatusCur", "isClosedForReceive", "isClosed", "(JZ)Z", "isCellNonEmpty", "id", "startFrom", "findSegmentSend", "(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", "findSegmentReceive", "currentBufferEndCounter", "findSegmentBufferEnd", "(JLkotlinx/coroutines/channels/ChannelSegment;J)Lkotlinx/coroutines/channels/ChannelSegment;", "moveSegmentBufferEndToSpecifiedOrLast", "(JLkotlinx/coroutines/channels/ChannelSegment;)V", "value", "updateSendersCounterIfLower", "updateReceiversCounterIfLower", "Lkotlin/reflect/KFunction3;", "Lme/i;", "bindCancellationFunResult", "(Lwe/k;)LDe/g;", "context", "onCancellationChannelResultImplDoNotCall-5_sEAP8", "(Ljava/lang/Throwable;Ljava/lang/Object;Lme/i;)V", "onCancellationChannelResultImplDoNotCall", "Lkotlin/Function3;", "bindCancellationFun", "(Lwe/k;Ljava/lang/Object;)Lwe/o;", "onCancellationImplDoNotCall", "I", "Lwe/k;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onUndeliveredElementReceiveCancellationConstructor", "Lwe/o;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "getSendersCounter$kotlinx_coroutines_core", "()J", "getReceiversCounter$kotlinx_coroutines_core", "receiversCounter", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "onReceive", "getOnReceiveCatching", "getOnReceiveCatching$annotations", "onReceiveCatching", "getCloseCause", "()Ljava/lang/Throwable;", "closeCause", "getSendException", "sendException", "isConflatedDropOldest", "isClosedForSend", "isClosedForSend$annotations", "isClosedForReceive$annotations", "getBufferEndCounter", "bufferEndCounter", "isRendezvousOrUnlimited", "getReceiveException", "receiveException", "isClosedForSend0", "isClosedForReceive0", "Lkotlinx/atomicfu/AtomicLong;", "sendersAndCloseStatus", "receivers", "bufferEnd", "completedExpandBuffersAndPauseFlag", "Lkotlinx/atomicfu/AtomicRef;", "sendSegment", "receiveSegment", "bufferEndSegment", "_closeCause", "closeHandler", "BufferedChannelIterator", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class BufferedChannel implements Channel {
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u000E\u001A\u00020\u00052\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0082@¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0005H\u0096B¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001A\u00020\u00102\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00028\u0000¢\u0006\u0004\b\u001B\u0010\u001CJ\r\u0010\u001D\u001A\u00020\u0010¢\u0006\u0004\b\u001D\u0010\u0012R\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u001E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u001E\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "", "onClosedHasNext", "()Z", "Lkotlinx/coroutines/channels/ChannelSegment;", "segment", "", "index", "", "r", "hasNextOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "onClosedHasNextNoWaiterSuspend", "()V", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Segment;", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "next", "()Ljava/lang/Object;", "element", "tryResumeHasNext", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "", "receiveResult", "Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    final class BufferedChannelIterator implements Waiter, ChannelIterator {
        @Nullable
        private CancellableContinuationImpl continuation;
        @Nullable
        private Object receiveResult;

        public BufferedChannelIterator() {
            this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
        }

        @Override  // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation continuation0) {
            ChannelSegment channelSegment2;
            if(this.receiveResult == BufferedChannelKt.NO_RECEIVE_RESULT || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel bufferedChannel0 = BufferedChannel.this;
                ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel0);
                while(true) {
                    if(bufferedChannel0.isClosedForReceive()) {
                        return Boolean.valueOf(this.onClosedHasNext());
                    }
                    long v = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel0);
                    long v1 = v / ((long)BufferedChannelKt.SEGMENT_SIZE);
                    int v2 = (int)(v % ((long)BufferedChannelKt.SEGMENT_SIZE));
                    if(channelSegment0.id == v1) {
                        channelSegment2 = channelSegment0;
                    }
                    else {
                        ChannelSegment channelSegment1 = bufferedChannel0.findSegmentReceive(v1, channelSegment0);
                        if(channelSegment1 == null) {
                            continue;
                        }
                        channelSegment2 = channelSegment1;
                    }
                    Object object0 = bufferedChannel0.updateCellReceive(channelSegment2, v2, v, null);
                    if(object0 == BufferedChannelKt.SUSPEND) {
                        break;
                    }
                    if(object0 == BufferedChannelKt.FAILED) {
                        if(v < bufferedChannel0.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment2.cleanPrev();
                        }
                        channelSegment0 = channelSegment2;
                        continue;
                    }
                    if(object0 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                        return this.hasNextOnNoWaiterSuspend(channelSegment2, v2, v, continuation0);
                    }
                    channelSegment2.cleanPrev();
                    this.receiveResult = object0;
                    return true;
                }
                throw new IllegalStateException("unreachable");
            }
            return true;
        }

        private final Object hasNextOnNoWaiterSuspend(ChannelSegment channelSegment0, int v, long v1, Continuation continuation0) {
            Object object1;
            ChannelSegment channelSegment3;
            BufferedChannel bufferedChannel0 = BufferedChannel.this;
            CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(u.D(continuation0));
            try {
                this.continuation = cancellableContinuationImpl0;
                o o0 = null;
                Object object0 = bufferedChannel0.updateCellReceive(channelSegment0, v, v1, this);
                if(object0 == BufferedChannelKt.SUSPEND) {
                    bufferedChannel0.prepareReceiverForSuspension(this, channelSegment0, v);
                    return cancellableContinuationImpl0.getResult();
                }
                if(object0 == BufferedChannelKt.FAILED) {
                    if(v1 < bufferedChannel0.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment0.cleanPrev();
                    }
                    ChannelSegment channelSegment1 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel0);
                    while(true) {
                        if(bufferedChannel0.isClosedForReceive()) {
                            this.onClosedHasNextNoWaiterSuspend();
                            return cancellableContinuationImpl0.getResult();
                        }
                        long v2 = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel0);
                        long v3 = v2 / ((long)BufferedChannelKt.SEGMENT_SIZE);
                        int v4 = (int)(v2 % ((long)BufferedChannelKt.SEGMENT_SIZE));
                        if(channelSegment1.id == v3) {
                            channelSegment3 = channelSegment1;
                        }
                        else {
                            ChannelSegment channelSegment2 = bufferedChannel0.findSegmentReceive(v3, channelSegment1);
                            if(channelSegment2 == null) {
                                continue;
                            }
                            channelSegment3 = channelSegment2;
                        }
                        object1 = bufferedChannel0.updateCellReceive(channelSegment3, v4, v2, this);
                        if(object1 == BufferedChannelKt.SUSPEND) {
                            bufferedChannel0.prepareReceiverForSuspension(this, channelSegment3, v4);
                            return cancellableContinuationImpl0.getResult();
                        }
                        if(object1 != BufferedChannelKt.FAILED) {
                            break;
                        }
                        if(v2 < bufferedChannel0.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment3.cleanPrev();
                        }
                        channelSegment1 = channelSegment3;
                    }
                    if(object1 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                        throw new IllegalStateException("unexpected");
                    }
                    channelSegment3.cleanPrev();
                    this.receiveResult = object1;
                    this.continuation = null;
                    k k0 = bufferedChannel0.onUndeliveredElement;
                    if(k0 != null) {
                        o0 = bufferedChannel0.bindCancellationFun(k0, object1);
                    }
                }
                else {
                    channelSegment0.cleanPrev();
                    this.receiveResult = object0;
                    this.continuation = null;
                    k k1 = bufferedChannel0.onUndeliveredElement;
                    if(k1 != null) {
                        o0 = bufferedChannel0.bindCancellationFun(k1, object0);
                    }
                }
                cancellableContinuationImpl0.resume(Boolean.TRUE, o0);
                return cancellableContinuationImpl0.getResult();
            }
            catch(Throwable throwable0) {
                cancellableContinuationImpl0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw throwable0;
            }
        }

        @Override  // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment segment0, int v) {
            CancellableContinuationImpl cancellableContinuationImpl0 = this.continuation;
            if(cancellableContinuationImpl0 != null) {
                cancellableContinuationImpl0.invokeOnCancellation(segment0, v);
            }
        }

        @Override  // kotlinx.coroutines.channels.ChannelIterator
        public Object next() {
            Object object0 = this.receiveResult;
            if(object0 == BufferedChannelKt.NO_RECEIVE_RESULT) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
            if(object0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            return object0;
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable0 = BufferedChannel.this.getCloseCause();
            if(throwable0 != null) {
                throw throwable0;
            }
            return false;
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl cancellableContinuationImpl0 = this.continuation;
            q.d(cancellableContinuationImpl0);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable0 = BufferedChannel.this.getCloseCause();
            if(throwable0 == null) {
                cancellableContinuationImpl0.resumeWith(Boolean.FALSE);
                return;
            }
            cancellableContinuationImpl0.resumeWith(n.t(throwable0));
        }

        public final boolean tryResumeHasNext(Object object0) {
            CancellableContinuationImpl cancellableContinuationImpl0 = this.continuation;
            q.d(cancellableContinuationImpl0);
            o o0 = null;
            this.continuation = null;
            this.receiveResult = object0;
            BufferedChannel bufferedChannel0 = BufferedChannel.this;
            k k0 = bufferedChannel0.onUndeliveredElement;
            if(k0 != null) {
                o0 = bufferedChannel0.bindCancellationFun(k0, object0);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl0, Boolean.TRUE, o0);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl cancellableContinuationImpl0 = this.continuation;
            q.d(cancellableContinuationImpl0);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable throwable0 = BufferedChannel.this.getCloseCause();
            if(throwable0 == null) {
                cancellableContinuationImpl0.resumeWith(Boolean.FALSE);
                return;
            }
            cancellableContinuationImpl0.resumeWith(n.t(throwable0));
        }
    }

    private volatile Object _closeCause$volatile;
    private static final AtomicReferenceFieldUpdater _closeCause$volatile$FU;
    private volatile long bufferEnd$volatile;
    private static final AtomicLongFieldUpdater bufferEnd$volatile$FU;
    private volatile Object bufferEndSegment$volatile;
    private static final AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU;
    private final int capacity;
    private volatile Object closeHandler$volatile;
    private static final AtomicReferenceFieldUpdater closeHandler$volatile$FU;
    private volatile long completedExpandBuffersAndPauseFlag$volatile;
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU;
    @Nullable
    public final k onUndeliveredElement;
    @Nullable
    private final o onUndeliveredElementReceiveCancellationConstructor;
    private volatile Object receiveSegment$volatile;
    private static final AtomicReferenceFieldUpdater receiveSegment$volatile$FU;
    private volatile long receivers$volatile;
    private static final AtomicLongFieldUpdater receivers$volatile$FU;
    private volatile Object sendSegment$volatile;
    private static final AtomicReferenceFieldUpdater sendSegment$volatile$FU;
    private volatile long sendersAndCloseStatus$volatile;
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU;

    static {
        BufferedChannel.sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
        BufferedChannel.receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
        BufferedChannel.bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
        BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
        BufferedChannel.sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
        BufferedChannel.receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
        BufferedChannel.bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
        BufferedChannel._closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
        BufferedChannel.closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    }

    public BufferedChannel(int v, @Nullable k k0) {
        this.capacity = v;
        this.onUndeliveredElement = k0;
        if(v < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + v + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.access$initialBufferEnd(v);
        this.completedExpandBuffersAndPauseFlag$volatile = this.getBufferEndCounter();
        ChannelSegment channelSegment0 = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment0;
        this.receiveSegment$volatile = channelSegment0;
        if(this.isRendezvousOrUnlimited()) {
            channelSegment0 = BufferedChannelKt.access$getNULL_SEGMENT$p();
            q.e(channelSegment0, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = channelSegment0;
        this.onUndeliveredElementReceiveCancellationConstructor = k0 == null ? null : new e(this, 15);
        this._closeCause$volatile = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
    }

    public static H a(Object object0, BufferedChannel bufferedChannel0, SelectInstance selectInstance0, Throwable throwable0, Object object1, i i0) {
        return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(object0, bufferedChannel0, selectInstance0, throwable0, object1, i0);
    }

    public static o b(BufferedChannel bufferedChannel0, SelectInstance selectInstance0, Object object0, Object object1) {
        return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(bufferedChannel0, selectInstance0, object0, object1);
    }

    private final g bindCancellationFun(k k0) {
        return new o() {
            {
                super(3, 0, BufferedChannel.class, object0, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V");
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                this.invoke(((Throwable)object0), object1, ((i)object2));
                return H.a;
            }

            public final void invoke(Throwable throwable0, Object object0, i i0) {
                ((BufferedChannel)this.receiver).onCancellationImplDoNotCall(throwable0, object0, i0);
            }
        };
    }

    private final o bindCancellationFun(k k0, Object object0) {
        return new a4(5, k0, object0);
    }

    private static final H bindCancellationFun$lambda$89(k k0, Object object0, Throwable throwable0, Object object1, i i0) {
        OnUndeliveredElementKt.callUndeliveredElement(k0, object0, i0);
        return H.a;
    }

    private final g bindCancellationFunResult(k k0) {
        return new o() {
            {
                super(3, 0, BufferedChannel.class, object0, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V");
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                this.invoke-5_sEAP8(((Throwable)object0), ((ChannelResult)object1).unbox-impl(), ((i)object2));
                return H.a;
            }

            public final void invoke-5_sEAP8(Throwable throwable0, Object object0, i i0) {
                ((BufferedChannel)this.receiver).onCancellationChannelResultImplDoNotCall-5_sEAP8(throwable0, object0, i0);
            }
        };
    }

    private final boolean bufferOrRendezvousSend(long v) {
        return v < this.getBufferEndCounter() || v < this.getReceiversCounter$kotlinx_coroutines_core() + ((long)this.capacity);
    }

    public static H c(k k0, Object object0, Throwable throwable0, Object object1, i i0) {
        return BufferedChannel.bindCancellationFun$lambda$89(k0, object0, throwable0, object1, i0);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cancellationException0) {
        this.cancelImpl$kotlinx_coroutines_core(cancellationException0);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable throwable0) {
        if(throwable0 == null) {
            throwable0 = new CancellationException("Channel was cancelled");
        }
        return this.closeOrCancelImpl(throwable0, true);
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment channelSegment0, long v) {
        Object object1;
        Object object0 = InlineList.constructor-impl$default(null, 1, null);
    alab1:
        while(channelSegment0 != null) {
            int v1 = BufferedChannelKt.SEGMENT_SIZE - 1;
            while(-1 < v1) {
                if(channelSegment0.id * ((long)BufferedChannelKt.SEGMENT_SIZE) + ((long)v1) < v) {
                    break alab1;
                }
            alab2:
                while(true) {
                    do {
                        do {
                            object1 = channelSegment0.getState$kotlinx_coroutines_core(v1);
                            if(object1 == null || object1 == BufferedChannelKt.IN_BUFFER) {
                                goto label_17;
                            }
                            if(!(object1 instanceof WaiterEB)) {
                                goto label_12;
                            }
                        }
                        while(!channelSegment0.casState$kotlinx_coroutines_core(v1, object1, BufferedChannelKt.getCHANNEL_CLOSED()));
                        object0 = InlineList.plus-FjFbRPM(object0, ((WaiterEB)object1).waiter);
                        channelSegment0.onCancelledRequest(v1, true);
                        break alab2;
                    label_12:
                        if(!(object1 instanceof Waiter)) {
                            break alab2;
                        }
                    }
                    while(!channelSegment0.casState$kotlinx_coroutines_core(v1, object1, BufferedChannelKt.getCHANNEL_CLOSED()));
                    object0 = InlineList.plus-FjFbRPM(object0, object1);
                    channelSegment0.onCancelledRequest(v1, true);
                    break;
                label_17:
                    if(channelSegment0.casState$kotlinx_coroutines_core(v1, object1, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        channelSegment0.onSlotCleaned();
                        break;
                    }
                }
                --v1;
            }
            channelSegment0 = (ChannelSegment)channelSegment0.getPrev();
        }
        if(object0 != null) {
            if(!(object0 instanceof ArrayList)) {
                this.resumeReceiverOnClosedChannel(((Waiter)object0));
                return;
            }
            for(int v2 = ((ArrayList)object0).size() - 1; -1 < v2; --v2) {
                this.resumeReceiverOnClosedChannel(((Waiter)((ArrayList)object0).get(v2)));
            }
        }
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable throwable0) {
        return this.closeOrCancelImpl(throwable0, false);
    }

    private final ChannelSegment closeLinkedList() {
        ChannelSegment channelSegment0 = BufferedChannel.getBufferEndSegment$volatile$FU().get(this);
        ChannelSegment channelSegment1 = (ChannelSegment)BufferedChannel.getSendSegment$volatile$FU().get(this);
        if(channelSegment1.id > channelSegment0.id) {
            channelSegment0 = channelSegment1;
        }
        ChannelSegment channelSegment2 = (ChannelSegment)BufferedChannel.getReceiveSegment$volatile$FU().get(this);
        if(channelSegment2.id > channelSegment0.id) {
            channelSegment0 = channelSegment2;
        }
        return (ChannelSegment)ConcurrentLinkedListKt.close(channelSegment0);
    }

    public boolean closeOrCancelImpl(@Nullable Throwable throwable0, boolean z) {
        boolean z1;
        if(z) {
            this.markCancellationStarted();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel._closeCause$volatile$FU;
        Symbol symbol0 = BufferedChannelKt.NO_CLOSE_CAUSE;
        while(true) {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, symbol0, throwable0)) {
                z1 = true;
                break;
            }
            if(atomicReferenceFieldUpdater0.get(this) != symbol0) {
                z1 = false;
                break;
            }
        }
        if(z) {
            this.markCancelled();
        }
        else {
            this.markClosed();
        }
        this.completeCloseOrCancel();
        if(z1) {
            this.invokeCloseHandler();
        }
        return z1;
    }

    private final void completeCancel(long v) {
        this.removeUnprocessedElements(this.completeClose(v));
    }

    private final ChannelSegment completeClose(long v) {
        ChannelSegment channelSegment0 = this.closeLinkedList();
        if(this.isConflatedDropOldest()) {
            long v1 = this.markAllEmptyCellsAsClosed(channelSegment0);
            if(v1 != -1L) {
                this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(v1);
            }
        }
        this.cancelSuspendedReceiveRequests(channelSegment0, v);
        return channelSegment0;
    }

    private final void completeCloseOrCancel() {
        this.isClosedForSend();
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long v) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this);
        while(true) {
            long v1 = BufferedChannel.receivers$volatile$FU.get(this);
            long v2 = this.getBufferEndCounter();
            if(v < Math.max(((long)this.capacity) + v1, v2)) {
                return;
            }
            if(BufferedChannel.receivers$volatile$FU.compareAndSet(this, v1, v1 + 1L)) {
                long v3 = v1 / ((long)BufferedChannelKt.SEGMENT_SIZE);
                int v4 = (int)(v1 % ((long)BufferedChannelKt.SEGMENT_SIZE));
                if(channelSegment0.id == v3) {
                    channelSegment2 = channelSegment0;
                }
                else {
                    ChannelSegment channelSegment1 = this.findSegmentReceive(v3, channelSegment0);
                    if(channelSegment1 == null) {
                        continue;
                    }
                    channelSegment2 = channelSegment1;
                }
                Object object0 = this.updateCellReceive(channelSegment2, v4, v1, null);
                if(object0 != BufferedChannelKt.FAILED) {
                    channelSegment2.cleanPrev();
                    k k0 = this.onUndeliveredElement;
                    if(k0 != null) {
                        UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(k0, object0, null, 2, null);
                        if(undeliveredElementException0 != null) {
                            throw undeliveredElementException0;
                        }
                    }
                }
                else if(v1 < this.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                channelSegment0 = channelSegment2;
            }
        }
    }

    private final void expandBuffer() {
        if(this.isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.getBufferEndSegment$volatile$FU().get(this);
        while(true) {
            long v = BufferedChannel.getBufferEnd$volatile$FU().getAndIncrement(this);
            int v1 = BufferedChannelKt.SEGMENT_SIZE;
            long v2 = v / ((long)v1);
            if(Long.compare(this.getSendersCounter$kotlinx_coroutines_core(), v) <= 0) {
                if(channelSegment0.id < v2 && channelSegment0.getNext() != null) {
                    this.moveSegmentBufferEndToSpecifiedOrLast(v2, channelSegment0);
                }
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if(channelSegment0.id != v2) {
                ChannelSegment channelSegment1 = this.findSegmentBufferEnd(v2, channelSegment0, v);
                if(channelSegment1 == null) {
                    continue;
                }
                channelSegment0 = channelSegment1;
            }
            if(this.updateCellExpandBuffer(channelSegment0, ((int)(v % ((long)v1))), v)) {
                BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment findSegmentBufferEnd(long v, ChannelSegment channelSegment0, long v1) {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel.bufferEndSegment$volatile$FU;
        we.n n0 = (we.n)BufferedChannelKt.createSegmentFunction();
    alab1:
        while(true) {
            object0 = ConcurrentLinkedListKt.findSegmentInternal(channelSegment0, v, n0);
            if(SegmentOrClosed.isClosed-impl(object0)) {
                break;
            }
            Segment segment0 = SegmentOrClosed.getSegment-impl(object0);
            while(true) {
                Segment segment1 = (Segment)atomicReferenceFieldUpdater0.get(this);
                if(segment1.id >= segment0.id) {
                    break alab1;
                }
                if(!segment0.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, segment1, segment0)) {
                        if(!segment1.decPointers$kotlinx_coroutines_core()) {
                            break alab1;
                        }
                        segment1.remove();
                        break alab1;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == segment1);
                if(segment0.decPointers$kotlinx_coroutines_core()) {
                    segment0.remove();
                }
            }
        }
        if(SegmentOrClosed.isClosed-impl(object0)) {
            this.completeCloseOrCancel();
            this.moveSegmentBufferEndToSpecifiedOrLast(v, channelSegment0);
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        Segment segment2 = SegmentOrClosed.getSegment-impl(object0);
        if(((ChannelSegment)segment2).id > v) {
            int v2 = BufferedChannelKt.SEGMENT_SIZE;
            if(BufferedChannel.bufferEnd$volatile$FU.compareAndSet(this, v1 + 1L, ((ChannelSegment)segment2).id * ((long)v2))) {
                this.incCompletedExpandBufferAttempts(((ChannelSegment)segment2).id * ((long)v2) - v1);
                return null;
            }
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        return (ChannelSegment)segment2;
    }

    private final ChannelSegment findSegmentReceive(long v, ChannelSegment channelSegment0) {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel.receiveSegment$volatile$FU;
        we.n n0 = (we.n)BufferedChannelKt.createSegmentFunction();
    alab1:
        while(true) {
            object0 = ConcurrentLinkedListKt.findSegmentInternal(channelSegment0, v, n0);
            if(SegmentOrClosed.isClosed-impl(object0)) {
                break;
            }
            Segment segment0 = SegmentOrClosed.getSegment-impl(object0);
            while(true) {
                Segment segment1 = (Segment)atomicReferenceFieldUpdater0.get(this);
                if(segment1.id >= segment0.id) {
                    break alab1;
                }
                if(!segment0.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, segment1, segment0)) {
                        if(!segment1.decPointers$kotlinx_coroutines_core()) {
                            break alab1;
                        }
                        segment1.remove();
                        break alab1;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == segment1);
                if(segment0.decPointers$kotlinx_coroutines_core()) {
                    segment0.remove();
                }
            }
        }
        if(SegmentOrClosed.isClosed-impl(object0)) {
            this.completeCloseOrCancel();
            long v1 = this.getSendersCounter$kotlinx_coroutines_core();
            if(channelSegment0.id * ((long)BufferedChannelKt.SEGMENT_SIZE) < v1) {
                channelSegment0.cleanPrev();
            }
            return null;
        }
        ChannelSegment channelSegment1 = (ChannelSegment)SegmentOrClosed.getSegment-impl(object0);
        if(!this.isRendezvousOrUnlimited() && v <= this.getBufferEndCounter() / ((long)BufferedChannelKt.SEGMENT_SIZE)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = BufferedChannel.bufferEndSegment$volatile$FU;
            while(true) {
                Segment segment2 = (Segment)atomicReferenceFieldUpdater1.get(this);
                if(segment2.id >= channelSegment1.id || !channelSegment1.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
            label_28:
                if(atomicReferenceFieldUpdater1.compareAndSet(this, segment2, channelSegment1)) {
                    if(!segment2.decPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    segment2.remove();
                    break;
                }
                if(atomicReferenceFieldUpdater1.get(this) != segment2) {
                    if(!channelSegment1.decPointers$kotlinx_coroutines_core()) {
                        continue;
                    }
                    channelSegment1.remove();
                    continue;
                }
                if(false) {
                    break;
                }
                goto label_28;
            }
        }
        long v2 = channelSegment1.id;
        if(v2 > v) {
            this.updateReceiversCounterIfLower(v2 * ((long)BufferedChannelKt.SEGMENT_SIZE));
            long v3 = this.getSendersCounter$kotlinx_coroutines_core();
            if(channelSegment1.id * ((long)BufferedChannelKt.SEGMENT_SIZE) < v3) {
                channelSegment1.cleanPrev();
            }
            return null;
        }
        return channelSegment1;
    }

    private final ChannelSegment findSegmentSend(long v, ChannelSegment channelSegment0) {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel.sendSegment$volatile$FU;
        we.n n0 = (we.n)BufferedChannelKt.createSegmentFunction();
    alab1:
        while(true) {
            object0 = ConcurrentLinkedListKt.findSegmentInternal(channelSegment0, v, n0);
            if(SegmentOrClosed.isClosed-impl(object0)) {
                break;
            }
            Segment segment0 = SegmentOrClosed.getSegment-impl(object0);
            while(true) {
                Segment segment1 = (Segment)atomicReferenceFieldUpdater0.get(this);
                if(segment1.id >= segment0.id) {
                    break alab1;
                }
                if(!segment0.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, segment1, segment0)) {
                        if(!segment1.decPointers$kotlinx_coroutines_core()) {
                            break alab1;
                        }
                        segment1.remove();
                        break alab1;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == segment1);
                if(segment0.decPointers$kotlinx_coroutines_core()) {
                    segment0.remove();
                }
            }
        }
        if(SegmentOrClosed.isClosed-impl(object0)) {
            this.completeCloseOrCancel();
            long v1 = this.getReceiversCounter$kotlinx_coroutines_core();
            if(channelSegment0.id * ((long)BufferedChannelKt.SEGMENT_SIZE) < v1) {
                channelSegment0.cleanPrev();
            }
            return null;
        }
        ChannelSegment channelSegment1 = (ChannelSegment)SegmentOrClosed.getSegment-impl(object0);
        long v2 = channelSegment1.id;
        if(v2 > v) {
            this.updateSendersCounterIfLower(v2 * ((long)BufferedChannelKt.SEGMENT_SIZE));
            long v3 = this.getReceiversCounter$kotlinx_coroutines_core();
            if(channelSegment1.id * ((long)BufferedChannelKt.SEGMENT_SIZE) < v3) {
                channelSegment1.cleanPrev();
            }
            return null;
        }
        return channelSegment1;
    }

    private final long getBufferEndCounter() {
        return BufferedChannel.bufferEnd$volatile$FU.get(this);
    }

    @Nullable
    public final Throwable getCloseCause() {
        return (Throwable)BufferedChannel._closeCause$volatile$FU.get(this);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1 getOnReceive() {
        q.e(kotlinx.coroutines.channels.BufferedChannel.onReceive.1.INSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        N.e(3, kotlinx.coroutines.channels.BufferedChannel.onReceive.1.INSTANCE);
        q.e(kotlinx.coroutines.channels.BufferedChannel.onReceive.2.INSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        N.e(3, kotlinx.coroutines.channels.BufferedChannel.onReceive.2.INSTANCE);
        return new SelectClause1Impl(this, kotlinx.coroutines.channels.BufferedChannel.onReceive.1.INSTANCE, kotlinx.coroutines.channels.BufferedChannel.onReceive.2.INSTANCE, this.onUndeliveredElementReceiveCancellationConstructor);

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.channels.BufferedChannel.onReceive.1 extends kotlin.jvm.internal.n implements o {
            public static final kotlinx.coroutines.channels.BufferedChannel.onReceive.1 INSTANCE;

            static {
                kotlinx.coroutines.channels.BufferedChannel.onReceive.1.INSTANCE = new kotlinx.coroutines.channels.BufferedChannel.onReceive.1();
            }

            public kotlinx.coroutines.channels.BufferedChannel.onReceive.1() {
                super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                this.invoke(((BufferedChannel)object0), ((SelectInstance)object1), object2);
                return H.a;
            }

            public final void invoke(BufferedChannel bufferedChannel0, SelectInstance selectInstance0, Object object0) {
                bufferedChannel0.registerSelectForReceive(selectInstance0, object0);
            }
        }


        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.channels.BufferedChannel.onReceive.2 extends kotlin.jvm.internal.n implements o {
            public static final kotlinx.coroutines.channels.BufferedChannel.onReceive.2 INSTANCE;

            static {
                kotlinx.coroutines.channels.BufferedChannel.onReceive.2.INSTANCE = new kotlinx.coroutines.channels.BufferedChannel.onReceive.2();
            }

            public kotlinx.coroutines.channels.BufferedChannel.onReceive.2() {
                super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((BufferedChannel)object0), object1, object2);
            }

            public final Object invoke(BufferedChannel bufferedChannel0, Object object0, Object object1) {
                return bufferedChannel0.processResultSelectReceive(object0, object1);
            }
        }

    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1 getOnReceiveCatching() {
        q.e(kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1.INSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        N.e(3, kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1.INSTANCE);
        q.e(kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2.INSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        N.e(3, kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2.INSTANCE);
        return new SelectClause1Impl(this, kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1.INSTANCE, kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2.INSTANCE, this.onUndeliveredElementReceiveCancellationConstructor);

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1 extends kotlin.jvm.internal.n implements o {
            public static final kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1 INSTANCE;

            static {
                kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1.INSTANCE = new kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1();
            }

            public kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1() {
                super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                this.invoke(((BufferedChannel)object0), ((SelectInstance)object1), object2);
                return H.a;
            }

            public final void invoke(BufferedChannel bufferedChannel0, SelectInstance selectInstance0, Object object0) {
                bufferedChannel0.registerSelectForReceive(selectInstance0, object0);
            }
        }


        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2 extends kotlin.jvm.internal.n implements o {
            public static final kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2 INSTANCE;

            static {
                kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2.INSTANCE = new kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2();
            }

            public kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2() {
                super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((BufferedChannel)object0), object1, object2);
            }

            public final Object invoke(BufferedChannel bufferedChannel0, Object object0, Object object1) {
                return bufferedChannel0.processResultSelectReceiveCatching(object0, object1);
            }
        }

    }

    private final Throwable getReceiveException() {
        Throwable throwable0 = this.getCloseCause();
        return throwable0 == null ? new ClosedReceiveChannelException("Channel was closed") : throwable0;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return BufferedChannel.receivers$volatile$FU.get(this);
    }

    @NotNull
    public final Throwable getSendException() {
        Throwable throwable0 = this.getCloseCause();
        return throwable0 == null ? new ClosedSendChannelException("Channel was closed") : throwable0;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this) & 0xFFFFFFFFFFFFFFFL;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while(true) {
            ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this);
            long v = this.getReceiversCounter$kotlinx_coroutines_core();
            if(Long.compare(this.getSendersCounter$kotlinx_coroutines_core(), v) <= 0) {
                return false;
            }
            int v1 = BufferedChannelKt.SEGMENT_SIZE;
            long v2 = v / ((long)v1);
            if(channelSegment0.id != v2) {
                ChannelSegment channelSegment1 = this.findSegmentReceive(v2, channelSegment0);
                if(channelSegment1 == null) {
                    if(((ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this)).id >= v2) {
                        continue;
                    }
                    return false;
                }
                else {
                    channelSegment0 = channelSegment1;
                }
            }
            channelSegment0.cleanPrev();
            if(this.isCellNonEmpty(channelSegment0, ((int)(v % ((long)v1))), v)) {
                return true;
            }
            BufferedChannel.receivers$volatile$FU.compareAndSet(this, v, v + 1L);
        }
    }

    private final void incCompletedExpandBufferAttempts(long v) {
        if((BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, v) & 0x4000000000000000L) != 0L) {
            while((BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & 0x4000000000000000L) != 0L) {
            }
        }
    }

    public static void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel0, long v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if((v1 & 1) != 0) {
            v = 1L;
        }
        bufferedChannel0.incCompletedExpandBufferAttempts(v);
    }

    private final void invokeCloseHandler() {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel.closeHandler$volatile$FU;
        while(true) {
            object0 = atomicReferenceFieldUpdater0.get(this);
            Symbol symbol0 = object0 == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED;
        label_3:
            if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, symbol0)) {
                break;
            }
            if(atomicReferenceFieldUpdater0.get(this) != object0) {
                continue;
            }
            if(false) {
                break;
            }
            goto label_3;
        }
        if(object0 == null) {
            return;
        }
        N.e(1, object0);
        ((k)object0).invoke(this.getCloseCause());
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull k k0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel.closeHandler$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, null, k0)) {
                return;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = BufferedChannel.closeHandler$volatile$FU;
        Object object0;
        while((object0 = atomicReferenceFieldUpdater1.get(this)) == BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = BufferedChannel.closeHandler$volatile$FU;
            Symbol symbol0 = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            Symbol symbol1 = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
            do {
                if(atomicReferenceFieldUpdater2.compareAndSet(this, symbol0, symbol1)) {
                    k0.invoke(this.getCloseCause());
                    return;
                }
            }
            while(atomicReferenceFieldUpdater2.get(this) == symbol0);
        }
        throw object0 == BufferedChannelKt.CLOSE_HANDLER_INVOKED ? new IllegalStateException("Another handler was already registered and successfully invoked") : new IllegalStateException(("Another handler is already registered: " + object0).toString());
    }

    private final boolean isCellNonEmpty(ChannelSegment channelSegment0, int v, long v1) {
        do {
            Object object0 = channelSegment0.getState$kotlinx_coroutines_core(v);
            if(object0 != null && object0 != BufferedChannelKt.IN_BUFFER) {
                if(object0 == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if(object0 == BufferedChannelKt.INTERRUPTED_SEND) {
                    return false;
                }
                if(object0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return false;
                }
                if(object0 == BufferedChannelKt.DONE_RCV) {
                    return false;
                }
                if(object0 == BufferedChannelKt.POISONED) {
                    return false;
                }
                if(object0 == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                return object0 == BufferedChannelKt.RESUMING_BY_RCV ? false : v1 == this.getReceiversCounter$kotlinx_coroutines_core();
            }
        }
        while(!channelSegment0.casState$kotlinx_coroutines_core(v, object0, BufferedChannelKt.POISONED));
        this.expandBuffer();
        return false;
    }

    private final boolean isClosed(long v, boolean z) {
        switch(((int)(v >> 60))) {
            case 0: 
            case 1: {
                return false;
            }
            case 2: {
                this.completeClose(v & 0xFFFFFFFFFFFFFFFL);
                return !z || !this.hasElements$kotlinx_coroutines_core();
            }
            case 3: {
                this.completeCancel(v & 0xFFFFFFFFFFFFFFFL);
                return true;
            }
            default: {
                throw new IllegalStateException(("unexpected close status: " + ((int)(v >> 60))).toString());
            }
        }
    }

    public boolean isClosedForReceive() {
        return this.isClosedForReceive0(BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean isClosedForReceive0(long v) {
        return this.isClosed(v, true);
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.isClosedForSend0(BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this));
    }

    private final boolean isClosedForSend0(long v) {
        return this.isClosed(v, false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    private final boolean isRendezvousOrUnlimited() {
        long v = this.getBufferEndCounter();
        return v == 0L || v == 0x7FFFFFFFFFFFFFFFL;
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator iterator() {
        return new BufferedChannelIterator(this);
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment channelSegment0) {
        do {
            for(int v = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < v; --v) {
                long v1 = channelSegment0.id * ((long)BufferedChannelKt.SEGMENT_SIZE) + ((long)v);
                if(v1 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                while(true) {
                    Object object0 = channelSegment0.getState$kotlinx_coroutines_core(v);
                    if(object0 != null && object0 != BufferedChannelKt.IN_BUFFER) {
                        if(object0 != BufferedChannelKt.BUFFERED) {
                            break;
                        }
                        return v1;
                    }
                    if(channelSegment0.casState$kotlinx_coroutines_core(v, object0, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        channelSegment0.onSlotCleaned();
                        break;
                    }
                }
            }
            channelSegment0 = (ChannelSegment)channelSegment0.getPrev();
        }
        while(channelSegment0 != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = BufferedChannel.sendersAndCloseStatus$volatile$FU;
        do {
            long v = atomicLongFieldUpdater0.get(this);
        }
        while(((int)(v >> 60)) == 0 && !atomicLongFieldUpdater0.compareAndSet(this, v, BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v, 1)));
    }

    private final void markCancelled() {
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = BufferedChannel.sendersAndCloseStatus$volatile$FU;
        do {
            long v = atomicLongFieldUpdater0.get(this);
        }
        while(!atomicLongFieldUpdater0.compareAndSet(this, v, BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v, 3)));
    }

    private final void markClosed() {
        long v1;
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = BufferedChannel.sendersAndCloseStatus$volatile$FU;
        do {
            long v = atomicLongFieldUpdater0.get(this);
            switch(((int)(v >> 60))) {
                case 0: {
                    v1 = BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v, 2);
                    break;
                }
                case 1: {
                    v1 = BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v, 3);
                    break;
                }
                default: {
                    return;
                }
            }
        }
        while(!atomicLongFieldUpdater0.compareAndSet(this, v, v1));
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long v, ChannelSegment channelSegment0) {
        Segment segment0;
        while(channelSegment0.id < v) {
            ChannelSegment channelSegment1 = (ChannelSegment)channelSegment0.getNext();
            if(channelSegment1 == null) {
                break;
            }
            channelSegment0 = channelSegment1;
        }
        while(true) {
            if(channelSegment0.isRemoved()) {
                ChannelSegment channelSegment2 = (ChannelSegment)channelSegment0.getNext();
                if(channelSegment2 != null) {
                    channelSegment0 = channelSegment2;
                    continue;
                }
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = BufferedChannel.bufferEndSegment$volatile$FU;
        label_11:
            segment0 = (Segment)atomicReferenceFieldUpdater0.get(this);
            if(segment0.id >= channelSegment0.id) {
                return;
            }
            if(channelSegment0.tryIncPointers$kotlinx_coroutines_core()) {
                break;
            }
        }
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, segment0, channelSegment0)) {
                if(segment0.decPointers$kotlinx_coroutines_core()) {
                    segment0.remove();
                }
                return;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == segment0);
        if(!channelSegment0.decPointers$kotlinx_coroutines_core()) {
            goto label_11;
        }
        channelSegment0.remove();
        goto label_11;
    }

    private final void onCancellationChannelResultImplDoNotCall-5_sEAP8(Throwable throwable0, Object object0, i i0) {
        q.d(this.onUndeliveredElement);
        Object object1 = ChannelResult.getOrNull-impl(object0);
        q.d(object1);
        OnUndeliveredElementKt.callUndeliveredElement(this.onUndeliveredElement, object1, i0);
    }

    private final void onCancellationImplDoNotCall(Throwable throwable0, Object object0, i i0) {
        q.d(this.onUndeliveredElement);
        OnUndeliveredElementKt.callUndeliveredElement(this.onUndeliveredElement, object0, i0);
    }

    public void onClosedIdempotent() {
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation cancellableContinuation0) {
        Throwable throwable0 = this.getCloseCause();
        cancellableContinuation0.resumeWith(ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(throwable0)));
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation cancellableContinuation0) {
        cancellableContinuation0.resumeWith(n.t(this.getReceiveException()));
    }

    private final void onClosedSelectOnReceive(SelectInstance selectInstance0) {
        selectInstance0.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(Object object0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        k k0 = this.onUndeliveredElement;
        if(k0 == null) {
            cancellableContinuationImpl0.resumeWith(n.t(this.getSendException()));
        }
        else {
            UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(k0, object0, null, 2, null);
            if(undeliveredElementException0 == null) {
                cancellableContinuationImpl0.resumeWith(n.t(this.getSendException()));
            }
            else {
                a.q(undeliveredElementException0, this.getSendException());
                cancellableContinuationImpl0.resumeWith(n.t(undeliveredElementException0));
            }
        }
        Object object1 = cancellableContinuationImpl0.getResult();
        return object1 == ne.a.a ? object1 : H.a;
    }

    private final void onClosedSendOnNoWaiterSuspend(Object object0, CancellableContinuation cancellableContinuation0) {
        k k0 = this.onUndeliveredElement;
        if(k0 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(k0, object0, cancellableContinuation0.getContext());
        }
        cancellableContinuation0.resumeWith(n.t(this.getSendException()));
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    private static final o onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56(BufferedChannel bufferedChannel0, SelectInstance selectInstance0, Object object0, Object object1) {
        return new i2(object1, bufferedChannel0, selectInstance0, 4);
    }

    private static final H onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(Object object0, BufferedChannel bufferedChannel0, SelectInstance selectInstance0, Throwable throwable0, Object object1, i i0) {
        if(object0 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            i i1 = selectInstance0.getContext();
            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel0.onUndeliveredElement, object0, i1);
        }
        return H.a;
    }

    private final void prepareReceiverForSuspension(Waiter waiter0, ChannelSegment channelSegment0, int v) {
        waiter0.invokeOnCancellation(channelSegment0, v);
    }

    private final void prepareSenderForSuspension(Waiter waiter0, ChannelSegment channelSegment0, int v) {
        waiter0.invokeOnCancellation(channelSegment0, v + BufferedChannelKt.SEGMENT_SIZE);
    }

    private final Object processResultSelectReceive(Object object0, Object object1) {
        if(object1 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            throw this.getReceiveException();
        }
        return object1;
    }

    private final Object processResultSelectReceiveCatching(Object object0, Object object1) {
        if(object1 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            Throwable throwable0 = this.getCloseCause();
            return ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(throwable0));
        }
        return ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(object1));
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation continuation0) {
        return BufferedChannel.receive$suspendImpl(this, continuation0);
    }

    public static Object receive$suspendImpl(BufferedChannel bufferedChannel0, Continuation continuation0) {
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel0);
        while(!bufferedChannel0.isClosedForReceive()) {
            long v = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel0);
            long v1 = v / ((long)BufferedChannelKt.SEGMENT_SIZE);
            int v2 = (int)(v % ((long)BufferedChannelKt.SEGMENT_SIZE));
            if(channelSegment0.id == v1) {
                channelSegment2 = channelSegment0;
            }
            else {
                ChannelSegment channelSegment1 = bufferedChannel0.findSegmentReceive(v1, channelSegment0);
                if(channelSegment1 == null) {
                    continue;
                }
                channelSegment2 = channelSegment1;
            }
            Object object0 = bufferedChannel0.updateCellReceive(channelSegment2, v2, v, null);
            if(object0 == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if(object0 == BufferedChannelKt.FAILED) {
                if(v < bufferedChannel0.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment2.cleanPrev();
                }
                channelSegment0 = channelSegment2;
                continue;
            }
            if(object0 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return bufferedChannel0.receiveOnNoWaiterSuspend(channelSegment2, v2, v, continuation0);
            }
            channelSegment2.cleanPrev();
            return object0;
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel0.getReceiveException());
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receiveCatching-JP2dKIU(@NotNull Continuation continuation0) {
        return BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this, continuation0);
    }

    public static Object receiveCatching-JP2dKIU$suspendImpl(BufferedChannel bufferedChannel0, Continuation continuation0) {
        ChannelSegment channelSegment2;
        kotlinx.coroutines.channels.BufferedChannel.receiveCatching.1 bufferedChannel$receiveCatching$10;
        if(continuation0 instanceof kotlinx.coroutines.channels.BufferedChannel.receiveCatching.1) {
            bufferedChannel$receiveCatching$10 = (kotlinx.coroutines.channels.BufferedChannel.receiveCatching.1)continuation0;
            int v = bufferedChannel$receiveCatching$10.label;
            if((v & 0x80000000) == 0) {
                bufferedChannel$receiveCatching$10 = new c(continuation0) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        Object object1 = BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(bufferedChannel0, this);
                        return object1 == ne.a.a ? object1 : ChannelResult.box-impl(object1);
                    }
                };
            }
            else {
                bufferedChannel$receiveCatching$10.label = v ^ 0x80000000;
            }
        }
        else {
            bufferedChannel$receiveCatching$10 = new c(continuation0) {
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    Object object1 = BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(bufferedChannel0, this);
                    return object1 == ne.a.a ? object1 : ChannelResult.box-impl(object1);
                }
            };
        }
        Object object0 = bufferedChannel$receiveCatching$10.result;
        ne.a a0 = ne.a.a;
        switch(bufferedChannel$receiveCatching$10.label) {
            case 0: {
                n.D(object0);
                ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(bufferedChannel0);
                while(true) {
                    if(bufferedChannel0.isClosedForReceive()) {
                        Throwable throwable0 = bufferedChannel0.getCloseCause();
                        return ChannelResult.Companion.closed-JP2dKIU(throwable0);
                    }
                    long v1 = BufferedChannel.receivers$volatile$FU.getAndIncrement(bufferedChannel0);
                    long v2 = v1 / ((long)BufferedChannelKt.SEGMENT_SIZE);
                    int v3 = (int)(v1 % ((long)BufferedChannelKt.SEGMENT_SIZE));
                    if(channelSegment0.id == v2) {
                        channelSegment2 = channelSegment0;
                    }
                    else {
                        ChannelSegment channelSegment1 = bufferedChannel0.findSegmentReceive(v2, channelSegment0);
                        if(channelSegment1 == null) {
                            continue;
                        }
                        channelSegment2 = channelSegment1;
                    }
                    Object object1 = bufferedChannel0.updateCellReceive(channelSegment2, v3, v1, null);
                    if(object1 == BufferedChannelKt.SUSPEND) {
                        break;
                    }
                    if(object1 == BufferedChannelKt.FAILED) {
                        if(v1 < bufferedChannel0.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment2.cleanPrev();
                        }
                        channelSegment0 = channelSegment2;
                        continue;
                    }
                    if(object1 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                        bufferedChannel$receiveCatching$10.label = 1;
                        Object object2 = bufferedChannel0.receiveCatchingOnNoWaiterSuspend-GKJJFZk(channelSegment2, v3, v1, bufferedChannel$receiveCatching$10);
                        return object2 == a0 ? a0 : object2;
                    }
                    channelSegment2.cleanPrev();
                    return ChannelResult.Companion.success-JP2dKIU(object1);
                }
                throw new IllegalStateException("unexpected");
            }
            case 1: {
                n.D(object0);
                return ((ChannelResult)object0).unbox-impl();
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object receiveCatchingOnNoWaiterSuspend-GKJJFZk(ChannelSegment channelSegment0, int v, long v1, Continuation continuation0) {
        o o0;
        ChannelResult channelResult0;
        ChannelSegment channelSegment3;
        kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend.1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$10;
        if(continuation0 instanceof kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend.1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$10 = (kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend.1)continuation0;
            int v2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.label;
            if((v2 & 0x80000000) == 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    long J$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        Object object1 = continuation0.receiveCatchingOnNoWaiterSuspend-GKJJFZk(null, 0, 0L, this);
                        return object1 == ne.a.a ? object1 : ChannelResult.box-impl(object1);
                    }
                };
            }
            else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.label = v2 ^ 0x80000000;
            }
        }
        else {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                long J$0;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    Object object1 = continuation0.receiveCatchingOnNoWaiterSuspend-GKJJFZk(null, 0, 0L, this);
                    return object1 == ne.a.a ? object1 : ChannelResult.box-impl(object1);
                }
            };
        }
        Object object0 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.result;
        ne.a a0 = ne.a.a;
        switch(bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.label) {
            case 0: {
                n.D(object0);
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.L$0 = this;
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.L$1 = channelSegment0;
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.I$0 = v;
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.J$0 = v1;
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(u.D(bufferedChannel$receiveCatchingOnNoWaiterSuspend$10));
                try {
                    q.e(cancellableContinuationImpl0, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel>>");
                    ReceiveCatching receiveCatching0 = new ReceiveCatching(cancellableContinuationImpl0);
                    g g0 = null;
                    Object object1 = this.updateCellReceive(channelSegment0, v, v1, receiveCatching0);
                    if(object1 == BufferedChannelKt.SUSPEND) {
                        this.prepareReceiverForSuspension(receiveCatching0, channelSegment0, v);
                    }
                    else {
                        if(object1 == BufferedChannelKt.FAILED) {
                            if(v1 < this.getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment0.cleanPrev();
                            }
                            ChannelSegment channelSegment1 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this);
                            while(!this.isClosedForReceive()) {
                                long v3 = BufferedChannel.receivers$volatile$FU.getAndIncrement(this);
                                long v4 = v3 / ((long)BufferedChannelKt.SEGMENT_SIZE);
                                int v5 = (int)(v3 % ((long)BufferedChannelKt.SEGMENT_SIZE));
                                if(channelSegment1.id == v4) {
                                    channelSegment3 = channelSegment1;
                                }
                                else {
                                    ChannelSegment channelSegment2 = this.findSegmentReceive(v4, channelSegment1);
                                    if(channelSegment2 == null) {
                                        continue;
                                    }
                                    channelSegment3 = channelSegment2;
                                }
                                Object object2 = this.updateCellReceive(channelSegment3, v5, v3, receiveCatching0);
                                if(object2 != BufferedChannelKt.SUSPEND) {
                                    if(object2 == BufferedChannelKt.FAILED) {
                                        if(v3 < this.getSendersCounter$kotlinx_coroutines_core()) {
                                            channelSegment3.cleanPrev();
                                        }
                                        channelSegment1 = channelSegment3;
                                        continue;
                                    }
                                    if(object2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    channelSegment3.cleanPrev();
                                    channelResult0 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(object2));
                                    k k0 = this.onUndeliveredElement;
                                    if(k0 != null) {
                                        g0 = this.bindCancellationFunResult(k0);
                                    }
                                    o0 = (o)g0;
                                    cancellableContinuationImpl0.resume(channelResult0, o0);
                                    object0 = cancellableContinuationImpl0.getResult();
                                    return object0 == a0 ? a0 : ((ChannelResult)object0).unbox-impl();
                                }
                                this.prepareReceiverForSuspension(receiveCatching0, channelSegment3, v5);
                                object0 = cancellableContinuationImpl0.getResult();
                                return object0 == a0 ? a0 : ((ChannelResult)object0).unbox-impl();
                            }
                            this.onClosedReceiveCatchingOnNoWaiterSuspend(cancellableContinuationImpl0);
                            object0 = cancellableContinuationImpl0.getResult();
                            return object0 == a0 ? a0 : ((ChannelResult)object0).unbox-impl();
                        }
                        else {
                            channelSegment0.cleanPrev();
                            channelResult0 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(object1));
                            k k1 = this.onUndeliveredElement;
                            if(k1 != null) {
                                g0 = this.bindCancellationFunResult(k1);
                            }
                            o0 = (o)g0;
                        }
                        cancellableContinuationImpl0.resume(channelResult0, o0);
                    }
                }
                catch(Throwable throwable0) {
                    cancellableContinuationImpl0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                    throw throwable0;
                }
                object0 = cancellableContinuationImpl0.getResult();
                return object0 == a0 ? a0 : ((ChannelResult)object0).unbox-impl();
            }
            case 1: {
                ChannelSegment channelSegment4 = (ChannelSegment)bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.L$1;
                BufferedChannel bufferedChannel0 = (BufferedChannel)bufferedChannel$receiveCatchingOnNoWaiterSuspend$10.L$0;
                n.D(object0);
                return ((ChannelResult)object0).unbox-impl();
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object receiveOnNoWaiterSuspend(ChannelSegment channelSegment0, int v, long v1, Continuation continuation0) {
        ChannelSegment channelSegment3;
        int v4;
        o o0;
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(u.D(continuation0));
        try {
            g g0 = null;
            Object object0 = this.updateCellReceive(channelSegment0, v, v1, cancellableContinuationImpl0);
            if(object0 == BufferedChannelKt.SUSPEND) {
                this.prepareReceiverForSuspension(cancellableContinuationImpl0, channelSegment0, v);
                return cancellableContinuationImpl0.getResult();
            }
            if(object0 != BufferedChannelKt.FAILED) {
                channelSegment0.cleanPrev();
                k k0 = this.onUndeliveredElement;
                if(k0 != null) {
                    g0 = this.bindCancellationFun(k0);
                }
                o0 = (o)g0;
                cancellableContinuationImpl0.resume(object0, o0);
                return cancellableContinuationImpl0.getResult();
            }
            if(v1 < this.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment0.cleanPrev();
            }
            ChannelSegment channelSegment1 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this);
            while(true) {
                if(this.isClosedForReceive()) {
                    this.onClosedReceiveOnNoWaiterSuspend(cancellableContinuationImpl0);
                    return cancellableContinuationImpl0.getResult();
                }
                long v2 = BufferedChannel.receivers$volatile$FU.getAndIncrement(this);
                long v3 = v2 / ((long)BufferedChannelKt.SEGMENT_SIZE);
                v4 = (int)(v2 % ((long)BufferedChannelKt.SEGMENT_SIZE));
                if(channelSegment1.id == v3) {
                    channelSegment3 = channelSegment1;
                }
                else {
                    ChannelSegment channelSegment2 = this.findSegmentReceive(v3, channelSegment1);
                    if(channelSegment2 == null) {
                        continue;
                    }
                    channelSegment3 = channelSegment2;
                }
                object0 = this.updateCellReceive(channelSegment3, v4, v2, cancellableContinuationImpl0);
                if(object0 == BufferedChannelKt.SUSPEND) {
                    break;
                }
                if(object0 != BufferedChannelKt.FAILED) {
                    if(object0 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                        throw new IllegalStateException("unexpected");
                    }
                    channelSegment3.cleanPrev();
                    k k1 = this.onUndeliveredElement;
                    if(k1 != null) {
                        g0 = this.bindCancellationFun(k1);
                    }
                    o0 = (o)g0;
                    cancellableContinuationImpl0.resume(object0, o0);
                    return cancellableContinuationImpl0.getResult();
                }
                if(v2 < this.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment3.cleanPrev();
                }
                channelSegment1 = channelSegment3;
            }
            if(cancellableContinuationImpl0 != null) {
                g0 = cancellableContinuationImpl0;
            }
            if(g0 != null) {
                this.prepareReceiverForSuspension(((Waiter)g0), channelSegment3, v4);
                return cancellableContinuationImpl0.getResult();
            }
        }
        catch(Throwable throwable0) {
            cancellableContinuationImpl0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw throwable0;
        }
        return cancellableContinuationImpl0.getResult();
    }

    private final void registerSelectForReceive(SelectInstance selectInstance0, Object object0) {
        Object object1;
        ChannelSegment channelSegment2;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this);
        while(true) {
            if(this.isClosedForReceive()) {
                this.onClosedSelectOnReceive(selectInstance0);
                return;
            }
            long v = BufferedChannel.receivers$volatile$FU.getAndIncrement(this);
            long v1 = v / ((long)BufferedChannelKt.SEGMENT_SIZE);
            int v2 = (int)(v % ((long)BufferedChannelKt.SEGMENT_SIZE));
            if(channelSegment0.id == v1) {
                channelSegment2 = channelSegment0;
            }
            else {
                ChannelSegment channelSegment1 = this.findSegmentReceive(v1, channelSegment0);
                if(channelSegment1 == null) {
                    continue;
                }
                channelSegment2 = channelSegment1;
            }
            object1 = this.updateCellReceive(channelSegment2, v2, v, selectInstance0);
            channelSegment0 = channelSegment2;
            if(object1 == BufferedChannelKt.SUSPEND) {
                Waiter waiter0 = selectInstance0 instanceof Waiter ? ((Waiter)selectInstance0) : null;
                if(waiter0 != null) {
                    this.prepareReceiverForSuspension(waiter0, channelSegment0, v2);
                }
                return;
            }
            if(object1 != BufferedChannelKt.FAILED) {
                break;
            }
            if(v < this.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment0.cleanPrev();
            }
        }
        if(object1 == BufferedChannelKt.SUSPEND_NO_WAITER) {
            throw new IllegalStateException("unexpected");
        }
        channelSegment0.cleanPrev();
        selectInstance0.selectInRegistrationPhase(object1);
    }

    private final void removeUnprocessedElements(ChannelSegment channelSegment0) {
        Waiter waiter0;
        Object object1;
        k k0 = this.onUndeliveredElement;
        Throwable throwable0 = null;
        Object object0 = InlineList.constructor-impl$default(null, 1, null);
    alab1:
        do {
            int v = BufferedChannelKt.SEGMENT_SIZE - 1;
            while(-1 < v) {
                long v1 = channelSegment0.id * ((long)BufferedChannelKt.SEGMENT_SIZE) + ((long)v);
            alab2:
                do {
                    do {
                        do {
                            do {
                                object1 = channelSegment0.getState$kotlinx_coroutines_core(v);
                                if(object1 == BufferedChannelKt.DONE_RCV) {
                                    break alab1;
                                }
                                if(object1 != BufferedChannelKt.BUFFERED) {
                                    goto label_16;
                                }
                                if(v1 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                                    break alab1;
                                }
                            }
                            while(!channelSegment0.casState$kotlinx_coroutines_core(v, object1, BufferedChannelKt.getCHANNEL_CLOSED()));
                            if(k0 != null) {
                                throwable0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(k0, channelSegment0.getElement$kotlinx_coroutines_core(v), ((UndeliveredElementException)throwable0));
                            }
                            channelSegment0.cleanElement$kotlinx_coroutines_core(v);
                            channelSegment0.onSlotCleaned();
                            break;
                        label_16:
                            if(object1 == BufferedChannelKt.IN_BUFFER || object1 == null) {
                                continue alab2;
                            }
                            if(object1 instanceof Waiter || object1 instanceof WaiterEB) {
                                goto label_21;
                            }
                            if(object1 == BufferedChannelKt.RESUMING_BY_EB || object1 == BufferedChannelKt.RESUMING_BY_RCV) {
                                break alab1;
                            }
                        }
                        while(object1 == BufferedChannelKt.RESUMING_BY_EB);
                        goto label_32;
                    label_21:
                        if(v1 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                            break alab1;
                        }
                        waiter0 = object1 instanceof WaiterEB ? ((WaiterEB)object1).waiter : ((Waiter)object1);
                    }
                    while(!channelSegment0.casState$kotlinx_coroutines_core(v, object1, BufferedChannelKt.getCHANNEL_CLOSED()));
                    if(k0 != null) {
                        throwable0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException(k0, channelSegment0.getElement$kotlinx_coroutines_core(v), ((UndeliveredElementException)throwable0));
                    }
                    object0 = InlineList.plus-FjFbRPM(object0, waiter0);
                    channelSegment0.cleanElement$kotlinx_coroutines_core(v);
                    channelSegment0.onSlotCleaned();
                    goto label_32;
                }
                while(!channelSegment0.casState$kotlinx_coroutines_core(v, object1, BufferedChannelKt.getCHANNEL_CLOSED()));
                channelSegment0.onSlotCleaned();
            label_32:
                --v;
            }
            channelSegment0 = (ChannelSegment)channelSegment0.getPrev();
        }
        while(channelSegment0 != null);
        if(object0 != null) {
            if(object0 instanceof ArrayList) {
                for(int v2 = ((ArrayList)object0).size() - 1; -1 < v2; --v2) {
                    this.resumeSenderOnCancelledChannel(((Waiter)((ArrayList)object0).get(v2)));
                }
            }
            else {
                this.resumeSenderOnCancelledChannel(((Waiter)object0));
            }
        }
        if(throwable0 != null) {
            throw throwable0;
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter0) {
        this.resumeWaiterOnClosedChannel(waiter0, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter0) {
        this.resumeWaiterOnClosedChannel(waiter0, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter0, boolean z) {
        if(waiter0 instanceof CancellableContinuation) {
            ((Continuation)waiter0).resumeWith(n.t((z ? this.getReceiveException() : this.getSendException())));
            return;
        }
        if(waiter0 instanceof ReceiveCatching) {
            Throwable throwable0 = this.getCloseCause();
            ChannelResult channelResult0 = ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(throwable0));
            ((ReceiveCatching)waiter0).cont.resumeWith(channelResult0);
            return;
        }
        if(waiter0 instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator)waiter0).tryResumeHasNextOnClosedChannel();
            return;
        }
        if(!(waiter0 instanceof SelectInstance)) {
            throw new IllegalStateException(("Unexpected waiter: " + waiter0).toString());
        }
        ((SelectInstance)waiter0).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(Object object0, @NotNull Continuation continuation0) {
        return BufferedChannel.send$suspendImpl(this, object0, continuation0);
    }

    public static Object send$suspendImpl(BufferedChannel bufferedChannel0, Object object0, Continuation continuation0) {
        ChannelSegment channelSegment2;
        int v3;
        long v1;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.sendSegment$volatile$FU.get(bufferedChannel0);
    alab1:
        while(true) {
            long v = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel0);
            v1 = v & 0xFFFFFFFFFFFFFFFL;
            boolean z = bufferedChannel0.isClosedForSend0(v);
            long v2 = v1 / ((long)BufferedChannelKt.SEGMENT_SIZE);
            v3 = (int)(v1 % ((long)BufferedChannelKt.SEGMENT_SIZE));
            if(channelSegment0.id == v2) {
            label_15:
                channelSegment2 = channelSegment0;
            }
            else {
                ChannelSegment channelSegment1 = bufferedChannel0.findSegmentSend(v2, channelSegment0);
                if(channelSegment1 == null) {
                    if(!z) {
                        continue;
                    }
                    Object object1 = bufferedChannel0.onClosedSend(object0, continuation0);
                    return object1 != ne.a.a ? H.a : object1;
                }
                else {
                    channelSegment2 = channelSegment1;
                    goto label_16;
                }
                goto label_15;
            }
        label_16:
            switch(bufferedChannel0.updateCellSend(channelSegment2, v3, object0, v1, null, z)) {
                case 0: {
                    channelSegment2.cleanPrev();
                    return H.a;
                }
                case 1: {
                    return H.a;
                }
                case 2: {
                    goto label_29;
                }
                case 3: {
                    goto label_26;
                }
                case 4: {
                    break alab1;
                }
                case 5: {
                    channelSegment2.cleanPrev();
                    channelSegment0 = channelSegment2;
                    break;
                }
                default: {
                    channelSegment0 = channelSegment2;
                    break;
                }
            }
        }
        if(v1 < bufferedChannel0.getReceiversCounter$kotlinx_coroutines_core()) {
            channelSegment2.cleanPrev();
        }
        Object object2 = bufferedChannel0.onClosedSend(object0, continuation0);
        if(object2 == ne.a.a) {
            return object2;
        label_26:
            Object object3 = bufferedChannel0.sendOnNoWaiterSuspend(channelSegment2, v3, object0, v1, continuation0);
            if(object3 == ne.a.a) {
                return object3;
            label_29:
                if(z) {
                    channelSegment2.onSlotCleaned();
                    Object object4 = bufferedChannel0.onClosedSend(object0, continuation0);
                    if(object4 == ne.a.a) {
                        return object4;
                    }
                }
            }
        }
        return H.a;
    }

    private final Object sendOnNoWaiterSuspend(ChannelSegment channelSegment0, int v, Object object0, long v1, Continuation continuation0) {
        ChannelSegment channelSegment3;
        H h0;
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(u.D(continuation0));
        try {
            int v2 = this.updateCellSend(channelSegment0, v, object0, v1, cancellableContinuationImpl0, false);
            h0 = H.a;
        alab1:
            switch(v2) {
                case 0: {
                    channelSegment0.cleanPrev();
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    this.prepareSenderForSuspension(cancellableContinuationImpl0, channelSegment0, v);
                    goto label_51;
                }
                case 4: {
                    if(v1 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment0.cleanPrev();
                    }
                    this.onClosedSendOnNoWaiterSuspend(object0, cancellableContinuationImpl0);
                    goto label_51;
                }
                case 5: {
                    channelSegment0.cleanPrev();
                    ChannelSegment channelSegment1 = (ChannelSegment)BufferedChannel.sendSegment$volatile$FU.get(this);
                    while(true) {
                        long v3 = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                        long v4 = 0xFFFFFFFFFFFFFFFL & v3;
                        boolean z = this.isClosedForSend0(v3);
                        long v5 = v4 / ((long)BufferedChannelKt.SEGMENT_SIZE);
                        int v6 = (int)(v4 % ((long)BufferedChannelKt.SEGMENT_SIZE));
                        if(channelSegment1.id == v5) {
                        label_19:
                            channelSegment3 = channelSegment1;
                        }
                        else {
                            ChannelSegment channelSegment2 = this.findSegmentSend(v5, channelSegment1);
                            if(channelSegment2 == null) {
                                if(!z) {
                                    continue;
                                }
                                this.onClosedSendOnNoWaiterSuspend(object0, cancellableContinuationImpl0);
                                goto label_51;
                            }
                            else {
                                channelSegment3 = channelSegment2;
                                goto label_20;
                            }
                            goto label_19;
                        }
                    label_20:
                        switch(this.updateCellSend(channelSegment3, v6, object0, v4, cancellableContinuationImpl0, z)) {
                            case 0: {
                                channelSegment3.cleanPrev();
                                break alab1;
                            }
                            case 1: {
                                break alab1;
                            }
                            case 2: {
                                if(z) {
                                    channelSegment3.onSlotCleaned();
                                    this.onClosedSendOnNoWaiterSuspend(object0, cancellableContinuationImpl0);
                                    goto label_51;
                                }
                                CancellableContinuationImpl cancellableContinuationImpl1 = cancellableContinuationImpl0 == null ? null : cancellableContinuationImpl0;
                                if(cancellableContinuationImpl1 == null) {
                                    goto label_51;
                                }
                                this.prepareSenderForSuspension(cancellableContinuationImpl1, channelSegment3, v6);
                                goto label_51;
                            }
                            case 3: {
                                throw new IllegalStateException("unexpected");
                            }
                            case 4: {
                                if(v4 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                                    channelSegment3.cleanPrev();
                                }
                                this.onClosedSendOnNoWaiterSuspend(object0, cancellableContinuationImpl0);
                                goto label_51;
                            }
                            case 5: {
                                channelSegment3.cleanPrev();
                                channelSegment1 = channelSegment3;
                                break;
                            }
                            default: {
                                channelSegment1 = channelSegment3;
                                break;
                            }
                        }
                    }
                }
                default: {
                    throw new IllegalStateException("unexpected");
                }
            }
            cancellableContinuationImpl0.resumeWith(h0);
        }
        catch(Throwable throwable0) {
            cancellableContinuationImpl0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw throwable0;
        }
    label_51:
        Object object1 = cancellableContinuationImpl0.getResult();
        return object1 == ne.a.a ? object1 : h0;
    }

    // 去混淆评级： 低(20)
    private final boolean shouldSendSuspend(long v) {
        return this.isClosedForSend0(v) ? false : !this.bufferOrRendezvousSend(v & 0xFFFFFFFFFFFFFFFL);
    }

    @Override
    @NotNull
    public String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        switch(((int)(BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this) >> 60))) {
            case 2: {
                stringBuilder0.append("closed,");
                break;
            }
            case 3: {
                stringBuilder0.append("cancelled,");
            }
        }
        stringBuilder0.append("capacity=" + this.capacity + ',');
        stringBuilder0.append("data=[");
        Iterable iterable0 = e.k.A(new ChannelSegment[]{BufferedChannel.receiveSegment$volatile$FU.get(this), BufferedChannel.sendSegment$volatile$FU.get(this), BufferedChannel.bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            if(((ChannelSegment)object0) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList0.add(object0);
            }
        }
        Iterator iterator1 = arrayList0.iterator();
        if(!iterator1.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object1 = iterator1.next();
        if(iterator1.hasNext()) {
            long v = ((ChannelSegment)object1).id;
            while(true) {
                Object object2 = iterator1.next();
                long v1 = ((ChannelSegment)object2).id;
                if(v > v1) {
                    object1 = object2;
                    v = v1;
                }
                if(!iterator1.hasNext()) {
                    break;
                }
            }
        }
        ChannelSegment channelSegment0 = (ChannelSegment)object1;
        long v2 = this.getReceiversCounter$kotlinx_coroutines_core();
        long v3 = this.getSendersCounter$kotlinx_coroutines_core();
    alab1:
        do {
            int v4 = BufferedChannelKt.SEGMENT_SIZE;
            int v5 = 0;
            while(v5 < v4) {
                long v6 = channelSegment0.id * ((long)BufferedChannelKt.SEGMENT_SIZE) + ((long)v5);
                int v7 = Long.compare(v6, v3);
                if(v7 >= 0 && v6 >= v2) {
                    break alab1;
                }
                Object object3 = channelSegment0.getState$kotlinx_coroutines_core(v5);
                Object object4 = channelSegment0.getElement$kotlinx_coroutines_core(v5);
                if(object3 instanceof CancellableContinuation) {
                    int v8 = Long.compare(v6, v2);
                    if(v8 < 0 && v7 >= 0) {
                        s = "receive";
                    }
                    else if(v7 >= 0 || v8 < 0) {
                        s = "cont";
                    }
                    else {
                        s = "send";
                    }
                    goto label_69;
                }
                else if(object3 instanceof SelectInstance) {
                    int v9 = Long.compare(v6, v2);
                    if(v9 < 0 && v7 >= 0) {
                        s = "onReceive";
                    }
                    else if(v7 >= 0 || v9 < 0) {
                        s = "select";
                    }
                    else {
                        s = "onSend";
                    }
                    goto label_69;
                }
                else if(object3 instanceof ReceiveCatching) {
                    s = "receiveCatching";
                    goto label_69;
                }
                else if(object3 instanceof WaiterEB) {
                    s = "EB(" + object3 + ')';
                    goto label_69;
                }
                else if(q.b(object3, BufferedChannelKt.RESUMING_BY_RCV) || q.b(object3, BufferedChannelKt.RESUMING_BY_EB)) {
                    s = "resuming_sender";
                label_69:
                    if(object4 == null) {
                        stringBuilder0.append(s + ',');
                    }
                    else {
                        stringBuilder0.append("(" + s + ',' + object4 + "),");
                    }
                }
                else if(object3 != null && !object3.equals(BufferedChannelKt.IN_BUFFER) && !object3.equals(BufferedChannelKt.DONE_RCV) && !object3.equals(BufferedChannelKt.POISONED) && !object3.equals(BufferedChannelKt.INTERRUPTED_RCV) && !object3.equals(BufferedChannelKt.INTERRUPTED_SEND) && !object3.equals(BufferedChannelKt.getCHANNEL_CLOSED())) {
                    s = object3.toString();
                    goto label_69;
                }
                ++v5;
            }
            channelSegment0 = (ChannelSegment)channelSegment0.getNext();
        }
        while(channelSegment0 != null);
        if(Tf.o.I0(stringBuilder0) == 44) {
            q.f(stringBuilder0.deleteCharAt(stringBuilder0.length() - 1), "deleteCharAt(...)");
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public Object tryReceive-PtdJZtk() {
        Object object0;
        ChannelSegment channelSegment1;
        long v = BufferedChannel.receivers$volatile$FU.get(this);
        long v1 = BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this);
        if(this.isClosedForReceive0(v1)) {
            Throwable throwable0 = this.getCloseCause();
            return ChannelResult.Companion.closed-JP2dKIU(throwable0);
        }
        if(v >= (v1 & 0xFFFFFFFFFFFFFFFL)) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        Symbol symbol0 = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.receiveSegment$volatile$FU.get(this);
        while(true) {
            if(this.isClosedForReceive()) {
                Throwable throwable1 = this.getCloseCause();
                return ChannelResult.Companion.closed-JP2dKIU(throwable1);
            }
            long v2 = BufferedChannel.receivers$volatile$FU.getAndIncrement(this);
            long v3 = v2 / ((long)BufferedChannelKt.SEGMENT_SIZE);
            int v4 = (int)(v2 % ((long)BufferedChannelKt.SEGMENT_SIZE));
            if(channelSegment0.id == v3) {
                channelSegment1 = channelSegment0;
            }
            else {
                channelSegment1 = this.findSegmentReceive(v3, channelSegment0);
                if(channelSegment1 == null) {
                    continue;
                }
            }
            object0 = this.updateCellReceive(channelSegment1, v4, v2, symbol0);
            if(object0 == BufferedChannelKt.SUSPEND) {
                Waiter waiter0 = symbol0 instanceof Waiter ? ((Waiter)symbol0) : null;
                if(waiter0 != null) {
                    this.prepareReceiverForSuspension(waiter0, channelSegment1, v4);
                }
                this.waitExpandBufferCompletion$kotlinx_coroutines_core(v2);
                channelSegment1.onSlotCleaned();
                return ChannelResult.Companion.failure-PtdJZtk();
            }
            if(object0 != BufferedChannelKt.FAILED) {
                break;
            }
            if(v2 < this.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment1.cleanPrev();
            }
            channelSegment0 = channelSegment1;
        }
        if(object0 == BufferedChannelKt.SUSPEND_NO_WAITER) {
            throw new IllegalStateException("unexpected");
        }
        channelSegment1.cleanPrev();
        return ChannelResult.Companion.success-JP2dKIU(object0);
    }

    private final boolean tryResumeReceiver(Object object0, Object object1) {
        g g0 = null;
        if(object0 instanceof SelectInstance) {
            return ((SelectInstance)object0).trySelect(this, object1);
        }
        if(object0 instanceof ReceiveCatching) {
            q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl cancellableContinuationImpl0 = ((ReceiveCatching)object0).cont;
            ChannelResult channelResult0 = ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(object1));
            k k0 = this.onUndeliveredElement;
            if(k0 != null) {
                g0 = this.bindCancellationFunResult(k0);
            }
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl0, channelResult0, ((o)g0));
        }
        if(object0 instanceof BufferedChannelIterator) {
            q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator)object0).tryResumeHasNext(object1);
        }
        if(!(object0 instanceof CancellableContinuation)) {
            throw new IllegalStateException(("Unexpected receiver type: " + object0).toString());
        }
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        k k1 = this.onUndeliveredElement;
        if(k1 != null) {
            g0 = this.bindCancellationFun(k1);
        }
        return BufferedChannelKt.tryResume0(((CancellableContinuation)object0), object1, ((o)g0));
    }

    private final boolean tryResumeSender(Object object0, ChannelSegment channelSegment0, int v) {
        H h0 = H.a;
        if(object0 instanceof CancellableContinuation) {
            q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default(((CancellableContinuation)object0), h0, null, 2, null);
        }
        if(!(object0 instanceof SelectInstance)) {
            throw new IllegalStateException(("Unexpected waiter: " + object0).toString());
        }
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        TrySelectDetailedResult trySelectDetailedResult0 = ((SelectImplementation)object0).trySelectDetailed(this, h0);
        if(trySelectDetailedResult0 == TrySelectDetailedResult.REREGISTER) {
            channelSegment0.cleanElement$kotlinx_coroutines_core(v);
        }
        return trySelectDetailedResult0 == TrySelectDetailedResult.SUCCESSFUL;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public Object trySend-JP2dKIU(Object object0) {
        ChannelSegment channelSegment2;
        int v4;
        if(this.shouldSendSuspend(BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this))) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        Symbol symbol0 = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.sendSegment$volatile$FU.get(this);
        while(true) {
            long v = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long v1 = v & 0xFFFFFFFFFFFFFFFL;
            boolean z = this.isClosedForSend0(v);
            long v2 = v1 / ((long)BufferedChannelKt.SEGMENT_SIZE);
            int v3 = (int)(v1 % ((long)BufferedChannelKt.SEGMENT_SIZE));
            if(channelSegment0.id == v2) {
            label_18:
                v4 = v3;
                channelSegment2 = channelSegment0;
            }
            else {
                ChannelSegment channelSegment1 = this.findSegmentSend(v2, channelSegment0);
                if(channelSegment1 == null) {
                    if(!z) {
                        continue;
                    }
                    Throwable throwable0 = this.getSendException();
                    return ChannelResult.Companion.closed-JP2dKIU(throwable0);
                }
                else {
                    v4 = v3;
                    channelSegment2 = channelSegment1;
                    goto label_20;
                }
                goto label_18;
            }
        label_20:
            int v5 = this.updateCellSend(channelSegment2, v4, object0, v1, symbol0, z);
            channelSegment0 = channelSegment2;
            H h0 = H.a;
            switch(v5) {
                case 0: {
                    channelSegment0.cleanPrev();
                    return ChannelResult.Companion.success-JP2dKIU(h0);
                }
                case 1: {
                    return ChannelResult.Companion.success-JP2dKIU(h0);
                }
                case 2: {
                    if(z) {
                        channelSegment0.onSlotCleaned();
                        Throwable throwable2 = this.getSendException();
                        return ChannelResult.Companion.closed-JP2dKIU(throwable2);
                    }
                    Waiter waiter0 = symbol0 instanceof Waiter ? ((Waiter)symbol0) : null;
                    if(waiter0 != null) {
                        this.prepareSenderForSuspension(waiter0, channelSegment0, v4);
                    }
                    channelSegment0.onSlotCleaned();
                    return ChannelResult.Companion.failure-PtdJZtk();
                }
                case 3: {
                    throw new IllegalStateException("unexpected");
                }
                case 4: {
                    if(v1 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment0.cleanPrev();
                    }
                    Throwable throwable1 = this.getSendException();
                    return ChannelResult.Companion.closed-JP2dKIU(throwable1);
                }
                case 5: {
                    channelSegment0.cleanPrev();
                }
            }
        }
    }

    @NotNull
    public final Object trySendDropOldest-JP2dKIU(Object object0) {
        int v5;
        ChannelSegment channelSegment1;
        Symbol symbol0 = BufferedChannelKt.BUFFERED;
        ChannelSegment channelSegment0 = (ChannelSegment)BufferedChannel.sendSegment$volatile$FU.get(this);
        while(true) {
            long v = BufferedChannel.sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long v1 = v & 0xFFFFFFFFFFFFFFFL;
            boolean z = this.isClosedForSend0(v);
            int v2 = BufferedChannelKt.SEGMENT_SIZE;
            long v3 = v1 / ((long)v2);
            int v4 = (int)(v1 % ((long)v2));
            if(channelSegment0.id == v3) {
            label_16:
                channelSegment1 = channelSegment0;
                v5 = v4;
            }
            else {
                channelSegment1 = this.findSegmentSend(v3, channelSegment0);
                if(channelSegment1 == null) {
                    if(!z) {
                        continue;
                    }
                    Throwable throwable0 = this.getSendException();
                    return ChannelResult.Companion.closed-JP2dKIU(throwable0);
                }
                else {
                    v5 = v4;
                    goto label_18;
                }
                goto label_16;
            }
        label_18:
            int v6 = this.updateCellSend(channelSegment1, v5, object0, v1, symbol0, z);
            channelSegment0 = channelSegment1;
            H h0 = H.a;
            switch(v6) {
                case 0: {
                    channelSegment0.cleanPrev();
                    return ChannelResult.Companion.success-JP2dKIU(h0);
                }
                case 1: {
                    return ChannelResult.Companion.success-JP2dKIU(h0);
                }
                case 2: {
                    if(z) {
                        channelSegment0.onSlotCleaned();
                        Throwable throwable2 = this.getSendException();
                        return ChannelResult.Companion.closed-JP2dKIU(throwable2);
                    }
                    Waiter waiter0 = symbol0 instanceof Waiter ? ((Waiter)symbol0) : null;
                    if(waiter0 != null) {
                        this.prepareSenderForSuspension(waiter0, channelSegment0, v5);
                    }
                    this.dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(channelSegment0.id * ((long)v2) + ((long)v5));
                    return ChannelResult.Companion.success-JP2dKIU(h0);
                }
                case 3: {
                    throw new IllegalStateException("unexpected");
                }
                case 4: {
                    if(v1 < this.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment0.cleanPrev();
                    }
                    Throwable throwable1 = this.getSendException();
                    return ChannelResult.Companion.closed-JP2dKIU(throwable1);
                }
                case 5: {
                    channelSegment0.cleanPrev();
                }
            }
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment channelSegment0, int v, long v1) {
        Object object0 = channelSegment0.getState$kotlinx_coroutines_core(v);
        if(object0 instanceof Waiter && v1 >= BufferedChannel.receivers$volatile$FU.get(this) && channelSegment0.casState$kotlinx_coroutines_core(v, object0, BufferedChannelKt.RESUMING_BY_EB)) {
            if(this.tryResumeSender(object0, channelSegment0, v)) {
                channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.BUFFERED);
                return true;
            }
            channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.INTERRUPTED_SEND);
            channelSegment0.onCancelledRequest(v, false);
            return false;
        }
        return this.updateCellExpandBufferSlow(channelSegment0, v, v1);
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment channelSegment0, int v, long v1) {
        Object object0;
        do {
            while(true) {
            alab1:
                while(true) {
                    do {
                        object0 = channelSegment0.getState$kotlinx_coroutines_core(v);
                        if(!(object0 instanceof Waiter)) {
                            break alab1;
                        }
                        if(v1 >= BufferedChannel.receivers$volatile$FU.get(this)) {
                            goto label_5;
                        }
                    }
                    while(!channelSegment0.casState$kotlinx_coroutines_core(v, object0, new WaiterEB(((Waiter)object0))));
                    return true;
                label_5:
                    if(channelSegment0.casState$kotlinx_coroutines_core(v, object0, BufferedChannelKt.RESUMING_BY_EB)) {
                        if(this.tryResumeSender(object0, channelSegment0, v)) {
                            channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.BUFFERED);
                            return true;
                        }
                        channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.INTERRUPTED_SEND);
                        channelSegment0.onCancelledRequest(v, false);
                        return false;
                    }
                }
                if(object0 == BufferedChannelKt.INTERRUPTED_SEND) {
                    return false;
                }
                if(object0 != null) {
                    break;
                }
                if(channelSegment0.casState$kotlinx_coroutines_core(v, null, BufferedChannelKt.IN_BUFFER)) {
                    return true;
                }
            }
            if(object0 == BufferedChannelKt.BUFFERED) {
                return true;
            }
            if(object0 == BufferedChannelKt.POISONED || object0 == BufferedChannelKt.DONE_RCV || object0 == BufferedChannelKt.INTERRUPTED_RCV || object0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                return true;
            }
        }
        while(object0 == BufferedChannelKt.RESUMING_BY_RCV);
        throw new IllegalStateException(("Unexpected cell state: " + object0).toString());
    }

    private final Object updateCellReceive(ChannelSegment channelSegment0, int v, long v1, Object object0) {
        Object object1 = channelSegment0.getState$kotlinx_coroutines_core(v);
        if(object1 == null) {
            if(v1 >= (BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this) & 0xFFFFFFFFFFFFFFFL)) {
                if(object0 == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if(channelSegment0.casState$kotlinx_coroutines_core(v, null, object0)) {
                    this.expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        }
        else if(object1 == BufferedChannelKt.BUFFERED && channelSegment0.casState$kotlinx_coroutines_core(v, object1, BufferedChannelKt.DONE_RCV)) {
            this.expandBuffer();
            return channelSegment0.retrieveElement$kotlinx_coroutines_core(v);
        }
        return this.updateCellReceiveSlow(channelSegment0, v, v1, object0);
    }

    private final Object updateCellReceiveSlow(ChannelSegment channelSegment0, int v, long v1, Object object0) {
        Waiter waiter0;
        do {
            while(true) {
            alab1:
                while(true) {
                    do {
                        waiter0 = channelSegment0.getState$kotlinx_coroutines_core(v);
                        if(waiter0 == null || waiter0 == BufferedChannelKt.IN_BUFFER) {
                            break alab1;
                        }
                        if(waiter0 != BufferedChannelKt.BUFFERED) {
                            goto label_6;
                        }
                    }
                    while(!channelSegment0.casState$kotlinx_coroutines_core(v, waiter0, BufferedChannelKt.DONE_RCV));
                    this.expandBuffer();
                    return channelSegment0.retrieveElement$kotlinx_coroutines_core(v);
                label_6:
                    if(waiter0 == BufferedChannelKt.INTERRUPTED_SEND) {
                        return BufferedChannelKt.FAILED;
                    }
                    if(waiter0 == BufferedChannelKt.POISONED) {
                        return BufferedChannelKt.FAILED;
                    }
                    if(waiter0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        this.expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                    if(waiter0 != BufferedChannelKt.RESUMING_BY_EB && channelSegment0.casState$kotlinx_coroutines_core(v, waiter0, BufferedChannelKt.RESUMING_BY_RCV)) {
                        boolean z = waiter0 instanceof WaiterEB;
                        if(z) {
                            waiter0 = ((WaiterEB)waiter0).waiter;
                        }
                        if(this.tryResumeSender(waiter0, channelSegment0, v)) {
                            channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.DONE_RCV);
                            this.expandBuffer();
                            return channelSegment0.retrieveElement$kotlinx_coroutines_core(v);
                        }
                        channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.INTERRUPTED_SEND);
                        channelSegment0.onCancelledRequest(v, false);
                        if(z) {
                            this.expandBuffer();
                        }
                        return BufferedChannelKt.FAILED;
                    }
                }
                if(v1 >= (BufferedChannel.sendersAndCloseStatus$volatile$FU.get(this) & 0xFFFFFFFFFFFFFFFL)) {
                    break;
                }
                if(channelSegment0.casState$kotlinx_coroutines_core(v, waiter0, BufferedChannelKt.POISONED)) {
                    this.expandBuffer();
                    return BufferedChannelKt.FAILED;
                }
            }
            if(object0 == null) {
                return BufferedChannelKt.SUSPEND_NO_WAITER;
            }
        }
        while(!channelSegment0.casState$kotlinx_coroutines_core(v, waiter0, object0));
        this.expandBuffer();
        return BufferedChannelKt.SUSPEND;
    }

    private final int updateCellSend(ChannelSegment channelSegment0, int v, Object object0, long v1, Object object1, boolean z) {
        channelSegment0.storeElement$kotlinx_coroutines_core(v, object0);
        if(z) {
            return this.updateCellSendSlow(channelSegment0, v, object0, v1, object1, true);
        }
        Object object2 = channelSegment0.getState$kotlinx_coroutines_core(v);
        if(object2 == null) {
            if(this.bufferOrRendezvousSend(v1)) {
                return channelSegment0.casState$kotlinx_coroutines_core(v, null, BufferedChannelKt.BUFFERED) ? 1 : this.updateCellSendSlow(channelSegment0, v, object0, v1, object1, false);
            }
            if(object1 == null) {
                return 3;
            }
            return channelSegment0.casState$kotlinx_coroutines_core(v, null, object1) ? 2 : this.updateCellSendSlow(channelSegment0, v, object0, v1, object1, false);
        }
        if(object2 instanceof Waiter) {
            channelSegment0.cleanElement$kotlinx_coroutines_core(v);
            if(this.tryResumeReceiver(object2, object0)) {
                channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.DONE_RCV);
                return 0;
            }
            if(channelSegment0.getAndSetState$kotlinx_coroutines_core(v, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                channelSegment0.onCancelledRequest(v, true);
            }
            return 5;
        }
        return this.updateCellSendSlow(channelSegment0, v, object0, v1, object1, false);
    }

    private final int updateCellSendSlow(ChannelSegment channelSegment0, int v, Object object0, long v1, Object object1, boolean z) {
        Waiter waiter0;
        while(true) {
        alab1:
            while(true) {
                do {
                    do {
                        waiter0 = channelSegment0.getState$kotlinx_coroutines_core(v);
                        if(waiter0 != null) {
                            break alab1;
                        }
                        if(!this.bufferOrRendezvousSend(v1) || z) {
                            goto label_5;
                        }
                    }
                    while(!channelSegment0.casState$kotlinx_coroutines_core(v, null, BufferedChannelKt.BUFFERED));
                    return 1;
                label_5:
                    if(!z) {
                        goto label_9;
                    }
                }
                while(!channelSegment0.casState$kotlinx_coroutines_core(v, null, BufferedChannelKt.INTERRUPTED_SEND));
                channelSegment0.onCancelledRequest(v, false);
                return 4;
            label_9:
                if(object1 == null) {
                    return 3;
                }
                if(channelSegment0.casState$kotlinx_coroutines_core(v, null, object1)) {
                    return 2;
                }
            }
            if(waiter0 != BufferedChannelKt.IN_BUFFER) {
                break;
            }
            if(channelSegment0.casState$kotlinx_coroutines_core(v, waiter0, BufferedChannelKt.BUFFERED)) {
                return 1;
            }
        }
        if(waiter0 == BufferedChannelKt.INTERRUPTED_RCV) {
            channelSegment0.cleanElement$kotlinx_coroutines_core(v);
            return 5;
        }
        if(waiter0 == BufferedChannelKt.POISONED) {
            channelSegment0.cleanElement$kotlinx_coroutines_core(v);
            return 5;
        }
        if(waiter0 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            channelSegment0.cleanElement$kotlinx_coroutines_core(v);
            this.completeCloseOrCancel();
            return 4;
        }
        channelSegment0.cleanElement$kotlinx_coroutines_core(v);
        if(waiter0 instanceof WaiterEB) {
            waiter0 = ((WaiterEB)waiter0).waiter;
        }
        if(this.tryResumeReceiver(waiter0, object0)) {
            channelSegment0.setState$kotlinx_coroutines_core(v, BufferedChannelKt.DONE_RCV);
            return 0;
        }
        if(channelSegment0.getAndSetState$kotlinx_coroutines_core(v, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
            channelSegment0.onCancelledRequest(v, true);
        }
        return 5;
    }

    private final void updateReceiversCounterIfLower(long v) {
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = BufferedChannel.receivers$volatile$FU;
        do {
            long v1 = atomicLongFieldUpdater0.get(this);
        }
        while(v1 < v && !BufferedChannel.receivers$volatile$FU.compareAndSet(this, v1, v));
    }

    private final void updateSendersCounterIfLower(long v) {
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = BufferedChannel.sendersAndCloseStatus$volatile$FU;
        do {
            long v1 = atomicLongFieldUpdater0.get(this);
        }
        while((0xFFFFFFFFFFFFFFFL & v1) < v && !BufferedChannel.sendersAndCloseStatus$volatile$FU.compareAndSet(this, v1, BufferedChannelKt.access$constructSendersAndCloseStatus(0xFFFFFFFFFFFFFFFL & v1, ((int)(v1 >> 60)))));
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long v) {
        if(!this.isRendezvousOrUnlimited()) {
            while(this.getBufferEndCounter() <= v) {
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater0 = BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU;
            do {
                long v1 = atomicLongFieldUpdater0.get(this);
            }
            while(!atomicLongFieldUpdater0.compareAndSet(this, v1, BufferedChannelKt.constructEBCompletedAndPauseFlag(v1 & 0x3FFFFFFFFFFFFFFFL, true)));
            while(true) {
                long v2 = this.getBufferEndCounter();
                long v3 = BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
                long v4 = v3 & 0x3FFFFFFFFFFFFFFFL;
                if(v2 == v4 && v2 == this.getBufferEndCounter()) {
                    break;
                }
                if((0x4000000000000000L & v3) == 0L) {
                    BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(this, v3, BufferedChannelKt.constructEBCompletedAndPauseFlag(v4, true));
                }
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater1 = BufferedChannel.completedExpandBuffersAndPauseFlag$volatile$FU;
            while(true) {
                long v5 = atomicLongFieldUpdater1.get(this);
                if(atomicLongFieldUpdater1.compareAndSet(this, v5, BufferedChannelKt.constructEBCompletedAndPauseFlag(v5 & 0x3FFFFFFFFFFFFFFFL, false))) {
                    break;
                }
            }
        }
    }
}

