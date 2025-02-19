package com.program.graphics;

import org.lwjgl.opengl.GL20;

public class Shader {

    private int programID;

    public Shader(String vertexShaderSource, String fragmentShaderSource) {
        int vertexShaderID = compileShader(vertexShaderSource, GL20.GL_VERTEX_SHADER);
        int fragmentShaderID = compileShader(fragmentShaderSource, GL20.GL_FRAGMENT_SHADER);

        programID = GL20.glCreateProgram();
        GL20.glAttachShader(programID, vertexShaderID);
        GL20.glAttachShader(programID, fragmentShaderID);
        GL20.glLinkProgram(programID);
        GL20.glValidateProgram(programID);
    }

    private int compileShader(String source, int shaderType) {
        int shaderID = GL20.glCreateShader(shaderType);
        GL20.glShaderSource(shaderID, source);
        GL20.glCompileShader(shaderID);
        return shaderID;
    }

    public void use() {
        GL20.glUseProgram(programID);
    }

    public void cleanUp() {
        GL20.glDeleteProgram(programID);
    }
}
