package com.kakaoent.leonplayer.delegate;

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
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 -2\u00020\u0001:\u0001-J#\u0010\u0006\u001A\u00020\u00052\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001A\u00020\u00052\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H&¢\u0006\u0004\b\b\u0010\u0007R\u0016\u0010\f\u001A\u0004\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\u0010\u001A\u0004\u0018\u00010\r8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0014\u001A\u0004\u0018\u00010\u00118&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001A\u0004\u0018\u00010\u00158&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001C\u001A\u0004\u0018\u00010\u00198&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0016\u0010 \u001A\u0004\u0018\u00010\u001D8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0016\u0010$\u001A\u0004\u0018\u00010!8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#R\u0016\u0010(\u001A\u0004\u0018\u00010%8&X¦\u0004¢\u0006\u0006\u001A\u0004\b&\u0010\'R\u0016\u0010,\u001A\u0004\u0018\u00010)8&X¦\u0004¢\u0006\u0006\u001A\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/kakaoent/leonplayer/delegate/LeonPlayerEventListenerDelegate;", "", "", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "listeners", "Lie/H;", "addListeners", "([Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;)V", "removeListeners", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "getPlayerStateEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "playerStateEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "getBufferingStateEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "bufferingStateEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "getTimedTextEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "timedTextEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "getCurrentTimeEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "currentTimeEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "getBufferedTimeEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "bufferedTimeEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "getRenderingStartEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "renderingStartEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "getTimedMetaDataEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "timedMetaDataEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "getSeekCompleteEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "seekCompleteEventListener", "Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "getPosterImageEventListener", "()Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "posterImageEventListener", "Companion", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonPlayerEventListenerDelegate {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/leonplayer/delegate/LeonPlayerEventListenerDelegate$Companion;", "", "()V", "create", "Lcom/kakaoent/leonplayer/delegate/LeonPlayerEventListenerDelegate;", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final LeonPlayerEventListenerDelegate create() {
            return new LeonPlayerEventListenerDelegateImpl();
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        LeonPlayerEventListenerDelegate.Companion = Companion.$$INSTANCE;
    }

    void addListeners(@NotNull LeonPlayerEventListener[] arg1);

    @Nullable
    OnBufferedTime getBufferedTimeEventListener();

    @Nullable
    OnBufferingStateChanged getBufferingStateEventListener();

    @Nullable
    OnCurrentTime getCurrentTimeEventListener();

    @Nullable
    OnPlayerStateChanged getPlayerStateEventListener();

    @Nullable
    PosterImageEventListener getPosterImageEventListener();

    @Nullable
    OnRenderingStart getRenderingStartEventListener();

    @Nullable
    OnSeekComplete getSeekCompleteEventListener();

    @Nullable
    OnTimedMetaData getTimedMetaDataEventListener();

    @Nullable
    OnTimedText getTimedTextEventListener();

    void removeListeners(@NotNull LeonPlayerEventListener[] arg1);
}

