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
package org.trancecode.xproc.step;

import org.trancecode.logging.Logger;
import org.trancecode.xproc.Environment;

/**
 * @author Herve Quiroz
 */
public class AbstractCompoundStepProcessor implements StepProcessor
{
    private static final Logger LOG = Logger.getLogger(AbstractCompoundStepProcessor.class);

    @Override
    public Environment run(final Step step, final Environment environment)
    {
        LOG.trace("step = {}", step.getName());
        assert step.isCompoundStep();

        final Environment stepEnvironment = environment.newFollowingStepEnvironment(step);
        final Environment resultEnvironment = runSteps(step.getSubpipeline(), stepEnvironment);

        return stepEnvironment.setupOutputPorts(step, resultEnvironment);
    }

    protected Environment runSteps(final Iterable<Step> steps, final Environment environment)
    {
        LOG.trace("steps = {}", steps);

        Environment currentEnvironment = environment.newChildStepEnvironment();

        for (final Step childStep : steps)
        {
            currentEnvironment = childStep.run(currentEnvironment);
        }

        return currentEnvironment;
    }
}
