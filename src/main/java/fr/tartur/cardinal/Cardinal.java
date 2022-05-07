package fr.tartur.cardinal;

import fr.tartur.cardinal.events.OnMessage;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Cardinal {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();

        try {
            JDABuilder.createDefault(dotenv.get("TOKEN"))
                    .setActivity(Activity.playing("modérer l'Oasis"))
                    .disableCache(CacheFlag.ACTIVITY, CacheFlag.CLIENT_STATUS)
                    .addEventListeners(new OnMessage())
                    .build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }

    }

}