package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.util.AsyncMapping;
import io.netty.util.DomainNameMapping;
import io.netty.util.Mapping;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;

public class SniHandler extends AbstractSniHandler {
    static final class AsyncMappingAdapter implements AsyncMapping {
        private final Mapping mapping;

        private AsyncMappingAdapter(Mapping mapping0) {
            this.mapping = (Mapping)ObjectUtil.checkNotNull(mapping0, "mapping");
        }

        public AsyncMappingAdapter(Mapping mapping0, io.netty.handler.ssl.SniHandler.1 sniHandler$10) {
            this(mapping0);
        }

        @Override  // io.netty.util.AsyncMapping
        public Future map(Object object0, Promise promise0) {
            return this.map(((String)object0), promise0);
        }

        public Future map(String s, Promise promise0) {
            try {
                return promise0.setSuccess(((SslContext)this.mapping.map(s)));
            }
            catch(Throwable throwable0) {
                return promise0.setFailure(throwable0);
            }
        }
    }

    static final class Selection {
        final SslContext context;
        final String hostname;

        public Selection(SslContext sslContext0, String s) {
            this.context = sslContext0;
            this.hostname = s;
        }
    }

    private static final Selection EMPTY_SELECTION;
    protected final AsyncMapping mapping;
    private volatile Selection selection;

    static {
        SniHandler.EMPTY_SELECTION = new Selection(null, null);
    }

    public SniHandler(AsyncMapping asyncMapping0) {
        this(asyncMapping0, 0, 0L);
    }

    public SniHandler(AsyncMapping asyncMapping0, int v, long v1) {
        super(v, v1);
        this.selection = SniHandler.EMPTY_SELECTION;
        this.mapping = (AsyncMapping)ObjectUtil.checkNotNull(asyncMapping0, "mapping");
    }

    public SniHandler(AsyncMapping asyncMapping0, long v) {
        this(asyncMapping0, 0, v);
    }

    public SniHandler(DomainNameMapping domainNameMapping0) {
        this(domainNameMapping0);
    }

    public SniHandler(Mapping mapping0) {
        this(new AsyncMappingAdapter(mapping0, null));
    }

    public SniHandler(Mapping mapping0, int v, long v1) {
        this(new AsyncMappingAdapter(mapping0, null), v, v1);
    }

    public SniHandler(Mapping mapping0, long v) {
        this(new AsyncMappingAdapter(mapping0, null), v);
    }

    public String hostname() {
        return this.selection.hostname;
    }

    @Override  // io.netty.handler.ssl.AbstractSniHandler
    public Future lookup(ChannelHandlerContext channelHandlerContext0, String s) {
        Promise promise0 = channelHandlerContext0.executor().newPromise();
        return this.mapping.map(s, promise0);
    }

    public SslHandler newSslHandler(SslContext sslContext0, ByteBufAllocator byteBufAllocator0) {
        SslHandler sslHandler0 = sslContext0.newHandler(byteBufAllocator0);
        sslHandler0.setHandshakeTimeoutMillis(this.handshakeTimeoutMillis);
        return sslHandler0;
    }

    @Override  // io.netty.handler.ssl.AbstractSniHandler
    public final void onLookupComplete(ChannelHandlerContext channelHandlerContext0, String s, Future future0) {
        if(!future0.isSuccess()) {
            Throwable throwable0 = future0.cause();
            if(!(throwable0 instanceof Error)) {
                throw new DecoderException("failed to get the SslContext for " + s, throwable0);
            }
            throw (Error)throwable0;
        }
        SslContext sslContext0 = (SslContext)future0.getNow();
        this.selection = new Selection(sslContext0, s);
        try {
            this.replaceHandler(channelHandlerContext0, s, sslContext0);
        }
        catch(Throwable throwable1) {
            this.selection = SniHandler.EMPTY_SELECTION;
            PlatformDependent.throwException(throwable1);
        }
        return;
    }

    public void replaceHandler(ChannelHandlerContext channelHandlerContext0, String s, SslContext sslContext0) {
        SslHandler sslHandler0 = null;
        try {
            sslHandler0 = this.newSslHandler(sslContext0, channelHandlerContext0.alloc());
            channelHandlerContext0.pipeline().replace(this, SslHandler.class.getName(), sslHandler0);
        }
        catch(Throwable throwable0) {
            if(sslHandler0 != null) {
                ReferenceCountUtil.safeRelease(sslHandler0.engine());
            }
            throw throwable0;
        }
    }

    public SslContext sslContext() {
        return this.selection.context;
    }

    class io.netty.handler.ssl.SniHandler.1 {
    }

}

