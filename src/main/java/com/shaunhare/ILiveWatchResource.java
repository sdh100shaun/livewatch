package com.shaunhare;

import com.atlassian.confluence.mail.notification.Notification;
import com.atlassian.user.User;



import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public interface ILiveWatchResource {


    public List<Notification> loadNotificationsForUser(User user);

}
