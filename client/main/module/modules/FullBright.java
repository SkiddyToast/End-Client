package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import paradox.client.main.module.Category;
import paradox.client.main.module.Module;
import paradox.client.main.utils.RenderUtils;

public class FullBright extends Module{

	public FullBright() {
		super("FullBright", Category.RENDER, Keyboard.KEY_0);
	}
	
	@Override
	public void onRender() {
		if(this.isEnabled()) {
			mc.gameSettings.gammaSetting = 10f;
		} else {
			mc.gameSettings.gammaSetting = 0.5f;
		}
	}
}

