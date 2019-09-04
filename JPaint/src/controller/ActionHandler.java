package controller;

public class ActionHandler {
	IActionStrategy strategy;
	ActionHandler(IActionStrategy strategy){
		strategy.copy();
	}
}
