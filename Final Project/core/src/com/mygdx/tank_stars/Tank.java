//package com.mygdx.tank_stars;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
//import com.badlogic.gdx.math.Circle;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.*;
//
//import java.awt.*;
//import java.awt.geom.RectangularShape;
//import java.util.ArrayList;
//
//public class Tank extends Sprite{
//
//    public World world;
//    public Body b2body;
//
//    double fuel;
//    double maxHP;
//    Weapon w;
//    ArrayList<Integer> weapons;
//    Texture tankImage_l;
//    Texture tankImage_r;
//
//    private TextureRegion tankImage;
//
//    public Tank(World world){
//        this.world = world;
//        defineTank();
//        tankImage = new TextureRegion(new Texture(Gdx.files.internal("spectre_r.png")));
//        setBounds(0,0,0,0);
//        setRegion(tankImage);
//    }
//
//    public Tank(TankStars game, float originX, float originY) {
//    }
//
//    public void update(float dt){
//        setPosition(b2body.getPosition().x-2*getWidth(), b2body.getPosition().y-2*getHeight());
//    }
//
//    public void defineTank(){
//        BodyDef bdef = new BodyDef();
//        bdef.position.set(200/ TankStars.PPM, 200/ TankStars.PPM);
//        bdef.type = BodyDef.BodyType.DynamicBody;
//        b2body = world.createBody(bdef);
//
//        FixtureDef fdef = new FixtureDef();
//        CircleShape shape = new CircleShape();
//        shape.setRadius(35/TankStars.PPM);
//
//        fdef.shape = shape;
//        fdef.density=1;
//        fdef.friction=100;
//        b2body.createFixture(fdef);
//
//    }
//
//    public void attack(String choice){
//
//    }
//
//}
//
////public class Tank extends Sprite implements InputProcessor{
////
////    private Vector2 velocity = new Vector2();
////
////    private float speed = 60 * 2,gravity = 60 * 1.8f;
////
////    private TiledMapTileLayer collisionLayer;
////
////    public Tank(Sprite sprite, TiledMapTileLayer collisionLayer){
////        super(sprite);
////        this.collisionLayer = collisionLayer;
////    }
////    public void draw(SpriteBatch spriteBatch) {
////        update(Gdx.graphics.getDeltaTime());
////        super.draw(spriteBatch);
////    }
////
////    public float getSpeed() {
////        return speed;
////    }
////
////    public void setSpeed(float speed) {
////        this.speed = speed;
////    }
////
////    public float getGravity() {
////        return gravity;
////    }
////
////    public void setGravity(float gravity) {
////        this.gravity = gravity;
////    }
////
////    public TiledMapTileLayer getCollisionLayer() {
////        return collisionLayer;
////    }
////
////    public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
////        this.collisionLayer = collisionLayer;
////    }
////
////    public Vector2 getVelocity() {
////        return velocity;
////    }
////
////    public void setVelocity(Vector2 velocity) {
////        this.velocity = velocity;
////    }
////
////    public void update(float delta) {
////        velocity.y -= gravity * delta;
////
////        if(velocity.y > speed)
////            velocity.y = speed;
////        else if(velocity.y < -speed)
////            velocity.y = -speed;
////
////        float oldX = getX(), oldY = getY(), titleWidth = collisionLayer.getTileHeight(), titleHeight = collisionLayer.getTileHeight();
////        boolean collisionX = false, collisionY = false;
////
////        setX(getX() + velocity.x * delta);
////        if(velocity.x < 0){
////            collisionX = collisionLayer.getCell((int)(getX() / titleWidth), (int)((getY()+getHeight()) / titleHeight))
////                    .getTile().getProperties().containsKey("blocked");
////
////            if(!collisionX)
////                collisionX = collisionLayer.getCell((int)(getX() / titleWidth), (int)((getY()+getHeight() / 2) / titleHeight))
////                    .getTile().getProperties().containsKey("blocked");
////
////            if(!collisionX)
////                collisionX =  collisionLayer.getCell((int)(getX() / titleWidth), (int)(getY() / titleHeight))
////                    .getTile().getProperties().containsKey("blocked");
////        } else if (velocity.x > 0) {
////            collisionX = collisionLayer.getCell((int)((getX() + getWidth()) / titleWidth), (int)((getY()+getHeight()) / titleHeight))
////                    .getTile().getProperties().containsKey("blocked");
////            if(!collisionX)
////                collisionX = collisionLayer.getCell((int)((getX() + getWidth()) / titleWidth), (int)((getY()+getWidth() / 2) / titleHeight))
////                        .getTile().getProperties().containsKey("blocked");
////            if(!collisionX)
////                collisionX = collisionLayer.getCell((int)((getX() + getWidth()) / titleWidth), (int)(getY() / titleHeight))
////                        .getTile().getProperties().containsKey("blocked");
////
////        }
////    }
////    @Override
////    public boolean keyDown(int keycode) {
////        return true;
////    }
////
////    @Override
////    public boolean keyUp(int keycode) {
////        return true;
////    }
////
////    @Override
////    public boolean keyTyped(char character) {
////        return false;
////    }
////
////    @Override
////    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
////        return false;
////    }
////
////    @Override
////    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
////        return false;
////    }
////
////    @Override
////    public boolean touchDragged(int screenX, int screenY, int pointer) {
////        return false;
////    }
////
////    @Override
////    public boolean mouseMoved(int screenX, int screenY) {
////        return false;
////    }
////
////    @Override
////    public boolean scrolled(float amountX, float amountY) {
////        return false;
////    }
////}
package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.particles.values.RectangleSpawnShapeValue;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class Tank extends Sprite{

    public World world;
    public Body b2body;

    double fuel;
    double maxHP;
    Weapon w;
    ArrayList<Integer> weapons;
    Texture tankImage_l;
    Texture tankImage_r;
    private int flag;

    float power;
    float angle;

    private TextureRegion tankImage;
    private String tank_Type;


    public Tank(World world,String tank_Type,int flag){
        this.flag = flag;
        this.world = world;
        this.tank_Type = tank_Type;
        power=0;
        angle=0;
        defineTank();
        tankImage = new TextureRegion(new Texture(Gdx.files.internal(tank_Type)));
        setBounds(0,0,0,0);
        setRegion(tankImage);
    }
    public String gettankType(){
        return tank_Type;
    }

    public Tank(TankStars game, float originX, float originY) {
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x-2*getWidth(), b2body.getPosition().y-2*getHeight());
    }

    public void defineTank(){
        BodyDef bdef = new BodyDef();
        if(flag == 1) {
            bdef.position.set(200 / TankStars.PPM, 200 / TankStars.PPM);
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body = world.createBody(bdef);

            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(34/TankStars.PPM);


            fdef.shape = shape;
            fdef.density=50;
            fdef.friction=5;
            b2body.createFixture(fdef);
        }
        else if (flag == 2){
            bdef.position.set(1400 / TankStars.PPM, 220 / TankStars.PPM);
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body = world.createBody(bdef);

            FixtureDef fdef = new FixtureDef();
            CircleShape shape = new CircleShape();
            shape.setRadius(34/TankStars.PPM);

            fdef.shape = shape;
            fdef.density=50;
            fdef.friction=5;
            b2body.createFixture(fdef);
        }
        else if (flag == 3) {
            bdef.position.set(750 , 800);
            bdef.type = BodyDef.BodyType.DynamicBody;
            b2body = world.createBody(bdef);

            FixtureDef fdef = new FixtureDef();

            PolygonShape shape = new PolygonShape();

            shape.setAsBox(5,5);
            fdef.shape=shape;
            fdef.density = 50;
            fdef.friction = 1000;
            b2body.createFixture(fdef);
        }


    }
    public void attack(String choice){

    }

}