package com.melon.net.res.v3;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import ba.s;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Predicate;
import e.k;
import java.util.ArrayList;
import java.util.Collection;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u001F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u00E1\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\f\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0005\u0012\u0006\u0010\u0010\u001A\u00020\u0005\u0012\u0006\u0010\u0011\u001A\u00020\u0005\u0012\u0006\u0010\u0012\u001A\u00020\f\u0012\u0006\u0010\u0013\u001A\u00020\f\u0012\b\b\u0002\u0010\u0014\u001A\u00020\f\u0012\u0006\u0010\u0015\u001A\u00020\u0003\u0012\u0006\u0010\u0016\u001A\u00020\f\u0012\u0006\u0010\u0017\u001A\u00020\f\u0012\b\b\u0002\u0010\u0018\u001A\u00020\u0003\u0012\u0006\u0010\u0019\u001A\u00020\f\u0012\u0006\u0010\u001A\u001A\u00020\u0003\u0012\u0006\u0010\u001B\u001A\u00020\u0003\u0012\u0006\u0010\u001C\u001A\u00020\u0005\u0012\u0006\u0010\u001D\u001A\u00020\u0005\u0012\u0006\u0010\u001E\u001A\u00020\u0005\u0012\u0006\u0010\u001F\u001A\u00020\u0005\u0012\u0006\u0010 \u001A\u00020\f\u0012\u0006\u0010!\u001A\u00020\f\u0012\u0006\u0010\"\u001A\u00020\u0003\u0012\u0006\u0010#\u001A\u00020\u0003\u0012\u0006\u0010$\u001A\u00020\u0005\u0012\u0006\u0010%\u001A\u00020\u0005\u0012\u0006\u0010&\u001A\u00020\u0005\u0012\u0006\u0010\'\u001A\u00020\u0005\u0012\u0006\u0010(\u001A\u00020\u0005\u0012\u0006\u0010)\u001A\u00020\u0005\u0012\u0006\u0010*\u001A\u00020\u0003\u0012\u0006\u0010+\u001A\u00020\f\u0012\u0016\u0010.\u001A\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-\u0012\b\u00100\u001A\u0004\u0018\u00010/\u00A2\u0006\u0004\b1\u00102J\r\u00103\u001A\u00020\u0005\u00A2\u0006\u0004\b3\u00104J\u0015\u00107\u001A\u00020\u00052\u0006\u00106\u001A\u000205\u00A2\u0006\u0004\b7\u00108J\u0015\u0010\u001D\u001A\u00020\u00052\u0006\u00106\u001A\u000205\u00A2\u0006\u0004\b\u001D\u00108J\u0015\u00109\u001A\u00020\u00052\u0006\u00106\u001A\u000205\u00A2\u0006\u0004\b9\u00108J\r\u0010:\u001A\u00020\u0003\u00A2\u0006\u0004\b:\u0010;J\u001D\u0010@\u001A\u00020?2\u0006\u0010=\u001A\u00020<2\u0006\u0010>\u001A\u00020\u0003\u00A2\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bB\u0010;J\u0010\u0010C\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bC\u00104J\u0010\u0010D\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bD\u00104J\u0010\u0010E\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bE\u00104J\u0010\u0010F\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bF\u0010;J\u0010\u0010G\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bG\u00104J\u0010\u0010H\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bH\u00104J\u0010\u0010I\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bK\u0010;J\u0010\u0010L\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bL\u00104J\u0010\u0010M\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bM\u00104J\u0010\u0010N\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bN\u00104J\u0010\u0010O\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bO\u0010JJ\u0010\u0010P\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bP\u0010JJ\u0010\u0010Q\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bQ\u0010JJ\u0010\u0010R\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bR\u0010;J\u0010\u0010S\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bS\u0010JJ\u0010\u0010T\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bT\u0010JJ\u0010\u0010U\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bU\u0010;J\u0010\u0010V\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bV\u0010JJ\u0010\u0010W\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bW\u0010;J\u0010\u0010X\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bX\u0010;J\u0010\u0010Y\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bY\u00104J\u0010\u0010Z\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bZ\u00104J\u0010\u0010[\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b[\u00104J\u0010\u0010\\\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\\\u00104J\u0010\u0010]\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\b]\u0010JJ\u0010\u0010^\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\b^\u0010JJ\u0010\u0010_\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b_\u0010;J\u0010\u0010`\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b`\u0010;J\u0010\u0010a\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\ba\u00104J\u0010\u0010b\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bb\u00104J\u0010\u0010c\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bc\u00104J\u0010\u0010d\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bd\u00104J\u0010\u0010e\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\be\u00104J\u0010\u0010f\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\bf\u00104J\u0010\u0010g\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\bg\u0010;J\u0010\u0010h\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\bh\u0010JJ \u0010i\u001A\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-H\u00C6\u0003\u00A2\u0006\u0004\bi\u0010jJ\u0012\u0010k\u001A\u0004\u0018\u00010/H\u00C6\u0003\u00A2\u0006\u0004\bk\u0010lJ\u00B2\u0003\u0010m\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u00052\b\b\u0002\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0012\u001A\u00020\f2\b\b\u0002\u0010\u0013\u001A\u00020\f2\b\b\u0002\u0010\u0014\u001A\u00020\f2\b\b\u0002\u0010\u0015\u001A\u00020\u00032\b\b\u0002\u0010\u0016\u001A\u00020\f2\b\b\u0002\u0010\u0017\u001A\u00020\f2\b\b\u0002\u0010\u0018\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\f2\b\b\u0002\u0010\u001A\u001A\u00020\u00032\b\b\u0002\u0010\u001B\u001A\u00020\u00032\b\b\u0002\u0010\u001C\u001A\u00020\u00052\b\b\u0002\u0010\u001D\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\u00052\b\b\u0002\u0010 \u001A\u00020\f2\b\b\u0002\u0010!\u001A\u00020\f2\b\b\u0002\u0010\"\u001A\u00020\u00032\b\b\u0002\u0010#\u001A\u00020\u00032\b\b\u0002\u0010$\u001A\u00020\u00052\b\b\u0002\u0010%\u001A\u00020\u00052\b\b\u0002\u0010&\u001A\u00020\u00052\b\b\u0002\u0010\'\u001A\u00020\u00052\b\b\u0002\u0010(\u001A\u00020\u00052\b\b\u0002\u0010)\u001A\u00020\u00052\b\b\u0002\u0010*\u001A\u00020\u00032\b\b\u0002\u0010+\u001A\u00020\f2\u0018\b\u0002\u0010.\u001A\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-2\n\b\u0002\u00100\u001A\u0004\u0018\u00010/H\u00C6\u0001\u00A2\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001A\u00020\fH\u00D6\u0001\u00A2\u0006\u0004\bo\u0010JJ\u0010\u0010p\u001A\u00020\u0003H\u00D6\u0001\u00A2\u0006\u0004\bp\u0010;J\u001A\u0010s\u001A\u00020\u00052\b\u0010r\u001A\u0004\u0018\u00010qH\u00D6\u0003\u00A2\u0006\u0004\bs\u0010tJ\u0017\u0010u\u001A\u00020\u00052\u0006\u00106\u001A\u000205H\u0002\u00A2\u0006\u0004\bu\u00108J\u0013\u0010\u001C\u001A\u00020\u0005*\u000205H\u0002\u00A2\u0006\u0004\b\u001C\u00108R\u0017\u0010\u0004\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010v\u001A\u0004\bw\u0010;R\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010x\u001A\u0004\b\u0006\u00104R\u0017\u0010\u0007\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0007\u0010x\u001A\u0004\b\u0007\u00104R\u0017\u0010\b\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\b\u0010x\u001A\u0004\b\b\u00104R\u0017\u0010\t\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\t\u0010v\u001A\u0004\by\u0010;R\u0017\u0010\n\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\n\u0010x\u001A\u0004\b\n\u00104R\u0017\u0010\u000B\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010x\u001A\u0004\b\u000B\u00104R\u0017\u0010\r\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010z\u001A\u0004\b{\u0010JR\u0017\u0010\u000E\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010v\u001A\u0004\b|\u0010;R\u0017\u0010\u000F\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u000F\u0010x\u001A\u0004\b}\u00104R\u0017\u0010\u0010\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010x\u001A\u0004\b\u0010\u00104R\u0017\u0010\u0011\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0011\u0010x\u001A\u0004\b\u0011\u00104R\u0017\u0010\u0012\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b\u0012\u0010z\u001A\u0004\b~\u0010JR\u0017\u0010\u0013\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b\u0013\u0010z\u001A\u0004\b\u007F\u0010JR\u0018\u0010\u0014\u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b\u0014\u0010z\u001A\u0005\b\u0080\u0001\u0010JR\u0018\u0010\u0015\u001A\u00020\u00038\u0006\u00A2\u0006\r\n\u0004\b\u0015\u0010v\u001A\u0005\b\u0081\u0001\u0010;R\u0018\u0010\u0016\u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b\u0016\u0010z\u001A\u0005\b\u0082\u0001\u0010JR\u0018\u0010\u0017\u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b\u0017\u0010z\u001A\u0005\b\u0083\u0001\u0010JR%\u0010\u0018\u001A\u00020\u00038\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0015\n\u0004\b\u0018\u0010v\u001A\u0005\b\u0084\u0001\u0010;\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0019\u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b\u0019\u0010z\u001A\u0005\b\u0087\u0001\u0010JR\u0018\u0010\u001A\u001A\u00020\u00038\u0006\u00A2\u0006\r\n\u0004\b\u001A\u0010v\u001A\u0005\b\u0088\u0001\u0010;R\u0018\u0010\u001B\u001A\u00020\u00038\u0006\u00A2\u0006\r\n\u0004\b\u001B\u0010v\u001A\u0005\b\u0089\u0001\u0010;R\u0017\u0010\u001C\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u001C\u0010x\u001A\u0004\b\u001C\u00104R\u0017\u0010\u001D\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u001D\u0010x\u001A\u0004\b\u001D\u00104R\u0017\u0010\u001E\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u001E\u0010x\u001A\u0004\b\u001E\u00104R\u0017\u0010\u001F\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010x\u001A\u0004\b\u001F\u00104R\u0018\u0010 \u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b \u0010z\u001A\u0005\b\u008A\u0001\u0010JR\u0018\u0010!\u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b!\u0010z\u001A\u0005\b\u008B\u0001\u0010JR\u0018\u0010\"\u001A\u00020\u00038\u0006\u00A2\u0006\r\n\u0004\b\"\u0010v\u001A\u0005\b\u008C\u0001\u0010;R\u0018\u0010#\u001A\u00020\u00038\u0006\u00A2\u0006\r\n\u0004\b#\u0010v\u001A\u0005\b\u008D\u0001\u0010;R\u0017\u0010$\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b$\u0010x\u001A\u0004\b$\u00104R\u0017\u0010%\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b%\u0010x\u001A\u0004\b%\u00104R\u0017\u0010&\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b&\u0010x\u001A\u0004\b&\u00104R\u0017\u0010\'\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\'\u0010x\u001A\u0004\b\'\u00104R\u0017\u0010(\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b(\u0010x\u001A\u0004\b(\u00104R\u0017\u0010)\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b)\u0010x\u001A\u0004\b)\u00104R\u0018\u0010*\u001A\u00020\u00038\u0006\u00A2\u0006\r\n\u0004\b*\u0010v\u001A\u0005\b\u008E\u0001\u0010;R\u0018\u0010+\u001A\u00020\f8\u0006\u00A2\u0006\r\n\u0004\b+\u0010z\u001A\u0005\b\u008F\u0001\u0010JR)\u0010.\u001A\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-8\u0006\u00A2\u0006\u000E\n\u0005\b.\u0010\u0090\u0001\u001A\u0005\b\u0091\u0001\u0010jR\u001B\u00100\u001A\u0004\u0018\u00010/8\u0006\u00A2\u0006\u000E\n\u0005\b0\u0010\u0092\u0001\u001A\u0005\b\u0093\u0001\u0010l\u00A8\u0006\u0094\u0001"}, d2 = {"Lcom/melon/net/res/v3/CommentConfig;", "Lba/s;", "Landroid/os/Parcelable;", "", "pageNo", "", "isPlayFilterUse", "isValid", "isLikeAvailable", "count", "isBlindChannel", "isBlindWrite", "", "blindText", "startSeq", "needCheckArtistFan", "isArtistFan", "isBreakMember", "breakMemberGuideUrl", "breakMemberGuideAppScheme", "breakMemberGuideText", "channelSeq", "channelName", "contentRefValue", "parentCommentSeq", "replyPlaceholder", "replyMinLength", "replyMaxLength", "isReportable", "isReplyAvailable", "isPinAvailable", "isPlayFilterable", "reportWindowUrl", "writePlaceholderText", "writeMaxLength", "writeMinLength", "isSongAttachable", "isImageAttachable", "isVideoAttachable", "isLinkAttachable", "isKakaoEmoticonAttachable", "isAttachable", "attachMaxCount", "cmtImageUploadDomain", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoLinkPermitList", "Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;", "linkInfo", "<init>", "(IZZZIZZLjava/lang/String;IZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IIZZZZLjava/lang/String;Ljava/lang/String;IIZZZZZZILjava/lang/String;Ljava/util/ArrayList;Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;)V", "isFanTalk", "()Z", "Lcom/melon/net/res/v3/CommentUiModel;", "comment", "hasCommentMoreOption", "(Lcom/melon/net/res/v3/CommentUiModel;)Z", "isRecommendAvailable", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "()Ljava/lang/String;", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "()Ljava/util/ArrayList;", "component40", "()Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;", "copy", "(IZZZIZZLjava/lang/String;IZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;IIZZZZLjava/lang/String;Ljava/lang/String;IIZZZZZZILjava/lang/String;Ljava/util/ArrayList;Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;)Lcom/melon/net/res/v3/CommentConfig;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "isCommentGeneralStatus", "I", "getPageNo", "Z", "getCount", "Ljava/lang/String;", "getBlindText", "getStartSeq", "getNeedCheckArtistFan", "getBreakMemberGuideUrl", "getBreakMemberGuideAppScheme", "getBreakMemberGuideText", "getChannelSeq", "getChannelName", "getContentRefValue", "getParentCommentSeq", "setParentCommentSeq", "(I)V", "getReplyPlaceholder", "getReplyMinLength", "getReplyMaxLength", "getReportWindowUrl", "getWritePlaceholderText", "getWriteMaxLength", "getWriteMinLength", "getAttachMaxCount", "getCmtImageUploadDomain", "Ljava/util/ArrayList;", "getVideoLinkPermitList", "Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;", "getLinkInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommentConfig implements Parcelable, s {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class Creator implements Parcelable.Creator {
        public final CommentConfig createFromParcel(Parcel parcel0) {
            boolean z17;
            boolean z16;
            boolean z15;
            boolean z14;
            boolean z13;
            boolean z11;
            boolean z10;
            boolean z9;
            boolean z7;
            boolean z6;
            boolean z4;
            int v2;
            boolean z3;
            boolean z2;
            q.g(parcel0, "parcel");
            int v = parcel0.readInt();
            boolean z = false;
            boolean z1 = true;
            if(parcel0.readInt() != 0) {
                z = true;
            }
            if(parcel0.readInt() == 0) {
                z2 = true;
                z1 = false;
            }
            else {
                z2 = true;
            }
            if(parcel0.readInt() == 0) {
                z2 = false;
            }
            int v1 = parcel0.readInt();
            if(parcel0.readInt() == 0) {
                z3 = true;
                v2 = v1;
                z4 = false;
            }
            else {
                z3 = true;
                v2 = v1;
                z4 = true;
            }
            if(parcel0.readInt() == 0) {
                z3 = false;
            }
            String s = parcel0.readString();
            boolean z5 = true;
            int v3 = parcel0.readInt();
            if(parcel0.readInt() == 0) {
                z6 = true;
                z5 = false;
            }
            else {
                z6 = true;
            }
            if(parcel0.readInt() == 0) {
                z7 = true;
                z6 = false;
            }
            else {
                z7 = true;
            }
            if(parcel0.readInt() == 0) {
                z7 = false;
            }
            String s1 = parcel0.readString();
            String s2 = parcel0.readString();
            String s3 = parcel0.readString();
            int v4 = parcel0.readInt();
            String s4 = parcel0.readString();
            String s5 = parcel0.readString();
            int v5 = parcel0.readInt();
            String s6 = parcel0.readString();
            int v6 = parcel0.readInt();
            boolean z8 = true;
            int v7 = parcel0.readInt();
            if(parcel0.readInt() == 0) {
                z9 = true;
                z8 = false;
            }
            else {
                z9 = true;
            }
            if(parcel0.readInt() == 0) {
                z10 = true;
                z9 = false;
            }
            else {
                z10 = true;
            }
            if(parcel0.readInt() == 0) {
                z11 = true;
                z10 = false;
            }
            else {
                z11 = true;
            }
            if(parcel0.readInt() == 0) {
                z11 = false;
            }
            String s7 = parcel0.readString();
            String s8 = parcel0.readString();
            int v8 = parcel0.readInt();
            boolean z12 = true;
            int v9 = parcel0.readInt();
            if(parcel0.readInt() == 0) {
                z13 = true;
                z12 = false;
            }
            else {
                z13 = true;
            }
            if(parcel0.readInt() == 0) {
                z14 = true;
                z13 = false;
            }
            else {
                z14 = true;
            }
            if(parcel0.readInt() == 0) {
                z15 = true;
                z14 = false;
            }
            else {
                z15 = true;
            }
            if(parcel0.readInt() == 0) {
                z16 = true;
                z15 = false;
            }
            else {
                z16 = true;
            }
            if(parcel0.readInt() == 0) {
                z17 = true;
                z16 = false;
            }
            else {
                z17 = true;
            }
            if(parcel0.readInt() == 0) {
                z17 = false;
            }
            return new CommentConfig(v, z, z1, z2, v2, z4, z3, s, v3, z5, z6, z7, s1, s2, s3, v4, s4, s5, v5, s6, v6, v7, z8, z9, z10, z11, s7, s8, v8, v9, z12, z13, z14, z15, z16, z17, parcel0.readInt(), parcel0.readString(), parcel0.createStringArrayList(), ((LinkInfo)parcel0.readSerializable()));
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        public final CommentConfig[] newArray(int v) {
            return new CommentConfig[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator CREATOR;
    private final int attachMaxCount;
    @NotNull
    private final String blindText;
    @NotNull
    private final String breakMemberGuideAppScheme;
    @NotNull
    private final String breakMemberGuideText;
    @NotNull
    private final String breakMemberGuideUrl;
    @NotNull
    private final String channelName;
    private final int channelSeq;
    @NotNull
    private final String cmtImageUploadDomain;
    @NotNull
    private final String contentRefValue;
    private final int count;
    private final boolean isArtistFan;
    private final boolean isAttachable;
    private final boolean isBlindChannel;
    private final boolean isBlindWrite;
    private final boolean isBreakMember;
    private final boolean isImageAttachable;
    private final boolean isKakaoEmoticonAttachable;
    private final boolean isLikeAvailable;
    private final boolean isLinkAttachable;
    private final boolean isPinAvailable;
    private final boolean isPlayFilterUse;
    private final boolean isPlayFilterable;
    private final boolean isReplyAvailable;
    private final boolean isReportable;
    private final boolean isSongAttachable;
    private final boolean isValid;
    private final boolean isVideoAttachable;
    @Nullable
    private final LinkInfo linkInfo;
    private final boolean needCheckArtistFan;
    private final int pageNo;
    private int parentCommentSeq;
    private final int replyMaxLength;
    private final int replyMinLength;
    @NotNull
    private final String replyPlaceholder;
    @NotNull
    private final String reportWindowUrl;
    private final int startSeq;
    @NotNull
    private final ArrayList videoLinkPermitList;
    private final int writeMaxLength;
    private final int writeMinLength;
    @NotNull
    private final String writePlaceholderText;

    static {
        CommentConfig.CREATOR = new Creator();
    }

    public CommentConfig(int v, boolean z, boolean z1, boolean z2, int v1, boolean z3, boolean z4, @NotNull String s, int v2, boolean z5, boolean z6, boolean z7, @NotNull String s1, @NotNull String s2, @NotNull String s3, int v3, @NotNull String s4, @NotNull String s5, int v4, @NotNull String s6, int v5, int v6, boolean z8, boolean z9, boolean z10, boolean z11, @NotNull String s7, @NotNull String s8, int v7, int v8, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, int v9, @NotNull String s9, @NotNull ArrayList arrayList0, @Nullable LinkInfo loadPgnRes$Result$ChnlInfo$LinkInfo0) {
        q.g(s, "blindText");
        q.g(s1, "breakMemberGuideUrl");
        q.g(s2, "breakMemberGuideAppScheme");
        q.g(s3, "breakMemberGuideText");
        q.g(s4, "channelName");
        q.g(s5, "contentRefValue");
        q.g(s6, "replyPlaceholder");
        q.g(s7, "reportWindowUrl");
        q.g(s8, "writePlaceholderText");
        q.g(s9, "cmtImageUploadDomain");
        q.g(arrayList0, "videoLinkPermitList");
        super();
        this.pageNo = v;
        this.isPlayFilterUse = z;
        this.isValid = z1;
        this.isLikeAvailable = z2;
        this.count = v1;
        this.isBlindChannel = z3;
        this.isBlindWrite = z4;
        this.blindText = s;
        this.startSeq = v2;
        this.needCheckArtistFan = z5;
        this.isArtistFan = z6;
        this.isBreakMember = z7;
        this.breakMemberGuideUrl = s1;
        this.breakMemberGuideAppScheme = s2;
        this.breakMemberGuideText = s3;
        this.channelSeq = v3;
        this.channelName = s4;
        this.contentRefValue = s5;
        this.parentCommentSeq = v4;
        this.replyPlaceholder = s6;
        this.replyMinLength = v5;
        this.replyMaxLength = v6;
        this.isReportable = z8;
        this.isReplyAvailable = z9;
        this.isPinAvailable = z10;
        this.isPlayFilterable = z11;
        this.reportWindowUrl = s7;
        this.writePlaceholderText = s8;
        this.writeMaxLength = v7;
        this.writeMinLength = v8;
        this.isSongAttachable = z12;
        this.isImageAttachable = z13;
        this.isVideoAttachable = z14;
        this.isLinkAttachable = z15;
        this.isKakaoEmoticonAttachable = z16;
        this.isAttachable = z17;
        this.attachMaxCount = v9;
        this.cmtImageUploadDomain = s9;
        this.videoLinkPermitList = arrayList0;
        this.linkInfo = loadPgnRes$Result$ChnlInfo$LinkInfo0;
    }

    public CommentConfig(int v, boolean z, boolean z1, boolean z2, int v1, boolean z3, boolean z4, String s, int v2, boolean z5, boolean z6, boolean z7, String s1, String s2, String s3, int v3, String s4, String s5, int v4, String s6, int v5, int v6, boolean z8, boolean z9, boolean z10, boolean z11, String s7, String s8, int v7, int v8, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, int v9, String s9, ArrayList arrayList0, LinkInfo loadPgnRes$Result$ChnlInfo$LinkInfo0, int v10, int v11, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, z, z1, z2, v1, z3, ((v10 & 0x40) == 0 ? z4 : false), ((v10 & 0x80) == 0 ? s : ""), v2, z5, z6, z7, s1, s2, ((v10 & 0x4000) == 0 ? s3 : ""), v3, s4, s5, ((v10 & 0x40000) == 0 ? v4 : -1), s6, v5, v6, z8, z9, z10, z11, s7, s8, v7, v8, z12, z13, z14, z15, z16, z17, v9, s9, arrayList0, loadPgnRes$Result$ChnlInfo$LinkInfo0);
    }

    public final int component1() {
        return this.pageNo;
    }

    public final boolean component10() {
        return this.needCheckArtistFan;
    }

    public final boolean component11() {
        return this.isArtistFan;
    }

    public final boolean component12() {
        return this.isBreakMember;
    }

    @NotNull
    public final String component13() {
        return this.breakMemberGuideUrl;
    }

    @NotNull
    public final String component14() {
        return this.breakMemberGuideAppScheme;
    }

    @NotNull
    public final String component15() {
        return this.breakMemberGuideText;
    }

    public final int component16() {
        return this.channelSeq;
    }

    @NotNull
    public final String component17() {
        return this.channelName;
    }

    @NotNull
    public final String component18() {
        return this.contentRefValue;
    }

    public final int component19() {
        return this.parentCommentSeq;
    }

    public final boolean component2() {
        return this.isPlayFilterUse;
    }

    @NotNull
    public final String component20() {
        return this.replyPlaceholder;
    }

    public final int component21() {
        return this.replyMinLength;
    }

    public final int component22() {
        return this.replyMaxLength;
    }

    public final boolean component23() {
        return this.isReportable;
    }

    public final boolean component24() {
        return this.isReplyAvailable;
    }

    public final boolean component25() {
        return this.isPinAvailable;
    }

    public final boolean component26() {
        return this.isPlayFilterable;
    }

    @NotNull
    public final String component27() {
        return this.reportWindowUrl;
    }

    @NotNull
    public final String component28() {
        return this.writePlaceholderText;
    }

    public final int component29() {
        return this.writeMaxLength;
    }

    public final boolean component3() {
        return this.isValid;
    }

    public final int component30() {
        return this.writeMinLength;
    }

    public final boolean component31() {
        return this.isSongAttachable;
    }

    public final boolean component32() {
        return this.isImageAttachable;
    }

    public final boolean component33() {
        return this.isVideoAttachable;
    }

    public final boolean component34() {
        return this.isLinkAttachable;
    }

    public final boolean component35() {
        return this.isKakaoEmoticonAttachable;
    }

    public final boolean component36() {
        return this.isAttachable;
    }

    public final int component37() {
        return this.attachMaxCount;
    }

    @NotNull
    public final String component38() {
        return this.cmtImageUploadDomain;
    }

    @NotNull
    public final ArrayList component39() {
        return this.videoLinkPermitList;
    }

    public final boolean component4() {
        return this.isLikeAvailable;
    }

    @Nullable
    public final LinkInfo component40() {
        return this.linkInfo;
    }

    public final int component5() {
        return this.count;
    }

    public final boolean component6() {
        return this.isBlindChannel;
    }

    public final boolean component7() {
        return this.isBlindWrite;
    }

    @NotNull
    public final String component8() {
        return this.blindText;
    }

    public final int component9() {
        return this.startSeq;
    }

    @NotNull
    public final CommentConfig copy(int v, boolean z, boolean z1, boolean z2, int v1, boolean z3, boolean z4, @NotNull String s, int v2, boolean z5, boolean z6, boolean z7, @NotNull String s1, @NotNull String s2, @NotNull String s3, int v3, @NotNull String s4, @NotNull String s5, int v4, @NotNull String s6, int v5, int v6, boolean z8, boolean z9, boolean z10, boolean z11, @NotNull String s7, @NotNull String s8, int v7, int v8, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, int v9, @NotNull String s9, @NotNull ArrayList arrayList0, @Nullable LinkInfo loadPgnRes$Result$ChnlInfo$LinkInfo0) {
        q.g(s, "blindText");
        q.g(s1, "breakMemberGuideUrl");
        q.g(s2, "breakMemberGuideAppScheme");
        q.g(s3, "breakMemberGuideText");
        q.g(s4, "channelName");
        q.g(s5, "contentRefValue");
        q.g(s6, "replyPlaceholder");
        q.g(s7, "reportWindowUrl");
        q.g(s8, "writePlaceholderText");
        q.g(s9, "cmtImageUploadDomain");
        q.g(arrayList0, "videoLinkPermitList");
        return new CommentConfig(v, z, z1, z2, v1, z3, z4, s, v2, z5, z6, z7, s1, s2, s3, v3, s4, s5, v4, s6, v5, v6, z8, z9, z10, z11, s7, s8, v7, v8, z12, z13, z14, z15, z16, z17, v9, s9, arrayList0, loadPgnRes$Result$ChnlInfo$LinkInfo0);
    }

    public static CommentConfig copy$default(CommentConfig commentConfig0, int v, boolean z, boolean z1, boolean z2, int v1, boolean z3, boolean z4, String s, int v2, boolean z5, boolean z6, boolean z7, String s1, String s2, String s3, int v3, String s4, String s5, int v4, String s6, int v5, int v6, boolean z8, boolean z9, boolean z10, boolean z11, String s7, String s8, int v7, int v8, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, int v9, String s9, ArrayList arrayList0, LinkInfo loadPgnRes$Result$ChnlInfo$LinkInfo0, int v10, int v11, Object object0) {
        int v12 = (v10 & 1) == 0 ? v : commentConfig0.pageNo;
        boolean z18 = (v10 & 2) == 0 ? z : commentConfig0.isPlayFilterUse;
        boolean z19 = (v10 & 4) == 0 ? z1 : commentConfig0.isValid;
        boolean z20 = (v10 & 8) == 0 ? z2 : commentConfig0.isLikeAvailable;
        int v13 = (v10 & 16) == 0 ? v1 : commentConfig0.count;
        boolean z21 = (v10 & 0x20) == 0 ? z3 : commentConfig0.isBlindChannel;
        boolean z22 = (v10 & 0x40) == 0 ? z4 : commentConfig0.isBlindWrite;
        String s10 = (v10 & 0x80) == 0 ? s : commentConfig0.blindText;
        int v14 = (v10 & 0x100) == 0 ? v2 : commentConfig0.startSeq;
        boolean z23 = (v10 & 0x200) == 0 ? z5 : commentConfig0.needCheckArtistFan;
        boolean z24 = (v10 & 0x400) == 0 ? z6 : commentConfig0.isArtistFan;
        boolean z25 = (v10 & 0x800) == 0 ? z7 : commentConfig0.isBreakMember;
        String s11 = (v10 & 0x1000) == 0 ? s1 : commentConfig0.breakMemberGuideUrl;
        String s12 = (v10 & 0x2000) == 0 ? s2 : commentConfig0.breakMemberGuideAppScheme;
        String s13 = (v10 & 0x4000) == 0 ? s3 : commentConfig0.breakMemberGuideText;
        int v15 = (v10 & 0x8000) == 0 ? v3 : commentConfig0.channelSeq;
        String s14 = (v10 & 0x10000) == 0 ? s4 : commentConfig0.channelName;
        String s15 = (v10 & 0x20000) == 0 ? s5 : commentConfig0.contentRefValue;
        int v16 = (v10 & 0x40000) == 0 ? v4 : commentConfig0.parentCommentSeq;
        String s16 = (v10 & 0x80000) == 0 ? s6 : commentConfig0.replyPlaceholder;
        int v17 = (v10 & 0x100000) == 0 ? v5 : commentConfig0.replyMinLength;
        int v18 = (v10 & 0x200000) == 0 ? v6 : commentConfig0.replyMaxLength;
        boolean z26 = (v10 & 0x400000) == 0 ? z8 : commentConfig0.isReportable;
        boolean z27 = (v10 & 0x800000) == 0 ? z9 : commentConfig0.isReplyAvailable;
        boolean z28 = (v10 & 0x1000000) == 0 ? z10 : commentConfig0.isPinAvailable;
        boolean z29 = (v10 & 0x2000000) == 0 ? z11 : commentConfig0.isPlayFilterable;
        String s17 = (v10 & 0x4000000) == 0 ? s7 : commentConfig0.reportWindowUrl;
        String s18 = (v10 & 0x8000000) == 0 ? s8 : commentConfig0.writePlaceholderText;
        int v19 = (v10 & 0x10000000) == 0 ? v7 : commentConfig0.writeMaxLength;
        int v20 = (v10 & 0x20000000) == 0 ? v8 : commentConfig0.writeMinLength;
        boolean z30 = (v10 & 0x40000000) == 0 ? z12 : commentConfig0.isSongAttachable;
        boolean z31 = (v10 & 0x80000000) == 0 ? z13 : commentConfig0.isImageAttachable;
        boolean z32 = (v11 & 1) == 0 ? z14 : commentConfig0.isVideoAttachable;
        boolean z33 = (v11 & 2) == 0 ? z15 : commentConfig0.isLinkAttachable;
        boolean z34 = (v11 & 4) == 0 ? z16 : commentConfig0.isKakaoEmoticonAttachable;
        boolean z35 = (v11 & 8) == 0 ? z17 : commentConfig0.isAttachable;
        int v21 = (v11 & 16) == 0 ? v9 : commentConfig0.attachMaxCount;
        String s19 = (v11 & 0x20) == 0 ? s9 : commentConfig0.cmtImageUploadDomain;
        ArrayList arrayList1 = (v11 & 0x40) == 0 ? arrayList0 : commentConfig0.videoLinkPermitList;
        return (v11 & 0x80) == 0 ? commentConfig0.copy(v12, z18, z19, z20, v13, z21, z22, s10, v14, z23, z24, z25, s11, s12, s13, v15, s14, s15, v16, s16, v17, v18, z26, z27, z28, z29, s17, s18, v19, v20, z30, z31, z32, z33, z34, z35, v21, s19, arrayList1, loadPgnRes$Result$ChnlInfo$LinkInfo0) : commentConfig0.copy(v12, z18, z19, z20, v13, z21, z22, s10, v14, z23, z24, z25, s11, s12, s13, v15, s14, s15, v16, s16, v17, v18, z26, z27, z28, z29, s17, s18, v19, v20, z30, z31, z32, z33, z34, z35, v21, s19, arrayList1, commentConfig0.linkInfo);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CommentConfig)) {
            return false;
        }
        CommentConfig commentConfig0 = (CommentConfig)object0;
        if(this.pageNo != commentConfig0.pageNo) {
            return false;
        }
        if(this.isPlayFilterUse != commentConfig0.isPlayFilterUse) {
            return false;
        }
        if(this.isValid != commentConfig0.isValid) {
            return false;
        }
        if(this.isLikeAvailable != commentConfig0.isLikeAvailable) {
            return false;
        }
        if(this.count != commentConfig0.count) {
            return false;
        }
        if(this.isBlindChannel != commentConfig0.isBlindChannel) {
            return false;
        }
        if(this.isBlindWrite != commentConfig0.isBlindWrite) {
            return false;
        }
        if(!q.b(this.blindText, commentConfig0.blindText)) {
            return false;
        }
        if(this.startSeq != commentConfig0.startSeq) {
            return false;
        }
        if(this.needCheckArtistFan != commentConfig0.needCheckArtistFan) {
            return false;
        }
        if(this.isArtistFan != commentConfig0.isArtistFan) {
            return false;
        }
        if(this.isBreakMember != commentConfig0.isBreakMember) {
            return false;
        }
        if(!q.b(this.breakMemberGuideUrl, commentConfig0.breakMemberGuideUrl)) {
            return false;
        }
        if(!q.b(this.breakMemberGuideAppScheme, commentConfig0.breakMemberGuideAppScheme)) {
            return false;
        }
        if(!q.b(this.breakMemberGuideText, commentConfig0.breakMemberGuideText)) {
            return false;
        }
        if(this.channelSeq != commentConfig0.channelSeq) {
            return false;
        }
        if(!q.b(this.channelName, commentConfig0.channelName)) {
            return false;
        }
        if(!q.b(this.contentRefValue, commentConfig0.contentRefValue)) {
            return false;
        }
        if(this.parentCommentSeq != commentConfig0.parentCommentSeq) {
            return false;
        }
        if(!q.b(this.replyPlaceholder, commentConfig0.replyPlaceholder)) {
            return false;
        }
        if(this.replyMinLength != commentConfig0.replyMinLength) {
            return false;
        }
        if(this.replyMaxLength != commentConfig0.replyMaxLength) {
            return false;
        }
        if(this.isReportable != commentConfig0.isReportable) {
            return false;
        }
        if(this.isReplyAvailable != commentConfig0.isReplyAvailable) {
            return false;
        }
        if(this.isPinAvailable != commentConfig0.isPinAvailable) {
            return false;
        }
        if(this.isPlayFilterable != commentConfig0.isPlayFilterable) {
            return false;
        }
        if(!q.b(this.reportWindowUrl, commentConfig0.reportWindowUrl)) {
            return false;
        }
        if(!q.b(this.writePlaceholderText, commentConfig0.writePlaceholderText)) {
            return false;
        }
        if(this.writeMaxLength != commentConfig0.writeMaxLength) {
            return false;
        }
        if(this.writeMinLength != commentConfig0.writeMinLength) {
            return false;
        }
        if(this.isSongAttachable != commentConfig0.isSongAttachable) {
            return false;
        }
        if(this.isImageAttachable != commentConfig0.isImageAttachable) {
            return false;
        }
        if(this.isVideoAttachable != commentConfig0.isVideoAttachable) {
            return false;
        }
        if(this.isLinkAttachable != commentConfig0.isLinkAttachable) {
            return false;
        }
        if(this.isKakaoEmoticonAttachable != commentConfig0.isKakaoEmoticonAttachable) {
            return false;
        }
        if(this.isAttachable != commentConfig0.isAttachable) {
            return false;
        }
        if(this.attachMaxCount != commentConfig0.attachMaxCount) {
            return false;
        }
        if(!q.b(this.cmtImageUploadDomain, commentConfig0.cmtImageUploadDomain)) {
            return false;
        }
        return q.b(this.videoLinkPermitList, commentConfig0.videoLinkPermitList) ? q.b(this.linkInfo, commentConfig0.linkInfo) : false;
    }

    public final int getAttachMaxCount() {
        return this.attachMaxCount;
    }

    @NotNull
    public final String getBlindText() {
        return this.blindText;
    }

    @NotNull
    public final String getBreakMemberGuideAppScheme() {
        return this.breakMemberGuideAppScheme;
    }

    @NotNull
    public final String getBreakMemberGuideText() {
        return this.breakMemberGuideText;
    }

    @NotNull
    public final String getBreakMemberGuideUrl() {
        return this.breakMemberGuideUrl;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelSeq() {
        return this.channelSeq;
    }

    @NotNull
    public final String getCmtImageUploadDomain() {
        return this.cmtImageUploadDomain;
    }

    @NotNull
    public final String getContentRefValue() {
        return this.contentRefValue;
    }

    public final int getCount() {
        return this.count;
    }

    @Nullable
    public final LinkInfo getLinkInfo() {
        return this.linkInfo;
    }

    public final boolean getNeedCheckArtistFan() {
        return this.needCheckArtistFan;
    }

    public final int getPageNo() {
        return this.pageNo;
    }

    public final int getParentCommentSeq() {
        return this.parentCommentSeq;
    }

    public final int getReplyMaxLength() {
        return this.replyMaxLength;
    }

    public final int getReplyMinLength() {
        return this.replyMinLength;
    }

    @NotNull
    public final String getReplyPlaceholder() {
        return this.replyPlaceholder;
    }

    @NotNull
    public final String getReportWindowUrl() {
        return this.reportWindowUrl;
    }

    public final int getStartSeq() {
        return this.startSeq;
    }

    @NotNull
    public final ArrayList getVideoLinkPermitList() {
        return this.videoLinkPermitList;
    }

    public final int getWriteMaxLength() {
        return this.writeMaxLength;
    }

    public final int getWriteMinLength() {
        return this.writeMinLength;
    }

    @NotNull
    public final String getWritePlaceholderText() {
        return this.writePlaceholderText;
    }

    public final boolean hasCommentMoreOption(@NotNull CommentUiModel commentUiModel0) {
        q.g(commentUiModel0, "comment");
        return commentUiModel0.isEditable() || this.isCommentGeneralStatus(commentUiModel0);
    }

    @Override
    public int hashCode() {
        int v = x.b(d.b(this.attachMaxCount, d.e(d.e(d.e(d.e(d.e(d.e(d.b(this.writeMinLength, d.b(this.writeMaxLength, x.b(x.b(d.e(d.e(d.e(d.e(d.b(this.replyMaxLength, d.b(this.replyMinLength, x.b(d.b(this.parentCommentSeq, x.b(x.b(d.b(this.channelSeq, x.b(x.b(x.b(d.e(d.e(d.e(d.b(this.startSeq, x.b(d.e(d.e(d.b(this.count, d.e(d.e(d.e(this.pageNo * 0x1F, 0x1F, this.isPlayFilterUse), 0x1F, this.isValid), 0x1F, this.isLikeAvailable), 0x1F), 0x1F, this.isBlindChannel), 0x1F, this.isBlindWrite), 0x1F, this.blindText), 0x1F), 0x1F, this.needCheckArtistFan), 0x1F, this.isArtistFan), 0x1F, this.isBreakMember), 0x1F, this.breakMemberGuideUrl), 0x1F, this.breakMemberGuideAppScheme), 0x1F, this.breakMemberGuideText), 0x1F), 0x1F, this.channelName), 0x1F, this.contentRefValue), 0x1F), 0x1F, this.replyPlaceholder), 0x1F), 0x1F), 0x1F, this.isReportable), 0x1F, this.isReplyAvailable), 0x1F, this.isPinAvailable), 0x1F, this.isPlayFilterable), 0x1F, this.reportWindowUrl), 0x1F, this.writePlaceholderText), 0x1F), 0x1F), 0x1F, this.isSongAttachable), 0x1F, this.isImageAttachable), 0x1F, this.isVideoAttachable), 0x1F, this.isLinkAttachable), 0x1F, this.isKakaoEmoticonAttachable), 0x1F, this.isAttachable), 0x1F), 0x1F, this.cmtImageUploadDomain);
        int v1 = this.videoLinkPermitList.hashCode();
        return this.linkInfo == null ? (v1 + v) * 0x1F : (v1 + v) * 0x1F + this.linkInfo.hashCode();
    }

    public final boolean isArtistFan() {
        return this.isArtistFan;
    }

    public final boolean isAttachable() {
        return this.isAttachable;
    }

    public final boolean isBlindChannel() {
        return this.isBlindChannel;
    }

    public final boolean isBlindWrite() {
        return this.isBlindWrite;
    }

    public final boolean isBreakMember() {
        return this.isBreakMember;
    }

    // 去混淆评级： 低(20)
    private final boolean isCommentGeneralStatus(CommentUiModel commentUiModel0) {
        return this.isReportable && this.isReportable(commentUiModel0);
    }

    public final boolean isFanTalk() {
        return this.channelSeq == 101;
    }

    public final boolean isImageAttachable() {
        return this.isImageAttachable;
    }

    public final boolean isKakaoEmoticonAttachable() {
        return this.isKakaoEmoticonAttachable;
    }

    public final boolean isLikeAvailable() {
        return this.isLikeAvailable;
    }

    public final boolean isLinkAttachable() {
        return this.isLinkAttachable;
    }

    public final boolean isPinAvailable() {
        return this.isPinAvailable;
    }

    public final boolean isPlayFilterUse() {
        return this.isPlayFilterUse;
    }

    public final boolean isPlayFilterable() {
        return this.isPlayFilterable;
    }

    // 去混淆评级： 低(20)
    public final boolean isRecommendAvailable(@NotNull CommentUiModel commentUiModel0) {
        q.g(commentUiModel0, "comment");
        return !commentUiModel0.isBlocked() && !commentUiModel0.isNotice() && this.isLikeAvailable && !commentUiModel0.isTempAction();
    }

    public final boolean isReplyAvailable() {
        return this.isReplyAvailable;
    }

    public final boolean isReplyAvailable(@NotNull CommentUiModel commentUiModel0) {
        q.g(commentUiModel0, "comment");
        return !commentUiModel0.isNotice() && this.isReplyAvailable && !commentUiModel0.isTempAction();
    }

    private final boolean isReportable(CommentUiModel commentUiModel0) {
        if(!commentUiModel0.isBlocked() && !commentUiModel0.isNotice() && !commentUiModel0.getMemberCmtFlag()) {
            Iterable iterable0 = k.A(new Predicate[]{StringIds.i, StringIds.j, StringIds.k});
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                for(Object object0: iterable0) {
                    if(StringIds.a(commentUiModel0.getMemberKey(), ((Predicate)object0))) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return !commentUiModel0.isTempAction();
        }
        return false;
    }

    public final boolean isReportable() {
        return this.isReportable;
    }

    public final boolean isSongAttachable() {
        return this.isSongAttachable;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public final boolean isVideoAttachable() {
        return this.isVideoAttachable;
    }

    public final void setParentCommentSeq(int v) {
        this.parentCommentSeq = v;
    }

    @Override
    @NotNull
    public String toString() {
        int v = this.parentCommentSeq;
        StringBuilder stringBuilder0 = new StringBuilder("CommentConfig(pageNo=");
        stringBuilder0.append(this.pageNo);
        stringBuilder0.append(", isPlayFilterUse=");
        stringBuilder0.append(this.isPlayFilterUse);
        stringBuilder0.append(", isValid=");
        x.y(stringBuilder0, this.isValid, ", isLikeAvailable=", this.isLikeAvailable, ", count=");
        stringBuilder0.append(this.count);
        stringBuilder0.append(", isBlindChannel=");
        stringBuilder0.append(this.isBlindChannel);
        stringBuilder0.append(", isBlindWrite=");
        Y.y(stringBuilder0, this.isBlindWrite, ", blindText=", this.blindText, ", startSeq=");
        stringBuilder0.append(this.startSeq);
        stringBuilder0.append(", needCheckArtistFan=");
        stringBuilder0.append(this.needCheckArtistFan);
        stringBuilder0.append(", isArtistFan=");
        x.y(stringBuilder0, this.isArtistFan, ", isBreakMember=", this.isBreakMember, ", breakMemberGuideUrl=");
        d.u(stringBuilder0, this.breakMemberGuideUrl, ", breakMemberGuideAppScheme=", this.breakMemberGuideAppScheme, ", breakMemberGuideText=");
        d.t(stringBuilder0, this.breakMemberGuideText, ", channelSeq=", this.channelSeq, ", channelName=");
        d.u(stringBuilder0, this.channelName, ", contentRefValue=", this.contentRefValue, ", parentCommentSeq=");
        stringBuilder0.append(v);
        stringBuilder0.append(", replyPlaceholder=");
        stringBuilder0.append(this.replyPlaceholder);
        stringBuilder0.append(", replyMinLength=");
        x.x(stringBuilder0, this.replyMinLength, ", replyMaxLength=", this.replyMaxLength, ", isReportable=");
        x.y(stringBuilder0, this.isReportable, ", isReplyAvailable=", this.isReplyAvailable, ", isPinAvailable=");
        x.y(stringBuilder0, this.isPinAvailable, ", isPlayFilterable=", this.isPlayFilterable, ", reportWindowUrl=");
        d.u(stringBuilder0, this.reportWindowUrl, ", writePlaceholderText=", this.writePlaceholderText, ", writeMaxLength=");
        x.x(stringBuilder0, this.writeMaxLength, ", writeMinLength=", this.writeMinLength, ", isSongAttachable=");
        x.y(stringBuilder0, this.isSongAttachable, ", isImageAttachable=", this.isImageAttachable, ", isVideoAttachable=");
        x.y(stringBuilder0, this.isVideoAttachable, ", isLinkAttachable=", this.isLinkAttachable, ", isKakaoEmoticonAttachable=");
        x.y(stringBuilder0, this.isKakaoEmoticonAttachable, ", isAttachable=", this.isAttachable, ", attachMaxCount=");
        stringBuilder0.append(this.attachMaxCount);
        stringBuilder0.append(", cmtImageUploadDomain=");
        stringBuilder0.append(this.cmtImageUploadDomain);
        stringBuilder0.append(", videoLinkPermitList=");
        stringBuilder0.append(this.videoLinkPermitList);
        stringBuilder0.append(", linkInfo=");
        stringBuilder0.append(this.linkInfo);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeInt(this.pageNo);
        parcel0.writeInt(((int)this.isPlayFilterUse));
        parcel0.writeInt(((int)this.isValid));
        parcel0.writeInt(((int)this.isLikeAvailable));
        parcel0.writeInt(this.count);
        parcel0.writeInt(((int)this.isBlindChannel));
        parcel0.writeInt(((int)this.isBlindWrite));
        parcel0.writeString(this.blindText);
        parcel0.writeInt(this.startSeq);
        parcel0.writeInt(((int)this.needCheckArtistFan));
        parcel0.writeInt(((int)this.isArtistFan));
        parcel0.writeInt(((int)this.isBreakMember));
        parcel0.writeString(this.breakMemberGuideUrl);
        parcel0.writeString(this.breakMemberGuideAppScheme);
        parcel0.writeString(this.breakMemberGuideText);
        parcel0.writeInt(this.channelSeq);
        parcel0.writeString(this.channelName);
        parcel0.writeString(this.contentRefValue);
        parcel0.writeInt(this.parentCommentSeq);
        parcel0.writeString(this.replyPlaceholder);
        parcel0.writeInt(this.replyMinLength);
        parcel0.writeInt(this.replyMaxLength);
        parcel0.writeInt(((int)this.isReportable));
        parcel0.writeInt(((int)this.isReplyAvailable));
        parcel0.writeInt(((int)this.isPinAvailable));
        parcel0.writeInt(((int)this.isPlayFilterable));
        parcel0.writeString(this.reportWindowUrl);
        parcel0.writeString(this.writePlaceholderText);
        parcel0.writeInt(this.writeMaxLength);
        parcel0.writeInt(this.writeMinLength);
        parcel0.writeInt(((int)this.isSongAttachable));
        parcel0.writeInt(((int)this.isImageAttachable));
        parcel0.writeInt(((int)this.isVideoAttachable));
        parcel0.writeInt(((int)this.isLinkAttachable));
        parcel0.writeInt(((int)this.isKakaoEmoticonAttachable));
        parcel0.writeInt(((int)this.isAttachable));
        parcel0.writeInt(this.attachMaxCount);
        parcel0.writeString(this.cmtImageUploadDomain);
        parcel0.writeStringList(this.videoLinkPermitList);
        parcel0.writeSerializable(this.linkInfo);
    }
}

