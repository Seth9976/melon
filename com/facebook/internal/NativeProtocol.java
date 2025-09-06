package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import je.n;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b}\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\n\b\u00C7\u0002\u0018\u00002\u00020\u0001:\u000E\u00F3\u0001\u00F4\u0001\u00F5\u0001\u00F6\u0001\u00F7\u0001\u00F8\u0001\u00F9\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00A2\u0006\u0004\b\b\u0010\u0007J!\u0010\u000B\u001A\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\tH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0012\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0013J\u0083\u0001\u0010$\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\n2\u000E\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\n2\b\u0010 \u001A\u0004\u0018\u00010\n2\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u00192\u0006\u0010#\u001A\u00020\u0019H\u0007\u00A2\u0006\u0004\b$\u0010%J\u00A9\u0001\u0010,\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0015\u001A\u00020\n2\u000E\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u001B\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010&\u001A\u00020\u00192\b\u0010 \u001A\u0004\u0018\u00010\n2\u0006\u0010!\u001A\u00020\u00192\u0006\u0010(\u001A\u00020\'2\u0006\u0010\"\u001A\u00020\u00192\u0006\u0010#\u001A\u00020\u00192\b\u0010)\u001A\u0004\u0018\u00010\n2\b\u0010*\u001A\u0004\u0018\u00010\n2\b\u0010+\u001A\u0004\u0018\u00010\nH\u0002\u00A2\u0006\u0004\b,\u0010-J\u00B1\u0001\u0010.\u001A\b\u0012\u0004\u0012\u00020\u000F0\u00042\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001A\u00020\n2\u000E\u0010\u0017\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00162\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001E\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\n2\u0006\u0010&\u001A\u00020\u00192\b\u0010 \u001A\u0004\u0018\u00010\n2\u0006\u0010!\u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u00192\u0006\u0010#\u001A\u00020\u00192\b\u0010)\u001A\u0004\u0018\u00010\n2\b\u0010*\u001A\u0004\u0018\u00010\n2\n\b\u0002\u0010+\u001A\u0004\u0018\u00010\nH\u0007\u00A2\u0006\u0004\b.\u0010/J\u000F\u00101\u001A\u000200H\u0007\u00A2\u0006\u0004\b1\u00102J\u0017\u00104\u001A\u00020\u00192\u0006\u00103\u001A\u000200H\u0007\u00A2\u0006\u0004\b4\u00105JA\u0010<\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000E\u001A\u00020\r2\b\u00106\u001A\u0004\u0018\u00010\n2\b\u00107\u001A\u0004\u0018\u00010\n2\b\u00109\u001A\u0004\u0018\u0001082\b\u0010;\u001A\u0004\u0018\u00010:H\u0007\u00A2\u0006\u0004\b<\u0010=J=\u0010@\u001A\u00020?2\u0006\u0010\u0010\u001A\u00020\u000F2\b\u00106\u001A\u0004\u0018\u00010\n2\b\u00107\u001A\u0004\u0018\u00010\n2\u0006\u00103\u001A\u0002002\b\u0010>\u001A\u0004\u0018\u00010:H\u0007\u00A2\u0006\u0004\b@\u0010AJ-\u0010F\u001A\u0004\u0018\u00010\u000F2\u0006\u0010B\u001A\u00020\u000F2\b\u0010C\u001A\u0004\u0018\u00010:2\b\u0010E\u001A\u0004\u0018\u00010DH\u0007\u00A2\u0006\u0004\bF\u0010GJ\u0019\u0010H\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001A\u0002002\u0006\u0010\u0010\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\bJ\u0010KJ\u001B\u0010M\u001A\u0004\u0018\u00010L2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001A\u0004\u0018\u00010:2\u0006\u0010\u0010\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\bO\u0010PJ\u0019\u0010Q\u001A\u0004\u0018\u00010:2\u0006\u0010\u0010\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\bQ\u0010PJ\u0019\u0010S\u001A\u0004\u0018\u00010:2\u0006\u0010R\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\bS\u0010PJ\u0017\u0010T\u001A\u00020\u00192\u0006\u0010R\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\bT\u0010UJ\u0019\u0010V\u001A\u0004\u0018\u00010:2\u0006\u0010R\u001A\u00020\u000FH\u0007\u00A2\u0006\u0004\bV\u0010PJ\u001B\u0010X\u001A\u0004\u0018\u00010D2\b\u0010W\u001A\u0004\u0018\u00010:H\u0007\u00A2\u0006\u0004\bX\u0010YJ\u001B\u0010[\u001A\u0004\u0018\u00010:2\b\u0010Z\u001A\u0004\u0018\u00010DH\u0007\u00A2\u0006\u0004\b[\u0010\\J\u0017\u0010^\u001A\u0002002\u0006\u0010]\u001A\u000200H\u0007\u00A2\u0006\u0004\b^\u0010_J\u001F\u0010b\u001A\u0002082\u0006\u00107\u001A\u00020\n2\u0006\u0010a\u001A\u00020`H\u0007\u00A2\u0006\u0004\bb\u0010cJ\'\u0010e\u001A\u0002082\u000E\u0010d\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010a\u001A\u00020`H\u0002\u00A2\u0006\u0004\be\u0010fJ\u000F\u0010g\u001A\u00020?H\u0007\u00A2\u0006\u0004\bg\u0010\u0003J\u001D\u0010i\u001A\b\u0012\u0004\u0012\u0002000h2\u0006\u0010\u0011\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bi\u0010jJ/\u0010m\u001A\u0002002\u000E\u0010k\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010h2\u0006\u0010l\u001A\u0002002\u0006\u0010a\u001A\u00020`H\u0007\u00A2\u0006\u0004\bm\u0010nJ\u0017\u0010p\u001A\u00020o2\u0006\u0010\u0011\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bp\u0010qR\u0014\u0010r\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\br\u0010sR\u001C\u0010u\u001A\n t*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0014\u0010w\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bw\u0010vR\u0014\u0010x\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bx\u0010vR\u0014\u0010y\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\by\u0010vR\u0014\u0010z\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bz\u0010vR\u0014\u0010{\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b{\u0010vR\u0014\u0010|\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b|\u0010vR\u0014\u0010}\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b}\u0010vR\u0014\u0010~\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b~\u0010vR\u0014\u0010\u007F\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u007F\u0010sR\u0016\u0010\u0080\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0080\u0001\u0010sR\u0016\u0010\u0081\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0081\u0001\u0010sR\u0016\u0010\u0082\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0082\u0001\u0010sR\u0016\u0010\u0083\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0083\u0001\u0010sR\u0016\u0010\u0084\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0084\u0001\u0010sR\u0016\u0010\u0085\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0085\u0001\u0010sR\u0016\u0010\u0086\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0086\u0001\u0010sR\u0016\u0010\u0087\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0087\u0001\u0010sR\u0016\u0010\u0088\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0088\u0001\u0010sR\u0016\u0010\u0089\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0089\u0001\u0010sR\u0016\u0010\u008A\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u008A\u0001\u0010sR\u0016\u0010\u008B\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u008B\u0001\u0010sR\u0016\u0010\u008C\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u008C\u0001\u0010sR\u0016\u0010\u008D\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u008D\u0001\u0010sR\u0016\u0010\u008E\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u008E\u0001\u0010sR\u0016\u0010\u008F\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u008F\u0001\u0010sR\u0016\u0010\u0090\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0090\u0001\u0010sR\u0016\u0010\u0091\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0091\u0001\u0010sR\u0016\u0010\u0092\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0092\u0001\u0010sR\u0016\u0010\u0093\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0093\u0001\u0010sR\u0016\u0010\u0094\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0094\u0001\u0010sR\u0016\u0010\u0095\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0095\u0001\u0010vR\u0016\u0010\u0096\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0096\u0001\u0010vR\u0016\u0010\u0097\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0097\u0001\u0010vR\u0016\u0010\u0098\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0098\u0001\u0010vR\u0016\u0010\u0099\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0099\u0001\u0010vR\u0016\u0010\u009A\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009A\u0001\u0010vR\u0016\u0010\u009B\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009B\u0001\u0010vR\u0016\u0010\u009C\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009C\u0001\u0010vR\u0016\u0010\u009D\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009D\u0001\u0010vR\u0016\u0010\u009E\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009E\u0001\u0010vR\u0016\u0010\u009F\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009F\u0001\u0010vR\u0016\u0010\u00A0\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A0\u0001\u0010vR\u0016\u0010\u00A1\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A1\u0001\u0010vR\u0016\u0010\u00A2\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A2\u0001\u0010vR\u0016\u0010\u00A3\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A3\u0001\u0010sR\u0016\u0010\u00A4\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A4\u0001\u0010sR\u0016\u0010\u00A5\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A5\u0001\u0010sR\u0016\u0010\u00A6\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A6\u0001\u0010sR\u0016\u0010\u00A7\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A7\u0001\u0010sR\u0016\u0010\u00A8\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A8\u0001\u0010sR\u0016\u0010\u00A9\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A9\u0001\u0010sR\u0016\u0010\u00AA\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AA\u0001\u0010sR\u0016\u0010\u00AB\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AB\u0001\u0010sR\u0016\u0010\u00AC\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AC\u0001\u0010sR\u0016\u0010\u00AD\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AD\u0001\u0010sR\u0016\u0010\u00AE\u0001\u001A\u0002008\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AE\u0001\u0010sR\u0016\u0010\u00AF\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AF\u0001\u0010vR\u0016\u0010\u00B0\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B0\u0001\u0010vR\u0016\u0010\u00B1\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B1\u0001\u0010vR\u0016\u0010\u00B2\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B2\u0001\u0010vR\u0016\u0010\u00B3\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B3\u0001\u0010vR\u0016\u0010\u00B4\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B4\u0001\u0010vR\u0016\u0010\u00B5\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B5\u0001\u0010vR\u0016\u0010\u00B6\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B6\u0001\u0010vR\u0016\u0010\u00B7\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B7\u0001\u0010vR\u0016\u0010\u00B8\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B8\u0001\u0010vR\u0016\u0010\u00B9\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B9\u0001\u0010vR\u0016\u0010\u00BA\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00BA\u0001\u0010vR\u0016\u0010\u00BB\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00BB\u0001\u0010vR\u0016\u0010\u00BC\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00BC\u0001\u0010vR\u0016\u0010\u00BD\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00BD\u0001\u0010vR\u0016\u0010\u00BE\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00BE\u0001\u0010vR\u0016\u0010\u00BF\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00BF\u0001\u0010vR\u0016\u0010\u00C0\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C0\u0001\u0010vR\u0016\u0010\u00C1\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C1\u0001\u0010vR\u0016\u0010\u00C2\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C2\u0001\u0010vR\u0016\u0010\u00C3\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C3\u0001\u0010vR\u0016\u0010\u00C4\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C4\u0001\u0010vR\u0016\u0010\u00C5\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C5\u0001\u0010vR\u0016\u0010\u00C6\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C6\u0001\u0010vR\u0016\u0010\u00C7\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C7\u0001\u0010vR\u0016\u0010\u00C8\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C8\u0001\u0010vR\u0016\u0010\u00C9\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00C9\u0001\u0010vR\u0016\u0010\u00CA\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00CA\u0001\u0010vR\u0016\u0010\u00CB\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00CB\u0001\u0010vR\u0016\u0010\u00CC\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00CC\u0001\u0010vR\u0016\u0010\u00CD\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00CD\u0001\u0010vR\u0016\u0010\u00CE\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00CE\u0001\u0010vR\u0016\u0010\u00CF\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00CF\u0001\u0010vR\u0016\u0010\u00D0\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D0\u0001\u0010vR\u0016\u0010\u00D1\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D1\u0001\u0010vR\u0016\u0010\u00D2\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D2\u0001\u0010vR\u0016\u0010\u00D3\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D3\u0001\u0010vR\u0016\u0010\u00D4\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D4\u0001\u0010vR\u0016\u0010\u00D5\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D5\u0001\u0010vR\u0016\u0010\u00D6\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D6\u0001\u0010vR\u0016\u0010\u00D7\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D7\u0001\u0010vR\u0016\u0010\u00D8\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D8\u0001\u0010vR\u0016\u0010\u00D9\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00D9\u0001\u0010vR\u0016\u0010\u00DA\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00DA\u0001\u0010vR\u0016\u0010\u00DB\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00DB\u0001\u0010vR\u0016\u0010\u00DC\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00DC\u0001\u0010vR\u0016\u0010\u00DD\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00DD\u0001\u0010vR\u0016\u0010\u00DE\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00DE\u0001\u0010vR\u0016\u0010\u00DF\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00DF\u0001\u0010vR\u0016\u0010\u00E0\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00E0\u0001\u0010vR\u0016\u0010\u00E1\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00E1\u0001\u0010vR\u0016\u0010\u00E2\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00E2\u0001\u0010vR\u0016\u0010\u00E3\u0001\u001A\u00020\n8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00E3\u0001\u0010vR\u0016\u0010\u00E4\u0001\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0007\n\u0005\b\u00E4\u0001\u0010vR\u0016\u0010\u00E5\u0001\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0007\n\u0005\b\u00E5\u0001\u0010vR\u0016\u0010\u00E6\u0001\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0007\n\u0005\b\u00E6\u0001\u0010vR\u0016\u0010\u00E7\u0001\u001A\u00020\n8\u0002X\u0082T\u00A2\u0006\u0007\n\u0005\b\u00E7\u0001\u0010vR\u001D\u0010\u00E8\u0001\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00E8\u0001\u0010\u00E9\u0001R\u001D\u0010\u00EA\u0001\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00EA\u0001\u0010\u00E9\u0001R)\u0010\u00EB\u0001\u001A\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\t8\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00EB\u0001\u0010\u00EC\u0001R\u0018\u0010\u00EE\u0001\u001A\u00030\u00ED\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00EE\u0001\u0010\u00EF\u0001R\u001E\u0010\u00F1\u0001\u001A\t\u0012\u0004\u0012\u0002000\u00F0\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00F1\u0001\u0010\u00F2\u0001\u00A8\u0006\u00FA\u0001"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "<init>", "()V", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "buildFacebookAppList", "()Ljava/util/List;", "buildEffectCameraAppInfoList", "", "", "buildActionToAppInfoMap", "()Ljava/util/Map;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "appInfo", "validateActivityIntent", "(Landroid/content/Context;Landroid/content/Intent;Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/content/Intent;", "validateServiceIntent", "applicationId", "", "permissions", "e2e", "", "isRerequest", "isForPublish", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createInstagramIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;ZZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Landroid/content/Intent;", "ignoreAppSwitchToLoggedOut", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "nonce", "codeChallenge", "codeChallengeMethod", "createNativeAppIntent", "(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;ZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/facebook/login/LoginTargetApp;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "createProxyAuthIntents", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;ZZLcom/facebook/login/DefaultAudience;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "getLatestKnownVersion", "()I", "version", "isVersionCompatibleWithBucketedIntent", "(I)Z", "callId", "action", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "versionResult", "Landroid/os/Bundle;", "extras", "createPlatformActivityIntent", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;Landroid/os/Bundle;)Landroid/content/Intent;", "params", "Lie/H;", "setupProtocolRequestIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)V", "requestIntent", "results", "Lcom/facebook/FacebookException;", "error", "createProtocolResultIntent", "(Landroid/content/Intent;Landroid/os/Bundle;Lcom/facebook/FacebookException;)Landroid/content/Intent;", "createPlatformServiceIntent", "(Landroid/content/Context;)Landroid/content/Intent;", "getProtocolVersionFromIntent", "(Landroid/content/Intent;)I", "Ljava/util/UUID;", "getCallIdFromIntent", "(Landroid/content/Intent;)Ljava/util/UUID;", "getBridgeArgumentsFromIntent", "(Landroid/content/Intent;)Landroid/os/Bundle;", "getMethodArgumentsFromIntent", "resultIntent", "getSuccessResultsFromIntent", "isErrorResult", "(Landroid/content/Intent;)Z", "getErrorDataFromResultIntent", "errorData", "getExceptionFromErrorData", "(Landroid/os/Bundle;)Lcom/facebook/FacebookException;", "e", "createBundleForException", "(Lcom/facebook/FacebookException;)Landroid/os/Bundle;", "minimumVersion", "getLatestAvailableProtocolVersionForService", "(I)I", "", "versionSpec", "getLatestAvailableProtocolVersionForAction", "(Ljava/lang/String;[I)Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "appInfoList", "getLatestAvailableProtocolVersionForAppInfoList", "(Ljava/util/List;[I)Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "updateAllAvailableProtocolVersionsAsync", "Ljava/util/TreeSet;", "fetchAllAvailableProtocolVersionsForAppInfo", "(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Ljava/util/TreeSet;", "allAvailableFacebookAppVersions", "latestSdkVersion", "computeLatestAvailableVersionFromVersionSpec", "(Ljava/util/TreeSet;I[I)I", "Landroid/net/Uri;", "buildPlatformProviderVersionURI", "(Lcom/facebook/internal/NativeProtocol$NativeAppInfo;)Landroid/net/Uri;", "NO_PROTOCOL_AVAILABLE", "I", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_SDK_VERSION_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131024", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140313", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20150401", "PROTOCOL_VERSION_20150702", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20161017", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "PROTOCOL_VERSION_20210906", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "EXTRA_PROTOCOL_VERSIONS", "ACTION_FEED_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_APPINVITE_DIALOG", "ACTION_CAMERA_EFFECT", "ACTION_SHARE_STORY", "EXTRA_PERMISSIONS", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_USER_ID", "EXTRA_LOGGER_REF", "EXTRA_TOAST_DURATION_MS", "EXTRA_GRAPH_API_VERSION", "EXTRA_NONCE", "EXTRA_ACCESS_TOKEN", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_AUTHENTICATION_TOKEN", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_SIGNED_REQUEST", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_PERMISSIONS", "OPEN_GRAPH_CREATE_OBJECT_KEY", "IMAGE_USER_GENERATED_KEY", "IMAGE_URL_KEY", "STATUS_ERROR_TYPE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_CODE", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_JSON", "BRIDGE_ARG_ERROR_TYPE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_JSON", "ERROR_UNKNOWN_ERROR", "ERROR_PROTOCOL_ERROR", "ERROR_USER_CANCELED", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_SERVICE_DISABLED", "WEB_DIALOG_URL", "WEB_DIALOG_ACTION", "WEB_DIALOG_PARAMS", "WEB_DIALOG_IS_FALLBACK", "AUDIENCE_ME", "AUDIENCE_FRIENDS", "AUDIENCE_EVERYONE", "CONTENT_SCHEME", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "facebookAppInfoList", "Ljava/util/List;", "effectCameraAppInfoList", "actionToAppInfoMap", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "KNOWN_PROTOCOL_VERSIONS", "[Ljava/lang/Integer;", "EffectTestAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class NativeProtocol {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class EffectTestAppInfo extends NativeAppInfo {
        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        public String getLoginActivity() {
            return null;
        }

        @Nullable
        public Void getLoginActivity() [...] // Inlined contents

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0016J\b\u0010\u0005\u001A\u00020\u0004H\u0016J\b\u0010\u0006\u001A\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class InstagramAppInfo extends NativeAppInfo {
        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.instagram.android";
        }

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getResponseType() {
            return "token,signed_request,graph_domain,granted_scopes";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "<init>", "()V", "", "isAndroidAPIVersionNotLessThan30", "()Z", "", "getLoginActivity", "()Ljava/lang/String;", "getPackage", "Lie/H;", "onAvailableVersionsNullOrEmpty", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class KatanaAppInfo extends NativeAppInfo {
        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.katana";
        }

        private final boolean isAndroidAPIVersionNotLessThan30() {
            return true;
        }

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        public void onAvailableVersionsNullOrEmpty() {
            if(this.isAndroidAPIVersionNotLessThan30()) {
                Log.w("com.facebook.internal.NativeProtocol", "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001A\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class MessengerAppInfo extends NativeAppInfo {
        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        public String getLoginActivity() {
            return null;
        }

        @Nullable
        public Void getLoginActivity() [...] // Inlined contents

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.orca";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0003J\u0015\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "<init>", "()V", "", "getPackage", "()Ljava/lang/String;", "getLoginActivity", "getResponseType", "Lie/H;", "onAvailableVersionsNullOrEmpty", "Ljava/util/TreeSet;", "", "getAvailableVersions", "()Ljava/util/TreeSet;", "", "force", "fetchAvailableVersions", "(Z)V", "availableVersions", "Ljava/util/TreeSet;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static abstract class NativeAppInfo {
        @Nullable
        private TreeSet availableVersions;

        public final void fetchAvailableVersions(boolean z) {
            synchronized(this) {
                if(z || (this.availableVersions == null || this.availableVersions.isEmpty())) {
                    this.availableVersions = NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol.INSTANCE, this);
                }
                if(this.availableVersions == null || this.availableVersions.isEmpty()) {
                    this.onAvailableVersionsNullOrEmpty();
                }
            }
        }

        @Nullable
        public final TreeSet getAvailableVersions() {
            if(this.availableVersions == null || this.availableVersions.isEmpty()) {
                this.fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        @Nullable
        public abstract String getLoginActivity();

        @NotNull
        public abstract String getPackage();

        @NotNull
        public String getResponseType() [...] // 潜在的解密器

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001E\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\b@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class ProtocolVersionQueryResult {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007J\b\u0010\t\u001A\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult$Companion;", "", "()V", "create", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "nativeAppInfo", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "protocolVersion", "", "createEmpty", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final ProtocolVersionQueryResult create(@Nullable NativeAppInfo nativeProtocol$NativeAppInfo0, int v) {
                ProtocolVersionQueryResult nativeProtocol$ProtocolVersionQueryResult0 = new ProtocolVersionQueryResult(null);
                nativeProtocol$ProtocolVersionQueryResult0.appInfo = nativeProtocol$NativeAppInfo0;
                nativeProtocol$ProtocolVersionQueryResult0.protocolVersion = v;
                return nativeProtocol$ProtocolVersionQueryResult0;
            }

            @NotNull
            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult nativeProtocol$ProtocolVersionQueryResult0 = new ProtocolVersionQueryResult(null);
                nativeProtocol$ProtocolVersionQueryResult0.protocolVersion = -1;
                return nativeProtocol$ProtocolVersionQueryResult0;
            }
        }

        @NotNull
        public static final Companion Companion;
        @Nullable
        private NativeAppInfo appInfo;
        private int protocolVersion;

        static {
            ProtocolVersionQueryResult.Companion = new Companion(null);
        }

        private ProtocolVersionQueryResult() {
        }

        public ProtocolVersionQueryResult(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public static final ProtocolVersionQueryResult create(@Nullable NativeAppInfo nativeProtocol$NativeAppInfo0, int v) {
            return ProtocolVersionQueryResult.Companion.create(nativeProtocol$NativeAppInfo0, v);
        }

        @NotNull
        public static final ProtocolVersionQueryResult createEmpty() {
            return ProtocolVersionQueryResult.Companion.createEmpty();
        }

        @Nullable
        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001A\u00020\u0004H\u0016J\b\u0010\u0005\u001A\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class WakizashiAppInfo extends NativeAppInfo {
        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override  // com.facebook.internal.NativeProtocol$NativeAppInfo
        @NotNull
        public String getPackage() {
            return "com.facebook.wakizashi";
        }
    }

    @NotNull
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    @NotNull
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    @NotNull
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    @NotNull
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    @NotNull
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    @NotNull
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    @NotNull
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    @NotNull
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    @NotNull
    public static final String AUDIENCE_EVERYONE = "everyone";
    @NotNull
    public static final String AUDIENCE_FRIENDS = "friends";
    @NotNull
    public static final String AUDIENCE_ME = "only_me";
    @NotNull
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    @NotNull
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    @NotNull
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    @NotNull
    private static final String CONTENT_SCHEME = "content://";
    @NotNull
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    @NotNull
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    @NotNull
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    @NotNull
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    @NotNull
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    @NotNull
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    @NotNull
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    @NotNull
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    @NotNull
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    @NotNull
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    @NotNull
    public static final String EXTRA_AUTHENTICATION_TOKEN = "com.facebook.platform.extra.ID_TOKEN";
    @NotNull
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    @NotNull
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    @NotNull
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    @NotNull
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    @NotNull
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    @NotNull
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    @NotNull
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    @NotNull
    public static final String EXTRA_NONCE = "com.facebook.platform.extra.NONCE";
    @NotNull
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    @NotNull
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    @NotNull
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    @NotNull
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    @NotNull
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    @NotNull
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    @NotNull
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    @NotNull
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    @NotNull
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    @NotNull
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    @NotNull
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    @NotNull
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    @NotNull
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    @NotNull
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    @NotNull
    public static final String IMAGE_URL_KEY = "url";
    @NotNull
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    @NotNull
    public static final NativeProtocol INSTANCE = null;
    @NotNull
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    @NotNull
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    @NotNull
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS = null;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 0x10001;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 0x10000;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 0x10009;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 0x10008;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 0x10005;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 0x10004;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 0x10007;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 0x10006;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 0x1000B;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 0x1000A;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 0x10003;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 0x10002;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    @NotNull
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    @NotNull
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    @NotNull
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    @NotNull
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 0x133060D;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131024 = 20131024;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140313 = 20140313;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20150401 = 20150401;
    public static final int PROTOCOL_VERSION_20150702 = 20150702;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20161017 = 20161017;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final int PROTOCOL_VERSION_20210906 = 20210906;
    @NotNull
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    @NotNull
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    @NotNull
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    @NotNull
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    @NotNull
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    @NotNull
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    @NotNull
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    @NotNull
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    @NotNull
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    @NotNull
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    @NotNull
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    @NotNull
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG = null;
    @NotNull
    public static final String WEB_DIALOG_ACTION = "action";
    @NotNull
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    @NotNull
    public static final String WEB_DIALOG_PARAMS = "params";
    @NotNull
    public static final String WEB_DIALOG_URL = "url";
    @NotNull
    private static final Map actionToAppInfoMap;
    @NotNull
    private static final List effectCameraAppInfoList;
    @NotNull
    private static final List facebookAppInfoList;
    @NotNull
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    static {
        NativeProtocol nativeProtocol0 = new NativeProtocol();
        NativeProtocol.INSTANCE = nativeProtocol0;
        NativeProtocol.TAG = "com.facebook.internal.NativeProtocol";
        NativeProtocol.facebookAppInfoList = nativeProtocol0.buildFacebookAppList();
        NativeProtocol.effectCameraAppInfoList = nativeProtocol0.buildEffectCameraAppInfoList();
        NativeProtocol.actionToAppInfoMap = nativeProtocol0.buildActionToAppInfoMap();
        NativeProtocol.protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        NativeProtocol.KNOWN_PROTOCOL_VERSIONS = new Integer[]{20210906, 20171115, 20170417, 20170411, 20170213, 20161017, 20160327, 20150702, 20150401, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140313, 20140204, 20131107, 20131024, 20130618, 20130502, 0x133060D};
    }

    public static final TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol0, NativeAppInfo nativeProtocol$NativeAppInfo0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return nativeProtocol0.fetchAllAvailableProtocolVersionsForAppInfo(nativeProtocol$NativeAppInfo0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    // 去混淆评级： 低(40)
    public static final String access$getTAG$p() [...] // 潜在的解密器

    private final Map buildActionToAppInfoMap() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map map0 = new HashMap();
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(new MessengerAppInfo());
            map0.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", NativeProtocol.facebookAppInfoList);
            map0.put("com.facebook.platform.action.request.FEED_DIALOG", NativeProtocol.facebookAppInfoList);
            map0.put("com.facebook.platform.action.request.LIKE_DIALOG", NativeProtocol.facebookAppInfoList);
            map0.put("com.facebook.platform.action.request.APPINVITES_DIALOG", NativeProtocol.facebookAppInfoList);
            map0.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList0);
            map0.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList0);
            map0.put("com.facebook.platform.action.request.CAMERA_EFFECT", NativeProtocol.effectCameraAppInfoList);
            map0.put("com.facebook.platform.action.request.SHARE_STORY", NativeProtocol.facebookAppInfoList);
            return map0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final List buildEffectCameraAppInfoList() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List list0 = k.e(new NativeAppInfo[]{new EffectTestAppInfo()});
            ((ArrayList)list0).addAll(this.buildFacebookAppList());
            return list0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final List buildFacebookAppList() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return k.e(new NativeAppInfo[]{new KatanaAppInfo(), new WakizashiAppInfo()});
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeProtocol$NativeAppInfo0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri uri0 = Uri.parse(("content://" + nativeProtocol$NativeAppInfo0.getPackage() + ".provider.PlatformProvider/versions"));
            q.f(uri0, "parse(CONTENT_SCHEME + a…ATFORM_PROVIDER_VERSIONS)");
            return uri0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    public static final int computeLatestAvailableVersionFromVersionSpec(@Nullable TreeSet treeSet0, int v, @NotNull int[] arr_v) {
        int v2;
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        try {
            q.g(arr_v, "versionSpec");
            if(treeSet0 == null) {
                return -1;
            }
            int v1 = arr_v.length - 1;
            v2 = -1;
            Iterator iterator0 = treeSet0.descendingIterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(((Integer)object0), "fbAppVersion");
                v2 = Math.max(v2, ((int)(((Integer)object0))));
                while(v1 >= 0 && arr_v[v1] > ((int)(((Integer)object0)))) {
                    --v1;
                }
                if(v1 < 0) {
                    return -1;
                }
                if(arr_v[v1] != ((int)(((Integer)object0)))) {
                    continue;
                }
                if(v1 % 2 != 0) {
                    break;
                }
                return Math.min(v2, v);
            }
            return -1;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return 0;
    }

    @Nullable
    public static final Bundle createBundleForException(@Nullable FacebookException facebookException0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(facebookException0 == null) {
            return null;
        }
        try {
            Bundle bundle0 = new Bundle();
            bundle0.putString("error_description", "");
            if(facebookException0 instanceof FacebookOperationCanceledException) {
                bundle0.putString("error_type", "UserCanceled");
                return bundle0;
            }
            return bundle0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final Intent createInstagramIntent(@NotNull Context context0, @NotNull String s, @NotNull Collection collection0, @NotNull String s1, boolean z, boolean z1, @NotNull DefaultAudience defaultAudience0, @NotNull String s2, @NotNull String s3, @Nullable String s4, boolean z2, boolean z3, boolean z4) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            q.g(s, "applicationId");
            q.g(collection0, "permissions");
            q.g(s1, "e2e");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s2, "clientState");
            q.g(s3, "authType");
            InstagramAppInfo nativeProtocol$InstagramAppInfo0 = new InstagramAppInfo();
            return NativeProtocol.validateActivityIntent(context0, NativeProtocol.INSTANCE.createNativeAppIntent(nativeProtocol$InstagramAppInfo0, s, collection0, s1, z1, defaultAudience0, s2, s3, false, s4, z2, LoginTargetApp.INSTAGRAM, z3, z4, "", null, null), nativeProtocol$InstagramAppInfo0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeProtocol$NativeAppInfo0, String s, Collection collection0, String s1, boolean z, DefaultAudience defaultAudience0, String s2, String s3, boolean z1, String s4, boolean z2, LoginTargetApp loginTargetApp0, boolean z3, boolean z4, String s5, String s6, String s7) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String s8 = nativeProtocol$NativeAppInfo0.getLoginActivity();
            if(s8 == null) {
                return null;
            }
            Intent intent0 = new Intent().setClassName(nativeProtocol$NativeAppInfo0.getPackage(), s8).putExtra("client_id", s);
            q.f(intent0, "Intent()\n            .se…PP_ID_KEY, applicationId)");
            intent0.putExtra("facebook_sdk_version", "18.1.3");
            if(!Utility.isNullOrEmpty(collection0)) {
                intent0.putExtra("scope", TextUtils.join(",", collection0));
            }
            if(!Utility.isNullOrEmpty(s1)) {
                intent0.putExtra("e2e", s1);
            }
            intent0.putExtra("state", s2);
            intent0.putExtra("response_type", "id_token,token,signed_request,graph_domain");
            intent0.putExtra("nonce", s5);
            intent0.putExtra("return_scopes", "true");
            if(z) {
                intent0.putExtra("default_audience", defaultAudience0.getNativeProtocolAudience());
            }
            intent0.putExtra("legacy_override", FacebookSdk.getGraphApiVersion());
            intent0.putExtra("auth_type", s3);
            if(z1) {
                intent0.putExtra("fail_on_logged_out", true);
            }
            intent0.putExtra("messenger_page_id", s4);
            intent0.putExtra("reset_messenger_state", z2);
            if(z3) {
                intent0.putExtra("fx_app", loginTargetApp0.toString());
            }
            if(z4) {
                intent0.putExtra("skip_dedupe", true);
            }
            return intent0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public static final Intent createPlatformActivityIntent(@NotNull Context context0, @Nullable String s, @Nullable String s1, @Nullable ProtocolVersionQueryResult nativeProtocol$ProtocolVersionQueryResult0, @Nullable Bundle bundle0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            if(nativeProtocol$ProtocolVersionQueryResult0 == null) {
                return null;
            }
            NativeAppInfo nativeProtocol$NativeAppInfo0 = nativeProtocol$ProtocolVersionQueryResult0.getAppInfo();
            if(nativeProtocol$NativeAppInfo0 == null) {
                return null;
            }
            Intent intent0 = NativeProtocol.validateActivityIntent(context0, new Intent().setAction("com.facebook.platform.PLATFORM_ACTIVITY").setPackage(nativeProtocol$NativeAppInfo0.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeProtocol$NativeAppInfo0);
            if(intent0 == null) {
                return null;
            }
            NativeProtocol.setupProtocolRequestIntent(intent0, s, s1, nativeProtocol$ProtocolVersionQueryResult0.getProtocolVersion(), bundle0);
            return intent0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final Intent createPlatformServiceIntent(@NotNull Context context0) {
        Intent intent0;
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            Iterator iterator0 = NativeProtocol.facebookAppInfoList.iterator();
            do {
                if(!iterator0.hasNext()) {
                    return null;
                }
                Object object0 = iterator0.next();
                intent0 = NativeProtocol.validateServiceIntent(context0, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(((NativeAppInfo)object0).getPackage()).addCategory("android.intent.category.DEFAULT"), ((NativeAppInfo)object0));
            }
            while(intent0 == null);
            return intent0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final Intent createProtocolResultIntent(@NotNull Intent intent0, @Nullable Bundle bundle0, @Nullable FacebookException facebookException0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(intent0, "requestIntent");
            UUID uUID0 = NativeProtocol.getCallIdFromIntent(intent0);
            if(uUID0 == null) {
                return null;
            }
            Intent intent1 = new Intent();
            intent1.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", NativeProtocol.getProtocolVersionFromIntent(intent0));
            Bundle bundle1 = new Bundle();
            bundle1.putString("action_id", uUID0.toString());
            if(facebookException0 != null) {
                bundle1.putBundle("error", NativeProtocol.createBundleForException(facebookException0));
            }
            intent1.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle1);
            if(bundle0 != null) {
                intent1.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle0);
            }
            return intent1;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @NotNull
    public static final List createProxyAuthIntents(@Nullable Context context0, @NotNull String s, @NotNull Collection collection0, @NotNull String s1, boolean z, boolean z1, @NotNull DefaultAudience defaultAudience0, @NotNull String s2, @NotNull String s3, boolean z2, @Nullable String s4, boolean z3, boolean z4, boolean z5, @Nullable String s5, @Nullable String s6, @Nullable String s7) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "applicationId");
            q.g(collection0, "permissions");
            q.g(s1, "e2e");
            q.g(defaultAudience0, "defaultAudience");
            q.g(s2, "clientState");
            q.g(s3, "authType");
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: NativeProtocol.facebookAppInfoList) {
                Intent intent0 = NativeProtocol.INSTANCE.createNativeAppIntent(((NativeAppInfo)object0), s, collection0, s1, z1, defaultAudience0, s2, s3, z2, s4, z3, LoginTargetApp.FACEBOOK, z4, z5, s5, s6, s7);
                if(intent0 != null) {
                    arrayList0.add(intent0);
                }
            }
            return arrayList0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static List createProxyAuthIntents$default(Context context0, String s, Collection collection0, String s1, boolean z, boolean z1, DefaultAudience defaultAudience0, String s2, String s3, boolean z2, String s4, boolean z3, boolean z4, boolean z5, String s5, String s6, String s7, int v, Object object0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return NativeProtocol.createProxyAuthIntents(context0, s, collection0, s1, z, z1, defaultAudience0, s2, s3, z2, s4, z3, z4, z5, s5, s6, ((v & 0x10000) == 0 ? s7 : "S256"));
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final TreeSet fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo nativeProtocol$NativeAppInfo0) {
        Cursor cursor1;
        Throwable throwable2;
        Cursor cursor0;
        ProviderInfo providerInfo0;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            TreeSet treeSet0 = new TreeSet();
            ContentResolver contentResolver0 = FacebookSdk.getApplicationContext().getContentResolver();
            Uri uri0 = this.buildPlatformProviderVersionURI(nativeProtocol$NativeAppInfo0);
            try {
                PackageManager packageManager0 = FacebookSdk.getApplicationContext().getPackageManager();
                String s = nativeProtocol$NativeAppInfo0.getPackage() + ".provider.PlatformProvider";
                try {
                    providerInfo0 = packageManager0.resolveContentProvider(s, 0);
                }
                catch(RuntimeException runtimeException0) {
                    Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.", runtimeException0);
                    providerInfo0 = null;
                }
                if(providerInfo0 == null) {
                    goto label_36;
                }
                else {
                    try {
                        cursor0 = contentResolver0.query(uri0, new String[]{"version"}, null, null, null);
                        goto label_26;
                    }
                    catch(NullPointerException unused_ex) {
                        Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.");
                    }
                    catch(SecurityException unused_ex) {
                        Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.");
                    }
                    catch(IllegalArgumentException unused_ex) {
                        Log.e("com.facebook.internal.NativeProtocol", "Failed to query content resolver.");
                    }
                    cursor0 = null;
                    goto label_26;
                }
                goto label_37;
            }
            catch(Throwable throwable1) {
                throwable2 = throwable1;
                cursor1 = null;
                goto label_33;
            }
        label_26:
            if(cursor0 != null) {
                try {
                    while(true) {
                        if(!cursor0.moveToNext()) {
                            goto label_37;
                        }
                        treeSet0.add(cursor0.getInt(cursor0.getColumnIndex("version")));
                    }
                }
                catch(Throwable throwable3) {
                    cursor1 = cursor0;
                    throwable2 = throwable3;
                }
            label_33:
                if(cursor1 != null) {
                    cursor1.close();
                }
                throw throwable2;
            label_36:
                cursor0 = null;
            }
        label_37:
            if(cursor0 != null) {
                cursor0.close();
                return treeSet0;
            }
            return treeSet0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public static final Bundle getBridgeArgumentsFromIntent(@NotNull Intent intent0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(intent0, "intent");
            return NativeProtocol.isVersionCompatibleWithBucketedIntent(NativeProtocol.getProtocolVersionFromIntent(intent0)) ? intent0.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS") : null;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final UUID getCallIdFromIntent(@Nullable Intent intent0) {
        String s;
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(intent0 == null) {
            return null;
        }
        try {
            if(NativeProtocol.isVersionCompatibleWithBucketedIntent(NativeProtocol.getProtocolVersionFromIntent(intent0))) {
                Bundle bundle0 = intent0.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                s = bundle0 == null ? null : bundle0.getString("action_id");
            }
            else {
                s = intent0.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if(s != null) {
                try {
                    return UUID.fromString(s);
                }
                catch(IllegalArgumentException unused_ex) {
                    return null;
                }
                goto label_16;
            }
            return null;
        }
        catch(Throwable throwable0) {
        }
    label_16:
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @Nullable
    public static final Bundle getErrorDataFromResultIntent(@NotNull Intent intent0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(intent0, "resultIntent");
            if(!NativeProtocol.isErrorResult(intent0)) {
                return null;
            }
            Bundle bundle0 = NativeProtocol.getBridgeArgumentsFromIntent(intent0);
            return bundle0 == null ? intent0.getExtras() : bundle0.getBundle("error");
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @Nullable
    public static final FacebookException getExceptionFromErrorData(@Nullable Bundle bundle0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(bundle0 == null) {
            return null;
        }
        try {
            String s = bundle0.getString("error_type");
            if(s == null) {
                s = bundle0.getString("com.facebook.platform.status.ERROR_TYPE");
            }
            String s1 = bundle0.getString("error_description");
            if(s1 == null) {
                s1 = bundle0.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
            }
            return s != null && s.equalsIgnoreCase("UserCanceled") ? new FacebookOperationCanceledException(s1) : new FacebookException(s1);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @NotNull
    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(@NotNull String s, @NotNull int[] arr_v) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "action");
            q.g(arr_v, "versionSpec");
            List list0 = (List)NativeProtocol.actionToAppInfoMap.get(s);
            if(list0 == null) {
                list0 = w.a;
            }
            return NativeProtocol.INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(list0, arr_v);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List list0, int[] arr_v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            NativeProtocol.updateAllAvailableProtocolVersionsAsync();
            if(list0 == null) {
                return ProtocolVersionQueryResult.Companion.createEmpty();
            }
            for(Object object0: list0) {
                NativeAppInfo nativeProtocol$NativeAppInfo0 = (NativeAppInfo)object0;
                int v = NativeProtocol.computeLatestAvailableVersionFromVersionSpec(nativeProtocol$NativeAppInfo0.getAvailableVersions(), NativeProtocol.getLatestKnownVersion(), arr_v);
                if(v != -1) {
                    return ProtocolVersionQueryResult.Companion.create(nativeProtocol$NativeAppInfo0, v);
                }
                if(false) {
                    break;
                }
            }
            return ProtocolVersionQueryResult.Companion.createEmpty();
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    public static final int getLatestAvailableProtocolVersionForService(int v) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        try {
            return NativeProtocol.INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(NativeProtocol.facebookAppInfoList, new int[]{v}).getProtocolVersion();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return 0;
        }
    }

    public static final int getLatestKnownVersion() {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        try {
            return (int)NativeProtocol.KNOWN_PROTOCOL_VERSIONS[0];
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return 0;
        }
    }

    @Nullable
    public static final Bundle getMethodArgumentsFromIntent(@NotNull Intent intent0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(intent0, "intent");
            return NativeProtocol.isVersionCompatibleWithBucketedIntent(NativeProtocol.getProtocolVersionFromIntent(intent0)) ? intent0.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS") : intent0.getExtras();
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    public static final int getProtocolVersionFromIntent(@NotNull Intent intent0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        try {
            q.g(intent0, "intent");
            return intent0.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return 0;
        }
    }

    @Nullable
    public static final Bundle getSuccessResultsFromIntent(@NotNull Intent intent0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(intent0, "resultIntent");
            int v = NativeProtocol.getProtocolVersionFromIntent(intent0);
            Bundle bundle0 = intent0.getExtras();
            return !NativeProtocol.isVersionCompatibleWithBucketedIntent(v) || bundle0 == null ? bundle0 : bundle0.getBundle("com.facebook.platform.protocol.RESULT_ARGS");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final boolean isErrorResult(@NotNull Intent intent0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            q.g(intent0, "resultIntent");
            Bundle bundle0 = NativeProtocol.getBridgeArgumentsFromIntent(intent0);
            return bundle0 == null ? intent0.hasExtra("com.facebook.platform.status.ERROR_TYPE") : bundle0.containsKey("error");
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return false;
    }

    public static final boolean isVersionCompatibleWithBucketedIntent(int v) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            if(n.Q(NativeProtocol.KNOWN_PROTOCOL_VERSIONS, v) && v >= 20140701) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return false;
    }

    public static final void setupProtocolRequestIntent(@NotNull Intent intent0, @Nullable String s, @Nullable String s1, int v, @Nullable Bundle bundle0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(intent0, "intent");
                String s2 = FacebookSdk.getApplicationId();
                String s3 = FacebookSdk.getApplicationName();
                intent0.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", v).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", s1).putExtra("com.facebook.platform.extra.APPLICATION_ID", s2);
                if(NativeProtocol.isVersionCompatibleWithBucketedIntent(v)) {
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("action_id", s);
                    Utility.putNonEmptyString(bundle1, "app_name", s3);
                    intent0.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle1);
                    if(bundle0 == null) {
                        bundle0 = new Bundle();
                    }
                    intent0.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle0);
                    return;
                }
                intent0.putExtra("com.facebook.platform.protocol.CALL_ID", s);
                if(!Utility.isNullOrEmpty(s3)) {
                    intent0.putExtra("com.facebook.platform.extra.APPLICATION_NAME", s3);
                }
                if(bundle0 != null) {
                    intent0.putExtras(bundle0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    public static final void updateAllAvailableProtocolVersionsAsync() {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                if(NativeProtocol.protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                    FacebookSdk.getExecutor().execute(() -> {
                        Class class0 = NativeProtocol.class;
                        if(CrashShieldHandler.isObjectCrashing(class0)) {
                            return;
                        }
                        try {
                            for(Object object0: NativeProtocol.facebookAppInfoList) {
                                ((NativeAppInfo)object0).fetchAvailableVersions(true);
                            }
                            return;
                        }
                        catch(Throwable throwable0) {
                        }
                        finally {
                            NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                        }
                        CrashShieldHandler.handleThrowable(throwable0, class0);
                    });
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    // 检测为 Lambda 实现
    private static final void updateAllAvailableProtocolVersionsAsync$lambda$1() [...]

    @Nullable
    public static final Intent validateActivityIntent(@NotNull Context context0, @Nullable Intent intent0, @Nullable NativeAppInfo nativeProtocol$NativeAppInfo0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            if(intent0 == null) {
                return null;
            }
            ResolveInfo resolveInfo0 = context0.getPackageManager().resolveActivity(intent0, 0);
            if(resolveInfo0 == null) {
                return null;
            }
            String s = resolveInfo0.activityInfo.packageName;
            q.f(s, "resolveInfo.activityInfo.packageName");
            return !FacebookSignatureValidator.validateSignature(context0, s) ? null : intent0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @Nullable
    public static final Intent validateServiceIntent(@NotNull Context context0, @Nullable Intent intent0, @Nullable NativeAppInfo nativeProtocol$NativeAppInfo0) {
        Class class0 = NativeProtocol.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(context0, "context");
            if(intent0 == null) {
                return null;
            }
            ResolveInfo resolveInfo0 = context0.getPackageManager().resolveService(intent0, 0);
            if(resolveInfo0 == null) {
                return null;
            }
            String s = resolveInfo0.serviceInfo.packageName;
            q.f(s, "resolveInfo.serviceInfo.packageName");
            return !FacebookSignatureValidator.validateSignature(context0, s) ? null : intent0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

