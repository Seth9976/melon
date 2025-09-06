package com.kakaoent.leonplayer.core;

import E9.b;
import E9.c;
import E9.d;
import E9.e;
import E9.f;
import E9.n;
import E9.r;
import E9.s;
import Tf.v;
import U4.x;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.media3.session.legacy.C;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.inisoft.media.MediaPlayer.TrackInfo;
import com.inisoft.media.MediaPlayer.TrackRepresentation;
import com.kakaoent.leonplayer.core.common.Timer;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnBufferedTime;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnBufferingStateChanged;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnCurrentTime;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnPlayerStateChanged;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnRenderingStart;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnSeekComplete;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnTimedMetaData;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener.OnTimedText;
import com.kakaoent.leonplayer.core.event.LeonPlayerEventListener;
import com.kakaoent.leonplayer.core.event.PosterImageEventListener;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonConfiguration;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonDrmInfo.Companion;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonDrmInfo;
import com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem;
import com.kakaoent.leonplayer.core.model.data.json.DrmInfo;
import com.kakaoent.leonplayer.core.model.data.json.DrmProtection;
import com.kakaoent.leonplayer.core.model.data.json.Media;
import com.kakaoent.leonplayer.core.model.data.json.MediaProperties;
import com.kakaoent.leonplayer.core.model.data.json.PlaybackUrl;
import com.kakaoent.leonplayer.core.model.data.json.PlayerItem;
import com.kakaoent.leonplayer.core.model.data.json.Representation;
import com.kakaoent.leonplayer.core.model.data.json.ThumbnailInfo;
import com.kakaoent.leonplayer.core.model.data.json.Video;
import com.kakaoent.leonplayer.core.model.data.json.VideoTrack;
import com.kakaoent.leonplayer.core.model.data.player.LeonMediaTime;
import com.kakaoent.leonplayer.core.model.data.player.LeonMediaTrack;
import com.kakaoent.leonplayer.core.model.data.player.LeonTimedMeta;
import com.kakaoent.leonplayer.core.model.data.player.LeonVideoProfile;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Completion;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Error;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Idle;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Prepared;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState.Preparing;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState;
import com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate;
import com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegate;
import e.k;
import i.n.i.b.a.s.e.Bc;
import i.n.i.b.a.s.e.Ja;
import i.n.i.b.a.s.e.K7;
import i.n.i.b.a.s.e.L9;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.N5;
import i.n.i.b.a.s.e.O8;
import i.n.i.b.a.s.e.P5;
import i.n.i.b.a.s.e.P7;
import i.n.i.b.a.s.e.R1;
import i.n.i.b.a.s.e.R5;
import i.n.i.b.a.s.e.T8;
import i.n.i.b.a.s.e.V4;
import i.n.i.b.a.s.e.Vb;
import i.n.i.b.a.s.e.W4;
import i.n.i.b.a.s.e.b4;
import i.n.i.b.a.s.e.g;
import i.n.i.b.a.s.e.h;
import i.n.i.b.a.s.e.i;
import i.n.i.b.a.s.e.n4;
import ie.H;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import je.p;
import je.w;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001A\u00020\u000B2\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0096\u0001\u00A2\u0006\u0004\b\f\u0010\rJ$\u0010\u000E\u001A\u00020\u000B2\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0096\u0001\u00A2\u0006\u0004\b\u000E\u0010\rJ\u001A\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0096\u0001\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0015\u001A\u00020\u0014H\u0096\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001EJ\u0019\u0010!\u001A\u00020\u000B2\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0016\u00A2\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001A\u0004\u0018\u00010\u001FH\u0016\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\'\u0010&J\u000F\u0010(\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b(\u0010&J\u000F\u0010)\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b)\u0010&J\u000F\u0010*\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b*\u0010&J\u0017\u0010,\u001A\u00020\u000B2\u0006\u0010+\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b,\u0010-J\u0017\u0010.\u001A\u00020\u000B2\u0006\u0010+\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b.\u0010-J\u0017\u00100\u001A\u00020\u000B2\u0006\u0010/\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b0\u0010-J\u0017\u00102\u001A\u00020\u000B2\u0006\u00101\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b2\u0010-J#\u00103\u001A\u00020\u000B2\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016\u00A2\u0006\u0004\b3\u0010\rJ#\u00104\u001A\u00020\u000B2\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016\u00A2\u0006\u0004\b4\u0010\rJ\u0017\u00106\u001A\u00020\u000B2\u0006\u00105\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b6\u0010-J\u0017\u00107\u001A\u00020\u000B2\u0006\u00105\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b7\u0010-J\u0019\u00109\u001A\u00020\u000B2\b\u00108\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b9\u0010\u001EJ\u0019\u0010:\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b:\u0010\u0013J\u0017\u0010=\u001A\u00020\u000B2\u0006\u0010<\u001A\u00020;H\u0002\u00A2\u0006\u0004\b=\u0010>J\u001F\u0010B\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020?2\u0006\u0010A\u001A\u00020@H\u0002\u00A2\u0006\u0004\bB\u0010CJ\u000F\u0010D\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\bD\u0010&J\u0013\u0010E\u001A\u00020\u001C*\u00020\u000FH\u0002\u00A2\u0006\u0004\bE\u0010FJ\u0013\u0010I\u001A\u00020H*\u00020GH\u0002\u00A2\u0006\u0004\bI\u0010JJ\u0013\u0010L\u001A\u00020H*\u00020KH\u0002\u00A2\u0006\u0004\bL\u0010MR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010NR\u0018\u0010O\u001A\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001A\u0004\u0018\u00010\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0019\u0010SR*\u0010V\u001A\u00020T2\u0006\u0010U\u001A\u00020T8\u0016@VX\u0096\u000E\u00A2\u0006\u0012\n\u0004\bV\u0010W\u001A\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010\\\u001A\u00020;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R*\u0010^\u001A\u00020H2\u0006\u0010U\u001A\u00020H8\u0016@VX\u0096\u000E\u00A2\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\b`\u0010a\"\u0004\bb\u0010cR*\u0010d\u001A\u00020H2\u0006\u0010U\u001A\u00020H8V@VX\u0096\u000E\u00A2\u0006\u0012\n\u0004\bd\u0010_\u001A\u0004\be\u0010a\"\u0004\bf\u0010cR\"\u0010h\u001A\u00020g8V@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010n\u001A\u00020g8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bn\u0010iR*\u0010o\u001A\u00020H2\u0006\u0010U\u001A\u00020H8\u0016@VX\u0096\u000E\u00A2\u0006\u0012\n\u0004\bo\u0010_\u001A\u0004\bo\u0010a\"\u0004\bp\u0010cR(\u0010s\u001A\b\u0012\u0004\u0012\u00020r0q8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bs\u0010t\u001A\u0004\bu\u0010v\"\u0004\bw\u0010xR(\u0010z\u001A\b\u0012\u0004\u0012\u00020y0q8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bz\u0010t\u001A\u0004\b{\u0010v\"\u0004\b|\u0010xR\'\u0010}\u001A\u0004\u0018\u00010y8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0015\n\u0004\b}\u0010~\u001A\u0005\b\u007F\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0083\u0001\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R#\u0010\u0087\u0001\u001A\u000E\u0012\u0004\u0012\u00020\u000B0\u0085\u0001j\u0003`\u0086\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008A\u0001\u001A\u00030\u0089\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008A\u0001\u0010\u008B\u0001R\u001B\u0010\u008C\u0001\u001A\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008C\u0001\u0010\u008D\u0001R\u001A\u0010\u0091\u0001\u001A\u0005\u0018\u00010\u008E\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u008F\u0001\u0010\u0090\u0001R\u001A\u0010\u0095\u0001\u001A\u0005\u0018\u00010\u0092\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001A\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u0096\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001A\u0010\u009D\u0001\u001A\u0005\u0018\u00010\u009A\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u009B\u0001\u0010\u009C\u0001R\u001A\u0010\u00A1\u0001\u001A\u0005\u0018\u00010\u009E\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u009F\u0001\u0010\u00A0\u0001R\u001A\u0010\u00A5\u0001\u001A\u0005\u0018\u00010\u00A2\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u00A3\u0001\u0010\u00A4\u0001R\u001A\u0010\u00A9\u0001\u001A\u0005\u0018\u00010\u00A6\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u00A7\u0001\u0010\u00A8\u0001R\u001A\u0010\u00AD\u0001\u001A\u0005\u0018\u00010\u00AA\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u00AB\u0001\u0010\u00AC\u0001R\u001A\u0010\u00B1\u0001\u001A\u0005\u0018\u00010\u00AE\u00018\u0016X\u0096\u0005\u00A2\u0006\b\u001A\u0006\b\u00AF\u0001\u0010\u00B0\u0001R\'\u0010<\u001A\u00020;2\u0006\u0010U\u001A\u00020;8V@VX\u0096\u000E\u00A2\u0006\u000F\u001A\u0006\b\u00B2\u0001\u0010\u00B3\u0001\"\u0005\b\u00B4\u0001\u0010>R(\u0010\u00B8\u0001\u001A\u00020\u000F2\u0006\u0010U\u001A\u00020\u000F8V@VX\u0096\u000E\u00A2\u0006\u000F\u001A\u0006\b\u00B5\u0001\u0010\u00B6\u0001\"\u0005\b\u00B7\u0001\u0010-R\u0017\u0010\u00BA\u0001\u001A\u00020\u000F8VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00B9\u0001\u0010\u00B6\u0001R\u0017\u0010\u00BC\u0001\u001A\u00020\u000F8VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00BB\u0001\u0010\u00B6\u0001R\u0018\u0010\u00C0\u0001\u001A\u00030\u00BD\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00BE\u0001\u0010\u00BF\u0001R\u0018\u0010\u00C2\u0001\u001A\u00030\u00BD\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00C1\u0001\u0010\u00BF\u0001R\u0018\u0010\u00C4\u0001\u001A\u00030\u00BD\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00C3\u0001\u0010\u00BF\u0001R\u0016\u0010\u00C5\u0001\u001A\u00020H8VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00C5\u0001\u0010a\u00A8\u0006\u00C6\u0001"}, d2 = {"Lcom/kakaoent/leonplayer/core/LeonPlayerImpl;", "Lcom/kakaoent/leonplayer/core/LeonPlayer;", "Lcom/kakaoent/leonplayer/delegate/LeonPlayerEventListenerDelegate;", "Lcom/kakaoent/leonplayer/delegate/ThumbnailPreviewDelegate;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "listeners", "Lie/H;", "addListeners", "([Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;)V", "removeListeners", "", "position", "Landroid/graphics/Bitmap;", "getThumbnail", "(I)Landroid/graphics/Bitmap;", "Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;", "thumbnailInfo", "setThumbnailInfo", "(Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailInfo;)V", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "configuration", "configure", "(Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;)V", "", "jsonFormatString", "(Ljava/lang/String;)V", "Landroid/view/SurfaceView;", "surfaceView", "setSurfaceView", "(Landroid/view/SurfaceView;)V", "getSurfaceView", "()Landroid/view/SurfaceView;", "releasePlayer", "()V", "prepare", "reset", "play", "pause", "msec", "forward", "(I)V", "backward", "offset", "seek", "bitrate", "preferredPeakBitRate", "addPlayerEventListeners", "removePlayerEventListeners", "index", "selectMediaTrack", "deselectMediaTrack", "id", "setVideoProfileId", "getThumbnailPreview", "", "volume", "setVolumeInternal", "(F)V", "LE9/p;", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "drmInfo", "setDrmInfo", "(LE9/p;Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;)V", "loadPosterImage", "getErrorMessage", "(I)Ljava/lang/String;", "LE9/n;", "", "isPlayingSafety", "(LE9/n;)Z", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "isLiveContents", "(Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;)Z", "Landroid/content/Context;", "player", "LE9/n;", "internalSurfaceView", "Landroid/view/SurfaceView;", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonConfiguration;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "value", "playerState", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "getPlayerState", "()Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "setPlayerState", "(Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;)V", "currentVolume", "F", "mute", "Z", "getMute", "()Z", "setMute", "(Z)V", "loop", "getLoop", "setLoop", "", "totalPlayTime", "J", "getTotalPlayTime", "()J", "setTotalPlayTime", "(J)V", "latestPlayTime", "isBuffering", "setBuffering", "", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTrack;", "mediaTracks", "Ljava/util/List;", "getMediaTracks", "()Ljava/util/List;", "setMediaTracks", "(Ljava/util/List;)V", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;", "currentVideoProfiles", "getCurrentVideoProfiles", "setCurrentVideoProfiles", "currentVideoProfile", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;", "getCurrentVideoProfile", "()Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;", "setCurrentVideoProfile", "(Lcom/kakaoent/leonplayer/core/model/data/player/LeonVideoProfile;)V", "preferredBitrate", "I", "Lkotlin/Function0;", "Lcom/kakaoent/leonplayer/core/common/Action;", "tickerAction", "Lwe/a;", "Lcom/kakaoent/leonplayer/core/common/Timer;", "mediaTimer", "Lcom/kakaoent/leonplayer/core/common/Timer;", "properties", "Lcom/kakaoent/leonplayer/core/model/data/json/MediaProperties;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "getBufferedTimeEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "bufferedTimeEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "getBufferingStateEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "bufferingStateEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "getCurrentTimeEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "currentTimeEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "getPlayerStateEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "playerStateEventListener", "Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "getPosterImageEventListener", "()Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "posterImageEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "getRenderingStartEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "renderingStartEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "getSeekCompleteEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "seekCompleteEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "getTimedMetaDataEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "timedMetaDataEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "getTimedTextEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "timedTextEventListener", "getVolume", "()F", "setVolume", "getRate", "()I", "setRate", "rate", "getVideoWidth", "videoWidth", "getVideoHeight", "videoHeight", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "getCurrentTime", "()Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "currentTime", "getBufferedTime", "bufferedTime", "getLiveTime", "liveTime", "isPlaying", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonPlayerImpl implements LeonPlayer, LeonPlayerEventListenerDelegate, ThumbnailPreviewDelegate {
    private final LeonPlayerEventListenerDelegate $$delegate_0;
    private final ThumbnailPreviewDelegate $$delegate_1;
    @Nullable
    private LeonConfiguration configuration;
    @NotNull
    private final Context context;
    @Nullable
    private LeonVideoProfile currentVideoProfile;
    @NotNull
    private List currentVideoProfiles;
    private float currentVolume;
    @Nullable
    private SurfaceView internalSurfaceView;
    private boolean isBuffering;
    private long latestPlayTime;
    private boolean loop;
    @NotNull
    private final Timer mediaTimer;
    @NotNull
    private List mediaTracks;
    private boolean mute;
    @Nullable
    private n player;
    @NotNull
    private LeonPlayerState playerState;
    private int preferredBitrate;
    @Nullable
    private MediaProperties properties;
    @NotNull
    private final a tickerAction;
    private long totalPlayTime;

    public LeonPlayerImpl(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.context = context0;
        this.$$delegate_0 = LeonPlayerEventListenerDelegate.Companion.create();
        this.$$delegate_1 = ThumbnailPreviewDelegate.Companion.create(context0);
        this.playerState = Idle.INSTANCE;
        this.currentVolume = 1.0f;
        this.mediaTracks = w.a;
        this.currentVideoProfiles = w.a;
        com.kakaoent.leonplayer.core.LeonPlayerImpl.tickerAction.1 leonPlayerImpl$tickerAction$10 = new a() {
            {
                LeonPlayerImpl.this = leonPlayerImpl0;
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                this.invoke();
                return H.a;
            }

            public final void invoke() {
                OnCurrentTime leonPlayerEventListener$OnCurrentTime0 = LeonPlayerImpl.this.getCurrentTimeEventListener();
                if(leonPlayerEventListener$OnCurrentTime0 != null) {
                    leonPlayerEventListener$OnCurrentTime0.onCurrentTime(LeonPlayerImpl.this.getCurrentTime());
                }
            }
        };
        this.tickerAction = leonPlayerImpl$tickerAction$10;
        this.mediaTimer = new Timer(leonPlayerImpl$tickerAction$10);
        n n0 = new n();
        n0.f = new com.kakaoent.leonplayer.core.a(this);
        n0.g = new com.kakaoent.leonplayer.core.a(this);
        n0.l = new com.kakaoent.leonplayer.core.a(this);
        n0.k = new com.kakaoent.leonplayer.core.a(this);
        n0.m = new com.kakaoent.leonplayer.core.a(this);
        n0.i = new com.kakaoent.leonplayer.core.a(this);
        n0.j = new com.kakaoent.leonplayer.core.a(this);
        n0.h = new com.kakaoent.leonplayer.core.a(this);
        com.kakaoent.leonplayer.core.LeonPlayerImpl.1.9 leonPlayerImpl$1$90 = new f() {
            @Override  // E9.f
            public void onDownstreamFormatChanged(@Nullable E9.a a0, @Nullable c c0) {
            }

            @Override  // E9.f
            public void onDroppedVideoFrames(@Nullable E9.a a0, int v, long v1) {
            }

            @Override  // E9.f
            public void onIsPlayingChanged(@Nullable E9.a a0, boolean z) {
                if(z) {
                    long v = SystemClock.elapsedRealtime();
                    LeonPlayerImpl.access$setLatestPlayTime$p(LeonPlayerImpl.this, v);
                    return;
                }
                long v1 = SystemClock.elapsedRealtime();
                long v2 = LeonPlayerImpl.this.getTotalPlayTime();
                LeonPlayerImpl.this.setTotalPlayTime(v1 - LeonPlayerImpl.access$getLatestPlayTime$p(LeonPlayerImpl.this) + v2);
            }

            @Override  // E9.f
            public void onLoadCanceled(@Nullable E9.a a0, @Nullable b b0, @Nullable c c0) {
            }

            @Override  // E9.f
            public void onLoadCompleted(@Nullable E9.a a0, @Nullable b b0, @Nullable c c0) {
            }

            @Override  // E9.f
            public void onLoadError(@Nullable E9.a a0, @Nullable b b0, @Nullable c c0, @Nullable IOException iOException0, int v, boolean z) {
            }

            @Override  // E9.f
            public void onLoadStarted(@Nullable E9.a a0, @Nullable b b0, @Nullable c c0) {
            }

            @Override  // E9.f
            public void onPlayWhenReadyChanged(@Nullable E9.a a0, boolean z, int v) {
            }

            @Override  // E9.f
            public void onPlaybackStateChanged(@Nullable E9.a a0, int v) {
            }

            @Override  // E9.f
            public void onPlayerError(@Nullable E9.a a0, int v, @Nullable Exception exception0) {
            }

            @Override  // E9.f
            public void onPositionDiscontinuity(@Nullable E9.a a0, @Nullable d d0, @Nullable d d1, int v) {
            }

            @Override  // E9.f
            public void onVideoSizeChanged(@Nullable E9.a a0, @Nullable e e0) {
            }
        };
        n0.a("addAnalyticsListener", new Object[]{leonPlayerImpl$1$90});
        s s0 = new s(leonPlayerImpl$1$90);
        n0.r.add(s0);
        n0.d.W.add(s0);
        Bc bc0 = n0.d.a;
        if(bc0 != null) {
            bc0.k.getClass();
            com.iloen.melon.sns.model.a a0 = bc0.k.e;
            if(!a0.a) {
                ((CopyOnWriteArraySet)a0.e).add(new K7(s0));
            }
        }
        this.player = n0;
    }

    public static void a(LeonPlayerImpl leonPlayerImpl0, n n0) {
        LeonPlayerImpl.lambda-10$lambda-2(leonPlayerImpl0, n0);
    }

    public static final long access$getLatestPlayTime$p(LeonPlayerImpl leonPlayerImpl0) {
        return leonPlayerImpl0.latestPlayTime;
    }

    public static final void access$setLatestPlayTime$p(LeonPlayerImpl leonPlayerImpl0, long v) {
        leonPlayerImpl0.latestPlayTime = v;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    public void addListeners(@NotNull LeonPlayerEventListener[] arr_leonPlayerEventListener) {
        q.g(arr_leonPlayerEventListener, "listeners");
        this.$$delegate_0.addListeners(arr_leonPlayerEventListener);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void addPlayerEventListeners(@NotNull LeonPlayerEventListener[] arr_leonPlayerEventListener) {
        q.g(arr_leonPlayerEventListener, "listeners");
        this.addListeners(((LeonPlayerEventListener[])Arrays.copyOf(arr_leonPlayerEventListener, arr_leonPlayerEventListener.length)));
    }

    public static boolean b(LeonPlayerImpl leonPlayerImpl0, n n0, int v, int v1, Object object0) {
        return LeonPlayerImpl.lambda-10$lambda-8(leonPlayerImpl0, n0, v, v1, object0);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void backward(int v) {
        this.seek(this.getCurrentTime().getPosition() - v);
    }

    public static void c(LeonPlayerImpl leonPlayerImpl0, n n0) {
        LeonPlayerImpl.lambda-10$lambda-4(leonPlayerImpl0, n0);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void configure(@NotNull LeonConfiguration leonConfiguration0) {
        q.g(leonConfiguration0, "configuration");
        this.configuration = leonConfiguration0;
        this.properties = null;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void configure(@NotNull String s) {
        LeonDrmInfo leonDrmInfo0;
        String s4;
        String s2;
        q.g(s, "jsonFormatString");
        PlayerItem playerItem0 = PlayerItem.Companion.parse(s);
        if(playerItem0 == null) {
            throw new IllegalArgumentException("IllegalJsonFormatString");
        }
        for(Object object0: playerItem0.getPlaybackUrls()) {
            PlaybackUrl playbackUrl0 = (PlaybackUrl)object0;
            if(q.b(playbackUrl0.getType(), "MPEG-DASH")) {
                List list0 = playbackUrl0.getMedia();
                Object object1 = null;
                if(playbackUrl0.getDrm() == null) {
                    leonDrmInfo0 = null;
                }
                else {
                    Companion leonDrmInfo$Companion0 = LeonDrmInfo.Companion;
                    DrmInfo drmInfo0 = playerItem0.getDrmInfo();
                    if(drmInfo0 == null) {
                        s2 = "";
                    }
                    else {
                        List list1 = drmInfo0.getProtections();
                        if(list1 == null) {
                            s2 = "";
                        }
                        else {
                            Object object2 = null;
                            for(Object object3: list1) {
                                if(q.b(((DrmProtection)object3).getScheme(), "widevine")) {
                                    object2 = object3;
                                    break;
                                }
                            }
                            if(((DrmProtection)object2) == null) {
                                s2 = "";
                            }
                            else {
                                String s1 = ((DrmProtection)object2).getUrl();
                                s2 = s1 == null ? "" : s1;
                            }
                        }
                    }
                    DrmInfo drmInfo1 = playerItem0.getDrmInfo();
                    if(drmInfo1 == null) {
                        s4 = "";
                    }
                    else {
                        String s3 = drmInfo1.getToken();
                        s4 = s3 == null ? "" : s3;
                    }
                    leonDrmInfo0 = Companion.of$default(leonDrmInfo$Companion0, "widevine", s2, s4, null, 8, null);
                }
                String s5 = ((Media)list0.get(0)).getUrl();
                LeonPlayerItem leonPlayerItem0 = com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem.Companion.of$default(LeonPlayerItem.Companion, null, s5, 0, null, leonDrmInfo0, null, 45, null);
                this.configuration = LeonConfiguration.Companion.of(leonPlayerItem0);
                this.properties = playerItem0.getMediaProperties();
                Video video0 = (Video)((Media)list0.get(0)).getVideos().get(0);
                String s6 = video0.getTrack();
                List list2 = video0.getRepresentations();
                Set set0 = list2 == null ? new LinkedHashSet() : p.T0(list2);
                ke.b b0 = k.l();
                for(Object object4: playerItem0.getVideoTracks()) {
                    if(q.b(((VideoTrack)object4).getId(), s6)) {
                        object1 = object4;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
                if(((VideoTrack)object1) != null) {
                    List list3 = ((VideoTrack)object1).getRepresentations();
                    if(list3 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object5: list3) {
                            if(set0.contains(((Representation)object5).getId())) {
                                arrayList0.add(object5);
                            }
                        }
                        for(Object object6: arrayList0) {
                            String s7 = ((Representation)object6).getId();
                            String s8 = ((Representation)object6).getDispName();
                            int v = ((Representation)object6).getBitrate();
                            String s9 = ((Representation)object6).getResolution();
                            if(s9 == null) {
                                s9 = "";
                            }
                            b0.add(new LeonVideoProfile(s7, s8, v, s9));
                        }
                    }
                }
                this.setCurrentVideoProfiles(k.h(b0));
                return;
            }
            if(false) {
                break;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static void d(LeonPlayerImpl leonPlayerImpl0, n n0, E9.q q0) {
        LeonPlayerImpl.lambda-10$lambda-6(leonPlayerImpl0, n0, q0);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void deselectMediaTrack(int v) {
        n n0 = this.player;
        if(n0 != null) {
            n0.f(v);
        }
    }

    public static boolean e(LeonPlayerImpl leonPlayerImpl0, n n0, int v, int v1) {
        return LeonPlayerImpl.lambda-10$lambda-9(leonPlayerImpl0, n0, v, v1);
    }

    public static void f(LeonPlayerImpl leonPlayerImpl0, n n0, int v) {
        LeonPlayerImpl.lambda-10$lambda-7(leonPlayerImpl0, n0, v);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void forward(int v) {
        this.seek(this.getCurrentTime().getPosition() + v);
    }

    public static void g(LeonPlayerImpl leonPlayerImpl0, n n0) {
        LeonPlayerImpl.lambda-10$lambda-3(leonPlayerImpl0, n0);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @NotNull
    public LeonMediaTime getBufferedTime() {
        int v5;
        n n0 = this.player;
        int v = 0;
        if(n0 == null) {
            v5 = 0;
        }
        else {
            Vb vb0 = n0.d;
            long v1 = 0L;
            if(vb0 != null) {
                Bc bc0 = vb0.a;
                if(bc0 != null) {
                    bc0.v1();
                    O8 o80 = bc0.d;
                    if(!o80.S0()) {
                        if(o80.S.a.p()) {
                            v1 = o80.V;
                        }
                        else {
                            R5 r50 = o80.S;
                            if(r50.k.d == r50.b.d) {
                                long v3 = r50.q;
                                if(o80.S.k.a()) {
                                    g g0 = o80.S.a.i(o80.S.k.a, o80.k);
                                    long v4 = g0.g.b[o80.S.k.b];
                                    v3 = v4 == 0x8000000000000000L ? g0.d : v4;
                                }
                                o80.S.a.i(o80.S.k.a, o80.k);
                                v1 = b4.b(v3 + o80.k.e);
                            }
                            else {
                                int v2 = o80.e1();
                                v1 = b4.b(r50.a.j(v2, ((h)o80.a), 0L).n);
                            }
                        }
                    }
                    else if(o80.S.k.equals(o80.S.b)) {
                        v1 = b4.b(o80.S.q);
                    }
                    else {
                        v1 = o80.A1();
                    }
                }
            }
            v5 = (int)v1;
        }
        n n1 = this.player;
        if(n1 != null) {
            v = n1.g();
        }
        return new LeonMediaTime(v5, v);
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnBufferedTime getBufferedTimeEventListener() {
        return this.$$delegate_0.getBufferedTimeEventListener();
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnBufferingStateChanged getBufferingStateEventListener() {
        return this.$$delegate_0.getBufferingStateEventListener();
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @NotNull
    public LeonMediaTime getCurrentTime() {
        int v1;
        n n0 = this.player;
        int v = 0;
        if(n0 == null) {
            v1 = 0;
        }
        else {
            Vb vb0 = n0.d;
            v1 = vb0 == null ? 0 : ((int)vb0.o());
        }
        n n1 = this.player;
        if(n1 != null) {
            v = n1.g();
        }
        return new LeonMediaTime(v1, v);
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnCurrentTime getCurrentTimeEventListener() {
        return this.$$delegate_0.getCurrentTimeEventListener();
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @Nullable
    public LeonVideoProfile getCurrentVideoProfile() {
        return this.currentVideoProfile;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @NotNull
    public List getCurrentVideoProfiles() {
        return this.currentVideoProfiles;
    }

    private final String getErrorMessage(int v) {
        Field[] arr_field = E9.h.class.getDeclaredFields();
        q.f(arr_field, "ErrorCodes::class.java.declaredFields");
        for(int v1 = 0; v1 < arr_field.length; ++v1) {
            Field field0 = arr_field[v1];
            try {
                if(field0.getInt(0) == v) {
                    String s = field0.getName();
                    q.f(s, "it.name");
                    return s;
                }
            }
            catch(Exception unused_ex) {
            }
        }
        return "Unknown Error";
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @NotNull
    public LeonMediaTime getLiveTime() {
        long v3;
        int v = 0;
        int v1 = this.player == null ? 0 : this.player.h();
        n n0 = this.player;
        if(n0 != null) {
            Vb vb0 = n0.d;
            synchronized(vb0.J) {
                if(vb0.j(new int[]{4, 5, 6, 8})) {
                    if(vb0.a == null) {
                        Log.w("IbisPlayer", "Player state is invalid : " + vb0.r());
                        goto label_17;
                    }
                    goto label_11;
                }
                else {
                    goto label_17;
                }
                goto label_22;
            }
        label_11:
            long v2 = vb0.N;
            if(v2 == 0x8000000000000001L) {
            label_17:
                v3 = 0x8000000000000001L;
            }
            else {
                v3 = v2 - vb0.O;
            }
        label_22:
            if(v3 == 0x8000000000000001L) {
                return new LeonMediaTime(v1, -1);
            }
            v = (int)v3;
        }
        return new LeonMediaTime(v1, v);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public boolean getLoop() {
        n n0 = this.player;
        if(n0 != null) {
            return n0.d == null ? false : n0.d.B;
        }
        return false;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @NotNull
    public List getMediaTracks() {
        return this.mediaTracks;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public boolean getMute() {
        return this.mute;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @NotNull
    public LeonPlayerState getPlayerState() {
        return this.playerState;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnPlayerStateChanged getPlayerStateEventListener() {
        return this.$$delegate_0.getPlayerStateEventListener();
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public PosterImageEventListener getPosterImageEventListener() {
        return this.$$delegate_0.getPosterImageEventListener();
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public int getRate() {
        n n0 = this.player;
        if(n0 != null) {
            n0.e();
            Vb vb0 = n0.d;
            synchronized(vb0.J) {
                Bc bc0 = vb0.a;
                if(bc0 != null) {
                    bc0.v1();
                    return Math.round(bc0.d.S.n.a * 100.0f);
                }
            }
            throw new IllegalStateException("Player is invalid : " + vb0.r());
        }
        return 100;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnRenderingStart getRenderingStartEventListener() {
        return this.$$delegate_0.getRenderingStartEventListener();
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnSeekComplete getSeekCompleteEventListener() {
        return this.$$delegate_0.getSeekCompleteEventListener();
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @Nullable
    public SurfaceView getSurfaceView() {
        return this.internalSurfaceView;
    }

    @Override  // com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegate
    @Nullable
    public Bitmap getThumbnail(int v) {
        return this.$$delegate_1.getThumbnail(v);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    @Nullable
    public Bitmap getThumbnailPreview(int v) {
        return this.getThumbnail(v);
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnTimedMetaData getTimedMetaDataEventListener() {
        return this.$$delegate_0.getTimedMetaDataEventListener();
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnTimedText getTimedTextEventListener() {
        return this.$$delegate_0.getTimedTextEventListener();
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public long getTotalPlayTime() {
        if(this.player != null && this.isPlayingSafety(this.player)) {
            long v = SystemClock.elapsedRealtime();
            this.totalPlayTime = v - this.latestPlayTime + this.totalPlayTime;
            this.latestPlayTime = v;
        }
        return this.totalPlayTime;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public int getVideoHeight() {
        n n0 = this.player;
        if(n0 != null) {
            Vb vb0 = n0.d;
            if(vb0 != null) {
                return vb0.a == null ? 0 : vb0.a.e0.b;
            }
        }
        return 0;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public int getVideoWidth() {
        n n0 = this.player;
        if(n0 != null) {
            Vb vb0 = n0.d;
            if(vb0 != null) {
                Bc bc0 = vb0.a;
                n4 n40 = bc0 == null ? new n4() : bc0.e0;
                if(bc0 != null) {
                    return n40.d <= 0.0f || n40.d == 1.0f ? n40.a : Math.round(((float)n40.a) * n40.d);
                }
            }
        }
        return 0;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public float getVolume() {
        return this.currentVolume;
    }

    public static void h(LeonPlayerImpl leonPlayerImpl0, n n0, r[] arr_r) {
        LeonPlayerImpl.lambda-10$lambda-5(leonPlayerImpl0, n0, arr_r);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public boolean isBuffering() {
        return this.isBuffering;
    }

    private final boolean isLiveContents(MediaProperties mediaProperties0) {
        return v.j0(mediaProperties0.getType(), "live", true);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public boolean isPlaying() {
        return this.player == null ? false : this.player.j();
    }

    private final boolean isPlayingSafety(n n0) {
        try {
            return n0.j();
        }
        catch(IllegalStateException unused_ex) {
            return false;
        }
    }

    private static final void lambda-10$lambda-2(LeonPlayerImpl leonPlayerImpl0, n n0) {
        q.g(leonPlayerImpl0, "this$0");
        ke.b b0 = k.l();
        n n1 = leonPlayerImpl0.player;
        if(n1 != null) {
            MediaPlayer.TrackInfo[] arr_mediaPlayer$TrackInfo = n1.i();
            if(arr_mediaPlayer$TrackInfo != null) {
                ArrayList arrayList0 = new ArrayList(arr_mediaPlayer$TrackInfo.length);
                boolean z = true;
                int v = 0;
                int v1 = 0;
                while(v < arr_mediaPlayer$TrackInfo.length) {
                    MediaPlayer.TrackInfo mediaPlayer$TrackInfo0 = arr_mediaPlayer$TrackInfo[v];
                    int v2 = mediaPlayer$TrackInfo0.c;
                    String s = mediaPlayer$TrackInfo0.d.b;
                    if(s == null) {
                        if("application/dash+xml".equals(mediaPlayer$TrackInfo0.h) && (v2 == 2 || v2 == 3)) {
                            String s1 = mediaPlayer$TrackInfo0.g[0].b.a;
                            if(s1 != null) {
                                s = s1;
                                goto label_21;
                            }
                        }
                        s = null;
                    }
                label_21:
                    if(s == null) {
                        s = "undefined";
                    }
                    q.f(mediaPlayer$TrackInfo0.f, "track.language");
                    b0.add(new LeonMediaTrack(v2, s, mediaPlayer$TrackInfo0.f));
                    if(z && v2 == 3) {
                        n n2 = leonPlayerImpl0.player;
                        if(n2 != null) {
                            n2.f(v1);
                        }
                        z = false;
                    }
                    arrayList0.add(H.a);
                    ++v;
                    ++v1;
                }
            }
        }
        leonPlayerImpl0.setMediaTracks(k.h(b0));
        leonPlayerImpl0.setPlayerState(Prepared.INSTANCE);
        PosterImageEventListener posterImageEventListener0 = leonPlayerImpl0.getPosterImageEventListener();
        if(posterImageEventListener0 != null) {
            posterImageEventListener0.onPosterImageLoaded(null);
        }
    }

    private static final void lambda-10$lambda-3(LeonPlayerImpl leonPlayerImpl0, n n0) {
        q.g(leonPlayerImpl0, "this$0");
        leonPlayerImpl0.setPlayerState(Completion.INSTANCE);
    }

    private static final void lambda-10$lambda-4(LeonPlayerImpl leonPlayerImpl0, n n0) {
        q.g(leonPlayerImpl0, "this$0");
        if(q.b(leonPlayerImpl0.getPlayerState(), Completion.INSTANCE)) {
            leonPlayerImpl0.setPlayerState(Prepared.INSTANCE);
        }
        OnCurrentTime leonPlayerEventListener$OnCurrentTime0 = leonPlayerImpl0.getCurrentTimeEventListener();
        if(leonPlayerEventListener$OnCurrentTime0 != null) {
            leonPlayerEventListener$OnCurrentTime0.onCurrentTime(leonPlayerImpl0.getCurrentTime());
        }
        OnSeekComplete leonPlayerEventListener$OnSeekComplete0 = leonPlayerImpl0.getSeekCompleteEventListener();
        if(leonPlayerEventListener$OnSeekComplete0 != null) {
            leonPlayerEventListener$OnSeekComplete0.onSeekComplete();
        }
    }

    private static final void lambda-10$lambda-5(LeonPlayerImpl leonPlayerImpl0, n n0, r[] arr_r) {
        q.g(leonPlayerImpl0, "this$0");
        StringBuilder stringBuilder0 = new StringBuilder();
        q.f(arr_r, "textCues");
        for(int v = 0; v < arr_r.length; ++v) {
            r r0 = arr_r[v];
            stringBuilder0.append(" ");
            stringBuilder0.append(r0.a);
        }
        OnTimedText leonPlayerEventListener$OnTimedText0 = leonPlayerImpl0.getTimedTextEventListener();
        if(leonPlayerEventListener$OnTimedText0 != null) {
            String s = stringBuilder0.toString();
            q.f(s, "builder.toString()");
            leonPlayerEventListener$OnTimedText0.onTimedText(s);
        }
    }

    private static final void lambda-10$lambda-6(LeonPlayerImpl leonPlayerImpl0, n n0, E9.q q0) {
        q.g(leonPlayerImpl0, "this$0");
        OnTimedMetaData leonPlayerEventListener$OnTimedMetaData0 = leonPlayerImpl0.getTimedMetaDataEventListener();
        if(leonPlayerEventListener$OnTimedMetaData0 != null) {
            q0.getClass();
            byte[] arr_b = q0.a;
            q.f(arr_b, "timedMetaData.metaData");
            leonPlayerEventListener$OnTimedMetaData0.onTimedMetaData(new LeonTimedMeta(0L, new String(arr_b, Tf.a.a)));
        }
    }

    private static final void lambda-10$lambda-7(LeonPlayerImpl leonPlayerImpl0, n n0, int v) {
        q.g(leonPlayerImpl0, "this$0");
        OnBufferedTime leonPlayerEventListener$OnBufferedTime0 = leonPlayerImpl0.getBufferedTimeEventListener();
        if(leonPlayerEventListener$OnBufferedTime0 != null) {
            leonPlayerEventListener$OnBufferedTime0.onBufferedTime(leonPlayerImpl0.getBufferedTime());
        }
    }

    private static final boolean lambda-10$lambda-8(LeonPlayerImpl leonPlayerImpl0, n n0, int v, int v1, Object object0) {
        q.g(leonPlayerImpl0, "this$0");
        switch(v) {
            case 3: {
                OnRenderingStart leonPlayerEventListener$OnRenderingStart0 = leonPlayerImpl0.getRenderingStartEventListener();
                if(leonPlayerEventListener$OnRenderingStart0 != null) {
                    leonPlayerEventListener$OnRenderingStart0.onRenderingStart();
                }
                return true;
            }
            case 701: {
                leonPlayerImpl0.setBuffering(true);
                return true;
            }
            case 702: {
                leonPlayerImpl0.setBuffering(false);
                return true;
            }
            default: {
                return true;
            }
        }
    }

    private static final boolean lambda-10$lambda-9(LeonPlayerImpl leonPlayerImpl0, n n0, int v, int v1) {
        q.g(leonPlayerImpl0, "this$0");
        leonPlayerImpl0.setPlayerState(new Error(v1, leonPlayerImpl0.getErrorMessage(v1)));
        return true;
    }

    private final void loadPosterImage() {
        LeonConfiguration leonConfiguration0 = this.configuration;
        if(leonConfiguration0 != null) {
            List list0 = leonConfiguration0.getPlayerItemList();
            if(list0 != null) {
                LeonPlayerItem leonPlayerItem0 = (LeonPlayerItem)list0.get(0);
                if(leonPlayerItem0 != null) {
                    String s = leonPlayerItem0.getPosterImage();
                    if(s != null) {
                        Glide.with(this.context).asBitmap().load(s).into(new CustomTarget() {
                            @Override  // com.bumptech.glide.request.target.Target
                            public void onLoadCleared(@Nullable Drawable drawable0) {
                            }

                            public void onResourceReady(@NotNull Bitmap bitmap0, @Nullable Transition transition0) {
                                q.g(bitmap0, "resource");
                                PosterImageEventListener posterImageEventListener0 = LeonPlayerImpl.this.getPosterImageEventListener();
                                if(posterImageEventListener0 != null) {
                                    posterImageEventListener0.onPosterImageLoaded(bitmap0);
                                }
                            }

                            @Override  // com.bumptech.glide.request.target.Target
                            public void onResourceReady(Object object0, Transition transition0) {
                                this.onResourceReady(((Bitmap)object0), transition0);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void pause() {
        n n0 = this.player;
        if(n0 != null) {
            n0.a("pause", new Object[0]);
            n0.e();
            n0.b(false);
            Vb vb0 = n0.d;
            Vb vb1 = vb0.J;
            __monitor_enter(vb1);
            int v = FIN.finallyOpen$NT();
            if(!vb0.j(new int[]{5, 6, 8})) {
                goto label_29;
            }
            if(vb0.a == null) {
                goto label_27;
            }
            if(vb0.I == 6) {
                FIN.finallyExec$NT(v);
            }
            else {
                vb0.I = 6;
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(vb1);
                FIN.finallyCodeEnd$NT(v);
                P5 p50 = vb0.u;
                if(p50 != null) {
                    long v1 = vb0.o();
                    N5 n50 = new N5();  // 初始化器: Ljava/util/HashMap;-><init>()V
                    n50.put("at", v1);
                    n50.put("duration", p50.g);
                    p50.f("PAUSE", n50);
                }
                vb0.a.F1(false);
                goto label_31;
            label_27:
                FIN.finallyExec$NT(v);
                throw new IllegalStateException("Player is invalid : " + vb0.r());
            label_29:
                FIN.finallyExec$NT(v);
                throw new IllegalStateException(vb0.n("pause"));
            }
        }
    label_31:
        this.mediaTimer.stop();
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void play() {
        n n0 = this.player;
        if(n0 != null) {
            if(this.properties != null && this.isLiveContents(this.properties)) {
                n0.l(n0.h());
            }
            n0.a("start", new Object[0]);
            n0.e();
            n0.b(true);
            Vb vb0 = n0.d;
            Vb vb1 = vb0.J;
            __monitor_enter(vb1);
            int v = FIN.finallyOpen$NT();
            if(!vb0.j(new int[]{4, 5, 6, 8})) {
                goto label_41;
            }
            if(vb0.a == null) {
                goto label_39;
            }
            if(vb0.I == 5) {
                FIN.finallyExec$NT(v);
            }
            else {
                vb0.I = 5;
                FIN.finallyCodeBegin$NT(v);
                __monitor_exit(vb1);
                FIN.finallyCodeEnd$NT(v);
                P5 p50 = vb0.u;
                if(p50 != null) {
                    long v1 = vb0.o();
                    N5 n50 = new N5();  // 初始化器: Ljava/util/HashMap;-><init>()V
                    n50.put("at", v1);
                    n50.put("duration", p50.g);
                    p50.f("PLAY", n50);
                }
                if(vb0.K) {
                    vb0.h(0L, true);
                    vb0.K = false;
                }
                if(vb0.L && vb0.z.F) {
                    vb0.a.y1(vb0.a.e1(), 0x8000000000000001L);
                }
                if(vb0.A) {
                    C c0 = vb0.e;
                    if(!c0.b) {
                        c0.b = true;
                        c0.sendEmptyMessage(0x457);
                    }
                }
                vb0.a.F1(true);
                goto label_43;
            label_39:
                FIN.finallyExec$NT(v);
                throw new IllegalStateException("Player is invalid : " + vb0.r());
            label_41:
                FIN.finallyExec$NT(v);
                throw new IllegalStateException(vb0.n("start"));
            }
        }
    label_43:
        int v2 = this.getCurrentTime().getPosition();
        int v3 = this.getCurrentTime().getDuration();
        this.mediaTimer.start(v2, v3);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void preferredPeakBitRate(int v) {
        this.preferredBitrate = v;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void prepare() {
        HashMap hashMap0;
        String s5;
        String s2;
        LeonConfiguration leonConfiguration0 = this.configuration;
        if(leonConfiguration0 == null) {
            return;
        }
        this.reset();
        this.loadPosterImage();
        LeonPlayerItem leonPlayerItem0 = (LeonPlayerItem)leonConfiguration0.getPlayerItemList().get(0);
        n n0 = this.player;
        if(n0 != null) {
            n0.n((this.internalSurfaceView == null ? null : this.internalSurfaceView.getHolder()));
            Context context0 = this.context;
            Uri uri0 = Uri.parse(leonPlayerItem0.getUrl());
            Map map0 = leonPlayerItem0.getHeader();
            String s = "";
            String s1 = "null";
            if(uri0 == null) {
                s2 = "null";
            }
            else {
                String s3 = uri0.getScheme();
                s2 = x.m(new StringBuilder(), (s3 == null ? "" : s3 + "://"), "<suppressed>");
            }
            if(map0 != null) {
                Iterator iterator0 = map0.keySet().iterator();
                StringBuilder stringBuilder0 = new StringBuilder("[");
                boolean z = true;
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    if(z) {
                        z = false;
                    }
                    else {
                        stringBuilder0.append(", ");
                    }
                    stringBuilder0.append(((String)object0));
                }
                stringBuilder0.append("]");
                s1 = stringBuilder0.toString();
            }
            n0.a("setDataSource", new Object[]{context0, s2, s1});
            n0.e();
            Log.i("MEDIA_COMMON", "DICEBLDPROP: @V2.14.0@T2022-09-27T17:52@H77f5116c");
            int v1 = Build.VERSION.SDK_INT;
            String[] arr_s = Build.SUPPORTED_ABIS;
            StringBuilder stringBuilder1 = new StringBuilder("DICESYSPROP: @N");
            stringBuilder1.append(Build.PRODUCT);
            stringBuilder1.append("@M");
            A7.d.t(stringBuilder1, Build.MODEL, "@S", v1, "@B");
            stringBuilder1.append(Build.BOARD);
            stringBuilder1.append("@H");
            stringBuilder1.append(Build.HARDWARE);
            stringBuilder1.append("@A");
            if(arr_s.length != 0) {
                StringBuilder stringBuilder2 = new StringBuilder("");
                for(int v = 0; true; ++v) {
                    stringBuilder2.append(arr_s[v]);
                    if(v == arr_s.length - 1) {
                        break;
                    }
                    stringBuilder2.append(",");
                }
                stringBuilder2.append("");
                s = stringBuilder2.toString();
            }
            stringBuilder1.append(s);
            Log.i("MEDIA_COMMON", stringBuilder1.toString());
            String s4 = Build.VERSION.RELEASE;
            try {
                s5 = "Unknown Application";
                s5 = context0.getApplicationContext().getApplicationInfo().packageName;
            }
            catch(Exception unused_ex) {
            }
            Ja.J = "inidrmagent/2.0 (Android " + s4 + "; " + s5 + ")";
            n0.e = context0;
            Vb vb0 = n0.d;
            String s6 = uri0.toString();
            synchronized(vb0.J) {
                if(vb0.I != 1) {
                    throw new IllegalStateException("Player state is invalid : " + vb0.r());
                }
                vb0.I = 2;
            }
            vb0.o = context0;
            vb0.p = s6;
            if(map0 == null) {
                hashMap0 = new HashMap();
            }
            else {
                hashMap0 = new HashMap();
                for(Object object1: map0.entrySet()) {
                    hashMap0.put(((String)((Map.Entry)object1).getKey()), ((String)((Map.Entry)object1).getValue()));
                }
            }
            vb0.q = Collections.unmodifiableMap(hashMap0);
            String s7 = vb0.p.toLowerCase();
            if(s7.startsWith("http") || s7.startsWith("https")) {
                vb0.A = true;
            }
            E9.p p0 = new E9.p();
            p0.a.put("DISABLE_SSL_HOST_VERIFICATION", Boolean.TRUE);
            if(leonPlayerItem0.getDrmInfo() != null) {
                LeonDrmInfo leonDrmInfo0 = leonPlayerItem0.getDrmInfo();
                q.d(leonDrmInfo0);
                this.setDrmInfo(p0, leonDrmInfo0);
            }
            if(leonPlayerItem0.getStartTime() > 0) {
                n0.k(leonPlayerItem0.getStartTime(), p0);
            }
            else {
                n0.k(-1, p0);
            }
        }
        this.setPlayerState(Preparing.INSTANCE);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void releasePlayer() {
        this.reset();
        n n0 = this.player;
        if(n0 != null) {
            n0.a("release", new Object[0]);
            n0.c.v();
            n0.c.getClass();
            Vb vb0 = n0.d;
            if(vb0 != null) {
                Vb vb1 = vb0.J;
                __monitor_enter(vb1);
                if(vb0.I == 9) {
                    __monitor_exit(vb1);
                }
                else {
                    vb0.I = 9;
                    __monitor_exit(vb1);
                    R1 r10 = vb0.y;
                    if(r10 != null) {
                        r10.e();
                    }
                    vb0.y = null;
                    vb0.H = 4;
                    Bc bc0 = vb0.a;
                    if(bc0 != null) {
                        bc0.t1();
                    }
                    vb0.f = null;
                    vb0.X = null;
                    vb0.K = false;
                    vb0.e.b = false;
                    vb0.c.removeCallbacksAndMessages(null);
                    vb0.e.removeCallbacksAndMessages(null);
                    vb0.a();
                    vb0.x.clear();
                    vb0.V.getClass();
                }
            }
            n0.b(false);
            SurfaceHolder surfaceHolder0 = n0.a;
            if(surfaceHolder0 != null) {
                surfaceHolder0.setKeepScreenOn(false);
            }
            n0.o = 0;
        }
        this.player = null;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    public void removeListeners(@NotNull LeonPlayerEventListener[] arr_leonPlayerEventListener) {
        q.g(arr_leonPlayerEventListener, "listeners");
        this.$$delegate_0.removeListeners(arr_leonPlayerEventListener);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void removePlayerEventListeners(@NotNull LeonPlayerEventListener[] arr_leonPlayerEventListener) {
        q.g(arr_leonPlayerEventListener, "listeners");
        this.removeListeners(((LeonPlayerEventListener[])Arrays.copyOf(arr_leonPlayerEventListener, arr_leonPlayerEventListener.length)));
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void reset() {
        Pair pair0;
        P7 p71;
        n n0 = this.player;
        if(n0 != null) {
            n0.a("reset", new Object[0]);
            Vb vb0 = n0.d;
            if(vb0 != null) {
                synchronized(vb0.J) {
                    if(!vb0.j(new int[]{9})) {
                        vb0.I = 1;
                        R1 r10 = vb0.y;
                        if(r10 != null) {
                            r10.e();
                        }
                        vb0.y = null;
                        vb0.z.c();
                        vb0.H = 1;
                        Bc bc0 = vb0.a;
                        if(bc0 != null) {
                            bc0.v1();
                            boolean z = bc0.r1();
                            bc0.m.a(1, z);
                            bc0.d.w1(null);
                            Bc bc1 = vb0.a;
                            bc1.v1();
                            O8 o80 = bc1.d;
                            int v1 = Math.min(0x7FFFFFFF, o80.l.size());
                            M7.u(v1 >= 0 && v1 <= o80.l.size());
                            int v2 = o80.e1();
                            i i0 = o80.S.a;
                            int v3 = o80.l.size();
                            ++o80.B;
                            o80.y1(v1);
                            P7 p70 = new P7(o80.l, o80.I);
                            R5 r50 = o80.S;
                            g g0 = o80.k;
                            long v4 = o80.U0();
                            if(!i0.p() && !p70.p()) {
                                int v5 = o80.e1();
                                Pair pair1 = i0.f(((h)o80.a), o80.k, v5, b4.a(v4));
                                Object object0 = pair1.first;
                                if(p70.d(object0) == -1) {
                                    Object object1 = L9.q(((h)o80.a), o80.k, 0, false, object0, i0, p70);
                                    p71 = p70;
                                    if(object1 == null) {
                                        pair0 = o80.t1(p71, -1, 0x8000000000000001L);
                                    }
                                    else {
                                        p71.i(object1, g0);
                                        int v6 = g0.c;
                                        h h0 = (h)o80.a;
                                        p71.j(v6, h0, 0L);
                                        pair0 = o80.t1(p71, v6, b4.b(h0.m));
                                    }
                                }
                                else {
                                    p71 = p70;
                                    pair0 = pair1;
                                }
                            }
                            else {
                                p71 = p70;
                                boolean z1 = !i0.p() && p71.p();
                                pair0 = o80.t1(p71, (z1 ? -1 : o80.r1()), (z1 ? 0x8000000000000001L : v4));
                            }
                            R5 r51 = o80.u1(r50, p71, pair0);
                            if(r51.e != 1 && r51.e != 4 && v1 > 0 && v1 == v3 && v2 >= r51.a.l()) {
                                r51 = r51.a(4);
                            }
                            T8 t80 = o80.I;
                            o80.h.g.getClass();
                            V4 v40 = W4.a();
                            v40.a = o80.h.g.a.obtainMessage(20, 0, v1, t80);
                            v40.a();
                            o80.v1(r51, 0, 1, false, !r51.b.a.equals(o80.S.b.a), 4, o80.s1(r51), -1);
                            vb0.a.t1();
                            vb0.a = null;
                        }
                        vb0.f = null;
                        vb0.h = -3.402823E+38f;
                        vb0.i = -3.402823E+38f;
                        vb0.j.clear();
                        vb0.T = false;
                        vb0.U = false;
                        vb0.C = false;
                        vb0.X = null;
                        vb0.K = false;
                        vb0.e.b = false;
                        vb0.c.removeCallbacksAndMessages(null);
                        vb0.e.removeCallbacksAndMessages(null);
                        vb0.a();
                        vb0.x.clear();
                        vb0.O = 0L;
                        vb0.L = false;
                        vb0.N = 0L;
                        vb0.Q = -1;
                        vb0.R = -1;
                        vb0.S = false;
                        goto label_95;
                    }
                }
                throw new IllegalStateException(vb0.n("reset"));
            }
        label_95:
            n0.b(false);
            n0.c.v();
            n0.o = 0;
            n0.n = null;
            n0.p = 0x8000000000000001L;
            n0.q = 0L;
            n0.s = new x9.c(1);
            n0.t = new y5.a[0];
            n0.b.removeCallbacksAndMessages(null);
        }
        this.setPlayerState(Idle.INSTANCE);
        this.preferredBitrate = 0;
        this.setTotalPlayTime(0L);
        this.setMediaTracks(new ArrayList());
        this.mediaTimer.stop();
        this.setCurrentVideoProfile(null);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void seek(int v) {
        n n0 = this.player;
        if(n0 != null) {
            n0.l(v);
        }
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void selectMediaTrack(int v) {
        n n0 = this.player;
        if(n0 != null) {
            n0.m(null, v, false);
        }
    }

    public void setBuffering(boolean z) {
        OnBufferingStateChanged leonPlayerEventListener$OnBufferingStateChanged0 = this.getBufferingStateEventListener();
        if(leonPlayerEventListener$OnBufferingStateChanged0 != null) {
            leonPlayerEventListener$OnBufferingStateChanged0.onChanged(z);
        }
        this.isBuffering = z;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setCurrentVideoProfile(@Nullable LeonVideoProfile leonVideoProfile0) {
        this.currentVideoProfile = leonVideoProfile0;
    }

    public void setCurrentVideoProfiles(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.currentVideoProfiles = list0;
    }

    private final void setDrmInfo(E9.p p0, LeonDrmInfo leonDrmInfo0) {
        String s = leonDrmInfo0.getType();
        if(q.b(s, "widevine")) {
            p0.f("DRM_WIDEVINE_SERVER_URL", leonDrmInfo0.getLicenseUrl());
            p0.f("DRM_WIDEVINE_SERVER_HEADER", leonDrmInfo0.getHeader().toString());
            p0.f("DRM_WIDEVINE_CUSTOMDATA", leonDrmInfo0.getToken());
            return;
        }
        if(q.b(s, "playready")) {
            p0.f("DRM_PLAYREADY_SERVER_URL", leonDrmInfo0.getLicenseUrl());
            p0.f("DRM_PLAYREADY_SERVER_HEADER", leonDrmInfo0.getHeader().toString());
            p0.f("DRM_PLAYREADY_CUSTOMDATA", leonDrmInfo0.getToken());
        }
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setLoop(boolean z) {
        n n0 = this.player;
        if(n0 != null) {
            n0.a("setLooping", new Object[]{Boolean.valueOf(z)});
            Vb vb0 = n0.d;
            if(vb0 != null) {
                Vb vb1 = vb0.J;
                __monitor_enter(vb1);
                int v = FIN.finallyOpen$NT();
                if(vb0.j(new int[]{1, 2, 4, 3, 5, 6, 7, 8})) {
                    FIN.finallyCodeBegin$NT(v);
                    __monitor_exit(vb1);
                    FIN.finallyCodeEnd$NT(v);
                    vb0.B = z;
                }
                else {
                    Log.w("IbisPlayer", vb0.n("setLooping"));
                    FIN.finallyExec$NT(v);
                }
            }
        }
        this.loop = z;
    }

    public void setMediaTracks(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.mediaTracks = list0;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setMute(boolean z) {
        if(z) {
            n n0 = this.player;
            if(n0 != null) {
                n0.p(0.0f);
            }
        }
        else {
            n n1 = this.player;
            if(n1 != null) {
                n1.p(this.getVolume());
            }
        }
        this.mute = z;
    }

    public void setPlayerState(@NotNull LeonPlayerState leonPlayerState0) {
        q.g(leonPlayerState0, "value");
        this.playerState = leonPlayerState0;
        OnPlayerStateChanged leonPlayerEventListener$OnPlayerStateChanged0 = this.getPlayerStateEventListener();
        if(leonPlayerEventListener$OnPlayerStateChanged0 != null) {
            leonPlayerEventListener$OnPlayerStateChanged0.onChanged(leonPlayerState0);
        }
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setRate(int v) {
        if(v < 50) {
            n n0 = this.player;
            if(n0 == null) {
                return;
            }
            n0.o(50);
            return;
        }
        if(v > 200) {
            n n1 = this.player;
            if(n1 == null) {
                return;
            }
            n1.o(200);
            return;
        }
        n n2 = this.player;
        if(n2 == null) {
            return;
        }
        n2.o(v);
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setSurfaceView(@Nullable SurfaceView surfaceView0) {
        this.internalSurfaceView = surfaceView0;
        n n0 = this.player;
        if(n0 != null) {
            n0.n((surfaceView0 == null ? null : surfaceView0.getHolder()));
        }
    }

    @Override  // com.kakaoent.leonplayer.delegate.ThumbnailPreviewDelegate
    public void setThumbnailInfo(@NotNull ThumbnailInfo thumbnailInfo0) {
        q.g(thumbnailInfo0, "thumbnailInfo");
        this.$$delegate_1.setThumbnailInfo(thumbnailInfo0);
    }

    public void setTotalPlayTime(long v) {
        this.totalPlayTime = v;
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setVideoProfileId(@Nullable String s) {
        n n0 = this.player;
        if(n0 != null) {
            MediaPlayer.TrackInfo[] arr_mediaPlayer$TrackInfo = n0.i();
            if(arr_mediaPlayer$TrackInfo != null) {
                int v = 0;
                for(int v1 = 0; v < arr_mediaPlayer$TrackInfo.length; ++v1) {
                    Object object0 = null;
                    MediaPlayer.TrackInfo mediaPlayer$TrackInfo0 = arr_mediaPlayer$TrackInfo[v];
                    if(mediaPlayer$TrackInfo0.c == 1) {
                        if(s == null) {
                            this.setCurrentVideoProfile(null);
                            n n1 = this.player;
                            if(n1 == null) {
                                break;
                            }
                            n1.m(null, v1, false);
                            return;
                        }
                        for(Object object1: this.getCurrentVideoProfiles()) {
                            if(q.b(((LeonVideoProfile)object1).getId(), s)) {
                                object0 = object1;
                                break;
                            }
                            if(false) {
                                break;
                            }
                        }
                        if(((LeonVideoProfile)object0) == null) {
                            break;
                        }
                        this.setCurrentVideoProfile(((LeonVideoProfile)object0));
                        ArrayList arrayList0 = new ArrayList();
                        MediaPlayer.TrackRepresentation[] arr_mediaPlayer$TrackRepresentation = mediaPlayer$TrackInfo0.g;
                        q.f(arr_mediaPlayer$TrackRepresentation, "trackRepresentation");
                        int v2 = 0;
                        for(int v3 = 0; v2 < arr_mediaPlayer$TrackRepresentation.length; ++v3) {
                            int v4 = arr_mediaPlayer$TrackRepresentation[v2].b.h;
                            if(v4 == -1) {
                                v4 = 0;
                            }
                            if(v4 <= ((LeonVideoProfile)object0).getBitrate()) {
                                arrayList0.add(v3);
                            }
                            ++v2;
                        }
                        n n2 = this.player;
                        if(n2 == null) {
                            break;
                        }
                        n2.m(p.O0(arrayList0), v1, true);
                        return;
                    }
                    ++v;
                }
            }
        }
    }

    @Override  // com.kakaoent.leonplayer.core.LeonPlayer
    public void setVolume(float f) {
        if(f < 0.0f) {
            this.setVolumeInternal(0.0f);
            return;
        }
        if(f > 1.0f) {
            this.setVolumeInternal(1.0f);
            return;
        }
        this.setVolumeInternal(f);
    }

    private final void setVolumeInternal(float f) {
        n n0 = this.player;
        if(n0 != null) {
            n0.p(f);
        }
        this.currentVolume = f;
    }
}

