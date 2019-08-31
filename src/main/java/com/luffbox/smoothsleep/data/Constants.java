package com.luffbox.smoothsleep.data;

import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {

	public static final long NIGHT_START = 12541L;
	public static final long NIGHT_END = 23460L;
	public static final long NIGHT_DURA = NIGHT_END - NIGHT_START;
	public static final long TICKS_PER_DAY = 1728000L;
	public static final long TICKS_PER_HOUR = 72000L;
	public static final long TICKS_PER_MIN = 1200L;

	public static final Map<String, GlobalConfigKey> movedGlobalSettings = new LinkedHashMap<String, GlobalConfigKey>() {{
		put("enable-data-share", null);
	}};

	public static final Map<String, WorldConfigKey> movedWorldSettings = new LinkedHashMap<String, WorldConfigKey>() {{
		put("morning-particle-options", null);
		put("min-night-speed-mult", WorldConfigKey.MIN_NIGHT_SPEED);
		put("max-night-speed-mult", WorldConfigKey.MAX_NIGHT_SPEED);
		put("night-speed-curve", WorldConfigKey.SPEED_CURVE);
		put("instant-day-if-all-sleeping", WorldConfigKey.INSTANT_DAY_ENABLED);
		put("accelerate-random-tick", WorldConfigKey.TICK_RAND_TICK);
		put("max-random-tick", WorldConfigKey.RAND_TICK_MAX);
		put("accelerate-weather", WorldConfigKey.TICK_WEATHER);
		put("clear-weather-when-morning", WorldConfigKey.CLEAR_WEATHER);
		put("heal-slept-villagers", WorldConfigKey.HEAL_VILLAGERS);
	}};

}
