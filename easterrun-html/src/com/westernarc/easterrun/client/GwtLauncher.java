package com.westernarc.easterrun.client;

import com.westernarc.easterrun.EasterRun;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class GwtLauncher extends GwtApplication {
	@Override
	public GwtApplicationConfiguration getConfig () {
		GwtApplicationConfiguration cfg = new GwtApplicationConfiguration(480, 800);
		return cfg;
	}

	@Override
	public ApplicationListener getApplicationListener () {
		return new EasterRun();
	}
}