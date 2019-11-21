package com.atgui.utils;
import java.util.Map;

public class BeanUtils {
	
	public static<T> T getBean(T bean,Map map) {
		try {
			org.apache.commons.beanutils.BeanUtils.populate(bean, map);
			return  bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
