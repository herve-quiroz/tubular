/*
 * Copyright (C) 2011 Herve Quiroz
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA 
 */
package org.trancecode.event;

import org.trancecode.concurrent.TaskExecutor;
import org.trancecode.event.AbstractEventObservable.NotificationFailurePolicy;

/**
 * Utility methods related to {@link EventObservable}.
 * 
 * @author Herve Quiroz
 */
public final class EventObservables
{
    public static <T extends Event> EventObservable<T> newEventDispatcher()
    {
        return new AbstractEventObservable<T>()
        {
        };
    }

    public static <T extends Event> EventObservable<T> newEventDispatcher(final boolean blockingNotification,
            final TaskExecutor eventDispatcher, final NotificationFailurePolicy notificationFailurePolicy)
    {
        return new AbstractEventObservable<T>(blockingNotification, eventDispatcher, notificationFailurePolicy)
        {
        };
    }

    private EventObservables()
    {
        // No instantiation
    }
}
