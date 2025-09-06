package com.kakaoent.leonplayer.core.event;

import com.kakaoent.leonplayer.core.model.data.player.LeonMediaTime;
import com.kakaoent.leonplayer.core.model.data.player.LeonTimedMeta;
import com.kakaoent.leonplayer.core.model.state.LeonPlayerState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\t\n\u000B\f\r\u000E\u000F\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "", "OnBufferedTime", "OnBufferingStateChanged", "OnCurrentTime", "OnPlayerStateChanged", "OnRenderingStart", "OnSeekComplete", "OnTimedMetaData", "OnTimedText", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonPlayerEventListener {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "mediaTime", "Lie/H;", "onBufferedTime", "(Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnBufferedTime extends LeonPlayerEventListener {
        void onBufferedTime(@NotNull LeonMediaTime arg1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "", "state", "Lie/H;", "onChanged", "(Z)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnBufferingStateChanged extends LeonPlayerEventListener {
        void onChanged(boolean arg1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;", "mediaTime", "Lie/H;", "onCurrentTime", "(Lcom/kakaoent/leonplayer/core/model/data/player/LeonMediaTime;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnCurrentTime extends LeonPlayerEventListener {
        void onCurrentTime(@NotNull LeonMediaTime arg1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;", "state", "Lie/H;", "onChanged", "(Lcom/kakaoent/leonplayer/core/model/state/LeonPlayerState;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnPlayerStateChanged extends LeonPlayerEventListener {
        void onChanged(@NotNull LeonPlayerState arg1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Lie/H;", "onRenderingStart", "()V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnRenderingStart extends LeonPlayerEventListener {
        void onRenderingStart();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Lie/H;", "onSeekComplete", "()V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnSeekComplete extends LeonPlayerEventListener {
        void onSeekComplete();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "Lcom/kakaoent/leonplayer/core/model/data/player/LeonTimedMeta;", "timedMeta", "Lie/H;", "onTimedMetaData", "(Lcom/kakaoent/leonplayer/core/model/data/player/LeonTimedMeta;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnTimedMetaData extends LeonPlayerEventListener {
        void onTimedMetaData(@NotNull LeonTimedMeta arg1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "", "text", "Lie/H;", "onTimedText", "(Ljava/lang/String;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OnTimedText extends LeonPlayerEventListener {
        void onTimedText(@NotNull String arg1);
    }

}

