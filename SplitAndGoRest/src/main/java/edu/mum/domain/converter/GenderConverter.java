package edu.mum.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import edu.mum.domain.Gender;

@Converter(autoApply = true)
public class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		switch (gender) {
		case MALE:
			return 0;
		case FEMALE:
			return 1;
		default:
			throw new IllegalArgumentException("Unknown value: " + gender);
		}
	}

	@Override
	public Gender convertToEntityAttribute(Integer fromDatabase) {
		switch (fromDatabase) {
		case 0:
			return Gender.MALE;
		case 1:
			return Gender.FEMALE;
		default:
			throw new IllegalArgumentException("Unknown value: " + fromDatabase);
		}
	}

}
