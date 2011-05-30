package com.shaunhare;


import com.atlassian.confluence.mail.notification.Notification;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaunhare
 * Date: 30/05/2011
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "watches")
@XmlAccessorType(XmlAccessType.FIELD)
public class Watches {

    @XmlElement(name = "item")
        protected final List<Notification> notifications = new ArrayList<Notification>();

        public List<Notification> getNotifications() {
            return notifications;
        }



    public Watches(){}

    public Watches(List<Notification> notificationList)
    {

        this.notifications.addAll(notificationList);

    }
}
