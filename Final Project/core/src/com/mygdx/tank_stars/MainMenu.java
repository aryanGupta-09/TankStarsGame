//package com.mygdx.tank_stars;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.Array;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class MainMenu implements Screen, Serializable {
//
//    final TankStars game;
//    private Texture backgroundImage;
//    private TextureRegion backgroundTexture;
//
//    private Skin skin;
//    private TextButton newGameButton;
//    private TextButton resumeGameButton;
//    private TextButton exitGameButton;
//
//    OrthographicCamera camera;
//    private Stage stage;
////    private String str[];
//    private ArrayList<String> str;
//
//    public MainMenu(final TankStars game) {
//
//        this.game = game;
//
//        str.add("");
//        str.add("");
//        backgroundImage = new Texture(Gdx.files.internal("tankstarbg1.png"));
//        backgroundTexture = new TextureRegion(backgroundImage);
//        skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));
//
//        newGameButton = new TextButton("NEW GAME", skin);
//        newGameButton.setPosition(660,340);
//        newGameButton.setSize(289,58);
//        newGameButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                game.setScreen(new TankSelectionScreen(game,"","Player1",str));
//                dispose();
//            }
//        });
//
//        resumeGameButton = new TextButton("RESUME GAME", skin);
//        resumeGameButton.setPosition(660,240);
//        resumeGameButton.setSize(289,58);
//        resumeGameButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                game.setScreen(new SaveSlotScreen(game));
//                dispose();
//            }
//        });
//
//        exitGameButton = new TextButton("EXIT GAME", skin);
//        exitGameButton.setPosition(660,140);
//        exitGameButton.setSize(289,58);
//        exitGameButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                Gdx.app.exit();
//                dispose();
//            }
//        });
//
//        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
//        stage.addActor(newGameButton); //Add the button to the stage to perform rendering and take input.
//        stage.addActor(resumeGameButton);
//        stage.addActor(exitGameButton);
//        Gdx.input.setInputProcessor(stage); //Start taking input from the ui
//
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 800, 480);
//    }
//
//    public void serialize() throws IOException {
//
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream (new FileOutputStream("out.txt"));
//            out.writeObject(this);
//        } finally {
//            out.close();
//        }
//    }
//
//    public void deserialize() throws IOException, ClassNotFoundException {
//        ObjectInputStream in = null;
//        try {
//            in = new ObjectInputStream (new FileInputStream("out.txt"));
//        } finally {
//            in.close();
//        }
//    }
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0, 0);
//
//        camera.update();
//        game.batch.setProjectionMatrix(camera.combined);
//
//        game.batch.begin();
//        game.batch.draw(backgroundTexture, 0,0, 800, 480);
//        game.batch.end();
//
//        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
//        stage.draw(); //Draw the ui
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        backgroundImage.dispose();
//        stage.dispose();
//        skin.dispose();
//    }
//}
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

import java.io.*;

public class MainMenu implements Screen, Serializable {

    final TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    private Skin skin;
    private TextButton newGameButton;
    private TextButton resumeGameButton;
    private TextButton exitGameButton;

    OrthographicCamera camera;
    private Stage stage;

    public MainMenu(final TankStars game) {

        this.game = game;

        backgroundImage = new Texture(Gdx.files.internal("tankstarbg1.png"));
        backgroundTexture = new TextureRegion(backgroundImage);
        skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));

        newGameButton = new TextButton("NEW GAME", skin);
        newGameButton.setPosition(660,340);
        newGameButton.setSize(289,58);
        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new TankSelectionScreen(game,"","Player1","",""));
                dispose();
            }
        });

        resumeGameButton = new TextButton("RESUME GAME", skin);
        resumeGameButton.setPosition(660,240);
        resumeGameButton.setSize(289,58);
        resumeGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new SaveSlotScreen(game));
                dispose();
            }
        });

        exitGameButton = new TextButton("EXIT GAME", skin);
        exitGameButton.setPosition(660,140);
        exitGameButton.setSize(289,58);
        exitGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                dispose();
            }
        });

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(newGameButton); //Add the button to the stage to perform rendering and take input.
        stage.addActor(resumeGameButton);
        stage.addActor(exitGameButton);
        Gdx.input.setInputProcessor(stage); //Start taking input from the ui

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

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
        stage.dispose();
        skin.dispose();
    }
}
