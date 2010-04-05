/*
 * Copyright (C) 2008 TranceCode Software
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
 *
 * $Id$
 */
package org.trancecode.io;

import org.trancecode.annotation.Nullable;
import org.trancecode.annotation.ReturnsNullable;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Utility methods related to {@link URI}.
 * 
 * @author Herve Quiroz
 */
public final class Uris
{
    private Uris()
    {
        // To prevent instantiation
    }

    @ReturnsNullable
    public static URI createUri(@Nullable final String uri)
    {
        if (uri == null || uri.length() == 0)
        {
            return null;
        }

        return URI.create(uri);
    }

    @ReturnsNullable
    public static URI resolve(@Nullable final String href, @Nullable final String base)
    {
        return resolve(createUri(href), createUri(base));
    }

    @ReturnsNullable
    public static URI resolve(@Nullable final URI href, @Nullable final URI base)
    {
        if (base == null)
        {
            return href;
        }

        if (href == null)
        {
            return base;
        }

        return base.resolve(href);
    }

    public static boolean isValidUri(final String string)
    {
        try
        {
            new URI(string);
            return true;
        }
        catch (final URISyntaxException e)
        {
            return false;
        }
    }
}
