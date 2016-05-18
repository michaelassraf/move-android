package com.lbis.enums;

public enum PathEnums {
	NAVIGENIE_PREFIX_FOLDER("/move"),NAVIGENIE_DATA_FILE_NAME("data.zip"),NAVIGENIE_TEMP_FILE_NAME("temp.zip") ;

	private final String pathValue;

	public String getPathValue() {
		return pathValue;
	}

	private PathEnums(String pathValue) {
		this.pathValue = pathValue;
	}

}