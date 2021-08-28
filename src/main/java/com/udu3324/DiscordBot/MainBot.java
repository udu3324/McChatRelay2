package com.udu3324.DiscordBot;

import com.udu3324.FileScanner.ChatHook;
import com.udu3324.Variables;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.concurrent.TimeUnit;

public class MainBot extends ListenerAdapter {
    // Remember to change the Variables in Variables.java (located in pkg.Values)

    // It is not recommended changing any code or value below unless if you know what you're doing.
    // Do not change the value of mcChatRelayChannel, session, or latestLogLine.
    public static TextChannel mcChatRelayChannel;
    public static Integer sessionToggle = 1;

    public static void main(String[] args) throws LoginException {
        {
            ChatHook object = new ChatHook();
            object.run();
        }
        JDABuilder
                .createLight(Variables.botToken, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(new MainBot())
                .setActivity(Activity.playing(Variables.botStatus))
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Member author = event.getMember();

        Message session = event.getMessage();
        if (session.getContentRaw().startsWith(Variables.commandPrefix + "session")) {
            MessageChannel channel = event.getChannel();
            assert author != null;
            String userRoles = String.valueOf(author.getRoles());
            if (userRoles.contains(Variables.staffRoleID)) {
                mcChatRelayChannel = event.getGuild().getTextChannelById(Variables.minecraftChatChannelID);
                channel.sendMessage("A new session has been created. Relay channel is set to <#" + Variables.minecraftChatChannelID + ">.").queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                session.delete().queueAfter(3, TimeUnit.SECONDS);
                sessionToggle = 0;
                System.out.println(mcChatRelayChannel);
            } else {
                channel.sendMessage("You do not have access to this command.").queue(message -> message.delete().queueAfter(3, TimeUnit.SECONDS));
                session.delete().queueAfter(3, TimeUnit.SECONDS);
            }
        }
    }
}
