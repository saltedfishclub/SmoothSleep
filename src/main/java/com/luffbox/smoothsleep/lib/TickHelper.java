package com.luffbox.smoothsleep.lib;

import org.bukkit.World;

public class TickHelper {

	private World w;
	private ConfigHelper.WorldSettings ws;
	private TickOptions options;
	private int randTickSpeed;

	public TickHelper(World world, ConfigHelper.WorldSettings settings, TickOptions options) {
		if (world == null) { throw new NullPointerException(); }
		this.w = world;
		this.ws = settings;
		this.options = options;
		randTickSpeed = Integer.parseInt(world.getGameRuleValue("randomTickSpeed"));
	}

	public void tick(int ticks) {
		w.setTime(w.getTime() + ticks);
		if (options.weather) { w.setWeatherDuration(w.getWeatherDuration() - ticks); }
		if (options.randomTick) {
			int rts = Math.min(randTickSpeed * ticks, ws.getInt(ConfigHelper.WorldSettingKey.MAX_RAND_TICK));
			w.setGameRuleValue("randomTickSpeed", String.valueOf(rts));
		}
	}

	public void reset() {
		w.setGameRuleValue("randomTickSpeed", String.valueOf(randTickSpeed));
	}

}
