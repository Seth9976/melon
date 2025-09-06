package io.netty.util.internal;

import io.netty.util.concurrent.FastThreadLocalThread;
import java.util.function.Function;
import java.util.function.Predicate;
import reactor.blockhound.BlockHound.Builder;
import reactor.blockhound.integration.BlockHoundIntegration;

class Hidden {
    @SuppressJava6Requirement(reason = "BlockHound is Java 8+, but this class is only loaded by it\'s SPI")
    public static final class NettyBlockHoundIntegration implements BlockHoundIntegration {
        public void applyTo(BlockHound.Builder blockHound$Builder0) {
            blockHound$Builder0.allowBlockingCallsInside("io.netty.channel.nio.NioEventLoop", "handleLoopException");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.channel.kqueue.KQueueEventLoop", "handleLoopException");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.channel.epoll.EpollEventLoop", "handleLoopException");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.HashedWheelTimer", "start");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.HashedWheelTimer", "stop");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.HashedWheelTimer$Worker", "waitForNextTick");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "confirmShutdown");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.buffer.PoolArena", "lock");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.buffer.PoolSubpage", "lock");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.buffer.PoolChunk", "allocateRun");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.buffer.PoolChunk", "free");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "handshake");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "runAllDelegatedTasks");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.handler.ssl.SslHandler", "runDelegatedTasks");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.concurrent.GlobalEventExecutor", "takeTask");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.concurrent.GlobalEventExecutor", "addTask");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "takeTask");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.concurrent.SingleThreadEventExecutor", "addTask");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.handler.ssl.ReferenceCountedOpenSslClientContext$ExtendedTrustManagerVerifyCallback", "verify");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.handler.ssl.JdkSslContext$Defaults", "init");
            blockHound$Builder0.allowBlockingCallsInside("sun.security.ssl.SSLEngineImpl", "unwrap");
            blockHound$Builder0.allowBlockingCallsInside("sun.security.ssl.SSLEngineImpl", "wrap");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider", "parse");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider", "parseEtcResolverSearchDomains");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider", "parseEtcResolverOptions");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.resolver.HostsFileEntriesProvider$ParserImpl", "parse");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.NetUtil$SoMaxConnAction", "run");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.internal.ReferenceCountUpdater", "retryRelease0");
            blockHound$Builder0.allowBlockingCallsInside("io.netty.util.internal.PlatformDependent", "createTempFile");
            blockHound$Builder0.nonBlockingThreadPredicate(new Function() {
                @Override
                public Object apply(Object object0) {
                    return this.apply(((Predicate)object0));
                }

                public Predicate apply(Predicate predicate0) {
                    return new Predicate() {
                        @Override
                        @SuppressJava6Requirement(reason = "Predicate#test")
                        public boolean test(Object object0) {
                            return this.test(((Thread)object0));
                        }

                        // 去混淆评级： 中等(50)
                        @SuppressJava6Requirement(reason = "Predicate#test")
                        public boolean test(Thread thread0) {
                            return predicate0.test(thread0) || thread0 instanceof FastThreadLocalThread;
                        }
                    };
                }
            });
        }

        public int compareTo(Object object0) {
            return this.compareTo(((BlockHoundIntegration)object0));
        }

        public int compareTo(BlockHoundIntegration blockHoundIntegration0) {
            return 0;
        }
    }

}

