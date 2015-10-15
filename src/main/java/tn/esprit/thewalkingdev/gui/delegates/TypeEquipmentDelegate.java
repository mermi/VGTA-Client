package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.TypeEquipment;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.TypeEquipmentDAORemote;

public class TypeEquipmentDelegate {

	private static TypeEquipmentDAORemote remote;
	private static final String jndi="vgta/TypeEquipmentCrud!tn.esprit.thewalkingdev.services.contract.TypeEquipmentDAORemote";
	
	public static TypeEquipmentDAORemote getProxy( )
	{			 

		return (TypeEquipmentDAORemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
	public static void addTypeEquipment(TypeEquipment typeEquipment){
		getProxy().addTypeEquipment(typeEquipment);
	}
	public static void deleteTypeEqui(TypeEquipment typeEquipment){
		getProxy().deleteTypeEquipment(typeEquipment);
	}
	public static List<TypeEquipment> displayTypeEquipments(){
		return getProxy().findAllTypeEquipment();
	}
	public static void updateTypeEq(TypeEquipment typeEquipment){
		getProxy().updateTypeEquipment(typeEquipment);
	}
	public static TypeEquipment findBrandById(Integer idTypeEquipment){
		return getProxy().findTypeEquipmentById(idTypeEquipment);
	}
}
