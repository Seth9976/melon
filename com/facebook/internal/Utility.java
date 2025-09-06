package com.facebook.internal;

import Tf.a;
import Tf.o;
import Tf.v;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import jeb.synthetic.TWR;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000\u00A0\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u000F\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u0006\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0002\u009C\u0002B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0007\u001A\u00020\u00062\f\u0010\u0005\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u0007\u0010\u000BJ%\u0010\r\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0010\u001A\u0004\u0018\u00010\t2\u0006\u0010\u000F\u001A\u00020\tH\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u0004\u0018\u00010\t2\u0006\u0010\u000F\u001A\u00020\tH\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0012\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001A\u00020\u0013H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0015J\u001B\u0010\u0016\u001A\u0004\u0018\u00010\t2\b\u0010\u000F\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0011J\u001B\u0010\u0016\u001A\u0004\u0018\u00010\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0015J!\u0010\u0018\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0018\u0010\u000EJ!\u0010\u0018\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001C\u001A\u00020\t2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0014\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001DJ-\u0010#\u001A\u00020\"2\b\u0010\u001E\u001A\u0004\u0018\u00010\t2\b\u0010\u001F\u001A\u0004\u0018\u00010\t2\b\u0010!\u001A\u0004\u0018\u00010 H\u0007\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010&\u001A\u00020 2\b\u0010%\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b&\u0010\'J+\u0010+\u001A\u00020*2\u0006\u0010(\u001A\u00020 2\b\u0010\u000F\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b+\u0010,J3\u0010/\u001A\u00020*2\u0006\u0010(\u001A\u00020 2\b\u0010\u000F\u001A\u0004\u0018\u00010\t2\u0010\u0010.\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010-H\u0007\u00A2\u0006\u0004\b/\u00100J+\u00102\u001A\u00020*2\u0006\u0010(\u001A\u00020 2\b\u0010\u000F\u001A\u0004\u0018\u00010\t2\b\u00101\u001A\u0004\u0018\u00010\"H\u0007\u00A2\u0006\u0004\b2\u00103J+\u00105\u001A\u00020\u00062\u0006\u00104\u001A\u00020 2\b\u0010\u000F\u001A\u0004\u0018\u00010\t2\b\u0010)\u001A\u0004\u0018\u00010\u0001H\u0007\u00A2\u0006\u0004\b5\u00106J\u0019\u00109\u001A\u00020*2\b\u00108\u001A\u0004\u0018\u000107H\u0007\u00A2\u0006\u0004\b9\u0010:J\u0019\u0010=\u001A\u00020*2\b\u0010<\u001A\u0004\u0018\u00010;H\u0007\u00A2\u0006\u0004\b=\u0010>J\u0019\u0010A\u001A\u00020\t2\b\u0010@\u001A\u0004\u0018\u00010?H\u0007\u00A2\u0006\u0004\bA\u0010BJ#\u0010F\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010E2\u0006\u0010D\u001A\u00020CH\u0007\u00A2\u0006\u0004\bF\u0010GJ#\u0010H\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0E2\u0006\u0010D\u001A\u00020CH\u0007\u00A2\u0006\u0004\bH\u0010GJ-\u0010M\u001A\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010Kj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`L2\b\u0010J\u001A\u0004\u0018\u00010IH\u0007\u00A2\u0006\u0004\bM\u0010NJ\u001D\u0010O\u001A\b\u0012\u0004\u0012\u00020\t0-2\u0006\u0010J\u001A\u00020IH\u0007\u00A2\u0006\u0004\bO\u0010PJ-\u0010R\u001A\u0004\u0018\u00010\u00012\u0006\u0010D\u001A\u00020C2\b\u0010\u000F\u001A\u0004\u0018\u00010\t2\b\u0010Q\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001A\u00020\t2\b\u0010U\u001A\u0004\u0018\u00010TH\u0007\u00A2\u0006\u0004\bV\u0010WJ!\u0010[\u001A\u00020Z2\b\u0010U\u001A\u0004\u0018\u00010T2\u0006\u0010Y\u001A\u00020XH\u0007\u00A2\u0006\u0004\b[\u0010\\J#\u0010^\u001A\u00020\u00062\b\u0010]\u001A\u0004\u0018\u00010\t2\b\u0010(\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b^\u0010_J\u001F\u0010a\u001A\u00020*2\u0006\u0010@\u001A\u00020?2\u0006\u0010`\u001A\u00020\tH\u0002\u00A2\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001A\u00020*2\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0004\bc\u0010dJ)\u0010i\u001A\u00020*2\b\u0010e\u001A\u0004\u0018\u00010\t2\u000E\u0010h\u001A\n\u0018\u00010fj\u0004\u0018\u0001`gH\u0007\u00A2\u0006\u0004\bi\u0010jJ#\u0010i\u001A\u00020*2\b\u0010e\u001A\u0004\u0018\u00010\t2\b\u0010k\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\bi\u0010lJ-\u0010i\u001A\u00020*2\b\u0010e\u001A\u0004\u0018\u00010\t2\b\u0010k\u001A\u0004\u0018\u00010\t2\b\u0010n\u001A\u0004\u0018\u00010mH\u0007\u00A2\u0006\u0004\bi\u0010oJ)\u0010q\u001A\u00020\u0006\"\u0004\b\u0000\u0010p2\b\u0010]\u001A\u0004\u0018\u00018\u00002\b\u0010(\u001A\u0004\u0018\u00018\u0000H\u0007\u00A2\u0006\u0004\bq\u0010rJ#\u0010u\u001A\u00020\t2\b\u0010s\u001A\u0004\u0018\u00010C2\b\u0010t\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\bu\u0010vJ%\u0010x\u001A\u0004\u0018\u00010C2\b\u0010s\u001A\u0004\u0018\u00010C2\b\u0010w\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\bx\u0010yJ%\u0010z\u001A\u0004\u0018\u00010I2\b\u0010s\u001A\u0004\u0018\u00010C2\b\u0010w\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\bz\u0010{J\u001D\u0010|\u001A\b\u0012\u0004\u0012\u00020\t0-2\u0006\u0010J\u001A\u00020IH\u0007\u00A2\u0006\u0004\b|\u0010PJ\u001D\u0010~\u001A\b\u0012\u0004\u0012\u00020\t0}2\u0006\u0010J\u001A\u00020IH\u0007\u00A2\u0006\u0004\b~\u0010\u007FJ+\u0010\u0081\u0001\u001A\u00020\t2\u0017\u0010\u0080\u0001\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0EH\u0007\u00A2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\'\u0010\u0084\u0001\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0E2\u0007\u0010\u0083\u0001\u001A\u00020\tH\u0007\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001JC\u0010\u008B\u0001\u001A\u00020*2\u0007\u0010\u0086\u0001\u001A\u00020C2\n\u0010\u0088\u0001\u001A\u0005\u0018\u00010\u0087\u00012\t\u0010\u0089\u0001\u001A\u0004\u0018\u00010\t2\u0007\u0010\u008A\u0001\u001A\u00020\u00062\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0006\b\u008B\u0001\u0010\u008C\u0001J\u0014\u0010\u008D\u0001\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J$\u0010\u0090\u0001\u001A\u00020*2\u0007\u0010\u0086\u0001\u001A\u00020C2\u0007\u0010\u008F\u0001\u001A\u00020?H\u0007\u00A2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001JP\u0010\u0098\u0001\u001A\u0005\u0018\u00010\u0097\u00012\f\u0010\u0093\u0001\u001A\u0007\u0012\u0002\b\u00030\u0092\u00012\u0007\u0010\u0094\u0001\u001A\u00020\t2\"\u0010\u0096\u0001\u001A\u0012\u0012\r\b\u0001\u0012\t\u0012\u0002\b\u0003\u0018\u00010\u0092\u00010\u0095\u0001\"\t\u0012\u0002\b\u0003\u0018\u00010\u0092\u0001H\u0007\u00A2\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001JK\u0010\u0098\u0001\u001A\u0005\u0018\u00010\u0097\u00012\u0007\u0010\u009A\u0001\u001A\u00020\t2\u0007\u0010\u0094\u0001\u001A\u00020\t2\"\u0010\u0096\u0001\u001A\u0012\u0012\r\b\u0001\u0012\t\u0012\u0002\b\u0003\u0018\u00010\u0092\u00010\u0095\u0001\"\t\u0012\u0002\b\u0003\u0018\u00010\u0092\u0001H\u0007\u00A2\u0006\u0006\b\u0098\u0001\u0010\u009B\u0001JC\u0010\u009F\u0001\u001A\u0004\u0018\u00010\u00012\t\u0010\u009C\u0001\u001A\u0004\u0018\u00010\u00012\b\u0010\u009D\u0001\u001A\u00030\u0097\u00012\u0018\u0010\u009E\u0001\u001A\r\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0095\u0001\"\u0004\u0018\u00010\u0001H\u0007\u00A2\u0006\u0006\b\u009F\u0001\u0010\u00A0\u0001J\u001B\u0010\u00A1\u0001\u001A\u00020\t2\b\u0010@\u001A\u0004\u0018\u00010?H\u0007\u00A2\u0006\u0005\b\u00A1\u0001\u0010BJ\u001E\u0010\u00A2\u0001\u001A\u0004\u0018\u00010\t2\b\u00101\u001A\u0004\u0018\u00010\"H\u0007\u00A2\u0006\u0006\b\u00A2\u0001\u0010\u00A3\u0001J\u001C\u0010\u00A4\u0001\u001A\u00020\u00062\b\u00101\u001A\u0004\u0018\u00010\"H\u0007\u00A2\u0006\u0006\b\u00A4\u0001\u0010\u00A5\u0001J\u001C\u0010\u00A6\u0001\u001A\u00020\u00062\b\u00101\u001A\u0004\u0018\u00010\"H\u0007\u00A2\u0006\u0006\b\u00A6\u0001\u0010\u00A5\u0001J\u001C\u0010\u00A7\u0001\u001A\u00020\u00062\b\u00101\u001A\u0004\u0018\u00010\"H\u0007\u00A2\u0006\u0006\b\u00A7\u0001\u0010\u00A5\u0001J\u001C\u0010\u00AA\u0001\u001A\u00030\u00A9\u00012\u0007\u0010\u00A8\u0001\u001A\u00020\"H\u0007\u00A2\u0006\u0006\b\u00AA\u0001\u0010\u00AB\u0001J3\u0010\u00AE\u0001\u001A\u0005\u0018\u00010\u00AC\u00012\b\u00104\u001A\u0004\u0018\u00010 2\b\u0010\u000F\u001A\u0004\u0018\u00010\t2\b\u0010\u00AD\u0001\u001A\u00030\u00AC\u0001H\u0007\u00A2\u0006\u0006\b\u00AE\u0001\u0010\u00AF\u0001J7\u0010\u00B2\u0001\u001A\u00020*2\b\u0010\u00B1\u0001\u001A\u00030\u00B0\u00012\u0019\u0010\u0080\u0001\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010EH\u0007\u00A2\u0006\u0006\b\u00B2\u0001\u0010\u00B3\u0001J.\u0010\u00B4\u0001\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010E2\b\u0010\u00B1\u0001\u001A\u00030\u00B0\u0001H\u0007\u00A2\u0006\u0006\b\u00B4\u0001\u0010\u00B5\u0001J3\u0010\u00B6\u0001\u001A\u00020*2\b\u0010\u00B1\u0001\u001A\u00030\u00B0\u00012\u0015\u0010\u0080\u0001\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010EH\u0007\u00A2\u0006\u0006\b\u00B6\u0001\u0010\u00B3\u0001J*\u0010\u00B7\u0001\u001A\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010E2\b\u0010\u00B1\u0001\u001A\u00030\u00B0\u0001H\u0007\u00A2\u0006\u0006\b\u00B7\u0001\u0010\u00B5\u0001J\u001E\u0010\u00BA\u0001\u001A\u00020\u00062\n\u0010\u00B9\u0001\u001A\u0005\u0018\u00010\u00B8\u0001H\u0007\u00A2\u0006\u0006\b\u00BA\u0001\u0010\u00BB\u0001J\u001C\u0010\u00BD\u0001\u001A\u00020\t2\t\u0010\u00BC\u0001\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0005\b\u00BD\u0001\u0010\u0011J%\u0010\u00C1\u0001\u001A\u00020*2\u0007\u0010\u00BE\u0001\u001A\u00020\t2\b\u0010\u00C0\u0001\u001A\u00030\u00BF\u0001H\u0007\u00A2\u0006\u0006\b\u00C1\u0001\u0010\u00C2\u0001J\u001D\u0010\u00C3\u0001\u001A\u0004\u0018\u00010C2\u0007\u0010\u00BE\u0001\u001A\u00020\tH\u0007\u00A2\u0006\u0006\b\u00C3\u0001\u0010\u00C4\u0001J\u001C\u0010\u00C6\u0001\u001A\u00030\u00C5\u00012\u0007\u0010\u00BE\u0001\u001A\u00020\tH\u0002\u00A2\u0006\u0006\b\u00C6\u0001\u0010\u00C7\u0001J\u001C\u0010\u00C9\u0001\u001A\u00020\t2\t\u0010\u00C8\u0001\u001A\u0004\u0018\u00010\tH\u0002\u00A2\u0006\u0005\b\u00C9\u0001\u0010\u0011J\u0014\u0010\u00CA\u0001\u001A\u0004\u0018\u00010\tH\u0002\u00A2\u0006\u0006\b\u00CA\u0001\u0010\u008E\u0001J\u0012\u0010\u00CB\u0001\u001A\u00020ZH\u0002\u00A2\u0006\u0006\b\u00CB\u0001\u0010\u00CC\u0001J\u001A\u0010\u00CD\u0001\u001A\u00020*2\u0007\u0010\u008F\u0001\u001A\u00020?H\u0002\u00A2\u0006\u0005\b\u00CD\u0001\u0010dJ\u0011\u0010\u00CE\u0001\u001A\u00020*H\u0002\u00A2\u0006\u0005\b\u00CE\u0001\u0010\u0003J\u001A\u0010\u00CF\u0001\u001A\u00020*2\u0007\u0010\u008F\u0001\u001A\u00020?H\u0002\u00A2\u0006\u0005\b\u00CF\u0001\u0010dJ\u0012\u0010\u00D0\u0001\u001A\u00020\u0006H\u0002\u00A2\u0006\u0006\b\u00D0\u0001\u0010\u00D1\u0001J\u0011\u0010\u00D2\u0001\u001A\u00020*H\u0002\u00A2\u0006\u0005\b\u00D2\u0001\u0010\u0003J\u0011\u0010\u00D3\u0001\u001A\u00020*H\u0002\u00A2\u0006\u0005\b\u00D3\u0001\u0010\u0003J\u001C\u0010\u00D5\u0001\u001A\u00030\u00A9\u00012\u0007\u0010\u0014\u001A\u00030\u00D4\u0001H\u0002\u00A2\u0006\u0006\b\u00D5\u0001\u0010\u00D6\u0001J8\u0010\u00D7\u0001\u001A\u00020*2\u0007\u0010\u0086\u0001\u001A\u00020C2\b\u0010\u0088\u0001\u001A\u00030\u0087\u00012\t\u0010\u0089\u0001\u001A\u0004\u0018\u00010\t2\u0006\u0010@\u001A\u00020?H\u0002\u00A2\u0006\u0006\b\u00D7\u0001\u0010\u00D8\u0001J-\u0010\u00D9\u0001\u001A\u00020*2\u0007\u0010\u0086\u0001\u001A\u00020C2\b\u0010\u0088\u0001\u001A\u00030\u0087\u00012\u0006\u0010@\u001A\u00020?H\u0002\u00A2\u0006\u0006\b\u00D9\u0001\u0010\u00DA\u0001J\u001A\u0010\u00DB\u0001\u001A\u00020\u00062\u0006\u0010@\u001A\u00020?H\u0002\u00A2\u0006\u0006\b\u00DB\u0001\u0010\u00DC\u0001J\u001B\u0010\u00DE\u0001\u001A\u00020\t2\u0007\u0010\u00DD\u0001\u001A\u00020ZH\u0007\u00A2\u0006\u0006\b\u00DE\u0001\u0010\u00DF\u0001J\u001A\u0010\u00E0\u0001\u001A\u00020\u00062\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0006\b\u00E0\u0001\u0010\u00DC\u0001J\u001A\u0010\u00E1\u0001\u001A\u00020\u00062\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0006\b\u00E1\u0001\u0010\u00DC\u0001J\u001A\u0010\u00E2\u0001\u001A\u00020\u00062\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0006\b\u00E2\u0001\u0010\u00DC\u0001J\u001E\u0010\u00E5\u0001\u001A\u00020*2\n\u0010\u00E4\u0001\u001A\u0005\u0018\u00010\u00E3\u0001H\u0007\u00A2\u0006\u0006\b\u00E5\u0001\u0010\u00E6\u0001J\u0019\u0010\u00E7\u0001\u001A\u00020\t2\u0006\u0010@\u001A\u00020?H\u0007\u00A2\u0006\u0005\b\u00E7\u0001\u0010BR\u0017\u0010\u00E8\u0001\u001A\u00020\t8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00E8\u0001\u0010\u00E9\u0001R\u0017\u0010\u00EA\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00EA\u0001\u0010\u00E9\u0001R\u0017\u0010\u00EB\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00EB\u0001\u0010\u00E9\u0001R\u0017\u0010\u00EC\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00EC\u0001\u0010\u00E9\u0001R\u0017\u0010\u00ED\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00ED\u0001\u0010\u00E9\u0001R\u0017\u0010\u00EE\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00EE\u0001\u0010\u00E9\u0001R\u0017\u0010\u00EF\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00EF\u0001\u0010\u00E9\u0001R\u0017\u0010\u00F0\u0001\u001A\u00020Z8\u0006X\u0086T\u00A2\u0006\b\n\u0006\b\u00F0\u0001\u0010\u00F1\u0001R\u0017\u0010\u00F2\u0001\u001A\u00020Z8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00F2\u0001\u0010\u00F1\u0001R\u0017\u0010\u00F3\u0001\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u00F3\u0001\u0010\u00E9\u0001R\u0019\u0010\u00F4\u0001\u001A\u00020Z8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00F4\u0001\u0010\u00F1\u0001R\u001A\u0010\u00F5\u0001\u001A\u00030\u00A9\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00F5\u0001\u0010\u00F6\u0001R\u001A\u0010\u00F7\u0001\u001A\u00030\u00A9\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00F7\u0001\u0010\u00F6\u0001R*\u0010\u00F8\u0001\u001A\u00030\u00A9\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00F8\u0001\u0010\u00F6\u0001\u001A\u0006\b\u00F9\u0001\u0010\u00FA\u0001\"\u0006\b\u00FB\u0001\u0010\u00FC\u0001R\u0019\u0010\u00FD\u0001\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00FD\u0001\u0010\u00E9\u0001R)\u0010\u00FE\u0001\u001A\u00020\t8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00FE\u0001\u0010\u00E9\u0001\u001A\u0006\b\u00FF\u0001\u0010\u008E\u0001\"\u0006\b\u0080\u0002\u0010\u0081\u0002R)\u0010\u0082\u0002\u001A\u00020\t8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0082\u0002\u0010\u00E9\u0001\u001A\u0006\b\u0083\u0002\u0010\u008E\u0001\"\u0006\b\u0084\u0002\u0010\u0081\u0002R+\u0010\u0085\u0002\u001A\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0085\u0002\u0010\u00E9\u0001\u001A\u0006\b\u0086\u0002\u0010\u008E\u0001\"\u0006\b\u0087\u0002\u0010\u0081\u0002R,\u0010\u0089\u0002\u001A\u0005\u0018\u00010\u0088\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0089\u0002\u0010\u008A\u0002\u001A\u0006\b\u008B\u0002\u0010\u008C\u0002\"\u0006\b\u008D\u0002\u0010\u008E\u0002R\u0017\u0010\u008F\u0002\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u008F\u0002\u0010\u00E9\u0001R\u0017\u0010\u0090\u0002\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u0090\u0002\u0010\u00E9\u0001R\u0017\u0010\u0091\u0002\u001A\u00020\t8\u0002X\u0082T\u00A2\u0006\b\n\u0006\b\u0091\u0002\u0010\u00E9\u0001R\u0017\u0010\u0093\u0002\u001A\u0005\u0018\u00010\u0088\u00028G\u00A2\u0006\b\u001A\u0006\b\u0092\u0002\u0010\u008C\u0002R\u0015\u0010\u0095\u0002\u001A\u00030\u0088\u00028G\u00A2\u0006\b\u001A\u0006\b\u0094\u0002\u0010\u008C\u0002R\u001E\u0010\u0096\u0002\u001A\u00020\u00068FX\u0087\u0004\u00A2\u0006\u000F\u0012\u0005\b\u0097\u0002\u0010\u0003\u001A\u0006\b\u0096\u0002\u0010\u00D1\u0001R\u0016\u0010\u009A\u0002\u001A\u0004\u0018\u00010C8G\u00A2\u0006\b\u001A\u0006\b\u0098\u0002\u0010\u0099\u0002R\u0014\u0010\u009B\u0002\u001A\u00020\u00068G\u00A2\u0006\b\u001A\u0006\b\u009B\u0002\u0010\u00D1\u0001\u00A8\u0006\u009D\u0002"}, d2 = {"Lcom/facebook/internal/Utility;", "", "<init>", "()V", "", "c", "", "isNullOrEmpty", "(Ljava/util/Collection;)Z", "", "s", "(Ljava/lang/String;)Z", "valueIfNullOrEmpty", "coerceValueIfNullOrEmpty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "key", "md5hash", "(Ljava/lang/String;)Ljava/lang/String;", "sha1hash", "", "bytes", "([B)Ljava/lang/String;", "sha256hash", "algorithm", "hashWithAlgorithm", "(Ljava/lang/String;[B)Ljava/lang/String;", "Ljava/security/MessageDigest;", "hash", "hashBytes", "(Ljava/security/MessageDigest;[B)Ljava/lang/String;", "authority", "path", "Landroid/os/Bundle;", "parameters", "Landroid/net/Uri;", "buildUri", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/net/Uri;", "queryString", "parseUrlQueryString", "(Ljava/lang/String;)Landroid/os/Bundle;", "b", "value", "Lie/H;", "putNonEmptyString", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "", "list", "putCommaSeparatedStringList", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/List;)V", "uri", "putUri", "(Landroid/os/Bundle;Ljava/lang/String;Landroid/net/Uri;)V", "bundle", "putJSONValueInBundle", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)Z", "Ljava/io/Closeable;", "closeable", "closeQuietly", "(Ljava/io/Closeable;)V", "Ljava/net/URLConnection;", "connection", "disconnectQuietly", "(Ljava/net/URLConnection;)V", "Landroid/content/Context;", "context", "getMetadataApplicationId", "(Landroid/content/Context;)Ljava/lang/String;", "Lorg/json/JSONObject;", "jsonObject", "", "convertJSONObjectToHashMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "convertJSONObjectToStringMap", "Lorg/json/JSONArray;", "jsonArray", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "convertJSONArrayToHashSet", "(Lorg/json/JSONArray;)Ljava/util/HashSet;", "convertJSONArrayToList", "(Lorg/json/JSONArray;)Ljava/util/List;", "nonJSONPropertyKey", "getStringPropertyAsJSON", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Ljava/io/InputStream;", "inputStream", "readStreamToString", "(Ljava/io/InputStream;)Ljava/lang/String;", "Ljava/io/OutputStream;", "outputStream", "", "copyAndCloseInputStream", "(Ljava/io/InputStream;Ljava/io/OutputStream;)I", "a", "stringsEqualOrEmpty", "(Ljava/lang/String;Ljava/lang/String;)Z", "domain", "clearCookiesForDomain", "(Landroid/content/Context;Ljava/lang/String;)V", "clearFacebookCookies", "(Landroid/content/Context;)V", "tag", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "logd", "(Ljava/lang/String;Ljava/lang/Exception;)V", "msg", "(Ljava/lang/String;Ljava/lang/String;)V", "", "t", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "T", "areObjectsEqual", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "response", "propertyName", "safeGetStringFromResponse", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "propertyKey", "tryGetJSONObjectFromResponse", "(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;", "tryGetJSONArrayFromResponse", "(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;", "jsonArrayToStringList", "", "jsonArrayToSet", "(Lorg/json/JSONArray;)Ljava/util/Set;", "map", "mapToJsonStr", "(Ljava/util/Map;)Ljava/lang/String;", "str", "jsonStrToMap", "(Ljava/lang/String;)Ljava/util/Map;", "params", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventAttributionParameters", "(Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;ZLandroid/content/Context;)V", "getAppVersion", "()Ljava/lang/String;", "appContext", "setAppEventExtendedDeviceInfoParameters", "(Lorg/json/JSONObject;Landroid/content/Context;)V", "Ljava/lang/Class;", "clazz", "methodName", "", "parameterTypes", "Ljava/lang/reflect/Method;", "getMethodQuietly", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "receiver", "method", "args", "invokeMethodQuietly", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "getActivityName", "getUriString", "(Landroid/net/Uri;)Ljava/lang/String;", "isWebUri", "(Landroid/net/Uri;)Z", "isContentUri", "isFileUri", "contentUri", "", "getContentSize", "(Landroid/net/Uri;)J", "Ljava/util/Date;", "dateBase", "getBundleLongAsDate", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/Date;)Ljava/util/Date;", "Landroid/os/Parcel;", "parcel", "writeStringMapToParcel", "(Landroid/os/Parcel;Ljava/util/Map;)V", "readStringMapFromParcel", "(Landroid/os/Parcel;)Ljava/util/Map;", "writeNonnullStringMapToParcel", "readNonnullStringMapFromParcel", "Lcom/facebook/AccessToken;", "token", "isCurrentAccessToken", "(Lcom/facebook/AccessToken;)Z", "tokenGraphDomain", "getGraphDomainFromTokenDomain", "accessToken", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "callback", "getGraphMeRequestWithCacheAsync", "(Ljava/lang/String;Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;)V", "awaitGetGraphMeRequestWithCache", "(Ljava/lang/String;)Lorg/json/JSONObject;", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCache", "(Ljava/lang/String;)Lcom/facebook/GraphRequest;", "graphDomain", "getProfileFieldsForGraphDomain", "getCurrentTokenDomainWithDefault", "refreshBestGuessNumberOfCPUCores", "()I", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshCarrierName", "externalStorageExists", "()Z", "refreshAvailableExternalStorage", "refreshTotalExternalStorage", "", "convertBytesToGB", "(D)J", "appendAnonIdUnderCompliance", "(Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;Landroid/content/Context;)V", "appendAttributionIdUnderCompliance", "(Lorg/json/JSONObject;Lcom/facebook/internal/AttributionIdentifiers;Landroid/content/Context;)V", "isGooglePlayServicesAvailable", "(Landroid/content/Context;)Z", "length", "generateRandomString", "(I)Ljava/lang/String;", "mustFixWindowParamsForAutofill", "isAutofillAvailable", "isChromeOS", "Ljava/lang/Runnable;", "runnable", "runOnNonUiThread", "(Ljava/lang/Runnable;)V", "getAppName", "LOG_TAG", "Ljava/lang/String;", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "URL_SCHEME", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "UTF8", "DEFAULT_STREAM_BUFFER_SIZE", "I", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "NO_CARRIER", "numCPUCores", "timestampOfLastCheck", "J", "totalExternalStorageGB", "availableExternalStorageGB", "getAvailableExternalStorageGB", "()J", "setAvailableExternalStorageGB", "(J)V", "deviceTimezoneAbbreviation", "deviceTimeZoneName", "getDeviceTimeZoneName", "setDeviceTimeZoneName", "(Ljava/lang/String;)V", "carrierName", "getCarrierName", "setCarrierName", "versionName", "getVersionName", "setVersionName", "Ljava/util/Locale;", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "ARC_DEVICE_PATTERN", "FACEBOOK_PROFILE_FIELDS", "INSTAGRAM_PROFILE_FIELDS", "getResourceLocale", "resourceLocale", "getCurrentLocale", "currentLocale", "isAutoAppLinkSetup", "isAutoAppLinkSetup$annotations", "getDataProcessingOptions", "()Lorg/json/JSONObject;", "dataProcessingOptions", "isDataProcessingRestricted", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Utility {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "Lorg/json/JSONObject;", "userInfo", "Lie/H;", "onSuccess", "(Lorg/json/JSONObject;)V", "Lcom/facebook/FacebookException;", "error", "onFailure", "(Lcom/facebook/FacebookException;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(@Nullable FacebookException arg1);

        void onSuccess(@Nullable JSONObject arg1);
    }

    @NotNull
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 0x2000;
    @NotNull
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    @NotNull
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    @NotNull
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    @NotNull
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    @NotNull
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    @NotNull
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    @NotNull
    public static final Utility INSTANCE = null;
    @NotNull
    public static final String LOG_TAG = "FacebookSDK";
    @NotNull
    private static final String NO_CARRIER = "NoCarrier";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    @NotNull
    private static final String URL_SCHEME = "https";
    @NotNull
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB;
    @NotNull
    private static String carrierName;
    @NotNull
    private static String deviceTimeZoneName;
    @NotNull
    private static String deviceTimezoneAbbreviation;
    @Nullable
    private static Locale locale;
    private static int numCPUCores;
    private static long timestampOfLastCheck;
    private static long totalExternalStorageGB;
    @Nullable
    private static String versionName;

    static {
        Utility.INSTANCE = new Utility();
        Utility.timestampOfLastCheck = -1L;
        Utility.totalExternalStorageGB = -1L;
        Utility.availableExternalStorageGB = -1L;
        Utility.deviceTimezoneAbbreviation = "";
        Utility.deviceTimeZoneName = "";
        Utility.carrierName = "NoCarrier";
        Utility.versionName = "";
    }

    private final void appendAnonIdUnderCompliance(JSONObject jSONObject0, AttributionIdentifiers attributionIdentifiers0, String s, Context context0) {
        if(Build.VERSION.SDK_INT >= 0x1F && this.isGooglePlayServicesAvailable(context0)) {
            if(!attributionIdentifiers0.isTrackingLimited()) {
                jSONObject0.put("anon_id", s);
            }
            return;
        }
        jSONObject0.put("anon_id", s);
    }

    private final void appendAttributionIdUnderCompliance(JSONObject jSONObject0, AttributionIdentifiers attributionIdentifiers0, Context context0) {
        if(Build.VERSION.SDK_INT >= 0x1F && this.isGooglePlayServicesAvailable(context0)) {
            if(!attributionIdentifiers0.isTrackingLimited()) {
                jSONObject0.put("attribution", attributionIdentifiers0.getAttributionId());
            }
            return;
        }
        jSONObject0.put("attribution", attributionIdentifiers0.getAttributionId());
    }

    public static final boolean areObjectsEqual(@Nullable Object object0, @Nullable Object object1) {
        return object0 == null ? object1 == null : object0.equals(object1);
    }

    @Nullable
    public static final JSONObject awaitGetGraphMeRequestWithCache(@NotNull String s) {
        q.g(s, "accessToken");
        JSONObject jSONObject0 = ProfileInformationCache.getProfileInformation(s);
        if(jSONObject0 != null) {
            return jSONObject0;
        }
        GraphResponse graphResponse0 = Utility.INSTANCE.getGraphMeRequestWithCache(s).executeAndWait();
        return graphResponse0.getError() == null ? graphResponse0.getJsonObject() : null;
    }

    @NotNull
    public static final Uri buildUri(@Nullable String s, @Nullable String s1, @Nullable Bundle bundle0) {
        Uri.Builder uri$Builder0 = new Uri.Builder();
        uri$Builder0.scheme("https");
        uri$Builder0.authority(s);
        uri$Builder0.path(s1);
        if(bundle0 != null) {
            for(Object object0: bundle0.keySet()) {
                String s2 = (String)object0;
                Object object1 = bundle0.get(s2);
                if(object1 instanceof String) {
                    uri$Builder0.appendQueryParameter(s2, ((String)object1));
                }
            }
        }
        Uri uri0 = uri$Builder0.build();
        q.f(uri0, "builder.build()");
        return uri0;
    }

    private final void clearCookiesForDomain(Context context0, String s) {
        CookieSyncManager.createInstance(context0).sync();
        CookieManager cookieManager0 = CookieManager.getInstance();
        String s1 = cookieManager0.getCookie(s);
        if(s1 == null) {
            return;
        }
        String[] arr_s = (String[])o.R0(s1, new String[]{";"}, 0, 6).toArray(new String[0]);
        for(int v = 0; v < arr_s.length; ++v) {
            String[] arr_s1 = (String[])o.R0(arr_s[v], new String[]{"="}, 0, 6).toArray(new String[0]);
            if(arr_s1.length > 0) {
                StringBuilder stringBuilder0 = new StringBuilder();
                String s2 = arr_s1[0];
                int v1 = s2.length() - 1;
                int v2 = 0;
                boolean z = false;
                while(v2 <= v1) {
                    boolean z1 = q.h(s2.charAt((z ? v1 : v2)), 0x20) <= 0;
                    if(z) {
                        if(!z1) {
                            break;
                        }
                        --v1;
                    }
                    else if(z1) {
                        ++v2;
                    }
                    else {
                        z = true;
                    }
                }
                stringBuilder0.append(s2.subSequence(v2, v1 + 1).toString());
                stringBuilder0.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                cookieManager0.setCookie(s, stringBuilder0.toString());
            }
        }
        cookieManager0.removeExpiredCookie();
    }

    public static final void clearFacebookCookies(@NotNull Context context0) {
        q.g(context0, "context");
        try {
            Utility.INSTANCE.clearCookiesForDomain(context0, "facebook.com");
            Utility.INSTANCE.clearCookiesForDomain(context0, ".facebook.com");
            Utility.INSTANCE.clearCookiesForDomain(context0, "https://facebook.com");
            Utility.INSTANCE.clearCookiesForDomain(context0, "https://.facebook.com");
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void closeQuietly(@Nullable Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(IOException unused_ex) {
            }
        }
    }

    // 去混淆评级： 低(20)
    @Nullable
    public static final String coerceValueIfNullOrEmpty(@Nullable String s, @Nullable String s1) {
        return Utility.isNullOrEmpty(s) ? s1 : s;
    }

    private final long convertBytesToGB(double f) [...] // 潜在的解密器

    @Nullable
    public static final HashSet convertJSONArrayToHashSet(@Nullable JSONArray jSONArray0) {
        if(jSONArray0 != null && jSONArray0.length() != 0) {
            HashSet hashSet0 = new HashSet();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = jSONArray0.getString(v1);
                q.f(s, "jsonArray.getString(i)");
                hashSet0.add(s);
            }
            return hashSet0;
        }
        return null;
    }

    @NotNull
    public static final List convertJSONArrayToList(@NotNull JSONArray jSONArray0) {
        q.g(jSONArray0, "jsonArray");
        try {
            List list0 = new ArrayList();
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = jSONArray0.getString(v1);
                q.f(s, "jsonArray.getString(i)");
                list0.add(s);
            }
            return list0;
        }
        catch(JSONException unused_ex) {
            return new ArrayList();
        }
    }

    @NotNull
    public static final Map convertJSONObjectToHashMap(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        Map map0 = new HashMap();
        JSONArray jSONArray0 = jSONObject0.names();
        if(jSONArray0 != null) {
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                try {
                    String s = jSONArray0.getString(v1);
                    q.f(s, "keys.getString(i)");
                    Map map1 = jSONObject0.get(s);
                    if(map1 instanceof JSONObject) {
                        map1 = Utility.convertJSONObjectToHashMap(((JSONObject)map1));
                    }
                    q.f(map1, "value");
                    map0.put(s, map1);
                }
                catch(JSONException unused_ex) {
                }
            }
        }
        return map0;
    }

    @NotNull
    public static final Map convertJSONObjectToStringMap(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "jsonObject");
        Map map0 = new HashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s = (String)object0;
            String s1 = jSONObject0.optString(s);
            if(s1 != null) {
                q.f(s, "key");
                map0.put(s, s1);
            }
        }
        return map0;
    }

    public static final int copyAndCloseInputStream(@Nullable InputStream inputStream0, @NotNull OutputStream outputStream0) {
        int v;
        q.g(outputStream0, "outputStream");
        BufferedInputStream bufferedInputStream0 = null;
        try {
            bufferedInputStream0 = new BufferedInputStream(inputStream0);
            byte[] arr_b = new byte[0x2000];
            v = 0;
            int v1;
            while((v1 = bufferedInputStream0.read(arr_b)) != -1) {
                outputStream0.write(arr_b, 0, v1);
                v += v1;
            }
        }
        catch(Throwable throwable0) {
            if(bufferedInputStream0 != null) {
                bufferedInputStream0.close();
            }
            if(inputStream0 != null) {
                inputStream0.close();
            }
            throw throwable0;
        }
        bufferedInputStream0.close();
        if(inputStream0 != null) {
            inputStream0.close();
        }
        return v;
    }

    public static final void disconnectQuietly(@Nullable URLConnection uRLConnection0) {
        if(uRLConnection0 != null && uRLConnection0 instanceof HttpURLConnection) {
            ((HttpURLConnection)uRLConnection0).disconnect();
        }
    }

    private final boolean externalStorageExists() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    @NotNull
    public static final String generateRandomString(int v) [...] // 潜在的解密器

    @NotNull
    public static final String getActivityName(@Nullable Context context0) {
        if(context0 == null) {
            return "null";
        }
        return context0 == context0.getApplicationContext() ? "unknown" : context0.getClass().getSimpleName();
    }

    @NotNull
    public static final String getAppName(@NotNull Context context0) {
        q.g(context0, "context");
        try {
            String s = FacebookSdk.getApplicationName();
            if(s != null) {
                return s;
            }
            ApplicationInfo applicationInfo0 = context0.getApplicationInfo();
            int v = applicationInfo0.labelRes;
            if(v == 0) {
                return applicationInfo0.nonLocalizedLabel.toString();
            }
            String s1 = context0.getString(v);
            q.f(s1, "context.getString(stringId)");
            return s1;
        }
        catch(Exception unused_ex) {
            return "";
        }
    }

    @Nullable
    public static final String getAppVersion() {
        Context context0 = FacebookSdk.getApplicationContext();
        if(context0 == null) {
            return null;
        }
        try {
            PackageInfo packageInfo0 = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0);
            return packageInfo0 == null ? null : packageInfo0.versionName;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    public final long getAvailableExternalStorageGB() [...] // 潜在的解密器

    @Nullable
    public static final Date getBundleLongAsDate(@Nullable Bundle bundle0, @Nullable String s, @NotNull Date date0) {
        long v;
        q.g(date0, "dateBase");
        if(bundle0 == null) {
            return null;
        }
        Object object0 = bundle0.get(s);
        if(object0 instanceof Long) {
            v = ((Number)object0).longValue();
            return v == 0L ? new Date(0x7FFFFFFFFFFFFFFFL) : new Date(v * 1000L + date0.getTime());
        }
        if(object0 instanceof String) {
            try {
                v = Long.parseLong(((String)object0));
            }
            catch(NumberFormatException unused_ex) {
                return null;
            }
            return v == 0L ? new Date(0x7FFFFFFFFFFFFFFFL) : new Date(v * 1000L + date0.getTime());
        }
        return null;
    }

    @NotNull
    public final String getCarrierName() [...] // 潜在的解密器

    public static final long getContentSize(@NotNull Uri uri0) {
        long v1;
        q.g(uri0, "contentUri");
        Cursor cursor0 = null;
        try {
            cursor0 = FacebookSdk.getApplicationContext().getContentResolver().query(uri0, null, null, null, null);
            if(cursor0 == null) {
                return 0L;
            }
            int v = cursor0.getColumnIndex("_size");
            cursor0.moveToFirst();
            v1 = cursor0.getLong(v);
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        cursor0.close();
        return v1;
    }

    @NotNull
    public static final Locale getCurrentLocale() {
        Locale locale0 = Utility.getResourceLocale();
        if(locale0 == null) {
            locale0 = Locale.getDefault();
            q.f(locale0, "getDefault()");
        }
        return locale0;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        return accessToken0 == null || accessToken0.getGraphDomain() == null ? "facebook" : accessToken0.getGraphDomain();
    }

    @Nullable
    public static final JSONObject getDataProcessingOptions() {
        Class class0 = Utility.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            String s = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
            if(s != null) {
                try {
                    return new JSONObject(s);
                }
                catch(JSONException unused_ex) {
                }
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return null;
    }

    @NotNull
    public final String getDeviceTimeZoneName() [...] // 潜在的解密器

    @NotNull
    public static final String getGraphDomainFromTokenDomain(@Nullable String s) {
        String s1 = FacebookSdk.getFacebookDomain();
        if(s != null) {
            if(s.equals("gaming")) {
                return v.p0(s1, "facebook.com", "fb.gg");
            }
            return s.equals("instagram") ? v.p0(s1, "facebook.com", "instagram.com") : s1;
        }
        return s1;
    }

    private final GraphRequest getGraphMeRequestWithCache(String s) {
        Bundle bundle0 = new Bundle();
        bundle0.putString("fields", this.getProfileFieldsForGraphDomain(this.getCurrentTokenDomainWithDefault()));
        bundle0.putString("access_token", s);
        GraphRequest graphRequest0 = GraphRequest.Companion.newMeRequest(null, null);
        graphRequest0.setParameters(bundle0);
        graphRequest0.setHttpMethod(HttpMethod.GET);
        return graphRequest0;
    }

    public static final void getGraphMeRequestWithCacheAsync(@NotNull String s, @NotNull GraphMeRequestWithCacheCallback utility$GraphMeRequestWithCacheCallback0) {
        q.g(s, "accessToken");
        q.g(utility$GraphMeRequestWithCacheCallback0, "callback");
        JSONObject jSONObject0 = ProfileInformationCache.getProfileInformation(s);
        if(jSONObject0 != null) {
            utility$GraphMeRequestWithCacheCallback0.onSuccess(jSONObject0);
            return;
        }
        e e0 = (GraphResponse graphResponse0) -> {
            q.g(utility$GraphMeRequestWithCacheCallback0, "$callback");
            q.g(s, "$accessToken");
            q.g(graphResponse0, "response");
            if(graphResponse0.getError() != null) {
                utility$GraphMeRequestWithCacheCallback0.onFailure(graphResponse0.getError().getException());
                return;
            }
            JSONObject jSONObject0 = graphResponse0.getJsonObject();
            if(jSONObject0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ProfileInformationCache.putProfileInformation(s, jSONObject0);
            utility$GraphMeRequestWithCacheCallback0.onSuccess(graphResponse0.getJsonObject());
        };
        GraphRequest graphRequest0 = Utility.INSTANCE.getGraphMeRequestWithCache(s);
        graphRequest0.setCallback(e0);
        graphRequest0.executeAsync();
    }

    // 检测为 Lambda 实现
    private static final void getGraphMeRequestWithCacheAsync$lambda$3(GraphMeRequestWithCacheCallback utility$GraphMeRequestWithCacheCallback0, String s, GraphResponse graphResponse0) [...]

    @Nullable
    public final Locale getLocale() {
        return Utility.locale;
    }

    @NotNull
    public static final String getMetadataApplicationId(@Nullable Context context0) {
        Validate.notNull(context0, "context");
        return FacebookSdk.getApplicationId();
    }

    @Nullable
    public static final Method getMethodQuietly(@NotNull Class class0, @NotNull String s, @NotNull Class[] arr_class) {
        q.g(class0, "clazz");
        q.g(s, "methodName");
        q.g(arr_class, "parameterTypes");
        try {
            return class0.getMethod(s, ((Class[])Arrays.copyOf(arr_class, arr_class.length)));
        }
        catch(NoSuchMethodException unused_ex) {
            return null;
        }
    }

    @Nullable
    public static final Method getMethodQuietly(@NotNull String s, @NotNull String s1, @NotNull Class[] arr_class) {
        q.g(s, "className");
        q.g(s1, "methodName");
        q.g(arr_class, "parameterTypes");
        try {
            return Utility.getMethodQuietly(Class.forName(s), s1, ((Class[])Arrays.copyOf(arr_class, arr_class.length)));
        }
        catch(ClassNotFoundException unused_ex) {
            return null;
        }
    }

    // 去混淆评级： 低(20)
    private final String getProfileFieldsForGraphDomain(String s) {
        return q.b(s, "instagram") ? "id,name,profile_picture" : "id,name,first_name,middle_name,last_name";
    }

    @Nullable
    public static final Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    @Nullable
    public static final Object getStringPropertyAsJSON(@NotNull JSONObject jSONObject0, @Nullable String s, @Nullable String s1) {
        q.g(jSONObject0, "jsonObject");
        Object object0 = jSONObject0.opt(s);
        if(object0 != null && object0 instanceof String) {
            object0 = new JSONTokener(((String)object0)).nextValue();
        }
        if(object0 != null && !(object0 instanceof JSONObject) && !(object0 instanceof JSONArray)) {
            if(s1 == null) {
                throw new FacebookException("Got an unexpected non-JSON object.");
            }
            JSONObject jSONObject1 = new JSONObject();
            jSONObject1.putOpt(s1, object0);
            return jSONObject1;
        }
        return object0;
    }

    @Nullable
    public static final String getUriString(@Nullable Uri uri0) {
        return uri0 == null ? null : uri0.toString();
    }

    @Nullable
    public final String getVersionName() [...] // 潜在的解密器

    private final String hashBytes(MessageDigest messageDigest0, byte[] arr_b) {
        messageDigest0.update(arr_b);
        byte[] arr_b1 = messageDigest0.digest();
        StringBuilder stringBuilder0 = new StringBuilder();
        q.f(arr_b1, "digest");
        for(int v = 0; v < arr_b1.length; ++v) {
            int v1 = arr_b1[v];
            stringBuilder0.append(Integer.toHexString(v1 >> 4 & 15));
            stringBuilder0.append(Integer.toHexString(v1 & 15));
        }
        String s = stringBuilder0.toString();
        q.f(s, "builder.toString()");
        return s;
    }

    private final String hashWithAlgorithm(String s, String s1) {
        byte[] arr_b = s1.getBytes(a.a);
        q.f(arr_b, "this as java.lang.String).getBytes(charset)");
        return this.hashWithAlgorithm(s, arr_b);
    }

    private final String hashWithAlgorithm(String s, byte[] arr_b) {
        MessageDigest messageDigest0;
        try {
            messageDigest0 = MessageDigest.getInstance(s);
        }
        catch(NoSuchAlgorithmException unused_ex) {
            return null;
        }
        q.f(messageDigest0, "hash");
        return this.hashBytes(messageDigest0, arr_b);
    }

    @Nullable
    public static final Object invokeMethodQuietly(@Nullable Object object0, @NotNull Method method0, @NotNull Object[] arr_object) {
        q.g(method0, "method");
        q.g(arr_object, "args");
        try {
            return method0.invoke(object0, Arrays.copyOf(arr_object, arr_object.length));
        }
        catch(IllegalAccessException | InvocationTargetException unused_ex) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent0 = new Intent("android.intent.action.VIEW");
            intent0.setData(Uri.parse(String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1))));
            List list0 = FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent0, 0x10000);
            q.f(list0, "packageManager.queryInte…nager.MATCH_DEFAULT_ONLY)");
            for(Object object0: list0) {
                if(!q.b("com.iloen.melon", ((ResolveInfo)object0).activityInfo.packageName)) {
                    continue;
                }
                return true;
            }
        }
        catch(Exception unused_ex) {
        }
        return false;
    }

    public static void isAutoAppLinkSetup$annotations() {
    }

    public static final boolean isAutofillAvailable(@NotNull Context context0) {
        q.g(context0, "context");
        AutofillManager autofillManager0 = (AutofillManager)context0.getSystemService(AutofillManager.class);
        return autofillManager0 != null && autofillManager0.isAutofillSupported() && autofillManager0.isEnabled();
    }

    public static final boolean isChromeOS(@NotNull Context context0) {
        q.g(context0, "context");
        if(Build.VERSION.SDK_INT >= 27) {
            return context0.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String s = Build.DEVICE;
        if(s != null) {
            q.f(s, "DEVICE");
            Pattern pattern0 = Pattern.compile(".+_cheets|cheets_.+");
            q.f(pattern0, "compile(...)");
            return pattern0.matcher(s).matches();
        }
        return false;
    }

    public static final boolean isContentUri(@Nullable Uri uri0) {
        return uri0 != null && "content".equalsIgnoreCase(uri0.getScheme());
    }

    public static final boolean isCurrentAccessToken(@Nullable AccessToken accessToken0) {
        return accessToken0 != null && accessToken0.equals(AccessToken.Companion.getCurrentAccessToken());
    }

    public static final boolean isDataProcessingRestricted() {
        JSONObject jSONObject0;
        Class class0 = Utility.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            jSONObject0 = Utility.getDataProcessingOptions();
            if(jSONObject0 == null) {
                return false;
            }
            goto label_6;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return false;
        try {
        label_6:
            JSONArray jSONArray0 = jSONObject0.getJSONArray("data_processing_options");
            int v = jSONArray0.length();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = jSONArray0.getString(v1);
                q.f(s, "options.getString(i)");
                String s1 = s.toLowerCase();
                q.f(s1, "this as java.lang.String).toLowerCase()");
                if(s1.equals("ldu")) {
                    return true;
                }
            }
            return false;
        }
        catch(Exception unused_ex) {
            return false;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return false;
    }

    public static final boolean isFileUri(@Nullable Uri uri0) {
        return uri0 != null && "file".equalsIgnoreCase(uri0.getScheme());
    }

    private final boolean isGooglePlayServicesAvailable(Context context0) {
        Method method0 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
        if(method0 == null) {
            return false;
        }
        Object object0 = Utility.invokeMethodQuietly(null, method0, new Object[]{context0});
        return object0 instanceof Integer && q.b(object0, 0);
    }

    public static final boolean isNullOrEmpty(@Nullable String s) {
        return s == null || s.length() == 0;
    }

    public static final boolean isNullOrEmpty(@Nullable Collection collection0) {
        return collection0 == null || collection0.isEmpty();
    }

    // 去混淆评级： 低(30)
    public static final boolean isWebUri(@Nullable Uri uri0) {
        return uri0 != null && ("http".equalsIgnoreCase(uri0.getScheme()) || "https".equalsIgnoreCase(uri0.getScheme()) || "fbstaging".equalsIgnoreCase(uri0.getScheme()));
    }

    @NotNull
    public static final Set jsonArrayToSet(@NotNull JSONArray jSONArray0) {
        q.g(jSONArray0, "jsonArray");
        Set set0 = new HashSet();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = jSONArray0.getString(v1);
            q.f(s, "jsonArray.getString(i)");
            set0.add(s);
        }
        return set0;
    }

    @NotNull
    public static final List jsonArrayToStringList(@NotNull JSONArray jSONArray0) {
        q.g(jSONArray0, "jsonArray");
        List list0 = new ArrayList();
        int v = jSONArray0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            ((ArrayList)list0).add(jSONArray0.getString(v1));
        }
        return list0;
    }

    @NotNull
    public static final Map jsonStrToMap(@NotNull String s) {
        q.g(s, "str");
        if(s.length() == 0) {
            return new HashMap();
        }
        try {
            Map map0 = new HashMap();
            JSONObject jSONObject0 = new JSONObject(s);
            Iterator iterator0 = jSONObject0.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(((String)object0), "key");
                String s1 = jSONObject0.getString(((String)object0));
                q.f(s1, "jsonObject.getString(key)");
                map0.put(((String)object0), s1);
            }
            return map0;
        }
        catch(JSONException unused_ex) {
            return new HashMap();
        }
    }

    // 去混淆评级： 低(30)
    public static final void logd(@Nullable String s, @Nullable Exception exception0) {
    }

    // 去混淆评级： 低(30)
    public static final void logd(@Nullable String s, @Nullable String s1) {
    }

    // 去混淆评级： 低(40)
    public static final void logd(@Nullable String s, @Nullable String s1, @Nullable Throwable throwable0) {
    }

    @NotNull
    public static final String mapToJsonStr(@NotNull Map map0) [...] // 潜在的解密器

    @Nullable
    public static final String md5hash(@NotNull String s) {
        q.g(s, "key");
        return Utility.INSTANCE.hashWithAlgorithm("MD5", s);
    }

    public static final boolean mustFixWindowParamsForAutofill(@NotNull Context context0) {
        q.g(context0, "context");
        return Utility.isAutofillAvailable(context0);
    }

    @NotNull
    public static final Bundle parseUrlQueryString(@Nullable String s) {
        Bundle bundle0 = new Bundle();
        if(!Utility.isNullOrEmpty(s)) {
            if(s == null) {
                throw new IllegalStateException("Required value was null.");
            }
            String[] arr_s = (String[])o.R0(s, new String[]{"&"}, 0, 6).toArray(new String[0]);
            for(int v = 0; v < arr_s.length; ++v) {
                String[] arr_s1 = (String[])o.R0(arr_s[v], new String[]{"="}, 0, 6).toArray(new String[0]);
                try {
                    if(arr_s1.length == 2) {
                        bundle0.putString(URLDecoder.decode(arr_s1[0], "UTF-8"), URLDecoder.decode(arr_s1[1], "UTF-8"));
                    }
                    else if(arr_s1.length == 1) {
                        bundle0.putString(URLDecoder.decode(arr_s1[0], "UTF-8"), "");
                    }
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    Utility.logd("FacebookSDK", unsupportedEncodingException0);
                }
            }
            return bundle0;
        }
        return bundle0;
    }

    public static final void putCommaSeparatedStringList(@NotNull Bundle bundle0, @Nullable String s, @Nullable List list0) {
        q.g(bundle0, "b");
        if(list0 != null) {
            bundle0.putString(s, TextUtils.join(",", list0));
        }
    }

    public static final boolean putJSONValueInBundle(@NotNull Bundle bundle0, @Nullable String s, @Nullable Object object0) {
        q.g(bundle0, "bundle");
        if(object0 == null) {
            bundle0.remove(s);
            return true;
        }
        if(object0 instanceof Boolean) {
            bundle0.putBoolean(s, ((Boolean)object0).booleanValue());
            return true;
        }
        if(object0 instanceof boolean[]) {
            bundle0.putBooleanArray(s, ((boolean[])object0));
            return true;
        }
        if(object0 instanceof Double) {
            bundle0.putDouble(s, ((Number)object0).doubleValue());
            return true;
        }
        if(object0 instanceof double[]) {
            bundle0.putDoubleArray(s, ((double[])object0));
            return true;
        }
        if(object0 instanceof Integer) {
            bundle0.putInt(s, ((Number)object0).intValue());
            return true;
        }
        if(object0 instanceof int[]) {
            bundle0.putIntArray(s, ((int[])object0));
            return true;
        }
        if(object0 instanceof Long) {
            bundle0.putLong(s, ((Number)object0).longValue());
            return true;
        }
        if(object0 instanceof long[]) {
            bundle0.putLongArray(s, ((long[])object0));
            return true;
        }
        if(object0 instanceof String) {
            bundle0.putString(s, ((String)object0));
            return true;
        }
        if(object0 instanceof JSONArray) {
            bundle0.putString(s, ((JSONArray)object0).toString());
            return true;
        }
        if(object0 instanceof JSONObject) {
            bundle0.putString(s, ((JSONObject)object0).toString());
            return true;
        }
        return false;
    }

    public static final void putNonEmptyString(@NotNull Bundle bundle0, @Nullable String s, @Nullable String s1) {
        q.g(bundle0, "b");
        if(!Utility.isNullOrEmpty(s1)) {
            bundle0.putString(s, s1);
        }
    }

    public static final void putUri(@NotNull Bundle bundle0, @Nullable String s, @Nullable Uri uri0) {
        q.g(bundle0, "b");
        if(uri0 != null) {
            Utility.putNonEmptyString(bundle0, s, uri0.toString());
        }
    }

    @Nullable
    public static final Map readNonnullStringMapFromParcel(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        int v = parcel0.readInt();
        if(v < 0) {
            return null;
        }
        Map map0 = new HashMap();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = parcel0.readString();
            String s1 = parcel0.readString();
            if(s != null && s1 != null) {
                map0.put(s, s1);
            }
        }
        return map0;
    }

    @NotNull
    public static final String readStreamToString(@Nullable InputStream inputStream0) {
        String s;
        InputStreamReader inputStreamReader0;
        Throwable throwable1;
        BufferedInputStream bufferedInputStream0;
        try {
            bufferedInputStream0 = new BufferedInputStream(inputStream0);
        }
        catch(Throwable throwable0) {
            bufferedInputStream0 = null;
            throwable1 = throwable0;
            inputStreamReader0 = null;
            Utility.closeQuietly(bufferedInputStream0);
            Utility.closeQuietly(inputStreamReader0);
            throw throwable1;
        }
        try {
            inputStreamReader0 = new InputStreamReader(bufferedInputStream0);
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            inputStreamReader0 = null;
            Utility.closeQuietly(bufferedInputStream0);
            Utility.closeQuietly(inputStreamReader0);
            throw throwable1;
        }
        try {
            StringBuilder stringBuilder0 = new StringBuilder();
            char[] arr_c = new char[0x800];
            int v;
            while((v = inputStreamReader0.read(arr_c)) != -1) {
                stringBuilder0.append(arr_c, 0, v);
            }
            s = stringBuilder0.toString();
            q.f(s, "{\n      bufferedInputStr…gBuilder.toString()\n    }");
        }
        catch(Throwable throwable1) {
            Utility.closeQuietly(bufferedInputStream0);
            Utility.closeQuietly(inputStreamReader0);
            throw throwable1;
        }
        Utility.closeQuietly(bufferedInputStream0);
        Utility.closeQuietly(inputStreamReader0);
        return s;
    }

    @Nullable
    public static final Map readStringMapFromParcel(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        int v = parcel0.readInt();
        if(v < 0) {
            return null;
        }
        Map map0 = new HashMap();
        for(int v1 = 0; v1 < v; ++v1) {
            map0.put(parcel0.readString(), parcel0.readString());
        }
        return map0;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if(this.externalStorageExists()) {
                StatFs statFs0 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                Utility.availableExternalStorageGB = ((long)statFs0.getAvailableBlocks()) * ((long)statFs0.getBlockSize());
            }
            Utility.availableExternalStorageGB = 0L;
        }
        catch(Exception unused_ex) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int v = Utility.numCPUCores;
        if(v > 0) {
            return v;
        }
        try {
            File[] arr_file = new File("/sys/devices/system/cpu/").listFiles(new b(2));
            if(arr_file != null) {
                Utility.numCPUCores = arr_file.length;
            }
        }
        catch(Exception unused_ex) {
        }
        if(Utility.numCPUCores <= 0) {
            Utility.numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return Utility.numCPUCores;
    }

    private static final boolean refreshBestGuessNumberOfCPUCores$lambda$4(File file0, String s) {
        return Pattern.matches("cpu[0-9]+", s);
    }

    private final void refreshCarrierName(Context context0) {
        if(q.b("NoCarrier", "NoCarrier")) {
            try {
                Object object0 = context0.getSystemService("phone");
                q.e(object0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                String s = ((TelephonyManager)object0).getNetworkOperatorName();
                q.f(s, "telephonyManager.networkOperatorName");
                Utility.carrierName = s;
            }
            catch(Exception unused_ex) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context0) {
        if(Utility.timestampOfLastCheck != -1L && System.currentTimeMillis() - Utility.timestampOfLastCheck < 1800000L) {
            return;
        }
        Utility.timestampOfLastCheck = System.currentTimeMillis();
        this.refreshTimezone();
        this.refreshCarrierName(context0);
        this.refreshTotalExternalStorage();
        this.refreshAvailableExternalStorage();
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone0 = TimeZone.getDefault();
            String s = timeZone0.getDisplayName(timeZone0.inDaylightTime(new Date()), 0);
            q.f(s, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            Utility.deviceTimezoneAbbreviation = s;
            String s1 = timeZone0.getID();
            q.f(s1, "tz.id");
            Utility.deviceTimeZoneName = s1;
        }
        catch(AssertionError | Exception unused_ex) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if(this.externalStorageExists()) {
                StatFs statFs0 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                Utility.totalExternalStorageGB = ((long)statFs0.getBlockCount()) * ((long)statFs0.getBlockSize());
            }
            Utility.totalExternalStorageGB = 0L;
        }
        catch(Exception unused_ex) {
        }
    }

    public static final void runOnNonUiThread(@Nullable Runnable runnable0) {
        try {
            FacebookSdk.getExecutor().execute(runnable0);
        }
        catch(Exception unused_ex) {
        }
    }

    @NotNull
    public static final String safeGetStringFromResponse(@Nullable JSONObject jSONObject0, @Nullable String s) {
        if(jSONObject0 != null) {
            String s1 = jSONObject0.optString(s, "");
            q.f(s1, "response.optString(propertyName, \"\")");
            return s1;
        }
        return "";
    }

    public static final void setAppEventAttributionParameters(@NotNull JSONObject jSONObject0, @Nullable AttributionIdentifiers attributionIdentifiers0, @Nullable String s, boolean z, @NotNull Context context0) {
        q.g(jSONObject0, "params");
        q.g(context0, "context");
        Feature featureManager$Feature0 = Feature.ServiceUpdateCompliance;
        if(!FeatureManager.isEnabled(featureManager$Feature0)) {
            jSONObject0.put("anon_id", s);
        }
        jSONObject0.put("application_tracking_enabled", !z);
        jSONObject0.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if(attributionIdentifiers0 != null) {
            if(FeatureManager.isEnabled(featureManager$Feature0)) {
                Utility.INSTANCE.appendAnonIdUnderCompliance(jSONObject0, attributionIdentifiers0, s, context0);
            }
            if(attributionIdentifiers0.getAttributionId() != null) {
                if(FeatureManager.isEnabled(featureManager$Feature0)) {
                    Utility.INSTANCE.appendAttributionIdUnderCompliance(jSONObject0, attributionIdentifiers0, context0);
                }
                else {
                    jSONObject0.put("attribution", attributionIdentifiers0.getAttributionId());
                }
            }
            if(attributionIdentifiers0.getAndroidAdvertiserId() != null) {
                jSONObject0.put("advertiser_id", attributionIdentifiers0.getAndroidAdvertiserId());
                jSONObject0.put("advertiser_tracking_enabled", !attributionIdentifiers0.isTrackingLimited());
            }
            if(attributionIdentifiers0.getAndroidInstallerPackage() != null) {
                jSONObject0.put("installer_package", attributionIdentifiers0.getAndroidInstallerPackage());
            }
        }
        AppLinkManager appLinkManager0 = AppLinkManager.Companion.getInstance();
        String s1 = appLinkManager0 == null ? null : appLinkManager0.getInfo("campaign_ids");
        if(s1 != null) {
            jSONObject0.put("campaign_ids", s1);
        }
    }

    public static final void setAppEventExtendedDeviceInfoParameters(@NotNull JSONObject jSONObject0, @NotNull Context context0) {
        int v2;
        Locale locale0;
        q.g(jSONObject0, "params");
        q.g(context0, "appContext");
        JSONArray jSONArray0 = new JSONArray();
        jSONArray0.put("a2");
        Utility.INSTANCE.refreshPeriodicExtendedDeviceInfo(context0);
        int v = 0;
        int v1 = -1;
        try {
            PackageInfo packageInfo0 = context0.getPackageManager().getPackageInfo("com.iloen.melon", 0);
            if(packageInfo0 == null) {
                return;
            }
            v1 = packageInfo0.versionCode;
            Utility.versionName = packageInfo0.versionName;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        jSONArray0.put("com.iloen.melon");
        jSONArray0.put(v1);
        jSONArray0.put("");
        jSONArray0.put(Build.VERSION.RELEASE);
        jSONArray0.put(Build.MODEL);
        try {
            locale0 = context0.getResources().getConfiguration().locale;
        }
        catch(Exception unused_ex) {
            locale0 = Locale.getDefault();
        }
        Utility.locale = locale0;
        StringBuilder stringBuilder0 = new StringBuilder();
        Locale locale1 = Utility.locale;
        Display display0 = null;
        if(locale1 != null) {
            locale1.getLanguage();
        }
        stringBuilder0.append("");
        stringBuilder0.append('_');
        Locale locale2 = Utility.locale;
        if(locale2 != null) {
            locale2.getCountry();
        }
        stringBuilder0.append("");
        jSONArray0.put("_");
        jSONArray0.put("");
        jSONArray0.put("NoCarrier");
        double f = 0.0;
        try {
            Object object0 = context0.getSystemService("display");
            DisplayManager displayManager0 = object0 instanceof DisplayManager ? ((DisplayManager)object0) : null;
            if(displayManager0 != null) {
                display0 = displayManager0.getDisplay(0);
            }
            if(display0 == null) {
            label_47:
                v2 = 0;
            }
            else {
                DisplayMetrics displayMetrics0 = new DisplayMetrics();
                display0.getMetrics(displayMetrics0);
                f = (double)displayMetrics0.density;
                v2 = displayMetrics0.heightPixels;
                v = displayMetrics0.widthPixels;
            }
        }
        catch(Exception unused_ex) {
            goto label_47;
        }
        jSONArray0.put(v);
        jSONArray0.put(v2);
        jSONArray0.put(new DecimalFormat("#.##").format(f));
        jSONArray0.put(Utility.INSTANCE.refreshBestGuessNumberOfCPUCores());
        jSONArray0.put(Utility.totalExternalStorageGB);
        jSONArray0.put(-1L);
        jSONArray0.put("");
        jSONObject0.put("extinfo", jSONArray0.toString());
    }

    public final void setAvailableExternalStorageGB(long v) {
        Utility.availableExternalStorageGB = v;
    }

    public final void setCarrierName(@NotNull String s) {
        q.g(s, "<set-?>");
        Utility.carrierName = s;
    }

    public final void setDeviceTimeZoneName(@NotNull String s) {
        q.g(s, "<set-?>");
        Utility.deviceTimeZoneName = s;
    }

    public final void setLocale(@Nullable Locale locale0) {
        Utility.locale = locale0;
    }

    public final void setVersionName(@Nullable String s) {
        Utility.versionName = s;
    }

    @Nullable
    public static final String sha1hash(@NotNull String s) {
        q.g(s, "key");
        return Utility.INSTANCE.hashWithAlgorithm("SHA-1", s);
    }

    @Nullable
    public static final String sha1hash(@NotNull byte[] arr_b) {
        q.g(arr_b, "bytes");
        return Utility.INSTANCE.hashWithAlgorithm("SHA-1", arr_b);
    }

    @Nullable
    public static final String sha256hash(@Nullable String s) {
        return s == null ? null : Utility.INSTANCE.hashWithAlgorithm("SHA-256", s);
    }

    @Nullable
    public static final String sha256hash(@Nullable byte[] arr_b) {
        return arr_b == null ? null : Utility.INSTANCE.hashWithAlgorithm("SHA-256", arr_b);
    }

    public static final boolean stringsEqualOrEmpty(@Nullable String s, @Nullable String s1) {
        boolean z = s == null || s.length() == 0;
        boolean z1 = s1 == null || s1.length() == 0;
        if(z && z1) {
            return true;
        }
        return z || z1 ? false : q.b(s, s1);
    }

    @Nullable
    public static final JSONArray tryGetJSONArrayFromResponse(@Nullable JSONObject jSONObject0, @Nullable String s) {
        return jSONObject0 == null ? null : jSONObject0.optJSONArray(s);
    }

    @Nullable
    public static final JSONObject tryGetJSONObjectFromResponse(@Nullable JSONObject jSONObject0, @Nullable String s) {
        return jSONObject0 == null ? null : jSONObject0.optJSONObject(s);
    }

    public static final void writeNonnullStringMapToParcel(@NotNull Parcel parcel0, @Nullable Map map0) {
        q.g(parcel0, "parcel");
        if(map0 == null) {
            parcel0.writeInt(-1);
            return;
        }
        parcel0.writeInt(map0.size());
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            String s1 = (String)((Map.Entry)object0).getValue();
            parcel0.writeString(s);
            parcel0.writeString(s1);
        }
    }

    public static final void writeStringMapToParcel(@NotNull Parcel parcel0, @Nullable Map map0) {
        q.g(parcel0, "parcel");
        if(map0 == null) {
            parcel0.writeInt(-1);
            return;
        }
        parcel0.writeInt(map0.size());
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            String s1 = (String)((Map.Entry)object0).getValue();
            parcel0.writeString(s);
            parcel0.writeString(s1);
        }
    }
}

