/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.javaee.resources.api.model;

import org.openide.filesystems.FileObject;

/**
 * Holds the location of the resource definition which is file and offset in that file.
 *
 * @author Martin Fousek <marfous@netbeans.org>
 */
public interface Location {

    /**
     * Returns the file corresponding to this location.
     * @return the file; never null
     */
    FileObject getFile();

    /**
     * Returns the offset corresponding to this location.
     * @return the offset or -1 if the offset is not known
     */
    int getOffset();
}
