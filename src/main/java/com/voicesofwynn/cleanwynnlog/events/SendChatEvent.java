package com.voicesofwynn.cleanwynnlog.events;

import com.voicesofwynn.cleanwynnlog.CleanWynnLog;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SendChatEvent {

    @SubscribeEvent
    public static void onSendChat(ClientChatEvent event) {

        String message = event.getMessage();
        if (!message.toLowerCase().startsWith("/addnote"))
            return;

        message = message.split(" ", 2)[1];

        CleanWynnLog.neatLogger.write("//" + message + "\n");
    }

}



