package com.sesu8642.feudaltactics;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sesu8642.feudaltactics.engine.PreferencesHelper;
import com.sesu8642.feudaltactics.screens.IngameScreen;
import com.sesu8642.feudaltactics.screens.SplashScreen;

public class FeudalTactics extends Game {

	static public Skin skin;
	static public TextureAtlas textureAtlas;
	static public FeudalTactics game;

	@Override
	public void create() {
		game = this;
		textureAtlas = new TextureAtlas(Gdx.files.internal("textures.atlas"));
		skin = new Skin(Gdx.files.internal("skin/pixthulhu-ui.json"));
		if (PreferencesHelper.getNoOfAutoSaves() > 0) {
			setScreen(new IngameScreen(true));
		} else {
			setScreen(new SplashScreen());
		}
		// do not close on android back key
		Gdx.input.setCatchKey(Keys.BACK, true);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void dispose() {
		skin.dispose();
		super.dispose();
		textureAtlas.dispose();
	}

}