package servletgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletforgraphics
 */
@WebServlet("/servletforgraphics")
public class servletforgraphics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numberobject;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletforgraphics() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("image/jpeg");
		BufferedImage bi = new BufferedImage(300,203,BufferedImage.TYPE_INT_RGB);
		//int[] rgbarray={255,48,48};
		//bi.setRGB(0, 0, 300, 203,rgbarray,0,0);
		Graphics g = bi.getGraphics();
		numberobject=zufall();
		switch(numberobject){
		case 1: 
			g.setColor(Color.yellow);
			g.fillOval(23, 39, 80, 69);
			
			break;
		case 2:
			g.setColor(Color.yellow);
			g.fillOval(90, 70, 40, 120);
			break;
		case 3:
			g.setColor(Color.green);
			g.fillRoundRect(40, 55, 70, 30, 40, 44);
			break;
		case 4:
			g.setColor(Color.orange);
			g.fillRect(70, 20, 130, 180);
			break;
		case 5: 
			g.setColor(Color.yellow);
			g.fillArc(40, 30,50, 80, 33,55);
			break;
		case 6:
			g.setColor(Color.green);
			g.fillRect(130, 99, 80, 140);
			break;
		}
		
		OutputStream ous= response.getOutputStream();
		g.dispose();
		
		try{
		
		ImageIO.write(bi,"jpeg",ous);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	public int zufall(){
		int zufall = 1+ (int) (Math.random()*6); // Zufallszahl von 1 bis 6
		return zufall;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
