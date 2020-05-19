package com.github.dabasan.jassimp;

import java.io.IOException;
import java.util.List;

public class GetVertexNum {
	public static void main(String[] args) {
		AiScene scene;
		try {
			scene = Jassimp.importFile("./TestData/model.obj");
		} catch (final IOException e) {
			e.printStackTrace();
			return;
		}

		final List<AiMesh> meshes = scene.getMeshes();
		for (final var mesh : meshes) {
			System.out.println(mesh.getNumVertices());
		}
	}
}
