//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public LoggerUtil() {
    }

    public static StackTraceElement findCaller() {
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if(callStack == null) {
            return null;
        } else {
            StackTraceElement caller = null;
            String logClassName = LoggerUtil.class.getName();
            boolean isEachLogClass = false;
            StackTraceElement[] var7 = callStack;
            int var6 = callStack.length;

            for(int var5 = 0; var5 < var6; ++var5) {
                StackTraceElement s = var7[var5];
                if(logClassName.equals(s.getClassName())) {
                    isEachLogClass = true;
                }

                if(isEachLogClass && !logClassName.equals(s.getClassName())) {
                    isEachLogClass = false;
                    caller = s;
                    break;
                }
            }

            return caller;
        }
    }

    private static Logger logger() {
        StackTraceElement caller = findCaller();
        if(caller == null) {
            return LoggerFactory.getLogger(LoggerUtil.class);
        } else {
            Logger log = LoggerFactory.getLogger(caller.getClassName() + "." + caller.getMethodName() + " L " + caller.getLineNumber());
            return log;
        }
    }

    public static void trace(String msg) {
        trace(msg, (Throwable)null);
    }

    public static void trace(String msg, Throwable e) {
        logger().trace(msg, e);
    }

    public static void debug(String msg) {
        debug(msg, (Throwable)null);
    }

    public static void debug(String msg, Throwable e) {
        logger().debug(msg, e);
    }

    public static void info(String msg) {
        info(msg, (Throwable)null);
    }

    public static void info(String msg, Throwable e) {
        logger().info(msg, e);
    }

    public static void warn(String msg) {
        warn(msg, (Throwable)null);
    }

    public static void warn(String msg, Throwable e) {
        logger().warn(msg, e);
    }

    public static void error(String msg) {
        error(msg, (Throwable)null);
    }

    public static void error(String msg, Throwable e) {
        logger().error(msg, e);
    }
}

