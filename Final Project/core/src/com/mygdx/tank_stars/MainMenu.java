package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenu implements Screen {

    final TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    private Texture buttonImage;
    private TextureRegion buttonTexture;
    private TextureRegionDrawable buttonTexRegionDrawable;
    private ImageButton button;

    OrthographicCamera camera;
    private Stage stage;

    public MainMenu(final TankStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("background.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage);
        buttonImage = new Texture(Gdx.files.internal("atomic_l.png"));
        buttonTexture = new TextureRegion(buttonImage);
        buttonTexRegionDrawable = new TextureRegionDrawable(buttonTexture);
        button = new ImageButton(buttonTexRegionDrawable); //Set the button up
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }
    public void create(){

    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
//        game.font.draw(game.batch, "Welcome to TankStars!", 300, 460);
//        game.font.draw(game.batch, "New game!", 300, 440);
//        game.font.draw(game.batch, "Resume game!", 300, 340);
//        game.font.draw(game.batch, "Exit game!", 300, 240);
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw(); //Draw the ui

//        if (Gdx.input.isTouched()) {
//            game.setScreen(new GameScreen(game));
//            dispose();
//        }
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
