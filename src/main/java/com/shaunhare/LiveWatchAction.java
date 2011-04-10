package com.shaunhare;



import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.core.ContentEntityManager;
import com.atlassian.confluence.mail.ChangeDigestNotificationBean;
import com.atlassian.confluence.mail.notification.NotificationManager;
import com.atlassian.confluence.security.PermissionManager;
import com.atlassian.confluence.setup.settings.SettingsManager;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.confluence.user.UserAccessor;
import com.atlassian.user.User;


/**
 * com.shaunhare
 *
 * @version 1.0
 * @author: shaunhare
 * Date: 06/04/2011
 * Time: 11:53
 */
public class LiveWatchAction extends ConfluenceActionSupport {

    private UserAccessor userAccessor;

    public LiveWatchAction()
    {



    }

    public String doDefault()
    {

        User user = AuthenticatedUserThreadLocal.getUser();
        user.getFullName();




        return INPUT;
    }


}
