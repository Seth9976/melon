package com.facebook.login;

import Tf.v;
import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.media3.session.G0;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager.ActivityResultParameters;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import e.b;
import e.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import je.n;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.d;

@Metadata(d1 = {"\u0000\u00F6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000 \u00AF\u00012\u00020\u0001:\f\u00B0\u0001\u00B1\u0001\u00AF\u0001\u00B2\u0001\u00B3\u0001\u00B4\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\t\u0010\rJ%\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\u0010J\u001D\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u00112\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\u0012J%\u0010\t\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\t\u0010\u0015J\'\u0010\u0019\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001B\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u001B\u0010\u001CJ3\u0010\"\u001A\u00020!2\u0006\u0010\u001E\u001A\u00020\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\u0010\b\u0002\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0017\u00A2\u0006\u0004\b\"\u0010#J\u0015\u0010&\u001A\u00020\u00002\u0006\u0010%\u001A\u00020$\u00A2\u0006\u0004\b&\u0010\'J\u0015\u0010*\u001A\u00020\u00002\u0006\u0010)\u001A\u00020(\u00A2\u0006\u0004\b*\u0010+J\u0015\u0010.\u001A\u00020\u00002\u0006\u0010-\u001A\u00020,\u00A2\u0006\u0004\b.\u0010/J\u0015\u00102\u001A\u00020\u00002\u0006\u00101\u001A\u000200\u00A2\u0006\u0004\b2\u00103J\u0017\u00105\u001A\u00020\u00002\b\u00104\u001A\u0004\u0018\u000100\u00A2\u0006\u0004\b5\u00103J\u0015\u00107\u001A\u00020\u00002\u0006\u00106\u001A\u00020!\u00A2\u0006\u0004\b7\u00108J\u0015\u0010:\u001A\u00020\u00002\u0006\u00109\u001A\u00020!\u00A2\u0006\u0004\b:\u00108J\u0015\u0010<\u001A\u00020\u00002\u0006\u0010;\u001A\u00020!\u00A2\u0006\u0004\b<\u00108J\u000F\u0010=\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b=\u0010\u0003J\u001D\u0010B\u001A\u00020\b2\u0006\u0010?\u001A\u00020>2\u0006\u0010A\u001A\u00020@\u00A2\u0006\u0004\bB\u0010CJ%\u0010B\u001A\u00020\b2\u0006\u0010?\u001A\u00020>2\u0006\u0010E\u001A\u00020D2\u0006\u0010A\u001A\u00020@\u00A2\u0006\u0004\bB\u0010FJ%\u0010I\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000GH\u0007\u00A2\u0006\u0004\bI\u0010JJ+\u0010I\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bI\u0010KJ#\u0010I\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u00112\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bI\u0010LJ%\u0010I\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G\u00A2\u0006\u0004\bI\u0010MJ+\u0010I\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bI\u0010NJ\u001D\u0010Q\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010P\u001A\u00020O\u00A2\u0006\u0004\bQ\u0010RJ\u001D\u0010S\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010P\u001A\u00020O\u00A2\u0006\u0004\bS\u0010TJ\u0015\u0010U\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\bU\u0010VJ\u0015\u0010U\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\bU\u0010WJ%\u0010X\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000GH\u0007\u00A2\u0006\u0004\bX\u0010JJ+\u0010X\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bX\u0010KJ#\u0010X\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u00112\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bX\u0010LJ%\u0010X\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G\u00A2\u0006\u0004\bX\u0010MJ+\u0010X\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bX\u0010NJ%\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G\u00A2\u0006\u0004\bY\u0010JJ/\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G2\b\u0010Z\u001A\u0004\u0018\u000100\u00A2\u0006\u0004\bY\u0010[J%\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u00112\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G\u00A2\u0006\u0004\bY\u0010LJ/\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u00112\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G2\b\u0010Z\u001A\u0004\u0018\u000100\u00A2\u0006\u0004\bY\u0010\\J%\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G\u00A2\u0006\u0004\bY\u0010^J/\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G2\b\u0010Z\u001A\u0004\u0018\u000100\u00A2\u0006\u0004\bY\u0010_J%\u0010Y\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G\u00A2\u0006\u0004\bY\u0010MJ\u001D\u0010Y\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\u0006\u0010P\u001A\u00020O\u00A2\u0006\u0004\bY\u0010`J\u001D\u0010Y\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010P\u001A\u00020O\u00A2\u0006\u0004\bY\u0010TJ/\u0010Y\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010G2\b\u0010Z\u001A\u0004\u0018\u000100\u00A2\u0006\u0004\bY\u0010aJ5\u0010Y\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G2\b\u0010Z\u001A\u0004\u0018\u000100\u00A2\u0006\u0004\bY\u0010bJ+\u0010Y\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000G\u00A2\u0006\u0004\bY\u0010NJ+\u0010d\u001A\u00060cR\u00020\u00002\n\b\u0002\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\n\b\u0002\u0010Z\u001A\u0004\u0018\u000100H\u0007\u00A2\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001A\u00020f2\u0006\u0010P\u001A\u00020OH\u0014\u00A2\u0006\u0004\bg\u0010hJ\u001F\u0010i\u001A\u00020f2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010GH\u0014\u00A2\u0006\u0004\bi\u0010jJ\u000F\u0010k\u001A\u00020fH\u0014\u00A2\u0006\u0004\bk\u0010lJ\u0017\u0010n\u001A\u00020\u001F2\u0006\u0010m\u001A\u00020fH\u0014\u00A2\u0006\u0004\bn\u0010oJ\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010pJ\u0017\u0010q\u001A\u00020f2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bq\u0010rJ%\u0010I\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000GH\u0002\u00A2\u0006\u0004\bI\u0010^J\u001F\u0010S\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\u0006\u0010P\u001A\u00020OH\u0002\u00A2\u0006\u0004\bS\u0010`J\u0017\u0010U\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]H\u0002\u00A2\u0006\u0004\bU\u0010sJ%\u0010X\u001A\u00020\b2\u0006\u0010\f\u001A\u00020]2\f\u0010H\u001A\b\u0012\u0004\u0012\u0002000GH\u0002\u00A2\u0006\u0004\bX\u0010^J\'\u0010Y\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010P\u001A\u00020OH\u0002\u00A2\u0006\u0004\bY\u0010tJ\u001F\u0010u\u001A\u00020\b2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010GH\u0002\u00A2\u0006\u0004\bu\u0010vJ\u001F\u0010w\u001A\u00020\b2\u000E\u0010H\u001A\n\u0012\u0004\u0012\u000200\u0018\u00010GH\u0002\u00A2\u0006\u0004\bw\u0010vJ\u001F\u0010z\u001A\u00020\b2\u0006\u0010y\u001A\u00020x2\u0006\u0010m\u001A\u00020fH\u0002\u00A2\u0006\u0004\bz\u0010{J#\u0010}\u001A\u00020\b2\b\u0010?\u001A\u0004\u0018\u00010>2\b\u0010|\u001A\u0004\u0018\u00010fH\u0002\u00A2\u0006\u0004\b}\u0010~J\\\u0010\u0086\u0001\u001A\u00020\b2\b\u0010?\u001A\u0004\u0018\u00010>2\u0007\u0010\u0080\u0001\u001A\u00020\u007F2\u0016\u0010\u0082\u0001\u001A\u0011\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200\u0018\u00010\u0081\u00012\n\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0085\u0001\u001A\u00020!2\b\u0010m\u001A\u0004\u0018\u00010fH\u0002\u00A2\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\"\u0010\u0088\u0001\u001A\u00020!2\u0006\u0010y\u001A\u00020x2\u0006\u0010m\u001A\u00020fH\u0002\u00A2\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001B\u0010\u008B\u0001\u001A\u00020!2\u0007\u0010\u008A\u0001\u001A\u00020\u001FH\u0002\u00A2\u0006\u0006\b\u008B\u0001\u0010\u008C\u0001JZ\u0010\u0094\u0001\u001A\u00020\b2\n\u0010\u008E\u0001\u001A\u0005\u0018\u00010\u008D\u00012\n\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u00012\t\u0010\u0091\u0001\u001A\u0004\u0018\u00010f2\n\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0092\u00012\u0007\u0010\u0093\u0001\u001A\u00020!2\u000E\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002\u00A2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J*\u0010\u0096\u0001\u001A\u00020\b2\u0006\u0010?\u001A\u00020>2\u0006\u0010A\u001A\u00020@2\u0006\u0010E\u001A\u00020DH\u0002\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001B\u0010\u0099\u0001\u001A\u00020\b2\u0007\u0010\u0098\u0001\u001A\u00020!H\u0002\u00A2\u0006\u0006\b\u0099\u0001\u0010\u009A\u0001R(\u0010%\u001A\u00020$2\u0007\u0010\u009B\u0001\u001A\u00020$8\u0006@BX\u0086\u000E\u00A2\u0006\u000F\n\u0005\b%\u0010\u009C\u0001\u001A\u0006\b\u009D\u0001\u0010\u009E\u0001R(\u0010-\u001A\u00020,2\u0007\u0010\u009B\u0001\u001A\u00020,8\u0006@BX\u0086\u000E\u00A2\u0006\u000F\n\u0005\b-\u0010\u009F\u0001\u001A\u0006\b\u00A0\u0001\u0010\u00A1\u0001R\u0018\u0010\u00A3\u0001\u001A\u00030\u00A2\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u00A4\u0001R(\u00101\u001A\u0002002\u0007\u0010\u009B\u0001\u001A\u0002008\u0006@BX\u0086\u000E\u00A2\u0006\u000F\n\u0005\b1\u0010\u00A5\u0001\u001A\u0006\b\u00A6\u0001\u0010\u00A7\u0001R\u0019\u00104\u001A\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b4\u0010\u00A5\u0001R\u0017\u00106\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b6\u0010\u00A8\u0001R*\u0010\u00A9\u0001\u001A\u00020(2\u0007\u0010\u009B\u0001\u001A\u00020(8\u0006@BX\u0086\u000E\u00A2\u0006\u0010\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001\u001A\u0006\b\u00AB\u0001\u0010\u00AC\u0001R\'\u00109\u001A\u00020!2\u0007\u0010\u009B\u0001\u001A\u00020!8\u0006@BX\u0086\u000E\u00A2\u0006\u000E\n\u0005\b9\u0010\u00A8\u0001\u001A\u0005\b9\u0010\u00AD\u0001R(\u0010;\u001A\u00020!2\u0007\u0010\u009B\u0001\u001A\u00020!8\u0006@BX\u0086\u000E\u00A2\u0006\u000F\n\u0005\b;\u0010\u00A8\u0001\u001A\u0006\b\u00AE\u0001\u0010\u00AD\u0001R\u0017\u0010\u0098\u0001\u001A\u00020!8BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u0098\u0001\u0010\u00AD\u0001\u00A8\u0006\u00B5\u0001"}, d2 = {"Lcom/facebook/login/LoginManager;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Lcom/facebook/GraphResponse;", "response", "Lie/H;", "resolveError", "(Landroid/app/Activity;Lcom/facebook/GraphResponse;)V", "Landroidx/fragment/app/I;", "fragment", "(Landroidx/fragment/app/I;Lcom/facebook/GraphResponse;)V", "Lcom/facebook/CallbackManager;", "callbackManager", "(Landroidx/fragment/app/I;Lcom/facebook/CallbackManager;Lcom/facebook/GraphResponse;)V", "Landroid/app/Fragment;", "(Landroid/app/Fragment;Lcom/facebook/GraphResponse;)V", "Le/i;", "activityResultRegistryOwner", "(Le/i;Lcom/facebook/CallbackManager;Lcom/facebook/GraphResponse;)V", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "callback", "registerCallback", "(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V", "unregisterCallback", "(Lcom/facebook/CallbackManager;)V", "", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(ILandroid/content/Intent;Lcom/facebook/FacebookCallback;)Z", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)Lcom/facebook/login/LoginManager;", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)Lcom/facebook/login/LoginManager;", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)Lcom/facebook/login/LoginManager;", "", "authType", "setAuthType", "(Ljava/lang/String;)Lcom/facebook/login/LoginManager;", "messengerPageId", "setMessengerPageId", "resetMessengerState", "setResetMessengerState", "(Z)Lcom/facebook/login/LoginManager;", "isFamilyLogin", "setFamilyLogin", "shouldSkipAccountDeduplication", "setShouldSkipAccountDeduplication", "logOut", "Landroid/content/Context;", "context", "Lcom/facebook/LoginStatusCallback;", "responseCallback", "retrieveLoginStatus", "(Landroid/content/Context;Lcom/facebook/LoginStatusCallback;)V", "", "toastDurationMs", "(Landroid/content/Context;JLcom/facebook/LoginStatusCallback;)V", "", "permissions", "logInWithReadPermissions", "(Landroidx/fragment/app/I;Ljava/util/Collection;)V", "(Landroidx/fragment/app/I;Lcom/facebook/CallbackManager;Ljava/util/Collection;)V", "(Landroid/app/Fragment;Ljava/util/Collection;)V", "(Landroid/app/Activity;Ljava/util/Collection;)V", "(Le/i;Lcom/facebook/CallbackManager;Ljava/util/Collection;)V", "Lcom/facebook/login/LoginConfiguration;", "loginConfig", "logInWithConfiguration", "(Landroidx/fragment/app/I;Lcom/facebook/login/LoginConfiguration;)V", "loginWithConfiguration", "(Landroid/app/Activity;Lcom/facebook/login/LoginConfiguration;)V", "reauthorizeDataAccess", "(Landroid/app/Activity;)V", "(Landroidx/fragment/app/I;)V", "logInWithPublishPermissions", "logIn", "loggerID", "(Landroidx/fragment/app/I;Ljava/util/Collection;Ljava/lang/String;)V", "(Landroid/app/Fragment;Ljava/util/Collection;Ljava/lang/String;)V", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;Ljava/util/Collection;)V", "(Lcom/facebook/internal/FragmentWrapper;Ljava/util/Collection;Ljava/lang/String;)V", "(Lcom/facebook/internal/FragmentWrapper;Lcom/facebook/login/LoginConfiguration;)V", "(Landroid/app/Activity;Ljava/util/Collection;Ljava/lang/String;)V", "(Le/i;Lcom/facebook/CallbackManager;Ljava/util/Collection;Ljava/lang/String;)V", "Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "createLogInActivityResultContract", "(Lcom/facebook/CallbackManager;Ljava/lang/String;)Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Lcom/facebook/login/LoginClient$Request;", "createLoginRequestWithConfig", "(Lcom/facebook/login/LoginConfiguration;)Lcom/facebook/login/LoginClient$Request;", "createLoginRequest", "(Ljava/util/Collection;)Lcom/facebook/login/LoginClient$Request;", "createReauthorizeRequest", "()Lcom/facebook/login/LoginClient$Request;", "request", "getFacebookActivityIntent", "(Lcom/facebook/login/LoginClient$Request;)Landroid/content/Intent;", "(Lcom/facebook/internal/FragmentWrapper;Lcom/facebook/GraphResponse;)V", "createLoginRequestFromResponse", "(Lcom/facebook/GraphResponse;)Lcom/facebook/login/LoginClient$Request;", "(Lcom/facebook/internal/FragmentWrapper;)V", "(Le/i;Lcom/facebook/CallbackManager;Lcom/facebook/login/LoginConfiguration;)V", "validateReadPermissions", "(Ljava/util/Collection;)V", "validatePublishPermissions", "Lcom/facebook/login/StartActivityDelegate;", "startActivityDelegate", "startLogin", "(Lcom/facebook/login/StartActivityDelegate;Lcom/facebook/login/LoginClient$Request;)V", "loginRequest", "logStartLogin", "(Landroid/content/Context;Lcom/facebook/login/LoginClient$Request;)V", "Lcom/facebook/login/LoginClient$Result$Code;", "result", "", "resultExtras", "Ljava/lang/Exception;", "exception", "wasLoginActivityTried", "logCompleteLogin", "(Landroid/content/Context;Lcom/facebook/login/LoginClient$Result$Code;Ljava/util/Map;Ljava/lang/Exception;ZLcom/facebook/login/LoginClient$Request;)V", "tryFacebookActivity", "(Lcom/facebook/login/StartActivityDelegate;Lcom/facebook/login/LoginClient$Request;)Z", "intent", "resolveIntent", "(Landroid/content/Intent;)Z", "Lcom/facebook/AccessToken;", "newToken", "Lcom/facebook/AuthenticationToken;", "newIdToken", "origRequest", "Lcom/facebook/FacebookException;", "isCanceled", "finishLogin", "(Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;Lcom/facebook/login/LoginClient$Request;Lcom/facebook/FacebookException;ZLcom/facebook/FacebookCallback;)V", "retrieveLoginStatusImpl", "(Landroid/content/Context;Lcom/facebook/LoginStatusCallback;J)V", "isExpressLoginAllowed", "setExpressLoginStatus", "(Z)V", "<set-?>", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Ljava/lang/String;", "getAuthType", "()Ljava/lang/String;", "Z", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "()Z", "getShouldSkipAccountDeduplication", "Companion", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "FacebookLoginActivityResultContract", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class LoginManager {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\r\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "Lie/H;", "startActivityForResult", "(Landroid/content/Intent;I)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        @NotNull
        private final Activity activityContext;

        public ActivityStartActivityDelegate(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            super();
            this.activityContext = activity0;
        }

        @Override  // com.facebook.login.StartActivityDelegate
        @NotNull
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override  // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent0, int v) {
            q.g(intent0, "intent");
            this.getActivityContext().startActivityForResult(intent0, v);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0014\u001A\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Le/i;", "activityResultRegistryOwner", "Lcom/facebook/CallbackManager;", "callbackManager", "<init>", "(Le/i;Lcom/facebook/CallbackManager;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "Lie/H;", "startActivityForResult", "(Landroid/content/Intent;I)V", "Le/i;", "Lcom/facebook/CallbackManager;", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        @NotNull
        private final i activityResultRegistryOwner;
        @NotNull
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(@NotNull i i0, @NotNull CallbackManager callbackManager0) {
            q.g(i0, "activityResultRegistryOwner");
            q.g(callbackManager0, "callbackManager");
            super();
            this.activityResultRegistryOwner = i0;
            this.callbackManager = callbackManager0;
        }

        // 去混淆评级： 低(20)
        @Override  // com.facebook.login.StartActivityDelegate
        @Nullable
        public Activity getActivityContext() {
            return this.activityResultRegistryOwner instanceof Activity ? ((Activity)this.activityResultRegistryOwner) : null;
        }

        @Override  // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent0, int v) {
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R*\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"com/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder", "", "<init>", "()V", "Le/b;", "Landroid/content/Intent;", "launcher", "Le/b;", "getLauncher", "()Le/b;", "setLauncher", "(Le/b;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
            public static final class LauncherHolder {
                @Nullable
                private b launcher;

                @Nullable
                public final b getLauncher() {
                    return this.launcher;
                }

                public final void setLauncher(@Nullable b b0) {
                    this.launcher = b0;
                }
            }

            q.g(intent0, "intent");
            LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0 = new LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().d("facebook-login", new com.facebook.login.LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult.1(), new g(this, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0)));
            b b0 = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0.getLauncher();
            if(b0 != null) {
                b0.b(intent0);
            }

            @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u001A\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00030\u0001J\u001F\u0010\b\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\n\u001A\u00020\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"com/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1", "Lf/b;", "Landroid/content/Intent;", "Landroid/util/Pair;", "", "Landroid/content/Context;", "context", "input", "createIntent", "(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/Intent;", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Landroid/util/Pair;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
            public final class com.facebook.login.LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.startActivityForResult.1 extends f.b {
                @NotNull
                public Intent createIntent(@NotNull Context context0, @NotNull Intent intent0) {
                    q.g(context0, "context");
                    q.g(intent0, "input");
                    return intent0;
                }

                @Override  // f.b
                public Intent createIntent(Context context0, Object object0) {
                    return this.createIntent(context0, ((Intent)object0));
                }

                @NotNull
                public Pair parseResult(int v, @Nullable Intent intent0) {
                    Pair pair0 = Pair.create(v, intent0);
                    q.f(pair0, "create(resultCode, intent)");
                    return pair0;
                }

                @Override  // f.b
                public Object parseResult(int v, Intent intent0) {
                    return this.parseResult(v, intent0);
                }
            }

        }

        private static final void startActivityForResult$lambda$0(AndroidxActivityResultRegistryOwnerStartActivityDelegate loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate0, LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0, Pair pair0) {
            q.g(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate0, "this$0");
            q.g(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0, "$launcherHolder");
            int v = RequestCodeOffset.Login.toRequestCode();
            Object object0 = pair0.first;
            q.f(object0, "result.first");
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate0.callbackManager.onActivityResult(v, ((Number)object0).intValue(), ((Intent)pair0.second));
            b b0 = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0.getLauncher();
            if(b0 != null) {
                b0.c();
            }
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder0.setLauncher(null);
        }
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J9\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0017\u00A2\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ)\u0010\"\u001A\u00020!2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001E\u001A\u00020\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0007\u00A2\u0006\u0004\b\"\u0010#R\u001A\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00040$8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b%\u0010&R\u0014\u0010(\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010)R\u001A\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00040$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u0010.\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010)R\u0014\u0010/\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00100\u001A\u00020\u000F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b0\u00101\u00A8\u00062"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "<init>", "()V", "", "errorType", "errorDescription", "loggerRef", "Lcom/facebook/login/LoginLogger;", "logger", "Lcom/facebook/LoginStatusCallback;", "responseCallback", "Lie/H;", "handleLoginStatusError", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/login/LoginLogger;Lcom/facebook/LoginStatusCallback;)V", "Lcom/facebook/login/LoginManager;", "getInstance", "()Lcom/facebook/login/LoginManager;", "Landroid/content/Intent;", "intent", "", "getExtraDataFromIntent", "(Landroid/content/Intent;)Ljava/util/Map;", "permission", "", "isPublishPermission", "(Ljava/lang/String;)Z", "Lcom/facebook/login/LoginClient$Request;", "request", "Lcom/facebook/AccessToken;", "newToken", "Lcom/facebook/AuthenticationToken;", "newIdToken", "Lcom/facebook/login/LoginResult;", "computeLoginResult", "(Lcom/facebook/login/LoginClient$Request;Lcom/facebook/AccessToken;Lcom/facebook/AuthenticationToken;)Lcom/facebook/login/LoginResult;", "", "getOtherPublishPermissions", "()Ljava/util/Set;", "otherPublishPermissions", "EXPRESS_LOGIN_ALLOWED", "Ljava/lang/String;", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "Ljava/util/Set;", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Set access$getOtherPublishPermissions(Companion loginManager$Companion0) {
            return loginManager$Companion0.getOtherPublishPermissions();
        }

        public static final void access$handleLoginStatusError(Companion loginManager$Companion0, String s, String s1, String s2, LoginLogger loginLogger0, LoginStatusCallback loginStatusCallback0) {
            loginManager$Companion0.handleLoginStatusError(s, s1, s2, loginLogger0, loginStatusCallback0);
        }

        @NotNull
        public final LoginResult computeLoginResult(@NotNull Request loginClient$Request0, @NotNull AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0) {
            q.g(loginClient$Request0, "request");
            q.g(accessToken0, "newToken");
            Set set0 = loginClient$Request0.getPermissions();
            Set set1 = p.S0(p.i0(accessToken0.getPermissions()));
            if(loginClient$Request0.isRerequest()) {
                set1.retainAll(set0);
            }
            Set set2 = p.S0(p.i0(set0));
            set2.removeAll(set1);
            return new LoginResult(accessToken0, authenticationToken0, set1, set2);
        }

        @Nullable
        public final Map getExtraDataFromIntent(@Nullable Intent intent0) {
            if(intent0 == null) {
                return null;
            }
            intent0.setExtrasClassLoader(Result.class.getClassLoader());
            Result loginClient$Result0 = (Result)intent0.getParcelableExtra("com.facebook.LoginFragment:Result");
            return loginClient$Result0 == null ? null : loginClient$Result0.extraData;
        }

        @NotNull
        public LoginManager getInstance() {
            if(LoginManager.instance == null) {
                synchronized(this) {
                    LoginManager.instance = new LoginManager();
                }
            }
            LoginManager loginManager0 = LoginManager.instance;
            if(loginManager0 != null) {
                return loginManager0;
            }
            q.m("instance");
            throw null;
        }

        private final Set getOtherPublishPermissions() {
            return n.A0(new String[]{"ads_management", "create_event", "rsvp_event"});
        }

        private final void handleLoginStatusError(String s, String s1, String s2, LoginLogger loginLogger0, LoginStatusCallback loginStatusCallback0) {
            FacebookException facebookException0 = new FacebookException(s + ": " + s1);
            loginLogger0.logLoginStatusError(s2, facebookException0);
            loginStatusCallback0.onError(facebookException0);
        }

        // 去混淆评级： 低(30)
        public final boolean isPublishPermission(@Nullable String s) {
            return s != null && (v.r0(s, "publish", false) || v.r0(s, "manage", false) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(s));
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000F\b\u0086\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001F\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Lf/b;", "", "", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "Lcom/facebook/CallbackManager;", "callbackManager", "loggerID", "<init>", "(Lcom/facebook/login/LoginManager;Lcom/facebook/CallbackManager;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "permissions", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/util/Collection;)Landroid/content/Intent;", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Lcom/facebook/CallbackManager$ActivityResultParameters;", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "Ljava/lang/String;", "getLoggerID", "()Ljava/lang/String;", "setLoggerID", "(Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class FacebookLoginActivityResultContract extends f.b {
        @Nullable
        private CallbackManager callbackManager;
        @Nullable
        private String loggerID;

        public FacebookLoginActivityResultContract(@Nullable CallbackManager callbackManager0, @Nullable String s) {
            this.callbackManager = callbackManager0;
            this.loggerID = s;
        }

        public FacebookLoginActivityResultContract(CallbackManager callbackManager0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                callbackManager0 = null;
            }
            if((v & 2) != 0) {
                s = null;
            }
            this(callbackManager0, s);
        }

        @Override  // f.b
        public Intent createIntent(Context context0, Object object0) {
            return this.createIntent(context0, ((Collection)object0));
        }

        @NotNull
        public Intent createIntent(@NotNull Context context0, @NotNull Collection collection0) {
            q.g(context0, "context");
            q.g(collection0, "permissions");
            LoginConfiguration loginConfiguration0 = new LoginConfiguration(collection0, null, 2, null);
            Request loginClient$Request0 = LoginManager.this.createLoginRequestWithConfig(loginConfiguration0);
            String s = this.loggerID;
            if(s != null) {
                loginClient$Request0.setAuthId(s);
            }
            LoginManager.this.logStartLogin(context0, loginClient$Request0);
            Intent intent0 = LoginManager.this.getFacebookActivityIntent(loginClient$Request0);
            if(LoginManager.this.resolveIntent(intent0)) {
                return intent0;
            }
            FacebookException facebookException0 = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context0, Code.ERROR, null, facebookException0, false, loginClient$Request0);
            throw facebookException0;
        }

        @Nullable
        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        @Nullable
        public final String getLoggerID() {
            return this.loggerID;
        }

        @NotNull
        public ActivityResultParameters parseResult(int v, @Nullable Intent intent0) {
            LoginManager.onActivityResult$default(LoginManager.this, v, intent0, null, 4, null);
            int v1 = RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager0 = this.callbackManager;
            if(callbackManager0 != null) {
                callbackManager0.onActivityResult(v1, v, intent0);
            }
            return new ActivityResultParameters(v1, v, intent0);
        }

        @Override  // f.b
        public Object parseResult(int v, Intent intent0) {
            return this.parseResult(v, intent0);
        }

        public final void setCallbackManager(@Nullable CallbackManager callbackManager0) {
            this.callbackManager = callbackManager0;
        }

        public final void setLoggerID(@Nullable String s) {
            this.loggerID = s;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001C\u0010\u000F\u001A\u0004\u0018\u00010\u000E8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Lcom/facebook/internal/FragmentWrapper;", "fragment", "<init>", "(Lcom/facebook/internal/FragmentWrapper;)V", "Landroid/content/Intent;", "intent", "", "requestCode", "Lie/H;", "startActivityForResult", "(Landroid/content/Intent;I)V", "Lcom/facebook/internal/FragmentWrapper;", "Landroid/app/Activity;", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        @Nullable
        private final Activity activityContext;
        @NotNull
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(@NotNull FragmentWrapper fragmentWrapper0) {
            q.g(fragmentWrapper0, "fragment");
            super();
            this.fragment = fragmentWrapper0;
            this.activityContext = fragmentWrapper0.getActivity();
        }

        @Override  // com.facebook.login.StartActivityDelegate
        @Nullable
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override  // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@NotNull Intent intent0, int v) {
            q.g(intent0, "intent");
            this.fragment.startActivityForResult(intent0, v);
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class LoginLoggerHolder {
        @NotNull
        public static final LoginLoggerHolder INSTANCE;
        @Nullable
        private static LoginLogger logger;

        static {
            LoginLoggerHolder.INSTANCE = new LoginLoggerHolder();
        }

        @Nullable
        public final LoginLogger getLogger(@Nullable Context context0) {
            synchronized(this) {
                if(context0 == null) {
                    context0 = FacebookSdk.getApplicationContext();
                }
                if(context0 == null) {
                    return null;
                }
                if(LoginLoggerHolder.logger == null) {
                    LoginLoggerHolder.logger = new LoginLogger(context0, FacebookSdk.getApplicationId());
                }
                return LoginLoggerHolder.logger;
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    @NotNull
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    @NotNull
    private static final Set OTHER_PUBLISH_PERMISSIONS = null;
    @NotNull
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    @NotNull
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    @NotNull
    private static final String TAG;
    @NotNull
    private String authType;
    @NotNull
    private DefaultAudience defaultAudience;
    private static volatile LoginManager instance;
    private boolean isFamilyLogin;
    @NotNull
    private LoginBehavior loginBehavior;
    @NotNull
    private LoginTargetApp loginTargetApp;
    @Nullable
    private String messengerPageId;
    private boolean resetMessengerState;
    @NotNull
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;

    static {
        Companion loginManager$Companion0 = new Companion(null);
        LoginManager.Companion = loginManager$Companion0;
        LoginManager.OTHER_PUBLISH_PERMISSIONS = Companion.access$getOtherPublishPermissions(loginManager$Companion0);
        String s = LoginManager.class.toString();
        q.f(s, "LoginManager::class.java.toString()");
        LoginManager.TAG = s;
    }

    public LoginManager() {
        this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        this.defaultAudience = DefaultAudience.FRIENDS;
        this.authType = "rerequest";
        this.loginTargetApp = LoginTargetApp.FACEBOOK;
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.loginManager", 0);
        q.f(sharedPreferences0, "getApplicationContext().…ER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences0;
        if(FacebookSdk.hasCustomTabsPrefetching && CustomTabUtils.getChromePackage() != null) {
            CustomTabPrefetchHelper customTabPrefetchHelper0 = new CustomTabPrefetchHelper();
            d.a(FacebookSdk.getApplicationContext(), "com.android.chrome", customTabPrefetchHelper0);
            Context context0 = FacebookSdk.getApplicationContext().getApplicationContext();
            p.b b0 = new p.b(context0);
            try {
                d.a(context0, "com.iloen.melon", b0);
            }
            catch(SecurityException unused_ex) {
            }
        }
    }

    public static void c(String s, LoginLogger loginLogger0, LoginStatusCallback loginStatusCallback0, String s1, Bundle bundle0) {
        LoginManager.retrieveLoginStatusImpl$lambda$2(s, loginLogger0, loginStatusCallback0, s1, bundle0);
    }

    @NotNull
    public static final LoginResult computeLoginResult(@NotNull Request loginClient$Request0, @NotNull AccessToken accessToken0, @Nullable AuthenticationToken authenticationToken0) {
        return LoginManager.Companion.computeLoginResult(loginClient$Request0, accessToken0, authenticationToken0);
    }

    @NotNull
    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return LoginManager.createLogInActivityResultContract$default(this, null, null, 3, null);
    }

    @NotNull
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager0) {
        return LoginManager.createLogInActivityResultContract$default(this, callbackManager0, null, 2, null);
    }

    @NotNull
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@Nullable CallbackManager callbackManager0, @Nullable String s) {
        return new FacebookLoginActivityResultContract(this, callbackManager0, s);
    }

    public static FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager0, CallbackManager callbackManager0, String s, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
        }
        if((v & 1) != 0) {
            callbackManager0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        return loginManager0.createLogInActivityResultContract(callbackManager0, s);
    }

    @NotNull
    public Request createLoginRequest(@Nullable Collection collection0) {
        LoginBehavior loginBehavior0 = this.loginBehavior;
        Set set0 = collection0 == null ? null : p.T0(collection0);
        DefaultAudience defaultAudience0 = this.defaultAudience;
        String s = this.authType;
        String s1 = FacebookSdk.getApplicationId();
        q.f("b169bdcb-6a95-4ad6-a89d-6ca011b34920", "randomUUID().toString()");
        Request loginClient$Request0 = new Request(loginBehavior0, set0, defaultAudience0, s, s1, "b169bdcb-6a95-4ad6-a89d-6ca011b34920", this.loginTargetApp, null, null, null, null, 0x780, null);
        loginClient$Request0.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        loginClient$Request0.setMessengerPageId(this.messengerPageId);
        loginClient$Request0.setResetMessengerState(this.resetMessengerState);
        loginClient$Request0.setFamilyLogin(this.isFamilyLogin);
        loginClient$Request0.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return loginClient$Request0;
    }

    private final Request createLoginRequestFromResponse(GraphResponse graphResponse0) {
        AccessToken accessToken0 = graphResponse0.getRequest().getAccessToken();
        if(accessToken0 != null) {
            Set set0 = accessToken0.getPermissions();
            return set0 == null ? this.createLoginRequest(null) : this.createLoginRequest(p.i0(set0));
        }
        return this.createLoginRequest(null);
    }

    @NotNull
    public Request createLoginRequestWithConfig(@NotNull LoginConfiguration loginConfiguration0) {
        String s;
        q.g(loginConfiguration0, "loginConfig");
        CodeChallengeMethod codeChallengeMethod0 = CodeChallengeMethod.S256;
        try {
            s = PKCEUtil.generateCodeChallenge(loginConfiguration0.getCodeVerifier(), codeChallengeMethod0);
        }
        catch(FacebookException unused_ex) {
            codeChallengeMethod0 = CodeChallengeMethod.PLAIN;
            s = loginConfiguration0.getCodeVerifier();
        }
        LoginBehavior loginBehavior0 = this.loginBehavior;
        Set set0 = p.T0(loginConfiguration0.getPermissions());
        DefaultAudience defaultAudience0 = this.defaultAudience;
        String s1 = this.authType;
        String s2 = FacebookSdk.getApplicationId();
        q.f("dd67c015-e97f-4755-af80-c839e33c6ced", "randomUUID().toString()");
        Request loginClient$Request0 = new Request(loginBehavior0, set0, defaultAudience0, s1, s2, "dd67c015-e97f-4755-af80-c839e33c6ced", this.loginTargetApp, loginConfiguration0.getNonce(), loginConfiguration0.getCodeVerifier(), s, codeChallengeMethod0);
        loginClient$Request0.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        loginClient$Request0.setMessengerPageId(this.messengerPageId);
        loginClient$Request0.setResetMessengerState(this.resetMessengerState);
        loginClient$Request0.setFamilyLogin(this.isFamilyLogin);
        loginClient$Request0.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return loginClient$Request0;
    }

    @NotNull
    public Request createReauthorizeRequest() {
        HashSet hashSet0 = new HashSet();
        DefaultAudience defaultAudience0 = this.defaultAudience;
        String s = FacebookSdk.getApplicationId();
        q.f("828b0135-d7e7-45ec-89ec-d814245ec2c6", "randomUUID().toString()");
        Request loginClient$Request0 = new Request(LoginBehavior.DIALOG_ONLY, hashSet0, defaultAudience0, "reauthorize", s, "828b0135-d7e7-45ec-89ec-d814245ec2c6", this.loginTargetApp, null, null, null, null, 0x780, null);
        loginClient$Request0.setFamilyLogin(this.isFamilyLogin);
        loginClient$Request0.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return loginClient$Request0;
    }

    private final void finishLogin(AccessToken accessToken0, AuthenticationToken authenticationToken0, Request loginClient$Request0, FacebookException facebookException0, boolean z, FacebookCallback facebookCallback0) {
        if(accessToken0 != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken0);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if(authenticationToken0 != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken0);
        }
        if(facebookCallback0 != null) {
            LoginResult loginResult0 = accessToken0 == null || loginClient$Request0 == null ? null : LoginManager.Companion.computeLoginResult(loginClient$Request0, accessToken0, authenticationToken0);
            if(z || loginResult0 != null && loginResult0.getRecentlyGrantedPermissions().isEmpty()) {
                facebookCallback0.onCancel();
            }
            else {
                if(facebookException0 != null) {
                    facebookCallback0.onError(facebookException0);
                    return;
                }
                if(accessToken0 != null && loginResult0 != null) {
                    this.setExpressLoginStatus(true);
                    facebookCallback0.onSuccess(loginResult0);
                }
            }
        }
    }

    @NotNull
    public final String getAuthType() {
        return this.authType;
    }

    @NotNull
    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    @Nullable
    public static final Map getExtraDataFromIntent(@Nullable Intent intent0) {
        return LoginManager.Companion.getExtraDataFromIntent(intent0);
    }

    @NotNull
    public Intent getFacebookActivityIntent(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        Intent intent0 = new Intent();
        intent0.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent0.setAction(loginClient$Request0.getLoginBehavior().toString());
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("request", loginClient$Request0);
        intent0.putExtra("com.facebook.LoginFragment:Request", bundle0);
        return intent0;
    }

    @NotNull
    public static LoginManager getInstance() {
        return LoginManager.Companion.getInstance();
    }

    @NotNull
    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    @NotNull
    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean("express_login_allowed", true);
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public static final boolean isPublishPermission(@Nullable String s) {
        return LoginManager.Companion.isPublishPermission(s);
    }

    private final void logCompleteLogin(Context context0, Code loginClient$Result$Code0, Map map0, Exception exception0, boolean z, Request loginClient$Request0) {
        LoginLogger loginLogger0 = LoginLoggerHolder.INSTANCE.getLogger(context0);
        if(loginLogger0 == null) {
            return;
        }
        if(loginClient$Request0 == null) {
            LoginLogger.logUnexpectedError$default(loginLogger0, "fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap hashMap0 = new HashMap();
        hashMap0.put("try_login_activity", (z ? "1" : "0"));
        loginLogger0.logCompleteLogin(loginClient$Request0.getAuthId(), hashMap0, loginClient$Result$Code0, map0, exception0, (loginClient$Request0.isFamilyLogin() ? "foa_mobile_login_complete" : "fb_mobile_login_complete"));
    }

    private final void logIn(i i0, CallbackManager callbackManager0, LoginConfiguration loginConfiguration0) {
        Request loginClient$Request0 = this.createLoginRequestWithConfig(loginConfiguration0);
        this.startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(i0, callbackManager0), loginClient$Request0);
    }

    public final void logIn(@NotNull Activity activity0, @NotNull LoginConfiguration loginConfiguration0) {
        q.g(activity0, "activity");
        q.g(loginConfiguration0, "loginConfig");
        if(activity0 instanceof i) {
            Log.w(LoginManager.TAG, "You\'re calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        Request loginClient$Request0 = this.createLoginRequestWithConfig(loginConfiguration0);
        this.startLogin(new ActivityStartActivityDelegate(activity0), loginClient$Request0);
    }

    public final void logIn(@NotNull Activity activity0, @Nullable Collection collection0) {
        q.g(activity0, "activity");
        this.logIn(activity0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logIn(@NotNull Activity activity0, @Nullable Collection collection0, @Nullable String s) {
        q.g(activity0, "activity");
        Request loginClient$Request0 = this.createLoginRequestWithConfig(new LoginConfiguration(collection0, null, 2, null));
        if(s != null) {
            loginClient$Request0.setAuthId(s);
        }
        this.startLogin(new ActivityStartActivityDelegate(activity0), loginClient$Request0);
    }

    public final void logIn(@NotNull Fragment fragment0, @Nullable Collection collection0) {
        q.g(fragment0, "fragment");
        this.logIn(new FragmentWrapper(fragment0), collection0);
    }

    public final void logIn(@NotNull Fragment fragment0, @Nullable Collection collection0, @Nullable String s) {
        q.g(fragment0, "fragment");
        this.logIn(new FragmentWrapper(fragment0), collection0, s);
    }

    public final void logIn(@NotNull I i0, @Nullable Collection collection0) {
        q.g(i0, "fragment");
        this.logIn(new FragmentWrapper(i0), collection0);
    }

    public final void logIn(@NotNull I i0, @Nullable Collection collection0, @Nullable String s) {
        q.g(i0, "fragment");
        this.logIn(new FragmentWrapper(i0), collection0, s);
    }

    public final void logIn(@NotNull FragmentWrapper fragmentWrapper0, @NotNull LoginConfiguration loginConfiguration0) {
        q.g(fragmentWrapper0, "fragment");
        q.g(loginConfiguration0, "loginConfig");
        Request loginClient$Request0 = this.createLoginRequestWithConfig(loginConfiguration0);
        this.startLogin(new FragmentStartActivityDelegate(fragmentWrapper0), loginClient$Request0);
    }

    public final void logIn(@NotNull FragmentWrapper fragmentWrapper0, @Nullable Collection collection0) {
        q.g(fragmentWrapper0, "fragment");
        this.logIn(fragmentWrapper0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logIn(@NotNull FragmentWrapper fragmentWrapper0, @Nullable Collection collection0, @Nullable String s) {
        q.g(fragmentWrapper0, "fragment");
        Request loginClient$Request0 = this.createLoginRequestWithConfig(new LoginConfiguration(collection0, null, 2, null));
        if(s != null) {
            loginClient$Request0.setAuthId(s);
        }
        this.startLogin(new FragmentStartActivityDelegate(fragmentWrapper0), loginClient$Request0);
    }

    public final void logIn(@NotNull i i0, @NotNull CallbackManager callbackManager0, @NotNull Collection collection0) {
        q.g(i0, "activityResultRegistryOwner");
        q.g(callbackManager0, "callbackManager");
        q.g(collection0, "permissions");
        this.logIn(i0, callbackManager0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logIn(@NotNull i i0, @NotNull CallbackManager callbackManager0, @NotNull Collection collection0, @Nullable String s) {
        q.g(i0, "activityResultRegistryOwner");
        q.g(callbackManager0, "callbackManager");
        q.g(collection0, "permissions");
        Request loginClient$Request0 = this.createLoginRequestWithConfig(new LoginConfiguration(collection0, null, 2, null));
        if(s != null) {
            loginClient$Request0.setAuthId(s);
        }
        this.startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(i0, callbackManager0), loginClient$Request0);
    }

    public final void logInWithConfiguration(@NotNull I i0, @NotNull LoginConfiguration loginConfiguration0) {
        q.g(i0, "fragment");
        q.g(loginConfiguration0, "loginConfig");
        this.loginWithConfiguration(new FragmentWrapper(i0), loginConfiguration0);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper0, Collection collection0) {
        this.validatePublishPermissions(collection0);
        this.loginWithConfiguration(fragmentWrapper0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logInWithPublishPermissions(@NotNull Activity activity0, @Nullable Collection collection0) {
        q.g(activity0, "activity");
        this.validatePublishPermissions(collection0);
        this.loginWithConfiguration(activity0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logInWithPublishPermissions(@NotNull Fragment fragment0, @NotNull Collection collection0) {
        q.g(fragment0, "fragment");
        q.g(collection0, "permissions");
        this.logInWithPublishPermissions(new FragmentWrapper(fragment0), collection0);
    }

    public final void logInWithPublishPermissions(@NotNull I i0, @NotNull CallbackManager callbackManager0, @NotNull Collection collection0) {
        q.g(i0, "fragment");
        q.g(callbackManager0, "callbackManager");
        q.g(collection0, "permissions");
        FragmentActivity fragmentActivity0 = i0.getActivity();
        if(fragmentActivity0 == null) {
            throw new FacebookException("Cannot obtain activity context on the fragment " + i0);
        }
        this.logInWithPublishPermissions(fragmentActivity0, callbackManager0, collection0);
    }

    @ie.d
    public final void logInWithPublishPermissions(@NotNull I i0, @NotNull Collection collection0) {
        q.g(i0, "fragment");
        q.g(collection0, "permissions");
        this.logInWithPublishPermissions(new FragmentWrapper(i0), collection0);
    }

    public final void logInWithPublishPermissions(@NotNull i i0, @NotNull CallbackManager callbackManager0, @NotNull Collection collection0) {
        q.g(i0, "activityResultRegistryOwner");
        q.g(callbackManager0, "callbackManager");
        q.g(collection0, "permissions");
        this.validatePublishPermissions(collection0);
        this.logIn(i0, callbackManager0, new LoginConfiguration(collection0, null, 2, null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper0, Collection collection0) {
        this.validateReadPermissions(collection0);
        this.logIn(fragmentWrapper0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logInWithReadPermissions(@NotNull Activity activity0, @Nullable Collection collection0) {
        q.g(activity0, "activity");
        this.validateReadPermissions(collection0);
        this.logIn(activity0, new LoginConfiguration(collection0, null, 2, null));
    }

    public final void logInWithReadPermissions(@NotNull Fragment fragment0, @NotNull Collection collection0) {
        q.g(fragment0, "fragment");
        q.g(collection0, "permissions");
        this.logInWithReadPermissions(new FragmentWrapper(fragment0), collection0);
    }

    public final void logInWithReadPermissions(@NotNull I i0, @NotNull CallbackManager callbackManager0, @NotNull Collection collection0) {
        q.g(i0, "fragment");
        q.g(callbackManager0, "callbackManager");
        q.g(collection0, "permissions");
        FragmentActivity fragmentActivity0 = i0.getActivity();
        if(fragmentActivity0 == null) {
            throw new FacebookException("Cannot obtain activity context on the fragment " + i0);
        }
        this.logInWithReadPermissions(fragmentActivity0, callbackManager0, collection0);
    }

    @ie.d
    public final void logInWithReadPermissions(@NotNull I i0, @NotNull Collection collection0) {
        q.g(i0, "fragment");
        q.g(collection0, "permissions");
        this.logInWithReadPermissions(new FragmentWrapper(i0), collection0);
    }

    public final void logInWithReadPermissions(@NotNull i i0, @NotNull CallbackManager callbackManager0, @NotNull Collection collection0) {
        q.g(i0, "activityResultRegistryOwner");
        q.g(callbackManager0, "callbackManager");
        q.g(collection0, "permissions");
        this.validateReadPermissions(collection0);
        this.logIn(i0, callbackManager0, new LoginConfiguration(collection0, null, 2, null));
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken(null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken(null);
        Profile.Companion.setCurrentProfile(null);
        this.setExpressLoginStatus(false);
    }

    private final void logStartLogin(Context context0, Request loginClient$Request0) {
        LoginLogger loginLogger0 = LoginLoggerHolder.INSTANCE.getLogger(context0);
        if(loginLogger0 != null && loginClient$Request0 != null) {
            loginLogger0.logStartLogin(loginClient$Request0, (loginClient$Request0.isFamilyLogin() ? "foa_mobile_login_start" : "fb_mobile_login_start"));
        }
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper0, LoginConfiguration loginConfiguration0) {
        this.logIn(fragmentWrapper0, loginConfiguration0);
    }

    public final void loginWithConfiguration(@NotNull Activity activity0, @NotNull LoginConfiguration loginConfiguration0) {
        q.g(activity0, "activity");
        q.g(loginConfiguration0, "loginConfig");
        this.logIn(activity0, loginConfiguration0);
    }

    public final boolean onActivityResult(int v, @Nullable Intent intent0) {
        return LoginManager.onActivityResult$default(this, v, intent0, null, 4, null);
    }

    public boolean onActivityResult(int v, @Nullable Intent intent0, @Nullable FacebookCallback facebookCallback0) {
        Code loginClient$Result$Code2;
        AuthenticationToken authenticationToken1;
        boolean z1;
        Request loginClient$Request1;
        Map map0;
        AuthenticationToken authenticationToken0;
        AccessToken accessToken0;
        Code loginClient$Result$Code0 = Code.ERROR;
        FacebookException facebookException0 = null;
        boolean z = false;
        if(intent0 != null) {
            intent0.setExtrasClassLoader(Result.class.getClassLoader());
            Result loginClient$Result0 = (Result)intent0.getParcelableExtra("com.facebook.LoginFragment:Result");
            if(loginClient$Result0 == null) {
                goto label_38;
            }
            else {
                Request loginClient$Request0 = loginClient$Result0.request;
                Code loginClient$Result$Code1 = loginClient$Result0.code;
                switch(v) {
                    case -1: {
                        if(loginClient$Result$Code1 == Code.SUCCESS) {
                            accessToken0 = loginClient$Result0.token;
                            authenticationToken0 = loginClient$Result0.authenticationToken;
                        }
                        else {
                            authenticationToken0 = null;
                            facebookException0 = new FacebookAuthorizationException(loginClient$Result0.errorMessage);
                            accessToken0 = null;
                        }
                        break;
                    }
                    case 0: {
                        z = true;
                        accessToken0 = null;
                        authenticationToken0 = null;
                        break;
                    }
                    default: {
                        accessToken0 = null;
                        authenticationToken0 = null;
                    }
                }
                map0 = loginClient$Result0.loggingExtras;
                loginClient$Request1 = loginClient$Request0;
                z1 = z;
                authenticationToken1 = authenticationToken0;
                loginClient$Result$Code2 = loginClient$Result$Code1;
            }
        }
        else if(v == 0) {
            loginClient$Result$Code2 = Code.CANCEL;
            z1 = true;
            accessToken0 = null;
            authenticationToken1 = null;
            map0 = null;
            loginClient$Request1 = null;
        }
        else {
        label_38:
            loginClient$Result$Code2 = loginClient$Result$Code0;
            accessToken0 = null;
            authenticationToken1 = null;
            map0 = null;
            loginClient$Request1 = null;
            z1 = false;
        }
        if(facebookException0 == null && accessToken0 == null && !z1) {
            facebookException0 = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        this.logCompleteLogin(null, loginClient$Result$Code2, map0, facebookException0, true, loginClient$Request1);
        this.finishLogin(accessToken0, authenticationToken1, loginClient$Request1, facebookException0, z1, facebookCallback0);
        return true;
    }

    public static boolean onActivityResult$default(LoginManager loginManager0, int v, Intent intent0, FacebookCallback facebookCallback0, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
        }
        if((v1 & 4) != 0) {
            facebookCallback0 = null;
        }
        return loginManager0.onActivityResult(v, intent0, facebookCallback0);
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper0) {
        Request loginClient$Request0 = this.createReauthorizeRequest();
        this.startLogin(new FragmentStartActivityDelegate(fragmentWrapper0), loginClient$Request0);
    }

    public final void reauthorizeDataAccess(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        Request loginClient$Request0 = this.createReauthorizeRequest();
        this.startLogin(new ActivityStartActivityDelegate(activity0), loginClient$Request0);
    }

    public final void reauthorizeDataAccess(@NotNull I i0) {
        q.g(i0, "fragment");
        this.reauthorizeDataAccess(new FragmentWrapper(i0));
    }

    public final void registerCallback(@Nullable CallbackManager callbackManager0, @Nullable FacebookCallback facebookCallback0) {
        if(!(callbackManager0 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl)callbackManager0).registerCallback(RequestCodeOffset.Login.toRequestCode(), (int v, Intent intent0) -> {
            q.g(this, "this$0");
            return this.onActivityResult(v, intent0, facebookCallback0);
        });
    }

    // 检测为 Lambda 实现
    private static final boolean registerCallback$lambda$0(LoginManager loginManager0, FacebookCallback facebookCallback0, int v, Intent intent0) [...]

    private final void resolveError(FragmentWrapper fragmentWrapper0, GraphResponse graphResponse0) {
        this.startLogin(new FragmentStartActivityDelegate(fragmentWrapper0), this.createLoginRequestFromResponse(graphResponse0));
    }

    public final void resolveError(@NotNull Activity activity0, @NotNull GraphResponse graphResponse0) {
        q.g(activity0, "activity");
        q.g(graphResponse0, "response");
        this.startLogin(new ActivityStartActivityDelegate(activity0), this.createLoginRequestFromResponse(graphResponse0));
    }

    public final void resolveError(@NotNull Fragment fragment0, @NotNull GraphResponse graphResponse0) {
        q.g(fragment0, "fragment");
        q.g(graphResponse0, "response");
        this.resolveError(new FragmentWrapper(fragment0), graphResponse0);
    }

    public final void resolveError(@NotNull I i0, @NotNull CallbackManager callbackManager0, @NotNull GraphResponse graphResponse0) {
        q.g(i0, "fragment");
        q.g(callbackManager0, "callbackManager");
        q.g(graphResponse0, "response");
        FragmentActivity fragmentActivity0 = i0.getActivity();
        if(fragmentActivity0 == null) {
            throw new FacebookException("Cannot obtain activity context on the fragment " + i0);
        }
        this.resolveError(fragmentActivity0, callbackManager0, graphResponse0);
    }

    @ie.d
    public final void resolveError(@NotNull I i0, @NotNull GraphResponse graphResponse0) {
        q.g(i0, "fragment");
        q.g(graphResponse0, "response");
        this.resolveError(new FragmentWrapper(i0), graphResponse0);
    }

    public final void resolveError(@NotNull i i0, @NotNull CallbackManager callbackManager0, @NotNull GraphResponse graphResponse0) {
        q.g(i0, "activityResultRegistryOwner");
        q.g(callbackManager0, "callbackManager");
        q.g(graphResponse0, "response");
        this.startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(i0, callbackManager0), this.createLoginRequestFromResponse(graphResponse0));
    }

    private final boolean resolveIntent(Intent intent0) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent0, 0) != null;
    }

    public final void retrieveLoginStatus(@NotNull Context context0, long v, @NotNull LoginStatusCallback loginStatusCallback0) {
        q.g(context0, "context");
        q.g(loginStatusCallback0, "responseCallback");
        this.retrieveLoginStatusImpl(context0, loginStatusCallback0, v);
    }

    public final void retrieveLoginStatus(@NotNull Context context0, @NotNull LoginStatusCallback loginStatusCallback0) {
        q.g(context0, "context");
        q.g(loginStatusCallback0, "responseCallback");
        this.retrieveLoginStatus(context0, 5000L, loginStatusCallback0);
    }

    private final void retrieveLoginStatusImpl(Context context0, LoginStatusCallback loginStatusCallback0, long v) {
        String s = FacebookSdk.getApplicationId();
        q.f("3b8657fb-c0fe-453d-9e62-2b97b8d455f7", "randomUUID().toString()");
        LoginLogger loginLogger0 = new LoginLogger((context0 == null ? FacebookSdk.getApplicationContext() : context0), s);
        if(!this.isExpressLoginAllowed()) {
            loginLogger0.logLoginStatusFailure("3b8657fb-c0fe-453d-9e62-2b97b8d455f7");
            loginStatusCallback0.onFailure();
            return;
        }
        String s1 = FacebookSdk.getGraphApiVersion();
        LoginStatusClient loginStatusClient0 = LoginStatusClient.Companion.newInstance$facebook_common_release(context0, s, "3b8657fb-c0fe-453d-9e62-2b97b8d455f7", s1, v, null);
        loginStatusClient0.setCompletedListener(new G0("3b8657fb-c0fe-453d-9e62-2b97b8d455f7", loginLogger0, loginStatusCallback0, s));
        loginLogger0.logLoginStatusStart("3b8657fb-c0fe-453d-9e62-2b97b8d455f7");
        if(!loginStatusClient0.start()) {
            loginLogger0.logLoginStatusFailure("3b8657fb-c0fe-453d-9e62-2b97b8d455f7");
            loginStatusCallback0.onFailure();
        }
    }

    private static final void retrieveLoginStatusImpl$lambda$2(String s, LoginLogger loginLogger0, LoginStatusCallback loginStatusCallback0, String s1, Bundle bundle0) {
        q.g(s, "$loggerRef");
        q.g(loginLogger0, "$logger");
        q.g(loginStatusCallback0, "$responseCallback");
        q.g(s1, "$applicationId");
        if(bundle0 != null) {
            String s2 = bundle0.getString("com.facebook.platform.status.ERROR_TYPE");
            String s3 = bundle0.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
            if(s2 != null) {
                Companion.access$handleLoginStatusError(LoginManager.Companion, s2, s3, s, loginLogger0, loginStatusCallback0);
                return;
            }
            String s4 = bundle0.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            Date date0 = Utility.getBundleLongAsDate(bundle0, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
            ArrayList arrayList0 = bundle0.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            String s5 = bundle0.getString("signed request");
            String s6 = bundle0.getString("graph_domain");
            Date date1 = Utility.getBundleLongAsDate(bundle0, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
            String s7 = s5 == null || s5.length() == 0 ? null : LoginMethodHandler.Companion.getUserIDFromSignedRequest(s5);
            if(s4 != null && s4.length() != 0 && arrayList0 != null && !arrayList0.isEmpty() && s7 != null && s7.length() != 0) {
                AccessToken accessToken0 = new AccessToken(s4, s1, s7, arrayList0, null, null, null, date0, null, date1, s6);
                AccessToken.Companion.setCurrentAccessToken(accessToken0);
                Profile.Companion.fetchProfileForCurrentAccessToken();
                loginLogger0.logLoginStatusSuccess(s);
                loginStatusCallback0.onCompleted(accessToken0);
                return;
            }
            loginLogger0.logLoginStatusFailure(s);
            loginStatusCallback0.onFailure();
            return;
        }
        loginLogger0.logLoginStatusFailure(s);
        loginStatusCallback0.onFailure();
    }

    @NotNull
    public final LoginManager setAuthType(@NotNull String s) {
        q.g(s, "authType");
        this.authType = s;
        return this;
    }

    @NotNull
    public final LoginManager setDefaultAudience(@NotNull DefaultAudience defaultAudience0) {
        q.g(defaultAudience0, "defaultAudience");
        this.defaultAudience = defaultAudience0;
        return this;
    }

    private final void setExpressLoginStatus(boolean z) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.sharedPreferences.edit();
        sharedPreferences$Editor0.putBoolean("express_login_allowed", z);
        sharedPreferences$Editor0.apply();
    }

    @NotNull
    public final LoginManager setFamilyLogin(boolean z) {
        this.isFamilyLogin = z;
        return this;
    }

    @NotNull
    public final LoginManager setLoginBehavior(@NotNull LoginBehavior loginBehavior0) {
        q.g(loginBehavior0, "loginBehavior");
        this.loginBehavior = loginBehavior0;
        return this;
    }

    @NotNull
    public final LoginManager setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp0) {
        q.g(loginTargetApp0, "targetApp");
        this.loginTargetApp = loginTargetApp0;
        return this;
    }

    @NotNull
    public final LoginManager setMessengerPageId(@Nullable String s) {
        this.messengerPageId = s;
        return this;
    }

    @NotNull
    public final LoginManager setResetMessengerState(boolean z) {
        this.resetMessengerState = z;
        return this;
    }

    @NotNull
    public final LoginManager setShouldSkipAccountDeduplication(boolean z) {
        this.shouldSkipAccountDeduplication = z;
        return this;
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate0, Request loginClient$Request0) {
        this.logStartLogin(startActivityDelegate0.getActivityContext(), loginClient$Request0);
        int v = RequestCodeOffset.Login.toRequestCode();
        f f0 = (int v, Intent intent0) -> {
            q.g(this, "this$0");
            return LoginManager.onActivityResult$default(this, v, intent0, null, 4, null);
        };
        CallbackManagerImpl.Companion.registerStaticCallback(v, f0);
        if(this.tryFacebookActivity(startActivityDelegate0, loginClient$Request0)) {
            return;
        }
        FacebookException facebookException0 = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        this.logCompleteLogin(startActivityDelegate0.getActivityContext(), Code.ERROR, null, facebookException0, false, loginClient$Request0);
        throw facebookException0;
    }

    // 检测为 Lambda 实现
    private static final boolean startLogin$lambda$1(LoginManager loginManager0, int v, Intent intent0) [...]

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate0, Request loginClient$Request0) {
        Intent intent0 = this.getFacebookActivityIntent(loginClient$Request0);
        if(!this.resolveIntent(intent0)) {
            return false;
        }
        try {
            startActivityDelegate0.startActivityForResult(intent0, LoginClient.Companion.getLoginRequestCode());
            return true;
        }
        catch(ActivityNotFoundException unused_ex) {
            return false;
        }
    }

    public final void unregisterCallback(@Nullable CallbackManager callbackManager0) {
        if(!(callbackManager0 instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl)callbackManager0).unregisterCallback(RequestCodeOffset.Login.toRequestCode());
    }

    private final void validatePublishPermissions(Collection collection0) {
        if(collection0 != null) {
            for(Object object0: collection0) {
                String s = (String)object0;
                if(!LoginManager.Companion.isPublishPermission(s)) {
                    throw new FacebookException("Cannot pass a read permission (" + s + ") to a request for publish authorization");
                }
                if(false) {
                    break;
                }
            }
        }
    }

    private final void validateReadPermissions(Collection collection0) {
        if(collection0 != null) {
            for(Object object0: collection0) {
                String s = (String)object0;
                if(LoginManager.Companion.isPublishPermission(s)) {
                    throw new FacebookException("Cannot pass a publish or manage permission (" + s + ") to a request for read authorization");
                }
                if(false) {
                    break;
                }
            }
        }
    }
}

