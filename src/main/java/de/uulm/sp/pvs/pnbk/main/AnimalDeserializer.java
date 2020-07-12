package de.uulm.sp.pvs.pnbk.main;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import de.uulm.sp.Zoo.animals.Animal;
import de.uulm.sp.Zoo.animals.Penguin;
import de.uulm.sp.Zoo.animals.Tiger;

class AnimalDeserializer implements JsonDeserializer<Animal> {

	@Override
	public Animal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		final var jsonObj = json.getAsJsonObject();
		if (jsonObj.has("inTheAir")) {
			//Bird
			return new Gson().fromJson(jsonObj, Penguin.class);
		} else {
			//Mammal
			return new Gson().fromJson(jsonObj, Tiger.class);
		}
	}

}
