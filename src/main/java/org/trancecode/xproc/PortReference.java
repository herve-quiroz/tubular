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
package org.trancecode.xproc;

/**
 * @author Herve Quiroz
 * @version $Revision$
 */
public class PortReference
{
	private static final int HASHCODE_CLASS = PortReference.class.hashCode();

	public final String stepName;
	public final String portName;
	private transient int hashCode;
	private transient String toString;


	public PortReference(final String stepName, final String portName)
	{
		assert stepName != null;
		this.stepName = stepName;

		assert portName != null;
		this.portName = portName;
	}


	@Override
	public int hashCode()
	{
		if (hashCode == 0)
		{
			int h = HASHCODE_CLASS;

			h <<= 4;
			h ^= stepName.hashCode();

			h <<= 4;
			h ^= portName.hashCode();

			hashCode = h;
		}

		return hashCode;
	}


	@Override
	public boolean equals(final Object o)
	{
		if (o != null && o instanceof PortReference)
		{
			final PortReference portReference = (PortReference)o;
			return stepName.equals(portReference.stepName) && portName.equals(portReference.portName);
		}

		return false;
	}


	@Override
	public String toString()
	{
		if (toString == null)
		{
			toString = stepName + "/" + portName;
		}

		return toString;
	}
}
