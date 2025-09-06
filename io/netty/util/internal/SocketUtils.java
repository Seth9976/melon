package io.netty.util.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.Enumeration;

public final class SocketUtils {
    private static final Enumeration EMPTY;

    static {
        SocketUtils.EMPTY = Collections.enumeration(Collections.EMPTY_LIST);
    }

    public static SocketChannel accept(ServerSocketChannel serverSocketChannel0) {
        try {
            return (SocketChannel)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public SocketChannel run() {
                    return serverSocketChannel0.accept();
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getCause();
        }
    }

    public static InetAddress addressByName(String s) {
        try {
            return (InetAddress)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public InetAddress run() {
                    return InetAddress.getByName(s);
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (UnknownHostException)privilegedActionException0.getCause();
        }
    }

    public static Enumeration addressesFromNetworkInterface(NetworkInterface networkInterface0) {
        Enumeration enumeration0 = (Enumeration)AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                return this.run();
            }

            public Enumeration run() {
                return networkInterface0.getInetAddresses();
            }
        });
        return enumeration0 == null ? SocketUtils.empty() : enumeration0;
    }

    public static InetAddress[] allAddressesByName(String s) {
        try {
            return (InetAddress[])AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public InetAddress[] run() {
                    return InetAddress.getAllByName(s);
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (UnknownHostException)privilegedActionException0.getCause();
        }
    }

    public static void bind(Socket socket0, SocketAddress socketAddress0) {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    socket0.bind(socketAddress0);
                    return null;
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getCause();
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void bind(DatagramChannel datagramChannel0, SocketAddress socketAddress0) {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    datagramChannel0.bind(socketAddress0);
                    return null;
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getCause();
        }
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static void bind(SocketChannel socketChannel0, SocketAddress socketAddress0) {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    socketChannel0.bind(socketAddress0);
                    return null;
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getCause();
        }
    }

    public static void connect(Socket socket0, SocketAddress socketAddress0, int v) {
        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public Void run() {
                    socket0.connect(socketAddress0, v);
                    return null;
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getCause();
        }
    }

    public static boolean connect(SocketChannel socketChannel0, SocketAddress socketAddress0) {
        try {
            return ((Boolean)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Boolean run() {
                    return Boolean.valueOf(socketChannel0.connect(socketAddress0));
                }

                @Override
                public Object run() {
                    return this.run();
                }
            })).booleanValue();
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (IOException)privilegedActionException0.getCause();
        }
    }

    private static Enumeration empty() {
        return SocketUtils.EMPTY;
    }

    public static byte[] hardwareAddressFromNetworkInterface(NetworkInterface networkInterface0) {
        try {
            return (byte[])AccessController.doPrivileged(new PrivilegedExceptionAction() {
                @Override
                public Object run() {
                    return this.run();
                }

                public byte[] run() {
                    return networkInterface0.getHardwareAddress();
                }
            });
        }
        catch(PrivilegedActionException privilegedActionException0) {
            throw (SocketException)privilegedActionException0.getCause();
        }
    }

    public static SocketAddress localSocketAddress(ServerSocket serverSocket0) {
        return (SocketAddress)AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                return this.run();
            }

            public SocketAddress run() {
                return serverSocket0.getLocalSocketAddress();
            }
        });
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static InetAddress loopbackAddress() {
        return (InetAddress)AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                return this.run();
            }

            public InetAddress run() {
                if(PlatformDependent.javaVersion() >= 7) {
                    return InetAddress.getLoopbackAddress();
                }
                try {
                    return InetAddress.getByName(null);
                }
                catch(UnknownHostException unknownHostException0) {
                    throw new IllegalStateException(unknownHostException0);
                }
            }
        });
    }

    public static InetSocketAddress socketAddress(String s, int v) {
        return (InetSocketAddress)AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                return this.run();
            }

            public InetSocketAddress run() {
                return new InetSocketAddress(s, v);
            }
        });
    }
}

