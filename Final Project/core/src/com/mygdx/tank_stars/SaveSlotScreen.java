package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SaveSlotScreen implements Screen {

    final TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    private Skin skin;
    private Stage stage;
    private TextButton slot1;
    private TextButton slot2;
    private TextButton slot3;
    private TextButton backButton;

    OrthographicCamera camera;

    public SaveSlotScreen(final TankStars game) {

        this.game = game;

        backgroundImage = new Texture(Gdx.files.internal("tankstarbg1.png"));
        backgroundTexture = new TextureRegion(backgroundImage);
        skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));

        slot1 = new TextButton("Empty slot", skin);
        slot1.setPosition(660,350);
        slot1.setSize(300,70);

        slot2 = new TextButton("Empty slot", skin);
        slot2.setPosition(660,230);
        slot2.setSize(300,70);

        slot3 = new TextButton("Empty slot", skin);
        slot3.setPosition(660,110);
        slot3.setSize(300,70);

        backButton = new TextButton("<--", skin);
        backButton.setPosition(1480,847);
        backButton.setSize(150,70);
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenu(game));
            }
        });

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(slot1); //Add the button to the stage to perform rendering and take input.
        stage.addActor(slot2);
        stage.addActor(slot3);
        stage.addActor(backButton);
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    public boolean allSlotsEmpty(){
        if(slot1.getText()=="Empty Slot" && slot2.getText()=="Empty Slot" && slot3.getText()=="Empty Slot"){
            return false;
        }
        return true;
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

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui
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
        backgroundImage.dispose();
        skin.dispose();
        stage.dispose();
    }
}
