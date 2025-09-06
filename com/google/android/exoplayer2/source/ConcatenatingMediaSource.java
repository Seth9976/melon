package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ConcatenatingMediaSource extends CompositeMediaSource {
    static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final HashMap childIndexByUid;
        private final int[] firstPeriodInChildIndices;
        private final int[] firstWindowInChildIndices;
        private final int periodCount;
        private final Timeline[] timelines;
        private final Object[] uids;
        private final int windowCount;

        public ConcatenatedTimeline(Collection collection0, ShuffleOrder shuffleOrder0, boolean z) {
            super(z, shuffleOrder0);
            int v = collection0.size();
            this.firstPeriodInChildIndices = new int[v];
            this.firstWindowInChildIndices = new int[v];
            this.timelines = new Timeline[v];
            this.uids = new Object[v];
            this.childIndexByUid = new HashMap();
            int v1 = 0;
            int v2 = 0;
            int v3 = 0;
            for(Object object0: collection0) {
                this.timelines[v3] = ((MediaSourceHolder)object0).mediaSource.getTimeline();
                this.firstWindowInChildIndices[v3] = v1;
                this.firstPeriodInChildIndices[v3] = v2;
                v1 += this.timelines[v3].getWindowCount();
                v2 += this.timelines[v3].getPeriodCount();
                this.uids[v3] = ((MediaSourceHolder)object0).uid;
                this.childIndexByUid.put(((MediaSourceHolder)object0).uid, v3);
                ++v3;
            }
            this.windowCount = v1;
            this.periodCount = v2;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByChildUid(Object object0) {
            Integer integer0 = (Integer)this.childIndexByUid.get(object0);
            return integer0 == null ? -1 : ((int)integer0);
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByPeriodIndex(int v) {
            return Util.binarySearchFloor(this.firstPeriodInChildIndices, v + 1, false, false);
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getChildIndexByWindowIndex(int v) {
            return Util.binarySearchFloor(this.firstWindowInChildIndices, v + 1, false, false);
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Object getChildUidByChildIndex(int v) {
            return this.uids[v];
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstPeriodIndexByChildIndex(int v) {
            return this.firstPeriodInChildIndices[v];
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public int getFirstWindowIndexByChildIndex(int v) {
            return this.firstWindowInChildIndices[v];
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getPeriodCount() {
            return this.periodCount;
        }

        @Override  // com.google.android.exoplayer2.source.AbstractConcatenatedTimeline
        public Timeline getTimelineByChildIndex(int v) {
            return this.timelines[v];
        }

        @Override  // com.google.android.exoplayer2.Timeline
        public int getWindowCount() {
            return this.windowCount;
        }
    }

    static final class DummyMediaSource extends BaseMediaSource {
        private DummyMediaSource() {
        }

        public DummyMediaSource(com.google.android.exoplayer2.source.ConcatenatingMediaSource.1 concatenatingMediaSource$10) {
        }

        @Override  // com.google.android.exoplayer2.source.MediaSource
        public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
            throw new UnsupportedOperationException();
        }

        @Override  // com.google.android.exoplayer2.source.MediaSource
        public Object getTag() {
            return null;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSource
        public void maybeThrowSourceInfoRefreshError() {
        }

        @Override  // com.google.android.exoplayer2.source.BaseMediaSource
        public void prepareSourceInternal(TransferListener transferListener0) {
        }

        @Override  // com.google.android.exoplayer2.source.MediaSource
        public void releasePeriod(MediaPeriod mediaPeriod0) {
        }

        @Override  // com.google.android.exoplayer2.source.BaseMediaSource
        public void releaseSourceInternal() {
        }
    }

    static final class HandlerAndRunnable {
        private final Handler handler;
        private final Runnable runnable;

        public HandlerAndRunnable(Handler handler0, Runnable runnable0) {
            this.handler = handler0;
            this.runnable = runnable0;
        }

        public void dispatch() {
            this.handler.post(this.runnable);
        }
    }

    static final class MediaSourceHolder {
        public final List activeMediaPeriodIds;
        public int childIndex;
        public int firstWindowIndexInChild;
        public boolean isRemoved;
        public final MaskingMediaSource mediaSource;
        public final Object uid;

        public MediaSourceHolder(MediaSource mediaSource0, boolean z) {
            this.mediaSource = new MaskingMediaSource(mediaSource0, z);
            this.activeMediaPeriodIds = new ArrayList();
            this.uid = new Object();
        }

        public void reset(int v, int v1) {
            this.childIndex = v;
            this.firstWindowIndexInChild = v1;
            this.isRemoved = false;
            this.activeMediaPeriodIds.clear();
        }
    }

    static final class MessageData {
        public final Object customData;
        public final int index;
        public final HandlerAndRunnable onCompletionAction;

        public MessageData(int v, Object object0, HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable0) {
            this.index = v;
            this.customData = object0;
            this.onCompletionAction = concatenatingMediaSource$HandlerAndRunnable0;
        }
    }

    private static final int MSG_ADD = 0;
    private static final int MSG_MOVE = 2;
    private static final int MSG_ON_COMPLETION = 5;
    private static final int MSG_REMOVE = 1;
    private static final int MSG_SET_SHUFFLE_ORDER = 3;
    private static final int MSG_UPDATE_TIMELINE = 4;
    private final Set enabledMediaSourceHolders;
    private final boolean isAtomic;
    private final Map mediaSourceByMediaPeriod;
    private final Map mediaSourceByUid;
    private final List mediaSourceHolders;
    private final List mediaSourcesPublic;
    private Set nextTimelineUpdateOnCompletionActions;
    private final Set pendingOnCompletionActions;
    private Handler playbackThreadHandler;
    private ShuffleOrder shuffleOrder;
    private boolean timelineUpdateScheduled;
    private final boolean useLazyPreparation;

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder0, MediaSource[] arr_mediaSource) {
        this(z, false, shuffleOrder0, arr_mediaSource);
    }

    public ConcatenatingMediaSource(boolean z, boolean z1, ShuffleOrder shuffleOrder0, MediaSource[] arr_mediaSource) {
        for(int v = 0; v < arr_mediaSource.length; ++v) {
            Assertions.checkNotNull(arr_mediaSource[v]);
        }
        if(shuffleOrder0.getLength() > 0) {
            shuffleOrder0 = shuffleOrder0.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder0;
        this.mediaSourceByMediaPeriod = new IdentityHashMap();
        this.mediaSourceByUid = new HashMap();
        this.mediaSourcesPublic = new ArrayList();
        this.mediaSourceHolders = new ArrayList();
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        this.pendingOnCompletionActions = new HashSet();
        this.enabledMediaSourceHolders = new HashSet();
        this.isAtomic = z;
        this.useLazyPreparation = z1;
        this.addMediaSources(Arrays.asList(arr_mediaSource));
    }

    public ConcatenatingMediaSource(boolean z, MediaSource[] arr_mediaSource) {
        this(z, new DefaultShuffleOrder(0), arr_mediaSource);
    }

    public ConcatenatingMediaSource(MediaSource[] arr_mediaSource) {
        this(false, arr_mediaSource);
    }

    public void addMediaSource(int v, MediaSource mediaSource0) {
        synchronized(this) {
            this.addPublicMediaSources(v, Collections.singletonList(mediaSource0), null, null);
        }
    }

    public void addMediaSource(int v, MediaSource mediaSource0, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.addPublicMediaSources(v, Collections.singletonList(mediaSource0), handler0, runnable0);
        }
    }

    public void addMediaSource(MediaSource mediaSource0) {
        synchronized(this) {
            this.addMediaSource(this.mediaSourcesPublic.size(), mediaSource0);
        }
    }

    public void addMediaSource(MediaSource mediaSource0, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.addMediaSource(this.mediaSourcesPublic.size(), mediaSource0, handler0, runnable0);
        }
    }

    private void addMediaSourceInternal(int v, MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0) {
        if(v > 0) {
            MediaSourceHolder concatenatingMediaSource$MediaSourceHolder1 = (MediaSourceHolder)this.mediaSourceHolders.get(v - 1);
            int v1 = concatenatingMediaSource$MediaSourceHolder1.firstWindowIndexInChild;
            concatenatingMediaSource$MediaSourceHolder0.reset(v, concatenatingMediaSource$MediaSourceHolder1.mediaSource.getTimeline().getWindowCount() + v1);
        }
        else {
            concatenatingMediaSource$MediaSourceHolder0.reset(v, 0);
        }
        this.correctOffsets(v, 1, concatenatingMediaSource$MediaSourceHolder0.mediaSource.getTimeline().getWindowCount());
        this.mediaSourceHolders.add(v, concatenatingMediaSource$MediaSourceHolder0);
        this.mediaSourceByUid.put(concatenatingMediaSource$MediaSourceHolder0.uid, concatenatingMediaSource$MediaSourceHolder0);
        this.prepareChildSource(concatenatingMediaSource$MediaSourceHolder0, concatenatingMediaSource$MediaSourceHolder0.mediaSource);
        if(this.isEnabled() && this.mediaSourceByMediaPeriod.isEmpty()) {
            this.enabledMediaSourceHolders.add(concatenatingMediaSource$MediaSourceHolder0);
            return;
        }
        this.disableChildSource(concatenatingMediaSource$MediaSourceHolder0);
    }

    public void addMediaSources(int v, Collection collection0) {
        synchronized(this) {
            this.addPublicMediaSources(v, collection0, null, null);
        }
    }

    public void addMediaSources(int v, Collection collection0, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.addPublicMediaSources(v, collection0, handler0, runnable0);
        }
    }

    public void addMediaSources(Collection collection0) {
        synchronized(this) {
            this.addPublicMediaSources(this.mediaSourcesPublic.size(), collection0, null, null);
        }
    }

    public void addMediaSources(Collection collection0, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.addPublicMediaSources(this.mediaSourcesPublic.size(), collection0, handler0, runnable0);
        }
    }

    private void addMediaSourcesInternal(int v, Collection collection0) {
        for(Object object0: collection0) {
            this.addMediaSourceInternal(v, ((MediaSourceHolder)object0));
            ++v;
        }
    }

    private void addPublicMediaSources(int v, Collection collection0, Handler handler0, Runnable runnable0) {
        Assertions.checkArgument((handler0 == null ? 1 : 0) == (runnable0 == null ? 1 : 0));
        Handler handler1 = this.playbackThreadHandler;
        for(Object object0: collection0) {
            Assertions.checkNotNull(((MediaSource)object0));
        }
        ArrayList arrayList0 = new ArrayList(collection0.size());
        for(Object object1: collection0) {
            arrayList0.add(new MediaSourceHolder(((MediaSource)object1), this.useLazyPreparation));
        }
        this.mediaSourcesPublic.addAll(v, arrayList0);
        if(handler1 != null && !collection0.isEmpty()) {
            handler1.obtainMessage(0, new MessageData(v, arrayList0, this.createOnCompletionAction(handler0, runnable0))).sendToTarget();
            return;
        }
        if(runnable0 != null && handler0 != null) {
            handler0.post(runnable0);
        }
    }

    public void clear() {
        synchronized(this) {
            this.removeMediaSourceRange(0, this.getSize());
        }
    }

    public void clear(Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.removeMediaSourceRange(0, this.getSize(), handler0, runnable0);
        }
    }

    private void correctOffsets(int v, int v1, int v2) {
        while(v < this.mediaSourceHolders.size()) {
            MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)this.mediaSourceHolders.get(v);
            concatenatingMediaSource$MediaSourceHolder0.childIndex += v1;
            concatenatingMediaSource$MediaSourceHolder0.firstWindowIndexInChild += v2;
            ++v;
        }
    }

    private HandlerAndRunnable createOnCompletionAction(Handler handler0, Runnable runnable0) {
        if(handler0 != null && runnable0 != null) {
            HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable0 = new HandlerAndRunnable(handler0, runnable0);
            this.pendingOnCompletionActions.add(concatenatingMediaSource$HandlerAndRunnable0);
            return concatenatingMediaSource$HandlerAndRunnable0;
        }
        return null;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        Object object0 = ConcatenatingMediaSource.getMediaSourceHolderUid(mediaSource$MediaPeriodId0.periodUid);
        MediaPeriodId mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId0.copyWithPeriodUid(ConcatenatingMediaSource.getChildPeriodUid(mediaSource$MediaPeriodId0.periodUid));
        MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)this.mediaSourceByUid.get(object0);
        if(concatenatingMediaSource$MediaSourceHolder0 == null) {
            concatenatingMediaSource$MediaSourceHolder0 = new MediaSourceHolder(new DummyMediaSource(null), this.useLazyPreparation);
            concatenatingMediaSource$MediaSourceHolder0.isRemoved = true;
            this.prepareChildSource(concatenatingMediaSource$MediaSourceHolder0, concatenatingMediaSource$MediaSourceHolder0.mediaSource);
        }
        this.enableMediaSource(concatenatingMediaSource$MediaSourceHolder0);
        concatenatingMediaSource$MediaSourceHolder0.activeMediaPeriodIds.add(mediaSource$MediaPeriodId1);
        MediaPeriod mediaPeriod0 = concatenatingMediaSource$MediaSourceHolder0.mediaSource.createPeriod(mediaSource$MediaPeriodId1, allocator0, v);
        this.mediaSourceByMediaPeriod.put(mediaPeriod0, concatenatingMediaSource$MediaSourceHolder0);
        this.disableUnusedMediaSources();
        return mediaPeriod0;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void disableInternal() {
        super.disableInternal();
        this.enabledMediaSourceHolders.clear();
    }

    private void disableUnusedMediaSources() {
        Iterator iterator0 = this.enabledMediaSourceHolders.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)object0;
            if(concatenatingMediaSource$MediaSourceHolder0.activeMediaPeriodIds.isEmpty()) {
                this.disableChildSource(concatenatingMediaSource$MediaSourceHolder0);
                iterator0.remove();
            }
        }
    }

    private void dispatchOnCompletionActions(Set set0) {
        synchronized(this) {
            for(Object object0: set0) {
                ((HandlerAndRunnable)object0).dispatch();
            }
            this.pendingOnCompletionActions.removeAll(set0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void enableInternal() {
    }

    private void enableMediaSource(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0) {
        this.enabledMediaSourceHolders.add(concatenatingMediaSource$MediaSourceHolder0);
        this.enableChildSource(concatenatingMediaSource$MediaSourceHolder0);
    }

    private static Object getChildPeriodUid(Object object0) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object0);
    }

    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0, MediaPeriodId mediaSource$MediaPeriodId0) {
        for(int v = 0; v < concatenatingMediaSource$MediaSourceHolder0.activeMediaPeriodIds.size(); ++v) {
            if(((MediaPeriodId)concatenatingMediaSource$MediaSourceHolder0.activeMediaPeriodIds.get(v)).windowSequenceNumber == mediaSource$MediaPeriodId0.windowSequenceNumber) {
                return mediaSource$MediaPeriodId0.copyWithPeriodUid(ConcatenatingMediaSource.getPeriodUid(concatenatingMediaSource$MediaSourceHolder0, mediaSource$MediaPeriodId0.periodUid));
            }
        }
        return null;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.getMediaPeriodIdForChildMediaPeriodId(((MediaSourceHolder)object0), mediaSource$MediaPeriodId0);
    }

    public MediaSource getMediaSource(int v) {
        synchronized(this) {
            return ((MediaSourceHolder)this.mediaSourcesPublic.get(v)).mediaSource;
        }
    }

    private static Object getMediaSourceHolderUid(Object object0) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object0);
    }

    private static Object getPeriodUid(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0, Object object0) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(concatenatingMediaSource$MediaSourceHolder0.uid, object0);
    }

    private Handler getPlaybackThreadHandlerOnPlaybackThread() {
        return (Handler)Assertions.checkNotNull(this.playbackThreadHandler);
    }

    public int getSize() {
        synchronized(this) {
        }
        return this.mediaSourcesPublic.size();
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return null;
    }

    public int getWindowIndexForChildWindowIndex(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0, int v) {
        return v + concatenatingMediaSource$MediaSourceHolder0.firstWindowIndexInChild;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public int getWindowIndexForChildWindowIndex(Object object0, int v) {
        return this.getWindowIndexForChildWindowIndex(((MediaSourceHolder)object0), v);
    }

    private boolean handleMessage(Message message0) {
        switch(message0.what) {
            case 0: {
                MessageData concatenatingMediaSource$MessageData0 = (MessageData)message0.obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(concatenatingMediaSource$MessageData0.index, ((Collection)concatenatingMediaSource$MessageData0.customData).size());
                this.addMediaSourcesInternal(concatenatingMediaSource$MessageData0.index, ((Collection)concatenatingMediaSource$MessageData0.customData));
                this.scheduleTimelineUpdate(concatenatingMediaSource$MessageData0.onCompletionAction);
                return true;
            }
            case 1: {
                MessageData concatenatingMediaSource$MessageData1 = (MessageData)message0.obj;
                int v = concatenatingMediaSource$MessageData1.index;
                int v1 = (int)(((Integer)concatenatingMediaSource$MessageData1.customData));
                this.shuffleOrder = v != 0 || v1 != this.shuffleOrder.getLength() ? this.shuffleOrder.cloneAndRemove(v, v1) : this.shuffleOrder.cloneAndClear();
                for(int v2 = v1 - 1; v2 >= v; --v2) {
                    this.removeMediaSourceInternal(v2);
                }
                this.scheduleTimelineUpdate(concatenatingMediaSource$MessageData1.onCompletionAction);
                return true;
            }
            case 2: {
                MessageData concatenatingMediaSource$MessageData2 = (MessageData)message0.obj;
                this.shuffleOrder = this.shuffleOrder.cloneAndRemove(concatenatingMediaSource$MessageData2.index, concatenatingMediaSource$MessageData2.index + 1).cloneAndInsert(((int)(((Integer)concatenatingMediaSource$MessageData2.customData))), 1);
                this.moveMediaSourceInternal(concatenatingMediaSource$MessageData2.index, ((int)(((Integer)concatenatingMediaSource$MessageData2.customData))));
                this.scheduleTimelineUpdate(concatenatingMediaSource$MessageData2.onCompletionAction);
                return true;
            }
            case 3: {
                MessageData concatenatingMediaSource$MessageData3 = (MessageData)message0.obj;
                this.shuffleOrder = (ShuffleOrder)concatenatingMediaSource$MessageData3.customData;
                this.scheduleTimelineUpdate(concatenatingMediaSource$MessageData3.onCompletionAction);
                return true;
            }
            case 4: {
                this.updateTimelineAndScheduleOnCompletionActions();
                return true;
            }
            case 5: {
                this.dispatchOnCompletionActions(((Set)message0.obj));
                return true;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private void maybeReleaseChildSource(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0) {
        if(concatenatingMediaSource$MediaSourceHolder0.isRemoved && concatenatingMediaSource$MediaSourceHolder0.activeMediaPeriodIds.isEmpty()) {
            this.enabledMediaSourceHolders.remove(concatenatingMediaSource$MediaSourceHolder0);
            this.releaseChildSource(concatenatingMediaSource$MediaSourceHolder0);
        }
    }

    public void moveMediaSource(int v, int v1) {
        synchronized(this) {
            this.movePublicMediaSource(v, v1, null, null);
        }
    }

    public void moveMediaSource(int v, int v1, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.movePublicMediaSource(v, v1, handler0, runnable0);
        }
    }

    private void moveMediaSourceInternal(int v, int v1) {
        int v2 = Math.min(v, v1);
        int v3 = Math.max(v, v1);
        int v4 = ((MediaSourceHolder)this.mediaSourceHolders.get(v2)).firstWindowIndexInChild;
        MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)this.mediaSourceHolders.remove(v);
        this.mediaSourceHolders.add(v1, concatenatingMediaSource$MediaSourceHolder0);
        while(v2 <= v3) {
            MediaSourceHolder concatenatingMediaSource$MediaSourceHolder1 = (MediaSourceHolder)this.mediaSourceHolders.get(v2);
            concatenatingMediaSource$MediaSourceHolder1.childIndex = v2;
            concatenatingMediaSource$MediaSourceHolder1.firstWindowIndexInChild = v4;
            v4 += concatenatingMediaSource$MediaSourceHolder1.mediaSource.getTimeline().getWindowCount();
            ++v2;
        }
    }

    private void movePublicMediaSource(int v, int v1, Handler handler0, Runnable runnable0) {
        Assertions.checkArgument((handler0 == null ? 1 : 0) == (runnable0 == null ? 1 : 0));
        Handler handler1 = this.playbackThreadHandler;
        MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)this.mediaSourcesPublic.remove(v);
        this.mediaSourcesPublic.add(v1, concatenatingMediaSource$MediaSourceHolder0);
        if(handler1 != null) {
            handler1.obtainMessage(2, new MessageData(v, v1, this.createOnCompletionAction(handler0, runnable0))).sendToTarget();
            return;
        }
        if(runnable0 != null && handler0 != null) {
            handler0.post(runnable0);
        }
    }

    public void onChildSourceInfoRefreshed(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0, MediaSource mediaSource0, Timeline timeline0) {
        this.updateMediaSourceInternal(concatenatingMediaSource$MediaSourceHolder0, timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((MediaSourceHolder)object0), mediaSource0, timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        synchronized(this) {
            super.prepareSourceInternal(transferListener0);
            this.playbackThreadHandler = new Handler(new b(this));
            if(this.mediaSourcesPublic.isEmpty()) {
                this.updateTimelineAndScheduleOnCompletionActions();
            }
            else {
                this.shuffleOrder = this.shuffleOrder.cloneAndInsert(0, this.mediaSourcesPublic.size());
                this.addMediaSourcesInternal(0, this.mediaSourcesPublic);
                this.scheduleTimelineUpdate();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)Assertions.checkNotNull(((MediaSourceHolder)this.mediaSourceByMediaPeriod.remove(mediaPeriod0)));
        concatenatingMediaSource$MediaSourceHolder0.mediaSource.releasePeriod(mediaPeriod0);
        concatenatingMediaSource$MediaSourceHolder0.activeMediaPeriodIds.remove(((MaskingMediaPeriod)mediaPeriod0).id);
        if(!this.mediaSourceByMediaPeriod.isEmpty()) {
            this.disableUnusedMediaSources();
        }
        this.maybeReleaseChildSource(concatenatingMediaSource$MediaSourceHolder0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void releaseSourceInternal() {
        synchronized(this) {
            super.releaseSourceInternal();
            this.mediaSourceHolders.clear();
            this.enabledMediaSourceHolders.clear();
            this.mediaSourceByUid.clear();
            this.shuffleOrder = this.shuffleOrder.cloneAndClear();
            Handler handler0 = this.playbackThreadHandler;
            if(handler0 != null) {
                handler0.removeCallbacksAndMessages(null);
                this.playbackThreadHandler = null;
            }
            this.timelineUpdateScheduled = false;
            this.nextTimelineUpdateOnCompletionActions.clear();
            this.dispatchOnCompletionActions(this.pendingOnCompletionActions);
        }
    }

    public MediaSource removeMediaSource(int v) {
        synchronized(this) {
            MediaSource mediaSource0 = this.getMediaSource(v);
            this.removePublicMediaSources(v, v + 1, null, null);
            return mediaSource0;
        }
    }

    public MediaSource removeMediaSource(int v, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            MediaSource mediaSource0 = this.getMediaSource(v);
            this.removePublicMediaSources(v, v + 1, handler0, runnable0);
            return mediaSource0;
        }
    }

    private void removeMediaSourceInternal(int v) {
        MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0 = (MediaSourceHolder)this.mediaSourceHolders.remove(v);
        this.mediaSourceByUid.remove(concatenatingMediaSource$MediaSourceHolder0.uid);
        this.correctOffsets(v, -1, -concatenatingMediaSource$MediaSourceHolder0.mediaSource.getTimeline().getWindowCount());
        concatenatingMediaSource$MediaSourceHolder0.isRemoved = true;
        this.maybeReleaseChildSource(concatenatingMediaSource$MediaSourceHolder0);
    }

    public void removeMediaSourceRange(int v, int v1) {
        synchronized(this) {
            this.removePublicMediaSources(v, v1, null, null);
        }
    }

    public void removeMediaSourceRange(int v, int v1, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.removePublicMediaSources(v, v1, handler0, runnable0);
        }
    }

    private void removePublicMediaSources(int v, int v1, Handler handler0, Runnable runnable0) {
        Assertions.checkArgument((handler0 == null ? 1 : 0) == (runnable0 == null ? 1 : 0));
        Handler handler1 = this.playbackThreadHandler;
        Util.removeRange(this.mediaSourcesPublic, v, v1);
        if(handler1 != null) {
            handler1.obtainMessage(1, new MessageData(v, v1, this.createOnCompletionAction(handler0, runnable0))).sendToTarget();
            return;
        }
        if(runnable0 != null && handler0 != null) {
            handler0.post(runnable0);
        }
    }

    private void scheduleTimelineUpdate() {
        this.scheduleTimelineUpdate(null);
    }

    private void scheduleTimelineUpdate(HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable0) {
        if(!this.timelineUpdateScheduled) {
            this.getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(4).sendToTarget();
            this.timelineUpdateScheduled = true;
        }
        if(concatenatingMediaSource$HandlerAndRunnable0 != null) {
            this.nextTimelineUpdateOnCompletionActions.add(concatenatingMediaSource$HandlerAndRunnable0);
        }
    }

    private void setPublicShuffleOrder(ShuffleOrder shuffleOrder0, Handler handler0, Runnable runnable0) {
        Assertions.checkArgument((handler0 == null ? 1 : 0) == (runnable0 == null ? 1 : 0));
        Handler handler1 = this.playbackThreadHandler;
        if(handler1 != null) {
            int v = this.getSize();
            if(shuffleOrder0.getLength() != v) {
                shuffleOrder0 = shuffleOrder0.cloneAndClear().cloneAndInsert(0, v);
            }
            handler1.obtainMessage(3, new MessageData(0, shuffleOrder0, this.createOnCompletionAction(handler0, runnable0))).sendToTarget();
            return;
        }
        if(shuffleOrder0.getLength() > 0) {
            shuffleOrder0 = shuffleOrder0.cloneAndClear();
        }
        this.shuffleOrder = shuffleOrder0;
        if(runnable0 != null && handler0 != null) {
            handler0.post(runnable0);
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder0) {
        synchronized(this) {
            this.setPublicShuffleOrder(shuffleOrder0, null, null);
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder0, Handler handler0, Runnable runnable0) {
        synchronized(this) {
            this.setPublicShuffleOrder(shuffleOrder0, handler0, runnable0);
        }
    }

    private void updateMediaSourceInternal(MediaSourceHolder concatenatingMediaSource$MediaSourceHolder0, Timeline timeline0) {
        if(concatenatingMediaSource$MediaSourceHolder0 == null) {
            throw new IllegalArgumentException();
        }
        if(concatenatingMediaSource$MediaSourceHolder0.childIndex + 1 < this.mediaSourceHolders.size()) {
            MediaSourceHolder concatenatingMediaSource$MediaSourceHolder1 = (MediaSourceHolder)this.mediaSourceHolders.get(concatenatingMediaSource$MediaSourceHolder0.childIndex + 1);
            int v = timeline0.getWindowCount() - (concatenatingMediaSource$MediaSourceHolder1.firstWindowIndexInChild - concatenatingMediaSource$MediaSourceHolder0.firstWindowIndexInChild);
            if(v != 0) {
                this.correctOffsets(concatenatingMediaSource$MediaSourceHolder0.childIndex + 1, 0, v);
            }
        }
        this.scheduleTimelineUpdate();
    }

    private void updateTimelineAndScheduleOnCompletionActions() {
        this.timelineUpdateScheduled = false;
        Set set0 = this.nextTimelineUpdateOnCompletionActions;
        this.nextTimelineUpdateOnCompletionActions = new HashSet();
        this.refreshSourceInfo(new ConcatenatedTimeline(this.mediaSourceHolders, this.shuffleOrder, this.isAtomic));
        this.getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(5, set0).sendToTarget();
    }

    class com.google.android.exoplayer2.source.ConcatenatingMediaSource.1 {
    }

}

