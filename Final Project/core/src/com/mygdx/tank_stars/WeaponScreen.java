//package com.mygdx.tank_stars;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//
//import javax.swing.text.View;
//import java.io.*;
//import java.util.ArrayList;
//
//public class WeaponScreen implements Screen, Serializable {
//
//    final TankStars game;
//    private Texture selectTank;
//    private Texture selectedTank;
//    private Texture tankImage;
//    private Texture weaponOne;
//    private  Texture weaponTwo;
//    private TextButton infoOne;
//    private TextButton infoTwo;
//    private TextButton backButton;
//    private Stage stage;
//    private SpriteBatch batch;
//    OrthographicCamera camera;
//    private ArrayList<String> playerTank;
//
//    WeaponScreen(final TankStars game, final String tankname, final String playerText, final ArrayList<String> playerTank){
//
//        this.game = game;
//
//        selectTank = new Texture(Gdx.files.internal("tankselect_bg.png"));
//        selectedTank = new Texture(Gdx.files.internal("selected_bg.png"));
//        Skin skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));
//
//        batch = new SpriteBatch();
//
//        if(tankname.equals("Toxic")){
//
//            tankImage = new Texture(Gdx.files.internal("toxic_r.png"));
//            weaponOne = new Texture(Gdx.files.internal("acidStream.png"));
//            weaponTwo = new Texture(Gdx.files.internal("toxicBlast.png"));
//
//            infoOne = new TextButton("Acid Stream\n\nAcid stream is\na weapon that shoots\nfour acid shot\nat the tank", skin);
//            infoTwo = new TextButton("Toxic Blast\n\nToxic blast is\nweapon that shoots\na toxic missile", skin);
//
//        } else if (tankname.equals("Spectre")) {
//
//            tankImage = new Texture(Gdx.files.internal("spectre_r.png"));
//            weaponOne = new Texture(Gdx.files.internal("lightningball.png"));
//            weaponTwo = new Texture(Gdx.files.internal("railgun.png"));
//
//            infoOne = new TextButton("Lightning Ball\n\nWhen shot on the ground,\nit would travel a\nshort distance and\nexplode", skin);
//            infoTwo = new TextButton("Railgun\n\nis an electric weapon\nused by Spectre,\nunaffected by gravity", skin);
//
//        } else if (tankname.equals("Helios")) {
//
//            tankImage = new Texture(Gdx.files.internal("helios_r.png"));
//            weaponOne = new Texture(Gdx.files.internal("napalm.png"));
//            weaponTwo = new Texture(Gdx.files.internal("hyperblast.png"));
//
//            infoOne = new TextButton("Napalm\n\nOn shooting\nit will have about\n5 to 15 balls of fire\nand causes area damage", skin);
//            infoTwo = new TextButton("Hyper Blast\n\na Long-range weapon that\nupon hitting the ground,\ncreates a sphere of\nfire and explodes.", skin);
//
//        }
//
//        backButton = new TextButton("<--", skin);
//        backButton.setPosition(1480,847);
//        backButton.setSize(150,70);
//        backButton.addListener(new ClickListener(){
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//
//                game.setScreen(new TankSelectionScreen(game,tankname,playerText,playerTank));
//            }
//        });
//
//
//        infoOne.setPosition(1180,460);
//        infoOne.setSize(380,170);
//        infoOne.setColor(Color.YELLOW);
//
//        infoTwo.setColor(Color.YELLOW);
//        infoTwo.setPosition(1180,160);
//        infoTwo.setSize(380,170);
//
//        stage = new Stage(new ScreenViewport());
//        stage.addActor(backButton);
//        stage.addActor(infoOne);
//        stage.addActor(infoTwo);
//        Gdx.input.setInputProcessor(stage);
//
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 800, 480);
//
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
//        batch.begin();
//        batch.draw(selectTank, 950, 0, 700, 900);
//        batch.draw(selectedTank, 0, 0, 950, 900);
//        batch.draw(tankImage,290,150,450,250);
//        batch.draw(weaponOne,1040,500,140,100);
//        batch.draw(weaponTwo,1040,200,140,100);
//        batch.end();
//
//        stage.act(Gdx.graphics.getDeltaTime());
//        stage.draw();
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
//        tankImage.dispose();
//        weaponOne.dispose();
//        weaponTwo.dispose();
//        selectedTank.dispose();
//        selectTank.dispose();
//        stage.dispose();
//        batch.dispose();
//    }
//}
package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.text.View;
import java.io.*;

public class WeaponScreen implements Screen, Serializable {

    final TankStars game;
    private Texture selectTank;
    private Texture selectedTank;
    private Texture tankImage;
    private Texture weaponOne;
    private  Texture weaponTwo;
    private TextButton infoOne;
    private TextButton infoTwo;
    private TextButton backButton;
    private Stage stage;
    private SpriteBatch batch;
    OrthographicCamera camera;

    WeaponScreen(final TankStars game, final String tankname,final String playerText, final String p1, final String p2){

        this.game = game;

        selectTank = new Texture(Gdx.files.internal("tankselect_bg.png"));
        selectedTank = new Texture(Gdx.files.internal("selected_bg.png"));
        Skin skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));

        batch = new SpriteBatch();

        if(tankname.equals("Toxic")){

            tankImage = new Texture(Gdx.files.internal("toxic_r.png"));
            weaponOne = new Texture(Gdx.files.internal("acidStream.png"));
            weaponTwo = new Texture(Gdx.files.internal("toxicBlast.png"));

            infoOne = new TextButton("Acid Stream\n\nAcid stream is\na weapon that shoots\nfour acid shot\nat the tank", skin);
            infoTwo = new TextButton("Toxic Blast\n\nToxic blast is\nweapon that shoots\na toxic missile", skin);

        } else if (tankname.equals("Spectre")) {

            tankImage = new Texture(Gdx.files.internal("spectre_r.png"));
            weaponOne = new Texture(Gdx.files.internal("lightningball.png"));
            weaponTwo = new Texture(Gdx.files.internal("railgun.png"));

            infoOne = new TextButton("Lightning Ball\n\nWhen shot on the ground,\nit would travel a\nshort distance and\nexplode", skin);
            infoTwo = new TextButton("Railgun\n\nis an electric weapon\nused by Spectre,\nunaffected by gravity", skin);

        } else if (tankname.equals("Helios")) {

            tankImage = new Texture(Gdx.files.internal("helios_r.png"));
            weaponOne = new Texture(Gdx.files.internal("napalm.png"));
            weaponTwo = new Texture(Gdx.files.internal("hyperblast.png"));

            infoOne = new TextButton("Napalm\n\nOn shooting\nit will have about\n5 to 15 balls of fire\nand causes area damage", skin);
            infoTwo = new TextButton("Hyper Blast\n\na Long-range weapon that\nupon hitting the ground,\ncreates a sphere of\nfire and explodes.", skin);

        }

        backButton = new TextButton("<--", skin);
        backButton.setPosition(1480,847);
        backButton.setSize(150,70);
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new TankSelectionScreen(game,tankname,playerText,p1,p2));
            }
        });


        infoOne.setPosition(1180,460);
        infoOne.setSize(380,170);
        infoOne.setColor(Color.YELLOW);

        infoTwo.setColor(Color.YELLOW);
        infoTwo.setPosition(1180,160);
        infoTwo.setSize(380,170);

        stage = new Stage(new ScreenViewport());
        stage.addActor(backButton);
        stage.addActor(infoOne);
        stage.addActor(infoTwo);
        Gdx.input.setInputProcessor(stage);

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

        batch.begin();
        batch.draw(selectTank, 950, 0, 700, 900);
        batch.draw(selectedTank, 0, 0, 950, 900);
        batch.draw(tankImage,290,150,450,250);
        batch.draw(weaponOne,1040,500,140,100);
        batch.draw(weaponTwo,1040,200,140,100);
        batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
        tankImage.dispose();
        weaponOne.dispose();
        weaponTwo.dispose();
        selectedTank.dispose();
        selectTank.dispose();
        stage.dispose();
        batch.dispose();
    }
}
