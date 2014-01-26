package MainMenuScreen;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MainMenuInput extends InputListener {
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
		return true;
	}

	public void touchDragged(InputEvent event, float x, float y, int pointer) {

	}

	public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

	}

	public boolean keyTyped(InputEvent event, char character) {
		return true;
	}
}
