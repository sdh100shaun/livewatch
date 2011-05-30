package com.shaunhare;


import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonValue;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
@JsonAutoDetect
public class LiveWatchNotification {

    @JsonProperty
    public String getLastModified() {
        return lastModified;
    }


    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @JsonProperty
    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }
    @JsonProperty
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @JsonProperty
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


    public String lastModified;

    public String space;

    public String page;
    public String modifiedBy;

    public LiveWatchNotification() {

    }
}
