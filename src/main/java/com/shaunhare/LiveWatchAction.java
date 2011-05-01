package com.shaunhare;



import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.core.ContentEntityManager;
import com.atlassian.confluence.mail.ChangeDigestNotificationBean;
import com.atlassian.confluence.mail.notification.DefaultNotificationManager;
import com.atlassian.confluence.mail.notification.Notification;
import com.atlassian.confluence.mail.notification.NotificationManager;
import com.atlassian.confluence.pages.AbstractPage;
import com.atlassian.confluence.pages.actions.PageAware;
import com.atlassian.confluence.security.PermissionManager;
import com.atlassian.confluence.setup.settings.SettingsManager;
import com.atlassian.confluence.spaces.Space;
import com.atlassian.confluence.spaces.actions.SpaceAware;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.UserAccessor;
import com.atlassian.user.User;

import java.util.ArrayList;
import java.util.List;


/**
 * com.shaunhare
 *
 * @version 1.0
 * @author: shaunhare
 * Date: 06/04/2011
 * Time: 11:53
 */
public class LiveWatchAction extends ConfluenceActionSupport{

    private UserAccessor userAccessor;
    private List<Notification> pageNotificationsForUser;
    private List<Notification> spaceNotificationsForUser;
    private NotificationManager notificationManager;

    public LiveWatchAction(UserAccessor userAccessor, NotificationManager notificationManager)
    {
               this.userAccessor = userAccessor;
               this.notificationManager = notificationManager;



    }

    public String execute()
    {



        loadNotificationsForUser();

        return SUCCESS;
    }


private void loadNotificationsForUser()
    {
        User user = AuthenticatedUserThreadLocal.getUser();
        List<Notification> notificationsForUser = notificationManager.getNotificationsByUser(user);
        pageNotificationsForUser = new ArrayList<Notification>();
        spaceNotificationsForUser = new ArrayList<Notification>();

        for (Notification notification : notificationsForUser)
        {
            System.out.println(notification.getUserName());

            if (notification.getPage() != null)
            {
                pageNotificationsForUser.add(notification);
                System.out.println(notification.getPage().getNameForComparison());
            }
            else
            {
                spaceNotificationsForUser.add(notification);
            }
        }
    }

}
