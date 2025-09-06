package com.kakaoent.trevi.ad.domain;

import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0003\b\u008D\u0001\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00AD\u0004\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010.\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010/\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0002\u00101J\u000B\u0010a\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010b\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010c\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010d\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010e\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010f\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010g\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010h\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010i\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010j\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010k\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010l\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010m\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010n\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010o\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010p\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010q\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010r\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010s\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010t\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010u\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010v\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010w\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010x\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010y\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010z\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010{\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010|\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010}\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010~\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u007F\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0080\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0081\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0083\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0084\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0085\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0086\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0088\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u0089\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u008A\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u008B\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u008C\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u008D\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\f\u0010\u008E\u0001\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u00B2\u0004\u0010\u008F\u0001\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001A\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001C\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\'\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010.\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010/\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u00100\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0016\u0010\u0090\u0001\u001A\u00030\u0091\u00012\t\u0010\u0092\u0001\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\u000B\u0010\u0093\u0001\u001A\u00030\u0094\u0001H\u00D6\u0001J\n\u0010\u0095\u0001\u001A\u00020\u0003H\u00D6\u0001R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b2\u00103R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b4\u00103R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b5\u00103R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b6\u00103R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b7\u00103R\u0013\u0010\b\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b8\u00103R\u0013\u0010\t\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b9\u00103R\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b:\u00103R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b;\u00103R\u0013\u0010\f\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b<\u00103R\u0013\u0010\r\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b=\u00103R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b>\u00103R\u0013\u0010\u000F\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b?\u00103R\u0013\u0010\u0010\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b@\u00103R\u0013\u0010\u0011\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bA\u00103R\u0013\u0010\u0012\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bB\u00103R\u0013\u0010\u0013\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bC\u00103R\u0013\u0010\u0014\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bD\u00103R\u0013\u0010\u0015\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bE\u00103R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bF\u00103R\u0013\u0010\u0017\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bG\u00103R\u0013\u0010\u0018\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bH\u00103R\u0013\u0010\u0019\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bI\u00103R\u0013\u0010\u001A\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bJ\u00103R\u0013\u0010\u001B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bK\u00103R\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bL\u00103R\u0013\u0010\u001D\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bM\u00103R\u0013\u0010\u001E\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bN\u00103R\u0013\u0010\u001F\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bO\u00103R\u0013\u0010 \u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bP\u00103R\u0013\u0010!\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bQ\u00103R\u0013\u0010\"\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bR\u00103R\u0013\u0010#\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bS\u00103R\u0013\u0010$\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bT\u00103R\u0013\u0010%\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bU\u00103R\u0013\u0010&\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bV\u00103R\u0013\u0010\'\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bW\u00103R\u0013\u0010(\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bX\u00103R\u0013\u0010)\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bY\u00103R\u0013\u0010*\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\bZ\u00103R\u0013\u0010+\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b[\u00103R\u0013\u0010,\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\\\u00103R\u0013\u0010-\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b]\u00103R\u0013\u0010.\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b^\u00103R\u0013\u0010/\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b_\u00103R\u0013\u00100\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b`\u00103\u00A8\u0006\u0096\u0001"}, d2 = {"Lcom/kakaoent/trevi/ad/domain/TrackResponse;", "", "actSeq", "", "actType", "adSeq", "ask", "bidMinPrice", "campaignSeq", "clientId", "contentId", "contentSeq", "count", "deviceBrowser", "deviceModelName", "deviceOs", "district", "dspAdId", "dspCampaignId", "dspContentId", "dspId", "dt", "evId", "evTime", "eventId", "eventName", "ifa", "impDttm", "impId", "impTime", "impType", "ip", "label", "layer", "pubAppId", "pubId", "pubPlacementId", "redirectUrl", "reqId", "reqTime", "slotId", "sspId", "status", "test", "ua", "unitId", "userInfo_gender", "userInfo_userId", "winPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActSeq", "()Ljava/lang/String;", "getActType", "getAdSeq", "getAsk", "getBidMinPrice", "getCampaignSeq", "getClientId", "getContentId", "getContentSeq", "getCount", "getDeviceBrowser", "getDeviceModelName", "getDeviceOs", "getDistrict", "getDspAdId", "getDspCampaignId", "getDspContentId", "getDspId", "getDt", "getEvId", "getEvTime", "getEventId", "getEventName", "getIfa", "getImpDttm", "getImpId", "getImpTime", "getImpType", "getIp", "getLabel", "getLayer", "getPubAppId", "getPubId", "getPubPlacementId", "getRedirectUrl", "getReqId", "getReqTime", "getSlotId", "getSspId", "getStatus", "getTest", "getUa", "getUnitId", "getUserInfo_gender", "getUserInfo_userId", "getWinPrice", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TrackResponse {
    @Nullable
    private final String actSeq;
    @Nullable
    private final String actType;
    @Nullable
    private final String adSeq;
    @Nullable
    private final String ask;
    @Nullable
    private final String bidMinPrice;
    @Nullable
    private final String campaignSeq;
    @Nullable
    private final String clientId;
    @Nullable
    private final String contentId;
    @Nullable
    private final String contentSeq;
    @Nullable
    private final String count;
    @Nullable
    private final String deviceBrowser;
    @Nullable
    private final String deviceModelName;
    @Nullable
    private final String deviceOs;
    @Nullable
    private final String district;
    @Nullable
    private final String dspAdId;
    @Nullable
    private final String dspCampaignId;
    @Nullable
    private final String dspContentId;
    @Nullable
    private final String dspId;
    @Nullable
    private final String dt;
    @Nullable
    private final String evId;
    @Nullable
    private final String evTime;
    @Nullable
    private final String eventId;
    @Nullable
    private final String eventName;
    @Nullable
    private final String ifa;
    @Nullable
    private final String impDttm;
    @Nullable
    private final String impId;
    @Nullable
    private final String impTime;
    @Nullable
    private final String impType;
    @Nullable
    private final String ip;
    @Nullable
    private final String label;
    @Nullable
    private final String layer;
    @Nullable
    private final String pubAppId;
    @Nullable
    private final String pubId;
    @Nullable
    private final String pubPlacementId;
    @Nullable
    private final String redirectUrl;
    @Nullable
    private final String reqId;
    @Nullable
    private final String reqTime;
    @Nullable
    private final String slotId;
    @Nullable
    private final String sspId;
    @Nullable
    private final String status;
    @Nullable
    private final String test;
    @Nullable
    private final String ua;
    @Nullable
    private final String unitId;
    @Nullable
    private final String userInfo_gender;
    @Nullable
    private final String userInfo_userId;
    @Nullable
    private final String winPrice;

    public TrackResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 0x3FFF, null);
    }

    public TrackResponse(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable String s11, @Nullable String s12, @Nullable String s13, @Nullable String s14, @Nullable String s15, @Nullable String s16, @Nullable String s17, @Nullable String s18, @Nullable String s19, @Nullable String s20, @Nullable String s21, @Nullable String s22, @Nullable String s23, @Nullable String s24, @Nullable String s25, @Nullable String s26, @Nullable String s27, @Nullable String s28, @Nullable String s29, @Nullable String s30, @Nullable String s31, @Nullable String s32, @Nullable String s33, @Nullable String s34, @Nullable String s35, @Nullable String s36, @Nullable String s37, @Nullable String s38, @Nullable String s39, @Nullable String s40, @Nullable String s41, @Nullable String s42, @Nullable String s43, @Nullable String s44, @Nullable String s45) {
        this.actSeq = s;
        this.actType = s1;
        this.adSeq = s2;
        this.ask = s3;
        this.bidMinPrice = s4;
        this.campaignSeq = s5;
        this.clientId = s6;
        this.contentId = s7;
        this.contentSeq = s8;
        this.count = s9;
        this.deviceBrowser = s10;
        this.deviceModelName = s11;
        this.deviceOs = s12;
        this.district = s13;
        this.dspAdId = s14;
        this.dspCampaignId = s15;
        this.dspContentId = s16;
        this.dspId = s17;
        this.dt = s18;
        this.evId = s19;
        this.evTime = s20;
        this.eventId = s21;
        this.eventName = s22;
        this.ifa = s23;
        this.impDttm = s24;
        this.impId = s25;
        this.impTime = s26;
        this.impType = s27;
        this.ip = s28;
        this.label = s29;
        this.layer = s30;
        this.pubAppId = s31;
        this.pubId = s32;
        this.pubPlacementId = s33;
        this.redirectUrl = s34;
        this.reqId = s35;
        this.reqTime = s36;
        this.slotId = s37;
        this.sspId = s38;
        this.status = s39;
        this.test = s40;
        this.ua = s41;
        this.unitId = s42;
        this.userInfo_gender = s43;
        this.userInfo_userId = s44;
        this.winPrice = s45;
    }

    public TrackResponse(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, String s16, String s17, String s18, String s19, String s20, String s21, String s22, String s23, String s24, String s25, String s26, String s27, String s28, String s29, String s30, String s31, String s32, String s33, String s34, String s35, String s36, String s37, String s38, String s39, String s40, String s41, String s42, String s43, String s44, String s45, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(((v & 1) == 0 ? s : null), ((v & 2) == 0 ? s1 : null), ((v & 4) == 0 ? s2 : null), ((v & 8) == 0 ? s3 : null), ((v & 16) == 0 ? s4 : null), ((v & 0x20) == 0 ? s5 : null), ((v & 0x40) == 0 ? s6 : null), ((v & 0x80) == 0 ? s7 : null), ((v & 0x100) == 0 ? s8 : null), ((v & 0x200) == 0 ? s9 : null), ((v & 0x400) == 0 ? s10 : null), ((v & 0x800) == 0 ? s11 : null), ((v & 0x1000) == 0 ? s12 : null), ((v & 0x2000) == 0 ? s13 : null), ((v & 0x4000) == 0 ? s14 : null), ((v & 0x8000) == 0 ? s15 : null), ((v & 0x10000) == 0 ? s16 : null), ((v & 0x20000) == 0 ? s17 : null), ((v & 0x40000) == 0 ? s18 : null), ((v & 0x80000) == 0 ? s19 : null), ((v & 0x100000) == 0 ? s20 : null), ((v & 0x200000) == 0 ? s21 : null), ((v & 0x400000) == 0 ? s22 : null), ((v & 0x800000) == 0 ? s23 : null), ((v & 0x1000000) == 0 ? s24 : null), ((v & 0x2000000) == 0 ? s25 : null), ((v & 0x4000000) == 0 ? s26 : null), ((v & 0x8000000) == 0 ? s27 : null), ((v & 0x10000000) == 0 ? s28 : null), ((v & 0x20000000) == 0 ? s29 : null), ((v & 0x40000000) == 0 ? s30 : null), ((v & 0x80000000) == 0 ? s31 : null), ((v1 & 1) == 0 ? s32 : null), ((v1 & 2) == 0 ? s33 : null), ((v1 & 4) == 0 ? s34 : null), ((v1 & 8) == 0 ? s35 : null), ((v1 & 16) == 0 ? s36 : null), ((v1 & 0x20) == 0 ? s37 : null), ((v1 & 0x40) == 0 ? s38 : null), ((v1 & 0x80) == 0 ? s39 : null), ((v1 & 0x100) == 0 ? s40 : null), ((v1 & 0x200) == 0 ? s41 : null), ((v1 & 0x400) == 0 ? s42 : null), ((v1 & 0x800) == 0 ? s43 : null), ((v1 & 0x1000) == 0 ? s44 : null), ((v1 & 0x2000) == 0 ? s45 : null));
    }

    @Nullable
    public final String component1() {
        return this.actSeq;
    }

    @Nullable
    public final String component10() {
        return this.count;
    }

    @Nullable
    public final String component11() {
        return this.deviceBrowser;
    }

    @Nullable
    public final String component12() {
        return this.deviceModelName;
    }

    @Nullable
    public final String component13() {
        return this.deviceOs;
    }

    @Nullable
    public final String component14() {
        return this.district;
    }

    @Nullable
    public final String component15() {
        return this.dspAdId;
    }

    @Nullable
    public final String component16() {
        return this.dspCampaignId;
    }

    @Nullable
    public final String component17() {
        return this.dspContentId;
    }

    @Nullable
    public final String component18() {
        return this.dspId;
    }

    @Nullable
    public final String component19() {
        return this.dt;
    }

    @Nullable
    public final String component2() {
        return this.actType;
    }

    @Nullable
    public final String component20() {
        return this.evId;
    }

    @Nullable
    public final String component21() {
        return this.evTime;
    }

    @Nullable
    public final String component22() {
        return this.eventId;
    }

    @Nullable
    public final String component23() {
        return this.eventName;
    }

    @Nullable
    public final String component24() {
        return this.ifa;
    }

    @Nullable
    public final String component25() {
        return this.impDttm;
    }

    @Nullable
    public final String component26() {
        return this.impId;
    }

    @Nullable
    public final String component27() {
        return this.impTime;
    }

    @Nullable
    public final String component28() {
        return this.impType;
    }

    @Nullable
    public final String component29() {
        return this.ip;
    }

    @Nullable
    public final String component3() {
        return this.adSeq;
    }

    @Nullable
    public final String component30() {
        return this.label;
    }

    @Nullable
    public final String component31() {
        return this.layer;
    }

    @Nullable
    public final String component32() {
        return this.pubAppId;
    }

    @Nullable
    public final String component33() {
        return this.pubId;
    }

    @Nullable
    public final String component34() {
        return this.pubPlacementId;
    }

    @Nullable
    public final String component35() {
        return this.redirectUrl;
    }

    @Nullable
    public final String component36() {
        return this.reqId;
    }

    @Nullable
    public final String component37() {
        return this.reqTime;
    }

    @Nullable
    public final String component38() {
        return this.slotId;
    }

    @Nullable
    public final String component39() {
        return this.sspId;
    }

    @Nullable
    public final String component4() {
        return this.ask;
    }

    @Nullable
    public final String component40() {
        return this.status;
    }

    @Nullable
    public final String component41() {
        return this.test;
    }

    @Nullable
    public final String component42() {
        return this.ua;
    }

    @Nullable
    public final String component43() {
        return this.unitId;
    }

    @Nullable
    public final String component44() {
        return this.userInfo_gender;
    }

    @Nullable
    public final String component45() {
        return this.userInfo_userId;
    }

    @Nullable
    public final String component46() {
        return this.winPrice;
    }

    @Nullable
    public final String component5() {
        return this.bidMinPrice;
    }

    @Nullable
    public final String component6() {
        return this.campaignSeq;
    }

    @Nullable
    public final String component7() {
        return this.clientId;
    }

    @Nullable
    public final String component8() {
        return this.contentId;
    }

    @Nullable
    public final String component9() {
        return this.contentSeq;
    }

    @NotNull
    public final TrackResponse copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable String s11, @Nullable String s12, @Nullable String s13, @Nullable String s14, @Nullable String s15, @Nullable String s16, @Nullable String s17, @Nullable String s18, @Nullable String s19, @Nullable String s20, @Nullable String s21, @Nullable String s22, @Nullable String s23, @Nullable String s24, @Nullable String s25, @Nullable String s26, @Nullable String s27, @Nullable String s28, @Nullable String s29, @Nullable String s30, @Nullable String s31, @Nullable String s32, @Nullable String s33, @Nullable String s34, @Nullable String s35, @Nullable String s36, @Nullable String s37, @Nullable String s38, @Nullable String s39, @Nullable String s40, @Nullable String s41, @Nullable String s42, @Nullable String s43, @Nullable String s44, @Nullable String s45) {
        return new TrackResponse(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, s31, s32, s33, s34, s35, s36, s37, s38, s39, s40, s41, s42, s43, s44, s45);
    }

    public static TrackResponse copy$default(TrackResponse trackResponse0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, String s16, String s17, String s18, String s19, String s20, String s21, String s22, String s23, String s24, String s25, String s26, String s27, String s28, String s29, String s30, String s31, String s32, String s33, String s34, String s35, String s36, String s37, String s38, String s39, String s40, String s41, String s42, String s43, String s44, String s45, int v, int v1, Object object0) {
        String s46 = (v & 1) == 0 ? s : trackResponse0.actSeq;
        String s47 = (v & 2) == 0 ? s1 : trackResponse0.actType;
        String s48 = (v & 4) == 0 ? s2 : trackResponse0.adSeq;
        String s49 = (v & 8) == 0 ? s3 : trackResponse0.ask;
        String s50 = (v & 16) == 0 ? s4 : trackResponse0.bidMinPrice;
        String s51 = (v & 0x20) == 0 ? s5 : trackResponse0.campaignSeq;
        String s52 = (v & 0x40) == 0 ? s6 : trackResponse0.clientId;
        String s53 = (v & 0x80) == 0 ? s7 : trackResponse0.contentId;
        String s54 = (v & 0x100) == 0 ? s8 : trackResponse0.contentSeq;
        String s55 = (v & 0x200) == 0 ? s9 : trackResponse0.count;
        String s56 = (v & 0x400) == 0 ? s10 : trackResponse0.deviceBrowser;
        String s57 = (v & 0x800) == 0 ? s11 : trackResponse0.deviceModelName;
        String s58 = (v & 0x1000) == 0 ? s12 : trackResponse0.deviceOs;
        String s59 = (v & 0x2000) == 0 ? s13 : trackResponse0.district;
        String s60 = (v & 0x4000) == 0 ? s14 : trackResponse0.dspAdId;
        String s61 = (v & 0x8000) == 0 ? s15 : trackResponse0.dspCampaignId;
        String s62 = (v & 0x10000) == 0 ? s16 : trackResponse0.dspContentId;
        String s63 = (v & 0x20000) == 0 ? s17 : trackResponse0.dspId;
        String s64 = (v & 0x40000) == 0 ? s18 : trackResponse0.dt;
        String s65 = (v & 0x80000) == 0 ? s19 : trackResponse0.evId;
        String s66 = (v & 0x100000) == 0 ? s20 : trackResponse0.evTime;
        String s67 = (v & 0x200000) == 0 ? s21 : trackResponse0.eventId;
        String s68 = (v & 0x400000) == 0 ? s22 : trackResponse0.eventName;
        String s69 = (v & 0x800000) == 0 ? s23 : trackResponse0.ifa;
        String s70 = (v & 0x1000000) == 0 ? s24 : trackResponse0.impDttm;
        String s71 = (v & 0x2000000) == 0 ? s25 : trackResponse0.impId;
        String s72 = (v & 0x4000000) == 0 ? s26 : trackResponse0.impTime;
        String s73 = (v & 0x8000000) == 0 ? s27 : trackResponse0.impType;
        String s74 = (v & 0x10000000) == 0 ? s28 : trackResponse0.ip;
        String s75 = (v & 0x20000000) == 0 ? s29 : trackResponse0.label;
        String s76 = (v & 0x40000000) == 0 ? s30 : trackResponse0.layer;
        String s77 = (v & 0x80000000) == 0 ? s31 : trackResponse0.pubAppId;
        String s78 = (v1 & 1) == 0 ? s32 : trackResponse0.pubId;
        String s79 = (v1 & 2) == 0 ? s33 : trackResponse0.pubPlacementId;
        String s80 = (v1 & 4) == 0 ? s34 : trackResponse0.redirectUrl;
        String s81 = (v1 & 8) == 0 ? s35 : trackResponse0.reqId;
        String s82 = (v1 & 16) == 0 ? s36 : trackResponse0.reqTime;
        String s83 = (v1 & 0x20) == 0 ? s37 : trackResponse0.slotId;
        String s84 = (v1 & 0x40) == 0 ? s38 : trackResponse0.sspId;
        String s85 = (v1 & 0x80) == 0 ? s39 : trackResponse0.status;
        String s86 = (v1 & 0x100) == 0 ? s40 : trackResponse0.test;
        String s87 = (v1 & 0x200) == 0 ? s41 : trackResponse0.ua;
        String s88 = (v1 & 0x400) == 0 ? s42 : trackResponse0.unitId;
        String s89 = (v1 & 0x800) == 0 ? s43 : trackResponse0.userInfo_gender;
        String s90 = (v1 & 0x1000) == 0 ? s44 : trackResponse0.userInfo_userId;
        return (v1 & 0x2000) == 0 ? trackResponse0.copy(s46, s47, s48, s49, s50, s51, s52, s53, s54, s55, s56, s57, s58, s59, s60, s61, s62, s63, s64, s65, s66, s67, s68, s69, s70, s71, s72, s73, s74, s75, s76, s77, s78, s79, s80, s81, s82, s83, s84, s85, s86, s87, s88, s89, s90, s45) : trackResponse0.copy(s46, s47, s48, s49, s50, s51, s52, s53, s54, s55, s56, s57, s58, s59, s60, s61, s62, s63, s64, s65, s66, s67, s68, s69, s70, s71, s72, s73, s74, s75, s76, s77, s78, s79, s80, s81, s82, s83, s84, s85, s86, s87, s88, s89, s90, trackResponse0.winPrice);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof TrackResponse)) {
            return false;
        }
        TrackResponse trackResponse0 = (TrackResponse)object0;
        if(!q.b(this.actSeq, trackResponse0.actSeq)) {
            return false;
        }
        if(!q.b(this.actType, trackResponse0.actType)) {
            return false;
        }
        if(!q.b(this.adSeq, trackResponse0.adSeq)) {
            return false;
        }
        if(!q.b(this.ask, trackResponse0.ask)) {
            return false;
        }
        if(!q.b(this.bidMinPrice, trackResponse0.bidMinPrice)) {
            return false;
        }
        if(!q.b(this.campaignSeq, trackResponse0.campaignSeq)) {
            return false;
        }
        if(!q.b(this.clientId, trackResponse0.clientId)) {
            return false;
        }
        if(!q.b(this.contentId, trackResponse0.contentId)) {
            return false;
        }
        if(!q.b(this.contentSeq, trackResponse0.contentSeq)) {
            return false;
        }
        if(!q.b(this.count, trackResponse0.count)) {
            return false;
        }
        if(!q.b(this.deviceBrowser, trackResponse0.deviceBrowser)) {
            return false;
        }
        if(!q.b(this.deviceModelName, trackResponse0.deviceModelName)) {
            return false;
        }
        if(!q.b(this.deviceOs, trackResponse0.deviceOs)) {
            return false;
        }
        if(!q.b(this.district, trackResponse0.district)) {
            return false;
        }
        if(!q.b(this.dspAdId, trackResponse0.dspAdId)) {
            return false;
        }
        if(!q.b(this.dspCampaignId, trackResponse0.dspCampaignId)) {
            return false;
        }
        if(!q.b(this.dspContentId, trackResponse0.dspContentId)) {
            return false;
        }
        if(!q.b(this.dspId, trackResponse0.dspId)) {
            return false;
        }
        if(!q.b(this.dt, trackResponse0.dt)) {
            return false;
        }
        if(!q.b(this.evId, trackResponse0.evId)) {
            return false;
        }
        if(!q.b(this.evTime, trackResponse0.evTime)) {
            return false;
        }
        if(!q.b(this.eventId, trackResponse0.eventId)) {
            return false;
        }
        if(!q.b(this.eventName, trackResponse0.eventName)) {
            return false;
        }
        if(!q.b(this.ifa, trackResponse0.ifa)) {
            return false;
        }
        if(!q.b(this.impDttm, trackResponse0.impDttm)) {
            return false;
        }
        if(!q.b(this.impId, trackResponse0.impId)) {
            return false;
        }
        if(!q.b(this.impTime, trackResponse0.impTime)) {
            return false;
        }
        if(!q.b(this.impType, trackResponse0.impType)) {
            return false;
        }
        if(!q.b(this.ip, trackResponse0.ip)) {
            return false;
        }
        if(!q.b(this.label, trackResponse0.label)) {
            return false;
        }
        if(!q.b(this.layer, trackResponse0.layer)) {
            return false;
        }
        if(!q.b(this.pubAppId, trackResponse0.pubAppId)) {
            return false;
        }
        if(!q.b(this.pubId, trackResponse0.pubId)) {
            return false;
        }
        if(!q.b(this.pubPlacementId, trackResponse0.pubPlacementId)) {
            return false;
        }
        if(!q.b(this.redirectUrl, trackResponse0.redirectUrl)) {
            return false;
        }
        if(!q.b(this.reqId, trackResponse0.reqId)) {
            return false;
        }
        if(!q.b(this.reqTime, trackResponse0.reqTime)) {
            return false;
        }
        if(!q.b(this.slotId, trackResponse0.slotId)) {
            return false;
        }
        if(!q.b(this.sspId, trackResponse0.sspId)) {
            return false;
        }
        if(!q.b(this.status, trackResponse0.status)) {
            return false;
        }
        if(!q.b(this.test, trackResponse0.test)) {
            return false;
        }
        if(!q.b(this.ua, trackResponse0.ua)) {
            return false;
        }
        if(!q.b(this.unitId, trackResponse0.unitId)) {
            return false;
        }
        if(!q.b(this.userInfo_gender, trackResponse0.userInfo_gender)) {
            return false;
        }
        return q.b(this.userInfo_userId, trackResponse0.userInfo_userId) ? q.b(this.winPrice, trackResponse0.winPrice) : false;
    }

    @Nullable
    public final String getActSeq() {
        return this.actSeq;
    }

    @Nullable
    public final String getActType() {
        return this.actType;
    }

    @Nullable
    public final String getAdSeq() {
        return this.adSeq;
    }

    @Nullable
    public final String getAsk() {
        return this.ask;
    }

    @Nullable
    public final String getBidMinPrice() {
        return this.bidMinPrice;
    }

    @Nullable
    public final String getCampaignSeq() {
        return this.campaignSeq;
    }

    @Nullable
    public final String getClientId() {
        return this.clientId;
    }

    @Nullable
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    public final String getContentSeq() {
        return this.contentSeq;
    }

    @Nullable
    public final String getCount() {
        return this.count;
    }

    @Nullable
    public final String getDeviceBrowser() {
        return this.deviceBrowser;
    }

    @Nullable
    public final String getDeviceModelName() {
        return this.deviceModelName;
    }

    @Nullable
    public final String getDeviceOs() {
        return this.deviceOs;
    }

    @Nullable
    public final String getDistrict() {
        return this.district;
    }

    @Nullable
    public final String getDspAdId() {
        return this.dspAdId;
    }

    @Nullable
    public final String getDspCampaignId() {
        return this.dspCampaignId;
    }

    @Nullable
    public final String getDspContentId() {
        return this.dspContentId;
    }

    @Nullable
    public final String getDspId() {
        return this.dspId;
    }

    @Nullable
    public final String getDt() {
        return this.dt;
    }

    @Nullable
    public final String getEvId() {
        return this.evId;
    }

    @Nullable
    public final String getEvTime() {
        return this.evTime;
    }

    @Nullable
    public final String getEventId() {
        return this.eventId;
    }

    @Nullable
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getIfa() {
        return this.ifa;
    }

    @Nullable
    public final String getImpDttm() {
        return this.impDttm;
    }

    @Nullable
    public final String getImpId() {
        return this.impId;
    }

    @Nullable
    public final String getImpTime() {
        return this.impTime;
    }

    @Nullable
    public final String getImpType() {
        return this.impType;
    }

    @Nullable
    public final String getIp() {
        return this.ip;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getLayer() {
        return this.layer;
    }

    @Nullable
    public final String getPubAppId() {
        return this.pubAppId;
    }

    @Nullable
    public final String getPubId() {
        return this.pubId;
    }

    @Nullable
    public final String getPubPlacementId() {
        return this.pubPlacementId;
    }

    @Nullable
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @Nullable
    public final String getReqId() {
        return this.reqId;
    }

    @Nullable
    public final String getReqTime() {
        return this.reqTime;
    }

    @Nullable
    public final String getSlotId() {
        return this.slotId;
    }

    @Nullable
    public final String getSspId() {
        return this.sspId;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTest() {
        return this.test;
    }

    @Nullable
    public final String getUa() {
        return this.ua;
    }

    @Nullable
    public final String getUnitId() {
        return this.unitId;
    }

    @Nullable
    public final String getUserInfo_gender() {
        return this.userInfo_gender;
    }

    @Nullable
    public final String getUserInfo_userId() {
        return this.userInfo_userId;
    }

    @Nullable
    public final String getWinPrice() {
        return this.winPrice;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.actSeq == null ? 0 : this.actSeq.hashCode();
        int v2 = this.actType == null ? 0 : this.actType.hashCode();
        int v3 = this.adSeq == null ? 0 : this.adSeq.hashCode();
        int v4 = this.ask == null ? 0 : this.ask.hashCode();
        int v5 = this.bidMinPrice == null ? 0 : this.bidMinPrice.hashCode();
        int v6 = this.campaignSeq == null ? 0 : this.campaignSeq.hashCode();
        int v7 = this.clientId == null ? 0 : this.clientId.hashCode();
        int v8 = this.contentId == null ? 0 : this.contentId.hashCode();
        int v9 = this.contentSeq == null ? 0 : this.contentSeq.hashCode();
        int v10 = this.count == null ? 0 : this.count.hashCode();
        int v11 = this.deviceBrowser == null ? 0 : this.deviceBrowser.hashCode();
        int v12 = this.deviceModelName == null ? 0 : this.deviceModelName.hashCode();
        int v13 = this.deviceOs == null ? 0 : this.deviceOs.hashCode();
        int v14 = this.district == null ? 0 : this.district.hashCode();
        int v15 = this.dspAdId == null ? 0 : this.dspAdId.hashCode();
        int v16 = this.dspCampaignId == null ? 0 : this.dspCampaignId.hashCode();
        int v17 = this.dspContentId == null ? 0 : this.dspContentId.hashCode();
        int v18 = this.dspId == null ? 0 : this.dspId.hashCode();
        int v19 = this.dt == null ? 0 : this.dt.hashCode();
        int v20 = this.evId == null ? 0 : this.evId.hashCode();
        int v21 = this.evTime == null ? 0 : this.evTime.hashCode();
        int v22 = this.eventId == null ? 0 : this.eventId.hashCode();
        int v23 = this.eventName == null ? 0 : this.eventName.hashCode();
        int v24 = this.ifa == null ? 0 : this.ifa.hashCode();
        int v25 = this.impDttm == null ? 0 : this.impDttm.hashCode();
        int v26 = this.impId == null ? 0 : this.impId.hashCode();
        int v27 = this.impTime == null ? 0 : this.impTime.hashCode();
        int v28 = this.impType == null ? 0 : this.impType.hashCode();
        int v29 = this.ip == null ? 0 : this.ip.hashCode();
        int v30 = this.label == null ? 0 : this.label.hashCode();
        int v31 = this.layer == null ? 0 : this.layer.hashCode();
        int v32 = this.pubAppId == null ? 0 : this.pubAppId.hashCode();
        int v33 = this.pubId == null ? 0 : this.pubId.hashCode();
        int v34 = this.pubPlacementId == null ? 0 : this.pubPlacementId.hashCode();
        int v35 = this.redirectUrl == null ? 0 : this.redirectUrl.hashCode();
        int v36 = this.reqId == null ? 0 : this.reqId.hashCode();
        int v37 = this.reqTime == null ? 0 : this.reqTime.hashCode();
        int v38 = this.slotId == null ? 0 : this.slotId.hashCode();
        int v39 = this.sspId == null ? 0 : this.sspId.hashCode();
        int v40 = this.status == null ? 0 : this.status.hashCode();
        int v41 = this.test == null ? 0 : this.test.hashCode();
        int v42 = this.ua == null ? 0 : this.ua.hashCode();
        int v43 = this.unitId == null ? 0 : this.unitId.hashCode();
        int v44 = this.userInfo_gender == null ? 0 : this.userInfo_gender.hashCode();
        int v45 = this.userInfo_userId == null ? 0 : this.userInfo_userId.hashCode();
        String s = this.winPrice;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((((((((((((((((((((((((((((((((((((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v12) * 0x1F + v13) * 0x1F + v14) * 0x1F + v15) * 0x1F + v16) * 0x1F + v17) * 0x1F + v18) * 0x1F + v19) * 0x1F + v20) * 0x1F + v21) * 0x1F + v22) * 0x1F + v23) * 0x1F + v24) * 0x1F + v25) * 0x1F + v26) * 0x1F + v27) * 0x1F + v28) * 0x1F + v29) * 0x1F + v30) * 0x1F + v31) * 0x1F + v32) * 0x1F + v33) * 0x1F + v34) * 0x1F + v35) * 0x1F + v36) * 0x1F + v37) * 0x1F + v38) * 0x1F + v39) * 0x1F + v40) * 0x1F + v41) * 0x1F + v42) * 0x1F + v43) * 0x1F + v44) * 0x1F + v45) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("TrackResponse(actSeq=");
        stringBuilder0.append(this.actSeq);
        stringBuilder0.append(", actType=");
        stringBuilder0.append(this.actType);
        stringBuilder0.append(", adSeq=");
        stringBuilder0.append(this.adSeq);
        stringBuilder0.append(", ask=");
        stringBuilder0.append(this.ask);
        stringBuilder0.append(", bidMinPrice=");
        stringBuilder0.append(this.bidMinPrice);
        stringBuilder0.append(", campaignSeq=");
        stringBuilder0.append(this.campaignSeq);
        stringBuilder0.append(", clientId=");
        stringBuilder0.append(this.clientId);
        stringBuilder0.append(", contentId=");
        stringBuilder0.append(this.contentId);
        stringBuilder0.append(", contentSeq=");
        stringBuilder0.append(this.contentSeq);
        stringBuilder0.append(", count=");
        stringBuilder0.append(this.count);
        stringBuilder0.append(", deviceBrowser=");
        stringBuilder0.append(this.deviceBrowser);
        stringBuilder0.append(", deviceModelName=");
        stringBuilder0.append(this.deviceModelName);
        stringBuilder0.append(", deviceOs=");
        stringBuilder0.append(this.deviceOs);
        stringBuilder0.append(", district=");
        stringBuilder0.append(this.district);
        stringBuilder0.append(", dspAdId=");
        stringBuilder0.append(this.dspAdId);
        stringBuilder0.append(", dspCampaignId=");
        stringBuilder0.append(this.dspCampaignId);
        stringBuilder0.append(", dspContentId=");
        stringBuilder0.append(this.dspContentId);
        stringBuilder0.append(", dspId=");
        stringBuilder0.append(this.dspId);
        stringBuilder0.append(", dt=");
        stringBuilder0.append(this.dt);
        stringBuilder0.append(", evId=");
        stringBuilder0.append(this.evId);
        stringBuilder0.append(", evTime=");
        stringBuilder0.append(this.evTime);
        stringBuilder0.append(", eventId=");
        stringBuilder0.append(this.eventId);
        stringBuilder0.append(", eventName=");
        stringBuilder0.append(this.eventName);
        stringBuilder0.append(", ifa=");
        stringBuilder0.append(this.ifa);
        stringBuilder0.append(", impDttm=");
        stringBuilder0.append(this.impDttm);
        stringBuilder0.append(", impId=");
        stringBuilder0.append(this.impId);
        stringBuilder0.append(", impTime=");
        stringBuilder0.append(this.impTime);
        stringBuilder0.append(", impType=");
        stringBuilder0.append(this.impType);
        stringBuilder0.append(", ip=");
        stringBuilder0.append(this.ip);
        stringBuilder0.append(", label=");
        stringBuilder0.append(this.label);
        stringBuilder0.append(", layer=");
        stringBuilder0.append(this.layer);
        stringBuilder0.append(", pubAppId=");
        stringBuilder0.append(this.pubAppId);
        stringBuilder0.append(", pubId=");
        stringBuilder0.append(this.pubId);
        stringBuilder0.append(", pubPlacementId=");
        stringBuilder0.append(this.pubPlacementId);
        stringBuilder0.append(", redirectUrl=");
        stringBuilder0.append(this.redirectUrl);
        stringBuilder0.append(", reqId=");
        stringBuilder0.append(this.reqId);
        stringBuilder0.append(", reqTime=");
        stringBuilder0.append(this.reqTime);
        stringBuilder0.append(", slotId=");
        stringBuilder0.append(this.slotId);
        stringBuilder0.append(", sspId=");
        stringBuilder0.append(this.sspId);
        stringBuilder0.append(", status=");
        stringBuilder0.append(this.status);
        stringBuilder0.append(", test=");
        stringBuilder0.append(this.test);
        stringBuilder0.append(", ua=");
        stringBuilder0.append(this.ua);
        stringBuilder0.append(", unitId=");
        stringBuilder0.append(this.unitId);
        stringBuilder0.append(", userInfo_gender=");
        stringBuilder0.append(this.userInfo_gender);
        stringBuilder0.append(", userInfo_userId=");
        stringBuilder0.append(this.userInfo_userId);
        stringBuilder0.append(", winPrice=");
        return o.r(stringBuilder0, this.winPrice, ')');
    }
}

