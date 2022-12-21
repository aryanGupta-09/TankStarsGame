//package com.mygdx.tank_stars;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.maps.MapGroupLayer;
//import com.badlogic.gdx.maps.MapObject;
//import com.badlogic.gdx.maps.objects.*;
//import com.badlogic.gdx.maps.tiled.TiledMap;
//import com.badlogic.gdx.maps.tiled.TmxMapLoader;
//import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
//import com.badlogic.gdx.math.*;
//import com.badlogic.gdx.physics.box2d.*;
//import com.badlogic.gdx.utils.viewport.Viewport;
//
//import java.io.*;
//
//public class Weapon implements InputProcessor, Screen, Serializable {
//
//    final TankStars game;
//
//    private Texture tankImage1;
//    private TextureRegion tankImageTexture1;
//
//    private Texture tankImage2;
//    private TextureRegion tankImageTexture2;
//
//    private TmxMapLoader mapLoader;
//    private TiledMap map;
//    private OrthogonalTiledMapRenderer renderer;
//
//    private Viewport gamePort;
//    OrthographicCamera camera;
//
//    private Box2DDebugRenderer b2dr;
//    private World world;
//
//    private Tank player;
//
//    Rectangle tank1;
//    Rectangle tank2;
//    private ShapeRenderer sr;
//    private int maxPower;
//
//    public Weapon(final TankStars game) {
//
//        this.game = game;
//    }
//}

package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.awt.*;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class Weapon extends Sprite{

    public World world;
    public Body b2body;

    double fuel;
    double maxHP;
    float X;
    float Y;
    private TextureRegion WeaponImage;

    public Weapon(World world,float X,float Y){
        this.world = world;
        this.X=X;
        this.Y=Y;
        defineWeapon();
        WeaponImage = new TextureRegion(new Texture(Gdx.files.internal("spectre_r.png")));
        setBounds(0,0,50,35);
        setRegion(WeaponImage);
    }

    public void remove(){
        this.b2body.destroyFixture(this.b2body.getFixtureList().get(0));
        CircleShape shape = new CircleShape();
        shape.setRadius(0);
        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        fdef.density=1;
        this.b2body.createFixture(fdef);
    }


    public void update(float dt){
        setPosition(b2body.getPosition().x-2*getWidth(), b2body.getPosition().y-2*getHeight());
    }

    public void defineWeapon(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(this.X,this.Y+40);
        bdef.type = BodyDef.BodyType.StaticBody;
        b2body = world.createBody(bdef);


        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5/TankStars.PPM);

        fdef.shape = shape;
        fdef.density=1;
        b2body.createFixture(fdef);
    }

    public void attack(String choice){

    }

}
