package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityShulkerBox;
import paradox.client.main.module.Category;
import paradox.client.main.module.Module;
import paradox.client.main.utils.RenderUtils;

public class StorageESP extends Module{

	public StorageESP() {
		super("StorageESP", Category.RENDER, Keyboard.KEY_0);
	}
	
	@Override
	public void onRender() {
		if(this.isEnabled()) {
			for(Object o : mc.world.loadedTileEntityList) {
				if(o instanceof TileEntityEnderChest) {
					RenderUtils.enderChestESPBox(((TileEntityEnderChest)o).getPos());
				}
				else if(o instanceof TileEntityChest)
                {
                    RenderUtils.blockESPBox(((TileEntityChest)o).getPos());
                }
				else if(o instanceof TileEntityShulkerBox) {
					RenderUtils.shulkerESPBox(((TileEntityShulkerBox)o).getPos());
				}
			}
		}
	}

}
