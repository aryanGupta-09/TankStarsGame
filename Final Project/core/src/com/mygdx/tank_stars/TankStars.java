package com.mygdx.tank_stars;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class TankStars extends Game {
	SpriteBatch batch;
	Texture img;

	BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new MainMenu(this));
	}

	public void render() {
		super.render(); // important!
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}
