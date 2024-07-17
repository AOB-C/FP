package com.lmy.util;

public class AntiXssUtil {
    public static String replaceHtmlCode(String content) {
        if (null == content) {
            return null;
        }
        if (0 == content.length()) {
            return "";
        }
        // 需要滤除的脚本事件关键字
        String[] eventKeywords = {"onmouseover", "onmouseout", "onmousedown",
                "onmouseup", "onmousemove", "onclick", "ondblclick",
                "onkeypress", "onkeydown", "onkeyup", "ondragstart",
                "onerrorupdate", "onhelp", "onreadystatechange", "onrowenter",
                "onrowexit", "onselectstart", "onload", "onunload",
                "onbeforeunload", "onblur", "onerror", "onfocus", "onresize",
                "onscroll", "oncontextmenu", "alert", "href", "window", "script"};
        content = replace(content, "<script", "<script", false);
        content = replace(content, "</script", "</script", false);
        content = replace(content, "<marquee", "<marquee", false);
        content = replace(content, "</marquee", "</marquee", false);
        content = replace(content, "'", "_", false);// 将单引号替换成下划线
        content = replace(content, "\"", "_", false);// 将双引号替换成下划线
        // 滤除脚本事件代码
        for (int i = 0; i < eventKeywords.length; i++) {
            if (content.toLowerCase().contains(eventKeywords[i].toLowerCase())) {
                content = replace(content, eventKeywords[i],
                        "_" + eventKeywords[i], false); // 添加一个"_", 使事件代码无效
            }
        }
        return content;
    }
    private static String replace(String source, String oldStr, String newStr) {
        return replace(source, oldStr, newStr, true);
    }
    private static String replace(String source, String oldStr, String newStr,
                                  boolean matchCase) {
        if (source == null) {
            return null;
        }
        if (source.toLowerCase().indexOf(oldStr.toLowerCase()) == -1) {
            return source;
        }
        int findStartPos = 0;
        int a = 0;
        while (a > -1) {
            int b = 0;
            String str1, str2, str3, str4, strA, strB;
            str1 = source;
            str2 = str1.toLowerCase();
            str3 = oldStr;
            str4 = str3.toLowerCase();
            if (matchCase) {
                strA = str1;
                strB = str3;
            } else {
                strA = str2;
                strB = str4;
            }
            a = strA.indexOf(strB, findStartPos);
            if (a > -1) {
                b = oldStr.length();
                findStartPos = a + b;
                StringBuffer bbuf = new StringBuffer(source);
                source = bbuf.replace(a, a + b, newStr) + "";
                findStartPos = findStartPos + newStr.length() - b;
            }
        }
        return source;
    }

}
