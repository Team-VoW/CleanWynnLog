package com.voicesofwynn.cleanwynnlog.events;


import com.voicesofwynn.cleanwynnlog.CleanWynnLog;
import com.voicesofwynn.cleanwynnlog.NeatLog.LineData;
import com.voicesofwynn.cleanwynnlog.NeatLog.LineFormatter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.vecmath.Vector3f;

@Mod.EventBusSubscriber
public class
ReceiveChatEvent {

    private static final Vector3f mixedFeelingsNPC1 = new Vector3f(-5881, 17, -2464);
    private static final Vector3f mixedFeelingsNPC2 = new Vector3f(-5835, 16, -2463);
    private static final Vector3f mixedFeelingsNPC3 = new Vector3f(-5807, 16, -2421);


    @SubscribeEvent
    public static void receivedChat(ClientChatReceivedEvent event) {
        String msg = event.getMessage().getUnformattedText();

        //Replace player Name with "soldier"
        String name = GetPlayerName(event.getMessage().toString());
        if (msg.contains(name)) {
            msg = msg.replace(name, "soldier");
        }


        LineData lineData = LineFormatter.formatToLineData(msg);

        String message = lineData.getRealLine();

        if (!LineFormatter.isNPCSentLine(message) && !msg.contains("Press SHIFT to continue")){
            return;
        }

        CleanWynnLog.neatLogger.ReceivedChat(message);
    }


    private static String GetPlayerName(String eventMessageToString) {
        String segments[] = eventMessageToString.split("hoverEvent=HoverEvent\\{action=SHOW_TEXT, value='TextComponent\\{text='");
        if (segments.length <= 1) return Minecraft.getMinecraft().player.getDisplayNameString();

        String name = segments[segments.length - 1].split("',")[0];
        if (name.contains("Previous")) return Minecraft.getMinecraft().player.getDisplayNameString();
        return name.split("'")[0];
    }
}


