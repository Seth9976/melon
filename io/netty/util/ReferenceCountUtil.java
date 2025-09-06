package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class ReferenceCountUtil {
    static final class ReleasingTask implements Runnable {
        private final int decrement;
        private final ReferenceCounted obj;

        public ReleasingTask(ReferenceCounted referenceCounted0, int v) {
            this.obj = referenceCounted0;
            this.decrement = v;
        }

        @Override
        public void run() {
            try {
                if(!this.obj.release(this.decrement)) {
                    ReferenceCountUtil.logger.warn("Non-zero refCnt: {}", this);
                    return;
                }
                ReferenceCountUtil.logger.debug("Released: {}", this);
                return;
            }
            catch(Exception exception0) {
            }
            ReferenceCountUtil.logger.warn("Failed to release an object: {}", this.obj, exception0);
        }

        @Override
        public String toString() {
            return StringUtil.simpleClassName(this.obj) + ".release(" + this.decrement + ") refCnt: " + this.obj.refCnt();
        }
    }

    private static final InternalLogger logger;

    static {
        ReferenceCountUtil.logger = InternalLoggerFactory.getInstance(ReferenceCountUtil.class);
        ResourceLeakDetector.addExclusions(ReferenceCountUtil.class, new String[]{"touch"});
    }

    // 去混淆评级： 低(20)
    public static int refCnt(Object object0) {
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).refCnt() : -1;
    }

    // 去混淆评级： 低(20)
    public static boolean release(Object object0) {
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).release() : false;
    }

    public static boolean release(Object object0, int v) {
        ObjectUtil.checkPositive(v, "decrement");
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).release(v) : false;
    }

    @Deprecated
    public static Object releaseLater(Object object0) {
        return ReferenceCountUtil.releaseLater(object0, 1);
    }

    @Deprecated
    public static Object releaseLater(Object object0, int v) {
        ObjectUtil.checkPositive(v, "decrement");
        if(object0 instanceof ReferenceCounted) {
            ThreadDeathWatcher.watch(Thread.currentThread(), new ReleasingTask(((ReferenceCounted)object0), v));
        }
        return object0;
    }

    public static Object retain(Object object0) {
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).retain() : object0;
    }

    public static Object retain(Object object0, int v) {
        ObjectUtil.checkPositive(v, "increment");
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).retain(v) : object0;
    }

    public static void safeRelease(Object object0) {
        try {
            ReferenceCountUtil.release(object0);
        }
        catch(Throwable throwable0) {
            ReferenceCountUtil.logger.warn("Failed to release a message: {}", object0, throwable0);
        }
    }

    public static void safeRelease(Object object0, int v) {
        try {
            ObjectUtil.checkPositive(v, "decrement");
            ReferenceCountUtil.release(object0, v);
        }
        catch(Throwable throwable0) {
            InternalLogger internalLogger0 = ReferenceCountUtil.logger;
            if(internalLogger0.isWarnEnabled()) {
                internalLogger0.warn("Failed to release a message: {} (decrement: {})", new Object[]{object0, v, throwable0});
            }
        }
    }

    public static Object touch(Object object0) {
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).touch() : object0;
    }

    public static Object touch(Object object0, Object object1) {
        return object0 instanceof ReferenceCounted ? ((ReferenceCounted)object0).touch(object1) : object0;
    }
}

