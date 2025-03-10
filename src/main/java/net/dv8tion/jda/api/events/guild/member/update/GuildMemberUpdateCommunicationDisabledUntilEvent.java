/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.events.guild.member.update;

import java.time.OffsetDateTime;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;

/**
 * Indicates that a {@link Member Member} updated their {@link net.dv8tion.jda.api.entities.Guild Guild} communication disabled until time.
 * <br>This happens when a member started or stopped having a communication disabled.
 *
 * <p>Can be used to retrieve members who have a communication disabled, triggering guild.
 *
 * <p>Identifier: {@code communication_disabled_until}
 *
 * <h2>Requirements</h2>
 *
 * <p>This event requires the {@link net.dv8tion.jda.api.requests.GatewayIntent#GUILD_MEMBERS GUILD_MEMBERS} intent to be enabled.
 * <br>{@link net.dv8tion.jda.api.JDABuilder#createDefault(String) createDefault(String)} and
 * {@link net.dv8tion.jda.api.JDABuilder#createLight(String) createLight(String)} disable this by default!
 *
 * <p>Additionally, this event requires the {@link net.dv8tion.jda.api.utils.MemberCachePolicy MemberCachePolicy}
 * to cache the updated members. Discord does not specifically tell us about the updates, but merely tells us the
 * member was updated and gives us the updated member object. In order to fire a specific event like this we
 * need to have the old member cached to compare against.
 */
public class GuildMemberUpdateCommunicationDisabledUntilEvent extends GenericGuildMemberUpdateEvent<OffsetDateTime>
{
    public static final String IDENTIFIER = "communication_disabled_until";

    public GuildMemberUpdateCommunicationDisabledUntilEvent(@Nonnull JDA api, long responseNumber, @Nonnull Member member, @Nullable OffsetDateTime previous)
    {
        super(api, responseNumber, member, previous, member.getTimeCommunicationDisabledUntil(), IDENTIFIER);
    }

    /**
     * The old communication disabled time
     *
     * @return The old communication disabled time
     */
    @Nullable
    public OffsetDateTime getOldCommunicationDisabledTime()
    {
        return getOldValue();
    }

    /**
     * The new communication disabled time
     *
     * @return The new communication disabled time
     */
    @Nullable
    public OffsetDateTime getNewCommunicationDisabledTime()
    {
        return getNewValue();
    }
}
