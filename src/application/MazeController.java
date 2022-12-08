package application;

import searches.SearchAlgorithm;
import searches.SearchFactory;
import java.awt.Point;


public class MazeController {
	// Where to start and stop the search
	private Point start;
	private Point goal;
	
	//model and display
		private MazeDisplay mazeDisplay;
		private Maze maze;
	
	private SearchFactory searchStyle=new SearchFactory();
	private SearchAlgorithm search;
	
	
	
	public MazeController(int numRows, int numColumns, MazeDisplay display){
		start = new Point(1,1);
		goal = new Point(numRows-2, numColumns-2);
		maze = new Maze(numRows, numColumns);
		mazeDisplay = display;
	}
	
	/*
	 * Re-create the maze from scratch.
	 * When this happens, we should also stop the search.
	 */
	public void newMaze() {
		maze.createMaze(maze.getNumRows(),maze.getNumCols());
		//search = "";
		mazeDisplay.redraw();
		search = null;
	}
	
	public void startSearch(String searchType) {
		maze.reColorMaze();
		//search = searchType;
		
		// Restart the search.  Since I don't know 
		// which one, I'll restart all of them.
		
		search=searchStyle.makeSearch(searchType, maze, start, goal);

	}
	
	/*
	 * Does a step in the search regardless of pause status
	 */
	public void doOneStep(double elapsedTime){
		if (search != null) {
			search.step();
		}
//		if(search.equals("DFS")) dfs.step();
//		else if (search.equals("BFS")) bfs.step();
//		else if (search.equals("Greedy")) greedy.step();
//		else if (search.equals("RandomWalk")) rand.step();
//		else if (search.equals("Magic")) magic.step();
		mazeDisplay.redraw();
	}
	
	public int getCellState(Point position) {
		return maze.get(position);
	}

}
