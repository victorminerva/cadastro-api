package br.com.minervait.spring.enums;

/**
 * 
 * <p>
 * Represents the sex of the person.
 * <li><u>M</u>ALE</li>
 * <li><u>F</u>EMALE</li>
 * <li><u>O</u>THERS</li>
 *
 * @author Victor Minerva
 * @since Mar 13, 2018.
 *
 */
public enum SexoEnum {

	/** Sex Male */
	M("Masculino", "M"),

	/** Sex Female */
	F("Feminino", "F"),

	/** Others for sex not defined yet */
	O("Outros", "O");

	private String value;
	private String displayValue;

	private SexoEnum(String value, String displayValue) {
		this.value = value;
		this.displayValue = displayValue;
	}

	public String getValue() {
		return value;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	private SexoEnum getSexoEnumByValue(final String value) {
		return SexoEnum.valueOf(value);
	}

	private SexoEnum getSexoEnumByDisplayValue(final String displayValue) {
		for (SexoEnum sexo : SexoEnum.values()) {
			if (sexo.displayValue.equals(displayValue)) {
				return sexo;
			}
		}
		throw new IllegalStateException(String.format("Unsupported type %s.", displayValue));
	}
}
