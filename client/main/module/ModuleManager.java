package paradox.client.main.module;

import java.util.ArrayList;

import paradox.client.main.gui.InGameGUI;
import paradox.client.main.module.modules.StorageESP;
import paradox.client.main.module.modules.Flight;
import paradox.client.main.module.modules.FullBright;
import paradox.client.main.module.modules.Gui;
import paradox.client.main.module.modules.Jesus;
import paradox.client.main.module.modules.KillAura;
import paradox.client.main.module.modules.MobESP;
import paradox.client.main.module.modules.NoFall;
import paradox.client.main.module.modules.Sprint;
import paradox.client.main.module.modules.Step;
import paradox.client.main.module.modules.Tracers;
import paradox.client.main.module.modules.Xray;

public class ModuleManager {
	public static ArrayList<Module> moduleList = new ArrayList<Module>();
	private static InGameGUI inGameGUI;
	public boolean toggled;
	
	public void init() {
		moduleList.add(new Sprint());
		moduleList.add(new Flight());
		moduleList.add(new Tracers());
		moduleList.add(new NoFall());
		moduleList.add(new MobESP());
		moduleList.add(new KillAura());
		moduleList.add(new Jesus());
		moduleList.add(new Step());
		moduleList.add(new StorageESP());
		moduleList.add(new FullBright());
		
		
		
		moduleList.add(new Gui());
		
		inGameGUI = new InGameGUI();
	}
	
	public void toggle(){
		toggled = !toggled;
		if(toggled){
			onEnable();
		}else{
			onDisable();
		}
	}
	
	public void onEnable(){}
	public void onDisable(){}
	
	public static InGameGUI getInGameGUI() {
		return inGameGUI;
	}
	
	public static ArrayList<Module> getAllModules() {
		return moduleList;
	}
	
	public static ArrayList<Module> getModules() {
		return getEnabledModules();
	}
	
	public static ArrayList<Module> getEnabledModules() {
		ArrayList<Module> toggledModules = new ArrayList<Module>();
		for(Module module : moduleList) {
			if(module.isEnabled()) {
				toggledModules.add(module);
			}
		}
		return toggledModules;
	}
	public boolean isToggled() {
		return toggled;
	}

}
