/*
 * Copyright 2017 John Grosh (john.a.grosh@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.soarclient.libraries.discordipc.entities;

import com.soarclient.libraries.discordipc.IPCClient;

/**
 * Constants representing various Discord client builds,
 * such as Stable, Canary, Public Test Build (PTB)
 */
public enum DiscordBuild {
    /**
     * Constant for the current Discord Canary release.
     */
    CANARY("//canary.discord.com/api"),

    /**
     * Constant for the current Discord Public Test Build or PTB release.
     */
    PTB("//ptb.discord.com/api"),

    /**
     * Constant for the current stable Discord release.
     */
    STABLE("//discord.com/api"),

    /**
     * 'Wildcard' build constant used in {@link IPCClient#connect(DiscordBuild...)
     * IPCClient#connect(DiscordBuild...)} to signify that the build to target is not important, and
     * that the first valid build will be used.
     * <p>
     * Other than this exact function, there is no use for this value.
     */
    ANY;

    private final String endpoint;

    DiscordBuild(String endpoint) {
        this.endpoint = endpoint;
    }

    DiscordBuild() {
        this(null);
    }

    /**
     * Gets a {@link DiscordBuild} matching the specified index.
     * <p>
     * This is only internally implemented.
     *
     * @param index The index to get from.
     * @return The {@link DiscordBuild} corresponding to the parameters, or
     * {@link DiscordBuild#ANY} if none match.
     */
    public static DiscordBuild from(int index) {
        for (DiscordBuild value : values()) {
            if (value.ordinal() == index) {
                return value;
            }
        }
        return ANY;
    }

    /**
     * Gets a {@link DiscordBuild} matching the specified endpoint.
     * <p>
     * This is only internally implemented.
     *
     * @param endpoint The endpoint to get from.
     * @return The DiscordBuild corresponding to the endpoint, or
     * {@link DiscordBuild#ANY} if none match.
     */
    public static DiscordBuild from(String endpoint) {
        for (DiscordBuild value : values()) {
            if (value.endpoint != null && value.endpoint.equals(endpoint)) {
                return value;
            }
        }
        return ANY;
    }
}
