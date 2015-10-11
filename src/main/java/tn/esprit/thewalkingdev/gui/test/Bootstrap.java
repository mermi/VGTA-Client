package tn.esprit.thewalkingdev.gui.test;





import java.util.Date;

import tn.esprit.thewalkingdev.entites.Event;
import tn.esprit.thewalkingdev.gui.delegates.EventCrudDelegate;

public class Bootstrap {

	public static void main(String[] args) {
		System.out.println("Iam in boot");

		EventCrudDelegate.addEvent(new Event("kkkkk", null, 52, "fadoua", false, false, null, null, null));

		System.out.println("boot is over");

	}

}
