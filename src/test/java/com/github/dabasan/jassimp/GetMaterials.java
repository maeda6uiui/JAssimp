package com.github.dabasan.jassimp;

import java.io.IOException;
import java.util.List;

public class GetMaterials {
	public static void main(String[] args) {
		AiScene scene;
		try {
			scene = Jassimp.importFile("./TestData/model.obj");
		} catch (final IOException e) {
			e.printStackTrace();
			return;
		}

		final List<AiMaterial> materials = scene.getMaterials();
		for (final var material : materials) {
			System.out.println(material.getName());
			System.out.println(material.getTextureFile(AiTextureType.DIFFUSE, 0));
			System.out.println("====================");
		}
	}
}
