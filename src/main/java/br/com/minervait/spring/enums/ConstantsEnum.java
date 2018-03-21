package br.com.minervait.spring.enums;

public enum ConstantsEnum {

	EMAIL("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

	public String value;

	private ConstantsEnum(String value) {
		this.value = value;
	}

}
