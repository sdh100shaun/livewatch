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



    public String lastModified;

    public String space;

    public String page;
    public String modifiedBy;

    public LiveWatchNotification() {

    }
}
