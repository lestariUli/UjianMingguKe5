package com.juaracoding.ujianMinggu5.driver;

import com.juaracoding.ujianMinggu5.utils.Constant;


public class DriverStrategyImplement {
	public static DriverStrategy chooseStrategy (String strategy) {
		switch (strategy) {
		case Constant.CHROME:
			return new Chrome();
		case Constant.FIREFOX:
			return new Firefox();
		default:
			return null;
		}
		
		
	}

}
