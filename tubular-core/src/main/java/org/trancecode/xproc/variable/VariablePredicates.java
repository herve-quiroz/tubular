/*
 * Copyright (C) 2008 Herve Quiroz
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
package org.trancecode.xproc.variable;

import com.google.common.base.Predicate;
import net.sf.saxon.s9api.QName;

/**
 * {@link Predicate} implementations related to {@link Variable}.
 * 
 * @author Herve Quiroz
 */
public final class VariablePredicates
{
    private VariablePredicates()
    {
        // No instantiation
    }

    public static Predicate<Variable> isNamed(final QName name)
    {
        return new IsNamedPredicate(name);
    }

    private static final class IsNamedPredicate implements Predicate<Variable>
    {
        private final QName name;

        private IsNamedPredicate(final QName name)
        {
            this.name = name;
        }

        @Override
        public boolean apply(final Variable variable)
        {
            return variable.getName().equals(name);
        }
    }

    public static Predicate<Variable> isOption()
    {
        return IsOptionPredicate.INSTANCE;
    }

    private static final class IsOptionPredicate implements Predicate<Variable>
    {
        private static final IsOptionPredicate INSTANCE = new IsOptionPredicate();

        @Override
        public boolean apply(final Variable variable)
        {
            return variable.isOption();
        }
    }
}
