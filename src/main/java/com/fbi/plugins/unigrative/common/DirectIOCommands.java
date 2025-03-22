package com.fbi.plugins.unigrative.common;

public class DirectIOCommands {
    public static final int SET_ACTION = 6000;
    public static int scannerID;

    public static String XML_SET_RED_LED_ON() {

        return "<inArgs>\n" +
                " <scannerID>" + scannerID + "</scannerID>\n" +
                " <cmdArgs>\n" +
                "  <arg-xml>\n" +
                "   <attrib_list>\n" +
                "    <attribute>\n" +
                "     <id>6000</id>\n" +
                "     <datatype>X</datatype>\n" +
                "     <value>47</value>\n" +
                "    </attribute>\n" +
                "   </attrib_list>\n" +
                "  </arg-xml>\n" +
                " </cmdArgs>\n" +
                "</inArgs>";
    }
    public static String XML_SET_RED_LED_OFF() {
        return "<inArgs>\n" +
                " <scannerID>" + scannerID + "</scannerID>\n" +
                " <cmdArgs>\n" +
                "  <arg-xml>\n" +
                "   <attrib_list>\n" +
                "    <attribute>\n" +
                "     <id>6000</id>\n" +
                "     <datatype>X</datatype>\n" +
                "     <value>48</value>\n" +
                "    </attribute>\n" +
                "   </attrib_list>\n" +
                "  </arg-xml>\n" +
                " </cmdArgs>\n" +
                "</inArgs>";
    }
    public static String XML_SET_ERROR_BEEP () {
        return "<inArgs>\n" +
                " <scannerID>" + scannerID + "</scannerID>\n" +
                " <cmdArgs>\n" +
                "  <arg-xml>\n" +
                "   <attrib_list>\n" +
                "    <attribute>\n" +
                "     <id>6000</id>\n" +
                "     <datatype>X</datatype>\n" +
                "     <value>7</value>\n" +
                "    </attribute>\n" +
                "   </attrib_list>\n" +
                "  </arg-xml>\n" +
                " </cmdArgs>\n" +
                "</inArgs>";
    }
}
