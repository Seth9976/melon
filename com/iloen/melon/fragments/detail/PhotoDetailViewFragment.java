package com.iloen.melon.fragments.detail;

import Cb.j;
import F8.S;
import F8.m;
import H0.b;
import Tf.o;
import Tf.v;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.github.chrisbanes.OnSwipeListener;
import com.github.chrisbanes.PhotoView;
import com.google.android.exoplayer2.upstream.cache.a;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.request.SearchPhotoViewBaseReq.Params;
import com.iloen.melon.net.v4x.request.SearchPhotoViewReq;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.SearchPhotoViewRes;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.net.v6x.request.AlbumContentsPhotoReq;
import com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq;
import com.iloen.melon.net.v6x.request.PhotoCountInfoReq;
import com.iloen.melon.net.v6x.request.PhotoInfoReq;
import com.iloen.melon.net.v6x.response.AlbumContentsPhotoRes;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes;
import com.iloen.melon.net.v6x.response.PhotoCountInfoRes;
import com.iloen.melon.net.v6x.response.PhotoInfoRes.RESPONSE.NEXTPHOTOIDLIST;
import com.iloen.melon.net.v6x.response.PhotoInfoRes.RESPONSE.PREVPHOTOIDLIST;
import com.iloen.melon.net.v6x.response.PhotoInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.PhotoInfoRes;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharablePhoto;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.template.TemplateImageCacheManager;
import com.iloen.melon.utils.ui.PhotoDetailUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ArtistInfoBase;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u00E8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t*\u0004\u00A9\u0001\u00AD\u0001\b\u0017\u0018\u0000 \u00BA\u00012\u00020\u0001:\n\u00BA\u0001\u00BB\u0001\u00BC\u0001\u00BD\u0001\u00BE\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000EJ-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001D\u0010#\u001A\b\u0012\u0002\b\u0003\u0018\u00010\"2\u0006\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b#\u0010$J\u0011\u0010&\u001A\u0004\u0018\u00010%H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0016\u00A2\u0006\u0004\b)\u0010*J\u0011\u0010,\u001A\u0004\u0018\u00010+H\u0014\u00A2\u0006\u0004\b,\u0010-J\u0011\u0010/\u001A\u0004\u0018\u00010.H\u0014\u00A2\u0006\u0004\b/\u00100J\'\u00106\u001A\u00020\u00042\u0006\u00102\u001A\u0002012\u0006\u00104\u001A\u0002032\u0006\u00105\u001A\u00020(H\u0014\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b8\u0010\u0003J\u000F\u00109\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b9\u0010\u0003J\u0011\u0010;\u001A\u0004\u0018\u00010:H\u0002\u00A2\u0006\u0004\b;\u0010<J\u000F\u0010=\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b=\u0010\u0003J\u0017\u0010?\u001A\u00020\f2\u0006\u0010>\u001A\u00020:H\u0002\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bA\u0010\u0003J\u0017\u0010C\u001A\u00020\f2\u0006\u0010B\u001A\u00020:H\u0002\u00A2\u0006\u0004\bC\u0010@J\u0017\u0010D\u001A\u00020\f2\u0006\u0010B\u001A\u00020:H\u0002\u00A2\u0006\u0004\bD\u0010@J#\u0010G\u001A\u00020\f2\b\u0010E\u001A\u0004\u0018\u00010(2\b\u0010F\u001A\u0004\u0018\u00010(H\u0002\u00A2\u0006\u0004\bG\u0010HJ\u0019\u0010J\u001A\u00020\f2\b\u0010I\u001A\u0004\u0018\u00010:H\u0002\u00A2\u0006\u0004\bJ\u0010@J-\u0010N\u001A\u00020\f2\b\u0010K\u001A\u0004\u0018\u00010(2\b\u0010L\u001A\u0004\u0018\u00010(2\b\u0010M\u001A\u0004\u0018\u00010(H\u0002\u00A2\u0006\u0004\bN\u0010OJ#\u0010R\u001A\u00020\f2\b\u0010P\u001A\u0004\u0018\u00010(2\b\u0010Q\u001A\u0004\u0018\u00010(H\u0002\u00A2\u0006\u0004\bR\u0010HJ\u0017\u0010T\u001A\u00020\f2\u0006\u0010S\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bT\u0010UJ\u000F\u0010V\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bV\u0010\u0003J\u000F\u0010W\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bW\u0010\u0003J\u000F\u0010X\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bX\u0010\u0003J\u000F\u0010Y\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bY\u0010\u0003J\u000F\u0010Z\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bZ\u0010\u0003J\u0017\u0010\\\u001A\u00020\f2\u0006\u0010[\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\\\u0010UJ\u0019\u0010]\u001A\u00020\f2\b\u0010F\u001A\u0004\u0018\u00010(H\u0002\u00A2\u0006\u0004\b]\u0010^J\u000F\u0010_\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b_\u0010\u0003J\u0019\u0010`\u001A\u00020\f2\b\u0010E\u001A\u0004\u0018\u00010(H\u0002\u00A2\u0006\u0004\b`\u0010^J\u000F\u0010a\u001A\u00020\fH\u0002\u00A2\u0006\u0004\ba\u0010\u0003J\u0017\u0010c\u001A\u00020\f2\u0006\u0010b\u001A\u00020(H\u0002\u00A2\u0006\u0004\bc\u0010^J\u000F\u0010d\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bd\u0010\u0003J\u000F\u0010e\u001A\u00020\fH\u0002\u00A2\u0006\u0004\be\u0010\u0003J\u0017\u0010f\u001A\u00020\f2\u0006\u0010S\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bf\u0010UJ\u0013\u0010g\u001A\u00020\f*\u00020\u0016H\u0002\u00A2\u0006\u0004\bg\u0010hJ\u0013\u0010i\u001A\u00020\f*\u00020\u0016H\u0002\u00A2\u0006\u0004\bi\u0010hJ\u0017\u0010k\u001A\u00020\f2\u0006\u0010j\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bk\u0010UJ\u000F\u0010l\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bl\u0010\u0003R\u001C\u0010n\u001A\u00020m8\u0002@\u0002X\u0082\u000E\u00A2\u0006\f\n\u0004\bn\u0010o\u0012\u0004\bp\u0010\u0003R\u0018\u0010r\u001A\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010u\u001A\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010w\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\by\u0010xR\u0018\u0010z\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bz\u0010xR\u0018\u0010{\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b{\u0010xR\u0018\u0010|\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b|\u0010xR\u0018\u0010}\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b}\u0010xR\u0018\u0010~\u001A\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b~\u0010vR\u001B\u0010\u0080\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001B\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R\u001B\u0010\u0083\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001R\u001A\u0010\u0084\u0001\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0084\u0001\u0010xR\u001B\u0010\u0085\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0081\u0001R\u001A\u0010\u0086\u0001\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0086\u0001\u0010xR\u001A\u0010\u0087\u0001\u001A\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u0087\u0001\u0010vR\u001C\u0010\u0089\u0001\u001A\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008A\u0001R\u001B\u0010\u008B\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008B\u0001\u0010\u0081\u0001R\u001B\u0010\u008C\u0001\u001A\u0004\u0018\u00010\u007F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008C\u0001\u0010\u0081\u0001R\u0019\u0010\u008D\u0001\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\u001B\u0010\u008F\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008F\u0001\u0010\u0090\u0001R\u001B\u0010\u0091\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0090\u0001R\u001B\u0010\u0092\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R\u001B\u0010\u0093\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0090\u0001R\u001B\u0010\u0094\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001R\u001C\u0010\u0096\u0001\u001A\u0005\u0018\u00010\u0095\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001C\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u0098\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009A\u0001R\u001B\u0010\u009B\u0001\u001A\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009B\u0001\u0010\u009C\u0001R\u0018\u0010\u009D\u0001\u001A\u00020m8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b\u009D\u0001\u0010oR\u001C\u0010\u009F\u0001\u001A\u0005\u0018\u00010\u009E\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009F\u0001\u0010\u00A0\u0001R\u001B\u0010\u00A1\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A1\u0001\u0010\u0090\u0001R\u001B\u0010\u00A2\u0001\u001A\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00A2\u0001\u0010\u0090\u0001R\u0018\u0010\u00A4\u0001\u001A\u00030\u00A3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A4\u0001\u0010\u00A5\u0001R\u0018\u0010\u00A6\u0001\u001A\u00030\u00A3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A6\u0001\u0010\u00A5\u0001R\u0018\u0010\u00A7\u0001\u001A\u00030\u00A3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A7\u0001\u0010\u00A5\u0001R\u0018\u0010\u00A8\u0001\u001A\u00030\u00A3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00A8\u0001\u0010\u00A5\u0001R\u0018\u0010\u00AA\u0001\u001A\u00030\u00A9\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AA\u0001\u0010\u00AB\u0001R\u0018\u0010\u00AC\u0001\u001A\u00030\u00A3\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AC\u0001\u0010\u00A5\u0001R\u0018\u0010\u00AE\u0001\u001A\u00030\u00AD\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00AE\u0001\u0010\u00AF\u0001R\u0016\u0010\u00B0\u0001\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B0\u0001\u0010\u0006R\u0018\u0010\u00B2\u0001\u001A\u0004\u0018\u00010(8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B1\u0001\u0010*R\u0017\u0010b\u001A\u0004\u0018\u00010(8BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B3\u0001\u0010*R\u0016\u0010\u00B4\u0001\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B4\u0001\u0010\u0006R\u0016\u0010\u00B5\u0001\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00B5\u0001\u0010\u0006R\u001A\u0010\u00B9\u0001\u001A\u0005\u0018\u00010\u00B6\u00018BX\u0082\u0004\u00A2\u0006\b\u001A\u0006\b\u00B7\u0001\u0010\u00B8\u0001\u00A8\u0006\u00BF\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "shouldShowMiniPlayer", "()Z", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onRestoreInstanceState", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "getCacheKey", "()Ljava/lang/String;", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onDirectOpenFragment", "initPhotoDetailLayout", "Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;", "fetchData", "()Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;", "executeArtistContentsPhotoListReq", "photoInfoResponse", "executeSearchPhotoViewReq", "(Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;)V", "executeAlbumContentsPhotoListReq", "info", "getLikeYnFromServer", "getViewCntFromServer", "viewCnt", "likeCnt", "setViewCountLikeCount", "(Ljava/lang/String;Ljava/lang/String;)V", "response", "updateUi", "artistId", "artistName", "artistImg", "setArtistInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "photoImg", "photoDesc", "setInfoView", "isVisible", "setErrorViewVisibility", "(Z)V", "initInfoView", "updateInfoView", "updateInfoViewGroupLayoutParams", "updatePhotoIndex", "updateMyLike", "isLike", "updateLikeViewColor", "updateLikeCntView", "(Ljava/lang/String;)V", "updateLikeContainerContentDescription", "updateViewCntView", "updateBtnMoreView", "description", "setInfoDescriptionText", "calculateButtonGroupHeight", "setInfoViewGroupHeight", "setInfoViewVisibility", "fadeInAndShow", "(Landroid/view/View;)V", "fadeOutAndHide", "isLeftSlide", "slidePhotoView", "openCmtPage", "", "currentScaleMode", "I", "getCurrentScaleMode$annotations", "Lcom/github/chrisbanes/PhotoView;", "detailImageView", "Lcom/github/chrisbanes/PhotoView;", "Landroid/widget/ImageView;", "btnSwipeNext", "Landroid/widget/ImageView;", "shadowView", "Landroid/view/View;", "infoViewGroup", "infoSeparatorView", "buttonGroup", "errorView", "likeContainer", "likeYnView", "Landroid/widget/TextView;", "textDescView", "Landroid/widget/TextView;", "btnMoreView", "likeCount", "cmtContainer", "cmtCount", "artistContainer", "ivThumbCircleDefault", "Lcom/iloen/melon/custom/BorderImageView;", "ivThumbCircle", "Lcom/iloen/melon/custom/BorderImageView;", "textArtistChannel", "viewCount", "isActivityView", "Z", "initialPhotoUrl", "Ljava/lang/String;", "initialDescription", "photoTitle", "photoAccessibilityDesc", "pvLogDummyAction", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfo;", "photoInfo", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfo;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;", "photoInfoList", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;", "photoInfoRes", "Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;", "photoButtonHeight", "LF8/S;", "shareButton", "LF8/S;", "descWithNewline", "descWithoutNewline", "Landroid/view/View$OnClickListener;", "likedOnClickListener", "Landroid/view/View$OnClickListener;", "reviewedOnClickListener", "sharedOnClickListener", "infoViewGroupOnClickListener", "com/iloen/melon/fragments/detail/PhotoDetailViewFragment$photoViewAnimationListener$1", "photoViewAnimationListener", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$photoViewAnimationListener$1;", "onClickListener", "com/iloen/melon/fragments/detail/PhotoDetailViewFragment$onSwipeListener$1", "onSwipeListener", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$onSwipeListener$1;", "isSimplePhotoView", "getPhotoUrl", "photoUrl", "getDescription", "isLayoutChanged", "isDisplayedArtistImage", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "tiaraEventBuilder", "Companion", "PhotoViewType", "PhotoItem", "PhotoInfoList", "PhotoInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PhotoDetailViewFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u00182\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001AH\u0007J\u001A\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00052\b\b\u0002\u0010\u001B\u001A\u00020\u001AH\u0007JH\u0010\u0015\u001A\u00020\u00162\b\u0010\u001D\u001A\u0004\u0018\u00010\u00052\b\u0010\u001E\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0019\u001A\u00020\u001A2\b\b\u0002\u0010\u001B\u001A\u00020\u001AH\u0007J\u000E\u0010\u0015\u001A\u00020\u00162\u0006\u0010!\u001A\u00020\"R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_IS_ACTIVITY_VIEW", "ARG_PHOTO_INFO", "ARG_PHOTO_INFO_LIST", "ARG_PHOTO_URL", "ARG_PHOTO_TITLE", "ARG_DESCRIPTION", "ARG_ACCESSIBILITY_DESCRIPTION", "ARG_KEY_SCALE", "ARG_PV_LOG_DUMMY_ACTION", "SCALE_FULL", "", "SCALE_SMALL", "REQ_COUNT", "DEFAULT_DESCRIPTION_LINES", "thumbCircleDiameter", "newInstance", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment;", "infoList", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;", "isActivityView", "", "showSnsPopup", "photoId", "photoUrl", "description", "photoTitle", "pvLogDummyAction", "param", "Lcom/iloen/melon/net/v4x/request/SearchPhotoViewBaseReq$Params;", "Scale", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        @Retention(RetentionPolicy.SOURCE)
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$Companion$Scale;", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public @interface Scale {
        }

        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0) {
            q.g(photoDetailViewFragment$PhotoInfoList0, "infoList");
            return Companion.newInstance$default(this, photoDetailViewFragment$PhotoInfoList0, false, false, 6, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0, boolean z) {
            q.g(photoDetailViewFragment$PhotoInfoList0, "infoList");
            return Companion.newInstance$default(this, photoDetailViewFragment$PhotoInfoList0, z, false, 4, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0, boolean z, boolean z1) {
            q.g(photoDetailViewFragment$PhotoInfoList0, "infoList");
            PhotoDetailViewFragment photoDetailViewFragment0 = new PhotoDetailViewFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("argPhotoInfoList", photoDetailViewFragment$PhotoInfoList0);
            bundle0.putBoolean("argIsActivityView", z);
            bundle0.putBoolean("argVisibleSnsPopup", z1);
            photoDetailViewFragment0.setArguments(bundle0);
            return photoDetailViewFragment0;
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@NotNull Params searchPhotoViewBaseReq$Params0) {
            q.g(searchPhotoViewBaseReq$Params0, "param");
            PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
            photoDetailViewFragment$PhotoInfoList0.setType(Search.INSTANCE);
            photoDetailViewFragment$PhotoInfoList0.getPhotoItems().add(new PhotoItem(searchPhotoViewBaseReq$Params0.photoId, null, null, null, null, 16, null));
            photoDetailViewFragment$PhotoInfoList0.setSearchParam(searchPhotoViewBaseReq$Params0);
            PhotoDetailViewFragment photoDetailViewFragment0 = new PhotoDetailViewFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("argPhotoInfoList", photoDetailViewFragment$PhotoInfoList0);
            bundle0.putBoolean("argVisibleSnsPopup", false);
            photoDetailViewFragment0.setArguments(bundle0);
            return photoDetailViewFragment0;
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@NotNull String s) {
            q.g(s, "photoId");
            return Companion.newInstance$default(this, s, false, 2, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1) {
            return Companion.newInstance$default(this, s, s1, null, null, false, false, 60, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2) {
            return Companion.newInstance$default(this, s, s1, s2, null, false, false, 56, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            return Companion.newInstance$default(this, s, s1, s2, s3, false, false, 0x30, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z) {
            return Companion.newInstance$default(this, s, s1, s2, s3, z, false, 0x20, null);
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z, boolean z1) {
            PhotoDetailViewFragment photoDetailViewFragment0 = new PhotoDetailViewFragment();
            Bundle bundle0 = Y.b("argPhotoUrl", s);
            if(s1 != null && s1.length() > 0 && o.e1(s1).toString().length() > 0) {
                bundle0.putString("argDescription", s1);
            }
            if(s2 != null && s2.length() > 0 && o.e1(s2).toString().length() > 0) {
                PhotoDetailUtils photoDetailUtils0 = PhotoDetailUtils.INSTANCE;
                if(photoDetailUtils0.isAccessibilityDesc(s2)) {
                    bundle0.putString("argAccessibilityDescription", photoDetailUtils0.convertToTitleFromAccessibilityDesc(s2));
                }
                else {
                    bundle0.putString("argPhotoTitle", s2);
                }
            }
            bundle0.putBoolean("argIsActivityView", z);
            bundle0.putBoolean("argVisibleSnsPopup", z1);
            bundle0.putString("argPvLogDummyAction", s3);
            photoDetailViewFragment0.setArguments(bundle0);
            return photoDetailViewFragment0;
        }

        @NotNull
        public final PhotoDetailViewFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "photoId");
            PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
            photoDetailViewFragment$PhotoInfoList0.setType(Etc.INSTANCE);
            photoDetailViewFragment$PhotoInfoList0.getPhotoItems().add(new PhotoItem(s, null, null, null, null, 30, null));
            PhotoDetailViewFragment photoDetailViewFragment0 = new PhotoDetailViewFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("argPhotoInfoList", photoDetailViewFragment$PhotoInfoList0);
            bundle0.putBoolean("argVisibleSnsPopup", z);
            photoDetailViewFragment0.setArguments(bundle0);
            return photoDetailViewFragment0;
        }

        public static PhotoDetailViewFragment newInstance$default(Companion photoDetailViewFragment$Companion0, PhotoInfoList photoDetailViewFragment$PhotoInfoList0, boolean z, boolean z1, int v, Object object0) {
            if((v & 2) != 0) {
                z = false;
            }
            if((v & 4) != 0) {
                z1 = false;
            }
            return photoDetailViewFragment$Companion0.newInstance(photoDetailViewFragment$PhotoInfoList0, z, z1);
        }

        public static PhotoDetailViewFragment newInstance$default(Companion photoDetailViewFragment$Companion0, String s, String s1, String s2, String s3, boolean z, boolean z1, int v, Object object0) {
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            boolean z2 = (v & 16) == 0 ? z : false;
            return (v & 0x20) == 0 ? photoDetailViewFragment$Companion0.newInstance(s, s1, s2, s3, z2, z1) : photoDetailViewFragment$Companion0.newInstance(s, s1, s2, s3, z2, false);
        }

        public static PhotoDetailViewFragment newInstance$default(Companion photoDetailViewFragment$Companion0, String s, boolean z, int v, Object object0) {
            if((v & 2) != 0) {
                z = false;
            }
            return photoDetailViewFragment$Companion0.newInstance(s, z);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b \n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\n\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\u000B\u0010\fJ3\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u000F\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\u000B\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000E\u0010\u0014\u001A\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017R$\u0010\u000F\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u000F\u0010\u0014\u001A\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0017R$\u0010\u0010\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001A\u0004\b\u001A\u0010\u0013\"\u0004\b\u001B\u0010\u0017R$\u0010\u001C\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001C\u0010\u0014\u001A\u0004\b\u001D\u0010\u0013\"\u0004\b\u001E\u0010\u0017R$\u0010\u001F\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001F\u0010\u0014\u001A\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0017R$\u0010\"\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001A\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0017R$\u0010%\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b%\u0010\u0014\u001A\u0004\b&\u0010\u0013\"\u0004\b\'\u0010\u0017R$\u0010(\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010\u0014\u001A\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0017R$\u0010+\u001A\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010\u0014\u001A\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0017R\"\u0010/\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b5\u00100\u001A\u0004\b6\u00102\"\u0004\b7\u00104R\"\u00108\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b8\u00100\u001A\u0004\b9\u00102\"\u0004\b:\u00104R\"\u0010<\u001A\u00020;8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b<\u0010=\u001A\u0004\b<\u0010>\"\u0004\b?\u0010@R\"\u0010A\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bA\u00100\u001A\u0004\bB\u00102\"\u0004\bC\u00104\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfo;", "Ljava/io/Serializable;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;", "photoInfoList", "<init>", "(Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;)V", "Lie/H;", "clear", "()V", "Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;", "response", "setResponse", "(Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;)V", "", "artistId", "artistName", "artistImg", "(Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getArtistId", "setArtistId", "(Ljava/lang/String;)V", "getArtistName", "setArtistName", "getArtistImg", "setArtistImg", "menuId", "getMenuId", "setMenuId", "photoId", "getPhotoId", "setPhotoId", "photoImg", "getPhotoImg", "setPhotoImg", "postImg", "getPostImg", "setPostImg", "postEditImg", "getPostEditImg", "setPostEditImg", "photoDesc", "getPhotoDesc", "setPhotoDesc", "", "viewCnt", "I", "getViewCnt", "()I", "setViewCnt", "(I)V", "cmtCnt", "getCmtCnt", "setCmtCnt", "likeCnt", "getLikeCnt", "setLikeCnt", "", "isLike", "Z", "()Z", "setLike", "(Z)V", "bbsChannelSeq", "getBbsChannelSeq", "setBbsChannelSeq", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PhotoInfo implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfo$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfo.Companion {
            private com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfo.Companion() {
            }

            public com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfo.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfo.Companion Companion = null;
        @Nullable
        private String artistId;
        @Nullable
        private String artistImg;
        @Nullable
        private String artistName;
        private int bbsChannelSeq;
        private int cmtCnt;
        private boolean isLike;
        private int likeCnt;
        @Nullable
        private String menuId;
        @Nullable
        private String photoDesc;
        @Nullable
        private String photoId;
        @Nullable
        private String photoImg;
        @Nullable
        private String postEditImg;
        @Nullable
        private String postImg;
        private static final long serialVersionUID = 1L;
        private int viewCnt;

        static {
            PhotoInfo.Companion = new com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfo.Companion(null);
            PhotoInfo.$stable = 8;
        }

        public PhotoInfo(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0) {
            q.g(photoDetailViewFragment$PhotoInfoList0, "photoInfoList");
            super();
            this.artistId = photoDetailViewFragment$PhotoInfoList0.getCurrentArtistId();
            this.artistName = photoDetailViewFragment$PhotoInfoList0.getCurrentArtistName();
            this.artistImg = photoDetailViewFragment$PhotoInfoList0.getCurrentArtistImg();
        }

        public final void clear() {
            this.menuId = null;
            this.photoId = null;
            this.photoImg = null;
            this.postImg = null;
            this.postEditImg = null;
            this.photoDesc = null;
            this.viewCnt = 0;
            this.cmtCnt = 0;
            this.likeCnt = 0;
            this.isLike = false;
            this.bbsChannelSeq = 0;
        }

        @Nullable
        public final String getArtistId() {
            return this.artistId;
        }

        @Nullable
        public final String getArtistImg() {
            return this.artistImg;
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        public final int getBbsChannelSeq() {
            return this.bbsChannelSeq;
        }

        public final int getCmtCnt() {
            return this.cmtCnt;
        }

        public final int getLikeCnt() {
            return this.likeCnt;
        }

        @Nullable
        public final String getMenuId() {
            return this.menuId;
        }

        @Nullable
        public final String getPhotoDesc() {
            return this.photoDesc;
        }

        @Nullable
        public final String getPhotoId() {
            return this.photoId;
        }

        @Nullable
        public final String getPhotoImg() {
            return this.photoImg;
        }

        @Nullable
        public final String getPostEditImg() {
            return this.postEditImg;
        }

        @Nullable
        public final String getPostImg() {
            return this.postImg;
        }

        public final int getViewCnt() {
            return this.viewCnt;
        }

        public final boolean isLike() {
            return this.isLike;
        }

        public final void setArtistId(@Nullable String s) {
            this.artistId = s;
        }

        public final void setArtistImg(@Nullable String s) {
            this.artistImg = s;
        }

        public final void setArtistName(@Nullable String s) {
            this.artistName = s;
        }

        public final void setBbsChannelSeq(int v) {
            this.bbsChannelSeq = v;
        }

        public final void setCmtCnt(int v) {
            this.cmtCnt = v;
        }

        public final void setLike(boolean z) {
            this.isLike = z;
        }

        public final void setLikeCnt(int v) {
            this.likeCnt = v;
        }

        public final void setMenuId(@Nullable String s) {
            this.menuId = s;
        }

        public final void setPhotoDesc(@Nullable String s) {
            this.photoDesc = s;
        }

        public final void setPhotoId(@Nullable String s) {
            this.photoId = s;
        }

        public final void setPhotoImg(@Nullable String s) {
            this.photoImg = s;
        }

        public final void setPostEditImg(@Nullable String s) {
            this.postEditImg = s;
        }

        public final void setPostImg(@Nullable String s) {
            this.postImg = s;
        }

        public final void setResponse(@NotNull RESPONSE photoInfoRes$RESPONSE0) {
            q.g(photoInfoRes$RESPONSE0, "response");
            if(this.artistId == null || this.artistId.length() == 0) {
                this.artistId = ProtocolUtils.getFirstArtistId(photoInfoRes$RESPONSE0.artistlist);
            }
            if(this.artistName == null || this.artistName.length() == 0) {
                this.artistName = ProtocolUtils.findArtistName(photoInfoRes$RESPONSE0.artistlist, this.artistId);
            }
            if(this.artistImg == null || this.artistImg.length() == 0) {
                this.artistImg = ProtocolUtils.findArtistImg(photoInfoRes$RESPONSE0.artistlist, this.artistId);
            }
            this.setResponse(photoInfoRes$RESPONSE0, this.artistId, this.artistName, this.artistImg);
        }

        public final void setResponse(@NotNull RESPONSE photoInfoRes$RESPONSE0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
            q.g(photoInfoRes$RESPONSE0, "response");
            this.clear();
            this.artistId = s;
            this.artistName = s1;
            this.artistImg = s2;
            this.menuId = photoInfoRes$RESPONSE0.menuId;
            this.photoId = photoInfoRes$RESPONSE0.photoid;
            this.photoImg = photoInfoRes$RESPONSE0.photoimg;
            this.postImg = photoInfoRes$RESPONSE0.postimg;
            this.postEditImg = photoInfoRes$RESPONSE0.posteditimg;
            this.photoDesc = photoInfoRes$RESPONSE0.desc;
            this.cmtCnt = StringUtils.getNumberFromString(photoInfoRes$RESPONSE0.cmtcnt);
            this.bbsChannelSeq = photoInfoRes$RESPONSE0.bbschannelseq;
        }

        public final void setViewCnt(int v) {
            this.viewCnt = v;
        }

        @Override
        @NotNull
        public String toString() {
            String s = "{artistId:" + this.artistId + ", artistName:" + this.artistName + ", artistImg:" + this.artistImg + ", menuId:" + this.menuId + ", photoId:" + this.photoId + ", photoImg:" + this.photoImg + ", postImg:" + this.postImg + ", postEditImg:" + this.postEditImg + ", photoDesc:" + this.photoDesc + ", viewCnt:" + this.viewCnt + ", cmtCnt:" + this.cmtCnt + ", likeCnt:" + this.likeCnt + ", isLike:" + this.isLike + ", bbsChannelSeq:" + this.bbsChannelSeq + "}";
            q.f(s, "toString(...)");
            return s;
        }
    }

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u001E\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u001B\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b\u00A2\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\u0004\u00A2\u0006\u0004\b\u000E\u0010\u0006J\u0015\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u0017\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u0010\u001A\u00020\u001A\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FR$\u0010!\u001A\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\'8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010(\u001A\u0004\b)\u0010*R$\u0010+\u001A\u0004\u0018\u00010\u001D8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010,\u001A\u0004\b-\u0010\u001F\"\u0004\b.\u0010/R\"\u00101\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u00102\u001A\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b7\u00102\u001A\u0004\b8\u00104\"\u0004\b9\u00106R\"\u0010:\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b:\u00102\u001A\u0004\b;\u00104\"\u0004\b<\u00106R\"\u0010=\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b?\u0010\u0006\"\u0004\b@\u0010AR\"\u0010B\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bB\u0010>\u001A\u0004\bC\u0010\u0006\"\u0004\bD\u0010AR$\u0010F\u001A\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bF\u0010G\u001A\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010L\u001A\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bL\u0010M\u001A\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010R\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bR\u0010>\u001A\u0004\bS\u0010\u0006\"\u0004\bT\u0010AR\"\u0010U\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010>\u001A\u0004\bV\u0010\u0006\"\u0004\bW\u0010AR\u0013\u0010Y\u001A\u0004\u0018\u00010\u001D8F\u00A2\u0006\u0006\u001A\u0004\bX\u0010\u001FR\u0013\u0010[\u001A\u0004\u0018\u00010\u001D8F\u00A2\u0006\u0006\u001A\u0004\bZ\u0010\u001FR\u0013\u0010]\u001A\u0004\u0018\u00010\u001D8F\u00A2\u0006\u0006\u001A\u0004\b\\\u0010\u001FR\u0013\u0010_\u001A\u0004\u0018\u00010\u001D8F\u00A2\u0006\u0006\u001A\u0004\b^\u0010\u001FR\u0013\u0010a\u001A\u0004\u0018\u00010\u001D8F\u00A2\u0006\u0006\u001A\u0004\b`\u0010\u001F\u00A8\u0006c"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;", "Ljava/io/Serializable;", "<init>", "()V", "", "movePrevious", "()Z", "moveNext", "", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "photoItems", "Lie/H;", "append", "(Ljava/util/List;)V", "needLoadMore", "Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;", "response", "setPhotoInformResponse", "(Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;)V", "Lcom/iloen/melon/net/v4x/response/SearchPhotoViewRes$RESPONSE;", "searchResponse", "setSearchPhotoInformResponse", "(Lcom/iloen/melon/net/v6x/response/PhotoInfoRes$RESPONSE;Lcom/iloen/melon/net/v4x/response/SearchPhotoViewRes$RESPONSE;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsPhotoListRes;", "setArtistDetailContentsPhotoListRes", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsPhotoListRes;)V", "Lcom/iloen/melon/net/v6x/response/AlbumContentsPhotoRes;", "setAlbumDetailContentsPhotoListRes", "(Lcom/iloen/melon/net/v6x/response/AlbumContentsPhotoRes;)V", "", "toString", "()Ljava/lang/String;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "type", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "getType", "()Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "setType", "(Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;)V", "", "Ljava/util/List;", "getPhotoItems", "()Ljava/util/List;", "orderBy", "Ljava/lang/String;", "getOrderBy", "setOrderBy", "(Ljava/lang/String;)V", "", "position", "I", "getPosition", "()I", "setPosition", "(I)V", "photoIndex", "getPhotoIndex", "setPhotoIndex", "photoTotalCount", "getPhotoTotalCount", "setPhotoTotalCount", "hasMorePrevOutOfRange", "Z", "getHasMorePrevOutOfRange", "setHasMorePrevOutOfRange", "(Z)V", "hasMoreNextOutOfRange", "getHasMoreNextOutOfRange", "setHasMoreNextOutOfRange", "Lcom/iloen/melon/net/v4x/request/SearchPhotoViewBaseReq$Params;", "searchParam", "Lcom/iloen/melon/net/v4x/request/SearchPhotoViewBaseReq$Params;", "getSearchParam", "()Lcom/iloen/melon/net/v4x/request/SearchPhotoViewBaseReq$Params;", "setSearchParam", "(Lcom/iloen/melon/net/v4x/request/SearchPhotoViewBaseReq$Params;)V", "artistPhotoItem", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "getArtistPhotoItem", "()Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "setArtistPhotoItem", "(Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;)V", "displayArtistImage", "getDisplayArtistImage", "setDisplayArtistImage", "changeViewType", "getChangeViewType", "setChangeViewType", "getCurrId", "currId", "getCurrentArtistId", "currentArtistId", "getCurrentArtistName", "currentArtistName", "getCurrentArtistImg", "currentArtistImg", "getCurrentAlbumId", "currentAlbumId", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PhotoInfoList implements Serializable {
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007J4\u0010\u0010\u001A\u00020\u00072\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\t0\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u000FJ0\u0010\u0015\u001A\u00020\u00072\b\u0010\u0016\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0017\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0018\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0019\u001A\u0004\u0018\u00010\u000FH\u0007J4\u0010\u001A\u001A\u00020\u00072\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\t0\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\u000FR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList$Companion;", "", "<init>", "()V", "serialVersionUID", "", "buildArtistWithPhotoParams", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoInfoList;", "artistItem", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "photoItemList", "", "hasMore", "", "orderBy", "", "buildArtistInfoParams", "photoIds", "position", "", "totalCount", "buildEtcParams", "photoId", "artistId", "artistName", "artistImg", "buildAlbumInfoParams", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList.Companion {
            private com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList.Companion() {
            }

            public com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final PhotoInfoList buildAlbumInfoParams(@NotNull List list0, boolean z, int v, int v1, @NotNull String s) {
                q.g(list0, "photoIds");
                q.g(s, "orderBy");
                PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
                photoDetailViewFragment$PhotoInfoList0.setType(AlbumInfo.INSTANCE);
                photoDetailViewFragment$PhotoInfoList0.setPosition(v);
                photoDetailViewFragment$PhotoInfoList0.setPhotoIndex(photoDetailViewFragment$PhotoInfoList0.getPosition() + 1);
                photoDetailViewFragment$PhotoInfoList0.setPhotoTotalCount(v1);
                photoDetailViewFragment$PhotoInfoList0.setOrderBy(s);
                photoDetailViewFragment$PhotoInfoList0.setHasMoreNextOutOfRange(z);
                photoDetailViewFragment$PhotoInfoList0.getPhotoItems().addAll(list0);
                return photoDetailViewFragment$PhotoInfoList0;
            }

            @NotNull
            public final PhotoInfoList buildArtistInfoParams(@NotNull List list0, boolean z, int v, int v1, @NotNull String s) {
                q.g(list0, "photoIds");
                q.g(s, "orderBy");
                PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
                photoDetailViewFragment$PhotoInfoList0.setType(ArtistInfo.INSTANCE);
                photoDetailViewFragment$PhotoInfoList0.setPosition(v);
                photoDetailViewFragment$PhotoInfoList0.setPhotoIndex(photoDetailViewFragment$PhotoInfoList0.getPosition() + 1);
                photoDetailViewFragment$PhotoInfoList0.setPhotoTotalCount(v1);
                photoDetailViewFragment$PhotoInfoList0.setOrderBy(s);
                photoDetailViewFragment$PhotoInfoList0.setHasMoreNextOutOfRange(z);
                photoDetailViewFragment$PhotoInfoList0.getPhotoItems().addAll(list0);
                return photoDetailViewFragment$PhotoInfoList0;
            }

            @NotNull
            public final PhotoInfoList buildArtistWithPhotoParams(@NotNull PhotoItem photoDetailViewFragment$PhotoItem0, @NotNull List list0, boolean z, @NotNull String s) {
                q.g(photoDetailViewFragment$PhotoItem0, "artistItem");
                q.g(list0, "photoItemList");
                q.g(s, "orderBy");
                PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
                photoDetailViewFragment$PhotoInfoList0.setType(ArtistWithPhoto.INSTANCE);
                photoDetailViewFragment$PhotoInfoList0.setPosition(0);
                photoDetailViewFragment$PhotoInfoList0.setPhotoIndex(photoDetailViewFragment$PhotoInfoList0.getPosition() + 1);
                photoDetailViewFragment$PhotoInfoList0.setDisplayArtistImage(true);
                photoDetailViewFragment$PhotoInfoList0.setArtistPhotoItem(photoDetailViewFragment$PhotoItem0);
                photoDetailViewFragment$PhotoInfoList0.setPhotoTotalCount(list0.size());
                photoDetailViewFragment$PhotoInfoList0.getPhotoItems().addAll(list0);
                photoDetailViewFragment$PhotoInfoList0.setHasMoreNextOutOfRange(z);
                photoDetailViewFragment$PhotoInfoList0.setOrderBy(s);
                return photoDetailViewFragment$PhotoInfoList0;
            }

            @NotNull
            public final PhotoInfoList buildEtcParams(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
                PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
                photoDetailViewFragment$PhotoInfoList0.setType(Etc.INSTANCE);
                photoDetailViewFragment$PhotoInfoList0.getPhotoItems().add(new PhotoItem(s, s1, s2, s3, null, 16, null));
                return photoDetailViewFragment$PhotoInfoList0;
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList.Companion Companion = null;
        @Nullable
        private PhotoItem artistPhotoItem;
        private boolean changeViewType;
        private boolean displayArtistImage;
        private boolean hasMoreNextOutOfRange;
        private boolean hasMorePrevOutOfRange;
        @Nullable
        private String orderBy;
        private int photoIndex;
        @NotNull
        private final List photoItems;
        private int photoTotalCount;
        private int position;
        @Nullable
        private Params searchParam;
        private static final long serialVersionUID = 1L;
        @Nullable
        private PhotoViewType type;

        static {
            PhotoInfoList.Companion = new com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList.Companion(null);
            PhotoInfoList.$stable = 8;
        }

        public PhotoInfoList() {
            this.photoItems = new ArrayList();
        }

        public final void append(@NotNull List list0) {
            q.g(list0, "photoItems");
            if(!list0.isEmpty()) {
                this.photoItems.addAll(list0);
            }
        }

        @NotNull
        public static final PhotoInfoList buildArtistWithPhotoParams(@NotNull PhotoItem photoDetailViewFragment$PhotoItem0, @NotNull List list0, boolean z, @NotNull String s) {
            return PhotoInfoList.Companion.buildArtistWithPhotoParams(photoDetailViewFragment$PhotoItem0, list0, z, s);
        }

        @NotNull
        public static final PhotoInfoList buildEtcParams(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            return PhotoInfoList.Companion.buildEtcParams(s, s1, s2, s3);
        }

        @Nullable
        public final PhotoItem getArtistPhotoItem() {
            return this.artistPhotoItem;
        }

        public final boolean getChangeViewType() {
            return this.changeViewType;
        }

        @Nullable
        public final String getCurrId() {
            PhotoItem photoDetailViewFragment$PhotoItem0 = (PhotoItem)p.n0(this.position, this.photoItems);
            return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getPhotoId();
        }

        @Nullable
        public final String getCurrentAlbumId() {
            PhotoItem photoDetailViewFragment$PhotoItem0 = (PhotoItem)p.n0(this.position, this.photoItems);
            return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getAlbumId();
        }

        @Nullable
        public final String getCurrentArtistId() {
            PhotoItem photoDetailViewFragment$PhotoItem0 = (PhotoItem)p.n0(this.position, this.photoItems);
            return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getArtistId();
        }

        @Nullable
        public final String getCurrentArtistImg() {
            PhotoItem photoDetailViewFragment$PhotoItem0 = (PhotoItem)p.n0(this.position, this.photoItems);
            return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getArtistImg();
        }

        @Nullable
        public final String getCurrentArtistName() {
            PhotoItem photoDetailViewFragment$PhotoItem0 = (PhotoItem)p.n0(this.position, this.photoItems);
            return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getArtistName();
        }

        public final boolean getDisplayArtistImage() {
            return this.displayArtistImage;
        }

        public final boolean getHasMoreNextOutOfRange() {
            return this.hasMoreNextOutOfRange;
        }

        public final boolean getHasMorePrevOutOfRange() {
            return this.hasMorePrevOutOfRange;
        }

        @Nullable
        public final String getOrderBy() {
            return this.orderBy;
        }

        public final int getPhotoIndex() {
            return this.photoIndex;
        }

        @NotNull
        public final List getPhotoItems() {
            return this.photoItems;
        }

        public final int getPhotoTotalCount() {
            return this.photoTotalCount;
        }

        public final int getPosition() {
            return this.position;
        }

        @Nullable
        public final Params getSearchParam() {
            return this.searchParam;
        }

        @Nullable
        public final PhotoViewType getType() {
            return this.type;
        }

        public final boolean moveNext() {
            if(this.photoItems.isEmpty()) {
                return false;
            }
            if(this.position == 0 && q.b(ArtistWithPhoto.INSTANCE, this.type) && this.displayArtistImage) {
                this.displayArtistImage = false;
                this.changeViewType = true;
                return true;
            }
            if(this.position == this.photoItems.size() - 1) {
                return false;
            }
            ++this.position;
            ++this.photoIndex;
            Params searchPhotoViewBaseReq$Params0 = this.searchParam;
            if(searchPhotoViewBaseReq$Params0 != null) {
                searchPhotoViewBaseReq$Params0.photoId = this.getCurrId();
                ++searchPhotoViewBaseReq$Params0.photoIndex;
            }
            this.changeViewType = false;
            return true;
        }

        public final boolean movePrevious() {
            if(this.photoItems.isEmpty()) {
                return false;
            }
            int v = this.position;
            if(v == 0) {
                if(q.b(ArtistWithPhoto.INSTANCE, this.type) && !this.displayArtistImage) {
                    this.displayArtistImage = true;
                    this.changeViewType = true;
                    return true;
                }
                return false;
            }
            this.position = v - 1;
            --this.photoIndex;
            Params searchPhotoViewBaseReq$Params0 = this.searchParam;
            if(searchPhotoViewBaseReq$Params0 != null) {
                searchPhotoViewBaseReq$Params0.photoId = this.getCurrId();
                --searchPhotoViewBaseReq$Params0.photoIndex;
            }
            this.changeViewType = false;
            return true;
        }

        public final boolean needLoadMore() {
            return this.hasMoreNextOutOfRange && this.position == this.photoItems.size() - 2;
        }

        public final void setAlbumDetailContentsPhotoListRes(@NotNull AlbumContentsPhotoRes albumContentsPhotoRes0) {
            q.g(albumContentsPhotoRes0, "response");
            List list0 = albumContentsPhotoRes0.response == null ? null : albumContentsPhotoRes0.response.photos;
            if(list0 != null && !list0.isEmpty()) {
                ArrayList arrayList0 = new ArrayList(list0.size());
                for(Object object0: list0) {
                    arrayList0.add(new PhotoItem(((PHOTO)object0).photoId, this.getCurrentArtistId(), this.getCurrentArtistName(), this.getCurrentArtistImg(), this.getCurrentAlbumId()));
                }
                this.append(arrayList0);
                this.hasMoreNextOutOfRange = albumContentsPhotoRes0.hasMore();
                this.photoTotalCount += arrayList0.size();
            }
        }

        public final void setArtistDetailContentsPhotoListRes(@NotNull ArtistContentsPhotoListRes artistContentsPhotoListRes0) {
            q.g(artistContentsPhotoListRes0, "response");
            List list0 = artistContentsPhotoListRes0.response == null ? null : artistContentsPhotoListRes0.response.photos;
            if(list0 != null && !list0.isEmpty()) {
                ArrayList arrayList0 = new ArrayList(list0.size());
                for(Object object0: list0) {
                    arrayList0.add(new PhotoItem(((PHOTO)object0).photoId, this.getCurrentArtistId(), this.getCurrentArtistName(), this.getCurrentArtistImg(), this.getCurrentAlbumId()));
                }
                this.append(arrayList0);
                this.hasMoreNextOutOfRange = artistContentsPhotoListRes0.hasMore();
                this.photoTotalCount += arrayList0.size();
            }
        }

        public final void setArtistPhotoItem(@Nullable PhotoItem photoDetailViewFragment$PhotoItem0) {
            this.artistPhotoItem = photoDetailViewFragment$PhotoItem0;
        }

        public final void setChangeViewType(boolean z) {
            this.changeViewType = z;
        }

        public final void setDisplayArtistImage(boolean z) {
            this.displayArtistImage = z;
        }

        public final void setHasMoreNextOutOfRange(boolean z) {
            this.hasMoreNextOutOfRange = z;
        }

        public final void setHasMorePrevOutOfRange(boolean z) {
            this.hasMorePrevOutOfRange = z;
        }

        public final void setOrderBy(@Nullable String s) {
            this.orderBy = s;
        }

        public final void setPhotoIndex(int v) {
            this.photoIndex = v;
        }

        public final void setPhotoInformResponse(@NotNull RESPONSE photoInfoRes$RESPONSE0) {
            q.g(photoInfoRes$RESPONSE0, "response");
            if(photoInfoRes$RESPONSE0.photoindex != null && photoInfoRes$RESPONSE0.photoindex.length() > 0) {
                try {
                    Integer integer0 = Integer.valueOf(photoInfoRes$RESPONSE0.photoindex);
                    q.f(integer0, "valueOf(...)");
                    this.photoIndex = integer0.intValue();
                }
                catch(NumberFormatException unused_ex) {
                }
            }
            if(photoInfoRes$RESPONSE0.photocnt != null && photoInfoRes$RESPONSE0.photocnt.length() > 0) {
                try {
                    Integer integer1 = Integer.valueOf(photoInfoRes$RESPONSE0.photocnt);
                    q.f(integer1, "valueOf(...)");
                    this.photoTotalCount = integer1.intValue();
                }
                catch(NumberFormatException unused_ex) {
                }
            }
            ArrayList arrayList0 = photoInfoRes$RESPONSE0.prevphotoidlist;
            ArrayList arrayList1 = photoInfoRes$RESPONSE0.nextphotoidlist;
            if(arrayList0 != null && !arrayList0.isEmpty() || arrayList1 != null && !arrayList1.isEmpty()) {
                String s = this.getCurrentArtistId();
                String s1 = s == null || s.length() == 0 ? ProtocolUtils.getFirstArtistId(photoInfoRes$RESPONSE0.artistlist) : this.getCurrentArtistId();
                String s2 = ProtocolUtils.findArtistName(photoInfoRes$RESPONSE0.artistlist, s1);
                String s3 = this.getCurrentArtistImg();
                String s4 = s3 == null || s3.length() == 0 ? ProtocolUtils.findArtistImg(photoInfoRes$RESPONSE0.artistlist, s1) : this.getCurrentArtistImg();
                this.photoItems.clear();
                if(arrayList0 != null) {
                    for(Object object0: arrayList0) {
                        PhotoItem photoDetailViewFragment$PhotoItem0 = new PhotoItem(((PREVPHOTOIDLIST)object0).photoid, s1, s2, s4, null, 16, null);
                        this.photoItems.add(photoDetailViewFragment$PhotoItem0);
                    }
                }
                this.position = this.photoItems.size();
                PhotoItem photoDetailViewFragment$PhotoItem1 = new PhotoItem(photoInfoRes$RESPONSE0.photoid, s1, s2, s4, null, 16, null);
                this.photoItems.add(photoDetailViewFragment$PhotoItem1);
                if(arrayList1 != null) {
                    for(Object object1: arrayList1) {
                        PhotoItem photoDetailViewFragment$PhotoItem2 = new PhotoItem(((NEXTPHOTOIDLIST)object1).photoid, s1, s2, s4, null, 16, null);
                        this.photoItems.add(photoDetailViewFragment$PhotoItem2);
                    }
                }
                this.hasMorePrevOutOfRange = "Y".equals(photoInfoRes$RESPONSE0.prevmoreyn);
                this.hasMoreNextOutOfRange = "Y".equals(photoInfoRes$RESPONSE0.nextmoreyn);
                return;
            }
            LogU.Companion.w("PhotoDetailViewFragment", "setPhotoInformResponse() prev & next list empty");
        }

        public final void setPhotoTotalCount(int v) {
            this.photoTotalCount = v;
        }

        public final void setPosition(int v) {
            this.position = v;
        }

        public final void setSearchParam(@Nullable Params searchPhotoViewBaseReq$Params0) {
            this.searchParam = searchPhotoViewBaseReq$Params0;
        }

        public final void setSearchPhotoInformResponse(@NotNull RESPONSE photoInfoRes$RESPONSE0, @NotNull com.iloen.melon.net.v4x.response.SearchPhotoViewRes.RESPONSE searchPhotoViewRes$RESPONSE0) {
            q.g(photoInfoRes$RESPONSE0, "response");
            q.g(searchPhotoViewRes$RESPONSE0, "searchResponse");
            if(photoInfoRes$RESPONSE0.photoindex != null && photoInfoRes$RESPONSE0.photoindex.length() > 0) {
                try {
                    Integer integer0 = Integer.valueOf(photoInfoRes$RESPONSE0.photoindex);
                    q.f(integer0, "valueOf(...)");
                    this.photoIndex = integer0.intValue();
                }
                catch(NumberFormatException unused_ex) {
                }
            }
            this.photoTotalCount = 0;
            ArrayList arrayList0 = searchPhotoViewRes$RESPONSE0.prevphotoidlist;
            ArrayList arrayList1 = searchPhotoViewRes$RESPONSE0.nextphotoidlist;
            if(arrayList0 != null && !arrayList0.isEmpty() || arrayList1 != null && !arrayList1.isEmpty()) {
                String s = this.getCurrentArtistId();
                String s1 = s == null || s.length() == 0 ? ProtocolUtils.getFirstArtistId(photoInfoRes$RESPONSE0.artistlist) : this.getCurrentArtistId();
                String s2 = this.getCurrentArtistName();
                String s3 = s2 == null || s2.length() == 0 ? ProtocolUtils.findArtistName(photoInfoRes$RESPONSE0.artistlist, s1) : this.getCurrentArtistName();
                String s4 = this.getCurrentArtistImg();
                String s5 = s4 == null || s4.length() == 0 ? ProtocolUtils.findArtistImg(photoInfoRes$RESPONSE0.artistlist, s1) : this.getCurrentArtistImg();
                this.photoItems.clear();
                if(arrayList0 != null) {
                    for(Object object0: arrayList0) {
                        PhotoItem photoDetailViewFragment$PhotoItem0 = new PhotoItem(((com.iloen.melon.net.v4x.response.SearchPhotoViewRes.RESPONSE.PREVPHOTOIDLIST)object0).photoid, ProtocolUtils.getFirstArtistId(((com.iloen.melon.net.v4x.response.SearchPhotoViewRes.RESPONSE.PREVPHOTOIDLIST)object0).artistlist), null, null, null, 16, null);
                        this.photoItems.add(photoDetailViewFragment$PhotoItem0);
                    }
                }
                this.position = this.photoItems.size();
                PhotoItem photoDetailViewFragment$PhotoItem1 = new PhotoItem(photoInfoRes$RESPONSE0.photoid, s1, s3, s5, null, 16, null);
                this.photoItems.add(photoDetailViewFragment$PhotoItem1);
                if(arrayList1 != null) {
                    for(Object object1: arrayList1) {
                        PhotoItem photoDetailViewFragment$PhotoItem2 = new PhotoItem(((com.iloen.melon.net.v4x.response.SearchPhotoViewRes.RESPONSE.NEXTPHOTOIDLIST)object1).photoid, ProtocolUtils.getFirstArtistId(((com.iloen.melon.net.v4x.response.SearchPhotoViewRes.RESPONSE.NEXTPHOTOIDLIST)object1).artistlist), null, null, null, 16, null);
                        this.photoItems.add(photoDetailViewFragment$PhotoItem2);
                    }
                }
                this.hasMorePrevOutOfRange = "Y".equals(searchPhotoViewRes$RESPONSE0.prevmoreyn);
                this.hasMoreNextOutOfRange = "Y".equals(searchPhotoViewRes$RESPONSE0.nextmoreyn);
                return;
            }
            LogU.Companion.w("PhotoDetailViewFragment", "setSearchPhotoInformResponse() prev & next list empty");
        }

        public final void setType(@Nullable PhotoViewType photoDetailViewFragment$PhotoViewType0) {
            this.type = photoDetailViewFragment$PhotoViewType0;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = Y.p("{type:");
            stringBuilder0.append(this.type);
            stringBuilder0.append(", position:");
            stringBuilder0.append(this.position);
            stringBuilder0.append(", photoIndex:");
            stringBuilder0.append(this.photoIndex);
            stringBuilder0.append(", totalCount:");
            stringBuilder0.append(this.photoTotalCount);
            stringBuilder0.append(", hasMorePrevOutOfRange:");
            stringBuilder0.append(this.hasMorePrevOutOfRange);
            stringBuilder0.append(", hasMoreNextOutOfRange:");
            stringBuilder0.append(this.hasMoreNextOutOfRange);
            stringBuilder0.append(", displayArtistImage:");
            stringBuilder0.append(this.displayArtistImage);
            stringBuilder0.append(", changeViewType:");
            stringBuilder0.append(this.changeViewType);
            PhotoItem photoDetailViewFragment$PhotoItem0 = this.artistPhotoItem;
            if(photoDetailViewFragment$PhotoItem0 != null) {
                stringBuilder0.append(", artistPhotoItem:(");
                stringBuilder0.append(photoDetailViewFragment$PhotoItem0.getArtistId());
                stringBuilder0.append("-");
                stringBuilder0.append(photoDetailViewFragment$PhotoItem0.getArtistName());
                stringBuilder0.append("-");
                stringBuilder0.append(photoDetailViewFragment$PhotoItem0.getArtistImg());
                stringBuilder0.append(")");
            }
            stringBuilder0.append(", photoItems.size:");
            stringBuilder0.append(this.photoItems.size());
            stringBuilder0.append(", photoItems[");
            int v = 0;
            for(Object object0: this.photoItems) {
                PhotoItem photoDetailViewFragment$PhotoItem1 = (PhotoItem)object0;
                if(v == this.position) {
                    stringBuilder0.append("<");
                    stringBuilder0.append(photoDetailViewFragment$PhotoItem1.getPhotoId());
                    stringBuilder0.append("(");
                    stringBuilder0.append(photoDetailViewFragment$PhotoItem1.getArtistId());
                    stringBuilder0.append("-");
                    stringBuilder0.append(photoDetailViewFragment$PhotoItem1.getArtistName());
                    stringBuilder0.append("-");
                    stringBuilder0.append(photoDetailViewFragment$PhotoItem1.getArtistImg());
                    stringBuilder0.append(")>,");
                }
                else {
                    stringBuilder0.append(photoDetailViewFragment$PhotoItem1.getPhotoId());
                    stringBuilder0.append(",");
                }
                ++v;
            }
            stringBuilder0.deleteCharAt(stringBuilder0.length() - 1);
            stringBuilder0.append("]}");
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            return s;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010BC\b\u0007\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000BR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000B¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "Ljava/io/Serializable;", "photoId", "", "artistId", "artistName", "artistImg", "albumId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPhotoId", "()Ljava/lang/String;", "getArtistId", "getArtistName", "getArtistImg", "getAlbumId", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PhotoItem implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem.Companion {
            private com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem.Companion() {
            }

            public com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem.Companion Companion = null;
        @Nullable
        private final String albumId;
        @Nullable
        private final String artistId;
        @Nullable
        private final String artistImg;
        @Nullable
        private final String artistName;
        @Nullable
        private final String photoId;
        private static final long serialVersionUID = 1L;

        static {
            PhotoItem.Companion = new com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem.Companion(null);
        }

        public PhotoItem(@Nullable String s) {
            this(s, null, null, null, null, 30, null);
        }

        public PhotoItem(@Nullable String s, @Nullable String s1) {
            this(s, s1, null, null, null, 28, null);
        }

        public PhotoItem(@Nullable String s, @Nullable String s1, @Nullable String s2) {
            this(s, s1, s2, null, null, 24, null);
        }

        public PhotoItem(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            this(s, s1, s2, s3, null, 16, null);
        }

        public PhotoItem(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            this.photoId = s;
            this.artistId = s1;
            this.artistName = s2;
            this.artistImg = s3;
            this.albumId = s4;
        }

        public PhotoItem(String s, String s1, String s2, String s3, String s4, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            this(s, s1, s2, s3, ((v & 16) == 0 ? s4 : null));
        }

        @Nullable
        public final String getAlbumId() {
            return this.albumId;
        }

        @Nullable
        public final String getArtistId() {
            return this.artistId;
        }

        @Nullable
        public final String getArtistImg() {
            return this.artistImg;
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        @Nullable
        public final String getPhotoId() {
            return this.photoId;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u000F\u0010\u0011\u0012\u0013B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BH\u0096\u0002J\b\u0010\f\u001A\u00020\rH\u0016J\b\u0010\u000E\u001A\u00020\u0003H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "Ljava/io/Serializable;", "typeName", "", "<init>", "(Ljava/lang/String;)V", "getTypeName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "ArtistInfo", "ArtistWithPhoto", "Search", "Etc", "AlbumInfo", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$AlbumInfo;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$ArtistInfo;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$ArtistWithPhoto;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$Etc;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$Search;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class PhotoViewType implements Serializable {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$AlbumInfo;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class AlbumInfo extends PhotoViewType {
            public static final int $stable;
            @NotNull
            public static final AlbumInfo INSTANCE;

            static {
                AlbumInfo.INSTANCE = new AlbumInfo();
            }

            private AlbumInfo() {
                super("AlbumInfo", null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$ArtistInfo;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ArtistInfo extends PhotoViewType {
            public static final int $stable;
            @NotNull
            public static final ArtistInfo INSTANCE;

            static {
                ArtistInfo.INSTANCE = new ArtistInfo();
            }

            private ArtistInfo() {
                super("ArtistInfo", null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$ArtistWithPhoto;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ArtistWithPhoto extends PhotoViewType {
            public static final int $stable;
            @NotNull
            public static final ArtistWithPhoto INSTANCE;

            static {
                ArtistWithPhoto.INSTANCE = new ArtistWithPhoto();
            }

            private ArtistWithPhoto() {
                super("ArtistWithPhoto", null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$Etc;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Etc extends PhotoViewType {
            public static final int $stable;
            @NotNull
            public static final Etc INSTANCE;

            static {
                Etc.INSTANCE = new Etc();
            }

            private Etc() {
                super("Etc", null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType$Search;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoViewType;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Search extends PhotoViewType {
            public static final int $stable;
            @NotNull
            public static final Search INSTANCE;

            static {
                Search.INSTANCE = new Search();
            }

            private Search() {
                super("Search", null);
            }
        }

        public static final int $stable;
        @NotNull
        private final String typeName;

        private PhotoViewType(String s) {
            this.typeName = s;
        }

        public PhotoViewType(String s, DefaultConstructorMarker defaultConstructorMarker0) {
            this(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(object0 == null) {
                return false;
            }
            if(this == object0) {
                return true;
            }
            return object0 instanceof PhotoViewType ? q.b(this.typeName, ((PhotoViewType)object0).typeName) : false;
        }

        @NotNull
        public final String getTypeName() {
            return this.typeName;
        }

        @Override
        public int hashCode() {
            return this.typeName.hashCode() + 0x20F;
        }

        @Override
        @NotNull
        public String toString() {
            return "{typeName[" + this.typeName + "]}";
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ACCESSIBILITY_DESCRIPTION = "argAccessibilityDescription";
    @NotNull
    public static final String ARG_DESCRIPTION = "argDescription";
    @NotNull
    private static final String ARG_IS_ACTIVITY_VIEW = "argIsActivityView";
    @NotNull
    private static final String ARG_KEY_SCALE = "argKeyScale";
    @NotNull
    private static final String ARG_PHOTO_INFO = "argPhotoInfo";
    @NotNull
    public static final String ARG_PHOTO_INFO_LIST = "argPhotoInfoList";
    @NotNull
    private static final String ARG_PHOTO_TITLE = "argPhotoTitle";
    @NotNull
    public static final String ARG_PHOTO_URL = "argPhotoUrl";
    @NotNull
    public static final String ARG_PV_LOG_DUMMY_ACTION = "argPvLogDummyAction";
    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_DESCRIPTION_LINES = 2;
    private static final int REQ_COUNT = 1;
    private static final int SCALE_FULL = 0;
    private static final int SCALE_SMALL = 1;
    @NotNull
    private static final String TAG = "PhotoDetailViewFragment";
    @Nullable
    private View artistContainer;
    @Nullable
    private TextView btnMoreView;
    @Nullable
    private ImageView btnSwipeNext;
    @Nullable
    private View buttonGroup;
    @Nullable
    private View cmtContainer;
    @Nullable
    private TextView cmtCount;
    private int currentScaleMode;
    @Nullable
    private String descWithNewline;
    @Nullable
    private String descWithoutNewline;
    @Nullable
    private PhotoView detailImageView;
    @Nullable
    private View errorView;
    @Nullable
    private View infoSeparatorView;
    @Nullable
    private View infoViewGroup;
    @NotNull
    private final View.OnClickListener infoViewGroupOnClickListener;
    @Nullable
    private String initialDescription;
    @Nullable
    private String initialPhotoUrl;
    private boolean isActivityView;
    @Nullable
    private BorderImageView ivThumbCircle;
    @Nullable
    private ImageView ivThumbCircleDefault;
    @Nullable
    private View likeContainer;
    @Nullable
    private TextView likeCount;
    @Nullable
    private ImageView likeYnView;
    @NotNull
    private final View.OnClickListener likedOnClickListener;
    @NotNull
    private final View.OnClickListener onClickListener;
    @NotNull
    private final com.iloen.melon.fragments.detail.PhotoDetailViewFragment.onSwipeListener.1 onSwipeListener;
    @Nullable
    private String photoAccessibilityDesc;
    private int photoButtonHeight;
    @Nullable
    private PhotoInfo photoInfo;
    @Nullable
    private PhotoInfoList photoInfoList;
    @Nullable
    private RESPONSE photoInfoRes;
    @Nullable
    private String photoTitle;
    @NotNull
    private final com.iloen.melon.fragments.detail.PhotoDetailViewFragment.photoViewAnimationListener.1 photoViewAnimationListener;
    @Nullable
    private String pvLogDummyAction;
    @NotNull
    private final View.OnClickListener reviewedOnClickListener;
    @Nullable
    private View shadowView;
    @Nullable
    private S shareButton;
    @NotNull
    private final View.OnClickListener sharedOnClickListener;
    @Nullable
    private TextView textArtistChannel;
    @Nullable
    private TextView textDescView;
    private static final int thumbCircleDiameter;
    @Nullable
    private TextView viewCount;

    static {
        PhotoDetailViewFragment.Companion = new Companion(null);
        PhotoDetailViewFragment.$stable = 8;
        MelonAppBase.Companion.getClass();
        PhotoDetailViewFragment.thumbCircleDiameter = ScreenUtils.dipToPixel(t.a().getContext(), 40.0f);
    }

    public PhotoDetailViewFragment() {
        this.currentScaleMode = 1;
        this.likedOnClickListener = new y(this, 6);
        this.reviewedOnClickListener = new y(this, 1);
        this.sharedOnClickListener = new y(this, 2);
        this.infoViewGroupOnClickListener = new y(this, 3);
        this.photoViewAnimationListener = new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                q.g(animation0, "animation");
                PhotoView photoView0 = PhotoDetailViewFragment.access$getDetailImageView$p(PhotoDetailViewFragment.this);
                if(photoView0 != null) {
                    photoView0.setImageDrawable(null);
                }
                View view0 = PhotoDetailViewFragment.access$getErrorView$p(PhotoDetailViewFragment.this);
                if(view0 != null) {
                    view0.setVisibility(8);
                }
                PhotoView photoView1 = PhotoDetailViewFragment.access$getDetailImageView$p(PhotoDetailViewFragment.this);
                if(photoView1 != null) {
                    photoView1.clearAnimation();
                }
                View view1 = PhotoDetailViewFragment.access$getErrorView$p(PhotoDetailViewFragment.this);
                if(view1 != null) {
                    view1.clearAnimation();
                }
                PhotoView photoView2 = PhotoDetailViewFragment.access$getDetailImageView$p(PhotoDetailViewFragment.this);
                if(photoView2 != null) {
                    photoView2.setOnClickListener(PhotoDetailViewFragment.access$getOnClickListener$p(PhotoDetailViewFragment.this));
                    photoView2.setOnSwipeListener(PhotoDetailViewFragment.access$getOnSwipeListener$p(PhotoDetailViewFragment.this));
                }
                PhotoDetailViewFragment.access$startFetch(PhotoDetailViewFragment.this);
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
                q.g(animation0, "animation");
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                q.g(animation0, "animation");
                PhotoView photoView0 = PhotoDetailViewFragment.access$getDetailImageView$p(PhotoDetailViewFragment.this);
                if(photoView0 != null) {
                    photoView0.setOnClickListener(null);
                    photoView0.setOnSwipeListener(null);
                }
            }
        };
        this.onClickListener = new y(this, 4);
        this.onSwipeListener = new OnSwipeListener() {
            @Override  // com.github.chrisbanes.OnSwipeListener
            public void onSwipeLeft() {
                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.d("PhotoDetailViewFragment", "onSwipeLeft()");
                if(PhotoDetailViewFragment.access$getPhotoInfoList$p(PhotoDetailViewFragment.this) == null) {
                    logU$Companion0.e("PhotoDetailViewFragment", "onSwipeLeft() photoInfoList is empty");
                }
                PhotoDetailViewFragment.access$slidePhotoView(PhotoDetailViewFragment.this, true);
            }

            @Override  // com.github.chrisbanes.OnSwipeListener
            public void onSwipeRight() {
                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.d("PhotoDetailViewFragment", "onSwipeRight()");
                if(PhotoDetailViewFragment.access$getPhotoInfoList$p(PhotoDetailViewFragment.this) == null) {
                    logU$Companion0.e("PhotoDetailViewFragment", "onSwipeRight() photoInfoList is empty");
                }
                PhotoDetailViewFragment.access$slidePhotoView(PhotoDetailViewFragment.this, false);
            }
        };
    }

    public static final PhotoView access$getDetailImageView$p(PhotoDetailViewFragment photoDetailViewFragment0) {
        return photoDetailViewFragment0.detailImageView;
    }

    public static final View access$getErrorView$p(PhotoDetailViewFragment photoDetailViewFragment0) {
        return photoDetailViewFragment0.errorView;
    }

    public static final View.OnClickListener access$getOnClickListener$p(PhotoDetailViewFragment photoDetailViewFragment0) {
        return photoDetailViewFragment0.onClickListener;
    }

    public static final com.iloen.melon.fragments.detail.PhotoDetailViewFragment.onSwipeListener.1 access$getOnSwipeListener$p(PhotoDetailViewFragment photoDetailViewFragment0) {
        return photoDetailViewFragment0.onSwipeListener;
    }

    public static final PhotoInfoList access$getPhotoInfoList$p(PhotoDetailViewFragment photoDetailViewFragment0) {
        return photoDetailViewFragment0.photoInfoList;
    }

    public static final String access$getPhotoUrl(PhotoDetailViewFragment photoDetailViewFragment0) {
        return photoDetailViewFragment0.getPhotoUrl();
    }

    public static final void access$slidePhotoView(PhotoDetailViewFragment photoDetailViewFragment0, boolean z) {
        photoDetailViewFragment0.slidePhotoView(z);
    }

    public static final void access$startFetch(PhotoDetailViewFragment photoDetailViewFragment0) {
        photoDetailViewFragment0.startFetch();
    }

    private final void calculateButtonGroupHeight() {
        View view0 = this.buttonGroup;
        if(view0 != null) {
            view0.post(new Runnable() {
                @Override
                public void run() {
                    int v;
                    if(!PhotoDetailViewFragment.this.isFragmentValid()) {
                        return;
                    }
                    PhotoDetailViewFragment photoDetailViewFragment0 = PhotoDetailViewFragment.this;
                    String s = PhotoDetailViewFragment.access$getPhotoUrl(photoDetailViewFragment0);
                    if(s == null || s.length() == 0) {
                        View view0 = PhotoDetailViewFragment.this.buttonGroup;
                        v = view0 == null ? 0 : view0.getHeight();
                    }
                    else {
                        MelonAppBase.Companion.getClass();
                        v = t.a().getContext().getResources().getDimensionPixelSize(0x7F070405);  // dimen:photo_info_profile_margin_bottom
                    }
                    photoDetailViewFragment0.photoButtonHeight = v;
                    PhotoDetailViewFragment.this.setInfoViewGroupHeight();
                }
            });
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    public static void d0(VolleyError volleyError0) {
        PhotoDetailViewFragment.executeAlbumContentsPhotoListReq$lambda$34(volleyError0);
    }

    private final void executeAlbumContentsPhotoListReq() {
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList0 == null) {
            return;
        }
        com.iloen.melon.net.v6x.request.AlbumContentsPhotoReq.Params albumContentsPhotoReq$Params0 = new com.iloen.melon.net.v6x.request.AlbumContentsPhotoReq.Params();
        albumContentsPhotoReq$Params0.albumId = photoDetailViewFragment$PhotoInfoList0.getCurrentAlbumId();
        albumContentsPhotoReq$Params0.startIndex = photoDetailViewFragment$PhotoInfoList0.getPhotoItems().size() + 1;
        albumContentsPhotoReq$Params0.pageSize = 30;
        albumContentsPhotoReq$Params0.orderBy = photoDetailViewFragment$PhotoInfoList0.getOrderBy();
        RequestBuilder.newInstance(new AlbumContentsPhotoReq(this.getContext(), albumContentsPhotoReq$Params0)).tag(this.getRequestTag()).listener(new z(this, photoDetailViewFragment$PhotoInfoList0, 0)).errorListener(new a(15)).request();
    }

    private static final void executeAlbumContentsPhotoListReq$lambda$33(PhotoDetailViewFragment photoDetailViewFragment0, PhotoInfoList photoDetailViewFragment$PhotoInfoList0, Object object0) {
        if(((AlbumContentsPhotoRes)object0) != null) {
            j.b(((AlbumContentsPhotoRes)object0).notification, false, 3);
            if(j.d(((AlbumContentsPhotoRes)object0)) && photoDetailViewFragment0.isFragmentValid()) {
                photoDetailViewFragment$PhotoInfoList0.setAlbumDetailContentsPhotoListRes(((AlbumContentsPhotoRes)object0));
            }
        }
    }

    private static final void executeAlbumContentsPhotoListReq$lambda$34(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void executeArtistContentsPhotoListReq() {
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList0 == null) {
            return;
        }
        com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq.Params artistContentsPhotoListReq$Params0 = new com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq.Params();
        artistContentsPhotoListReq$Params0.artistId = photoDetailViewFragment$PhotoInfoList0.getCurrentArtistId();
        artistContentsPhotoListReq$Params0.startIndex = photoDetailViewFragment$PhotoInfoList0.getPhotoItems().size() + 1;
        artistContentsPhotoListReq$Params0.pageSize = 100;
        artistContentsPhotoListReq$Params0.orderBy = photoDetailViewFragment$PhotoInfoList0.getOrderBy();
        RequestBuilder.newInstance(new ArtistContentsPhotoListReq(this.getContext(), artistContentsPhotoListReq$Params0)).tag(this.getRequestTag()).listener(new z(this, photoDetailViewFragment$PhotoInfoList0, 1)).errorListener(new a(16)).request();
    }

    private static final void executeArtistContentsPhotoListReq$lambda$26(PhotoDetailViewFragment photoDetailViewFragment0, PhotoInfoList photoDetailViewFragment$PhotoInfoList0, Object object0) {
        ArtistContentsPhotoListRes artistContentsPhotoListRes0 = (ArtistContentsPhotoListRes)object0;
        if(object0 != null) {
            j.b(((ArtistContentsPhotoListRes)object0).notification, false, 3);
            if(j.d(((HttpResponse)object0)) && photoDetailViewFragment0.isFragmentValid()) {
                photoDetailViewFragment$PhotoInfoList0.setArtistDetailContentsPhotoListRes(((ArtistContentsPhotoListRes)object0));
            }
        }
    }

    private static final void executeArtistContentsPhotoListReq$lambda$27(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void executeSearchPhotoViewReq(RESPONSE photoInfoRes$RESPONSE0) {
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList0 != null) {
            Params searchPhotoViewBaseReq$Params0 = photoDetailViewFragment$PhotoInfoList0.getSearchParam();
            if(searchPhotoViewBaseReq$Params0 != null) {
                RequestBuilder.newInstance(new SearchPhotoViewReq(this.getContext(), searchPhotoViewBaseReq$Params0.searchKeyword, String.valueOf(searchPhotoViewBaseReq$Params0.orderBy), searchPhotoViewBaseReq$Params0.photoId, String.valueOf(searchPhotoViewBaseReq$Params0.photoIndex))).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.detail.a(11, this, photoInfoRes$RESPONSE0)).errorListener(new C(this, 5)).request();
            }
        }
    }

    private static final void executeSearchPhotoViewReq$lambda$29(PhotoDetailViewFragment photoDetailViewFragment0, RESPONSE photoInfoRes$RESPONSE0, Object object0) {
        if(((SearchPhotoViewRes)object0) != null) {
            j.b(((SearchPhotoViewRes)object0).notification, false, 3);
            if(j.d(((SearchPhotoViewRes)object0)) && photoDetailViewFragment0.isFragmentValid()) {
                PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = photoDetailViewFragment0.photoInfoList;
                if(photoDetailViewFragment$PhotoInfoList0 != null) {
                    com.iloen.melon.net.v4x.response.SearchPhotoViewRes.RESPONSE searchPhotoViewRes$RESPONSE0 = ((SearchPhotoViewRes)object0).response;
                    q.f(searchPhotoViewRes$RESPONSE0, "response");
                    photoDetailViewFragment$PhotoInfoList0.setSearchPhotoInformResponse(photoInfoRes$RESPONSE0, searchPhotoViewRes$RESPONSE0);
                }
                photoDetailViewFragment0.updateUi(photoInfoRes$RESPONSE0);
                photoDetailViewFragment0.performFetchCompleteOnlyViews();
            }
        }
    }

    private static final void executeSearchPhotoViewReq$lambda$30(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        photoDetailViewFragment0.setErrorViewVisibility(true);
        photoDetailViewFragment0.performFetchError(volleyError0);
    }

    private final void fadeInAndShow(View view0) {
        view0.setAnimation(AnimationUtils.loadAnimation(view0.getContext(), 0x10A0000));
        view0.setVisibility(0);
    }

    private final void fadeOutAndHide(View view0) {
        view0.setAnimation(AnimationUtils.loadAnimation(view0.getContext(), 0x10A0001));
        view0.setVisibility(8);
    }

    private final RESPONSE fetchData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            LogU.Companion.w("PhotoDetailViewFragment", "fetchData() invalid cursor");
            return null;
        }
        PhotoInfoRes photoInfoRes0 = (PhotoInfoRes)com.iloen.melon.responsecache.a.d(cursor0, PhotoInfoRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(photoInfoRes0 == null) {
            LogU.Companion.w("PhotoDetailViewFragment", "fetchData() failed to extract contents");
            return null;
        }
        return photoInfoRes0.response;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s2;
        Uri.Builder uri$Builder0 = MelonContentUris.e.buildUpon().appendPath("detail");
        String s = this.getPhotoUrl();
        String s1 = "";
        if(s == null) {
            s = "";
        }
        Uri.Builder uri$Builder1 = uri$Builder0.appendQueryParameter("photoUrl", s);
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 == null) {
            s2 = "";
        }
        else {
            s2 = photoDetailViewFragment$PhotoInfo0.getPhotoId();
            if(s2 == null) {
                s2 = "";
            }
        }
        Uri.Builder uri$Builder2 = uri$Builder1.appendQueryParameter("photoInfo", s2);
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList0 != null) {
            String s3 = photoDetailViewFragment$PhotoInfoList0.getCurrId();
            if(s3 != null) {
                s1 = s3;
            }
        }
        return l1.f(uri$Builder2, "photoInfoList", s1, "toString(...)");
    }

    private static void getCurrentScaleMode$annotations() {
    }

    private final String getDescription() {
        if(this.initialDescription == null) {
            PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
            if(photoDetailViewFragment$PhotoInfoList0 != null && q.b(ArtistWithPhoto.INSTANCE, photoDetailViewFragment$PhotoInfoList0.getType())) {
                if(photoDetailViewFragment$PhotoInfoList0.getDisplayArtistImage()) {
                    PhotoItem photoDetailViewFragment$PhotoItem0 = photoDetailViewFragment$PhotoInfoList0.getArtistPhotoItem();
                    return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getArtistName();
                }
                return null;
            }
        }
        return this.initialDescription;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    private final void getLikeYnFromServer(RESPONSE photoInfoRes$RESPONSE0) {
        com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
        userActionsReq$Params0.fields = "like";
        userActionsReq$Params0.contsTypeCode = "N10004";
        userActionsReq$Params0.contsId = photoInfoRes$RESPONSE0.photoid;
        RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag(this.getRequestTag()).listener(new C(this, 3)).errorListener(new C(this, 4)).request();
    }

    private static final void getLikeYnFromServer$lambda$37(PhotoDetailViewFragment photoDetailViewFragment0, Object object0) {
        if((((UserActionsRes)object0) == null ? null : ((UserActionsRes)object0).response) != null) {
            j.b(((UserActionsRes)object0).notification, false, 3);
            if(j.d(((HttpResponse)object0)) && photoDetailViewFragment0.isFragmentValid()) {
                PhotoInfo photoDetailViewFragment$PhotoInfo0 = photoDetailViewFragment0.photoInfo;
                if(photoDetailViewFragment$PhotoInfo0 != null) {
                    photoDetailViewFragment$PhotoInfo0.setLike(((UserActionsRes)object0).response.isLike());
                }
                photoDetailViewFragment0.updateLikeViewColor(((UserActionsRes)object0).response.isLike());
                photoDetailViewFragment0.updateLikeContainerContentDescription();
            }
        }
    }

    private static final void getLikeYnFromServer$lambda$38(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        LogU.Companion.e("PhotoDetailViewFragment", "getLikeYnFromServer error : " + volleyError0.getMessage());
        if(photoDetailViewFragment0.isFragmentValid()) {
            photoDetailViewFragment0.updateLikeViewColor(false);
            photoDetailViewFragment0.updateLikeContainerContentDescription();
        }
    }

    private final String getPhotoUrl() {
        if(this.initialPhotoUrl == null) {
            PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
            if(photoDetailViewFragment$PhotoInfoList0 != null && q.b(ArtistWithPhoto.INSTANCE, photoDetailViewFragment$PhotoInfoList0.getType())) {
                if(photoDetailViewFragment$PhotoInfoList0.getDisplayArtistImage()) {
                    PhotoItem photoDetailViewFragment$PhotoItem0 = photoDetailViewFragment$PhotoInfoList0.getArtistPhotoItem();
                    return photoDetailViewFragment$PhotoItem0 == null ? null : photoDetailViewFragment$PhotoItem0.getArtistImg();
                }
                return null;
            }
        }
        return this.initialPhotoUrl;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @Nullable
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.pvLogDummyAction == null || this.pvLogDummyAction.length() <= 0 ? null : new PvLogDummyReq(this.getContext(), this.pvLogDummyAction);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 == null) {
            LogU.Companion.w("PhotoDetailViewFragment", "getSharable() invalid photoInfo");
            return null;
        }
        LogU.Companion.w("PhotoDetailViewFragment", "getSharable() : " + photoDetailViewFragment$PhotoInfo0);
        Sharable sharable0 = new SharablePhoto();  // 初始化器: Ljava/lang/Object;-><init>()V
        sharable0.a = photoDetailViewFragment$PhotoInfo0.getPhotoId();
        sharable0.b = photoDetailViewFragment$PhotoInfo0.getPostImg();
        sharable0.d = photoDetailViewFragment$PhotoInfo0.getPostEditImg();
        sharable0.e = photoDetailViewFragment$PhotoInfo0.getArtistId();
        sharable0.f = photoDetailViewFragment$PhotoInfo0.getArtistName();
        return sharable0;
    }

    private final f getTiaraEventBuilder() {
        String s = null;
        if(this.mMelonTiaraProperty == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.y = this.getString(0x7F130F9B);  // string:tiara_photo_layer1_photo_detail "포토상세"
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 != null) {
            s = photoDetailViewFragment$PhotoInfo0.getPhotoId();
        }
        f0.o = s;
        f0.p = this.getString(0x7F130F9C);  // string:tiara_photo_meta_type_photo "포토"
        f0.I = this.mMelonTiaraProperty.c;
        return f0;
    }

    private final void getViewCntFromServer(RESPONSE photoInfoRes$RESPONSE0) {
        RequestBuilder.newInstance(new PhotoCountInfoReq(this.getContext(), photoInfoRes$RESPONSE0.photoid)).tag(this.getRequestTag()).listener(new C(this, 1)).errorListener(new C(this, 2)).request();
    }

    private static final void getViewCntFromServer$lambda$40(PhotoDetailViewFragment photoDetailViewFragment0, Object object0) {
        PhotoCountInfoRes photoCountInfoRes0 = (PhotoCountInfoRes)object0;
        if(object0 != null) {
            j.b(((PhotoCountInfoRes)object0).notification, false, 3);
            if(j.d(((HttpResponse)object0)) && photoDetailViewFragment0.isFragmentValid()) {
                com.iloen.melon.net.v6x.response.PhotoCountInfoRes.RESPONSE photoCountInfoRes$RESPONSE0 = ((PhotoCountInfoRes)object0).response;
                String s = null;
                String s1 = photoCountInfoRes$RESPONSE0 == null ? null : photoCountInfoRes$RESPONSE0.viewcnt;
                if(photoCountInfoRes$RESPONSE0 != null) {
                    s = photoCountInfoRes$RESPONSE0.likecnt;
                }
                photoDetailViewFragment0.setViewCountLikeCount(s1, s);
            }
        }
    }

    private static final void getViewCntFromServer$lambda$41(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        b.w("getViewCntFromServer error : ", volleyError0.getMessage(), LogU.Companion, "PhotoDetailViewFragment");
        photoDetailViewFragment0.setViewCountLikeCount("0", "0");
    }

    public static void h0(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        PhotoDetailViewFragment.onFetchStart$lambda$22(photoDetailViewFragment0, volleyError0);
    }

    public static void i0(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        PhotoDetailViewFragment.executeSearchPhotoViewReq$lambda$30(photoDetailViewFragment0, volleyError0);
    }

    private static final void infoViewGroupOnClickListener$lambda$68(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        photoDetailViewFragment0.updateInfoView();
    }

    private final void initInfoView() {
        String s = this.getPhotoUrl();
        if(s != null && s.length() != 0) {
            View view0 = this.buttonGroup;
            int v = 8;
            if(view0 != null) {
                view0.setVisibility(8);
            }
            View view1 = this.infoSeparatorView;
            if(view1 != null) {
                view1.setVisibility(8);
            }
            String s1 = this.getDescription();
            boolean z = s1 != null && s1.length() > 0;
            View view2 = this.infoViewGroup;
            if(view2 != null) {
                view2.setVisibility((z ? 0 : 8));
            }
            View view3 = this.shadowView;
            if(view3 != null) {
                if(z) {
                    v = 0;
                }
                view3.setVisibility(v);
            }
        }
    }

    private final void initPhotoDetailLayout() {
        this.initInfoView();
        this.calculateButtonGroupHeight();
        this.updateInfoViewGroupLayoutParams();
    }

    private final boolean isDisplayedArtistImage() {
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        return photoDetailViewFragment$PhotoInfoList0 == null || !q.b(photoDetailViewFragment$PhotoInfoList0.getType(), ArtistWithPhoto.INSTANCE) ? false : photoDetailViewFragment$PhotoInfoList0.getDisplayArtistImage();
    }

    private final boolean isLayoutChanged() {
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        return photoDetailViewFragment$PhotoInfoList0 == null || !q.b(photoDetailViewFragment$PhotoInfoList0.getType(), ArtistWithPhoto.INSTANCE) ? false : photoDetailViewFragment$PhotoInfoList0.getChangeViewType();
    }

    private final boolean isSimplePhotoView() {
        if(this.initialPhotoUrl != null) {
            return true;
        }
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        return photoDetailViewFragment$PhotoInfoList0 == null || !q.b(photoDetailViewFragment$PhotoInfoList0.getType(), ArtistWithPhoto.INSTANCE) ? false : photoDetailViewFragment$PhotoInfoList0.getDisplayArtistImage();
    }

    public static void k0(PhotoDetailViewFragment photoDetailViewFragment0, Object object0) {
        PhotoDetailViewFragment.getLikeYnFromServer$lambda$37(photoDetailViewFragment0, object0);
    }

    public static void l0(PhotoDetailViewFragment photoDetailViewFragment0, PhotoViewType photoDetailViewFragment$PhotoViewType0, PhotoInfoList photoDetailViewFragment$PhotoInfoList0, Object object0) {
        PhotoDetailViewFragment.onFetchStart$lambda$21(photoDetailViewFragment0, photoDetailViewFragment$PhotoViewType0, photoDetailViewFragment$PhotoInfoList0, object0);
    }

    private static final void likedOnClickListener$lambda$65(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        photoDetailViewFragment0.updateMyLike();
        f f0 = photoDetailViewFragment0.getTiaraEventBuilder();
        if(f0 == null) {
            return;
        }
        f0.a = photoDetailViewFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        f0.d = ActionKind.Like;
        f0.F = photoDetailViewFragment0.getString(0x7F130D41);  // string:tiara_click_copy_like "좋아요"
        f0.V = photoDetailViewFragment0.getString((photoDetailViewFragment0.photoInfo == null || !photoDetailViewFragment0.photoInfo.isLike() ? 0x7F130FCF : 0x7F130FCE));  // string:tiara_props_on "on"
        f0.a().track();
    }

    public static void m0(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        PhotoDetailViewFragment.getLikeYnFromServer$lambda$38(photoDetailViewFragment0, volleyError0);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0) {
        return PhotoDetailViewFragment.Companion.newInstance(photoDetailViewFragment$PhotoInfoList0);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0, boolean z) {
        return PhotoDetailViewFragment.Companion.newInstance(photoDetailViewFragment$PhotoInfoList0, z);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@NotNull PhotoInfoList photoDetailViewFragment$PhotoInfoList0, boolean z, boolean z1) {
        return PhotoDetailViewFragment.Companion.newInstance(photoDetailViewFragment$PhotoInfoList0, z, z1);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@NotNull String s) {
        return PhotoDetailViewFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1) {
        return PhotoDetailViewFragment.Companion.newInstance(s, s1);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        return PhotoDetailViewFragment.Companion.newInstance(s, s1, s2);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        return PhotoDetailViewFragment.Companion.newInstance(s, s1, s2, s3);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z) {
        return PhotoDetailViewFragment.Companion.newInstance(s, s1, s2, s3, z);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, boolean z, boolean z1) {
        return PhotoDetailViewFragment.Companion.newInstance(s, s1, s2, s3, z, z1);
    }

    @NotNull
    public static final PhotoDetailViewFragment newInstance(@NotNull String s, boolean z) {
        return PhotoDetailViewFragment.Companion.newInstance(s, z);
    }

    public static void o0(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        PhotoDetailViewFragment.getViewCntFromServer$lambda$41(photoDetailViewFragment0, volleyError0);
    }

    private static final void onClickListener$lambda$69(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        photoDetailViewFragment0.setInfoViewVisibility(photoDetailViewFragment0.infoViewGroup != null && photoDetailViewFragment0.infoViewGroup.getVisibility() == 8);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.setInfoViewGroupHeight();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        LogU.Companion.d("PhotoDetailViewFragment", "onCreate()");
        super.onCreate(bundle0);
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
        return layoutInflater0.inflate(0x7F0D0590, viewGroup0, false);  // layout:photo_detailview
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onDirectOpenFragment() {
        this.openCmtPage();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("PhotoDetailViewFragment", "onFetchStart reason:" + s);
        this.setErrorViewVisibility(false);
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList0 != null && this.isDisplayedArtistImage() && photoDetailViewFragment$PhotoInfoList0.getPhotoTotalCount() > 0) {
            com.iloen.melon.utils.animation.AnimationUtils.setFadeInAndOutAnimation(this.btnSwipeNext);
        }
        if(this.isLayoutChanged()) {
            this.initPhotoDetailLayout();
        }
        l1.B("isSimplePhotoView:", this.isSimplePhotoView(), logU$Companion0, "PhotoDetailViewFragment");
        boolean z = true;
        if(this.isSimplePhotoView()) {
            this.calculateButtonGroupHeight();
            this.setInfoView(this.getPhotoUrl(), this.getDescription());
            S s1 = this.shareButton;
            if(s1 != null) {
                String s2 = this.getPhotoUrl();
                if(s2 != null && s2.length() != 0) {
                    z = false;
                }
                else {
                    String s3 = this.getDescription();
                    if(s3 == null || s3.length() <= 0) {
                        z = false;
                    }
                }
                ImageView imageView0 = s1.g;
                if(imageView0 != null) {
                    ViewUtils.showWhen(imageView0, z);
                    this.setArtistInfo(null, null, null);
                    return false;
                }
                q.m("view");
                throw null;
            }
            this.setArtistInfo(null, null, null);
            return false;
        }
        PhotoInfoList photoDetailViewFragment$PhotoInfoList1 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList1 == null) {
            return false;
        }
        PhotoViewType photoDetailViewFragment$PhotoViewType0 = photoDetailViewFragment$PhotoInfoList1.getType();
        String s4 = photoDetailViewFragment$PhotoInfoList1.getCurrentArtistId();
        PhotoInfoReq photoInfoReq0 = q.b(Etc.INSTANCE, photoDetailViewFragment$PhotoViewType0) ? new PhotoInfoReq(this.getContext(), photoDetailViewFragment$PhotoInfoList1.getCurrId(), s4, 1) : new PhotoInfoReq(this.getContext(), photoDetailViewFragment$PhotoInfoList1.getCurrId(), s4, -1);
        Context context0 = this.getContext();
        if(com.iloen.melon.responsecache.a.e(300000L, this.getCacheKey(), context0)) {
            logU$Companion0.d("PhotoDetailViewFragment", "call network process...");
            RequestBuilder.newInstance(photoInfoReq0).tag(this.getRequestTag()).listener(new B(this, photoDetailViewFragment$PhotoViewType0, photoDetailViewFragment$PhotoInfoList1, 0)).errorListener(new C(this, 0)).request();
            return true;
        }
        logU$Companion0.d("PhotoDetailViewFragment", "not call network process...");
        this.updateUi(this.fetchData());
        return false;
    }

    private static final void onFetchStart$lambda$21(PhotoDetailViewFragment photoDetailViewFragment0, PhotoViewType photoDetailViewFragment$PhotoViewType0, PhotoInfoList photoDetailViewFragment$PhotoInfoList0, Object object0) {
        if((((PhotoInfoRes)object0) == null ? null : ((PhotoInfoRes)object0).response) != null) {
            j.b(((PhotoInfoRes)object0).notification, false, 3);
            if(j.d(((HttpResponse)object0)) && photoDetailViewFragment0.isFragmentValid()) {
                photoDetailViewFragment0.performLogging(((HttpResponse)object0));
                if(q.b(Search.INSTANCE, photoDetailViewFragment$PhotoViewType0)) {
                    RESPONSE photoInfoRes$RESPONSE0 = ((PhotoInfoRes)object0).response;
                    q.f(photoInfoRes$RESPONSE0, "response");
                    photoDetailViewFragment0.executeSearchPhotoViewReq(photoInfoRes$RESPONSE0);
                    return;
                }
                if(q.b(Etc.INSTANCE, photoDetailViewFragment$PhotoViewType0)) {
                    RESPONSE photoInfoRes$RESPONSE1 = ((PhotoInfoRes)object0).response;
                    q.f(photoInfoRes$RESPONSE1, "response");
                    photoDetailViewFragment$PhotoInfoList0.setPhotoInformResponse(photoInfoRes$RESPONSE1);
                }
                else if(photoDetailViewFragment$PhotoInfoList0.needLoadMore()) {
                    if(q.b(photoDetailViewFragment$PhotoViewType0, ArtistInfo.INSTANCE) || q.b(photoDetailViewFragment$PhotoViewType0, ArtistWithPhoto.INSTANCE)) {
                        photoDetailViewFragment0.executeArtistContentsPhotoListReq();
                    }
                    else if(q.b(photoDetailViewFragment$PhotoViewType0, AlbumInfo.INSTANCE)) {
                        photoDetailViewFragment0.executeAlbumContentsPhotoListReq();
                    }
                }
                photoDetailViewFragment0.updateUi(((PhotoInfoRes)object0).response);
                photoDetailViewFragment0.mMelonTiaraProperty = new s(((PhotoInfoRes)object0).response.section, ((PhotoInfoRes)object0).response.page, ((PhotoInfoRes)object0).getMenuId(), null);
                photoDetailViewFragment0.performFetchCompleteOnlyViews();
                return;
            }
        }
        photoDetailViewFragment0.setErrorViewVisibility(true);
    }

    private static final void onFetchStart$lambda$22(PhotoDetailViewFragment photoDetailViewFragment0, VolleyError volleyError0) {
        photoDetailViewFragment0.setErrorViewVisibility(true);
        photoDetailViewFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
        if(bundle0.containsKey("argPhotoInfoList")) {
            this.photoInfoList = (PhotoInfoList)CompatUtils.getSerializable(bundle0, "argPhotoInfoList", PhotoInfoList.class);
        }
        if(bundle0.containsKey("argPhotoInfo")) {
            this.photoInfo = (PhotoInfo)CompatUtils.getSerializable(bundle0, "argPhotoInfo", PhotoInfo.class);
        }
        if(bundle0.containsKey("argPhotoUrl")) {
            this.initialPhotoUrl = bundle0.getString("argPhotoUrl");
        }
        if(bundle0.containsKey("argDescription")) {
            this.initialDescription = bundle0.getString("argDescription");
        }
        if(bundle0.containsKey("argPhotoTitle")) {
            this.photoTitle = bundle0.getString("argPhotoTitle");
        }
        if(bundle0.containsKey("argAccessibilityDescription")) {
            this.photoAccessibilityDesc = bundle0.getString("argAccessibilityDescription");
        }
        if(bundle0.containsKey("argPvLogDummyAction")) {
            this.pvLogDummyAction = bundle0.getString("argPvLogDummyAction");
        }
        if(bundle0.containsKey("argIsActivityView")) {
            this.isActivityView = bundle0.getBoolean("argIsActivityView");
        }
        this.currentScaleMode = bundle0.getInt("argKeyScale", 1);
        if(this.photoInfo == null) {
            PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
            if(photoDetailViewFragment$PhotoInfoList0 != null) {
                this.photoInfo = new PhotoInfo(photoDetailViewFragment$PhotoInfoList0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argKeyScale", this.currentScaleMode);
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(photoDetailViewFragment$PhotoInfoList0 != null) {
            bundle0.putSerializable("argPhotoInfoList", photoDetailViewFragment$PhotoInfoList0);
        }
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 != null) {
            bundle0.putSerializable("argPhotoInfo", photoDetailViewFragment$PhotoInfo0);
        }
        if(this.initialPhotoUrl != null && this.initialPhotoUrl.length() > 0) {
            bundle0.putString("argPhotoUrl", this.initialPhotoUrl);
        }
        if(this.initialDescription != null && this.initialDescription.length() > 0) {
            bundle0.putString("argDescription", this.initialDescription);
        }
        if(this.photoTitle != null && this.photoTitle.length() > 0) {
            bundle0.putString("argPhotoTitle", this.photoTitle);
        }
        if(this.photoAccessibilityDesc != null && this.photoAccessibilityDesc.length() > 0) {
            bundle0.putString("argAccessibilityDescription", this.photoAccessibilityDesc);
        }
        if(this.pvLogDummyAction != null && this.pvLogDummyAction.length() > 0) {
            bundle0.putString("argPvLogDummyAction", this.pvLogDummyAction);
        }
        bundle0.putBoolean("argIsActivityView", this.isActivityView);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setBackgroundColor(0);
            F8.p p0 = new F8.p(0);
            p0.c = new y(this, 5);
            S s0 = new S();  // 初始化器: Ljava/lang/Object;-><init>()V
            s0.c = this.sharedOnClickListener;
            p0.g(new m(0, false));
            p0.g(s0);
            titleBar0.a(p0);
            ImageView imageView0 = s0.g;
            if(imageView0 != null) {
                ViewUtils.showWhen(imageView0, false);
                this.shareButton = s0;
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = titleBar0.getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.getStatusBarHeight(this.getContext());
                titleBar0.setTitle(this.photoTitle);
                titleBar0.requestLayout();
                goto label_24;
            }
            q.m("view");
            throw null;
        }
    label_24:
        this.currentScaleMode = 1;
        View view1 = this.findViewById(0x7F0A03BB);  // id:detail_image
        q.e(view1, "null cannot be cast to non-null type com.github.chrisbanes.PhotoView");
        ((PhotoView)view1).setOnClickListener(this.onClickListener);
        ((PhotoView)view1).setOnSwipeListener(this.onSwipeListener);
        this.detailImageView = (PhotoView)view1;
        View view2 = this.findViewById(0x7F0A0696);  // id:iv_swipe_next
        q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
        this.btnSwipeNext = (ImageView)view2;
        View view3 = this.findViewById(0x7F0A0A7E);  // id:shadow_info_view
        q.d(view3);
        view3.setVisibility(8);
        this.shadowView = view3;
        View view4 = this.findViewById(0x7F0A0575);  // id:info
        q.d(view4);
        view4.setVisibility(8);
        this.infoViewGroup = view4;
        View view5 = this.findViewById(0x7F0A057A);  // id:info_separator
        q.d(view5);
        view5.setVisibility(8);
        this.infoSeparatorView = view5;
        View view6 = this.findViewById(0x7F0A0B55);  // id:text_desc
        q.e(view6, "null cannot be cast to non-null type android.widget.TextView");
        this.textDescView = (TextView)view6;
        View view7 = this.findViewById(0x7F0A017A);  // id:btn_more
        q.e(view7, "null cannot be cast to non-null type android.widget.TextView");
        this.btnMoreView = (TextView)view7;
        View view8 = this.findViewById(0x7F0A02CF);  // id:cmt_container
        view8.setOnClickListener(this.reviewedOnClickListener);
        this.cmtContainer = view8;
        View view9 = this.findViewById(0x7F0A02D0);  // id:cmt_count
        q.e(view9, "null cannot be cast to non-null type android.widget.TextView");
        this.cmtCount = (TextView)view9;
        View view10 = this.findViewById(0x7F0A0767);  // id:like_icon
        q.e(view10, "null cannot be cast to non-null type android.widget.ImageView");
        this.likeYnView = (ImageView)view10;
        View view11 = this.findViewById(0x7F0A0765);  // id:like_count
        q.e(view11, "null cannot be cast to non-null type android.widget.TextView");
        this.likeCount = (TextView)view11;
        View view12 = this.findViewById(0x7F0A0764);  // id:like_container
        view12.setOnClickListener(this.likedOnClickListener);
        this.likeContainer = view12;
        this.artistContainer = this.findViewById(0x7F0A00B3);  // id:artist_container
        View view13 = this.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        q.e(view13, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivThumbCircleDefault = (ImageView)view13;
        ViewUtils.setDefaultImage(((ImageView)view13), PhotoDetailViewFragment.thumbCircleDiameter, true);
        View view14 = this.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        q.e(view14, "null cannot be cast to non-null type com.iloen.melon.custom.BorderImageView");
        ((BorderImageView)view14).setBorderColor(ColorUtils.getColor(((BorderImageView)view14).getContext(), 0x7F06014A));  // color:gray100a
        ((BorderImageView)view14).setBorderWidth(ScreenUtils.dipToPixel(((BorderImageView)view14).getContext(), 0.5f));
        this.ivThumbCircle = (BorderImageView)view14;
        View view15 = this.findViewById(0x7F0A0C13);  // id:tv_artist_channel
        q.e(view15, "null cannot be cast to non-null type android.widget.TextView");
        this.textArtistChannel = (TextView)view15;
        View view16 = this.findViewById(0x7F0A0DC2);  // id:view_count
        q.e(view16, "null cannot be cast to non-null type android.widget.TextView");
        this.viewCount = (TextView)view16;
        View view17 = this.findViewById(0x7F0A01E3);  // id:button_container
        q.d(view17);
        view17.setVisibility(8);
        this.buttonGroup = view17;
        this.errorView = this.findViewById(0x7F0A044A);  // id:error_layout
        this.initPhotoDetailLayout();
    }

    private static final void onViewCreated$lambda$9$lambda$7$lambda$6(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        photoDetailViewFragment0.performBackPress();
    }

    private final void openCmtPage() {
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 == null) {
            LogU.Companion.w("PhotoDetailViewFragment", "openCmtPage() invalid photoInfo");
            return;
        }
        String s = photoDetailViewFragment$PhotoInfo0.getPhotoId();
        int v = photoDetailViewFragment$PhotoInfo0.getBbsChannelSeq();
        if(s != null && s.length() > 0 && v > 0) {
            Param cmtListFragment$Param0 = new Param();
            cmtListFragment$Param0.chnlSeq = v;
            cmtListFragment$Param0.contsRefValue = s;
            cmtListFragment$Param0.showTitle = true;
            cmtListFragment$Param0.headerTitle = this.getString(0x7F130212);  // string:comments "댓글"
            cmtListFragment$Param0.cacheKeyOfTargetPage = this.getCacheKey();
            Navigator.INSTANCE.openCommentRenewalVersion(cmtListFragment$Param0);
        }
    }

    public static void q0(PhotoDetailViewFragment photoDetailViewFragment0, Object object0) {
        PhotoDetailViewFragment.getViewCntFromServer$lambda$40(photoDetailViewFragment0, object0);
    }

    private static final void reviewedOnClickListener$lambda$66(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        photoDetailViewFragment0.openCmtPage();
        f f0 = photoDetailViewFragment0.getTiaraEventBuilder();
        if(f0 == null) {
            return;
        }
        f0.a = photoDetailViewFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.F = photoDetailViewFragment0.getString(0x7F130F99);  // string:tiara_photo_copy_comment_move "댓글이동"
        f0.a().track();
    }

    public static void s0(VolleyError volleyError0) {
        PhotoDetailViewFragment.executeArtistContentsPhotoListReq$lambda$27(volleyError0);
    }

    private final void setArtistInfo(String s, String s1, String s2) {
        if(StringIds.a(s, StringIds.e)) {
            TextView textView0 = this.textArtistChannel;
            if(textView0 != null) {
                textView0.setText(s1);
            }
            Context context0 = this.getContext();
            if(context0 != null) {
                BorderImageView borderImageView0 = this.ivThumbCircle;
                if(borderImageView0 != null) {
                    Glide.with(context0).load(s2).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                }
                ViewUtils.setContentDescriptionWithButtonClassName(this.artistContainer, s1 + ", " + this.getString(0x7F130B3A));  // string:talkback_go_to_artist_channel_button "아티스트 채널 가기"
                View view0 = this.artistContainer;
                if(view0 != null) {
                    view0.setVisibility(0);
                }
                View view1 = this.artistContainer;
                if(view1 != null) {
                    view1.setOnClickListener(new y(this, 0));
                }
                View view2 = this.artistContainer;
                if(view2 != null) {
                    view2.setVisibility(0);
                }
            }
        }
        else {
            View view3 = this.artistContainer;
            if(view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    private static final void setArtistInfo$lambda$44(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        ArtistInfoBase artistInfoBase0;
        Integer integer0;
        if(photoDetailViewFragment0.isActivityView) {
            FragmentActivity fragmentActivity0 = photoDetailViewFragment0.getActivity();
            if(fragmentActivity0 != null) {
                fragmentActivity0.finish();
            }
        }
        String s = null;
        photoDetailViewFragment0.showMultiArtistPopup((photoDetailViewFragment0.photoInfoRes == null ? null : photoDetailViewFragment0.photoInfoRes.artistlist), null, true, null);
        f f0 = photoDetailViewFragment0.getTiaraEventBuilder();
        if(f0 == null) {
            return;
        }
        RESPONSE photoInfoRes$RESPONSE0 = photoDetailViewFragment0.photoInfoRes;
        if(photoInfoRes$RESPONSE0 == null) {
            integer0 = null;
        }
        else {
            ArrayList arrayList0 = photoInfoRes$RESPONSE0.artistlist;
            integer0 = arrayList0 == null ? null : arrayList0.size();
        }
        if(integer0 != null && ((int)integer0) > 1) {
            f0.a = photoDetailViewFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.d = ActionKind.ClickContent;
            f0.F = photoDetailViewFragment0.getString(0x7F130F98);  // string:tiara_photo_copy_channel_select "채널선택"
            f0.a().track();
            return;
        }
        RESPONSE photoInfoRes$RESPONSE1 = photoDetailViewFragment0.photoInfoRes;
        if(photoInfoRes$RESPONSE1 == null) {
            artistInfoBase0 = null;
        }
        else {
            ArrayList arrayList1 = photoInfoRes$RESPONSE1.artistlist;
            artistInfoBase0 = arrayList1 == null ? null : ((ArtistInfoBase)p.n0(0, arrayList1));
        }
        f0.a = photoDetailViewFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.e = artistInfoBase0 == null ? null : artistInfoBase0.getArtistId();
        f0.f = Y.i(ContsTypeCode.ARTIST, "code(...)");
        if(artistInfoBase0 != null) {
            s = artistInfoBase0.getArtistName();
        }
        f0.g = s;
        f0.a().track();
    }

    private final void setErrorViewVisibility(boolean z) {
        if(this.isFragmentValid()) {
            View view0 = this.errorView;
            if(view0 != null) {
                view0.setVisibility((z ? 0 : 8));
            }
        }
    }

    private final void setInfoDescriptionText(String s) {
        this.descWithNewline = s;
        this.descWithoutNewline = v.p0(s, "\n", " ");
        TextView textView0 = this.textDescView;
        if(textView0 != null) {
            textView0.setVisibility(4);
            new Handler(Looper.getMainLooper()).post(() -> PhotoDetailViewFragment.setInfoDescriptionText$lambda$56$lambda$55(textView0, s, this));
        }
    }

    private static final void setInfoDescriptionText$lambda$56$lambda$55(TextView textView0, String s, PhotoDetailViewFragment photoDetailViewFragment0) {
        textView0.setText(s);
        int v = 0x7FFFFFFF;
        TextUtils.TruncateAt textUtils$TruncateAt0 = null;
        if(textView0.getLineCount() > 2 || ViewUtils.isTextViewEllipsis(textView0)) {
            textView0.setOnClickListener(photoDetailViewFragment0.infoViewGroupOnClickListener);
            if(photoDetailViewFragment0.currentScaleMode != 0) {
                textUtils$TruncateAt0 = TextUtils.TruncateAt.END;
            }
            textView0.setEllipsize(textUtils$TruncateAt0);
            if(photoDetailViewFragment0.currentScaleMode != 0) {
                v = 2;
            }
            textView0.setMaxLines(v);
            String s2 = photoDetailViewFragment0.descWithNewline;
            if(s2 != null) {
                String s3 = photoDetailViewFragment0.descWithoutNewline;
                if(s3 != null) {
                    if(photoDetailViewFragment0.currentScaleMode != 0) {
                        s2 = s3;
                    }
                    textView0.setText(s2);
                }
            }
            photoDetailViewFragment0.updateBtnMoreView();
            TextView textView2 = photoDetailViewFragment0.btnMoreView;
            if(textView2 != null) {
                textView2.setOnClickListener(photoDetailViewFragment0.infoViewGroupOnClickListener);
            }
        }
        else {
            View view0 = photoDetailViewFragment0.infoViewGroup;
            if(view0 != null) {
                view0.setOnClickListener(null);
                view0.setClickable(false);
            }
            textView0.setOnClickListener(null);
            textView0.setClickable(false);
            textView0.setEllipsize(null);
            textView0.setMaxLines(0x7FFFFFFF);
            String s1 = photoDetailViewFragment0.descWithNewline;
            if(s1 != null && photoDetailViewFragment0.descWithoutNewline != null) {
                textView0.setText(s1);
            }
            TextView textView1 = photoDetailViewFragment0.btnMoreView;
            if(textView1 != null) {
                textView1.setVisibility(8);
                textView1.setOnClickListener(null);
            }
        }
        textView0.setVisibility(0);
    }

    private final void setInfoView(String s, String s1) {
        PhotoView photoView0 = this.detailImageView;
        if(photoView0 != null) {
            Context context0 = this.getContext();
            if(context0 != null) {
                String s2 = this.photoAccessibilityDesc;
                if(s2 != null) {
                    photoView0.setContentDescription(s2);
                }
                if(s == null || !v.r0(s, "template://", false)) {
                    Glide.with(context0).load(s).listener(new RequestListener() {
                        public static void a(Drawable drawable0, PhotoDetailViewFragment photoDetailViewFragment0) {
                            com.iloen.melon.fragments.detail.PhotoDetailViewFragment.setInfoView.1.2.onResourceReady$lambda$0(drawable0, photoDetailViewFragment0);
                        }

                        @Override  // com.bumptech.glide.request.RequestListener
                        public boolean onLoadFailed(GlideException glideException0, Object object0, Target target0, boolean z) {
                            q.g(target0, "target");
                            PhotoDetailViewFragment.this.setErrorViewVisibility(false);
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable0, Object object0, Target target0, DataSource dataSource0, boolean z) {
                            q.g(drawable0, "resource");
                            q.g(object0, "model");
                            q.g(dataSource0, "dataSource");
                            FragmentActivity fragmentActivity0 = PhotoDetailViewFragment.this.getActivity();
                            if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                                fragmentActivity0.runOnUiThread(new H(1, drawable0, PhotoDetailViewFragment.this));
                                return false;
                            }
                            LogU.Companion.e("PhotoDetailViewFragment", "onResourceReady() Activity Object is vaild!");
                            return false;
                        }

                        @Override  // com.bumptech.glide.request.RequestListener
                        public boolean onResourceReady(Object object0, Object object1, Target target0, DataSource dataSource0, boolean z) {
                            return this.onResourceReady(((Drawable)object0), object1, target0, dataSource0, z);
                        }

                        private static final void onResourceReady$lambda$0(Drawable drawable0, PhotoDetailViewFragment photoDetailViewFragment0) {
                            if(drawable0 == null) {
                                photoDetailViewFragment0.setErrorViewVisibility(true);
                                return;
                            }
                            photoDetailViewFragment0.setErrorViewVisibility(false);
                        }
                    }).into(photoView0);
                }
                else {
                    Bitmap bitmap0 = TemplateImageCacheManager.getBitmapFromMemCache(s);
                    if(bitmap0 != null) {
                        photoView0.setImageBitmap(bitmap0);
                    }
                }
            }
        }
        if(s1 != null && s1.length() > 0) {
            this.currentScaleMode = 1;
            this.setInfoViewVisibility(true);
            this.setInfoDescriptionText(s1);
        }
    }

    private final void setInfoViewGroupHeight() {
        View view0 = this.infoSeparatorView;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            viewGroup$LayoutParams0.height = this.photoButtonHeight;
            view0.requestLayout();
        }
    }

    private final void setInfoViewVisibility(boolean z) {
        if(this.infoViewGroup != null && this.getContext() != null) {
            if(z) {
                String s = this.getPhotoUrl();
                boolean z1 = s == null || s.length() == 0;
                if(z1) {
                label_7:
                    View view0 = this.infoViewGroup;
                    if(view0 != null && view0.getVisibility() == 8) {
                        this.fadeInAndShow(view0);
                        View view1 = this.shadowView;
                        if(view1 != null) {
                            this.fadeInAndShow(view1);
                        }
                    }
                }
                else {
                    String s1 = this.getDescription();
                    if(s1 != null && s1.length() > 0) {
                        goto label_7;
                    }
                }
                if(z1) {
                    View view2 = this.buttonGroup;
                    if(view2 != null && view2.getVisibility() == 8) {
                        this.fadeInAndShow(view2);
                    }
                }
            }
            else {
                View view3 = this.infoViewGroup;
                if(view3 != null && view3.getVisibility() == 0) {
                    this.fadeOutAndHide(view3);
                    View view4 = this.shadowView;
                    if(view4 != null) {
                        this.fadeOutAndHide(view4);
                    }
                }
                View view5 = this.buttonGroup;
                if(view5 != null && view5.getVisibility() == 0) {
                    this.fadeOutAndHide(view5);
                }
            }
        }
    }

    private final void setViewCountLikeCount(String s, String s1) {
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 != null) {
            photoDetailViewFragment$PhotoInfo0.setViewCnt(ProtocolUtils.parseInt(s, 0));
        }
        this.updateViewCntView(s);
        PhotoInfo photoDetailViewFragment$PhotoInfo1 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo1 != null) {
            photoDetailViewFragment$PhotoInfo1.setLikeCnt(ProtocolUtils.parseInt(s1, 0));
        }
        this.updateLikeCntView(s1);
        this.updateLikeContainerContentDescription();
    }

    private static final void sharedOnClickListener$lambda$67(PhotoDetailViewFragment photoDetailViewFragment0, View view0) {
        photoDetailViewFragment0.showSNSListPopup(view0, photoDetailViewFragment0.getSNSSharable());
        f f0 = photoDetailViewFragment0.getTiaraEventBuilder();
        if(f0 == null) {
            return;
        }
        f0.a = photoDetailViewFragment0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
        f0.d = ActionKind.Share;
        f0.F = photoDetailViewFragment0.getString(0x7F130F9A);  // string:tiara_photo_copy_share "공유"
        f0.a().track();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void slidePhotoView(boolean z) {
        Boolean boolean1;
        Boolean boolean0 = null;
        PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
        if(!z) {
            boolean1 = photoDetailViewFragment$PhotoInfoList0 == null ? null : Boolean.valueOf(photoDetailViewFragment$PhotoInfoList0.movePrevious());
        }
        else if(photoDetailViewFragment$PhotoInfoList0 != null) {
            boolean1 = Boolean.valueOf(photoDetailViewFragment$PhotoInfoList0.moveNext());
        }
        else {
            boolean1 = null;
        }
        PhotoInfoList photoDetailViewFragment$PhotoInfoList1 = this.photoInfoList;
        if(!z) {
            if(photoDetailViewFragment$PhotoInfoList1 != null) {
                boolean0 = Boolean.valueOf(photoDetailViewFragment$PhotoInfoList1.getHasMorePrevOutOfRange());
            }
        }
        else if(photoDetailViewFragment$PhotoInfoList1 != null) {
            boolean0 = Boolean.valueOf(photoDetailViewFragment$PhotoInfoList1.getHasMoreNextOutOfRange());
        }
        if(!q.b(boolean1, Boolean.TRUE) && !q.b(boolean0, Boolean.TRUE)) {
            LogU.Companion.v("PhotoDetailViewFragment", "slidePhotoView() There are no more");
            return;
        }
        View view0 = this.errorView == null || this.errorView.getVisibility() != 0 ? this.detailImageView : this.errorView;
        if(view0 == null) {
            return;
        }
        int v = view0.getWidth();
        if(z) {
            v = -v;
        }
        TranslateAnimation translateAnimation0 = new TranslateAnimation(0.0f, ((float)v), 0.0f, 0.0f);
        translateAnimation0.setDuration(300L);
        translateAnimation0.setFillAfter(true);
        translateAnimation0.setAnimationListener(this.photoViewAnimationListener);
        view0.startAnimation(translateAnimation0);
    }

    private final void updateBtnMoreView() {
        int v = 0;
        TextView textView0 = this.btnMoreView;
        if(textView0 != null) {
            if(this.currentScaleMode == 0) {
                v = 8;
            }
            textView0.setVisibility(v);
        }
    }

    private final void updateInfoView() {
        this.currentScaleMode = this.currentScaleMode == 0 ? 1 : 0;
        this.updateBtnMoreView();
        this.updateInfoViewGroupLayoutParams();
    }

    private final void updateInfoViewGroupLayoutParams() {
        if(this.currentScaleMode == 0) {
            View view0 = this.infoSeparatorView;
            if(view0 != null) {
                view0.setVisibility(0);
            }
            TextView textView0 = this.textDescView;
            if(textView0 != null) {
                textView0.setEllipsize(null);
                textView0.setMaxLines(0x7FFFFFFF);
            }
            String s = this.descWithNewline;
            if(s != null && this.descWithoutNewline != null) {
                TextView textView1 = this.textDescView;
                if(textView1 != null) {
                    textView1.setText(s);
                }
            }
        }
        else {
            View view1 = this.infoSeparatorView;
            if(view1 != null) {
                view1.setVisibility(0);
            }
            TextView textView2 = this.textDescView;
            if(textView2 != null) {
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setMaxLines(2);
            }
            if(this.descWithNewline != null) {
                String s1 = this.descWithoutNewline;
                if(s1 != null) {
                    TextView textView3 = this.textDescView;
                    if(textView3 != null) {
                        textView3.setText(s1);
                    }
                }
            }
        }
    }

    private final void updateLikeCntView(String s) {
        TextView textView0 = this.likeCount;
        if(textView0 != null) {
            textView0.setText(StringUtils.getCountString(s, 0x1869F));
        }
    }

    private final void updateLikeContainerContentDescription() {
        int v = this.photoInfo == null || !this.photoInfo.isLike() ? 0x7F130B61 : 0x7F130B5E;  // string:talkback_like_on_with_cnt "좋아요, %1$s명, 좋아요 선택하기"
        Context context0 = this.getContext();
        if(context0 != null) {
            ViewUtils.setContentDescriptionWithButtonClassName(this.likeContainer, context0.getString(v, new Object[]{(this.likeCount == null ? null : this.likeCount.getText())}));
        }
    }

    private final void updateLikeViewColor(boolean z) {
        ImageView imageView0 = this.likeYnView;
        if(imageView0 != null) {
            imageView0.setImageResource((z ? 0x7F08014B : 0x7F080149));  // drawable:btn_common_like_22_on
        }
    }

    private final void updateMyLike() {
        PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
        if(photoDetailViewFragment$PhotoInfo0 == null) {
            LogU.Companion.w("PhotoDetailViewFragment", "updateMyLike() invalid photoInfo");
            return;
        }
        this.updateLike(photoDetailViewFragment$PhotoInfo0.getPhotoId(), "N10004", !photoDetailViewFragment$PhotoInfo0.isLike(), photoDetailViewFragment$PhotoInfo0.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                if(!photoDetailViewFragment$PhotoInfo0.isFragmentValid() || s.length() > 0) {
                    return;
                }
                this.$photoInfo.setLike(z);
                this.$photoInfo.setLikeCnt(v);
                photoDetailViewFragment$PhotoInfo0.updateLikeViewColor(this.$photoInfo.isLike());
                photoDetailViewFragment$PhotoInfo0.updateLikeCntView(String.valueOf(this.$photoInfo.getLikeCnt()));
                photoDetailViewFragment$PhotoInfo0.updateLikeContainerContentDescription();
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
            }
        });
    }

    private final void updatePhotoIndex() {
    }

    private final void updateUi(RESPONSE photoInfoRes$RESPONSE0) {
        boolean z;
        String s5;
        String s3;
        String s1;
        if(photoInfoRes$RESPONSE0 != null) {
            this.getLikeYnFromServer(photoInfoRes$RESPONSE0);
            this.getViewCntFromServer(photoInfoRes$RESPONSE0);
            CharSequence charSequence0 = null;
            String s = this.photoInfoList == null ? null : this.photoInfoList.getCurrentArtistId();
            if(s == null || s.length() == 0) {
                s1 = ProtocolUtils.getFirstArtistId(photoInfoRes$RESPONSE0.artistlist);
            }
            else {
                PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = this.photoInfoList;
                s1 = photoDetailViewFragment$PhotoInfoList0 == null ? null : photoDetailViewFragment$PhotoInfoList0.getCurrentArtistId();
            }
            String s2 = this.photoInfoList == null ? null : this.photoInfoList.getCurrentArtistName();
            if(s2 == null || s2.length() == 0) {
                s3 = ProtocolUtils.findArtistName(photoInfoRes$RESPONSE0.artistlist, s1);
            }
            else {
                PhotoInfoList photoDetailViewFragment$PhotoInfoList1 = this.photoInfoList;
                s3 = photoDetailViewFragment$PhotoInfoList1 == null ? null : photoDetailViewFragment$PhotoInfoList1.getCurrentArtistName();
            }
            String s4 = this.photoInfoList == null ? null : this.photoInfoList.getCurrentArtistImg();
            if(s4 == null || s4.length() == 0) {
                s5 = ProtocolUtils.findArtistImg(photoInfoRes$RESPONSE0.artistlist, s1);
            }
            else {
                PhotoInfoList photoDetailViewFragment$PhotoInfoList2 = this.photoInfoList;
                s5 = photoDetailViewFragment$PhotoInfoList2 == null ? null : photoDetailViewFragment$PhotoInfoList2.getCurrentArtistImg();
            }
            PhotoInfo photoDetailViewFragment$PhotoInfo0 = this.photoInfo;
            if(photoDetailViewFragment$PhotoInfo0 != null) {
                photoDetailViewFragment$PhotoInfo0.setResponse(photoInfoRes$RESPONSE0, s1, s3, s5);
                this.photoInfoRes = photoInfoRes$RESPONSE0;
            }
            PhotoInfo photoDetailViewFragment$PhotoInfo1 = this.photoInfo;
            if(photoDetailViewFragment$PhotoInfo1 != null) {
                String s6 = photoDetailViewFragment$PhotoInfo1.getPhotoId();
                if(s6 != null && s6.length() > 0) {
                    this.setInfoView(photoDetailViewFragment$PhotoInfo1.getPhotoImg(), photoDetailViewFragment$PhotoInfo1.getPhotoDesc());
                    S s7 = this.shareButton;
                    if(s7 != null) {
                        String s8 = this.getPhotoUrl();
                        if(s8 != null && s8.length() != 0) {
                            z = false;
                        }
                        else {
                            String s9 = photoDetailViewFragment$PhotoInfo1.getPhotoDesc();
                            z = s9 == null || s9.length() <= 0 ? false : true;
                        }
                        ImageView imageView0 = s7.g;
                        if(imageView0 != null) {
                            ViewUtils.showWhen(imageView0, z);
                            goto label_57;
                        }
                        q.m("view");
                        throw null;
                    }
                label_57:
                    this.setArtistInfo(photoDetailViewFragment$PhotoInfo1.getArtistId(), photoDetailViewFragment$PhotoInfo1.getArtistName(), photoDetailViewFragment$PhotoInfo1.getArtistImg());
                    TextView textView0 = this.cmtCount;
                    if(textView0 != null) {
                        textView0.setText(StringUtils.getCountString(String.valueOf(photoDetailViewFragment$PhotoInfo1.getCmtCnt()), 0x1869F));
                    }
                    View view0 = this.cmtContainer;
                    TextView textView1 = this.cmtCount;
                    if(textView1 != null) {
                        charSequence0 = textView1.getText();
                    }
                    ViewUtils.setContentDescriptionWithButtonClassName(view0, this.getString(0x7F130AEA, new Object[]{charSequence0}));  // string:talkback_cmt_count "댓글 %1$s개"
                    this.calculateButtonGroupHeight();
                }
            }
        }
    }

    private final void updateViewCntView(String s) {
        TextView textView0 = this.viewCount;
        if(textView0 != null) {
            textView0.setText(StringUtils.getCountString(s, -1));
            textView0.setContentDescription(this.getString(0x7F130C83, new Object[]{textView0.getText()}));  // string:talkback_views "조회수 : %1$s"
        }
    }

    // 检测为 Lambda 实现
    public static void v0(TextView textView0, String s, PhotoDetailViewFragment photoDetailViewFragment0) [...]
}

