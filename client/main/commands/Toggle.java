package paradox.client.main.commands;

import paradox.client.main.Client;
import paradox.client.main.command.Command;
import paradox.client.main.module.Module;
import paradox.client.main.module.ModuleManager;

public class Toggle extends Command{

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "toggle";
	}
	
	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ".toggle <Module>";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		boolean found = false;
		for(Module m: ModuleManager.getAllModules()){
			if(args[0].equalsIgnoreCase(m.getName())){
				m.toggle();
				found = true;
				Client.addChatMessage(m.getName() + " was toggled!");
			}
		}
		if(found == false){
			Client.addChatMessage("Targeted Module was not found!");
		}
	}

}
