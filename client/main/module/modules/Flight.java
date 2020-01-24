package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import paradox.client.main.module.Category;
import paradox.client.main.module.Module;

public class Flight extends Module {
	
	public Flight() {
		super("Flight", Category.MOVEMENT, Keyboard.KEY_F);
	}
	
	public void onDisable() {
		if(!this.isEnabled()) {
			mc.player.capabilities.isFlying = false;
			super.onDisable();
		}
	}
	
	@Override
	public void onPreUpdate() {
		
		if(!isEnabled()) {
			return;
		}
		
		mc.player.capabilities.isFlying = true;
		super.onPreUpdate();
	}
	
}
