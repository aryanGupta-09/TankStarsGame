package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SaveSlotScreen implements Screen {

    final TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    private TextButton slot1;
    private TextButton slot2;
    private TextButton slot3;

    OrthographicCamera camera;
    private Stage stage;

    public SaveSlotScreen(TankStars game) {

        this.game = game;

//        skin = new Skin();
//        skin.add("logo",new TextureAtlas("logo.png"));
//        backgroundImage = skin.get("logo",Texture.class);
//        backgroundTexture = skin.getRegion("logo");

        backgroundImage = new Texture(Gdx.files.internal("tankstarbg1.png"));
        backgroundTexture = new TextureRegion(backgroundImage);
        Skin skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));
        slot1 = new TextButton("Empty slot", skin);
        slot2 = new TextButton("Empty slot", skin);
        slot3 = new TextButton("Empty slot", skin);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(slot1); //Add the button to the stage to perform rendering and take input.
        stage.addActor(slot2);
        stage.addActor(slot3);
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
