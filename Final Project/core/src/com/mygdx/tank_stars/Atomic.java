package com.mygdx.tank_stars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class Atomic extends Tank {

    Atomic(){
        tankImage_l = new Texture(Gdx.files.internal("atomic_l.png"));
        tankImage_r = new Texture(Gdx.files.internal("atomic_r.png"));
        weapons = new ArrayList<>(2);
    }

}
