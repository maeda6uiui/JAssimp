package com.github.dabasan.jassimp;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.EnumSet;
import java.util.List;

public class GetVertices {
	public static void main(String[] args) {
		AiScene scene;
		try {
			scene = Jassimp.importFile("./TestData/model.x",
					EnumSet.of(AiPostProcessSteps.TRIANGULATE, AiPostProcessSteps.GEN_NORMALS,
							AiPostProcessSteps.FIND_INVALID_DATA,
							AiPostProcessSteps.FIX_INFACING_NORMALS,
							AiPostProcessSteps.OPTIMIZE_MESHES,
							AiPostProcessSteps.VALIDATE_DATA_STRUCTURE));
		} catch (final IOException e) {
			e.printStackTrace();
			return;
		}

		final List<AiMesh> meshes = scene.getMeshes();
		for (var mesh : meshes) {
			IntBuffer index_buffer = mesh.getIndexBuffer();
			FloatBuffer pos_buffer = mesh.getPositionBuffer();

			int vertex_num = index_buffer.capacity();
			int triangle_num = vertex_num / 3;

			for (int i = 0; i < triangle_num; i++) {
				System.out.printf("[Face %d]\n", i);

				for (int j = 0; j < 3; j++) {
					int index = index_buffer.get();
					float x = pos_buffer.get(3 * index);
					float y = pos_buffer.get(3 * index + 1);
					float z = pos_buffer.get(3 * index + 2);

					System.out.printf("v%d: (%f, %f, %f)\n", j, x, y, z);
				}
			}
		}
	}
}
