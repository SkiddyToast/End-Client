package paradox.client.main.command;

import java.util.ArrayList;

import paradox.client.main.Client;
import paradox.client.main.commands.Toggle;

public class CommandManager {
	
	private ArrayList<Command> commands;
	
	public CommandManager(){
		commands = new ArrayList();
		addCommand(new Toggle());
	}
	
	public void addCommand(Command c){
		commands.add(c);
	}
	
	public ArrayList<Command> getCommands(){
		return commands;
	}
	
	public void callCommand(String input){
		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();
		for(Command c: getCommands()){
			if(c.getAlias().equalsIgnoreCase(command)){
				try{
					c.onCommand(args, args.split(" "));
				}catch(Exception e){
					Client.addChatMessage("Invalid Command Usage!");
					Client.addChatMessage(c.getSyntax());
				}
				return;
			}
		}
		Client.addChatMessage("Command not found!");
	}

}
