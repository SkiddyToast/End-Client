package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import paradox.client.main.module.Category;
import paradox.client.main.module.Module;

public class Step extends Module {
	
	public Step() {
		super("Step", Category.MOVEMENT, 0);
	}
	
	public void onDisable() {
		if(!this.isEnabled()) {
			mc.player.stepHeight = 0.5F;
			super.onDisable();
		}
	}
	
	@Override
	public void onPreUpdate() {
		
		if(!isEnabled()) {
			return;
		}
		
		mc.player.stepHeight = 2F;
		super.onPreUpdate();
	}
	
}
