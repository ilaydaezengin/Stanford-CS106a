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
//Additional libraries
// Your code starts here

// Your code ends here

public class Comp130_HW4_Sum19Soln extends GraphicsProgram{

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
	private static final int TREE_Y_COORDINATE = 250;
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

	private final int TRUNK_WIDTH = 30;
	private final int TRUNK_HEIGHT = 100;
	private static final int SNOW_SIZE = 5;
	// file names for input and output
	private static final String inputFileName = "students.txt";
	private static final String outputFileName = "output.txt";
	private static final String CRAWL_MUSIC_FILENAME = "music.au";
	// names of the ornaments
	String[] ornaments = {"Circle", "Oval", "Star"};
	
	
	// Additional instance variable
	// Your code starts here
	// Your code ends here
	private int ornamentCount =0;
	private int presentCount = 0;
	private int treeCount =0;
	private PrintWriter wr = null;
	//private Tree tr;
	private JComboBox  <String> ornamentList;
	private JCheckBox isFill;
	private ArrayList <GOval> circleOrnamentCollection;
	private ArrayList <GCompound> treeCollection;
	private JSlider treeSizeSlider;
	private JSlider ornamentSizeSlider;
	private JComboBox  <String> colorChooser;
	private JComboBox <String> nameChooser;
	
	private DoubleField ornamentSpending;
	private DoubleField treeSpending;
	private DoubleField presentSpending;
	private DoubleField totalSpending;
	
	private HashMap<String,Integer> spending;
	
	private ArrayList<GOval> snowList = new ArrayList<GOval>();
	private ArrayList<String> studentList = new ArrayList<String>();

	public void run() {

		while(true) {
			// update world
			makeNewSnow();
			moveSnow();

			// pause
			pause(10);
		}

	}

	private void moveSnow() {
		for(GOval nextFlake : snowList) {
			if(nextFlake.getY() + SNOW_SIZE < getHeight()) {
				nextFlake.move(0, 1);
			}
		}
	}

	private void makeNewSnow() {
		// make a new snowflake with 5% probability
		if(rgen.nextBoolean(0.05)) {
			double x = rgen.nextInt(getWidth() - SNOW_SIZE);
			GOval flake = new GOval(SNOW_SIZE, SNOW_SIZE);
			flake.setFilled(true);
			flake.setColor(Color.WHITE);
			add(flake, x, -SNOW_SIZE);
			snowList.add(flake);
		}

	}
	private void addMusicAndBackground() {
		// Play the background music
		AudioClip music = MediaTools.loadAudioClip(CRAWL_MUSIC_FILENAME);
		//music.play();

		// Add our background image
		GImage bg = new GImage("snowBack1.jpeg");
		bg.setSize(getWidth(), getHeight());
		add(bg, 0, 0);
	}
	/**
	 * The method to initialize the GUI and the program
	 */
    public void init(){
		// Your code starts here
    		setSize (APPLICATION_WIDTH, APPLICATION_HEIGHT);
    		addMusicAndBackground();
    		isFill = new JCheckBox ("Filled");
    		isFill.setSelected(true);
    		add(isFill, NORTH);
    		
    		circleOrnamentCollection = new ArrayList();
    		treeCollection = new ArrayList();
		spending = new HashMap<String, Integer>();
		createStudentList(); 
		initNameChooser();
		initColorChooser();
		ornamentList = new JComboBox<String> (ornaments);
		
		//treeSizeSlider = new JSlider(MIN_SLIDER_SIZE,MAX_SLIDER_SIZE, INITIAL_SLIDER_SIZE );	
		//add(new JLabel("Tree Size - 0"), NORTH);
	    //add(treeSizeSlider, NORTH);
	    //add(new JLabel("2"), NORTH);
	    add(new JButton("Create Tree"), SOUTH);
	    ornamentSizeSlider = new JSlider(MIN_SLIDER_SIZE,MAX_SLIDER_SIZE, INITIAL_SLIDER_SIZE );	
	    add(new JLabel("Ornament Size - 0"), NORTH);
	    add(ornamentSizeSlider, NORTH);
	    add(new JLabel("2"), NORTH);  
		add(ornamentList, NORTH);
		add(colorChooser, NORTH);
		
		add(new JButton("Create Present"), SOUTH);
		
		add(new JButton("Clear"), SOUTH);
		add(nameChooser, NORTH);
		//budget = new JTextField(20);
		//add(budget, SOUTH);
		add(new JLabel("Ornament Spending"), EAST);
		ornamentSpending = new DoubleField(0);
		ornamentSpending.setEditable(true);
		add(ornamentSpending, EAST);
		add(new JLabel("Tree Spending"), EAST);
		treeSpending = new DoubleField(0);
		treeSpending.setEditable(true);
		add(treeSpending, EAST);
		add(new JLabel("Present Spending"), EAST);
		presentSpending = new DoubleField(0);
		presentSpending.setEditable(true);
		add(presentSpending, EAST);
		add(new JLabel("Total Spending"), EAST);
		totalSpending = new DoubleField(0);
		totalSpending.setEditable(true);

		add(totalSpending, EAST);
	add(new JButton("Calculate Spending"), EAST);
		
		addActionListeners();
		addMouseListeners();
	
		// Your code ends here
		
    }

    /**
     * The method to handle the mouse clicked events.
     * @param MouseEvent - the event created when a mouse is clicked
     */
    public void mouseClicked(MouseEvent e) {	
	    	// Your code starts here
	
	    	// Your code ends here
    		if (!treeCollection.isEmpty()) {
    			createOrnament(e);
    		} else {
    			println("You need to plant a tree first");
    		}
		
		
	}
    /**
     * The method to handle the action events.
     * @param ActionEvent - the event created when an action happens
     */
    public void actionPerformed(ActionEvent e) {
		// Your code starts here
    		if(e.getActionCommand().equals("Create Tree")) {
    			createTree();
    		} else if(e.getActionCommand().equals("Create Present")) {
    			createPresent();
    		}else if(e.getActionCommand().equals("Calculate Spending")) {
	    		
    			createPrice();
    		} else if(e.getActionCommand().equals("Clear")) {
    			removeAll();
    			spending.clear();
    			treeCollection.clear();
    			clearSpendings();
    			addMusicAndBackground();
    			makeNewSnow();
    		}
    		
		// Your code ends here
    }
    private void initColorChooser() {
		colorChooser = new JComboBox<String> ();
		colorChooser.addItem("White");
		colorChooser.addItem("Red");
		colorChooser.addItem("Blue");
		colorChooser.addItem("Yellow");
		colorChooser.setSelectedIndex(0);
	}
    
    /**
     * 
     */
    
    private void createOrnament(MouseEvent e) {
    		String ornament = (String) ornamentList.getSelectedItem();
    		
		if (ornament.equals("Circle")) {
			circleOrnamentCollection.add(createCircleOrnament(e));		
		}else if (ornament.equals("Oval")) {
			circleOrnamentCollection.add(createOvalOrnament(e));		
		}else if (ornament.equals("Star")) {
			createStarOrnament(e);		
		}	
	}
    private void createPresent() {
    		
		String name = (String) nameChooser.getSelectedItem();
		String initials= createInitials(name);
		GCompound c = new GCompound();
		GRect frame = new GRect (PRESENT_WIDTH, PRESENT_HEIGHT);
		c.add(frame);
		frame.setFilled(true);
		frame.setFillColor(rgen.nextColor());
		GLabel label = new GLabel(initials);
		double x = (frame.getWidth()-label.getWidth())/2;
		double y = (frame.getHeight() +label.getAscent())/2;
		//double y2 = label2.getAscent()+ (frame.getHeight() -(label.getAscent()+label.getDescent()))/2;
		//label2.setLocation(x, y2);
		c.add(label);
		label.setLocation(x, y);
		add(c, setLocation(),PRESENT_Y_COORDINATE);
		presentCount++;
		spending.put((presentCount+ "-Present"), PRESENT_PRICE);
	}
   
    private Color getOrnamentColor() {
		// Return the color chosen by the user
		// Your code starts here
		String color = (String) colorChooser.getSelectedItem();
		if (color.equals("Red")) {
			return Color.RED;
		} else if (color.equals("Yellow")) {
			return Color.YELLOW;
		} else if (color.equals("Blue")) {
			return Color.BLUE;
		} else if (color.equals("White")) {
			return Color.WHITE;
		}
		// Your code ends here
		return Color.RED;
	}
    private GOval createCircleOrnament(MouseEvent e) {
    		int ornamentSize = getOrnamentSize();
    		GOval circleOrnament = new GOval(MEDIUM_CIRCLE_ORNAMENT_SIZE, MEDIUM_CIRCLE_ORNAMENT_SIZE); 
    		switch (ornamentSize) {
    		case 0:
    			circleOrnament = new GOval(SMALL_CIRCLE_ORNAMENT_SIZE, SMALL_CIRCLE_ORNAMENT_SIZE);
    			spending.put(ornamentCount+"-CircleOrnament",SMALL_CIRCLE_ORNAMENT_PRICE );
    			
    			break;
    		case 1: default:
    			circleOrnament = new GOval(MEDIUM_CIRCLE_ORNAMENT_SIZE, MEDIUM_CIRCLE_ORNAMENT_SIZE);
    			spending.put(ornamentCount+"-CircleOrnament",MEDIUM_CIRCLE_ORNAMENT_PRICE );
    			
    			break;
    		case 2: 
    			circleOrnament = new GOval(LARGE_CIRCLE_ORNAMENT_SIZE, LARGE_CIRCLE_ORNAMENT_SIZE);
    			spending.put(ornamentCount+"-CircleOrnament",LARGE_CIRCLE_ORNAMENT_PRICE );
    			
    			break;
    		}
	
		circleOrnament.setFilled(isFill.isSelected());
		circleOrnament.setFillColor(getOrnamentColor());
		add(circleOrnament, e.getX(), e.getY());
		ornamentCount++;
		
		return circleOrnament;
    }
    private GOval createOvalOrnament(MouseEvent e) {
		int ornamentSize = getOrnamentSize();
		GOval circleOrnament = new GOval(MEDIUM_OVAL_ORNAMENT_WIDTH, MEDIUM_OVAL_ORNAMENT_HEIGHT); 
		switch (ornamentSize) {
		case 0:
			circleOrnament = new GOval(SMALL_OVAL_ORNAMENT_WIDTH, SMALL_OVAL_ORNAMENT_HEIGHT);
			spending.put(ornamentCount+"-SmallOvalOrnament",SMALL_OVAL_ORNAMENT_PRICE );
			
			break;
		case 1: default:
			circleOrnament = new GOval(MEDIUM_OVAL_ORNAMENT_WIDTH, MEDIUM_OVAL_ORNAMENT_HEIGHT);
			spending.put(ornamentCount+"-MediumOvalOrnament",MEDIUM_OVAL_ORNAMENT_PRICE );
			
			break;
		case 2: 
			circleOrnament = new GOval(LARGE_OVAL_ORNAMENT_WIDTH, LARGE_OVAL_ORNAMENT_HEIGHT);
			spending.put(ornamentCount+"-LargeOvalOrnament",LARGE_OVAL_ORNAMENT_PRICE );
			
			break;
		}

	circleOrnament.setFilled(isFill.isSelected());
	circleOrnament.setFillColor(getOrnamentColor());
	add(circleOrnament, e.getX(), e.getY());
	ornamentCount++;
	
	return circleOrnament;
}
    private GPolygon createStarOrnament(MouseEvent e) {
		int ornamentSize = getOrnamentSize();
		
		GPolygon starOrnament = createStar (MEDIUM_STAR_ORNAMENT_SIZE);
		switch (ornamentSize) {
		case 0:
			starOrnament = createStar (SMALL_STAR_ORNAMENT_SIZE);
			spending.put(ornamentCount+"-SmallStarOrnament",SMALL_STAR_ORNAMENT_PRICE);	
			break;
		case 1: default:
			starOrnament = createStar (MEDIUM_STAR_ORNAMENT_SIZE);
			spending.put(ornamentCount+"-MediumStarOrnament",MEDIUM_STAR_ORNAMENT_PRICE);	
			break;
		case 2: 
			starOrnament = createStar (LARGE_STAR_ORNAMENT_SIZE);
			spending.put(ornamentCount+"-LargeStarOrnament",LARGE_STAR_ORNAMENT_PRICE);	
			break;
		}

		starOrnament.setFilled(isFill.isSelected());
		starOrnament.setFillColor(getOrnamentColor());
		add(starOrnament, e.getX(), e.getY());
		ornamentCount++;
	
		return starOrnament;
}
    private int setLocation() {
    		int xLocation =0;
    		xLocation = rgen.nextInt(40, APPLICATION_WIDTH-40);
    		return xLocation;
    }
    /**
     * The method returns the size of the tree selected
     * from the slider.
     * @return int - the size of the tree selected in the slider
     */
    private int getTreeSize() {
	    	// Your code starts here
	
	    	
		int answer = 0;
		answer = (int) treeSizeSlider.getValue();
		println("tree size is " + answer);
		return answer;
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
		answer = (int) ornamentSizeSlider.getValue();
		//println("ornament size is " + answer);
		return answer;
	    	// Your code ends here
		
	}
    
    private void initNameChooser() {
		nameChooser = new JComboBox<String>();
		ArrayList<String> newNameList = new ArrayList<String>();
		for (String nameLastname: studentList){
			int index = nameLastname.indexOf(';');
			String lastName = nameLastname.substring(0, index);
			String name = nameLastname.substring(index+1, nameLastname.length());
			newNameList.add((name + " " + lastName));
		}
		Collections.sort(newNameList);
		for (String name : newNameList) {
			
				nameChooser.addItem(name);

		}
	}
    private void createTree () {
    		GCompound tree = new GCompound();
    	
		GRect root = new GRect(TRUNK_WIDTH,TRUNK_HEIGHT);
		root.setFilled(true);
		root.setFillColor(new Color(165, 42, 42));
		tree.add(root,-15,50);
	
		GPolygon leaf1 = new GPolygon();
		leaf1.addVertex(-100, 50);
		leaf1.addVertex(0,-50);
		leaf1.addVertex(100,50);
		leaf1.setFilled(true);
		leaf1.setFillColor(Color.green);
		tree.add(leaf1);
	
		GPolygon leaf2 = new GPolygon();
		leaf2.addVertex(-50,-50);
		leaf2.addVertex(0,-100);
		leaf2.addVertex(50,-50);
		leaf2.setFilled(true);
		leaf2.setFillColor(Color.green);
		tree.add(leaf2);
		int locationX = setLocation();
		
		treeCount++;
		spending.put((treeCount+"-Tree"), TREE_PRICE);
		add(tree, locationX, TREE_Y_COORDINATE);
		treeCollection.add(tree);
		//return tree;
    }
    private void createPrice() {
    		
    		double total = 0;
    		double ornamentTotal=0;
    		double treeTotal=0;
    		double presentTotal=0;
   
		
    		try {
				wr = new PrintWriter (new FileWriter(outputFileName));
				wr.println("Your new year shopping spending details are as such:");
				
				for (String item : spending.keySet()) {
		    			int currentPrice = (Integer)spending.get(item);
		    			total = total + currentPrice;
		    			if (item.contains("Ornament")) {
		    				ornamentTotal = ornamentTotal + currentPrice;
		    			}else if (item.contains("Tree")) {
		    				treeTotal = treeTotal + currentPrice;
		    			}else if (item.contains("Present")) {
		    				presentTotal = presentTotal + currentPrice;
		    			}
		    			
		    			//println(item + "=" + currentPrice);
		    			//wr.println(item + "=" + currentPrice);
		    			
	    			}
				println("Ornament spending=" + ornamentTotal);
				ornamentSpending.setValue(ornamentTotal);
				wr.println("Ornament spending=" + ornamentTotal);
				println("Tree spending=" + treeTotal);
			
				treeSpending.setValue(treeTotal);
				wr.println("Tree spending=" + treeTotal);
				println("Present spending=" + presentTotal);
				presentSpending.setValue(presentTotal);
				wr.println("Present spending=" + presentTotal);
				println("Total price=" + total);
				totalSpending.setValue(total);

				wr.println("Total price=" + total);
				wr.close();
		} catch (IOException ex) {
				println("cannot open the file");
		}

    }
    private void clearSpendings(){
    		
		ornamentSpending.setValue(0);
			
		treeSpending.setValue(0);
			
		presentSpending.setValue(0);
				
		totalSpending.setValue(0);
    }
    
    private void createStudentList() {
    		studentList.add("GÜVEN;AHMET");
    		studentList.add("GAZEL;ALİ");
    	    	studentList.add("DOĞANGÜN;ALİ");
		studentList.add("AKYÜREK;ALİ");
		studentList.add("YELİMLİEŞ;ALPER");
    		studentList.add("YİGİT;ARYA");
    		studentList.add("GÜRSOY;ATA");
    		studentList.add("AKÇAY;AYBERK");
    		studentList.add("IŞIK;AYKUT");
    		studentList.add("ORHAN;BAHA");
    		studentList.add("ÖZTÜRK;BAHAR");
    		studentList.add("DİNÇER;BETÜL");
    		studentList.add("GUDEN;CAN");
    		studentList.add("ÇOK;CANKUT");
    		studentList.add("SAĞMANLI;DENİZ");
    		studentList.add("KARADUMAN;DİLARA");
    		studentList.add("YAPRAK;DOĞUKAN");
    		studentList.add("AKŞEHİRLİOĞLU;EGE");
    		studentList.add("KILIÇ;EGE");
    		studentList.add("COMBA;ENEL");
    		studentList.add("ÇEVİK;ENES");
    		studentList.add("AYAR;ENES");
    }
    private String createInitials(String name) {
    		String initials = "";
    		StringTokenizer tokenizer = new StringTokenizer(name);
    		while (tokenizer.hasMoreTokens()) {
    			   String token = tokenizer.nextToken();
    			   initials = initials + token.charAt(0);
    			   //println(token);
    		}
    		println("present for " + initials);
    		return initials;
    }
    private GPolygon createStar(int size) {  
		GPolygon star = new GPolygon();
	    	double sinTheta = GMath.sinDegrees(18);
	    	double b = 0.5 * sinTheta / (1.0 + sinTheta);
	    	double edge = (0.5 - b) * size;
	    star.addVertex(-size / 2, -b * size);
	    	int angle = 0;
	    	for (int i = 0; i < 5; i++) {
	    		star.addPolarEdge(edge, angle);
	    	    star.addPolarEdge(edge, angle + 72);
	    	    angle -= 72;
	    	}
	    	star.setFilled(true);
	    	return star;
    } 	
  
}
