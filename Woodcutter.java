package Woodcutter;
import java.awt.Graphics;
import org.osbot.rs07.script.MethodProvider;
import org.osbot.rs07.api.Players;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import org.osbot.rs07.api.Objects;
import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.Inventory;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.Walking;
import org.osbot.rs07.api.model.Character;


@ScriptManifest(author="FinesseKing (Quinn)", info = "Cuts logs in Falador and banks them", name = "Woodcutter Bot", logo = "none", version = 0)

public class WoodcutterBot extends Script {

	final String YEW_NAME = "Yew";
	final Area BANK_AREA = new Area(1249, 2130, 1257, 2138);
	final Area YEW_AREA = new Area(1210, 2155, 1185, 2115);

	final int BANK_BOOTH_ID = 13161;

	public int onLoop() throws InterruptedException {

		Inventory inven = getInventory();
		Players player = getMyPlayerIndex();
		Bank bank = getBank();

		if (!inven.isFull()) {

		if(YEW_AREA.contains(player)){
			Entity yew = closestObjectForName(YEW_NAME);

		if (yew != null) {
			
		if (yew.isVisible()) {
			
		if (!player.isAnimating()) {
			
		if (!player.isMoving()) {
			yew.interact("Chop down");
			sleep(random(500, 750));
						}
					}
				} 
		else {
				client.moveCameraToEntity(yew);
				}
			}
	   }
		else{
			walk(YEW_AREA);
			}
		}
		else {
			
		if (BANK_AREA.contains(player)) {
			Entity bankbooth = closestObject(BANK_BOOTH_ID);

		if (bank.isOpen()) {
			bank.depositAll();
	    	} 
		else {
		if (bankbooth != null) {
		if (bankbooth.isVisible()) {
			bankbooth.interact("Bank");
			sleep(random(500, 800));
						}
        else{
			client.moveCameraToEntity(bankbooth);
						}
					}
				}

			} 
    	  else {
			walk(BANK_AREA);
			}
			
		}

		return 150;
	}
	public void onExit() {

		stop();
	}

}