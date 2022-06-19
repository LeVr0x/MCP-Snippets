package pl.h00p03.client.utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.client.Minecraft;
import pl.h00p03.client.mods.Mod;


public class ModToggle {

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static Minecraft mc = Minecraft.getMinecraft();

	public static File getFolder(Mod mod) {
		File file = mod.getFolder();
		file.mkdirs();
		return file;
	}

	public static void saveEnabled(Mod... mods) throws IOException {
		for(Mod mod : mods) {
			// Opcjonalne
			System.out.println("Saving mod: " + mod.getClass().getSimpleName().split("Mod")[1]);

			File file = new File(new File(mc.mcDataDir, "Hussars Client" + File.separator + File.separator + "Mods" + File.separator + mod.getName()), "enabled.json");
			file.getParentFile().mkdirs();
			file.createNewFile();
			boolean isEnabled = mod.isEnabled;
			FileWriter writer = new FileWriter(file);
			writer.write(gson.toJson(isEnabled));
			writer.close();
		}
	}
	public static void loadEnabled(Mod... mods) throws FileNotFoundException {
		for(Mod mod : mods) {
			// Opcjonalne
			System.out.println("Loading mod: " + mod.getName());

			File file = new File(new File(mc.mcDataDir, "Hussars Client" + File.separator + File.separator + "Mods" + File.separator + mod.getName()), "enabled.json");
			mod.isEnabled = gson.fromJson(new FileReader(file), boolean.class);
		}
	}
	
	public static void saveDoubleToFile(Mod mod, Double b) {
		FileManager.writeJsonToFile(new File(getFolder(mod), "Double.json"), b);
	}
	public static Double loadDoubleFromFile(Mod mod) {
		Double b = FileManager.readFromJson(new File(getFolder(mod), "Double.json"), Double.class);
		
		if (b == null) {
			b = 1.0;
			saveDoubleToFile(mod, b);
		}
		return b;
	}

	// Zapisywanie kosmetykĂłw
/*
	public static void saveCosmetics(CosmeticBase... cosmetics) throws IOException {
		for (CosmeticBase cosmetic : cosmetics) {
			String name = cosmetic.getClass().getSimpleName().replaceFirst("Cosmetic", "");
			File file = new File(Minecraft.getMinecraft().mcDataDir, "Guardly Client"  +File.separator +  "Cosmetics" + File.separator + name + ".json");
			Map<String, Object> cosmeticsMap = new HashMap<>();
			cosmeticsMap.put("name", name);
			cosmeticsMap.put("enabled", cosmetic.isEnabled);

			file.getParentFile().mkdirs();
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(cosmeticsMap));
			writer.close();
		}

	}
	// Ĺ�adowanie kometykĂłw
	public static void loadCosmetics(CosmeticBase... cosmetics) throws IOException {
		for(CosmeticBase cosmetic : cosmetics) {
			// trzeba to kiedys zatapic nazwa w konstruktorze
			String name = cosmetic.getClass().getSimpleName().replaceFirst("Cosmetic", "");

			if(new File(Minecraft.getMinecraft().mcDataDir, "Guardly Client"  +File.separator +  "Cosmetics" + File.separator + name + ".json").exists()){

				FileReader reader = new FileReader(new File(Minecraft.getMinecraft().mcDataDir, "Cosmetics" + File.separator + name + ".json"));
				Gson gson = new Gson();
				Map<String,Object> cosmeticsMap = gson.fromJson(reader, HashMap.class);

				cosmetic.isEnabled = Boolean.parseBoolean(String.valueOf(cosmeticsMap.get("enabled")));
			}


		}
	}
	*/
}