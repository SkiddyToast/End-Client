package paradox.client.main.gui;

import java.util.Random;
import java.text.DecimalFormat;

import org.apache.logging.log4j.core.appender.RandomAccessFileManager;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import paradox.client.main.Client;
import paradox.client.main.module.Module;
import paradox.client.main.module.ModuleManager;

public class InGameGUI extends GuiScreen {
	
	public InGameGUI() {
		this.mc = Minecraft.getMinecraft();
	}
	
	public void renderScreen() {
		DecimalFormat dFormatter = new DecimalFormat("0.00");
		double x = mc.player.posX;
		double y = mc.player.posY;
		double z = mc.player.posZ;
		String sx = dFormatter.format(x);
		String sy = dFormatter.format(y);
		String sz = dFormatter.format(z);
		
		String ClientName = Client.clientName;
		String ClientVersion = Client.clientVersion;
		mc.fontRendererObj.drawString(ClientName + ClientVersion, 4, 4, 0xffffffff);
		mc.fontRendererObj.drawString("Username: " + mc.player.getName(), 4, 14, 0xffffffff);
		mc.fontRendererObj.drawString(sx + ", " + sy + ", " + sz, 4, 24, 0xffffffff);
		mc.fontRendererObj.drawString("FPS:" + mc.getDebugFPS() + "/" + mc.getLimitFramerate(), 4, 34, 0xffffffff);
		//Horizontal space in text here
		mc.fontRendererObj.drawString("Enabled Modules:", 4, 54, 0xffffffff);
		int count = 0;
		for(Module module : ModuleManager.getModules()) {
			mc.fontRendererObj.drawString("- " + module.getName(), 4, 64 + (10 * count), 0xffffffff);
			count++;
		}
	}
}
