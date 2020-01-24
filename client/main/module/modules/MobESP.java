package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import paradox.client.main.module.Category;
import paradox.client.main.module.Module;
import paradox.client.main.utils.RenderUtils;

public class MobESP  extends Module{

	public MobESP() {
		super("MobESP", Category.RENDER, Keyboard.KEY_K);
	}
	@Override
	public void onRender() {
		if(this.isEnabled()) {
			for(Object e : mc.world.loadedEntityList) {
				if(e instanceof EntityLivingBase) {
					if(e instanceof EntityPlayer) {
						if(e != mc.player)
							RenderUtils.entityESPBox((Entity)e, 3);
							continue;
						}
						if(e instanceof EntityMob) {
							RenderUtils.entityESPBox((Entity)e, 0);
							continue;
						}
						if(e instanceof EntityAnimal) {
							RenderUtils.entityESPBox((Entity)e, 2);
							continue;
						}
					
						RenderUtils.entityESPBox((Entity)e, 2);
					}
			}
		}
	}
}
