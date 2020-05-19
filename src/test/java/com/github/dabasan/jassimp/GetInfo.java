package com.github.dabasan.jassimp;

public class GetInfo {
	public static void main(String[] args) {
		System.out.printf("Version: %d.%d.%d\n\n", Jassimp.getVersionMajor(),
				Jassimp.getVersionMinor(), Jassimp.getVersionRevision());
		System.out.println(Jassimp.getLegalString());
	}
}
