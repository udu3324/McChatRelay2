package com.udu3324.mcchatrelay2;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent ev) {
        JDA jda = ev.getJDA(); // This JDA instance is fully built, so do more stuff with this JDA instance

        // Set Channels
        Guild guild = jda.getGuildById(Data.guildID);
        assert guild != null;
        Data.mcChatRelayChannel = guild.getTextChannelById(Data.channelID);

        // Start ChatHook
        ChatHook object = new ChatHook();
        object.run();
    }
}
