package com.iloen.melon.playback.playlist.add;

import U4.x;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.system.ToastManager;
import i.n.i.b.a.s.e.M3;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import oc.X;
import oc.Y;
import oc.a0;
import oc.b0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\r\u000EB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001A\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\f\u0082\u0001\u0002\u000F\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddResult;", "", "<init>", "()V", "Lcom/iloen/melon/playback/playlist/add/AddAction;", "addAction", "Lie/H;", "handleToast", "(Lcom/iloen/melon/playback/playlist/add/AddAction;)V", "", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "notUsedDefaultSuccessToastPlaylist", "Ljava/util/Set;", "Success", "Failure", "Lcom/iloen/melon/playback/playlist/add/AddResult$Failure;", "Lcom/iloen/melon/playback/playlist/add/AddResult$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class AddResult {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddResult$Failure;", "Lcom/iloen/melon/playback/playlist/add/AddResult;", "type", "Lcom/iloen/melon/playback/playlist/add/AddFailType;", "<init>", "(Lcom/iloen/melon/playback/playlist/add/AddFailType;)V", "getType", "()Lcom/iloen/melon/playback/playlist/add/AddFailType;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Failure extends AddResult {
        public static final int $stable = 8;
        @NotNull
        private final AddFailType type;

        public Failure(@NotNull AddFailType addFailType0) {
            q.g(addFailType0, "type");
            super(null);
            this.type = addFailType0;
        }

        @NotNull
        public final AddFailType getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ0\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000FJ\u0010\u0010\u0014\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001AR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001B\u001A\u0004\b\u001C\u0010\u000BR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001D\u001A\u0004\b\u001E\u0010\rR\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001F\u001A\u0004\b \u0010\u000F¨\u0006!"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddResult$Success;", "Lcom/iloen/melon/playback/playlist/add/AddResult;", "Loc/b0;", "requestAddResult", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "extra", "", "extraMsg", "<init>", "(Loc/b0;Lcom/iloen/melon/playback/playlist/add/SuccessExtra;Ljava/lang/String;)V", "component1", "()Loc/b0;", "component2", "()Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "component3", "()Ljava/lang/String;", "copy", "(Loc/b0;Lcom/iloen/melon/playback/playlist/add/SuccessExtra;Ljava/lang/String;)Lcom/iloen/melon/playback/playlist/add/AddResult$Success;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Loc/b0;", "getRequestAddResult", "Lcom/iloen/melon/playback/playlist/add/SuccessExtra;", "getExtra", "Ljava/lang/String;", "getExtraMsg", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success extends AddResult {
        public static final int $stable = 8;
        @NotNull
        private final SuccessExtra extra;
        @Nullable
        private final String extraMsg;
        @NotNull
        private final b0 requestAddResult;

        public Success(@NotNull b0 b00, @NotNull SuccessExtra successExtra0, @Nullable String s) {
            q.g(b00, "requestAddResult");
            q.g(successExtra0, "extra");
            super(null);
            this.requestAddResult = b00;
            this.extra = successExtra0;
            this.extraMsg = s;
        }

        public Success(b0 b00, SuccessExtra successExtra0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                s = null;
            }
            this(b00, successExtra0, s);
        }

        @NotNull
        public final b0 component1() {
            return this.requestAddResult;
        }

        @NotNull
        public final SuccessExtra component2() {
            return this.extra;
        }

        @Nullable
        public final String component3() {
            return this.extraMsg;
        }

        @NotNull
        public final Success copy(@NotNull b0 b00, @NotNull SuccessExtra successExtra0, @Nullable String s) {
            q.g(b00, "requestAddResult");
            q.g(successExtra0, "extra");
            return new Success(b00, successExtra0, s);
        }

        public static Success copy$default(Success addResult$Success0, b0 b00, SuccessExtra successExtra0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                b00 = addResult$Success0.requestAddResult;
            }
            if((v & 2) != 0) {
                successExtra0 = addResult$Success0.extra;
            }
            if((v & 4) != 0) {
                s = addResult$Success0.extraMsg;
            }
            return addResult$Success0.copy(b00, successExtra0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Success)) {
                return false;
            }
            if(!q.b(this.requestAddResult, ((Success)object0).requestAddResult)) {
                return false;
            }
            return q.b(this.extra, ((Success)object0).extra) ? q.b(this.extraMsg, ((Success)object0).extraMsg) : false;
        }

        @NotNull
        public final SuccessExtra getExtra() {
            return this.extra;
        }

        @Nullable
        public final String getExtraMsg() {
            return this.extraMsg;
        }

        @NotNull
        public final b0 getRequestAddResult() {
            return this.requestAddResult;
        }

        @Override
        public int hashCode() {
            int v = this.requestAddResult.hashCode();
            int v1 = this.extra.hashCode();
            return this.extraMsg == null ? (v1 + v * 0x1F) * 0x1F : (v1 + v * 0x1F) * 0x1F + this.extraMsg.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("Success(requestAddResult=");
            stringBuilder0.append(this.requestAddResult);
            stringBuilder0.append(", extra=");
            stringBuilder0.append(this.extra);
            stringBuilder0.append(", extraMsg=");
            return x.m(stringBuilder0, this.extraMsg, ")");
        }
    }

    public static final int $stable = 8;
    @NotNull
    private final Set notUsedDefaultSuccessToastPlaylist;

    private AddResult() {
        this.notUsedDefaultSuccessToastPlaylist = n.A0(new PlaylistId[]{PlaylistId.STATION, PlaylistId.DRAWER, PlaylistId.MUSIC_WAVE, PlaylistId.VOD, PlaylistId.LIVE});
    }

    public AddResult(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    public final void handleToast(@NotNull AddAction addAction0) {
        int v;
        q.g(addAction0, "addAction");
        if(this instanceof Success) {
            b0 b00 = ((Success)this).getRequestAddResult();
            String s = ((Success)this).getExtraMsg();
            if(s != null && s.length() != 0) {
                ToastManager.show(((Success)this).getExtraMsg());
            }
            PlaylistId playlistId0 = b00.b();
            if(this.notUsedDefaultSuccessToastPlaylist.contains(playlistId0)) {
                return;
            }
            boolean z = addAction0 instanceof AddPlay && ((AddPlay)addAction0).isShufflePlay() || addAction0 instanceof AddPlayOpenPlayer && ((AddPlayOpenPlayer)addAction0).isShufflePlay();
            if(b00 instanceof Y && ((Y)b00).d) {
                ToastManager.show(String.format(Z.m(MelonAppBase.Companion, 0x7F130843, "getString(...)"), Arrays.copyOf(new Object[]{String.valueOf(((Y)b00).e)}, 1)));  // string:playlist_truncate_toast "재생목록은 %1$s곡까지 담을 수 있고, 오래된 순서대로 삭제됩니다."
                return;
            }
            if(b00 instanceof Y) {
                List list0 = ((Y)b00).b;
                if(((Y)b00).c) {
                    if(z) {
                        ToastManager.showFormatted(0x7F1307AB, new Object[]{list0.size()});  // string:nowplaying_added_n_shuffled_items_del_duplicated "중복곡을 삭제하고 %1$d곡을 무작위순서로 
                                                                                             // 담았습니다."
                        return;
                    }
                    ToastManager.showFormatted(0x7F1307A9, new Object[]{list0.size()});  // string:nowplaying_added_n_items_del_duplicated "중복곡을 삭제하고 %1$d곡을 재생 목록에 담았습니다."
                    return;
                }
            }
            if(b00 instanceof a0) {
                if(((a0)b00) instanceof oc.Z) {
                    v = ((oc.Z)b00).b.size();
                }
                else if(((a0)b00) instanceof X) {
                    v = ((X)b00).b.size();
                }
                else if(((a0)b00) instanceof Y) {
                    v = ((Y)b00).b.size();
                }
                else {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                if(z) {
                    ToastManager.showFormatted(0x7F1307AA, new Object[]{v});  // string:nowplaying_added_n_shuffled_items "%1$d곡을 무작위순서로 담았습니다."
                    return;
                }
                if(b00.b().isMixUp()) {
                    SuccessExtra successExtra0 = ((Success)this).getExtra();
                    if(successExtra0 instanceof MixUpSimple) {
                        ToastManager.show(0x7F1306A3);  // string:mixup_simple_play_toast_msg "DJ 말랑이가 선곡한 음악을 재생합니다."
                        return;
                    }
                    if(successExtra0 instanceof MixUpSeedOverMaxSize) {
                        String s1 = k8.Y.a(MelonAppBase.Companion).getString(0x7F1306A1, new Object[]{1000});  // string:mixup_play_max_size_limit "초과되는 곡을 제외하고 %d곡으로 믹스업 재생을 시작합니다."
                        q.f(s1, "getString(...)");
                        ToastManager.show(s1);
                        return;
                    }
                    ToastManager.show(0x7F1306A2);  // string:mixup_play_toast_msg "믹스업으로 재생합니다."
                    return;
                }
                ToastManager.showFormatted(0x7F1307A8, new Object[]{v});  // string:nowplaying_added_n_items "%1$d곡을 재생 목록에 담았습니다."
                return;
            }
            ToastManager.show(0x7F1303C5);  // string:error_invalid_network "네트워크 연결 상태를 확인하거나, 잠시 후 다시 이용해 주세요."
            return;
        }
        if(!(this instanceof Failure)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        AddFailType addFailType0 = ((Failure)this).getType();
        if(addFailType0 instanceof EmptyPlaylist) {
            ToastManager.showShort(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
            return;
        }
        if(addFailType0 instanceof VideoOpenWhenAuto) {
            ToastManager.show(0x7F131069);  // string:toast_message_androidauto_not_support_video_play_in_auto "Android Auto 실행 
                                            // 중에는 영상 재생을 할 수 없습니다."
        }
    }
}

