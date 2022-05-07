package fr.tartur.cardinal.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnMessage extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (!event.getChannel().getId().equals("971701327350603816")) return;

        String message = event.getMessage().getContentRaw().toLowerCase();

        if (
                message.contains("salut")   ||
                        message.contains("coucou")  ||
                        message.contains("hey")     ||
                        message.contains("hello")   ||
                        message.contains("bonsoir") ||
                        message.contains("bonjour")
        ) {
            // Adding wave emoji reaction to message
            event.getMessage().addReaction("\uD83D\uDC4B").queue();
        }

    }
}