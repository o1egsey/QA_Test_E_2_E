package com.sumdu.edu.ua.properties.conventors;

import com.sumdu.edu.ua.enumeration.SupportedBrowsers;

public class SupportedBrowserConverter {
    public static SupportedBrowsers valueOfWebBrowser(String webBrowserName) {
        return switch(webBrowserName) {
            case "local_chrome" -> SupportedBrowsers.LOCAL_CHROME;
            case "local_firefox" -> SupportedBrowsers.LOCAL_FIREFOX;
            case "local_edge" -> SupportedBrowsers.LOCAL_EDGE;
            default -> throw new IllegalArgumentException();
        };
    }
}
