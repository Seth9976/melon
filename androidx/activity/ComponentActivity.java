package androidx.activity;

import Ac.U;
import Cc.j3;
import E4.b;
import E4.g;
import N1.A;
import N1.B;
import P1.e;
import P1.f;
import Q0.o0;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.fragment.app.a0;
import androidx.lifecycle.D;
import androidx.lifecycle.F;
import androidx.lifecycle.Z;
import androidx.lifecycle.f0;
import androidx.lifecycle.n0;
import androidx.lifecycle.n;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import b.c;
import b.d;
import b.k;
import b.u;
import c2.m;
import c2.o;
import c2.p;
import d.a;
import e.h;
import e.i;
import ie.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00E4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00DB\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\u00022\u00020\t2\u00020\n2\u00020\u00022\u00020\u000B2\u00020\f2\u00020\u00022\u00020\r2\u00020\u0002:\n\u00DC\u0001\u00DD\u0001\u00DE\u0001\u0096\u0001\u00DF\u0001B\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FB\u0013\b\u0017\u0012\b\b\u0001\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u000E\u0010\u0012J\u0019\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u0013H\u0015\u00A2\u0006\u0004\b\u0019\u0010\u0017J\u000F\u0010\u001A\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0011\u0010\u001C\u001A\u0004\u0018\u00010\u0002H\u0017\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0019\u0010\u001E\u001A\u00020\u00152\b\b\u0001\u0010\u001D\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0012J\u0019\u0010\u001E\u001A\u00020\u00152\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0016\u00A2\u0006\u0004\b\u001E\u0010!J#\u0010\u001E\u001A\u00020\u00152\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010#\u001A\u0004\u0018\u00010\"H\u0016\u00A2\u0006\u0004\b\u001E\u0010$J#\u0010%\u001A\u00020\u00152\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010#\u001A\u0004\u0018\u00010\"H\u0016\u00A2\u0006\u0004\b%\u0010$J\u000F\u0010&\u001A\u00020\u0015H\u0017\u00A2\u0006\u0004\b&\u0010\u000FJ\u0011\u0010(\u001A\u0004\u0018\u00010\'H\u0016\u00A2\u0006\u0004\b(\u0010)J\u0015\u0010,\u001A\u00020\u00152\u0006\u0010+\u001A\u00020*\u00A2\u0006\u0004\b,\u0010-J\u0015\u0010.\u001A\u00020\u00152\u0006\u0010+\u001A\u00020*\u00A2\u0006\u0004\b.\u0010-J)\u00103\u001A\u0002022\u0006\u0010/\u001A\u00020\u00102\b\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b3\u00104J\u001F\u00105\u001A\u0002022\u0006\u0010/\u001A\u00020\u00102\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b5\u00106J\u001F\u00109\u001A\u0002022\u0006\u0010/\u001A\u00020\u00102\u0006\u00108\u001A\u000207H\u0016\u00A2\u0006\u0004\b9\u0010:J\u001F\u0010;\u001A\u00020\u00152\u0006\u0010/\u001A\u00020\u00102\u0006\u00101\u001A\u000200H\u0016\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010?\u001A\u00020\u00152\u0006\u0010>\u001A\u00020=H\u0016\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010?\u001A\u00020\u00152\u0006\u0010>\u001A\u00020=2\u0006\u0010A\u001A\u00020\u0003H\u0016\u00A2\u0006\u0004\b?\u0010BJ\'\u0010?\u001A\u00020\u00152\u0006\u0010>\u001A\u00020=2\u0006\u0010A\u001A\u00020\u00032\u0006\u0010D\u001A\u00020CH\u0017\u00A2\u0006\u0004\b?\u0010EJ\u0017\u0010F\u001A\u00020\u00152\u0006\u0010>\u001A\u00020=H\u0016\u00A2\u0006\u0004\bF\u0010@J\u000F\u0010G\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\bG\u0010\u000FJ\u000F\u0010H\u001A\u00020\u0015H\u0017\u00A2\u0006\u0004\bH\u0010\u000FJ\u001F\u0010L\u001A\u00020\u00152\u0006\u0010J\u001A\u00020I2\u0006\u0010K\u001A\u00020\u0010H\u0017\u00A2\u0006\u0004\bL\u0010MJ)\u0010L\u001A\u00020\u00152\u0006\u0010J\u001A\u00020I2\u0006\u0010K\u001A\u00020\u00102\b\u0010N\u001A\u0004\u0018\u00010\u0013H\u0017\u00A2\u0006\u0004\bL\u0010OJA\u0010U\u001A\u00020\u00152\u0006\u0010J\u001A\u00020P2\u0006\u0010K\u001A\u00020\u00102\b\u0010Q\u001A\u0004\u0018\u00010I2\u0006\u0010R\u001A\u00020\u00102\u0006\u0010S\u001A\u00020\u00102\u0006\u0010T\u001A\u00020\u0010H\u0017\u00A2\u0006\u0004\bU\u0010VJK\u0010U\u001A\u00020\u00152\u0006\u0010J\u001A\u00020P2\u0006\u0010K\u001A\u00020\u00102\b\u0010Q\u001A\u0004\u0018\u00010I2\u0006\u0010R\u001A\u00020\u00102\u0006\u0010S\u001A\u00020\u00102\u0006\u0010T\u001A\u00020\u00102\b\u0010N\u001A\u0004\u0018\u00010\u0013H\u0017\u00A2\u0006\u0004\bU\u0010WJ)\u0010Z\u001A\u00020\u00152\u0006\u0010K\u001A\u00020\u00102\u0006\u0010X\u001A\u00020\u00102\b\u0010Y\u001A\u0004\u0018\u00010IH\u0015\u00A2\u0006\u0004\bZ\u0010[J-\u0010a\u001A\u00020\u00152\u0006\u0010K\u001A\u00020\u00102\f\u0010^\u001A\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010`\u001A\u00020_H\u0017\u00A2\u0006\u0004\ba\u0010bJI\u0010l\u001A\b\u0012\u0004\u0012\u00028\u00000k\"\u0004\b\u0000\u0010c\"\u0004\b\u0001\u0010d2\u0012\u0010f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010e2\u0006\u0010h\u001A\u00020g2\f\u0010j\u001A\b\u0012\u0004\u0012\u00028\u00010i\u00A2\u0006\u0004\bl\u0010mJA\u0010l\u001A\b\u0012\u0004\u0012\u00028\u00000k\"\u0004\b\u0000\u0010c\"\u0004\b\u0001\u0010d2\u0012\u0010f\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010e2\f\u0010j\u001A\b\u0012\u0004\u0012\u00028\u00010i\u00A2\u0006\u0004\bl\u0010nJ\u0017\u0010q\u001A\u00020\u00152\u0006\u0010p\u001A\u00020oH\u0017\u00A2\u0006\u0004\bq\u0010rJ\u001B\u0010t\u001A\u00020\u00152\f\u0010+\u001A\b\u0012\u0004\u0012\u00020o0s\u00A2\u0006\u0004\bt\u0010uJ\u001B\u0010v\u001A\u00020\u00152\f\u0010+\u001A\b\u0012\u0004\u0012\u00020o0s\u00A2\u0006\u0004\bv\u0010uJ\u0017\u0010x\u001A\u00020\u00152\u0006\u0010w\u001A\u00020\u0010H\u0017\u00A2\u0006\u0004\bx\u0010\u0012J\u001B\u0010y\u001A\u00020\u00152\f\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00100s\u00A2\u0006\u0004\by\u0010uJ\u001B\u0010z\u001A\u00020\u00152\f\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00100s\u00A2\u0006\u0004\bz\u0010uJ\u0017\u0010{\u001A\u00020\u00152\u0006\u0010J\u001A\u00020IH\u0015\u00A2\u0006\u0004\b{\u0010|J\u001B\u0010}\u001A\u00020\u00152\f\u0010+\u001A\b\u0012\u0004\u0012\u00020I0s\u00A2\u0006\u0004\b}\u0010uJ\u001B\u0010~\u001A\u00020\u00152\f\u0010+\u001A\b\u0012\u0004\u0012\u00020I0s\u00A2\u0006\u0004\b~\u0010uJ\u001A\u0010\u0080\u0001\u001A\u00020\u00152\u0006\u0010\u007F\u001A\u000202H\u0017\u00A2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\"\u0010\u0080\u0001\u001A\u00020\u00152\u0006\u0010\u007F\u001A\u0002022\u0006\u0010p\u001A\u00020oH\u0017\u00A2\u0006\u0006\b\u0080\u0001\u0010\u0082\u0001J\u001E\u0010\u0084\u0001\u001A\u00020\u00152\r\u0010+\u001A\t\u0012\u0005\u0012\u00030\u0083\u00010s\u00A2\u0006\u0005\b\u0084\u0001\u0010uJ\u001E\u0010\u0085\u0001\u001A\u00020\u00152\r\u0010+\u001A\t\u0012\u0005\u0012\u00030\u0083\u00010s\u00A2\u0006\u0005\b\u0085\u0001\u0010uJ\u001B\u0010\u0087\u0001\u001A\u00020\u00152\u0007\u0010\u0086\u0001\u001A\u000202H\u0017\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0081\u0001J#\u0010\u0087\u0001\u001A\u00020\u00152\u0007\u0010\u0086\u0001\u001A\u0002022\u0006\u0010p\u001A\u00020oH\u0017\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0082\u0001J\u001E\u0010\u0089\u0001\u001A\u00020\u00152\r\u0010+\u001A\t\u0012\u0005\u0012\u00030\u0088\u00010s\u00A2\u0006\u0005\b\u0089\u0001\u0010uJ\u001E\u0010\u008A\u0001\u001A\u00020\u00152\r\u0010+\u001A\t\u0012\u0005\u0012\u00030\u0088\u00010s\u00A2\u0006\u0005\b\u008A\u0001\u0010uJ\u0011\u0010\u008B\u0001\u001A\u00020\u0015H\u0015\u00A2\u0006\u0005\b\u008B\u0001\u0010\u000FJ\u0019\u0010\u008D\u0001\u001A\u00020\u00152\u0007\u0010+\u001A\u00030\u008C\u0001\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J\u0019\u0010\u008F\u0001\u001A\u00020\u00152\u0007\u0010+\u001A\u00030\u008C\u0001\u00A2\u0006\u0006\b\u008F\u0001\u0010\u008E\u0001J\u0011\u0010\u0090\u0001\u001A\u00020\u0015H\u0016\u00A2\u0006\u0005\b\u0090\u0001\u0010\u000FJ\u0011\u0010\u0091\u0001\u001A\u00020\u0015H\u0002\u00A2\u0006\u0005\b\u0091\u0001\u0010\u000FJ\u001C\u0010\u0094\u0001\u001A\u00020\u00152\b\u0010\u0093\u0001\u001A\u00030\u0092\u0001H\u0003\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0013\u0010\u0097\u0001\u001A\u00030\u0096\u0001H\u0002\u00A2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009A\u0001\u001A\u00030\u0099\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u009A\u0001\u0010\u009B\u0001R\u0018\u0010\u009D\u0001\u001A\u00030\u009C\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u009D\u0001\u0010\u009E\u0001R\u001F\u0010\u00A0\u0001\u001A\u00030\u009F\u00018\u0002X\u0082\u0004\u00A2\u0006\u000F\n\u0006\b\u00A0\u0001\u0010\u00A1\u0001\u0012\u0005\b\u00A2\u0001\u0010\u000FR\u001C\u0010\u00A4\u0001\u001A\u0005\u0018\u00010\u00A3\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u00A5\u0001R\u0018\u0010\u00A6\u0001\u001A\u00030\u0096\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A6\u0001\u0010\u00A7\u0001R!\u0010\u00AD\u0001\u001A\u00030\u00A8\u00018VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001\u001A\u0006\b\u00AB\u0001\u0010\u00AC\u0001R\u0016\u0010\u0011\u001A\u00020\u00108\u0002@\u0002X\u0083\u000E\u00A2\u0006\u0006\n\u0004\b\u0011\u0010cR\u0018\u0010\u00AF\u0001\u001A\u00030\u00AE\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AF\u0001\u0010\u00B0\u0001R\u001C\u0010\u00B1\u0001\u001A\u00020g8\u0006\u00A2\u0006\u0010\n\u0006\b\u00B1\u0001\u0010\u00B2\u0001\u001A\u0006\b\u00B3\u0001\u0010\u00B4\u0001R$\u0010\u00B6\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020o0s0\u00B5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B6\u0001\u0010\u00B7\u0001R$\u0010\u00B8\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100s0\u00B5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B8\u0001\u0010\u00B7\u0001R$\u0010\u00B9\u0001\u001A\u000F\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0s0\u00B5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B9\u0001\u0010\u00B7\u0001R%\u0010\u00BA\u0001\u001A\u0010\u0012\u000B\u0012\t\u0012\u0005\u0012\u00030\u0083\u00010s0\u00B5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BA\u0001\u0010\u00B7\u0001R%\u0010\u00BB\u0001\u001A\u0010\u0012\u000B\u0012\t\u0012\u0005\u0012\u00030\u0088\u00010s0\u00B5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BB\u0001\u0010\u00B7\u0001R\u001F\u0010\u00BC\u0001\u001A\n\u0012\u0005\u0012\u00030\u008C\u00010\u00B5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BC\u0001\u0010\u00B7\u0001R\u0019\u0010\u00BD\u0001\u001A\u0002028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BD\u0001\u0010\u00BE\u0001R\u0019\u0010\u00BF\u0001\u001A\u0002028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BF\u0001\u0010\u00BE\u0001R!\u0010\u00C4\u0001\u001A\u00030\u00C0\u00018VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00C1\u0001\u0010\u00AA\u0001\u001A\u0006\b\u00C2\u0001\u0010\u00C3\u0001R(\u0010\u00C9\u0001\u001A\u00030\u0092\u00018FX\u0086\u0084\u0002\u00A2\u0006\u0017\n\u0006\b\u00C5\u0001\u0010\u00AA\u0001\u0012\u0005\b\u00C8\u0001\u0010\u000F\u001A\u0006\b\u00C6\u0001\u0010\u00C7\u0001R\u0018\u0010\u00CB\u0001\u001A\u0004\u0018\u00010\u00028WX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00CA\u0001\u0010\u001BR\u0018\u0010\u00CF\u0001\u001A\u00030\u00CC\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00CD\u0001\u0010\u00CE\u0001R\u0018\u0010\u00D2\u0001\u001A\u00030\u00A3\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00D0\u0001\u0010\u00D1\u0001R\u0018\u0010\u00D6\u0001\u001A\u00030\u00D3\u00018WX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00D4\u0001\u0010\u00D5\u0001R\u0015\u0010\u00DA\u0001\u001A\u00030\u00D7\u00018F\u00A2\u0006\b\u001A\u0006\b\u00D8\u0001\u0010\u00D9\u0001\u00A8\u0006\u00E0\u0001"}, d2 = {"Landroidx/activity/ComponentActivity;", "Landroidx/core/app/ComponentActivity;", "", "Landroidx/lifecycle/D;", "Landroidx/lifecycle/r0;", "Landroidx/lifecycle/n;", "LE4/g;", "Lb/u;", "Le/i;", "LP1/f;", "LP1/g;", "LN1/A;", "LN1/B;", "Lc2/m;", "<init>", "()V", "", "contentLayoutId", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onRetainNonConfigurationInstance", "()Ljava/lang/Object;", "onRetainCustomNonConfigurationInstance", "layoutResID", "setContentView", "Landroid/view/View;", "view", "(Landroid/view/View;)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "addContentView", "initializeViewTreeOwners", "Landroid/content/Context;", "peekAvailableContext", "()Landroid/content/Context;", "Ld/b;", "listener", "addOnContextAvailableListener", "(Ld/b;)V", "removeOnContextAvailableListener", "featureId", "Landroid/view/Menu;", "menu", "", "onPreparePanel", "(ILandroid/view/View;Landroid/view/Menu;)Z", "onCreatePanelMenu", "(ILandroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onMenuItemSelected", "(ILandroid/view/MenuItem;)Z", "onPanelClosed", "(ILandroid/view/Menu;)V", "Lc2/p;", "provider", "addMenuProvider", "(Lc2/p;)V", "owner", "(Lc2/p;Landroidx/lifecycle/D;)V", "Landroidx/lifecycle/s;", "state", "(Lc2/p;Landroidx/lifecycle/D;Landroidx/lifecycle/s;)V", "removeMenuProvider", "invalidateMenu", "onBackPressed", "Landroid/content/Intent;", "intent", "requestCode", "startActivityForResult", "(Landroid/content/Intent;I)V", "options", "(Landroid/content/Intent;ILandroid/os/Bundle;)V", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "startIntentSenderForResult", "(Landroid/content/IntentSender;ILandroid/content/Intent;III)V", "(Landroid/content/IntentSender;ILandroid/content/Intent;IIILandroid/os/Bundle;)V", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "I", "O", "Lf/b;", "contract", "Le/h;", "registry", "Le/a;", "callback", "Le/b;", "registerForActivityResult", "(Lf/b;Le/h;Le/a;)Le/b;", "(Lf/b;Le/a;)Le/b;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lb2/a;", "addOnConfigurationChangedListener", "(Lb2/a;)V", "removeOnConfigurationChangedListener", "level", "onTrimMemory", "addOnTrimMemoryListener", "removeOnTrimMemoryListener", "onNewIntent", "(Landroid/content/Intent;)V", "addOnNewIntentListener", "removeOnNewIntentListener", "isInMultiWindowMode", "onMultiWindowModeChanged", "(Z)V", "(ZLandroid/content/res/Configuration;)V", "LN1/k;", "addOnMultiWindowModeChangedListener", "removeOnMultiWindowModeChangedListener", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "LN1/D;", "addOnPictureInPictureModeChangedListener", "removeOnPictureInPictureModeChangedListener", "onUserLeaveHint", "Ljava/lang/Runnable;", "addOnUserLeaveHintListener", "(Ljava/lang/Runnable;)V", "removeOnUserLeaveHintListener", "reportFullyDrawn", "ensureViewModelStore", "Lb/t;", "dispatcher", "addObserverForBackInvoker", "(Lb/t;)V", "Lb/h;", "createFullyDrawnExecutor", "()Lb/h;", "Ld/a;", "contextAwareHelper", "Ld/a;", "Lc2/o;", "menuHostHelper", "Lc2/o;", "LE4/f;", "savedStateRegistryController", "LE4/f;", "getSavedStateRegistryController$annotations", "Landroidx/lifecycle/q0;", "_viewModelStore", "Landroidx/lifecycle/q0;", "reportFullyDrawnExecutor", "Lb/h;", "Lb/m;", "fullyDrawnReporter$delegate", "Lie/j;", "getFullyDrawnReporter", "()Lb/m;", "fullyDrawnReporter", "Ljava/util/concurrent/atomic/AtomicInteger;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "activityResultRegistry", "Le/h;", "getActivityResultRegistry", "()Le/h;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onConfigurationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onTrimMemoryListeners", "onNewIntentListeners", "onMultiWindowModeChangedListeners", "onPictureInPictureModeChangedListeners", "onUserLeaveHintListeners", "dispatchingOnMultiWindowModeChanged", "Z", "dispatchingOnPictureInPictureModeChanged", "Landroidx/lifecycle/o0;", "defaultViewModelProviderFactory$delegate", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/o0;", "defaultViewModelProviderFactory", "onBackPressedDispatcher$delegate", "getOnBackPressedDispatcher", "()Lb/t;", "getOnBackPressedDispatcher$annotations", "onBackPressedDispatcher", "getLastCustomNonConfigurationInstance", "lastCustomNonConfigurationInstance", "Landroidx/lifecycle/t;", "getLifecycle", "()Landroidx/lifecycle/t;", "lifecycle", "getViewModelStore", "()Landroidx/lifecycle/q0;", "viewModelStore", "LS2/c;", "getDefaultViewModelCreationExtras", "()LS2/c;", "defaultViewModelCreationExtras", "LE4/e;", "getSavedStateRegistry", "()LE4/e;", "savedStateRegistry", "Companion", "P1/e", "b/f", "b/g", "b/i", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class ComponentActivity extends androidx.core.app.ComponentActivity implements g, A, B, f, P1.g, n, r0, u, m, i {
    @NotNull
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    @NotNull
    private static final b.f Companion;
    @Nullable
    private q0 _viewModelStore;
    @NotNull
    private final h activityResultRegistry;
    private int contentLayoutId;
    @NotNull
    private final a contextAwareHelper;
    @NotNull
    private final j defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    @NotNull
    private final j fullyDrawnReporter$delegate;
    @NotNull
    private final o menuHostHelper;
    @NotNull
    private final AtomicInteger nextLocalRequestCode;
    @NotNull
    private final j onBackPressedDispatcher$delegate;
    @NotNull
    private final CopyOnWriteArrayList onConfigurationChangedListeners;
    @NotNull
    private final CopyOnWriteArrayList onMultiWindowModeChangedListeners;
    @NotNull
    private final CopyOnWriteArrayList onNewIntentListeners;
    @NotNull
    private final CopyOnWriteArrayList onPictureInPictureModeChangedListeners;
    @NotNull
    private final CopyOnWriteArrayList onTrimMemoryListeners;
    @NotNull
    private final CopyOnWriteArrayList onUserLeaveHintListeners;
    @NotNull
    private final b.h reportFullyDrawnExecutor;
    @NotNull
    private final E4.f savedStateRegistryController;

    static {
        ComponentActivity.Companion = new b.f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public ComponentActivity() {
        this.contextAwareHelper = new a();
        this.menuHostHelper = new o(new c(this, 0));
        F4.a a0 = new F4.a(this, new U(this, 14));
        this.savedStateRegistryController = new E4.f(a0);
        this.reportFullyDrawnExecutor = this.createFullyDrawnExecutor();
        this.fullyDrawnReporter$delegate = d3.g.Q(new k(this, 2));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new b.j(this);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList();
        this.onNewIntentListeners = new CopyOnWriteArrayList();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList();
        if(this.getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity\'s constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        this.getLifecycle().a(new d(this, 0));
        this.getLifecycle().a(new d(this, 1));
        this.getLifecycle().a(new b(this, 3));
        a0.a();
        f0.c(this);
        this.getSavedStateRegistry().c("android:support:activity-result", new o0(this, 2));
        this.addOnContextAvailableListener((Context context0) -> {
            q.g(context0, "it");
            Bundle bundle0 = this.getSavedStateRegistry().a("android:support:activity-result");
            if(bundle0 != null) {
                h h0 = this.activityResultRegistry;
                LinkedHashMap linkedHashMap0 = h0.b;
                LinkedHashMap linkedHashMap1 = h0.a;
                Bundle bundle1 = h0.g;
                ArrayList arrayList0 = bundle0.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                ArrayList arrayList1 = bundle0.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                if(arrayList1 != null && arrayList0 != null) {
                    ArrayList arrayList2 = bundle0.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if(arrayList2 != null) {
                        h0.d.addAll(arrayList2);
                    }
                    Bundle bundle2 = bundle0.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    if(bundle2 != null) {
                        bundle1.putAll(bundle2);
                    }
                    int v = arrayList1.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        String s = (String)arrayList1.get(v1);
                        if(linkedHashMap0.containsKey(s)) {
                            Integer integer0 = (Integer)linkedHashMap0.remove(s);
                            if(!bundle1.containsKey(s)) {
                                N.c(linkedHashMap1).remove(integer0);
                            }
                        }
                        Object object0 = arrayList0.get(v1);
                        q.f(object0, "rcs[i]");
                        int v2 = ((Number)object0).intValue();
                        Object object1 = arrayList1.get(v1);
                        q.f(object1, "keys[i]");
                        linkedHashMap1.put(v2, ((String)object1));
                        h0.b.put(((String)object1), v2);
                    }
                }
            }
        });
        this.defaultViewModelProviderFactory$delegate = d3.g.Q(new k(this, 0));
        this.onBackPressedDispatcher$delegate = d3.g.Q(new k(this, 3));
    }

    public ComponentActivity(int v) {
        this.contentLayoutId = v;
    }

    private static final void _init_$lambda$2(ComponentActivity componentActivity0, D d0, r r0) {
        q.g(d0, "<anonymous parameter 0>");
        q.g(r0, "event");
        if(r0 == r.ON_STOP) {
            Window window0 = componentActivity0.getWindow();
            if(window0 != null) {
                View view0 = window0.peekDecorView();
                if(view0 != null) {
                    view0.cancelPendingInputEvents();
                }
            }
        }
    }

    private static final void _init_$lambda$3(ComponentActivity componentActivity0, D d0, r r0) {
        q.g(d0, "<anonymous parameter 0>");
        q.g(r0, "event");
        if(r0 == r.ON_DESTROY) {
            componentActivity0.contextAwareHelper.b = null;
            if(!componentActivity0.isChangingConfigurations()) {
                componentActivity0.getViewModelStore().a();
            }
            ((b.i)componentActivity0.reportFullyDrawnExecutor).d.getWindow().getDecorView().removeCallbacks(((b.i)componentActivity0.reportFullyDrawnExecutor));
            ((b.i)componentActivity0.reportFullyDrawnExecutor).d.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(((b.i)componentActivity0.reportFullyDrawnExecutor));
        }
    }

    private static final Bundle _init_$lambda$4(ComponentActivity componentActivity0) {
        Bundle bundle0 = new Bundle();
        componentActivity0.activityResultRegistry.getClass();
        bundle0.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(componentActivity0.activityResultRegistry.b.values()));
        bundle0.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(componentActivity0.activityResultRegistry.b.keySet()));
        bundle0.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(componentActivity0.activityResultRegistry.d));
        bundle0.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(componentActivity0.activityResultRegistry.g));
        return bundle0;
    }

    // 检测为 Lambda 实现
    private static final void _init_$lambda$5(ComponentActivity componentActivity0, Context context0) [...]

    @Override  // android.app.Activity
    public void addContentView(@Nullable View view0, @Nullable ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initializeViewTreeOwners();
        View view1 = this.getWindow().getDecorView();
        q.f(view1, "window.decorView");
        ((b.i)this.reportFullyDrawnExecutor).a(view1);
        super.addContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // c2.m
    public void addMenuProvider(@NotNull p p0) {
        q.g(p0, "provider");
        this.menuHostHelper.b.add(p0);
        this.menuHostHelper.a.run();
    }

    public void addMenuProvider(@NotNull p p0, @NotNull D d0) {
        q.g(p0, "provider");
        q.g(d0, "owner");
        o o0 = this.menuHostHelper;
        o0.b.add(p0);
        o0.a.run();
        t t0 = d0.getLifecycle();
        HashMap hashMap0 = o0.c;
        c2.n n0 = (c2.n)hashMap0.remove(p0);
        if(n0 != null) {
            n0.a.c(n0.b);
            n0.b = null;
        }
        hashMap0.put(p0, new c2.n(t0, new j3(3, o0, p0)));
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@NotNull p p0, @NotNull D d0, @NotNull s s0) {
        q.g(p0, "provider");
        q.g(d0, "owner");
        q.g(s0, "state");
        o o0 = this.menuHostHelper;
        o0.getClass();
        t t0 = d0.getLifecycle();
        HashMap hashMap0 = o0.c;
        c2.n n0 = (c2.n)hashMap0.remove(p0);
        if(n0 != null) {
            n0.a.c(n0.b);
            n0.b = null;
        }
        hashMap0.put(p0, new c2.n(t0, new bd.A(o0, s0, p0, 1)));
    }

    private final void addObserverForBackInvoker(b.t t0) {
        this.getLifecycle().a(new j3(2, t0, this));
    }

    private static final void addObserverForBackInvoker$lambda$7(b.t t0, ComponentActivity componentActivity0, D d0, r r0) {
        q.g(d0, "<anonymous parameter 0>");
        q.g(r0, "event");
        if(r0 == r.ON_CREATE) {
            t0.e = e.a(componentActivity0);
            t0.d(t0.g);
        }
    }

    @Override  // P1.f
    public final void addOnConfigurationChangedListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onConfigurationChangedListeners.add(a0);
    }

    public final void addOnContextAvailableListener(@NotNull d.b b0) {
        q.g(b0, "listener");
        a a0 = this.contextAwareHelper;
        a0.getClass();
        ComponentActivity componentActivity0 = a0.b;
        if(componentActivity0 != null) {
            b0.onContextAvailable(componentActivity0);
        }
        a0.a.add(b0);
    }

    @Override  // N1.A
    public final void addOnMultiWindowModeChangedListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onMultiWindowModeChangedListeners.add(a0);
    }

    public final void addOnNewIntentListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onNewIntentListeners.add(a0);
    }

    @Override  // N1.B
    public final void addOnPictureInPictureModeChangedListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onPictureInPictureModeChangedListeners.add(a0);
    }

    @Override  // P1.g
    public final void addOnTrimMemoryListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onTrimMemoryListeners.add(a0);
    }

    public final void addOnUserLeaveHintListener(@NotNull Runnable runnable0) {
        q.g(runnable0, "listener");
        this.onUserLeaveHintListeners.add(runnable0);
    }

    private final b.h createFullyDrawnExecutor() {
        return new b.i(this);
    }

    private final void ensureViewModelStore() {
        if(this._viewModelStore == null) {
            b.g g0 = (b.g)this.getLastNonConfigurationInstance();
            if(g0 != null) {
                this._viewModelStore = g0.b;
            }
            if(this._viewModelStore == null) {
                this._viewModelStore = new q0();
            }
        }
    }

    @Override  // e.i
    @NotNull
    public final h getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override  // androidx.lifecycle.n
    @NotNull
    public S2.c getDefaultViewModelCreationExtras() {
        S2.c c0 = new S2.d(0);
        Application application0 = this.getApplication();
        LinkedHashMap linkedHashMap0 = c0.a;
        if(application0 != null) {
            Application application1 = this.getApplication();
            q.f(application1, "application");
            linkedHashMap0.put(n0.d, application1);
        }
        linkedHashMap0.put(f0.a, this);
        linkedHashMap0.put(f0.b, this);
        Intent intent0 = this.getIntent();
        Bundle bundle0 = intent0 == null ? null : intent0.getExtras();
        if(bundle0 != null) {
            linkedHashMap0.put(f0.c, bundle0);
        }
        return c0;
    }

    @Override  // androidx.lifecycle.n
    @NotNull
    public androidx.lifecycle.o0 getDefaultViewModelProviderFactory() {
        return (androidx.lifecycle.o0)this.defaultViewModelProviderFactory$delegate.getValue();
    }

    @NotNull
    public b.m getFullyDrawnReporter() {
        return (b.m)this.fullyDrawnReporter$delegate.getValue();
    }

    @ie.d
    @Nullable
    public Object getLastCustomNonConfigurationInstance() {
        b.g g0 = (b.g)this.getLastNonConfigurationInstance();
        return g0 == null ? null : g0.a;
    }

    @Override  // androidx.core.app.ComponentActivity, androidx.lifecycle.D
    @NotNull
    public t getLifecycle() {
        return super.getLifecycle();
    }

    @Override  // b.u
    @NotNull
    public final b.t getOnBackPressedDispatcher() {
        return (b.t)this.onBackPressedDispatcher$delegate.getValue();
    }

    public static void getOnBackPressedDispatcher$annotations() {
    }

    @Override  // E4.g
    @NotNull
    public final E4.e getSavedStateRegistry() {
        return this.savedStateRegistryController.b;
    }

    private static void getSavedStateRegistryController$annotations() {
    }

    @Override  // androidx.lifecycle.r0
    @NotNull
    public q0 getViewModelStore() {
        if(this.getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can\'t request ViewModel before onCreate call.");
        }
        this.ensureViewModelStore();
        q0 q00 = this._viewModelStore;
        q.d(q00);
        return q00;
    }

    public void initializeViewTreeOwners() {
        View view0 = this.getWindow().getDecorView();
        q.f(view0, "window.decorView");
        f0.k(view0, this);
        View view1 = this.getWindow().getDecorView();
        q.f(view1, "window.decorView");
        f0.l(view1, this);
        View view2 = this.getWindow().getDecorView();
        q.f(view2, "window.decorView");
        a.a.M(view2, this);
        View view3 = this.getWindow().getDecorView();
        q.f(view3, "window.decorView");
        view3.setTag(0x7F0A0DD2, this);  // id:view_tree_on_back_pressed_dispatcher_owner
        View view4 = this.getWindow().getDecorView();
        q.f(view4, "window.decorView");
        view4.setTag(0x7F0A09EA, this);  // id:report_drawn
    }

    public void invalidateMenu() {
        this.invalidateOptionsMenu();
    }

    private static final void menuHostHelper$lambda$0(ComponentActivity componentActivity0) {
        componentActivity0.invalidateMenu();
    }

    @Override  // android.app.Activity
    @ie.d
    public void onActivityResult(int v, int v1, @Nullable Intent intent0) {
        if(!this.activityResultRegistry.a(v, v1, intent0)) {
            super.onActivityResult(v, v1, intent0);
        }
    }

    @Override  // android.app.Activity
    @ie.d
    public void onBackPressed() {
        this.getOnBackPressedDispatcher().c();
    }

    @Override  // android.app.Activity
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        for(Object object0: this.onConfigurationChangedListeners) {
            ((b2.a)object0).accept(configuration0);
        }
    }

    @Override  // androidx.core.app.ComponentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        this.savedStateRegistryController.a(bundle0);
        this.contextAwareHelper.getClass();
        this.contextAwareHelper.b = this;
        for(Object object0: this.contextAwareHelper.a) {
            ((d.b)object0).onContextAvailable(this);
        }
        super.onCreate(bundle0);
        Z.b(this);
        int v = this.contentLayoutId;
        if(v != 0) {
            this.setContentView(v);
        }
    }

    @Override  // android.app.Activity
    public boolean onCreatePanelMenu(int v, @NotNull Menu menu0) {
        q.g(menu0, "menu");
        if(v == 0) {
            super.onCreatePanelMenu(0, menu0);
            MenuInflater menuInflater0 = this.getMenuInflater();
            for(Object object0: this.menuHostHelper.b) {
                ((a0)(((p)object0))).a.k(menu0, menuInflater0);
            }
        }
        return true;
    }

    @Override  // android.app.Activity
    public boolean onMenuItemSelected(int v, @NotNull MenuItem menuItem0) {
        q.g(menuItem0, "item");
        if(super.onMenuItemSelected(v, menuItem0)) {
            return true;
        }
        return v == 0 ? this.menuHostHelper.a(menuItem0) : false;
    }

    @Override  // android.app.Activity
    @ie.d
    public void onMultiWindowModeChanged(boolean z) {
        if(!this.dispatchingOnMultiWindowModeChanged) {
            for(Object object0: this.onMultiWindowModeChangedListeners) {
                ((b2.a)object0).accept(new N1.k(z));
            }
        }
    }

    @Override  // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, @NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration0);
        }
        finally {
            this.dispatchingOnMultiWindowModeChanged = false;
        }
        for(Object object0: this.onMultiWindowModeChangedListeners) {
            ((b2.a)object0).accept(new N1.k(z));
        }
    }

    @Override  // android.app.Activity
    public void onNewIntent(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        super.onNewIntent(intent0);
        for(Object object0: this.onNewIntentListeners) {
            ((b2.a)object0).accept(intent0);
        }
    }

    @Override  // android.app.Activity
    public void onPanelClosed(int v, @NotNull Menu menu0) {
        q.g(menu0, "menu");
        for(Object object0: this.menuHostHelper.b) {
            ((a0)(((p)object0))).a.q(menu0);
        }
        super.onPanelClosed(v, menu0);
    }

    @Override  // android.app.Activity
    @ie.d
    public void onPictureInPictureModeChanged(boolean z) {
        if(!this.dispatchingOnPictureInPictureModeChanged) {
            for(Object object0: this.onPictureInPictureModeChangedListeners) {
                ((b2.a)object0).accept(new N1.D(z));
            }
        }
    }

    @Override  // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, @NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration0);
        }
        finally {
            this.dispatchingOnPictureInPictureModeChanged = false;
        }
        for(Object object0: this.onPictureInPictureModeChangedListeners) {
            ((b2.a)object0).accept(new N1.D(z));
        }
    }

    @Override  // android.app.Activity
    public boolean onPreparePanel(int v, @Nullable View view0, @NotNull Menu menu0) {
        q.g(menu0, "menu");
        if(v == 0) {
            super.onPreparePanel(0, view0, menu0);
            for(Object object0: this.menuHostHelper.b) {
                ((a0)(((p)object0))).a.t(menu0);
            }
        }
        return true;
    }

    @Override  // android.app.Activity
    @ie.d
    public void onRequestPermissionsResult(int v, @NotNull String[] arr_s, @NotNull int[] arr_v) {
        q.g(arr_s, "permissions");
        q.g(arr_v, "grantResults");
        Intent intent0 = new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arr_s).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", arr_v);
        if(!this.activityResultRegistry.a(v, -1, intent0)) {
            super.onRequestPermissionsResult(v, arr_s, arr_v);
        }
    }

    @ie.d
    @Nullable
    public Object onRetainCustomNonConfigurationInstance() [...] // Inlined contents

    @Override  // android.app.Activity
    @Nullable
    public final Object onRetainNonConfigurationInstance() {
        q0 q00 = this._viewModelStore;
        if(q00 == null) {
            b.g g0 = (b.g)this.getLastNonConfigurationInstance();
            if(g0 != null) {
                q00 = g0.b;
            }
        }
        if(q00 == null) {
            return null;
        }
        b.g g1 = new b.g();  // 初始化器: Ljava/lang/Object;-><init>()V
        g1.a = null;
        g1.b = q00;
        return g1;
    }

    @Override  // androidx.core.app.ComponentActivity
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        if(this.getLifecycle() instanceof F) {
            t t0 = this.getLifecycle();
            q.e(t0, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((F)t0).h(s.c);
        }
        super.onSaveInstanceState(bundle0);
        this.savedStateRegistryController.b(bundle0);
    }

    @Override  // android.app.Activity
    public void onTrimMemory(int v) {
        super.onTrimMemory(v);
        for(Object object0: this.onTrimMemoryListeners) {
            ((b2.a)object0).accept(v);
        }
    }

    @Override  // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        for(Object object0: this.onUserLeaveHintListeners) {
            ((Runnable)object0).run();
        }
    }

    @Nullable
    public Context peekAvailableContext() {
        return this.contextAwareHelper.b;
    }

    @NotNull
    public final e.b registerForActivityResult(@NotNull f.b b0, @NotNull e.a a0) {
        q.g(b0, "contract");
        q.g(a0, "callback");
        return this.registerForActivityResult(b0, this.activityResultRegistry, a0);
    }

    @NotNull
    public final e.b registerForActivityResult(@NotNull f.b b0, @NotNull h h0, @NotNull e.a a0) {
        q.g(b0, "contract");
        q.g(h0, "registry");
        q.g(a0, "callback");
        return h0.c("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, b0, a0);
    }

    @Override  // c2.m
    public void removeMenuProvider(@NotNull p p0) {
        q.g(p0, "provider");
        this.menuHostHelper.b(p0);
    }

    @Override  // P1.f
    public final void removeOnConfigurationChangedListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onConfigurationChangedListeners.remove(a0);
    }

    public final void removeOnContextAvailableListener(@NotNull d.b b0) {
        q.g(b0, "listener");
        this.contextAwareHelper.getClass();
        this.contextAwareHelper.a.remove(b0);
    }

    @Override  // N1.A
    public final void removeOnMultiWindowModeChangedListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onMultiWindowModeChangedListeners.remove(a0);
    }

    public final void removeOnNewIntentListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onNewIntentListeners.remove(a0);
    }

    @Override  // N1.B
    public final void removeOnPictureInPictureModeChangedListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onPictureInPictureModeChangedListeners.remove(a0);
    }

    @Override  // P1.g
    public final void removeOnTrimMemoryListener(@NotNull b2.a a0) {
        q.g(a0, "listener");
        this.onTrimMemoryListeners.remove(a0);
    }

    public final void removeOnUserLeaveHintListener(@NotNull Runnable runnable0) {
        q.g(runnable0, "listener");
        this.onUserLeaveHintListeners.remove(runnable0);
    }

    @Override  // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if(V4.u.x()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            b.m m0 = this.getFullyDrawnReporter();
            Object object0 = m0.b;
            synchronized(object0) {
                m0.c = true;
                for(Object object1: m0.d) {
                    ((we.a)object1).invoke();
                }
                m0.d.clear();
            }
        }
        finally {
            Trace.endSection();
        }
    }

    @Override  // android.app.Activity
    public void setContentView(int v) {
        this.initializeViewTreeOwners();
        View view0 = this.getWindow().getDecorView();
        q.f(view0, "window.decorView");
        ((b.i)this.reportFullyDrawnExecutor).a(view0);
        super.setContentView(v);
    }

    @Override  // android.app.Activity
    public void setContentView(@Nullable View view0) {
        this.initializeViewTreeOwners();
        View view1 = this.getWindow().getDecorView();
        q.f(view1, "window.decorView");
        ((b.i)this.reportFullyDrawnExecutor).a(view1);
        super.setContentView(view0);
    }

    @Override  // android.app.Activity
    public void setContentView(@Nullable View view0, @Nullable ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initializeViewTreeOwners();
        View view1 = this.getWindow().getDecorView();
        q.f(view1, "window.decorView");
        ((b.i)this.reportFullyDrawnExecutor).a(view1);
        super.setContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // android.app.Activity
    @ie.d
    public void startActivityForResult(@NotNull Intent intent0, int v) {
        q.g(intent0, "intent");
        super.startActivityForResult(intent0, v);
    }

    @Override  // android.app.Activity
    @ie.d
    public void startActivityForResult(@NotNull Intent intent0, int v, @Nullable Bundle bundle0) {
        q.g(intent0, "intent");
        super.startActivityForResult(intent0, v, bundle0);
    }

    @Override  // android.app.Activity
    @ie.d
    public void startIntentSenderForResult(@NotNull IntentSender intentSender0, int v, @Nullable Intent intent0, int v1, int v2, int v3) {
        q.g(intentSender0, "intent");
        super.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3);
    }

    @Override  // android.app.Activity
    @ie.d
    public void startIntentSenderForResult(@NotNull IntentSender intentSender0, int v, @Nullable Intent intent0, int v1, int v2, int v3, @Nullable Bundle bundle0) {
        q.g(intentSender0, "intent");
        super.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3, bundle0);
    }
}

