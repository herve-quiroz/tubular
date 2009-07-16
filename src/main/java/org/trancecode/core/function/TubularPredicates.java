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
package org.trancecode.core.function;

import org.trancecode.core.AbstractImmutableObject;

import java.util.Collection;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;


/**
 * Utility methods related to {@link Predicate}.
 * 
 * @author Herve Quiroz
 * @version $Revision$
 */
public final class TubularPredicates
{
	private TubularPredicates()
	{
		// No instantiation
	}


	public static <T> Predicate<T> matches(final Collection<T> filters)
	{
		if (filters.isEmpty())
		{
			return Predicates.alwaysTrue();
		}

		return new MatchingPredicate<T>(filters);
	}


	private static class MatchingPredicate<T> extends AbstractImmutableObject implements Predicate<T>
	{
		private final Collection<T> filters;


		public MatchingPredicate(final Collection<T> filters)
		{
			super(filters);
			Preconditions.checkNotNull(filters);
			this.filters = filters;
		}


		@Override
		public boolean apply(final T object)
		{
			return filters.contains(object);
		}
	}
}
