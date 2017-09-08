/************************************************************************************
 **                                                                                **
 **    Code by: Alejandro Davila Murra                                             **
 **                                                                                **
 **    CS 2365: Object Oriented Programming                                        **
 **    Instructor: Elham Hojati                                                    **
 **    TA: Judas Tadeo                                                             **
 **    Project #4                                                                  **
 **    Description: Program to practice basic and important subjects               **
 **                 to prepare for a programming technical interview               **
 **    How to use: Click on the tabs to go to specific subjects, then              **
 **                click on the buttons to learn more.                             **
 **    Due Date: Tuesday, May 10                                                   **
 **    Last modification: 5/08/2017                                                **
 **                                                                                **
 ************************************************************************************/

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Interview class
public class Interview implements ActionListener {

    //instance variables
    private JLabel lblMain;
    private JLabel lblBigOText;
    private JLabel lblDescrip;
    private JLabel lblCode;
    private JLabel lblMethods;
    private ArrayList<DataStructure> DSList;
    private ArrayList<Algorithm> AlgsList;
    private ArrayList<BigO> BigOList;
    public String name;

    //method to create GUI
    private void createGui() {

        //Create JFrame
        JFrame frame = new JFrame("Interview Preparation");
        frame.setSize(1000, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create JTabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0,0,250,700);

        //Create Maim View Panel
        JPanel panelMain = new JPanel(new GridBagLayout());
        panelMain.setBounds(338,21,647,641);
        panelMain.setBackground(Color.DARK_GRAY);
        frame.add(panelMain);
        GridBagConstraints consView = new GridBagConstraints();

        //Add Tabs
        JPanel tabHome = new JPanel();
        tabbedPane.addTab("Home", tabHome);
        JPanel tabDS = new JPanel();
        tabbedPane.addTab("Data Structures", tabDS);
        JPanel tabAlgs = new JPanel();
        tabbedPane.addTab("Algorithms", tabAlgs);
        JPanel tabBigO = new JPanel();
        tabbedPane.addTab("BigO", tabBigO);
        frame.add(tabbedPane); //add Tabbed Pane to Frame
        frame.getContentPane().add(tabbedPane, BorderLayout.WEST);
        GridBagConstraints c = new GridBagConstraints();
        tabbedPane.addChangeListener(new ChangeListener() { //add the Listener
            //Clear text from Main View when different tab is selected
            public void stateChanged(ChangeEvent e) {
                lblMain.setText("");
                lblBigOText.setText("");
                lblDescrip.setText("");
                lblCode.setText("");
                lblMethods.setText("");
                lblDescrip.setIcon(null);
            }
        });


        //region Main View Info
        //---------------------------------------------------------------------------------------

        //Main Label
        lblMain = new JLabel("");
        lblMain.setFont(new Font("Tahoma", Font.BOLD, 24));
        consView.gridx = 0;
        consView.gridy = 0;
        consView.gridwidth = 2;
        consView.gridheight = 1;
        consView.fill = GridBagConstraints.BOTH;
        consView.insets = new Insets(30, 25, 10, 0);
        lblMain.setForeground(Color.WHITE);
        consView.anchor = GridBagConstraints.NORTHWEST;
        panelMain.add(lblMain, consView);

        //BigO Label
        lblBigOText = new JLabel("");
        lblBigOText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        consView.gridx = 0;
        consView.gridy = 1;
        consView.weightx = 1;
        consView.weighty = 1;
        consView.gridwidth = 2;
        consView.gridheight = 1;
        consView.fill = GridBagConstraints.BOTH;
        lblBigOText.setForeground(Color.WHITE);
        consView.anchor = GridBagConstraints.NORTHWEST;
        panelMain.add(lblBigOText, consView);

        //Description Label
        lblDescrip = new JLabel("");
        lblDescrip.setFont(new Font("Tahoma", Font.PLAIN, 17));
        consView.gridx = 0;
        consView.gridy = 2;
        consView.gridwidth = 2;
        consView.gridheight = 1;
        consView.fill = GridBagConstraints.BOTH;
        consView.weightx = 1;
        consView.weighty = 1;
        consView.insets = new Insets(5, 25, 5, 20);
        lblDescrip.setForeground(Color.WHITE);
        consView.anchor = GridBagConstraints.NORTHWEST;
        panelMain.add(lblDescrip, consView);

        //Code Label
        lblCode = new JLabel("");
        lblCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
        consView.gridx = 0;
        consView.gridy = 3;
        consView.gridwidth = 1;
        consView.gridheight = 1;
        consView.fill = GridBagConstraints.BOTH;
        consView.weightx = 1;
        consView.weighty = 1;
        consView.insets = new Insets(5, 25, 5, 5);
        lblCode.setForeground(Color.WHITE);
        consView.anchor = GridBagConstraints.NORTHWEST;
        panelMain.add(lblCode, consView);

        //Methods Label
        lblMethods = new JLabel("");
        lblMethods.setFont(new Font("Tahoma", Font.PLAIN, 14));
        consView.gridx = 1;
        consView.gridy = 3;
        consView.gridwidth = 1;
        consView.gridheight = 1;
        consView.fill = GridBagConstraints.BOTH;
        consView.weightx = 1;
        consView.weighty = 1;
        consView.insets = new Insets(5, 5, 5, 5);
        lblMethods.setForeground(Color.WHITE);
        consView.anchor = GridBagConstraints.NORTHWEST;
        panelMain.add(lblMethods, consView);


        //---------------------------------------------------------------------------------------
        //endregion

        //region Home Tab
        //---------------------------------------------------------------------------------------
        //Home Panel
        JPanel pnlHome = new JPanel(new GridBagLayout());
        tabHome.add(pnlHome);

        //Title Label
        JLabel lblTitle = new JLabel("<html>Programming Technical<br> Interview Preparation</html>");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(20, 20, 20, 20);
        pnlHome.add(lblTitle, c);

        //Info Labels
        JLabel lblInfo1 = new JLabel("<html>Review important topics <br>before your technical interview</html>");
        lblInfo1.setFont(new Font("Tahoma", Font.BOLD, 17));
        c.gridx = 0;
        c.gridy = 1;
        pnlHome.add(lblInfo1, c);

        JLabel lblInfo2 = new JLabel("<html><ul><li>Data Structures</li><br><li>Algorithms</li><br><li>BigO</li><ul></html>");
        lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        pnlHome.add(lblInfo2, c);

        ImageIcon img = createImageIcon("interviews.png","Graph");
        JLabel lblImg = new JLabel();
        lblImg.setIcon(img);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(84, 11, 0, 0);
        consView.anchor = GridBagConstraints.SOUTH;
        pnlHome.add(lblImg, c);


        //---------------------------------------------------------------------------------------
        //endregion

        //region Data Structures Tab
        //---------------------------------------------------------------------------------------
        //Data Structures Panel
        JPanel pnlDS = new JPanel(new GridBagLayout());
        tabDS.add(pnlDS);
        fillDSList();

        //Title Label
        JLabel lblDSTitle = new JLabel("<html>Click on the Data Structure<br> you want to review</html>");
        lblDSTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(30, 0, 30, 0);
        pnlDS.add(lblDSTitle, c);

        //Array Button
        JButton btnArray = new JButton("Array");
        btnArray.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnArray, c);
        btnArray.addActionListener(this);

        //LinkedList Button
        JButton btnLinkedList = new JButton("LinkedList");
        btnLinkedList.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnLinkedList, c);
        btnLinkedList.addActionListener(this);

        //Stack Button
        JButton btnStack = new JButton("Stack");
        btnStack.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnStack, c);
        btnStack.addActionListener(this);

        //Queue Button
        JButton btnQueue = new JButton("Queue");
        btnQueue.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnQueue, c);
        btnQueue.addActionListener(this);

        //Tree Button
        JButton btnTree = new JButton("Tree");
        btnTree.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnTree, c);
        btnTree.addActionListener(this);

        //Hash Table Button
        JButton btnHashTable = new JButton("HashTable");
        btnHashTable.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnHashTable, c);
        btnHashTable.addActionListener(this);

        //ArrayList Button
        JButton btnList = new JButton("ArrayList");
        btnList.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(5, 0, 5, 0);
        pnlDS.add(btnList, c);
        btnList.addActionListener(this);

        JLabel lblImg1 = new JLabel();
        lblImg1.setIcon(img);
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(60, 0, 0, 0);
        pnlDS.add(lblImg1, c);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Algorithms Tab
        //---------------------------------------------------------------------------------------
        //Algorithms Panel
        JPanel pnlAlgs = new JPanel(new GridBagLayout());
        tabAlgs.add(pnlAlgs);
        fillAlgsList();

        //Title Label
        JLabel lblAlgsTitle = new JLabel("<html>Click on the Algorithms<br> you want to review</html>");
        lblAlgsTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(30, 0, 10, 0);
        pnlAlgs.add(lblAlgsTitle, c);

        //Search Label
        JLabel lblSearch = new JLabel("<html>Search</html>");
        lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(30, 0, 0, 0);
        pnlAlgs.add(lblSearch, c);

        //Linear Search Button
        JButton btnLinear = new JButton("Linear Search");
        btnLinear.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 5, 0);
        pnlAlgs.add(btnLinear, c);
        btnLinear.addActionListener(this);

        //Binary Search Button
        JButton btnBinary = new JButton("Binary Search");
        btnBinary.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 0, 5, 0);
        pnlAlgs.add(btnBinary, c);
        btnBinary.addActionListener(this);

        //Sort Label
        JLabel lblSort = new JLabel("<html>Sort</html>");
        lblSort.setFont(new Font("Tahoma", Font.PLAIN, 16));
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(20, 0, 0, 0);
        pnlAlgs.add(lblSort, c);

        //Bubble Sort Button
        JButton btnBubble = new JButton("Bubble Sort");
        btnBubble.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(5, 0, 5, 0);
        pnlAlgs.add(btnBubble, c);
        btnBubble.addActionListener(this);

        //Insertion Sort Button
        JButton btnInsertion = new JButton("Insertion Sort");
        btnInsertion.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(5, 0, 5, 0);
        pnlAlgs.add(btnInsertion, c);
        btnInsertion.addActionListener(this);

        //Merge Sort Button
        JButton btnMerge = new JButton("Merge Sort");
        btnMerge.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(5, 0, 5, 0);
        pnlAlgs.add(btnMerge, c);
        btnMerge.addActionListener(this);

        //Quick Sort Algorithm
        JButton btnQuick = new JButton("Quick Sort");
        btnQuick.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 8;
        c.insets = new Insets(5, 0, 5, 0);
        pnlAlgs.add(btnQuick, c);
        btnQuick.addActionListener(this);

        JLabel lblImg2 = new JLabel();
        lblImg2.setIcon(img);
        c.gridx = 0;
        c.gridy = 9;
        c.insets = new Insets(30, 0, 0, 0);
        pnlAlgs.add(lblImg2, c);

        //---------------------------------------------------------------------------------------
        //endregion

        //region BigO Tab
        //---------------------------------------------------------------------------------------
        //BigO Panel
        JPanel pnlBigO = new JPanel(new GridBagLayout());
        tabBigO.add(pnlBigO);

        //Title Label
        JLabel lblBigOTitle = new JLabel("<html>BigO Notation</html>");
        lblBigOTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(30, 0, 30, 0);
        pnlBigO.add(lblBigOTitle, c);

        //Info Button
        JButton btnDescription = new JButton("Description");
        btnDescription.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 5, 0);
        pnlBigO.add(btnDescription, c);
        btnDescription.addActionListener(this);

        //Examples Button
        JButton btnExamples = new JButton("Notation");
        btnExamples.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 2;
        pnlBigO.add(btnExamples, c);
        btnExamples.addActionListener(this);

        //Graph Algorithm
        JButton btnGraph = new JButton("Graph");
        btnGraph.setPreferredSize(new Dimension(120, 30));
        c.gridx = 0;
        c.gridy = 3;
        pnlBigO.add(btnGraph, c);
        btnGraph.addActionListener(this);

        JLabel lblImg3 = new JLabel();
        lblImg3.setIcon(img);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(242, 0, 0, 0);
        consView.anchor = GridBagConstraints.SOUTH;
        pnlBigO.add(lblImg3, c);

        //---------------------------------------------------------------------------------------
        //endregion
    }

    //Main method
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interview().createGui();
            }
        });
    }

    //Method to fill ArrayList with Data Structures
    public void fillDSList(){
        DSList = new ArrayList<DataStructure>();
        //region Array
        //---------------------------------------------------------------------------------------
        DataStructure array = new DataStructure("Array","<html><b>BigO: </b>O(n)</html>");
        array.description = "<html>An array is a container object that holds a fixed number of values of a single type. " +
                "<br>The length of an array is established when the array is created. After creation, its length is fixed." +
                "<br>Each item in an array is called an element, and each element is accessed by its numerical index.</html>";
        array.code = "<html><b>Sample Code</b><br>public void CreateAndPrintArray(){ <br>" +
                " &nbsp; &nbsp; int[] array = new int[4]; <br>" +
                " &nbsp; &nbsp; array[0] = 21; <br>" +
                " &nbsp; &nbsp; array[1] = 13; <br>" +
                " &nbsp; &nbsp; array[2] = 5; <br>" +
                " &nbsp; &nbsp; array[3] = 7; <br>" +
                " &nbsp; &nbsp; for(int i = 0; i < array.length; i++){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; System.out.println(array[i]); <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        array.Methods = "<html><b>Methods:</b><ul>" +
                "<li>binarySearch(Object[] a, Object key)  ->  int</li>" +
                "<li>equals(long[] a, long[] a2)  ->  boolean</li>" +
                "<li>fill(int[] a, int val)  ->  void</li>" +
                "<li>sort(Object[] a)  ->  void</li>" +
                "</ul></html>";
        DSList.add(array);

        //---------------------------------------------------------------------------------------
        //endregion

        //region LinkedList
        //---------------------------------------------------------------------------------------
        DataStructure linkedList = new DataStructure("LinkedList","<html><b>BigO: </b>O(n)</html>");
        linkedList.description = "<html>Java LinkedList class uses doubly linked list to store the elements. It provides a linked-list data structure. It inherits the AbstractList class and implements List and Deque interfaces.<br>" +
                "The important points about Java LinkedList are:" +
                "<ul><li>Java LinkedList class can contain duplicate elements.</li>" +
                "<li>Java LinkedList class maintains insertion order.</li>" +
                "<li>Java LinkedList class is non synchronized.</li>" +
                "<li>In Java LinkedList class, manipulation is fast because no shifting needs to be occurred.</li>" +
                "<li>Java LinkedList class can be used as list, stack or queue.</li></ul></html>";
        linkedList.code = "<html><b>Sample Code</b><br>public void CreateAndPrintLinkedList(){ <br>" +
                " &nbsp; &nbsp; LinkedList<String> al=new LinkedList<String>(); <br>" +
                " &nbsp; &nbsp; al.add(\"Bob\");  <br>" +
                " &nbsp; &nbsp; al.add(\"James\");  <br>" +
                " &nbsp; &nbsp; al.add(\"John\");  <br>" +
                " &nbsp; &nbsp; Iterator<String> itr=al.iterator(); <br>" +
                " &nbsp; &nbsp; while(itr.hasNext()){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; System.out.println(itr.next()); <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        linkedList.Methods = "<html><b>Methods:</b><ul>" +
                "<li>add(int index, Object element)  ->  void</li>" +
                "<li>addFirst(Object o)  ->  void</li>" +
                "<li>addLast(Object o)  ->  void</li>" +
                "<li>size()  ->  int</li>" +
                "<li>add(Object o)  ->  boolean</li>" +
                "<li>contains(Object o)  ->  boolean</li>" +
                "<li>remove(Object o)  ->  boolean</li>" +
                "<li>getFirst()  ->  Object</li>" +
                "<li>getLast()  ->  Object</li>" +
                "<li>indexOf(Object o)  ->  int</li>" +
                "<li>lastIndexOf(Object o)  ->  int</li>" +
                "</ul></html>";
        DSList.add(linkedList);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Stack
        //---------------------------------------------------------------------------------------
        DataStructure stack = new DataStructure("Stack","<html><b>BigO: </b>O(n)</html>");
        stack.description = "<html>A stack is a collection that is based on the last-in-first-out (LIFO) policy.  " +
                "<br>By tradition, we name the stack insert method push() and the stack remove operation pop(). We also include a method to test whether the stack is empty.</html>";
        stack.code = "<html><b>Sample Code</b><br>public void CreateAndPrintStack(){ <br>" +
                " &nbsp; &nbsp; Stack<String> stack = new Stack<String>(); <br>" +
                " &nbsp; &nbsp; stack.push(\"Bob\"); <br>" +
                " &nbsp; &nbsp; stack.push(\"John\"); <br>" +
                " &nbsp; &nbsp; stack.push(\"Robert\"); <br>" +
                " &nbsp; &nbsp; stack.push(\"Michael\"); <br>" +
                " &nbsp; &nbsp; while(!stack.isEmpty()){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; System.out.println(stack.pop()); <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        stack.Methods = "<html><b>Methods:</b><ul>" +
                "<li>isEmpty()  ->  boolean</li>" +
                "<li>push(Item item)  ->  void</li>" +
                "<li>pop()  ->  Item</li>" +
                "<li>size()  ->  int</li>" +
                "</ul></html>";
        DSList.add(stack);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Queue
        //---------------------------------------------------------------------------------------
        DataStructure queue = new DataStructure("Queue","<html><b>BigO: </b>O(n)</html>");
        queue.description = "<html>A queue supports the insert and remove operations using a first-in first-out (FIFO) discipline. " +
                "<br>By convention, we name the queue insert operation enqueue and the remove operation dequeue.</html>";
        queue.code = "<html><b>Sample Code</b><br>public void CreateAndPrintQueue(){ <br>" +
                " &nbsp; &nbsp; Queue<String> queue = new Queue<String>(); <br>" +
                " &nbsp; &nbsp; queue.enqueue(\"Bob\"); <br>" +
                " &nbsp; &nbsp; queue.enqueue(\"John\"); <br>" +
                " &nbsp; &nbsp; queue.enqueue(\"Robert\"); <br>" +
                " &nbsp; &nbsp; queue.enqueue(\"Michael\"); <br>" +
                " &nbsp; &nbsp; while(!queue.isEmpty()){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; System.out.println(queue.dequeue()); <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        queue.Methods = "<html><b>Methods:</b><ul>" +
                "<li>isEmpty()  ->  boolean</li>" +
                "<li>enqueue(Item item)  ->  void</li>" +
                "<li>dequeue()  ->  Item</li>" +
                "<li>size()  ->  int</li>" +
                "</ul></html>";
        DSList.add(queue);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Tree
        //---------------------------------------------------------------------------------------
        DataStructure Tree = new DataStructure("Tree","<html><b>BigO: </b>O(log(n))</html>");
        Tree.description = "<html>Trees are made up of nodes. The class definition looks like this: " +
                "<br> public Tree (Object data, Tree left, Tree right){ <br>" +
                " &nbsp; &nbsp; Object data;  <br>" +
                " &nbsp; &nbsp; Tree left, right;  <br> }" +
                "<br>It is important to know how to Traverse Trees and Insert/Delete Nodes </html>";
        Tree.code = "<html><b>Sample Code</b><br>public void PrintTree(Tree tree){ <br>" +
                " &nbsp; &nbsp; if (tree == null) return; <br>" +
                " &nbsp; &nbsp; System.out.print (tree + \" \"); <br>" +
                " &nbsp; &nbsp; print (tree.left); <br>" +
                " &nbsp; &nbsp; print (tree.right); <br>" +
                "} </html>";
        Tree.Methods = "<html><b>Basic Operations</b><ul>" +
                "<li>Insert − Inserts an element in a tree/create a tree.</li>" +
                "<li>Search − Searches an element in a tree.</li>" +
                "<li>Preorder Traversal − Traverses a tree in a pre-order manner.</li>" +
                "<li>Inorder Traversal − Traverses a tree in an in-order manner.</li>" +
                "<li>Postorder Traversal − Traverses a tree in a post-order manner.</li>" +
                "</ul></html>";
        DSList.add(Tree);

        //---------------------------------------------------------------------------------------
        //endregion

        //region HashTable
        //---------------------------------------------------------------------------------------
        DataStructure hashTable = new DataStructure("HashTable","<html><b>BigO: </b>O(n)</html>");
        hashTable.description = "<html>Java Hashtable class implements a hashtable, which maps keys to values. It inherits Dictionary class and implements the Map interface." +
                "<br>The important points about Java Hashtable class are:" +
                "<ul><li>A Hashtable is an array of list. Each list is known as a bucket. The position of bucket is identified by calling the hashcode() method. A Hashtable contains values based on the key.</li>" +
                "<li>It contains only unique elements.</li>" +
                "<li>It may have not have any null key or value.</li>" +
                "<li>It is synchronized.</li></ul></html>";
        hashTable.code = "<html><b>Sample Code</b><br>public void CreateAndPrintHashTable(){ <br>" +
                " &nbsp; &nbsp; Hashtable table = new Hashtable(); <br>" +
                " &nbsp; &nbsp; table.put(\"key1\", \"John\");  <br>" +
                " &nbsp; &nbsp; table.put(\"key1\", \"James\");  <br>" +
                " &nbsp; &nbsp; table.put(\"key1\", \"Bob\");  <br>" +
                " &nbsp; &nbsp; System.out.println(table); <br>" +
                "} </html>";
        hashTable.Methods = "<html><b>Methods:</b><ul>" +
                "<li>clear()  ->  void</li>" +
                "<li>contains(Object value)  ->  boolean</li>" +
                "<li>containsValue(Object value)  ->  boolean</li>" +
                "<li>containsKey(Object key)  ->  boolean</li>" +
                "<li>isEmpty()  ->  boolean</li>" +
                "<li>rehash()  ->  void</li>" +
                "<li>get(Object key)  ->  Object</li>" +
                "<li>remove(Object key)  ->  Object</li>" +
                "<li>size()  ->  int</li>" +
                "</ul></html>";
        DSList.add(hashTable);

        //---------------------------------------------------------------------------------------
        //endregion

        //region ArrayList
        //---------------------------------------------------------------------------------------
        DataStructure arrayList = new DataStructure("ArrayList","<html><b>BigO: </b>O(n)</html>");
        arrayList.description = "<html>Java Hashtable class implements a hashtable, which maps keys to values. It inherits Dictionary class and implements the Map interface." +
                "<br>The important points about Java Hashtable class are:" +
                "<ul><li>A Hashtable is an array of list. A Hashtable contains values based on the key.</li>" +
                "<li>It contains only unique elements.</li>" +
                "<li>It may have not have any null key or value.</li>" +
                "<li>It is synchronized.</li></ul></html>";
        arrayList.code = "<html><b>Sample Code</b><br>public void CreateAndPrintArrayList(){ <br>" +
                " &nbsp; &nbsp; ArrayList<String> arrayList = new ArrayList<String>(); <br>" +
                " &nbsp; &nbsp; arrayList.add(\"Bob\"); <br>" +
                " &nbsp; &nbsp; arrayList.add(\"James\"); <br>" +
                " &nbsp; &nbsp; arrayList.add(\"John\"); <br>" +
                " &nbsp; &nbsp; arrayList.add(\"Michael\"); <br>" +
                " &nbsp; &nbsp; for(String str : arrayList){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; System.out.println(str); <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        arrayList.Methods = "<html><b>Methods:</b><ul>" +
                "<li>add(int index, Object element)  ->  void</li>" +
                "<li>addAll(Collection c)  ->  boolean</li>" +
                "<li>clear()  ->  void</li>" +
                "<li>lastIndexOf(Object o)  ->  int </li>" +
                "<li>toArray()  ->  Object[]</li>" +
                "<li>toArray(Object[] a)  ->  Object[]</li>" +
                "<li>add(Object o)  ->  boolean </li>" +
                "<li>addAll(int index, Collection c)  ->  boolean</li>" +
                "<li>clone()  ->  Object</li>" +
                "<li>indexOf(Object o)  ->  int</li>" +
                "<li>trimToSize()  ->  void</li>" +
                "</ul></html>";
        DSList.add(arrayList);

        //---------------------------------------------------------------------------------------
        //endregion
    }

    //Method to fill ArrayList with Algorithms
    public void fillAlgsList(){
        AlgsList = new ArrayList<Algorithm>();
        //region Linear Search
        //---------------------------------------------------------------------------------------
        Algorithm linear = new Algorithm("Linear Search","<html><b>BigO: </b>O(n)</html>");
        linear.description = "<html>Linear search is a very simple search algorithm. " +
                "<br>In this type of search, a sequential search is made over all items one by one. " +
                "<br>Every item is checked and if a match is found then that particular item is returned, otherwise the search continues till the end of the data collection.</html>";
        linear.code = "<html><b>Sample Code</b><br>public boolean linearSearch(int[] data, int key){ <br>" +
                " &nbsp; &nbsp; for(int i = 0; i < data.length; i++){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; if(data[index] == key) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return true; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; if(data[index] < key)) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return false; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; return false; <br>" +
                "} </html>";
        AlgsList.add(linear);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Binary Search
        //---------------------------------------------------------------------------------------
        Algorithm binary = new Algorithm("Binary Search","<html><b>BigO: </b>O(log(n))</html>");
        binary.description = "<html>Binary search is an efficient algorithm for finding an item from an ordered list of items." +
                "<br>It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one. " +
                "<br>One of the most common ways to use binary search is to find an item in an array. </html>";
        binary.code = "<html><b>Sample Code</b><br>public boolean binarySearch(int[] data, int key) <br>" +
                " &nbsp; &nbsp; int low = 0; <br>" +
                " &nbsp; &nbsp; int high = data.length - 1; <br>" +
                " &nbsp; &nbsp; while(high >= low) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; int middle = (low + high) / 2; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; if(data[middle] == key) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; return true; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; if(data[middle] < key) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; low = middle + 1; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; if(data[middle] > key) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; high = middle - 1; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; return false; = 7; <br>" +
                "} </html>";
        AlgsList.add(binary);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Bubble Sort
        //---------------------------------------------------------------------------------------
        Algorithm bubble = new Algorithm("Bubble Sort","<html><b>BigO: </b>O(n^2)</html>");
        bubble.description = "<html>We can create a java program to sort array elements using bubble sort. Bubble sort algorithm is known as the simplest sorting algorithm. " +
                "<br>In bubble sort algorithm, array is traversed from first element to last element." +
                "<br>Here, current element is compared with the next element. If current element is greater than the next element, it is swapped.</html>";
        bubble.code = "<html><b>Sample Code</b><br>public static void bubbleSort(int[] numArray) { <br>" +
                " &nbsp; &nbsp; int temp = 0; <br>" +
                " &nbsp; &nbsp; for(int i = 0; i < numArray.length; i++){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; for(int j = 1; j < numArray.length-1; j++){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; if (numArray[j - 1] > numArray[j]) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; temp = numArray[j - 1]; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; numArray[j - 1] = numArray[j]; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; numArray[j] = temp; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        AlgsList.add(bubble);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Insertion Sort
        //---------------------------------------------------------------------------------------
        Algorithm insertion = new Algorithm("Insertion Sort","<html><b>BigO: </b>O(n^2)</html>");
        insertion.description = "<html>This is an in-place comparison-based sorting algorithm. Here, a sub-list is maintained which is always sorted." +
                "<br>The array is searched sequentially and unsorted items are moved and inserted into the sorted sub-list (in the same array).";
        insertion.code = "<html><b>Sample Code</b><br>public static void insertionSort(int array[]) { <br>" +
                " &nbsp; &nbsp; for(int i = 0; i < array.length; i++){ <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; int key = array[i]; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; int j = i-1; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; while ( (j > -1) && ( array [j] > key ) ) { <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; array [j+1] = array [j];  <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; j--; <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; } <br>" +
                " &nbsp; &nbsp; &nbsp; &nbsp; array[j+1] = key; <br>" +
                " &nbsp; &nbsp; } <br>" +
                "} </html>";
        AlgsList.add(insertion);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Merge Sort
        //---------------------------------------------------------------------------------------
        Algorithm merge = new Algorithm("Merge Sort","<html><b>BigO: </b>O(nlog(n))</html>");
        merge.description = "<html>Merge Sort uses a Divide and Conquer:" +
                "<ol><li>Divide by finding the number q qq of the position midway between p pp and r rr. Do this step the same way we found the midpoint in binary search: add p pp and r rr, divide by 2, and round down.</li>" +
                "<li>Conquer by recursively sorting the subarrays in each of the two subproblems created by the divide step. That is, recursively sort the subarray array[p..q] and recursively sort the subarray array[q+1..r].</li>" +
                "<li>Combine by merging the two sorted subarrays back into the single sorted subarray array[p..r].</li></ol></html>";
        merge.code = null;
        AlgsList.add(merge);

        //---------------------------------------------------------------------------------------
        //endregion

        //region Quick Sort
        //---------------------------------------------------------------------------------------
        Algorithm quick = new Algorithm("Quick Sort","<html><b>BigO: </b>O(n^2)</html>");
        quick.description = "<html>If the array contains only one element or zero elements then the array is sorted. " +
                "<br>If the array contains more than one element then:" +
                "<ul><li>Select an element from the array. This element is called the \"pivot element\". For example select the element in the middle of the array.</li>" +
                "<li>All elements which are smaller than the pivot element are placed in one array and all elements which are larger are placed in another array.</li>" +
                "<li>Sort both arrays by recursively applying Quicksort to them.</li>" +
                "<li>Combine the arrays.</li></ul></html>";
        quick.code = null;
        AlgsList.add(quick);

        //---------------------------------------------------------------------------------------
        //endregion
    }

    //Method to fill ArrayList with BigO
    public void fillBigOList(){
        BigOList = new ArrayList<BigO>();
        //region O(1)
        //---------------------------------------------------------------------------------------
        BigO o1 = new BigO("O(1)","Constant");
        BigOList.add(o1);
        //---------------------------------------------------------------------------------------
        //endregion

        //region O(logn)
        //---------------------------------------------------------------------------------------
        BigO oLogN = new BigO("O(log(n))","Logarithmic");
        BigOList.add(oLogN);
        //---------------------------------------------------------------------------------------
        //endregion

        //region O(n)
        //---------------------------------------------------------------------------------------
        BigO oN = new BigO("O(n)","Linear");
        BigOList.add(oN);
        //---------------------------------------------------------------------------------------
        //endregion

        //region O(nlogn)
        //---------------------------------------------------------------------------------------
        BigO oNlogN = new BigO("O(nlog(n))","Linearithmic");
        BigOList.add(oNlogN);
        //---------------------------------------------------------------------------------------
        //endregion

        //region O(n^2)
        //---------------------------------------------------------------------------------------
        BigO oN2 = new BigO("O(n^2)","Quadratic");
        BigOList.add(o1);
        //---------------------------------------------------------------------------------------
        //endregion

        //region O(n^c)
        //---------------------------------------------------------------------------------------
        BigO oNc = new BigO("O(n^c)","Polynomial");
        BigOList.add(oNc);
        //---------------------------------------------------------------------------------------
        //endregion

        //region O(c^n)
        //---------------------------------------------------------------------------------------
        BigO oCn = new BigO("O(c^n)","Exponential");
        BigOList.add(oCn);
        //---------------------------------------------------------------------------------------
        //endregion

    }

    //Method to determine Button Click Action
    public void actionPerformed(ActionEvent e) {
        JButton btnAction = (JButton)e.getSource();
        String text = btnAction.getText();
        try{
            checkButtonsText(text);
        }
        catch (Exception ex){
            String error = "Error" + ex;
        }
    }

    //Method to change the labels from the Main View with Data Structure info
    public void changeLabels(DataStructure ds){
        lblMain.setText(ds.name);
        lblBigOText.setText(ds.bigO);
        lblDescrip.setText(ds.description);
        lblCode.setText(ds.code);
        lblMethods.setText(ds.Methods);
    }

    //Method to change the labels from the Main View with Algorithm info
    public void changeLabels(Algorithm algorithm){
        lblMain.setText(algorithm.name);
        lblBigOText.setText(algorithm.bigO);
        lblDescrip.setText(algorithm.description);
        lblCode.setText(algorithm.code);
    }

    //Method to change the labels from the Main View with BigO info
    public void changeLabels(String text){
        if(text.equals("Description")){
            lblMain.setText("Big O");
            lblDescrip.setText("<html><b>Description:</b><br>Big O notation is used in Computer Science to describe the performance or complexity of an algorithm. " +
                    "<br/>Big O usually describes the worst-case scenario, and can be used to describe the execution time required or the space used (e.g. in memory or on disk) by an algorithm.</html>");
            lblDescrip.setIcon(null);
            return;
        }
        else if(text.equals("Notation")){
            fillBigOList();
            lblMain.setText("Notation");
            String main = "<html><table><tr><th><b>Notation</b></th><th><b>Name</b></th></tr>\n";
            for(BigO bO : BigOList){
                main += "<tr><td>" + bO.notation +"</td><td>" + bO.name + "</td></tr>\n";
            }
            main += "</table></html>";
            lblDescrip.setText(main);
            lblDescrip.setIcon(null);
            return;
        }
        else if(text.equals("Graph")){
            lblMain.setText("Time (t) x Number of Elements (n)");
            ImageIcon img = createImageIcon("graph.png","Graph");
            lblDescrip.setIcon(img);
            lblDescrip.setText("");
        }
    }

    //Method to check which button is being clicked
    public void checkButtonsText(String text){
        for(DataStructure ds : DSList){
            if(ds.name.equals(text)){
                changeLabels(ds);
                lblDescrip.setIcon(null);
                return;
            }
        }
        for(Algorithm algorithm : AlgsList){
            if(algorithm.name.equals(text)){
                changeLabels(algorithm);
                lblDescrip.setIcon(null);
                return;
            }
        }
        changeLabels(text);
    }

    //Method to create an ImageIcon
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}