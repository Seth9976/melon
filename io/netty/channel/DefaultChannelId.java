package io.netty.channel;

import com.iloen.melon.custom.l1;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.MacAddressUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public final class DefaultChannelId implements ChannelId {
    static final boolean $assertionsDisabled = false;
    private static final byte[] MACHINE_ID = null;
    private static final int PROCESS_ID = 0;
    private static final int PROCESS_ID_LEN = 4;
    private static final int RANDOM_LEN = 4;
    private static final int SEQUENCE_LEN = 4;
    private static final int TIMESTAMP_LEN = 8;
    private final byte[] data;
    private final int hashCode;
    private static final InternalLogger logger = null;
    private transient String longValue;
    private static final AtomicInteger nextSequence = null;
    private static final long serialVersionUID = 0x35E702B5CE50B54FL;
    private transient String shortValue;

    static {
        int v1;
        DefaultChannelId.logger = InternalLoggerFactory.getInstance(DefaultChannelId.class);
        DefaultChannelId.nextSequence = new AtomicInteger();
        String s = SystemPropertyUtil.get("io.netty.processId");
        int v = -1;
        if(s != null) {
            try {
                v1 = -1;
                v1 = Integer.parseInt(s);
            }
            catch(NumberFormatException unused_ex) {
            }
            if(v1 < 0) {
                DefaultChannelId.logger.warn("-Dio.netty.processId: {} (malformed)", s);
            }
            else {
                InternalLogger internalLogger0 = DefaultChannelId.logger;
                if(internalLogger0.isDebugEnabled()) {
                    internalLogger0.debug("-Dio.netty.processId: {} (user-set)", v1);
                }
                v = v1;
            }
        }
        if(v < 0) {
            v = DefaultChannelId.defaultProcessId();
            InternalLogger internalLogger1 = DefaultChannelId.logger;
            if(internalLogger1.isDebugEnabled()) {
                internalLogger1.debug("-Dio.netty.processId: {} (auto-detected)", v);
            }
        }
        DefaultChannelId.PROCESS_ID = v;
        String s1 = SystemPropertyUtil.get("io.netty.machineId");
        byte[] arr_b = null;
        if(s1 != null) {
            try {
                arr_b = MacAddressUtil.parseMAC(s1);
            }
            catch(Exception exception0) {
                DefaultChannelId.logger.warn("-Dio.netty.machineId: {} (malformed)", s1, exception0);
            }
            if(arr_b != null) {
                DefaultChannelId.logger.debug("-Dio.netty.machineId: {} (user-set)", s1);
            }
        }
        if(arr_b == null) {
            arr_b = MacAddressUtil.defaultMachineId();
            InternalLogger internalLogger2 = DefaultChannelId.logger;
            if(internalLogger2.isDebugEnabled()) {
                internalLogger2.debug("-Dio.netty.machineId: {} (auto-detected)", MacAddressUtil.formatAddress(arr_b));
            }
        }
        DefaultChannelId.MACHINE_ID = arr_b;
    }

    private DefaultChannelId() {
        byte[] arr_b = new byte[DefaultChannelId.MACHINE_ID.length + 20];
        this.data = arr_b;
        System.arraycopy(DefaultChannelId.MACHINE_ID, 0, arr_b, 0, DefaultChannelId.MACHINE_ID.length);
        this.writeInt(this.writeLong(this.writeInt(this.writeInt(DefaultChannelId.MACHINE_ID.length, DefaultChannelId.PROCESS_ID), DefaultChannelId.nextSequence.getAndIncrement()), Long.reverse(System.nanoTime()) ^ System.currentTimeMillis()), PlatformDependent.threadLocalRandom().nextInt());
        this.hashCode = Arrays.hashCode(arr_b);
    }

    private int appendHexDumpField(StringBuilder stringBuilder0, int v, int v1) {
        stringBuilder0.append(ByteBufUtil.hexDump(this.data, v, v1));
        stringBuilder0.append('-');
        return v + v1;
    }

    @Override  // io.netty.channel.ChannelId
    public String asLongText() {
        String s = this.longValue;
        if(s == null) {
            s = this.newLongValue();
            this.longValue = s;
        }
        return s;
    }

    @Override  // io.netty.channel.ChannelId
    public String asShortText() {
        String s = this.shortValue;
        if(s == null) {
            s = ByteBufUtil.hexDump(this.data, this.data.length - 4, 4);
            this.shortValue = s;
        }
        return s;
    }

    public int compareTo(ChannelId channelId0) {
        if(this == channelId0) {
            return 0;
        }
        if(channelId0 instanceof DefaultChannelId) {
            byte[] arr_b = ((DefaultChannelId)channelId0).data;
            int v1 = Math.min(this.data.length, arr_b.length);
            for(int v = 0; v < v1; ++v) {
                int v2 = this.data[v];
                int v3 = arr_b[v];
                if(v2 != v3) {
                    return (v2 & 0xFF) - (v3 & 0xFF);
                }
            }
            return this.data.length - arr_b.length;
        }
        return this.asLongText().compareTo(channelId0.asLongText());
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((ChannelId)object0));
    }

    public static int defaultProcessId() {
        ClassLoader classLoader0 = PlatformDependent.getClassLoader(DefaultChannelId.class);
        int v = DefaultChannelId.processHandlePid(classLoader0);
        return v == -1 ? DefaultChannelId.jmxPid(classLoader0) : v;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DefaultChannelId ? this.hashCode == ((DefaultChannelId)object0).hashCode && Arrays.equals(this.data, ((DefaultChannelId)object0).data) : false;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    public static int jmxPid(ClassLoader classLoader0) {
        int v1;
        String s;
        try {
            Class class0 = Class.forName("java.lang.management.ManagementFactory", true, classLoader0);
            Class class1 = Class.forName("java.lang.management.RuntimeMXBean", true, classLoader0);
            Object object0 = class0.getMethod("getRuntimeMXBean", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS);
            s = (String)class1.getMethod("getName", EmptyArrays.EMPTY_CLASSES).invoke(object0, EmptyArrays.EMPTY_OBJECTS);
        }
        catch(Throwable throwable0) {
            DefaultChannelId.logger.debug("Could not invoke ManagementFactory.getRuntimeMXBean().getName(); Android?", throwable0);
            try {
                s = Class.forName("android.os.Process", true, classLoader0).getMethod("myPid", EmptyArrays.EMPTY_CLASSES).invoke(null, EmptyArrays.EMPTY_OBJECTS).toString();
            }
            catch(Throwable throwable1) {
                DefaultChannelId.logger.debug("Could not invoke Process.myPid(); not Android?", throwable1);
                s = "";
            }
        }
        int v = s.indexOf(0x40);
        if(v >= 0) {
            s = s.substring(0, v);
        }
        try {
            v1 = -1;
            v1 = Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
        }
        if(v1 < 0) {
            v1 = PlatformDependent.threadLocalRandom().nextInt();
            DefaultChannelId.logger.warn("Failed to find the current process ID from \'{}\'; using a random value: {}", s, v1);
        }
        return v1;
    }

    public static DefaultChannelId newInstance() {
        return new DefaultChannelId();
    }

    private String newLongValue() {
        StringBuilder stringBuilder0 = new StringBuilder(this.data.length * 2 + 5);
        this.appendHexDumpField(stringBuilder0, this.appendHexDumpField(stringBuilder0, this.appendHexDumpField(stringBuilder0, this.appendHexDumpField(stringBuilder0, this.appendHexDumpField(stringBuilder0, 0, DefaultChannelId.MACHINE_ID.length), 4), 4), 8), 4);
        return l1.q(stringBuilder0, 1, 0);
    }

    public static int processHandlePid(ClassLoader classLoader0) {
        Long long0;
        if(PlatformDependent.javaVersion() >= 9) {
            try {
                Class class0 = Class.forName("java.lang.ProcessHandle", true, classLoader0);
                long0 = (Long)class0.getMethod("pid", null).invoke(class0.getMethod("current", null).invoke(null, null), null);
            }
            catch(Exception exception0) {
                DefaultChannelId.logger.debug("Could not invoke ProcessHandle.current().pid();", exception0);
                return -1;
            }
            if(((long)long0) > 0x7FFFFFFFL || ((long)long0) < 0xFFFFFFFF80000000L) {
                throw new IllegalStateException("Current process ID exceeds int range: " + long0);
            }
            return long0.intValue();
        }
        return -1;
    }

    @Override
    public String toString() {
        return this.asShortText();
    }

    private int writeInt(int v, int v1) {
        this.data[v] = (byte)(v1 >>> 24);
        this.data[v + 1] = (byte)(v1 >>> 16);
        this.data[v + 2] = (byte)(v1 >>> 8);
        this.data[v + 3] = (byte)v1;
        return v + 4;
    }

    private int writeLong(int v, long v1) {
        this.data[v] = (byte)(((int)(v1 >>> 56)));
        this.data[v + 1] = (byte)(((int)(v1 >>> 0x30)));
        this.data[v + 2] = (byte)(((int)(v1 >>> 40)));
        this.data[v + 3] = (byte)(((int)(v1 >>> 0x20)));
        this.data[v + 4] = (byte)(((int)(v1 >>> 24)));
        this.data[v + 5] = (byte)(((int)(v1 >>> 16)));
        this.data[v + 6] = (byte)(((int)(v1 >>> 8)));
        this.data[v + 7] = (byte)(((int)v1));
        return v + 8;
    }
}

