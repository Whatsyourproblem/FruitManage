package com.pdsu.daoimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.pdsu.bean.Fruit;
import com.pdsu.dao.IAddFruit;

public class AddFruit implements IAddFruit {
	
	@Override
	public void addFruit(Fruit fruit) throws Exception {
		File file = new File("store.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(fruit);
		oos.close();
		fos.close();
	} 
}
