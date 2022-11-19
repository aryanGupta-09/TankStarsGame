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

public class WeaponScreen implements Screen {

    final TankStars game;
    private Texture selectTank;
    private Texture selectedTank;
    private TextButton infoOne;
    private TextButton infoTwo;
    private TextButton infoOneDesc;
    private TextButton infoTwoDesc;
    private Texture tankImage;
    private Texture weaponOne;
    private  Texture weaponTwo;
    private Stage stage;
    private TextButton backButton;
    private SpriteBatch batch;
    OrthographicCamera camera;
    CharSequence str = "Hello World!";
    BitmapFont font = new BitmapFont();
    WeaponScreen(final TankStars game,String tankname){

        this.game = game;

        selectTank = new Texture(Gdx.files.internal("tankselect_bg.png"));
        selectedTank = new Texture(Gdx.files.internal("selected_bg.png"));
        Skin skin = new Skin(Gdx.files.internal("quantum-horizon-ui.json"));


        batch = new SpriteBatch();

        if (tankname.equals("toxic")){

            tankImage = new Texture(Gdx.files.internal("toxic_r.png"));
            weaponOne = new Texture(Gdx.files.internal("acidStream.png"));
            weaponTwo = new Texture(Gdx.files.internal("toxicBlast.png"));
            infoOne = new TextButton("Acid Stream\n\nToxic blast is\nweapon that shoots\na toxic missile", skin);
            infoOne.setPosition(1150,470);
            infoOne.setSize(300,150);

            infoTwo = new TextButton("Toxic Blast", skin);
            infoTwo.setPosition(1130,300);
            infoTwo.setSize(289,58);



        }

        backButton = new TextButton("<--", skin);
        backButton.setPosition(1480,847);
        backButton.setSize(150,70);
        backButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new TankSelectionScreen(game));
            }
        });

        infoOne.setColor(Color.YELLOW);
        stage = new Stage(new ScreenViewport());
        stage.addActor(backButton);
        stage.addActor(infoOne);
        stage.addActor(infoTwo);
        Gdx.input.setInputProcessor(stage);

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

        batch.begin();
        batch.draw(selectTank, 950, 0, 700, 900);
        batch.draw(selectedTank, 0, 0, 950, 900);
        batch.draw(tankImage,290,150,450,250);


        batch.draw(weaponOne,1010,500,140,100);
        batch.draw(weaponTwo,1210,200,140,100);
        batch.end();

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
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

    }
}
