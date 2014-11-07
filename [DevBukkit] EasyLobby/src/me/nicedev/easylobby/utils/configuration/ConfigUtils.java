package me.nicedev.easylobby.utils.configuration;

import java.io.File;
import java.io.IOException;

import me.nicedev.easylobby.EasyLobby;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigUtils {
	
	private File configFile;
	private FileConfiguration config;
	
	/**
	 * Loads the config
	 */
	public ConfigUtils() {
		loadConfig();
	}
	
	/**
	 * Loads the config
	 */
	private void loadConfig() {
		if(!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch(IOException e) {
				EasyLobby.logError(e.getMessage());
			}
		}
		
	}
	
	public void saveConfig() {
		try {
			config.save(configFile);
		} catch (IOException e) {
			EasyLobby.logError(e.getMessage());
		}
	}
	
	public FileConfiguration getConfig() {
		return config;
	}

}
