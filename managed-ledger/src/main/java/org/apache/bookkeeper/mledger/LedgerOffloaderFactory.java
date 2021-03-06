/**
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
package org.apache.bookkeeper.mledger;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.apache.bookkeeper.common.annotation.InterfaceAudience.LimitedPrivate;
import org.apache.bookkeeper.common.annotation.InterfaceStability.Evolving;
import org.apache.bookkeeper.common.util.OrderedScheduler;

/**
 * Factory to create {@link LedgerOffloader} to offload ledgers into long-term storage.
 */
@LimitedPrivate
@Evolving
public interface LedgerOffloaderFactory<T extends LedgerOffloader> {

    /**
     * Check whether the provided driver <tt>driverName</tt> is supported.
     *
     * @param driverName offloader driver name
     * @return true if the driver is supported, otherwise false.
     */
    boolean isDriverSupported(String driverName);

    /**
     * Create a ledger offloader with the provided configuration, user-metadata and scheduler.
     *
     * @param properties service configuration
     * @param userMetadata user metadata
     * @param scheduler scheduler
     * @return the offloader instance
     * @throws IOException when fail to create an offloader
     */
    T create(Properties properties,
             Map<String, String> userMetadata,
             OrderedScheduler scheduler)
        throws IOException;

}
