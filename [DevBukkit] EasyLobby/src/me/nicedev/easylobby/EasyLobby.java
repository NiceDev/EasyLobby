package me.nicedev.easylobby;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.nicedev.easylobby.utils.MainUtils;
import me.nicedev.easylobby.utils.configuration.ConfigUtils;

import org.bukkit.plugin.java.JavaPlugin;

public class EasyLobby extends JavaPlugin {

	/* Maps and Lists */
	
	/* Variables */
	
	/* Utilties */
	public ConfigUtils configUtil;
	
	/**
	 * Enable-Method (calling on enable of plugin)
	 */
	public void onEnable() {
		/* Define instance */
		instance = this;
		
		/* Creating Datafolder */
		this.getDataFolder().mkdir();
		
		/* Creating Log-File */
		File logFile = new File(this.getDataFolder(), "errors.log");
		
		if(!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	/**
	 * Disable-Method (calling on disable of plugin)
	 */
	public void onDisable() {
		
	}
	
	/**
	 * Get instance of plugin
	 * @return instance of this plugin
	 */
	public static EasyLobby getInstance() {
		return instance;
	}
	
	/* Instance */
	private static EasyLobby instance;
	
	/**
	 * Log into log-file and console
	 * @param error The error
	 */
	public static void logError(String error) {
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
	    String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
	    int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
	    
	    String info = "(" + className + "." + methodName + "():" + lineNumber + ")";
	    System.err.println("[EasyLobby] Error: " + error + " " + info);
	    
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(new File("plugins/EasyLobby/errors.log")));
	    	
	    	writer.append("[" + MainUtils.getTime() + "] Error: " + error + " " + info);
	    	writer.close();
	    } catch(Exception e) {
	    	System.err.println("[EasyLobby] Error: Can\u00B4t write into log-file! (" + e.getMessage() + ")");
	    }
	}
	
}
