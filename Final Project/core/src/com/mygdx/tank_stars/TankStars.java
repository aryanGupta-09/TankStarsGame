package com.mygdx.tank_stars;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.io.*;

public class TankStars extends Game implements Serializable {
	public SpriteBatch batch;
	Texture img;
	BitmapFont font;

	FitViewport viewport;
	OrthographicCamera camera;
	ShapeRenderer shape;

	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 480;
	public static final float PPM=1;

	public void serialize() throws IOException {

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream (new FileOutputStream("out.txt"));
			out.writeObject(this);
		} finally {
			out.close();
		}
	}

	public void deserialize() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (new FileInputStream("out.txt"));
		} finally {
			in.close();
		}
	}

	public void create () {
		batch = new SpriteBatch();
		img = new Texture("tankstarbg1.png");
		font = new BitmapFont(); // use libGDX's default Arial font
		this.setScreen(new MainMenu(this));
	}

	public void render() {
		shape = new ShapeRenderer();
		camera = new OrthographicCamera();
		viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);
		super.render(); // important!
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
	}
}
