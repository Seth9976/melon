package com.iloen.melon.fragments.detail;

import F8.I;
import F8.p;
import J8.E2;
import J8.F2;
import J8.P;
import J8.e3;
import J8.f3;
import J8.m0;
import Tf.o;
import Tf.v;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.media3.session.G0;
import androidx.media3.session.W0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnClickListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnData;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnInfo;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.fragments.melonchart.StreamingCardFragment;
import com.iloen.melon.fragments.settings.SettingBannedContentsFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.request.MyMusicInsertBanSongReq.Param;
import com.iloen.melon.net.v4x.request.MyMusicInsertBanSongReq;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.response.MyMusicInsertBanSongRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.request.ForUTorosBanFeedbackReq;
import com.iloen.melon.net.v6x.request.ForUDetailReq.Params;
import com.iloen.melon.net.v6x.request.ForUDetailReq;
import com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE.LIST;
import com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ForUDetailRes;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.PopupClickLogHelper;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.template.TemplateData.Builder.BUILD_TYPE;
import com.iloen.melon.utils.template.TemplateData.Builder;
import com.iloen.melon.utils.template.TemplateImageLoader;
import com.iloen.melon.utils.ui.PhotoDetailUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.F1;
import com.melon.ui.H1;
import com.melon.ui.J1;
import com.melon.ui.K1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.R1;
import com.melon.ui.V1;
import com.melon.ui.c2;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.h2;
import com.melon.ui.i2;
import com.melon.ui.k2;
import com.melon.ui.w1;
import com.melon.ui.x1;
import d3.g;
import e.k;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import me.i;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;
import p8.f;
import p8.s;
import pc.Z0;
import pc.l1;
import v9.h;
import we.n;
import zd.C0;
import zd.M;
import zd.e0;

@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00E4\u00012\u00020\u0001:\u0004\u00E4\u0001\u00E5\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ!\u0010#\u001A\u00020\n2\u0006\u0010!\u001A\u00020 2\b\u0010\"\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b%\u0010\u0003J\u000F\u0010&\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b&\u0010\u0003J\u0017\u0010)\u001A\u00020\n2\u0006\u0010(\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b)\u0010*J-\u00100\u001A\u00020\u00122\b\u0010,\u001A\u0004\u0018\u00010+2\b\u0010.\u001A\u0004\u0018\u00010-2\b\u0010/\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b2\u0010\u0003J\u000F\u00104\u001A\u0004\u0018\u000103\u00A2\u0006\u0004\b4\u00105J\r\u00106\u001A\u00020\n\u00A2\u0006\u0004\b6\u0010\u0003J\u000F\u00107\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b7\u0010\u0003J\u0017\u00109\u001A\u00020\n2\b\u00108\u001A\u0004\u0018\u000103\u00A2\u0006\u0004\b9\u0010:J\u001F\u0010>\u001A\u00020\n2\u0006\u0010;\u001A\u00020\u00042\b\u0010=\u001A\u0004\u0018\u00010<\u00A2\u0006\u0004\b>\u0010?J;\u0010>\u001A\u00020\n2\b\u0010A\u001A\u0004\u0018\u00010@2\u0006\u0010B\u001A\u00020\u00042\b\u0010=\u001A\u0004\u0018\u00010<2\u0006\u0010C\u001A\u00020\'2\u0006\u0010D\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b>\u0010EJ\u000F\u0010F\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bF\u0010\u0006J\u0017\u0010H\u001A\n G*\u0004\u0018\u00010\u00040\u0004H\u0016\u00A2\u0006\u0004\bH\u0010\u0006J\u000F\u0010I\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bI\u0010\u0006J!\u0010M\u001A\u00020\n2\b\u0010K\u001A\u0004\u0018\u00010J2\u0006\u0010L\u001A\u00020\'H\u0016\u00A2\u0006\u0004\bM\u0010NJ!\u0010Q\u001A\u00020\n2\b\u0010O\u001A\u0004\u0018\u00010\u00042\b\u0010P\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\bQ\u0010RJ\r\u0010S\u001A\u00020\u0012\u00A2\u0006\u0004\bS\u0010TJ\u000F\u0010U\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bU\u0010\u0003J\u000F\u0010V\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bV\u0010\u0003J\u0017\u0010Y\u001A\n\u0012\u0004\u0012\u00020X\u0018\u00010WH\u0016\u00A2\u0006\u0004\bY\u0010ZJ!\u0010]\u001A\u0016\u0012\u0004\u0012\u00020J\u0018\u00010[j\n\u0012\u0004\u0012\u00020J\u0018\u0001`\\\u00A2\u0006\u0004\b]\u0010^J\u0017\u0010`\u001A\u00020\n2\u0006\u0010,\u001A\u00020_H\u0016\u00A2\u0006\u0004\b`\u0010aJ}\u0010n\u001A\u00020\n2\b\u0010c\u001A\u0004\u0018\u00010b2\b\u0010d\u001A\u0004\u0018\u00010\u00042\b\u0010e\u001A\u0004\u0018\u00010\u00042\b\u0010f\u001A\u0004\u0018\u00010\u00042\b\u0010g\u001A\u0004\u0018\u00010\'2\b\u0010h\u001A\u0004\u0018\u00010\u00042\b\u0010i\u001A\u0004\u0018\u00010\u00042\b\u0010j\u001A\u0004\u0018\u00010\u00042\b\u0010k\u001A\u0004\u0018\u00010\u00042\b\u0010l\u001A\u0004\u0018\u00010\u00042\b\u0010m\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\bn\u0010oJ\u0011\u0010q\u001A\u0004\u0018\u00010pH\u0016\u00A2\u0006\u0004\bq\u0010rJ\u0011\u0010t\u001A\u0004\u0018\u00010sH\u0016\u00A2\u0006\u0004\bt\u0010uJ\r\u0010v\u001A\u00020\u0004\u00A2\u0006\u0004\bv\u0010\u0006J\u000F\u0010w\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bw\u0010\u0006J\u000F\u0010x\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bx\u0010\u0003J\u000F\u0010y\u001A\u00020\nH\u0002\u00A2\u0006\u0004\by\u0010\u0003J\u0011\u0010z\u001A\u0004\u0018\u000103H\u0002\u00A2\u0006\u0004\bz\u00105J\u000F\u0010{\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b{\u0010\u0003J\u000F\u0010|\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b|\u0010\u0003J\u000F\u0010}\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b}\u0010\u0003J(\u0010\u007F\u001A\u00020\n2\u0006\u0010K\u001A\u00020J2\u0006\u0010~\u001A\u00020\u00042\u0006\u0010L\u001A\u00020\'H\u0002\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001J\u0019\u0010\u0081\u0001\u001A\u00020\n2\u0006\u0010L\u001A\u00020\'H\u0002\u00A2\u0006\u0005\b\u0081\u0001\u0010*J\u0013\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0005\b\u0082\u0001\u0010\u0006J;\u0010\u0084\u0001\u001A\u00020\n2\t\u0010\u0083\u0001\u001A\u0004\u0018\u00010p2\b\u0010d\u001A\u0004\u0018\u00010\u00042\b\u0010i\u001A\u0004\u0018\u00010\u00042\b\u0010g\u001A\u0004\u0018\u00010\'H\u0002\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0086\u0001\u001A\u00020\u0012H\u0002\u00A2\u0006\u0005\b\u0086\u0001\u0010TJ\u0013\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0005\b\u0087\u0001\u0010\u0006J\u0011\u0010\u0088\u0001\u001A\u00020\nH\u0002\u00A2\u0006\u0005\b\u0088\u0001\u0010\u0003R\u001A\u0010\u008A\u0001\u001A\u00030\u0089\u00018\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u008A\u0001\u0010\u008B\u0001R\u0019\u0010\u008C\u0001\u001A\u00020 8\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u008C\u0001\u0010\u008D\u0001R\u0018\u0010\u008F\u0001\u001A\u00030\u008E\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008F\u0001\u0010\u0090\u0001R\u001B\u0010\u0091\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0091\u0001\u0010\u008D\u0001R\u001B\u0010\u0092\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u008D\u0001R\u001B\u0010\u0093\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0093\u0001\u0010\u008D\u0001R\u001B\u0010\u0094\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u008D\u0001R\u001B\u0010\u0095\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0095\u0001\u0010\u008D\u0001R\u001C\u0010\u0097\u0001\u001A\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001C\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u0098\u0001R\u001B\u0010\u009A\u0001\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009A\u0001\u0010\u009B\u0001R\u001B\u0010\u009C\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009C\u0001\u0010\u008D\u0001R\u001B\u0010\u009D\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009D\u0001\u0010\u008D\u0001R\u001B\u0010\u009E\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009E\u0001\u0010\u008D\u0001R\u001B\u0010\u009F\u0001\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009F\u0001\u0010\u009B\u0001R\u001B\u0010\u00A0\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A0\u0001\u0010\u008D\u0001R\u001B\u0010\u00A1\u0001\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A1\u0001\u0010\u009B\u0001R\u001B\u0010\u00A2\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A2\u0001\u0010\u008D\u0001R\u001B\u0010\u00A3\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A3\u0001\u0010\u008D\u0001R\u001B\u0010\u00A4\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u008D\u0001R\u001B\u0010\u00A5\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A5\u0001\u0010\u008D\u0001R\u001B\u0010\u00A6\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A6\u0001\u0010\u008D\u0001R\u001B\u0010\u00A7\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u008D\u0001R\u001B\u0010\u00A8\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A8\u0001\u0010\u008D\u0001R\u001B\u0010\u00A9\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A9\u0001\u0010\u008D\u0001R\u001C\u0010\u00AB\u0001\u001A\u0005\u0018\u00010\u00AA\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AB\u0001\u0010\u00AC\u0001R\u001B\u0010\u00AD\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AD\u0001\u0010\u008D\u0001R\u001B\u0010\u00AE\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AE\u0001\u0010\u008D\u0001R\u001B\u0010\u00AF\u0001\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AF\u0001\u0010\u009B\u0001R\u001B\u0010\u00B0\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B0\u0001\u0010\u008D\u0001R\u001B\u0010\u00B1\u0001\u001A\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B1\u0001\u0010\u009B\u0001R\u001B\u0010\u00B2\u0001\u001A\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B2\u0001\u0010\u008D\u0001R\u001B\u0010\u00B3\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B3\u0001\u0010\u00B4\u0001R\u001B\u0010\u00B5\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B5\u0001\u0010\u00B4\u0001R\u0019\u0010;\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b;\u0010\u00B4\u0001R\u001B\u0010\u00B6\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B6\u0001\u0010\u00B4\u0001R\u001B\u0010\u00B7\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B7\u0001\u0010\u00B4\u0001R\u001B\u0010\u00B8\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B8\u0001\u0010\u00B4\u0001R\u001B\u0010\u00B9\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B9\u0001\u0010\u00B4\u0001R\u001C\u0010\u00BB\u0001\u001A\u0005\u0018\u00010\u00BA\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BB\u0001\u0010\u00BC\u0001R\u001C\u0010\u00BD\u0001\u001A\u0005\u0018\u00010\u00BA\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BD\u0001\u0010\u00BC\u0001R\u001B\u0010\u00BE\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BE\u0001\u0010\u00B4\u0001R\u001B\u0010\u00BF\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00BF\u0001\u0010\u00B4\u0001R3\u0010\u00C1\u0001\u001A\u001C\u0012\u0007\b\u0001\u0012\u00030\u00C0\u0001\u0018\u00010[j\r\u0012\u0007\b\u0001\u0012\u00030\u00C0\u0001\u0018\u0001`\\8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C1\u0001\u0010\u00C2\u0001R\u001B\u0010\u00C3\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C3\u0001\u0010\u00B4\u0001R\u001B\u0010\u00C4\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C4\u0001\u0010\u00B4\u0001R\u001B\u0010\u00C5\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C5\u0001\u0010\u00B4\u0001R\u0019\u0010\u00C6\u0001\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C6\u0001\u0010\u00C7\u0001R\u001B\u0010\u00C8\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00C8\u0001\u0010\u00B4\u0001R\u001C\u0010\u00CA\u0001\u001A\u0005\u0018\u00010\u00C9\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00CA\u0001\u0010\u00CB\u0001R\u001B\u0010\u00CC\u0001\u001A\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00CC\u0001\u0010\u00CD\u0001R\u001A\u0010\u00CF\u0001\u001A\u00030\u00CE\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00CF\u0001\u0010\u00D0\u0001R\u0019\u0010\u00D1\u0001\u001A\u00020\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D1\u0001\u0010\u00D2\u0001R\u001B\u0010\u00D3\u0001\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D3\u0001\u0010\u00B4\u0001R\u0019\u0010\u00D4\u0001\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D4\u0001\u0010\u00C7\u0001R\u0019\u0010\u00D5\u0001\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D5\u0001\u0010\u00C7\u0001R\u0019\u0010\u00D6\u0001\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D6\u0001\u0010\u00C7\u0001R\u001A\u0010\u00D8\u0001\u001A\u00030\u00D7\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00D8\u0001\u0010\u00D9\u0001R!\u0010\u00DF\u0001\u001A\u00030\u00DA\u00018VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00DB\u0001\u0010\u00DC\u0001\u001A\u0006\b\u00DD\u0001\u0010\u00DE\u0001R\u0018\u0010\u00E3\u0001\u001A\u00030\u00E0\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00E1\u0001\u0010\u00E2\u0001\u00A8\u0006\u00E6\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "getDetailCacheKey", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "", "isVisible", "onFragmentVisibilityChanged", "(Z)V", "LJ8/E2;", "getHeaderBinding", "()LJ8/E2;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onAppBarCollapsed", "onAppBarExpended", "", "offset", "onAppBarScrolling", "(I)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "updateHeaderView", "Lcom/iloen/melon/net/v6x/response/ForUDetailRes;", "fetchDetailCacheData", "()Lcom/iloen/melon/net/v6x/response/ForUDetailRes;", "updateSongInfo", "showContextPopupPlaylistDetail", "response", "drawHeaderView", "(Lcom/iloen/melon/net/v6x/response/ForUDetailRes;)V", "desc", "Landroid/text/SpannableString;", "spannableText", "setDescText", "(Ljava/lang/String;Landroid/text/SpannableString;)V", "Landroid/widget/TextView;", "textView", "text", "maxLine", "count", "(Landroid/widget/TextView;Ljava/lang/String;Landroid/text/SpannableString;II)V", "getContsId", "kotlin.jvm.PlatformType", "getContsTypeCode", "getPageMetaType", "Lcom/iloen/melon/playback/Playable;", "playable", "position", "showContextPopupFromSong", "(Lcom/iloen/melon/playback/Playable;I)V", "songId", "menuId", "requestTorosBanFeedback", "(Ljava/lang/String;Ljava/lang/String;)V", "isNotRecommendMenuEnable", "()Z", "addAll", "downloadAll", "", "Lcom/melon/net/res/common/SongInfoBase;", "getAllSongList", "()Ljava/util/List;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "makePlayables", "()Ljava/util/ArrayList;", "Lzd/M;", "contextMenuCheckSongList", "(Lzd/M;)V", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "clickLayer1", "clickCopy", "ordNum", "image", "eventMetaId", "eventMetaType", "eventMetaName", "eventMetaAuthor", "propsLikeType", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getTiaraFileHashKey", "getTiaraImpArea", "restoreCoverInfoFromCache", "initLayout", "requestSongList", "updateStatusBar", "updateForUMixCoverUi", "updateSingleImageCoverUi", "reasonContsTypeCode", "requestBanSong", "(Lcom/iloen/melon/playback/Playable;Ljava/lang/String;I)V", "removeItemsIfExist", "getImpressionId", "builder", "setTorosProperties", "(Lp8/f;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "hasImpressionData", "getReqSeedContsId", "mixUpPlayClickLog", "LJ8/F2;", "playlistDetailHeaderSpecialBinding", "LJ8/F2;", "bottomDivider", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "playlistThumbContainer", "coverDim", "layoutCoverGradient", "layoutContent", "layoutLike", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "ivThumbCircle", "playlistName", "Landroid/widget/TextView;", "tvPlaylistMakeBtn", "layoutMakeButtonTooltip", "ivPlaylistMakeTooltipClose", "ownerNickName", "ownerContainer", "issueDate", "djOfficial", "djBadge", "btnShare", "btnLiked", "btnComment", "likedCnt", "commentCnt", "followLayout", "Lcom/iloen/melon/custom/CoverView;", "coverView", "Lcom/iloen/melon/custom/CoverView;", "descContainer", "descLongContainer", "descLong", "descShortContainer", "descShort", "descMore", "typeCode", "Ljava/lang/String;", "title", "detailText", "detailReplace", "updateDate", "coverImgUrl", "Landroid/graphics/Bitmap;", "coverBitmap", "Landroid/graphics/Bitmap;", "thumbBitmap", "moreViewImgUrl", "coverCacheKey", "Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "tagList", "Ljava/util/ArrayList;", "strSongList", "contstypecode", "contsId", "isSpecial", "Z", "seedContsId", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "foruMixInfo", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "mixDetailRes", "Lcom/iloen/melon/net/v6x/response/ForUDetailRes;", "", "playSec", "J", "mixSongCount", "I", "dailyPickTiaraNameCache", "isDefaultSongContextPopup", "isPossibleBanned", "isAppBarCollapsed", "", "alpha", "F", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData$delegate", "Lie/j;", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "ForUDetailParam", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixPlaylistDetailFragment extends Hilt_MixPlaylistDetailFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment;", "detailData", "Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment$ForUDetailParam;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MixPlaylistDetailFragment newInstance(@NotNull ForUDetailParam mixPlaylistDetailFragment$ForUDetailParam0) {
            q.g(mixPlaylistDetailFragment$ForUDetailParam0, "detailData");
            Bundle bundle0 = new Bundle();
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getTypeCode())) {
                bundle0.putString("argTypeCode", mixPlaylistDetailFragment$ForUDetailParam0.getTypeCode());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getTitle())) {
                bundle0.putString("argTitle", mixPlaylistDetailFragment$ForUDetailParam0.getTitle());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getDesc())) {
                bundle0.putString("argDesc", mixPlaylistDetailFragment$ForUDetailParam0.getDesc());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getDetailText())) {
                bundle0.putString("argDetailText", mixPlaylistDetailFragment$ForUDetailParam0.getDetailText());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getDetailReplace())) {
                bundle0.putString("argDetailReplace", mixPlaylistDetailFragment$ForUDetailParam0.getDetailReplace());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getUpdateDate())) {
                bundle0.putString("argUpdateDate", mixPlaylistDetailFragment$ForUDetailParam0.getUpdateDate());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getCoverCacheKey())) {
                bundle0.putString("argCacheKey", mixPlaylistDetailFragment$ForUDetailParam0.getCoverCacheKey());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getCoverImgUrl())) {
                bundle0.putString("argCoverImgUrl", mixPlaylistDetailFragment$ForUDetailParam0.getCoverImgUrl());
            }
            ArrayList arrayList0 = mixPlaylistDetailFragment$ForUDetailParam0.getTags();
            if(arrayList0 != null && arrayList0.size() > 0) {
                bundle0.putSerializable("argTagList", arrayList0);
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getSongIds())) {
                bundle0.putString("argSongList", mixPlaylistDetailFragment$ForUDetailParam0.getSongIds());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getContsTypeCode())) {
                bundle0.putString("argContsTypeCode", mixPlaylistDetailFragment$ForUDetailParam0.getContsTypeCode());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getContsId())) {
                bundle0.putString("argContsIds", mixPlaylistDetailFragment$ForUDetailParam0.getContsId());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getSeedContsId())) {
                bundle0.putString("argSeedContsIds", mixPlaylistDetailFragment$ForUDetailParam0.getSeedContsId());
            }
            if(!TextUtils.isEmpty(mixPlaylistDetailFragment$ForUDetailParam0.getStatsElements())) {
                bundle0.putString("argStatsElements", mixPlaylistDetailFragment$ForUDetailParam0.getStatsElements());
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            ArrayList arrayList1 = mixPlaylistDetailFragment$ForUDetailParam0.getTags();
            if(arrayList1 != null) {
                Iterator iterator0 = arrayList1.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append(",");
                    }
                    stringBuilder0.append(((TagInfoBase)object0).tagName);
                }
            }
            MixPlaylistDetailFragment mixPlaylistDetailFragment0 = new MixPlaylistDetailFragment();
            mixPlaylistDetailFragment0.setArguments(bundle0);
            return mixPlaylistDetailFragment0;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0005J\u0010\u0010\n\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\r\u001A\u00020\u00002\b\u0010\r\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0013\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0016\u001A\u00020\u00002\b\u0010\u0016\u001A\u0004\u0018\u00010\u0005J\u0010\u00106\u001A\u00020\u00002\b\u00106\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u001C\u001A\u00020\u00002\b\u0010\u001C\u001A\u0004\u0018\u00010\u0005J&\u00107\u001A\u00020\u00002\u001E\u0010\u001F\u001A\u001A\u0012\u0006\b\u0001\u0012\u00020!\u0018\u00010 j\f\u0012\u0006\b\u0001\u0012\u00020!\u0018\u0001`\"J\u0010\u0010\'\u001A\u00020\u00002\b\u0010\'\u001A\u0004\u0018\u00010\u0005J\u0010\u0010*\u001A\u00020\u00002\b\u0010*\u001A\u0004\u0018\u00010\u0005J\u000E\u0010-\u001A\u00020\u00002\u0006\u0010-\u001A\u00020\u0005J\u000E\u00100\u001A\u00020\u00002\u0006\u00100\u001A\u00020\u0005J\u0010\u00103\u001A\u00020\u00002\b\u00103\u001A\u0004\u0018\u00010\u0005J\u0010\u00103\u001A\u00020\u00002\b\u00103\u001A\u0004\u0018\u000108R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001C\u0010\r\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR\u001C\u0010\u001C\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR2\u0010\u001F\u001A\u001A\u0012\u0006\b\u0001\u0012\u00020!\u0018\u00010 j\f\u0012\u0006\b\u0001\u0012\u00020!\u0018\u0001`\"X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001C\u0010\'\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001C\u0010*\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b+\u0010\u0007\"\u0004\b,\u0010\tR\u001C\u0010-\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u001C\u00100\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001C\u00103\u001A\u0004\u0018\u00010\u0005X\u0086\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b4\u0010\u0007\"\u0004\b5\u0010\t\u00A8\u0006:"}, d2 = {"Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment$ForUDetailParam;", "", "<init>", "()V", "typeCode", "", "getTypeCode", "()Ljava/lang/String;", "setTypeCode", "(Ljava/lang/String;)V", "title", "getTitle", "setTitle", "desc", "getDesc", "setDesc", "detailText", "getDetailText", "setDetailText", "detailReplace", "getDetailReplace", "setDetailReplace", "updateDate", "getUpdateDate", "setUpdateDate", "coverCacheKey", "getCoverCacheKey", "setCoverCacheKey", "coverImgUrl", "getCoverImgUrl", "setCoverImgUrl", "tags", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "Lkotlin/collections/ArrayList;", "getTags", "()Ljava/util/ArrayList;", "setTags", "(Ljava/util/ArrayList;)V", "songIds", "getSongIds", "setSongIds", "contsTypeCode", "getContsTypeCode", "setContsTypeCode", "contsId", "getContsId", "setContsId", "seedContsId", "getSeedContsId", "setSeedContsId", "statsElements", "getStatsElements", "setStatsElements", "templateCoverCacheKey", "tagList", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ForUDetailParam {
        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u001F\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u0007R\u0014\u0010\u000E\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0007R\u0014\u0010\u0010\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001A\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0007R\u0014\u0010\u001C\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0007R\u0014\u0010\u001E\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0007R\u0014\u0010 \u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b!\u0010\u0007R\u0014\u0010\"\u001A\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b#\u0010\u0007R\u0014\u0010$\u001A\u00020%X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b&\u0010\'¨\u0006("}, d2 = {"Lcom/iloen/melon/fragments/detail/MixPlaylistDetailFragment$ForUDetailParam$Companion;", "", "<init>", "()V", "ARG_TYPE_CODE", "", "getARG_TYPE_CODE", "()Ljava/lang/String;", "ARG_TITLE", "getARG_TITLE", "ARG_DESC", "getARG_DESC", "ARG_DETAIL_TEXT", "getARG_DETAIL_TEXT", "ARG_DETAIL_REPLACE", "getARG_DETAIL_REPLACE", "ARG_UPDATE_DATE", "getARG_UPDATE_DATE", "ARG_COVER_CACHE_KEY", "getARG_COVER_CACHE_KEY", "ARG_COVER_IMG_URL", "getARG_COVER_IMG_URL", "ARG_TAG_LIST", "getARG_TAG_LIST", "ARG_SONG_LIST", "getARG_SONG_LIST", "ARG_CONTS_TYPE_CODE", "getARG_CONTS_TYPE_CODE", "ARG_CONTS_ID", "getARG_CONTS_ID", "ARG_SEED_CONTS_ID", "getARG_SEED_CONTS_ID", "ARG_IS_DEF_SONG_CTX_POPUP", "getARG_IS_DEF_SONG_CTX_POPUP", "ARG_STATS_ELEMENTS", "getARG_STATS_ELEMENTS", "BACKGROUND_BLUR_RADIUS", "", "getBACKGROUND_BLUR_RADIUS", "()I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam.Companion {
            private com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam.Companion() {
            }

            public com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_CONTS_ID() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_CONTS_TYPE_CODE() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_COVER_CACHE_KEY() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_COVER_IMG_URL() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_DESC() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_DETAIL_REPLACE() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_DETAIL_TEXT() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_IS_DEF_SONG_CTX_POPUP() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_SEED_CONTS_ID() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_SONG_LIST() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_STATS_ELEMENTS() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_TAG_LIST() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_TITLE() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_TYPE_CODE() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            @NotNull
            public final String getARG_UPDATE_DATE() [...] // 潜在的解密器

            // 去混淆评级： 低(20)
            public final int getBACKGROUND_BLUR_RADIUS() {
                return 40;
            }
        }

        public static final int $stable;
        @NotNull
        private static final String ARG_CONTS_ID;
        @NotNull
        private static final String ARG_CONTS_TYPE_CODE;
        @NotNull
        private static final String ARG_COVER_CACHE_KEY;
        @NotNull
        private static final String ARG_COVER_IMG_URL;
        @NotNull
        private static final String ARG_DESC;
        @NotNull
        private static final String ARG_DETAIL_REPLACE;
        @NotNull
        private static final String ARG_DETAIL_TEXT;
        @NotNull
        private static final String ARG_IS_DEF_SONG_CTX_POPUP;
        @NotNull
        private static final String ARG_SEED_CONTS_ID;
        @NotNull
        private static final String ARG_SONG_LIST;
        @NotNull
        private static final String ARG_STATS_ELEMENTS;
        @NotNull
        private static final String ARG_TAG_LIST;
        @NotNull
        private static final String ARG_TITLE;
        @NotNull
        private static final String ARG_TYPE_CODE;
        @NotNull
        private static final String ARG_UPDATE_DATE;
        private static final int BACKGROUND_BLUR_RADIUS;
        @NotNull
        public static final com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam.Companion Companion;
        @Nullable
        private String contsId;
        @Nullable
        private String contsTypeCode;
        @Nullable
        private String coverCacheKey;
        @Nullable
        private String coverImgUrl;
        @Nullable
        private String desc;
        @Nullable
        private String detailReplace;
        @Nullable
        private String detailText;
        @Nullable
        private String seedContsId;
        @Nullable
        private String songIds;
        @Nullable
        private String statsElements;
        @Nullable
        private ArrayList tags;
        @Nullable
        private String title;
        @Nullable
        private String typeCode;
        @Nullable
        private String updateDate;

        static {
            ForUDetailParam.Companion = new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.ForUDetailParam.Companion(null);
            ForUDetailParam.$stable = 8;
            ForUDetailParam.ARG_TYPE_CODE = "argTypeCode";
            ForUDetailParam.ARG_TITLE = "argTitle";
            ForUDetailParam.ARG_DESC = "argDesc";
            ForUDetailParam.ARG_DETAIL_TEXT = "argDetailText";
            ForUDetailParam.ARG_DETAIL_REPLACE = "argDetailReplace";
            ForUDetailParam.ARG_UPDATE_DATE = "argUpdateDate";
            ForUDetailParam.ARG_COVER_CACHE_KEY = "argCacheKey";
            ForUDetailParam.ARG_COVER_IMG_URL = "argCoverImgUrl";
            ForUDetailParam.ARG_TAG_LIST = "argTagList";
            ForUDetailParam.ARG_SONG_LIST = "argSongList";
            ForUDetailParam.ARG_CONTS_TYPE_CODE = "argContsTypeCode";
            ForUDetailParam.ARG_CONTS_ID = "argContsIds";
            ForUDetailParam.ARG_SEED_CONTS_ID = "argSeedContsIds";
            ForUDetailParam.ARG_IS_DEF_SONG_CTX_POPUP = "argIsDefaultSongContextPopup";
            ForUDetailParam.ARG_STATS_ELEMENTS = "argStatsElements";
            ForUDetailParam.BACKGROUND_BLUR_RADIUS = 40;
        }

        public static final String access$getARG_CONTS_ID$cp() [...] // 潜在的解密器

        public static final String access$getARG_CONTS_TYPE_CODE$cp() [...] // 潜在的解密器

        public static final String access$getARG_COVER_CACHE_KEY$cp() [...] // 潜在的解密器

        public static final String access$getARG_COVER_IMG_URL$cp() [...] // 潜在的解密器

        public static final String access$getARG_DESC$cp() [...] // 潜在的解密器

        public static final String access$getARG_DETAIL_REPLACE$cp() [...] // 潜在的解密器

        public static final String access$getARG_DETAIL_TEXT$cp() [...] // 潜在的解密器

        public static final String access$getARG_IS_DEF_SONG_CTX_POPUP$cp() [...] // 潜在的解密器

        public static final String access$getARG_SEED_CONTS_ID$cp() [...] // 潜在的解密器

        public static final String access$getARG_SONG_LIST$cp() [...] // 潜在的解密器

        public static final String access$getARG_STATS_ELEMENTS$cp() [...] // 潜在的解密器

        public static final String access$getARG_TAG_LIST$cp() [...] // 潜在的解密器

        public static final String access$getARG_TITLE$cp() [...] // 潜在的解密器

        public static final String access$getARG_TYPE_CODE$cp() [...] // 潜在的解密器

        public static final String access$getARG_UPDATE_DATE$cp() [...] // 潜在的解密器

        public static final int access$getBACKGROUND_BLUR_RADIUS$cp() [...] // 潜在的解密器

        @NotNull
        public final ForUDetailParam contsId(@NotNull String s) {
            q.g(s, "contsId");
            this.contsId = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam contsTypeCode(@Nullable String s) {
            this.contsTypeCode = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam coverImgUrl(@Nullable String s) {
            this.coverImgUrl = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam desc(@Nullable String s) {
            this.desc = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam detailReplace(@Nullable String s) {
            this.detailReplace = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam detailText(@Nullable String s) {
            this.detailText = s;
            return this;
        }

        @Nullable
        public final String getContsId() {
            return this.contsId;
        }

        @Nullable
        public final String getContsTypeCode() {
            return this.contsTypeCode;
        }

        @Nullable
        public final String getCoverCacheKey() {
            return this.coverCacheKey;
        }

        @Nullable
        public final String getCoverImgUrl() {
            return this.coverImgUrl;
        }

        @Nullable
        public final String getDesc() {
            return this.desc;
        }

        @Nullable
        public final String getDetailReplace() {
            return this.detailReplace;
        }

        @Nullable
        public final String getDetailText() {
            return this.detailText;
        }

        @Nullable
        public final String getSeedContsId() {
            return this.seedContsId;
        }

        @Nullable
        public final String getSongIds() {
            return this.songIds;
        }

        @Nullable
        public final String getStatsElements() {
            return this.statsElements;
        }

        @Nullable
        public final ArrayList getTags() {
            return this.tags;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTypeCode() {
            return this.typeCode;
        }

        @Nullable
        public final String getUpdateDate() {
            return this.updateDate;
        }

        @NotNull
        public final ForUDetailParam seedContsId(@NotNull String s) {
            q.g(s, "seedContsId");
            this.seedContsId = s;
            return this;
        }

        public final void setContsId(@Nullable String s) {
            this.contsId = s;
        }

        public final void setContsTypeCode(@Nullable String s) {
            this.contsTypeCode = s;
        }

        public final void setCoverCacheKey(@Nullable String s) {
            this.coverCacheKey = s;
        }

        public final void setCoverImgUrl(@Nullable String s) {
            this.coverImgUrl = s;
        }

        public final void setDesc(@Nullable String s) {
            this.desc = s;
        }

        public final void setDetailReplace(@Nullable String s) {
            this.detailReplace = s;
        }

        public final void setDetailText(@Nullable String s) {
            this.detailText = s;
        }

        public final void setSeedContsId(@Nullable String s) {
            this.seedContsId = s;
        }

        public final void setSongIds(@Nullable String s) {
            this.songIds = s;
        }

        public final void setStatsElements(@Nullable String s) {
            this.statsElements = s;
        }

        public final void setTags(@Nullable ArrayList arrayList0) {
            this.tags = arrayList0;
        }

        public final void setTitle(@Nullable String s) {
            this.title = s;
        }

        public final void setTypeCode(@Nullable String s) {
            this.typeCode = s;
        }

        public final void setUpdateDate(@Nullable String s) {
            this.updateDate = s;
        }

        @NotNull
        public final ForUDetailParam songIds(@Nullable String s) {
            this.songIds = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam statsElements(@Nullable StatsElementsBase statsElementsBase0) {
            this.statsElements = StatsElementsBase.toJsonString(statsElementsBase0);
            return this;
        }

        @NotNull
        public final ForUDetailParam statsElements(@Nullable String s) {
            this.statsElements = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam tagList(@Nullable ArrayList arrayList0) {
            this.tags = arrayList0;
            return this;
        }

        @NotNull
        public final ForUDetailParam templateCoverCacheKey(@Nullable String s) {
            this.coverCacheKey = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam title(@Nullable String s) {
            this.title = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam typeCode(@NotNull String s) {
            q.g(s, "typeCode");
            this.typeCode = s;
            return this;
        }

        @NotNull
        public final ForUDetailParam updateDate(@Nullable String s) {
            this.updateDate = s;
            return this;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[6] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[8] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MixPlaylistDetailFragment";
    private float alpha;
    @NotNull
    private final j bottomBtnData$delegate;
    private View bottomDivider;
    @Nullable
    private View btnComment;
    @Nullable
    private View btnLiked;
    @Nullable
    private View btnShare;
    @Nullable
    private View commentCnt;
    @Nullable
    private String contsId;
    @Nullable
    private String contstypecode;
    @Nullable
    private Bitmap coverBitmap;
    @Nullable
    private String coverCacheKey;
    @Nullable
    private View coverDim;
    @Nullable
    private String coverImgUrl;
    @Nullable
    private CoverView coverView;
    @Nullable
    private String dailyPickTiaraNameCache;
    @Nullable
    private String desc;
    @Nullable
    private View descContainer;
    @Nullable
    private TextView descLong;
    @Nullable
    private View descLongContainer;
    @Nullable
    private View descMore;
    @Nullable
    private TextView descShort;
    @Nullable
    private View descShortContainer;
    @Nullable
    private String detailReplace;
    @Nullable
    private String detailText;
    @Nullable
    private View djBadge;
    @Nullable
    private View djOfficial;
    @Nullable
    private View followLayout;
    @Nullable
    private ForUMixInfoBase foruMixInfo;
    private boolean isAppBarCollapsed;
    private boolean isDefaultSongContextPopup;
    private boolean isPossibleBanned;
    private boolean isSpecial;
    @Nullable
    private TextView issueDate;
    @Nullable
    private View ivPlaylistMakeTooltipClose;
    @Nullable
    private ImageView ivThumb;
    @Nullable
    private ImageView ivThumbCircle;
    @Nullable
    private View layoutContent;
    @Nullable
    private View layoutCoverGradient;
    @Nullable
    private View layoutLike;
    @Nullable
    private View layoutMakeButtonTooltip;
    @Nullable
    private View likedCnt;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @Nullable
    private ForUDetailRes mixDetailRes;
    private int mixSongCount;
    @Nullable
    private String moreViewImgUrl;
    @Nullable
    private View ownerContainer;
    @Nullable
    private TextView ownerNickName;
    private long playSec;
    private F2 playlistDetailHeaderSpecialBinding;
    @Nullable
    private TextView playlistName;
    @Nullable
    private View playlistThumbContainer;
    @Nullable
    private String seedContsId;
    @Nullable
    private String strSongList;
    @Nullable
    private ArrayList tagList;
    @Nullable
    private Bitmap thumbBitmap;
    @Nullable
    private String title;
    @Nullable
    private View tvPlaylistMakeBtn;
    @Nullable
    private String typeCode;
    @Nullable
    private String updateDate;

    static {
        MixPlaylistDetailFragment.Companion = new Companion(null);
        MixPlaylistDetailFragment.$stable = 8;
    }

    public MixPlaylistDetailFragment() {
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.mainExceptionHandler.1.1(MixPlaylistDetailFragment.this, throwable0, null), 3, null);
            }
        };
        this.bottomBtnData$delegate = g.Q(new b(this, 4));

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/detail/MixPlaylistDetailFragment$bottomBtnData$2$1", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "Lie/H;", "onShuffleSongClick", "()V", "onPlayAllSongClick", "onMixUpPlayClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.bottomBtnData.2.1 implements BottomBtnClickListener {
            public com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.bottomBtnData.2.1(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onAddSongClick() {
                BottomBtnClickListener.super.onAddSongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onMixUpPlayClick() {
                j0 j00 = MixPlaylistDetailFragment.this.getAdapter();
                DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0 = j00 instanceof DetailAdapter ? ((DetailAdapter)j00) : null;
                if(detailSongMetaContentBaseFragment$DetailAdapter0 != null) {
                    List list0 = detailSongMetaContentBaseFragment$DetailAdapter0.getAllPlayableItems();
                    if(list0 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object0: list0) {
                            if(object0 instanceof Playable) {
                                arrayList0.add(object0);
                            }
                        }
                        MixPlaylistDetailFragment mixPlaylistDetailFragment0 = MixPlaylistDetailFragment.this;
                        String s = mixPlaylistDetailFragment0.getMenuId();
                        String s1 = mixPlaylistDetailFragment0.contsId;
                        String s2 = "";
                        if(s1 == null) {
                            s1 = "";
                        }
                        String s3 = MixPlaylistDetailFragment.access$getTitle$p(mixPlaylistDetailFragment0);
                        if(s3 != null) {
                            s2 = s3;
                        }
                        mixPlaylistDetailFragment0.playMixUp(s, new Z0(mixPlaylistDetailFragment0.getStatsElementsBase(), s1, s2, arrayList0));
                        MixPlaylistDetailFragment.access$mixUpPlayClickLog(mixPlaylistDetailFragment0);
                    }
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlayAllSongClick() {
                MixPlaylistDetailFragment.access$playAll(MixPlaylistDetailFragment.this);
                MixPlaylistDetailFragment.this.playAllClickLog();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlaySongClick() {
                BottomBtnClickListener.super.onPlaySongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onShuffleSongClick() {
                MixPlaylistDetailFragment.access$playShuffleAll(MixPlaylistDetailFragment.this);
                MixPlaylistDetailFragment.this.playShuffleClickLog();
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.MixPlaylistDetailFragment$mainExceptionHandler$1$1", f = "MixPlaylistDetailFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.mainExceptionHandler.1.1(MixPlaylistDetailFragment mixPlaylistDetailFragment0, Throwable throwable0, Continuation continuation0) {
                MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                this.$throwable = throwable0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.mainExceptionHandler.1.1(MixPlaylistDetailFragment.this, this.$throwable, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                MixPlaylistDetailFragment.this.showNetworkErrorHeaderView(true);
                if(this.$throwable instanceof VolleyError) {
                    MixPlaylistDetailFragment.access$getMResponseErrorListener$p$s-1442940529(MixPlaylistDetailFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static void F0(LayoutParams constraintLayout$LayoutParams0, MixPlaylistDetailFragment mixPlaylistDetailFragment0, View view0) {
        MixPlaylistDetailFragment.setDescText$lambda$16(mixPlaylistDetailFragment0, constraintLayout$LayoutParams0, view0);
    }

    public static void G0(TextView textView0, int v, MixPlaylistDetailFragment mixPlaylistDetailFragment0, String s, SpannableString spannableString0, int v1) {
        MixPlaylistDetailFragment.setDescText$lambda$17(textView0, v, mixPlaylistDetailFragment0, s, spannableString0, v1);
    }

    public static void H0(Object object0) {
    }

    public static void J0(MixPlaylistDetailFragment mixPlaylistDetailFragment0, CoverView coverView0, kotlin.jvm.internal.H h0, TemplateImageLoader templateImageLoader0, Bitmap bitmap0) {
        MixPlaylistDetailFragment.updateForUMixCoverUi$lambda$30$lambda$27$lambda$26(mixPlaylistDetailFragment0, coverView0, h0, templateImageLoader0, bitmap0);
    }

    public static void N0(TemplateImageLoader templateImageLoader0, ForUMixInfoBase forUMixInfoBase0, MixPlaylistDetailFragment mixPlaylistDetailFragment0, kotlin.jvm.internal.H h0, View view0) {
        MixPlaylistDetailFragment.updateForUMixCoverUi$lambda$30$lambda$29$lambda$28(templateImageLoader0, forUMixInfoBase0, mixPlaylistDetailFragment0, h0, view0);
    }

    public static final ErrorListener access$getMResponseErrorListener$p$s-1442940529(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        return mixPlaylistDetailFragment0.mResponseErrorListener;
    }

    public static final String access$getTitle$p(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        return mixPlaylistDetailFragment0.title;
    }

    public static final void access$mixUpPlayClickLog(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        mixPlaylistDetailFragment0.mixUpPlayClickLog();
    }

    public static final void access$playAll(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        mixPlaylistDetailFragment0.playAll();
    }

    public static final void access$playShuffleAll(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        mixPlaylistDetailFragment0.playShuffleAll();
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void addAll() {
        this.playSongs(this.makePlayables(), false, false);
    }

    private static final BottomBtnData bottomBtnData_delegate$lambda$2(MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        return new BottomBtnData(11.0f, k.e(new BottomBtnInfo[]{new BottomBtnInfo(10002, 0.0f, null, 4, null), new BottomBtnInfo(10001, 0.0f, null, 4, null), new BottomBtnInfo(10004, 0.0f, null, 4, null)}), new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.bottomBtnData.2.1(mixPlaylistDetailFragment0));
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void contextMenuCheckSongList(@NotNull M m0) {
        q.g(m0, "type");
        switch(WhenMappings.$EnumSwitchMapping$0[m0.ordinal()]) {
            case 1: {
                this.downloadAll();
                return;
            }
            case 2: {
                this.showContextMenuAddTo();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void downloadAll() {
        this.downloadSongs(this.getMenuId(), this.makePlayables());
    }

    public final void drawHeaderView(@Nullable ForUDetailRes forUDetailRes0) {
        int v1;
        if(!this.isFragmentValid()) {
            return;
        }
        this.initLayout();
        if(forUDetailRes0 != null) {
            List list0 = forUDetailRes0.response == null ? null : forUDetailRes0.response.list;
            this.mixSongCount = list0 == null ? 0 : list0.size();
            this.playSec = 0L;
            if(list0 != null) {
                for(Object object0: list0) {
                    long v = this.playSec;
                    String s = ((LIST)object0).playTime;
                    if(s == null) {
                        v1 = 0;
                    }
                    else {
                        Integer integer0 = v.t0(s);
                        if(integer0 != null) {
                            v1 = (int)integer0;
                        }
                    }
                    this.playSec = v + ((long)v1);
                }
            }
            this.updateSongInfo();
        }
        View view0 = this.playlistThumbContainer;
        if(view0 != null) {
            view0.setVisibility(0);
        }
        ImageView imageView0 = this.ivThumb;
        if(imageView0 != null) {
            imageView0.setVisibility(8);
        }
        ImageView imageView1 = this.ivThumbCircle;
        if(imageView1 != null) {
            Glide.with(imageView1).load(0x7F080681).apply(RequestOptions.circleCropTransform()).into(imageView1);  // drawable:img_symbol_32
        }
        String s1 = this.title;
        if(s1 != null) {
            this.setTitleText(s1);
        }
        TextView textView0 = this.playlistName;
        if(textView0 != null) {
            textView0.setText(this.getTitleText());
        }
        TextView textView1 = this.ownerNickName;
        if(textView1 != null) {
            textView1.setText(this.getString(0x7F13033E));  // string:dj_playlist_name_mix "Melon"
        }
        TextView textView2 = this.issueDate;
        if(textView2 != null) {
            textView2.setText(this.updateDate);
        }
        View view1 = this.ownerContainer;
        if(view1 != null) {
            view1.setContentDescription(this.getString(0x7F130B82));  // string:talkback_mix_playlist_owner "제작자, 멜론, 멜론 공식인증"
        }
        View view2 = this.tvPlaylistMakeBtn;
        if(view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.tvPlaylistMakeBtn;
        if(view3 != null) {
            view3.setOnClickListener(new com.iloen.melon.fragments.detail.v(this, 2));
        }
        if(!MelonPrefs.getInstance().getBoolean("mixPlaylistMakeButtonTooltip", false)) {
            View view4 = this.layoutMakeButtonTooltip;
            if(view4 != null) {
                view4.setVisibility(0);
            }
            View view5 = this.ivPlaylistMakeTooltipClose;
            if(view5 != null) {
                view5.setOnClickListener(new com.iloen.melon.fragments.detail.v(this, 3));
            }
        }
        String s2 = ForUUtils.replaceNicknameWithMarkup(this.detailText, "<b>DETAILREPLACE</b>", this.detailReplace);
        if(s2 != null && s2.length() > 0) {
            this.setDescText(s2, ViewUtils.replaceTextColor(this.getContext(), s2, (this.detailReplace == null ? "" : this.detailReplace), 0x7F06017C));  // color:green500s_support_high_contrast
        }
        if("TYPE_FORU_WEATHER".equals(H0.e.z(this.contsId))) {
            View view6 = this.layoutLike;
            if(view6 != null) {
                view6.setVisibility(8);
            }
        }
        View view7 = this.djOfficial;
        if(view7 != null) {
            view7.setVisibility(0);
        }
        View view8 = this.djBadge;
        if(view8 != null) {
            view8.setVisibility(8);
        }
        View view9 = this.btnShare;
        if(view9 != null) {
            view9.setVisibility(8);
        }
        View view10 = this.btnLiked;
        if(view10 != null) {
            view10.setVisibility(8);
        }
        View view11 = this.btnComment;
        if(view11 != null) {
            view11.setVisibility(8);
        }
        View view12 = this.likedCnt;
        if(view12 != null) {
            view12.setVisibility(8);
        }
        View view13 = this.commentCnt;
        if(view13 != null) {
            view13.setVisibility(8);
        }
        View view14 = this.followLayout;
        if(view14 != null) {
            view14.setVisibility(8);
        }
        if(this.foruMixInfo == null) {
            this.updateSingleImageCoverUi();
        }
        else {
            this.updateForUMixCoverUi();
        }
        this.onAppBarScrolling(this.getAppBarOffset());
        this.setSongListHeader();
    }

    private static final void drawHeaderView$lambda$13(MixPlaylistDetailFragment mixPlaylistDetailFragment0, View view0) {
        MelonPrefs.getInstance().setBoolean("mixPlaylistMakeButtonTooltip", true);
        View view1 = mixPlaylistDetailFragment0.layoutMakeButtonTooltip;
        if(view1 != null) {
            view1.setVisibility(8);
        }
        if(!mixPlaylistDetailFragment0.isLoginUser()) {
            mixPlaylistDetailFragment0.showLoginPopup();
            return;
        }
        List list0 = mixPlaylistDetailFragment0.getSongList();
        if(list0 != null) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                if(object0 instanceof SongInfoBase) {
                    arrayList0.add(object0);
                }
            }
            ArrayList arrayList1 = new ArrayList();
            for(Object object1: arrayList0) {
                String s = ((SongInfoBase)object1).songId;
                if(s == null) {
                    s = "";
                }
                arrayList1.add(s);
            }
            Navigator.open(PlaylistMakeFragment.newInstance(null, "M20001", arrayList1, null, null, true, null, null));
        }
    }

    private static final void drawHeaderView$lambda$14(MixPlaylistDetailFragment mixPlaylistDetailFragment0, View view0) {
        MelonPrefs.getInstance().setBoolean("mixPlaylistMakeButtonTooltip", true);
        View view1 = mixPlaylistDetailFragment0.layoutMakeButtonTooltip;
        if(view1 != null) {
            view1.setVisibility(8);
        }
    }

    @Nullable
    public final ForUDetailRes fetchDetailCacheData() {
        Cursor cursor0 = a.f(this.getContext(), this.getDetailCacheKey());
        if(cursor0 == null) {
            return null;
        }
        ForUDetailRes forUDetailRes0 = (ForUDetailRes)a.d(cursor0, ForUDetailRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        return forUDetailRes0 == null ? null : forUDetailRes0;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public List getAllSongList() {
        ForUDetailRes forUDetailRes0 = this.mixDetailRes;
        if(forUDetailRes0 != null) {
            return forUDetailRes0.response == null ? null : forUDetailRes0.response.list;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public BottomBtnData getBottomBtnData() {
        return (BottomBtnData)this.bottomBtnData$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.M0.buildUpon().appendPath(this.getContsId()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public String getContsId() {
        return this.contsId == null ? "" : this.contsId;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public String getContsTypeCode() {
        return "N10078";
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getDetailCacheKey() {
        String s = MelonContentUris.N0.buildUpon().appendPath(this.getContsId()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @Nullable
    public E2 getHeaderBinding() {
        if(this.isSpecial) {
            return null;
        }
        Q4.a a0 = this.getHeaderBindingBase();
        q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderBinding");
        return (E2)a0;
    }

    private final String getImpressionId() {
        StatsElementsBase statsElementsBase0 = this.getStatsElementsBase();
        return statsElementsBase0 == null ? null : statsElementsBase0.impressionId;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return this.isSpecial ? f1.b : f1.a;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public String getPageMetaType() {
        String s = this.getString(0x7F130F08);  // string:tiara_mixplaylist_meta_type "Mix플레이리스트"
        q.f(s, "getString(...)");
        return s;
    }

    private final String getReqSeedContsId() {
        if(this.seedContsId != null && !o.H0(this.seedContsId)) {
            return this.seedContsId;
        }
        StatsElementsBase statsElementsBase0 = this.getStatsElementsBase();
        return statsElementsBase0 == null ? null : statsElementsBase0.seedContsId;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public StatsElementsBase getStatsElements() {
        return this.getStatsElementsBase();
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @Nullable
    public f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty == null) {
            return null;
        }
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.getContsId();
        f0.p = this.getString(0x7F130F08);  // string:tiara_mixplaylist_meta_type "Mix플레이리스트"
        f0.q = this.getTitleText();
        f0.I = this.getMenuId();
        String s = H0.e.z(this.contsId);
        if(!s.equals("TYPE_FORU_ARTIST") && !s.equals("TYPE_FORU_HISTORY")) {
            return f0;
        }
        f0.t = this.getReqSeedContsId();
        return f0;
    }

    @NotNull
    public final String getTiaraFileHashKey() {
        String s = this.contsId;
        if(s != null) {
            switch(H0.e.z(s)) {
                case "TYPE_FORU_ARTIST": {
                    return "3036cfb895631aa30b";
                }
                case "TYPE_FORU_DAILY_PICK": {
                    return "1727140957b6fc5c5a";
                }
                case "TYPE_FORU_HOUR_MIX": {
                    return "1727140957b6fc5c5a";
                }
                case "TYPE_FORU_NEW_SONGS": {
                    return "185fc90e40f313e9ec";
                }
                case "TYPE_FORU_RECENT_RECM_MIX": {
                    return "488c8fbcfbba439072";
                }
                case "TYPE_FORU_WEEKLY_PICK": {
                    return "06a336bbb7c6480621";
                }
                default: {
                    return "";
                }
            }
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getTiaraImpArea() {
        String s = this.contsId;
        String s1 = "";
        if(s != null) {
            switch(H0.e.z(s)) {
                case "TYPE_FORU_ARTIST": {
                    String s6 = this.getString(0x7F130EA4);  // string:tiara_foru_detail_imp_area_artist_mood "artist_personal_mood"
                    q.f(s6, "getString(...)");
                    return s6;
                }
                case "TYPE_FORU_DAILY_PICK": {
                    String s7 = this.dailyPickTiaraNameCache;
                    if(s7 == null) {
                        int v = ProtocolUtils.parseInt(s, 0);
                        if(v >= 8 && v <= 14) {
                            s1 = "daily" + (v - 8) + ".song";
                            q.d(s1);
                        }
                        this.dailyPickTiaraNameCache = s1;
                        return s1;
                    }
                    return s7;
                }
                case "TYPE_FORU_HOUR_MIX": {
                    String s2 = this.getString(0x7F130EA5);  // string:tiara_foru_detail_imp_area_hourly_pick "hourly_pick"
                    q.f(s2, "getString(...)");
                    return s2;
                }
                case "TYPE_FORU_NEW_SONGS": {
                    String s4 = this.getString(0x7F130EA6);  // string:tiara_foru_detail_imp_area_new_wave "new_wave"
                    q.f(s4, "getString(...)");
                    return s4;
                }
                case "TYPE_FORU_RECENT_RECM_MIX": {
                    String s5 = this.getString(0x7F130EA7);  // string:tiara_foru_detail_imp_area_similar_song "melon_song_similar"
                    q.f(s5, "getString(...)");
                    return s5;
                }
                case "TYPE_FORU_WEEKLY_PICK": {
                    String s3 = this.getString(0x7F130EA8);  // string:tiara_foru_detail_imp_area_weekly_pick "weekly_pick"
                    q.f(s3, "getString(...)");
                    return s3;
                }
                default: {
                    return "";
                }
            }
        }
        return "";
    }

    private final boolean hasImpressionData() {
        StatsElementsBase statsElementsBase0 = this.getStatsElementsBase();
        return statsElementsBase0 != null && (statsElementsBase0.impressionId != null && !o.H0(statsElementsBase0.impressionId) || statsElementsBase0.impressionProvider != null && !o.H0(statsElementsBase0.impressionProvider));
    }

    private final void initLayout() {
        String s = this.getString(0x7F13104A);  // string:title_playlist "플레이리스트"
        q.f(s, "getString(...)");
        I i0 = new I(1, s);
        i0.c = new com.iloen.melon.fragments.detail.v(this, 0);
        TitleBar titleBar0 = this.getTitleBar();
        F8.o o0 = this.getTitlebarDetailCommon();
        o0.g(i0);
        titleBar0.a(o0);
        this.setMoreButton(i0);
        Q4.a a0 = this.getHeaderBindingBase();
        if(a0 != null) {
            View view0 = a0.getRoot();
            if(view0 != null) {
                this.playlistThumbContainer = view0.findViewById(0x7F0A0939);  // id:playlist_thumb_container
                this.coverDim = view0.findViewById(0x7F0A034E);  // id:cover_dim
                this.layoutCoverGradient = view0.findViewById(0x7F0A0714);  // id:layout_cover_gradient
                this.layoutContent = view0.findViewById(0x7F0A0711);  // id:layout_content
                this.layoutLike = view0.findViewById(0x7F0A0723);  // id:layout_like
                this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                this.ivThumbCircle = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                this.playlistName = (TextView)view0.findViewById(0x7F0A0937);  // id:playlist_name
                this.tvPlaylistMakeBtn = view0.findViewById(0x7F0A0CE2);  // id:tv_playlist_make_btn
                this.layoutMakeButtonTooltip = view0.findViewById(0x7F0A0728);  // id:layout_make_button_tooltip
                this.ivPlaylistMakeTooltipClose = view0.findViewById(0x7F0A066D);  // id:iv_playlist_make_tooltip_close
                this.ownerNickName = (TextView)view0.findViewById(0x7F0A08F6);  // id:owner_nick_name
                this.ownerContainer = view0.findViewById(0x7F0A08F5);  // id:owner_container
                this.issueDate = (TextView)view0.findViewById(0x7F0A0594);  // id:issue_date
                this.djOfficial = view0.findViewById(0x7F0A03DC);  // id:dj_official
                this.djBadge = view0.findViewById(0x7F0A03DA);  // id:dj_badge
                this.btnShare = view0.findViewById(0x7F0A01B7);  // id:btn_share
                this.btnLiked = view0.findViewById(0x7F0A0170);  // id:btn_liked
                this.btnComment = view0.findViewById(0x7F0A014E);  // id:btn_comment
                this.likedCnt = view0.findViewById(0x7F0A076B);  // id:liked_cnt
                this.commentCnt = view0.findViewById(0x7F0A02F6);  // id:comment_cnt
                this.followLayout = view0.findViewById(0x7F0A04D2);  // id:follow_layout
                this.coverView = (CoverView)view0.findViewById(0x7F0A0355);  // id:cover_view
                this.descContainer = view0.findViewById(0x7F0A03A7);  // id:desc_container
                this.descLongContainer = view0.findViewById(0x7F0A03AA);  // id:desc_long_container
                this.descLong = (TextView)view0.findViewById(0x7F0A03A9);  // id:desc_long
                this.descShortContainer = view0.findViewById(0x7F0A03AD);  // id:desc_short_container
                this.descShort = (TextView)view0.findViewById(0x7F0A03AC);  // id:desc_short
                this.descMore = view0.findViewById(0x7F0A03AB);  // id:desc_more
            }
        }
        if(this.isSpecial) {
            View view1 = this.playlistThumbContainer;
            if(view1 != null) {
                View view2 = view1.findViewById(0x7F0A069E);  // id:iv_thumb_default
                if(view2 != null) {
                    view2.setVisibility(8);
                }
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = null;
            if(ScreenUtils.isOrientationPortrait(this.getContext())) {
                int v = ScreenUtils.getScreenWidth(this.getContext());
                if((this.playlistThumbContainer == null ? null : this.playlistThumbContainer.getLayoutParams()) instanceof FrameLayout.LayoutParams) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = this.playlistThumbContainer == null ? null : this.playlistThumbContainer.getLayoutParams();
                    q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams1).width = v;
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams1).height = v;
                    View view3 = this.playlistThumbContainer;
                    if(view3 != null) {
                        view3.setLayoutParams(((FrameLayout.LayoutParams)viewGroup$LayoutParams1));
                    }
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams1).setMargins(0, 0, 0, 0);
                }
                TextView textView0 = this.playlistName;
                if(textView0 != null) {
                    viewGroup$LayoutParams0 = textView0.getLayoutParams();
                }
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((LayoutParams)viewGroup$LayoutParams0).setMargins(0, ((int)(((float)v) * 0.8f)), 0, 0);
                View view4 = this.layoutCoverGradient;
                if(view4 != null) {
                    view4.setVisibility(0);
                }
            }
            else {
                int v1 = ScreenUtils.getScreenWidth(this.getContext());
                boolean z = ScreenUtils.isTablet(this.getContext());
                int v2 = ScreenUtils.dipToPixel(this.getContext(), (z ? 360.0f : 340.0f));
                View view5 = this.playlistThumbContainer;
                if(view5 != null) {
                    viewGroup$LayoutParams0 = view5.getLayoutParams();
                }
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).width = v1;
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).height = v2;
                View view6 = this.playlistThumbContainer;
                if(view6 != null) {
                    view6.setLayoutParams(((FrameLayout.LayoutParams)viewGroup$LayoutParams0));
                }
            }
        }
    }

    private static final void initLayout$lambda$4$lambda$3(MixPlaylistDetailFragment mixPlaylistDetailFragment0, View view0) {
        mixPlaylistDetailFragment0.showContextPopupPlaylistDetail();
        mixPlaylistDetailFragment0.moreClickLog();
    }

    public final boolean isNotRecommendMenuEnable() {
        return this.isPossibleBanned;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void itemClickLog(@Nullable ActionKind actionKind0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
        String s11;
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.d = actionKind0;
        g0.a = s;
        s s9 = this.mMelonTiaraProperty;
        String s10 = "";
        if(s9 == null) {
            s11 = "";
        }
        else {
            s11 = s9.a;
            if(s11 == null) {
                s11 = "";
            }
        }
        g0.b = s11;
        if(s9 != null) {
            String s12 = s9.b;
            if(s12 != null) {
                s10 = s12;
            }
        }
        g0.c = s10;
        g0.y = s1;
        g0.F = s2;
        g0.o = this.getContsId();
        g0.p = this.getString(0x7F130F08);  // string:tiara_mixplaylist_meta_type "Mix플레이리스트"
        g0.q = this.getTitleText();
        g0.e = s4;
        g0.f = s5;
        g0.g = s6;
        g0.h = s7;
        g0.I = this.getMenuId();
        if(integer0 != null) {
            g0.c(((int)integer0));
        }
        if(s3 != null) {
            g0.E = s3;
        }
        String s13 = H0.e.z(this.contsId);
        if(s13.equals("TYPE_FORU_ARTIST") || s13.equals("TYPE_FORU_HISTORY")) {
            g0.t = this.getReqSeedContsId();
        }
        if(this.hasImpressionData()) {
            this.setTorosProperties(g0, s, s4, integer0);
        }
        g0.a().track();
    }

    @Nullable
    public final ArrayList makePlayables() {
        ForUDetailRes forUDetailRes0 = this.mixDetailRes;
        if(forUDetailRes0 != null) {
            RESPONSE forUDetailRes$RESPONSE0 = forUDetailRes0.response;
            if(forUDetailRes$RESPONSE0 != null) {
                List list0 = forUDetailRes$RESPONSE0.list;
                if(list0 != null) {
                    ArrayList arrayList0 = new ArrayList();
                    for(Object object0: list0) {
                        arrayList0.add(Playable.from(((LIST)object0), this.getMenuId(), this.getStatsElementsBase()));
                    }
                    return arrayList0;
                }
            }
        }
        return null;
    }

    private final void mixUpPlayClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = this.getString(0x7F130D53);  // string:tiara_click_copy_mixup "믹스업"
            f0.e = this.getContsId();
            f0.f = Y.i(ContsTypeCode.MIX_PLAYLIST_MIXUP, "code(...)");
            f0.g = this.getTitleText();
            f0.W = "1000003099";
            f0.a().track();
        }
    }

    @NotNull
    public static final MixPlaylistDetailFragment newInstance(@NotNull ForUDetailParam mixPlaylistDetailFragment$ForUDetailParam0) {
        return MixPlaylistDetailFragment.Companion.newInstance(mixPlaylistDetailFragment$ForUDetailParam0);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onAppBarCollapsed() {
        this.isAppBarCollapsed = true;
        if(!this.isSpecial) {
            super.onAppBarCollapsed();
            return;
        }
        this.getTitleBar().f(false);
        FrameLayout frameLayout0 = this.getDetailHeader();
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(4);
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onAppBarExpended() {
        this.isAppBarCollapsed = false;
        if(!this.isSpecial) {
            super.onAppBarExpended();
            return;
        }
        FrameLayout frameLayout0 = this.getDetailHeader();
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(0);
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onAppBarScrolling(int v) {
        float f2;
        int v1;
        if(this.isSpecial) {
            if(this.getHeaderBindingBase() != null) {
                float f = (float)Math.abs(v);
                Q4.a a0 = this.getHeaderBindingBase();
                if(a0 == null) {
                    v1 = 0;
                }
                else {
                    View view0 = a0.getRoot();
                    v1 = view0 == null ? 0 : view0.getMeasuredHeight();
                }
                if(v1 <= 0) {
                    Q4.a a1 = this.getHeaderBindingBase();
                    if(a1 != null) {
                        View view1 = a1.getRoot();
                        if(view1 != null) {
                            view1.measure(0, 0);
                        }
                    }
                    Q4.a a2 = this.getHeaderBindingBase();
                    if(a2 == null) {
                        v1 = 0;
                    }
                    else {
                        View view2 = a2.getRoot();
                        v1 = view2 == null ? 0 : view2.getMeasuredHeight();
                    }
                    View view3 = this.descShortContainer;
                    if(view3 != null) {
                        view3.requestLayout();
                    }
                }
                int v2 = ScreenUtils.dipToPixel(this.getContext(), 200.0f);
                ScreenUtils.getStatusBarHeight(this.getContext());
                int v3 = this.getCollapseToolbarHeight();
                int v4 = ScreenUtils.getStatusBarHeight(this.getContext());
                float f1 = (float)(v1 - v2);
                if(Float.compare(f, f1) >= 0) {
                    f2 = (f - f1) / ((float)(v4 + v3));
                    if(f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    if(f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                }
                else {
                    f2 = 0.0f;
                }
                float f3 = 1.0f - f2 * 5.0f < 0.0f ? 0.0f : 1.0f - f2 * 5.0f;
                this.alpha = f3;
                TextView textView0 = this.playlistName;
                if(textView0 != null) {
                    textView0.setAlpha(f3);
                }
                TextView textView1 = this.issueDate;
                if(textView1 != null) {
                    textView1.setAlpha(this.alpha);
                }
                View view4 = this.coverDim;
                if(view4 != null) {
                    view4.setAlpha(1.0f - this.alpha);
                }
                boolean z = ScreenUtils.isDarkMode(this.getContext());
                Window window0 = null;
                if(Float.compare(this.alpha, 0.0f) <= 0) {
                    int v5 = ColorUtils.getColor(this.getContext(), 0x7F0604AA);  // color:white000s_support_high_contrast
                    this.getTitleBar().setTitle(this.getTitleText());
                    this.getTitleBar().setBackgroundColor(v5);
                    p p0 = this.getBackButton();
                    if(p0 != null) {
                        p0.j(1);
                    }
                    I i0 = this.getMoreButton();
                    if(i0 != null) {
                        i0.j(1);
                    }
                    FragmentActivity fragmentActivity0 = this.getActivity();
                    if(fragmentActivity0 != null) {
                        window0 = fragmentActivity0.getWindow();
                    }
                    ScreenUtils.setAppearanceLightStatusBars(window0, !z);
                    if(!this.isAppBarCollapsed) {
                        this.getTitleBar().f(true);
                        return;
                    }
                }
                else {
                    this.getTitleBar().setTitle("");
                    this.getTitleBar().setBackgroundColor(0);
                    this.getTitleBar().f(false);
                    FragmentActivity fragmentActivity1 = this.getActivity();
                    if(fragmentActivity1 != null) {
                        window0 = fragmentActivity1.getWindow();
                    }
                    ScreenUtils.setAppearanceLightStatusBars(window0, false);
                    p p1 = this.getBackButton();
                    if(p1 != null) {
                        p1.j(((int)z));
                    }
                    I i1 = this.getMoreButton();
                    if(i1 != null) {
                        i1.j(((int)z));
                    }
                }
            }
            return;
        }
        super.onAppBarScrolling(v);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(this.isSpecial) {
            Q4.a a0 = this.getHeaderBindingBase();
            q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderSpecialBinding");
            this.playlistDetailHeaderSpecialBinding = (F2)a0;
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        if(this.isSpecial) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0599, null, false);  // layout:playlist_detail_header_special
            int v = 0x7F0A00F1;  // id:banner_iv
            if(((ImageView)De.I.C(view0, 0x7F0A00F1)) != null && ((FrameLayout)De.I.C(view0, 0x7F0A00F2)) != null && (((ImageView)De.I.C(view0, 0x7F0A014E)) != null && ((CheckableImageView)De.I.C(view0, 0x7F0A0170)) != null) && (((ImageView)De.I.C(view0, 0x7F0A01B7)) != null && ((MelonTextView)De.I.C(view0, 0x7F0A02F6)) != null)) {  // id:banner_iv
                v = 0x7F0A034E;  // id:cover_dim
                View view1 = De.I.C(view0, 0x7F0A034E);  // id:cover_dim
                if(view1 != null && ((CoverView)De.I.C(view0, 0x7F0A0355)) != null && (((RelativeLayout)De.I.C(view0, 0x7F0A03A7)) != null && ((MelonTextView)De.I.C(view0, 0x7F0A03A9)) != null) && (((RelativeLayout)De.I.C(view0, 0x7F0A03AA)) != null && ((LinearLayout)De.I.C(view0, 0x7F0A03AB)) != null && (((MelonTextView)De.I.C(view0, 0x7F0A03AC)) != null && ((RelativeLayout)De.I.C(view0, 0x7F0A03AD)) != null)) && (((MelonTextView)De.I.C(view0, 0x7F0A03DA)) != null && ((ImageView)De.I.C(view0, 0x7F0A03DC)) != null && (((MelonTextView)De.I.C(view0, 0x7F0A0488)) != null && ((LinearLayoutCompat)De.I.C(view0, 0x7F0A0489)) != null) && (((FrameLayout)De.I.C(view0, 0x7F0A04D1)) != null && ((LinearLayout)De.I.C(view0, 0x7F0A04D2)) != null && (((LinearLayout)De.I.C(view0, 0x7F0A04D6)) != null && ((ImageView)De.I.C(view0, 0x7F0A0544)) != null))) && ((MelonTextView)De.I.C(view0, 0x7F0A0594)) != null) {  // id:cover_view
                    ImageView imageView0 = (ImageView)De.I.C(view0, 0x7F0A0634);  // id:iv_hot
                    ImageView imageView1 = (ImageView)De.I.C(view0, 0x7F0A0653);  // id:iv_new
                    v = 0x7F0A066C;  // id:iv_playlist_make_tooltip_anchor
                    if(((ImageView)De.I.C(view0, 0x7F0A066C)) != null && ((ImageView)De.I.C(view0, 0x7F0A066D)) != null && ((ImageView)De.I.C(view0, 0x7F0A0702)) != null) {  // id:iv_playlist_make_tooltip_anchor
                        LinearLayout linearLayout0 = (LinearLayout)De.I.C(view0, 0x7F0A070E);  // id:layout_comment
                        v = 0x7F0A0711;  // id:layout_content
                        if(((ConstraintLayout)De.I.C(view0, 0x7F0A0711)) != null && ((LinearLayout)De.I.C(view0, 0x7F0A0714)) != null && ((LinearLayout)De.I.C(view0, 0x7F0A0728)) != null) {  // id:layout_content
                            v = 0x7F0A0746;  // id:layout_special_cover_container
                            View view2 = De.I.C(view0, 0x7F0A0746);  // id:layout_special_cover_container
                            if(((FrameLayout)view2) != null && ((MelonTextView)De.I.C(view0, 0x7F0A076B)) != null && (((LinearLayoutCompat)De.I.C(view0, 0x7F0A08F5)) != null && ((MelonTextView)De.I.C(view0, 0x7F0A08F6)) != null) && ((MelonTextView)De.I.C(view0, 0x7F0A0937)) != null) {  // id:liked_cnt
                                v = 0x7F0A0938;  // id:playlist_thumb
                                View view3 = De.I.C(view0, 0x7F0A0938);  // id:playlist_thumb
                                if(view3 != null) {
                                    f3.a(view3);
                                    v = 0x7F0A0939;  // id:playlist_thumb_container
                                    View view4 = De.I.C(view0, 0x7F0A0939);  // id:playlist_thumb_container
                                    if(((FrameLayout)view4) != null) {
                                        v = 0x7F0A0A81;  // id:share_bottom
                                        View view5 = De.I.C(view0, 0x7F0A0A81);  // id:share_bottom
                                        if(view5 != null) {
                                            v = 0x7F0A0B79;  // id:thumb_layout
                                            View view6 = De.I.C(view0, 0x7F0A0B79);  // id:thumb_layout
                                            if(view6 != null) {
                                                e3.a(view6);
                                                v = 0x7F0A0CE2;  // id:tv_playlist_make_btn
                                                if(((MelonTextView)De.I.C(view0, 0x7F0A0CE2)) != null) {  // id:tv_playlist_make_btn
                                                    F2 f20 = new F2(((FrameLayout)view0), view1, ((FrameLayout)view2), ((FrameLayout)view4), view5);
                                                    this.playlistDetailHeaderSpecialBinding = f20;
                                                    return f20;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
        return E2.a(LayoutInflater.from(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        this.setFetchStart(true);
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO().plus(this.mainExceptionHandler), null, new n(i0, null) {
            final v9.i $type;
            int label;

            {
                MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1(MixPlaylistDetailFragment.this, this.$type, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1.1 mixPlaylistDetailFragment$onFetchStart$1$10 = new n(this.$type, null) {
                            final v9.i $type;
                            Object L$0;
                            int label;

                            {
                                MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                                this.$type = i0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1.1(MixPlaylistDetailFragment.this, this.$type, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        ForUDetailRes forUDetailRes0 = MixPlaylistDetailFragment.this.requestSongList();
                                        if(forUDetailRes0 != null && forUDetailRes0.isSuccessful()) {
                                            j0 j00 = MixPlaylistDetailFragment.this.getAdapter();
                                            DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0 = j00 instanceof DetailAdapter ? ((DetailAdapter)j00) : null;
                                            if(detailSongMetaContentBaseFragment$DetailAdapter0 != null) {
                                                detailSongMetaContentBaseFragment$DetailAdapter0.setStatsElements(MixPlaylistDetailFragment.this.getStatsElementsBase());
                                            }
                                            i i0 = Dispatchers.getMain().plus(MixPlaylistDetailFragment.this.mainExceptionHandler);
                                            com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1.1.1 mixPlaylistDetailFragment$onFetchStart$1$1$10 = new n(forUDetailRes0, this.$type, null) {
                                                final ForUDetailRes $songListRes;
                                                final v9.i $type;
                                                int label;

                                                {
                                                    MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                                                    this.$songListRes = forUDetailRes0;
                                                    this.$type = i0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1.1.1(MixPlaylistDetailFragment.this, this.$songListRes, this.$type, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.onFetchStart.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    if(this.label != 0) {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                    d5.n.D(object0);
                                                    MixPlaylistDetailFragment.this.mixDetailRes = this.$songListRes;
                                                    ForUDetailRes forUDetailRes0 = MixPlaylistDetailFragment.this.mixDetailRes;
                                                    if(forUDetailRes0 != null) {
                                                        RESPONSE forUDetailRes$RESPONSE0 = forUDetailRes0.response;
                                                        if(forUDetailRes$RESPONSE0 != null) {
                                                            MixPlaylistDetailFragment.this.mMenuId = forUDetailRes$RESPONSE0.menuId;
                                                            j0 j00 = MixPlaylistDetailFragment.this.getAdapter();
                                                            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.PlaylistDetailAdapter");
                                                            ((PlaylistDetailAdapter)j00).setMenuId(MixPlaylistDetailFragment.this.mMenuId);
                                                            s s0 = new s(forUDetailRes$RESPONSE0.section, forUDetailRes$RESPONSE0.page, forUDetailRes$RESPONSE0.menuId, null);
                                                            MixPlaylistDetailFragment.this.mMelonTiaraProperty = s0;
                                                        }
                                                    }
                                                    Context context0 = MixPlaylistDetailFragment.this.getContext();
                                                    String s1 = MixPlaylistDetailFragment.this.getDetailCacheKey();
                                                    a.a(context0, this.$songListRes, s1);
                                                    MixPlaylistDetailFragment.this.drawHeaderView(this.$songListRes);
                                                    this.$songListRes.response.tagList = MixPlaylistDetailFragment.this.tagList;
                                                    MixPlaylistDetailFragment.this.isPossibleBanned = this.$songListRes.response.isPossibleBanned;
                                                    boolean z = MixPlaylistDetailFragment.this.prepareFetchComplete(this.$songListRes);
                                                    H h0 = H.a;
                                                    if(!z) {
                                                        return h0;
                                                    }
                                                    MixPlaylistDetailFragment.this.performFetchComplete(this.$type, this.$songListRes);
                                                    return h0;
                                                }
                                            };
                                            this.L$0 = null;
                                            this.label = 1;
                                            if(BuildersKt.withContext(i0, mixPlaylistDetailFragment$onFetchStart$1$1$10, this) == a0) {
                                                return a0;
                                            }
                                        }
                                        break;
                                    }
                                    case 1: {
                                        ForUDetailRes forUDetailRes1 = (ForUDetailRes)this.L$0;
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                MixPlaylistDetailFragment.this.setFetchStart(false);
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return SupervisorKt.supervisorScope(mixPlaylistDetailFragment$onFetchStart$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onFragmentVisibilityChanged(boolean z) {
        super.onFragmentVisibilityChanged(z);
        if(z) {
            this.updateStatusBar();
        }
    }

    // 去混淆评级： 低(21)
    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.typeCode = bundle0.getString("argTypeCode");
        this.title = bundle0.getString("argTitle");
        this.desc = bundle0.getString("argDesc");
        this.detailText = bundle0.getString("argDetailText");
        this.detailReplace = bundle0.getString("argDetailReplace");
        this.updateDate = bundle0.getString("argUpdateDate");
        this.coverCacheKey = bundle0.getString("argCacheKey");
        this.coverImgUrl = bundle0.getString("argCoverImgUrl");
        this.strSongList = bundle0.getString("argSongList");
        this.contstypecode = bundle0.getString("argContsTypeCode");
        this.contsId = bundle0.getString("argContsIds");
        this.seedContsId = bundle0.getString("argSeedContsIds");
        String s = H0.e.z(this.contsId);
        this.isSpecial = "TYPE_FORU_DAILY_PICK".equals(s) || "TYPE_FORU_WEEKLY_PICK".equals(s) || "TYPE_FORU_NEW_SONGS".equals(s) || "TYPE_FORU_MONTH_SUPERLIKE".equals(s) || "TYPE_FORU_REMIND".equals(s) || "TYPE_FORU_YEAR_SUPERLIKE".equals(s) || "TYPE_FORU_BIRTH".equals(s) || "TYPE_FORU_WELCOMEPICK".equals(s) || "TYPE_FORU_HOUR_MIX".equals(s) || "TYPE_FORU_MY_REPLAY".equals(s) || "TYPE_FORU_USER_TASTE".equals(s);
        this.setStatsElementsBase(StatsElementsBase.toStatsElementsBase(bundle0.getString("argStatsElements")));
        if(bundle0.containsKey("argTagList")) {
            this.tagList = (ArrayList)com.google.firebase.b.G(bundle0, "argTagList", ArrayList.class);
        }
        if(bundle0.containsKey("argIsDefaultSongContextPopup")) {
            this.isDefaultSongContextPopup = bundle0.getBoolean("argIsDefaultSongContextPopup");
        }
        this.restoreCoverInfoFromCache();
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        if(!TextUtils.isEmpty(this.typeCode)) {
            bundle0.putString("argTypeCode", this.typeCode);
        }
        if(!TextUtils.isEmpty(this.seedContsId)) {
            bundle0.putString("argSeedContsIds", this.seedContsId);
        }
        if(!TextUtils.isEmpty(this.title)) {
            bundle0.putString("argTitle", this.title);
        }
        if(!TextUtils.isEmpty(this.desc)) {
            bundle0.putString("argDesc", this.desc);
        }
        if(!TextUtils.isEmpty(this.detailText)) {
            bundle0.putString("argDetailText", this.detailText);
        }
        if(!TextUtils.isEmpty(this.detailReplace)) {
            bundle0.putString("argDetailReplace", this.detailReplace);
        }
        if(!TextUtils.isEmpty(this.updateDate)) {
            bundle0.putString("argUpdateDate", this.updateDate);
        }
        if(!TextUtils.isEmpty(this.coverCacheKey)) {
            bundle0.putString("argCacheKey", this.coverCacheKey);
        }
        if(!TextUtils.isEmpty(this.coverImgUrl)) {
            bundle0.putString("argCoverImgUrl", this.coverImgUrl);
        }
        if(this.tagList != null && this.tagList.size() > 0) {
            bundle0.putSerializable("argTagList", this.tagList);
        }
        if(!TextUtils.isEmpty(this.strSongList)) {
            bundle0.putString("argSongList", this.strSongList);
        }
        if(!TextUtils.isEmpty(this.contsId)) {
            bundle0.putString("argContsIds", this.contsId);
        }
        if(this.getStatsElementsBase() != null) {
            bundle0.putString("argStatsElements", StatsElementsBase.toJsonString(this.getStatsElementsBase()));
        }
        bundle0.putBoolean("argIsDefaultSongContextPopup", this.isDefaultSongContextPopup);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        if(this.isSpecial) {
            Q4.a a0 = this.getHeaderBindingBase();
            q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderSpecialBinding");
            this.playlistDetailHeaderSpecialBinding = (F2)a0;
            ((F2)a0).d.setVisibility(8);
        }
        else {
            Q4.a a1 = this.getHeaderBindingBase();
            q.e(a1, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderBinding");
            this.setPlaylistDetailHeaderBinding(((E2)a1));
        }
        m0 m00 = this.getBinding();
        q.f(m00.d, "bottomDivider");
        this.bottomDivider = m00.d;
        m00.d.setVisibility(8);
    }

    private final void removeItemsIfExist(int v) {
        int v2;
        j0 j00 = this.mAdapter;
        if(j00 instanceof com.iloen.melon.adapters.common.p) {
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.PlaylistDetailAdapter");
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)((PlaylistDetailAdapter)j00).getItem(v);
            Object object0 = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getItem();
            if(!(object0 instanceof SongInfoBase)) {
                LogU.Companion.d("MixPlaylistDetailFragment", "removeItemsIfExist() - item is not SongInfoBase: " + object0);
                return;
            }
            long v1 = this.playSec;
            String s = ((SongInfoBase)object0).playTime;
            if(s == null) {
                v2 = 0;
            }
            else {
                Integer integer0 = v.t0(s);
                v2 = integer0 == null ? 0 : ((int)integer0);
            }
            this.playSec = v1 - ((long)v2);
            --this.mixSongCount;
            this.updateSongInfo();
            ((PlaylistDetailAdapter)j00).remove(v);
            if(this.mixSongCount == 0) {
                ((PlaylistDetailAdapter)j00).addEmptySongList();
            }
            ((PlaylistDetailAdapter)j00).notifyItemRangeChanged(v, ((PlaylistDetailAdapter)j00).getCount());
            this.setSelectAllWithToolbar(false);
        }
        TimeExpiredCache.getInstance().remove(this.getCacheKey());
    }

    private final void requestBanSong(Playable playable0, String s, int v) {
        Param myMusicInsertBanSongReq$Param0 = new Param();
        myMusicInsertBanSongReq$Param0.songId = "";
        myMusicInsertBanSongReq$Param0.menuId = "";
        myMusicInsertBanSongReq$Param0.reasonContsTypeCode = s;
        RequestBuilder.newInstance(new MyMusicInsertBanSongReq(this.getContext(), myMusicInsertBanSongReq$Param0)).tag("MixPlaylistDetailFragment").listener(new c(v, this, playable0)).request();
    }

    private static final void requestBanSong$lambda$35(MixPlaylistDetailFragment mixPlaylistDetailFragment0, int v, Playable playable0, MyMusicInsertBanSongRes myMusicInsertBanSongRes0) {
        if(myMusicInsertBanSongRes0 != null && myMusicInsertBanSongRes0.isSuccessful(true)) {
            mixPlaylistDetailFragment0.removeItemsIfExist(v);
            mixPlaylistDetailFragment0.requestTorosBanFeedback("", "");
        }
    }

    private final ForUDetailRes requestSongList() {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        Params forUDetailReq$Params0 = new Params();
        forUDetailReq$Params0.contsId = this.contsId;
        forUDetailReq$Params0.songIds = this.strSongList;
        forUDetailReq$Params0.seedContsId = this.getReqSeedContsId();
        return (ForUDetailRes)RequestBuilder.newInstance(new ForUDetailReq(this.getContext(), forUDetailReq$Params0)).tag("MixPlaylistDetailFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    public final void requestTorosBanFeedback(@Nullable String s, @Nullable String s1) {
        com.iloen.melon.net.v5x.request.ForUTorosBanFeedbackReq.Params forUTorosBanFeedbackReq$Params0 = new com.iloen.melon.net.v5x.request.ForUTorosBanFeedbackReq.Params();
        forUTorosBanFeedbackReq$Params0.impressionId = this.getImpressionId();
        forUTorosBanFeedbackReq$Params0.songId = s;
        forUTorosBanFeedbackReq$Params0.menuId = s1;
        RequestBuilder.newInstance(new ForUTorosBanFeedbackReq(this.getContext(), forUTorosBanFeedbackReq$Params0)).tag("MixPlaylistDetailFragment").listener(new com.google.android.exoplayer2.upstream.cache.a(14)).request();
    }

    private static final void requestTorosBanFeedback$lambda$36(Object object0) {
    }

    private final void restoreCoverInfoFromCache() {
        if(!TextUtils.isEmpty(this.coverCacheKey)) {
            Cursor cursor0 = a.f(this.getContext(), this.coverCacheKey);
            if(cursor0 != null && cursor0.getCount() != 0) {
                if("FORU_MIX_COVER_CACHE_KEY".equals(this.coverCacheKey)) {
                    this.foruMixInfo = (ForUMixInfoBase)a.d(cursor0, ForUMixInfoBase.class);
                }
                if(!cursor0.isClosed()) {
                    cursor0.close();
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void setDescText(@Nullable TextView textView0, @NotNull String s, @Nullable SpannableString spannableString0, int v, int v1) {
        q.g(s, "text");
        if(v1 > 5) {
            if(textView0 != null) {
                textView0.setMaxLines(v);
            }
        }
        else if(textView0 != null) {
            textView0.post(new W0(textView0, v, this, s, spannableString0, v1, 2));
        }
    }

    public final void setDescText(@NotNull String s, @Nullable SpannableString spannableString0) {
        SpannableString spannableString1;
        q.g(s, "desc");
        View view0 = this.descContainer;
        if(view0 != null) {
            view0.setVisibility(0);
        }
        int v = s.length();
        if(spannableString0 == null) {
            spannableString1 = new SpannableString(va.e.h(s, this.getString(0x7F130333)));  // string:dj_playlist_desc_fold " 접기"
        }
        else {
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(spannableString0).append(this.getString(0x7F130333));  // string:dj_playlist_desc_fold " 접기"
            q.f(spannableStringBuilder0, "append(...)");
            spannableString1 = SpannableString.valueOf(spannableStringBuilder0);
        }
        spannableString1.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06016D)), v, spannableString1.length(), 33);  // color:gray900s
        TextView textView0 = this.descLong;
        if(textView0 != null) {
            textView0.setText(spannableString1);
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.descContainer == null ? null : this.descContainer.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        View view1 = this.descLongContainer;
        if(view1 != null) {
            view1.setOnClickListener(new w(((LayoutParams)viewGroup$LayoutParams0), this));
        }
        this.setDescText(this.descShort, s, spannableString0, 2);
        View view2 = this.descShortContainer;
        if(view2 != null) {
            view2.setOnClickListener(new w(this, ((LayoutParams)viewGroup$LayoutParams0)));
        }
    }

    private static final void setDescText$lambda$15(LayoutParams constraintLayout$LayoutParams0, MixPlaylistDetailFragment mixPlaylistDetailFragment0, View view0) {
        constraintLayout$LayoutParams0.Q = ScreenUtils.dipToPixel(mixPlaylistDetailFragment0.getContext(), 40.0f);
        View view1 = mixPlaylistDetailFragment0.descShortContainer;
        if(view1 != null) {
            view1.setVisibility(0);
        }
        View view2 = mixPlaylistDetailFragment0.descLongContainer;
        if(view2 != null) {
            view2.setVisibility(8);
        }
    }

    private static final void setDescText$lambda$16(MixPlaylistDetailFragment mixPlaylistDetailFragment0, LayoutParams constraintLayout$LayoutParams0, View view0) {
        if(mixPlaylistDetailFragment0.descMore != null && mixPlaylistDetailFragment0.descMore.getVisibility() == 0) {
            constraintLayout$LayoutParams0.Q = 0x7FFFFFFF;
            View view1 = mixPlaylistDetailFragment0.descShortContainer;
            if(view1 != null) {
                view1.setVisibility(8);
            }
            View view2 = mixPlaylistDetailFragment0.descLongContainer;
            if(view2 != null) {
                view2.setVisibility(0);
            }
            mixPlaylistDetailFragment0.introduceMoreClickLog();
        }
    }

    private static final void setDescText$lambda$17(TextView textView0, int v, MixPlaylistDetailFragment mixPlaylistDetailFragment0, String s, SpannableString spannableString0, int v1) {
        try {
            if(textView0.getLineCount() > v) {
                View view0 = mixPlaylistDetailFragment0.descMore;
                if(view0 != null) {
                    view0.setVisibility(0);
                }
                int v2 = textView0.getLayout().getLineEnd(v - 1);
                if(v2 < s.length()) {
                    String s1 = s.substring(0, v2);
                    q.f(s1, "substring(...)");
                    SpannableString spannableString1 = spannableString0 == null ? s1 : spannableString0;
                    textView0.setText(spannableString1);
                    mixPlaylistDetailFragment0.setDescText(textView0, s1, spannableString0, v, v1 + 1);
                    return;
                }
                textView0.setMaxLines(v);
                return;
            }
            textView0.setMaxLines(v);
        }
        catch(Exception unused_ex) {
        }
    }

    private final void setTorosProperties(f f0, String s, String s1, Integer integer0) {
        if(!q.b(s, this.getString(0x7F130DD0)) && f0 != null) {  // string:tiara_common_action_name_select "선택"
            StatsElementsBase statsElementsBase0 = this.getStatsElementsBase();
            String s2 = null;
            f0.J = statsElementsBase0 == null ? null : statsElementsBase0.rangeCode;
            StatsElementsBase statsElementsBase1 = this.getStatsElementsBase();
            f0.L = statsElementsBase1 == null ? null : statsElementsBase1.impressionId;
            f0.N = this.getTiaraFileHashKey();
            f0.O = "app_user_id";
            f0.Q = this.getTiaraImpArea();
            f0.S = this.strSongList;
            StatsElementsBase statsElementsBase2 = this.getStatsElementsBase();
            f0.G = statsElementsBase2 == null ? null : statsElementsBase2.impressionId;
            StatsElementsBase statsElementsBase3 = this.getStatsElementsBase();
            if(statsElementsBase3 != null) {
                s2 = statsElementsBase3.impressionProvider;
            }
            f0.H = s2;
            if(integer0 != null) {
                f0.P = String.valueOf(((int)integer0));
            }
            f0.R = s1 == null || o.H0(s1) ? this.strSongList : s1;
            String s3 = H0.e.z(this.contsId);
            if(s3.equals("TYPE_FORU_ARTIST") || s3.equals("TYPE_FORU_RECENT_RECM_MIX")) {
                f0.T = this.getReqSeedContsId();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void showContextPopupFromSong(@Nullable Playable playable0, int v) {
        if(!this.isAdded() || !this.isPossiblePopupShow() || playable0 == null) {
            return;
        }
        if(this.isDefaultSongContextPopup) {
            super.showContextPopupSong(playable0);
            return;
        }
        C0 c00 = new C0(playable0, this.isPossibleBanned);
        com.melon.ui.popup.b.o(this.getChildFragmentManager(), c00, new x(v, this, playable0), 12);
    }

    private static final H showContextPopupFromSong$lambda$34(Playable playable0, MixPlaylistDetailFragment mixPlaylistDetailFragment0, int v, k2 k20) {
        q.g(k20, "moreListPopupOnEvent");
        H h0 = H.a;
        if(k20 instanceof M1) {
            q.f("", "getSongidString(...)");
            q.f("", "getSongName(...)");
            l1 l10 = new l1("", "", playable0.getArtistid(), mixPlaylistDetailFragment0.getStatsElements());
            mixPlaylistDetailFragment0.playMixUp(mixPlaylistDetailFragment0.mMenuId, l10);
            Context context0 = mixPlaylistDetailFragment0.getContext();
            PopupClickLogHelper.Companion.sendMorePopupPlayClickLog(context0, mixPlaylistDetailFragment0.mMenuId, playable0);
            return h0;
        }
        if(k20 instanceof h2) {
            q.f("", "getSongidString(...)");
            Navigator.open(StreamingCardFragment.Companion.newInstance(""));
            return h0;
        }
        if(k20 instanceof e2) {
            Navigator.openSimilarSongList("", "N10001");
            return h0;
        }
        if(k20 instanceof H1) {
            if(!mixPlaylistDetailFragment0.isLoginUser()) {
                mixPlaylistDetailFragment0.showLoginPopup();
                return h0;
            }
            mixPlaylistDetailFragment0.showKakaoProfileMusicPopup("", "", "");
            return h0;
        }
        if(k20 instanceof i2) {
            O.a(new UaLogDummyReq(mixPlaylistDetailFragment0.getContext(), "songListTiktok"));
            MelonLinkExecutor.open(((i2)k20).a, ((i2)k20).b);
            return h0;
        }
        if(k20 instanceof R1) {
            mixPlaylistDetailFragment0.setSelectAllWithToolbar(false);
            Navigator.open(SettingBannedContentsFragment.Companion.newInstance());
            return h0;
        }
        if(!(k20 instanceof K1)) {
            if(k20 instanceof J1) {
                Navigator.open(DetailLikePersonListFragment.newInstance("N10001", "N20001", ""));
                return h0;
            }
            if(k20 instanceof c2) {
                mixPlaylistDetailFragment0.shareData(playable0, "N10001");
                return h0;
            }
            if(k20 instanceof f2) {
                mixPlaylistDetailFragment0.showSongInfoPage(playable0);
                return h0;
            }
            if(k20 instanceof w1) {
                mixPlaylistDetailFragment0.showAlbumInfoPage(playable0);
                return h0;
            }
            if(k20 instanceof x1) {
                mixPlaylistDetailFragment0.showArtistInfoPage(playable0);
                return h0;
            }
            if(k20 instanceof N1) {
                mixPlaylistDetailFragment0.showMvInfoPage(playable0);
            }
        }
        else if(((K1)k20).b.a == M.R0) {
            mixPlaylistDetailFragment0.setSelectAllWithToolbar(false);
            q.f("N10001", "code(...)");
            mixPlaylistDetailFragment0.requestBanSong(playable0, "N10001", v);
            return h0;
        }
        return h0;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void showContextPopupPlaylistDetail() {
        if(this.isAdded() && this.isPossiblePopupShow()) {
            this.setSelectAllWithToolbar(false);
            com.melon.ui.popup.b.o(this.getChildFragmentManager(), new e0(this.contsId, this.title, "", this.mMenuId, this.thumbBitmap, this.coverBitmap, this.moreViewImgUrl), new com.iloen.melon.fragments.detail.f(this, 3), 12);
        }
    }

    private static final H showContextPopupPlaylistDetail$lambda$6(MixPlaylistDetailFragment mixPlaylistDetailFragment0, k2 k20) {
        q.g(k20, "moreListPopupOnEvent");
        H h0 = H.a;
        if(k20 instanceof F1) {
            if(mixPlaylistDetailFragment0.getSongCount() < 1) {
                ToastManager.show(0x7F13036E);  // string:download_available_empty "다운로드 가능한 곡이 없습니다."
                return h0;
            }
            mixPlaylistDetailFragment0.contextMenuCheckSongList(M.g);
            return h0;
        }
        if(k20 instanceof V1) {
            if(mixPlaylistDetailFragment0.getSongCount() < 1) {
                ToastManager.show(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                return h0;
            }
            mixPlaylistDetailFragment0.contextMenuCheckSongList(M.i);
        }
        return h0;
    }

    private final void updateForUMixCoverUi() {
        if(this.isSpecial) {
            String s = H0.e.z(this.contsId);
            LogU.Companion.d("MixPlaylistDetailFragment", "updateForUMixCoverUi() - coverType: " + s);
            if("TYPE_FORU_REMIND".equals(s) || "TYPE_FORU_YEAR_SUPERLIKE".equals(s) || "TYPE_FORU_MONTH_SUPERLIKE".equals(s) || "TYPE_FORU_BIRTH".equals(s)) {
                Context context3 = this.getContext();
                if(context3 != null) {
                    ImageView imageView2 = this.ivThumb;
                    if(imageView2 != null) {
                        imageView2.setVisibility(0);
                        Glide.with(context3).load(this.coverImgUrl).into(imageView2);
                        this.moreViewImgUrl = this.coverImgUrl;
                    }
                }
            }
            else {
                int v = 0x7F0A0D27;  // id:tv_text2
                int v1 = 0x7F0A069A;  // id:iv_thumb
                String s1 = null;
                if("TYPE_FORU_WELCOMEPICK".equals(s) || "TYPE_FORU_HOUR_MIX".equals(s) || "TYPE_FORU_USER_TASTE".equals(s)) {
                    View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0207, null, false);  // layout:detail_cover_special_type_b
                    View view3 = De.I.C(view2, 0x7F0A069A);  // id:iv_thumb
                    if(((MelonImageView)view3) == null) {
                        v = 0x7F0A069A;  // id:iv_thumb
                        throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v));
                    }
                    View view4 = De.I.C(view2, 0x7F0A0D26);  // id:tv_text1
                    if(((MelonTextView)view4) == null) {
                        v = 0x7F0A0D26;  // id:tv_text1
                        throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v));
                    }
                    View view5 = De.I.C(view2, 0x7F0A0D27);  // id:tv_text2
                    if(((MelonTextView)view5) == null) {
                        throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v));
                    }
                    J8.O o0 = new J8.O(view2, ((MelonImageView)view3), ((MelonTextView)view4), ((MelonTextView)view5), De.I.C(view2, 0x7F0A0DA0));  // id:v_text_anchor
                    F2 f24 = this.playlistDetailHeaderSpecialBinding;
                    if(f24 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f24.c.setVisibility(0);
                    F2 f25 = this.playlistDetailHeaderSpecialBinding;
                    if(f25 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f25.c.addView(view2);
                    this.getTitleBar().setImportantForAccessibility(1);
                    F2 f26 = this.playlistDetailHeaderSpecialBinding;
                    if(f26 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f26.c.setImportantForAccessibility(1);
                    F2 f27 = this.playlistDetailHeaderSpecialBinding;
                    if(f27 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    int v4 = this.getTitleBar().getId();
                    f27.c.setAccessibilityTraversalAfter(v4);
                    Context context2 = this.getContext();
                    if(context2 != null) {
                        ((MelonTextView)view4).setText((this.foruMixInfo == null ? null : this.foruMixInfo.getDetailImgText1()));
                        ForUMixInfoBase forUMixInfoBase2 = this.foruMixInfo;
                        if(forUMixInfoBase2 != null) {
                            s1 = forUMixInfoBase2.getDetailImgText2();
                        }
                        ((MelonTextView)view5).setText(s1);
                        ForUMixInfoBase forUMixInfoBase3 = this.foruMixInfo;
                        if(forUMixInfoBase3 != null) {
                            ArrayList arrayList1 = forUMixInfoBase3.getDetailImgUrls();
                            if(arrayList1 != null && arrayList1.size() > 0) {
                                ((com.bumptech.glide.RequestBuilder)Glide.with(context2).load(((String)arrayList1.get(0))).override(500)).into(new CustomTarget() {
                                    @Override  // com.bumptech.glide.request.target.Target
                                    public void onLoadCleared(Drawable drawable0) {
                                    }

                                    public void onResourceReady(Drawable drawable0, Transition transition0) {
                                        q.g(drawable0, "d");
                                        this.$specialCoverB.b.setImageDrawable(drawable0);
                                        if(drawable0 instanceof Animatable) {
                                            x1.a.l(((Animatable)drawable0));
                                        }
                                    }

                                    @Override  // com.bumptech.glide.request.target.Target
                                    public void onResourceReady(Object object0, Transition transition0) {
                                        this.onResourceReady(((Drawable)object0), transition0);
                                    }
                                });
                                this.moreViewImgUrl = (String)arrayList1.get(0);
                            }
                        }
                    }
                }
                else if("TYPE_FORU_DAILY_PICK".equals(s) || "TYPE_FORU_WEEKLY_PICK".equals(s) || "TYPE_FORU_NEW_SONGS".equals(s)) {
                    View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0209, null, false);  // layout:detail_cover_special_type_e
                    int v3 = 0x7F0A0617;  // id:iv_cover
                    ImageView imageView0 = (ImageView)De.I.C(view1, 0x7F0A0617);  // id:iv_cover
                    if(imageView0 == null) {
                        v1 = v3;
                        throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(v1));
                    }
                    v3 = 0x7F0A0656;  // id:iv_noimage
                    ImageView imageView1 = (ImageView)De.I.C(view1, 0x7F0A0656);  // id:iv_noimage
                    if(imageView1 == null) {
                        v1 = v3;
                        throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(v1));
                    }
                    MelonImageView melonImageView1 = (MelonImageView)De.I.C(view1, 0x7F0A069A);  // id:iv_thumb
                    if(melonImageView1 == null) {
                        throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(v1));
                    }
                    P p0 = new P(imageView0, imageView1, ((ConstraintLayout)view1), melonImageView1);
                    F2 f22 = this.playlistDetailHeaderSpecialBinding;
                    if(f22 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f22.c.setVisibility(0);
                    F2 f23 = this.playlistDetailHeaderSpecialBinding;
                    if(f23 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f23.c.addView(((ConstraintLayout)view1));
                    this.getTitleBar().setImportantForAccessibility(1);
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = melonImageView1.getLayoutParams();
                    if(viewGroup$LayoutParams0 != null) {
                        float f = ScreenUtils.isOrientationPortrait(this.getContext()) ? 0.8f : 1.0f;
                        ((LayoutParams)viewGroup$LayoutParams0).S = f;
                        ((LayoutParams)viewGroup$LayoutParams0).R = f;
                    }
                    Context context1 = this.getContext();
                    if(context1 != null) {
                        D d0 = this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new n(p0, context1, null) {
                            final Context $it;
                            final P $specialCoverE;
                            private Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;

                            {
                                MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                                this.$specialCoverE = p0;
                                this.$it = context0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.updateForUMixCoverUi.4.1(MixPlaylistDetailFragment.this, this.$specialCoverE, this.$it, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.updateForUMixCoverUi.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Bitmap bitmap0;
                                Deferred deferred1;
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getIO(), null, new n(MixPlaylistDetailFragment.this, null) {
                                            final Context $it;
                                            int label;

                                            {
                                                this.$it = context0;
                                                MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.updateForUMixCoverUi.4.1.coverImgDeferred.1(this.$it, MixPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.updateForUMixCoverUi.4.1.coverImgDeferred.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label == 0) {
                                                    d5.n.D(object0);
                                                    try {
                                                        com.bumptech.glide.RequestBuilder requestBuilder0 = Glide.with(this.$it).asBitmap();
                                                        ForUMixInfoBase forUMixInfoBase0 = MixPlaylistDetailFragment.this.foruMixInfo;
                                                        return (Bitmap)requestBuilder0.load((forUMixInfoBase0 == null ? null : forUMixInfoBase0.getMixDetailImageUrl())).submit().get();
                                                    }
                                                    catch(Exception unused_ex) {
                                                        return null;
                                                    }
                                                }
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }, 2, null);
                                        deferred1 = BuildersKt__Builders_commonKt.async$default(coroutineScope0, Dispatchers.getIO(), null, new n(MixPlaylistDetailFragment.this, null) {
                                            final Context $it;
                                            int label;

                                            {
                                                this.$it = context0;
                                                MixPlaylistDetailFragment.this = mixPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.updateForUMixCoverUi.4.1.insideImgDeferred.1(this.$it, MixPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.MixPlaylistDetailFragment.updateForUMixCoverUi.4.1.insideImgDeferred.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label == 0) {
                                                    d5.n.D(object0);
                                                    try {
                                                        com.bumptech.glide.RequestBuilder requestBuilder0 = Glide.with(this.$it).asBitmap();
                                                        ForUMixInfoBase forUMixInfoBase0 = MixPlaylistDetailFragment.this.foruMixInfo;
                                                        return (Bitmap)requestBuilder0.load((forUMixInfoBase0 == null ? null : forUMixInfoBase0.getMixDetailInsideImageUrl())).submit().get();
                                                    }
                                                    catch(Exception unused_ex) {
                                                        return null;
                                                    }
                                                }
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }, 2, null);
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = deferred1;
                                        this.label = 1;
                                        object0 = deferred0.await(this);
                                        if(object0 == a0) {
                                            return a0;
                                        }
                                        goto label_17;
                                    }
                                    case 1: {
                                        deferred1 = (Deferred)this.L$2;
                                        Deferred deferred2 = (Deferred)this.L$1;
                                        d5.n.D(object0);
                                    label_17:
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = (Bitmap)object0;
                                        this.label = 2;
                                        Object object1 = deferred1.await(this);
                                        if(object1 == a0) {
                                            return a0;
                                        }
                                        bitmap0 = (Bitmap)object0;
                                        object0 = object1;
                                        break;
                                    }
                                    case 2: {
                                        bitmap0 = (Bitmap)this.L$3;
                                        Deferred deferred3 = (Deferred)this.L$2;
                                        Deferred deferred4 = (Deferred)this.L$1;
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                MixPlaylistDetailFragment.this.coverBitmap = bitmap0;
                                MixPlaylistDetailFragment.this.thumbBitmap = (Bitmap)object0;
                                int v = 0;
                                if(bitmap0 != null) {
                                    this.$specialCoverE.b.setImageBitmap(bitmap0);
                                    this.$specialCoverE.d.setImageBitmap(((Bitmap)object0));
                                    MixPlaylistDetailFragment.this.thumbBitmap = (Bitmap)object0;
                                    ImageView imageView0 = this.$specialCoverE.c;
                                    if(((Bitmap)object0) != null) {
                                        v = 8;
                                    }
                                    imageView0.setVisibility(v);
                                    return H.a;
                                }
                                this.$specialCoverE.c.setVisibility(0);
                                return H.a;
                            }
                        }, 2, null);
                    }
                }
                else if("TYPE_FORU_MY_REPLAY".equals(s) || "TYPE_FORU_EVERYONE_SONG".equals(s)) {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0208, null, false);  // layout:detail_cover_special_type_d
                    MelonImageView melonImageView0 = (MelonImageView)De.I.C(view0, 0x7F0A069A);  // id:iv_thumb
                    if(melonImageView0 == null) {
                        v = 0x7F0A069A;  // id:iv_thumb
                        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
                    }
                    MelonTextView melonTextView0 = (MelonTextView)De.I.C(view0, 0x7F0A0D26);  // id:tv_text1
                    if(melonTextView0 == null) {
                        v = 0x7F0A0D26;  // id:tv_text1
                        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
                    }
                    MelonTextView melonTextView1 = (MelonTextView)De.I.C(view0, 0x7F0A0D27);  // id:tv_text2
                    if(melonTextView1 == null) {
                        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
                    }
                    De.I.C(view0, 0x7F0A0DA0);  // id:v_text_anchor
                    F2 f20 = this.playlistDetailHeaderSpecialBinding;
                    if(f20 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f20.c.setVisibility(0);
                    F2 f21 = this.playlistDetailHeaderSpecialBinding;
                    if(f21 == null) {
                        q.m("playlistDetailHeaderSpecialBinding");
                        throw null;
                    }
                    f21.c.addView(view0);
                    Context context0 = this.getContext();
                    if(context0 != null) {
                        melonTextView0.setText((this.foruMixInfo == null ? null : this.foruMixInfo.getDetailImgText1()));
                        melonTextView1.setText((this.foruMixInfo == null ? null : this.foruMixInfo.getDetailImgText2()));
                        ForUMixInfoBase forUMixInfoBase0 = this.foruMixInfo;
                        if(forUMixInfoBase0 != null) {
                            s1 = forUMixInfoBase0.getDetailTextShadowColor();
                        }
                        int v2 = ColorUtils.getColorFromHexStr(s1);
                        melonTextView0.setBackgroundColor(v2);
                        melonTextView1.setBackgroundColor(v2);
                        ForUMixInfoBase forUMixInfoBase1 = this.foruMixInfo;
                        if(forUMixInfoBase1 != null) {
                            ArrayList arrayList0 = forUMixInfoBase1.getDetailImgUrls();
                            if(arrayList0 != null && arrayList0.size() > 0) {
                                Glide.with(context0).load(((String)arrayList0.get(0))).into(melonImageView0);
                            }
                        }
                    }
                }
            }
        }
        else {
            ForUMixInfoBase forUMixInfoBase4 = this.foruMixInfo;
            if(forUMixInfoBase4 != null) {
                if(q.b("", "N10078")) {
                    kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h0.a = "";
                    CoverView coverView0 = this.coverView;
                    if(coverView0 != null) {
                        coverView0.setVisibility(0);
                        TemplateImageLoader templateImageLoader0 = new TemplateImageLoader(new Builder(coverView0, forUMixInfoBase4, BUILD_TYPE.DETAIL).build());
                        templateImageLoader0.load(new G0(this, coverView0, h0, templateImageLoader0));
                        ViewUtils.setContentDescriptionWithButtonClassName(this.coverView, this.getString(0x7F130BFB));  // string:talkback_playlist_thumb_cover "플레이리스트 커버 크게보기"
                        ViewUtils.setOnClickListener(this.coverView, new com.iloen.melon.fragments.a(templateImageLoader0, forUMixInfoBase4, this, h0, 2));
                    }
                }
                else {
                    LogU.Companion.w("MixPlaylistDetailFragment", "updateForUMixCoverUi() contsTypeCode is not mix type.");
                }
            }
        }
    }

    private static final void updateForUMixCoverUi$lambda$30$lambda$27$lambda$26(MixPlaylistDetailFragment mixPlaylistDetailFragment0, CoverView coverView0, kotlin.jvm.internal.H h0, TemplateImageLoader templateImageLoader0, Bitmap bitmap0) {
        q.g(bitmap0, "bitmap");
        mixPlaylistDetailFragment0.thumbBitmap = bitmap0;
        coverView0.setImageBitmap(bitmap0);
        h0.a = templateImageLoader0.captureWithCustomKey(coverView0, "withLogo");
    }

    private static final void updateForUMixCoverUi$lambda$30$lambda$29$lambda$28(TemplateImageLoader templateImageLoader0, ForUMixInfoBase forUMixInfoBase0, MixPlaylistDetailFragment mixPlaylistDetailFragment0, kotlin.jvm.internal.H h0, View view0) {
        if(templateImageLoader0.isCachingSuccess()) {
            String s = va.e.c("", ",", mixPlaylistDetailFragment0.getString(0x7F130AED));  // string:talkback_common_cover "커버"
            String s1 = (String)h0.a;
            String s2 = PhotoDetailUtils.INSTANCE.convertToAccessibilityDesc(s);
            Navigator.INSTANCE.openPhotoUrlWithTitle(s1, s2);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateHeaderView() {
        ForUDetailRes forUDetailRes0 = this.fetchDetailCacheData();
        this.mixDetailRes = forUDetailRes0;
        this.drawHeaderView(forUDetailRes0);
    }

    private final void updateSingleImageCoverUi() {
        if(this.coverImgUrl != null && !o.H0(this.coverImgUrl)) {
            Context context0 = this.getContext();
            if(context0 != null) {
                ImageView imageView0 = this.ivThumb;
                if(imageView0 != null) {
                    imageView0.setVisibility(0);
                    ViewUtils.setContentDescriptionWithButtonClassName(imageView0, this.getString(0x7F130BFB));  // string:talkback_playlist_thumb_cover "플레이리스트 커버 크게보기"
                    Glide.with(context0).load(this.coverImgUrl).into(imageView0);
                    ViewUtils.setOnClickListener(imageView0, new com.iloen.melon.fragments.detail.v(this, 1));
                }
            }
        }
    }

    private static final void updateSingleImageCoverUi$lambda$33$lambda$32$lambda$31(MixPlaylistDetailFragment mixPlaylistDetailFragment0, View view0) {
        Navigator.openPhotoUrl(mixPlaylistDetailFragment0.coverImgUrl);
    }

    public final void updateSongInfo() {
        TimeUnit timeUnit0 = TimeUnit.SECONDS;
        long v = timeUnit0.toHours(this.playSec);
        long v1 = timeUnit0.toMinutes(this.playSec) - 60L * v;
        String s = v == 0L ? this.getString(0x7F13033D, new Object[]{v1}) : this.getString(0x7F13033C, new Object[]{v, v1});  // string:dj_playlist_mix_time_min "%1$d분"
        q.d(s);
        this.setTotalPlayTime(s);
        this.setTotalSongCount(String.valueOf(this.mixSongCount));
        this.getHeaderData().setTotPlayTime(this.getTotalPlayTime());
        this.getHeaderData().setTotSongCnt(this.getTotalSongCount());
        this.updateSelectButton(this.mMarkedAll);
    }

    private final void updateStatusBar() {
        if(this.isSpecial) {
            boolean z = ScreenUtils.isDarkMode(this.getContext());
            Window window0 = null;
            if(Float.compare(this.alpha, 0.0f) <= 0) {
                FragmentActivity fragmentActivity0 = this.getActivity();
                if(fragmentActivity0 != null) {
                    window0 = fragmentActivity0.getWindow();
                }
                ScreenUtils.setAppearanceLightStatusBars(window0, !z);
                return;
            }
            FragmentActivity fragmentActivity1 = this.getActivity();
            if(fragmentActivity1 != null) {
                window0 = fragmentActivity1.getWindow();
            }
            ScreenUtils.setAppearanceLightStatusBars(window0, false);
        }
    }
}

