package paradox.client.main.module.modules;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import paradox.client.main.module.Category;
import paradox.client.main.module.Module;
import paradox.client.main.utils.RenderUtils;

public class Tracers extends Module {
	
	public Tracers() {
		super("Tracers", Category.RENDER, Keyboard.KEY_Y);
	}
	
	@Override
	public void onRender() {
		
		if(!this.isEnabled()) {
			return;
		}
		
		for(Object theObject : mc.world.loadedEntityList) {
			if(!(theObject instanceof EntityLivingBase))
				continue;
			
			EntityLivingBase entity = (EntityLivingBase) theObject;
			
			if(entity instanceof EntityPlayer) {
				if(entity != mc.player)
					player(entity);
				continue;
			}
			if(entity instanceof EntityMob) {
				mob(entity);
				continue;
			}
			if(entity instanceof EntityAnimal) {
				animal(entity);
				continue;
			}
			
			passive(entity);
		}
		
		super.onRender();
	}
	
	
	public void player(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 1F;
		
		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void mob(EntityLivingBase entity) {
		float red = 1F;
		float green = 0.5F;
		float blue = 0.5F;

		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void animal(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 1F;
		float blue = 0.5F;

		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void passive(EntityLivingBase entity) {
		float red = 0.5F;
		float green = 0.5F;
		float blue = 0.5F;

		double xPos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosX;
		double yPos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosY;
		double zPos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().renderPosZ;
		
		render(red, green, blue, xPos, yPos, zPos);
	}
	
	public void render(float red, float green, float blue, double x, double y, double z) {
		RenderUtils.drawTracerLine(x, y, z, red, green, blue, 0.5F, 1F);
	}
}
