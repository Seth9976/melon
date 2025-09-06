package io.netty.bootstrap;

import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ServiceLoader;

abstract class ChannelInitializerExtensions {
    static final class EmptyExtensions extends ChannelInitializerExtensions {
        private EmptyExtensions() {
            super(null);
        }

        public EmptyExtensions(io.netty.bootstrap.ChannelInitializerExtensions.1 channelInitializerExtensions$10) {
        }

        @Override  // io.netty.bootstrap.ChannelInitializerExtensions
        public Collection extensions(ClassLoader classLoader0) {
            return Collections.EMPTY_LIST;
        }
    }

    static final class ServiceLoadingExtensions extends ChannelInitializerExtensions {
        private WeakReference classLoader;
        private Collection extensions;
        private final boolean loadAndCache;
        private final InternalLogLevel logLevel;

        public ServiceLoadingExtensions(InternalLogLevel internalLogLevel0, boolean z) {
            super(null);
            this.logLevel = internalLogLevel0;
            this.loadAndCache = z;
        }

        @Override  // io.netty.bootstrap.ChannelInitializerExtensions
        public Collection extensions(ClassLoader classLoader0) {
            synchronized(this) {
                ClassLoader classLoader1 = this.classLoader == null ? null : ((ClassLoader)this.classLoader.get());
                if(classLoader1 == null || classLoader1 != classLoader0) {
                    Collection collection0 = ServiceLoadingExtensions.serviceLoadExtensions(this.logLevel, classLoader0);
                    this.classLoader = new WeakReference(classLoader0);
                    if(!this.loadAndCache) {
                        collection0 = Collections.EMPTY_LIST;
                    }
                    this.extensions = collection0;
                }
                return this.extensions;
            }
        }

        private static Collection serviceLoadExtensions(InternalLogLevel internalLogLevel0, ClassLoader classLoader0) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: ServiceLoader.load(ChannelInitializerExtension.class, classLoader0)) {
                ChannelInitializerExtensions.logger.log(internalLogLevel0, "Loaded extension: {}", ((ChannelInitializerExtension)object0).getClass());
                arrayList0.add(((ChannelInitializerExtension)object0));
            }
            if(!arrayList0.isEmpty()) {
                Collections.sort(arrayList0, new Comparator() {
                    public int compare(ChannelInitializerExtension channelInitializerExtension0, ChannelInitializerExtension channelInitializerExtension1) {
                        return 0;
                    }

                    @Override
                    public int compare(Object object0, Object object1) {
                        return this.compare(((ChannelInitializerExtension)object0), ((ChannelInitializerExtension)object1));
                    }
                });
                return Collections.unmodifiableList(arrayList0);
            }
            return Collections.EMPTY_LIST;
        }
    }

    private static volatile ChannelInitializerExtensions implementation;
    private static final InternalLogger logger;

    static {
        ChannelInitializerExtensions.logger = InternalLoggerFactory.getInstance(ChannelInitializerExtensions.class);
    }

    private ChannelInitializerExtensions() {
    }

    public ChannelInitializerExtensions(io.netty.bootstrap.ChannelInitializerExtensions.1 channelInitializerExtensions$10) {
    }

    public abstract Collection extensions(ClassLoader arg1);

    public static ChannelInitializerExtensions getExtensions() {
        ChannelInitializerExtensions channelInitializerExtensions2;
        ChannelInitializerExtensions channelInitializerExtensions0 = ChannelInitializerExtensions.implementation;
        if(channelInitializerExtensions0 == null) {
            synchronized(ChannelInitializerExtensions.class) {
                ChannelInitializerExtensions channelInitializerExtensions1 = ChannelInitializerExtensions.implementation;
                if(channelInitializerExtensions1 != null) {
                    return channelInitializerExtensions1;
                }
                String s = SystemPropertyUtil.get("io.netty.bootstrap.extensions");
                ChannelInitializerExtensions.logger.debug("-Dio.netty.bootstrap.extensions: {}", s);
                if("serviceload".equalsIgnoreCase(s)) {
                    channelInitializerExtensions2 = new ServiceLoadingExtensions(InternalLogLevel.DEBUG, true);
                }
                else if("log".equalsIgnoreCase(s)) {
                    channelInitializerExtensions2 = new ServiceLoadingExtensions(InternalLogLevel.INFO, false);
                }
                else {
                    channelInitializerExtensions2 = new EmptyExtensions(null);
                }
                ChannelInitializerExtensions.implementation = channelInitializerExtensions2;
                return channelInitializerExtensions2;
            }
        }
        return channelInitializerExtensions0;
    }

    class io.netty.bootstrap.ChannelInitializerExtensions.1 {
    }

}

