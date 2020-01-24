package paradox.client.main.module;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;

public class Module {
	private String name;
	private Category category;
	private String description;
	private int keyCode;
	private String[] modes;
	
	private boolean enabled;
	
	protected Minecraft mc = Minecraft.getMinecraft();
	
	public Module(String name, Category category) {
		this(name, category, null, Keyboard.KEY_NONE, "default");
	}
	public Module(String name, Category category, String description) {
		this(name, category, description, Keyboard.KEY_NONE, "default");
	}
	public Module(String name, Category category, int keyCode) {
		this(name, category, null, keyCode, "default");
	}
	public Module(String name, Category category, String description, int keyCode, String... modes) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.keyCode = keyCode;
		this.modes = modes;
		this.enabled = false;
	}
	
	public Category getCategory() {
		return this.category;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void onDisable() {
		
	}
	public void onEnable() {
		
	}
	
	public void onRender() {
		
	}
	public void onPreUpdate() {
		
	}
	public void onPostUpdate() {
		
	}
	public void onKeyPressed(int keyCode) {
		if(this.keyCode == keyCode) {
			this.toggle();
		}
	}
	public void toggle() {
		enabled = !enabled;
		if(this.enabled) {
			onEnable();
		}else {
			onDisable();
		}
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public boolean onSendChatMessage(String s){
		return true;
	}
	
	public boolean onRecieveChatMessage(SPacketChat packet){
		return true;
	}
	
}
