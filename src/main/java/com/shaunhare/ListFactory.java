package com.shaunhare;

import com.atlassian.confluence.mail.notification.Notification;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 29/05/2011
 * Time: 11:09
 * To change this template use File | Settings | File Templates.
 */
public class ListFactory implements IListFactory{


    public ArrayList<Notification> createEmptyNotificationList()
    {
        return  new ArrayList<Notification>();
    }

    public ArrayList<LiveWatchNotification> createEmptyRestNotificationList() {
        return new ArrayList<LiveWatchNotification>();
    }
}
