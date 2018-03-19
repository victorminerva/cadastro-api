package br.com.minervait.spring.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.minervait.spring.enums.ConstantsEnum;

public class CadastroUtils {

	public static Boolean isEmailValid(String email) {
		Boolean isValid = Boolean.FALSE;

		final Pattern pattern = Pattern.compile(ConstantsEnum.EMAIL.value);
		final Matcher matcher = pattern.matcher(email);

		isValid = matcher.find();

		return isValid;
	}

}
