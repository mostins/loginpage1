package com.example.meiyoudalao.pesystem;

import java.io.InputStream;
import java.util.Properties;
public class ReadFontByteProperties {
    static private String fontByteStr = null;
    static {
        loads();
    }
    synchronized static public void loads() {
        if (fontByteStr == null) {
            InputStream is = ReadFontByteProperties.class.getResourceAsStream("/fontByte.properties");
            Properties dbproperties = new Properties();
            try {
                dbproperties.load(is);
                fontByteStr = dbproperties.getProperty("fontByteStr").toString();
            } catch (Exception e) {
                //System.err.println("不能读取属性文件. " + "请确保fontByte.properties在CLASSPATH指定的路径中");
            }
        }
    }
    public static String getFontByteStr() {
        if (fontByteStr == null)
            loads();
        return fontByteStr;
    }
}
