package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import paradox.client.main.module.Category;
import paradox.client.main.module.Module;

public class Sprint extends Module {
	public Sprint() {
		super("Sprint", Category.MOVEMENT, Keyboard.KEY_V);
	}
	
	@Override
	public void onPreUpdate() {
		super.onPreUpdate();
		
		if(mc.player.movementInput.moveForward > 0) {
			mc.player.setSprinting(true);
		}
	}
}
