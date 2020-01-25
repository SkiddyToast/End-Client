package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import paradox.client.main.module.Category;
import paradox.client.main.module.Module;

public class Jesus extends Module {
	
	public Jesus() {
		super("Jesus", Category.MOVEMENT, 0);
	}
	@Override
	public void onPreUpdate() {
		
		if(mc.world.getBlockState(new BlockPos(mc.player.posX, mc.player.posY - 0.1, mc.player.posZ)).getBlock() == Block.getBlockFromName("Water")){
            mc.player.motionY = 0;
            mc.player.onGround = true;
        }
		if(mc.player.isInWater()) {
            mc.player.motionY = 0.1;
        }
	}
	
}
