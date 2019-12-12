package controller;
/*
 * This is a simple application for a Restaurant POS system.
 * It is intended to be used at a traditional style restaurant
 * were the wait staff takes your order at a the table and brings it to you.
 */

import javax.swing.SwingUtilities;

import view.MainFrame;

public class RPOSApplication {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainFrame();

			}

		});
	}
}
