package com.shaunhare;

import com.atlassian.confluence.mail.notification.Notification;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 09:13
 * To change this template use File | Settings | File Templates.
 */
public interface IListFactory  {


    public ArrayList<Notification> createEmptyNotificationList();

    public ArrayList<LiveWatchNotification> createEmptyRestNotificationList();
}
