package com.raxixor.simplelog;

import java.text.SimpleDateFormat;
import java.util.*;

public class SimpleLog {
    
    public static Level LEVEL = Level.INFO;
    
    public static boolean ENABLE_GUI = false;
    
    private static final String FORMAT = "[%time%] [%level%] [%name%]: %text%";
    private static final String MSGFORMAT = "%text%";
    private static final SimpleDateFormat DFORMAT = new SimpleDateFormat("HH:mm:ss dd:MM:YYYY");
    
    private static final Map<String, SimpleLog> LOGS = new HashMap<>();
    
    
    public interface LogListener {
        
        void onLog(SimpleLog log, Level logLevel, Object message);
        
        void onError(SimpleLog log, Throwable err);
    }
    
    public enum Level {
        ALL("Finest", 0, false),
        TRACE("Trace", 1, false),
        DEBUG("Debug", 2, false),
        INFO("Info", 3, false),
        WARNING("Warning", 4, true),
        FATAL("Fatal", 5, true),
        OFF("NO-LOGGING", 6, true);
        
        private final String msg;
        private final int pri;
        private final boolean isError;
        
        Level(String message, int priority, boolean isError) {
            this.msg = message;
            this.pri = priority;
            this.isError = isError;
        }
        
        public String getTag() {
            return msg;
        }
    
        public int getPriority() {
            return pri;
        }
    
        /**
         * Returns whether this LOG-level should be treated like an error or not
         *
         * @return boolean true, if this LOG-level is an error-level
         */
        public boolean isError() {
            return isError;
        }
    }
}
