package com.pluralsight.command;

import java.util.ArrayList;
import java.util.List;

//client
public class CommandDemo {

	public static void main(String args[]) {
		Light bedroomLight = new Light();
		Light kitchenLight = new Light();
		Switch lightSwitch = new Switch(); 
		
		Command toggleCommand = new ToggleCommand(bedroomLight);
		Command togglekichCommand = new ToggleCommand(kitchenLight);
		
		
		lightSwitch.storeAndExecute(toggleCommand);
		lightSwitch.storeAndExecute(togglekichCommand);
		lightSwitch.storeAndExecute(toggleCommand);
		
		List<Light> lights = new ArrayList<>();
		lights.add(kitchenLight);
		lights.add(bedroomLight);
		Command allLightsCommand = new AllLightsCommand(lights);
		
		lightSwitch.storeAndExecute(allLightsCommand);
	}
}
