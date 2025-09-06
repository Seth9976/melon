package com.bumptech.glide.load.engine;

import U4.x;
import android.util.Log;
import b2.d;
import b3.Z;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob implements FetcherReadyCallback, Poolable, Comparable, Runnable {
    interface Callback {
        void onLoadFailed(GlideException arg1);

        void onResourceReady(Resource arg1, DataSource arg2, boolean arg3);

        void reschedule(DecodeJob arg1);
    }

    final class DecodeCallback implements com.bumptech.glide.load.engine.DecodePath.DecodeCallback {
        private final DataSource dataSource;

        public DecodeCallback(DataSource dataSource0) {
            this.dataSource = dataSource0;
        }

        @Override  // com.bumptech.glide.load.engine.DecodePath$DecodeCallback
        public Resource onResourceDecoded(Resource resource0) {
            return DecodeJob.this.onResourceDecoded(this.dataSource, resource0);
        }
    }

    static class DeferredEncodeManager {
        private ResourceEncoder encoder;
        private Key key;
        private LockedResource toEncode;

        public void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }

        public void encode(DiskCacheProvider decodeJob$DiskCacheProvider0, Options options0) {
            try {
                decodeJob$DiskCacheProvider0.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, options0));
            }
            finally {
                this.toEncode.unlock();
            }
        }

        public boolean hasResourceToEncode() {
            return this.toEncode != null;
        }

        public void init(Key key0, ResourceEncoder resourceEncoder0, LockedResource lockedResource0) {
            this.key = key0;
            this.encoder = resourceEncoder0;
            this.toEncode = lockedResource0;
        }
    }

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        // 去混淆评级： 低(40)
        private boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }

        public boolean onEncodeComplete() {
            synchronized(this) {
                this.isEncodeComplete = true;
                return this.isComplete(false);
            }
        }

        public boolean onFailed() {
            synchronized(this) {
                this.isFailed = true;
                return this.isComplete(false);
            }
        }

        public boolean release(boolean z) {
            synchronized(this) {
                this.isReleased = true;
                return this.isComplete(z);
            }
        }

        public void reset() {
            synchronized(this) {
                this.isEncodeComplete = false;
                this.isReleased = false;
                this.isFailed = false;
            }
        }
    }

    static enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA;

        private static RunReason[] $values() [...] // Inlined contents
    }

    static enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED;

        private static Stage[] $values() [...] // Inlined contents
    }

    private static final String TAG = "DecodeJob";
    private Callback callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    private Key currentSourceKey;
    private Thread currentThread;
    private final DecodeHelper decodeHelper;
    private final DeferredEncodeManager deferredEncodeManager;
    private final DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private boolean isLoadingFromAlternateCacheKey;
    private EngineKey loadKey;
    private Object model;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int order;
    private final d pool;
    private Priority priority;
    private final ReleaseManager releaseManager;
    private RunReason runReason;
    private Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier;
    private final List throwables;
    private int width;

    public DecodeJob(DiskCacheProvider decodeJob$DiskCacheProvider0, d d0) {
        this.decodeHelper = new DecodeHelper();
        this.throwables = new ArrayList();
        this.stateVerifier = StateVerifier.newInstance();
        this.deferredEncodeManager = new DeferredEncodeManager();
        this.releaseManager = new ReleaseManager();
        this.diskCacheProvider = decodeJob$DiskCacheProvider0;
        this.pool = d0;
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator dataFetcherGenerator0 = this.currentGenerator;
        if(dataFetcherGenerator0 != null) {
            dataFetcherGenerator0.cancel();
        }
    }

    public int compareTo(DecodeJob decodeJob0) {
        int v = this.getPriority() - decodeJob0.getPriority();
        return v == 0 ? this.order - decodeJob0.order : v;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((DecodeJob)object0));
    }

    private Resource decodeFromData(DataFetcher dataFetcher0, Object object0, DataSource dataSource0) {
        try {
            if(object0 == null) {
                return null;
            }
            long v1 = LogTime.getLogTime();
            Resource resource0 = this.decodeFromFetcher(object0, dataSource0);
            if(Log.isLoggable("DecodeJob", 2)) {
                this.logWithTimeAndKey("Decoded result " + resource0, v1);
            }
            return resource0;
        }
        finally {
            dataFetcher0.cleanup();
        }
    }

    private Resource decodeFromFetcher(Object object0, DataSource dataSource0) {
        Class class0 = object0.getClass();
        return this.runLoadPath(object0, dataSource0, this.decodeHelper.getLoadPath(class0));
    }

    private void decodeFromRetrievedData() {
        Resource resource0;
        if(Log.isLoggable("DecodeJob", 2)) {
            this.logWithTimeAndKey("Retrieved data", this.startFetchTime, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
        }
        try {
            resource0 = this.decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        }
        catch(GlideException glideException0) {
            glideException0.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(glideException0);
            resource0 = null;
        }
        if(resource0 != null) {
            this.notifyEncodeAndRelease(resource0, this.currentDataSource, this.isLoadingFromAlternateCacheKey);
            return;
        }
        this.runGenerators();
    }

    private DataFetcherGenerator getNextGenerator() {
        switch(com.bumptech.glide.load.engine.DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()]) {
            case 1: {
                return new ResourceCacheGenerator(this.decodeHelper, this);
            }
            case 2: {
                return new DataCacheGenerator(this.decodeHelper, this);
            }
            case 3: {
                return new SourceGenerator(this.decodeHelper, this);
            }
            case 4: {
                return null;
            }
            default: {
                throw new IllegalStateException("Unrecognized stage: " + this.stage);
            }
        }
    }

    private Stage getNextStage(Stage decodeJob$Stage0) {
        switch(com.bumptech.glide.load.engine.DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[decodeJob$Stage0.ordinal()]) {
            case 1: {
                return this.diskCacheStrategy.decodeCachedData() ? Stage.DATA_CACHE : this.getNextStage(Stage.DATA_CACHE);
            }
            case 2: {
                return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
            }
            case 3: 
            case 4: {
                return Stage.FINISHED;
            }
            case 5: {
                return this.diskCacheStrategy.decodeCachedResource() ? Stage.RESOURCE_CACHE : this.getNextStage(Stage.RESOURCE_CACHE);
            }
            default: {
                throw new IllegalArgumentException("Unrecognized stage: " + decodeJob$Stage0);
            }
        }
    }

    private Options getOptionsWithHardwareConfig(DataSource dataSource0) {
        Options options0 = this.options;
        boolean z = dataSource0 == DataSource.RESOURCE_DISK_CACHE || this.decodeHelper.isScaleOnlyOrNoTransform();
        Option option0 = Downsampler.ALLOW_HARDWARE_CONFIG;
        Boolean boolean0 = (Boolean)options0.get(option0);
        if(boolean0 != null && (!boolean0.booleanValue() || z)) {
            return options0;
        }
        Options options1 = new Options();
        options1.putAll(this.options);
        options1.set(option0, Boolean.valueOf(z));
        return options1;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    @Override  // com.bumptech.glide.util.pool.FactoryPools$Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public DecodeJob init(GlideContext glideContext0, Object object0, EngineKey engineKey0, Key key0, int v, int v1, Class class0, Class class1, Priority priority0, DiskCacheStrategy diskCacheStrategy0, Map map0, boolean z, boolean z1, boolean z2, Options options0, Callback decodeJob$Callback0, int v2) {
        this.decodeHelper.init(glideContext0, object0, key0, v, v1, diskCacheStrategy0, class0, class1, priority0, options0, map0, z, z1, this.diskCacheProvider);
        this.glideContext = glideContext0;
        this.signature = key0;
        this.priority = priority0;
        this.loadKey = engineKey0;
        this.width = v;
        this.height = v1;
        this.diskCacheStrategy = diskCacheStrategy0;
        this.onlyRetrieveFromCache = z2;
        this.options = options0;
        this.callback = decodeJob$Callback0;
        this.order = v2;
        this.runReason = RunReason.INITIALIZE;
        this.model = object0;
        return this;
    }

    private void logWithTimeAndKey(String s, long v) {
        this.logWithTimeAndKey(s, v, null);
    }

    private void logWithTimeAndKey(String s, long v, String s1) {
        StringBuilder stringBuilder0 = x.p(s, " in ");
        stringBuilder0.append(LogTime.getElapsedMillis(v));
        stringBuilder0.append(", load key: ");
        stringBuilder0.append(this.loadKey);
        stringBuilder0.append((s1 == null ? "" : ", " + s1));
        stringBuilder0.append(", thread: ");
        stringBuilder0.append("jeb-dexdec-sb-st-1119");
        Log.v("DecodeJob", stringBuilder0.toString());
    }

    private void notifyComplete(Resource resource0, DataSource dataSource0, boolean z) {
        this.setNotifiedOrThrow();
        this.callback.onResourceReady(resource0, dataSource0, z);
    }

    private void notifyEncodeAndRelease(Resource resource0, DataSource dataSource0, boolean z) {
        Resource resource1;
        try {
            if(resource0 instanceof Initializable) {
                ((Initializable)resource0).initialize();
            }
            if(this.deferredEncodeManager.hasResourceToEncode()) {
                resource0 = LockedResource.obtain(resource0);
                resource1 = resource0;
            }
            else {
                resource1 = null;
            }
            this.notifyComplete(resource0, dataSource0, z);
            this.stage = Stage.ENCODE;
            try {
                if(this.deferredEncodeManager.hasResourceToEncode()) {
                    this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
                }
            }
            finally {
                if(resource1 != null) {
                    ((LockedResource)resource1).unlock();
                }
            }
            this.onEncodeComplete();
            return;
        }
        catch(Throwable throwable0) {
        }
        throw throwable0;
    }

    private void notifyFailed() {
        this.setNotifiedOrThrow();
        GlideException glideException0 = new GlideException("Failed to load resource", new ArrayList(this.throwables));
        this.callback.onLoadFailed(glideException0);
        this.onLoadFailed();
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public void onDataFetcherFailed(Key key0, Exception exception0, DataFetcher dataFetcher0, DataSource dataSource0) {
        dataFetcher0.cleanup();
        GlideException glideException0 = new GlideException("Fetching data failed", exception0);
        glideException0.setLoggingDetails(key0, dataSource0, dataFetcher0.getDataClass());
        this.throwables.add(glideException0);
        if(Thread.currentThread() != this.currentThread) {
            this.reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
            return;
        }
        this.runGenerators();
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public void onDataFetcherReady(Key key0, Object object0, DataFetcher dataFetcher0, DataSource dataSource0, Key key1) {
        this.currentSourceKey = key0;
        this.currentData = object0;
        this.currentFetcher = dataFetcher0;
        this.currentDataSource = dataSource0;
        this.currentAttemptingKey = key1;
        this.isLoadingFromAlternateCacheKey = key0 != this.decodeHelper.getCacheKeys().get(0);
        if(Thread.currentThread() != this.currentThread) {
            this.reschedule(RunReason.DECODE_DATA);
            return;
        }
        this.decodeFromRetrievedData();
    }

    private void onEncodeComplete() {
        if(this.releaseManager.onEncodeComplete()) {
            this.releaseInternal();
        }
    }

    private void onLoadFailed() {
        if(this.releaseManager.onFailed()) {
            this.releaseInternal();
        }
    }

    // 检测为 Lambda 实现
    public Resource onResourceDecoded(DataSource dataSource0, Resource resource0) [...]

    public void release(boolean z) {
        if(this.releaseManager.release(z)) {
            this.releaseInternal();
        }
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0L;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    private void reschedule(RunReason decodeJob$RunReason0) {
        this.runReason = decodeJob$RunReason0;
        this.callback.reschedule(this);
    }

    @Override  // com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback
    public void reschedule() {
        this.reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override
    public void run() {
        DataFetcher dataFetcher0;
        try {
            dataFetcher0 = this.currentFetcher;
            if(this.isCancelled) {
                this.notifyFailed();
                if(dataFetcher0 != null) {
                    goto label_4;
                }
                return;
            }
            goto label_6;
        }
        catch(CallbackException callbackException0) {
            throw callbackException0;
        }
        catch(Throwable throwable0) {
            goto label_11;
        }
    label_4:
        dataFetcher0.cleanup();
        return;
        try {
        label_6:
            this.runWrapped();
            goto label_21;
        }
        catch(CallbackException callbackException0) {
        }
        catch(Throwable throwable0) {
            goto label_11;
        }
        try {
            throw callbackException0;
        label_11:
            if(Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.isCancelled + ", stage: " + this.stage, throwable0);
            }
            if(this.stage != Stage.ENCODE) {
                this.throwables.add(throwable0);
                this.notifyFailed();
            }
            throw throwable0;
        label_18:
            if(dataFetcher0 == null) {
                throw throwable1;
            }
        }
        catch(Throwable throwable1) {
            goto label_18;
        }
        dataFetcher0.cleanup();
        throw throwable1;
    label_21:
        if(dataFetcher0 != null) {
            dataFetcher0.cleanup();
        }
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean z = false;
        while(!this.isCancelled && this.currentGenerator != null) {
            z = this.currentGenerator.startNext();
            if(z) {
                break;
            }
            this.stage = this.getNextStage(this.stage);
            this.currentGenerator = this.getNextGenerator();
            if(this.stage == Stage.SOURCE) {
                this.reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
            if(false) {
                break;
            }
        }
        if((this.stage == Stage.FINISHED || this.isCancelled) && !z) {
            this.notifyFailed();
        }
    }

    private Resource runLoadPath(Object object0, DataSource dataSource0, LoadPath loadPath0) {
        Options options0 = this.getOptionsWithHardwareConfig(dataSource0);
        DataRewinder dataRewinder0 = this.glideContext.getRegistry().getRewinder(object0);
        try {
            return loadPath0.load(dataRewinder0, options0, this.width, this.height, (Resource resource0) -> {
                DataCacheKey dataCacheKey0;
                EncodeStrategy encodeStrategy0;
                Resource resource1;
                Transformation transformation1;
                Class class0 = resource0.get().getClass();
                ResourceEncoder resourceEncoder0 = null;
                if(dataSource0 == DataSource.RESOURCE_DISK_CACHE) {
                    resource1 = resource0;
                    transformation1 = null;
                }
                else {
                    Transformation transformation0 = DecodeJob.this.decodeHelper.getTransformation(class0);
                    transformation1 = transformation0;
                    resource1 = transformation0.transform(DecodeJob.this.glideContext, resource0, DecodeJob.this.width, DecodeJob.this.height);
                }
                if(!resource0.equals(resource1)) {
                    resource0.recycle();
                }
                if(DecodeJob.this.decodeHelper.isResourceEncoderAvailable(resource1)) {
                    resourceEncoder0 = DecodeJob.this.decodeHelper.getResultEncoder(resource1);
                    encodeStrategy0 = resourceEncoder0.getEncodeStrategy(DecodeJob.this.options);
                }
                else {
                    encodeStrategy0 = EncodeStrategy.NONE;
                }
                boolean z = DecodeJob.this.decodeHelper.isSourceKey(DecodeJob.this.currentSourceKey);
                if(DecodeJob.this.diskCacheStrategy.isResourceCacheable(!z, dataSource0, encodeStrategy0)) {
                    if(resourceEncoder0 == null) {
                        throw new NoResultEncoderAvailableException(resource1.get().getClass());
                    }
                    switch(com.bumptech.glide.load.engine.DecodeJob.1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[encodeStrategy0.ordinal()]) {
                        case 1: {
                            dataCacheKey0 = new DataCacheKey(DecodeJob.this.currentSourceKey, DecodeJob.this.signature);
                            break;
                        }
                        case 2: {
                            dataCacheKey0 = new ResourceCacheKey(DecodeJob.this.decodeHelper.getArrayPool(), DecodeJob.this.currentSourceKey, DecodeJob.this.signature, DecodeJob.this.width, DecodeJob.this.height, transformation1, class0, DecodeJob.this.options);
                            break;
                        }
                        default: {
                            throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy0);
                        }
                    }
                    Resource resource2 = LockedResource.obtain(resource1);
                    DecodeJob.this.deferredEncodeManager.init(dataCacheKey0, resourceEncoder0, ((LockedResource)resource2));
                    return resource2;
                }
                return resource1;
            });
        }
        finally {
            dataRewinder0.cleanup();
        }
    }

    private void runWrapped() {
        switch(com.bumptech.glide.load.engine.DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()]) {
            case 1: {
                this.stage = this.getNextStage(Stage.INITIALIZE);
                this.currentGenerator = this.getNextGenerator();
                this.runGenerators();
                return;
            }
            case 2: {
                this.runGenerators();
                return;
            }
            case 3: {
                this.decodeFromRetrievedData();
                return;
            }
            default: {
                throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
            }
        }
    }

    private void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if(this.isCallbackNotified) {
            throw new IllegalStateException("Already notified", (this.throwables.isEmpty() ? null : ((Throwable)Z.h(1, this.throwables))));
        }
        this.isCallbackNotified = true;
    }

    public boolean willDecodeFromCache() {
        Stage decodeJob$Stage0 = this.getNextStage(Stage.INITIALIZE);
        return decodeJob$Stage0 == Stage.RESOURCE_CACHE || decodeJob$Stage0 == Stage.DATA_CACHE;
    }
}

