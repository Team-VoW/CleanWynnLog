package com.voicesofwynn.cleanwynnlog.events;


import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.util.Timer;
import java.util.TimerTask;

@Mod.EventBusSubscriber
public class JoinServerEvent {


    @SubscribeEvent
    public static void onServerJoin(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        Timer timer = new Timer();

        timer.schedule(new SchedulerTask(), 10000L);
    }

    public static class SchedulerTask extends TimerTask {
        @Override
        public void run() {

            String message = "You are using the CleanLogMod. If you no longer need it then make sure to delete it, as the bigger the file gets, the heavier it will become on your pc";
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(message));


        }
    }
}
