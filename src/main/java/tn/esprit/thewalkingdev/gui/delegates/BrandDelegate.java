package tn.esprit.thewalkingdev.gui.delegates;

import java.util.List;

import tn.esprit.thewalkingdev.entites.Brand;
import tn.esprit.thewalkingdev.entites.Equipment;
import tn.esprit.thewalkingdev.gui.utils.ServicesLocator;
import tn.esprit.thewalkingdev.services.contract.BrandRemote;
import tn.esprit.thewalkingdev.services.contract.GamerRemote;

public class BrandDelegate {
	private static BrandRemote remote;
	private static final String jndi="vgta/BrandCrud!tn.esprit.thewalkingdev.services.contract.BrandRemote";
	
	public static BrandRemote getProxy( )
	{			 

		return (BrandRemote) ServicesLocator.getInstance().getProxy(jndi);
		
	}
	
	public static void addBrand(Brand brand){
		getProxy().addBrand(brand);
	}
	public static void deleteBrand(Brand brand){
		getProxy().deleteBrand(brand);
	}
	public static List<Brand> displayBrands(){
		return getProxy().findAllBrands();
	}
	public static void updateBrand(Brand brand){
		getProxy().updateBrand(brand);
	}
	public static Brand findBrandById(Integer idBrand){
		return getProxy().findBrandById(idBrand);
	}
	public static List<Brand> search(String keyword){
		return getProxy().search(keyword);
	}
}
