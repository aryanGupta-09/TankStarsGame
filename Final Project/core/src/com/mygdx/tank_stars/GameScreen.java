package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapGroupLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.*;
import java.util.ArrayList;

public class GameScreen implements InputProcessor, Screen, Serializable {

    final TankStars game;
    private Texture tankImage1;
    private TextureRegion tankImageTexture1;
    private Texture tankImage2;
    private Texture dropImage;
    private TextureRegion tankImageTexture2;
    private TextureRegion dropImageTexture;
    private Music gameMusic;
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private Viewport gamePort;
    OrthographicCamera camera;
    private Box2DDebugRenderer b2dr;
    private World world;
    private Tank player1;
    private Tank player2;
    private Tank drop;
    private Weapon weapon;
    Vector2 velocity;

    Rectangle tank1;
    Rectangle tank2;
    private Skin skin;
    private Stage stage;
    private TextButton sureButton;
    Sprite sprite;

    public GameScreen(final TankStars game, final String playerTank1,final String playerTank2) {

        this.game = game;
        tankImage1 = new Texture(Gdx.files.internal(playerTank1));
        tankImageTexture1 = new TextureRegion(tankImage1);
        tankImage2 = new Texture(Gdx.files.internal(playerTank2));
        tankImageTexture2 = new TextureRegion(tankImage2);
        dropImage = new Texture(Gdx.files.internal("drops.png"));
        dropImageTexture = new TextureRegion(dropImage);



        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("game_map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        world = new World(new Vector2(0,-150),true);
        b2dr = new Box2DDebugRenderer();

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for(MapObject object : map.getLayers().get("Ground").getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2)/TankStars.PPM, (rect.getY() + rect.getHeight() / 2)/TankStars.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 /TankStars.PPM, rect.getHeight() / 2 / TankStars.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }
        player1 = new Tank(world,playerTank1,1);
        player2 = new Tank(world,playerTank2,2);
        drop = new Tank(world,"projectile.png",3);

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

    boolean flag=true;
    boolean p1=true;

    public void handleInput(float dt){

        Gdx.input.setInputProcessor(this);

        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            if(p1)
                player1.b2body.applyLinearImpulse(new Vector2(-300000f, 0), player1.b2body.getWorldCenter(), true);
            else
                player2.b2body.applyLinearImpulse(new Vector2(-300000f, 0), player2.b2body.getWorldCenter(), true);
        }
        else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            if(p1)
                player1.b2body.applyLinearImpulse(new Vector2(300000f, 0), player1.b2body.getWorldCenter(), true);
            else
                player2.b2body.applyLinearImpulse(new Vector2(300000f, 0), player2.b2body.getWorldCenter(), true);
        }

        if(Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
            game.setScreen(new PauseMenuScreen(game,player1.gettankType(),player2.gettankType()));// your actions
            dispose();
        }

        if(Gdx.input.isKeyJustPressed(Keys.ENTER)){
            if(p1) {
                if (flag) {
                    weapon = new Weapon(world, player1.getX(), player1.getY());
                    weapon.b2body.setFixedRotation(true);
                } else {
                    world.destroyBody(weapon.b2body);
                }
                flag = !flag;
            }else{
                if (flag) {
                    weapon = new Weapon(world, player2.getX(), player2.getY());
                    weapon.b2body.setFixedRotation(true);
                } else {
                    world.destroyBody(weapon.b2body);
                }
                flag = !flag;
            }
        }
        if(Gdx.input.isKeyPressed(Keys.W)){
            if(p1)
                player1.angle+=0.1;
            else
                player2.angle+=0.1;
        }
        if(Gdx.input.isKeyPressed(Keys.S)){
            if(p1)
                player1.angle-=0.1;
            else
                player2.angle-=0.1;
        }
        if(Gdx.input.isKeyPressed(Keys.A)){
            if(p1)
                player1.power-=1000000;
            else
                player2.power-=1000000;
        }
        if(Gdx.input.isKeyPressed(Keys.D)){
            if(p1)
                player1.power+=1000000;
            else
                player2.power+=1000000;
        }
        if(Gdx.input.isKeyPressed(Keys.SPACE)){
            if(p1) {
                float vx = (float) (300000000f * player1.power * Math.cos(player1.angle));
                float vy = (float) (300000000f * player1.power * Math.sin(player1.angle));
                weapon.b2body.setType(BodyDef.BodyType.DynamicBody);
                weapon.b2body.applyLinearImpulse(new Vector2(vx, vy), new Vector2(17, 17), true);
            }else{
                float vx = (float) (300000000f * player2.power * Math.cos(player2.angle));
                float vy = (float) (300000000f * player2.power * Math.sin(player2.angle));
                weapon.b2body.setType(BodyDef.BodyType.DynamicBody);
                weapon.b2body.applyLinearImpulse(new Vector2(vx, vy), new Vector2(17, 17), true);
            }
            p1=!p1;
        }
    }


    public void update(float dt){
        handleInput(dt);

        world.step(1/60f, 6, 2);

        player1.update(dt);
        player2.update(dt);
        camera.update();
        renderer.setView(camera);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        b2dr.render(world, camera.combined);
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        player1.draw(game.batch);
        player2.draw(game.batch);
        game.batch.draw(tankImage1, player1.b2body.getPosition().x-30, player1.b2body.getPosition().y-30, 80, 57);
        game.batch.draw(tankImage2, player2.b2body.getPosition().x-30, player2.b2body.getPosition().y-30, 80, 57);
        if(weapon!=null)
            game.batch.draw(new Texture(Gdx.files.internal("zatch.png")), weapon.b2body.getPosition().x, weapon.b2body.getPosition().y, 20, 20);
        game.batch.draw(dropImage,drop.b2body.getPosition().x,drop.b2body.getPosition().y,30,30);

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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

