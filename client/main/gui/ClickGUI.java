package paradox.client.main.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiScreen;
import paradox.client.main.module.Category;
import paradox.client.main.module.Module;
import paradox.client.main.module.ModuleManager;

public class ClickGUI extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		drawRect(150, 2, 220, 14, 0x80000000);
		mc.fontRendererObj.drawString("Combat Hacks", 152, 4, 0xffffff);
		drawRect(250, 2, 322, 14, 0x80000000);
		mc.fontRendererObj.drawString("Render Hacks", 252, 4, 0xffffff);
		drawRect(350, 2, 432, 14, 0x80000000);
		mc.fontRendererObj.drawString("Movement Hacks", 352, 4, 0xffffff);
		drawRect(450, 2, 522, 14, 0x80000000);
		mc.fontRendererObj.drawString("Player Hacks", 452, 4, 0xffffff);
		drawRect(550, 2, 606, 14, 0x80000000);
		mc.fontRendererObj.drawString("Misc Hacks", 552, 4, 0xffffff);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	public int placeForHackY(Module m) {
		
		if(m.getCategory().equals(Category.COMBAT)) return Category.placeInListCombat(m) * 14;
		if(m.getCategory().equals(Category.MISC)) return 14 + Category.placeInListMisc(m) *14;
		if(m.getCategory().equals(Category.MOVEMENT)) return Category.placeInListMovement(m) * 14 - 14;
		if(m.getCategory().equals(Category.PLAYER)) return Category.placeInListPlayer(m) * 14;
		if(m.getCategory().equals(Category.RENDER)) return 14 + Category.placeInListRender(m) * 14;
		
		return 0;
	}
	
	public int placeForHackX(Module m) {
		
		if(m.getCategory().equals(Category.COMBAT)) return 150;
		if(m.getCategory().equals(Category.MISC)) return 550;
		if(m.getCategory().equals(Category.MOVEMENT)) return 350;
		if(m.getCategory().equals(Category.PLAYER)) return 450;
		if(m.getCategory().equals(Category.RENDER)) return 250;
		
		return 0;
	}
	
	@Override
	public void initGui() {
		for(int i = 1; i < ModuleManager.moduleList.size(); i++) {
			Module m = ModuleManager.moduleList.get(i);
			buttonList.add(new GuiButton(i, placeForHackX(m), placeForHackY(m), 25 + (m.getName().length() * 3) + m.getName().length() * 2, 14, m.getName()));
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		for(int i = 1; i < ModuleManager.moduleList.size(); i++) {
			if(button.id == i) {
				ModuleManager.moduleList.get(i).toggle();
			}
		}
	}
}
