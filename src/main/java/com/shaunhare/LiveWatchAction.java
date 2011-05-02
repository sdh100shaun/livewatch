package com.shaunhare;



import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.core.ContentEntityManager;
import com.atlassian.confluence.mail.ChangeDigestNotificationBean;
import com.atlassian.confluence.mail.notification.DefaultNotificationManager;
import com.atlassian.confluence.mail.notification.Notification;
import com.atlassian.confluence.mail.notification.NotificationManager;
import com.atlassian.confluence.pages.AbstractPage;
import com.atlassian.confluence.pages.actions.PageAware;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.security.PermissionManager;
import com.atlassian.confluence.setup.settings.SettingsManager;
import com.atlassian.confluence.spaces.Space;
import com.atlassian.confluence.spaces.actions.SpaceAware;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.UserAccessor;
import com.atlassian.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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

    public String getBaseUrl() {
        return baseUrl;
    }

    private String baseUrl;


    public List<Notification> getPageNotificationsForUser() {
        return pageNotificationsForUser;
    }

    public void setPageNotificationsForUser(List<Notification> pageNotificationsForUser) {
        this.pageNotificationsForUser = pageNotificationsForUser;
    }


    public List<Notification> getSpaceNotificationsForUser() {
        return spaceNotificationsForUser;
    }

    public void setSpaceNotificationsForUser(List<Notification> spaceNotificationsForUser) {
        this.spaceNotificationsForUser = spaceNotificationsForUser;
    }





    private List<Notification> pageNotificationsForUser;
    private List<Notification> spaceNotificationsForUser;
    private NotificationManager notificationManager;




    public LiveWatchAction(UserAccessor userAccessor, NotificationManager notificationManager, SettingsManager settingsManager)
    {
               this.userAccessor = userAccessor;
               this.notificationManager = notificationManager;
               this.baseUrl = settingsManager.getGlobalSettings().getBaseUrl();


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

            if (notification.getPage() != null)
            {
                pageNotificationsForUser.add(notification);

            }
            else
            {
                spaceNotificationsForUser.add(notification);
            }
        }
    }

}
