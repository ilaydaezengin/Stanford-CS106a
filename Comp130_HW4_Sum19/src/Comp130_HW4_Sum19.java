/* Student Name: Ilayda Ezgi Zengin,50302
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
	JButton createTreeButton;
	JButton createPresentButton;
	JButton calculateSpendingButton;
	JButton clearButton;
	JCheckBox checkbox;
	JSlider slider;
	JComboBox<String> orm_shape;
	JComboBox<String> orm_color;
	JComboBox<String> orm_list; 
	DoubleField orm_spending;
	DoubleField tree_spending;
	DoubleField present_spending;
	DoubleField total_spending;
	int tree_count = 0;
	int present_count = 0;
	int sm_circ_orn_count = 0;
	int med_circ_orn_count = 0;
	int lrg_circ_orn_count = 0;
	int sm_oval_orn_count = 0;
	int med_oval_orn_count = 0;
	int lrg_oval_orn_count = 0;
	int sm_star_orn_count = 0;
	int med_star_orn_count = 0;
	int lrg_star_orn_count = 0;
	
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
    	
    		createTreeButton = new JButton("Create Tree");
    		createPresentButton = new JButton("Create Present");
    		calculateSpendingButton = new JButton("Calculate Spending");
    		clearButton = new JButton("Clear");
    		add(createTreeButton,SOUTH);
    		add(createPresentButton,SOUTH);
    		add(clearButton,SOUTH);
    		
    		checkbox = new JCheckBox("Filled");
    		add(checkbox,NORTH);
    		slider = new JSlider(MIN_SLIDER_SIZE,MAX_SLIDER_SIZE,INITIAL_SLIDER_SIZE);
    		add(new JLabel("Ornament Size - "+ MIN_SLIDER_SIZE +""),NORTH);
    		add(slider,NORTH);
    		add(new JLabel(""+ MAX_SLIDER_SIZE +" "),NORTH);
    		orm_shape = new JComboBox<String>();
    		orm_shape.addItem(ornaments[0]);
    		orm_shape.addItem(ornaments[1]);
    		orm_shape.addItem(ornaments[2]);
    		orm_shape.setEditable(false);
    		add(orm_shape,NORTH);

    		orm_color = new JComboBox<String>();
    		orm_color.addItem("White");
    		orm_color.addItem("Red");
    		orm_color.addItem("Yellow");
    		orm_color.addItem("Blue");
    		orm_color.setEditable(false);
    		add(orm_color,NORTH);
    		
    		orm_list = new JComboBox<String>();
    		createStudentList();
    		for(int i = 0; i < studentList.size(); i++){
    			orm_list.addItem(studentList.get(i));
    		}
    		orm_list.setEditable(false);
    		add(orm_list,NORTH);
    		
    		JLabel l1 = new JLabel("Ornament Spending");
    		add(l1,EAST);
    		orm_spending = new DoubleField(0.0);
    		add(orm_spending,EAST);
    		
    		JLabel l2 = new JLabel("Tree Spending");
    		add(l2,EAST);
    		tree_spending = new DoubleField(0.0);
    		add(tree_spending,EAST);
    		
    		JLabel l3 = new JLabel("Present Spending");
    		add(l3,EAST);
    		present_spending = new DoubleField(0.0);
    		add(present_spending,EAST);
    		
    		JLabel l4 = new JLabel("Total Spending");
    		add(l4,EAST);
    		total_spending = new DoubleField(0.0);
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
    	createOrnament(e);	
    	}
	    	// Your code ends here
    		
		
	
    /**
     * The method to handle the action events.
     * @param ActionEvent - the event created when an action happens
     */
    public void actionPerformed(ActionEvent e) {
		// Your code starts here
    	String s = e.getActionCommand();
    		if(s.equals("Create Tree")){
    			createTree();
    			tree_count ++;
    		} else if(s.equals("Create Present")){
    			createPresent();
    			present_count ++;
    		} else if(s.equals("Clear")){
    			removeAll();
    			total_spending.setValue(0.0);
    			orm_spending.setValue(0.0);
    			present_spending.setValue(0.0);
    			tree_spending.setValue(0.0);
    		} else if(s.equals("Calcuate Spending")){
    			createPrice();
    			
    			
    			
    		}
    		}
		// Your code ends here


    
   
    private void createOrnament(MouseEvent e) {
    		// Your code starts here
    		String name = (String) orm_shape.getSelectedItem();
    		if(name.equals("Circle")){
    			GOval circ = createCircleOrnament(e);
    			if(checkbox.isSelected()){
    				circ.setFilled(true);
    				circ.setFillColor(getOrnamentColor());
    			}
    			add(circ,e.getX(),e.getY());
    		} else if (name.equals("Oval")){
    			GOval circ = createOvalOrnament(e);
    			if(checkbox.isSelected()){
    				circ.setFilled(true);
    				circ.setFillColor(getOrnamentColor());
    			}
    			add(circ,e.getX(),e.getY());
    		} else if (name.equals("Star")){
    			GPolygon circ = createStarOrnament(e);
    			if(checkbox.isSelected()){
    				circ.setFilled(true);
    				circ.setFillColor(getOrnamentColor());
    			}
    			add(circ,e.getX(),e.getY());
    		}
    	} 
		
    		// Your code ends here
	
    private void createPresent() {
    		
    		// Your code starts here
		
    		// Your code ends here
	}
   
    private Color getOrnamentColor() {
		// Return the color chosen by the user
		// Your code starts here
    	String name = (String) orm_color.getSelectedItem();

		if (name.equals("Red"))
			return Color.RED;

		if (name.equals("Yellow"))
			return Color.YELLOW;

		if (name.equals("Blue"))
			return Color.BLUE;
		// Your code ends here
		return Color.WHITE;
	}
		// Your code ends here
		
    private GOval createCircleOrnament(MouseEvent e) {
    		// Your code starts here
    	int size = getOrnamentSize();
    	if(size == 0){
		GOval circ = new GOval(e.getX(),e.getY(),2*SMALL_CIRCLE_ORNAMENT_SIZE,2*SMALL_CIRCLE_ORNAMENT_SIZE);
		sm_circ_orn_count++;
		return circ;
    	} else if(size == 1){
    	GOval circ = new GOval(e.getX(),e.getY(),2*MEDIUM_CIRCLE_ORNAMENT_SIZE,2*MEDIUM_CIRCLE_ORNAMENT_SIZE);
    	med_circ_orn_count++;
    	return circ;
    	} else {
    	GOval circ = new GOval(e.getX(),e.getY(),2*LARGE_CIRCLE_ORNAMENT_SIZE,2*LARGE_CIRCLE_ORNAMENT_SIZE);
    	lrg_circ_orn_count++;
    	return circ;
    	}
    		// Your code ends here
		
		

    }
    private GOval createOvalOrnament(MouseEvent e) {
    		// Your code starts here
    	int size = getOrnamentSize();
    	if(size == 0){
    		GOval circ = new GOval(e.getX(),e.getY(),SMALL_OVAL_ORNAMENT_WIDTH,SMALL_OVAL_ORNAMENT_HEIGHT);
    		sm_oval_orn_count++;
    		return circ;
    	} else if(size == 1){
        	GOval circ = new GOval(e.getX(),e.getY(),MEDIUM_OVAL_ORNAMENT_WIDTH,MEDIUM_OVAL_ORNAMENT_HEIGHT);
        	med_oval_orn_count++;
        	return circ;
    	} else {
        	GOval circ = new GOval(e.getX(),e.getY(),LARGE_OVAL_ORNAMENT_WIDTH,LARGE_OVAL_ORNAMENT_HEIGHT);
        	lrg_oval_orn_count++;
        	return circ;
    	}
    		// Your code ends here
	}


    private GPolygon createStarOrnament(MouseEvent e) {
    		// Your code starts here
    	int size = getOrnamentSize();
    	if(size == 0){
    		GPolygon star = createStar(SMALL_STAR_ORNAMENT_SIZE);
    		add(star,e.getX(),e.getY());
    		sm_star_orn_count++;
    		return star;
    	} else if(size == 1){
    		GPolygon star = createStar(MEDIUM_STAR_ORNAMENT_SIZE);
    		add(star,e.getX(),e.getY());
    		med_star_orn_count++;
    		return star;
    	} else{
    		GPolygon star = createStar(LARGE_STAR_ORNAMENT_SIZE);
    		add(star,e.getX(),e.getY());
    		lrg_star_orn_count++;
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
    	int answer = 0;
    	answer = slider.getValue();
    	return answer;
    	
	    	// Your code ends here
		
	}
 
   private void createTree () {
    		// Your code starts here
	   GCompound tree = new GCompound();
	   GPolygon small_tri = new GPolygon(3*TRUNK_WIDTH,TRUNK_HEIGHT/2);
	   small_tri.addVertex(0,-TRUNK_HEIGHT/4);
	   small_tri.addEdge(-3*TRUNK_WIDTH/2,TRUNK_HEIGHT/4);
	   small_tri.addEdge(3*TRUNK_WIDTH, 0);
	   small_tri.setFilled(true);
	   small_tri.setFillColor(Color.green);
	   tree.add(small_tri,0,0);
	   
	   GPolygon big_tri =  new GPolygon(6*TRUNK_WIDTH,TRUNK_HEIGHT);
	   big_tri.addVertex(0, -TRUNK_HEIGHT/2);
	   big_tri.addEdge(-3*TRUNK_WIDTH,TRUNK_HEIGHT);
	   big_tri.addEdge(6*TRUNK_WIDTH, 0);
	   big_tri.setFilled(true);
	   big_tri.setFillColor(Color.green);
	   tree.add(big_tri,0,TRUNK_HEIGHT/2);
	   
	   GRect body = new GRect(TRUNK_WIDTH,TRUNK_HEIGHT);
	   body.setFilled(true);
	   body.setFillColor(Color.BLACK);
	   tree.add(body,5*TRUNK_WIDTH/2,3*TRUNK_HEIGHT/2);
	   
	   int y = TREE_Y_COORDINATE;
	   int x = rgen.nextInt(0,getWidth());
		add(tree,x,y);
		
    		// Your code ends here
    }
    private void createPrice() {
		// Your code starts here
    	double tree_spend =  tree_count * TREE_PRICE;
    	double present_spend = present_count * PRESENT_PRICE;
    	double orn_spend = sm_circ_orn_count * SMALL_CIRCLE_ORNAMENT_PRICE +
				med_circ_orn_count * MEDIUM_CIRCLE_ORNAMENT_PRICE +
				lrg_circ_orn_count * LARGE_CIRCLE_ORNAMENT_PRICE +
				sm_oval_orn_count *  SMALL_OVAL_ORNAMENT_PRICE +
				med_oval_orn_count * MEDIUM_OVAL_ORNAMENT_PRICE +
				lrg_oval_orn_count * LARGE_OVAL_ORNAMENT_PRICE +
				sm_star_orn_count * SMALL_STAR_ORNAMENT_PRICE +
				med_star_orn_count * MEDIUM_STAR_ORNAMENT_PRICE +
				lrg_star_orn_count * LARGE_STAR_ORNAMENT_PRICE;
		double price = tree_spend + present_spend + orn_spend;
		tree_spending.setValue(tree_spend);
		present_spending.setValue(present_spend);
		orm_spending.setValue(orn_spend);
			
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
