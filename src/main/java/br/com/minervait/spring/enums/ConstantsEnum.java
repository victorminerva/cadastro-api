package br.com.minervait.spring.enums;

public enum ConstantsEnum {

	EMAIL("^[a-z]{1,6}_?\\d{0,4}@[a-z0-9.-]+\\.[a-z]{2,}$");

	public String value;

	private ConstantsEnum(String value) {
		this.value = value;
	}

}
