package controller;

import java.util.Stack;

import interfaces.IUndoRedo;

class CommandHistory {
	private static final Stack<IUndoRedo> undoStack = new Stack<IUndoRedo>();
	private static final Stack<IUndoRedo> redoStack = new Stack<IUndoRedo>();

	public static void add(IUndoRedo cmd) {
		undoStack.push(cmd);
		redoStack.clear();
		System.out.print("undo stack now: " + undoStack + "\n");
	}

	public static boolean undo() {
		boolean result = !undoStack.empty();

		if (result) {
			IUndoRedo c = undoStack.pop();
			System.out.print("this means I'm in \n");
			redoStack.push(c);
			c.undo();
		}
		System.out.print("undo stack after: " + undoStack + "\n");
		System.out.print("redo stack after: " + redoStack + "\n");
		return result;
	}

	public static boolean redo() {
		boolean result = !redoStack.empty();
		if (result) {
			IUndoRedo c = redoStack.pop();
			undoStack.push(c);
			c.redo();
		}
		return result;
	}
}
