package tn.esprit.thewalkingdev.gui.utils;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServicesLocator {
	
	private Context context;
	private Map<String, Object> cache;
	private static ServicesLocator instance;
	
	public static ServicesLocator getInstance() {
		if(instance==null){
			return new ServicesLocator();
		}
		return instance;
	}
	private ServicesLocator() {
		cache = new HashMap<>();
	}
	public Object getProxy(String jndiName) {
		if(cache.containsKey(jndiName)){
			return cache.get(jndiName);
		}
		else{
			try {
				context = new InitialContext();
				cache.put(jndiName, context.lookup(jndiName));
				return cache.get(jndiName);
			} catch (NamingException e) {
				return null;
			}

		}
		
	}
}
