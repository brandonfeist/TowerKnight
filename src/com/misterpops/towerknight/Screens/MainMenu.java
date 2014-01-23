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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.misterpops.towerknight.TowerKnight;

public class MainMenu implements Screen{
	
	TowerKnight game;
	Stage stage;
	BitmapFont whiteFont;
	TextureAtlas buttonAtlas;
	Skin skin;
	SpriteBatch batch;
	TextButton newGameButton;
	Label label;
	private final int BUFFER = 100, 
			BUTTON_WIDTH = 500, 
			BUTTON_HEIGHT = 80;
	
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
		
		//Setup for menu buttons...
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("button_unselected");
		style.over = skin.getDrawable("button_selected");
		style.font = whiteFont;
		
		newGameButton = new TextButton("New Game", style);
		newGameButton.setWidth(BUTTON_WIDTH); newGameButton.setHeight(BUTTON_HEIGHT);
		newGameButton.setX(Gdx.graphics.getWidth() / 2 - newGameButton.getWidth() / 2);
		newGameButton.setY(Gdx.graphics.getHeight() / 2 - newGameButton.getHeight() / 2);
		
		newGameButton.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}
			
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen(new Game(game));
			}
		});
		
		//Game name, probably will replaced with animated picture in the future
		LabelStyle labelStyle = new LabelStyle(whiteFont, Color.BLACK);
		label = new Label("Tower Knight", labelStyle);
		label.setX(0); label.setY(Gdx.graphics.getHeight() / 2 + BUFFER);
		label.setWidth(width);
		label.setAlignment(Align.center);
		
		stage.addActor(newGameButton);
		stage.addActor(label);
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
