package com.WhateverSoftware.LuftrauserClone.Graphics;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public static AssetManager assetManager;

	public static void loadArtAssets() {
		Assets.loadSkies();
		Assets.loadClouds();
		Assets.loadSkyLines();
		Assets.loadBoats();
		Assets.loadPlanes();
		Assets.loadProjectiles();

		Assets.assetManager.load("MainMenu/PlayGame.png", Texture.class);
		Assets.assetManager.load("MainMenu/Options.png", Texture.class);
		Assets.assetManager.load("MainMenu/ExitGame.png", Texture.class);
	}
	
	public static void loadSkies(){
		Assets.assetManager.load("Background/Backgrounds/sky01.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky02.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky03.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky04.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky05.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky06.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky07.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky08.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky09.png", Texture.class);
		Assets.assetManager.load("Background/Backgrounds/sky10.png", Texture.class);
	}
	
	public static void loadClouds(){
		Assets.assetManager.load("Background/Clouds/cloud1.png", Texture.class);
		Assets.assetManager.load("Background/Clouds/cloud2.png", Texture.class);
		Assets.assetManager.load("Background/Clouds/cloud3.png", Texture.class);
		Assets.assetManager.load("Background/Clouds/cloud4.png", Texture.class);
		Assets.assetManager.load("Background/Clouds/cloud5.png", Texture.class);
		Assets.assetManager.load("Background/Clouds/cloud6.png", Texture.class);
		Assets.assetManager.load("Background/Clouds/cloud7.png", Texture.class);
	}
	
	public static void loadSkyLines(){
		Assets.assetManager.load("Background/Skylines/city1.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/city2.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/city3.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/city4.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/city5.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/mountains1.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/mountains2.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/mountainshills.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/mountainsisland.png", Texture.class);
		Assets.assetManager.load("Background/Skylines/pyramids.png", Texture.class);
	}
	
	public static void loadBoats(){
		Assets.assetManager.load("Boats/pirateboat1.png", Texture.class);
		Assets.assetManager.load("Boats/pirateboat2.png", Texture.class);
		Assets.assetManager.load("Boats/pirateboat3.png", Texture.class);
		Assets.assetManager.load("Boats/pirateboat4.png", Texture.class);
		Assets.assetManager.load("Boats/ship1.png", Texture.class);
		Assets.assetManager.load("Boats/ship1.png", Texture.class);
		Assets.assetManager.load("Boats/ship2.png", Texture.class);
		Assets.assetManager.load("Boats/ship3.png", Texture.class);
		Assets.assetManager.load("Boats/ship4.png", Texture.class);
		Assets.assetManager.load("Boats/ship5.png", Texture.class);
		Assets.assetManager.load("Boats/ship6.png", Texture.class);
		Assets.assetManager.load("Boats/ship7.png", Texture.class);
		Assets.assetManager.load("Boats/ship8.png", Texture.class);
		Assets.assetManager.load("Boats/ship9.png", Texture.class);
		Assets.assetManager.load("Boats/ship10.png", Texture.class);
	}
	
	public static void loadPlanes(){
		Assets.assetManager.load("Planes/plane1.png", Texture.class);
		Assets.assetManager.load("Planes/plane2.png", Texture.class);
		Assets.assetManager.load("Planes/plane3.png", Texture.class);
		Assets.assetManager.load("Planes/plane4.png", Texture.class);
		Assets.assetManager.load("Planes/plane5.png", Texture.class);
		Assets.assetManager.load("Planes/plane6.png", Texture.class);
		Assets.assetManager.load("Planes/plane7.png", Texture.class);
		Assets.assetManager.load("Planes/plane8.png", Texture.class);
		Assets.assetManager.load("Planes/plane9.png", Texture.class);
		Assets.assetManager.load("Planes/plane10.png", Texture.class);
		Assets.assetManager.load("Planes/plane11.png", Texture.class);
		Assets.assetManager.load("Planes/plane12.png", Texture.class);
		Assets.assetManager.load("Planes/plane13.png", Texture.class);
		Assets.assetManager.load("Planes/plane14.png", Texture.class);
		Assets.assetManager.load("Planes/plane15.png", Texture.class);
		Assets.assetManager.load("Planes/tail1.png", Texture.class);
		Assets.assetManager.load("Planes/tail2.png", Texture.class);
	}
	
	public static void loadProjectiles(){
		Assets.assetManager.load("Projectiles/bomb1.png", Texture.class);
		Assets.assetManager.load("Projectiles/bomb2.png", Texture.class);
		Assets.assetManager.load("Projectiles/bomb3.png", Texture.class);
		Assets.assetManager.load("Projectiles/bomb4.png", Texture.class);
	}

	public static void loadSoundAssets() {
		Assets.assetManager.load("Sounds/3shot.wav", Sound.class);
		Assets.assetManager.load("Sounds/gattlingShoot.wav", Sound.class);
		Assets.assetManager.load("Sounds/gattlingSpinDown.wav", Sound.class);
		Assets.assetManager.load("Sounds/gattlingSpinUp.wav", Sound.class);
	}
}
