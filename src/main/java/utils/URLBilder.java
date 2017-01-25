package utils;

import java.util.HashMap;
import java.util.Map;


public class URLBilder {
    private String protocol = "";
    private String domain = "";
    private String port = "";
    private String path = "";
    private Map<String, String> params = new HashMap();
    private String authority = "";
    private String anchor = "";

    public String bild() {
        StringBuilder urlString = new StringBuilder();

        urlString.append(protocol).append("://");

        if (!authority.isEmpty()) urlString.append(authority);

        urlString.append(domain);

        if (!port.isEmpty()) urlString.append(":").append(port);

        if (!path.isEmpty()) urlString.append("/").append(path);

        StringBuilder paramStr = new StringBuilder();
        params.forEach((k, v) -> paramStr.append("&").append(k).append(v == null ? "" : "=" + v));
        paramStr.replace(0, 1, "?");
        urlString.append(paramStr);

        if (!anchor.isEmpty()) urlString.append("#").append(anchor);

        return urlString.toString();
    }

    public URLBilder setProtocol(String proctol) {
        this.protocol = proctol;
        return this;
    }

    public URLBilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public URLBilder setPath(String path) {
        if (path.indexOf("/") == 0) {
            this.path = path.substring(1, path.length());
        } else {
            this.path = path;
        }
        return this;
    }

    public URLBilder setPort(String port) {
        this.port = port;
        return this;
    }

    public URLBilder setAuthority(String login, String password) {
        this.authority = login + ":" + password + "@";
        return this;
    }

    public URLBilder addParam(String key, String value) {

        params.put(key, value);
        return this;
    }

    public URLBilder addParam(String key) {

        params.put(key, null);
        return this;
    }

    public URLBilder addParam(HashMap<String, String> params) {

        this.params.putAll(params);
        return this;
    }
/*
    private String bildParam() {
        StringBuilder paramStr = new StringBuilder();
        params.forEach((k, v) -> paramStr.append("&" + k + (v == null ? "" : "=" + v)));
        paramStr.replace(0, 1, "?");
        return paramStr.toString();


    }
*/

/*
    private String bildParam1() {

        StringBuilder parmStr = new StringBuilder();
        for (String k : params.keySet()) {
            parmStr.append("&" + k + "=" + (String) params.get(k));
            parmStr.replace(0, 1, "?");
        }
        return parmStr.toString();

    }
*/

    public URLBilder setAnchor(String anchor) {
        this.anchor = "#" + anchor;
        if (anchor.indexOf("#") == 0) {
            this.anchor = anchor.substring(1, anchor.length());
        } else {
            this.anchor = anchor;
        }
        return this;
    }
}
