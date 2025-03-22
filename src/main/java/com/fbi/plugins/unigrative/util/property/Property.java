// 
// Decompiled by Procyon v0.5.30
// 

package com.fbi.plugins.unigrative.util.property;

import com.fbi.plugins.unigrative.util.property.reader.BooleanReader;
import com.fbi.plugins.unigrative.util.property.reader.StringReader;

public final class Property
{
    private static final StringReader STRING;
    private static final BooleanReader BOOLEAN_DEFAULT_FALSE;
    private static final BooleanReader BOOLEAN_DEFAULT_TRUE;
//    private static final DoubleReader DOUBLE;
//    private static final IntegerReader INTEGER;
//    private static final LongReader LONG;

    public static final GlobalProperty<Boolean> DEBUG_MODE;
    
    static {
        STRING = new StringReader();
        BOOLEAN_DEFAULT_FALSE = new BooleanReader(false);
        BOOLEAN_DEFAULT_TRUE = new BooleanReader(true);
//        DOUBLE = new DoubleReader(0.0);
//        INTEGER = new IntegerReader();
//        LONG = new LongReader();
        DEBUG_MODE = new GlobalProperty<Boolean>("DebugMode", Property.BOOLEAN_DEFAULT_FALSE);

    }
}
