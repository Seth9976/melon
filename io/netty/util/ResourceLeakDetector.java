package io.netty.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class ResourceLeakDetector {
    static final class DefaultResourceLeak extends WeakReference implements ResourceLeak, ResourceLeakTracker {
        static final boolean $assertionsDisabled;
        private final Set allLeaks;
        private volatile int droppedRecords;
        private static final AtomicIntegerFieldUpdater droppedRecordsUpdater;
        private volatile TraceRecord head;
        private static final AtomicReferenceFieldUpdater headUpdater;
        private final int trackedHash;

        static {
            DefaultResourceLeak.headUpdater = AtomicReferenceFieldUpdater.newUpdater(DefaultResourceLeak.class, TraceRecord.class, "head");
            DefaultResourceLeak.droppedRecordsUpdater = AtomicIntegerFieldUpdater.newUpdater(DefaultResourceLeak.class, "droppedRecords");
        }

        public DefaultResourceLeak(Object object0, ReferenceQueue referenceQueue0, Set set0, Object object1) {
            super(object0, referenceQueue0);
            this.trackedHash = System.identityHashCode(object0);
            set0.add(this);
            TraceRecord resourceLeakDetector$TraceRecord0 = object1 == null ? new TraceRecord(TraceRecord.access$100()) : new TraceRecord(TraceRecord.access$100(), object1);
            DefaultResourceLeak.headUpdater.set(this, resourceLeakDetector$TraceRecord0);
            this.allLeaks = set0;
        }

        @Override  // io.netty.util.ResourceLeak
        public boolean close() {
            if(this.allLeaks.remove(this)) {
                this.clear();
                DefaultResourceLeak.headUpdater.set(this, null);
                return true;
            }
            return false;
        }

        @Override  // io.netty.util.ResourceLeakTracker
        public boolean close(Object object0) {
            return this.close();
        }

        public boolean dispose() {
            this.clear();
            return this.allLeaks.remove(this);
        }

        private String generateReport(TraceRecord resourceLeakDetector$TraceRecord0) {
            if(resourceLeakDetector$TraceRecord0 == null) {
                return "";
            }
            int v = DefaultResourceLeak.droppedRecordsUpdater.get(this);
            int v1 = resourceLeakDetector$TraceRecord0.pos;
            int v2 = 1;
            StringBuilder stringBuilder0 = new StringBuilder((v1 + 1) * 0x800);
            stringBuilder0.append("\n");
            stringBuilder0.append("Recent access records: ");
            stringBuilder0.append("\n");
            HashSet hashSet0 = new HashSet(v1 + 1);
            int v3 = 0;
            while(resourceLeakDetector$TraceRecord0 != TraceRecord.BOTTOM) {
                if(!hashSet0.add("")) {
                    ++v3;
                }
                else if(resourceLeakDetector$TraceRecord0.next == TraceRecord.BOTTOM) {
                    stringBuilder0.append("Created at:");
                    stringBuilder0.append("\n");
                    stringBuilder0.append("");
                }
                else {
                    stringBuilder0.append('#');
                    stringBuilder0.append(v2);
                    stringBuilder0.append(':');
                    stringBuilder0.append("\n");
                    stringBuilder0.append("");
                    ++v2;
                }
                resourceLeakDetector$TraceRecord0 = resourceLeakDetector$TraceRecord0.next;
            }
            if(v3 > 0) {
                stringBuilder0.append(": ");
                stringBuilder0.append(v3);
                stringBuilder0.append(" leak records were discarded because they were duplicates");
                stringBuilder0.append("\n");
            }
            if(v > 0) {
                stringBuilder0.append(": ");
                stringBuilder0.append(v);
                stringBuilder0.append(" leak records were discarded because the leak record count is targeted to ");
                stringBuilder0.append(0);
                stringBuilder0.append(". Use system property io.netty.leakDetection.targetRecords to increase the limit.");
                stringBuilder0.append("\n");
            }
            stringBuilder0.setLength(stringBuilder0.length() - 1);
            return stringBuilder0.toString();
        }

        public String getReportAndClearRecords() {
            return this.generateReport(((TraceRecord)DefaultResourceLeak.headUpdater.getAndSet(this, null)));
        }

        private static void reachabilityFence0(Object object0) {
            if(object0 != null) {
            }
        }

        @Override  // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record() {
            this.record0(null);
        }

        @Override  // io.netty.util.ResourceLeakTracker, io.netty.util.ResourceLeak
        public void record(Object object0) {
            this.record0(object0);
        }

        // 去混淆评级： 中等(70)
        private void record0(Object object0) {
        }

        @Override
        public String toString() {
            return this.generateReport(((TraceRecord)DefaultResourceLeak.headUpdater.get(this)));
        }
    }

    public interface LeakListener {
        void onLeak(String arg1, String arg2);
    }

    public static enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID;

        public static Level parseLevel(String s) {
            String s1 = s.trim();
            Level[] arr_resourceLeakDetector$Level = Level.values();
            int v = 0;
            while(v < arr_resourceLeakDetector$Level.length) {
                Level resourceLeakDetector$Level0 = arr_resourceLeakDetector$Level[v];
                if(!s1.equalsIgnoreCase(resourceLeakDetector$Level0.name()) && !s1.equals(String.valueOf(resourceLeakDetector$Level0.ordinal()))) {
                    ++v;
                    continue;
                }
                return resourceLeakDetector$Level0;
            }
            return ResourceLeakDetector.DEFAULT_LEVEL;
        }
    }

    static class TraceRecord extends Throwable {
        private static final TraceRecord BOTTOM = null;
        private final String hintString;
        private final TraceRecord next;
        private final int pos;
        private static final long serialVersionUID = 0x542BC121FC24B620L;

        static {
            TraceRecord.BOTTOM = new TraceRecord() {
                private static final long serialVersionUID = 7396077602074694571L;

                {
                    super(null);
                }

                @Override
                public Throwable fillInStackTrace() {
                    return this;
                }
            };
        }

        private TraceRecord() {
            this.hintString = null;
            this.next = null;
            this.pos = -1;
        }

        public TraceRecord(io.netty.util.ResourceLeakDetector.1 resourceLeakDetector$10) {
        }

        public TraceRecord(TraceRecord resourceLeakDetector$TraceRecord0) {
            this.hintString = null;
            this.next = resourceLeakDetector$TraceRecord0;
            this.pos = resourceLeakDetector$TraceRecord0.pos + 1;
        }

        public TraceRecord(TraceRecord resourceLeakDetector$TraceRecord0, Object object0) {
            this.hintString = object0 instanceof ResourceLeakHint ? ((ResourceLeakHint)object0).toHintString() : object0.toString();
            this.next = resourceLeakDetector$TraceRecord0;
            this.pos = resourceLeakDetector$TraceRecord0.pos + 1;
        }

        @Override
        public String toString() [...] // 潜在的解密器
    }

    private static final Level DEFAULT_LEVEL = null;
    private static final int DEFAULT_SAMPLING_INTERVAL = 0x80;
    private static final int DEFAULT_TARGET_RECORDS = 4;
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_SAMPLING_INTERVAL = "io.netty.leakDetection.samplingInterval";
    private static final String PROP_TARGET_RECORDS = "io.netty.leakDetection.targetRecords";
    static final int SAMPLING_INTERVAL;
    private static final int TARGET_RECORDS;
    private final Set allLeaks;
    private static final AtomicReference excludedMethods;
    private volatile LeakListener leakListener;
    private static Level level;
    private static final InternalLogger logger;
    private final ReferenceQueue refQueue;
    private final Set reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;

    static {
        Level resourceLeakDetector$Level0 = Level.SIMPLE;
        ResourceLeakDetector.DEFAULT_LEVEL = resourceLeakDetector$Level0;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(ResourceLeakDetector.class);
        ResourceLeakDetector.logger = internalLogger0;
        boolean z = false;
        if(SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            internalLogger0.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z));
            internalLogger0.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use \'-D{}={}\' instead.", "io.netty.leakDetection.level", "disabled");
        }
        if(z) {
            resourceLeakDetector$Level0 = Level.DISABLED;
        }
        Level resourceLeakDetector$Level1 = Level.parseLevel(SystemPropertyUtil.get("io.netty.leakDetection.level", SystemPropertyUtil.get("io.netty.leakDetectionLevel", resourceLeakDetector$Level0.name())));
        int v = SystemPropertyUtil.getInt("io.netty.leakDetection.targetRecords", 4);
        ResourceLeakDetector.TARGET_RECORDS = v;
        ResourceLeakDetector.SAMPLING_INTERVAL = SystemPropertyUtil.getInt("io.netty.leakDetection.samplingInterval", 0x80);
        ResourceLeakDetector.level = resourceLeakDetector$Level1;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-D{}: {}", "io.netty.leakDetection.level", resourceLeakDetector$Level1.name().toLowerCase());
            internalLogger0.debug("-D{}: {}", "io.netty.leakDetection.targetRecords", v);
        }
        ResourceLeakDetector.excludedMethods = new AtomicReference(EmptyArrays.EMPTY_STRINGS);
    }

    @Deprecated
    public ResourceLeakDetector(Class class0) {
        this(StringUtil.simpleClassName(class0));
    }

    public ResourceLeakDetector(Class class0, int v) {
        this(StringUtil.simpleClassName(class0), v, 0x7FFFFFFFFFFFFFFFL);
    }

    @Deprecated
    public ResourceLeakDetector(Class class0, int v, long v1) {
        this(class0, v);
    }

    @Deprecated
    public ResourceLeakDetector(String s) {
        this(s, 0x80, 0x7FFFFFFFFFFFFFFFL);
    }

    @Deprecated
    public ResourceLeakDetector(String s, int v, long v1) {
        this.allLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.refQueue = new ReferenceQueue();
        this.reportedLeaks = Collections.newSetFromMap(new ConcurrentHashMap());
        this.resourceType = (String)ObjectUtil.checkNotNull(s, "resourceType");
        this.samplingInterval = v;
    }

    public static int access$200() [...] // 潜在的解密器

    public static void addExclusions(Class class0, String[] arr_s) {
        HashSet hashSet0 = new HashSet(Arrays.asList(arr_s));
        Method[] arr_method = class0.getDeclaredMethods();
        for(int v = 0; v < arr_method.length && (!hashSet0.remove(arr_method[v].getName()) || !hashSet0.isEmpty()); ++v) {
        }
        if(!hashSet0.isEmpty()) {
            throw new IllegalArgumentException("Can\'t find \'" + hashSet0 + "\' in " + class0.getName());
        }
        while(true) {
            String[] arr_s1 = (String[])ResourceLeakDetector.excludedMethods.get();
            String[] arr_s2 = (String[])Arrays.copyOf(arr_s1, arr_s.length * 2 + arr_s1.length);
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                arr_s2[arr_s1.length + v1 * 2] = class0.getName();
                arr_s2[arr_s1.length + v1 * 2 + 1] = arr_s[v1];
            }
            AtomicReference atomicReference0 = ResourceLeakDetector.excludedMethods;
        label_16:
            if(atomicReference0.compareAndSet(arr_s1, arr_s2)) {
                break;
            }
            if(atomicReference0.get() != arr_s1) {
                continue;
            }
            if(false) {
                break;
            }
            goto label_16;
        }
    }

    private void clearRefQueue() {
        DefaultResourceLeak resourceLeakDetector$DefaultResourceLeak0;
        while((resourceLeakDetector$DefaultResourceLeak0 = (DefaultResourceLeak)this.refQueue.poll()) != null) {
            resourceLeakDetector$DefaultResourceLeak0.dispose();
        }
    }

    public Object getInitialHint(String s) [...] // Inlined contents

    public static Level getLevel() {
        return ResourceLeakDetector.level;
    }

    public static boolean isEnabled() {
        return ResourceLeakDetector.getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    public boolean needReport() {
        return ResourceLeakDetector.logger.isErrorEnabled();
    }

    @Deprecated
    public final ResourceLeak open(Object object0) {
        return this.track0(object0, false);
    }

    @Deprecated
    public void reportInstancesLeak(String s) {
    }

    private void reportLeak() {
        if(!this.needReport()) {
            this.clearRefQueue();
            return;
        }
        DefaultResourceLeak resourceLeakDetector$DefaultResourceLeak0;
        while((resourceLeakDetector$DefaultResourceLeak0 = (DefaultResourceLeak)this.refQueue.poll()) != null) {
            if(resourceLeakDetector$DefaultResourceLeak0.dispose()) {
                String s = resourceLeakDetector$DefaultResourceLeak0.getReportAndClearRecords();
                if(this.reportedLeaks.add(s)) {
                    if(s.isEmpty()) {
                        this.reportUntracedLeak(this.resourceType);
                    }
                    else {
                        this.reportTracedLeak(this.resourceType, s);
                    }
                    LeakListener resourceLeakDetector$LeakListener0 = this.leakListener;
                    if(resourceLeakDetector$LeakListener0 != null) {
                        resourceLeakDetector$LeakListener0.onLeak(this.resourceType, s);
                    }
                }
            }
        }
    }

    public void reportTracedLeak(String s, String s1) {
        ResourceLeakDetector.logger.error("LEAK: {}.release() was not called before it\'s garbage-collected. See https://netty.io/wiki/reference-counted-objects.html for more information.{}", s, s1);
    }

    public void reportUntracedLeak(String s) {
        String s1 = StringUtil.simpleClassName(this);
        ResourceLeakDetector.logger.error("LEAK: {}.release() was not called before it\'s garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option \'-D{}={}\' or call {}.setLevel() See https://netty.io/wiki/reference-counted-objects.html for more information.", new Object[]{s, "io.netty.leakDetection.level", "advanced", s1});
    }

    @Deprecated
    public static void setEnabled(boolean z) {
        ResourceLeakDetector.setLevel((z ? Level.SIMPLE : Level.DISABLED));
    }

    public void setLeakListener(LeakListener resourceLeakDetector$LeakListener0) {
        this.leakListener = resourceLeakDetector$LeakListener0;
    }

    public static void setLevel(Level resourceLeakDetector$Level0) {
        ResourceLeakDetector.level = (Level)ObjectUtil.checkNotNull(resourceLeakDetector$Level0, "level");
    }

    public final ResourceLeakTracker track(Object object0) {
        return this.track0(object0, false);
    }

    private DefaultResourceLeak track0(Object object0, boolean z) {
        if(!z && ResourceLeakDetector.level != Level.PARANOID && (ResourceLeakDetector.level == Level.DISABLED || PlatformDependent.threadLocalRandom().nextInt(this.samplingInterval) != 0)) {
            return null;
        }
        this.reportLeak();
        return new DefaultResourceLeak(object0, this.refQueue, this.allLeaks, null);
    }

    public ResourceLeakTracker trackForcibly(Object object0) {
        return this.track0(object0, true);
    }

    class io.netty.util.ResourceLeakDetector.1 {
    }

}

