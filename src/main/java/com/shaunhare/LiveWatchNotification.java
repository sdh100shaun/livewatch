package com.shaunhare;

import javax.xml.bind.annotation.XmlValue;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
public class LiveWatchNotification {


    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


    private String lastModified;
    private String space;
    private String page;
    private String modifiedBy;

    public LiveWatchNotification() {

    }
}
