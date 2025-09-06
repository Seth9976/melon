package com.facebook;

import Tf.v;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import b.l;
import b3.z;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.iap.InAppPurchaseLoggerManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener.Companion;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import ie.d;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import je.I;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u009A\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\b\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0004\u00B6\u0001\u00B7\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0016J\u000F\u0010\u001B\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b \u0010\u0013J\u000F\u0010!\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b!\u0010\u001CJ\u000F\u0010\"\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b\"\u0010\u001CJ\u000F\u0010#\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b#\u0010\u001CJ\u0017\u0010%\u001A\u00020\b2\u0006\u0010$\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b%\u0010\u001FJ\u001F\u0010*\u001A\u00020\b2\u0006\u0010\'\u001A\u00020&2\u0006\u0010)\u001A\u00020(H\u0007\u00A2\u0006\u0004\b*\u0010+J)\u0010*\u001A\u00020\b2\u0006\u0010\'\u001A\u00020&2\u0006\u0010)\u001A\u00020(2\b\u0010-\u001A\u0004\u0018\u00010,H\u0007\u00A2\u0006\u0004\b*\u0010.J\u0017\u0010*\u001A\u00020\b2\u0006\u0010\'\u001A\u00020&H\u0007\u00A2\u0006\u0004\b*\u0010/J!\u0010*\u001A\u00020\b2\u0006\u0010\'\u001A\u00020&2\b\u0010-\u001A\u0004\u0018\u00010,H\u0007\u00A2\u0006\u0004\b*\u00100J\u000F\u00101\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b1\u0010\u0013J\u000F\u00102\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b2\u0010\u0003J\u0015\u00105\u001A\b\u0012\u0004\u0012\u00020403H\u0007\u00A2\u0006\u0004\b5\u00106J\u0017\u00108\u001A\u00020\b2\u0006\u00107\u001A\u000204H\u0007\u00A2\u0006\u0004\b8\u00109J\u0017\u0010:\u001A\u00020\b2\u0006\u00107\u001A\u000204H\u0007\u00A2\u0006\u0004\b:\u00109J\u000F\u0010;\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b;\u0010\u0003J\u0017\u0010<\u001A\u00020\u00112\u0006\u00107\u001A\u000204H\u0007\u00A2\u0006\u0004\b<\u0010=J\u000F\u0010>\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b>\u0010\u0003J\u000F\u0010?\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\b?\u0010\u001CJ\u000F\u0010@\u001A\u00020&H\u0007\u00A2\u0006\u0004\b@\u0010AJ\u001F\u0010D\u001A\u00020\b2\u0006\u0010B\u001A\u00020&2\u0006\u0010C\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\bD\u0010EJ\u001F\u0010F\u001A\u00020\b2\u0006\u0010B\u001A\u00020&2\u0006\u0010C\u001A\u00020\u001AH\u0003\u00A2\u0006\u0004\bF\u0010EJ\u000F\u0010G\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\bG\u0010\u001CJ\u0017\u0010H\u001A\u00020\u00112\u0006\u0010B\u001A\u00020&H\u0007\u00A2\u0006\u0004\bH\u0010IJ\u001F\u0010K\u001A\u00020\b2\u0006\u0010B\u001A\u00020&2\u0006\u0010J\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001A\u00020\b2\b\u0010B\u001A\u0004\u0018\u00010&H\u0001\u00A2\u0006\u0004\bM\u0010/J\u001B\u0010O\u001A\u0004\u0018\u00010\u001A2\b\u0010B\u001A\u0004\u0018\u00010&H\u0007\u00A2\u0006\u0004\bO\u0010PJ\u000F\u0010Q\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\bQ\u0010\u001CJ\u0017\u0010R\u001A\u00020\b2\u0006\u0010C\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\bR\u0010\u001FJ\u0011\u0010S\u001A\u0004\u0018\u00010\u001AH\u0007\u00A2\u0006\u0004\bS\u0010\u001CJ\u0019\u0010U\u001A\u00020\b2\b\u0010T\u001A\u0004\u0018\u00010\u001AH\u0007\u00A2\u0006\u0004\bU\u0010\u001FJ\u000F\u0010V\u001A\u00020\u001AH\u0007\u00A2\u0006\u0004\bV\u0010\u001CJ\u0019\u0010X\u001A\u00020\b2\b\u0010W\u001A\u0004\u0018\u00010\u001AH\u0007\u00A2\u0006\u0004\bX\u0010\u001FJ\u000F\u0010Y\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\bY\u0010\u0013J\u0017\u0010[\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b[\u0010\u0016J\u000F\u0010\\\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\\\u0010\u0013J\u0017\u0010]\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b]\u0010\u0016J\u000F\u0010^\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b^\u0010\u0013J\u000F\u0010_\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b_\u0010\u0013J\u000F\u0010`\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b`\u0010\u0013J\u0017\u0010a\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\ba\u0010\u0016J\u0017\u0010b\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\bb\u0010\u0016J\u000F\u0010c\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\bc\u0010\u0013J\u0017\u0010d\u001A\u00020\b2\u0006\u0010Z\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\bd\u0010\u0016J\u001F\u0010g\u001A\u00020\b2\u000E\u0010f\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010eH\u0007\u00A2\u0006\u0004\bg\u0010hJ/\u0010g\u001A\u00020\b2\u000E\u0010f\u001A\n\u0012\u0004\u0012\u00020\u001A\u0018\u00010e2\u0006\u0010i\u001A\u00020(2\u0006\u0010j\u001A\u00020(H\u0007\u00A2\u0006\u0004\bg\u0010kJ\u0011\u0010m\u001A\u0004\u0018\u00010lH\u0007\u00A2\u0006\u0004\bm\u0010nJ\u0017\u0010p\u001A\u00020\b2\u0006\u0010o\u001A\u00020lH\u0007\u00A2\u0006\u0004\bp\u0010qJ\u000F\u0010r\u001A\u00020(H\u0007\u00A2\u0006\u0004\br\u0010sJ\u0017\u0010u\u001A\u00020\u00112\u0006\u0010t\u001A\u00020(H\u0007\u00A2\u0006\u0004\bu\u0010vJ\u0017\u0010{\u001A\u00020\b2\u0006\u0010x\u001A\u00020wH\u0001\u00A2\u0006\u0004\by\u0010zR\u001C\u0010}\u001A\n |*\u0004\u0018\u00010\u001A0\u001A8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b}\u0010~R(\u0010\u0081\u0001\u001A\u0013\u0012\u0004\u0012\u0002040\u007Fj\t\u0012\u0004\u0012\u000204`\u0080\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0017\u0010\u0083\u0001\u001A\u00020(8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0007\u0010\u0085\u0001R\u0018\u0010C\u001A\u0004\u0018\u00010\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010~R\u0018\u0010T\u001A\u0004\u0018\u00010\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010~R\u001A\u0010\u0086\u0001\u001A\u0004\u0018\u00010\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0086\u0001\u0010~R\u001B\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001A\u0010\u008A\u0001\u001A\u00030\u0089\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008A\u0001\u0010\u008B\u0001R\u0019\u0010\u008C\u0001\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008C\u0001\u0010\u008D\u0001R\u0017\u0010\u0017\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0017\u0010\u008D\u0001R\u001E\u0010o\u001A\t\u0012\u0004\u0012\u00020l0\u008E\u00018\u0002@\u0002X\u0082.\u00A2\u0006\u0007\n\u0005\bo\u0010\u008F\u0001R\u0017\u0010\'\u001A\u00020&8\u0002@\u0002X\u0082.\u00A2\u0006\u0007\n\u0005\b\'\u0010\u0090\u0001R\u0017\u0010)\u001A\u00020(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b)\u0010\u0084\u0001R\u0018\u0010\u0092\u0001\u001A\u00030\u0091\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0016\u0010\u001D\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u001D\u0010~R\u0017\u0010\u0094\u0001\u001A\u00020(8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0084\u0001R\u0016\u0010\u0095\u0001\u001A\u00020\u001A8\u0002X\u0082T\u00A2\u0006\u0007\n\u0005\b\u0095\u0001\u0010~R\u0016\u0010\u0096\u0001\u001A\u00020\u001A8\u0002X\u0082T\u00A2\u0006\u0007\n\u0005\b\u0096\u0001\u0010~R\u0016\u0010\u0097\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0097\u0001\u0010~R\u0016\u0010\u0098\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0098\u0001\u0010~R\u0016\u0010\u0099\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u0099\u0001\u0010~R\u0016\u0010\u009A\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009A\u0001\u0010~R\u0016\u0010\u009B\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009B\u0001\u0010~R\u0016\u0010\u009C\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009C\u0001\u0010~R\u0016\u0010\u009D\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009D\u0001\u0010~R\u0016\u0010\u009E\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009E\u0001\u0010~R\u0016\u0010\u009F\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u009F\u0001\u0010~R\u0016\u0010\u00A0\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A0\u0001\u0010~R\u0016\u0010\u00A1\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A1\u0001\u0010~R\u0016\u0010\u00A2\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A2\u0001\u0010~R\u0016\u0010\u00A3\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A3\u0001\u0010~R\u0016\u0010\u00A4\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A4\u0001\u0010~R\u0016\u0010\u00A5\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A5\u0001\u0010~R\u0016\u0010\u00A6\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A6\u0001\u0010~R\u0016\u0010\u00A7\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00A7\u0001\u0010~R\u0019\u0010\u00A8\u0001\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\b\n\u0006\b\u00A8\u0001\u0010\u008D\u0001R\u0019\u0010\u00A9\u0001\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\b\n\u0006\b\u00A9\u0001\u0010\u008D\u0001R\u0019\u0010\u00AA\u0001\u001A\u00020\u00118\u0006@\u0006X\u0087\u000E\u00A2\u0006\b\n\u0006\b\u00AA\u0001\u0010\u008D\u0001R\u0016\u0010\u00AB\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AB\u0001\u0010~R\u0016\u0010\u00AC\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AC\u0001\u0010~R\u0016\u0010\u00AD\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AD\u0001\u0010~R\u0016\u0010\u00AE\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AE\u0001\u0010~R\u0016\u0010\u00AF\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00AF\u0001\u0010~R\u0018\u0010\u00B1\u0001\u001A\u00030\u00B0\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B1\u0001\u0010\u00B2\u0001R\u0018\u0010\u00B3\u0001\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u00B3\u0001\u0010~R\u0016\u0010$\u001A\u00020\u001A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b$\u0010~R\u0017\u0010x\u001A\u00020w8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\bx\u0010\u00B4\u0001R\u0016\u0010\u00B5\u0001\u001A\u00020\u001A8\u0006X\u0086T\u00A2\u0006\u0007\n\u0005\b\u00B5\u0001\u0010~R\u0017\u0010 \u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b \u0010\u008D\u0001\u00A8\u0006\u00B8\u0001"}, d2 = {"Lcom/facebook/FacebookSdk;", "", "<init>", "()V", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "Lie/H;", "setExecutor", "(Ljava/util/concurrent/Executor;)V", "", "getOnProgressThreshold", "()J", "threshold", "setOnProgressThreshold", "(J)V", "", "isDebugEnabled", "()Z", "enabled", "setIsDebugEnabled", "(Z)V", "isLegacyTokenUpgradeSupported", "supported", "setLegacyTokenUpgradeSupported", "", "getGraphApiVersion", "()Ljava/lang/String;", "graphApiVersion", "setGraphApiVersion", "(Ljava/lang/String;)V", "isFullyInitialized", "getFacebookDomain", "getFacebookGamingDomain", "getInstagramDomain", "facebookDomain", "setFacebookDomain", "Landroid/content/Context;", "applicationContext", "", "callbackRequestCodeOffset", "sdkInitialize", "(Landroid/content/Context;I)V", "Lcom/facebook/FacebookSdk$InitializeCallback;", "callback", "(Landroid/content/Context;ILcom/facebook/FacebookSdk$InitializeCallback;)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Lcom/facebook/FacebookSdk$InitializeCallback;)V", "isInitialized", "fullyInitialize", "", "Lcom/facebook/LoggingBehavior;", "getLoggingBehaviors", "()Ljava/util/Set;", "behavior", "addLoggingBehavior", "(Lcom/facebook/LoggingBehavior;)V", "removeLoggingBehavior", "clearLoggingBehaviors", "isLoggingBehaviorEnabled", "(Lcom/facebook/LoggingBehavior;)Z", "updateGraphDebugBehavior", "getGraphDomain", "getApplicationContext", "()Landroid/content/Context;", "context", "applicationId", "publishInstallAsync", "(Landroid/content/Context;Ljava/lang/String;)V", "publishInstallAndWaitForResponse", "getSdkVersion", "getLimitEventAndDataUsage", "(Landroid/content/Context;)Z", "limitEventUsage", "setLimitEventAndDataUsage", "(Landroid/content/Context;Z)V", "loadDefaultsFromMetadata$facebook_core_release", "loadDefaultsFromMetadata", "getApplicationSignature", "(Landroid/content/Context;)Ljava/lang/String;", "getApplicationId", "setApplicationId", "getApplicationName", "applicationName", "setApplicationName", "getClientToken", "clientToken", "setClientToken", "getAutoInitEnabled", "flag", "setAutoInitEnabled", "getAutoLogAppEventsEnabled", "setAutoLogAppEventsEnabled", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getAdvertiserIDCollectionEnabled", "setAdvertiserIDCollectionEnabled", "setCodelessDebugLogEnabled", "getMonitorEnabled", "setMonitorEnabled", "", "options", "setDataProcessingOptions", "([Ljava/lang/String;)V", "country", "state", "([Ljava/lang/String;II)V", "Ljava/io/File;", "getCacheDir", "()Ljava/io/File;", "cacheDir", "setCacheDir", "(Ljava/io/File;)V", "getCallbackRequestCodeOffset", "()I", "requestCode", "isFacebookRequestCode", "(I)Z", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "graphRequestCreator", "setGraphRequestCreator$facebook_core_release", "(Lcom/facebook/FacebookSdk$GraphRequestCreator;)V", "setGraphRequestCreator", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "loggingBehaviors", "Ljava/util/HashSet;", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "I", "Ljava/util/concurrent/Executor;", "appClientToken", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "isDebugEnabledField", "Z", "Lcom/facebook/internal/LockOnGetVariable;", "Lcom/facebook/internal/LockOnGetVariable;", "Landroid/content/Context;", "Ljava/util/concurrent/locks/ReentrantLock;", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "ATTRIBUTION_PREFERENCES", "PUBLISH_ACTIVITY_PATH", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "APP_EVENT_PREFERENCES", "DATA_PROCESSING_OPTIONS_PREFERENCES", "APPLICATION_ID_PROPERTY", "APPLICATION_NAME_PROPERTY", "CLIENT_TOKEN_PROPERTY", "WEB_DIALOG_THEME", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "CALLBACK_OFFSET_PROPERTY", "MONITOR_ENABLED_PROPERTY", "DATA_PROCESSION_OPTIONS", "DATA_PROCESSION_OPTIONS_COUNTRY", "DATA_PROCESSION_OPTIONS_STATE", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "bypassAppSwitch", "INSTAGRAM", "GAMING", "FACEBOOK_COM", "FB_GG", "INSTAGRAM_COM", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "instagramDomain", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "CLOUDBRIDGE_SAVED_CREDENTIALS", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookSdk {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bá\u0080\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\u0010\b\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "createPostRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface GraphRequestCreator {
        @NotNull
        GraphRequest createPostRequest(@Nullable AccessToken arg1, @Nullable String arg2, @Nullable JSONObject arg3, @Nullable Callback arg4);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "Lie/H;", "onInitialized", "()V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface InitializeCallback {
        void onInitialized();
    }

    @NotNull
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    @NotNull
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    @NotNull
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    @NotNull
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    @NotNull
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    @NotNull
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    @NotNull
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    @NotNull
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can\'t be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    @NotNull
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can\'t be negative.";
    @NotNull
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    @NotNull
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    @NotNull
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";
    @NotNull
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    @NotNull
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    @NotNull
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";
    @NotNull
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";
    @NotNull
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 0xFACE;
    @NotNull
    public static final String FACEBOOK_COM = "facebook.com";
    @NotNull
    public static final String FB_GG = "fb.gg";
    @NotNull
    public static final String GAMING = "gaming";
    @NotNull
    public static final String INSTAGRAM = "instagram";
    @NotNull
    public static final String INSTAGRAM_COM = "instagram.com";
    @NotNull
    public static final FacebookSdk INSTANCE = null;
    @NotNull
    private static final ReentrantLock LOCK = null;
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    @NotNull
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    @NotNull
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = null;
    @NotNull
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    @Nullable
    private static volatile String appClientToken;
    private static Context applicationContext;
    @Nullable
    private static volatile String applicationId;
    @Nullable
    private static volatile String applicationName;
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable cacheDir;
    private static int callbackRequestCodeOffset;
    @Nullable
    private static volatile Boolean codelessDebugLogEnabled;
    @Nullable
    private static Executor executor;
    @NotNull
    private static volatile String facebookDomain;
    @NotNull
    private static String graphApiVersion;
    @NotNull
    private static GraphRequestCreator graphRequestCreator;
    public static boolean hasCustomTabsPrefetching;
    public static boolean ignoreAppSwitchToLoggedOut;
    @NotNull
    private static volatile String instagramDomain;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;
    @NotNull
    private static final HashSet loggingBehaviors;
    @NotNull
    private static AtomicLong onProgressThreshold;
    @NotNull
    private static final AtomicBoolean sdkInitialized;

    static {
        FacebookSdk.INSTANCE = new FacebookSdk();
        FacebookSdk.TAG = FacebookSdk.class.getCanonicalName();
        FacebookSdk.loggingBehaviors = I.H(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS});
        FacebookSdk.onProgressThreshold = new AtomicLong(0x10000L);
        FacebookSdk.callbackRequestCodeOffset = 0xFACE;
        FacebookSdk.LOCK = new ReentrantLock();
        FacebookSdk.graphApiVersion = "v16.0";
        FacebookSdk.sdkInitialized = new AtomicBoolean(false);
        FacebookSdk.instagramDomain = "instagram.com";
        FacebookSdk.facebookDomain = "facebook.com";
        FacebookSdk.graphRequestCreator = new z(14);
    }

    public static void a(boolean z) {
        FacebookSdk.sdkInitialize$lambda$6(z);
    }

    public static final void addLoggingBehavior(@NotNull LoggingBehavior loggingBehavior0) {
        q.g(loggingBehavior0, "behavior");
        synchronized(FacebookSdk.loggingBehaviors) {
            FacebookSdk.loggingBehaviors.add(loggingBehavior0);
            FacebookSdk.INSTANCE.updateGraphDebugBehavior();
        }
    }

    public static GraphRequest b(AccessToken accessToken0, String s, JSONObject jSONObject0, Callback graphRequest$Callback0) {
        return FacebookSdk.graphRequestCreator$lambda$0(accessToken0, s, jSONObject0, graphRequest$Callback0);
    }

    public static void c(boolean z) {
        FacebookSdk.sdkInitialize$lambda$7(z);
    }

    public static final void clearLoggingBehaviors() {
        synchronized(FacebookSdk.loggingBehaviors) {
            FacebookSdk.loggingBehaviors.clear();
        }
    }

    public static void d(Context context0, String s) {
        FacebookSdk.publishInstallAsync$lambda$15(context0, s);
    }

    public static void f(boolean z) {
        FacebookSdk.sdkInitialize$lambda$5(z);
    }

    public static final void fullyInitialize() {
        FacebookSdk.isFullyInitialized = true;
    }

    public static void g(boolean z) {
        FacebookSdk.sdkInitialize$lambda$4(z);
    }

    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    @NotNull
    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context0 = FacebookSdk.applicationContext;
        if(context0 != null) {
            return context0;
        }
        q.m("applicationContext");
        throw null;
    }

    @NotNull
    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String s = FacebookSdk.applicationId;
        if(s == null) {
            throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
        }
        return s;
    }

    @Nullable
    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return FacebookSdk.applicationName;
    }

    @Nullable
    public static final String getApplicationSignature(@Nullable Context context0) {
        MessageDigest messageDigest0;
        PackageInfo packageInfo0;
        Class class0 = FacebookSdk.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            Validate.sdkInitialized();
            if(context0 == null) {
                return null;
            }
            PackageManager packageManager0 = context0.getPackageManager();
            if(packageManager0 == null) {
                return null;
            }
            try {
                packageInfo0 = packageManager0.getPackageInfo("com.iloen.melon", 0x40);
                if(packageInfo0.signatures != null && packageInfo0.signatures.length != 0) {
                    goto label_11;
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
            }
            return null;
            try {
            label_11:
                messageDigest0 = MessageDigest.getInstance("SHA-1");
            }
            catch(NoSuchAlgorithmException unused_ex) {
                return null;
            }
            messageDigest0.update(packageInfo0.signatures[0].toByteArray());
            return Base64.encodeToString(messageDigest0.digest(), 9);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return null;
    }

    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    @Nullable
    public static final File getCacheDir() {
        Validate.sdkInitialized();
        LockOnGetVariable lockOnGetVariable0 = FacebookSdk.cacheDir;
        if(lockOnGetVariable0 != null) {
            return (File)lockOnGetVariable0.getValue();
        }
        q.m("cacheDir");
        throw null;
    }

    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return FacebookSdk.callbackRequestCodeOffset;
    }

    @NotNull
    public static final String getClientToken() {
        Validate.sdkInitialized();
        String s = FacebookSdk.appClientToken;
        if(s == null) {
            throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
        }
        return s;
    }

    public static final boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        return FacebookSdk.codelessDebugLogEnabled == null ? false : FacebookSdk.codelessDebugLogEnabled.booleanValue();
    }

    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    @NotNull
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock0 = FacebookSdk.LOCK;
        reentrantLock0.lock();
        if(FacebookSdk.executor == null) {
            FacebookSdk.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        }
        reentrantLock0.unlock();
        Executor executor0 = FacebookSdk.executor;
        if(executor0 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        return executor0;
    }

    @NotNull
    public static final String getFacebookDomain() {
        return FacebookSdk.facebookDomain;
    }

    @NotNull
    public static final String getFacebookGamingDomain() [...] // Inlined contents

    // 去混淆评级： 低(20)
    @NotNull
    public static final String getGraphApiVersion() {
        Utility.logd(FacebookSdk.TAG, "getGraphApiVersion: null");
        return FacebookSdk.graphApiVersion;
    }

    @NotNull
    public static final String getGraphDomain() {
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        return accessToken0 == null ? Utility.getGraphDomainFromTokenDomain(null) : Utility.getGraphDomainFromTokenDomain(accessToken0.getGraphDomain());
    }

    @NotNull
    public static final String getInstagramDomain() {
        return FacebookSdk.instagramDomain;
    }

    public static final boolean getLimitEventAndDataUsage(@NotNull Context context0) {
        q.g(context0, "context");
        Validate.sdkInitialized();
        return context0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    @NotNull
    public static final Set getLoggingBehaviors() {
        synchronized(FacebookSdk.loggingBehaviors) {
            Set set0 = Collections.unmodifiableSet(new HashSet(FacebookSdk.loggingBehaviors));
            q.f(set0, "unmodifiableSet(HashSet(loggingBehaviors))");
            return set0;
        }
    }

    public static final boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return FacebookSdk.onProgressThreshold.get();
    }

    @NotNull
    public static final String getSdkVersion() [...] // Inlined contents

    private static final GraphRequest graphRequestCreator$lambda$0(AccessToken accessToken0, String s, JSONObject jSONObject0, Callback graphRequest$Callback0) {
        return GraphRequest.Companion.newPostRequest(accessToken0, s, jSONObject0, graphRequest$Callback0);
    }

    public static void h(boolean z) {
        FacebookSdk.sdkInitialize$lambda$8(z);
    }

    public static final boolean isDebugEnabled() [...] // 潜在的解密器

    public static final boolean isFacebookRequestCode(int v) {
        return v >= FacebookSdk.callbackRequestCodeOffset && v < FacebookSdk.callbackRequestCodeOffset + 100;
    }

    public static final boolean isFullyInitialized() {
        synchronized(FacebookSdk.class) {
        }
        return FacebookSdk.isFullyInitialized;
    }

    public static final boolean isInitialized() {
        return FacebookSdk.sdkInitialized.get();
    }

    public static final boolean isLegacyTokenUpgradeSupported() {
        return FacebookSdk.isLegacyTokenUpgradeSupported;
    }

    public static final boolean isLoggingBehaviorEnabled(@NotNull LoggingBehavior loggingBehavior0) {
        q.g(loggingBehavior0, "behavior");
        synchronized(FacebookSdk.loggingBehaviors) {
        }
        return false;
    }

    public static final void loadDefaultsFromMetadata$facebook_core_release(@Nullable Context context0) {
        ApplicationInfo applicationInfo0;
        if(context0 != null) {
            try {
                applicationInfo0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                return;
            }
            q.f(applicationInfo0, "try {\n                co…     return\n            }");
            if(applicationInfo0.metaData != null) {
                if(FacebookSdk.applicationId == null) {
                    Object object0 = applicationInfo0.metaData.get("com.facebook.sdk.ApplicationId");
                    if(object0 instanceof String) {
                        Locale locale0 = Locale.ROOT;
                        q.f(locale0, "ROOT");
                        String s = ((String)object0).toLowerCase(locale0);
                        q.f(s, "this as java.lang.String).toLowerCase(locale)");
                        if(v.r0(s, "fb", false)) {
                            String s1 = ((String)object0).substring(2);
                            q.f(s1, "this as java.lang.String).substring(startIndex)");
                            FacebookSdk.applicationId = s1;
                        }
                        else {
                            FacebookSdk.applicationId = (String)object0;
                        }
                    }
                    else if(object0 instanceof Number) {
                        throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by \'fb\' or be placed in the string resource file.");
                    }
                }
                if(FacebookSdk.applicationName == null) {
                    FacebookSdk.applicationName = applicationInfo0.metaData.getString("com.facebook.sdk.ApplicationName");
                }
                if(FacebookSdk.appClientToken == null) {
                    FacebookSdk.appClientToken = applicationInfo0.metaData.getString("com.facebook.sdk.ClientToken");
                }
                if(FacebookSdk.callbackRequestCodeOffset == 0xFACE) {
                    FacebookSdk.callbackRequestCodeOffset = applicationInfo0.metaData.getInt("com.facebook.sdk.CallbackOffset", 0xFACE);
                }
                if(FacebookSdk.codelessDebugLogEnabled == null) {
                    FacebookSdk.codelessDebugLogEnabled = Boolean.valueOf(applicationInfo0.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
                }
            }
        }
    }

    private final void publishInstallAndWaitForResponse(Context context0, String s) {
        JSONObject jSONObject0;
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                try {
                    AttributionIdentifiers attributionIdentifiers0 = AttributionIdentifiers.Companion.getAttributionIdentifiers(context0);
                    SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                    long v = sharedPreferences0.getLong(s + "ping", 0L);
                    try {
                        String s1 = AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context0);
                        boolean z = FacebookSdk.getLimitEventAndDataUsage(context0);
                        jSONObject0 = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers0, s1, z, context0);
                    }
                    catch(JSONException jSONException0) {
                        throw new FacebookException("An error occurred while publishing install.", jSONException0);
                    }
                    String s2 = AppEventsLoggerImpl.Companion.getInstallReferrer();
                    if(s2 != null) {
                        jSONObject0.put("install_referrer", s2);
                    }
                    String s3 = String.format("%s/activities", Arrays.copyOf(new Object[]{s}, 1));
                    if(v == 0L && FacebookSdk.graphRequestCreator.createPostRequest(null, s3, jSONObject0, null).executeAndWait().getError() == null) {
                        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                        sharedPreferences$Editor0.putLong(s + "ping", System.currentTimeMillis());
                        sharedPreferences$Editor0.apply();
                        q.f(FacebookSdk.TAG, "TAG");
                        Logger.Companion.log(LoggingBehavior.APP_EVENTS, FacebookSdk.TAG, "MOBILE_APP_INSTALL has been logged");
                        return;
                    }
                    return;
                }
                catch(Exception exception0) {
                }
                Utility.logd("Facebook-publish", exception0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final void publishInstallAsync(@NotNull Context context0, @NotNull String s) {
        Class class0 = FacebookSdk.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(context0, "context");
                q.g(s, "applicationId");
                Context context1 = context0.getApplicationContext();
                if(context1 != null) {
                    if(!FetchedAppGateKeepersManager.getGateKeeperForKey("app_events_killswitch", FacebookSdk.getApplicationId(), false)) {
                        FacebookSdk.getExecutor().execute(new l(3, context1, s));
                    }
                    if(FeatureManager.isEnabled(Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                        OnDeviceProcessingManager.sendInstallEventAsync(s, "com.facebook.sdk.attributionTracking");
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private static final void publishInstallAsync$lambda$15(Context context0, String s) {
        q.g(context0, "$applicationContext");
        q.g(s, "$applicationId");
        FacebookSdk.INSTANCE.publishInstallAndWaitForResponse(context0, s);
    }

    public static final void removeLoggingBehavior(@NotNull LoggingBehavior loggingBehavior0) {
        q.g(loggingBehavior0, "behavior");
        synchronized(FacebookSdk.loggingBehaviors) {
            FacebookSdk.loggingBehaviors.remove(loggingBehavior0);
        }
    }

    @d
    public static final void sdkInitialize(@NotNull Context context0) {
        synchronized(FacebookSdk.class) {
            q.g(context0, "applicationContext");
            FacebookSdk.sdkInitialize(context0, null);
        }
    }

    @d
    public static final void sdkInitialize(@NotNull Context context0, int v) {
        synchronized(FacebookSdk.class) {
            q.g(context0, "applicationContext");
            FacebookSdk.sdkInitialize(context0, v, null);
        }
    }

    @d
    public static final void sdkInitialize(@NotNull Context context0, int v, @Nullable InitializeCallback facebookSdk$InitializeCallback0) {
        synchronized(FacebookSdk.class) {
            q.g(context0, "applicationContext");
            if(FacebookSdk.sdkInitialized.get() && v != FacebookSdk.callbackRequestCodeOffset) {
                throw new FacebookException("The callback request code offset can\'t be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method");
            }
            if(v >= 0) {
                FacebookSdk.callbackRequestCodeOffset = v;
                FacebookSdk.sdkInitialize(context0, facebookSdk$InitializeCallback0);
                return;
            }
        }
        throw new FacebookException("The callback request code offset can\'t be negative.");
    }

    @d
    public static final void sdkInitialize(@NotNull Context context0, @Nullable InitializeCallback facebookSdk$InitializeCallback0) {
        synchronized(FacebookSdk.class) {
            q.g(context0, "applicationContext");
            AtomicBoolean atomicBoolean0 = FacebookSdk.sdkInitialized;
            if(atomicBoolean0.get()) {
                if(facebookSdk$InitializeCallback0 != null) {
                    facebookSdk$InitializeCallback0.onInitialized();
                }
                return;
            }
            Validate.hasFacebookActivity(context0, false);
            Validate.hasInternetPermissions(context0, false);
            Context context1 = context0.getApplicationContext();
            q.f(context1, "applicationContext.applicationContext");
            FacebookSdk.applicationContext = context1;
            AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context0);
            Context context2 = FacebookSdk.applicationContext;
            if(context2 != null) {
                FacebookSdk.loadDefaultsFromMetadata$facebook_core_release(context2);
                if(FacebookSdk.applicationId == null || FacebookSdk.applicationId.length() == 0) {
                    throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                }
                if(FacebookSdk.appClientToken == null || FacebookSdk.appClientToken.length() == 0) {
                    throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
                }
                atomicBoolean0.set(true);
                if(FacebookSdk.getAutoInitEnabled()) {
                    FacebookSdk.fullyInitialize();
                }
                Context context3 = FacebookSdk.applicationContext;
                if(context3 != null) {
                    if(!(context3 instanceof Application) || !UserSettingsManager.getAutoLogAppEventsEnabled()) {
                        InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
                    }
                    else {
                        Context context4 = FacebookSdk.applicationContext;
                        if(context4 != null) {
                            ActivityLifecycleTracker.startTracking(((Application)context4), FacebookSdk.applicationId);
                            goto label_37;
                        }
                        q.m("applicationContext");
                        throw null;
                    }
                label_37:
                    AppLinkManager appLinkManager0 = AppLinkManager.Companion.getInstance();
                    if(appLinkManager0 != null) {
                        Context context5 = FacebookSdk.applicationContext;
                        if(context5 != null) {
                            appLinkManager0.setupLifecycleListener(((Application)context5));
                            goto label_46;
                        }
                        q.m("applicationContext");
                        throw null;
                    }
                label_46:
                    FetchedAppSettingsManager.loadAppSettingsAsync();
                    NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                    Companion boltsMeasurementEventListener$Companion0 = BoltsMeasurementEventListener.Companion;
                    Context context6 = FacebookSdk.applicationContext;
                    if(context6 != null) {
                        boltsMeasurementEventListener$Companion0.getInstance(context6);
                        FacebookSdk.cacheDir = new LockOnGetVariable(new f());  // 初始化器: Ljava/lang/Object;-><init>()V
                        z z0 = new z(15);
                        FeatureManager.checkFeature(Feature.Instrument, z0);
                        z z1 = new z(16);
                        FeatureManager.checkFeature(Feature.AppEvents, z1);
                        z z2 = new z(17);
                        FeatureManager.checkFeature(Feature.ChromeCustomTabsPrefetching, z2);
                        z z3 = new z(18);
                        FeatureManager.checkFeature(Feature.IgnoreAppSwitchToLoggedOut, z3);
                        z z4 = new z(19);
                        FeatureManager.checkFeature(Feature.BypassAppSwitch, z4);
                        FutureTask futureTask0 = new FutureTask(new g(facebookSdk$InitializeCallback0));
                        FacebookSdk.getExecutor().execute(futureTask0);
                        return;
                    }
                    q.m("applicationContext");
                    throw null;
                }
                q.m("applicationContext");
                throw null;
            }
            q.m("applicationContext");
        }
        throw null;
    }

    private static final File sdkInitialize$lambda$3() {
        Context context0 = FacebookSdk.applicationContext;
        if(context0 != null) {
            return context0.getCacheDir();
        }
        q.m("applicationContext");
        throw null;
    }

    private static final void sdkInitialize$lambda$4(boolean z) {
        if(z) {
            InstrumentManager.start();
        }
    }

    private static final void sdkInitialize$lambda$5(boolean z) {
        if(z) {
            AppEventsManager.start();
        }
    }

    private static final void sdkInitialize$lambda$6(boolean z) {
        if(z) {
            FacebookSdk.hasCustomTabsPrefetching = true;
        }
    }

    private static final void sdkInitialize$lambda$7(boolean z) {
        if(z) {
            FacebookSdk.ignoreAppSwitchToLoggedOut = true;
        }
    }

    private static final void sdkInitialize$lambda$8(boolean z) {
        if(z) {
            FacebookSdk.bypassAppSwitch = true;
        }
    }

    private static final Void sdkInitialize$lambda$9(InitializeCallback facebookSdk$InitializeCallback0) {
        AccessTokenManager.Companion.getInstance().loadCurrentAccessToken();
        ProfileManager.Companion.getInstance().loadCurrentProfile();
        if(AccessToken.Companion.isCurrentAccessTokenActive()) {
            com.facebook.Profile.Companion profile$Companion0 = Profile.Companion;
            if(profile$Companion0.getCurrentProfile() == null) {
                profile$Companion0.fetchProfileForCurrentAccessToken();
            }
        }
        if(facebookSdk$InitializeCallback0 != null) {
            facebookSdk$InitializeCallback0.onInitialized();
        }
        Context context0 = FacebookSdk.getApplicationContext();
        AppEventsLogger.Companion.initializeLib(context0, FacebookSdk.applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context context1 = FacebookSdk.getApplicationContext().getApplicationContext();
        q.f(context1, "getApplicationContext().applicationContext");
        AppEventsLogger.Companion.newLogger(context1).flush();
        return null;
    }

    public static final void setAdvertiserIDCollectionEnabled(boolean z) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z);
    }

    public static final void setApplicationId(@NotNull String s) {
        q.g(s, "applicationId");
        Validate.notEmpty(s, "applicationId");
        FacebookSdk.applicationId = s;
    }

    public static final void setApplicationName(@Nullable String s) {
        FacebookSdk.applicationName = s;
    }

    public static final void setAutoInitEnabled(boolean z) {
        UserSettingsManager.setAutoInitEnabled(z);
        if(z) {
            FacebookSdk.fullyInitialize();
        }
    }

    public static final void setAutoLogAppEventsEnabled(boolean z) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z);
        if(z) {
            Context context0 = FacebookSdk.getApplicationContext();
            q.e(context0, "null cannot be cast to non-null type android.app.Application");
            ActivityLifecycleTracker.startTracking(((Application)context0), FacebookSdk.getApplicationId());
        }
    }

    public static final void setCacheDir(@NotNull File file0) {
        q.g(file0, "cacheDir");
        FacebookSdk.cacheDir = new LockOnGetVariable(file0);
    }

    public static final void setClientToken(@Nullable String s) {
        FacebookSdk.appClientToken = s;
    }

    public static final void setCodelessDebugLogEnabled(boolean z) {
        FacebookSdk.codelessDebugLogEnabled = Boolean.valueOf(z);
    }

    public static final void setDataProcessingOptions(@Nullable String[] arr_s) {
        Class class0 = FacebookSdk.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            FacebookSdk.setDataProcessingOptions(arr_s, 0, 0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setDataProcessingOptions(@Nullable String[] arr_s, int v, int v1) {
        Class class0 = FacebookSdk.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            if(arr_s == null) {
                try {
                    arr_s = new String[0];
                    try {
                    label_4:
                        JSONObject jSONObject0 = new JSONObject();
                        jSONObject0.put("data_processing_options", new JSONArray(n.z0(arr_s)));
                        jSONObject0.put("data_processing_options_country", v);
                        jSONObject0.put("data_processing_options_state", v1);
                        Context context0 = FacebookSdk.applicationContext;
                        if(context0 != null) {
                            context0.getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).edit().putString("data_processing_options", jSONObject0.toString()).apply();
                            return;
                        }
                        q.m("applicationContext");
                        throw null;
                    }
                    catch(JSONException unused_ex) {
                        return;
                    }
                }
                catch(Throwable throwable0) {
                }
            }
            else {
                goto label_4;
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void setExecutor(@NotNull Executor executor0) {
        q.g(executor0, "executor");
        FacebookSdk.LOCK.lock();
        FacebookSdk.executor = executor0;
        FacebookSdk.LOCK.unlock();
    }

    public static final void setFacebookDomain(@NotNull String s) {
        q.g(s, "facebookDomain");
        Log.w(FacebookSdk.TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        FacebookSdk.facebookDomain = s;
    }

    public static final void setGraphApiVersion(@NotNull String s) {
        q.g(s, "graphApiVersion");
        Log.w(FacebookSdk.TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if(!Utility.isNullOrEmpty(s) && !q.b(FacebookSdk.graphApiVersion, s)) {
            FacebookSdk.graphApiVersion = s;
        }
    }

    public static final void setGraphRequestCreator$facebook_core_release(@NotNull GraphRequestCreator facebookSdk$GraphRequestCreator0) {
        q.g(facebookSdk$GraphRequestCreator0, "graphRequestCreator");
        FacebookSdk.graphRequestCreator = facebookSdk$GraphRequestCreator0;
    }

    public static final void setIsDebugEnabled(boolean z) {
        FacebookSdk.isDebugEnabledField = z;
    }

    public static final void setLegacyTokenUpgradeSupported(boolean z) {
        FacebookSdk.isLegacyTokenUpgradeSupported = z;
    }

    public static final void setLimitEventAndDataUsage(@NotNull Context context0, boolean z) {
        q.g(context0, "context");
        context0.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    public static final void setMonitorEnabled(boolean z) {
        UserSettingsManager.setMonitorEnabled(z);
    }

    public static final void setOnProgressThreshold(long v) {
        FacebookSdk.onProgressThreshold.set(v);
    }

    private final void updateGraphDebugBehavior() {
        HashSet hashSet0 = FacebookSdk.loggingBehaviors;
        if(hashSet0.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior0 = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if(!hashSet0.contains(loggingBehavior0)) {
                hashSet0.add(loggingBehavior0);
            }
        }
    }
}

