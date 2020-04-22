package ie.tudublin;

import processing.core.PApplet;
import java.util.ArrayList;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	public ArrayList<Task> tasks = new ArrayList<Task>();


	public void settings()
	{
		size(800, 600);
		loadTasks();
		printTasks();
	}

	public void loadTasks()
	{
		Table t = loadTable("tasks.csv", "header");
		for(TableRow row:t.rows())
		{
			Task tk = new Task(row);
			tasks.add(tk);
		}
	}

	public void printTasks()
	{
		for (int i = 0;i<tasks.size();i++)
		{
			System.out.println(tasks.get(i));
		}
	}
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}


	public void displayTasks()
	{
		float startX = 150;
		float endX = 750;
		float startY = 50;
		float endY = 550;
		String[] rows = {"Research", "Design", "Phase 1", "Phase 2", "Phase 3", "Integration", "Testing", "Evaluation", "Release"};
		float rowno = 9;
		

		//vertical lines & day nums
		for (int i=1; i<31; i++)
		{
			float x = map(i, 0f, 30f, startX, endX);
			line(x, startY, x, endY);
			text(i, x, startY - 25);
		}

		//rownames
		for (int i = 0; i<rowno - 1; i++)
		{
			float y = map(i, 0, rowno, 100, 550);
			String rowname = tasks.task.get(i);
			text(rowname, 75, y);
		}


		//colour bars

	}
	
	
	public void setup() 
	{
	}
	
	public void draw()
	{			
		background(0);
		colorMode(HSB);
		stroke(255);
		textAlign(CENTER, CENTER);

		displayTasks();
	}
}
