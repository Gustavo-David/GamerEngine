package com.program.input;

import org.lwjgl.glfw.GLFW;
import java.util.HashMap;
import java.util.Map;

public class KeyHandler {

    private long window;
    private boolean[] keyStates = new boolean[GLFW.GLFW_KEY_LAST + 1]; // Um array para armazenar o estado de todas as teclas
    private Map<String, Integer> keyBindings; // Mapa de teclas configuráveis

    public KeyHandler(long window) {
        this.window = window;
        keyBindings = new HashMap<>();
        // Configura teclas padrão (pode ser ajustado conforme necessário)
        setDefaultKeyBindings();
    }

    // Configurações padrões de teclas
    private void setDefaultKeyBindings() {
        // Exemplo de teclas padrão (pode ser alterado posteriormente)
        keyBindings.put("MOVE_FORWARD", GLFW.GLFW_KEY_W);
        keyBindings.put("MOVE_BACKWARD", GLFW.GLFW_KEY_S);
        keyBindings.put("MOVE_LEFT", GLFW.GLFW_KEY_A);
        keyBindings.put("MOVE_RIGHT", GLFW.GLFW_KEY_D);
        keyBindings.put("JUMP", GLFW.GLFW_KEY_SPACE);
        keyBindings.put("ESCAPE", GLFW.GLFW_KEY_ESCAPE);
    }

    // Atualiza o estado das teclas
    public void update() {
        for (int key = 0; key <= GLFW.GLFW_KEY_LAST; key++) {
            keyStates[key] = GLFW.glfwGetKey(window, key) == GLFW.GLFW_PRESS;
        }
    }

    // Verifica se a tecla configurada está pressionada
    public boolean isKeyPressed(String action) {
        Integer key = keyBindings.get(action);
        if (key != null) {
            return keyStates[key];
        }
        return false;
    }

    // Permite que o jogador configure uma tecla para uma ação específica
    public void bindKey(String action, int key) {
        keyBindings.put(action, key);
    }

    // Permite ao jogador redefinir uma tecla para uma ação
    public void resetKey(String action) {
        keyBindings.remove(action);
    }

    // Método para obter a tecla associada a uma ação
    public Integer getKey(String action) {
        return keyBindings.get(action);
    }
}
