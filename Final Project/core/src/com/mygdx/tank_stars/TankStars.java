package com.mygdx.tank_stars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class TankStars extends Game {
	public SpriteBatch batch;
	Texture img;
	BitmapFont font;

	FitViewport viewport;
	OrthographicCamera camera;
	ShapeRenderer shape;

	public void create () {
		batch = new SpriteBatch();
		img = new Texture("tankstarbg1.png");
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new WeaponScreen(this,"toxic"));
	}

	public void render() {
		shape = new ShapeRenderer();
		camera = new OrthographicCamera();
		viewport = new FitViewport(800, 480, camera);
		super.render(); // important!
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}
