package com.iloen.melon.fragments.detail;

import A7.d;
import De.I;
import J8.b2;
import J8.t0;
import U4.x;
import Vb.i;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.ToggleButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.UnderlineTextView;
import com.iloen.melon.custom.VerticalTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.SnsHlyricsUploadReq.Params;
import com.iloen.melon.net.v6x.request.SnsHlyricsUploadReq;
import com.iloen.melon.net.v6x.request.SongLyricHighlightPostReq;
import com.iloen.melon.net.v6x.response.SnsHlyricsUploadRes;
import com.iloen.melon.net.v6x.response.SongLyricHighlightPostRes.RESPONSE.POSTIMAGELIST;
import com.iloen.melon.net.v6x.response.SongLyricHighlightPostRes.RESPONSE.POSTINFO;
import com.iloen.melon.net.v6x.response.SongLyricHighlightPostRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongLyricHighlightPostRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableHighlight;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageSelector.ImageSelectorListener;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import d3.g;
import e.k;
import ie.H;
import ie.j;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.s;
import v9.h;
import we.n;

@Metadata(d1 = {"\u0000\u00D2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u00BB\u0001\b\u0007\u0018\u0000 \u00C8\u00012\u00020\u00012\u00020\u0002:\b\u00C8\u0001\u00C9\u0001\u00CA\u0001\u00CB\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0004J\u000F\u0010\u0019\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u001A\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\u00152\u0006\u0010\u001D\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001CJ-\u0010$\u001A\u00020\u00052\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010#\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b$\u0010%J\u001D\u0010)\u001A\b\u0012\u0002\b\u0003\u0018\u00010(2\u0006\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b)\u0010*J\u0011\u0010,\u001A\u0004\u0018\u00010+H\u0014\u00A2\u0006\u0004\b,\u0010-J\u0015\u00100\u001A\u00020\u00152\u0006\u0010/\u001A\u00020.\u00A2\u0006\u0004\b0\u00101J\u0011\u00103\u001A\u0004\u0018\u000102H\u0014\u00A2\u0006\u0004\b3\u00104J\u0017\u00105\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b5\u00106J\u000F\u00107\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b7\u0010\u0004J!\u0010:\u001A\u00020\u00152\u0006\u00108\u001A\u00020\b2\b\b\u0002\u00109\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b:\u0010;J!\u0010=\u001A\u00020\u00152\u0006\u0010<\u001A\u00020.2\b\b\u0002\u00109\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b=\u0010>J!\u0010@\u001A\u00020\u00152\u0006\u0010?\u001A\u00020.2\b\b\u0002\u00109\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b@\u0010>J\'\u0010F\u001A\u00020\u00152\u0006\u0010B\u001A\u00020A2\u0006\u0010D\u001A\u00020C2\u0006\u0010E\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bF\u0010GJ\u000F\u0010H\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\bH\u0010\u0004J\u000F\u0010I\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bI\u0010\u0007J\'\u0010O\u001A\u0012\u0012\u0004\u0012\u00020M0Lj\b\u0012\u0004\u0012\u00020M`N2\u0006\u0010K\u001A\u00020JH\u0002\u00A2\u0006\u0004\bO\u0010PJ\u0011\u0010R\u001A\u0004\u0018\u00010QH\u0002\u00A2\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001A\u00020U2\b\u0010T\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\bV\u0010WJ\u0019\u0010Z\u001A\u00020\u00152\b\u0010Y\u001A\u0004\u0018\u00010XH\u0002\u00A2\u0006\u0004\bZ\u0010[J\'\u0010_\u001A\u00020\u00152\u0006\u0010K\u001A\u00020\\2\u0006\u0010]\u001A\u00020.2\u0006\u0010^\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b_\u0010`J\u0017\u0010b\u001A\u00020\u00152\u0006\u0010a\u001A\u00020.H\u0002\u00A2\u0006\u0004\bb\u00101J\u0017\u0010d\u001A\u00020\u00152\u0006\u0010c\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bd\u0010eJ\u001F\u0010h\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010Q0g2\u0006\u0010f\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bh\u0010iJ!\u0010j\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u00112\u0006\u0010f\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bj\u0010kJ\u000F\u0010l\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\bl\u0010\u0004J+\u0010n\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020&2\b\u0010\u0014\u001A\u0004\u0018\u00010\u00112\b\b\u0002\u0010m\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bn\u0010oJ\u0011\u0010q\u001A\u0004\u0018\u00010pH\u0002\u00A2\u0006\u0004\bq\u0010rR\u0018\u0010t\u001A\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010f\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010vR\u0016\u0010w\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bw\u0010vR\u0016\u0010x\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bz\u0010yR\u0016\u0010{\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010}\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b}\u0010|R\u0016\u0010c\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010vR\u0016\u0010~\u001A\u00020.8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b~\u0010yR\u0017\u0010\u007F\u001A\u00020\\8\u0002@\u0002X\u0082.\u00A2\u0006\u0007\n\u0005\b\u007F\u0010\u0080\u0001R\u001C\u0010\u0082\u0001\u001A\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001C\u0010\u0085\u0001\u001A\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001B\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001B\u0010\u0089\u0001\u001A\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008A\u0001R\u001B\u0010\u008B\u0001\u001A\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008B\u0001\u0010\u008A\u0001R\u001C\u0010\u008D\u0001\u001A\u0005\u0018\u00010\u008C\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\u001C\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001C\u0010\u0092\u0001\u001A\u0005\u0018\u00010\u008F\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0091\u0001R\u001C\u0010\u0093\u0001\u001A\u0005\u0018\u00010\u008F\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0091\u0001R\u001C\u0010\u0094\u0001\u001A\u0005\u0018\u00010\u008F\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0091\u0001R\u001C\u0010\u0096\u0001\u001A\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001C\u0010\u0098\u0001\u001A\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u001C\u0010\u009A\u0001\u001A\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009A\u0001\u0010\u009B\u0001R\u001C\u0010\u009D\u0001\u001A\u0005\u0018\u00010\u009C\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009D\u0001\u0010\u009E\u0001R\u001B\u0010\u009F\u0001\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009F\u0001\u0010\u0088\u0001R\u001B\u0010\u00A0\u0001\u001A\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A0\u0001\u0010\u0088\u0001R\u001C\u0010\u00A2\u0001\u001A\u0005\u0018\u00010\u00A1\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A2\u0001\u0010\u00A3\u0001R\u001C\u0010\u00A5\u0001\u001A\u0005\u0018\u00010\u00A4\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A5\u0001\u0010\u00A6\u0001R\u001B\u0010\u00A7\u0001\u001A\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u00A8\u0001R-\u0010\u00A9\u0001\u001A\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010Lj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`N8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001R\u001C\u0010\u00AC\u0001\u001A\u00070\u00AB\u0001R\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AC\u0001\u0010\u00AD\u0001R\u001C\u0010\u00AF\u0001\u001A\u0005\u0018\u00010\u00AE\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AF\u0001\u0010\u00B0\u0001R\u001B\u0010\u00B1\u0001\u001A\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00B1\u0001\u0010\u00B2\u0001R\u0018\u0010\u00B4\u0001\u001A\u00030\u00B3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00B4\u0001\u0010\u00B5\u0001R0\u0010\u00BA\u0001\u001A\u0012\u0012\u0004\u0012\u00020M0Lj\b\u0012\u0004\u0012\u00020M`N8BX\u0082\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u00B6\u0001\u0010\u00B7\u0001\u001A\u0006\b\u00B8\u0001\u0010\u00B9\u0001R\u0018\u0010\u00BC\u0001\u001A\u00030\u00BB\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BC\u0001\u0010\u00BD\u0001R\u0018\u0010\u00BF\u0001\u001A\u00030\u00BE\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00BF\u0001\u0010\u00C0\u0001R\u0018\u0010\u00C2\u0001\u001A\u00030\u00C1\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00C2\u0001\u0010\u00C3\u0001R\u0018\u0010\u00C7\u0001\u001A\u00030\u00C4\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00C5\u0001\u0010\u00C6\u0001\u00A8\u0006\u00CC\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "isScreenLandscapeSupported", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onDestroyView", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "position", "updateBgSelect", "(I)V", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "initView", "(Landroid/view/View;)V", "initButtonFocus", "textColorType", "fromInit", "updateTextColorButton", "(Ljava/lang/String;Z)V", "selectType", "updateRatioButton", "(IZ)V", "designType", "updateDesignButton", "Lcom/iloen/melon/custom/MelonImageView;", "imageView", "Landroid/widget/ToggleButton;", "toggleButton", "isCheck", "checkAndUpdateButton", "(Lcom/iloen/melon/custom/MelonImageView;Landroid/widget/ToggleButton;Z)V", "initInnerRecyclerView", "isTypeNote", "Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes$RESPONSE;", "res", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgData;", "Lkotlin/collections/ArrayList;", "setBgList", "(Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes$RESPONSE;)Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes;", "fetchData", "()Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes;", "imageUrl", "Lkotlinx/coroutines/Job;", "drawBg", "(Ljava/lang/String;)Lkotlinx/coroutines/Job;", "Landroid/graphics/Bitmap;", "bitmap", "setHighlightBg", "(Landroid/graphics/Bitmap;)V", "Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes$RESPONSE$POSTINFO;", "viewType", "callFrom", "updateLyricUi", "(Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes$RESPONSE$POSTINFO;ILjava/lang/String;)V", "ratio", "updateAspectRatio", "textColor", "updateLyricTextColor", "(Ljava/lang/String;)V", "songId", "Lkotlinx/coroutines/Deferred;", "requestSongLyricHighlightPostAsync", "(Ljava/lang/String;)Lkotlinx/coroutines/Deferred;", "shareHighlightImage", "(Landroid/view/View;Ljava/lang/String;)V", "deleteImageFileAfterShare", "usePrivateStorage", "saveHighlightFileFromView", "(Landroid/content/Context;Landroid/view/View;Z)Z", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "LJ8/t0;", "binding", "LJ8/t0;", "Ljava/lang/String;", "songName", "selectedPos", "I", "currentType", "isTypeChanged", "Z", "isNickNameChanged", "aspectRatio", "postInfoRes", "Lcom/iloen/melon/net/v6x/response/SongLyricHighlightPostRes$RESPONSE$POSTINFO;", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$ShareImageData;", "shareImageData", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$ShareImageData;", "Landroid/net/Uri;", "savedImageUri", "Landroid/net/Uri;", "thumbContainer", "Landroid/view/View;", "bgHighlight", "Lcom/iloen/melon/custom/MelonImageView;", "ivDefaultCover", "Lcom/iloen/melon/custom/VerticalTextView;", "tvVerticalNickName", "Lcom/iloen/melon/custom/VerticalTextView;", "Lcom/iloen/melon/custom/MelonTextView;", "tvHorizonNickName", "Lcom/iloen/melon/custom/MelonTextView;", "tvSong", "tvArtist", "tvLyric", "Landroid/widget/ImageView;", "ivQuoteLeft", "Landroid/widget/ImageView;", "ivQuoteRight", "Landroid/widget/FrameLayout;", "albumContainer", "Landroid/widget/FrameLayout;", "Lcom/iloen/melon/custom/UnderlineTextView;", "underlineTvLyric", "Lcom/iloen/melon/custom/UnderlineTextView;", "type2TopUnderline", "vDash", "Landroid/widget/RelativeLayout;", "itemContainer", "Landroid/widget/RelativeLayout;", "Landroid/widget/ScrollView;", "scrollView", "Landroid/widget/ScrollView;", "toggleNickName", "Landroid/widget/ToggleButton;", "bgSelectViewGroup", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgInnerAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgInnerAdapter;", "", "bgImg", "Ljava/lang/Object;", "bgImgAsBitmap", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatcherMain", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "bgList$delegate", "Lie/j;", "getBgList", "()Ljava/util/ArrayList;", "bgList", "com/iloen/melon/fragments/detail/LyricHighLightShareFragment$imageSelectorListener$1", "imageSelectorListener", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$imageSelectorListener$1;", "Lcom/iloen/melon/utils/image/ImageSelector;", "imageSelector", "Lcom/iloen/melon/utils/image/ImageSelector;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "BgInnerAdapter", "ShareImageData", "BgData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LyricHighLightShareFragment extends MetaContentBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0010\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J1\u0010\u0012\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgData;", "", "itemType", "", "thumbImage", "largeImage", "voiceOverText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getItemType", "()Ljava/lang/String;", "getThumbImage", "getLargeImage", "getVoiceOverText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class BgData {
        @NotNull
        private final String itemType;
        @NotNull
        private final String largeImage;
        @NotNull
        private final String thumbImage;
        @NotNull
        private final String voiceOverText;

        public BgData(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
            q.g(s, "itemType");
            q.g(s1, "thumbImage");
            q.g(s2, "largeImage");
            q.g(s3, "voiceOverText");
            super();
            this.itemType = s;
            this.thumbImage = s1;
            this.largeImage = s2;
            this.voiceOverText = s3;
        }

        public BgData(String s, String s1, String s2, String s3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            this(s, s1, s2, s3);
        }

        @NotNull
        public final String component1() {
            return this.itemType;
        }

        @NotNull
        public final String component2() {
            return this.thumbImage;
        }

        @NotNull
        public final String component3() {
            return this.largeImage;
        }

        @NotNull
        public final String component4() {
            return this.voiceOverText;
        }

        @NotNull
        public final BgData copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
            q.g(s, "itemType");
            q.g(s1, "thumbImage");
            q.g(s2, "largeImage");
            q.g(s3, "voiceOverText");
            return new BgData(s, s1, s2, s3);
        }

        public static BgData copy$default(BgData lyricHighLightShareFragment$BgData0, String s, String s1, String s2, String s3, int v, Object object0) {
            if((v & 1) != 0) {
                s = lyricHighLightShareFragment$BgData0.itemType;
            }
            if((v & 2) != 0) {
                s1 = lyricHighLightShareFragment$BgData0.thumbImage;
            }
            if((v & 4) != 0) {
                s2 = lyricHighLightShareFragment$BgData0.largeImage;
            }
            if((v & 8) != 0) {
                s3 = lyricHighLightShareFragment$BgData0.voiceOverText;
            }
            return lyricHighLightShareFragment$BgData0.copy(s, s1, s2, s3);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof BgData)) {
                return false;
            }
            if(!q.b(this.itemType, ((BgData)object0).itemType)) {
                return false;
            }
            if(!q.b(this.thumbImage, ((BgData)object0).thumbImage)) {
                return false;
            }
            return q.b(this.largeImage, ((BgData)object0).largeImage) ? q.b(this.voiceOverText, ((BgData)object0).voiceOverText) : false;
        }

        @NotNull
        public final String getItemType() {
            return this.itemType;
        }

        @NotNull
        public final String getLargeImage() {
            return this.largeImage;
        }

        @NotNull
        public final String getThumbImage() {
            return this.thumbImage;
        }

        @NotNull
        public final String getVoiceOverText() {
            return this.voiceOverText;
        }

        @Override
        public int hashCode() {
            return this.voiceOverText.hashCode() + x.b(x.b(this.itemType.hashCode() * 0x1F, 0x1F, this.thumbImage), 0x1F, this.largeImage);
        }

        @Override
        @NotNull
        public String toString() {
            return d.n(d.o("BgData(itemType=", this.itemType, ", thumbImage=", this.thumbImage, ", largeImage="), this.largeImage, ", voiceOverText=", this.voiceOverText, ")");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001A\u00020\t2\u0016\u0010\b\u001A\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0015\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0017\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgInnerAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgData;", "Lkotlin/collections/ArrayList;", "list", "Lie/H;", "setData", "(Ljava/util/ArrayList;)V", "", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "ItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class BgInnerAdapter extends j0 {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\r\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/b2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgInnerAdapter;LJ8/b2;)V", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgData;", "bgData", "", "position", "Lie/H;", "bindItem", "(Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$BgData;I)V", "bind", "LJ8/b2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ItemViewHolder extends O0 {
            @NotNull
            private final b2 bind;

            public ItemViewHolder(@NotNull b2 b20) {
                q.g(b20, "binding");
                BgInnerAdapter.this = lyricHighLightShareFragment$BgInnerAdapter0;
                super(b20.a);
                this.bind = b20;
            }

            public final void bindItem(@NotNull BgData lyricHighLightShareFragment$BgData0, int v) {
                q.g(lyricHighLightShareFragment$BgData0, "bgData");
                String s = lyricHighLightShareFragment$BgData0.getThumbImage();
                String s1 = lyricHighLightShareFragment$BgData0.getLargeImage();
                String s2 = lyricHighLightShareFragment$BgData0.getItemType();
                int v1 = 0;
                String s3 = null;
                if(q.b(s2, "bgCamera")) {
                    this.bind.b.setImageResource(0x7F080209);  // drawable:btn_lyrics_gallery
                    this.bind.b.setBackgroundResource(0x7F0808F4);  // drawable:shape_rectangle_round4_gray200s_stroke_1dp
                    MelonImageView melonImageView0 = this.bind.b;
                    if(LyricHighLightShareFragment.this.getContext() != null) {
                        s3 = "사진 선택 버튼";
                    }
                    melonImageView0.setContentDescription(s3);
                }
                else if(q.b(s2, "bgDefault")) {
                    this.bind.c.setVisibility((LyricHighLightShareFragment.this.bgImgAsBitmap == null ? 0 : 8));
                    Context context0 = LyricHighLightShareFragment.this.getContext();
                    if(context0 != null) {
                        Glide.with(context0).load(LyricHighLightShareFragment.this.bgImgAsBitmap).into(this.bind.b);
                    }
                    MelonImageView melonImageView1 = this.bind.b;
                    if(LyricHighLightShareFragment.this.getContext() != null) {
                        s3 = "배경 버튼, 앨범 커버 색상";
                    }
                    melonImageView1.setContentDescription(s3);
                }
                else if(q.b(s2, "bgItem")) {
                    Context context1 = LyricHighLightShareFragment.this.getContext();
                    if(context1 != null) {
                        Glide.with(context1).load(s).into(this.bind.b);
                    }
                    this.bind.b.setContentDescription(lyricHighLightShareFragment$BgData0.getVoiceOverText());
                }
                else if(q.b(s2, "bgCameraAlbum")) {
                    Context context2 = LyricHighLightShareFragment.this.getContext();
                    if(context2 != null) {
                        ((RequestBuilder)Glide.with(context2).load(s).signature(new ObjectKey(System.currentTimeMillis()))).into(this.bind.b);
                    }
                    MelonImageView melonImageView2 = this.bind.b;
                    if(LyricHighLightShareFragment.this.getContext() != null) {
                        s3 = "선택한 사진 버튼";
                    }
                    melonImageView2.setContentDescription(s3);
                }
                ArrayList arrayList0 = LyricHighLightShareFragment.this.bgSelectViewGroup;
                if(arrayList0 != null && arrayList0.size() != BgInnerAdapter.this.getItemCount()) {
                    arrayList0.add(this.bind.d);
                }
                MelonImageView melonImageView3 = this.bind.d;
                if(v != LyricHighLightShareFragment.this.selectedPos) {
                    v1 = 8;
                }
                melonImageView3.setVisibility(v1);
                r r0 = new r(v, LyricHighLightShareFragment.this, lyricHighLightShareFragment$BgData0, this, s1);
                this.bind.b.setOnClickListener(r0);
            }

            private static final void bindItem$lambda$8(int v, LyricHighLightShareFragment lyricHighLightShareFragment0, BgData lyricHighLightShareFragment$BgData0, ItemViewHolder lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0, String s, View view0) {
                if(v == 0 || v != lyricHighLightShareFragment0.selectedPos) {
                    lyricHighLightShareFragment0.selectedPos = v;
                    String s1 = lyricHighLightShareFragment$BgData0.getItemType();
                    String s2 = "";
                    if(q.b(s1, "bgCamera")) {
                        if(34 == lyricHighLightShareFragment0.aspectRatio) {
                            lyricHighLightShareFragment0.imageSelector.setAspectRatio(3, 4);
                        }
                        else {
                            lyricHighLightShareFragment0.imageSelector.setAspectRatio(1, 1);
                        }
                        lyricHighLightShareFragment0.imageSelector.startSelector(Request.newNormalImage("tag_highlight"), null, false, null);
                        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
                        if(f0 != null) {
                            if(lyricHighLightShareFragment0.getContext() != null) {
                                s2 = "이미지불러오기";
                            }
                            f0.F = s2;
                            f0.a().track();
                        }
                    }
                    else {
                        if(q.b(s1, "bgDefault")) {
                            Bitmap bitmap0 = lyricHighLightShareFragment0.bgImgAsBitmap;
                            if(bitmap0 == null) {
                                lyricHighLightShareFragment0.bgImg = lyricHighLightShareFragment0.bgImgAsBitmap;
                                MelonImageView melonImageView0 = lyricHighLightShareFragment0.bgHighlight;
                                if(melonImageView0 != null) {
                                    melonImageView0.setImageBitmap(null);
                                }
                            }
                            else {
                                lyricHighLightShareFragment0.setHighlightBg(bitmap0);
                            }
                            lyricHighLightShareFragment0.updateBgSelect(lyricHighLightShareFragment0.selectedPos);
                        }
                        else if(q.b(s1, "bgItem")) {
                            lyricHighLightShareFragment0.bgImg = s;
                            RequestBuilder requestBuilder0 = Glide.with(view0).load(lyricHighLightShareFragment0.bgImg);
                            MelonImageView melonImageView1 = lyricHighLightShareFragment0.bgHighlight;
                            q.e(melonImageView1, "null cannot be cast to non-null type android.widget.ImageView");
                            requestBuilder0.into(melonImageView1);
                            lyricHighLightShareFragment0.updateBgSelect(lyricHighLightShareFragment0.selectedPos);
                        }
                        else if(q.b(s1, "bgCameraAlbum")) {
                            lyricHighLightShareFragment0.bgImg = s;
                            RequestBuilder requestBuilder1 = (RequestBuilder)Glide.with(view0).load(lyricHighLightShareFragment0.bgImg).signature(new ObjectKey(System.currentTimeMillis()));
                            MelonImageView melonImageView2 = lyricHighLightShareFragment0.bgHighlight;
                            q.e(melonImageView2, "null cannot be cast to non-null type android.widget.ImageView");
                            requestBuilder1.into(melonImageView2);
                            lyricHighLightShareFragment0.updateBgSelect(lyricHighLightShareFragment0.selectedPos);
                            lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0.bind.d.setVisibility(0);
                        }
                        f f1 = lyricHighLightShareFragment0.getTiaraEventBuilder();
                        if(f1 != null) {
                            if(lyricHighLightShareFragment0.getContext() != null) {
                                s2 = "기본배경변경";
                            }
                            f1.F = s2;
                            f1.a().track();
                        }
                    }
                }
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return LyricHighLightShareFragment.this.getBgList().size();
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            return v;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            q.g(o00, "holder");
            ItemViewHolder lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0 = o00 instanceof ItemViewHolder ? ((ItemViewHolder)o00) : null;
            if(lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0 != null) {
                Object object0 = LyricHighLightShareFragment.this.getBgList().get(v);
                q.f(object0, "get(...)");
                lyricHighLightShareFragment$BgInnerAdapter$ItemViewHolder0.bindItem(((BgData)object0), v);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(LyricHighLightShareFragment.this.getContext()).inflate(0x7F0D0494, viewGroup0, false);  // layout:listitem_highlight_bg
            int v1 = 0x7F0A05FE;  // id:iv_bg
            MelonImageView melonImageView0 = (MelonImageView)I.C(view0, 0x7F0A05FE);  // id:iv_bg
            if(melonImageView0 != null) {
                v1 = 0x7F0A061A;  // id:iv_default_cover
                CardView cardView0 = (CardView)I.C(view0, 0x7F0A061A);  // id:iv_default_cover
                if(cardView0 != null) {
                    v1 = 0x7F0A0687;  // id:iv_select
                    MelonImageView melonImageView1 = (MelonImageView)I.C(view0, 0x7F0A0687);  // id:iv_select
                    if(melonImageView1 != null) {
                        return new ItemViewHolder(this, new b2(((FrameLayout)view0), melonImageView0, cardView0, melonImageView1));
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
        }

        public final void setData(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "list");
            ArrayList arrayList1 = new ArrayList();
            LyricHighLightShareFragment.this.bgSelectViewGroup = arrayList1;
            ArrayList arrayList2 = LyricHighLightShareFragment.this.getBgList();
            if(arrayList2 == null || !arrayList2.isEmpty()) {
                for(Object object0: arrayList2) {
                    if(q.b(((BgData)object0).getItemType(), "bgItem")) {
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            LyricHighLightShareFragment.this.getBgList().addAll(arrayList0);
            this.notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$Companion;", "", "<init>", "()V", "TAG", "", "TAG_HIGHLIGHT", "HIGHLIGHT_FILE_NAME", "ARG_TEXT_COLOR", "ARG_RATIO", "TEXT_COLOR_WHITE", "TEXT_COLOR_BLACK", "BG_DEFAULT", "BG_CAMERA", "BG_CAMERA_ALBUM", "BG_ITEM", "DEFAULT_SELECTED_POS", "", "VIEW_TYPE_DIALOG", "VIEW_TYPE_NOTE", "VIEW_TYPE_ALBUM", "SQUARE_MAXLINE", "RECT_MAXLINE", "RATIO_SQUARE", "RATIO_RECTANGLE", "log", "Lcom/iloen/melon/utils/log/LogU;", "newInstance", "Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment;", "songId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LyricHighLightShareFragment newInstance(@NotNull String s) {
            q.g(s, "songId");
            LyricHighLightShareFragment lyricHighLightShareFragment0 = new LyricHighLightShareFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            lyricHighLightShareFragment0.setArguments(bundle0);
            return lyricHighLightShareFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/LyricHighLightShareFragment$ShareImageData;", "", "shareImagePath", "", "shareImageAccessKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShareImagePath", "()Ljava/lang/String;", "getShareImageAccessKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ShareImageData {
        @Nullable
        private final String shareImageAccessKey;
        @Nullable
        private final String shareImagePath;

        public ShareImageData(@Nullable String s, @Nullable String s1) {
            this.shareImagePath = s;
            this.shareImageAccessKey = s1;
        }

        @Nullable
        public final String getShareImageAccessKey() {
            return this.shareImageAccessKey;
        }

        @Nullable
        public final String getShareImagePath() {
            return this.shareImagePath;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_RATIO = null;
    @NotNull
    private static final String ARG_TEXT_COLOR = null;
    @NotNull
    private static final String BG_CAMERA = null;
    @NotNull
    private static final String BG_CAMERA_ALBUM = null;
    @NotNull
    private static final String BG_DEFAULT = null;
    @NotNull
    private static final String BG_ITEM = null;
    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_SELECTED_POS = 0;
    @NotNull
    private static final String HIGHLIGHT_FILE_NAME = null;
    private static final int RATIO_RECTANGLE = 0;
    private static final int RATIO_SQUARE = 0;
    private static final int RECT_MAXLINE = 0;
    private static final int SQUARE_MAXLINE = 0;
    @NotNull
    private static final String TAG = "LyricHighLightShareFragment";
    @NotNull
    private static final String TAG_HIGHLIGHT;
    @NotNull
    private static final String TEXT_COLOR_BLACK;
    @NotNull
    private static final String TEXT_COLOR_WHITE;
    private static final int VIEW_TYPE_ALBUM;
    private static final int VIEW_TYPE_DIALOG;
    private static final int VIEW_TYPE_NOTE;
    @Nullable
    private FrameLayout albumContainer;
    private int aspectRatio;
    @Nullable
    private MelonImageView bgHighlight;
    @Nullable
    private Object bgImg;
    @Nullable
    private Bitmap bgImgAsBitmap;
    @NotNull
    private final j bgList$delegate;
    @Nullable
    private ArrayList bgSelectViewGroup;
    @Nullable
    private t0 binding;
    private int currentType;
    @NotNull
    private final MainCoroutineDispatcher dispatcherMain;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    @NotNull
    private final ImageSelector imageSelector;
    @NotNull
    private final com.iloen.melon.fragments.detail.LyricHighLightShareFragment.imageSelectorListener.1 imageSelectorListener;
    @NotNull
    private final BgInnerAdapter innerAdapter;
    private boolean isNickNameChanged;
    private boolean isTypeChanged;
    @Nullable
    private RelativeLayout itemContainer;
    @Nullable
    private MelonImageView ivDefaultCover;
    @Nullable
    private ImageView ivQuoteLeft;
    @Nullable
    private ImageView ivQuoteRight;
    @NotNull
    private static final LogU log;
    private POSTINFO postInfoRes;
    @Nullable
    private Uri savedImageUri;
    @Nullable
    private ScrollView scrollView;
    private int selectedPos;
    @Nullable
    private ShareImageData shareImageData;
    @NotNull
    private String songId;
    @NotNull
    private String songName;
    @NotNull
    private String textColor;
    @Nullable
    private View thumbContainer;
    @Nullable
    private ToggleButton toggleNickName;
    @Nullable
    private MelonTextView tvArtist;
    @Nullable
    private MelonTextView tvHorizonNickName;
    @Nullable
    private MelonTextView tvLyric;
    @Nullable
    private MelonTextView tvSong;
    @Nullable
    private VerticalTextView tvVerticalNickName;
    @Nullable
    private View type2TopUnderline;
    @Nullable
    private UnderlineTextView underlineTvLyric;
    @Nullable
    private View vDash;

    static {
        LyricHighLightShareFragment.Companion = new Companion(null);
        LyricHighLightShareFragment.$stable = 8;
        LyricHighLightShareFragment.TAG_HIGHLIGHT = "tag_highlight";
        LyricHighLightShareFragment.HIGHLIGHT_FILE_NAME = "melon_highlight_";
        LyricHighLightShareFragment.ARG_TEXT_COLOR = "argTextColor";
        LyricHighLightShareFragment.ARG_RATIO = "argRatio";
        LyricHighLightShareFragment.TEXT_COLOR_WHITE = "textColorWhite";
        LyricHighLightShareFragment.TEXT_COLOR_BLACK = "textColorBlack";
        LyricHighLightShareFragment.BG_DEFAULT = "bgDefault";
        LyricHighLightShareFragment.BG_CAMERA = "bgCamera";
        LyricHighLightShareFragment.BG_CAMERA_ALBUM = "bgCameraAlbum";
        LyricHighLightShareFragment.BG_ITEM = "bgItem";
        LyricHighLightShareFragment.DEFAULT_SELECTED_POS = 1;
        LyricHighLightShareFragment.VIEW_TYPE_NOTE = 1;
        LyricHighLightShareFragment.VIEW_TYPE_ALBUM = 2;
        LyricHighLightShareFragment.SQUARE_MAXLINE = 5;
        LyricHighLightShareFragment.RECT_MAXLINE = 7;
        LyricHighLightShareFragment.RATIO_SQUARE = 11;
        LyricHighLightShareFragment.RATIO_RECTANGLE = 34;
        LyricHighLightShareFragment.log = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "LyricHighLightShareFragment", false, Category.UI, 2, null);
    }

    public LyricHighLightShareFragment() {
        this.songId = "";
        this.songName = "";
        this.selectedPos = LyricHighLightShareFragment.DEFAULT_SELECTED_POS;
        this.currentType = LyricHighLightShareFragment.VIEW_TYPE_DIALOG;
        this.textColor = "textColorWhite";
        this.aspectRatio = LyricHighLightShareFragment.RATIO_SQUARE;
        this.innerAdapter = new BgInnerAdapter(this);
        this.dispatcherMain = Dispatchers.getMain();
        this.bgList$delegate = g.Q(new i(24));
        com.iloen.melon.fragments.detail.LyricHighLightShareFragment.imageSelectorListener.1 lyricHighLightShareFragment$imageSelectorListener$10 = new ImageSelectorListener() {
            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onFinishBackgroundLoading() {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorCanceled(ImageSelector imageSelector0, Request imageSelector$Request0) {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorComplete(ImageSelector imageSelector0, Request imageSelector$Request0, Uri uri0) {
                q.g(imageSelector$Request0, "reqInfo");
                if(uri0 != null) {
                    if(q.b("bgCameraAlbum", ((BgData)LyricHighLightShareFragment.access$getBgList(LyricHighLightShareFragment.this).get(1)).getItemType())) {
                        ArrayList arrayList0 = LyricHighLightShareFragment.access$getBgList(LyricHighLightShareFragment.this);
                        String s = uri0.toString();
                        q.f(s, "toString(...)");
                        String s1 = uri0.toString();
                        q.f(s1, "toString(...)");
                        arrayList0.set(1, new BgData("bgCameraAlbum", s, s1, null, 8, null));
                    }
                    else {
                        ArrayList arrayList1 = LyricHighLightShareFragment.access$getBgList(LyricHighLightShareFragment.this);
                        String s2 = uri0.toString();
                        q.f(s2, "toString(...)");
                        String s3 = uri0.toString();
                        q.f(s3, "toString(...)");
                        arrayList1.add(1, new BgData("bgCameraAlbum", s2, s3, null, 8, null));
                    }
                    LyricHighLightShareFragment.access$setBgImg$p(LyricHighLightShareFragment.this, uri0.toString());
                    LyricHighLightShareFragment.access$setSelectedPos$p(LyricHighLightShareFragment.this, LyricHighLightShareFragment.access$getSelectedPos$p(LyricHighLightShareFragment.this) + 1);
                    ArrayList arrayList2 = LyricHighLightShareFragment.access$getBgSelectViewGroup$p(LyricHighLightShareFragment.this);
                    if(arrayList2 != null) {
                        arrayList2.clear();
                    }
                    LyricHighLightShareFragment.access$getInnerAdapter$p(LyricHighLightShareFragment.this).notifyDataSetChanged();
                    Context context0 = LyricHighLightShareFragment.this.getContext();
                    if(context0 != null) {
                        RequestBuilder requestBuilder0 = (RequestBuilder)Glide.with(context0).load(LyricHighLightShareFragment.access$getBgImg$p(LyricHighLightShareFragment.this)).signature(new ObjectKey(System.currentTimeMillis()));
                        MelonImageView melonImageView0 = LyricHighLightShareFragment.access$getBgHighlight$p(LyricHighLightShareFragment.this);
                        q.e(melonImageView0, "null cannot be cast to non-null type android.widget.ImageView");
                        requestBuilder0.into(melonImageView0);
                    }
                }
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onStartBackgroundLoading() {
            }
        };
        this.imageSelectorListener = lyricHighLightShareFragment$imageSelectorListener$10;
        this.imageSelector = new ImageSelector(this, lyricHighLightShareFragment$imageSelectorListener$10);
        this.exceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.LyricHighLightShareFragment.exceptionHandler.1.1(throwable0, LyricHighLightShareFragment.this, null), 3, null);
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.LyricHighLightShareFragment$exceptionHandler$1$1", f = "LyricHighLightShareFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.LyricHighLightShareFragment.exceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.LyricHighLightShareFragment.exceptionHandler.1.1(Throwable throwable0, LyricHighLightShareFragment lyricHighLightShareFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                LyricHighLightShareFragment.this = lyricHighLightShareFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.LyricHighLightShareFragment.exceptionHandler.1.1(this.$throwable, LyricHighLightShareFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.LyricHighLightShareFragment.exceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Throwable throwable0 = this.$throwable;
                if(throwable0 instanceof VolleyError) {
                    Y.w("exceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "LyricHighLightShareFragment");
                    ScrollView scrollView0 = LyricHighLightShareFragment.access$getScrollView$p(LyricHighLightShareFragment.this);
                    if(scrollView0 != null) {
                        scrollView0.setVisibility(8);
                    }
                    LyricHighLightShareFragment.access$getMResponseErrorListener$p$s1670971962(LyricHighLightShareFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final String access$getBG_CAMERA$cp() {
        return LyricHighLightShareFragment.BG_CAMERA;
    }

    public static final String access$getBG_CAMERA_ALBUM$cp() [...] // 潜在的解密器

    public static final String access$getBG_DEFAULT$cp() [...] // 潜在的解密器

    public static final String access$getBG_ITEM$cp() [...] // 潜在的解密器

    public static final ErrorListener access$getMResponseErrorListener$p$s1670971962(LyricHighLightShareFragment lyricHighLightShareFragment0) {
        return lyricHighLightShareFragment0.mResponseErrorListener;
    }

    public static final int access$getRATIO_RECTANGLE$cp() [...] // 潜在的解密器

    public static final ScrollView access$getScrollView$p(LyricHighLightShareFragment lyricHighLightShareFragment0) {
        return lyricHighLightShareFragment0.scrollView;
    }

    public static final String access$getTAG_HIGHLIGHT$cp() [...] // 潜在的解密器

    private static final ArrayList bgList_delegate$lambda$0() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(new BgData(LyricHighLightShareFragment.BG_CAMERA, null, null, null, 14, null));
        arrayList0.add(new BgData("bgDefault", null, null, null, 14, null));
        return arrayList0;
    }

    private final void checkAndUpdateButton(MelonImageView melonImageView0, ToggleButton toggleButton0, boolean z) {
        melonImageView0.setImageTintList((z ? ColorUtils.getColorStateList(this.getContext(), 0x7F060179) : null));  // color:green490e
        toggleButton0.setChecked(z);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    private final void deleteImageFileAfterShare() {
        Uri uri0 = this.savedImageUri;
        if(uri0 != null) {
            Context context0 = this.getContext();
            FileUtils.INSTANCE.deleteFileFromUri(context0, uri0);
        }
        this.savedImageUri = null;
    }

    private final Job drawBg(String s) {
        com.iloen.melon.fragments.detail.LyricHighLightShareFragment.drawBg.1 lyricHighLightShareFragment$drawBg$10 = new n(s, null) {
            final String $imageUrl;
            int label;

            {
                LyricHighLightShareFragment.this = lyricHighLightShareFragment0;
                this.$imageUrl = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.LyricHighLightShareFragment.drawBg.1(LyricHighLightShareFragment.this, this.$imageUrl, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.LyricHighLightShareFragment.drawBg.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Context context0 = LyricHighLightShareFragment.this.getContext();
                if(context0 != null) {
                    Glide.with(context0).asBitmap().load(this.$imageUrl).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                            q.g(bitmap0, "resource");
                            Bitmap bitmap1 = com.iloen.melon.utils.ui.LyricHighlightUtils.Companion.drawPalette$default(LyricHighlightUtils.Companion, this.$it, bitmap0, false, false, 12, null);
                            context0.bgImgAsBitmap = bitmap1;
                            context0.setHighlightBg(context0.bgImgAsBitmap);
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Bitmap)object0), transition0);
                        }
                    });
                }
                return H.a;
            }
        };
        return BuildersKt__Builders_commonKt.launch$default(this, this.dispatcherMain, null, lyricHighLightShareFragment$drawBg$10, 2, null);
    }

    private final SongLyricHighlightPostRes fetchData() {
        SongLyricHighlightPostRes songLyricHighlightPostRes0;
        Closeable closeable0 = a.f(this.getContext(), this.getCacheKey());
        try {
            songLyricHighlightPostRes0 = (SongLyricHighlightPostRes)a.d(((Cursor)closeable0), SongLyricHighlightPostRes.class);
        }
        catch(Throwable throwable0) {
            d8.d.l(closeable0, throwable0);
            throw throwable0;
        }
        d8.d.l(closeable0, null);
        return songLyricHighlightPostRes0;
    }

    private final ArrayList getBgList() {
        return (ArrayList)this.bgList$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.d.buildUpon().appendPath("highlightshare"), this.songId, "toString(...)");
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        String s = null;
        RESPONSE songLyricHighlightPostRes$RESPONSE0 = this.mResponse instanceof RESPONSE ? ((RESPONSE)this.mResponse) : null;
        if(songLyricHighlightPostRes$RESPONSE0 != null) {
            String s1 = songLyricHighlightPostRes$RESPONSE0.postInfo.songId;
            String s2 = songLyricHighlightPostRes$RESPONSE0.postInfo.songName;
            String s3 = ProtocolUtils.getArtistNames(songLyricHighlightPostRes$RESPONSE0.postInfo.artistList);
            String s4 = this.shareImageData == null ? null : this.shareImageData.getShareImagePath();
            ShareImageData lyricHighLightShareFragment$ShareImageData0 = this.shareImageData;
            if(lyricHighLightShareFragment$ShareImageData0 != null) {
                s = lyricHighLightShareFragment$ShareImageData0.getShareImageAccessKey();
            }
            return new SharableHighlight(s1, s2, s3, s4, s);
        }
        return null;
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty != null) {
            String s = "선택";
            f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = this.mMelonTiaraProperty.a;
            f0.c = this.mMelonTiaraProperty.b;
            f0.I = this.mMelonTiaraProperty.c;
            String s1 = "";
            if(this.getContext() == null) {
                s = "";
            }
            String s2 = "편집";
            f0.a = s;
            if(this.getContext() == null) {
                s2 = "";
            }
            f0.y = s2;
            f0.o = this.songId;
            if(this.getContext() != null) {
                s1 = "곡";
            }
            f0.p = s1;
            f0.q = this.songName;
            return f0;
        }
        return null;
    }

    private final void initButtonFocus() {
        this.updateTextColorButton(this.textColor, true);
        this.updateRatioButton(this.aspectRatio, true);
        this.updateDesignButton(this.currentType, true);
    }

    private final void initInnerRecyclerView() {
        t0 t00 = this.binding;
        if(t00 != null) {
            t00.u.getContext();
            LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(0, false);
            t00.u.setLayoutManager(linearLayoutManager0);
            t00.u.setNestedScrollingEnabled(false);
            t00.u.setHasFixedSize(false);
            t00.u.setAdapter(this.innerAdapter);
        }
    }

    private final void initView(View view0) {
        View view1 = this.findViewById(0x7F0A0BAD);  // id:titlebar
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.title.TitleBar");
        ((TitleBar)view1).a(B.a.s(1));
        ((TitleBar)view1).setTitle(this.getString(0x7F13049A));  // string:highlighting_title "내가 하이라이팅한 가사"
        ((TitleBar)view1).f(false);
        this.mEmptyView = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
        this.scrollView = (ScrollView)view0.findViewById(0x7F0A0A2F);  // id:scroll_view
        this.thumbContainer = view0.findViewById(0x7F0A0B72);  // id:thumb_container
        t0 t00 = this.binding;
        if(t00 != null) {
            this.bgHighlight = t00.b;
            this.ivDefaultCover = t00.e;
            this.itemContainer = t00.d;
            p p0 = new p(this, t00.i, 0);
            t00.i.setOnClickListener(p0);
            p p1 = new p(this, t00.j, 1);
            t00.j.setOnClickListener(p1);
            p p2 = new p(this, t00.k, 2);
            t00.k.setOnClickListener(p2);
            this.toggleNickName = t00.x;
            t00.x.setChecked(true);
            this.tvVerticalNickName = t00.z;
            this.tvHorizonNickName = t00.y;
            if(this.isTypeNote()) {
                MelonTextView melonTextView0 = this.tvHorizonNickName;
                if(melonTextView0 != null) {
                    melonTextView0.setVisibility(0);
                }
                VerticalTextView verticalTextView0 = this.tvVerticalNickName;
                if(verticalTextView0 != null) {
                    verticalTextView0.setVisibility(8);
                }
            }
            else {
                MelonTextView melonTextView1 = this.tvHorizonNickName;
                if(melonTextView1 != null) {
                    melonTextView1.setVisibility(8);
                }
                VerticalTextView verticalTextView1 = this.tvVerticalNickName;
                if(verticalTextView1 != null) {
                    verticalTextView1.setVisibility(0);
                }
            }
            this.initInnerRecyclerView();
            ViewUtils.setOnClickListener(this.toggleNickName, new com.iloen.melon.fragments.detail.q(this, 0));
            ToggleButton toggleButton0 = t00.s;
            if(ScreenUtils.isDarkMode(this.getContext())) {
                toggleButton0.setBackgroundResource(0x7F08082F);  // drawable:selector_lyric_text_color_black
            }
            else {
                toggleButton0.setBackgroundResource(0x7F080830);  // drawable:selector_lyric_text_color_white
            }
            ToggleButton toggleButton1 = t00.r;
            if(ScreenUtils.isDarkMode(this.getContext())) {
                toggleButton1.setBackgroundResource(0x7F080830);  // drawable:selector_lyric_text_color_white
            }
            else {
                toggleButton1.setBackgroundResource(0x7F08082F);  // drawable:selector_lyric_text_color_black
            }
            toggleButton0.setOnClickListener(new p(this, toggleButton0, 3));
            toggleButton1.setOnClickListener(new p(this, toggleButton1, 4));
            p p3 = new p(this, t00.q, 5);
            t00.q.setOnClickListener(p3);
            p p4 = new p(this, t00.n, 6);
            t00.n.setOnClickListener(p4);
            com.iloen.melon.fragments.detail.q q0 = new com.iloen.melon.fragments.detail.q(this, 1);
            ViewUtils.setOnClickListener(t00.o, q0);
            this.initButtonFocus();
        }
    }

    private static final void initView$lambda$21$lambda$10(LyricHighLightShareFragment lyricHighLightShareFragment0, View view0) {
        lyricHighLightShareFragment0.isNickNameChanged = !lyricHighLightShareFragment0.isNickNameChanged;
        int v = 8;
        if(lyricHighLightShareFragment0.isTypeNote()) {
            MelonTextView melonTextView0 = lyricHighLightShareFragment0.tvHorizonNickName;
            if(melonTextView0 != null) {
                if(lyricHighLightShareFragment0.toggleNickName != null && lyricHighLightShareFragment0.toggleNickName.isChecked()) {
                    v = 0;
                }
                melonTextView0.setVisibility(v);
            }
        }
        else {
            VerticalTextView verticalTextView0 = lyricHighLightShareFragment0.tvVerticalNickName;
            if(verticalTextView0 != null) {
                if(lyricHighLightShareFragment0.toggleNickName != null && lyricHighLightShareFragment0.toggleNickName.isChecked()) {
                    v = 0;
                }
                verticalTextView0.setVisibility(v);
            }
        }
        String s = "닉네임노출여부";
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$12(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        if(q.b(lyricHighLightShareFragment0.textColor, "textColorWhite")) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "글자색변경";
        LyricHighLightShareFragment.updateTextColorButton$default(lyricHighLightShareFragment0, "textColorWhite", false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$14(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        if(q.b(lyricHighLightShareFragment0.textColor, "textColorBlack")) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "글자색변경";
        LyricHighLightShareFragment.updateTextColorButton$default(lyricHighLightShareFragment0, "textColorBlack", false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$16(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        int v = LyricHighLightShareFragment.RATIO_SQUARE;
        if(lyricHighLightShareFragment0.aspectRatio == v) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "공유카드비율변경";
        LyricHighLightShareFragment.updateRatioButton$default(lyricHighLightShareFragment0, v, false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$18(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        int v = LyricHighLightShareFragment.RATIO_RECTANGLE;
        if(lyricHighLightShareFragment0.aspectRatio == v) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "공유카드비율변경";
        LyricHighLightShareFragment.updateRatioButton$default(lyricHighLightShareFragment0, v, false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$20(LyricHighLightShareFragment lyricHighLightShareFragment0, View view0) {
        String s = "공유하기";
        lyricHighLightShareFragment0.shareHighlightImage(lyricHighLightShareFragment0.thumbContainer, lyricHighLightShareFragment0.songId);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$4(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        int v = LyricHighLightShareFragment.VIEW_TYPE_DIALOG;
        if(lyricHighLightShareFragment0.currentType == v) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "공유카드디자인변경";
        LyricHighLightShareFragment.updateDesignButton$default(lyricHighLightShareFragment0, v, false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$6(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        int v = LyricHighLightShareFragment.VIEW_TYPE_NOTE;
        if(lyricHighLightShareFragment0.currentType == v) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "공유카드디자인변경";
        LyricHighLightShareFragment.updateDesignButton$default(lyricHighLightShareFragment0, v, false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    private static final void initView$lambda$21$lambda$8(LyricHighLightShareFragment lyricHighLightShareFragment0, ToggleButton toggleButton0, View view0) {
        int v = LyricHighLightShareFragment.VIEW_TYPE_ALBUM;
        if(lyricHighLightShareFragment0.currentType == v) {
            toggleButton0.setChecked(true);
            return;
        }
        String s = "공유카드디자인변경";
        LyricHighLightShareFragment.updateDesignButton$default(lyricHighLightShareFragment0, v, false, 2, null);
        f f0 = lyricHighLightShareFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            if(lyricHighLightShareFragment0.getContext() == null) {
                s = "";
            }
            f0.F = s;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    private final boolean isTypeNote() {
        return this.currentType == LyricHighLightShareFragment.VIEW_TYPE_NOTE;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D022F, viewGroup0, false);  // layout:detail_song_lyric_highlighting_share
        int v = 0x7F0A00E7;  // id:background_container
        if(((RelativeLayout)I.C(view0, 0x7F0A00E7)) != null) {  // id:background_container
            v = 0x7F0A0104;  // id:bg_highlight
            View view1 = I.C(view0, 0x7F0A0104);  // id:bg_highlight
            if(((MelonImageView)view1) != null && ((RelativeLayout)I.C(view0, 0x7F0A0118)) != null) {  // id:bottom_container
                v = 0x7F0A011F;  // id:bottom_line
                View view2 = I.C(view0, 0x7F0A011F);  // id:bottom_line
                if(view2 != null && ((LinearLayout)I.C(view0, 0x7F0A03B4)) != null && ((Guideline)I.C(view0, 0x7F0A0536)) != null) {  // id:design_container
                    v = 0x7F0A05A7;  // id:item_container
                    View view3 = I.C(view0, 0x7F0A05A7);  // id:item_container
                    if(((RelativeLayout)view3) != null) {
                        v = 0x7F0A061A;  // id:iv_default_cover
                        View view4 = I.C(view0, 0x7F0A061A);  // id:iv_default_cover
                        if(((MelonImageView)view4) != null) {
                            v = 0x7F0A061F;  // id:iv_design_01
                            View view5 = I.C(view0, 0x7F0A061F);  // id:iv_design_01
                            if(((MelonImageView)view5) != null) {
                                v = 0x7F0A0620;  // id:iv_design_02
                                View view6 = I.C(view0, 0x7F0A0620);  // id:iv_design_02
                                if(((MelonImageView)view6) != null) {
                                    v = 0x7F0A0621;  // id:iv_design_03
                                    View view7 = I.C(view0, 0x7F0A0621);  // id:iv_design_03
                                    if(((MelonImageView)view7) != null) {
                                        v = 0x7F0A0622;  // id:iv_design_stroke_01
                                        View view8 = I.C(view0, 0x7F0A0622);  // id:iv_design_stroke_01
                                        if(((ToggleButton)view8) != null) {
                                            v = 0x7F0A0623;  // id:iv_design_stroke_02
                                            View view9 = I.C(view0, 0x7F0A0623);  // id:iv_design_stroke_02
                                            if(((ToggleButton)view9) != null) {
                                                v = 0x7F0A0624;  // id:iv_design_stroke_03
                                                View view10 = I.C(view0, 0x7F0A0624);  // id:iv_design_stroke_03
                                                if(((ToggleButton)view10) != null) {
                                                    v = 0x7F0A064A;  // id:iv_logo
                                                    View view11 = I.C(view0, 0x7F0A064A);  // id:iv_logo
                                                    if(((ImageView)view11) != null) {
                                                        v = 0x7F0A067B;  // id:iv_rectangle_ratio
                                                        View view12 = I.C(view0, 0x7F0A067B);  // id:iv_rectangle_ratio
                                                        if(((MelonImageView)view12) != null) {
                                                            v = 0x7F0A067C;  // id:iv_rectangle_stroke
                                                            View view13 = I.C(view0, 0x7F0A067C);  // id:iv_rectangle_stroke
                                                            if(((ToggleButton)view13) != null) {
                                                                v = 0x7F0A068A;  // id:iv_share
                                                                View view14 = I.C(view0, 0x7F0A068A);  // id:iv_share
                                                                if(((ImageView)view14) != null) {
                                                                    v = 0x7F0A0690;  // id:iv_square_ratio
                                                                    View view15 = I.C(view0, 0x7F0A0690);  // id:iv_square_ratio
                                                                    if(((MelonImageView)view15) != null) {
                                                                        v = 0x7F0A0691;  // id:iv_square_stroke
                                                                        View view16 = I.C(view0, 0x7F0A0691);  // id:iv_square_stroke
                                                                        if(((ToggleButton)view16) != null) {
                                                                            v = 0x7F0A0697;  // id:iv_text_color_black_stroke
                                                                            View view17 = I.C(view0, 0x7F0A0697);  // id:iv_text_color_black_stroke
                                                                            if(((ToggleButton)view17) != null) {
                                                                                v = 0x7F0A0698;  // id:iv_text_color_white_stroke
                                                                                View view18 = I.C(view0, 0x7F0A0698);  // id:iv_text_color_white_stroke
                                                                                if(((ToggleButton)view18) != null) {
                                                                                    v = 0x7F0A0759;  // id:left_guideline
                                                                                    View view19 = I.C(view0, 0x7F0A0759);  // id:left_guideline
                                                                                    if(((Guideline)view19) != null && ((Guideline)I.C(view0, 0x7F0A07AC)) != null && (((Guideline)I.C(view0, 0x7F0A07AD)) != null && ((Guideline)I.C(view0, 0x7F0A07BD)) != null) && (((Guideline)I.C(view0, 0x7F0A07BE)) != null && ((RelativeLayout)I.C(view0, 0x7F0A08B3)) != null)) {  // id:logo_right_guideline
                                                                                        v = 0x7F0A09CF;  // id:recycler_horizontal
                                                                                        View view20 = I.C(view0, 0x7F0A09CF);  // id:recycler_horizontal
                                                                                        if(((RecyclerView)view20) != null) {
                                                                                            v = 0x7F0A09F8;  // id:right_guideline
                                                                                            View view21 = I.C(view0, 0x7F0A09F8);  // id:right_guideline
                                                                                            if(((Guideline)view21) != null && ((ScrollView)I.C(view0, 0x7F0A0A2F)) != null && ((LinearLayoutCompat)I.C(view0, 0x7F0A0B5E)) != null) {  // id:scroll_view
                                                                                                v = 0x7F0A0B70;  // id:thumb_cardview
                                                                                                View view22 = I.C(view0, 0x7F0A0B70);  // id:thumb_cardview
                                                                                                if(((CardView)view22) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0B72)) != null) {  // id:thumb_container
                                                                                                    v = 0x7F0A0BAD;  // id:titlebar
                                                                                                    View view23 = I.C(view0, 0x7F0A0BAD);  // id:titlebar
                                                                                                    if(view23 != null) {
                                                                                                        TitleBar titleBar0 = (TitleBar)view23;
                                                                                                        v = 0x7F0A0BBE;  // id:toggle_nickname
                                                                                                        View view24 = I.C(view0, 0x7F0A0BBE);  // id:toggle_nickname
                                                                                                        if(((ToggleButton)view24) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0BCE)) != null && (((MelonTextView)I.C(view0, 0x7F0A0C1D)) != null && ((MelonTextView)I.C(view0, 0x7F0A0C61)) != null)) {  // id:top_container
                                                                                                            v = 0x7F0A0C89;  // id:tv_horizon_nickname
                                                                                                            View view25 = I.C(view0, 0x7F0A0C89);  // id:tv_horizon_nickname
                                                                                                            if(((MelonTextView)view25) != null && ((MelonTextView)I.C(view0, 0x7F0A0CCD)) != null && (((MelonTextView)I.C(view0, 0x7F0A0CF6)) != null && ((MelonTextView)I.C(view0, 0x7F0A0D28)) != null)) {  // id:tv_nickname
                                                                                                                v = 0x7F0A0D4F;  // id:tv_vertical_nickname
                                                                                                                View view26 = I.C(view0, 0x7F0A0D4F);  // id:tv_vertical_nickname
                                                                                                                if(((VerticalTextView)view26) != null && ((Guideline)I.C(view0, 0x7F0A0DA9)) != null && ((Guideline)I.C(view0, 0x7F0A0DAA)) != null) {  // id:vertical_nickname_bottom_guideline
                                                                                                                    this.binding = new t0(((RelativeLayout)view0), ((MelonImageView)view1), view2, ((RelativeLayout)view3), ((MelonImageView)view4), ((MelonImageView)view5), ((MelonImageView)view6), ((MelonImageView)view7), ((ToggleButton)view8), ((ToggleButton)view9), ((ToggleButton)view10), ((ImageView)view11), ((MelonImageView)view12), ((ToggleButton)view13), ((ImageView)view14), ((MelonImageView)view15), ((ToggleButton)view16), ((ToggleButton)view17), ((ToggleButton)view18), ((Guideline)view19), ((RecyclerView)view20), ((Guideline)view21), ((CardView)view22), ((ToggleButton)view24), ((MelonTextView)view25), ((VerticalTextView)view26));
                                                                                                                    return (RelativeLayout)view0;
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        Context context0 = this.getContext();
        if(a.e(300000L, this.getCacheKey(), context0)) {
            this.savedImageUri = null;
            this.shareImageData = null;
            com.iloen.melon.fragments.detail.LyricHighLightShareFragment.onFetchStart.1 lyricHighLightShareFragment$onFetchStart$10 = new n(null) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;

                {
                    LyricHighLightShareFragment.this = lyricHighLightShareFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.detail.LyricHighLightShareFragment.onFetchStart.1(LyricHighLightShareFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.detail.LyricHighLightShareFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            Deferred deferred1 = LyricHighLightShareFragment.this.requestSongLyricHighlightPostAsync(LyricHighLightShareFragment.this.songId);
                            this.L$0 = null;
                            this.label = 1;
                            object0 = deferred1.await(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            break;
                        }
                        case 1: {
                            Deferred deferred2 = (Deferred)this.L$0;
                            d5.n.D(object0);
                            break;
                        }
                        case 2: {
                            me.i i0 = (me.i)this.L$2;
                            SongLyricHighlightPostRes songLyricHighlightPostRes0 = (SongLyricHighlightPostRes)this.L$1;
                            Deferred deferred0 = (Deferred)this.L$0;
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    me.i i1 = Dispatchers.getMain().plus(LyricHighLightShareFragment.this.exceptionHandler);
                    com.iloen.melon.fragments.detail.LyricHighLightShareFragment.onFetchStart.1.1 lyricHighLightShareFragment$onFetchStart$1$10 = new n(((SongLyricHighlightPostRes)object0), null) {
                        final SongLyricHighlightPostRes $songLyricHighlightPostRes;
                        int label;

                        {
                            LyricHighLightShareFragment.this = lyricHighLightShareFragment0;
                            this.$songLyricHighlightPostRes = songLyricHighlightPostRes0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.detail.LyricHighLightShareFragment.onFetchStart.1.1(LyricHighLightShareFragment.this, this.$songLyricHighlightPostRes, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.detail.LyricHighLightShareFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            boolean z = LyricHighLightShareFragment.this.prepareFetchComplete(this.$songLyricHighlightPostRes);
                            H h0 = H.a;
                            if(!z) {
                                return h0;
                            }
                            if(this.$songLyricHighlightPostRes != null && this.$songLyricHighlightPostRes.isSuccessful()) {
                                Context context0 = LyricHighLightShareFragment.this.getContext();
                                String s = LyricHighLightShareFragment.this.getCacheKey();
                                a.a(context0, this.$songLyricHighlightPostRes, s);
                                RESPONSE songLyricHighlightPostRes$RESPONSE0 = this.$songLyricHighlightPostRes.response;
                                s s1 = new s(songLyricHighlightPostRes$RESPONSE0.section, songLyricHighlightPostRes$RESPONSE0.page, songLyricHighlightPostRes$RESPONSE0.menuId, null);
                                LyricHighLightShareFragment.this.mMelonTiaraProperty = s1;
                                LyricHighLightShareFragment.this.mMenuId = songLyricHighlightPostRes$RESPONSE0.menuId;
                                POSTINFO songLyricHighlightPostRes$RESPONSE$POSTINFO0 = songLyricHighlightPostRes$RESPONSE0.postInfo;
                                if(songLyricHighlightPostRes$RESPONSE$POSTINFO0 != null) {
                                    String s2 = songLyricHighlightPostRes$RESPONSE$POSTINFO0.songName;
                                    q.f(s2, "songName");
                                    LyricHighLightShareFragment.this.songName = s2;
                                    LyricHighLightShareFragment.this.postInfoRes = songLyricHighlightPostRes$RESPONSE$POSTINFO0;
                                    LyricHighLightShareFragment.this.updateLyricUi(songLyricHighlightPostRes$RESPONSE$POSTINFO0, LyricHighLightShareFragment.this.currentType, "onFetchStart - response cache expire");
                                    LyricHighLightShareFragment.this.drawBg(songLyricHighlightPostRes$RESPONSE$POSTINFO0.albumImg);
                                }
                                ArrayList arrayList0 = LyricHighLightShareFragment.this.setBgList(songLyricHighlightPostRes$RESPONSE0);
                                LyricHighLightShareFragment.this.innerAdapter.setData(arrayList0);
                            }
                            LyricHighLightShareFragment.this.performFetchCompleteOnlyViews();
                            return h0;
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                    return BuildersKt.withContext(i1, lyricHighLightShareFragment$onFetchStart$1$10, this) == a0 ? a0 : H.a;
                }
            };
            BuildersKt__Builders_commonKt.launch$default(this, this.exceptionHandler, null, lyricHighLightShareFragment$onFetchStart$10, 2, null);
            return true;
        }
        SongLyricHighlightPostRes songLyricHighlightPostRes0 = this.fetchData();
        if(songLyricHighlightPostRes0 != null) {
            RESPONSE songLyricHighlightPostRes$RESPONSE0 = songLyricHighlightPostRes0.response;
            if(songLyricHighlightPostRes$RESPONSE0 != null) {
                this.mResponse = songLyricHighlightPostRes$RESPONSE0;
                POSTINFO songLyricHighlightPostRes$RESPONSE$POSTINFO0 = songLyricHighlightPostRes$RESPONSE0.postInfo;
                if(songLyricHighlightPostRes$RESPONSE$POSTINFO0 != null) {
                    q.f(songLyricHighlightPostRes$RESPONSE$POSTINFO0, "postInfo");
                    this.updateLyricUi(songLyricHighlightPostRes$RESPONSE$POSTINFO0, this.currentType, "onFetchStart - response cache");
                }
                ArrayList arrayList0 = this.setBgList(songLyricHighlightPostRes$RESPONSE0);
                this.innerAdapter.setData(arrayList0);
            }
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.songId = l1.g(bundle0, "inState", "argItemId", "", "getString(...)");
        String s = bundle0.getString("argTextColor", "textColorWhite");
        q.f(s, "getString(...)");
        this.textColor = s;
        this.currentType = bundle0.getInt("argTabType");
        this.aspectRatio = bundle0.getInt("argRatio", LyricHighLightShareFragment.RATIO_SQUARE);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.songId);
        bundle0.putString("argTextColor", this.textColor);
        bundle0.putInt("argTabType", this.currentType);
        bundle0.putInt("argRatio", this.aspectRatio);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        POSTINFO songLyricHighlightPostRes$RESPONSE$POSTINFO0 = this.postInfoRes;
        if(songLyricHighlightPostRes$RESPONSE$POSTINFO0 != null) {
            this.updateLyricUi(songLyricHighlightPostRes$RESPONSE$POSTINFO0, this.currentType, "onStart");
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initView(view0);
    }

    private final Deferred requestSongLyricHighlightPostAsync(String s) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new n(s, null) {
            final String $songId;
            int label;

            {
                LyricHighLightShareFragment.this = lyricHighLightShareFragment0;
                this.$songId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.LyricHighLightShareFragment.requestSongLyricHighlightPostAsync.1(LyricHighLightShareFragment.this, this.$songId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.LyricHighLightShareFragment.requestSongLyricHighlightPostAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = com.iloen.melon.net.RequestBuilder.newInstance(new SongLyricHighlightPostReq(LyricHighLightShareFragment.this.getContext(), this.$songId)).tag("LyricHighLightShareFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.SongLyricHighlightPostRes");
                return (SongLyricHighlightPostRes)httpResponse0;
            }
        }, 3, null);
    }

    private final boolean saveHighlightFileFromView(Context context0, View view0, boolean z) {
        Uri uri0;
        Bitmap bitmap0 = ViewUtils.getViewCapture(view0);
        if(bitmap0 != null) {
            try {
                uri0 = null;
                uri0 = FileUtils.INSTANCE.saveImageFile(context0, bitmap0, LyricHighLightShareFragment.HIGHLIGHT_FILE_NAME + this.songId + "_", z);
            }
            catch(IOException unused_ex) {
            }
            this.savedImageUri = uri0;
        }
        return this.savedImageUri != null;
    }

    public static boolean saveHighlightFileFromView$default(LyricHighLightShareFragment lyricHighLightShareFragment0, Context context0, View view0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return lyricHighLightShareFragment0.saveHighlightFileFromView(context0, view0, z);
    }

    private final ArrayList setBgList(RESPONSE songLyricHighlightPostRes$RESPONSE0) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = songLyricHighlightPostRes$RESPONSE0.postImageList;
        q.f(arrayList1, "postImageList");
        for(Object object0: arrayList1) {
            String s = ((POSTIMAGELIST)object0).thumbImagePath;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = ((POSTIMAGELIST)object0).largeImagePath;
            if(s2 == null) {
                s2 = "";
            }
            String s3 = ((POSTIMAGELIST)object0).voiceOverText;
            if(s3 != null) {
                s1 = s3;
            }
            arrayList0.add(new BgData("bgItem", s, s2, s1));
        }
        return arrayList0;
    }

    private final void setHighlightBg(Bitmap bitmap0) {
        if(bitmap0 == null) {
            return;
        }
        this.bgImg = bitmap0;
        MelonImageView melonImageView0 = this.bgHighlight;
        if(melonImageView0 != null) {
            melonImageView0.setImageBitmap(bitmap0);
        }
        this.innerAdapter.notifyDataSetChanged();
    }

    private final void shareHighlightImage(View view0, String s) {
        if(this.shareImageData == null || this.isTypeChanged || this.isNickNameChanged) {
            if(this.savedImageUri == null || this.isTypeChanged || this.isNickNameChanged) {
                Context context0 = this.getContext();
                if(context0 != null && this.saveHighlightFileFromView(context0, view0, true)) {
                    this.isTypeChanged = false;
                    this.isNickNameChanged = false;
                }
            }
            Uri uri0 = this.savedImageUri;
            if(uri0 != null) {
                this.showProgress(true);
                Params snsHlyricsUploadReq$Params0 = new Params();
                snsHlyricsUploadReq$Params0.sId = s;
                snsHlyricsUploadReq$Params0.type = "hlyrics";
                Context context1 = this.getContext();
                String s1 = FileUtils.INSTANCE.getImageFilePathForUri(context1, uri0);
                if(s1 != null) {
                    com.iloen.melon.net.RequestBuilder.newInstance(new SnsHlyricsUploadReq(this.getContext(), snsHlyricsUploadReq$Params0)).tag(this.getRequestTag()).file("imgFile", new File(s1)).listener(new o(this)).errorListener(new o(this)).request();
                    return;
                }
                this.showProgress(false);
            }
        }
        else {
            Sharable sharable0 = this.getSNSSharable();
            if(sharable0 != null) {
                this.showSNSListPopup(sharable0);
            }
        }
    }

    private static final void shareHighlightImage$lambda$51$lambda$49(LyricHighLightShareFragment lyricHighLightShareFragment0, SnsHlyricsUploadRes snsHlyricsUploadRes0) {
        if(lyricHighLightShareFragment0.isFragmentValid()) {
            lyricHighLightShareFragment0.showProgress(false);
            if((snsHlyricsUploadRes0 == null ? null : snsHlyricsUploadRes0.response) != null && snsHlyricsUploadRes0.isSuccessful()) {
                lyricHighLightShareFragment0.shareImageData = new ShareImageData(snsHlyricsUploadRes0.response.imgUrl, snsHlyricsUploadRes0.response.accessKey);
                Sharable sharable0 = lyricHighLightShareFragment0.getSNSSharable();
                if(sharable0 != null) {
                    lyricHighLightShareFragment0.showSNSListPopup(sharable0);
                }
                lyricHighLightShareFragment0.deleteImageFileAfterShare();
            }
        }
    }

    private static final void shareHighlightImage$lambda$51$lambda$50(LyricHighLightShareFragment lyricHighLightShareFragment0, VolleyError volleyError0) {
        lyricHighLightShareFragment0.showProgress(false);
        lyricHighLightShareFragment0.deleteImageFileAfterShare();
    }

    private final void updateAspectRatio(int v) {
        this.isTypeChanged = true;
        t0 t00 = this.binding;
        if(t00 != null) {
            VerticalTextView verticalTextView0 = t00.z;
            MelonTextView melonTextView0 = t00.y;
            ImageView imageView0 = t00.l;
            Guideline guideline0 = t00.v;
            Guideline guideline1 = t00.t;
            CardView cardView0 = t00.w;
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = cardView0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = guideline1.getLayoutParams();
            q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams viewGroup$LayoutParams2 = guideline0.getLayoutParams();
            q.e(viewGroup$LayoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams viewGroup$LayoutParams3 = imageView0.getLayoutParams();
            q.e(viewGroup$LayoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            int v1 = LyricHighLightShareFragment.RATIO_RECTANGLE;
            if(v == v1) {
                ((LayoutParams)viewGroup$LayoutParams0).G = "H,3:4";
                cardView0.setLayoutParams(((LayoutParams)viewGroup$LayoutParams0));
                ((LayoutParams)viewGroup$LayoutParams1).c = 0.125f;
                guideline1.setLayoutParams(((LayoutParams)viewGroup$LayoutParams1));
                ((LayoutParams)viewGroup$LayoutParams2).c = 0.875f;
                guideline0.setLayoutParams(((LayoutParams)viewGroup$LayoutParams2));
                viewGroup$LayoutParams3.width = this.getResources().getDimensionPixelSize(0x7F070132);  // dimen:lyric_highlight_logo_3_4
                viewGroup$LayoutParams3.height = this.getResources().getDimensionPixelSize(0x7F070132);  // dimen:lyric_highlight_logo_3_4
                imageView0.setLayoutParams(viewGroup$LayoutParams3);
                melonTextView0.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F07013C)));  // dimen:lyric_highlight_nickname_3_4
                verticalTextView0.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F07013C)));  // dimen:lyric_highlight_nickname_3_4
                MelonTextView melonTextView1 = this.tvSong;
                if(melonTextView1 != null) {
                    melonTextView1.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070144)));  // dimen:lyric_highlight_song_meta_3_4
                }
                MelonTextView melonTextView2 = this.tvArtist;
                if(melonTextView2 != null) {
                    melonTextView2.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070142)));  // dimen:lyric_highlight_song_artist_3_4
                }
                MelonImageView melonImageView0 = this.bgHighlight;
                if(melonImageView0 != null) {
                    melonImageView0.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
            }
            else {
                ((LayoutParams)viewGroup$LayoutParams0).G = "H, 1:1";
                cardView0.setLayoutParams(((LayoutParams)viewGroup$LayoutParams0));
                ((LayoutParams)viewGroup$LayoutParams1).c = 0.0f;
                guideline1.setLayoutParams(((LayoutParams)viewGroup$LayoutParams1));
                ((LayoutParams)viewGroup$LayoutParams2).c = 1.0f;
                guideline0.setLayoutParams(((LayoutParams)viewGroup$LayoutParams2));
                viewGroup$LayoutParams3.width = this.getResources().getDimensionPixelSize(0x7F070131);  // dimen:lyric_highlight_logo
                viewGroup$LayoutParams3.height = this.getResources().getDimensionPixelSize(0x7F070131);  // dimen:lyric_highlight_logo
                imageView0.setLayoutParams(viewGroup$LayoutParams3);
                melonTextView0.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F07013B)));  // dimen:lyric_highlight_nickname
                verticalTextView0.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F07013B)));  // dimen:lyric_highlight_nickname
                MelonTextView melonTextView3 = this.tvSong;
                if(melonTextView3 != null) {
                    melonTextView3.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070143)));  // dimen:lyric_highlight_song_meta
                }
                MelonTextView melonTextView4 = this.tvArtist;
                if(melonTextView4 != null) {
                    melonTextView4.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070141)));  // dimen:lyric_highlight_song_artist
                }
                MelonImageView melonImageView1 = this.bgHighlight;
                if(melonImageView1 != null) {
                    melonImageView1.setScaleType(ImageView.ScaleType.FIT_XY);
                }
            }
            Context context0 = this.getContext();
            if(context0 != null) {
                RequestBuilder requestBuilder0 = (RequestBuilder)Glide.with(context0).load(this.bgImg).signature(new ObjectKey(System.currentTimeMillis()));
                MelonImageView melonImageView2 = this.bgHighlight;
                q.e(melonImageView2, "null cannot be cast to non-null type android.widget.ImageView");
                requestBuilder0.into(melonImageView2);
            }
            int v2 = this.currentType;
            ViewGroup.LayoutParams viewGroup$LayoutParams4 = null;
            if(v2 == LyricHighLightShareFragment.VIEW_TYPE_DIALOG) {
                ViewGroup.LayoutParams viewGroup$LayoutParams5 = this.ivQuoteLeft == null ? null : this.ivQuoteLeft.getLayoutParams();
                ImageView imageView1 = this.ivQuoteRight;
                if(imageView1 != null) {
                    viewGroup$LayoutParams4 = imageView1.getLayoutParams();
                }
                if(v == v1) {
                    if(viewGroup$LayoutParams5 != null) {
                        viewGroup$LayoutParams5.width = this.getResources().getDimensionPixelSize(0x7F070140);  // dimen:lyric_highlight_quote_width_3_4
                        viewGroup$LayoutParams5.height = this.getResources().getDimensionPixelSize(0x7F07013E);  // dimen:lyric_highlight_quote_height_3_4
                        ImageView imageView2 = this.ivQuoteLeft;
                        if(imageView2 != null) {
                            imageView2.setLayoutParams(viewGroup$LayoutParams5);
                        }
                    }
                    if(viewGroup$LayoutParams4 != null) {
                        viewGroup$LayoutParams4.width = this.getResources().getDimensionPixelSize(0x7F070140);  // dimen:lyric_highlight_quote_width_3_4
                        viewGroup$LayoutParams4.height = this.getResources().getDimensionPixelSize(0x7F07013E);  // dimen:lyric_highlight_quote_height_3_4
                        ImageView imageView3 = this.ivQuoteRight;
                        if(imageView3 != null) {
                            imageView3.setLayoutParams(viewGroup$LayoutParams4);
                        }
                    }
                    MelonTextView melonTextView5 = this.tvLyric;
                    if(melonTextView5 != null) {
                        melonTextView5.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070134)));  // dimen:lyric_highlight_lyric_3_4
                    }
                    MelonTextView melonTextView6 = this.tvLyric;
                    if(melonTextView6 != null) {
                        melonTextView6.setLineSpacing(((float)this.getResources().getDimensionPixelSize(0x7F070136)), 1.0f);  // dimen:lyric_highlight_lyric_line_spacing_3_4
                    }
                }
                else {
                    if(viewGroup$LayoutParams5 != null) {
                        viewGroup$LayoutParams5.width = this.getResources().getDimensionPixelSize(0x7F07013F);  // dimen:lyric_highlight_quote_width
                        viewGroup$LayoutParams5.height = this.getResources().getDimensionPixelSize(0x7F07013D);  // dimen:lyric_highlight_quote_height
                        ImageView imageView4 = this.ivQuoteLeft;
                        if(imageView4 != null) {
                            imageView4.setLayoutParams(viewGroup$LayoutParams5);
                        }
                    }
                    if(viewGroup$LayoutParams4 != null) {
                        viewGroup$LayoutParams4.width = this.getResources().getDimensionPixelSize(0x7F07013F);  // dimen:lyric_highlight_quote_width
                        viewGroup$LayoutParams4.height = this.getResources().getDimensionPixelSize(0x7F07013D);  // dimen:lyric_highlight_quote_height
                        ImageView imageView5 = this.ivQuoteRight;
                        if(imageView5 != null) {
                            imageView5.setLayoutParams(viewGroup$LayoutParams4);
                        }
                    }
                    MelonTextView melonTextView7 = this.tvLyric;
                    if(melonTextView7 != null) {
                        melonTextView7.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070133)));  // dimen:lyric_highlight_lyric
                    }
                    MelonTextView melonTextView8 = this.tvLyric;
                    if(melonTextView8 != null) {
                        melonTextView8.setLineSpacing(((float)this.getResources().getDimensionPixelSize(0x7F070135)), 1.0f);  // dimen:lyric_highlight_lyric_line_spacing
                    }
                }
            }
            else if(v2 == LyricHighLightShareFragment.VIEW_TYPE_NOTE) {
                UnderlineTextView underlineTextView0 = this.underlineTvLyric;
                if(underlineTextView0 != null) {
                    viewGroup$LayoutParams4 = underlineTextView0.getLayoutParams();
                }
                q.e(viewGroup$LayoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                if(v == v1) {
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams4).topMargin = this.getResources().getDimensionPixelSize(0x7F07013A);  // dimen:lyric_highlight_lyric_type2_margin_3_4
                    UnderlineTextView underlineTextView1 = this.underlineTvLyric;
                    if(underlineTextView1 != null) {
                        underlineTextView1.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams4));
                    }
                    UnderlineTextView underlineTextView2 = this.underlineTvLyric;
                    if(underlineTextView2 != null) {
                        underlineTextView2.setPadding(0, 0, 0, this.getResources().getDimensionPixelSize(0x7F07013A));  // dimen:lyric_highlight_lyric_type2_margin_3_4
                    }
                    UnderlineTextView underlineTextView3 = this.underlineTvLyric;
                    if(underlineTextView3 != null) {
                        underlineTextView3.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070134)));  // dimen:lyric_highlight_lyric_3_4
                    }
                    UnderlineTextView underlineTextView4 = this.underlineTvLyric;
                    if(underlineTextView4 != null) {
                        underlineTextView4.setLineSpacing(((float)this.getResources().getDimensionPixelSize(0x7F070138)), 1.0f);  // dimen:lyric_highlight_lyric_type2_line_spacing_3_4
                    }
                }
                else {
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams4).topMargin = this.getResources().getDimensionPixelSize(0x7F070139);  // dimen:lyric_highlight_lyric_type2_margin
                    UnderlineTextView underlineTextView5 = this.underlineTvLyric;
                    if(underlineTextView5 != null) {
                        underlineTextView5.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams4));
                    }
                    UnderlineTextView underlineTextView6 = this.underlineTvLyric;
                    if(underlineTextView6 != null) {
                        underlineTextView6.setPadding(0, 0, 0, this.getResources().getDimensionPixelSize(0x7F070139));  // dimen:lyric_highlight_lyric_type2_margin
                    }
                    UnderlineTextView underlineTextView7 = this.underlineTvLyric;
                    if(underlineTextView7 != null) {
                        underlineTextView7.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070133)));  // dimen:lyric_highlight_lyric
                    }
                    UnderlineTextView underlineTextView8 = this.underlineTvLyric;
                    if(underlineTextView8 != null) {
                        underlineTextView8.setLineSpacing(((float)this.getResources().getDimensionPixelSize(0x7F070137)), 1.0f);  // dimen:lyric_highlight_lyric_type2_line_spacing
                    }
                }
            }
            else if(v2 == LyricHighLightShareFragment.VIEW_TYPE_ALBUM) {
                FrameLayout frameLayout0 = this.albumContainer;
                if(frameLayout0 != null) {
                    viewGroup$LayoutParams4 = frameLayout0.getLayoutParams();
                }
                if(v == v1) {
                    if(viewGroup$LayoutParams4 != null) {
                        viewGroup$LayoutParams4.width = this.getResources().getDimensionPixelSize(0x7F070130);  // dimen:lyric_highlight_album_image_3_4
                        viewGroup$LayoutParams4.height = this.getResources().getDimensionPixelSize(0x7F070130);  // dimen:lyric_highlight_album_image_3_4
                        FrameLayout frameLayout1 = this.albumContainer;
                        if(frameLayout1 != null) {
                            frameLayout1.setLayoutParams(viewGroup$LayoutParams4);
                        }
                    }
                    MelonTextView melonTextView9 = this.tvLyric;
                    if(melonTextView9 != null) {
                        melonTextView9.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070134)));  // dimen:lyric_highlight_lyric_3_4
                    }
                    MelonTextView melonTextView10 = this.tvLyric;
                    if(melonTextView10 != null) {
                        melonTextView10.setLineSpacing(((float)this.getResources().getDimensionPixelSize(0x7F070136)), 1.0f);  // dimen:lyric_highlight_lyric_line_spacing_3_4
                    }
                }
                else {
                    if(viewGroup$LayoutParams4 != null) {
                        viewGroup$LayoutParams4.width = this.getResources().getDimensionPixelSize(0x7F07012F);  // dimen:lyric_highlight_album_image
                        viewGroup$LayoutParams4.height = this.getResources().getDimensionPixelSize(0x7F07012F);  // dimen:lyric_highlight_album_image
                        FrameLayout frameLayout2 = this.albumContainer;
                        if(frameLayout2 != null) {
                            frameLayout2.setLayoutParams(viewGroup$LayoutParams4);
                        }
                    }
                    MelonTextView melonTextView11 = this.tvLyric;
                    if(melonTextView11 != null) {
                        melonTextView11.setTextSize(0, ((float)this.getResources().getDimensionPixelSize(0x7F070133)));  // dimen:lyric_highlight_lyric
                    }
                    MelonTextView melonTextView12 = this.tvLyric;
                    if(melonTextView12 != null) {
                        melonTextView12.setLineSpacing(((float)this.getResources().getDimensionPixelSize(0x7F070135)), 1.0f);  // dimen:lyric_highlight_lyric_line_spacing
                    }
                }
            }
        }
    }

    public final void updateBgSelect(int v) {
        ArrayList arrayList0 = this.bgSelectViewGroup;
        if(arrayList0 != null) {
            int v1 = 0;
            for(Object object0: arrayList0) {
                if(v1 >= 0) {
                    ((View)object0).setVisibility((v1 == v ? 0 : 8));
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
        }
        this.innerAdapter.notifyDataSetChanged();
    }

    private final void updateDesignButton(int v, boolean z) {
        LogU.debug$default(LyricHighLightShareFragment.log, "updateDesignButton currentType: " + this.currentType + ", designType: " + v, null, false, 6, null);
        t0 t00 = this.binding;
        if(t00 != null) {
            ToggleButton toggleButton0 = t00.k;
            MelonImageView melonImageView0 = t00.h;
            ToggleButton toggleButton1 = t00.j;
            MelonImageView melonImageView1 = t00.g;
            ToggleButton toggleButton2 = t00.i;
            MelonImageView melonImageView2 = t00.f;
            if(v == LyricHighLightShareFragment.VIEW_TYPE_DIALOG) {
                q.f(melonImageView2, "ivDesign01");
                q.f(toggleButton2, "ivDesignStroke01");
                this.checkAndUpdateButton(melonImageView2, toggleButton2, true);
                q.f(melonImageView1, "ivDesign02");
                q.f(toggleButton1, "ivDesignStroke02");
                this.checkAndUpdateButton(melonImageView1, toggleButton1, false);
                q.f(melonImageView0, "ivDesign03");
                q.f(toggleButton0, "ivDesignStroke03");
                this.checkAndUpdateButton(melonImageView0, toggleButton0, false);
            }
            else if(v == LyricHighLightShareFragment.VIEW_TYPE_NOTE) {
                q.f(melonImageView2, "ivDesign01");
                q.f(toggleButton2, "ivDesignStroke01");
                this.checkAndUpdateButton(melonImageView2, toggleButton2, false);
                q.f(melonImageView1, "ivDesign02");
                q.f(toggleButton1, "ivDesignStroke02");
                this.checkAndUpdateButton(melonImageView1, toggleButton1, true);
                q.f(melonImageView0, "ivDesign03");
                q.f(toggleButton0, "ivDesignStroke03");
                this.checkAndUpdateButton(melonImageView0, toggleButton0, false);
            }
            else if(v == LyricHighLightShareFragment.VIEW_TYPE_ALBUM) {
                q.f(melonImageView2, "ivDesign01");
                q.f(toggleButton2, "ivDesignStroke01");
                this.checkAndUpdateButton(melonImageView2, toggleButton2, false);
                q.f(melonImageView1, "ivDesign02");
                q.f(toggleButton1, "ivDesignStroke02");
                this.checkAndUpdateButton(melonImageView1, toggleButton1, false);
                q.f(melonImageView0, "ivDesign03");
                q.f(toggleButton0, "ivDesignStroke03");
                this.checkAndUpdateButton(melonImageView0, toggleButton0, true);
            }
            if(!z) {
                this.currentType = v;
                POSTINFO songLyricHighlightPostRes$RESPONSE$POSTINFO0 = this.postInfoRes;
                if(songLyricHighlightPostRes$RESPONSE$POSTINFO0 != null) {
                    this.updateLyricUi(songLyricHighlightPostRes$RESPONSE$POSTINFO0, v, "onClick - " + v);
                    return;
                }
                q.m("postInfoRes");
                throw null;
            }
        }
    }

    public static void updateDesignButton$default(LyricHighLightShareFragment lyricHighLightShareFragment0, int v, boolean z, int v1, Object object0) {
        if((v1 & 2) != 0) {
            z = false;
        }
        lyricHighLightShareFragment0.updateDesignButton(v, z);
    }

    private final void updateLyricTextColor(String s) {
        this.isTypeChanged = true;
        boolean z = q.b("textColorWhite", s);
        int v = this.currentType;
        if(v == LyricHighLightShareFragment.VIEW_TYPE_DIALOG) {
            MelonTextView melonTextView0 = this.tvLyric;
            if(melonTextView0 != null) {
                melonTextView0.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F06016A)));  // color:white000e
            }
            ImageView imageView0 = this.ivQuoteLeft;
            if(imageView0 != null) {
                imageView0.setImageResource((z ? 0x7F0805C2 : 0x7F0805C3));  // drawable:ic_quote_left
            }
            ImageView imageView1 = this.ivQuoteRight;
            if(imageView1 != null) {
                imageView1.setImageResource((z ? 0x7F0805C4 : 0x7F0805C5));  // drawable:ic_quote_right
            }
        }
        else if(v == LyricHighLightShareFragment.VIEW_TYPE_NOTE) {
            View view0 = this.type2TopUnderline;
            if(view0 != null) {
                view0.setBackgroundColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604B1 : 0x7F060153)));  // color:white220e
            }
            UnderlineTextView underlineTextView0 = this.underlineTvLyric;
            if(underlineTextView0 != null) {
                underlineTextView0.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F06016A)));  // color:white000e
            }
            UnderlineTextView underlineTextView1 = this.underlineTvLyric;
            if(underlineTextView1 != null) {
                underlineTextView1.setUnderlineColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604B1 : 0x7F060153)));  // color:white220e
            }
            UnderlineTextView underlineTextView2 = this.underlineTvLyric;
            if(underlineTextView2 != null) {
                underlineTextView2.h();
            }
        }
        else if(v == LyricHighLightShareFragment.VIEW_TYPE_ALBUM) {
            MelonTextView melonTextView1 = this.tvLyric;
            if(melonTextView1 != null) {
                melonTextView1.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F06016A)));  // color:white000e
            }
            View view1 = this.vDash;
            if(view1 != null) {
                view1.setBackgroundColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604B1 : 0x7F060153)));  // color:white220e
            }
        }
        t0 t00 = this.binding;
        if(t00 != null) {
            ImageView imageView2 = t00.l;
            int v1 = ColorUtils.getColor(this.getContext(), (z ? 0x7F0604B7 : 0x7F06015F));  // color:white700e
            t00.z.setTextColor(v1);
            int v2 = ColorUtils.getColor(this.getContext(), (z ? 0x7F0604B7 : 0x7F06015F));  // color:white700e
            t00.y.setTextColor(v2);
            MelonTextView melonTextView2 = this.tvSong;
            if(melonTextView2 != null) {
                melonTextView2.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F06016A)));  // color:white000e
            }
            MelonTextView melonTextView3 = this.tvArtist;
            if(melonTextView3 != null) {
                melonTextView3.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F06016A)));  // color:white000e
            }
            imageView2.setImageResource((z ? 0x7F0805E7 : 0x7F0805E6));  // drawable:ic_symbol_19_w
            imageView2.setAlpha(0.6f);
        }
    }

    private final void updateLyricUi(POSTINFO songLyricHighlightPostRes$RESPONSE$POSTINFO0, int v, String s) {
        View view0;
        Y.w("updateLyricUi callFrom: ", s, LogU.Companion, "LyricHighLightShareFragment");
        if(this.itemContainer != null) {
            this.postInfoRes = songLyricHighlightPostRes$RESPONSE$POSTINFO0;
            ScrollView scrollView0 = this.scrollView;
            int v1 = 0;
            if(scrollView0 != null) {
                scrollView0.setVisibility(0);
            }
            RelativeLayout relativeLayout0 = this.itemContainer;
            if(relativeLayout0 != null && relativeLayout0.getChildCount() > 0) {
                relativeLayout0.removeAllViews();
            }
            String s1 = songLyricHighlightPostRes$RESPONSE$POSTINFO0.chicLyric;
            q.f(s1, "chicLyric");
            List list0 = Tf.o.R0(s1, new String[]{"\n"}, 0, 6);
            int v2 = LyricHighLightShareFragment.RATIO_SQUARE == this.aspectRatio ? LyricHighLightShareFragment.SQUARE_MAXLINE : LyricHighLightShareFragment.RECT_MAXLINE;
            String s2 = "";
            int v3 = 0;
            int v4 = 0;
            for(Object object0: list0) {
                if(v3 >= 0) {
                    if(v4 == v2) {
                        break;
                    }
                    if(Tf.o.e1(((String)object0)).toString().length() > 0) {
                        s2 = s2 + ((String)object0);
                        ++v4;
                        if(v3 != list0.size() - 1) {
                            s2 = s2 + "\n";
                        }
                    }
                    ++v3;
                    continue;
                }
                k.O();
                throw null;
            }
            if(v == LyricHighLightShareFragment.VIEW_TYPE_DIALOG) {
                view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D041F, null, false);  // layout:highlighting_type1_item
                q.f(view0, "inflate(...)");
                MelonTextView melonTextView0 = (MelonTextView)view0.findViewById(0x7F0A0CA9);  // id:tv_lyric
                this.tvLyric = melonTextView0;
                if(melonTextView0 != null) {
                    melonTextView0.setMaxLines((LyricHighLightShareFragment.RATIO_SQUARE == this.aspectRatio ? LyricHighLightShareFragment.SQUARE_MAXLINE : LyricHighLightShareFragment.RECT_MAXLINE));
                }
                this.ivQuoteLeft = (ImageView)view0.findViewById(0x7F0A0676);  // id:iv_quote_left
                this.ivQuoteRight = (ImageView)view0.findViewById(0x7F0A0677);  // id:iv_quote_right
                MelonTextView melonTextView1 = this.tvLyric;
                if(melonTextView1 != null) {
                    melonTextView1.setText(s2);
                }
                VerticalTextView verticalTextView0 = this.tvVerticalNickName;
                if(verticalTextView0 != null) {
                    String s3 = this.getString(0x7F130499);  // string:highlighting_pick_by_nickname "Picked By %s"
                    q.f(s3, "getString(...)");
                    verticalTextView0.setText(String.format(s3, Arrays.copyOf(new Object[]{songLyricHighlightPostRes$RESPONSE$POSTINFO0.memberNickName}, 1)));
                }
            }
            else if(v == LyricHighLightShareFragment.VIEW_TYPE_NOTE) {
                view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0420, null, false);  // layout:highlighting_type2_item
                q.f(view0, "inflate(...)");
                UnderlineTextView underlineTextView0 = (UnderlineTextView)view0.findViewById(0x7F0A07C1);  // id:lyric_tv
                this.underlineTvLyric = underlineTextView0;
                if(underlineTextView0 != null) {
                    underlineTextView0.setMaxLines((LyricHighLightShareFragment.RATIO_SQUARE == this.aspectRatio ? LyricHighLightShareFragment.SQUARE_MAXLINE : LyricHighLightShareFragment.RECT_MAXLINE));
                }
                this.type2TopUnderline = view0.findViewById(0x7F0A0BD6);  // id:top_underline
                UnderlineTextView underlineTextView1 = this.underlineTvLyric;
                if(underlineTextView1 != null) {
                    underlineTextView1.setText(s2);
                }
                MelonTextView melonTextView2 = this.tvHorizonNickName;
                if(melonTextView2 != null) {
                    String s4 = this.getString(0x7F130499);  // string:highlighting_pick_by_nickname "Picked By %s"
                    q.f(s4, "getString(...)");
                    l1.D(new Object[]{songLyricHighlightPostRes$RESPONSE$POSTINFO0.memberNickName}, 1, s4, melonTextView2);
                }
            }
            else if(v == LyricHighLightShareFragment.VIEW_TYPE_ALBUM) {
                view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0421, null, false);  // layout:highlighting_type3_item
                q.f(view0, "inflate(...)");
                this.albumContainer = (FrameLayout)view0.findViewById(0x7F0A0081);  // id:album_container
                View view1 = view0.findViewById(0x7F0A05ED);  // id:iv_album_thumb
                q.f(view1, "findViewById(...)");
                Context context0 = this.getContext();
                if(context0 != null) {
                    Glide.with(context0).load(songLyricHighlightPostRes$RESPONSE$POSTINFO0.albumImg).into(((MelonImageView)view1));
                }
                String s5 = songLyricHighlightPostRes$RESPONSE$POSTINFO0.albumImg;
                q.f(s5, "albumImg");
                if(s5.length() > 0) {
                    View view2 = view0.findViewById(0x7F0A05EB);  // id:iv_album_default_cover
                    q.f(view2, "findViewById(...)");
                    ((ImageView)view2).setVisibility(8);
                }
                ((MelonImageView)view1).setAlpha(0.9f);
                MelonTextView melonTextView3 = (MelonTextView)view0.findViewById(0x7F0A0CA9);  // id:tv_lyric
                this.tvLyric = melonTextView3;
                if(melonTextView3 != null) {
                    melonTextView3.setMaxLines((LyricHighLightShareFragment.RATIO_SQUARE == this.aspectRatio ? LyricHighLightShareFragment.SQUARE_MAXLINE : LyricHighLightShareFragment.RECT_MAXLINE));
                }
                MelonTextView melonTextView4 = this.tvLyric;
                if(melonTextView4 != null) {
                    melonTextView4.setText(s2);
                }
                VerticalTextView verticalTextView1 = this.tvVerticalNickName;
                if(verticalTextView1 != null) {
                    String s6 = this.getString(0x7F130499);  // string:highlighting_pick_by_nickname "Picked By %s"
                    q.f(s6, "getString(...)");
                    verticalTextView1.setText(String.format(s6, Arrays.copyOf(new Object[]{songLyricHighlightPostRes$RESPONSE$POSTINFO0.memberNickName}, 1)));
                }
                this.vDash = view0.findViewById(0x7F0A0D99);  // id:v_dash
            }
            else {
                view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D041F, null, false);  // layout:highlighting_type1_item
                q.f(view0, "inflate(...)");
                MelonTextView melonTextView5 = (MelonTextView)view0.findViewById(0x7F0A0CA9);  // id:tv_lyric
                this.tvLyric = melonTextView5;
                if(melonTextView5 != null) {
                    melonTextView5.setText(s2);
                }
                VerticalTextView verticalTextView2 = this.tvVerticalNickName;
                if(verticalTextView2 != null) {
                    String s7 = this.getString(0x7F130499);  // string:highlighting_pick_by_nickname "Picked By %s"
                    q.f(s7, "getString(...)");
                    verticalTextView2.setText(String.format(s7, Arrays.copyOf(new Object[]{songLyricHighlightPostRes$RESPONSE$POSTINFO0.memberNickName}, 1)));
                }
            }
            this.tvSong = (MelonTextView)view0.findViewById(0x7F0A0D14);  // id:tv_song
            this.tvArtist = (MelonTextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
            if(this.isTypeNote()) {
                MelonTextView melonTextView6 = this.tvHorizonNickName;
                if(melonTextView6 != null) {
                    if(this.toggleNickName == null || !this.toggleNickName.isChecked()) {
                        v1 = 8;
                    }
                    melonTextView6.setVisibility(v1);
                }
                VerticalTextView verticalTextView3 = this.tvVerticalNickName;
                if(verticalTextView3 != null) {
                    verticalTextView3.setVisibility(8);
                }
            }
            else {
                VerticalTextView verticalTextView4 = this.tvVerticalNickName;
                if(verticalTextView4 != null) {
                    if(this.toggleNickName == null || !this.toggleNickName.isChecked()) {
                        v1 = 8;
                    }
                    verticalTextView4.setVisibility(v1);
                }
                MelonTextView melonTextView7 = this.tvHorizonNickName;
                if(melonTextView7 != null) {
                    melonTextView7.setVisibility(8);
                }
            }
            MelonTextView melonTextView8 = this.tvSong;
            if(melonTextView8 != null) {
                melonTextView8.setText(songLyricHighlightPostRes$RESPONSE$POSTINFO0.songName);
            }
            MelonTextView melonTextView9 = this.tvArtist;
            if(melonTextView9 != null) {
                melonTextView9.setText(ProtocolUtils.getArtistNames(songLyricHighlightPostRes$RESPONSE$POSTINFO0.artistList));
            }
            RelativeLayout relativeLayout1 = this.itemContainer;
            if(relativeLayout1 != null) {
                relativeLayout1.addView(view0);
            }
        }
        this.updateAspectRatio(this.aspectRatio);
        this.updateLyricTextColor(this.textColor);
    }

    private final void updateRatioButton(int v, boolean z) {
        LogU.debug$default(LyricHighLightShareFragment.log, "updateRatioButton aspectRatio: " + this.aspectRatio + ", selectType: " + v, null, false, 6, null);
        t0 t00 = this.binding;
        if(t00 != null) {
            ToggleButton toggleButton0 = t00.n;
            MelonImageView melonImageView0 = t00.m;
            ToggleButton toggleButton1 = t00.q;
            MelonImageView melonImageView1 = t00.p;
            if(LyricHighLightShareFragment.RATIO_SQUARE == v) {
                q.f(melonImageView1, "ivSquareRatio");
                q.f(toggleButton1, "ivSquareStroke");
                this.checkAndUpdateButton(melonImageView1, toggleButton1, true);
                q.f(melonImageView0, "ivRectangleRatio");
                q.f(toggleButton0, "ivRectangleStroke");
                this.checkAndUpdateButton(melonImageView0, toggleButton0, false);
            }
            else {
                q.f(melonImageView0, "ivRectangleRatio");
                q.f(toggleButton0, "ivRectangleStroke");
                this.checkAndUpdateButton(melonImageView0, toggleButton0, true);
                q.f(melonImageView1, "ivSquareRatio");
                q.f(toggleButton1, "ivSquareStroke");
                this.checkAndUpdateButton(melonImageView1, toggleButton1, false);
            }
            if(!z) {
                this.aspectRatio = v;
                POSTINFO songLyricHighlightPostRes$RESPONSE$POSTINFO0 = this.postInfoRes;
                if(songLyricHighlightPostRes$RESPONSE$POSTINFO0 != null) {
                    this.updateLyricUi(songLyricHighlightPostRes$RESPONSE$POSTINFO0, this.currentType, "onClick - " + v);
                    return;
                }
                q.m("postInfoRes");
                throw null;
            }
        }
    }

    public static void updateRatioButton$default(LyricHighLightShareFragment lyricHighLightShareFragment0, int v, boolean z, int v1, Object object0) {
        if((v1 & 2) != 0) {
            z = false;
        }
        lyricHighLightShareFragment0.updateRatioButton(v, z);
    }

    private final void updateTextColorButton(String s, boolean z) {
        StringBuilder stringBuilder0 = d.o("updateTextColorButton textColor: ", this.textColor, ", textColorType: ", s, ", fromInit: ");
        stringBuilder0.append(z);
        LogU.debug$default(LyricHighLightShareFragment.log, stringBuilder0.toString(), null, false, 6, null);
        t0 t00 = this.binding;
        if(t00 != null) {
            ToggleButton toggleButton0 = t00.r;
            ToggleButton toggleButton1 = t00.s;
            if(q.b("textColorWhite", s)) {
                toggleButton1.setChecked(true);
                toggleButton0.setChecked(false);
            }
            else {
                toggleButton0.setChecked(true);
                toggleButton1.setChecked(false);
            }
            if(!z) {
                this.textColor = s;
                this.updateLyricTextColor(s);
            }
        }
    }

    public static void updateTextColorButton$default(LyricHighLightShareFragment lyricHighLightShareFragment0, String s, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        lyricHighLightShareFragment0.updateTextColorButton(s, z);
    }
}

