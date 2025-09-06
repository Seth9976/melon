package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;

public abstract class ResourceLeakDetectorFactory {
    static final class DefaultResourceLeakDetectorFactory extends ResourceLeakDetectorFactory {
        private final Constructor customClassConstructor;
        private final Constructor obsoleteCustomClassConstructor;

        public DefaultResourceLeakDetectorFactory() {
            String s;
            try {
                s = SystemPropertyUtil.get("io.netty.customResourceLeakDetector");
            }
            catch(Throwable throwable0) {
                ResourceLeakDetectorFactory.logger.error("Could not access System property: io.netty.customResourceLeakDetector", throwable0);
                s = null;
            }
            if(s == null) {
                this.customClassConstructor = null;
                this.obsoleteCustomClassConstructor = null;
                return;
            }
            this.obsoleteCustomClassConstructor = DefaultResourceLeakDetectorFactory.obsoleteCustomClassConstructor(s);
            this.customClassConstructor = DefaultResourceLeakDetectorFactory.customClassConstructor(s);
        }

        private static Constructor customClassConstructor(String s) {
            try {
                Class class0 = Class.forName(s, true, PlatformDependent.getSystemClassLoader());
                if(ResourceLeakDetector.class.isAssignableFrom(class0)) {
                    return class0.getConstructor(Class.class, Integer.TYPE);
                }
                ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", s);
                return null;
            }
            catch(Throwable throwable0) {
            }
            ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", s, throwable0);
            return null;
        }

        @Override  // io.netty.util.ResourceLeakDetectorFactory
        public ResourceLeakDetector newResourceLeakDetector(Class class0, int v) {
            Constructor constructor0 = this.customClassConstructor;
            if(constructor0 != null) {
                try {
                    ResourceLeakDetector resourceLeakDetector0 = (ResourceLeakDetector)constructor0.newInstance(class0, v);
                    ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.customClassConstructor.getDeclaringClass().getName());
                    return resourceLeakDetector0;
                }
                catch(Throwable throwable0) {
                    ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", new Object[]{this.customClassConstructor.getDeclaringClass().getName(), class0, throwable0});
                }
            }
            ResourceLeakDetector resourceLeakDetector1 = new ResourceLeakDetector(class0, v);
            ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", resourceLeakDetector1);
            return resourceLeakDetector1;
        }

        @Override  // io.netty.util.ResourceLeakDetectorFactory
        public ResourceLeakDetector newResourceLeakDetector(Class class0, int v, long v1) {
            Constructor constructor0 = this.obsoleteCustomClassConstructor;
            if(constructor0 != null) {
                try {
                    ResourceLeakDetector resourceLeakDetector0 = (ResourceLeakDetector)constructor0.newInstance(class0, v, v1);
                    ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.obsoleteCustomClassConstructor.getDeclaringClass().getName());
                    return resourceLeakDetector0;
                }
                catch(Throwable throwable0) {
                    ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", new Object[]{this.obsoleteCustomClassConstructor.getDeclaringClass().getName(), class0, throwable0});
                }
            }
            ResourceLeakDetector resourceLeakDetector1 = new ResourceLeakDetector(class0, v, v1);
            ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", resourceLeakDetector1);
            return resourceLeakDetector1;
        }

        private static Constructor obsoleteCustomClassConstructor(String s) {
            try {
                Class class0 = Class.forName(s, true, PlatformDependent.getSystemClassLoader());
                if(ResourceLeakDetector.class.isAssignableFrom(class0)) {
                    return class0.getConstructor(Class.class, Integer.TYPE, Long.TYPE);
                }
                ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", s);
                return null;
            }
            catch(Throwable throwable0) {
            }
            ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", s, throwable0);
            return null;
        }
    }

    private static volatile ResourceLeakDetectorFactory factoryInstance;
    private static final InternalLogger logger;

    static {
        ResourceLeakDetectorFactory.logger = InternalLoggerFactory.getInstance(ResourceLeakDetectorFactory.class);
        ResourceLeakDetectorFactory.factoryInstance = new DefaultResourceLeakDetectorFactory();
    }

    public static ResourceLeakDetectorFactory instance() {
        return ResourceLeakDetectorFactory.factoryInstance;
    }

    public final ResourceLeakDetector newResourceLeakDetector(Class class0) {
        return this.newResourceLeakDetector(class0, ResourceLeakDetector.SAMPLING_INTERVAL);
    }

    public ResourceLeakDetector newResourceLeakDetector(Class class0, int v) {
        ObjectUtil.checkPositive(v, "samplingInterval");
        return this.newResourceLeakDetector(class0, v, 0x7FFFFFFFFFFFFFFFL);
    }

    @Deprecated
    public abstract ResourceLeakDetector newResourceLeakDetector(Class arg1, int arg2, long arg3);

    public static void setResourceLeakDetectorFactory(ResourceLeakDetectorFactory resourceLeakDetectorFactory0) {
        ResourceLeakDetectorFactory.factoryInstance = (ResourceLeakDetectorFactory)ObjectUtil.checkNotNull(resourceLeakDetectorFactory0, "factory");
    }
}

