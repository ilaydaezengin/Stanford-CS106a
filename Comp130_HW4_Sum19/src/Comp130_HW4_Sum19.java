/* Student Name:
 * The program allows the user to create tree(s), ornament(s), 
 * present(s) with different size and color to canvas 
 * by clicking the mouse. 
 * 
 */
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.*; 
import java.util.*;
import javax.swing.*;
import acm.graphics.*;
import acm.gui.*;
import acm.program.GraphicsProgram;
import acm.util.*;


public class Comp130_HW4_Sum19 extends GraphicsProgram{

	private final int APPLICATION_WIDTH = 900; // application width
	private final int APPLICATION_HEIGHT= 600; // application height
	// random generator
	private RandomGenerator rgen = RandomGenerator.getInstance();
	// slider sizes
	private static final int MIN_SLIDER_SIZE = 0;
	private static final int MAX_SLIDER_SIZE = 2;
	private static final int INITIAL_SLIDER_SIZE = 1;
	// pricing for the ornament as per size
	private static final int SMALL_CIRCLE_ORNAMENT_PRICE = 5;
	private static final int MEDIUM_CIRCLE_ORNAMENT_PRICE = 7;
	private static final int LARGE_CIRCLE_ORNAMENT_PRICE = 10;
	private static final int SMALL_OVAL_ORNAMENT_PRICE = 7;
	private static final int MEDIUM_OVAL_ORNAMENT_PRICE = 10;
	private static final int LARGE_OVAL_ORNAMENT_PRICE = 12;
	private static final int SMALL_STAR_ORNAMENT_PRICE = 8;
	private static final int MEDIUM_STAR_ORNAMENT_PRICE = 12;
	private static final int LARGE_STAR_ORNAMENT_PRICE = 15;
	//pricing of the tree 
	private static final int TREE_PRICE = 100;
	//pricing of the present
	private static final int PRESENT_PRICE = 20;
	//Y coordinate of Tree
	private static final int TREE_Y_COORDINATE = 300;
	//Y coordinate of Present
	private static final int PRESENT_Y_COORDINATE = 400;
	//size of Present, ornaments
	private static final int PRESENT_WIDTH = 30;
	private static final int PRESENT_HEIGHT = 20;
	private static final int SMALL_STAR_ORNAMENT_SIZE = 10;
	private static final int MEDIUM_STAR_ORNAMENT_SIZE = 15;
	private static final int LARGE_STAR_ORNAMENT_SIZE = 20;
	private static final int SMALL_CIRCLE_ORNAMENT_SIZE = 10;
	private static final int MEDIUM_CIRCLE_ORNAMENT_SIZE = 20;
	private static final int LARGE_CIRCLE_ORNAMENT_SIZE = 25;
	private static final int SMALL_OVAL_ORNAMENT_WIDTH = 5;
	private static final int MEDIUM_OVAL_ORNAMENT_WIDTH = 10;
	private static final int LARGE_OVAL_ORNAMENT_WIDTH = 15;
	private static final int SMALL_OVAL_ORNAMENT_HEIGHT = 10;
	private static final int MEDIUM_OVAL_ORNAMENT_HEIGHT = 20;
	private static final int LARGE_OVAL_ORNAMENT_HEIGHT = 25;
	//size of the tree
	private final int TRUNK_WIDTH = 30;
	private final int TRUNK_HEIGHT = 100;
	private static final int SNOW_SIZE = 5; // size of the snow
	private static final String CRAWL_MUSIC_FILENAME = "music.au"; // music file name
	// names of the ornaments
	String[] ornaments = {"Circle", "Oval", "Star"};
	private ArrayList<String> studentList = new ArrayList<String>(); // collection to store studentNames
	
	// Additional instance variable
	// Your code starts here
	// Your code ends here
	
	public void run() {
		init();
		addActionListeners();
		addMouseListeners();
		

	}

	
	private void addMusicAndBackground() {
		// Play the background music
		AudioClip music = MediaTools.loadAudioClip(CRAWL_MUSIC_FILENAME);
		music.play();

		// Add our background image
		// Your code starts here
		GImage background = new GImage("snowBack1.jpeg");
		background.setBounds(0, 0, getWidth(), getHeight());
		add(background);
		// Your code ends here
		
	}
	
	/**
	 * The method to initialize the GUI and the program
	 */
    public void init(){
		// Your code starts here
    	
    		JButton createTreeButton = new JButton("Create Tree");
    		JButton createPresentButton = new JButton("Create Present");
    		JButton calculateSpendingButton = new JButton("Calculate Spending");
    		JButton clearButton = new JButton("Clear");
    		add(createTreeButton,SOUTH);
    		add(createPresentButton,SOUTH);
    		add(clearButton,SOUTH);
    		
    		JCheckBox checkbox = new JCheckBox("Filled");
    		add(checkbox,NORTH);
    		JSlider slider = new JSlider(MIN_SLIDER_SIZE,MAX_SLIDER_SIZE,INITIAL_SLIDER_SIZE);
    		add(new JLabel("Ornament Size - "+ MIN_SLIDER_SIZE +""),NORTH);
    		add(slider,NORTH);
    		add(new JLabel(""+ MAX_SLIDER_SIZE +" "),NORTH);
    		JComboBox orm_shape = new JComboBox();
    		orm_shape.addItem(ornaments[0]);
    		orm_shape.addItem(ornaments[1]);
    		orm_shape.addItem(ornaments[2]);
    		orm_shape.setEditable(false);
    		add(orm_shape,NORTH);

    		JComboBox orm_color = new JComboBox();
    		orm_color.addItem("White");
    		orm_color.addItem("Red");
    		orm_color.addItem("Yellow");
    		orm_color.addItem("Blue");
    		orm_color.setEditable(false);
    		orm_color.setSelectedItem("White");
    		add(orm_color,NORTH);
    		
    		JComboBox orm_list = new JComboBox();
    		createStudentList();
    		for(int i = 0; i < studentList.size(); i++){
    			orm_list.addItem(studentList.get(i));
    		}
    		orm_list.setEditable(false);
    		add(orm_list,NORTH);
    		
    		JLabel l1 = new JLabel("Ornament Spending");
    		add(l1,EAST);
    		DoubleField orm_spending = new DoubleField(0.0);
    		add(orm_spending,EAST);
    		
    		JLabel l2 = new JLabel("Tree Spending");
    		add(l2,EAST);
    		DoubleField tree_spending = new DoubleField(0.0);
    		add(tree_spending,EAST);
    		
    		JLabel l3 = new JLabel("Present Spending");
    		add(l3,EAST);
    		DoubleField present_spending = new DoubleField(0.0);
    		add(present_spending,EAST);
    		
    		JLabel l4 = new JLabel("Total Spending");
    		add(l4,EAST);
    		DoubleField total_spending = new DoubleField(0.0);
    		add(total_spending,EAST);
    		add(calculateSpendingButton,EAST);
    		addMusicAndBackground();
		// Your code ends here
		
    }

    /**
     * The method to handle the mouse clicked events.
     * @param MouseEvent - the event created when a mouse is clicked
     */
   public void mouseClicked(MouseEvent e) {	
	    	// Your code starts here
    	
	    	// Your code ends here
    		
		
	}
    /**
     * The method to handle the action events.
     * @param ActionEvent - the event created when an action happens
     */
    public void actionPerformed(ActionEvent e) {
		// Your code starts here
    	String s = e.getActionCommand();
    		if(s.equals("Create Tree")){
    			createTree();
    		} else if(s.equals("Create Present")){
    			createPresent();
    		} else if(s.equals("Clear")){
    			removeAll();
    			//////////////SPENDING SHOULD ALSO BE CLEANED
    		} else if(s.equals("Calcuate Spending")){
    			createPrice();
    			
    		}
    		}
		// Your code ends here


    
   
    private void createOrnament(MouseEvent e) {
    		// Your code starts here
    	if(this.getGCanvas().getAccessibleContext() != null){
    		if(e.equals("Circle")){
    			createCircleOrnament(e);
    		} else if (e.equals("Oval")){
    			createOvalOrnament(e);
    		} else if (e.equals("Star")){
    			createStarOrnament(e);
    		}
    	} 
		
    		// Your code ends here
	}
    private void createPresent() {
    		
    		// Your code starts here
		
    		// Your code ends here
	}
   
    private Color getOrnamentColor() {
		// Return the color chosen by the user
		// Your code starts here
		
		// Your code ends here
		return Color.RED;
	}
    private GOval createCircleOrnament(MouseEvent e) {
    		// Your code starts here
    	if(e.equals("Small")){
		GOval circ = new GOval(e.getX(),e.getY(),2*SMALL_CIRCLE_ORNAMENT_SIZE,2*SMALL_CIRCLE_ORNAMENT_SIZE);
		return circ;
    	} else if(e.equals("Medium")){
    	GOval circ = new GOval(e.getX(),e.getY(),2*MEDIUM_CIRCLE_ORNAMENT_SIZE,2*MEDIUM_CIRCLE_ORNAMENT_SIZE);
    	return circ;
    	} else {
    	GOval circ = new GOval(e.getX(),e.getY(),2*LARGE_CIRCLE_ORNAMENT_SIZE,2*LARGE_CIRCLE_ORNAMENT_SIZE);
    	return circ;
    	}
    		// Your code ends here
		
		

    }
    private GOval createOvalOrnament(MouseEvent e) {
    		// Your code starts here
    	if(e.equals("Small")){
    		GOval circ = new GOval(e.getX(),e.getY(),SMALL_OVAL_ORNAMENT_WIDTH,SMALL_OVAL_ORNAMENT_HEIGHT);
    		///////////FİLLED CHECKBOX A NASIL ULAŞICAM ONA GÖRE FİLLED KOYUCAM VE COLOR????
    		return circ;
    	} else if(e.equals("Medium")){
        	GOval circ = new GOval(e.getX(),e.getY(),MEDIUM_OVAL_ORNAMENT_WIDTH,MEDIUM_OVAL_ORNAMENT_HEIGHT);
        	return circ;
    	} else {
        	GOval circ = new GOval(e.getX(),e.getY(),MEDIUM_OVAL_ORNAMENT_WIDTH,MEDIUM_OVAL_ORNAMENT_HEIGHT);
        	return circ;
    	}
    		// Your code ends here
	}


    private GPolygon createStarOrnament(MouseEvent e) {
    		// Your code starts here
    	if(e.equals("Small")){
    		GPolygon star = createStar(SMALL_STAR_ORNAMENT_SIZE);
    		add(star,e.getX(),e.getY());
    		return star;
    	} else if(e.equals("Medium")){
    		GPolygon star = createStar(MEDIUM_STAR_ORNAMENT_SIZE);
    		add(star,e.getX(),e.getY());
    		return star;
    	} else{
    		GPolygon star = createStar(LARGE_STAR_ORNAMENT_SIZE);
    		add(star,e.getX(),e.getY());
    		return star;
    	}
    		// Your code ends here
		
		
    }
    private int setLocation() {
    		// Your code starts here
return 0;		
		
    		// Your code ends here
    }
    
    /**
     * The method returns the size of the ornament selected
     * from the slider.
     * @return int - the size of the ornament selected in the slider
     */
    private int getOrnamentSize() {
	    	// Your code starts here
return 0;
	    	// Your code ends here
		
	}
 
   private void createTree () {
    		// Your code starts here
	   GCompound tree = new GCompound();
	   GPolygon small_tri = new GPolygon(TRUNK_WIDTH,TRUNK_HEIGHT/6);
	   small_tri.addVertex(0,-TRUNK_HEIGHT/12);
	   small_tri.addEdge(-TRUNK_WIDTH/4,TRUNK_HEIGHT/6);
	   small_tri.addEdge(TRUNK_WIDTH/2, 0);
	   small_tri.setFilled(true);
	   small_tri.setFillColor(Color.green);
	   tree.add(small_tri,0,0);
	   GPolygon big_tri =  new GPolygon(TRUNK_WIDTH,TRUNK_HEIGHT/3);
	   big_tri.addVertex(0, -TRUNK_HEIGHT/6);
	   big_tri.addEdge(-TRUNK_WIDTH/2,TRUNK_WIDTH/3);
	   big_tri.addEdge(TRUNK_WIDTH, 0);
	   big_tri.setFilled(true);
	   big_tri.setFillColor(Color.green);
	   tree.add(big_tri,0,TRUNK_HEIGHT/6);
	   GRect body = new GRect(TRUNK_WIDTH/4,TRUNK_HEIGHT/2);
	   tree.add(body,(TRUNK_WIDTH-TRUNK_WIDTH/4)/2,TRUNK_HEIGHT/2);
	   
	   int y = TREE_Y_COORDINATE;
	   int x = rgen.nextInt(0,getWidth());
		add(tree,x,y);
		
    		// Your code ends here
    }
    private void createPrice() {
		// Your code starts here
		
		// Your code ends here
   }
   private GPolygon createStar(int size) {  
		// Your code starts here
	   GPolygon star = new GPolygon();
		star.setFilled(true);
		star.setColor(getOrnamentColor());
		// Your code ends here
		return star;
   }
   private void moveSnow() {
		// Your code starts here
		
		// Your code ends here
	}

	private void makeNewSnow() {
		// make a new snowflake with 5% probability
		// Your code starts here
		
		// Your code ends here

	}

	// DO NOT REMOVE BELOW///
	/*
	 * Method to create a collection of the student names
	 */
	private void createStudentList() {
		studentList.add("AHMET;GÃœVEN");
		studentList.add("ALÄ°;GAZEL");
	    	studentList.add("ALÄ°;DOÄ�ANGÃœN");
	    	studentList.add("ALÄ°;AKYÃœREK");
	    	studentList.add("ALPER;YELÄ°MLÄ°EÅ�");
		studentList.add("ARYA;YÄ°GÄ°T");
		studentList.add("ATA;GÃœRSOY");
		studentList.add("AYBERK;AKÃ‡AY");
		studentList.add("AYKUT;IÅ�IK");
		studentList.add("BAHA;ORHAN");
		studentList.add("BAHAR;Ã–ZTÃœRK");
		studentList.add("BETÃœL;DÄ°NÃ‡ER");
		studentList.add("CAN;GUDEN");
		studentList.add("CANKUT;Ã‡OK");
		studentList.add("DENÄ°Z;SAÄ�MANLI");
		studentList.add("DÄ°LARA;KARADUMAN");
		studentList.add("DOÄ�UKAN;YAPRAK");
		studentList.add("EGE;AKÅ�EHÄ°RLÄ°OÄ�LU");
		studentList.add("EGE;KILIÃ‡");
		studentList.add("ENEL;COMBA");
		studentList.add("ENES;Ã‡EVÄ°K");
		studentList.add("ENES;AYAR");
	}

}
