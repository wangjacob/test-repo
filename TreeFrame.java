package ProgramAssignment4;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
public class TreeFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Shape> shapes = new ArrayList<Shape>();  
	public ArrayList<Shape> getShapes() {  
		return shapes;  
	}  
	public void paint(Graphics g) { 
		//redraw the existing shapes
		super.paint(g);  
		for (int i = 0; i < shapes.size(); i++) {  
			Shape sh = shapes.get(i);  
			sh.draw(g);  
		}  
	} 
	//draw the tree
	public void drawTree(TreeNode treeNode, int x, int y, int level) {  
		Graphics g = this.getGraphics();  
		level++;  
		g.drawString("" + treeNode.getItem(), x, y);  
		this.getShapes().add(new Point(Integer.parseInt(treeNode.getItem().toString()), x, y));
		if (treeNode.getLeft() != null) {  
			g.drawLine(x, y, x - 300/(int)Math.pow(2, level), y + 10*level);  
			this.getShapes().add(new Line(x, y, x - 300/(int)Math.pow(2, level), y + 10*level));  
			drawTree(treeNode.getLeft(), x - 300/(int)Math.pow(2, level), y + 10*level, level);  
		}  
		if (treeNode.getRight() != null) {  
			g.drawLine(x, y, x + 150/(int)Math.pow(2, level), y + 10*level);  
			this.getShapes().add(new Line(x, y, x + 300/(int)Math.pow(2, level), y + 10*level));  
			drawTree(treeNode.getRight(), x + 300/(int)Math.pow(2, level), y + 10*level, level);  
		}  	
	} 
}
