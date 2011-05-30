package com.shaunhare;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */


import com.atlassian.confluence.mail.notification.Notification;
import com.atlassian.confluence.mail.notification.NotificationManager;
import com.atlassian.confluence.user.UserAccessor;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.atlassian.user.User;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/watches")
public class LiveWatchResource {

    private NotificationManager notificationManager;
    private IListFactory listFactory;
    private UserAccessor userAccessor;

    public LiveWatchResource(NotificationManager notificationManager, IListFactory listFactory, UserAccessor userAccessor)
    {
        this.notificationManager = notificationManager;
        this.listFactory=listFactory;
        this.userAccessor=userAccessor;
    }

    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{user}")

    public Response getWatchesFromPath(@PathParam("user") String user)
    {

        try{
            User watcher  = userAccessor.getUser(user);


        List<Notification> watches = loadNotificationsForUser(watcher);

        List<LiveWatchNotification> notificationList = listFactory.createEmptyRestNotificationList();

        for(Notification notification:watches)
        {
             LiveWatchNotification liveWatchNotification = new LiveWatchNotification();

            if (notification.getPage() != null)
            {



                liveWatchNotification.setPage(notification.getPage().getDisplayTitle());
                liveWatchNotification.setSpace(notification.getPage().getSpace().getName());
                if(notification.getPage().getLastModifierName()!=null)
                {

                    liveWatchNotification.setLastModified(notification.getLastModificationDate().toString());
                    liveWatchNotification.setModifiedBy(notification.getPage().getLastModifierName());

                }



            }
            else
            {

                liveWatchNotification.setPage(notification.getSpace().getHomePage().getDisplayTitle());
                liveWatchNotification.setSpace(notification.getSpace().getName());

                if(notification.getSpace().getHomePage().getLastModifierName()!=null)
                {

                    liveWatchNotification.setLastModified(notification.getLastModificationDate().toString());
                    liveWatchNotification.setModifiedBy(notification.getSpace().getHomePage().getLastModifierName());

                }


            }



                notificationList.add(liveWatchNotification);

        }


        return Response.ok(new Watches(notificationList)).build();
        }
        catch(Exception exception)
        {
            return Response.noContent().build();
        }
    }


public List<Notification> loadNotificationsForUser(User user)
    {

       return  notificationManager.getNotificationsByUser(user);



    }


}
