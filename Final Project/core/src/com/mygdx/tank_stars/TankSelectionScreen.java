
package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.*;

public class TankSelectionScreen implements Screen, Serializable {

    final TankStars game;

    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    private SpriteBatch batch;
    private Texture selectTank;
    private Texture selectedTank;
    private Texture tankImage;

    private Stage stage;
    private Skin skin;
    private ImageButton spectre_icon;
    private ImageButton helios_icon;
    private ImageButton toxic_icon;
    private TextButton playerNumber;
    private TextButton weaponButton;
    private TextButton startGameButton;
    private TextButton backButton;
    private boolean unselected;
    OrthographicCamera camera;

    TankSelectionScreen(final TankStars game, final String TankType, final String playerText,final String player1, final String player2){

        this.game = game;
        final String firstplayer;
        firstplayer="";
        String secondplayer;
        secondplayer="";
        backgroundImage = new Texture(Gdx.files.internal("tankstarbg1.png"));
        backgroundTexture = new TextureRegion(backgroundImage);
        skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));

        batch = new SpriteBatch();
        selectTank = new Texture(Gdx.files.internal("tankselect_bg.png"));
        selectedTank = new Texture(Gdx.files.internal("selected_bg.png"));

        spectre_icon = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("spectre_select.png")))));
        spectre_icon.setSize(500,500);
        spectre_icon.setPosition(1030,490);
        spectre_icon.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(playerText.equals("Player1")) {
                    game.setScreen(new TankSelectionScreen(game, "Spectre", playerText,"spectre_r.png",""));
                }
                else if (playerText.equals("Player2")){
                    game.setScreen(new TankSelectionScreen(game, "Spectre", playerText,player1,"spectre_l.png"));
                }
            }
        });

        helios_icon = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("helios_select.png")))));
        helios_icon.setSize(500,500);
        helios_icon.setPosition(1030,260);
        helios_icon.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(playerText.equals("Player1")) {
                    game.setScreen(new TankSelectionScreen(game, "Helios", playerText,"helios_r.png",""));
                }
                else if (playerText.equals("Player2")){
                    game.setScreen(new TankSelectionScreen(game, "Helios", playerText,player1,"helios_l.png"));
                }
            }
        });

        toxic_icon = new ImageButton(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("toxic_select.png")))));
        toxic_icon.setSize(500,500);
        toxic_icon.setPosition(1030,30);
        toxic_icon.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(playerText.equals("Player1")) {
                    game.setScreen(new TankSelectionScreen(game, "Toxic", playerText,"toxic_r.png",""));
                }
                else if (playerText.equals("Player2")){
                    game.setScreen(new TankSelectionScreen(game, "Toxic", playerText,player1,"toxic_l.png"));
                }

            }
        });

        unselected = false;
        if(TankType.equals("Spectre")){
            tankImage = new Texture(Gdx.files.internal("spectre_r.png"));
        } else if (TankType.equals("Helios")) {
            tankImage = new Texture(Gdx.files.internal("helios_r.png"));
        } else if (TankType.equals("Toxic")) {
            tankImage = new Texture(Gdx.files.internal("toxic_r.png"));
        }else {
            tankImage = new Texture(Gdx.files.internal("blackTank_r.png"));
            unselected = true;
        }

        weaponButton = new TextButton("WEAPONS", skin);
        weaponButton.setSize(289,58);
        weaponButton.setPosition(640,25);
        weaponButton.setColor(Color.YELLOW);
        weaponButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(TankType.equals("Spectre")){
                    game.setScreen(new WeaponScreen(game, "Spectre",playerText,player1,player2));
                }else if(TankType.equals("Helios")){
                    game.setScreen(new WeaponScreen(game, "Helios",playerText,player1,player2));
                }else if(TankType.equals("Toxic")){
                    game.setScreen(new WeaponScreen(game, "Toxic",playerText,player1,player2));
                }
            }
        });

        playerNumber = new TextButton(playerText, skin);
        playerNumber.setPosition(500,750);
        playerNumber.setSize(300,70);

        startGameButton = new TextButton("READY!", skin);
        startGameButton.setSize(400,100);
        startGameButton.setPosition(1080,50);
        startGameButton.setColor(Color.YELLOW);
        startGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(playerText.equals("Player1") && !unselected){
                    game.setScreen(new TankSelectionScreen(game, "","Player2",player1,player2));
                } else if (playerText.equals("Player2") && !unselected) {
                    game.setScreen(new GameScreen(game,player1,player2));
                }
            }
        });

        backButton = new TextButton("<--", skin);
        backButton.setPosition(1480,847);
        backButton.setSize(150,70);
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(playerText.equals("Player1")){
                    game.setScreen(new MainMenu(game));
                } else if (playerText.equals("Player2")) {
                    game.setScreen(new TankSelectionScreen(game,"","Player1","",""));
                }
            }
        });

        stage = new Stage(new ScreenViewport());
        stage.addActor(spectre_icon);
        stage.addActor(helios_icon);
        stage.addActor(toxic_icon);
        stage.addActor(weaponButton);
        stage.addActor(startGameButton);
        stage.addActor(backButton);
        stage.addActor(playerNumber);
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

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.end();

        batch.begin();

        batch.draw(selectTank, 950, 0, 700, 900);
        batch.draw(selectedTank, 0, 0, 950, 900);
        batch.draw(tankImage,290,150,450,250);

        batch.end();

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
        selectTank.dispose();
        selectedTank.dispose();
        stage.dispose();
        skin.dispose();
        batch.dispose();
        tankImage.dispose();
    }
}