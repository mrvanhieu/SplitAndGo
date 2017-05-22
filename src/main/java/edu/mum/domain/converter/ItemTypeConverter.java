package edu.mum.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import edu.mum.domain.ItemType;

@Converter(autoApply = true)
public class ItemTypeConverter implements AttributeConverter<ItemType, String> {

	@Override
	public String convertToDatabaseColumn(ItemType itemType) {
		if (itemType == null) {
			return null;
		}

		switch (itemType) {
		case FOOD:
			return "Food";
		case DRINK:
			return "Drink";
		case ACCESSORY:
			return "Accessory";
		default:
			throw new IllegalArgumentException("Unknown value: " + itemType);
		}
	}

	@Override
	public ItemType convertToEntityAttribute(String fromDatabase) {
		if (fromDatabase == null) {
			return null;
		}
		
		switch (fromDatabase) {
		case "Food":
			return ItemType.FOOD;
		case "Drink":
			return ItemType.DRINK;
		case "Accessory":
			return ItemType.ACCESSORY;
		default:
			throw new IllegalArgumentException("Unknown value: " + fromDatabase);
		}
	}

}
