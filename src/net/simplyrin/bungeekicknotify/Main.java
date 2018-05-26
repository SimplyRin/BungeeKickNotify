package net.simplyrin.bungeekicknotify;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by SimplyRin on 2018/04/22
 */
public class Main extends Plugin implements Listener {

	private static Main instance;

	@Override
	public void onEnable() {
		instance = this;
		instance.getProxy().getPluginManager().registerListener(instance, instance);
	}

	@EventHandler
	public void onKick(ServerKickEvent event) {
		ProxiedPlayer player = event.getPlayer();

		instance.getProxy().getConsole().sendMessage(new TextComponent("§7[§cBungeeKickNotify§7] §e" + player.getName() + " was kicked! §c[" + event.getKickReason() + "§c]"));
		for(ProxiedPlayer p : instance.getProxy().getPlayers()) {
			if(p.hasPermission("bungeekicknotify")) {
				p.sendMessage(new TextComponent("§7[§cBungeeKickNotify§7] §e" + player.getName() + " was kicked! §c[" + event.getKickReason() + "§c]"));
			}
		}
	}

}
