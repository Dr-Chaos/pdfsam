/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 12/dic/2013
 * Copyright 2013 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.event;

import static org.pdfsam.support.RequireUtils.requireNotNull;

import java.io.File;

/**
 * Request to set a the destination using the given file as footprint.
 * 
 * @author Andrea Vacondio
 * 
 */
public class SetDestinationRequest {

    private File footprint;
    private boolean fallback = false;

    private SetDestinationRequest(File footprint, boolean fallback) {
        requireNotNull(footprint, "Footprint file cannot be null");
        this.footprint = footprint;
        this.fallback = fallback;
    }

    public File getFootprint() {
        return footprint;
    }

    public boolean isFallback() {
        return fallback;
    }

    /**
     * @param footprint
     * @return a request to set the destination for the task to the given file
     */
    public static SetDestinationRequest requestDestination(File footprint) {
        return new SetDestinationRequest(footprint, false);
    }

    /**
     * @param footprint
     * @return a request to set the destination as fallback for the task to the given file
     */
    public static SetDestinationRequest requestFallbackDestination(File footprint) {
        return new SetDestinationRequest(footprint, true);
    }
}
