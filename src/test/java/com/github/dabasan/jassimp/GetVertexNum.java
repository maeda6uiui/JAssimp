package com.github.dabasan.jassimp;

import java.io.IOException;
import java.util.List;

public class GetVertexNum {
	public static void main(String[] args) {
		AiScene scene;
		try {
			scene = Jassimp.importFile("./TestData/model.obj");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		List<AiMesh> meshes = scene.getMeshes();
		for (AiMesh mesh : meshes) {
			System.out.println(mesh.getNumVertices());
		}
	}
}
