package paradox.client.main.module;

public enum Category {
	COMBAT, MOVEMENT, PLAYER, MISC, RENDER;
	
	public static int size(Category cat) {
		int i = 0;
		
		for(Module m : ModuleManager.getAllModules()) {
			if(m.getCategory().equals(cat)) {
				i++;
			}
		}
		
		return i;
	}
	
	public static int placeInListRender(Module m) {
		
		int i = 0;
		
		for(Module mod : ModuleManager.getAllModules()) {
			if(mod.getCategory().equals(RENDER) && !mod.equals(m)) {
				i++;
				continue;
			}
			if(mod.getCategory().equals(RENDER) && mod.equals(m)) {
				return i;
			}
		}
		
		return 0;
	}
	
	public static int placeInListCombat(Module m) {
		
		int i = 1;
		
		for(Module mod : ModuleManager.getAllModules()) {
			if(mod.getCategory().equals(COMBAT) && !mod.equals(m)) {
				i++;
				continue;
			}
			if(mod.getCategory().equals(COMBAT) && mod.equals(m)) {
				return i;
			}
		}
		
		return 0;
	}

	public static int placeInListMovement(Module m) {
	
	int i = 1;
	
	for(Module mod : ModuleManager.getAllModules()) {
		if(mod.getCategory().equals(MOVEMENT) && !mod.equals(m)) {
			i++;
			continue;
		}
		if(mod.getCategory().equals(MOVEMENT) && mod.equals(m)) {
			return i;
		}
	}
	
	return i;
	}
	
	public static int placeInListPlayer(Module m) {
		
		int i = 1;
		
		for(Module mod : ModuleManager.getAllModules()) {
			if(mod.getCategory().equals(PLAYER) && !mod.equals(m)) {
				i++;
				continue;
			}
			if(mod.getCategory().equals(PLAYER) && mod.equals(m)) {
				return i;
			}
		}
		
		return 0;
	}
	
	public static int placeInListMisc(Module m) {
		
		int i = 1;
		
		for(Module mod : ModuleManager.getAllModules()) {
			if(mod.getCategory().equals(MISC) && !mod.equals(m)) {
				i++;
				continue;
			}
			if(mod.getCategory().equals(MISC) && mod.equals(m)) {
				return i;
			}
		}
		
		return 0;
	}
}
