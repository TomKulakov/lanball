package com.lanball;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LanBall implements ApplicationListener {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private Texture playerTexture;
    private Sprite sprite;
    private Sprite player;
    private float playerX;
    private float playerY;
    private Float playerSpeed = 1.0f; // 10 pixels per second.

    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(1, h / w);
        batch = new SpriteBatch();

        Texture.setEnforcePotImages(false);
        texture = new Texture(Gdx.files.internal("data/graphics/field/field.png"));
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        TextureRegion region = new TextureRegion(texture, 0, 0, 1024, 748);
        sprite = new Sprite(region);
        sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(-sprite.getWidth() / 2, -sprite.getHeight() / 2);


        Texture.setEnforcePotImages(false);
        playerTexture = new Texture(Gdx.files.internal("data/graphics/player/mario_pixel.png"));
        playerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        player = new Sprite(playerTexture, 0, 0, 300, 340);
        player.setSize(0.1f, 0.1f * player.getHeight() / player.getWidth());
        player.setOrigin(player.getWidth() / 2, player.getHeight() / 2);
        player.setPosition(-player.getWidth() / 2, -player.getHeight() / 2);
        playerX = 0;
        playerY = 0;


    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
            playerX -= Gdx.graphics.getDeltaTime() * playerSpeed;
        }
        if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
            playerX += Gdx.graphics.getDeltaTime() * playerSpeed;
        }
        if (Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
            playerY += Gdx.graphics.getDeltaTime() * playerSpeed;
        }
        if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
            playerY -= Gdx.graphics.getDeltaTime() * playerSpeed;
        }
        if (Gdx.input.isKeyPressed(Keys.X)) {
            /*            if (player.getColor().equals(Color.CYAN)) {
             player.setColor(Color.WHITE);
             } else {
             }*/
            player.setColor(Color.DARK_GRAY);
        }
        if (Gdx.input.isKeyPressed(Keys.Z)) {
             player.setColor(Color.WHITE);
        }

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        sprite.draw(batch);
        player.setPosition(playerX, playerY);
        player.draw(batch);
        batch.end();
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
}
