package com.misterpops.towerknight.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.misterpops.towerknight.TowerKnight;

public class MainMenu implements Screen{
	
	TowerKnight game;
	Stage stage;
	BitmapFont whiteFont;
	TextureAtlas buttonAtlas;
	Skin skin;
	SpriteBatch batch;
	TextButton button;
	
	public MainMenu(TowerKnight game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		batch.begin();
		stage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		if(stage == null) {
			stage = new Stage(width, height, true);
		}
		stage.clear();
		Gdx.input.setInputProcessor(stage);
		
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("button_unselected");
		style.over = skin.getDrawable("button_selected");
		style.font = whiteFont;
		
		button = new TextButton("New Game", style);
		button.setWidth(500); button.setHeight(80);
		button.setX(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2);
		button.setY(Gdx.graphics.getHeight() / 2 - button.getHeight() / 2);
		
		button.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new Game(game));
			}
		});
		
		stage.addActor(button);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		buttonAtlas = new TextureAtlas("data/menu/button.pack");
		skin = new Skin();
		skin.addRegions(buttonAtlas);
		whiteFont = new BitmapFont(Gdx.files.internal("data/font/white_font.fnt"), false);
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		buttonAtlas.dispose();
		whiteFont.dispose();
		stage.dispose();
	}

}
