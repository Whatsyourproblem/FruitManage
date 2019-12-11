package com.pdsu.dao;

import java.util.List;

import com.pdsu.bean.Fruit;

public interface ISelectFruit {
	List<Fruit> selectFruit() throws Exception;
}
