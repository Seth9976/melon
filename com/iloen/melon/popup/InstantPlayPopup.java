package com.iloen.melon.popup;

import A7.d;
import De.I;
import J8.I2;
import Tf.o;
import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.MarqueeTextView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.U0;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.StreamGetPathReq.ParamInfo;
import com.iloen.melon.net.v4x.request.StreamGetPathReq;
import com.iloen.melon.playback.IPlayer;
import com.iloen.melon.playback.IPlayerEventListener;
import com.iloen.melon.playback.OemMusicPlayer;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayableAlbumExtensionsKt;
import com.iloen.melon.playback.PlayableAlbumUriData;
import com.iloen.melon.playback.PlayerKind;
import com.iloen.melon.playback.PlayerPOCHelper;
import com.iloen.melon.playback.PlayerState;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.MelonBlurTransformation;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import he.b;
import he.e;
import ie.H;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import je.w;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0004PQROB\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0011\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u001B\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00132\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u000E\u0010\u001A\u001A\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001F\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u0019\u0010!\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b!\u0010\u0012J\u0019\u0010\"\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\"\u0010\u0012J)\u0010%\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010#\u001A\u00020\u00132\u0006\u0010$\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b%\u0010&JC\u0010-\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010(\u001A\u0004\u0018\u00010\'2\u0006\u0010)\u001A\u00020\u00132\u0006\u0010*\u001A\u00020\u00132\u0006\u0010+\u001A\u00020\u00132\u0006\u0010,\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b-\u0010.J+\u00104\u001A\u0002032\u0006\u00100\u001A\u00020/2\b\u00102\u001A\u0004\u0018\u0001012\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b4\u00105J\r\u00106\u001A\u00020\u001D\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b8\u0010\u000EJ\u000F\u00109\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b9\u0010\u000EJ\u0017\u0010<\u001A\u00020\f2\u0006\u0010;\u001A\u00020:H\u0016\u00A2\u0006\u0004\b<\u0010=J!\u0010A\u001A\u00020\f2\u0006\u0010?\u001A\u00020>2\b\u0010@\u001A\u0004\u0018\u00010\u0016H\u0016\u00A2\u0006\u0004\bA\u0010BR$\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bC\u0010D\u001A\u0004\bE\u0010F\"\u0004\bG\u0010\u0006R\"\u0010I\u001A\u00020H8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bI\u0010J\u001A\u0004\bK\u0010L\"\u0004\bM\u0010N\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/popup/InstantPlayPopup;", "Landroidx/fragment/app/w;", "Lcom/iloen/melon/playback/IPlayerEventListener;", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(Lcom/iloen/melon/playback/Playable;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lie/H;", "onDestroyView", "()V", "Lcom/iloen/melon/playback/IPlayer;", "player", "onPrepared", "(Lcom/iloen/melon/playback/IPlayer;)V", "", "what", "extra", "", "msg", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onError", "(Lcom/iloen/melon/playback/IPlayer;IILjava/lang/String;Ljava/lang/Exception;)V", "", "isBuffering", "onBufferingChange", "(Z)V", "onCompletion", "onSeekComplete", "width", "height", "onDisplayChange", "(Lcom/iloen/melon/playback/IPlayer;II)V", "", "pcm", "pcm_size", "channels", "samplerate", "samplefmt", "onPcm", "(Lcom/iloen/melon/playback/IPlayer;[BIIII)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "isShowing", "()Z", "onStart", "onStop", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroidx/fragment/app/l0;", "manager", "tag", "show", "(Landroidx/fragment/app/l0;Ljava/lang/String;)V", "f", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "()Lcom/iloen/melon/playback/Playable;", "setPlayable", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Companion", "AudioFocusHelper", "UiHandler", "Lyric", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InstantPlayPopup extends Hilt_InstantPlayPopup implements IPlayerEventListener {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\t\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/popup/InstantPlayPopup$AudioFocusHelper;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "<init>", "(Lcom/iloen/melon/popup/InstantPlayPopup;)V", "Lie/H;", "init", "()V", "destroy", "requestFocus", "abandonFocus", "", "focusChange", "onAudioFocusChange", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AudioFocusHelper implements AudioManager.OnAudioFocusChangeListener {
        public AudioManager a;
        public AudioAttributes b;
        public AudioFocusRequest c;
        public final InstantPlayPopup d;

        public final void abandonFocus() {
            AudioManager audioManager0 = this.a;
            if(audioManager0 != null) {
                audioManager0.abandonAudioFocus(null);
            }
        }

        public final void destroy() {
            this.abandonFocus();
        }

        public final void init() {
            this.a = (AudioManager)InstantPlayPopup.this.requireContext().getSystemService("audio");
            this.b = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
            AudioFocusRequest.Builder audioFocusRequest$Builder0 = new AudioFocusRequest.Builder(2);
            AudioAttributes audioAttributes0 = this.b;
            q.d(audioAttributes0);
            this.c = audioFocusRequest$Builder0.setAudioAttributes(audioAttributes0).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
        }

        @Override  // android.media.AudioManager$OnAudioFocusChangeListener
        public void onAudioFocusChange(int v) {
            if(v != -2 && v != -1) {
                return;
            }
            InstantPlayPopup.this.h = true;
            InstantPlayPopup.this.dismiss();
        }

        public final void requestFocus() {
            AudioFocusRequest audioFocusRequest0 = this.c;
            if(audioFocusRequest0 != null) {
                AudioManager audioManager0 = this.a;
                if(audioManager0 != null) {
                    audioManager0.requestAudioFocus(audioFocusRequest0);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/popup/InstantPlayPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "MAX_PLAY_POSITION", "I", "MAX_PLAY_LENGTH", "", "POST_DELAY", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u001D\b\u0082\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007\u0012\b\b\u0002\u0010\n\u001A\u00020\u0007\u0012\b\b\u0002\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001A\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJT\u0010\u001C\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\b\b\u0002\u0010\n\u001A\u00020\u00072\b\b\u0002\u0010\f\u001A\u00020\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001EH\u00D6\u0001\u00A2\u0006\u0004\b\u001F\u0010 J\u0010\u0010!\u001A\u00020\u000BH\u00D6\u0001\u00A2\u0006\u0004\b!\u0010\u001BJ\u001A\u0010$\u001A\u00020#2\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R$\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010\u0013\"\u0004\b)\u0010*R(\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b+\u0010,\u001A\u0004\b-\u0010\u0015\"\u0004\b.\u0010/R\"\u0010\b\u001A\u00020\u00078\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b2\u0010\u0017\"\u0004\b3\u00104R\"\u0010\t\u001A\u00020\u00078\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b5\u00101\u001A\u0004\b6\u0010\u0017\"\u0004\b7\u00104R\"\u0010\n\u001A\u00020\u00078\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b8\u00101\u001A\u0004\b9\u0010\u0017\"\u0004\b:\u00104R\"\u0010\f\u001A\u00020\u000B8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b;\u0010<\u001A\u0004\b=\u0010\u001B\"\u0004\b>\u0010?\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/popup/InstantPlayPopup$Lyric;", "", "Lcom/iloen/melon/playback/Playable;", "playable", "", "Lcom/iloen/melon/lyric/LyricsInfo;", "lyricsInfoList", "", "lastTime", "preLyricTime", "currentLyricTime", "", "currentIndex", "<init>", "(Lcom/iloen/melon/playback/Playable;Ljava/util/List;JJJI)V", "Lie/H;", "reset", "()V", "component1", "()Lcom/iloen/melon/playback/Playable;", "component2", "()Ljava/util/List;", "component3", "()J", "component4", "component5", "component6", "()I", "copy", "(Lcom/iloen/melon/playback/Playable;Ljava/util/List;JJJI)Lcom/iloen/melon/popup/InstantPlayPopup$Lyric;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "setPlayable", "(Lcom/iloen/melon/playback/Playable;)V", "b", "Ljava/util/List;", "getLyricsInfoList", "setLyricsInfoList", "(Ljava/util/List;)V", "c", "J", "getLastTime", "setLastTime", "(J)V", "d", "getPreLyricTime", "setPreLyricTime", "e", "getCurrentLyricTime", "setCurrentLyricTime", "f", "I", "getCurrentIndex", "setCurrentIndex", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class Lyric {
        public Playable a;
        public List b;
        public long c;
        public long d;
        public long e;
        public int f;

        public Lyric() {
            this(null, null, 0L, 0L, 0L, 0, 0x3F, null);
        }

        public Lyric(@Nullable Playable playable0, @NotNull List list0, long v, long v1, long v2, int v3) {
            q.g(list0, "lyricsInfoList");
            super();
            this.a = playable0;
            this.b = list0;
            this.c = v;
            this.d = v1;
            this.e = v2;
            this.f = v3;
        }

        public Lyric(Playable playable0, List list0, long v, long v1, long v2, int v3, int v4, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v4 & 1) != 0) {
                playable0 = null;
            }
            if((v4 & 2) != 0) {
                list0 = w.a;
            }
            if((v4 & 4) != 0) {
                v = 0L;
            }
            if((v4 & 8) != 0) {
                v1 = 0L;
            }
            if((v4 & 16) != 0) {
                v2 = 0L;
            }
            if((v4 & 0x20) != 0) {
                v3 = 0;
            }
            this(playable0, list0, v, v1, v2, v3);
        }

        @Nullable
        public final Playable component1() {
            return this.a;
        }

        @NotNull
        public final List component2() {
            return this.b;
        }

        public final long component3() {
            return this.c;
        }

        public final long component4() {
            return this.d;
        }

        public final long component5() {
            return this.e;
        }

        public final int component6() {
            return this.f;
        }

        @NotNull
        public final Lyric copy(@Nullable Playable playable0, @NotNull List list0, long v, long v1, long v2, int v3) {
            q.g(list0, "lyricsInfoList");
            return new Lyric(playable0, list0, v, v1, v2, v3);
        }

        public static Lyric copy$default(Lyric instantPlayPopup$Lyric0, Playable playable0, List list0, long v, long v1, long v2, int v3, int v4, Object object0) {
            if((v4 & 1) != 0) {
                playable0 = instantPlayPopup$Lyric0.a;
            }
            if((v4 & 2) != 0) {
                list0 = instantPlayPopup$Lyric0.b;
            }
            if((v4 & 4) != 0) {
                v = instantPlayPopup$Lyric0.c;
            }
            if((v4 & 8) != 0) {
                v1 = instantPlayPopup$Lyric0.d;
            }
            if((v4 & 16) != 0) {
                v2 = instantPlayPopup$Lyric0.e;
            }
            if((v4 & 0x20) != 0) {
                v3 = instantPlayPopup$Lyric0.f;
            }
            return instantPlayPopup$Lyric0.copy(playable0, list0, v, v1, v2, v3);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Lyric)) {
                return false;
            }
            if(!q.b(this.a, ((Lyric)object0).a)) {
                return false;
            }
            if(!q.b(this.b, ((Lyric)object0).b)) {
                return false;
            }
            if(this.c != ((Lyric)object0).c) {
                return false;
            }
            if(this.d != ((Lyric)object0).d) {
                return false;
            }
            return this.e == ((Lyric)object0).e ? this.f == ((Lyric)object0).f : false;
        }

        public final int getCurrentIndex() {
            return this.f;
        }

        public final long getCurrentLyricTime() {
            return this.e;
        }

        public final long getLastTime() {
            return this.c;
        }

        @NotNull
        public final List getLyricsInfoList() {
            return this.b;
        }

        @Nullable
        public final Playable getPlayable() {
            return this.a;
        }

        public final long getPreLyricTime() {
            return this.d;
        }

        @Override
        public int hashCode() {
            return this.a == null ? this.f + d.c(d.c(d.c(d.d(0, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e) : this.f + d.c(d.c(d.c(d.d(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
        }

        public final void reset() {
            this.f = 0;
            this.e = 0L;
            this.d = 0L;
        }

        public final void setCurrentIndex(int v) {
            this.f = v;
        }

        public final void setCurrentLyricTime(long v) {
            this.e = v;
        }

        public final void setLastTime(long v) {
            this.c = v;
        }

        public final void setLyricsInfoList(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.b = list0;
        }

        public final void setPlayable(@Nullable Playable playable0) {
            this.a = playable0;
        }

        public final void setPreLyricTime(long v) {
            this.d = v;
        }

        @Override
        @NotNull
        public String toString() {
            Playable playable0 = this.a;
            List list0 = this.b;
            long v = this.c;
            long v1 = this.d;
            long v2 = this.e;
            int v3 = this.f;
            StringBuilder stringBuilder0 = new StringBuilder("Lyric(playable=");
            stringBuilder0.append(playable0);
            stringBuilder0.append(", lyricsInfoList=");
            stringBuilder0.append(list0);
            stringBuilder0.append(", lastTime=");
            stringBuilder0.append(v);
            a.s(v1, ", preLyricTime=", ", currentLyricTime=", stringBuilder0);
            stringBuilder0.append(v2);
            stringBuilder0.append(", currentIndex=");
            stringBuilder0.append(v3);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001A\u00020\b2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\b¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/popup/InstantPlayPopup$UiHandler;", "Lcom/iloen/melon/custom/U0;", "Lcom/iloen/melon/popup/InstantPlayPopup;", "ref", "<init>", "(Lcom/iloen/melon/popup/InstantPlayPopup;)V", "Landroid/os/Message;", "msg", "Lie/H;", "handleMessage", "(Lcom/iloen/melon/popup/InstantPlayPopup;Landroid/os/Message;)V", "", "delayMillis", "requestUpdateLyric", "(J)V", "removeLyricMessage", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class UiHandler extends U0 {
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/popup/InstantPlayPopup$UiHandler$Companion;", "", "", "MSG_SHOW_LYRIC", "I", "MSG_UPDATE_LYRIC", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.popup.InstantPlayPopup.UiHandler.Companion {
            public com.iloen.melon.popup.InstantPlayPopup.UiHandler.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.iloen.melon.popup.InstantPlayPopup.UiHandler.Companion Companion = null;
        public static final int MSG_SHOW_LYRIC = 1000;
        public static final int MSG_UPDATE_LYRIC = 1001;

        static {
            UiHandler.Companion = new com.iloen.melon.popup.InstantPlayPopup.UiHandler.Companion(null);
        }

        public UiHandler(@NotNull InstantPlayPopup instantPlayPopup0) {
            q.g(instantPlayPopup0, "ref");
            super(instantPlayPopup0);
        }

        public void handleMessage(@Nullable InstantPlayPopup instantPlayPopup0, @Nullable Message message0) {
            Integer integer0 = message0 == null ? null : message0.what;
            if(integer0 != null && ((int)integer0) == 1000) {
                if(instantPlayPopup0 != null) {
                    InstantPlayPopup.access$toggleSongLyricLayout(instantPlayPopup0, true);
                }
            }
            else if(integer0 != null && ((int)integer0) == 1001 && instantPlayPopup0 != null && InstantPlayPopup.access$updateLyric(instantPlayPopup0, false)) {
                this.requestUpdateLyric(500L);
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((InstantPlayPopup)object0), message0);
        }

        public final void removeLyricMessage() {
            if(this.hasMessages(1000)) {
                this.removeMessages(1000);
            }
            if(this.hasMessages(1001)) {
                this.removeMessages(1001);
            }
        }

        public final void requestUpdateLyric(long v) {
            if(this.hasMessages(1001)) {
                this.removeMessages(1001);
            }
            this.sendMessageDelayed(this.obtainMessage(1001), v);
        }
    }

    public static final int $stable = 0;
    public I2 B;
    @NotNull
    public static final Companion Companion = null;
    public final y D;
    @NotNull
    public static final String TAG = "InstantPlayPopup";
    public Playable f;
    public boolean g;
    public boolean h;
    public Handler i;
    public com.iloen.melon.popup.w j;
    public OemMusicPlayer k;
    public PlayerState l;
    public AudioFocusHelper m;
    public String n;
    public final UiHandler o;
    @Inject
    public z playerUseCase;
    public final Lyric r;
    public boolean w;

    static {
        InstantPlayPopup.Companion = new Companion(null);
        InstantPlayPopup.$stable = 8;
    }

    public InstantPlayPopup(@Nullable Playable playable0) {
        this.f = playable0;
        this.l = PlayerState.End;
        this.o = new UiHandler(this);
        this.r = new Lyric(null, null, 0L, 0L, 0L, 0, 0x3F, null);
        this.D = new y(this, 0);
        this.l = PlayerState.Idle;
    }

    public static final I2 access$getBinding(InstantPlayPopup instantPlayPopup0) {
        I2 i20 = instantPlayPopup0.B;
        q.d(i20);
        return i20;
    }

    public static final void access$toggleSongLyricLayout(InstantPlayPopup instantPlayPopup0, boolean z) {
        if(!z) {
            I2 i20 = instantPlayPopup0.B;
            q.d(i20);
            i20.c.setVisibility(8);
            return;
        }
        I2 i21 = instantPlayPopup0.B;
        q.d(i21);
        i21.c.setVisibility(0);
    }

    public static final boolean access$updateLyric(InstantPlayPopup instantPlayPopup0, boolean z) {
        Lyric instantPlayPopup$Lyric0 = instantPlayPopup0.r;
        int v = 0;
        if(q.b(instantPlayPopup0.f, instantPlayPopup$Lyric0.getPlayable())) {
            Collection collection0 = instantPlayPopup$Lyric0.getLyricsInfoList();
            if(collection0 == null || collection0.isEmpty()) {
                I2 i28 = instantPlayPopup0.B;
                q.d(i28);
                String s6 = instantPlayPopup0.getString(0x7F13038E);  // string:empty_lyrics "등록된 가사가 없습니다"
                i28.j.setText(s6);
                I2 i29 = instantPlayPopup0.B;
                q.d(i29);
                int v4 = ColorUtils.getColor(instantPlayPopup0.getContext(), 0x7F060194);  // color:instant_play_lyric_text
                i29.j.setTextColor(v4);
                return false;
            }
            else if(!instantPlayPopup$Lyric0.getLyricsInfoList().isEmpty()) {
                if(instantPlayPopup0.w) {
                    I2 i20 = instantPlayPopup0.B;
                    q.d(i20);
                    String s = ((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(0)).b;
                    i20.j.setText(s);
                    I2 i21 = instantPlayPopup0.B;
                    q.d(i21);
                    int v1 = ColorUtils.getColor(instantPlayPopup0.getContext(), 0x7F060194);  // color:instant_play_lyric_text
                    i21.j.setTextColor(v1);
                    I2 i22 = instantPlayPopup0.B;
                    q.d(i22);
                    String s1 = instantPlayPopup$Lyric0.getLyricsInfoList().size() <= 1 ? "" : ((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(1)).b;
                    i22.k.setText(s1);
                    I2 i23 = instantPlayPopup0.B;
                    q.d(i23);
                    i23.k.setVisibility(0);
                    I2 i24 = instantPlayPopup0.B;
                    q.d(i24);
                    i24.g.setVisibility(0);
                    return true;
                }
                OemMusicPlayer oemMusicPlayer0 = instantPlayPopup0.k;
                if(oemMusicPlayer0 != null) {
                    v = oemMusicPlayer0.getCurrentPosition();
                }
                if(Math.abs(((long)v) - instantPlayPopup$Lyric0.getLastTime()) > 1000L) {
                    instantPlayPopup$Lyric0.reset();
                }
                instantPlayPopup$Lyric0.setLastTime(((long)v));
                if(z || instantPlayPopup$Lyric0.getLastTime() >= instantPlayPopup$Lyric0.getCurrentLyricTime()) {
                    if(z) {
                        instantPlayPopup$Lyric0.setPreLyricTime(0L);
                    }
                    int v2 = instantPlayPopup$Lyric0.getCurrentIndex();
                    int v3 = instantPlayPopup$Lyric0.getLyricsInfoList().size();
                    while(v2 < v3) {
                        instantPlayPopup$Lyric0.setCurrentLyricTime(((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(v2)).a);
                        if(((long)v) < instantPlayPopup$Lyric0.getCurrentLyricTime() && instantPlayPopup$Lyric0.getPreLyricTime() <= ((long)v)) {
                            String s2 = null;
                            instantPlayPopup$Lyric0.setPreLyricTime(instantPlayPopup$Lyric0.getCurrentLyricTime());
                            instantPlayPopup$Lyric0.setCurrentIndex(v2);
                            if(v2 > 0) {
                                I2 i25 = instantPlayPopup0.B;
                                q.d(i25);
                                String s3 = ((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(v2 - 1)).b;
                                i25.j.setText(s3);
                                I2 i26 = instantPlayPopup0.B;
                                q.d(i26);
                                String s4 = ((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(v2)).b;
                                i26.k.setText(s4);
                                return true;
                            }
                            String s5 = instantPlayPopup$Lyric0.getPlayable() == null ? null : "";
                            if(instantPlayPopup$Lyric0.getPlayable() != null) {
                                s2 = "";
                            }
                            I2 i27 = instantPlayPopup0.B;
                            q.d(i27);
                            i27.j.setText(s5 + " - " + s2);
                            return true;
                        }
                        ++v2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final Playable getPlayable() {
        return this.f;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    public final boolean isShowing() {
        Dialog dialog0 = this.getDialog();
        return dialog0 != null && dialog0.isShowing();
    }

    public final void n(Configuration configuration0) {
        int v = ViewUtilsKt.dpToPx((1 == configuration0.orientation ? 204 : 0x74));
        I2 i20 = this.B;
        q.d(i20);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(v, v);
        i20.b.setLayoutParams(linearLayout$LayoutParams0);
        int v1 = this.requireContext().getResources().getDimensionPixelSize(0x7F070124);  // dimen:instant_play_popup_width
        int v2 = ViewUtilsKt.dpToPx((1 == configuration0.orientation ? 382 : 294));
        I2 i21 = this.B;
        q.d(i21);
        FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(v1, v2);
        i21.f.setLayoutParams(frameLayout$LayoutParams0);
        I2 i22 = this.B;
        q.d(i22);
        i22.i.setLayoutParams(new LinearLayout.LayoutParams(v1, ViewUtilsKt.dpToPx((1 == configuration0.orientation ? 0xF8 : 0xB2))));
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onBufferingChange(boolean z) {
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onCompletion(@Nullable IPlayer iPlayer0) {
        this.l = PlayerState.PlaybackCompleted;
        this.dismiss();
    }

    @Override  // androidx.fragment.app.I
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.n(configuration0);
    }

    @Override  // androidx.fragment.app.w
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle0) {
        this.setStyle(0, 0x7F140298);  // style:Theme.AppCompat.Dialog
        View view0 = LayoutInflater.from(this.requireContext()).inflate(0x7F0D05AA, null, false);  // layout:popup_instant_play
        int v = 0x7F0A0080;  // id:album_art_layout
        View view1 = I.C(view0, 0x7F0A0080);  // id:album_art_layout
        if(((FrameLayout)view1) != null) {
            v = 0x7F0A032E;  // id:container_lyrics
            View view2 = I.C(view0, 0x7F0A032E);  // id:container_lyrics
            if(((LinearLayout)view2) != null) {
                v = 0x7F0A055E;  // id:img_bg
                View view3 = I.C(view0, 0x7F0A055E);  // id:img_bg
                if(((MelonImageView)view3) != null) {
                    v = 0x7F0A06A5;  // id:iv_thumbnail
                    View view4 = I.C(view0, 0x7F0A06A5);  // id:iv_thumbnail
                    if(((MelonImageView)view4) != null && ((ImageView)I.C(view0, 0x7F0A06A6)) != null) {  // id:iv_thumbnail_bg
                        v = 0x7F0A0710;  // id:layout_container
                        View view5 = I.C(view0, 0x7F0A0710);  // id:layout_container
                        if(((RelativeLayout)view5) != null) {
                            v = 0x7F0A07BC;  // id:lyric_gap
                            View view6 = I.C(view0, 0x7F0A07BC);  // id:lyric_gap
                            if(view6 != null) {
                                v = 0x7F0A0982;  // id:progress_bg
                                View view7 = I.C(view0, 0x7F0A0982);  // id:progress_bg
                                if(((FrameLayout)view7) != null) {
                                    v = 0x7F0A0987;  // id:progress_layout
                                    View view8 = I.C(view0, 0x7F0A0987);  // id:progress_layout
                                    if(((RelativeLayout)view8) != null && ((LinearLayout)I.C(view0, 0x7F0A0B9E)) != null) {  // id:title_layout
                                        v = 0x7F0A0CAA;  // id:tv_lyric_current
                                        View view9 = I.C(view0, 0x7F0A0CAA);  // id:tv_lyric_current
                                        if(((MelonTextView)view9) != null) {
                                            v = 0x7F0A0CAB;  // id:tv_lyric_next
                                            View view10 = I.C(view0, 0x7F0A0CAB);  // id:tv_lyric_next
                                            if(((MelonTextView)view10) != null) {
                                                v = 0x7F0A0D38;  // id:tv_title_artist
                                                View view11 = I.C(view0, 0x7F0A0D38);  // id:tv_title_artist
                                                if(((MarqueeTextView)view11) != null) {
                                                    v = 0x7F0A0D3E;  // id:tv_title_song
                                                    View view12 = I.C(view0, 0x7F0A0D3E);  // id:tv_title_song
                                                    if(((MarqueeTextView)view12) != null) {
                                                        this.B = new I2(((FrameLayout)view0), ((FrameLayout)view1), ((LinearLayout)view2), ((MelonImageView)view3), ((MelonImageView)view4), ((RelativeLayout)view5), view6, ((FrameLayout)view7), ((RelativeLayout)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((MarqueeTextView)view11), ((MarqueeTextView)view12));
                                                        Dialog dialog0 = super.onCreateDialog(bundle0);
                                                        q.f(dialog0, "onCreateDialog(...)");
                                                        return dialog0;
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

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
        I2 i20 = this.B;
        q.d(i20);
        i20.m.setText((this.f == null ? null : ""));
        I2 i21 = this.B;
        q.d(i21);
        i21.l.setText((this.f == null ? null : ""));
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final InstantPlayPopup w;

            {
                this.w = instantPlayPopup0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.popup.InstantPlayPopup.onCreateView.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.popup.InstantPlayPopup.onCreateView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                InstantPlayPopup instantPlayPopup0 = this.w;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        this.r = 1;
                        object0 = PlayableAlbumExtensionsKt.getAlbumUri(instantPlayPopup0.getPlayable(), false, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                String s = instantPlayPopup0.n;
                if(s == null || o.H0(s)) {
                    instantPlayPopup0.n = ((PlayableAlbumUriData)object0).getLargeAlbumUri().toString();
                }
                Glide.with(instantPlayPopup0.requireContext()).load(instantPlayPopup0.n).into(InstantPlayPopup.access$getBinding(instantPlayPopup0).e);
                e e0 = new e(ScreenUtils.dipToPixel(instantPlayPopup0.getContext(), 6.0f), RoundedCornersTransformation.CornerType.ALL);
                MelonBlurTransformation melonBlurTransformation0 = new MelonBlurTransformation(Glide.get(instantPlayPopup0.requireContext()).getBitmapPool(), 100, 2);
                b b0 = new b(ColorUtils.getColor(instantPlayPopup0.getContext(), 0x7F06003F));  // color:black_60
                CenterCrop centerCrop0 = new CenterCrop();
                Glide.with(instantPlayPopup0.requireContext()).asBitmap().load(((PlayableAlbumUriData)object0).getSmallAlbumUri()).apply(new RequestOptions().transform(new Transformation[]{centerCrop0, melonBlurTransformation0, b0, e0})).into(InstantPlayPopup.access$getBinding(instantPlayPopup0).d);
                return H.a;
            }
        }, 3, null);
        Configuration configuration0 = this.requireContext().getResources().getConfiguration();
        q.f(configuration0, "getConfiguration(...)");
        this.n(configuration0);
        I2 i22 = this.B;
        q.d(i22);
        q.f(i22.a, "getRoot(...)");
        return i22.a;
    }

    @Override  // androidx.fragment.app.w
    public void onDestroyView() {
        super.onDestroyView();
        this.B = null;
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onDisplayChange(@Nullable IPlayer iPlayer0, int v, int v1) {
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onError(@Nullable IPlayer iPlayer0, int v, int v1, @Nullable String s, @Nullable Exception exception0) {
        this.l = PlayerState.Error;
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onPcm(@Nullable IPlayer iPlayer0, @Nullable byte[] arr_b, int v, int v1, int v2, int v3) {
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onPrepared(@Nullable IPlayer iPlayer0) {
        AudioFocusHelper instantPlayPopup$AudioFocusHelper0 = this.m;
        if(instantPlayPopup$AudioFocusHelper0 != null) {
            instantPlayPopup$AudioFocusHelper0.requestFocus();
        }
        this.l = PlayerState.Prepared;
        if((iPlayer0 == null ? 0 : iPlayer0.getDuration()) >= 60000 && iPlayer0 != null) {
            iPlayer0.seekTo(30000);
        }
        if(iPlayer0 != null) {
            iPlayer0.play();
        }
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onSeekComplete(@Nullable IPlayer iPlayer0) {
    }

    @Override  // androidx.fragment.app.w
    public void onStart() {
        super.onStart();
        AudioFocusHelper instantPlayPopup$AudioFocusHelper0 = new AudioFocusHelper(this);
        instantPlayPopup$AudioFocusHelper0.init();
        this.m = instantPlayPopup$AudioFocusHelper0;
        F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        Handler handler0 = new Handler(Looper.getMainLooper());
        this.i = handler0;
        com.iloen.melon.popup.w w0 = new com.iloen.melon.popup.w(this, f0);
        this.j = w0;
        handler0.post(w0);
        if(this.getPlayerUseCase().n()) {
            this.getPlayerUseCase().s();
            this.g = true;
        }
        ParamInfo streamGetPathReq$ParamInfo0 = new ParamInfo();
        String s = null;
        streamGetPathReq$ParamInfo0.cid = this.f == null ? null : "";
        Playable playable0 = this.f;
        if(playable0 != null) {
            CType cType0 = playable0.getCtype();
            if(cType0 != null) {
                s = cType0.getValue();
            }
        }
        streamGetPathReq$ParamInfo0.cType = s;
        streamGetPathReq$ParamInfo0.preYn = "Y";
        String s1 = this.getString(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        q.f(s1, "getString(...)");
        RequestBuilder.newInstance(new StreamGetPathReq(this.getContext(), PlayerPOCHelper.getPOCValue(PlayerKind.InstantPlayer), PlayerKind.InstantPlayer, streamGetPathReq$ParamInfo0)).tag("InstantPlayPopup").listener(new x(this, s1)).errorListener(new x(s1, this)).request();
    }

    @Override  // androidx.fragment.app.w
    public void onStop() {
        super.onStop();
        if(this.g && !this.h) {
            this.getPlayerUseCase().u();
        }
        AudioFocusHelper instantPlayPopup$AudioFocusHelper0 = this.m;
        if(instantPlayPopup$AudioFocusHelper0 != null) {
            instantPlayPopup$AudioFocusHelper0.abandonFocus();
        }
        AudioFocusHelper instantPlayPopup$AudioFocusHelper1 = this.m;
        if(instantPlayPopup$AudioFocusHelper1 != null) {
            instantPlayPopup$AudioFocusHelper1.destroy();
        }
        this.m = null;
        this.o.removeLyricMessage();
        com.iloen.melon.popup.w w0 = this.j;
        if(w0 != null) {
            Handler handler0 = this.i;
            if(handler0 != null) {
                handler0.removeCallbacks(w0);
            }
        }
        this.i = null;
        this.j = null;
        OemMusicPlayer oemMusicPlayer0 = this.k;
        if(oemMusicPlayer0 != null) {
            oemMusicPlayer0.stop();
        }
        this.l = PlayerState.Stopped;
        OemMusicPlayer oemMusicPlayer1 = this.k;
        if(oemMusicPlayer1 != null) {
            oemMusicPlayer1.release();
            this.k = null;
        }
        OemMusicPlayer oemMusicPlayer2 = this.k;
        if(oemMusicPlayer2 != null) {
            oemMusicPlayer2.release();
            this.k = null;
        }
        this.dismissAllowingStateLoss();
    }

    public final void setPlayable(@Nullable Playable playable0) {
        this.f = playable0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    @Override  // androidx.fragment.app.w
    public void show(@NotNull l0 l00, @Nullable String s) {
        q.g(l00, "manager");
        if(this.f != null && this.f.isService()) {
            super.show(l00, s);
        }
    }
}

