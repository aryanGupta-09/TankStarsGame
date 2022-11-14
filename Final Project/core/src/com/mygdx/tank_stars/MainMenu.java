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

    private Texture newButtonImage,exitButtonImage,resumeButtonImage;
    private TextureRegion newButtonTexture,exitButtonTexture,resumeButtonTexture;
    private TextureRegionDrawable newButtonTexRegionDrawable,exitButtonTexRegionDrawable,resumeButtonTexRegionDrawable;
    private ImageButton newGameButton,exitGameButton,resumeGameButton;

    OrthographicCamera camera;
    private Stage stage;

    public MainMenu(final TankStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("tankstarbg1.png"));
        backgroundTexture = new TextureRegion(backgroundImage);

        newButtonImage = new Texture(Gdx.files.internal("newgameimg.png"));
        newButtonTexture = new TextureRegion(newButtonImage);
        newButtonTexRegionDrawable = new TextureRegionDrawable(newButtonTexture);

        exitButtonImage = new Texture(Gdx.files.internal("exitgameimg.png"));
        exitButtonTexture = new TextureRegion(exitButtonImage);
        exitButtonTexRegionDrawable = new TextureRegionDrawable(exitButtonTexture);

        resumeButtonImage = new Texture(Gdx.files.internal("resumegameimg.png"));
        resumeButtonTexture = new TextureRegion(resumeButtonImage);
        resumeButtonTexRegionDrawable = new TextureRegionDrawable(resumeButtonTexture);

        newGameButton = new ImageButton(newButtonTexRegionDrawable); //Set the button up
        newGameButton.setPosition(700,340);
        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(newGameButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });

        resumeGameButton = new ImageButton(resumeButtonTexRegionDrawable); //Set the button up
        resumeGameButton.setPosition(700,240);
        resumeGameButton.setSize(213,42);
        stage.addActor(resumeGameButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
        resumeGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                dispose();
            }
        });

        exitGameButton = new ImageButton(exitButtonTexRegionDrawable); //Set the button up
        exitGameButton.setPosition(700,140);
        exitGameButton.setSize(213,42);
        stage.addActor(exitGameButton); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);
        exitGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
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

    }

}
