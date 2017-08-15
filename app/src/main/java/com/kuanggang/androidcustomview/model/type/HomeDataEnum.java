package com.kuanggang.androidcustomview.model.type;

import java.io.Serializable;

/**
 * @author KG on 2017/8/15.
 */

public enum HomeDataEnum implements Serializable {
    CLASS1("自定义 View 1-1 绘制基础", "Canvas 的 drawXXX() 系列方法及 Paint 最常见的使用", "http://hencoder.com/ui-1-1/", 1);
    public String title;
    public String desc;
    public String url;
    public int code;

    HomeDataEnum(String title, String desc, String url, int code) {
        this.title = title;
        this.desc = desc;
        this.url = url;
        this.code = code;
    }

    public static HomeDataEnum get(int code) {
        for (HomeDataEnum element : values()) {
            if (element.code == code)
                return element;
        }
        return null;
    }
}
