package com.facebook.login.widget;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.fragment.app.I;
import b.l;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager.ActivityResultParameters;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R.color;
import com.facebook.common.R.drawable;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager.FacebookLoginActivityResultContract;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.R.string;
import com.facebook.login.R.style;
import com.facebook.login.R.styleable;
import d3.g;
import e.b;
import e.i;
import ie.d;
import ie.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import je.n;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u00DC\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 \u00C1\u00012\u00020\u0001:\b\u00C1\u0001\u00C2\u0001\u00C3\u0001\u00C4\u0001B;\b\u0004\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\u0006\u0010\n\u001A\u00020\t\u0012\u0006\u0010\u000B\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\f\u0010\u000EB\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\f\u0010\u000FB#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001A\u00020\u0006\u00A2\u0006\u0004\b\f\u0010\u0011J\u001D\u0010\u0015\u001A\u00020\u00142\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\t0\u0012H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u0015\u001A\u00020\u00142\u0016\u0010\u0013\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0017\"\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0018J%\u0010\u0019\u001A\u00020\u00142\u0016\u0010\u0013\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0017\"\u0004\u0018\u00010\t\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u001D\u0010\u001A\u001A\u00020\u00142\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\t0\u0012H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0016J\'\u0010\u001A\u001A\u00020\u00142\u0016\u0010\u0013\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0017\"\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0018J\r\u0010\u001B\u001A\u00020\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\r\u0010\u001D\u001A\u00020\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001CJ#\u0010#\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u001E2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020!0 \u00A2\u0006\u0004\b#\u0010$J\u0015\u0010%\u001A\u00020\u00142\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0014H\u0015\u00A2\u0006\u0004\b\'\u0010\u001CJ\u0017\u0010*\u001A\u00020\u00142\u0006\u0010)\u001A\u00020(H\u0015\u00A2\u0006\u0004\b*\u0010+J7\u00102\u001A\u00020\u00142\u0006\u0010-\u001A\u00020,2\u0006\u0010.\u001A\u00020\u00062\u0006\u0010/\u001A\u00020\u00062\u0006\u00100\u001A\u00020\u00062\u0006\u00101\u001A\u00020\u0006H\u0015\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\u0014H\u0015\u00A2\u0006\u0004\b4\u0010\u001CJ\u001F\u00108\u001A\u00020\u00142\u0006\u00106\u001A\u0002052\u0006\u00107\u001A\u00020\u0006H\u0015\u00A2\u0006\u0004\b8\u00109J1\u0010:\u001A\u00020\u00142\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0015\u00A2\u0006\u0004\b:\u0010;J1\u0010<\u001A\u00020\u00142\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006H\u0005\u00A2\u0006\u0004\b<\u0010;J\u001F\u0010?\u001A\u00020\u00142\u0006\u0010=\u001A\u00020\u00062\u0006\u0010>\u001A\u00020\u0006H\u0015\u00A2\u0006\u0004\b?\u0010@J\u0017\u0010A\u001A\u00020\u00062\u0006\u0010=\u001A\u00020\u0006H\u0005\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010C\u001A\u00020\u0014H\u0005\u00A2\u0006\u0004\bC\u0010\u001CJ\u000F\u0010D\u001A\u00020\u0014H\u0005\u00A2\u0006\u0004\bD\u0010\u001CJ\u000F\u0010E\u001A\u00020\u0014H\u0005\u00A2\u0006\u0004\bE\u0010\u001CJ\u000F\u0010F\u001A\u00020\u0014H\u0005\u00A2\u0006\u0004\bF\u0010\u001CJ\u0019\u0010I\u001A\u00020\u00142\b\u0010H\u001A\u0004\u0018\u00010GH\u0003\u00A2\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001A\u00020\u00142\u0006\u0010K\u001A\u00020\tH\u0003\u00A2\u0006\u0004\bL\u0010MJ\u000F\u0010N\u001A\u00020\u0014H\u0003\u00A2\u0006\u0004\bN\u0010\u001CJ\u0017\u0010P\u001A\u00020\u00062\u0006\u0010O\u001A\u00020\tH\u0003\u00A2\u0006\u0004\bP\u0010QR\u0016\u0010R\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR.\u0010U\u001A\u0004\u0018\u00010\t2\b\u0010T\u001A\u0004\u0018\u00010\t8\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bW\u0010X\"\u0004\bY\u0010MR.\u0010Z\u001A\u0004\u0018\u00010\t2\b\u0010T\u001A\u0004\u0018\u00010\t8\u0006@FX\u0086\u000E\u00A2\u0006\u0012\n\u0004\bZ\u0010V\u001A\u0004\b[\u0010X\"\u0004\b\\\u0010MR\u001A\u0010^\u001A\u00020]8\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b^\u0010_\u001A\u0004\b`\u0010aR\u0016\u0010b\u001A\u00020,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bb\u0010SR\"\u0010d\u001A\u00020c8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bd\u0010e\u001A\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010k\u001A\u00020j8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bk\u0010l\u001A\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010r\u001A\u00020q8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\br\u0010s\u001A\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0018\u0010y\u001A\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010|\u001A\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b|\u0010}R/\u0010\u0080\u0001\u001A\b\u0012\u0004\u0012\u00020\u007F0~8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001A\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001C\u0010\u0087\u0001\u001A\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u0089\u0001\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008A\u0001R\u001A\u0010\u008B\u0001\u001A\u00020\t8\u0006\u00A2\u0006\u000E\n\u0005\b\u008B\u0001\u0010V\u001A\u0005\b\u008C\u0001\u0010XR,\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\t\u0010\u008D\u0001\u001A\u0004\u0018\u00010\u001E8\u0006@BX\u0086\u000E\u00A2\u0006\u000F\n\u0005\b\u001F\u0010\u008E\u0001\u001A\u0006\b\u008F\u0001\u0010\u0090\u0001R)\u0010\u0093\u0001\u001A\u0012\u0012\u000B\u0012\t\u0012\u0004\u0012\u00020\t0\u0092\u0001\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R+\u0010\u009A\u0001\u001A\u00030\u0095\u00012\u0007\u0010T\u001A\u00030\u0095\u00018F@FX\u0086\u000E\u00A2\u0006\u0010\u001A\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R+\u0010\u00A0\u0001\u001A\u00030\u009B\u00012\u0007\u0010T\u001A\u00030\u009B\u00018F@FX\u0086\u000E\u00A2\u0006\u0010\u001A\u0006\b\u009C\u0001\u0010\u009D\u0001\"\u0006\b\u009E\u0001\u0010\u009F\u0001R+\u0010\u00A6\u0001\u001A\u00030\u00A1\u00012\u0007\u0010T\u001A\u00030\u00A1\u00018F@FX\u0086\u000E\u00A2\u0006\u0010\u001A\u0006\b\u00A2\u0001\u0010\u00A3\u0001\"\u0006\b\u00A4\u0001\u0010\u00A5\u0001R\'\u0010\u00A9\u0001\u001A\u00020\t2\u0006\u0010T\u001A\u00020\t8F@FX\u0086\u000E\u00A2\u0006\u000E\u001A\u0005\b\u00A7\u0001\u0010X\"\u0005\b\u00A8\u0001\u0010MR+\u0010\u00AC\u0001\u001A\u0004\u0018\u00010\t2\b\u0010T\u001A\u0004\u0018\u00010\t8F@FX\u0086\u000E\u00A2\u0006\u000E\u001A\u0005\b\u00AA\u0001\u0010X\"\u0005\b\u00AB\u0001\u0010MR)\u0010\u00B1\u0001\u001A\u00020,2\u0006\u0010T\u001A\u00020,8F@FX\u0086\u000E\u00A2\u0006\u0010\u001A\u0006\b\u00AD\u0001\u0010\u00AE\u0001\"\u0006\b\u00AF\u0001\u0010\u00B0\u0001R\u0014\u0010\u00B3\u0001\u001A\u00020,8F\u00A2\u0006\b\u001A\u0006\b\u00B2\u0001\u0010\u00AE\u0001R\u0017\u0010\u00B6\u0001\u001A\u00020\u00068EX\u0084\u0004\u00A2\u0006\b\u001A\u0006\b\u00B4\u0001\u0010\u00B5\u0001R2\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\t0\u00122\f\u0010T\u001A\b\u0012\u0004\u0012\u00020\t0\u00128F@FX\u0086\u000E\u00A2\u0006\u000E\u001A\u0006\b\u00B7\u0001\u0010\u00B8\u0001\"\u0004\b\u0019\u0010\u0016R\u001C\u0010\u00BC\u0001\u001A\u00070\u00B9\u0001R\u00020\u00008TX\u0094\u0004\u00A2\u0006\b\u001A\u0006\b\u00BA\u0001\u0010\u00BB\u0001R\u0017\u0010\u00BE\u0001\u001A\u00020\u00068TX\u0094\u0004\u00A2\u0006\b\u001A\u0006\b\u00BD\u0001\u0010\u00B5\u0001R\u0017\u0010\u00C0\u0001\u001A\u00020\u00068UX\u0094\u0004\u00A2\u0006\b\u001A\u0006\b\u00BF\u0001\u0010\u00B5\u0001\u00A8\u0006\u00C5\u0001"}, d2 = {"Lcom/facebook/login/widget/LoginButton;", "Lcom/facebook/FacebookButtonBase;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "", "analyticsButtonCreatedEventName", "analyticsButtonTappedEventName", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "permissions", "Lie/H;", "setReadPermissions", "(Ljava/util/List;)V", "", "([Ljava/lang/String;)V", "setPermissions", "setPublishPermissions", "clearPermissions", "()V", "dismissToolTip", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "callback", "registerCallback", "(Lcom/facebook/CallbackManager;Lcom/facebook/FacebookCallback;)V", "unregisterCallback", "(Lcom/facebook/CallbackManager;)V", "onAttachedToWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "configureButton", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "parseLoginButtonAttributes", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "getLoginButtonWidth", "(I)I", "setButtonText", "setButtonIcon", "setButtonRadius", "setButtonTransparency", "Lcom/facebook/internal/FetchedAppSettings;", "settings", "showToolTipPerSettings", "(Lcom/facebook/internal/FetchedAppSettings;)V", "toolTipString", "displayToolTip", "(Ljava/lang/String;)V", "checkToolTipSettings", "text", "measureButtonWidth", "(Ljava/lang/String;)I", "confirmLogout", "Z", "value", "loginText", "Ljava/lang/String;", "getLoginText", "()Ljava/lang/String;", "setLoginText", "logoutText", "getLogoutText", "setLogoutText", "Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "properties", "Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "getProperties", "()Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "toolTipChecked", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "toolTipStyle", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "getToolTipStyle", "()Lcom/facebook/login/widget/ToolTipPopup$Style;", "setToolTipStyle", "(Lcom/facebook/login/widget/ToolTipPopup$Style;)V", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "toolTipMode", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getToolTipMode", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "setToolTipMode", "(Lcom/facebook/login/widget/LoginButton$ToolTipMode;)V", "", "toolTipDisplayTime", "J", "getToolTipDisplayTime", "()J", "setToolTipDisplayTime", "(J)V", "Lcom/facebook/login/widget/ToolTipPopup;", "toolTipPopup", "Lcom/facebook/login/widget/ToolTipPopup;", "Lcom/facebook/AccessTokenTracker;", "accessTokenTracker", "Lcom/facebook/AccessTokenTracker;", "Lie/j;", "Lcom/facebook/login/LoginManager;", "loginManagerLazy", "Lie/j;", "getLoginManagerLazy", "()Lie/j;", "setLoginManagerLazy", "(Lie/j;)V", "", "customButtonRadius", "Ljava/lang/Float;", "customButtonTransparency", "I", "loggerID", "getLoggerID", "<set-?>", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "Le/b;", "", "androidXLoginCaller", "Le/b;", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "defaultAudience", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginBehavior", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "loginTargetApp", "getAuthType", "setAuthType", "authType", "getMessengerPageId", "setMessengerPageId", "messengerPageId", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "resetMessengerState", "getShouldSkipAccountDeduplication", "shouldSkipAccountDeduplication", "getLoginButtonContinueLabel", "()I", "loginButtonContinueLabel", "getPermissions", "()Ljava/util/List;", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "getNewLoginClickListener", "()Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "newLoginClickListener", "getDefaultStyleResource", "defaultStyleResource", "getDefaultRequestCode", "defaultRequestCode", "Companion", "LoginButtonProperties", "LoginClickListener", "ToolTipMode", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class LoginButton extends FacebookButtonBase {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/login/widget/LoginButton$Companion;", "", "()V", "MAX_BUTTON_TRANSPARENCY", "", "MIN_BUTTON_TRANSPARENCY", "TAG", "", "kotlin.jvm.PlatformType", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u000E\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR(\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001A\u00020\u00158\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR\"\u0010\u001C\u001A\u00020\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010!R\"\u0010#\u001A\u00020\"8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R*\u0010+\u001A\u00020)2\u0006\u0010*\u001A\u00020)8\u0006@DX\u0086\u000E¢\u0006\u0012\n\u0004\b+\u0010,\u001A\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b1\u0010\u001D\u001A\u0004\b2\u0010\u001F\"\u0004\b3\u0010!R\"\u00104\u001A\u00020)8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b4\u0010,\u001A\u0004\b5\u0010.\"\u0004\b6\u00100¨\u00067"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "", "<init>", "()V", "Lie/H;", "clearPermissions", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "", "", "permissions", "Ljava/util/List;", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "authType", "Ljava/lang/String;", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "", "<set-?>", "shouldSkipAccountDeduplication", "Z", "getShouldSkipAccountDeduplication", "()Z", "setShouldSkipAccountDeduplication", "(Z)V", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "resetMessengerState", "getResetMessengerState", "setResetMessengerState", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static class LoginButtonProperties {
        @NotNull
        private String authType;
        @NotNull
        private DefaultAudience defaultAudience;
        @NotNull
        private LoginBehavior loginBehavior;
        @NotNull
        private LoginTargetApp loginTargetApp;
        @Nullable
        private String messengerPageId;
        @NotNull
        private List permissions;
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;

        public LoginButtonProperties() {
            this.defaultAudience = DefaultAudience.FRIENDS;
            this.permissions = w.a;
            this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
            this.authType = "rerequest";
            this.loginTargetApp = LoginTargetApp.FACEBOOK;
        }

        public final void clearPermissions() {
            this.permissions = w.a;
        }

        @NotNull
        public final String getAuthType() [...] // 潜在的解密器

        @NotNull
        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        @NotNull
        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        @NotNull
        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        @Nullable
        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        @NotNull
        public final List getPermissions() {
            return this.permissions;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public final void setAuthType(@NotNull String s) {
            q.g(s, "<set-?>");
            this.authType = s;
        }

        public final void setDefaultAudience(@NotNull DefaultAudience defaultAudience0) {
            q.g(defaultAudience0, "<set-?>");
            this.defaultAudience = defaultAudience0;
        }

        public final void setLoginBehavior(@NotNull LoginBehavior loginBehavior0) {
            q.g(loginBehavior0, "<set-?>");
            this.loginBehavior = loginBehavior0;
        }

        public final void setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp0) {
            q.g(loginTargetApp0, "<set-?>");
            this.loginTargetApp = loginTargetApp0;
        }

        public final void setMessengerPageId(@Nullable String s) {
            this.messengerPageId = s;
        }

        public final void setPermissions(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.permissions = list0;
        }

        public final void setResetMessengerState(boolean z) {
            this.resetMessengerState = z;
        }

        public final void setShouldSkipAccountDeduplication(boolean z) {
            this.shouldSkipAccountDeduplication = z;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0095\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000BH\u0004¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001A\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "Landroid/view/View$OnClickListener;", "<init>", "(Lcom/facebook/login/widget/LoginButton;)V", "Landroid/view/View;", "v", "Lie/H;", "onClick", "(Landroid/view/View;)V", "performLogin", "()V", "Landroid/content/Context;", "context", "performLogout", "(Landroid/content/Context;)V", "Lcom/facebook/login/LoginManager;", "getLoginManager", "()Lcom/facebook/login/LoginManager;", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "loginTargetApp", "", "isFamilyLogin", "()Z", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public class LoginClickListener implements View.OnClickListener {
        public static void a(LoginManager loginManager0, DialogInterface dialogInterface0, int v) {
            LoginClickListener.performLogout$lambda$2(loginManager0, dialogInterface0, v);
        }

        @NotNull
        public LoginManager getLoginManager() {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager loginManager0 = LoginManager.Companion.getInstance();
                loginManager0.setDefaultAudience(LoginButton.this.getDefaultAudience());
                loginManager0.setLoginBehavior(LoginButton.this.getLoginBehavior());
                loginManager0.setLoginTargetApp(this.getLoginTargetApp());
                loginManager0.setAuthType(LoginButton.this.getAuthType());
                loginManager0.setFamilyLogin(this.isFamilyLogin());
                loginManager0.setShouldSkipAccountDeduplication(LoginButton.this.getShouldSkipAccountDeduplication());
                loginManager0.setMessengerPageId(LoginButton.this.getMessengerPageId());
                loginManager0.setResetMessengerState(LoginButton.this.getResetMessengerState());
                return loginManager0;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
                return null;
            }
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final LoginTargetApp getLoginTargetApp() {
            return CrashShieldHandler.isObjectCrashing(this) ? null : LoginTargetApp.FACEBOOK;
        }

        public final boolean isFamilyLogin() {
            CrashShieldHandler.isObjectCrashing(this);
            return false;
        }

        @Override  // android.view.View$OnClickListener
        public void onClick(@NotNull View view0) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                q.g(view0, "v");
                LoginButton.this.callExternalOnClickListener(view0);
                AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
                boolean z = AccessToken.Companion.isCurrentAccessTokenActive();
                if(z) {
                    Context context0 = LoginButton.this.getContext();
                    q.f(context0, "context");
                    this.performLogout(context0);
                }
                else {
                    this.performLogin();
                }
                InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(LoginButton.this.getContext());
                Bundle bundle0 = new Bundle();
                bundle0.putInt("logging_in", (accessToken0 == null ? 1 : 0));
                bundle0.putInt("access_token_expired", ((int)z));
                internalAppEventsLogger0.logEventImplicitly("fb_login_view_usage", bundle0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }

        public final void performLogin() {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            else {
                try {
                    LoginManager loginManager0 = this.getLoginManager();
                    b b0 = LoginButton.this.androidXLoginCaller;
                    if(b0 != null) {
                        f.b b1 = b0.a();
                        q.e(b1, "null cannot be cast to non-null type com.facebook.login.LoginManager.FacebookLoginActivityResultContract");
                        CallbackManager callbackManager0 = LoginButton.this.getCallbackManager();
                        if(callbackManager0 == null) {
                            callbackManager0 = new CallbackManagerImpl();
                        }
                        ((FacebookLoginActivityResultContract)b1).setCallbackManager(callbackManager0);
                        b0.b(LoginButton.this.getProperties().getPermissions());
                        return;
                    }
                    if(LoginButton.this.getFragment() == null) {
                        if(LoginButton.this.getNativeFragment() == null) {
                            loginManager0.logIn(LoginButton.this.getActivity(), LoginButton.this.getProperties().getPermissions(), LoginButton.this.getLoggerID());
                            return;
                        }
                        Fragment fragment0 = LoginButton.this.getNativeFragment();
                        if(fragment0 != null) {
                            loginManager0.logIn(fragment0, LoginButton.this.getProperties().getPermissions(), LoginButton.this.getLoggerID());
                            return;
                        }
                    }
                    else {
                        I i0 = LoginButton.this.getFragment();
                        if(i0 != null) {
                            loginManager0.logIn(i0, LoginButton.this.getProperties().getPermissions(), LoginButton.this.getLoggerID());
                            return;
                        }
                    }
                    return;
                }
                catch(Throwable throwable0) {
                }
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }

        public final void performLogout(@NotNull Context context0) {
            String s3;
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                q.g(context0, "context");
                LoginManager loginManager0 = this.getLoginManager();
                if(LoginButton.this.confirmLogout) {
                    String s = LoginButton.this.getResources().getString(string.com_facebook_loginview_log_out_action);
                    q.f(s, "resources.getString(R.st…loginview_log_out_action)");
                    String s1 = LoginButton.this.getResources().getString(string.com_facebook_loginview_cancel_action);
                    q.f(s1, "resources.getString(R.st…_loginview_cancel_action)");
                    Profile profile0 = Profile.Companion.getCurrentProfile();
                    if((profile0 == null ? null : profile0.getName()) == null) {
                        s3 = LoginButton.this.getResources().getString(string.com_facebook_loginview_logged_in_using_facebook);
                        q.f(s3, "{\n          resources.ge…using_facebook)\n        }");
                    }
                    else {
                        String s2 = LoginButton.this.getResources().getString(string.com_facebook_loginview_logged_in_as);
                        q.f(s2, "resources.getString(R.st…k_loginview_logged_in_as)");
                        s3 = String.format(s2, Arrays.copyOf(new Object[]{profile0.getName()}, 1));
                    }
                    AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(context0);
                    alertDialog$Builder0.setMessage(s3).setCancelable(true).setPositiveButton(s, new com.facebook.login.b(loginManager0, 1)).setNegativeButton(s1, null);
                    alertDialog$Builder0.create().show();
                    return;
                }
                loginManager0.logOut();
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }

        private static final void performLogout$lambda$2(LoginManager loginManager0, DialogInterface dialogInterface0, int v) {
            Class class0 = LoginClickListener.class;
            if(CrashShieldHandler.isObjectCrashing(class0)) {
                return;
            }
            try {
                q.g(loginManager0, "$loginManager");
                loginManager0.logOut();
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001A\u00020\u0003H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000Bj\u0002\b\f¨\u0006\u000E"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "", "stringValue", "", "intValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIntValue", "()I", "toString", "AUTOMATIC", "DISPLAY_ALWAYS", "NEVER_DISPLAY", "Companion", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum ToolTipMode {
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\tR\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode$Companion;", "", "()V", "DEFAULT", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getDEFAULT", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "fromInt", "enumValue", "", "facebook-login_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.login.widget.LoginButton.ToolTipMode.Companion {
            private com.facebook.login.widget.LoginButton.ToolTipMode.Companion() {
            }

            public com.facebook.login.widget.LoginButton.ToolTipMode.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @Nullable
            public final ToolTipMode fromInt(int v) {
                ToolTipMode[] arr_loginButton$ToolTipMode = ToolTipMode.values();
                for(int v1 = 0; v1 < arr_loginButton$ToolTipMode.length; ++v1) {
                    ToolTipMode loginButton$ToolTipMode0 = arr_loginButton$ToolTipMode[v1];
                    if(loginButton$ToolTipMode0.getIntValue() == v) {
                        return loginButton$ToolTipMode0;
                    }
                }
                return null;
            }

            @NotNull
            public final ToolTipMode getDEFAULT() {
                return ToolTipMode.DEFAULT;
            }
        }

        AUTOMATIC("automatic", 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);

        @NotNull
        public static final com.facebook.login.widget.LoginButton.ToolTipMode.Companion Companion;
        @NotNull
        private static final ToolTipMode DEFAULT;
        private final int intValue;
        @NotNull
        private final String stringValue;

        private static final ToolTipMode[] $values() [...] // Inlined contents

        static {
            ToolTipMode.Companion = new com.facebook.login.widget.LoginButton.ToolTipMode.Companion(null);
            ToolTipMode.DEFAULT = ToolTipMode.AUTOMATIC;
        }

        private ToolTipMode(String s1, int v1) {
            this.stringValue = s1;
            this.intValue = v1;
        }

        public final int getIntValue() {
            return this.intValue;
        }

        @Override
        @NotNull
        public String toString() {
            return this.stringValue;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[ToolTipMode.values().length];
            try {
                arr_v[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_BUTTON_TRANSPARENCY = 0xFF;
    private static final int MIN_BUTTON_TRANSPARENCY;
    private static final String TAG;
    @Nullable
    private AccessTokenTracker accessTokenTracker;
    @Nullable
    private b androidXLoginCaller;
    @Nullable
    private CallbackManager callbackManager;
    private boolean confirmLogout;
    @Nullable
    private Float customButtonRadius;
    private int customButtonTransparency;
    @NotNull
    private final String loggerID;
    @NotNull
    private j loginManagerLazy;
    @Nullable
    private String loginText;
    @Nullable
    private String logoutText;
    @NotNull
    private final LoginButtonProperties properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    @NotNull
    private ToolTipMode toolTipMode;
    @Nullable
    private ToolTipPopup toolTipPopup;
    @NotNull
    private Style toolTipStyle;

    static {
        LoginButton.Companion = new Companion(null);
        LoginButton.TAG = "com.facebook.login.widget.LoginButton";
    }

    public LoginButton(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        this(context0, attributeSet0, v, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v, int v1, @NotNull String s, @NotNull String s1) {
        q.g(context0, "context");
        q.g(s, "analyticsButtonCreatedEventName");
        q.g(s1, "analyticsButtonTappedEventName");
        super(context0, attributeSet0, v, v1, s, s1);
        this.properties = new LoginButtonProperties();
        this.toolTipStyle = Style.BLUE;
        this.toolTipMode = ToolTipMode.Companion.getDEFAULT();
        this.toolTipDisplayTime = 6000L;
        this.loginManagerLazy = g.Q(com.facebook.login.widget.LoginButton.loginManagerLazy.1.INSTANCE);
        this.customButtonTransparency = 0xFF;
        q.f("12f0d517-a868-44ee-93b1-49e9d4aadbf7", "randomUUID().toString()");
        this.loggerID = "12f0d517-a868-44ee-93b1-49e9d4aadbf7";

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/facebook/login/LoginManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.facebook.login.widget.LoginButton.loginManagerLazy.1 extends r implements a {
            public static final com.facebook.login.widget.LoginButton.loginManagerLazy.1 INSTANCE;

            static {
                com.facebook.login.widget.LoginButton.loginManagerLazy.1.INSTANCE = new com.facebook.login.widget.LoginButton.loginManagerLazy.1();
            }

            public com.facebook.login.widget.LoginButton.loginManagerLazy.1() {
                super(0);
            }

            @NotNull
            public final LoginManager invoke() {
                return LoginManager.Companion.getInstance();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    public static void b(LoginButton loginButton0, FetchedAppSettings fetchedAppSettings0) {
        LoginButton.checkToolTipSettings$lambda$3$lambda$2(loginButton0, fetchedAppSettings0);
    }

    public static void c(String s, LoginButton loginButton0) {
        LoginButton.checkToolTipSettings$lambda$3(s, loginButton0);
    }

    private final void checkToolTipSettings() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                switch(WhenMappings.$EnumSwitchMapping$0[this.toolTipMode.ordinal()]) {
                    case 1: {
                        String s = Utility.getMetadataApplicationId(this.getContext());
                        FacebookSdk.getExecutor().execute(new l(14, s, this));
                        return;
                    }
                    case 2: {
                        String s1 = this.getResources().getString(string.com_facebook_tooltip_default);
                        q.f(s1, "resources.getString(R.st…facebook_tooltip_default)");
                        this.displayToolTip(s1);
                        return;
                    }
                    default: {
                        return;
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void checkToolTipSettings$lambda$3(String s, LoginButton loginButton0) {
        q.g(s, "$appId");
        q.g(loginButton0, "this$0");
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(s, false);
        loginButton0.getActivity().runOnUiThread(new l(13, loginButton0, fetchedAppSettings0));
    }

    private static final void checkToolTipSettings$lambda$3$lambda$2(LoginButton loginButton0, FetchedAppSettings fetchedAppSettings0) {
        q.g(loginButton0, "this$0");
        loginButton0.showToolTipPerSettings(fetchedAppSettings0);
    }

    public final void clearPermissions() {
        this.properties.clearPermissions();
    }

    @Override  // com.facebook.FacebookButtonBase
    public void configureButton(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v, int v1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(context0, "context");
            super.configureButton(context0, attributeSet0, v, v1);
            this.setInternalOnClickListener(this.getNewLoginClickListener());
            this.parseLoginButtonAttributes(context0, attributeSet0, v, v1);
            if(this.isInEditMode()) {
                this.setBackgroundColor(this.getResources().getColor(color.com_facebook_blue));
                this.setLoginText("Continue with Facebook");
            }
            else {
                this.accessTokenTracker = new AccessTokenTracker() {
                    @Override  // com.facebook.AccessTokenTracker
                    public void onCurrentAccessTokenChanged(@Nullable AccessToken accessToken0, @Nullable AccessToken accessToken1) {
                        LoginButton.this.setButtonText();
                        LoginButton.this.setButtonIcon();
                    }
                };
            }
            this.setButtonText();
            this.setButtonRadius();
            this.setButtonTransparency();
            this.setButtonIcon();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public static void d(ActivityResultParameters callbackManager$ActivityResultParameters0) {
    }

    public final void dismissToolTip() {
        ToolTipPopup toolTipPopup0 = this.toolTipPopup;
        if(toolTipPopup0 != null) {
            toolTipPopup0.dismiss();
        }
        this.toolTipPopup = null;
    }

    private final void displayToolTip(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            ToolTipPopup toolTipPopup0 = new ToolTipPopup(s, this);
            toolTipPopup0.setStyle(this.toolTipStyle);
            toolTipPopup0.setNuxDisplayTime(this.toolTipDisplayTime);
            toolTipPopup0.show();
            this.toolTipPopup = toolTipPopup0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    // 去混淆评级： 低(20)
    @NotNull
    public final String getAuthType() {
        return "rerequest";
    }

    @Nullable
    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    @NotNull
    public final DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    @Override  // com.facebook.FacebookButtonBase
    public int getDefaultRequestCode() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return RequestCodeOffset.Login.toRequestCode();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return 0;
        }
    }

    @Override  // com.facebook.FacebookButtonBase
    public int getDefaultStyleResource() {
        return style.com_facebook_loginview_default_style;
    }

    @NotNull
    public final String getLoggerID() {
        return this.loggerID;
    }

    @NotNull
    public final LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public final int getLoginButtonContinueLabel() [...] // 潜在的解密器

    public final int getLoginButtonWidth(int v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Resources resources0 = this.getResources();
            String s = this.loginText;
            if(s == null) {
                s = resources0.getString(string.com_facebook_loginview_log_in_button_continue);
                int v1 = this.measureButtonWidth(s);
                if(View.resolveSize(v1, v) < v1) {
                    s = resources0.getString(string.com_facebook_loginview_log_in_button);
                }
            }
            return this.measureButtonWidth(s);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return 0;
    }

    @NotNull
    public final j getLoginManagerLazy() {
        return this.loginManagerLazy;
    }

    @NotNull
    public final LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    @Nullable
    public final String getLoginText() {
        return this.loginText;
    }

    @Nullable
    public final String getLogoutText() {
        return this.logoutText;
    }

    @Nullable
    public final String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    @NotNull
    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener(this);
    }

    @NotNull
    public final List getPermissions() {
        return this.properties.getPermissions();
    }

    @NotNull
    public final LoginButtonProperties getProperties() {
        return this.properties;
    }

    public final boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public final long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    @NotNull
    public final ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    @NotNull
    public final Style getToolTipStyle() {
        return this.toolTipStyle;
    }

    private final int measureButtonWidth(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            int v = this.measureTextWidth(s);
            return this.getCompoundPaddingLeft() + this.getCompoundDrawablePadding() + v + this.getCompoundPaddingRight();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return 0;
        }
    }

    @Override  // com.facebook.FacebookButtonBase
    public void onAttachedToWindow() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                super.onAttachedToWindow();
                if(this.getContext() instanceof i) {
                    Context context0 = this.getContext();
                    q.e(context0, "null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
                    this.androidXLoginCaller = ((i)context0).getActivityResultRegistry().d("facebook-login", ((LoginManager)this.loginManagerLazy.getValue()).createLogInActivityResultContract(this.callbackManager, this.loggerID), new com.facebook.appevents.b(7));
                }
                AccessTokenTracker accessTokenTracker0 = this.accessTokenTracker;
                if(accessTokenTracker0 != null && accessTokenTracker0.isTracking()) {
                    accessTokenTracker0.startTracking();
                    this.setButtonText();
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    private static final void onAttachedToWindow$lambda$0(ActivityResultParameters callbackManager$ActivityResultParameters0) {
    }

    @Override  // android.view.View
    public void onDetachedFromWindow() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onDetachedFromWindow();
            b b0 = this.androidXLoginCaller;
            if(b0 != null) {
                b0.c();
            }
            AccessTokenTracker accessTokenTracker0 = this.accessTokenTracker;
            if(accessTokenTracker0 != null) {
                accessTokenTracker0.stopTracking();
            }
            this.dismissToolTip();
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Override  // com.facebook.FacebookButtonBase
    public void onDraw(@NotNull Canvas canvas0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(canvas0, "canvas");
                super.onDraw(canvas0);
                if(!this.toolTipChecked && !this.isInEditMode()) {
                    this.toolTipChecked = true;
                    this.checkToolTipSettings();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Override  // android.widget.TextView
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onLayout(z, v, v1, v2, v3);
            this.setButtonText();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @Override  // android.widget.TextView
    public void onMeasure(int v, int v1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Paint.FontMetrics paint$FontMetrics0 = this.getPaint().getFontMetrics();
            int v2 = this.getCompoundPaddingTop() + ((int)Math.ceil(Math.abs(paint$FontMetrics0.top) + Math.abs(paint$FontMetrics0.bottom))) + this.getCompoundPaddingBottom();
            Resources resources0 = this.getResources();
            int v3 = this.getLoginButtonWidth(v);
            String s = this.logoutText;
            if(s == null) {
                s = resources0.getString(string.com_facebook_loginview_log_out_button);
                q.f(s, "resources.getString(R.st…loginview_log_out_button)");
            }
            this.setMeasuredDimension(View.resolveSize(Math.max(v3, this.measureButtonWidth(s)), v), v2);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    @Override  // android.widget.TextView
    public void onVisibilityChanged(@NotNull View view0, int v) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(view0, "changedView");
                super.onVisibilityChanged(view0, v);
                if(v != 0) {
                    this.dismissToolTip();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void parseLoginButtonAttributes(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v, int v1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.g(context0, "context");
            com.facebook.login.widget.LoginButton.ToolTipMode.Companion loginButton$ToolTipMode$Companion0 = ToolTipMode.Companion;
            this.toolTipMode = loginButton$ToolTipMode$Companion0.getDEFAULT();
            TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(attributeSet0, styleable.com_facebook_login_view, v, v1);
            q.f(typedArray0, "context\n            .the…efStyleAttr, defStyleRes)");
            try {
                this.confirmLogout = typedArray0.getBoolean(styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
                this.setLoginText(typedArray0.getString(styleable.com_facebook_login_view_com_facebook_login_text));
                this.setLogoutText(typedArray0.getString(styleable.com_facebook_login_view_com_facebook_logout_text));
                ToolTipMode loginButton$ToolTipMode0 = loginButton$ToolTipMode$Companion0.fromInt(typedArray0.getInt(styleable.com_facebook_login_view_com_facebook_tooltip_mode, loginButton$ToolTipMode$Companion0.getDEFAULT().getIntValue()));
                if(loginButton$ToolTipMode0 == null) {
                    loginButton$ToolTipMode0 = loginButton$ToolTipMode$Companion0.getDEFAULT();
                }
                this.toolTipMode = loginButton$ToolTipMode0;
                if(typedArray0.hasValue(styleable.com_facebook_login_view_com_facebook_login_button_radius)) {
                    this.customButtonRadius = typedArray0.getDimension(1, 0.0f);
                }
                this.customButtonTransparency = Math.min(0xFF, Math.max(0, typedArray0.getInteger(styleable.com_facebook_login_view_com_facebook_login_button_transparency, 0xFF)));
            }
            finally {
                typedArray0.recycle();
            }
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void registerCallback(@NotNull CallbackManager callbackManager0, @NotNull FacebookCallback facebookCallback0) {
        q.g(callbackManager0, "callbackManager");
        q.g(facebookCallback0, "callback");
        ((LoginManager)this.loginManagerLazy.getValue()).registerCallback(callbackManager0, facebookCallback0);
        CallbackManager callbackManager1 = this.callbackManager;
        if(callbackManager1 == null) {
            this.callbackManager = callbackManager0;
            return;
        }
        if(callbackManager1 != callbackManager0) {
            Log.w("com.facebook.login.widget.LoginButton", "You\'re registering a callback on the one Facebook login button with two different callback managers. It\'s almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    public final void setAuthType(@NotNull String s) {
        q.g(s, "value");
        this.properties.setAuthType(s);
    }

    public final void setButtonIcon() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.setCompoundDrawablesWithIntrinsicBounds(d5.w.B(this.getContext(), drawable.com_facebook_button_icon), null, null, null);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    @TargetApi(29)
    public final void setButtonRadius() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                Float float0 = this.customButtonRadius;
                if(float0 != null) {
                    float f = (float)float0;
                    Drawable drawable0 = this.getBackground();
                    if(Build.VERSION.SDK_INT >= 29 && drawable0 instanceof StateListDrawable) {
                        int v = ((StateListDrawable)drawable0).getStateCount();
                        for(int v1 = 0; v1 < v; ++v1) {
                            Drawable drawable1 = ((StateListDrawable)drawable0).getStateDrawable(v1);
                            GradientDrawable gradientDrawable0 = drawable1 instanceof GradientDrawable ? ((GradientDrawable)drawable1) : null;
                            if(gradientDrawable0 != null) {
                                gradientDrawable0.setCornerRadius(f);
                            }
                        }
                    }
                    if(drawable0 instanceof GradientDrawable) {
                        ((GradientDrawable)drawable0).setCornerRadius(f);
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void setButtonText() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Resources resources0 = this.getResources();
            if(!this.isInEditMode() && AccessToken.Companion.isCurrentAccessTokenActive()) {
                this.setText((this.logoutText == null ? resources0.getString(string.com_facebook_loginview_log_out_button) : this.logoutText));
                return;
            }
            String s = this.loginText;
            if(s != null) {
                this.setText(s);
                return;
            }
            String s1 = "Continue with Facebook";
            q.f("Continue with Facebook", "resources.getString(loginButtonContinueLabel)");
            int v = this.getWidth();
            if(v != 0 && this.measureButtonWidth("Continue with Facebook") > v) {
                s1 = resources0.getString(string.com_facebook_loginview_log_in_button);
                q.f(s1, "resources.getString(R.st…_loginview_log_in_button)");
            }
            this.setText(s1);
            return;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final void setButtonTransparency() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.getBackground().setAlpha(this.customButtonTransparency);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final void setDefaultAudience(@NotNull DefaultAudience defaultAudience0) {
        q.g(defaultAudience0, "value");
        this.properties.setDefaultAudience(defaultAudience0);
    }

    public final void setLoginBehavior(@NotNull LoginBehavior loginBehavior0) {
        q.g(loginBehavior0, "value");
        this.properties.setLoginBehavior(loginBehavior0);
    }

    public final void setLoginManagerLazy(@NotNull j j0) {
        q.g(j0, "<set-?>");
        this.loginManagerLazy = j0;
    }

    public final void setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp0) {
        q.g(loginTargetApp0, "value");
        this.properties.setLoginTargetApp(loginTargetApp0);
    }

    public final void setLoginText(@Nullable String s) {
        this.loginText = s;
        this.setButtonText();
    }

    public final void setLogoutText(@Nullable String s) {
        this.logoutText = s;
        this.setButtonText();
    }

    public final void setMessengerPageId(@Nullable String s) {
        this.properties.setMessengerPageId(s);
    }

    public final void setPermissions(@NotNull List list0) {
        q.g(list0, "value");
        this.properties.setPermissions(list0);
    }

    public final void setPermissions(@NotNull String[] arr_s) {
        q.g(arr_s, "permissions");
        Object[] arr_object = Arrays.copyOf(arr_s, arr_s.length);
        q.g(arr_object, "elements");
        ArrayList arrayList0 = n.g0(arr_object);
        this.properties.setPermissions(arrayList0);
    }

    @d
    public final void setPublishPermissions(@NotNull List list0) {
        q.g(list0, "permissions");
        this.properties.setPermissions(list0);
    }

    @d
    public final void setPublishPermissions(@NotNull String[] arr_s) {
        q.g(arr_s, "permissions");
        Object[] arr_object = Arrays.copyOf(arr_s, arr_s.length);
        q.g(arr_object, "elements");
        ArrayList arrayList0 = n.g0(arr_object);
        this.properties.setPermissions(arrayList0);
    }

    @d
    public final void setReadPermissions(@NotNull List list0) {
        q.g(list0, "permissions");
        this.properties.setPermissions(list0);
    }

    @d
    public final void setReadPermissions(@NotNull String[] arr_s) {
        q.g(arr_s, "permissions");
        Object[] arr_object = Arrays.copyOf(arr_s, arr_s.length);
        q.g(arr_object, "elements");
        ArrayList arrayList0 = n.g0(arr_object);
        this.properties.setPermissions(arrayList0);
    }

    public final void setResetMessengerState(boolean z) {
        this.properties.setResetMessengerState(z);
    }

    public final void setToolTipDisplayTime(long v) {
        this.toolTipDisplayTime = v;
    }

    public final void setToolTipMode(@NotNull ToolTipMode loginButton$ToolTipMode0) {
        q.g(loginButton$ToolTipMode0, "<set-?>");
        this.toolTipMode = loginButton$ToolTipMode0;
    }

    public final void setToolTipStyle(@NotNull Style toolTipPopup$Style0) {
        q.g(toolTipPopup$Style0, "<set-?>");
        this.toolTipStyle = toolTipPopup$Style0;
    }

    private final void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings0) {
        if(!CrashShieldHandler.isObjectCrashing(this) && fetchedAppSettings0 != null) {
            try {
                if(fetchedAppSettings0.getNuxEnabled() && this.getVisibility() == 0) {
                    this.displayToolTip(fetchedAppSettings0.getNuxContent());
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public final void unregisterCallback(@NotNull CallbackManager callbackManager0) {
        q.g(callbackManager0, "callbackManager");
        ((LoginManager)this.loginManagerLazy.getValue()).unregisterCallback(callbackManager0);
    }
}

