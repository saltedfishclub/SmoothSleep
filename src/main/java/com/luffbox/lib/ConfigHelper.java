package com.luffbox.lib;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class ConfigHelper {

	private Plugin plugin;

	public ConfigHelper(Plugin plugin) {
		this.plugin = plugin;
		reload();
	}

	public void reload() {
		plugin.saveDefaultConfig();
		plugin.reloadConfig();
	}

	private Configuration conf() { return plugin.getConfig(); }

	public Configuration getConfig() { return conf(); }
	public Configuration getDefaults() { return conf().getDefaults(); }

	public boolean contains(String path) { return conf().contains(path); }

	public void setToDefault(String path) { set(path, getDefaults().get(path)); }

	public void set(String path, Object value) { conf().set(path, value); }

	public void setSerializable(String path, LuffSerializable value) { conf().set(path, value.serialize()); }

	public int getInt(String path) { return conf().getInt(path, getDefaultInt(path)); }
	public int getDefaultInt(String path) { return getDefaults() == null ? 0 : getDefaults().getInt(path); }

	public boolean getBoolean(String path) { return conf().getBoolean(path, getDefaultBoolean(path)); }
	public boolean getDefaultBoolean(String path) { return getDefaults() != null && getDefaults().getBoolean(path); }

	public String getString(String path) { return conf().getString(path, getDefaultString(path)); }
	public String getDefaultString(String path) { return getDefaults() == null ? "" : getDefaults().getString(path); }

	public double getDouble(String path) { return conf().getDouble(path, getDefaultDouble(path)); }
	public double getDefaultDouble(String path) { return getDefaults() == null ? 0.0 : getDefaults().getDouble(path); }

	public ItemStack getItemStack(String path) { return conf().getItemStack(path, getDefaultItemStack(path)); }
	public ItemStack getDefaultItemStack(String path) { return getDefaults() == null ? new ItemStack(Material.AIR) : getDefaults().getItemStack(path); }

	public ConfigurationSection getConfSection(String path) {
		if (conf().contains(path))
			return conf().getConfigurationSection(path);
		else return getDefaultConfSection(path);
	}
	public ConfigurationSection getDefaultConfSection(String path) {
		if (getDefaults().contains(path))
			return getDefaults().getConfigurationSection(path);
		return new MemoryConfiguration();
	}

	public Sound getSound(String path) {
		String p = getString(path);
		for (Sound sound : Sound.values()) { if (sound.name().equalsIgnoreCase(p)) return sound; }
		return null;
	}

	public Particle getParticle(String path) {
		String p = getString(path);
		for (Particle particle : Particle.values()) { if (particle.name().equalsIgnoreCase(p)) return particle; }
		return null;
	}

}
