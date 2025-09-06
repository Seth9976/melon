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
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\b\u001A\u00020\u00072\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001A\u00020\u00072\u0012\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00A2\u0006\u0004\b\n\u0010\tR$\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR$\u0010!\u001A\u0004\u0018\u00010 8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001A\u0004\u0018\u00010\'8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001A\u0004\u0018\u00010.8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001A\u0004\u0018\u0001058\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001A\u0004\u0018\u00010<8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010D\u001A\u0004\u0018\u00010C8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bD\u0010E\u001A\u0004\bF\u0010G\"\u0004\bH\u0010I\u00A8\u0006J"}, d2 = {"Lcom/kakaoent/leonplayer/delegate/LeonPlayerEventListenerDelegateImpl;", "Lcom/kakaoent/leonplayer/delegate/LeonPlayerEventListenerDelegate;", "<init>", "()V", "", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;", "listeners", "Lie/H;", "addListeners", "([Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener;)V", "removeListeners", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "playerStateEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "getPlayerStateEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;", "setPlayerStateEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnPlayerStateChanged;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "bufferingStateEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "getBufferingStateEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;", "setBufferingStateEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferingStateChanged;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "timedTextEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "getTimedTextEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;", "setTimedTextEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedText;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "currentTimeEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "getCurrentTimeEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;", "setCurrentTimeEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnCurrentTime;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "bufferedTimeEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "getBufferedTimeEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;", "setBufferedTimeEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnBufferedTime;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "renderingStartEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "getRenderingStartEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;", "setRenderingStartEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnRenderingStart;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "timedMetaDataEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "getTimedMetaDataEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;", "setTimedMetaDataEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnTimedMetaData;)V", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "seekCompleteEventListener", "Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "getSeekCompleteEventListener", "()Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;", "setSeekCompleteEventListener", "(Lcom/kakaoent/leonplayer/core/event/LeonPlayerEventListener$OnSeekComplete;)V", "Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "posterImageEventListener", "Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "getPosterImageEventListener", "()Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;", "setPosterImageEventListener", "(Lcom/kakaoent/leonplayer/core/event/PosterImageEventListener;)V", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LeonPlayerEventListenerDelegateImpl implements LeonPlayerEventListenerDelegate {
    @Nullable
    private OnBufferedTime bufferedTimeEventListener;
    @Nullable
    private OnBufferingStateChanged bufferingStateEventListener;
    @Nullable
    private OnCurrentTime currentTimeEventListener;
    @Nullable
    private OnPlayerStateChanged playerStateEventListener;
    @Nullable
    private PosterImageEventListener posterImageEventListener;
    @Nullable
    private OnRenderingStart renderingStartEventListener;
    @Nullable
    private OnSeekComplete seekCompleteEventListener;
    @Nullable
    private OnTimedMetaData timedMetaDataEventListener;
    @Nullable
    private OnTimedText timedTextEventListener;

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    public void addListeners(@NotNull LeonPlayerEventListener[] arr_leonPlayerEventListener) {
        q.g(arr_leonPlayerEventListener, "listeners");
        for(int v = 0; v < arr_leonPlayerEventListener.length; ++v) {
            LeonPlayerEventListener leonPlayerEventListener0 = arr_leonPlayerEventListener[v];
            if(leonPlayerEventListener0 instanceof OnPlayerStateChanged) {
                this.setPlayerStateEventListener(((OnPlayerStateChanged)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnBufferingStateChanged) {
                this.setBufferingStateEventListener(((OnBufferingStateChanged)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnTimedText) {
                this.setTimedTextEventListener(((OnTimedText)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnCurrentTime) {
                this.setCurrentTimeEventListener(((OnCurrentTime)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnBufferedTime) {
                this.setBufferedTimeEventListener(((OnBufferedTime)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnRenderingStart) {
                this.setRenderingStartEventListener(((OnRenderingStart)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnTimedMetaData) {
                this.setTimedMetaDataEventListener(((OnTimedMetaData)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof OnSeekComplete) {
                this.setSeekCompleteEventListener(((OnSeekComplete)leonPlayerEventListener0));
            }
            else if(leonPlayerEventListener0 instanceof PosterImageEventListener) {
                this.setPosterImageEventListener(((PosterImageEventListener)leonPlayerEventListener0));
            }
        }
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnBufferedTime getBufferedTimeEventListener() {
        return this.bufferedTimeEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnBufferingStateChanged getBufferingStateEventListener() {
        return this.bufferingStateEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnCurrentTime getCurrentTimeEventListener() {
        return this.currentTimeEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnPlayerStateChanged getPlayerStateEventListener() {
        return this.playerStateEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public PosterImageEventListener getPosterImageEventListener() {
        return this.posterImageEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnRenderingStart getRenderingStartEventListener() {
        return this.renderingStartEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnSeekComplete getSeekCompleteEventListener() {
        return this.seekCompleteEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnTimedMetaData getTimedMetaDataEventListener() {
        return this.timedMetaDataEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    @Nullable
    public OnTimedText getTimedTextEventListener() {
        return this.timedTextEventListener;
    }

    @Override  // com.kakaoent.leonplayer.delegate.LeonPlayerEventListenerDelegate
    public void removeListeners(@NotNull LeonPlayerEventListener[] arr_leonPlayerEventListener) {
        q.g(arr_leonPlayerEventListener, "listeners");
        for(int v = 0; v < arr_leonPlayerEventListener.length; ++v) {
            LeonPlayerEventListener leonPlayerEventListener0 = arr_leonPlayerEventListener[v];
            if(leonPlayerEventListener0 instanceof OnPlayerStateChanged) {
                this.setPlayerStateEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnBufferingStateChanged) {
                this.setBufferingStateEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnTimedText) {
                this.setTimedTextEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnCurrentTime) {
                this.setCurrentTimeEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnBufferedTime) {
                this.setBufferedTimeEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnRenderingStart) {
                this.setRenderingStartEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnTimedMetaData) {
                this.setTimedMetaDataEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof OnSeekComplete) {
                this.setSeekCompleteEventListener(null);
            }
            else if(leonPlayerEventListener0 instanceof PosterImageEventListener) {
                this.setPosterImageEventListener(null);
            }
        }
    }

    public void setBufferedTimeEventListener(@Nullable OnBufferedTime leonPlayerEventListener$OnBufferedTime0) {
        this.bufferedTimeEventListener = leonPlayerEventListener$OnBufferedTime0;
    }

    public void setBufferingStateEventListener(@Nullable OnBufferingStateChanged leonPlayerEventListener$OnBufferingStateChanged0) {
        this.bufferingStateEventListener = leonPlayerEventListener$OnBufferingStateChanged0;
    }

    public void setCurrentTimeEventListener(@Nullable OnCurrentTime leonPlayerEventListener$OnCurrentTime0) {
        this.currentTimeEventListener = leonPlayerEventListener$OnCurrentTime0;
    }

    public void setPlayerStateEventListener(@Nullable OnPlayerStateChanged leonPlayerEventListener$OnPlayerStateChanged0) {
        this.playerStateEventListener = leonPlayerEventListener$OnPlayerStateChanged0;
    }

    public void setPosterImageEventListener(@Nullable PosterImageEventListener posterImageEventListener0) {
        this.posterImageEventListener = posterImageEventListener0;
    }

    public void setRenderingStartEventListener(@Nullable OnRenderingStart leonPlayerEventListener$OnRenderingStart0) {
        this.renderingStartEventListener = leonPlayerEventListener$OnRenderingStart0;
    }

    public void setSeekCompleteEventListener(@Nullable OnSeekComplete leonPlayerEventListener$OnSeekComplete0) {
        this.seekCompleteEventListener = leonPlayerEventListener$OnSeekComplete0;
    }

    public void setTimedMetaDataEventListener(@Nullable OnTimedMetaData leonPlayerEventListener$OnTimedMetaData0) {
        this.timedMetaDataEventListener = leonPlayerEventListener$OnTimedMetaData0;
    }

    public void setTimedTextEventListener(@Nullable OnTimedText leonPlayerEventListener$OnTimedText0) {
        this.timedTextEventListener = leonPlayerEventListener$OnTimedText0;
    }
}

