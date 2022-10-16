package com.voicesofwynn.cleanwynnlog.events;

import com.voicesofwynn.cleanwynnlog.CleanWynnLog;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SendChatEvent {

    @SubscribeEvent
    public static void onSendChat(ClientChatEvent event) {

        String message = event.getMessage();

        if (message.startsWith("/neatlog")){
            help();
            return;
        }

        if (!message.toLowerCase().startsWith("/addnote"))
            return;

        message = message.split(" ", 2)[1];

        CleanWynnLog.neatLogger.write("//" + message + "\n");
    }


    private static void help(){
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString("NEATLOG: /addnote to add a note. /toggle nonNumDia"));
    }
}



