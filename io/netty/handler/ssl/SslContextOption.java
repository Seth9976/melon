package io.netty.handler.ssl;

import io.netty.util.AbstractConstant;
import io.netty.util.Constant;
import io.netty.util.ConstantPool;
import io.netty.util.internal.ObjectUtil;

public class SslContextOption extends AbstractConstant {
    private static final ConstantPool pool;

    static {
        SslContextOption.pool = new ConstantPool() {
            public SslContextOption newConstant(int v, String s) {
                return new SslContextOption(v, s, null);
            }

            @Override  // io.netty.util.ConstantPool
            public Constant newConstant(int v, String s) {
                return this.newConstant(v, s);
            }
        };
    }

    private SslContextOption(int v, String s) {
        super(v, s);
    }

    public SslContextOption(int v, String s, io.netty.handler.ssl.SslContextOption.1 sslContextOption$10) {
        this(v, s);
    }

    public SslContextOption(String s) {
        this(SslContextOption.pool.nextId(), s);
    }

    public static boolean exists(String s) {
        return SslContextOption.pool.exists(s);
    }

    public void validate(Object object0) {
        ObjectUtil.checkNotNull(object0, "value");
    }

    public static SslContextOption valueOf(Class class0, String s) {
        return (SslContextOption)SslContextOption.pool.valueOf(class0, s);
    }

    public static SslContextOption valueOf(String s) {
        return (SslContextOption)SslContextOption.pool.valueOf(s);
    }
}

