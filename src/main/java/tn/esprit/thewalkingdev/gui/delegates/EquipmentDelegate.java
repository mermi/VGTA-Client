package tn.esprit.thewalkingdev.gui.delegates;


import java.util.List;

import javafx.scene.chart.PieChart;
import tn.esprit.thewalkingdev.entites.Equipment;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.EquipmentRemote;
import tn.esprit.thewalkingdev.services.contract.TypeEquipmentDAORemote;

public class EquipmentDelegate {
	
	private static EquipmentRemote remote;
	private static final String jndi="vgta/EquipmentCrud!tn.esprit.thewalkingdev.services.contract.EquipmentRemote";
	
	public static EquipmentRemote getProxy( )
	{			 

		return (EquipmentRemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
		public static void addEquipment(Equipment equi){
			getProxy().addEquipement(equi);
		}
		public static void deleteEquipment(Equipment equi){
			getProxy().deleteEquipement(equi);
		}
		public static void updateEquipment(Equipment equi){
			getProxy().updateEquipement(equi);
		}
		public static List<Equipment> displayEquis(){
			return getProxy().findAllEquipements();
		}
		public static Equipment findEquiById(Integer idEqui){
			return getProxy().findEquipementById(idEqui);
		}
		public static List<Equipment> search(Integer keyword){
			return getProxy().search(keyword);
		}
		
	}


