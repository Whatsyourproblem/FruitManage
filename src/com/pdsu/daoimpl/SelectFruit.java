package com.pdsu.daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.pdsu.bean.Fruit;
import com.pdsu.dao.ISelectFruit;

public class SelectFruit implements ISelectFruit {

	@Override
	public List<Fruit> selectFruit() throws Exception {
			List<Fruit> list = new ArrayList<Fruit>();
			
			File file = new File("store.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = null;

	        while(fis.available()>0){
	        	ois = new ObjectInputStream(fis);
	            Fruit fruit = (Fruit) ois.readObject();
	            list.add(fruit);
	        }
			ois.close(); 
			fis.close();
			return list;
	}
	
	

}
