package io.netty.channel.socket.nio;

import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.DatagramChannelConfig;
import io.netty.channel.socket.DefaultDatagramChannelConfig;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;
import java.util.Enumeration;
import java.util.Map;

class NioDatagramChannelConfig extends DefaultDatagramChannelConfig {
    private static final Method GET_OPTION;
    private static final Object IP_MULTICAST_IF;
    private static final Object IP_MULTICAST_LOOP;
    private static final Object IP_MULTICAST_TTL;
    private static final Method SET_OPTION;
    private final DatagramChannel javaChannel;

    static {
        Method method2;
        Method method1;
        Method method0;
        Class class2;
        Object object3;
        Object object2;
        Object object1;
        Class class1;
        Class class0;
        ClassLoader classLoader0 = PlatformDependent.getClassLoader(DatagramChannel.class);
        Object object0 = null;
        try {
            class0 = null;
            class0 = Class.forName("java.net.SocketOption", true, classLoader0);
            class1 = null;
        }
        catch(Exception unused_ex) {
        }
        try {
            class1 = Class.forName("java.net.StandardSocketOptions", true, classLoader0);
        }
        catch(Exception unused_ex) {
        }
        if(class0 == null) {
            method0 = null;
            method1 = null;
            object3 = null;
            object2 = null;
        }
        else {
            try {
                object1 = class1.getDeclaredField("IP_MULTICAST_TTL").get(null);
            }
            catch(Exception exception0) {
                throw new Error("cannot locate the IP_MULTICAST_TTL field", exception0);
            }
            try {
                object2 = class1.getDeclaredField("IP_MULTICAST_IF").get(null);
            }
            catch(Exception exception1) {
                throw new Error("cannot locate the IP_MULTICAST_IF field", exception1);
            }
            try {
                object3 = class1.getDeclaredField("IP_MULTICAST_LOOP").get(null);
            }
            catch(Exception exception2) {
                throw new Error("cannot locate the IP_MULTICAST_LOOP field", exception2);
            }
            try {
                class2 = null;
                class2 = Class.forName("java.nio.channels.NetworkChannel", true, classLoader0);
            }
            catch(Throwable unused_ex) {
            }
            if(class2 == null) {
                method0 = null;
                method1 = null;
            }
            else {
                try {
                    method2 = class2.getDeclaredMethod("getOption", class0);
                }
                catch(Exception exception3) {
                    throw new Error("cannot locate the getOption() method", exception3);
                }
                try {
                    method1 = class2.getDeclaredMethod("setOption", class0, Object.class);
                    method0 = method2;
                }
                catch(Exception exception4) {
                    throw new Error("cannot locate the setOption() method", exception4);
                }
            }
            object0 = object1;
        }
        NioDatagramChannelConfig.IP_MULTICAST_TTL = object0;
        NioDatagramChannelConfig.IP_MULTICAST_IF = object2;
        NioDatagramChannelConfig.IP_MULTICAST_LOOP = object3;
        NioDatagramChannelConfig.GET_OPTION = method0;
        NioDatagramChannelConfig.SET_OPTION = method1;
    }

    public NioDatagramChannelConfig(NioDatagramChannel nioDatagramChannel0, DatagramChannel datagramChannel0) {
        super(nioDatagramChannel0, datagramChannel0.socket());
        this.javaChannel = datagramChannel0;
    }

    @Override  // io.netty.channel.DefaultChannelConfig
    public void autoReadCleared() {
        ((NioDatagramChannel)this.channel).clearReadPending0();
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public InetAddress getInterface() {
        NetworkInterface networkInterface0 = this.getNetworkInterface();
        if(networkInterface0 != null) {
            Enumeration enumeration0 = SocketUtils.addressesFromNetworkInterface(networkInterface0);
            return enumeration0.hasMoreElements() ? ((InetAddress)enumeration0.nextElement()) : null;
        }
        return null;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public NetworkInterface getNetworkInterface() {
        return (NetworkInterface)this.getOption0(NioDatagramChannelConfig.IP_MULTICAST_IF);
    }

    // 去混淆评级： 低(30)
    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public Object getOption(ChannelOption channelOption0) {
        return super.getOption(channelOption0);
    }

    private Object getOption0(Object object0) {
        Method method0 = NioDatagramChannelConfig.GET_OPTION;
        if(method0 != null) {
            try {
                return method0.invoke(this.javaChannel, object0);
            }
            catch(Exception exception0) {
                throw new ChannelException(exception0);
            }
        }
        throw new UnsupportedOperationException();
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public Map getOptions() {
        return super.getOptions();
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public int getTimeToLive() {
        return (int)(((Integer)this.getOption0(NioDatagramChannelConfig.IP_MULTICAST_TTL)));
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public boolean isLoopbackModeDisabled() {
        return ((Boolean)this.getOption0(NioDatagramChannelConfig.IP_MULTICAST_LOOP)).booleanValue();
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public ChannelConfig setAutoRead(boolean z) {
        return this.setAutoRead(z);
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setAutoRead(boolean z) {
        super.setAutoRead(z);
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setInterface(InetAddress inetAddress0) {
        try {
            this.setNetworkInterface(NetworkInterface.getByInetAddress(inetAddress0));
            return this;
        }
        catch(SocketException socketException0) {
            throw new ChannelException(socketException0);
        }
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setLoopbackModeDisabled(boolean z) {
        this.setOption0(NioDatagramChannelConfig.IP_MULTICAST_LOOP, Boolean.valueOf(z));
        return this;
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setNetworkInterface(NetworkInterface networkInterface0) {
        this.setOption0(NioDatagramChannelConfig.IP_MULTICAST_IF, networkInterface0);
        return this;
    }

    // 去混淆评级： 低(30)
    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public boolean setOption(ChannelOption channelOption0, Object object0) {
        return super.setOption(channelOption0, object0);
    }

    private void setOption0(Object object0, Object object1) {
        Method method0 = NioDatagramChannelConfig.SET_OPTION;
        if(method0 != null) {
            try {
                method0.invoke(this.javaChannel, object0, object1);
                return;
            }
            catch(Exception exception0) {
                throw new ChannelException(exception0);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.channel.socket.DefaultDatagramChannelConfig
    public DatagramChannelConfig setTimeToLive(int v) {
        this.setOption0(NioDatagramChannelConfig.IP_MULTICAST_TTL, v);
        return this;
    }
}

