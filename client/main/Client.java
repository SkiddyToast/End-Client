package paradox.client.main;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.TextComponentString;
import paradox.client.main.command.CommandManager;
import paradox.client.main.module.Module;
import paradox.client.main.module.ModuleManager;


public class Client {
	public static String clientName = "End Client";
	public static String clientVersion = " Pre-Release 1.4";
	
	public static ModuleManager moduleManager;
	private static CommandManager commandManager;
	
	public static void init() {
		moduleManager = new ModuleManager();
		moduleManager.init();
		commandManager = new CommandManager();
	}
	public static void onRender() {
		for(Module module : moduleManager.getEnabledModules()) {
			module.onRender();
		}
	}
	public static void onPreUpdate() {
		for(Module module : moduleManager.getEnabledModules()) {
			module.onPreUpdate();
		}
	}
	public static void onPostUpdate() {
		for(Module module : moduleManager.getEnabledModules()) {
			module.onPostUpdate();
		}
	}
	public static void onKeyPressed(int keyCode) {
		for(Module module : moduleManager.moduleList) {
			module.onKeyPressed(keyCode);
		}
	}
	public static void addChatMessage(String s){
		Minecraft.getMinecraft().player.addChatMessage(new TextComponentString("[End Client] " + s));
	}
	
	public static boolean onSendChatMessage(String s){//EntityPlayerSP
		if(s.startsWith(".")){
			commandManager.callCommand(s.substring(1));
			return false;
		}
		for(Module m: ModuleManager.getAllModules()){
			if(m.isEnabled()){
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	
	public static boolean onRecieveChatMessage(SPacketChat packet){
		for(Module m: ModuleManager.getAllModules()){
			if(m.isEnabled()){
				return m.onRecieveChatMessage(packet);
			}
		}
		return true;
	}
}
