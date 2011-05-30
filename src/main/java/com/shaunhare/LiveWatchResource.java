package com.shaunhare;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */


import com.atlassian.confluence.mail.notification.Notification;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/watches")
public class LiveWatchResource {



    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/watches")

    public Response getWatchesFromPath()
    {

        List<Notification> notificationList = new ArrayList<Notification>();
        Notification notification = new Notification();

        notificationList.add(notification);
        return Response.ok(new Watches(notificationList)).build();
    }



}
