package io.netty.channel;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Constructor;

public class ReflectiveChannelFactory implements ChannelFactory {
    private final Constructor constructor;

    public ReflectiveChannelFactory(Class class0) {
        ObjectUtil.checkNotNull(class0, "clazz");
        try {
            this.constructor = class0.getConstructor(null);
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName(class0) + " does not have a public non-arg constructor", noSuchMethodException0);
        }
    }

    @Override  // io.netty.channel.ChannelFactory
    public Channel newChannel() {
        try {
            return (Channel)this.constructor.newInstance(null);
        }
        catch(Throwable throwable0) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), throwable0);
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return "ReflectiveChannelFactory" + '(' + StringUtil.simpleClassName(this.constructor.getDeclaringClass()) + ".class)";
    }
}

